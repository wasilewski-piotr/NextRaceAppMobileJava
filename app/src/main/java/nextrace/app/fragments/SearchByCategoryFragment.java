package nextrace.app.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import nextrace.app.R;
import nextrace.app.adapter.RecyclerViewRaceAdapter;
import nextrace.app.api.RaceApi;
import nextrace.app.api.RaceApiClient;
import nextrace.app.listener.ClickListener;
import nextrace.app.model.Race;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchByCategoryFragment extends Fragment implements ClickListener {

    private RecyclerView recyclerView;
    private RecyclerViewRaceAdapter raceAdapter;
    private List<Race> raceList;

    public SearchByCategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search_by_category, container, false);

        EditText editText = (EditText) rootView.findViewById(R.id.editText_category);
        Button button = (Button) rootView.findViewById(R.id.button_find_category);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = editText.getText().toString();
                getData(rootView, value);
                dismissKeyboard(getActivity());
            }
        });

        return rootView;
    }

    public void getData(View view, String value){
        recyclerView = (RecyclerView) view.findViewById(R.id.item_race_list_by_category);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        raceAdapter = new RecyclerViewRaceAdapter(raceList, this);

        recyclerView.setAdapter(raceAdapter);

        RaceApi raceApi = RaceApiClient.getRaces().create(RaceApi.class);
        Call<List<Race>> call = raceApi.getRacesByCategoryName(value);
        call.enqueue(new Callback<List<Race>>() {
            @Override
            public void onResponse(Call<List<Race>> call, Response<List<Race>> response) {
                raceList = response.body();
                Log.d("TAG","Response = "+raceList);

                raceAdapter.setRaceList(raceList);
            }

            @Override
            public void onFailure(Call<List<Race>> call, Throwable t) {
                Log.d("TAG","Response = "+t.toString());
            }
        });
    }

    @Override
    public void onClick(Object data) {

    }

    public void dismissKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (null != activity.getCurrentFocus())
            imm.hideSoftInputFromWindow(activity.getCurrentFocus()
                    .getApplicationWindowToken(), 0);
    }
}
