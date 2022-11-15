package com.example.myapp;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PoliceListViewAdapter extends BaseAdapter {


    final ArrayList<Police> listPolice;

    PoliceListViewAdapter(ArrayList<Police> listPolice) {
        this.listPolice = listPolice;
    }

    @Override
    public int getCount() {

        return listPolice.size();
    }

    @Override
    public Object getItem(int position) {

        return listPolice.get(position);
    }

    @Override
    public long getItemId(int position) {
        //Trả về một ID của phần
        return listPolice.get(position).id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View viewProduct;
        if (convertView == null) {
            viewProduct = View.inflate(parent.getContext(), R.layout.product_view, null);
        } else viewProduct = convertView;


        //Bind sữ liệu phần tử vào View
        Police police = (Police) getItem(position);
        ((CircleImageView) viewProduct.findViewById(R.id.imgPolice)).setImageResource(Integer.parseInt(String.format("%d", police.hinhAnh)));
        ((TextView) viewProduct.findViewById(R.id.name_txt)).setText(String.format("%s", police.ten));
        ((TextView) viewProduct.findViewById(R.id.quocGia)).setText(String.format("Quốc gia: %s", police.quocGia));
        ((TextView) viewProduct.findViewById(R.id.capBac_txt)).setText(String.format("Cấp bậc: %s", police.capBac));
        ((TextView) viewProduct.findViewById(R.id.noiCongTac_txt)).setText(String.format("Nơi công tác: %s", police.quocGia));
        ((TextView) viewProduct.findViewById(R.id.sao_txt)).setText(String.format("Sao tín nhiệm: %d/5", police.sao));


        return viewProduct;
    }
}
