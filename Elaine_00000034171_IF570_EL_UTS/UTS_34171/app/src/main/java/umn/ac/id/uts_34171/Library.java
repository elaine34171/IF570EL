package umn.ac.id.uts_34171;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class Library extends AppCompatActivity {
    RecyclerView rvAudioList;
    AudioListAdapter mAdapter;
    LinkedList<AudioSource> audioList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        Intent mainIntent = getIntent();
        String username = mainIntent.getStringExtra("Username");

        getSupportActionBar().setTitle(username);

        Toast toast = Toast.makeText(getApplicationContext(), "Selamat datang, " + username, Toast.LENGTH_SHORT);
        toast.show();

        audioListValue();
        rvAudioList = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new AudioListAdapter(this, audioList);
        rvAudioList.setAdapter(mAdapter);
        rvAudioList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_menu, menu);
        return true;
    }

    public void goToProfile() {
        Intent intent = new Intent(Library.this, Profile.class);
        startActivity(intent);
    }

    public void goToHome() {
        Intent intent = new Intent(Library.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.profileBtn:
                goToProfile();
                return true;

            case R.id.homeBtn:
                goToHome();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void audioListValue() {
        audioList.add(new AudioSource("Pink Soldiers", "Movie", "android.resource://" + getPackageName() + "/" + R.raw.pinksoldier));
        audioList.add(new AudioSource("Bouken Da Bouken", "Game", "android.resource://" + getPackageName() + "/" + R.raw.boukendabouken));
        audioList.add(new AudioSource("Hehe Boi", "Meme", "android.resource://" + getPackageName() + "/" + R.raw.heheboi));
        audioList.add(new AudioSource("Stop It, Get Some Help", "Meme", "android.resource://" + getPackageName() + "/" + R.raw.stopit));
        audioList.add(new AudioSource("Noice", "Meme", "android.resource://" + getPackageName() + "/" + R.raw.noice));
    }

    public void deleteAudio(View v) {
        String key = v.getTag().toString();

        for(int i = 0; i < audioList.size(); i++) {
            if(key.equals(audioList.get(i).getTitle())) {
                audioList.remove(audioList.get(i));
                mAdapter.notifyDataSetChanged();
                break;
            }
        }

        Toast toast = Toast.makeText(getApplicationContext(), "SFX " + key + " telah dihapus", Toast.LENGTH_SHORT);
        toast.show();
    }
}