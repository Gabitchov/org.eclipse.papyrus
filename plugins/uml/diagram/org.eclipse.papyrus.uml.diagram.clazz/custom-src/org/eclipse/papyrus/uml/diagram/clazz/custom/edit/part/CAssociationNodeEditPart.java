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

import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AssociationNodeEditPart;
import org.eclipse.papyrus.uml.diagram.common.figure.node.AssociationNodeFigure;

/**
 * this a specific editpart used to overload the method createNodePlate
 */
public class CAssociationNodeEditPart extends AssociationNodeEditPart {

	public CAssociationNodeEditPart(View view) {
		super(view);
	}

	/**
	 * 
	 * @return
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new AssociationNodeFigure(20, 20);
		return result;
	}
}
