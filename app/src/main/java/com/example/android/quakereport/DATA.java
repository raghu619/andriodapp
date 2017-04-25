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

private String mUrl;

    public DATA(double quakemag, String quakeplace, long quakedate,String url)
    {

        mquakemag=quakemag;
       mUrl=url;

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

   public String getUrl(){


       return mUrl;

   }

   }
