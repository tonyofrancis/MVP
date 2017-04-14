package com.tonyodev.mytvapp.main;

import android.support.v17.leanback.widget.Presenter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tonyodev.User;
import com.tonyodev.mytvapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by tonyofrancis on 4/14/17.
 */

public class UserPresenter extends Presenter {

    @Override
    public Presenter.ViewHolder onCreateViewHolder(ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object item) {

        ViewHolder userHolder = (ViewHolder) viewHolder;
        User user = (User) item;
        userHolder.namesTextView.setText(user.getName());
    }

    @Override
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        ((ViewHolder) viewHolder).namesTextView.setText("");
    }

    public static class ViewHolder extends Presenter.ViewHolder {

        @BindView(R.id.userTextView) TextView namesTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
