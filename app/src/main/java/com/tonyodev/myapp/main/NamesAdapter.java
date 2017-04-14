package com.tonyodev.myapp.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tonyodev.User;
import com.tonyodev.myapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by tonyofrancis on 4/14/17.
 */

public class NamesAdapter extends RecyclerView.Adapter<NamesAdapter.ViewHolder> {

    private User[] users;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(viewType,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        User user = users[position];
        holder.namesTextView.setText(user.getName());
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.user_item;
    }

    @Override
    public int getItemCount() {

        if(users == null) {
            return 0;
        }

        return users.length;
    }

    public void swap(User[] users) {
        this.users = users;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.userTextView) TextView namesTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}