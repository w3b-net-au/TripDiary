package com.yupog2003.tripdiary.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.yupog2003.tripdiary.MyActivity;
import com.yupog2003.tripdiary.R;
import com.yupog2003.tripdiary.TripDiaryApplication;
import com.yupog2003.tripdiary.data.DeviceHelper;
import com.yupog2003.tripdiary.data.DrawableHelper;
import com.yupog2003.tripdiary.data.FileHelper;
import com.yupog2003.tripdiary.services.DownloadTripService;
import com.yupog2003.tripdiary.thrift.TripDiary;
import com.yupog2003.tripdiary.views.CheckableLayout;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransportException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class RemoteTripsFragment extends Fragment implements OnRefreshListener {

    public static final int option_public = 0;
    public static final int option_personal = 1;
    public static final String tag_option = "optionTag";

    private enum Task {
        rename_trip, delete_trip, toggle_public
    }

    int trip_option;
    ListView listView;
    SwipeRefreshLayout swipeRefreshLayout;
    TripAdapter adapter;
    String account;
    String token;
    SearchView searchView;
    TripDiary.Client client;

    public RemoteTripsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_remotetrips, container, false);
        listView = (ListView) view.findViewById(R.id.listView);
        ViewCompat.setNestedScrollingEnabled(listView, true);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_container);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light);
        client = getClient();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        this.trip_option = getArguments().getInt(tag_option, 0);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (outState.isEmpty()) {
            outState.putBoolean("bug:fix", true);
        }
    }

    public void loadData() {
        if (trip_option == option_personal) {
            ((MyActivity) getActivity()).getAccount(new MyActivity.OnAccountPickedListener() {
                @Override
                public void onAccountPicked(@NonNull String accountName) {
                    account = accountName;
                    ((MyActivity) getActivity()).getAccessToken(account, new MyActivity.OnAccessTokenGotListener() {
                        @Override
                        public void onAccessTokenGot(@NonNull String token) {
                            setHasOptionsMenu(true);
                            RemoteTripsFragment.this.token = token;
                            new GetTripsTask().execute();
                        }
                    });
                }
            }, false);
        } else {
            account = "public";
            token = "abc";
            new GetTripsTask().execute();
        }
    }

    public TripDiary.Client getClient() {
        TripDiary.Client client = null;
        try {
            THttpClient transport = new THttpClient(TripDiaryApplication.serverURL + "/TripDiaryService_binary.php");
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            client = new TripDiary.Client(protocol, protocol);
        } catch (TTransportException e) {

            e.printStackTrace();
        }
        return client;
    }

    class GetTripsTask extends AsyncTask<Void, Void, Trip[]> {

        @Override
        protected void onPreExecute() {
            if (!swipeRefreshLayout.isRefreshing()) {
                swipeRefreshLayout.setRefreshing(true);
            }
        }

        @Override
        protected Trip[] doInBackground(Void... params) {

            if (client == null)
                return null;
            try {
                if (token == null) {
                    token = "abc";
                }
                List<com.yupog2003.tripdiary.thrift.Trip> tripList = client.getTrips(token, trip_option == option_public, account, 0);
                if (tripList == null)
                    return null;
                ArrayList<Trip> trips = new ArrayList<>();
                for (com.yupog2003.tripdiary.thrift.Trip trip : tripList) {
                    if (trip != null && trip.getPath() != null && trip.getName() != null) {
                        trips.add(new Trip(trip.getPath(), trip.getName()));
                    }
                }
                return trips.toArray(new Trip[trips.size()]);
            } catch (TException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Trip[] result) {
            if (result != null) {
                adapter = new TripAdapter(new ArrayList<>(Arrays.asList(result)));
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(adapter);
                if (trip_option == option_personal) {
                    listView.setLongClickable(true);
                    listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
                    listView.setMultiChoiceModeListener(adapter);
                }
                listView.setOnScrollListener(adapter);
                if (swipeRefreshLayout.isRefreshing())
                    swipeRefreshLayout.setRefreshing(false);
                setHasOptionsMenu(true);
            }
        }

    }

    class UpdateDataTask extends AsyncTask<String, Void, String> {

        Task task;
        String token;
        String tripPath;

        public UpdateDataTask(Task task, String token, String tripPath) {
            this.task = task;
            this.token = token;
            this.tripPath = tripPath;
        }

        @Override
        protected String doInBackground(String... params) {

            if (token == null || tripPath == null)
                return null;
            try {
                switch (task) {
                    case rename_trip:
                        String newTripPath = params[0];
                        if (newTripPath == null)
                            break;
                        client.rename_trip(token, tripPath, newTripPath);
                        break;
                    case delete_trip:
                        client.delete_trip(token, tripPath);
                        break;
                    case toggle_public:
                        String option = params[0];
                        if (option == null)
                            break;
                        client.toggle_public(token, tripPath, option);
                        break;
                }
            } catch (TException e) {

                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            adapter = null;
            loadData();
        }

    }

    class LoadMoreTripTask extends AsyncTask<Void, Void, ArrayList<Trip>> {
        @Override
        protected void onPreExecute() {
            if (!swipeRefreshLayout.isRefreshing()) {
                swipeRefreshLayout.setRefreshing(true);
            }
        }

        @Override
        protected ArrayList<Trip> doInBackground(Void... params) {

            if (trip_option == option_public) {
                try {
                    List<com.yupog2003.tripdiary.thrift.Trip> tripList = client.getTrips(token, true, account, adapter.getCount() / 20);
                    if (tripList == null)
                        return null;
                    ArrayList<Trip> trips = new ArrayList<>();
                    for (int i = 0; i < tripList.size(); i++) {
                        com.yupog2003.tripdiary.thrift.Trip trip = tripList.get(i);
                        if (trip != null && trip.getPath() != null && trip.getName() != null) {
                            trips.add(new Trip(trip.getPath(), trip.getName()));
                        }
                    }
                    return trips;
                } catch (TException e) {

                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(ArrayList<Trip> result) {
            if (result != null && adapter != null) {
                adapter.addTrips(result);
            }
        }
    }

    class TripAdapter extends BaseAdapter implements OnItemClickListener, OnQueryTextListener, MultiChoiceModeListener, OnScrollListener {

        ArrayList<Trip> trips;
        int dip10;
        boolean onActionMode = false;
        public boolean isLoading;

        public TripAdapter(ArrayList<Trip> trips) {
            this.trips = trips;
            this.dip10 = (int) DeviceHelper.pxFromDp(getActivity(), 10);
            this.isLoading = false;
        }

        public int getCount() {
            return trips.size();
        }

        public Object getItem(int position) {
            return trips.get(position);
        }

        public long getItemId(int position) {
            return position;
        }

        public void addTrips(ArrayList<Trip> trips) {
            this.trips.addAll(trips);
            notifyDataSetChanged();
            isLoading = false;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = new TextView(getActivity());
            textView.setTextAppearance(getActivity(), android.R.style.TextAppearance_Large);
            textView.setText(trips.get(position).name);
            textView.setPadding(dip10, dip10, dip10, dip10);
            CheckableLayout layout = new CheckableLayout(getActivity());
            layout.addView(textView);
            layout.setOnMultiChoiceMode(onActionMode);
            return layout;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, final int position, long id) {
            String[] selections = new String[]{getString(R.string.download), getString(R.string.open), getString(R.string.share)};
            AlertDialog.Builder ab = new AlertDialog.Builder(getActivity());
            ab.setSingleChoiceItems(selections, -1, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String tripPath = trips.get(position).path;
                    String tripName = trips.get(position).name;
                    if (which == 0) {
                        if (FileHelper.findfile(TripDiaryApplication.rootDocumentFile, tripName) != null) {
                            Toast.makeText(getActivity(), getString(R.string.same_trip), Toast.LENGTH_SHORT).show();
                        } else {
                            Intent intent = new Intent(getActivity(), DownloadTripService.class);
                            intent.putExtra("path", tripPath);
                            intent.putExtra("token", token);
                            getActivity().startService(intent);
                        }
                    } else if (which == 1) {
                        String tripPublic = trip_option == option_public ? "yes" : "no";
                        String urlStr = TripDiaryApplication.serverURL + "/Trip.html?tripname=" + tripName + "&trippath=" + tripPath + "&public=" + tripPublic;
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(urlStr));
                        startActivity(intent);
                    } else if (which == 2) {
                        try {
                            String tripPublic = trip_option == option_public ? "yes" : "no";
                            String urlStr = TripDiaryApplication.serverURL + "/Trip.html?tripname=" + URLEncoder.encode(tripName, "UTF-8") + "&trippath=" + URLEncoder.encode(tripPath, "UTF-8") + "&public=" + tripPublic;
                            Intent intent = new Intent(Intent.ACTION_SEND);
                            intent.setType("text/plain");
                            intent.putExtra(Intent.EXTRA_TEXT, urlStr);
                            intent.putExtra(Intent.EXTRA_SUBJECT, tripName);
                            startActivity(intent);
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }

                    }
                    dialog.dismiss();
                }
            });
            ab.show();

        }

        ArrayList<Trip> checksName;

        public boolean onActionItemClicked(ActionMode mode, MenuItem item) { //
            checksName = new ArrayList<>();
            for (int i = 0; i < checks.length; i++) {
                if (checks[i]) {
                    checksName.add(trips.get(i));
                }
            }
            mode.finish();
            switch (item.getItemId()) {
                case R.id.edit:
                    final String tripPath = checksName.get(0).path;
                    final String tripName = checksName.get(0).name;
                    AlertDialog.Builder ab = new AlertDialog.Builder(getActivity());
                    ab.setTitle(getString(R.string.Name));
                    final EditText editText = new EditText(getActivity());
                    editText.setText(tripName);
                    ab.setView(editText);
                    ab.setPositiveButton(getString(R.string.enter), new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            boolean conflict = false;
                            String newTripName = editText.getText().toString();
                            for (int i = 0; i < trips.size(); i++) {
                                if (tripPath.substring(tripPath.lastIndexOf("/") + 1).equals(newTripName)) {
                                    conflict = true;
                                    break;
                                }
                            }
                            if (!conflict) {
                                String newTripPath = tripPath.substring(0, tripPath.lastIndexOf("/") + 1) + newTripName;
                                new UpdateDataTask(Task.rename_trip, token, tripPath).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, newTripPath);
                            }
                        }
                    });
                    ab.setNegativeButton(getString(R.string.cancel), null);
                    ab.show();
                    break;
                case R.id.delete:
                    AlertDialog.Builder ab2 = new AlertDialog.Builder(getActivity());
                    ab2.setTitle(getString(R.string.be_careful));
                    ab2.setMessage(getString(R.string.are_you_sure_to_delete));
                    ab2.setIcon(DrawableHelper.getAlertDrawable(getActivity()));
                    ab2.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            for (int i = 0; i < checksName.size(); i++) {
                                String tripPath = checksName.get(i).path;
                                new UpdateDataTask(Task.delete_trip, token, tripPath).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, "");
                            }
                        }
                    });
                    ab2.setNegativeButton(getString(R.string.no), null);
                    ab2.show();
                    break;
                case R.id.togglepublic:
                    String tripPath2 = checksName.get(0).path;
                    new UpdateDataTask(Task.toggle_public, token, tripPath2).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, "toggle");
                    break;
                case R.id.selectall:
                    for (int i = 0; i < listView.getCount(); i++) {
                        listView.setItemChecked(i, !checkAll);
                    }
                    checkAll = !checkAll;
                    break;
            }
            return true;
        }

        boolean[] checks;
        boolean checkAll;

        public boolean onCreateActionMode(ActionMode mode, Menu menu) {

            mode.getMenuInflater().inflate(R.menu.remote_trip_menu, menu);
            if (account.equals("public")) {
                menu.removeItem(R.id.edit);
                menu.removeItem(R.id.togglepublic);
                menu.removeItem(R.id.delete);
            }
            onActionMode = true;
            checks = new boolean[trips.size()];
            Arrays.fill(checks, false);
            checkAll = false;
            return true;
        }

        public void onDestroyActionMode(ActionMode mode) {
            onActionMode = false;
        }

        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

            checks[position] = checked;
            int selects = 0;
            for (boolean check : checks) {
                if (check)
                    selects++;
            }
            if (!account.equals("public")) {
                mode.getMenu().findItem(R.id.edit).setVisible(!(selects > 1));
                mode.getMenu().findItem(R.id.togglepublic).setVisible(!(selects > 1));
            }
        }

        public boolean onQueryTextChange(String newText) {

            return false;
        }

        public boolean onQueryTextSubmit(String query) {
            final String searchName = searchView.getQuery().toString().toLowerCase(Locale.US);
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(searchView.getWindowToken(), 0);
            searchView.clearFocus();
            if (!searchName.equals("")) {
                final ArrayList<Trip> founds = new ArrayList<>();
                int adaptercount = trips.size();
                for (int i = 0; i < adaptercount; i++) {
                    String itemname = trips.get(i).name;
                    if (itemname.toLowerCase(Locale.US).contains(searchName)) {
                        founds.add(trips.get(i));
                    }
                }
                if (founds.size() == 0) {
                    Toast.makeText(getActivity(), getString(R.string.trip_not_found), Toast.LENGTH_SHORT).show();
                } else if (founds.size() == 1) {
                    String tripPath = founds.get(0).path;
                    String tripName = founds.get(0).name;
                    String uri = TripDiaryApplication.serverURL + "/Trip.html?tripname=" + tripName + "&trippath=" + tripPath;
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(uri));
                    startActivity(intent);
                } else {
                    AlertDialog.Builder choose = new AlertDialog.Builder(getActivity());
                    choose.setTitle(getString(R.string.choose_the_trip));
                    String[] names = new String[founds.size()];
                    for (int i = 0; i < names.length; i++) {
                        names[i] = founds.get(i).name;
                    }
                    choose.setSingleChoiceItems(names, -1, new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {

                            String tripPath = founds.get(which).path;
                            String tripName = founds.get(which).name;
                            String uri = TripDiaryApplication.serverURL + "/Trip.html?tripname=" + tripName + "&trippath=" + tripPath;
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse(uri));
                            startActivity(intent);
                            dialog.dismiss();
                        }
                    });
                    choose.show();
                }
            }
            return true;
        }

        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {

        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            boolean loadMore = firstVisibleItem + visibleItemCount >= totalItemCount - 1;
            if (loadMore && !isLoading) {
                isLoading = true;
                new LoadMoreTripTask().execute();
            }
        }
    }

    class Trip {
        String path;
        String name;

        public Trip(String path, String name) {
            this.path = path;
            this.name = name;
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_remote_trip, menu);
        MenuItem searchItem = menu.findItem(R.id.searchview);
        searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setQueryHint(getString(R.string.search_trip));
        searchView.setOnQueryTextListener(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void onRefresh() {
        loadData();
    }

}
