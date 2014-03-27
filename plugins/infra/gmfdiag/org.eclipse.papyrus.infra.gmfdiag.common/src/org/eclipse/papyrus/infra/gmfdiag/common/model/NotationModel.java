/**
 *
 */
package org.eclipse.papyrus.infra.gmfdiag.common.model;

import java.util.Collections;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.core.resource.BadArgumentExcetion;
import org.eclipse.papyrus.infra.core.resource.EMFLogicalModel;
import org.eclipse.papyrus.infra.core.resource.IEMFModel;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.IOpenable;
import org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.IOpenableWithContainer;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;

/**
 * @author cedric dumoulin
 *
 */
public class NotationModel extends EMFLogicalModel implements IModel {

	/**
	 * File extension used for notation.
	 */
	public static final String NOTATION_FILE_EXTENSION = "notation"; //$NON-NLS-1$

	/**
	 * Model ID.
	 */
	public static final String MODEL_ID = "org.eclipse.papyrus.infra.core.resource.notation.NotationModel"; //$NON-NLS-1$

	/**
	 *
	 * Constructor.
	 *
	 */
	public NotationModel() {

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
		return NOTATION_FILE_EXTENSION;
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
	 * Add a new initialized {@link Diagram} to the model.
	 *
	 * @param newDiagram
	 *        The diagram to add.
	 */
	public void addDiagram(Diagram newDiagram) {
		getResource().getContents().add(newDiagram);
	}

	/**
	 * Notation resources are controlled if their base element is controlled
	 */
	@Override
	public boolean isControlled(Resource resource) {
		for(EObject rootElement : resource.getContents()) {
			IOpenable openable = (IOpenableWithContainer)Platform.getAdapterManager().getAdapter(rootElement, IOpenable.class);
			if(openable instanceof IOpenableWithContainer) {
				EObject container = EMFHelper.getEObject(((IOpenableWithContainer)openable).getContainer());
				if(container != null) {
					IModel iModel = modelSet.getModelFor(container);
					if(iModel instanceof IEMFModel) {
						if(((IEMFModel)iModel).isControlled(container.eResource())) {
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	@Override
	public void handle(Resource resource) {
		super.handle(resource);
		if(resource == null) {
			return;
		}

		//If the parameter resource is already a notation resource, nothing to do
		if(!isRelatedResource(resource)) {
			URI notationURI = resource.getURI().trimFileExtension().appendFileExtension(NOTATION_FILE_EXTENSION);
			ResourceSet resourceSet = getResourceSet();
			if(resourceSet != null && resourceSet.getURIConverter() != null) {
				URIConverter converter = resourceSet.getURIConverter();
				if(converter.exists(notationURI, Collections.emptyMap())) {
					//If the notation resource associated to the parameter resource exists, load it
					getResourceSet().getResource(notationURI, true);
				}
			}
		}
	}


	/**
	 * Get a diagram by its name.
	 *
	 * @param diagramName
	 *        Name of the diagram. This is the name set by the user.
	 * @return
	 * @throws NotFoundException
	 * @throws BadArgumentExcetion
	 */
	public Diagram getDiagram(String diagramName) throws NotFoundException, BadArgumentExcetion {

		if(diagramName == null || diagramName.length() == 0) {
			throw new BadArgumentExcetion("Diagram name should not be null and size should be >0.");
		}

		for(EObject element : getResource().getContents()) {
			if(element instanceof Diagram) {
				Diagram diagram = (Diagram)element;

				if(diagramName.equals(diagram.getName())) {
					// Found
					return diagram;

				}
			}
		}
		// not found
		throw new NotFoundException("No Diagram named '" + diagramName + "' can be found in Model.");
	}
}
