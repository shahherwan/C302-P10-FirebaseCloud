package sg.edu.rp.c346.c302_p10_firebasecloud;

import android.service.quicksettings.Tile;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TextView tvTitle, tvDate, tvDays, tvCompleted, tv1, tv2, tv3, tv4;
    private EditText etTitle, etDate, etDays;
    private CheckBox checkBox;
    private Button btnAdd;

    // TODO: Task 1 - Declare Firebase variables
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference messagePOJOReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI Elements
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvDate = (TextView) findViewById(R.id.tvDate);
        tvDays = (TextView) findViewById(R.id.tvDays);
        tvCompleted = (TextView) findViewById(R.id.tvCompleted);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);

        etTitle = (EditText) findViewById(R.id.etTitle);
        etDate = (EditText) findViewById(R.id.etDate);
        etDays = (EditText) findViewById(R.id.etDays);

        checkBox = (CheckBox) findViewById(R.id.checkBox);

        btnAdd = (Button) findViewById(R.id.btnAdd);


        // TODO: Task 2 - Get Firebase database instance and reference
        firebaseDatabase = FirebaseDatabase.getInstance();
        messagePOJOReference = firebaseDatabase.getReference("toDoItem");

        // TODO: Task 3 - Add a value event listener to the "message" node

        messagePOJOReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // TODO: Task 4 - Get the latest value from the dataSnapshot and display on the UI using the EditText message
                // This method will get fired everytime the "message" value updates in the realtime database. We're getting our data back as a DataSnapshot
                Title title = dataSnapshot.getValue(Title.class);

                tvTitle.setText("Title: " + title.getTitle());
                tvDate.setText("Date: " + title.getDate());
                tvDays.setText("NumOfDays: " + title.getNoOfDays());
                tvCompleted.setText("Completed? " + title.isCompleted());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "Database error occurred", databaseError.toException());

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Title title = new Title(etTitle.getText().toString(), etDate.getText().toString(), Integer.parseInt(etDays.getText().toString()), checkBox.isChecked());
                messagePOJOReference.setValue(title);
            }
        });

    }
}
