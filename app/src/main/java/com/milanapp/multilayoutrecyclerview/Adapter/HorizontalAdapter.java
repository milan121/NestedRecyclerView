package com.milanapp.multilayoutrecyclerview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.milanapp.multilayoutrecyclerview.Model.HorizontalModel;
import com.milanapp.multilayoutrecyclerview.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder> {

    private Context context;
    private ArrayList<HorizontalModel> horizontalModelArrayList;

    public HorizontalAdapter(Context context, ArrayList<HorizontalModel> horizontalModelArrayList) {
        this.context = context;
        this.horizontalModelArrayList = horizontalModelArrayList;
    }

    @NonNull
    @Override
    public HorizontalAdapter.HorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal,parent,false);
        return new HorizontalViewHolder(view) ;

    }

    @Override
    public void onBindViewHolder(@NonNull final HorizontalAdapter.HorizontalViewHolder holder, final int position) {

        holder.textTitle.setText(horizontalModelArrayList.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "you clicked "+horizontalModelArrayList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return horizontalModelArrayList.size();
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textTitle;

        public HorizontalViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.iv_thumb);
            textTitle=itemView.findViewById(R.id.txtTitle);
        }
    }
}
