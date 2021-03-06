package com.hackdtu.healthhistory.model;

import android.widget.ImageView;
import android.widget.TextView;

import com.hackdtu.healthhistory.R;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

/**
 * Created by Nimit Agg on 11-02-2017.
 */

@NonReusable
@Layout(R.layout.drawer_header)
public class DrawerHeader {

    @View(R.id.profileImageView)
    private ImageView profileImage;

    @View(R.id.nameTxt)
    private TextView nameTxt;

    @View(R.id.emailTxt)
    private TextView emailTxt;

    @Resolve
    private void onResolved() {
        nameTxt.setText("Nimit Aggarwal");
        emailTxt.setText("nimitagg95@gmail.com");
    }
}