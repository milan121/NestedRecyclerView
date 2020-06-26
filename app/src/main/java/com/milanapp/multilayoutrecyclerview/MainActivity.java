package com.milanapp.multilayoutrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.milanapp.multilayoutrecyclerview.Adapter.VerticalAdapter;
import com.milanapp.multilayoutrecyclerview.Model.HorizontalModel;
import com.milanapp.multilayoutrecyclerview.Model.VerticalModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView verticalRecyclervier;
    private VerticalAdapter verticalAdapter;
    private ArrayList<VerticalModel> verticalModelArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verticalRecyclervier=findViewById(R.id.vertical_recycler_view);
        verticalRecyclervier.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        verticalRecyclervier.setLayoutManager(linearLayoutManager);

        verticalAdapter=new VerticalAdapter(this,verticalModelArrayList);
        verticalRecyclervier.setAdapter(verticalAdapter);

        setdata();
    }

    private void setdata() {

        for (int i=1;i<=5;i++){
            VerticalModel verticalModel = new VerticalModel();
            verticalModel.setTitle("Title: "+i);
            ArrayList<HorizontalModel> horizontalModelArrayList = new ArrayList<>();

            for (int j = 0 ; j<=5; j++){
                HorizontalModel horizontalModel = new HorizontalModel();
                horizontalModel.setName("Name: "+j);
                horizontalModel.setDescription("Desc: "+j);

                horizontalModelArrayList.add(horizontalModel);
            }
              verticalModel.setArrayList(horizontalModelArrayList);
            verticalModelArrayList.add(verticalModel);

        }
        verticalAdapter.notifyDataSetChanged();
    }
}
