package com.summer.demo.ui.view;

import android.view.View;

import com.summer.demo.R;
import com.summer.demo.adapter.CommonGridAdapter;
import com.summer.demo.bean.ModuleInfo;
import com.summer.demo.ui.main.BaseMainFragment;
import com.summer.helper.listener.OnSimpleClickListener;
import com.summer.helper.utils.JumpTo;
import com.summer.helper.view.NRecycleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @Description: 自定义View
 * @Author: xiastars@vip.qq.com
 * @CreateDate: 2019/10/9 10:29
 */
public class CustomViewFragment extends BaseMainFragment {
    @BindView(R.id.sv_container)
    NRecycleView svContainer;

    CommonGridAdapter adapter;

    @Override
    protected void initView(View view) {
        svContainer.setGridView(3);
        svContainer.setDivider();


        final List<ModuleInfo> moduleInfos = new ArrayList<>();
        moduleInfos.add(new ModuleInfo(R.drawable.so_gradient_redffe_blued8, "item收集", ElementPosition.POS_ITEM));
        moduleInfos.add(new ModuleInfo(R.drawable.ic_view_gallery, "Gallery", ElementPosition.POS));
        moduleInfos.add(new ModuleInfo(R.drawable.ic_view_danmake,"简单弹幕",ElementPosition.DANMAKU));
        moduleInfos.add(new ModuleInfo(R.drawable.ic_module_vibrate,"dd",ElementPosition.CAL));
        moduleInfos.add(new ModuleInfo(R.drawable.ic_view_calendar,"日历(当月)",ElementPosition.CALENDAR));
        moduleInfos.add(new ModuleInfo(R.drawable.ic_progress,"Battle",ElementPosition.BYD));

        adapter = new CommonGridAdapter(context, new OnSimpleClickListener() {
            @Override
            public void onClick(int position) {
                clickChild(moduleInfos.get(position).getPos());
            }
        });
        svContainer.setAdapter(adapter);
        adapter.notifyDataChanged(moduleInfos);
    }

    private void clickChild(int position) {
        JumpTo.getInstance().commonJump(context, ViewCustomContainerActivity.class, position);
    }

    @Override
    public void loadData() {

    }

    @Override
    protected void dealDatas(int requestType, Object obj) {

    }

    @Override
    protected int setContentView() {
        return R.layout.view_nrecyleview;
    }

}
