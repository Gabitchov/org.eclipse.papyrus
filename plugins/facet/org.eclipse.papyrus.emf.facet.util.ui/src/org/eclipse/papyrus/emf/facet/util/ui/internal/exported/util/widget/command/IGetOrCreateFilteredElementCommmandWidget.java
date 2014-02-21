/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.emf.facet.util.ui.internal.exported.util.widget.command;

import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog;

/**
 * @since 0.3
 */
public interface IGetOrCreateFilteredElementCommmandWidget<T extends Object, W extends Object>
		extends ICommandWidget {

	/**
	 * @return the selected element in the filtredList.
	 */
	T getElementSelected();

	void selectElement(T element);

	void selectElementByName(String name);

	IDialog<W> pressNewButton();

}