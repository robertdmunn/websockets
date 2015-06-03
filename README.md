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
   
For an example of how and why you would implement the websocket client in a CFML app, see the Coldboxing app (https://github.com/robertdmunn/coldboxing).
The client is called in /model/logging/WebSocketAppender.cfc.

**Implementation**

Load the Java class via Javaloader. You need java_websocket.jar (contained in the /lib folder in this project).

    var paths = arraynew(1);
    paths[1]= expandpath("/includes/java/java_websocket.jar");
    paths[2]= expandpath("/includes/java/com.bonnydoonmedia.io.jar");
    var uri = createObject( "java", "java.net.URI" ).init( "ws://" & getProperty("host") & ":" & getProperty("port") );
    javaloader = createObject('component',"javaloader.JavaLoader").init(paths);
    ws = javaloader.create( "com.bonnydoonmedia.io.WSClient" ).init( uri );

    try{
        ws.connect();
    }
    catch(Any e){
        throw(message="Error opening socket to #getProperty("host")#:#getProperty("port")#",
        detail=e.message & e.detail & e.stacktrace,
        type="ConnectionException");
    }
    
    entry = "Some message.";
    
    ws.send( entry );
    
    ws.close();
