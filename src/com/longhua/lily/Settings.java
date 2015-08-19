package com.longhua.lily;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class Settings {
	private static Settings self = null;
	private final static String SETTINGS_FILE = "settings.xml";
//	private final static String KEY_SERVER_URL = "server_url";
	private final static String KEY_USERNAME = "username";
	private final static String KEY_PASSWORD = "password";
	private boolean loaded;
	
//	private String serverUrl;
	private String serverAddress;
	private String userName;
	private String password;
	
	//RAM contents
	private int userId;

	// generate private constructor.
	private Settings() {
	}
	
	public static Settings instance() {
		if (self == null) {
			self = new Settings();
		}
		return self;
	}
	
	
	// load contents from SharedPreferences.
	public void load(Context context) {
		if (!loaded) {
			SharedPreferences preferences = context.getSharedPreferences(SETTINGS_FILE, Context.MODE_PRIVATE);
//			setServerUrl(preferences.getString(KEY_SERVER_URL, ""));
			userName = preferences.getString(KEY_USERNAME, "");
			password = preferences.getString(KEY_PASSWORD, "");
			loaded = true;
		}
	}

	// save contents from SharedPreferences.
	public void save(Context context) {
		SharedPreferences preferences = context.getSharedPreferences(SETTINGS_FILE, Context.MODE_PRIVATE);
		Editor editor = preferences.edit();
//		editor.putString(KEY_SERVER_URL, serverUrl);
		editor.putString(KEY_USERNAME, userName);
		editor.putString(KEY_PASSWORD, password);
		editor.commit();
	}
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public String getServerUrl() {
//		return serverUrl;
//	}
//
//	public void setServerUrl(String serverUrl) {
//		this.serverUrl = serverUrl;
//	}

	public String getServerAddress() {
		return serverAddress;
	}

	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
