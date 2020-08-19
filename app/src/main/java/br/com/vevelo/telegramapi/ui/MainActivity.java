package br.com.vevelo.telegramapi.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.dryperkyster.tgapibot.api.TelegramAPI;
import org.dryperkyster.tgapibot.network.RequestNetwork;

import br.com.vevelo.telegramapi.R;

public class MainActivity extends Activity {

    public EditText mEtToken;
    public EditText mEtChatId;
    public EditText mEtMessage;

    public Button mSendButton;

    public TelegramAPI tgApi;
    private RequestNetwork.RequestListener RKListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idLoad();
    }

    public void idLoad() {
        mEtToken = findViewById(R.id.mEtToken);
        mEtChatId = findViewById(R.id.mEtChatId);
        mEtMessage = findViewById(R.id.mEtMessage);
        mSendButton = findViewById(R.id.mSendButton);
        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tgApi = new TelegramAPI(MainActivity.this);
                RKListener = new RequestNetwork.RequestListener() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MainActivity.this, "Code: " + "https://api.telegram.org/bot" + mEtToken.getText().toString() + "/sendMessage" + "\n \n" + response, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onErrorResponse(String message) {
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                    }
                };
                tgApi.sendMessage(mEtToken.getText().toString(), mEtChatId.getText().toString(), mEtMessage.getText().toString(), RKListener, true);
            }
        });
    }
}
