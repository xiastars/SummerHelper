package com.summer.demo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.summer.demo.adapter.CommonAdapter;
import com.summer.demo.fragment.HorListFragment;
import com.summer.demo.fragment.list.RecycleGridFragment;
import com.summer.demo.fragment.list.RecycleListFragment;
import com.summer.helper.utils.JumpTo;
import com.summer.helper.web.WebContainerActivity;

import java.util.ArrayList;
import java.util.List;


/**
 * Java基础
 *
 * @author xiastars@vip.qq.com
 */
public class AcWXApp extends FragmentActivity implements OnItemClickListener, View.OnClickListener {
    private ListView titles;
    private Context context;
    FragmentManager fragmentManager;
    /* 当前显示的Fragment */
    Fragment mFragment;
    Button btnConceal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.ac_main);
        fragmentManager = this.getSupportFragmentManager();
        context = AcWXApp.this;
        initView();
    }

    private void initView() {
        titles = (ListView) findViewById(R.id.listview);
        titles.setOnItemClickListener(this);
        CommonAdapter adapter = new CommonAdapter(context);
        titles.setAdapter(adapter);
        adapter.notifyDataChanged(getData(context));

        btnConceal = (Button) findViewById(R.id.btn_conceal);
        btnConceal.setOnClickListener(this);
    }

    /**
     * 监听系统的返回键，当处于Fragment时，点击返回，则回到主界面
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mFragment != null) {
                removeFragment();
                return true;
            } else {
                finish();
            }
            return false;
        }
        return false;
    }

    public static List<String> getData(Context context) {
        List<String> title = new ArrayList<String>();
        /* 从XML里获取String数组的方法*/
        String[] group = context.getResources().getStringArray(R.array.wxapp_titles);
        for (int i = 0; i < group.length; i++) {
            String ti = group[i];
            title.add(ti);
        }
        return title;
    }

    /**
     * 点击每个子项跳转
     */
    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
        switch (position) {
            case 0:
                jump("https://xiastars.gitbooks.io/wxapp/content/%E7%AC%AC%E4%B8%80%E8%8A%82-%E4%BB%8E%E9%9B%B6%E5%BC%80%E5%A7%8B.html");
                break;
            case 1:
                jump("https://xiastars.gitbooks.io/wxapp/content/%E7%AC%AC%E4%BA%8C%E8%8A%82-d.html");
                break;
            case 2:
                jump("https://xiastars.gitbooks.io/wxapp/content/%E7%AC%AC%E4%B8%89%E8%8A%82-%E5%88%9B%E5%BB%BAjs%E6%96%87%E4%BB%B6.html");
                break;
            case 3:
                jump("https://xiastars.gitbooks.io/wxapp/content/%E7%AC%AC%E4%B8%89%E8%8A%82-%E4%BA%86%E8%A7%A3view%E5%B1%82.html");
                break;
            case 4:
                jump("https://xiastars.gitbooks.io/wxapp/content/%E7%AC%AC%E4%BA%94%E8%8A%82-css%E5%9F%BA%E7%A1%80.html");
                break;
        }
    }

    private void jump(String url){
        JumpTo.getInstance().commonJump(context, WebContainerActivity.class,url);
    }

    public void showFragment(Fragment fragment) {
        //销毁已显示的Fragment
        removeFragment();
        beginTransation(fragment);
    }

    /**
     * 添加Fragment
     *
     * @param fragment
     */
    private void beginTransation(Fragment fragment) {
        mFragment = fragment;
        findViewById(R.id.ll_container).setVisibility(View.VISIBLE);
        btnConceal.setVisibility(View.VISIBLE);
        fragmentManager.beginTransaction().add(R.id.ll_container, fragment).commit();
    }

    /**
     * 销毁Fragment最适用的方法是将它替换成一个空的
     */
    private void removeFragment() {
        mFragment = null;
        findViewById(R.id.ll_container).setVisibility(View.GONE);
        Fragment fragment = new Fragment();
        fragmentManager.beginTransaction().replace(R.id.ll_container, fragment).commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_conceal:
                removeFragment();
                btnConceal.setVisibility(View.GONE);
                break;
        }
    }

}
