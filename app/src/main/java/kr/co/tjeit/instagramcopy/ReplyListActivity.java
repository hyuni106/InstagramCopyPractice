package kr.co.tjeit.instagramcopy;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.instagramcopy.adapter.ReplyAdapter;
import kr.co.tjeit.instagramcopy.data.ReplyData;

public class ReplyListActivity extends BaseActivity {

    private android.widget.ListView replyListView;
    List<ReplyData> replyDataList = new ArrayList<>();
    ReplyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply_list);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {
        mAdapter = new ReplyAdapter(mContext, replyDataList);
        replyListView.setAdapter(mAdapter);
    }

    @Override
    public void bindViews() {
        this.replyListView = (ListView) findViewById(R.id.replyListView);
    }
}
