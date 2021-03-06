package com.xiaocoder.android_ptr;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;


import com.xiaocoder.android_xcfw.util.UtilScreen;

import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.R;
import in.srain.cube.views.ptr.header.MaterialHeader;

/**
 * @author xiaocoder on 2015/10/9
 * @email fengjingyu@foxmail.com
 * @description 封装了上下拉 ， 分页 ，无数据背景
 * <p/>
 * xml可配置autorefresh属性
 */
public class XCMaterialListPinRefreshLayout extends XCRefreshLayout {

    public XCMaterialListPinRefreshLayout(Context context) {
        super(context);
    }

    public XCMaterialListPinRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public XCMaterialListPinRefreshLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void inflaterLayout(LayoutInflater mInflater) {
        mInflater.inflate(R.layout.xc_l_view_list_refresh, this, true);
    }

    @Override
    public void initHeadStyle() {
        final MaterialHeader header = new MaterialHeader(getContext());
        int[] colors = getResources().getIntArray(R.array.google_colors);
        header.setColorSchemeColors(colors);
        header.setLayoutParams(new PtrFrameLayout.LayoutParams(-1, -2));
        header.setPadding(0, UtilScreen.dip2px(getContext(), 15), 0, UtilScreen.dip2px(getContext(), 10));
        header.setPtrFrameLayout(mPtrRefreshLayout);
        mPtrRefreshLayout.setHeaderView(header);
        mPtrRefreshLayout.addPtrUIHandler(header);
    }

    @Override
    public void initXCRefreshLayoutParams() {
        super.initXCRefreshLayoutParams();
        mPtrRefreshLayout.setLoadingMinTime(1000);
        mPtrRefreshLayout.setDurationToCloseHeader(1000);
        mPtrRefreshLayout.setPinContent(true);
    }
}
