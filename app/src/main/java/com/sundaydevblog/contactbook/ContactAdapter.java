package com.sundaydevblog.contactbook;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * {@link ContactAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
 * based on a data source, which is a list of {@link Contact} objects.
 */
public class ContactAdapter extends ArrayAdapter<Contact> {

    private static final String LOG_TAG = ContactAdapter.class.getSimpleName();

    /**
     * Custom constructor of a {@link ContactAdapter}.
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param objects A List of Contact objects to display in a list
     */
    public ContactAdapter(@NonNull Context context, @NonNull List<Contact> objects) {
        super(context, 0, objects);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        //  Get {@link Contact} object located at this position in the list
        Contact currentContact = getItem(position);
        assert currentContact != null;

        // Find the TextView in the list_item.xml layout with the ID name_text_view
        TextView contactName = (TextView) listItemView.findViewById(R.id.name_text_view);
        // Get the contact name from the current Contact object and set this text on the name TextView
        contactName.setText(currentContact.getContactName());

        // Find the TextView in the list_item.xml layout with the ID address_text_view
        TextView contactAddress = (TextView) listItemView.findViewById(R.id.address_text_view);
        // Get the contact address from the current Contact object and set this text on the name TextView
        contactAddress.setText(currentContact.getContactAddress());

        // Find the TextView in the list_item.xml layout with the ID mobile_text_view
        TextView contactMobile = (TextView) listItemView.findViewById(R.id.mobile_text_view);
        // Get the contact mobile number from the current Contact object and set this text on the name TextView
        contactMobile.setText(currentContact.getContactMobile());

        // Find the ImageView in the list_item.xml layout with the ID contact_image
        ImageView contactImage = (ImageView) listItemView.findViewById(R.id.contact_image);
        // Get the image resource ID from the current Contact object and set the image to the ImageView
        contactImage.setImageResource(currentContact.getContactImageResourceId());

        // Return the whole list item layout (containing 4 TextViews and a ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
