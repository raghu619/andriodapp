package com.example.android.quakereport;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by raghvendra on 19/2/17.
 */

public class DATA   {

private double mquakemag;
private  String mquakeplace;
    private long mquakedate;



    public DATA(double quakemag, String quakeplace, long quakedate)
    {

        mquakemag=quakemag;


        mquakeplace=quakeplace;

        mquakedate=quakedate;

    }



    public double getMquakemag()
    {



        return mquakemag;

    }


    public String getMquakeplace()

    {

    return mquakeplace;

    }

    public long getMquakedate()

    {
        return mquakedate;

    }



   }
