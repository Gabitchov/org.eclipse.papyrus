/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *  Atos Origin - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.diagram.composite;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.core.extension.commands.PerspectiveContextDependence;
import org.eclipse.uml2.uml.Collaboration;

/**
 * CompositeDiagramCreationCondition class allows to check if a Composite diagram can be added to the
 * selected element.
 */
public class CompositeDiagramCreationCondition  extends PerspectiveContextDependence {

	/**
	 * @return whether the diagram can be created.
	 */
	public boolean create(EObject selectedElement) {
		if(super.create(selectedElement)){
			return selectedElement instanceof org.eclipse.uml2.uml.Package || selectedElement instanceof org.eclipse.uml2.uml.Class || selectedElement instanceof Collaboration;
		}
		return false;
	}


}
