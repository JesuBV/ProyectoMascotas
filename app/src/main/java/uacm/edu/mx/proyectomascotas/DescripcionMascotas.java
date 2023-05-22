package uacm.edu.mx.proyectomascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DescripcionMascotas extends AppCompatActivity {

    private TextView tvDescripcion;
    private TextView tvEdad;
    private TextView tvMH;
    private TextView tvColor;
    private TextView tvPelaje;
    private  String nombre;

    SwipeRefreshLayout mySwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_mascotas);

        Bundle parametros = getIntent().getExtras();
        String descripcion = parametros.getString(getResources().getString(R.string.pdescripcion));
        String edad= parametros.getString(getResources().getString(R.string.pedad));
        String mh = parametros.getString(getResources().getString(R.string.pmh));
        String color = parametros.getString(getResources().getString(R.string.pcolor));
        String pelaje = parametros.getString(getResources().getString(R.string.ppelaje));

        nombre = parametros.getString(getResources().getString(R.string.pnombre));
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);
        tvEdad = (TextView) findViewById(R.id.tvEdad);
        tvMH = (TextView) findViewById(R.id.tvMachoHembra);
        tvColor = (TextView) findViewById(R.id.tvColor);
        tvPelaje = (TextView) findViewById(R.id.tvPelaje);

        tvDescripcion.setText("Descripción: "+descripcion);
        tvEdad.setText("Edad: "+edad);
        tvMH.setText("Macho-Hembra:"+mh);
        tvColor.setText("Color: "+color);
        tvPelaje.setText("Pelaje: "+pelaje);
        srl();

    }
    public void srl(){
        mySwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.mySwiperefresh);
        //mySwipeRefreshLayout.setColorSchemeColors(R.color.purple_200);
        mySwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh(nombre);
                //mySwipeRefreshLayout.setRefreshing(false);

            }
        });
    }
    public void refresh(String nombre){
        ImageView imageView = (ImageView)  findViewById(R.id.ivMascota);
        switch (nombre){
            case "Pelusa":
                imageView.setImageResource(R.drawable.drw_pelusa);
                break;
            case "Bolita":
                imageView.setImageResource(R.drawable.drw_bolita);
                break;
            case "Chechenio":
                imageView.setImageResource(R.drawable.drw_chechenio);
                break;
            case "Delgado":
                imageView.setImageResource(R.drawable.drw_delgado);
                break;
            case "Mika":
                imageView.setImageResource(R.drawable.drw_mika);
                break;
            case "Orton":
                imageView.setImageResource(R.drawable.drw_orton);
                break;
        }
        mySwipeRefreshLayout.setRefreshing(false);
    }
}