package com.example.recycleview.one;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recycleview.R;

import java.util.List;

/**
 * @name ShowHintTopAndButtomRecycleView
 * @class name：com.example.recycleview
 * @class describe
 * @anthor Vincent QQ:1032006226
 * @time 2017/8/10 10:11
 * @change
 * @chang time
 * @class describe
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyRecycleViewHodler> {

    private List<String> data;
    private Context mContext;

    public RecycleViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<String> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public MyRecycleViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mContext == null) mContext = parent.getContext();
        return new MyRecycleViewHodler(LayoutInflater.from(mContext).inflate(R.layout.item_recycleview_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(MyRecycleViewHodler holder, int position) {
        String str = data.get(position);
        holder.content.setText(str);
    }

    @Override
    public int getItemCount() {
        return data == null?0:data.size();
    }

    class MyRecycleViewHodler extends RecyclerView.ViewHolder{

        private TextView content;

        public MyRecycleViewHodler(View itemView) {
            super(itemView);
            content = itemView.findViewById(R.id.item_tv_content);
        }
    }
}
