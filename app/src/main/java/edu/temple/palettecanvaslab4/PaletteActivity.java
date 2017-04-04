package edu.temple.palettecanvaslab4;

        import android.app.Activity;
        import android.content.Context;
        import android.content.Intent;
        import android.content.res.Resources;
        import android.graphics.Color;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.GridView;
        import android.widget.RelativeLayout;
        import android.widget.Spinner;
        import android.widget.Toast;

        import java.util.List;

        import edu.temple.palettecanvaslab4.CustomAdapter;
        import edu.temple.palettecanvaslab4.R;

        import static android.R.attr.resource;
        import static edu.temple.palettecanvaslab4.R.id.activity_palette;

public class PaletteActivity extends AppCompatActivity {

    GridView colorGrid;
    String[] colors;
    String[] actualColors;
    //String[] colors = {"WHITE" , "RED" , "BLUE" , "GREEN" , "GRAY" , "PURPLE"};
    //String[] colors = getResources().getStringArray(R.string.colors);
    //String[] colors = colorArray.getStringArray(R.array.colors);
    //String[]

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);


       // Resources colorArray = getResources();

        colors = getResources().getStringArray(R.array.spanishColors);
        actualColors = getResources().getStringArray(R.array.colors);

        colorGrid = (GridView) findViewById(R.id.gridOfColor);

        final RelativeLayout paletteLayout = (RelativeLayout) findViewById(R.id.activity_palette);

        final CustomAdapter colorAdapter = new CustomAdapter(PaletteActivity.this , android.R.layout.simple_list_item_1 , colors);

        colorGrid.setAdapter(colorAdapter);

        colorGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(PaletteActivity.this , "HI" , Toast.LENGTH_SHORT).show();
                Toast.makeText(PaletteActivity.this , "Sending: " + colors[position] , Toast.LENGTH_SHORT).show();

                Intent sendInformation = new Intent(PaletteActivity.this , CanvasActivity.class);
                sendInformation.putExtra("color" ,  actualColors[position]);
                startActivity(sendInformation);
            }
        });
/*
        AdapterView.OnItemSelectedListener spinnerListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(PaletteActivity.this, colorGrid.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                //pallette_activity.setBackgroundColor(Color.parseColor(colorGrid.getSelectedItem().toString()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
*/

        //colorGrid.setOnItemSelectedListener(spinnerListener);
    }
}
