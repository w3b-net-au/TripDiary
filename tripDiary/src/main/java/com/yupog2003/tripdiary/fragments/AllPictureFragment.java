package com.yupog2003.tripdiary.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.provider.DocumentFile;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.yupog2003.tripdiary.R;
import com.yupog2003.tripdiary.ViewPointActivity;
import com.yupog2003.tripdiary.ViewTripActivity;
import com.yupog2003.tripdiary.data.DeviceHelper;
import com.yupog2003.tripdiary.data.FileHelper;
import com.yupog2003.tripdiary.data.POI;
import com.yupog2003.tripdiary.views.SquareImageView;
import com.yupog2003.tripdiary.views.UnScrollableGridView;

import java.util.Arrays;

public class AllPictureFragment extends Fragment {
    POI[] pois;
    RecyclerView recyclerView;
    POIAdapter poiAdapter;
    int width;
    int numColums;
    String timezone;

    public AllPictureFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int screenWidth = DeviceHelper.getScreenWidth(getActivity());
        int screenHeight = DeviceHelper.getScreenHeight(getActivity());
        if (screenWidth > screenHeight) {
            width = screenWidth / 5;
            numColums = 5;
        } else {
            width = screenWidth / 3;
            numColums = 3;
        }
        recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_all, container, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        setHasOptionsMenu(true);
        return recyclerView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public void refresh() {
        if (getActivity() != null && getActivity() instanceof ViewTripActivity) {
            this.pois = ((ViewTripActivity) getActivity()).trip.pois;
            this.timezone = ((ViewTripActivity) getActivity()).trip.timezone;
            poiAdapter = new POIAdapter();
            recyclerView.setAdapter(poiAdapter);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_all, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    class PictureAdapter extends BaseAdapter implements OnItemClickListener {
        DocumentFile[] pictures;
        Bitmap[] bitmaps;
        DisplayImageOptions options;

        public PictureAdapter(DocumentFile[] pictures) {
            this.pictures = pictures;
            this.bitmaps = new Bitmap[pictures.length];
            if (pictures.length > 0)
                options = new DisplayImageOptions.Builder()
                        .displayer(new FadeInBitmapDisplayer(500))
                        .cacheInMemory(false)
                        .cacheOnDisk(false)
                        .bitmapConfig(Bitmap.Config.RGB_565)
                        .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
                        .extraForDownloader(pictures[0].getParentFile())
                        .build();
        }

        public int getCount() {

            if (pictures == null)
                return 0;
            return pictures.length;
        }

        public Object getItem(int position) {
            return pictures[position];
        }

        public long getItemId(int position) {
            return position;
        }

        public void freeBitmaps() {
            if (bitmaps != null) {
                for (Bitmap bitmap : bitmaps) {
                    if (bitmap != null) {
                        bitmap.recycle();
                    }
                }
                Arrays.fill(bitmaps, null);
            }
        }

        public View getView(final int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                SquareImageView imageView = new SquareImageView(getActivity());
                imageView.setMaxWidth(width);
                imageView.setMaxHeight(width);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                convertView = imageView;
            }
            if (bitmaps[position] == null) {
                ImageLoader.getInstance().displayImage(FileHelper.getFileName(pictures[position]), (ImageView) convertView, options, new SimpleImageLoadingListener() {
                    @Override
                    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                        try {
                            bitmaps[position] = loadedImage;
                        } catch (OutOfMemoryError e) {
                            e.printStackTrace();
                        }
                    }

                });
            } else {
                ((ImageView) convertView).setImageBitmap(bitmaps[position]);
            }
            return convertView;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(pictures[position].getUri(), "image/*");
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivity(intent);
        }
    }

    class POIAdapter extends RecyclerView.Adapter<POIAdapter.ViewHolder> {
        PictureAdapter[] pictureAdapters;

        public class ViewHolder extends RecyclerView.ViewHolder {
            public CardView cardView;
            public TextView poiName;
            public TextView poiTime;
            public UnScrollableGridView gridView;
            public View.OnClickListener onClickListener;
            public int index;

            public ViewHolder(CardView v) {
                super(v);
                this.cardView = v;
                this.poiName = (TextView) cardView.findViewById(R.id.poiName);
                this.poiTime = (TextView) cardView.findViewById(R.id.poiTime);
                this.gridView = (UnScrollableGridView) cardView.findViewById(R.id.pictures);
                this.gridView.setNumColumns(numColums);
                this.onClickListener = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String tripName = FileHelper.getFileName(pois[index].dir.getParentFile());
                        String poiName = FileHelper.getFileName(pois[index].dir);
                        Intent intent = new Intent(getActivity(), ViewPointActivity.class);
                        intent.putExtra(ViewPointActivity.tag_tripname, tripName);
                        intent.putExtra(ViewPointActivity.tag_poiname, poiName);
                        intent.putExtra(ViewPointActivity.tag_fromActivity, ViewTripActivity.class.getSimpleName());
                        getActivity().startActivityForResult(intent, ViewTripActivity.REQUEST_VIEW_POI);
                    }
                };
                this.cardView.setOnClickListener(onClickListener);
            }

        }

        public POIAdapter() {
            this.pictureAdapters = new PictureAdapter[pois.length];
            for (int i = 0; i < pictureAdapters.length; i++) {
                pictureAdapters[i] = new PictureAdapter(pois[i].picFiles);
            }
        }

        public void freeBitmaps() {
            if (pictureAdapters != null) {
                for (PictureAdapter adapter : pictureAdapters) {
                    if (adapter != null) {
                        adapter.freeBitmaps();
                    }
                }
            }
        }

        @Override
        public POIAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            CardView v = (CardView) LayoutInflater.from(getActivity()).inflate(R.layout.card_pictures, parent, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(POIAdapter.ViewHolder holder, int position) {
            holder.poiName.setText(pois[position].title + "(" + String.valueOf(pois[position].picFiles.length) + ")");
            holder.poiTime.setText(pois[position].time.formatInTimezone(timezone));
            holder.gridView.setVisibility(pictureAdapters[position].getCount() == 0 ? View.GONE : View.VISIBLE);
            holder.gridView.setAdapter(pictureAdapters[position]);
            holder.gridView.setOnItemClickListener(pictureAdapters[position]);
            holder.index = position;
        }

        @Override
        public int getItemCount() {
            return pois.length;
        }
    }

    @Override
    public void onLowMemory() {
        if (poiAdapter != null) {
            poiAdapter.freeBitmaps();
        }
        super.onLowMemory();
    }
}
