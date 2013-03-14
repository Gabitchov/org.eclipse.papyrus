/**
 * 
 */
package org.eclipse.papyrus.infra.core.editorsfactory;

import org.eclipse.swt.graphics.Image;

/**
 * Factory used to create an {@link IPageModel} used by the {@link ISashWindowsContainer} to create an instance of the editor represented
 * by the provided Object. Such factory is required by the {@link DiSashModelMngr}. It is called whenever the ISashWindowsContainer need
 * to create an editor from an EObject representing this editor in the Di
 * implementation of the {@link ISashWindowsContentProvider}
 * 
 * 
 * @author cedric dumoulin
 * 
 */
public interface IEditorIconFactory {

	/**
	 * Get the icon associated to the editor used to render the model. Model
	 * represent the top level object of a model editor. Can return a cached
	 * Image.
	 * 
	 * @param pageIdentifier
	 *        the pageIdentifier representing the Editor. This is usually
	 *        the EObject used to reconstruct the editor.
	 * @return the icon representing the editor
	 */
	public Image getEditorIcon(Object pageIdentifier);

	/**
	 * Create the icon associated to the editor used to render the model. Model
	 * represent the top level object of a model editor. Always return a newly
	 * created Image.
	 * 
	 * @param pageIdentifier
	 *        the pageIdentifier representing the Editor. This is usually
	 *        the EObject used to reconstruct the editor.
	 * @return the icon representing the editor
	 */
	public Image createEditorIcon(Object pageIdentifier);

	/**
	 * Return true if the factory can create an IPageModel for the specified
	 * pageIdentifier. Return false otherwise TODO throw an exception
	 * encapsulating problems encountered while creating the model.
	 * 
	 * @param pageIdentifier
	 *        The object representing the page to test
	 * @return
	 */
	public boolean isPageModelFactoryFor(Object pageIdentifier);

	/**
	 * Dispose this factory
	 */
	public void dispose();

}
