/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Nizar GUEDIDI (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.custom.edit.part;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.figure.edge.DashedEdgeFigure;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyBranchEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.DependencyNodeEditPart;

/**
 * this a specific editpart used to overload the method createNodePlate
 */
public class CustomDependencyBranchEditPart extends DependencyBranchEditPart {

	public CustomDependencyBranchEditPart(View view) {
		super(view);
	}

	protected void refreshVisuals() {
		if(getTarget() instanceof DependencyNodeEditPart) {
			if(getPrimaryShape() instanceof DashedEdgeFigure) {
				((DashedEdgeFigure)getPrimaryShape()).setArrow(false);
			}
			super.refreshVisuals();
		}
	}
}
