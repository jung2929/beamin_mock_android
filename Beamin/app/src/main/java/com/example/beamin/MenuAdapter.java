package com.example.beamin;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.widget.Toast;

public class MenuAdapter extends FragmentStatePagerAdapter {

    private int mPageCount;
    public MenuAdapter(FragmentManager fm, int pageCount) {
        super(fm);
        this.mPageCount = pageCount;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fm = new ListFragment();
        switch (position) {
            //menu 별로 list adapter 설정
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            default:
                return null;
        }
        return fm;
    }

    @Override
    public int getCount() {
        return mPageCount;
    }
}
//Menu TabView에서 선택시 아래의 View Pager의 ListView 데이터가 바뀐다.