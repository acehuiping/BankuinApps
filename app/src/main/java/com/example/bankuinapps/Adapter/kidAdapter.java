package com.example.bankuinapps.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bankuinapps.ChildrenBankActivity;
import com.example.bankuinapps.Model.childrenData;
import com.example.bankuinapps.Model.kidData;
import com.example.bankuinapps.R;

import java.util.List;

public class kidAdapter extends RecyclerView.Adapter {

    List<kidData> kiddatalist;

    private RecyclerViewClickListner listner;

    public kidAdapter(List<kidData> kiddatalist, RecyclerViewClickListner listner) {
        this.kiddatalist = kiddatalist;
        this.listner = listner;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kid_recycler_data, parent, false);
        ViewHolderClass viewHolderClass = new ViewHolderClass(view);
        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolderClass  viewHolderClass = (ViewHolderClass) holder;
        kidData data = kiddatalist.get(position);
        viewHolderClass.name.setText(data.getName());

    }

    @Override
    public int getItemCount() {
        return kiddatalist.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView name;

        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.txt_kidname);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listner.onClick(itemView, getAdapterPosition());
        }
    }

    public interface RecyclerViewClickListner{
        void onClick(View v, int position);
    }
}
