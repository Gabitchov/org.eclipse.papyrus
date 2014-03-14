/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.ICommandWidget;

/**
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IENamedElementWidget<C extends EObject, CW extends Object>
		extends ICommandWidget {

	/**
	 * Press the get or create parent button.
	 * 
	 * @return the dialog open when the button is pressed.
	 */
	IDialog<CW> pressParentButton();

	/**
	 * @return the name of the element.
	 */
	String getElementName();

	/**
	 * Set the name of the element.
	 * 
	 * @param value
	 *            the name.
	 */
	void setName(String value);

	C getContainer();

}
