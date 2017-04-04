package edu.temple.palettecanvaslab4;

        import android.content.Context;
        import android.graphics.Color;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;

public class CustomAdapter extends ArrayAdapter<String> {

    String[] colors;
    String[] actualColors = {"WHITE" , "RED" , "BLUE" , "GREEN" , "GRAY" , "PURPLE"};



    public CustomAdapter(Context context , int resource , String[] objects) {
        super(context , android.R.layout.simple_list_item_1 , objects);
        this.colors = objects;
    }

    @Override
    public View getView(int position , View convertView , ViewGroup parent) {
        View v = super.getView(position , convertView , parent);
        v.setBackgroundColor(Color.parseColor(actualColors[position]));
        return v;
    }

    @Override
    public View getDropDownView(int position , View convertView , ViewGroup parent) {
        View v = super.getView(position , convertView, parent);
        v.setBackgroundColor(Color.parseColor(actualColors[position]));
        return v;
    }

}
