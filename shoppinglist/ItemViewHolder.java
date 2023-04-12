package com.example.shoppinglist;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    ImageView deleteItem, editImage;
    TextView itemInfo;
    EditText editItem;

    public ItemViewHolder(@NonNull View itemView){
        super(itemView);
        deleteItem = itemView.findViewById(R.id.imgDelete);
        editImage = itemView.findViewById(R.id.imgEdit);
        editItem = itemView.findViewById(R.id.editItem);
        itemInfo = itemView.findViewById(R.id.txtListItem);
    }
}
