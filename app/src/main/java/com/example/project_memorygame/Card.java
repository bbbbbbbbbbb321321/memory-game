package com.example.project_memorygame;

public class Card {
    private static int lastAssignedId = 0;

    private final int id;
    private  int pictureId;
    private boolean isMatched;

    public Card(int id) {
        this.id = id;
        this.pictureId = 0;
        this.isMatched = false;
    }

    public int getId() {
        return id;
    }
    public void  setPictureId(int id) {
         pictureId=id;
    }

    public int getPictureId() {
        return pictureId;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    private int generateUniqueId() {
        // Implement a unique ID generation logic here
        // For simplicity, you can use a counter or another method
        return ++lastAssignedId;
    }
}
