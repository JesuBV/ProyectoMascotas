package uacm.edu.mx.proyectomascotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class ListaMascotaRanqueada extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    AdaptadorMascotasR adaptador;
    private RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mascota_ranqueada);
        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotasRanqueadas);
        rvMascotas.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager dlm = new GridLayoutManager(this, 2);
        rvMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones_mascotas_cr,menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mAbout:
                openDialog();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void openDialog() {
        DialogoAboutR exampleDialog = new DialogoAboutR();
        exampleDialog.show(getSupportFragmentManager(), "dialogo about2");
    }

    private void inicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Esta gatita es adorable y tiene un aspecto encantador. Es de tamaño pequeño y delgada, lo que le da una apariencia elegante y ágil. Su pelaje es de color negro intenso y brillante, que resalta su belleza y le da un aire misterioso, sus ojos son grandes y expresivos, resaltando en contraste con su pelaje oscuro.","5 meses","hembra","negro","corto","Flaca",0,R.drawable.drw_flaca));
        mascotas.add(new Mascota("Nora es simplemente adorable. Aunque es pequeña en tamaño, irradia una gran elegancia y belleza. Su pelaje es corto y sedoso, con un patrón característico de puntos oscuros en su cara, orejas, patas y cola, contrastando con un cuerpo de color claro o crema. ","3 meses","hembra","blanco","corto","Nora",0,R.drawable.drw_nora));
        mascotas.add(new Mascota("Rocko es atigrado gris es absolutamente encantador. Su pelaje presenta un hermoso patrón de rayas o manchas en tonos de gris, creando un efecto visual fascinante. Las rayas pueden variar en intensidad y grosor, y se distribuyen de manera uniforme en todo su cuerpo.","5 meses","macho","atigrado-gris","corto","Rocko",0,R.drawable.drw_rocko));
        mascotas.add(new Mascota("Esta gatita de carey es una verdadera belleza. Su pelaje presenta un patrón de colores vibrantes y únicos que le dan un aspecto llamativo y exótico. El pelaje de carey es una combinación de manchas o rayas en tonos de naranja, negro, crema y a veces blanco. Estas manchas se entrelazan y se mezclan en un patrón caótico y maravillosamente pintoresco.","4 años","hembra","carey","corto","Luna",0,R.drawable.drw_luna));
        mascotas.add(new Mascota("Este gatito atigrado de 3 meses es simplemente adorable. Su pelaje presenta un patrón de rayas o manchas en tonos de marrón, negro y beige, creando un aspecto encantador y lleno de carácter. A medida que crezca, es posible que las rayas se vuelvan más definidas y que su pelaje se desarrolle aún más.","3 meses","macho","atigrado","corto","Paco",0,R.drawable.drw_paco));
        mascotas.add(new Mascota("Esta gatita blanca con heterocromía es absolutamente cautivadora. Su pelaje es completamente blanco, lo que le da un aspecto puro y angelical. Sin embargo, lo más notable de esta gatita son sus ojos de colores diferentes debido a la heterocromía.","4 años","hembra","blanco","corto","Celia",0,R.drawable.drw_celia));
    }
    private void inicializarAdaptador() {
        adaptador = new AdaptadorMascotasR(mascotas,this);
        rvMascotas.setAdapter(adaptador);
    }
}