package com.chilelingo.search;

public class Phrase {
    private String text;
    private String videoId;
    private int start;

    public Phrase() {}

    public Phrase(String text, String videoId, int start) {
        this.text = text;
        this.videoId = videoId;
        this.start = start;
    }

    public String getText() { return text; }
    public String getVideoId() { return videoId; }
    public int getStart() { return start; }

    public void setText(String text) { this.text = text; }
    public void setVideoId(String videoId) { this.videoId = videoId; }
    public void setStart(int start) { this.start = start; }
}