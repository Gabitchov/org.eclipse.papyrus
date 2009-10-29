package org.eclipse.papyrus.sasheditor.contentprovider;

/**
 * Interface implemented by classes firing events when the ContentProvider content change. This
 * interface can be used by client of ContentProvider. It is not use directly by the SashSystem.
 * 
 * @author dumoulin
 */
public interface IContentChangedProvider {

	/**
	 * Add a listener listening on content changed. This listener will be notified each time the
	 * content change.
	 * 
	 * @param listener
	 */
	public abstract void addContentChangedListener(IContentChangedListener listener);

	/**
	 * Add a listener listening on content changed. This listener will be notified each time the
	 * content change.
	 * 
	 * @param listener
	 */
	public abstract void removeContentChangedListener(IContentChangedListener listener);

}