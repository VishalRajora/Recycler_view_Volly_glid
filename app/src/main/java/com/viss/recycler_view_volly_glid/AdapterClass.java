package com.viss.recycler_view_volly_glid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterClass extends RecyclerView.Adapter < MyViewHolder > {

    List < ModelClass > myList;
    Context context;

    public AdapterClass(List < ModelClass > myList , Context context) {
        this.myList = myList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent , int viewType) {
        View view = LayoutInflater.from ( context ).inflate ( R.layout.custom_view , parent , false );
        return new MyViewHolder ( view );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder , int position) {

        holder.name.setText ( myList.get ( position ).getName () );
        holder.realname.setText ( myList.get ( position ).getRealname () );
        holder.createdBy.setText ( myList.get ( position ).getCreatedby () );
        holder.firstAppreance.setText ( String.valueOf (myList.get ( position ).getLaunchDate ()) );
        holder.team.setText ( myList.get ( position ).getTeam () );
        holder.publisher.setText ( myList.get ( position ).getMoviepublisher () );

        Glide.with ( context ).load ( myList.get ( position ).getImage () ).placeholder ( R.drawable.ic_launcher_background ).error ( R.drawable.image_shape ).into ( holder.myImage );

          }

    @Override
    public int getItemCount() {
        return myList.size ();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {

    TextView name, realname, publisher, createdBy, firstAppreance, team;
    ImageView myImage;

    public MyViewHolder(@NonNull View itemView) {
        super ( itemView );
        name = itemView.findViewById ( R.id.hero_name );
        realname = itemView.findViewById ( R.id.hero_realname );
        publisher = itemView.findViewById ( R.id.movie_publisher );
        createdBy = itemView.findViewById ( R.id.createdBy );
        firstAppreance = itemView.findViewById ( R.id.hero_date );
        team = itemView.findViewById ( R.id.hero_team );
        myImage = itemView.findViewById ( R.id.movie_image );
    }
}
