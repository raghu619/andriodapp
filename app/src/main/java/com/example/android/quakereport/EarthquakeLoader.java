package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

import static com.example.android.quakereport.QueryUtils.fetchdata;

/**
 * Created by raghvendra on 23/7/17.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<DATA>>{

private  String murl;
    public EarthquakeLoader(Context context,String url) {
        super(context);
        murl=url;
    }


    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<DATA> loadInBackground() {
        try{
            Thread.sleep(2000);

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }


        if(murl==null) {
            return null;
        }
        List<DATA> result=fetchdata(murl);
        return result;



    }




    }

