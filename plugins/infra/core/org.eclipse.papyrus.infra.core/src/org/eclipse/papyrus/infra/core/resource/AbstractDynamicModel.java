/**
 * 
 */
package org.eclipse.papyrus.infra.core.resource;

import java.io.IOException;

import org.eclipse.core.internal.resources.ResourceException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;

/**
 * Base class for models that can be created dynamically. Such models do not need to exist when others models are loaded.
 * If the model is missing, it will be created.
 * Furthermore, if the model is empty, it will not be saved.
 * 
 * 
 * @author cedric dumoulin
 * 
 * @param T
 *        Type of the roots of the model.
 */
public abstract class AbstractDynamicModel<T extends EObject> extends AbstractBaseModel {


	/**
	 * 
	 * Constructor.
	 * 
	 * @param modelKind
	 */
	public AbstractDynamicModel() {
		super();
	}

	/**
	 * Load the model if it exist, or create a new one if it doesn't exist.
	 * 
	 * @param fullPathWithoutExtension
	 */
	@SuppressWarnings("restriction")
	@Override
	public void loadModel(IPath fullPathWithoutExtension) {
		
		// Try to load the model. It this fail, create a model.
		try {
			// Try to load the model
			super.loadModel(fullPathWithoutExtension);
			return;
		} catch (RuntimeException e) {

			// Check if the exception come from an non existing resource.
			if(!( e.getCause() instanceof ResourceException) ) {
				throw e;
			}
		}
		// The resource do not exist, crate it.
		createModel(fullPathWithoutExtension);
		// call registered snippets
		snippets.performStart(this);		
	}

	/**
	 * Save the model if it contains something.
	 * 
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractBaseModel#saveModel()
	 * 
	 * @throws IOException
	 */
	@Override
	public void saveModel() throws IOException {

		if( getResource().getContents().size() <= 0) {
			return;
		}

		// Do the save
		super.saveModel();
	}

	/**
	 * Add a root to this model.
	 * 
	 * @param root
	 */
	public void addModelRoot(T root) {
		getResource().getContents().add(root);
	}
}
