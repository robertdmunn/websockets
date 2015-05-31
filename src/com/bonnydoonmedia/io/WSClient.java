package com.bonnydoonmedia.io;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_10;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

/*
 * author: Robert Munn
 * date: 3/15/15
 * 
 * WSClient.java
 * 
 * Simple extension of WebSocketClient by Too Tall Nate
 * 
 * based on example client at
 * 
 * https://github.com/TooTallNate/Java-WebSocket
 * 
 * License: Mozilla Public License 2.0
 * 
 */

public class WSClient extends WebSocketClient{

	public WSClient( URI serverUri , Draft_10 draft ) {
		super( serverUri, draft );
	}

	public WSClient( URI serverURI ) {
		super( serverURI );
	}
	
	public void connect(){
		super.connect();
	}
	
	public void send( String message ){
		super.send( message );
	}

	@Override
	public void onOpen( ServerHandshake handshakedata ) {
		System.out.println( "opened connection" );
		System.out.println( "ready state : " + super.getReadyState() );
		// if you plan to refuse connection based on ip or httpfields overload: onWebsocketHandshakeReceivedAsClient
	}

	@Override
	public void onMessage( String message ) {
		System.out.println( "received: " + message );
	}

	@Override
	public void onClose( int code, String reason, boolean remote ) {
		// The codecodes are documented in class org.java_websocket.framing.CloseFrame
		System.out.println( "Connection closed by " + ( remote ? "remote peer" : "us" ) );
	}

	@Override
	public void onError( Exception ex ) {
		ex.printStackTrace();
		// if the error is fatal then onClose will be called additionally
	}
}
