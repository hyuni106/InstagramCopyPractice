package kr.co.tjeit.instagramcopy.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;

import kr.co.tjeit.instagramcopy.R;
import kr.co.tjeit.instagramcopy.ReplyListActivity;
import kr.co.tjeit.instagramcopy.data.PostingData;

/**
 * Created by user on 2017-08-17.
 */

public class NewsFeedAdapter extends ArrayAdapter<PostingData> {
    Context mContext;
    List<PostingData> mList;
    LayoutInflater inf;

    public NewsFeedAdapter(Context context, List<PostingData> list) {
        super(context, R.layout.newsfeed_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inf.inflate(R.layout.newsfeed_list_item, null);
        }
        ImageView replyImgView = (ImageView) row.findViewById(R.id.replyImgView);

        replyImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ReplyListActivity.class);
                mContext.startActivity(intent);
            }
        });

        return row;
    }

    @Override
    public int getCount() {
        return 20;
    }
}
