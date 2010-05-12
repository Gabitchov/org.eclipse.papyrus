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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.editparts;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.figure.node.ConstraintFigure;
import org.eclipse.papyrus.diagram.common.figure.node.IPapyrusNodeFigure;

/**
 * this is an abstract editpart to manage  a constraint 
 *
 */
public class AbstractConstraintEditPart extends NamedElementEditPart {

	public AbstractConstraintEditPart(View view) {
		super(view);
		// TODO Auto-generated constructor stub
	}

	@Override
	public IPapyrusNodeFigure getPrimaryShape() {
		return new ConstraintFigure();
	}
}
