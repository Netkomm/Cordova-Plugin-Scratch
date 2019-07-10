package com.hitmacreed.plugin;

//Native apis
import android.widget.Toast;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.Window;
import android.graphics.Color;
import android.util.Log;
import android.widget.RelativeLayout;

//ScratchImageView
import com.goibibo.libs.views.ScratchRelativeLayoutView;

//Picasso
import com.squareup.picasso.Picasso;

public class Scratch extends Activity {
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        String package_name = getApplication().getPackageName();

        // Hide ActionBar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(getApplication().getResources().getIdentifier("activity_scratch", "layout", package_name));

        String toastMessage = getIntent().getStringExtra("message_ID");
       
        ScratchRelativeLayoutView scratchRelativeLayoutView = findViewById(getApplication().getResources().getIdentifier("scratch_card", "id", package_name));

        scratchRelativeLayoutView.setStrokeWidth(25);

        scratchRelativeLayoutView.setScratchView(getApplication().getResources().getIdentifier("lyt_scratch", "layout", package_name));

        scratchRelativeLayoutView.setRevealListener(new ScratchRelativeLayoutView.IRevealListener() {

            @Override
            public void onRevealed(ScratchRelativeLayoutView tv) {
                // on reveal
                Toast.makeText(Scratch.this, toastMessage, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onRevealPercentChangedListener(ScratchRelativeLayoutView siv, float percent) {
                // on percent change
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        String package_name = getApplication().getPackageName();

        // BEFORE SCRATCH

        String scratchCard = getIntent().getStringExtra("scratchCard_ID");

        ImageView beforeScratch = (ImageView) findViewById(getApplication().getResources().getIdentifier("img_before_scratch", "id", package_name));
       
        int before = getApplication().getResources().getIdentifier(scratchCard, null, package_name);

        Drawable res_before = ContextCompat.getDrawable(this, before);

        beforeScratch.setImageDrawable(res_before);


        // AFTER SCRATCHED THE CARD

        String scratchedCard = getIntent().getStringExtra("scratchedCard_ID");

        ImageView afterScratch = (ImageView) findViewById(getApplication().getResources().getIdentifier("img_after_scratch", "id", package_name));

        if(scratchedCard.contains("http")) {
            Picasso.get().load(scratchedCard).resize(300, 300).centerCrop().into(afterScratch);
        }

        else{

        int after = getApplication().getResources().getIdentifier(scratchedCard, null, package_name);

        Drawable res_after = ContextCompat.getDrawable(this, after);

        afterScratch.setImageDrawable(res_after);

        }

        // scratchTitle 
        String scratchTitle = getIntent().getStringExtra("scratchTitle_ID");

        String scratchTitleColor = getIntent().getStringExtra("scratchTitleColor_ID");

        TextView txt = (TextView) findViewById(getApplication().getResources().getIdentifier("text_before_scratch", "id", package_name));

        txt.setText(scratchTitle);

        txt.setTextColor(Color.parseColor(scratchTitleColor));

        //Background Container

        String backgroundContainer = getIntent().getStringExtra("backgroundContainer_ID");

        RelativeLayout parent = (RelativeLayout) findViewById(getApplication().getResources().getIdentifier("parent", "id", package_name));

        int backs = getApplication().getResources().getIdentifier(backgroundContainer, null, package_name);

        Drawable res_backs = ContextCompat.getDrawable(this, backs);

        parent.setBackground(res_backs);

    }
}