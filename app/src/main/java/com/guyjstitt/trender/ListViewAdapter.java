package com.guyjstitt.trender;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gstitt on 11/21/14.
 */
public class ListViewAdapter extends BaseAdapter {
    // Declare Variables
    Context context;
    LayoutInflater inflater;
    private List<TrendData> recentTrendList = null;
    private ArrayList<TrendData> arraylist;

    public ListViewAdapter(Context context,
                           List<TrendData> recentTrendList) {
        this.context = context;
        this.recentTrendList = recentTrendList;
        inflater = LayoutInflater.from(context);
        this.arraylist = new ArrayList<TrendData>();
        this.arraylist.addAll(recentTrendList);
    }

    public class ViewHolder {
        TextView trendName;
        TextView trendUrl;
    }

    @Override
    public int getCount() {
        return recentTrendList.size();
    }

    @Override
    public Object getItem(int position) {
        return recentTrendList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.view_each_recent_trend, null);
            // Locate the TextViews in listview_item.xml
            holder.trendName = (TextView) view.findViewById(R.id.trendLabel);
            holder.trendUrl = (TextView) view.findViewById(R.id.trendUrl);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.trendName.setText(recentTrendList.get(position).getTrend());


        // Listen for ListView Item Click
        view.setOnClickListener(new View.OnClickListener() {
            String recentTrendUrl = recentTrendList.get(position).getUrl();
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), WebActivity.class);
                Bundle extras = new Bundle();
                intent.putExtra("lucky_url", recentTrendUrl);
                context.startActivity(intent);
            }
        });
        return view;
    }
}