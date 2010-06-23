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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.figure.node.ConstraintFigure;
import org.eclipse.papyrus.diagram.common.figure.node.IPapyrusNodeFigure;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * this is an abstract editpart to manage  a constraint 
 *
 */
public class AbstractConstraintEditPart extends NamedElementEditPart {

	protected static final String CONSTRAINT_VALUE_SPECIFICATION_LISTENER = "Constraint_valueSpecification_Listener";
	public AbstractConstraintEditPart(View view) {
		super(view);
		// TODO Auto-generated constructor stub
	}
	/**
	 * this methods add listeners on targets and sources
	 */
	protected void addAssociationEndListeners() {
		
	}
	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.common.editparts.NodeEditPart#getPrimaryShape()
	 */
	public IPapyrusNodeFigure getPrimaryShape() {
		return new ConstraintFigure();
	}
	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.common.editparts.NamedElementEditPart#refreshLabelsFont(org.eclipse.swt.graphics.Font)
	 */
	protected void refreshLabelsFont(Font font) {
		// TODO Auto-generated method stub
		super.refreshLabelsFont(font);
		if(getPrimaryShape() instanceof ConstraintFigure){
			((ConstraintFigure)getPrimaryShape()).getTextFlow().setFont(font);
		}
	}
	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.common.editparts.NamedElementEditPart#setFontColor(org.eclipse.swt.graphics.Color)
	 */
	protected void setFontColor(Color color) {
		// TODO Auto-generated method stub
		super.setFontColor(color);
		if(getPrimaryShape() instanceof ConstraintFigure){
			((ConstraintFigure)getPrimaryShape()).getPageFlow().setForegroundColor(color);
		}
	} 
}
