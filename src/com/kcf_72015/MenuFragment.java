package com.kcf_72015;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MenuFragment extends Fragment{
	
	private int layout;
	
	public MenuFragment(int page){
		switch(page){
		case 0:
			layout = R.layout.menu_fragment_top;
		case 1:
			layout = R.layout.menu_fragment_me;
		case 2:
			layout = R.layout.menu_fragment_meu;
		case 3:
			layout = R.layout.menu_fragment_sync;
		default:
			layout = R.layout.menu_fragment_p2p;
		}
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		super.onCreateView(inflater, container, savedInstanceState);
		
		ViewGroup rootView = (ViewGroup) inflater.inflate(layout, container, false);
		
		return rootView;
	}
}
