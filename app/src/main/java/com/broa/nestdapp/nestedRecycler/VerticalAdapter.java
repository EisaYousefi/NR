package com.broa.nestdapp.nestedRecycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.broa.nestdapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.verticalViewHolder> {

    private Context context;
    private List<VerticalModel> verticalModelList;
    private Boolean flag=true;

    public VerticalAdapter(Context context, List <VerticalModel> verticalModelList) {
        this.context = context;
        this.verticalModelList = verticalModelList;
    }

    @NonNull
    @Override
    public verticalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_v,viewGroup,false);
        return new verticalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final verticalViewHolder holder, int i) {
        final VerticalModel verticalModel = verticalModelList.get(i);
        holder.img.setImageResource(verticalModel.getImg());
        holder.titleTextView.setText(verticalModel.getTitle());
        final HorezintalModel hmodel = new HorezintalModel(verticalModel.getTitle());

            holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (flag) {
                        flag = false;
                        holder.layout.setVisibility(View.VISIBLE);
                        final List <HorezintalModel> itemList = new ArrayList <>();
                        itemList.add(hmodel);

                        holder.recyclerView.setHasFixedSize(true);
                        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
                        final HorizintalAdapter adapter
                                = new HorizintalAdapter(context, itemList);
                        holder.recyclerView.setAdapter(adapter);
                    }else {
                        flag = true;
                        holder.layout.setVisibility(View.GONE);
                    }
                }
            });



    }

    @Override
    public int getItemCount() {
        return verticalModelList.size();
    }

    public class verticalViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.text_view_v)
        TextView titleTextView;
        @BindView(R.id.recycler_view_v)
        RecyclerView recyclerView;
        @BindView(R.id.layout_rv)
        LinearLayout layout;
        public verticalViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
