package org.eclipse.papyrus.core.extension.diagrameditor;


public interface IEditorDescriptor {

	/**
	 * to obtain the requestedContextId
	 * 
	 * @return the requestedContextId
	 */
	public String getRequestedContextId();

	/**
	 * @return the actionBarContributorId
	 */
	public String getActionBarContributorId();


}
