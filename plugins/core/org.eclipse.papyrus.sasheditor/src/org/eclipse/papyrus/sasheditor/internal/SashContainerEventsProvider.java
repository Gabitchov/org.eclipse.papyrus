/**
 * 
 */
package org.eclipse.papyrus.sasheditor.internal;

import java.util.ArrayList;
import java.util.List;


/**
 * A class managing events of the {@link SashWindowsContainer}.
 * This class dispatch events fired by the {@link SashWindowsContainer} to any listeners
 * implementing {@link SashContainerEventsProvider}.
 * 
 * @author cedric dumoulin
 *
 */
public class SashContainerEventsProvider {

	/** List of listeners */
	private List<SashContainerEventsListener> listeners = new ArrayList<SashContainerEventsListener>();

	/**
	 * Add a listener on the activeEditorChange event.
	 * 
	 * @param listener
	 */
	public void addListener(SashContainerEventsListener listener) {
		// no duplicate
		if(listeners.contains(listener))
			return;
		listeners.add(listener);
	}

	/**
	 * Add a listener on the activeEditorChange event.
	 * 
	 * @param listener
	 */
	public void removeListener(SashContainerEventsListener listener) {
		listeners.remove(listener);
	}


	/**
	 * Notify all listener with event.
	 * @param newEditor
	 */
	public void firePageOpenedEvent(PagePart page) {
		// Fire events to internal listeners
		for(SashContainerEventsListener listener : listeners) {
			listener.pageOpened(page);
		}
	}

	/**
	 * Notify all listener with event.
	 * @param newEditor
	 */
	public void firePageClosedEvent(PagePart page) {
		// Fire events to internal listeners
		for(SashContainerEventsListener listener : listeners) {
			listener.pageClosed(page);
		}
	}

	/**
	 * Notify all listener with event.
	 * @param newEditor
	 */
	public void firePageAboutToBeOpenedEvent(PagePart page) {
		// Fire events to internal listeners
		for(SashContainerEventsListener listener : listeners) {
			listener.pageAboutToBeOpened(page);
		}
	}

	/**
	 * Notify all listener with event.
	 * @param newEditor
	 */
	public void firePageAboutToBeClosedEvent(PagePart page) {
		// Fire events to internal listeners
		for(SashContainerEventsListener listener : listeners) {
			listener.pageAboutToBeClosed(page);
		}
	}

	/**
	 * Notify all listener with event.
	 * @param newEditor
	 */
	public void firePageActivatedEvent(PagePart page) {
		// Fire events to internal listeners
		for(SashContainerEventsListener listener : listeners) {
			listener.pageActivated(page);
		}
	}

	/**
	 * Notify all listener with event.
	 * @param newEditor
	 */
	public void firePageDeactivatedEvent(PagePart page) {
		// Fire events to internal listeners
		for(SashContainerEventsListener listener : listeners) {
			listener.pageDeactivated(page);
		}
	}

}
