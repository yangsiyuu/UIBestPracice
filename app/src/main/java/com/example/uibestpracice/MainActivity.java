package com.example.uibestpracice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycler;

    private List<Msg> mMsgList;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mButton = this.findViewById(R.id.button);
        final EditText input = findViewById(R.id.input_text);
        recycler = (RecyclerView) this.findViewById(R.id.msg_recycler_view);
        if (mMsgList == null) {
            mMsgList = new ArrayList<>();
        }
        for (int i = 0; i < 1; i++) {
            mMsgList.add(new Msg("hello", Msg.TYPE_RECEIVED));
            mMsgList.add(new Msg("hi", Msg.TYPE_SENT));

        }
       /* if(msg.getType()==Msg.TYPE_RECEIVED){
          leftLayout.setVisibility(View.VISIBLE);
            rightLayout.setVisibility(View.GONE);
        }else if(msg.getType()==Msg.TYPE_SENT) {
            rightLayout.setVisibility(View.VISIBLE);
            leftLayout.setVisibility(View.GONE);
        }*/
        final MsgAdapter adapter = new MsgAdapter(this, R.layout.msg_item, mMsgList);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = input.getText().toString();
                if (!"".equals(content)) {
                    Msg msg = new Msg(content, Msg.TYPE_SENT);
                    mMsgList.add(msg);
                    adapter.notifyItemInserted(mMsgList.size() - 1);
                    recycler.scrollToPosition(mMsgList.size()-1);
                    input.setText("");
                }
            }
        });
    }
}