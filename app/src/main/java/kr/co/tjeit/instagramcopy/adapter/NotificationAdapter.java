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
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import kr.co.tjeit.instagramcopy.R;
import kr.co.tjeit.instagramcopy.ReplyListActivity;
import kr.co.tjeit.instagramcopy.data.NotificationData;
import kr.co.tjeit.instagramcopy.data.PostingData;

/**
 * Created by user on 2017-08-17.
 */

public class NotificationAdapter extends ArrayAdapter<NotificationData> {
    Context mContext;
    List<NotificationData> mList;
    LayoutInflater inf;

    public NotificationAdapter(Context context, List<NotificationData> list) {
        super(context, R.layout.notification_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inf.inflate(R.layout.notification_list_item, null);
        }

        NotificationData data = mList.get(position);
        TextView nicknameTxt = (TextView) row.findViewById(R.id.nicknameTxt);
        TextView notificationTxt = (TextView) row.findViewById(R.id.notificationTxt);

        nicknameTxt.setText(data.getActor().getNickName());

        // %d > int
        // %f > float, double
        // %s > String
        if (data.getActionType().equals("like")) {
            notificationTxt.setText("님이 게시물을 좋아합니다.");
        } else {
            notificationTxt.setText("님이 게시물에 댓글을 남겼습니다.");
        }

        return row;
    }
}
