package com.huangjiahao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.huangjiahao.R;
import com.huangjiahao.bean.City;

import java.util.List;

/**
 * Created by ASUS on 2016/6/3.
 */
public class PickCityAdapter extends ArrayAdapter<City>{

    private int mResourcedId;

    public PickCityAdapter(Context context, int textViewResourceId, List<City> objects) { //用于具体城市选择
        super(context,textViewResourceId,objects);
        mResourcedId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        City city = getItem(position); //获取当前的City实例
        View view;
        ViewHolder viewHolder;
        if(convertView == null) { //convertView为空则将viewHolder存储在view中
            view = LayoutInflater.from(getContext()).inflate(mResourcedId, null);
            viewHolder = new ViewHolder();
            viewHolder.CityName = (TextView) view.findViewById(R.id.pick_city_tv);
            view.setTag(viewHolder); //将viewHolder存储在View中
        } else { //convertView不为空的时候直接把viewHolder取出
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.CityName.setText(city.getCityName());
        return view;
    }

    class ViewHolder {
        TextView CityName; //内部类，用于对控件的缓存
    }

}
