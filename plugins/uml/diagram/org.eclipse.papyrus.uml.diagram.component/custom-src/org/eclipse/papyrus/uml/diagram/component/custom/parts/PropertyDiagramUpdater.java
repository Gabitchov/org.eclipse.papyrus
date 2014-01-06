/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.custom.parts;

import java.util.Collections;
import java.util.List;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.part.ICustomDiagramUpdater;
import org.eclipse.papyrus.uml.diagram.component.part.UMLDiagramUpdater;

/**
 * <pre>
 * This class provides a custom implementation for the method 
 * resolving the semantic children of a Property (as viewed in a
 * structured classifier) in {@link UMLDiagramUpdater}.
 * </pre>
 */
public class PropertyDiagramUpdater implements ICustomDiagramUpdater {

	/**
	 * <pre>
	 * The original generated method of {@link UMLDiagramUpdater} class is kept commented below.
	 * 
	 * In the CompositeStructure Diagram, Port may be shown graphically attached to 
	 * a Property. This is only possible if the Property is typed by the StructuredClassifier
	 * that owns the Port.
	 * 
	 * In order to implement this in GMF, the Port is declared as an affixed child for both
	 * StructuredClassifier and Property, but as the Port is not contained by Property, the 
	 * Property related getSemanticChildren is not generated properly. 
	 * 
	 * FIXME : Not sure whether the {@link UMLDiagramUpdater} class is really needed by Papyrus
	 * 
	 * {@inheritDoc}
	 * </pre>
	 */
	public List<?> getSemanticChildren(View view) {

		return Collections.EMPTY_LIST;

		// if (!view.isSetElement()) {
		// return Collections.EMPTY_LIST;
		// }
		//
		// Property modelElement = (Property) view.getElement();
		// List<UMLNodeDescriptor> result = new LinkedList<UMLNodeDescriptor>();
		// for (Iterator<?> it = modelElement.getOwnedAttributes().iterator(); it.hasNext();) {
		// Property childElement = (Property) it.next();
		// int visualID = UMLVisualIDRegistry.getNodeVisualID(view, childElement);
		// if (visualID == PortEditPart.VISUAL_ID) {
		// result.add(new UMLNodeDescriptor(childElement, visualID));
		// continue;
		// }
		// }
		// return result;
	}
}
