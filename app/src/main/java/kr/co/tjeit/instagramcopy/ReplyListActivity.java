package kr.co.tjeit.instagramcopy;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.instagramcopy.adapter.ReplyAdapter;
import kr.co.tjeit.instagramcopy.data.PostingData;
import kr.co.tjeit.instagramcopy.data.ReplyData;

public class ReplyListActivity extends BaseActivity {

    private android.widget.ListView replyListView;
    PostingData postingData = null;
    ReplyAdapter replyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply_list);
        postingData = (PostingData) getIntent().getSerializableExtra("replies");
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {
        replyAdapter = new ReplyAdapter(mContext, postingData.getReplies());
        replyListView.setAdapter(replyAdapter);
    }

    @Override
    public void bindViews() {
        this.replyListView = (ListView) findViewById(R.id.replyListView);
    }
}
