package com.example.sueliopss.trabalhoso2;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    List<Pessoa> pessoas;

    @ViewById
    EditText editTextNome;

    @ViewById
    EditText editTextIdade;

    @ViewById
    EditText editTextNomeShow;

    @ViewById
    EditText editTextIdadeShow;

    @ViewById
    Button buttonAdd;

    @ViewById
    Chronometer chronometer;


    int count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pessoas = new ArrayList<Pessoa>();
        count = 0;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void adicionarPessoa(View view){

        chronometer.setBase(SystemClock.elapsedRealtime());

        chronometer.start();
        pessoas.add(new Pessoa(editTextNome.getText().toString(), Integer.parseInt(editTextIdade.getText().toString())));
        buttonAdd.setEnabled(false);
        showPessoa();
    }
    @UiThread(delay = 6000)
    public void showPessoa(){
        chronometer.stop();

       Pessoa pess = pessoas.get(pessoas.size() -1);

        editTextNomeShow.setText(pess.nome);
        editTextIdadeShow.setText("" + pess.idade);

        buttonAdd.setEnabled(true);


    }
}
