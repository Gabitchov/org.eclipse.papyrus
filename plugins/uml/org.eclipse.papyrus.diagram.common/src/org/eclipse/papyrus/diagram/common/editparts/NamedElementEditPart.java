/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.figure.node.NodeNamedElementFigure;
import org.eclipse.papyrus.editor.PapyrusConstant;
import org.eclipse.uml2.uml.NamedElement;

/**
 * this editpart manage the display of qualifiedName
 * 
 */
public abstract class NamedElementEditPart extends UmlNodeEditPart {

	/**
	 * {@inheritDoc}
	 */
	public NamedElementEditPart(View view) {
		super(view);
		// TODO Auto-generated constructor stub
	}

	/**
	 * get the depth to display for the qualified name from a eannotation in the view
	 * 
	 * @return the depth
	 */
	public int getQualifiedNamedepth() {
		EAnnotation stereotypeDisplayKind = ((View) getModel()).getEAnnotation(PapyrusConstant.QUALIFIED_NAME);
		if (stereotypeDisplayKind != null) {
			EMap<String, String> entries = stereotypeDisplayKind.getDetails();

			if (entries != null) {
				String depthString = entries.get(PapyrusConstant.QUALIFIED_NAME_DEPTH);
				if (!depthString.isEmpty()) {
					Integer i = new Integer(depthString);
					return i.intValue();
				}
			}
		}
		return 0;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);

		// set the figure active when the feature of the of a class is true
		if (resolveSemanticElement() != null) {
			((NodeNamedElementFigure) getPrimaryShape()).setDepth(getQualifiedNamedepth());
			((NodeNamedElementFigure) getPrimaryShape()).setQualifiedName(((NamedElement) resolveSemanticElement()).getQualifiedName());
			if (getParent() != null) {
				refreshVisuals();
			}
		}
	}
}
