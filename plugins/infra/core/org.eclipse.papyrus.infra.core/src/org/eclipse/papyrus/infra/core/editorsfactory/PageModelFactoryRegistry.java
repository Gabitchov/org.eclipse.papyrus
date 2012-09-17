/**
 * 
 */
package org.eclipse.papyrus.infra.core.editorsfactory;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.IPageModelFactory;

/**
 * Concrete implementation of the {@link IPageModelFactory} required by the di
 * implementation of {@link ISashWindowsContentProvider}. This implementation
 * allows to add and remove {@link IEditorFactory}.
 * 
 * 
 * @author cedric dumoulin
 */
public class PageModelFactoryRegistry implements IPageModelFactory {

	/** list of editor factories */
	protected List<IEditorFactory> editorFactories = new ArrayList<IEditorFactory>();

	/**
	 * Constructor.
	 * 
	 * @param editorFactoryRegistry
	 * @param servicesRegistry
	 */
	public PageModelFactoryRegistry() {

	}

	/**
	 * Walk each registered {@link IEditorFactory} to find the one handling the
	 * specified pageIdentifier. Call the corresponding method in the found
	 * pageIdentifier.
	 * 
	 * TODO Throw an exception to report errors.
	 * 
	 * @see org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.IPageModelFactory#createIPageModel(java.lang.Object)
	 */
	public IPageModel createIPageModel(Object pageIdentifier) {

		for(IEditorFactory factory : getEditorFactories()) {
			if(factory.isPageModelFactoryFor(pageIdentifier)) {
				{
					return factory.createIPageModel(pageIdentifier);
				}
			}
		}
		// no editor found !
		// TODO Throw an exception.
		// throw new EditorNotFoundException("No editor registered for '" +
		// pageIdentifier + "'.");
		return null;
	}

	/**
	 * @return the editorFactories
	 */
	protected List<IEditorFactory> getEditorFactories() {
		return editorFactories;
	}

	/**
	 * Add the specified {@link IEditorFactory}
	 * 
	 * @param editorFactory
	 */
	public void add(IEditorFactory editorFactory) {
		// This should never happen
		if(editorFactory == null)
			throw new RuntimeException("Parameter should not be null.");

		editorFactories.add(editorFactory);
	}

	/**
	 * Remove the specified {@link IEditorFactory}
	 * 
	 * @param editorFactory
	 */
	public void remove(IEditorFactory editorFactory) {
		editorFactories.remove(editorFactory);
	}
}
