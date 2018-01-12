package pf.aqsa.com.retroo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.squareup.otto.Bus;

public class MainActivity extends AppCompatActivity {

    private Communicator communicator;
    private String username, password;
    private EditText usernameET, passwordET;
    private Button loginButtonPost, loginButtonGet;
    private TextView information, extraInformation;
    private final static String TAG = "MainActivity";
    public static Bus bus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        communicator = new Communicator();

        usernameET = (EditText)findViewById(R.id.usernameInput);
        passwordET = (EditText)findViewById(R.id.passwordInput);
        //This is used to hide the password's EditText characters. So we can avoid the different hint font.
        passwordET.setTransformationMethod(new PasswordTransformationMethod());

        loginButtonPost = (Button)findViewById(R.id.loginButtonPost);
        loginButtonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = usernameET.getText().toString();
                password = passwordET.getText().toString();
                usePost(username, password);
            }
        });

        loginButtonGet = (Button)findViewById(R.id.loginButtonGet);
        loginButtonGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = usernameET.getText().toString();
                password = passwordET.getText().toString();
                useGet(username, password);
            }
        });

        information = (TextView)findViewById(R.id.information);
        extraInformation = (TextView)findViewById(R.id.extraInformation);
    }

    private void usePost(String username, String password){
        communicator.loginPost(username, password);
    }

    private void useGet(String username, String password){
        communicator.loginGet(username, password);
    }



    }

