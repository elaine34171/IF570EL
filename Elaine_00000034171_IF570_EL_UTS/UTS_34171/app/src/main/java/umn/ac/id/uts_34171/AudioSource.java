package umn.ac.id.uts_34171;

import java.io.Serializable;

public class AudioSource implements Serializable {
    private String title;
    private String category;
    private String audioURI;

    public AudioSource(String title, String category, String audioURI) {
        this.title = title;
        this.category = category;
        this.audioURI = audioURI;
    }

    public String getTitle() {
        return this.title;
    }

    public String getCategory() {
        return this.category;
    }

    public String getAudioURI() {
        return this.audioURI;
    }

    public String toString() {
        return this.getTitle() + " => " + this.getCategory();
    }
}