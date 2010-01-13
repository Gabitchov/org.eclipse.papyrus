/**
 * 
 */
package org.eclipse.papyrus.core.editorsfactory;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.core.extension.diagrameditor.EditorDescriptor;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageModel;
import org.eclipse.swt.graphics.Image;


/**
 * Concrete implementation of the {@link IPageIconsRegistry}.
 * This implementation allows to add and remove {@link IPageIconsRegistry}.
 * 
 * 
 * @author cedric dumoulin
 */
public class PageIconsRegistry implements IPageIconsRegistry {

	/** list of registered icon factories */
	protected List<IEditorIconFactory> pageIcons = new ArrayList<IEditorIconFactory>();


	/**
	 * Constructor.
	 * 
	 * @param editorFactoryRegistry
	 * @param servicesRegistry
	 */
	public PageIconsRegistry() {

	}

	/**
	 * Walk each registered {@link IEditorFactory} to find the one handling the specified pageIdentifier.
	 * Call the corresponding method in the found pageIdentifier.
	 * 
	 * TODO Throw an exception to report errors.
	 * 
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.di.IPageModelFactory#createIPageModel(java.lang.Object)
	 */
	public Image getEditorIcon(Object pageIdentifier) {
		
		for(IEditorIconFactory factory : getPageIcons()) {
			if(factory.isPageModelFactoryFor(pageIdentifier)) {
				{
//					return factory.getEditorIcon(pageIdentifier);
					return factory.createEditorIcon(pageIdentifier);
				}
			}
		}
		// no editor found !
		// TODO Throw an exception.
		// throw new EditorNotFoundException("No editor registered for '" + pageIdentifier + "'.");
		return null;
	}

	
	/**
	 * @return the editorFactories
	 */
	protected List<IEditorIconFactory> getPageIcons() {
		return pageIcons;
	}

	/**
	 * Add the specified {@link IEditorFactory}
	 * @param editorIconFactory
	 */
	public void add(IEditorIconFactory editorIconFactory)
	{
		// This should never happen
		if( editorIconFactory==null)
			throw new RuntimeException("Parameter should not be null.");
		
		pageIcons.add(editorIconFactory);
	}
	
	/**
	 * Remove the specified {@link IEditorFactory}
	 * @param editorIconFactory
	 */
	public void remove(IEditorIconFactory editorIconFactory)
	{
		pageIcons.remove(editorIconFactory);
	}
}
