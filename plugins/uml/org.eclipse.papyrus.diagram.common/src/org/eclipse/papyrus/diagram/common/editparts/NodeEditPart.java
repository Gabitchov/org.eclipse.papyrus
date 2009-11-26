/*****************************************************************************
 * Copyright (c) 2008-2009 CEA LIST.
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

import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.GradientData;
import org.eclipse.papyrus.diagram.common.figure.node.IPapyrusNodeFigure;
import org.eclipse.papyrus.umlutils.ui.helper.ShadowFigureHelper;
import org.eclipse.swt.graphics.Color;

/**
 * this uml edit part can refresh shadow and gradient.
 */
public abstract class NodeEditPart extends AbstractBorderedShapeEditPart implements IPapyrusEditPart {

	public NodeEditPart(View view) {
		super(view);
	}

	/**
	 * {@inheritDoc}
	 */
	protected NodeFigure createMainFigure() {
		return createNodeFigure();
	}

	/**
	 * <p>
	 * Returns the primary shape being the View of this edit part.
	 * </p>
	 * <b>Warning</b> It should never return <code>null</code>
	 * 
	 * @return the primary shape associated to this edit part.
	 */
	public abstract IPapyrusNodeFigure getPrimaryShape();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean supportsGradient() {
		return true;
	}

	/**
	 * Override to set the transparency to the correct figure
	 */
	@Override
	protected void setTransparency(int transp) {
		getPrimaryShape().setTransparency(transp);
	}

	/**
	 * sets the back ground color of this edit part
	 * 
	 * @param color
	 *            the new value of the back ground color
	 */
	protected void setBackgroundColor(Color color) {
		getPrimaryShape().setBackgroundColor(color);
		getPrimaryShape().setIsUsingGradient(false);
		getPrimaryShape().setGradientData(-1, -1, 0);
	}

	/**
	 * Override to set the gradient data to the correct figure
	 */
	@Override
	protected void setGradient(GradientData gradient) {
		IPapyrusNodeFigure fig = getPrimaryShape();
		FillStyle style = (FillStyle) getPrimaryView().getStyle(NotationPackage.Literals.FILL_STYLE);
		if (gradient != null) {
			fig.setIsUsingGradient(true);
			;
			fig.setGradientData(style.getFillColor(), gradient.getGradientColor1(), gradient.getGradientStyle());
		} else {
			fig.setIsUsingGradient(false);
		}
	}

	/**
	 * sets the font color
	 * 
	 * @param color
	 *            the new value of the font color
	 */
	protected void setFontColor(Color color) {
		// NULL implementation
	}

	/**
	 * sets the fore ground color of this edit part's figure
	 * 
	 * @param color
	 *            the new value of the foregroundcolor
	 */
	protected void setForegroundColor(Color color) {
		getPrimaryShape().setForegroundColor(color);
	}

	/**
	 * Refresh the shadow of the figure
	 */
	protected void refreshShadow() {
		getPrimaryShape().setShadow(ShadowFigureHelper.getShadowFigureValue((View) getModel()));
	}
}
