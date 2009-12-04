/**
 * 
 */
package org.eclipse.papyrus.sasheditor.editor;

import org.eclipse.papyrus.sasheditor.internal.SashWindowsContainer;


/**
 * A Visitor used to visit all the {@link IPage} of a {@link SashWindowsContainer}.
 * 
 * @author cedric dumoulin
 * 
 */
public interface IPageVisitor {

	/**
	 * Visit the provided page of type {@link IComponentPage}.
	 * 
	 * @param page
	 */
	void accept(IComponentPage page);

	/**
	 * Visit the provided page of type {@link IEditorPage}.
	 * 
	 * @param page
	 */
	void accept(IEditorPage page);

}
