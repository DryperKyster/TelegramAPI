package br.com.vevelo.telegramapi.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.dryperkyster.tgapibot.api.TelegramAPI;

import br.com.vevelo.telegramapi.R;

public class MainActivity extends Activity {

    public EditText mEtToken;
    public EditText mEtChatId;
    public EditText mEtMessage;

    public Button mSendButton;

    public TelegramAPI tgApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idLoad();
    }

    private void idLoad() {
        mEtToken = findViewById(R.id.mEtToken);
        mEtChatId = findViewById(R.id.mEtChatId);
        mEtMessage = findViewById(R.id.mEtMessage);
        mSendButton = findViewById(R.id.mSendButton);
        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
