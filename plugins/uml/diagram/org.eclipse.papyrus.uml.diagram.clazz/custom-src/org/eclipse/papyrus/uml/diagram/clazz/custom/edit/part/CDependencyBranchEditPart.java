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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.edit.part;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DependencyNodeEditPart;
import org.eclipse.papyrus.uml.diagram.common.figure.edge.DashedEdgeFigure;

/**
 * this branch dependency can change its arrow
 * 
 */
public class CDependencyBranchEditPart extends org.eclipse.papyrus.uml.diagram.clazz.edit.parts.DependencyBranchEditPart {

	public CDependencyBranchEditPart(View view) {
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
