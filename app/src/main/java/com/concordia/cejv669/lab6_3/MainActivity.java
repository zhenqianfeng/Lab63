package com.concordia.cejv669.lab6_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button b = findViewById(R.id.btn_cal);

        registerForContextMenu(b);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edit_num1 = findViewById(R.id.edit_num1);
                EditText edit_num2 = findViewById(R.id.edit_num2);
                TextView tv = findViewById(R.id.tv_result);
                double num1 = Double.valueOf(edit_num1.getText().toString());
                double num2 = Double.valueOf(edit_num2.getText().toString());

                if (b.getText().toString()=="Add"){
                    tv.setText(String.valueOf(num1+num2));
                }
                else {
                    tv.setText(String.valueOf(num1*num2));
                }
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose Function");
        menu.add(0,v.getId(),0,"Add");
        menu.add(1,v.getId(),0,"Multiply");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Button b = findViewById(R.id.btn_cal);

        b.setText(item.getTitle());
        if (item.getGroupId() == 0)
        {
        }
        if (item.getGroupId() == 1)
        {

        }
        return true;
    }
}
