package umn.ac.id.uts_34171;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView ref1 = findViewById(R.id.ref1);
        ref1.setMovementMethod(LinkMovementMethod.getInstance());

        TextView ref2 = findViewById(R.id.ref2);
        ref2.setMovementMethod(LinkMovementMethod.getInstance());

        TextView ref3 = findViewById(R.id.ref3);
        ref3.setMovementMethod(LinkMovementMethod.getInstance());

        TextView ref4 = findViewById(R.id.ref4);
        ref4.setMovementMethod(LinkMovementMethod.getInstance());

        TextView ref5 = findViewById(R.id.ref5);
        ref5.setMovementMethod(LinkMovementMethod.getInstance());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}