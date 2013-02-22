/**
 * 
 */
package org.eclipse.papyrus.infra.core.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;

/**
 * Base class for models sharing a common {@link Resource}. To share a common {@link Resource}, one of the model should be Master, while the other are
 * slaves. The Master is the one performing the save operation. All the model
 * should use the same file extension. So, {@link #getModelFileExtension()} should return the same value for all models.
 * 
 * @author cedric dumoulin
 * 
 * @param T
 *        Type of the roots of the model.
 */
public abstract class AbstractModelWithSharedResource<T extends EObject> extends AbstractBaseModel {

	/**
	 * Possible type for this model: master or slave
	 */
	public enum ModelKind {
		master, slave
	}

	/**
	 * Model kind.
	 */
	private ModelKind modelKind;;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param modelKind
	 */
	public AbstractModelWithSharedResource(ModelKind modelKind) {
		this.modelKind = modelKind;
	}

	/**
	 * By default, we are a slave. Constructor.
	 * 
	 * @param modelKind
	 */
	public AbstractModelWithSharedResource() {
		this.modelKind = ModelKind.slave;
	}

	/**
	 * Attach the model to its resource if this is not already done.
	 * 
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractBaseModel#loadModel(org.eclipse.core.runtime.IPath)
	 * 
	 * @param fullPathWithoutExtension
	 */
	@Override
	public void loadModel(IPath fullPathWithoutExtension) {

		// Look for the resource
		lookupResource(fullPathWithoutExtension);

		// Check if model is loaded.
		if(resourceIsSet()) {
			configureResource(resource);
			return;
		}
		// model is not loaded, do it.
		super.loadModel(fullPathWithoutExtension);
	}

	/**
	 * Create the model if this is not already done.
	 * 
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractBaseModel#createModel(org.eclipse.core.runtime.IPath)
	 * 
	 * @param fullPath
	 */
	@Override
	public void createModel(IPath fullPath) {

		// Look for the resource
		lookupResource(fullPath);

		// Check if model is loaded.
		if(resourceIsSet()) {
			configureResource(resource);
			return;
		}
		// model is not loaded, do it.
		super.createModel(fullPath);
	}

	/**
	 * Lookup for the resource in the resourceSet. Return the resource or null
	 * if not found.
	 * 
	 * @param fullPath
	 */
	private void lookupResource(IPath fullPath) {

		// Compute model URI
		resourceURI = getPlatformURI(fullPath.addFileExtension(getModelFileExtension()));

		resource = getResourceSet().getResource(resourceURI, false);

	}

	/**
	 * Do nothing as we are slave. The Resource is save by the master model.
	 * 
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractBaseModel#saveModel()
	 * 
	 * @throws IOException
	 */
	@Override
	public void saveModel() throws IOException {

		// Do nothing if we are a slave
		if(modelKind == ModelKind.slave) {
			return;
		}

		// Do the save
		super.saveModel();
	}

	/**
	 * Get the root of this model. Lookup in the associated {@link Resource} for
	 * the root.
	 * 
	 * @return The root of the model, or null if no root exist.
	 */
	@SuppressWarnings("unchecked")
	public T getModelRoot() {

		for(EObject object : getResource().getContents()) {

			if(isModelRoot(object)) {
				return (T)object;
			}
		}

		// Not found
		return null;
	}

	/**
	 * Get the roots of this model. Lookup in the associated {@link Resource} for the roots.
	 * 
	 * @return A list containing the roots of the model. The list is empty if
	 *         there is no root.
	 */
	@SuppressWarnings("unchecked")
	public List<T> getModelRoots() {

		List<T> roots = new ArrayList<T>();

		for(EObject object : getResource().getContents()) {
			if(isModelRoot(object)) {
				roots.add((T)object);
			}
		}

		return roots;
	}

	/**
	 * Return true if the provided object is a root of the model, false
	 * otherwise. This method should be implemented by subclasses.
	 * 
	 * @param object
	 * @return
	 */
	protected abstract boolean isModelRoot(EObject object);

	/**
	 * Add a root to this model.
	 * 
	 * @param root
	 */
	public void addModelRoot(T root) {
		getResource().getContents().add(root);
	}

	@Override
	protected Map<Object, Object> getSaveOptions() {
		if(modelKind == ModelKind.master) {
			return super.getSaveOptions();
		} else {
			return Collections.emptyMap();
		}
	}

}
