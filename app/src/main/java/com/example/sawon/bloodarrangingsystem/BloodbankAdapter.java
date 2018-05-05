package com.example.sawon.bloodarrangingsystem;

/**
 * Created by sawon on 11/4/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.sawon.bloodarrangingsystem.utils.Ambulance;
import com.example.sawon.bloodarrangingsystem.utils.Bloodbank;

import java.util.List;

public class BloodbankAdapter extends ArrayAdapter<Bloodbank> {

//the hero list that will be displayed
private List<Bloodbank> ambulanceList;

//the context object
private Context mCtx;

//here we are getting the herolist and context
//so while creating the object of this adapter class we need to give herolist and context
public BloodbankAdapter(List<Bloodbank> ambulanceList, Context mCtx) {
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
        Bloodbank bloodbank = ambulanceList.get(position);

        //setting hero values to textviews
        region.setText(bloodbank.getName());
        contact.setText(bloodbank.getContact());
        serviceTime.setText(bloodbank.getService_time());
        serviceTime.setText(bloodbank.getAddress());

        //returning the listitem
        return listViewItem;
        }
        }
