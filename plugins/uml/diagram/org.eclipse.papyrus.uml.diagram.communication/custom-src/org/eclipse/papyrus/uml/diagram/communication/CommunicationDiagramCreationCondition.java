/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Atos Origin - Initial API and implementation
 *  Saadia DHOUIB (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.communication;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.extension.commands.PerspectiveContextDependence;

// TODO: Auto-generated Javadoc
/**
 * The Class CommunicationDiagramCreationCondition.
 */
public class CommunicationDiagramCreationCondition extends PerspectiveContextDependence {

	/**
	 * Creates the.
	 * 
	 * @param selectedElement
	 *        the selected element
	 * @return whether the diagram can be created.
	 */
	public boolean create(EObject selectedElement) {
		return false;
	}

}
