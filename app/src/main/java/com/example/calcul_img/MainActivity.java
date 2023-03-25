package com.example.calcul_img;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
 EditText txtpoids,txttaille,txtage;
 RadioButton rdbHomme,rdbFemme;
 Button btnCalculIMG;
 TextView lblresult,lblIterp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtpoids = (EditText) findViewById(R.id.txtpoids);
        txttaille = (EditText) findViewById(R.id.txttaille);
        txtage = (EditText) findViewById(R.id.txtage);
        rdbFemme = (RadioButton) findViewById(R.id.rdbFemme);
        rdbHomme = (RadioButton) findViewById(R.id.rdbHomme);
        btnCalculIMG = (Button) findViewById(R.id.btnCalculIMG);
        lblresult = (TextView) findViewById(R.id.lblresult);
        lblIterp = (TextView) findViewById(R.id.lblIterp);

        btnCalculIMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer p ;
                Integer t ;
                Integer a ;
                Float imc;
                Float img = null;
                int s =0;

                p = Integer.parseInt (txtpoids.getText().toString());
                t = Integer.parseInt (txttaille.getText().toString());
                a = Integer.parseInt (txtage.getText().toString());

                Float tm = ((float)t)/100;
                imc = (float)(p/(tm*tm));

                if(rdbHomme.isChecked()) {
                    s = 1;

                    if (a >= 16) {
                        img = (float) ((1.2 * imc) + (0.23 * a) - (10.8 * s) - 5.4);

                    } else if (a < 15) {
                        img = (float) ((1.51 * imc) + (0.7 * a) - (3.6 * s) + 1.4);

                    }
               }
                      else if(rdbFemme.isChecked())
                        {
                          s=0;
                               if (a >= 16) {
                         img =(float) ((1.2 * imc) + (0.23 * a) - (10.8 * s) - 5.4);

                          }
                            else
                                if (a < 15) {
                                    img =(float) ((1.51 * imc) + (0.7 * a) - (3.6 * s) + 1.4);

                            }}
 if(s==1) {
     if (img<15){
         lblresult.setText("Votre IMG est "+img+" %");
         lblIterp.setText("Iterprétation : "+"Trop Maigre");
     } else
         if (img > 30) {
         lblresult.setText("Votre IMG est "+img+" %");
         lblIterp.setText("Iterprétation : "+"Trop de Graisse ");
     } else{
         lblresult.setText("Votre IMG est "+img+" %");
         lblIterp.setText("Iterprétation : "+"Pourcentage Normal");
     }
 }
 else {
     if (img < 20) {
         lblresult.setText("Votre IMG est "+img+" %");
         lblIterp.setText("Iterprétation : "+"Trop Maigre");
     } else
         if (img > 30 ) {
         lblresult.setText("Votre IMG est "+img+" %");
         lblIterp.setText("Iterprétation : "+"Trop de Graisse ");
     } else {
         lblresult.setText("Votre IMG est "+img+" %");
         lblIterp.setText("Iterprétation : "+"Pourcentage Normal");
     }
 }
            }

        });

    }

}