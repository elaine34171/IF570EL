package umn.ac.id.uts_34171;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.LinkedList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AudioListAdapter extends RecyclerView.Adapter<AudioListAdapter.ItemAudioViewHolder> {
    private LinkedList<AudioSource> mAudioList;
    private LayoutInflater mInflater;
    private Context mContext;

    public AudioListAdapter(Context context, LinkedList<AudioSource> audioList){
        this.mContext = context;
        this.mAudioList = audioList;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ItemAudioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.audio_item_layout, parent, false);
        return new ItemAudioViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAudioViewHolder holder, int position) {
        AudioSource mAudioSource = mAudioList.get(position);
        holder.tvTitle.setText(mAudioSource.getTitle());
        holder.tvCategory.setText(mAudioSource.getCategory());
        holder.tvUri.setText(mAudioSource.getAudioURI());
        holder.deleteBtn.setTag(mAudioSource.getTitle());
    }

    @Override
    public int getItemCount() {
        return mAudioList.size();
    }

    public class ItemAudioViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvTitle;
        private TextView tvCategory;
        private TextView tvUri;
        private AudioListAdapter mAdapter;
        private int mPosition;
        private AudioSource mAudioSource;
        private ImageButton deleteBtn;

        public ItemAudioViewHolder(@NonNull View itemView, AudioListAdapter adapter) {
            super(itemView);
            mAdapter = adapter;
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvCategory = itemView.findViewById(R.id.tvCategory);
            tvUri = itemView.findViewById(R.id.tvUri);
            deleteBtn = itemView.findViewById(R.id.deleteBtn);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mPosition = getLayoutPosition();
            mAudioSource = mAudioList.get(mPosition);
            Intent detailIntent = new Intent(mContext, AudioDetailActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("AudioDetail", mAudioSource);
            detailIntent.putExtras(bundle);
            mContext.startActivity(detailIntent);
        }
    }
}