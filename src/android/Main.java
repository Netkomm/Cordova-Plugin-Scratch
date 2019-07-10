package com.hitmacreed.plugin;
   
import android.content.Context;
import android.content.Intent;
   
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;
   
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;
   
public class Main extends CordovaPlugin {

    String toastMessage;
    String scratchCard;
    String scratchTitle;
    String scratchedCard;
    String backgroundContainer;
    String scratchTitleColor;
   
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }
   
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Context context = cordova.getActivity().getApplicationContext();

        try {
            JSONObject options = args.getJSONObject(0);

            //TOAST MESSAGE ON REVEAL
            toastMessage = options.getString("toastMessage");

            scratchCard = options.getString("scratchCard");

            scratchedCard = options.getString("scratchedCard");

            scratchTitle = options.getString("scratchTitle");

            scratchTitleColor = options.getString("scratchTitleColor");

            backgroundContainer = options.getString("backgroundContainer");


        } catch (JSONException e) {
            callbackContext.error("Error encountered: " + e.getMessage());
            return false;
        }
        
        if(action.equals("draw")) {
                       
            this.openNewActivity(context);
            return true;
        }
        return false;

    }
   
    private void openNewActivity(Context context) {

        Intent intent = new Intent(context, Scratch.class);
        intent.putExtra("message_ID", toastMessage);
        intent.putExtra("scratchCard_ID", scratchCard);
        intent.putExtra("scratchTitle_ID", scratchTitle);
        intent.putExtra("scratchedCard_ID", scratchedCard);
        intent.putExtra("backgroundContainer_ID", backgroundContainer);
        intent.putExtra("scratchTitleColor_ID",scratchTitleColor);
        this.cordova.getActivity().startActivity(intent);
    }
}