package com.example.chien.projectgroup1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chien.projectgroup1.R;
import com.example.chien.projectgroup1.model.NavDrawerItem;

import java.util.ArrayList;

/**
 * Created by chien on 8/31/2016.
 */
public class NavItemAdapter extends ArrayAdapter<NavDrawerItem> {
    private ArrayList<NavDrawerItem> navDrawerItemArrayList;
    private LayoutInflater layoutInflater;

    public NavItemAdapter(Context context, int resource, ArrayList<NavDrawerItem> objects) {
        super(context, resource, objects);
        this.navDrawerItemArrayList = objects;
        this.layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.item_listview_nav, parent, false);

            holder.imgvNav = (ImageView) convertView.findViewById(R.id.imgvNav);
            holder.tvNav = (TextView) convertView.findViewById(R.id.tvNav);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final NavDrawerItem item = navDrawerItemArrayList.get(position); //lay phan tu mang thu poisition de set cho item
        if (item != null) {
            holder.tvNav.setText(item.getTitle());
            holder.imgvNav.setImageResource(item.getIcon());
        }

        return convertView;
    }

    public static class ViewHolder {
        public ImageView imgvNav;
        public TextView tvNav;
    }
}
