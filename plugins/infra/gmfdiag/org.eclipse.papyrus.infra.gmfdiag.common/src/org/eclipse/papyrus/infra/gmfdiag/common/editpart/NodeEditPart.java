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
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Style implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.editpart;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.GradientData;
import org.eclipse.papyrus.infra.emf.appearance.helper.ShadowFigureHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IPapyrusNodeFigure;
import org.eclipse.papyrus.infra.gmfdiag.common.snap.PapyrusDragEditPartsTrackerEx;
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
	@Override
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
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);

		// Update the figure when the line width changes
		Object feature = event.getFeature();
		if((getModel() != null) && (getModel() == event.getNotifier())) {
			if(NotationPackage.eINSTANCE.getLineStyle_LineWidth().equals(feature)) {
				refreshLineWidth();
			} else if(NotationPackage.eINSTANCE.getLineTypeStyle_LineType().equals(feature)) {
				refreshLineType();
			}
		}

		// set the figure active when the feature of the of a class is true
		if(resolveSemanticElement() != null) {
			refreshShadow();
		}
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshShadow();
		refreshLineType();
		refreshLineWidth();
		refreshTransparency();
	}

	@Override
	protected void setLineWidth(int width) {
		if(width < 0) {
			width = 1;
		}
		getPrimaryShape().setLineWidth(width);
	}

	@Override
	protected void setLineType(int style) {
		getPrimaryShape().setLineStyle(style);
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
	 *        the new value of the back ground color
	 */
	@Override
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
		FillStyle style = (FillStyle)getPrimaryView().getStyle(NotationPackage.Literals.FILL_STYLE);
		if(gradient != null) {
			fig.setIsUsingGradient(true);;
			fig.setGradientData(style.getFillColor(), gradient.getGradientColor1(), gradient.getGradientStyle());
		} else {
			fig.setIsUsingGradient(false);
		}
	}

	/**
	 * sets the font color
	 * 
	 * @param color
	 *        the new value of the font color
	 */
	@Override
	protected void setFontColor(Color color) {
		// NULL implementation
	}

	/**
	 * sets the fore ground color of this edit part's figure
	 * 
	 * @param color
	 *        the new value of the foregroundcolor
	 */
	@Override
	protected void setForegroundColor(Color color) {
		getPrimaryShape().setForegroundColor(color);
	}

	/**
	 * Refresh the shadow of the figure
	 */
	protected final void refreshShadow() {
		getPrimaryShape().setShadow(ShadowFigureHelper.getShadowFigureValue((View)getModel()));
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#getDragTracker(org.eclipse.gef.Request)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	public DragTracker getDragTracker(final Request request) {
		return new PapyrusDragEditPartsTrackerEx(this, true, false, false);
	}
}
