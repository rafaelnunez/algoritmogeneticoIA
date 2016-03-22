package com.softwaresolutions.algoritmogeneticoia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    Button btnGenerar;
    EditText editText;
    TextView tvmuestra, tvb1, tve1, tvb2, tve2, tvb3, tve3, tvb4, tve4, tvselectindividuals, tvnewgeneration;
    ListView listView;
    Class_geneticAlgorithm geneticAlgorithm = new Class_geneticAlgorithm();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGenerar = (Button)findViewById(R.id.button);
        tvmuestra = (TextView)findViewById(R.id.tvmuestra);
        tvb1 = (TextView)findViewById(R.id.tvb1);
        tvb2 = (TextView)findViewById(R.id.tvb2);
        tvb3= (TextView)findViewById(R.id.tvb3);
        tvb4 = (TextView)findViewById(R.id.tvb4);
        tve1 = (TextView)findViewById(R.id.tve1);
        tve2 = (TextView)findViewById(R.id.tve2);
        tve3= (TextView)findViewById(R.id.tve3);
        tve4 = (TextView)findViewById(R.id.tve4);
        tvnewgeneration = (TextView)findViewById(R.id.tvnewgeneration);
        tvselectindividuals = (TextView)findViewById(R.id.tvselectindividuals);

        btnGenerar.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                String[] muestra;
                String[] combinationindiviual;
                int[] newgeneration;
                int[] muestraint = new int[4];
                double[] evaluation;
                String[] numberbinary;
                int[] selectionindividuals;
                muestra = geneticAlgorithm.numbersrandom();
                for (int i=0; i<=3; i++){
                    muestraint[i] = Integer.parseInt(muestra[i]);
                }
                numberbinary = geneticAlgorithm.convertNumberToBinary(muestraint);
                evaluation = geneticAlgorithm.evaluationFuntion(muestraint);
                selectionindividuals = geneticAlgorithm.selectionIndividuals(muestraint, evaluation);
                combinationindiviual = geneticAlgorithm.combinationIndividuals(muestraint, selectionindividuals, numberbinary);
                newgeneration = geneticAlgorithm.convertBinaryToNumber(combinationindiviual);
                //tvnewgeneration.setText("Nueva generación: " + combinationindiviual[0] + ", " + combinationindiviual[1] + ", " + combinationindiviual[2] + ", " + combinationindiviual[3]);
                tvnewgeneration.setText("Nueva generación: " + newgeneration[0] + ", " + newgeneration[1] + ", " + newgeneration[2] + ", " +newgeneration[3]);
                tvselectindividuals.setText("Individuos seleccionados: " + String.valueOf(selectionindividuals[3] + 1) + ", " + String.valueOf(selectionindividuals[2] + 1) + ", " + String.valueOf(selectionindividuals[1] + 1));

                tvb1.setText(numberbinary[0]);
                tvb2.setText(numberbinary[1]);
                tvb3.setText(numberbinary[2]);
                tvb4.setText(numberbinary[3]);
                tve1.setText(String.valueOf(evaluation[0]));
                tve2.setText(String.valueOf(evaluation[1]));
                tve3.setText(String.valueOf(evaluation[2]));
                tve4.setText(String.valueOf(evaluation[3]));
                tvmuestra.setText("Muestra: " + muestra[0] + ", " + muestra[1] + ", " + muestra[2] + ", " + muestra[3]);

                break;
        }
    }
}
