package com.example.checkboxes_and_etc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    CheckBox chocolate_syrup,sprinkles,crushed_nuts,cherries,orio_cookie_crumbles;
    Button show_toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chocolate_syrup = findViewById(R.id.chocolate_checkbox);
        sprinkles = findViewById(R.id.sprinkles_checkbox);
        crushed_nuts = findViewById(R.id.crushed_nuts_checkbox);
        cherries = findViewById(R.id.cherries_checkbox);
        orio_cookie_crumbles = findViewById(R.id.orio_cookies_crumbles_checkbox);
        show_toast = findViewById(R.id.show_toast);
        show_toast.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                StringBuffer result = new StringBuffer();
                result.append("Topping :");
                if(chocolate_syrup.isChecked()){
                    result.append("\t").append(chocolate_syrup.getText().toString());
                }
                if(sprinkles.isChecked()){
                    result.append("\t").append(sprinkles.getText().toString());
                }
                if(crushed_nuts.isChecked()){
                    result.append("\t").append(crushed_nuts.getText().toString());
                }
                if(cherries.isChecked()){
                    result.append("\t").append(cherries.getText().toString());
                }
                if(orio_cookie_crumbles.isChecked()){
                    result.append("\t").append(orio_cookie_crumbles.getText().toString());
                }
                if(!chocolate_syrup.isChecked() && !sprinkles.isChecked() && !crushed_nuts.isChecked() && !cherries.isChecked() && !orio_cookie_crumbles.isChecked())
                    result.append("\tNone");
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onCheckBoxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()){
            case R.id.chocolate_checkbox:
                if(checked)
                    displayToast(getString(R.string.chocolate_syrup));
                break;
            case R.id.sprinkles_checkbox:
                if(checked)
                    displayToast(getString(R.string.sprinkles));
            case R.id.crushed_nuts_checkbox:
                if(checked)
                    displayToast(getString(R.string.crushed_nuts));
                break;
            case R.id.cherries_checkbox:
                if(checked)
                    displayToast(getString(R.string.cherries));
            case R.id.orio_cookies_crumbles_checkbox:
                if(checked)
                    displayToast(getString(R.string.orio_cookie_crumbles));
                break;
            default:
                // Do nothing
                break;
        }

    }
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
}