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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.figure.node.HTMLCornerBentFigure;
import org.eclipse.papyrus.diagram.common.figure.node.IPapyrusNodeFigure;
import org.eclipse.swt.graphics.Color;

/**
 * this is a abstract editpart to display a comment
 */
public class AbstractCommentEditPart extends NodeEditPart {

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
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);

		// set the figure active when the feature of the of a class is true
		if(resolveSemanticElement() != null) {
			refreshFontColor();

		}
	}

	/**
	 * Refresh figure's background transparency.
	 * 
	 * @since 1.2
	 */
	protected void refreshTransparency() {
		FillStyle style = (FillStyle)getPrimaryView().getStyle(NotationPackage.Literals.FILL_STYLE);
		if(style.getGradient() != null) {
			setTransparency(style.getTransparency());
		} else {
			setTransparency(0);
		}
	}

	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshFontColor();

	}

	/** Refresh the editpart's figure font color. */
	protected void refreshFontColor() {
		FontStyle style = (FontStyle)getPrimaryView().getStyle(NotationPackage.Literals.FONT_STYLE);
		if(style != null) {
			setFontColor(DiagramColorRegistry.getInstance().getColor(new Integer(style.getFontColor())));
		}
	}

	/**
	 * @generated
	 */
	protected void setFontColor(Color color) {
		getFigure().setForegroundColor(color);
	}

	protected void setForegroundColor(Color color) {
		getPrimaryShape().setBorderColor(color);
	}
}
