package sg.edu.rp.c346.id22017139.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etElement, etIndexElement;
    Button btnAdd, btnRemove, btnUpdate;
    ListView lvColour;

    ArrayList<String> alColours;
    ArrayAdapter<String> aaColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alColours = new ArrayList<String>();
        alColours.add("Red");
        alColours.add("Orange");

        etElement = findViewById(R.id.editTextColour);
        etIndexElement = findViewById(R.id.editTextIndex);
        btnAdd = findViewById(R.id.buttonAddItem);
        btnRemove = findViewById(R.id.buttonRemoveItem);
        btnUpdate = findViewById(R.id.buttonUpdateItem);
        lvColour = findViewById(R.id.listViewColor);

        aaColour = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alColours);
        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newColor = etElement.getText().toString();
                int pos = Integer.parseInt(etIndexElement.getText().toString());

                if (pos >= 0 && pos <= alColours.size()) {
                    alColours.add(pos, newColor);
                    aaColour.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivity.this, "Invalid position", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                if (pos >= 0 && pos < alColours.size()) {
                    alColours.remove(pos);
                    aaColour.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivity.this, "Invalid position", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                if (pos >= 0 && pos < alColours.size()) {
                    String updatedColor = etElement.getText().toString();
                    alColours.set(pos, updatedColor);
                    aaColour.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivity.this, "Invalid position", Toast.LENGTH_SHORT).show();
                }
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = alColours.get(position);
                Toast.makeText(MainActivity.this, "Clicked color: " + colour, Toast.LENGTH_SHORT).show();
            }
        });
    }
}