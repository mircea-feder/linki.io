package com.example.linky;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.linky.backend.models.EditableLink;
import com.makeramen.roundedimageview.RoundedImageView;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    EditableLink[] editableLinks;
    Context context;

    public HomeAdapter(Context ct, EditableLink[] editableLinks) {
        context = ct;
        this.editableLinks = editableLinks;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.user_editable_link, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.platformLogo.setImageDrawable(
                ResourcesCompat.getDrawable(
                        context.getResources(),
                        R.drawable.facebook,
                        null
                )
        );
        holder.platformName.setText(editableLinks[position].getPlatform());
    }

    @Override
    public int getItemCount() {
        return editableLinks.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        RoundedImageView platformLogo;
        TextView platformName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            if (itemView.findViewById(R.id.platformLogo) == null)
                Log.e("ERROR", "Logo is null");
            if (itemView.findViewById(R.id.platformName) == null)
                Log.e("ERROR", "Name is null");
            platformLogo = itemView.findViewById(R.id.platformLogo);
            platformName = itemView.findViewById(R.id.platformName);
        }
    }
}
