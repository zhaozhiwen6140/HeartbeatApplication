package com.example.zhaozhiwen.heartbeatapplication.Activity;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.zhaozhiwen.heartbeatapplication.AlphaForegroundColorSpan;
import com.example.zhaozhiwen.heartbeatapplication.FocusItemModel;
import com.example.zhaozhiwen.heartbeatapplication.Adapter.ListViewAdapter;
import com.example.zhaozhiwen.heartbeatapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaozhiwen on 2016/4/25.
 */

public class NoBoringActionBarActivity extends Activity {

    private static final String TAG = "NoBoringActionBarActivity";
    private int mActionBarTitleColor;
    private int mActionBarHeight;
    private int mHeaderHeight;
    private int mMinHeaderTranslation;
    private ListView mListView;
    private ImageView mHeaderPicture;
    private ImageView mHeaderLogo;
    private View mHeader;
    private View mPlaceHolderView;
    private AccelerateDecelerateInterpolator mSmoothInterpolator;
    private int width;
    private int height;
    private int paramHeight;
    private List <FocusItemModel> focusList;

    private RectF mRect1 = new RectF();
    private RectF mRect2 = new RectF();

    private AlphaForegroundColorSpan mAlphaForegroundColorSpan;
    private SpannableString mSpannableString;

    private TypedValue mTypedValue = new TypedValue();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSmoothInterpolator = new AccelerateDecelerateInterpolator();
        setContentView(R.layout.activity_noboringactionbar);
        mHeaderPicture = (ImageView) findViewById(R.id.header_picture);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        width = dm.widthPixels;
        height = dm.heightPixels;

        FrameLayout.LayoutParams params= (FrameLayout.LayoutParams)mHeaderPicture.getLayoutParams();
        paramHeight=width/2;
        params.height=paramHeight;
        mHeaderPicture.setLayoutParams(params);
        mHeaderHeight=paramHeight;

//      mHeaderHeight = getResources().getDimensionPixelSize(R.dimen.header_height);
        mMinHeaderTranslation = -mHeaderHeight + getActionBarHeight();

        mListView = (ListView) findViewById(R.id.listview);
        mHeader = findViewById(R.id.header);

//      mHeaderPicture.setResourceIds(R.drawable.picture0, R.drawable.picture1);
        mHeaderLogo = (ImageView) findViewById(R.id.header_logo);
        mActionBarTitleColor = getResources().getColor(R.color.actionbar_title_color);
        mSpannableString = new SpannableString(getString(R.string.noboringactionbar_title));
        mAlphaForegroundColorSpan = new AlphaForegroundColorSpan(mActionBarTitleColor);
        setupActionBar();
        setupListView();
    }

    private void setupListView() {
         focusList = new ArrayList();
         initData();
        mPlaceHolderView = getLayoutInflater().inflate(R.layout.view_header_placeholder, mListView, false);
        mPlaceHolderView.setLayoutParams(new AbsListView.LayoutParams(width,paramHeight));
        mListView.addHeaderView(mPlaceHolderView);
        mListView.setAdapter(new ListViewAdapter(this,focusList));
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                int scrollY = getScrollY();
                mHeader.setTranslationY(Math.max(-scrollY, mMinHeaderTranslation));
                float ratio = clamp(mHeader.getTranslationY() / mMinHeaderTranslation, 0.0f, 1.0f);
                interpolate(mHeaderLogo, getActionBarIconView(), mSmoothInterpolator.getInterpolation(ratio));
                setTitleAlpha(clamp(5.0F * ratio - 4.0F, 0.0F, 1.0F));
            }
        });
    }

    private void initData() {
        focusList.add(new FocusItemModel("蘑菇街","蘑菇街，专注于时尚女性消费者的电子商务网站，为姑娘们提供衣服、鞋子、箱包、配饰和美妆等等领域适合年轻女性的商品，蘑菇街APP也成为时尚女性购买和互相分享的必备APP。","http://pic.orsoon.com/uploads/allimg/2015/11/05/6-46671446689009.jpeg",
                "http://2.pic.anfensi.com/Uploads/Picture/2016-3-9/t013954ee0bcb9b9d65.png","http://pic.5577.com/up/2016-3/20163151017483240.png","Mia音乐","听音乐"));

    }

    private void setTitleAlpha(float alpha) {
        mAlphaForegroundColorSpan.setAlpha(alpha);
        mSpannableString.setSpan(mAlphaForegroundColorSpan, 0, mSpannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        getActionBar().setTitle(mSpannableString);
    }

    public static float clamp(float value, float max, float min) {
        return Math.max(Math.min(value, min), max);
    }

    private void interpolate(View view1, View view2, float interpolation) {
        getOnScreenRect(mRect1, view1);
        getOnScreenRect(mRect2, view2);

        float scaleX = 1.0F + interpolation * (mRect2.width() / mRect1.width() - 1.0F);
        float scaleY = 1.0F + interpolation * (mRect2.height() / mRect1.height() - 1.0F);
        float translationX = 0.5F * (interpolation * (mRect2.left + mRect2.right - mRect1.left - mRect1.right));
        float translationY = 0.5F * (interpolation * (mRect2.top + mRect2.bottom - mRect1.top - mRect1.bottom));

        view1.setTranslationX(translationX);
        view1.setTranslationY(translationY - mHeader.getTranslationY());
        view1.setScaleX(scaleX);
        view1.setScaleY(scaleY);
    }

    private RectF getOnScreenRect(RectF rect, View view) {
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        return rect;
    }

    public int getScrollY() {
        View c = mListView.getChildAt(0);
        if (c == null) {
            return 0;
        }

        int firstVisiblePosition = mListView.getFirstVisiblePosition();
        int top = c.getTop();

        int headerHeight = 0;
        if (firstVisiblePosition >= 1) {
            headerHeight = mPlaceHolderView.getHeight();
        }

        return -top + firstVisiblePosition * c.getHeight() + headerHeight;
    }

    private void setupActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setIcon(R.drawable.ic_transparent);
    }

    private ImageView getActionBarIconView() {
        return (ImageView) findViewById(android.R.id.home);
    }


    public int getActionBarHeight() {
        if (mActionBarHeight != 0) {
            return mActionBarHeight;
        }
        getTheme().resolveAttribute(android.R.attr.actionBarSize, mTypedValue, true);
        mActionBarHeight = TypedValue.complexToDimensionPixelSize(mTypedValue.data, getResources().getDisplayMetrics());
        return mActionBarHeight;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return  true;
    }
}
