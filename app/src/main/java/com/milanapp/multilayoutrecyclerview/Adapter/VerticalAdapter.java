package com.milanapp.multilayoutrecyclerview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.milanapp.multilayoutrecyclerview.Model.HorizontalModel;
import com.milanapp.multilayoutrecyclerview.Model.VerticalModel;
import com.milanapp.multilayoutrecyclerview.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.VerticalViewHolder> {

    private Context context;
    private ArrayList<VerticalModel> verticalModelArrayList;

    public VerticalAdapter(Context context, ArrayList<VerticalModel> verticalModelArrayList) {
        this.context = context;
        this.verticalModelArrayList = verticalModelArrayList;
    }

    @NonNull
    @Override
    public VerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vertical,parent,false);
        return new VerticalViewHolder(view) ;

    }

    @Override
    public void onBindViewHolder(@NonNull VerticalViewHolder holder, int position) {

        VerticalModel verticalModel = verticalModelArrayList.get(position);

        String title = verticalModel.getTitle();
        ArrayList<HorizontalModel> singleItem = verticalModel.getArrayList();

        holder.tv_title.setText(title);

        HorizontalAdapter  horizontalAdapter = new HorizontalAdapter(context,singleItem);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        holder.recyclerView.setHasFixedSize(true);
        holder.recyclerView.setAdapter(horizontalAdapter);

        holder.button_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "cllicked successfully", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return verticalModelArrayList.size();
    }

    public class VerticalViewHolder extends RecyclerView.ViewHolder{
        RecyclerView recyclerView;
        TextView tv_title;
        Button button_more;

        public VerticalViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView=itemView.findViewById(R.id.recyclerview_horizontal);
            tv_title=itemView.findViewById(R.id.tv_title);
            button_more=itemView.findViewById(R.id.button_more);

        }
    }
}
