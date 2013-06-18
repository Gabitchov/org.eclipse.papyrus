/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.stereotype.edition.editpart;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Graphics;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.ConnectionEditPart;


/**
 * 
 * The editpart AppliedSterotypesCommentLinkEditPart, the link between the stereotyped element and the comment.
 * 
 */

public class AppliedStereotypesCommentLinkEditPart extends ConnectionEditPart {

	public static final String ID = "AppliedStereotypesCommentLink";

	public AppliedStereotypesCommentLinkEditPart(View view) {
		super(view);
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	@Override
	protected Connection createConnectionFigure() {
		return new AppliedStereotypesCommentLink();
	}

	/**
	 * @generated
	 */
	public AppliedStereotypesCommentLink getPrimaryShape() {
		return (AppliedStereotypesCommentLink)getFigure();
	}

	/**
	 * @generated
	 */
	public class AppliedStereotypesCommentLink extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		public AppliedStereotypesCommentLink() {
			this.setLineStyle(Graphics.LINE_DASH);
		}
	}
}
