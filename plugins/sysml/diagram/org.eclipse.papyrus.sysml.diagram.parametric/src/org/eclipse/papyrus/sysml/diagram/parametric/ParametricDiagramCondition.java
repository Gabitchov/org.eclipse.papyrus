/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		chevrel.regis@gmail.com
 *		CEA LIST - Initial API and implementation
 *		Laurent Wouters (CEA LIST) laurent.wouters@cea.fr - Viewpoints application
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.extension.commands.PerspectiveContextDependence;

/**
 * ParametricDiagramCondition to set conditions for the diagram creation
 */
public class ParametricDiagramCondition extends PerspectiveContextDependence {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean create(EObject selectedElement) {
		return false;
	}
}
