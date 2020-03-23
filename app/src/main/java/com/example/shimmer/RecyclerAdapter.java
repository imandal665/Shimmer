package com.example.shimmer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private boolean isShimmer = true;
    private int shimmerNumber = 10;
    private Context context;

    private ArrayList<Integer> models;

    public RecyclerAdapter(ArrayList<Integer> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (isShimmer) {
            holder.shimmerFrameLayout.startShimmer();
        } else {
            holder.shimmerFrameLayout.stopShimmer();
            holder.shimmerFrameLayout.setShimmer(null);
            holder.textView.setText("item " + models.get(position));
            holder.textView2.setText("Loading completed");
            holder.imageView.setBackgroundResource((R.drawable.ic_launcher_background));
//            holder.textView.setText("item loaded");
        }
    }


    public void stopShimmering() {
        isShimmer = false;
    }

    @Override
    public int getItemCount() {
        return isShimmer ? shimmerNumber : models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ShimmerFrameLayout shimmerFrameLayout;
        TextView textView, textView2;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            shimmerFrameLayout = itemView.findViewById(R.id.shimmer_layout);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.tvTitle);
            textView2 = itemView.findViewById(R.id.tvDesc);
        }
    }
}
