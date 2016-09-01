package com.example.chien.projectgroup1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chien.projectgroup1.R;
import com.example.chien.projectgroup1.model.Warning;

import java.util.ArrayList;

/**
 * Created by chien on 8/15/2016.
 */
public class WarningAdapter extends ArrayAdapter<Warning>{
    private ArrayList<Warning> arrayListWarning;
    private LayoutInflater layoutInflater;


    public WarningAdapter(Context context, int resource, ArrayList<Warning> objects) {
        super(context, resource, objects);
        this.arrayListWarning = objects;
        this.layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.item_warning, parent, false);

            holder.txtCategory = (TextView) convertView.findViewById(R.id.txtCategory);
            holder.txtAddress = (TextView) convertView.findViewById(R.id.txtAddress);
            holder.imgvWarning = (ImageView) convertView.findViewById(R.id.imgvWarning);
            holder.txtTime = (TextView) convertView.findViewById(R.id.txtTime);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final Warning warning = arrayListWarning.get(position); //lay phan tu mang thu poisition de set cho item
        if(warning != null){
            holder.txtCategory.setText(warning.getCategoryWarning());
            holder.txtAddress.setText(warning.getAddressWarning());
            //thuong thi thanh phan anh se load tren server (Universal Image loader)
            //https://github.com/nostra13/Android-Universal-Image-Loader
            if(warning.getCategory_Id() == 1){
                holder.imgvWarning.setImageResource(R.drawable.btn_jam);
            }else{
                holder.imgvWarning.setImageResource(R.drawable.btn_accident);
            }
            holder.txtTime.setText(warning.getCreate_time());

        }

        return convertView;
    }

    public static class ViewHolder {
        public ImageView imgvWarning;
        public TextView txtCategory;
        public TextView txtAddress;
        public TextView txtTime;
    }
}
