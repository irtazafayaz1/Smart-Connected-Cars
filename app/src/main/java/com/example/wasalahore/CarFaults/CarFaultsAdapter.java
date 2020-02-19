package com.example.wasalahore.CarFaults;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wasalahore.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CarFaultsAdapter extends RecyclerView.Adapter<CarFaultsAdapter.MyViewHolder> {

    private List<CarFaultsDataClass> dataClassList;
    private LayoutInflater layoutInflater;


    public CarFaultsAdapter(Context context, List<CarFaultsDataClass> dataClassList) {
        layoutInflater = LayoutInflater.from(context);
        this.dataClassList = dataClassList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.carfaults_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CarFaultsDataClass carFaultsDataClass = dataClassList.get(position);
        holder.id.setText(Long.toString(carFaultsDataClass.getId()));
        holder.title.setText(carFaultsDataClass.getTitle());
        holder.technicalDescription.setText(carFaultsDataClass.getTechnicalDescription());
        holder.description.setText(carFaultsDataClass.getDescription());
        holder.causes.setText(carFaultsDataClass.getCauses());
        holder.solutions.setText(carFaultsDataClass.getSolutions());

    }

    @Override
    public int getItemCount() {
        return dataClassList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id;
        TextView title;
        TextView technicalDescription;
        TextView description;
        TextView causes;
        TextView solutions;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.dtc_id);
            title = itemView.findViewById(R.id.title_id);
            technicalDescription = itemView.findViewById(R.id.technical_description_id);
            description = itemView.findViewById(R.id.description_id);
            causes = itemView.findViewById(R.id.causes_id);
            solutions = itemView.findViewById(R.id.solutions_id);

        }
    }

}
