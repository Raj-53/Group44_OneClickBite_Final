package com.example.oneclickbite;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Helper {
    public static void getListViewSize(ListView listView){
        ListAdapter listAdapter = listView.getAdapter();
        if(listAdapter == null){
            // do nothing
            return;
        }

        // set listAdapter in loop for getting final size
        int totalHeight = 0;
        for(int i=0; i<listAdapter.getCount(); i++){
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0,0);
            totalHeight += listItem.getMeasuredHeight();
        }

        // setting listView item in adapter
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);

        // print height of adapter on log
//        Log.i("MyLogs", "Height of listItem: "+ String.valueOf(totalHeight));
    }
}
