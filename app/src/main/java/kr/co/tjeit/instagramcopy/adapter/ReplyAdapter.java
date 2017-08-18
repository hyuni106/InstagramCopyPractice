package kr.co.tjeit.instagramcopy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import java.util.List;

import kr.co.tjeit.instagramcopy.R;
import kr.co.tjeit.instagramcopy.data.NotificationData;
import kr.co.tjeit.instagramcopy.data.ReplyData;

/**
 * Created by user on 2017-08-18.
 */

public class ReplyAdapter extends ArrayAdapter<ReplyData> {
    Context mContext;
    List<ReplyData> mList;
    LayoutInflater inf;

    public ReplyAdapter(Context context, List<ReplyData> list) {
        super(context, R.layout.reply_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inf.inflate(R.layout.reply_list_item, null);
        }

        LinearLayout ReLayout = (LinearLayout)row.findViewById(R.id.ReLayout);
        ReLayout.setVisibility(View.GONE);

        return row;
    }

    @Override
    public int getCount() {
        return 20;
    }
}
