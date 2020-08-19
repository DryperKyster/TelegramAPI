package org.dryperkyster.tgapibot.api;

public class TelegramAPI
{
	
	/*
	 * General headers
	 * param @ mApiKey = Bot's key - You can find in @BotFather
	 * param @ mChatUd = Chat id, use MissRose or custom client to get id
	 * param @ mBotUrl = Not a general function for user
	 */
	 
	private static String mApiKey = null;
	private static String mChatId = null;
	private static String mBotUrl = "https://api.telegram.org/bot" + mApiKey + "/sendMessage";
	 
	
	public TelegramAPI(String mApiKey, String mChatId) {
		this.mApiKey = mApiKey;
		this.mChatId = mChatId;
	}
	
}
