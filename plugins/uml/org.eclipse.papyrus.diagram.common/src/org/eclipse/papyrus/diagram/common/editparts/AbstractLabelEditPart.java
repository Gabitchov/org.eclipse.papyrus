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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.diagram.common.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.figure.node.IPapyrusUMLElementFigure;
/**
 * This is an editpart in which we can access to the wrapping label
 * for example it can be use to display stereotype as external node
 */
public abstract class AbstractLabelEditPart extends LabelEditPart implements IPapyrusEditPart {

	public AbstractLabelEditPart(View view) {
		super(view);
	}
/**
 * 
 * {@inheritDoc}
 */
	public IFigure getPrimaryShape() {
		return (IFigure) getFigure();
	}

	

}
