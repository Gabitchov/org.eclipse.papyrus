/**
 * 
 */
package org.eclipse.papyrus.uml.tools.model;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.resource.AbstractBaseModel;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * A UML model.
 * 
 * @author cedric dumoulin
 * 
 */
public class UmlModel extends AbstractBaseModel implements IModel {

	/**
	 * File extension used for DI.
	 */
	public static final String UML_FILE_EXTENSION = "uml"; //$NON-NLS-1$

	/**
	 * Model ID.
	 */
	public static final String MODEL_ID = "org.eclipse.papyrus.infra.core.resource.uml.UmlModel"; //$NON-NLS-1$

	/**
	 * @see org.eclipse.papyrus.infra.core.resource.IModel#createModel(org.eclipse.core.runtime.IPath)
	 * 
	 * @param fullPath
	 */
	@Override
	public void createModel(IPath fullPath) {

		// Compute model URI
		resourceURI = getPlatformURI(fullPath.addFileExtension(UML_FILE_EXTENSION));

		// Create Resource of appropriate type
		resource = getResourceSet().createResource(resourceURI, getContentType());
	}

	/**
	 * 
	 * @return
	 */
	protected String getContentType() {
		// TODO: use the uml identifier
		// return UMLPackage.eCONTENT_TYPE;
		return "org.eclipse.uml2.uml";
	}

	/**
	 * Get the file extension used for this model.
	 * 
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractBaseModel#getModelFileExtension()
	 * 
	 * @return
	 */
	@Override
	protected String getModelFileExtension() {
		return UML_FILE_EXTENSION;
	}

	/**
	 * Get the identifier used to register this model.
	 * 
	 * @see org.eclipse.papyrus.infra.core.resource.AbstractBaseModel#getIdentifier()
	 * 
	 * @return
	 */
	@Override
	public String getIdentifier() {
		return MODEL_ID;
	}

	/**
	 * Lookup the root of the model. Throw an exception if not found.
	 * 
	 * @return
	 */
	public EObject lookupRoot() throws NotFoundException {
		if(resource.getContents().isEmpty()) {
			// The root doesn't exist.
			throw new NotFoundException("No root defined in the model");
		}

		return resource.getContents().get(0);
	}

	/**
	 * Initialize the model if it is empty. Initialize  it with a default uml.Model
	 */
	public void initializeEmptyModel() {
		
		// Skip if the model is not empty
		if( ! resource.getContents().isEmpty() ) {
			return;
		}
		
		Model model = UMLFactory.eINSTANCE.createModel();
		model.setName("model");
		resource.getContents().add(model);
	}
}
