package com.lodz.android.fragmentback.premierleague.manutd;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lodz.android.fragmentback.R;
import com.lodz.android.fragmentback.base.BaseFragment;

/**
 * Created by zhouL on 2016/12/19.
 */

public class CarrickFragment extends BaseFragment{
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_common_layout;
    }

    @Override
    protected void findViews(View view, Bundle savedInstanceState) {
        TextView title = (TextView) view.findViewById(R.id.name_text_view);
        title.setText("卡里克");
    }

    @Override
    public boolean onPressBack() {
        Toast.makeText(getContext(), "卡里克", Toast.LENGTH_SHORT).show();
        return true;
    }
}
