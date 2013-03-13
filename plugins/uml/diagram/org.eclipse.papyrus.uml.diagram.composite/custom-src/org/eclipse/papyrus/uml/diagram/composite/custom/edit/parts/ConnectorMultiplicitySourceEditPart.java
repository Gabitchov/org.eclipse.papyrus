/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.edit.parts;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Connector;

/**
 * Replacement edit part for Connector multiplicity source label.
 */
public class ConnectorMultiplicitySourceEditPart extends org.eclipse.papyrus.uml.diagram.composite.edit.parts.ConnectorMultiplicitySourceEditPart {

	/**
	 * Constructor.
	 */
	public ConnectorMultiplicitySourceEditPart(View view) {
		super(view);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EObject resolveSemanticElement() {
		if(super.resolveSemanticElement() instanceof Connector) {
			Connector connector = (Connector)super.resolveSemanticElement();
			if(connector.getEnds().size() == 2) {
				return connector.getEnds().get(0);
			}
		}

		return null;
	}
}
