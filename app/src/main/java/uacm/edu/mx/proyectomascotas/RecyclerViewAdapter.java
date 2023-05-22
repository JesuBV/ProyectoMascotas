package uacm.edu.mx.proyectomascotas;

import static androidx.core.app.ActivityCompat.startActivityForResult;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    Context context;
    ArrayList<Mascota> items;

    String numeroRanking;


    public RecyclerViewAdapter(Context context, ArrayList<Mascota> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.card_view_mascota, parent, false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.imgfoto.setImageResource(items.get(position).getFoto());
        holder.tvNombre.setText(items.get(position).getNombre());
        holder.tvRanking.setText(String.valueOf(items.get(position).getRanking()));
        holder.setOnclickListener();
        holder.imgfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,DescripcionMascotas.class);
                intent.putExtra("nombre",items.get(position).getNombre());
                intent.putExtra("descripcion",items.get(position).getDescripcion());
                intent.putExtra("edad",items.get(position).getEdad());
                intent.putExtra("mh",items.get(position).getMh());
                intent.putExtra("color",items.get(position).getColor());
                intent.putExtra("pelaje",items.get(position).getPelaje());
                context.startActivity(intent);
            }
        });

    }
    @Override
    public int getItemCount() {
        return items.size();
    }
}