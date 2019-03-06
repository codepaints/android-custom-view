package me.jatinsoni.customview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import me.jatinsoni.customview.views.CircleView;

public class MainActivity extends AppCompatActivity {

    private CircleView myView;
    private Button     btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myView = findViewById(R.id.custView);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myView.setCircleCol(Color.GREEN);
                myView.setLabelText("Color Changed!");
                myView.setLabelCol(Color.BLACK);
            }
        });

    }
}
