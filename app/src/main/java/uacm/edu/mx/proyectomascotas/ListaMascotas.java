package uacm.edu.mx.proyectomascotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ListaMascotas extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    ArrayList<Integer> indicesAE;
    RecyclerViewAdapter adaptador;
    private Camera mCamera;

    private RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mascotas);

        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        rvMascotas.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager dlm = new GridLayoutManager(this, 2);
        rvMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

        FloatingActionButton miFAB = (FloatingActionButton) findViewById(R.id.fabCamara);
        miFAB.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
               abrirCamara();
            }
        });
    }
    private void abrirCamara(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //if(intent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(intent,1);
        //}
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones_mascotas_sr,menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mAbout:
                openDialog();
                break;
            case R.id.mActionRanking:
                //Toast.makeText(this,getResources().getString(R.string.menu_ranking), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this,ListaMascotaRanqueada.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    public void openDialog() {
        DialogoAbout exampleDialog = new DialogoAbout();
        exampleDialog.show(getSupportFragmentManager(), "dialogo about1");
    }

    private void inicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Pelusa Tiene unos ojos grandes y brillantes, de un intenso color verde esmeralda, que contrastan perfectamente con su pelaje blanco. Su nariz es pequeña y rosada, y sus orejas son puntiagudas y blancas en su interior.","6 meses","macho","blanco","largo","Pelusa",0,R.drawable.drw_pelusa));
        mascotas.add(new Mascota("Bolita tiene su cuerpo redondo y rechoncho se mueve con gracia y lentitud, y sus patitas cortas y regordetas parecen apenas sostener su peso. Su pelaje es de un tono banco con naranja con manchas blancas en su pecho y patas. ","3 años","macho","blanco-naranja","corto","Bolita",0,R.drawable.drw_bolita));
        mascotas.add(new Mascota("Chechenio tiene una figura elegante y delgada, con ojos grandes y expresivos de color amarillo intenso. Su pelaje es suave y sedoso al tacto, y su personalidad es tranquila y afectuosa.","9 meses","macho","gris","corto","Chechenio",0,R.drawable.drw_chechenio));
        mascotas.add(new Mascota("Delgado tiene un cuerpo esbelto y ágil, con patas largas y delgadas que le permiten moverse con gracia y agilidad. Es un animal muy activo y juguetón, le encanta saltar y perseguir juguetes.","1 año","macho","negro","corto","Delgado",0,R.drawable.drw_delgado));
        mascotas.add(new Mascota("Mika tiene su cabeza redondeada, con grandes ojos verdes que reflejan una mirada curiosa y alerta. El pelaje de este gato es principalmente de color marrón oscuro, con manchas blancas en el pecho, la barriga y las patas. ","2 años","hembra","pardo","corto","Mika",0,R.drawable.drw_mika));
        mascotas.add(new Mascota("Orton tiene un pelaje suave y sedoso de color naranja brillante que lo hace destacar entre otros gatos. Sus ojos grandes y redondos son de color ámbar y tienen una expresión dulce y juguetona. ","8 meses","macho","anaranjado","corto","Orton",0,R.drawable.drw_orton));
    }
    private void inicializarAdaptador() {
        adaptador = new RecyclerViewAdapter(this, mascotas);
        rvMascotas.setAdapter(adaptador);
    }


}

