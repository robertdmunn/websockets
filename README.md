# websocket-client
Simple Extension of websocket client by Too Tall Nate https://github.com/TooTallNate/Java-WebSocket

**What it is**

This project grew out of my need to implement a Websocket client in Lucee CFML Server (www.lucee.org). It implements a very basic Websocket client in Java.
This client is callable as a Java object in CFML from within Lucee. 

**Installation**

1. Download the zip file or "git clone" the repo from the links on the project homepage.

2. Build the project using Java, or just grab the com.bonnydoonmedia.io.jar file from the project root.

3. Put the jar (or .class if you want to deploy just WSClient.class ) file in your Web project. 

   - The easiest way to install it is to copy the jar file to a folder in your project, e.g. /includes/java (the Coldbox convention).
   
   - You can then call the file using Mark Mandel's Javaloader (https://github.com/markmandel/JavaLoader).
   
For an example of how and why you would implement the websocket client in a CFML app, see the Coldbox-sample app (https://github.com/robertdmunn/coldbox-sample).
The client is called in /model/logging/WebSocketAppender.cfc.
