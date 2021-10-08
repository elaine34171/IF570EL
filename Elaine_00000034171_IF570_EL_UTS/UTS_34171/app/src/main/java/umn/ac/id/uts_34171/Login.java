package umn.ac.id.uts_34171;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void goToLibrary(View view) {
        EditText nameInput = findViewById(R.id.nameInput);

        if(nameInput.getText().toString().trim().equals("")) {
            nameInput.setError("Harap Diisi");
            nameInput.setHint("Masukkan nama Anda...");
        }
        else {
            Intent intent = new Intent(Login.this, Library.class);
            String username = nameInput.getText().toString();
            intent.putExtra("Username", username);
            startActivity(intent);
            finish();
        }
    }
}