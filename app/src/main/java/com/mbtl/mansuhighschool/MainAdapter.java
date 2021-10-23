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

    private ArrayList<MainData> arrayList;

    public MainAdapter(ArrayList<MainData> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MainAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {



        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MainAdapter.CustomViewHolder holder, int position) {

//        Fresco.initialize(arrayList.get(position).getContext());

        holder.tv_name.setText(arrayList.get(position).getTv_name());
        holder.tv_content.setText(arrayList.get(position).getTv_content());
        holder.bon_moon.setText(arrayList.get(position).getBon_moon());
//        Uri uri = Uri.parse(arrayList.get(position).getIv_profile());
//        holder.iv_profile.setImageURI(uri);

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String curName = holder.tv_name.getText().toString();
                Toast.makeText(v.getContext(),curName, Toast.LENGTH_SHORT).show();


                String bon_moon = (String) holder.bon_moon.getText().toString();               // bonmoon 텍스트뷰 만들어서 여기에 본문 링크 넘겨주기.
                Uri urI = Uri.parse(bon_moon);
//                Intent intent = new Intent(context, urI);       // 아마도 context 맞을 듯
//                startActivity(intent);//액티비티 이동

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
//        protected Context context;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_profile = (ImageView) itemView.findViewById(R.id.iv_profile);
            this.tv_name = (TextView)  itemView.findViewById(R.id.tv_name);
            this.tv_content = (TextView)  itemView.findViewById(R.id.tv_content);
            this.bon_moon = (TextView) itemView.findViewById(R.id.bon_moon);



        }
    }
}


