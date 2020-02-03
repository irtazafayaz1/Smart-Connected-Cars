package com.example.wasalahore.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wasalahore.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<DataClass> dataClassList;
    private LayoutInflater layoutInflater;

    public Adapter(Context context, List<DataClass> dataClassList) {
        layoutInflater = LayoutInflater.from(context);
        this.dataClassList = dataClassList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.title.setText(dataClassList.get(position).getTitle());
        holder.v1n.setText(dataClassList.get(position).getV1n());
        holder.v2n.setText(dataClassList.get(position).getV2n());
        holder.v3n.setText(dataClassList.get(position).getV3n());

        holder.l1.setText(dataClassList.get(position).getL1());
        holder.l2.setText(dataClassList.get(position).getL2());
        holder.l3.setText(dataClassList.get(position).getL3());

        holder.frequency.setText(dataClassList.get(position).getFrequency());
        holder.pkva.setText(dataClassList.get(position).getPkva());
        holder.pf.setText(dataClassList.get(position).getPf());
        holder.autoModeOn.setText(dataClassList.get(position).getAutoModeOn());

        holder.pumpStatus.setText(dataClassList.get(position).getPumpStatus());
        holder.pumpStatus1.setText(dataClassList.get(position).getPumpStatus1());
        holder.pumpStatus2.setText(dataClassList.get(position).getPumpStatus2());
        holder.pumpStatus3.setText(dataClassList.get(position).getPumpStatus3());
        holder.pumpStatus4.setText(dataClassList.get(position).getPumpStatus4());
        holder.pumpStatus5.setText(dataClassList.get(position).getPumpStatus5());
        holder.pumpStatus6.setText(dataClassList.get(position).getPumpStatus6());
        holder.pumpStatus7.setText(dataClassList.get(position).getPumpStatus7());
        holder.pumpStatus8.setText(dataClassList.get(position).getPumpStatus8());
        holder.pumpStatus9.setText(dataClassList.get(position).getPumpStatus9());
        holder.pumpStatus10.setText(dataClassList.get(position).getPumpStatus10());


        holder.currentTrip.setText(dataClassList.get(position).getCurrentTrip());
        holder.voltageTrip.setText(dataClassList.get(position).getVoltageTrip());

        holder.remoteControl.setText(dataClassList.get(position).getRemoteControl());
        holder.chlorineLevel.setText(dataClassList.get(position).getChlorineLevel());

        holder.waterExtracted.setText(dataClassList.get(position).getWaterExtracted());
        holder.pkvar.setText(dataClassList.get(position).getPkva());
        holder.pkw.setText(dataClassList.get(position).getPkw());


    }

    @Override
    public int getItemCount() {
        return dataClassList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView v1n, v2n, v3n, l1, l2, l3, frequency, pkva, pf, autoModeOn, pumpStatus, currentTrip, voltageTrip, remoteControl, chlorineLevel, waterExtracted, pkvar, pkw, pumpStatus1, pumpStatus2, pumpStatus3, pumpStatus4, pumpStatus5, pumpStatus6, pumpStatus7, pumpStatus8, pumpStatus9, pumpStatus10;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            v1n = itemView.findViewById(R.id.v1n);
            v2n = itemView.findViewById(R.id.v2n);
            v3n = itemView.findViewById(R.id.v3n);
            l1 = itemView.findViewById(R.id.l1);
            l2 = itemView.findViewById(R.id.l2);
            l3 = itemView.findViewById(R.id.l3);
            frequency = itemView.findViewById(R.id.frequency);
            pkva = itemView.findViewById(R.id.pkva);
            pf = itemView.findViewById(R.id.pf);
            autoModeOn = itemView.findViewById(R.id.auto_mode_on);
            pumpStatus = itemView.findViewById(R.id.pump_status);
            currentTrip = itemView.findViewById(R.id.current_trip);
            voltageTrip = itemView.findViewById(R.id.voltage_trip);
            remoteControl = itemView.findViewById(R.id.remote_control);
            chlorineLevel = itemView.findViewById(R.id.chlorine_level);
            waterExtracted = itemView.findViewById(R.id.water_extracted);
            pkvar = itemView.findViewById(R.id.pkvar);
            pkw = itemView.findViewById(R.id.pkw);
            pumpStatus1 = itemView.findViewById(R.id.pump_status1);
            pumpStatus2 = itemView.findViewById(R.id.pump_status2);
            pumpStatus3 = itemView.findViewById(R.id.pump_status3);
            pumpStatus4 = itemView.findViewById(R.id.pump_status4);
            pumpStatus5 = itemView.findViewById(R.id.pump_status5);
            pumpStatus6 = itemView.findViewById(R.id.pump_status6);
            pumpStatus7 = itemView.findViewById(R.id.pump_status7);
            pumpStatus8 = itemView.findViewById(R.id.pump_status8);
            pumpStatus9 = itemView.findViewById(R.id.pump_status9);
            pumpStatus10 = itemView.findViewById(R.id.pump_status10);


        }
    }
}
