package nextrace.app.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.List;
import nextrace.app.R;
import nextrace.app.listener.ClickListener;
import nextrace.app.model.Event;
import nextrace.app.model.EventList;
import nextrace.app.model.Race;

public class RecyclerViewRaceAdapter extends RecyclerView.Adapter<RecyclerViewRaceAdapter.myViewHolder> {

    private List<Event> raceEvents;
    private List<Race> raceList;
    private ClickListener clickListener;

    public RecyclerViewRaceAdapter(List<Race> raceList, ClickListener clickListener) {
        this.raceList = raceList;
        this.clickListener = clickListener;
    }

    public void setRaceList(List<Race> raceList){
        this.raceList = raceList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerViewRaceAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_race,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        final Race race = raceList.get(position);

        Picasso.get().load(race.getCategory().getCategoryLogo().toString()).into(holder.categoryLogo);
        Picasso.get().load(race.getTrack().getCountry().getLink()).into(holder.countryFlag);

        Race new_race = raceList.get(position);
        raceEvents = new_race.getEventList().getEvents();

        for(int j = 0; j < raceEvents.size(); j++){
                if(raceEvents.get(j).getType().equals("Race")){
                    holder.raceDate.setText(raceEvents.get(j).getDate());
                    holder.raceLocalTime.setText(raceEvents.get(j).getLocalTime());
                    holder.raceCETTime.setText(raceEvents.get(j).getCetTime());
                }
        }


        holder.raceName.setText(race.getRaceName());
        holder.trackName.setText(race.getTrack().getName());
        holder.raceLaps.setText(race.getLaps().toString());
        holder.color_1.setBackgroundColor(Color.parseColor(race.getCategory().getCategoryHexColor()));
        holder.color_2.setBackgroundColor(Color.parseColor(race.getCategory().getCategoryHexColor()));
    }

    @Override
    public int getItemCount() {
        if(raceList != null){
            return raceList.size();
        }
        return 0;
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        public TextView raceName, trackName, raceDate, raceLocalTime, raceCETTime, raceLaps;
        public ImageView categoryLogo, countryFlag;
        public FrameLayout color_1, color_2;
        public CardView cardView;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            raceName = itemView.findViewById(R.id.race_name);
            trackName = itemView.findViewById(R.id.track_name);
            raceDate = itemView.findViewById(R.id.race_date);
            raceLocalTime = itemView.findViewById(R.id.race_local_time);
            raceCETTime = itemView.findViewById(R.id.race_cet_time);
            raceLaps = itemView.findViewById(R.id.race_laps);
            categoryLogo = itemView.findViewById(R.id.race_category_logo);
            countryFlag = itemView.findViewById(R.id.race_country_flag);
            cardView = itemView.findViewById(R.id.item_race_view);
            color_1 = itemView.findViewById(R.id.color_1);
            color_2 = itemView.findViewById(R.id.color_2);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    clickListener.onClick(getAdapterPosition());
                }
            });
        }

    }
}
