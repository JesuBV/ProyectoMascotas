package uacm.edu.mx.proyectomascotas;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.collection.CircularArray;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorMascotas extends RecyclerView.Adapter<AdaptadorMascotas.MascotaViewHolder>{

    public AdaptadorMascotas(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity= activity;
    }
    ArrayList<Mascota> mascotas;
    ArrayList<Mascota> mascotasR;


    Activity activity;

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_mascota, parent, false);
        return new MascotaViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull AdaptadorMascotas.MascotaViewHolder holder, int position) {

        Mascota mascota = mascotas.get(position);
        MascotaViewHolder.imgfoto.setImageResource(mascota.getFoto());
        MascotaViewHolder.tvNombre.setText(mascota.getNombre());
        MascotaViewHolder.tvRanking.setText(String.valueOf(mascota.getRanking()));
        MascotaViewHolder.imgfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(activity,DescripcionMascotas.class);
                intent.putExtra("nombre",mascota.getNombre());
                intent.putExtra("descripcion",mascota.getDescripcion());
                intent.putExtra("edad",mascota.getEdad());
                intent.putExtra("mh",mascota.getMh());
                intent.putExtra("color",mascota.getColor());
                intent.putExtra("pelaje",mascota.getPelaje());
                activity.startActivity(intent);
            }
        });

        MascotaViewHolder.ibRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity,"Ranqueaste a: "+mascota.getNombre(), Toast.LENGTH_LONG).show();
                actualizarRanking(mascota,view);
            }
        });
    }
    public void actualizarRanking(Mascota mascota, View view){
        int ranking = mascota.getRanking();
        if(ranking < 1){
            mascota.setRanking(ranking+1);
            view.setBackgroundResource(R.mipmap.ic_pescado2);
            //MascotaViewHolder.tvRanking.setText(String.valueOf(mascota.getRanking()));
        }else {
            mascota.setRanking(0);
            view.setBackgroundResource(R.mipmap.ic_pescado1);
            //MascotaViewHolder.tvRanking.setText(String.valueOf(mascota.getRanking()));

        }
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }
    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private static ImageView imgfoto;
        private static TextView tvNombre;
        private static ImageButton ibRanking;
        private static TextView tvRanking;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgfoto = (ImageView) itemView.findViewById(R.id.cvImgContacto);
            tvNombre = (TextView) itemView.findViewById(R.id.cvTvNombre);
            ibRanking= (ImageButton) itemView.findViewById(R.id.ibRanking);
            tvRanking= (TextView) itemView.findViewById(R.id.cvTvRanking);
        }

    }

}
