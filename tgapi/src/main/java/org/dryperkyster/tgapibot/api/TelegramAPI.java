package org.dryperkyster.tgapibot.api;

import android.app.Activity;

public class TelegramAPI
{

	/*
	 * General headers
	 * param @ mApiKey = Bot's key - You can find in @BotFather
	 * param @ mChatUd = Chat id, use MissRose or custom client to get id
	 * param @ mBotUrl = Not a general function for user
	 */

	private static String mApiKey = null;
	private static Integer mChatId = null;
	private static String mBotUrl = "https://api.telegram.org/bot" + mApiKey + "/sendMessage";
	private Activity mActivity;

	public TelegramAPI(String mApiKey, Integer mChatId, Activity mActivity)
	{
		this.mApiKey = mApiKey;
		this.mChatId = mChatId;
		this.mActivity = mActivity;

		if (mApiKey.equals(null) || mApiKey.equals(""))
		{
			throw new NullPointerException("mTelegramLib: Api key null or empty, fix that!");
		}

		if (mChatId.equals(null) || mChatId.equals(""))
		{
			throw new NullPointerException("mTelegramLib: Chat id null or empty, fix that!");
		}
	}

	public Activity getActivity()
	{
		return this.mActivity;
	}
}
