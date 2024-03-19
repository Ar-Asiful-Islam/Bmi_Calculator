package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;



public class UnderWeight extends Activity{

    ListView simpleList;
    String countryList[] = {"Milk\n\n" +"Milk is a complete food because it is rich in all nutrients that are essential for our body. It is high in proteins, calcium, carbs, fats, minerals, and vitamins. It is an excellent protein source that provides both casein and whey proteins. It can help you add muscle mass to your body. ", "Egg \n\n"+"Whole eggs are the best option for your dietitian for weight gain as they are full of proteins, calcium, and healthy fats. They are muscle building food that is available easily. It is necessary to eat the whole egg, its egg yolk is very beneficial.", "Rice\n"+"Rice is one of the convenient and cheap sources of carbohydrates that is essential to gain weight. Rice is also a calorie-dense food that means you can obtain carbs and calories from a single serving. One cup of rice provides about 200 calories that contribute to gain weight. ", "Dates\n\n"+"Dates can contribute to weight gain when consumed in excess due to their natural sugar content, but when eaten in moderation as part of a balanced diet, they are a healthy snack and unlikely to cause significant weight gain. ", "Red Meat \n\n"+"Red meat is a rich source of protein that helps to build your muscles and increase your weight. It contains leucine and creatine, nutrients that play a significant role in boosting muscle mass. Steak and other red meats contain both protein and fat, which promote weight gain."};
    int flags[] = {R.drawable.milk, R.drawable.egg, R.drawable.rice, R.drawable.dates, R.drawable.red_meat};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_under_weight);
        simpleList = (ListView) findViewById(R.id.simpleListView);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), countryList, flags);
        simpleList.setAdapter(customAdapter);
    };
}