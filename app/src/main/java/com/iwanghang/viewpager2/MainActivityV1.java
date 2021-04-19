package com.iwanghang.viewpager2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * https://blog.csdn.net/HouXinLin_CSDN/article/details/104440001
 */
public class MainActivityV1 extends AppCompatActivity {

    private static final String TAG = MainActivityV1.class.getSimpleName();

    String[] url ={
            "https://pic1.zhimg.com/80/v2-d90f73dc5a5cd06756ea820b1380aabd_hd.jpg",
            "https://c-ssl.duitang.com/uploads/item/201505/09/20150509171654_dGsCB.jpeg",
            "https://c-ssl.duitang.com/uploads/item/201509/17/20150917153109_svQch.jpeg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 viewPager2 = findViewById(R.id.viewpager2);
        viewPager2.setAdapter(new RecyclerView.Adapter<ViewPagerViewHolder>() {
            @NonNull
            @Override
            public ViewPagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View inflate = LayoutInflater.from(getApplicationContext()).inflate(R.layout.item_view_page_2, parent,false);
                return new ViewPagerViewHolder(inflate);
            }

            @Override
            public void onBindViewHolder(@NonNull ViewPagerViewHolder holder, int position) {
                getBitmapFromUrl(holder.mImageView,url[position]);
            }

            @Override
            public int getItemCount() {
                return url.length;
            }
        });
    }

    // 加载图片
    private void  getBitmapFromUrl(ImageView imageView,String str){
        new Thread(() -> {
            try {
                URL url =new URL(str);
                Bitmap bitmap = BitmapFactory.decodeStream(url.openStream());
                imageView.post(() -> imageView.setImageBitmap(bitmap));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    class ViewPagerViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public ViewPagerViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView=itemView.findViewById(R.id.imageview);
        }
    }

}