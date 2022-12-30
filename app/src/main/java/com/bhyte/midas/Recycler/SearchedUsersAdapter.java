package com.bhyte.midas.Recycler;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bhyte.midas.DataModels.SearchedUsersModel;
import com.bhyte.midas.R;

import java.util.ArrayList;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bhyte.midas.R;

public class SearchedUsersAdapter extends RecyclerView.Adapter<SearchedUsersAdapter.SearchedUsersViewHolder>{

    ArrayList<SearchedUsersModel> searchedUsers;

    public SearchedUsersAdapter(ArrayList<SearchedUsersModel> searchedUsers) {
        this.searchedUsers = searchedUsers;
    }

    @NonNull
    @Override
    public SearchedUsersAdapter.SearchedUsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.searcheduser_list_item, parent, false);
        return new SearchedUsersAdapter.SearchedUsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchedUsersAdapter.SearchedUsersViewHolder holder, int position) {
        SearchedUsersModel searchedUsersModel = searchedUsers.get(position);

        holder.tvUsersName.setText(searchedUsersModel.getName());
        holder.tvUsersEmail.setText(searchedUsersModel.getEmail());
    }

    @Override
    public int getItemCount() {
        return searchedUsers.size();
    }

    public static class SearchedUsersViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        OnNoteListener onNoteListener;
        TextView tvUsersName;
        TextView tvUsersEmail;

        public SearchedUsersViewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            tvUsersName = itemView.findViewById(R.id.tvUsersName);
            tvUsersEmail = itemView.findViewById(R.id.tvUsersEmail);
        }

        @Override
        public void onClick(View view) {
            //onNoteListener.onNoteClick(getAbsoluteAdapterPosition());
        }

    }

    public interface OnNoteListener{
        void onNoteClick(int position);
    }
}
