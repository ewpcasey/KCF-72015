package com.kcf_72015;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity {

	private static final int NUM_PAGES = 5;
	
	private ViewPager viewPager;
	private PagerAdapter mainPagerAdapter;
	
	@Override
	//Instantiation of this activity
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Set content view to the corresponding xml file.
		setContentView(R.layout.page_frame);
		
		//Create new pager using the pager identified in activity_main.
		viewPager = (ViewPager) findViewById(R.id.menu_fragment);
		//Create a new adapter and assign it to the pager.
		mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
		viewPager.setAdapter(mainPagerAdapter);
		
		final Button button_Me = (Button) findViewById(R.id.button_Me);
		final Button button_MeU = (Button) findViewById(R.id.button_MeU);
		final Button button_Sync = (Button) findViewById(R.id.button_Sync);
		final Button button_P2P = (Button) findViewById(R.id.button_P2P);
		
		button_Me.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				viewPager.setCurrentItem(1);
			}
		});
		button_MeU.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				viewPager.setCurrentItem(2);
			}
		});
		button_Sync.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				viewPager.setCurrentItem(3);
			}
		});
		button_P2P.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				viewPager.setCurrentItem(4);
			}
		});
	}
	
	@Override
	//Handle back button press.
	public void onBackPressed(){
		//If on first page, let system handle back button operation; otherwise, select previous step
		if (viewPager.getCurrentItem() == 0){
			super.onBackPressed();
		}
		else{
			viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
		}
	}
	
	//Customized PagerAdapter class
	private class MainPagerAdapter extends FragmentStatePagerAdapter{
		public MainPagerAdapter(FragmentManager fm){
			super(fm);
		}
		
		@Override
		//required override method
		public Fragment getItem(int position){
			return new MenuFragment(position);
		}
		
		@Override
		//required override method
		public int getCount(){
			return NUM_PAGES;
		}
	}
}
