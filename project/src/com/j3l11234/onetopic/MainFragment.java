package com.j3l11234.onetopic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment{
	
	private TopicFragment topicFragment;
	private MessageFragment messageFragment;
	private MeFragment meFragment;
	private ViewPager mViewPager;
	private SectionsPagerAdapter mAdapter;
	
	public MainFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container,
				false);
		
		topicFragment = new TopicFragment();
		messageFragment = new MessageFragment();
		meFragment = new MeFragment();
		
		mAdapter = new SectionsPagerAdapter(getChildFragmentManager());
        mViewPager = (ViewPager) rootView.findViewById(R.id.main_view_paper);
        mViewPager.setAdapter(mAdapter); 
        
		return rootView;
	}
	
	@Override
	public void onDestroy() {
		//fm.beginTransaction().remove(topicFragment).remove(messageFragment).remove(meFragment).commit();
		super.onDestroy();
	}
	
	private class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int i) {
            switch (i) {
                case 0: return topicFragment;
                case 1: return messageFragment;
                case 2: return meFragment;
            }	
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0: return getString(R.string.tab_title_topic);
                case 1: return getString(R.string.tab_title_message);
                case 2: return getString(R.string.tab_title_me);
            }
            return null;
        }
    }
}
