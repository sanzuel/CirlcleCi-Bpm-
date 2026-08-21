package com.songsetlist.app;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity {
    private final String[] songs = {
        "Adventure of a Lifetime — 100 BPM",
        "All of Me — 89 BPM",
        "Always — 72 BPM",
        "Believer — 125 BPM",
        "Blinding Lights — 120 BPM",
        "Bohemian Rhapsody — 72 BPM",
        "Can't Stop the Feeling! — 113 BPM",
        "Counting Stars — 100 BPM",
        "Dancing Queen — 110 BPM",
        "Don't Stop Believin' — 118 BPM",
        "Everlong — 94 BPM",
        "Happy — 100 BPM",
        "Hall of Fame — 132 BPM",
        "Havana — 105 BPM",
        "Levitating — 128 BPM",
        "Perfect — 94 BPM",
        "Someone Like You — 67 BPM",
        "Titanium — 126 BPM",
        "Uptown Funk — 115 BPM"
    };

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_main);

        ListView list = findViewById(R.id.songList);
        EditText search = findViewById(R.id.search);

        ArrayList<String> data = new ArrayList<>(Arrays.asList(songs));
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, data);
        list.setAdapter(adapter);

        search.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int st, int c, int a) {}
            public void onTextChanged(CharSequence s, int st, int before, int count) {
                adapter.getFilter().filter(s);
            }
            public void afterTextChanged(Editable e) {}
        });
    }
}
