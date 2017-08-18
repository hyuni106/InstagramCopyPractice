package kr.co.tjeit.instagramcopy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import kr.co.tjeit.instagramcopy.data.PostingData;
import kr.co.tjeit.instagramcopy.util.GlobalData;

public class ViewPostActivity extends BaseActivity {

    private android.widget.ImageView backBtn;
    private android.widget.ImageView refreshBtn;
    private android.widget.TextView nameTxt;
    private android.widget.ImageView replyImgView;
    private android.widget.TextView allCommentTxt;
    PostingData postingData = null;
    private TextView contentTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_post);
        postingData = (PostingData) getIntent().getSerializableExtra("data");
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "댓글을 새로 읽어옵니다..", Toast.LENGTH_SHORT).show();
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        View.OnClickListener intentReply = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ReplyListActivity.class);
                intent.putExtra("replies", postingData);
                startActivity(intent);
            }
        };

        replyImgView.setOnClickListener(intentReply);
        allCommentTxt.setOnClickListener(intentReply);
    }

    @Override
    public void setValues() {
        nameTxt.setText(postingData.getWriterData().getNickName());
        contentTxt.setText(postingData.getContent());
    }

    @Override
    public void bindViews() {
        this.allCommentTxt = (TextView) findViewById(R.id.allCommentTxt);
        this.contentTxt = (TextView) findViewById(R.id.contentTxt);
        this.replyImgView = (ImageView) findViewById(R.id.replyImgView);
        this.nameTxt = (TextView) findViewById(R.id.nameTxt);
        this.refreshBtn = (ImageView) findViewById(R.id.refreshBtn);
        this.backBtn = (ImageView) findViewById(R.id.backBtn);
    }
}
