package com.example.administrator.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.example.administrator.myapplication.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/7/23.
 */
public class GoodsListAdapter extends BaseAdapter {
    private Context mContext;
    private List<Map<String, Object>> mList;
    private LayoutInflater mInflater;
    private ImageLoader mImageLoader;
    public GoodsListAdapter(Context context, List<Map<String, Object>> list, ImageLoader imageLoader)
    {
        mContext = context;
        mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mList = list;
        mImageLoader = imageLoader;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null)
        {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.goods_list_item, null);
            viewHolder.imageView = (ImageView)convertView.findViewById(R.id.imageView);
            viewHolder.textView = (TextView)convertView.findViewById(R.id.textView);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        Map<String, Object> item = mList.get(position);
        viewHolder.textView.setText(item.get("name").toString());
        //viewHolder.imageView.setImageResource(R.drawable.goods_defult);
        ImageLoader.ImageListener listener = ImageLoader.getImageListener(viewHolder.imageView, R.drawable.goods_defult, R.drawable.goods_defult);
        String url = item.get("nImg").toString();
        Log.d("aaa", url);
        mImageLoader.get(url, listener);
        return convertView;
    }
    static class ViewHolder
    {
        ImageView imageView;
        TextView textView;
    }
}
