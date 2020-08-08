package com.example.uibestpracice;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MsgAdapter extends CommonRecyclerAdapter<Msg> {

    public MsgAdapter(Context context, int itemLayoutId, List<Msg> mMsgList) {
        super(context, itemLayoutId, mMsgList);
    }



    @Override
    public void convert(RecyclerHolder holder, Msg item, int position) {
        String content=item.getContent();
        int type=item.getType();
        if(type==Msg.TYPE_RECEIVED){

        holder.setText(R.id.left_msg,content);

    }else if(type==Msg.TYPE_SENT) {
            holder.setText(R.id.right_msg, content);
        }
        }
}
