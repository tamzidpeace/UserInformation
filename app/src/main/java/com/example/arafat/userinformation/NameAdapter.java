package com.example.arafat.userinformation;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class NameAdapter extends RecyclerView.Adapter<NameAdapter.MyViewHolder> {

    List<User> name;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView viewfirstName, viewLastName, viewEmail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            viewfirstName = itemView.findViewById(R.id.view_first_name);
            viewLastName = itemView.findViewById(R.id.view_last_name);
            viewEmail = itemView.findViewById(R.id.view_email);
        }
    }

    NameAdapter(List<User> mName) {
        this.name = mName;
    }

    @NonNull
    @Override
    public NameAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_row, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        myViewHolder.viewfirstName.setText(name.get(position).getFirstName());
        myViewHolder.viewLastName.setText(name.get(position).getLastName());
        myViewHolder.viewEmail.setText(name.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

}
