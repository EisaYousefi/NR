package com.broa.nestdapp.nestedRecycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.broa.nestdapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HorizintalAdapter extends RecyclerView.Adapter<HorizintalAdapter.HRVHolder> {

    Context context;
    List<HorezintalModel> horezintalModels;
    public HorizintalAdapter(Context context , List<HorezintalModel> horezintalModels){
        this.context = context;
        this.horezintalModels = horezintalModels;
    }
    @NonNull
    @Override
    public HRVHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_h,viewGroup,false);
        return new HRVHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HRVHolder holder, int i) {
        HorezintalModel hmodel = horezintalModels.get(i);
        holder.textView.setText(hmodel.getStr());
    }

    @Override
    public int getItemCount() {
        return horezintalModels.size();
    }

    public class HRVHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.text_view_h)
        TextView textView;
        public HRVHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
