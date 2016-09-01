package com.example.chien.projectgroup1.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chien.projectgroup1.R;
import com.example.chien.projectgroup1.model.Bank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chien on 7/26/2016.
 */
public class BankAdapter extends ArrayAdapter<Bank> {
    private ArrayList<Bank> arrayListBank;
    private LayoutInflater layoutInflater;

    public BankAdapter(Context context, List<Bank> objects) {
        super(context, R.layout.item_bank, objects);
        this.arrayListBank = (ArrayList<Bank>) objects;
        this.layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.item_bank, parent, false);

            holder.tvBankName = (TextView) convertView.findViewById(R.id.tvBankName);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final Bank bank = arrayListBank.get(position); //lay phan tu mang thu poisition de set cho item
        if(bank != null){
            holder.tvBankName.setText(bank.getBankName());
        }


        return convertView;
    }

    public static class ViewHolder {
        public TextView tvBankName;
    }
}
