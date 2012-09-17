/**
 * 
 */
package org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IContentChangedListener;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IContentChangedListener.ContentEvent;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IContentChangedProvider;
import org.eclipse.papyrus.infra.core.sashwindows.di.AbstractPanel;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashModel;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;
import org.eclipse.papyrus.infra.core.sashwindows.di.Window;


/**
 * A class listening on changes on the internal model and delivering events to registered listeners.
 * 
 * @author cedric dumoulin
 *
 */
public class ContentChangedEventProvider implements IContentChangedProvider {
	
	private List<IContentChangedListener> listeners;

	/** Is this mngr delivering events ? */
	private boolean isDeliverEnable = true;

	/** Last event stored when isDeliverEnable == false; */
	private ContentEvent storedEvent;

	private EMFAdapter emfAdapter = new EMFAdapter();

	/**
	 * The model firing events
	 */
	private SashModel diSashModel;
	
	/**
	 * 
	 * Constructor.
	 *
	 * @param diSashModel
	 */
	public ContentChangedEventProvider(SashModel diSashModel) {
		this.diSashModel = diSashModel;
		activate();
	}
	
	/**
	 * 
	 * Constructor.
	 *
	 * @param diSashModel
	 */
	public ContentChangedEventProvider(SashWindowsMngr sashWindowMngr) {
		this(sashWindowMngr.getSashModel());
	}
	
	/**
	 * Connect EMF changeListener to the {@link ContentChangeListenerManager}.
	 * Changes in the EMF di model will be fired by the ContentChangeListenerManager.
	 */
	protected void activate() {
		diSashModel.eAdapters().add(emfAdapter);
		setDeliver(true);
	}

	protected void deactivate() {
		setDeliver(false);
		diSashModel.eAdapters().remove(emfAdapter);
	}

	/**
	 * @return the isDeliverEnable
	 */
	protected boolean isDeliver() {
		return isDeliverEnable;
	}

	/**
	 * @param isDeliverEnable
	 *        the isDeliverEnable to set
	 */
	protected void setDeliver(boolean isDeliverEnable) {

		if(this.isDeliverEnable == isDeliverEnable)
			return;

		// Check if the old value is not delivering event
		if(!this.isDeliverEnable) {
			this.isDeliverEnable = true;
			// reenable events. Check if an event is stored
			if(storedEvent != null)
				fireContentChanged(storedEvent);

		} else
			this.isDeliverEnable = isDeliverEnable;

		storedEvent = null;
	}

	/**
	 * Add a listener listening on content changed. This listener will be
	 * notified each time the content change.
	 * 
	 * @param listener
	 */
	public void addListener(IContentChangedListener listener) {
		if(listeners == null)
			createListeners();

		// Check if already exists.
		if(listeners.contains(listener))
			return;

		listeners.add(listener);
	}

	/**
	 * Add a listener listening on content changed. This listener will be
	 * notified each time the content change.
	 * 
	 * @param listener
	 */
	public void removeListener(IContentChangedListener listener) {
		if(listeners == null)
			return;

		listeners.remove(listener);
	}

	/**
	 * Create the list of listeners.
	 */
	private void createListeners() {
		if(listeners == null)
			listeners = new ArrayList<IContentChangedListener>();

	}

	/**
	 * Fire the changed event.
	 * 
	 * @param event
	 */
	protected void fireContentChanged(ContentEvent event) {
		if(listeners == null)
			return;

		if(!isDeliverEnable) {
			storedEvent = event;
			return;
		}

		for(IContentChangedListener listener : listeners) {
			listener.contentChanged(event);
		}
	}

	/**
	 * Change event Adapter.
	 * Forward EMF changeEvent to the {@link ContentChangeListenerManager}.
	 * 
	 * @author cedric dumoulin
	 */
	public class EMFAdapter extends EContentAdapter {

		/**
		 * ContentProvider Model has changed.
		 * Changes includes : ADD, REMOVE and MOVE of elements
		 * 
		 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
		 * 
		 * @param msg
		 */
		@Override
		public void notifyChanged(Notification msg) {
			super.notifyChanged(msg);

			// Filter out notification of type RESOLVE
			// We don't need to be noti
			if(msg.getEventType() == Notification.RESOLVE)
				return;

			// W
			Object sender = msg.getNotifier();
			if(sender instanceof AbstractPanel || sender instanceof Window || sender instanceof PageRef)
				fireContentChanged(new ContentEvent(msg.getEventType(), sender, null));
		}
	}

}
