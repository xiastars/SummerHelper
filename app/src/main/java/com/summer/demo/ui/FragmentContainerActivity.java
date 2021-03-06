package com.summer.demo.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.FrameLayout;

import com.summer.demo.R;
import com.summer.demo.module.base.BaseFragment;
import com.summer.demo.module.base.BaseFragmentActivity;
import com.summer.demo.ui.fragment.views.TextViewFragment;
import com.summer.demo.ui.view.UiPosition;
import com.summer.demo.ui.view.commonfragment.CDrawableFragment;
import com.summer.demo.ui.view.commonfragment.ConstraintLayoutFragment;
import com.summer.demo.ui.view.commonfragment.EditTextFragment;
import com.summer.demo.ui.view.commonfragment.recyclerview.RecyclerViewFragment;
import com.summer.demo.ui.view.commonfragment.ViewPagerFragment;
import com.summer.demo.ui.view.customfragment.ProgressBarFragment;
import com.summer.helper.utils.JumpTo;

import butterknife.BindView;

/**
 * @Description: Fragment容器
 * @Author: xiastars@vip.qq.com
 * @CreateDate: 2019/10/9 11:44
 */
public class FragmentContainerActivity extends BaseFragmentActivity {
    @BindView(R.id.rl_container)
    FrameLayout rlContainer;

    public BaseFragment mFragment;
    FragmentManager fragmentManager;

    @Override
    protected void loadData() {

    }

    @Override
    protected void finishLoad() {

    }

    @Override
    protected void dealDatas(int requestCode, Object obj) {

    }

    @Override
    protected int setTitleId() {
        return 0;
    }

    @Override
    protected int setContentView() {
        return R.layout.activity_fragment_container;
    }

    @Override
    protected void initData() {
        fragmentManager = this.getSupportFragmentManager();
        int type = JumpTo.getInteger(this);
        showViews(type);
    }

    protected void showViews(int type) {
        switch (type) {
            case UiPosition.POS_DRAWABLE:
                setTitle("Drawable");
                showFragment(new CDrawableFragment());
                break;
            case UiPosition.POS_TEXT:
                setTitle("文本");
                showFragment(new TextViewFragment());
                break;
            case UiPosition.POS_CONSTRAINT:
                setTitle("ConstraintLayout");
                showFragment(new ConstraintLayoutFragment());
                break;
            case UiPosition.POS_LIST_REC:
                setTitle("RecyclerView");
                showFragment(new RecyclerViewFragment());
                break;
            case UiPosition.PROGRESS:
                setTitle("进度条");
                showFragment(new ProgressBarFragment());
                break;
            case UiPosition.EDITTEXT:
                setTitle("EditText");
                showFragment(new EditTextFragment());
                break;
            case UiPosition.VIEWPAGER:
                setTitle("ViewPager");
                showFragment(new ViewPagerFragment());
                break;
        }
    }

    public void showFragment(BaseFragment fragment) {
        //销毁已显示的Fragment
        removeFragment();
        beginTransation(fragment);
    }

    @Override
    protected void onBackClick() {
        if(mFragment != null && mFragment.isHasChildFragment()){
            mFragment.removeChildFragment();
        }else{
            super.onBackClick();
        }
    }

    /**
     * 添加Fragment
     *
     * @param fragment
     */
    private void beginTransation(BaseFragment fragment) {
        mFragment = fragment;
        rlContainer.setVisibility(View.VISIBLE);
        fragmentManager.beginTransaction().add(R.id.rl_container, fragment).commit();
    }

    /**
     * 销毁Fragment最适用的方法是将它替换成一个空的
     */
    private void removeFragment() {
        mFragment = null;
        rlContainer.setVisibility(View.GONE);
        Fragment fragment = new Fragment();
        fragmentManager.beginTransaction().replace(R.id.rl_container, fragment).commit();
    }


}
