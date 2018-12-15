package com.servlet.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCounter_Listener implements HttpSessionListener {

	private static int totalActiveSessions;

	public static int getTotalActiveSession(){
		return totalActiveSessions;
	}

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		totalActiveSessions++;
		System.out.println("SessionCounter_Listener->sessionCreated...");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		totalActiveSessions--;
		System.out.println("SessionCounter_Listener->sessionDestroyed...");
	}


}
