package com.sundaydevblog.contactbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ContactList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_list);

        // Create a list of contacts
        final ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Willie Perry", "15 Roslyn Rd, London N15, UK", "+44 7700 900716", R.drawable.c_willie));
        contacts.add(new Contact("Tammy Johnson", "20 Ashdon Cl, Woodford, Woodford Green IG8 0EF, UK", "+44 7700 900540", R.drawable.c_tammy));
        contacts.add(new Contact("Bobby Hill", "Dovehouse Ln, Norwich NR11 7PJ, UK", "+44 7700 900540", R.drawable.c_bob));
        contacts.add(new Contact("Elizabeth Hall", "32 Denny Rd, London N9 7QS, UK", "+44 7700 900563", R.drawable.c_elizabeth));
        contacts.add(new Contact("Christopher Davis", "74-80 Hallgate, Wigan WN1 1HP, UK", "+44 7700 900111", R.drawable.c_christopher));
        contacts.add(new Contact("Andrea Bailey", "C R Fouargue Bros, Farm Town Ln, Coleorton, Coalville LE67 8FG, UK", "+44 7700 900489", R.drawable.c_andrea));
        contacts.add(new Contact("Lisa Phillips", "Unnamed Road, Saffron Walden CB10 2PR, UK", "+44 7700 900093", R.drawable.c_lisa));
        contacts.add(new Contact("Phillip Collins", "Chalk Ln, Burgh le Marsh, Skegness PE24 5HN, UK", "+44 7700 900462", R.drawable.c_phillip));
        contacts.add(new Contact("Annie Washington", "19A Spring Gardens Rd, High Wycombe HP13 7AG, UK", "+44 7700 900345", R.drawable.c_annie));
        contacts.add(new Contact("Roy Ross", "17 Stapleton Cl, Highworth, Swindon SN6 7DR, UK", "+44 7700 900970", R.drawable.c_roy));


        // Create an {@link ContactAdapter}, whose data source is a list of {@link Contact}
        ContactAdapter adapter = new ContactAdapter(this, contacts);

        // Get a reference to the ListView, and attach the adapter to the listView
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Set a click listener to popup a message when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the {@link Contact} object at the given position the user clicked on
                Contact contact = contacts.get(position);

                // Display a Toast message
                Toast.makeText(ContactList.this, "Calling to: " + contact.getContactName(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}
