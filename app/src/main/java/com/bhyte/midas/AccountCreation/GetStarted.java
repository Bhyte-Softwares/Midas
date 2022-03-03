package com.bhyte.midas.AccountCreation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bhyte.midas.Common.AcceptTermsOfService;
import com.bhyte.midas.Common.MainDashboard;
import com.bhyte.midas.Common.NoInternet;
import com.bhyte.midas.R;
import com.bhyte.midas.User.VirtualCardDetails;

public class GetStarted extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);
    }

    public void callSignUpEnterNumber(View view) {
        startActivity(new Intent(getApplicationContext(), SignUpEnterNumber.class));
    }

    public void callAcceptTerms(View view) {
        startActivity(new Intent(getApplicationContext(), NoInternet.class));
    }

    public void callSignIn(View view) {
        startActivity(new Intent(getApplicationContext(), SignIn.class));
    }
}