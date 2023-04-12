package com.example.shoppinglist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemListAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private Context context;
    private ArrayList<Item> items = new ArrayList<>();

    public ItemListAdapter(Context context, ArrayList<Item> items){
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false));
    }

    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position){
        holder.itemInfo.setText(items.get(position).getItem());
        holder.editItem.setText(items.get(position).getItem());

        holder.deleteItem.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            ItemStorage.getInstance().removeItem(items.get(pos).getItem());
            notifyItemRemoved(pos);
        });

        holder.editImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                if(holder.editItem.getVisibility() == View.VISIBLE){
                    Item item = ItemStorage.getInstance().getItemByIdNoRemove(pos);
                    item.setItem(holder.editItem.getText().toString());
                    ItemStorage.getInstance().addItem(item);
                    holder.editItem.setVisibility(View.GONE);
                    notifyDataSetChanged();
                }else{
                    holder.editItem.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
