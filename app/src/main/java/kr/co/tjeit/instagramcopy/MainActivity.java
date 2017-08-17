package kr.co.tjeit.instagramcopy;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.instagramcopy.adapter.NewsFeedAdapter;
import kr.co.tjeit.instagramcopy.adapter.NotificationAdapter;
import kr.co.tjeit.instagramcopy.data.NotificationData;
import kr.co.tjeit.instagramcopy.data.PostingData;
import kr.co.tjeit.instagramcopy.util.ContextUtil;

public class MainActivity extends BaseActivity {

    private android.widget.Button logoutBtn;
    private android.widget.ImageView tabBtn1;
    private ImageView tabBtn2;
    private ImageView tabBtn3;
    private ImageView tabBtn4;
    private ImageView tabBtn5;
    private android.widget.ListView newsfeedListView;
    private android.widget.LinearLayout newsfeedLayout;

    NewsFeedAdapter newsFeedAdapter;
    List<PostingData> postingDataList = new ArrayList<>();
    NotificationAdapter notificationAdapter;
    List<NotificationData> notificationDataList = new ArrayList<>();

    private ImageView instaLogoImg;
    private android.widget.TextView profileTxt;
    private android.widget.TextView textView;
    private ListView profileListView;
    private LinearLayout profileLayout;
    private TextView notiTxt;
    private TextView followerSelectLine;
    private LinearLayout followerLayout;
    private TextView youSelectLine;
    private LinearLayout youLayout;
    private ListView notiListView;
    private LinearLayout notificationLayout;
    private TextView followerTxt;
    private TextView youTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 로그아웃 기능 구현
                ContextUtil.logoutProcess(mContext);
                Intent intent = new Intent(mContext, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        youLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youTxt.setTextColor(Color.parseColor("#125687"));
                followerTxt.setTextColor(Color.parseColor("#000000"));
                youSelectLine.setVisibility(View.VISIBLE);
                followerSelectLine.setVisibility(View.GONE);
            }
        });

        followerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youTxt.setTextColor(Color.parseColor("#000000"));
                followerTxt.setTextColor(Color.parseColor("#125687"));
                youSelectLine.setVisibility(View.GONE);
                followerSelectLine.setVisibility(View.VISIBLE);
            }
        });

        View.OnClickListener emptyHome = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingVisible();
                if (v.getId() == R.id.tabBtn1) {
                    tabBtn1.setImageResource(R.drawable.home_fill);
                    newsfeedLayout.setVisibility(View.VISIBLE);
                    instaLogoImg.setVisibility(View.VISIBLE);
                } else if (v.getId() == R.id.tabBtn2) {
                    tabBtn2.setImageResource(R.drawable.home_fill);
                } else if (v.getId() == R.id.tabBtn3) {
                    tabBtn3.setImageResource(R.drawable.home_fill);

                } else if (v.getId() == R.id.tabBtn4) {
                    tabBtn4.setImageResource(R.drawable.home_fill);
                    notificationLayout.setVisibility(View.VISIBLE);
                    notiTxt.setVisibility(View.VISIBLE);
                    notiListView.setVisibility(View.VISIBLE);
                } else {
                    tabBtn5.setImageResource(R.drawable.home_fill);
                    profileLayout.setVisibility(View.VISIBLE);
                    profileTxt.setVisibility(View.VISIBLE);
                }
            }
        };

        tabBtn1.setOnClickListener(emptyHome);
        tabBtn2.setOnClickListener(emptyHome);
        tabBtn3.setOnClickListener(emptyHome);
        tabBtn4.setOnClickListener(emptyHome);
        tabBtn5.setOnClickListener(emptyHome);
    }

    public void settingVisible() {
        tabBtn1.setImageResource(R.drawable.home_empty);
        tabBtn2.setImageResource(R.drawable.home_empty);
        tabBtn3.setImageResource(R.drawable.home_empty);
        tabBtn4.setImageResource(R.drawable.home_empty);
        tabBtn5.setImageResource(R.drawable.home_empty);
        profileLayout.setVisibility(View.INVISIBLE);
        newsfeedLayout.setVisibility(View.INVISIBLE);
        profileTxt.setVisibility(View.INVISIBLE);
        instaLogoImg.setVisibility(View.INVISIBLE);
        notificationLayout.setVisibility(View.INVISIBLE);
        notiTxt.setVisibility(View.INVISIBLE);
        notiListView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setValues() {
        newsFeedAdapter = new NewsFeedAdapter(mContext, postingDataList);
        newsfeedListView.setAdapter(newsFeedAdapter);

        notificationAdapter = new NotificationAdapter(mContext, notificationDataList);
        notiListView.setAdapter(notificationAdapter);
    }

    @Override
    public void bindViews() {
        this.logoutBtn = (Button) findViewById(R.id.logoutBtn);
        this.tabBtn5 = (ImageView) findViewById(R.id.tabBtn5);
        this.tabBtn4 = (ImageView) findViewById(R.id.tabBtn4);
        this.tabBtn3 = (ImageView) findViewById(R.id.tabBtn3);
        this.tabBtn2 = (ImageView) findViewById(R.id.tabBtn2);
        this.tabBtn1 = (ImageView) findViewById(R.id.tabBtn1);
        this.notificationLayout = (LinearLayout) findViewById(R.id.notificationLayout);
        this.notiListView = (ListView) findViewById(R.id.notiListView);
        this.youLayout = (LinearLayout) findViewById(R.id.youLayout);
        this.youSelectLine = (TextView) findViewById(R.id.youSelectLine);
        this.youTxt = (TextView) findViewById(R.id.youTxt);
        this.followerLayout = (LinearLayout) findViewById(R.id.followerLayout);
        this.followerSelectLine = (TextView) findViewById(R.id.followerSelectLine);
        this.followerTxt = (TextView) findViewById(R.id.followerTxt);
        this.profileLayout = (LinearLayout) findViewById(R.id.profileLayout);
        this.profileListView = (ListView) findViewById(R.id.profileListView);
        this.textView = (TextView) findViewById(R.id.textView);
        this.newsfeedLayout = (LinearLayout) findViewById(R.id.newsfeedLayout);
        this.newsfeedListView = (ListView) findViewById(R.id.newsfeedListView);
        this.notiTxt = (TextView) findViewById(R.id.notiTxt);
        this.profileTxt = (TextView) findViewById(R.id.profileTxt);
        this.instaLogoImg = (ImageView) findViewById(R.id.instaLogoImg);
    }
}
