package bwie.com.yuekao.tuer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import bwie.com.yuekao.R;
import bwie.com.yuekao.tuer.itemdianji.OnitemClickListener;

/**
 * Created by zld on 2018.06.01.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    List<CaipuBean.ResultBean.DataBean> data;
    public MyAdapter(Context conext, List<CaipuBean.ResultBean.DataBean> data ) {
        this.context = conext;
        this.data=data;

    }


    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    OnitemClickListener onitemClickListener;

    public void setOnitemClickListener(OnitemClickListener onitemClickListener) {
        this.onitemClickListener = onitemClickListener;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, final int position) {

        Log.d("MyAdapter--s", data.get(position).getAlbums().toString());
        String s = data.get(position).getAlbums().toString();
        int length = s.length();
        String substring = s.substring(1, length - 1);
        Log.d("MyAdapter-substring", substring);
         holder.item_simple.setImageURI(substring);
        holder.item_text01.setText(data.get(position).getTitle());
        holder.item_text02.setText(data.get(position).getBurden());
        if (onitemClickListener!=null){
            holder.item_simple.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onitemClickListener.onClick(position);
                }
            });
            holder.item_simple.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    onitemClickListener.onLongClick(position);
                    return false;
                }
            });
        }





    }

    @Override
    public int getItemCount() {
        return data.size();//显示的条目数
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView item_text01;
        private TextView item_text02;
        private  SimpleDraweeView item_simple;

        public ViewHolder(View itemView) {
            super(itemView);
            item_text01 = itemView.findViewById(R.id.item_text01);
            item_text02 = itemView.findViewById(R.id.item_text02);
            item_simple = itemView.findViewById(R.id.item_simple);

        }
    }
}
