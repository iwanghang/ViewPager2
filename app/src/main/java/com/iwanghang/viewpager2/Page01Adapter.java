package com.iwanghang.viewpager2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Page01Adapter extends RecyclerView.Adapter<Page01Adapter.ViewHolder> {

    private static List<View> mViews;
    private static Context mContext;
    private static CallBack mCallBack;

    public Page01Adapter(List<View > views , Context context, CallBack callBack) {
        this.mCallBack = callBack;
        this.mContext = context;
        this.mViews = views;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pp_01_00, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        View view = mViews.get(position);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallBack.onClick(position);
            }
        });
        holder.layout.addView(view);
    }

    @Override
    public int getItemCount() {
        return mViews.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.page2_layout);
        }
    }

    // 内部接口
    public interface CallBack {
        void onClick(int position);
    }

}

