package com.summer.demo.module.base.view;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.summer.demo.R;
import com.summer.helper.utils.SUtils;

public class CommonSureView extends AppCompatTextView {
    public CommonSureView(Context context) {
        super(context);
    }

    public CommonSureView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CommonSureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        SUtils.clickTransColor(this);
    }

    public void changeStyle(boolean enable) {
        this.setEnabled(enable);
        if (enable) {
            this.setBackgroundResource(R.drawable.so_blue56_8);
            this.setTextColor(getContext().getResources().getColor(R.color.white));
        } else {
            this.setBackgroundResource(R.drawable.so_greyd2_8);
            this.setTextColor(getContext().getResources().getColor(R.color.grey_95));
        }
    }
}
