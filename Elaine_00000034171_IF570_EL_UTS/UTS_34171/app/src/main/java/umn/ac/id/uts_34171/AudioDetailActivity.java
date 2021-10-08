package umn.ac.id.uts_34171;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class AudioDetailActivity extends AppCompatActivity {
    private VideoView vvDetail;
    private TextView etTitle;
    private TextView etCategory;
    private TextView etUri;
    private Button playBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audiodetail);

        vvDetail = findViewById(R.id.vvDetail);
        etTitle = findViewById(R.id.etTitle);
        etCategory = findViewById(R.id.etCategory);
        etUri = findViewById(R.id.etUri);
        playBtn = findViewById(R.id.playBtn);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        AudioSource sv = (AudioSource) bundle.getSerializable("AudioDetail");

        etTitle.setText(sv.getTitle());
        etCategory.setText(sv.getCategory());
        etUri.setText(sv.getAudioURI());
        vvDetail.setVideoURI(Uri.parse(sv.getAudioURI()));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(sv.getTitle());

        MediaController controller = new MediaController(this);
        controller.setMediaPlayer(vvDetail);
        vvDetail.setMediaController(controller);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vvDetail.seekTo(100);
                vvDetail.start();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}