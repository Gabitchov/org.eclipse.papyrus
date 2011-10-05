/**
 * 
 */
package org.eclipse.papyrus.core.lifecycleevents;



/**
 * Concrete implementation of this interface allows to listen on various lifecycle events.
 * This interface is the "public" part of the {@link LifeCycleEventsProvider}.
 * 
 * @author cedric dumoulin
 *
 */
public interface ILifeCycleEventsProvider {

	/**
	 * Add specified listener.
	 * 
	 * @param listener
	 */
	public void addDoSaveListener(ISaveEventListener listener);

	/**
	 * Remove specified listener.
	 * 
	 * @param listener
	 */
	public void removeDoSaveListener(ISaveEventListener listener);

	/**
	 * Add specified listener.
	 * 
	 * @param listener
	 */
	public void addAboutToDoSaveListener(ISaveEventListener listener);

	/**
	 * Remove specified listener.
	 * 
	 * @param listener
	 */
	public void removeAboutToDoSaveListener(ISaveEventListener listener);

	/**
	 * Add specified listener.
	 * 
	 * @param listener
	 */
	public void addPostDoSaveListener(ISaveEventListener listener);

	/**
	 * Remove specified listener.
	 * 
	 * @param listener
	 */
	public void removePostDoSaveListener(ISaveEventListener listener);

}
