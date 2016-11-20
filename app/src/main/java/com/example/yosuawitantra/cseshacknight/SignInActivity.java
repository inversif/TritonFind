package com.example.yosuawitantra.cseshacknight;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

/* Google imports */
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

public class SignInActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener,
        View.OnClickListener {

    /* Google API Client */
    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );

        /* remove title bar */
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        /* set the Google Sign-in options to request email */
        GoogleSignInOptions GSO = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        /* build the Google API client */
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, GSO)
                .build();

        /* listen for the button click */
        findViewById(R.id.signButton).setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onClick(View v) {
        switch( v.getId() ) {
            case R.id.signButton:
                signin();
                break;
        }
    }

    private void signin() {
        /* create an intent for the user to sign in */
        Intent signinIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signinIntent, 9001);
    }

    @Override
    protected void onActivityResult( int requestCode, int resultCode, Intent data ) {
        super.onActivityResult(requestCode, resultCode, data);

        /* call for Google to attempt to sign in and return the result */
        if ( requestCode == 9001 ) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    private void handleSignInResult( GoogleSignInResult result ) {
        /* if the user was able to log in */
        if ( result.isSuccess() ) {
            /* get a handle of the user account */
            GoogleSignInAccount account = result.getSignInAccount();

            /* set the main app user */
            //mApplication.setUser( new User( account.getDisplayName(), account.getEmail() ) );
            //mApplication.setLoggedIn(true);

            Intent mainActivityIntent = new Intent(getApplication(), MainActivity.class);
            mainActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(mainActivityIntent);
        }
        else {
            /* if the login was not successful do nothing */
        }
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        /* do nothing on connection failure */
    }
}
