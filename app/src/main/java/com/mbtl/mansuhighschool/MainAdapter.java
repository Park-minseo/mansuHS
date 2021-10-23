package com.mbtl.mansuhighschool;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustomViewHolder> {
    Context context;
    private ArrayList<MainData> arrayList;

    public MainAdapter(ArrayList<MainData> arrayList) {
        this.arrayList = arrayList;

    }
    public MainAdapter(Context context11)
    {
        context = context11;
    }
    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

//        Fresco.initialize(parent.getContext());          // 이거를 해야 링크를 이미지로 변환 가능

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MainAdapter.CustomViewHolder holder, int position) {



        holder.tv_name.setText(arrayList.get(position).getTv_name());
        holder.tv_content.setText(arrayList.get(position).getTv_content());
        holder.bon_moon.setText(arrayList.get(position).getBon_moon());

//        Uri uri = Uri.parse(arrayList.get(position).getIv_profile()); // 링크를 이미지로 변형
//        holder.iv_profile.setImageURI(uri);


        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String curName = holder.tv_name.getText().toString();
                Toast.makeText(v.getContext(),curName, Toast.LENGTH_SHORT).show();


                String bon_moon = (String) holder.bon_moon.getText().toString();               // 여기에 본문 링크 넘겨주기.
                Uri urI = Uri.parse(bon_moon);
                Intent intent = new Intent(Intent.ACTION_VIEW, urI);
                v.getContext().startActivity(intent);
//                context.startActivity(intent);        //액티비티 이동

            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected ImageView iv_profile;
        protected TextView tv_name;
        protected TextView tv_content;
        protected TextView bon_moon;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_profile = (ImageView) itemView.findViewById(R.id.iv_profile);
            this.tv_name = (TextView)  itemView.findViewById(R.id.tv_name);
            this.tv_content = (TextView)  itemView.findViewById(R.id.tv_content);
            this.bon_moon = (TextView) itemView.findViewById(R.id.bon_moon);
        }
    }



}


