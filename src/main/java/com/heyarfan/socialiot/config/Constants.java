package com.heyarfan.socialiot.config;

import java.util.Random;

public class Constants {
	public static final int PAGE_SIZE = 10;
	
	public static final int TOP_UPDATE_TABLE_LIMIT = 50;
	
	
	public static final String DATE_FORMAT = "yyyy-MM-dd-HH:mm:ss";
	
	
	
	
	public static final String CRICKET_API_ACCESS_TOKEN_IDENTIFIER = "session_access_token";
	
	public static final String CRICKET_API_ACCESS_TOKEN_EXPIRE_IDENTIFIER = "session_access_token_expire";
	
	public static final String CRICKET_CACHE_KEY_IDENTIFIER = "session_cache_key";
	
	public static final String CRICKET_API_BASE = "https://rest.cricketapi.com/rest/v2/";
	
	
	
	public static String randomMACAddress(){
	    Random rand = new Random();
	    byte[] macAddr = new byte[6];
	    rand.nextBytes(macAddr);

	    macAddr[0] = (byte)(macAddr[0] & (byte)254);  //zeroing last 2 bytes to make it unicast and locally adminstrated

	    StringBuilder sb = new StringBuilder(18);
	    for(byte b : macAddr){

	        if(sb.length() > 0)
	            sb.append(":");

	        sb.append(String.format("%02x", b));
	    }


	    return sb.toString();
	}
}
