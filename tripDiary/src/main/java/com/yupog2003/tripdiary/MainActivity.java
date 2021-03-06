package com.yupog2003.tripdiary;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.yupog2003.tripdiary.data.DeviceHelper;
import com.yupog2003.tripdiary.data.DrawableHelper;
import com.yupog2003.tripdiary.data.FileHelper;
import com.yupog2003.tripdiary.data.MyCalendar;
import com.yupog2003.tripdiary.data.Trip;
import com.yupog2003.tripdiary.data.documentfile.DocumentFile;
import com.yupog2003.tripdiary.services.RecordService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Set;
import java.util.TimeZone;

public class MainActivity extends MyActivity implements Button.OnClickListener {

    Button startTrip;
    Button resumeTrip;
    Button viewHistory;
    Button allRecord;

    public static final int PLAY_SERVICES_RESOLUTION_REQUEST = 130;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbar);
        if (toolBar != null) {
            setSupportActionBar(toolBar);
        }
        getSharedPreferences("category", MODE_PRIVATE).edit().putString(getString(R.string.nocategory), String.valueOf(Color.WHITE)).apply();
        startTrip = (Button) findViewById(R.id.starttrip);
        viewHistory = (Button) findViewById(R.id.viewhistory);
        resumeTrip = (Button) findViewById(R.id.resume_trip);
        allRecord = (Button) findViewById(R.id.all_record);
        int accentColor = ContextCompat.getColor(this, R.color.accent);
        DrawableCompat.setTint(DrawableCompat.wrap(startTrip.getCompoundDrawables()[0].mutate()), accentColor);
        DrawableCompat.setTint(DrawableCompat.wrap(viewHistory.getCompoundDrawables()[0].mutate()), accentColor);
        checkHasPermission(new OnGrantPermissionCompletedListener() {
            @Override
            public void onGranted() {
                if (TripDiaryApplication.rootDocumentFile == null) {
                    TripDiaryApplication.updateRootPath();
                }
                if (checkPlayService()) {
                    startTrip.setOnClickListener(MainActivity.this);
                    viewHistory.setOnClickListener(MainActivity.this);
                    resumeTrip.setOnClickListener(MainActivity.this);
                    allRecord.setOnClickListener(MainActivity.this);
                }
            }

            @Override
            public void onFailed() {
                finishAndRemoveTask();
            }
        }, Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (DeviceHelper.isGpsEnabled(this)) {
            if (requestCode == 0)
                startTripDialog();
            else if (requestCode == 1)
                resumeTripDialog();
        }
    }

    private boolean checkPlayService() {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        int resultCode = googleApiAvailability.isGooglePlayServicesAvailable(MainActivity.this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (googleApiAvailability.isUserResolvableError(resultCode)) {
                googleApiAvailability.getErrorDialog(MainActivity.this, resultCode, PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Toast.makeText(MainActivity.this, "This device is not supported by Google Play Service", Toast.LENGTH_SHORT).show();
                finishAndRemoveTask();
            }
            return false;
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkPlayService();
    }

    boolean tripNameClicked;

    private void startTripDialog() {
        tripNameClicked = false;
        final SharedPreferences categorySp = getSharedPreferences("category", MODE_PRIVATE);
        Set<String> keySet = categorySp.getAll().keySet();
        final String[] categories = keySet.toArray(new String[keySet.size()]);
        AlertDialog.Builder ab2 = new AlertDialog.Builder(MainActivity.this);
        View layout = getLayoutInflater().inflate(R.layout.edit_trip, (ViewGroup) findViewById(android.R.id.content), false);
        final RadioGroup rg = (RadioGroup) layout.findViewById(R.id.categories);
        final TextView category = (TextView) layout.findViewById(R.id.category);
        for (int i = 0; i < categories.length; i++) {
            RadioButton rb = new RadioButton(MainActivity.this);
            rb.setText(categories[i]);
            rb.setId(i);
            rg.addView(rb);
            if (categories[i].equals(getString(R.string.nocategory))) {
                rg.check(i);
                String color = categorySp.getString(categories[i], String.valueOf(Color.WHITE));
                category.setCompoundDrawablesWithIntrinsicBounds(DrawableHelper.getColorDrawable(MainActivity.this, 50, Integer.valueOf(color)), null, null, null);
            }
        }
        rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String color = categorySp.getString(categories[checkedId], "Gray");
                category.setCompoundDrawablesWithIntrinsicBounds(DrawableHelper.getColorDrawable(MainActivity.this, 50, Integer.valueOf(color)), null, null, null);
            }
        });
        ab2.setTitle(getString(R.string.Start_Trip));
        ab2.setView(layout);
        final EditText tripName = (EditText) layout.findViewById(R.id.tripname);
        final EditText tripNote = (EditText) layout.findViewById(R.id.tripnote);
        Calendar c = Calendar.getInstance();
        tripName.setText(String.valueOf(c.get(Calendar.YEAR)) + "-" + String.valueOf(c.get(Calendar.MONTH) + 1) + "-" + String.valueOf(c.get(Calendar.DAY_OF_MONTH)));
        tripName.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if (!tripNameClicked) {
                    tripName.setText("");
                }
                tripNameClicked = true;
            }
        });
        ab2.setPositiveButton(getString(R.string.enter), new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {

                final String name = tripName.getText().toString();
                final String note = tripNote.getText().toString();
                int radioGroupIndex = rg.getCheckedRadioButtonId();
                String temp;
                if (radioGroupIndex == -1 || radioGroupIndex >= categories.length) {
                    temp = getString(R.string.nocategory);
                } else {
                    temp = categories[rg.getCheckedRadioButtonId()];
                }
                final String category = temp;
                if (name.length() > 0) {
                    if (FileHelper.findfile(TripDiaryApplication.rootDocumentFile, name) == null) {
                        startTrip(name, note, category);
                    } else {
                        AlertDialog.Builder ab2 = new AlertDialog.Builder(MainActivity.this);
                        ab2.setTitle(getString(R.string.same_trip));
                        ab2.setMessage(getString(R.string.explain_same_trip));
                        ab2.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int which) {
                                startTrip(name, note, category);
                            }
                        });
                        ab2.setNegativeButton(getString(R.string.no), null);
                        ab2.show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, getString(R.string.input_the_trip_name), Toast.LENGTH_SHORT).show();
                }
            }
        });
        ab2.setNegativeButton(getString(R.string.cancel), null);
        AlertDialog ad = ab2.create();
        ad.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        ad.show();
    }

    private void startTrip(@NonNull final String name, @Nullable final String note, @Nullable final String category) {
        checkHasPermission(new OnGrantPermissionCompletedListener() {
            @Override
            public void onGranted() {
                if (isServiceRunning(RecordService.class)) {
                    Toast.makeText(MainActivity.this, R.string.please_stop_previous_trip_first, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!DeviceHelper.isGpsEnabled(MainActivity.this)) {
                    Toast.makeText(MainActivity.this, R.string.please_enable_the_gps_provider, Toast.LENGTH_SHORT).show();
                    return;
                }
                DocumentFile dir = FileHelper.findfile(TripDiaryApplication.rootDocumentFile, name);
                if (dir == null) { //new trip
                    dir = TripDiaryApplication.rootDocumentFile.createDirectory(name);
                    MyCalendar.updateTripTimeZone(MainActivity.this, name, TimeZone.getDefault().getID());
                }
                if (dir == null) {
                    Toast.makeText(getActivity(), R.string.storage_error, Toast.LENGTH_SHORT).show();
                    return;
                }
                Trip trip = new Trip(MainActivity.this, dir, false);
                if (category != null) {
                    trip.setCategory(category);
                }
                if (note != null) {
                    trip.updateNote(note);
                }
                Intent i = new Intent(MainActivity.this, RecordService.class);
                i.putExtra(RecordService.tag_tripName, name);
                startService(i);
                DeviceHelper.sendGATrack(MainActivity.this, "Trip", "start", name, null);
                MainActivity.this.finish();
            }

            @Override
            public void onFailed() {

            }
        }, Manifest.permission.ACCESS_FINE_LOCATION);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.setting && TripDiaryApplication.rootDocumentFile != null) {
            Intent intent = new Intent(MainActivity.this, PreferActivity.class);
            startActivity(intent);
        }
        return false;
    }

    private void resumeTripDialog() {
        AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
        DocumentFile[] files = TripDiaryApplication.rootDocumentFile.listFiles(DocumentFile.list_dirs);
        ArrayList<Trip> trips = new ArrayList<>();
        for (DocumentFile file : files) {
            if (file != null) {
                Trip trip = new Trip(MainActivity.this, file, true);
                trips.add(trip);
            }
        }
        Collections.sort(trips, Collections.reverseOrder());
        final String[] tripNames = new String[trips.size()];
        for (int i = 0; i < tripNames.length; i++) {
            tripNames[i] = trips.get(i).tripName;
        }
        ab.setSingleChoiceItems(tripNames, -1, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                String tripName = tripNames[which];
                DeviceHelper.sendGATrack(MainActivity.this, "Trip", "resume", tripName, null);
                startTrip(tripName, null, null);
            }
        });
        ab.setTitle(getString(R.string.resume_trip));
        ab.setNegativeButton(getString(R.string.cancel), null);
        ab.show();
    }

    public void onClick(View v) {
        if (v.equals(startTrip)) {
            if (isServiceRunning(RecordService.class)) {
                Toast.makeText(this, R.string.please_stop_previous_trip_first, Toast.LENGTH_SHORT).show();
                return;
            }
            if (!DeviceHelper.isGpsEnabled(this)) {
                Toast.makeText(this, getString(R.string.please_enable_the_gps_provider), Toast.LENGTH_SHORT).show();
                startActivityForResult(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS), 0);
                return;
            }
            startTripDialog();
        } else if (v.equals(viewHistory)) {
            startActivity(new Intent(MainActivity.this, ViewActivity.class));
        } else if (v.equals(resumeTrip)) {
            if (isServiceRunning(RecordService.class)) {
                Toast.makeText(this, R.string.please_stop_previous_trip_first, Toast.LENGTH_SHORT).show();
                return;
            }
            if (!DeviceHelper.isGpsEnabled(this)) {
                Toast.makeText(this, getString(R.string.please_enable_the_gps_provider), Toast.LENGTH_SHORT).show();
                startActivityForResult(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS), 1);
                return;
            }
            resumeTripDialog();
        } else if (v.equals(allRecord)) {
            Intent i = new Intent(MainActivity.this, AllRecordActivity.class);
            String[] tripNames = TripDiaryApplication.rootDocumentFile.listFileNames(DocumentFile.list_dirs);
            i.putExtra(AllRecordActivity.tag_trip_names, tripNames);
            startActivity(i);
        }
    }

}
