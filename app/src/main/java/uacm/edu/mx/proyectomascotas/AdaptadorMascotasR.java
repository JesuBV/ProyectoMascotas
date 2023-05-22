package uacm.edu.mx.proyectomascotas;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorMascotasR extends RecyclerView.Adapter<AdaptadorMascotasR.MascotaViewHolder>{

    public AdaptadorMascotasR(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity= activity;
    }
    ArrayList<Mascota> mascotas;
    Activity activity;

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_mascota_ranqueada, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorMascotasR.MascotaViewHolder holder, int position) {
        Mascota mascota = mascotas.get(position);
        MascotaViewHolder.imgfoto.setImageResource(mascota.getFoto());
        MascotaViewHolder.tvNombre.setText(mascota.getNombre());
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }
    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private static ImageView imgfoto;
        private static TextView tvNombre;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgfoto = (ImageView) itemView.findViewById(R.id.cvImgContacto);
            tvNombre = (TextView) itemView.findViewById(R.id.cvTvNombre);
        }


    }
}
