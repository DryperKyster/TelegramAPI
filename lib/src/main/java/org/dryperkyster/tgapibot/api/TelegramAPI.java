package org.dryperkyster.tgapibot.api;

import android.app.Activity;

import org.dryperkyster.tgapibot.network.RequestNetwork;
import org.dryperkyster.tgapibot.network.RequestNetworkController;

import java.util.HashMap;

public class TelegramAPI {

    /*
     * General headers
     * param @ mApiKey = Bot's key - You can find in @BotFather
     * param @ mChatId = Chat id, use MissRose or custom client to get id
     * param @ mBotUrl = Not a general function for user
     */

    private final Activity mActivity;

    public TelegramAPI(Activity mActivity) {
        this.mActivity = mActivity;
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    public void sendMessage(String mApiKey, String mChatId, String textMessage, RequestNetwork.RequestListener mListener, Boolean mDisableWebPreview) {
        try {
            String mBotUrl = "https://api.telegram.org/bot" + mApiKey + "/sendMessage";

            HashMap<String, Object> map = new HashMap<>();
            map.put("chat_id", mChatId);
            map.put("text", textMessage);
            map.put("parse_mode", "markdown");
            map.put("disable_web_page_preview", mDisableWebPreview);

            RequestNetwork requestNetwork = new RequestNetwork(getActivity());
            requestNetwork.setParams(map, RequestNetworkController.REQUEST_PARAM);
            requestNetwork.startRequestNetwork(RequestNetworkController.POST, mBotUrl, mListener);
        } catch (NullPointerException e) {
            throw new NullPointerException("mTelegramLib: " + e);
        }
    }
}
