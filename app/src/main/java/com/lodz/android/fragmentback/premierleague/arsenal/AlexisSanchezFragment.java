package com.lodz.android.fragmentback.premierleague.arsenal;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lodz.android.fragmentback.R;
import com.lodz.android.fragmentback.base.BaseFragment;

/**
 * Created by zhouL on 2016/12/18.
 */

public class AlexisSanchezFragment extends BaseFragment{
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_common_layout;
    }

    @Override
    protected void findViews(View view, Bundle savedInstanceState) {
        TextView title = (TextView) view.findViewById(R.id.name_text_view);
        title.setText("桑切斯");
    }
}
