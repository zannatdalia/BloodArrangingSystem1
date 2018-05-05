package com.example.sawon.bloodarrangingsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.sawon.bloodarrangingsystem.utils.Ambulance;

import java.util.List;

/**
 * Created by Belal on 9/5/2017.
 */

public class ListViewAdapter extends ArrayAdapter<Amb> {

    //the hero list that will be displayed
    private List<Amb> ambulanceList;

    //the context object
    private Context mCtx;

    //here we are getting the herolist and context
    //so while creating the object of this adapter class we need to give herolist and context
    public ListViewAdapter(List<Amb> ambulanceList, Context mCtx) {
        super(mCtx, R.layout.singleitem, ambulanceList);
        this.ambulanceList = ambulanceList;
        this.mCtx = mCtx;
    }

    //this method will return the list item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //getting the layoutinflater
        LayoutInflater inflater = LayoutInflater.from(mCtx);

        //creating a view with our xml layout
        View listViewItem = inflater.inflate(R.layout.singleitem, null, true);

        //getting text views
        TextView region = listViewItem.findViewById(R.id.aRegion);
        TextView contact = listViewItem.findViewById(R.id.contact);
        TextView serviceTime = listViewItem.findViewById(R.id.serviceTime);

        //Getting the hero for the specified position
        Amb ambulance = ambulanceList.get(position);

        //setting hero values to textviews
        region.setText(ambulance.getRegion());
        contact.setText(ambulance.getContact());
        serviceTime.setText(ambulance.getService_time());

        //returning the listitem
        return listViewItem;
    }
}
