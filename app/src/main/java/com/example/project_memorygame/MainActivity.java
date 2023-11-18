package com.example.project_memorygame;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //private ImageButton imageButton1,imageButton2,imageButton3,imageButton4;
    //private static List<ImageButton> ImageButton()
    private List<Card> cards;
    boolean isOpen;
    ImageButton lastImageButton;
    int lastId;
    private boolean click;
    Handler handler = new Handler();
    private List<Card> generateCards() {
        cards = new ArrayList<>();

        // Assuming you have 10 unique picture IDs (1 to 10)

        cards.add(new Card(R.id.imageButton1));
        cards.add(new Card(R.id.imageButton2));
        cards.add(new Card(R.id.imageButton3));
        cards.add(new Card(R.id.imageButton4));
        cards.add(new Card(R.id.imageButton5));
        cards.add(new Card(R.id.imageButton6));
        cards.add(new Card(R.id.imageButton7));
        cards.add(new Card(R.id.imageButton8));
        cards.add(new Card(R.id.imageButton9));
        cards.add(new Card(R.id.imageButton10));
        cards.add(new Card(R.id.imageButton11));
        cards.add(new Card(R.id.imageButton12));
        cards.add(new Card(R.id.imageButton13));
        cards.add(new Card(R.id.imageButton14));
        cards.add(new Card(R.id.imageButton15));
        cards.add(new Card(R.id.imageButton16));
        cards.add(new Card(R.id.imageButton17));
        cards.add(new Card(R.id.imageButton18));
        cards.add(new Card(R.id.imageButton19));
        cards.add(new Card(R.id.imageButton20));
        shuffleCards(cards);
        cards.get(0).setPictureId(R.drawable.dog);
        cards.get(1).setPictureId(R.drawable.dog);
        cards.get(2).setPictureId(R.drawable.cat);
        cards.get(3).setPictureId(R.drawable.cat);
        cards.get(4).setPictureId(R.drawable.hamster);
        cards.get(5).setPictureId(R.drawable.hamster);
        cards.get(6).setPictureId(R.drawable.hedgehog);
        cards.get(7).setPictureId(R.drawable.hedgehog);
        cards.get(8).setPictureId(R.drawable.panda);
        cards.get(9).setPictureId(R.drawable.panda);
        cards.get(10).setPictureId(R.drawable.penguin);
        cards.get(11).setPictureId(R.drawable.penguin);
        cards.get(12).setPictureId(R.drawable.rabbit);
        cards.get(13).setPictureId(R.drawable.rabbit);
        cards.get(14).setPictureId(R.drawable.rat);
        cards.get(15).setPictureId(R.drawable.rat);
        cards.get(16).setPictureId(R.drawable.white);
        cards.get(17).setPictureId(R.drawable.white);
        cards.get(18).setPictureId(R.drawable.parrot);
        cards.get(19).setPictureId(R.drawable.parrot);
        return cards;
    }

    private static void shuffleCards(List<Card> cards) {
        long seed = System.nanoTime();
        Collections.shuffle(cards, new Random(seed));
    }
    private void animateCardTurn(View view) {
        ObjectAnimator flipOut = ObjectAnimator.ofFloat(view, "rotationY", 0f, 360f);
        flipOut.setDuration(3000);
        AnimatorSet flip = new AnimatorSet();
        flip.playSequentially(flipOut);
        flip.start();

       // ObjectAnimator flipIn = ObjectAnimator.ofFloat(view, "rotationY", 0f, 0f);
        //flipIn.setDuration(600);


    }

    private void start()
    {
        ImageButton cardButton = findViewById(R.id.imageButton1);
        boolean isOpen = false;
        generateCards();
        boolean click=false;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start();

        int[] cardButtonIds = {R.id.imageButton1,R.id.imageButton2,R.id.imageButton3,R.id.imageButton4,
                R.id.imageButton5,R.id.imageButton6,R.id.imageButton7,R.id.imageButton8,
                R.id.imageButton9,R.id.imageButton10,R.id.imageButton11,R.id.imageButton12,
                R.id.imageButton13,R.id.imageButton14,R.id.imageButton15,R.id.imageButton16,
                R.id.imageButton17,R.id.imageButton18,R.id.imageButton19,R.id.imageButton20,/*, ... add more card buttons if needed */};

        // Assuming you have an array of ImageButton IDs representing your cards
        for (int cardButtonId : cardButtonIds) {
            ImageButton cardButton = findViewById(cardButtonId);
            cardButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onCardClick((ImageButton) v);
                }
            });
        }
    }

    public void onCardClick(ImageButton cardButton) {
        // Set the image for the clicked card to reveal the picture
        for (int i = 0; i < 20; i++)
         if (cards.get(i).getId()==cardButton.getId()) {
             animateCardTurn(cardButton);

             cardButton.setImageResource(cards.get(i).getPictureId());
                 if(isOpen) {
                     if (cards.get(i).getPictureId() == cards.get(lastId).getPictureId()) {
                         lastImageButton.setEnabled(false);
                         cardButton.setEnabled(false);
                     }
                    else
                     {
                         final int currentI = i;
                         cardButton.setImageResource(cards.get(i).getPictureId());

                         // Introduce a 5-second delay
                         Handler handler = new Handler();
                         handler.postDelayed(new Runnable() {
                             @Override
                             public void run() {
                                 // Code to be executed after a 5-second delay
                                 lastImageButton.setImageResource(R.drawable.cardback);
                                 cardButton.setImageResource(R.drawable.cardback);
                                 lastImageButton = cardButton;
                                 lastId = currentI;
                             }
                         }, 1000);
                     }
                     isOpen = false;
                 }
                 else {
                     lastImageButton=cardButton;
                     lastId=i;
                     isOpen = true;
                 }
         }

        // Replace 'picture' with the actual image resource
    }

    // Other methods and classes...
}


