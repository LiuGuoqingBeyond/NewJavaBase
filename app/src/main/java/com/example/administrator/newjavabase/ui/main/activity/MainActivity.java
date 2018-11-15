package com.example.administrator.newjavabase.ui.main.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.newjavabase.R;
import com.example.administrator.newjavabase.utils.dialog.ToastUtils;
import com.whty.xzfpos.base.AppToolBarActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppToolBarActivity {
    @BindView(R.id.btn_print)
    Button btn_print;
    @Override
    protected void initToolBar() {

    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViewsAndEvents() {
        ButterKnife.bind(MainActivity.this);
    }

    @OnClick({R.id.btn_print})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_print:
                ToastUtils.showLong("sadada");
                break;
        }
    }

    @Override
    protected View getLoadingTargetView() {
        return null;
    }
}
