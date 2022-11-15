package com.example.myapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListPoliceActivity extends AppCompatActivity {

    ArrayList<Police> listPolice; //Mảng dữ liệu
    PoliceListViewAdapter policeListViewAdapter;
    ListView listViewProduct;
    ImageButton back_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_friends);

        listPolice = new ArrayList<>();
        listPolice.add(new Police(R.drawable.hai_duong,4,1,"Nguyễn Hải Dương","Trung úy","Việt nam","Quảng Bình"));
        listPolice.add(new Police(R.drawable.tuanle,4,1,"Lê Hoàng Anh Tuấn","Trung úy","Việt nam","Quảng Bình"));
        listPolice.add(new Police(R.drawable.hong_anh,4,1,"Nguyễn Hồng Ánh","Trung úy","Việt nam","Quảng Bình"));


        policeListViewAdapter = new PoliceListViewAdapter(listPolice);

        listViewProduct = findViewById(R.id.listproduct);
        listViewProduct.setAdapter(policeListViewAdapter);

        listViewProduct.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                confirmDelete(i);

                return false;
            }
        });

    }

    private void confirmDelete (final int position){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ListPoliceActivity.this);
        alertDialogBuilder.setTitle("Xác nhận!");
        alertDialogBuilder.setMessage("Bạn có muốn xóa ?");
        alertDialogBuilder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listPolice.remove(position);
                policeListViewAdapter.notifyDataSetChanged();
                Toast.makeText(ListPoliceActivity.this, "Xóa thành công", Toast.LENGTH_LONG).show();
            }
        });

        alertDialogBuilder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        alertDialogBuilder.show();
    }



}