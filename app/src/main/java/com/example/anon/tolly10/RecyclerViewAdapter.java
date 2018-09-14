package com.example.anon.tolly10;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImgDesc = new ArrayList<>();
    private Context mcontext;

    public RecyclerViewAdapter(Context mcontext, ArrayList<String> ImageUrls, ArrayList<String> ImageNames, ArrayList<String> ImageDesc) {
        this.mImages = ImageUrls;
        this.mNames = ImageNames;
        this.mImgDesc = ImageDesc;
        this.mcontext = mcontext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_view, parent, false);
        return new ViewHolder(view);
    }
    @NonNull
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,final int position) {
        Log.d(TAG, "onBindViewHolder: Images & Name Binding");

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.mipmap.ic_launcher_foreground);

        Glide.with(mcontext)
                .load(mImages.get(position))
                .apply(requestOptions)
                .into(holder.image);

        holder.name.setText(mNames.get(position));

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Called"+ mNames.get(position));
                Intent intent = new Intent(mcontext, full_desc.class);
                intent.putExtra("image_name", mNames.get(position));
                intent.putExtra("image_url", mImages.get(position));
                intent.putExtra("image_desc", mImgDesc.get(position));
                mcontext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;

        public ViewHolder(View view) {
            super(view);
            image = itemView.findViewById(R.id.image_widget);
            name = itemView.findViewById(R.id.name_widget);
        }
    }

}
