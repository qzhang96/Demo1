package com.example.myapplication;

import android.app.Activity;
import android.content.res.Resources;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;

import java.util.ArrayList;
import java.util.EventListener;


// It provides suggestions automatically when the user is typing.
// The list of suggestions is displayed in a drop down menu from which the user can
// choose an item to replace the content
// of the edit box with.

//The multiAutoCompleteTextView demonstrates suggestions for not only a word but for whole text. As after writing first word ,
// when i start writing the second word , it displays me the suggestions.
public class MainActivity extends Activity {
    AutoCompleteTextView auto;
    MultiAutoCompleteTextView mutiple;
    Button save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        String[] countries = res.getStringArray(R.array.list_of_countries);
        auto=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView1);
        mutiple=(MultiAutoCompleteTextView)findViewById(R.id.multiAutoCompleteTextView1);
        save=findViewById(R.id.save);
        ArrayAdapter adapter = new
                ArrayAdapter(this,android.R.layout.simple_list_item_1,countries);

        auto.setAdapter(adapter);
        // so the user has to enter at least 1 character to show the suggestions.
        auto.setThreshold(1);

        mutiple.setAdapter(adapter);
        //This simple Tokenizer can be used for lists where the items are separated by a comma and one or more spaces.
        mutiple.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        EventHandler eventHandler =new EventHandler();
        save.setOnClickListener(eventHandler);


    }
    class EventHandler implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId())
            {
                case R.id.save:
                    //You can use a Snackbar to display a brief message to the user. The message automatically goes away after a short period.
                    // A Snackbar is ideal for brief messages that the user doesn't necessarily need to act on.
                    //For example, an email app could use a Snackbar to tell the user that the app successfully sent an email.

                    //A Snackbar is attached to a view. The Snackbar provides basic functionality if it is
                    // attached to any object derived from the View class, such as any of the common layout objects.
                    // However, if the Snackbar is attached to a CoordinatorLayout, the Snackbar gains additional features:
                    //
                    //The user can dismiss the Snackbar by swiping it away.

                    //Display a message
                    //There are two steps to displaying a message. First, you create a Snackbar object with the message text. Then, you call that object's show() method to display the message to the user.
                    //
                    //Creating a Snackbar object
                    //Create a Snackbar object by calling the static Snackbar.make() method. When you create the Snackbar,
                    // you specify both the message it displays, and the length of time to show the message:
                    //The length of time to show the message. This can be either LENGTH_SHORT or LENGTH_LONG.
                    //Once you have created the Snackbar, call its show() method to display the Snackbar to the user:
                    //To add an action to a Snackbar message, you need to define a listener object that implements the View.OnClickListener interface. The system calls your listener's onClick() method if the user clicks on the message action.
                    // For example, this snippet shows a listener for an undo action:
                    Snackbar.make(findViewById(R.id.myCoordinatorLayout), "Sent", Snackbar.LENGTH_LONG)
                            .setAction("Dismiss", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                }
                            }).show();
                break;
            }
        }
    }

}
