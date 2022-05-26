package com.example.tourguideproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter<Place> {

    /**
     * Resource ID for the background color for this list of words
     */
    private int mColorResourceId;

    /**
     * Create a new {@link PlaceAdapter} object.
     *
     * @param context         is the current context (i.e. Activity) that the adapter is being created in.
     * @param places          is the list of {@link Place}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of words
     */
    public PlaceAdapter(Context context, ArrayList<Place> places, int colorResourceId) {
        super(context, 0, places);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

// Get the {@link Place} object located at this position in the list
        Place currentPlace = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID name.
        TextView placeName = listItemView.findViewById(R.id.name);
        // Get the name from the place object and set this text on
        // the name textview.
        placeName.setText(currentPlace.getName());

        // Find the TextView in the list_item.xml layout with the ID contact.
        TextView contact = listItemView.findViewById(R.id.contact);
        // Get the contact from the place object and set this text on
        // the description textview.
        contact.setText(currentPlace.getContactInformation());

        // Find the TextView in the list_item.xml layout with the ID description.
        TextView description = listItemView.findViewById(R.id.description);
        // Get the description from the place object and set this text on
        // the description textview.
        description.setText(currentPlace.getDescription());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = listItemView.findViewById(R.id.image);
        // Check if an image is provided for this place or not
        if (currentPlace.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentPlace.getmImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
