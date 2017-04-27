package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Switch;
import android.widget.TextView;

import java.sql.Array;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by raghvendra on 19/2/17.
 */

public class CustomAdapter extends ArrayAdapter<DATA> {

    private static final String LOCATION_SEPAROTOR = "of";

    public CustomAdapter(Activity context,ArrayList<DATA> k) {
        super(context, 0, k);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {

            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }


        DATA k = getItem(position);
        String originalLocation = k.getMquakeplace();
        String primaryLocation;
        String locationOffset;
        if (originalLocation.contains(LOCATION_SEPAROTOR)) {

            String parts[] = originalLocation.split(LOCATION_SEPAROTOR);
            locationOffset = parts[0] + LOCATION_SEPAROTOR;
            primaryLocation = parts[1];
        } else
            {

            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;

        }

        DecimalFormat format = new DecimalFormat("0.00");

        String mag = format.format(k.getMquakemag());

        TextView textView = (TextView) listItemView.findViewById(R.id.quakemag);

        textView.setText("" + mag);
        GradientDrawable magnitudeCircle = (GradientDrawable) textView.getBackground();
        int magnitudeColor=getMagnitudeColor(k.getMquakemag());
        magnitudeCircle.setColor(magnitudeColor);

        TextView placetextView =(TextView) listItemView.findViewById(R.id.quakeplace);
        placetextView.setText("" + primaryLocation);


        TextView placetextView1=(TextView) listItemView.findViewById(R.id.quakeplace1);
        placetextView1.setText("" + locationOffset);


        TextView datetextView = (TextView) listItemView.findViewById(R.id.quakedate);
        Date dateObject = new Date(k.getMquakedate());
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        dateFormat.format(dateObject);

        datetextView.setText("" + dateFormat.format(dateObject));

        TextView timeview = (TextView) listItemView.findViewById(R.id.quaketime);
        Date datetime = new Date(k.getMquakedate());
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("h:mm a");
        dateFormat1.format(datetime);

        timeview.setText("" + dateFormat1.format(datetime));


        return listItemView;


}


    private int getMagnitudeColor(double mag) {

        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(mag);

        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;

            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;

            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;


        }
        return ContextCompat.getColor(getContext(),magnitudeColorResourceId);

    }



}
