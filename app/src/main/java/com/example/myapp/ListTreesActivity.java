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

public class ListTreesActivity extends AppCompatActivity {

    ArrayList<Tree> listTree = new ArrayList<>(); //Mảng dữ liệu
    TreeListViewAdapter policeListViewAdapter;
    ListView listViewProduct;
    ImageButton back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_friends);

        AddListItem();

        policeListViewAdapter = new TreeListViewAdapter(listTree);

        getList();
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
    public void AddListItem() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference myRef = db.getReference("list_tree");
        ArrayList<Tree> list = new ArrayList<>();
        list.add(new Tree("Đa","Sống lâu","Xanh",R.drawable.hai_duong));
        list.add(new Tree("Đa","Sống lâu","Xanh",R.drawable.hai_duong));
        list.add(new Tree("Đa","Sống lâu","Xanh",R.drawable.hai_duong));




        myRef.setValue(list, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                Toast.makeText(ListTreesActivity.this, "Complete", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void getList(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("list");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Tree police = dataSnapshot.getValue(Tree.class);
                    listTree.add(police);
                }

                policeListViewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void confirmDelete(final int position) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ListTreesActivity.this);
        alertDialogBuilder.setTitle("Xác nhận!");
        alertDialogBuilder.setMessage("Bạn có muốn xóa ?");
        alertDialogBuilder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listTree.remove(position);
                policeListViewAdapter.notifyDataSetChanged();
                Toast.makeText(ListTreesActivity.this, "Xóa thành công", Toast.LENGTH_LONG).show();
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