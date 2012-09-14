/**
 * 
 */
package org.eclipse.papyrus.infra.core.lifecycleevents;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides events about the life cycle of a MultiEditor. Not all
 * life cycle events are available. Available events:
 * <ul>
 * <li>aboutToDoSave, aboutToDoSaveAs - SaveEventListener</li>
 * <li>doSave, doSaveAs - SaveEventListener</li>
 * <li>afterDoSave, afterDoSaveAs - SaveEventListener</li>
 * <li></li>
 * <li></li>
 * </ul>
 * 
 * 
 * @author cedric dumoulin
 * 
 */
public class LifeCycleEventsProvider implements ILifeCycleEventsProvider {

	/**
	 * 
	 */
	protected SaveEventListenerLazyList preSaveListeners = new SaveEventListenerLazyList();

	/**
	 * 
	 */
	protected SaveEventListenerLazyList saveListeners = new SaveEventListenerLazyList();

	/**
	 * 
	 */
	protected SaveEventListenerLazyList postSaveListeners = new SaveEventListenerLazyList();

	/**
	 * Add specified listener.
	 * 
	 * @param listener
	 */
	public void addDoSaveListener(ISaveEventListener listener) {

		saveListeners.addListener(listener);
	}

	/**
	 * Remove specified listener.
	 * 
	 * @param listener
	 */
	public void removeDoSaveListener(ISaveEventListener listener) {
		saveListeners.removeListener(listener);
	}

	/**
	 * Add specified listener.
	 * 
	 * @param listener
	 */
	public void addAboutToDoSaveListener(ISaveEventListener listener) {

		preSaveListeners.addListener(listener);
	}

	/**
	 * Remove specified listener.
	 * 
	 * @param listener
	 */
	public void removeAboutToDoSaveListener(ISaveEventListener listener) {
		preSaveListeners.removeListener(listener);
	}

	/**
	 * Add specified listener.
	 * 
	 * @param listener
	 */
	public void addPostDoSaveListener(ISaveEventListener listener) {

		postSaveListeners.addListener(listener);
	}

	/**
	 * Remove specified listener.
	 * 
	 * @param listener
	 */
	public void removePostDoSaveListener(ISaveEventListener listener) {
		postSaveListeners.removeListener(listener);
	}

	// ****************************************************** //
	// Fire events methods //
	// ****************************************************** //

	/**
	 * Fire AboutToSaveEvent to registered Listeners.
	 * 
	 * @param editorPart
	 */
	public void fireAboutToDoSaveEvent(DoSaveEvent event) {
		preSaveListeners.fireSaveEvent(event);
	}

	/**
	 * Fire AboutToSaveAs to registered Listeners.
	 * 
	 * @param editorPart
	 */
	public void fireAboutToDoSaveAsEvent(DoSaveEvent event) {
		preSaveListeners.fireSaveAsEvent(event);
	}

	/**
	 * Fire AboutToSaveEvent to registered Listeners.
	 * 
	 * @param editorPart
	 */
	public void fireDoSaveEvent(DoSaveEvent event) {
		saveListeners.fireSaveEvent(event);
	}

	/**
	 * Fire AboutToSaveAs to registered Listeners.
	 * 
	 * @param editorPart
	 */
	public void fireDoSaveAsEvent(DoSaveEvent event) {
		saveListeners.fireSaveAsEvent(event);
	}

	/**
	 * Fire AboutToSaveEvent to registered Listeners.
	 * 
	 * @param editorPart
	 */
	public void firePostDoSaveEvent(DoSaveEvent event) {
		postSaveListeners.fireSaveEvent(event);
	}

	/**
	 * Fire AboutToSaveAs to registered Listeners.
	 * 
	 * @param editorPart
	 */
	public void firePostDoSaveAsEvent(DoSaveEvent event) {
		postSaveListeners.fireSaveAsEvent(event);
	}

	/**
	 * Fire all Save events (about, events, post) to registered Listeners.
	 * Exceptions from listeners are propagated and stop the event chain.
	 * 
	 * @param editorPart
	 */
	public void fireAllDoSaveEvent(DoSaveEvent event) {
		fireAboutToDoSaveEvent(event);
		fireDoSaveEvent(event);
		firePostDoSaveEvent(event);
	}

	/**
	 * Fire all SaveAs events (about, events, post) to registered Listeners. If
	 * one of the saveAs event fail, post events are not sent.
	 * 
	 * @param editorPart
	 */
	public void fireAllDoSaveAsEvent(DoSaveEvent event) {
		fireAboutToDoSaveAsEvent(event);
		fireDoSaveAsEvent(event);
		firePostDoSaveAsEvent(event);
	}

	/**
	 * Base class encapsulating a lazy creation list.
	 * 
	 * @author cedric dumoulin
	 * 
	 * @param <T>
	 */
	abstract protected class AbstractEventListenersLazyList<T> {

		List<T> listeners;

		/**
		 * Add specified listener.
		 * 
		 * @param listener
		 */
		public void addListener(T listener) {
			// Lazy creation
			if(listeners == null)
				listeners = new ArrayList<T>();

			// do not add if already present.
			if(listeners.contains(listener))
				return;

			listeners.add(listener);
		}

		/**
		 * Remove specified listener.
		 * 
		 * @param listener
		 */
		public void removeListener(T listener) {
			// Lazy creation
			if(listeners == null)
				return;

			listeners.remove(listener);
		}

		/**
		 * @return the listeners
		 */
		protected List<T> getListeners() {
			return listeners;
		}

		/**
		 * Remove all listeners.
		 */
		protected void clear() {
			if (listeners != null) {
				listeners.clear();
			}
		}
	}

	/**
	 * List of {@link ISaveEventListener}.
	 * 
	 * @author cedric dumoulin
	 * 
	 */
	protected class SaveEventListenerLazyList extends AbstractEventListenersLazyList<ISaveEventListener> {

		/**
		 * Fire OpenEvent to registered Listeners. If a listener throw an
		 * exception, remaining listeners are called, and then the exception is
		 * resent.
		 * 
		 * @param editorPart
		 */
		public void fireSaveEvent(DoSaveEvent event) {
			// Lazy creation
			if(listeners == null)
				return;

			for(ISaveEventListener listener : listeners) {
				listener.doSave(event);
			}
		}

		/**
		 * Fire OpenEvent to registered Listeners.
		 * 
		 * @param editorPart
		 */
		public void fireSaveAsEvent(DoSaveEvent event) {
			// Lazy creation
			if(listeners == null)
				return;

			for(ISaveEventListener listener : listeners) {
				listener.doSaveAs(event);
			}

		}

	}
}
