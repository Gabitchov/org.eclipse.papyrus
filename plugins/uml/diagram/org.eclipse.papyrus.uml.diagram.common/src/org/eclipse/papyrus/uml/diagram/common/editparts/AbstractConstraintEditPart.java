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
package org.eclipse.papyrus.uml.diagram.common.editparts;

import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IPapyrusNodeFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.ConstraintFigure;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;

/**
 * this is an abstract editpart to manage a constraint
 * 
 */
public abstract class AbstractConstraintEditPart extends NamedElementEditPart {

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
	 * @see org.eclipse.papyrus.uml.diagram.common.editparts.NodeEditPart#getPrimaryShape()
	 */
	@Override
	public IPapyrusNodeFigure getPrimaryShape() {
		return new ConstraintFigure();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.editparts.NamedElementEditPart#refreshLabelsFont(org.eclipse.swt.graphics.Font)
	 */
	@Override
	protected void refreshLabelsFont(Font font) {
		// TODO Auto-generated method stub
		super.refreshLabelsFont(font);
		if(getPrimaryShape() instanceof ConstraintFigure) {
			((ConstraintFigure)getPrimaryShape()).getTextFlow().setFont(font);
		}
	}

	@Override
	protected void refreshBackgroundColor() {
		FillStyle style = (FillStyle)getPrimaryView().getStyle(NotationPackage.Literals.FILL_STYLE);
		if(style != null) {
			if(style.getGradient() == null || !supportsGradient()) {
				setBackgroundColor(DiagramColorRegistry.getInstance().getColor(new Integer(style.getFillColor())));
			} else {
				setGradient(style.getGradient());
			}
		}
	}

	/**
	 * Refresh figure's background transparency.
	 * 
	 * @since 1.2
	 */
	@Override
	protected void refreshTransparency() {
		FillStyle style = (FillStyle)getPrimaryView().getStyle(NotationPackage.Literals.FILL_STYLE);
		if(style.getGradient() != null) {
			setTransparency(style.getTransparency());
		} else {
			setTransparency(0);
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.editparts.NamedElementEditPart#setFontColor(org.eclipse.swt.graphics.Color)
	 */
	@Override
	protected void setFontColor(Color color) {
		// TODO Auto-generated method stub
		super.setFontColor(color);
		if(getPrimaryShape() instanceof ConstraintFigure) {
			((ConstraintFigure)getPrimaryShape()).getPageFlow().setForegroundColor(color);
		}
	}
}
