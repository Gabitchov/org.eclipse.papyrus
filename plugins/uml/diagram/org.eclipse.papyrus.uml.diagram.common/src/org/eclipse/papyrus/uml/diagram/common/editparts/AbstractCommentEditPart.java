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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.NodeEditPart;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IPapyrusNodeFigure;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ApplyStereotypeEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.node.HTMLCornerBentFigure;
import org.eclipse.papyrus.uml.diagram.common.service.ApplyStereotypeRequest;
import org.eclipse.swt.graphics.Color;

/**
 * this is a abstract editpart to display a comment
 */
public abstract class  AbstractCommentEditPart extends NodeEditPart {

	public AbstractCommentEditPart(View view) {
		super(view);
	}

	@Override
	public IPapyrusNodeFigure getPrimaryShape() {
		return new HTMLCornerBentFigure();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);

		// set the figure active when the feature of the of a class is true
		if(resolveSemanticElement() != null) {
			refreshFontColor();

		}
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		// adds the stereotype application edit policy
		installEditPolicy(ApplyStereotypeRequest.APPLY_STEREOTYPE_REQUEST, new ApplyStereotypeEditPolicy());
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

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshFontColor();

	}

	/** Refresh the editpart's figure font color. */
	@Override
	protected void refreshFontColor() {
		FontStyle style = (FontStyle)getPrimaryView().getStyle(NotationPackage.Literals.FONT_STYLE);
		if(style != null) {
			setFontColor(DiagramColorRegistry.getInstance().getColor(new Integer(style.getFontColor())));
		}
	}

	/**
	 * @generated
	 */
	@Override
	protected void setFontColor(Color color) {
		getFigure().setForegroundColor(color);
	}

	@Override
	protected void setForegroundColor(Color color) {
		getPrimaryShape().setBorderColor(color);
	}
}
