package org.telosys.saas.websocket.scan;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.util.Set;

import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;

public class ScanEventHandler {
	
	private ScanSessionStore scanSessionStore = ScanSessionStore.getInstance();
	
	public void event(Path path, WatchEvent event) {
		System.out.println("Event: "+event+", path: "+path);
		
		if(path.toFile().isDirectory()) {
			eventForFolder(path, path, event);
		}
		if(path.toFile().isFile()) {
			eventForFolder(path, path.getParent(), event);
		}
	}
	
	protected void eventForFolder(Path path, Path folder, WatchEvent event) {
		if(folder == null) {
			return;
		}
		
		Set<Session> sessions = scanSessionStore.getSessionsForFolder(folder.toString());
		if(sessions != null) {
			for(Session session : sessions) {
				if(session.isOpen()) {
					try {
						final RemoteEndpoint.Basic remote = session.getBasicRemote();
			            remote.sendText(path.toString().substring(folder.toString().length()+1));
					} catch (IOException e) {
						throw new IllegalStateException(e);
					}
				}
			}
		}
		
		eventForFolder(path, folder.getParent(), event);
	}
	
}
