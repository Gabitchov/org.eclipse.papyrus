/**
 * 
 */
package org.eclipse.papyrus.infra.gmfdiag.common.model;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.core.resource.AbstractBaseModel;
import org.eclipse.papyrus.infra.core.resource.BadArgumentExcetion;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;

/**
 * @author dumoulin
 * 
 */
public class NotationModel extends AbstractBaseModel implements IModel {

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
	 * Get a diagram by its name.
	 * 
	 * @param diagramName Name of the diagram. This is the name set by the user.
	 * @return
	 * @throws NotFoundException 
	 * @throws BadArgumentExcetion 
	 */
	public Diagram getDiagram(String diagramName) throws NotFoundException, BadArgumentExcetion {
		
		if( diagramName == null || diagramName.length() == 0) {
			throw new BadArgumentExcetion("Diagram name should not be null and size should be >0.");
		}
		
		for( EObject element : getResource().getContents()) {
			if( element instanceof Diagram) {
				Diagram diagram = (Diagram)element;
				
				if( diagramName.equals(diagram.getName())) {
					// Found
					return diagram;
							
				}
			}
		}
		// not found
		throw new NotFoundException("No Diagram named '" + diagramName + "' can be found in Model.");
	}
}
