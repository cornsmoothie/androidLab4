package edu.temple.palettecanvaslab4;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        RelativeLayout canvasLayout = (RelativeLayout)  findViewById(R.id.activity_canvas);

        Intent receivedInfo = getIntent();
        String recievedColor = receivedInfo.getStringExtra("color");
        canvasLayout.setBackgroundColor(Color.parseColor(recievedColor));
    }
}
