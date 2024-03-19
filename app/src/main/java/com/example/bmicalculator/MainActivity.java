package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    public int heightIn,heightFt,weight;
    EditText HeightFt,HeightIn,Weight;
    TextView result, NM;
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HeightFt=findViewById(R.id.HeightFt_input);
        HeightIn=findViewById(R.id.heightIn_input);
        Weight=findViewById(R.id.weight_input);
        button = findViewById(R.id.calculate);
        result = findViewById(R.id.result);
        NM = findViewById(R.id.NM);
        imageView = findViewById(R.id.pb);
        imageView.setImageResource(R.drawable.first);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (HeightFt.length() > 0 && HeightIn.length() > 0 && Weight.length() > 0) {
                heightIn = Integer.parseInt(String.valueOf(HeightIn.getText()));
                heightFt = Integer.parseInt(String.valueOf(HeightFt.getText()));
                weight = Integer.parseInt(String.valueOf(Weight.getText()));
                    float totalInc = heightFt * 12 + heightIn;
                    float totalCm = totalInc * 2.53f;
                    float totalMeter = totalCm / 100;
                    float bmi = weight / (totalMeter * totalMeter);
                    result.setText(String.format("%.1f",bmi));

                    if (bmi > 25) {
                        imageView.setImageResource(0);
                        imageView.setImageResource(R.drawable.overweight);
                        TextView status = findViewById(R.id.status);
                        status.setText(R.string.you_are_overweight);
                        NM.setVisibility(View.VISIBLE);
                        NM.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(MainActivity.this, OverWeight.class);
                                startActivity(intent);
                            }
                        });

                    } else if (bmi < 18) {
                        imageView.setImageResource(0);
                        imageView.setImageResource(R.drawable.underweight);
                        TextView status = findViewById(R.id.status);
                        status.setText(R.string.you_are_underweight);
                        NM.setVisibility(View.VISIBLE);
                        NM.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent= new Intent( MainActivity.this, UnderWeight.class);
                                startActivity(intent);
                            }
                        });
                    } else {
                        imageView.setImageResource(0);
                        imageView.setImageResource(R.drawable.normal);
                        TextView status = findViewById(R.id.status);
                        status.setText(R.string.you_are_normal);
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Please Fill The Required Value", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void Male(View view){
        ImageView img1 = findViewById(R.id.male);
        ImageView img2 = findViewById(R.id.female);
        img1.setBackgroundResource(R.drawable.shape);
        img2.setBackgroundResource(0);
    }
    public void Female(View view){
        ImageView img1 = findViewById(R.id.male);
        ImageView img2 = findViewById(R.id.female);
        img2.setBackgroundResource(R.drawable.shape);
        img1.setBackgroundResource(0);
    }
}