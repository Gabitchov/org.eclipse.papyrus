/**
 * 
 */
package org.eclipse.papyrus.core.editor;

import org.eclipse.papyrus.core.extension.diagrameditor.EditorFactoryRegistry;
import org.eclipse.papyrus.core.extension.diagrameditor.IEditorFactoryRegistry;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageModel;
import org.eclipse.papyrus.sasheditor.contentprovider.di.IPageModelFactory;


/**
 * PageModelFactory for the sashwindow.
 * This factory is used by the SashWindows to create Diagrams.
 * It is a wrapper arround the {@link EditorFactoryRegistry}
 * 
 * @author dumoulin
 */
public class PageModelFactory implements IPageModelFactory {

	IEditorFactoryRegistry editorFactoryRegistry;

	ServicesRegistry servicesRegistry;

	/**
	 * Constructor.
	 * 
	 * @param editorFactoryRegistry
	 * @param servicesRegistry
	 */
	public PageModelFactory(IEditorFactoryRegistry editorFactoryRegistry, ServicesRegistry servicesRegistry) {

		if(servicesRegistry == null || editorFactoryRegistry == null)
			throw new IllegalArgumentException("Arguments should not be null.");

		this.editorFactoryRegistry = editorFactoryRegistry;
		this.servicesRegistry = servicesRegistry;
	}

	/**
	 * Call the corresponding method on the wrapped {@link EditorFactoryRegistry} {@inheritDoc}
	 * 
	 * @see org.eclipse.papyrus.sasheditor.contentprovider.di.IPageModelFactory#createIPageModel(java.lang.Object)
	 */
	public IPageModel createIPageModel(Object pageIdentifier) {
		return editorFactoryRegistry.createIPageModel(pageIdentifier, servicesRegistry);
	}

}
