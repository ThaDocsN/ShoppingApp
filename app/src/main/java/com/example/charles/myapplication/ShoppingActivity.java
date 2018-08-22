package com.example.charles.myapplication;

import android.support.annotation.LayoutRes;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageButton;

public class ShoppingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        setupAnimations();
    }
    private void setupAnimations(){
       final Button askSize = findViewById(R.id.askSize);
       final ImageButton close = findViewById(R.id.close);

       close.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               updateConstraints(R.layout.activity_shopping);
               askSize.setText("SELECT SIZE");
           }
       });

askSize.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        updateConstraints(R.layout.activity_shopping_alt);
        askSize.setText("ADD TO CART - 1234 INR");
    }
});

    }
    private void updateConstraints(@LayoutRes  int layoutId ){
        ConstraintSet constraintSet1 = new ConstraintSet();
        final ConstraintLayout mcon = findViewById(R.id.shoppingRoot);
        constraintSet1.clone(this, layoutId);
        constraintSet1.applyTo(mcon);
        ChangeBounds cb = new ChangeBounds();
        cb.setInterpolator(new OvershootInterpolator());
        TransitionManager.beginDelayedTransition(mcon,cb);
    }
}
