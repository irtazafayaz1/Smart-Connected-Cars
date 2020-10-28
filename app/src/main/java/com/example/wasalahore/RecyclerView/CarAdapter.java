package com.example.wasalahore.RecyclerView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wasalahore.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.MyViewHolder> {

    private OnClickInterface onClickInterface;
    private List<CarDataClass> dataClassList;
    private LayoutInflater layoutInflater;

    public CarAdapter(Context context, List<CarDataClass> dataClassList, OnClickInterface onClickInterface) {
        this.dataClassList = dataClassList;
        layoutInflater = LayoutInflater.from(context);
        this.onClickInterface = onClickInterface;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.user_car_rows, parent, false);
        return new MyViewHolder(view, onClickInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.CompanyName.setText(dataClassList.get(position).getCompanyname());
        holder.ModelName.setText(dataClassList.get(position).getModelname());
    }

    @Override
    public int getItemCount() {
        return dataClassList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView CompanyName;
        private TextView ModelName;
        private OnClickInterface onClickInterface;

        MyViewHolder(@NonNull View itemView, OnClickInterface onClickInterface) {
            super(itemView);

            CompanyName = itemView.findViewById(R.id.CompanyNameProfile);
            ModelName = itemView.findViewById(R.id.ModelNameProfile);
            this.onClickInterface = onClickInterface;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Log.e("AAAAAAAAAAAA", "onCarClick: AAAAAAAAAAAAAAAAAa" );
            onClickInterface.onCarClick(getAdapterPosition());
        }
    }

    public interface OnClickInterface {
        void onCarClick(int position);
    }
}
