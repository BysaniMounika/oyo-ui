package com.example.android.oyo;

import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by admin1 on 13/3/18.
 */

public interface RecyclerViewItemListener {
    void onClick(View view, int position, boolean isLongClick);

}
