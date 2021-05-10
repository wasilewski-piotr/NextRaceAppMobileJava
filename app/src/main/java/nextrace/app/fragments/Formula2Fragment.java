package nextrace.app.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

public class Formula2Fragment extends Fragment implements ClickListener {

    private RecyclerView recyclerView;
    private RecyclerViewRaceAdapter raceAdapter;
    private List<Race> raceList;

    public Formula2Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_formula2, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        getData(view);
    }

    public void getData(View view){
        recyclerView = (RecyclerView) view.findViewById(R.id.item_race_list_formula_2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        raceAdapter = new RecyclerViewRaceAdapter(raceList, this);

        recyclerView.setAdapter(raceAdapter);

        RaceApi raceApi = RaceApiClient.getRaces().create(RaceApi.class);
        Call<List<Race>> call = raceApi.getRacesFormula2();
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
        //On Click Recycler View TODO
    }
}
