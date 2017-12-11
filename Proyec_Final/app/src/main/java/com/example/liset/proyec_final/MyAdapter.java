package com.example.liset.proyec_final;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by LISET on 29/11/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        ListItem listItem=listItems.get(position);
        holder.textnombre.setText(listItem.getNombre());
        holder.textapellido.setText(listItem.getApellido());


    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textnombre;
        public TextView textapellido;

        public ViewHolder(View itemView) {
            super(itemView);

          //  textnombre=(TextView) itemView.findViewById(R.id.textnombre);
           // textapellido=(TextView) itemView.findViewById(R.id.textapellido);

        }
    }
}
