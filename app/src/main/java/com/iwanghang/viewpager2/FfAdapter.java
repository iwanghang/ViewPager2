//package com.iwanghang.viewpager2;
//
//import android.content.Context;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.List;
//
//public class FfAdapter extends RecyclerView.Adapter{
//
//    private static List<View> mViews;
//    private static Context mContext;
//    private static FfAdapter.CallBack mCallBack;
//
//    public FfAdapter(List<View > views , Context context, FfAdapter.CallBack callBack) {
//        this.mCallBack = callBack;
//        this.mContext = context;
//        this.mViews = views;
//    }
//
//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return null;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        View view = mViews.get(position);
//        holder.layout.addView(view);
//    }
//
//    @Override
//    public int getItemCount() {
//        return mViews.size();
//    }
//
//    // 内部接口
//    public interface CallBack {
//        void onClick(int position);
//    }
//
//}
