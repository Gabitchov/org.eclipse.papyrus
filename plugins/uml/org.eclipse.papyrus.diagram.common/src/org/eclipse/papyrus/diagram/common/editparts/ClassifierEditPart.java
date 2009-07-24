/****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Thibault Landre (Atos Origin) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.editparts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Classifier edit part.
 * 
 * @author tlandre
 */
public abstract class ClassifierEditPart extends NamedElementEditPart {

	/**
	 * isAbstract Classifier property
	 */
	private boolean isAbstract;

	/**
	 * Constructor
	 * 
	 * @param view
	 */
	public ClassifierEditPart(View view) {
		super(view);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);
		Object feature = notification.getFeature();

		// Manage isAbstract
		if (UMLPackage.eINSTANCE.getClassifier_IsAbstract().equals(feature)) {
			isAbstract = notification.getNewBooleanValue();
			refreshFont();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected FontData getFontData(FontStyle style) {
		return new FontData(style.getFontName(), style.getFontHeight(), (style.isBold() ? SWT.BOLD : SWT.NORMAL)
				| (isAbstract ? SWT.ITALIC : (style.isItalic() ? SWT.ITALIC : SWT.NORMAL)));
	}

}
