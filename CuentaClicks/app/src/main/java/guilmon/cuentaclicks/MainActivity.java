package guilmon.cuentaclicks;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txt1, txt2, txt3, txt4;
    Button btn1, btn2, btn3, btn4, btn5;
    int contador1=0, contador2=0, contador3=0, contador4=0, contador5=0;
    LinearLayout pantalla;
    EditText txt5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txt1 = (TextView)findViewById(R.id.txt1);
        txt2 = (TextView)findViewById(R.id.txt2);
        txt3 = (TextView)findViewById(R.id.txt3);
        txt4 = (TextView)findViewById(R.id.txt4);
        txt5 = (EditText) findViewById(R.id.txt5);

        pantalla=(LinearLayout)findViewById(R.id.pantalla);

        //BOTON2
        Button btn2=(Button)findViewById(R.id.btn2);
        btn2.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                contador2++;
                txt2.setText(""+contador2);
                return true;
            }
        });

        //BOTON3
        EditText edt1 = (EditText) findViewById(R.id.edt1);
        edt1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    contador3++;
                    txt3.setText("" + contador3);
                    return true;
                }
                return false;

            }});

        //BOTON 4
        this.pantalla.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_UP){
                    contador4++;
                    txt4.setText(""+contador4);
                }if (event.getAction()==MotionEvent.ACTION_DOWN){
                    contador4++;
                    txt4.setText(""+contador4);
                }
                return false;
            }
        });

        //Boton 5
        final Button btn5 =(Button)findViewById(R.id.bnt5);
        this.txt5.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                contador5++;
                btn5.setText("Pervertido me haz tocado"+contador5);
            }
        });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    //BOTON1
    public void OnClickListener(View v){
        contador1++;
        txt1.setText(""+contador1);

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
}
