/**
 * 
 */
package org.eclipse.papyrus.core.lifecycleevents;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.papyrus.core.lifecycleevents.DoSaveEvent;
import org.eclipse.papyrus.core.lifecycleevents.ISaveEventListener;


/**
 * @author dumoulin
 *
 */
public class FakeSaveEventListener implements ISaveEventListener {

	List<DoSaveEvent> receivedEvents = new ArrayList<DoSaveEvent>();
	
	/**
	 * @see org.eclipse.papyrus.core.lifecycleevents.ISaveEventListener#doSave(org.eclipse.papyrus.core.lifecycleevents.DoSaveEvent)
	 *
	 * @param event
	 */
	public void doSave(DoSaveEvent event) {
		receivedEvents.add(event);

	}

	/**
	 * @see org.eclipse.papyrus.core.lifecycleevents.ISaveEventListener#doSaveAs(org.eclipse.papyrus.core.lifecycleevents.DoSaveEvent)
	 *
	 * @param event
	 */
	public void doSaveAs(DoSaveEvent event) {
		receivedEvents.add(event);

	}

	/**
	 * Return true if the event has been received.
	 * @param event
	 * @return
	 */
	public boolean isEventReceived(DoSaveEvent event) {
		return receivedEvents.contains(event);
	}

	
	/**
	 * @return the receivedEvents
	 */
	public List<DoSaveEvent> getReceivedEvents() {
		return receivedEvents;
	}

}
