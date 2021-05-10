package nextrace.app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import nextrace.app.R;
import nextrace.app.adapter.SectionsPageAdapter;

public class SearchFragment extends Fragment {

    private ViewPager viewPager;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_search, container, false);

        viewPager = (ViewPager) rootView.findViewById(R.id.container);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        return rootView;
    }

    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getChildFragmentManager());
        adapter.addFragment(new SearchByCategoryFragment(), "Category");
        adapter.addFragment(new SearchByCountryFragment(), "Country");
        adapter.addFragment(new SearchByTrackNameFragment(), "Track");
        viewPager.setAdapter(adapter);
    }


}
