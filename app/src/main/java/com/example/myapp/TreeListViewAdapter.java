package com.example.myapp;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class TreeListViewAdapter extends BaseAdapter {


    final ArrayList<Tree> listTree;

    TreeListViewAdapter(ArrayList<Tree> listPolice) {
        this.listTree = listPolice;
    }

    @Override
    public int getCount() {

        return listTree.size();
    }

    @Override
    public Object getItem(int position) {

        return listTree.get(position);
    }

    @Override
    public long getItemId(int position) {
        //Trả về một ID của phần
        return 1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View viewProduct;
        if (convertView == null) {
            viewProduct = View.inflate(parent.getContext(), R.layout.item_view, null);
        } else viewProduct = convertView;


        //Bind sữ liệu phần tử vào View
        Tree tree = (Tree) getItem(position);
        ((CircleImageView) viewProduct.findViewById(R.id.imgPolice)).setImageResource(Integer.parseInt(String.format("%d", tree.getHinhAnh())));
        ((TextView) viewProduct.findViewById(R.id.name_txt)).setText(String.format("%s", tree.getTen()));
        ((TextView) viewProduct.findViewById(R.id.quocGia)).setText(String.format("Đặc tính: %s", tree.getDacTinh()));
        ((TextView) viewProduct.findViewById(R.id.capBac_txt)).setText(String.format("Màu lá: %s", tree.getMauLa()));


        return viewProduct;
    }
}
