package com.iwanghang.viewpager2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

/**
 * 这个类的作用就是对于ViewPager的Activity（View）的切换的
 * 时候需要的一个适配器的作用，其实ViewPager的原理就可以看作是一个ListView就行了
 * @author lhdn
 *
 */
public class EcgResultAdapter extends PagerAdapter {

	//list是为了存储容器中的view，context的作用就是上下文
	private List<View> mViews;
	private Context mContext;
	private static CallBack mCallBack;

	public EcgResultAdapter(List<View > views , Context context, CallBack callBack) {
		this.mCallBack = callBack;
		this.mContext = context;
		this.mViews = views;
	}

	/**
	 * 将不需要呈现的view及时的销毁
	 */
	@Override
	public void destroyItem(View container, int position, Object object) {
		((ViewPager) container).removeView(mViews.get(position));
	}

	/**
	 * 该方法的作用类似于ListViewAdapter的那个getView的作用
	 */
	@Override
	public Object instantiateItem(View container, final int position) {
		View view = mViews.get(position);
		view.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mCallBack.onClick(position);
			}
		});
		((ViewPager) container).addView(view);
		return view;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mViews.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// 判断当前获得的view是不是我们想要得到的view
		return (arg0 == arg1);
	}

	// 内部接口
	public interface CallBack {
		void onClick(int position);
	}

}
