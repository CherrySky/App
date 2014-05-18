package com.example.photographerapp1.adapter;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.photographerapp1.bo.Profile;

import com.example.photographerapp1.ItemListFragment;
import com.example.photographerapp1.R;

public class PhotographerListAdapter<T> extends BaseAdapter {

	List<T> photographerList;

	ItemListFragment listFragment;

	public PhotographerListAdapter(ItemListFragment listFragment) {
		this.listFragment = listFragment;
	}

	public List<Profile> getDummyPhotogapherList() {
		ArrayList<Profile> list = new ArrayList<Profile>();
		
		Profile profile = new Profile();
		profile.setProfileName("Don Kwan");
		profile.setProfileDesc("Hello~");
		list.add(profile);
		
		profile = new Profile();
		profile.setProfileName("Keith Au");
		profile.setProfileDesc("Im pro ;)");
		list.add(profile);
		
		profile = new Profile();
		profile.setProfileName("William Tung");
		profile.setProfileDesc("Im plastic :)");
		list.add(profile);
		
		for (int i = 0; i < 5; i++) {
			profile = new Profile();
			profile.setProfileName("...." + i);
			profile.setProfileDesc("......" + i);
			list.add(profile);
		}
		return list;
	}
	


	@Override
	public int getCount() {
		return photographerList.size();
	}

	@Override
	public Profile getItem(int position) {
		return (Profile) photographerList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) listFragment.getActivity()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.main_list_item, parent,
					false);
		}

		TextView name = (TextView) convertView.findViewById(R.id.profileName);
		TextView description = (TextView) convertView
				.findViewById(R.id.profileDesc);

		Profile photographer = getItem(position);
		name.setText(photographer.getProfileName());
		description.setText(photographer.getProfileDesc());

		return convertView;
	}

	public void setDataSource(List<T> photogapherList) {
		this.photographerList = photogapherList;
	}

}
