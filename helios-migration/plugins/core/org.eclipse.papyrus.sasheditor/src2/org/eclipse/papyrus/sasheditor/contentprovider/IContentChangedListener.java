/**
 * 
 */
package org.eclipse.papyrus.sasheditor.contentprovider;


/**
 * Interface to be implemented by classes needing to be notified
 * when the SashContent model has changed.
 * This interface is not used by the sashesWindows itself. It exists to allows ContentProvider
 * implementation to provide a common notification mechanism.
 * 
 * @author dumoulin
 */
public interface IContentChangedListener {

	/**
	 * Event indicating the change.
	 * TODO The types are not set correctly from user like DI model. But anyway there aren't used by clients.
	 * 
	 * @author dumoulin
	 */
	public class ContentEvent {

		public static final int ADDED = 0;

		public static final int REMOVED = 1;

		public static final int CHANGED = 2;

		public static final int MOVED = 3;

		/** type of event */
		private int type;

		/** model to which the event apply */
		private Object model;

		/** object added or removed or modified */
		private Object object;

		/**
		 * @param type
		 * @param model
		 * @param object
		 */
		public ContentEvent(int type, Object model, Object object) {
			this.type = type;
			this.model = model;
			this.object = object;
		}


		/**
		 * @return the type
		 */
		public int getType() {
			return type;
		}


		/**
		 * @return the model
		 */
		public Object getModel() {
			return model;
		}


		/**
		 * @return the object
		 */
		public Object getObject() {
			return object;
		}

	}

	/**
	 * Method called when the content has changed.
	 */
	public void contentChanged(ContentEvent event);
}
