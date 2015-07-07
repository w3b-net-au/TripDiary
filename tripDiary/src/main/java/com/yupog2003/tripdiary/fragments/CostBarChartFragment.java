package com.yupog2003.tripdiary.fragments;

import android.app.Fragment;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.yupog2003.tripdiary.R;
import com.yupog2003.tripdiary.data.FileHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CostBarChartFragment extends Fragment {
    String path;
    String title;
    int option;
    int[] colors;
    float[] totals;
    boolean hasData = false;
    BarChart barChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.option = getArguments().getInt("option");
        this.path = getArguments().getString("path");
        this.title = getArguments().getString("title");
        this.barChart=new BarChart(getActivity());
        return barChart;
    }

    @Override
    public void onResume() {
        super.onResume();
        TypedArray array = getActivity().getResources().obtainTypedArray(R.array.cost_type_colors);
        colors = new int[array.length()];
        for (int i = 0; i < colors.length; i++)
            colors[i] = array.getColor(i, 0);
        totals = new float[array.length()];
        array.recycle();
        switch (option) {
            case ViewCostFragment.optionPOI:
                File file = new File(path + "/costs");
                File[] files = file.listFiles();
                if (files == null)
                    files = new File[0];
                for (int i = 0; i < files.length; i++) {
                    readData(files[i]);
                    hasData = true;
                }
                break;
            case ViewCostFragment.optionTrip:
                File file2 = new File(path);
                File[] files2 = file2.listFiles();
                if (files2 == null)
                    files2 = new File[0];
                for (int i = 0; i < files2.length; i++) {
                    File file3 = new File(files2[i].getPath() + "/costs");
                    FileHelper.maintenDir(file3);
                    File[] files3 = file3.listFiles();
                    if (files3 != null) {
                        for (int j = 0; j < files3.length; j++) {
                            readData(files3[j]);
                            hasData = true;
                        }
                    }
                }
                break;
        }
        String[] titles = getActivity().getResources().getStringArray(R.array.cost_types);
        ArrayList<BarEntry> values=new ArrayList<>();
        for (int i=0;i<totals.length;i++){
            values.add(new BarEntry(totals[i], i));
        }
        BarDataSet barDataSet=new BarDataSet(values, "");
        barDataSet.setColors(colors);
        BarData barData=new BarData(titles, barDataSet);
        barChart.setData(barData);
        barChart.setDescription("");
        barChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        barChart.getLegend().setEnabled(false);
        barChart.invalidate();
    }

    private void readData(File file) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s;
            int type = -1;
            while ((s = br.readLine()) != null) {
                if (s.startsWith("type=")) {
                    type = Integer.valueOf(s.substring(s.indexOf("=") + 1));
                } else if (s.startsWith("dollar=") && type != -1) {
                    totals[type] += Float.valueOf(s.substring(s.indexOf("=") + 1));
                    type = -1;
                }
            }
            br.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
