package uacm.edu.mx.proyectomascotas;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView imgfoto;
    TextView tvNombre;
    ImageButton ibRanking;
    TextView tvRanking;

    int cont = 0;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        imgfoto = (ImageView) itemView.findViewById(R.id.cvImgMascota);
        tvNombre = (TextView) itemView.findViewById(R.id.cvTvNombre);
        ibRanking= (ImageButton) itemView.findViewById(R.id.ibRanking);
        tvRanking= (TextView) itemView.findViewById(R.id.cvTvRanking);
    }

    public void setOnclickListener(){ibRanking.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.ibRanking && cont < 5){
            cont++;
            ibRanking.setBackgroundResource(R.mipmap.ic_pescado2);
        }else{
            cont = 0;
            ibRanking.setBackgroundResource(R.mipmap.ic_pescado1);
        }
        tvRanking.setText(Integer.toString(cont));
    }

}