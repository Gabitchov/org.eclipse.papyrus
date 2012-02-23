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
package org.eclipse.papyrus.infra.emf.appearance.helper;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.appearance.style.AnnotationStyleProvider;

/**
 * @deprecated Use AppearanceHelper (For getters) or AnnotationStyleProvider
 *             (For Commands) instead.
 */
@Deprecated
public class NameLabelIconHelper {

	/**
	 * get the display name label icon indication true or false
	 * 
	 * @param modelElement
	 *        the view where is attach the element
	 */
	@Deprecated
	public static boolean showLabelIcon(EModelElement modelElement) {
		return AppearanceHelper.showElementIcon(modelElement);
	}

	/**
	 * Gets the command to set the gradient to true are false.
	 * 
	 * @param domain
	 *        the domain
	 * @param view
	 *        the view
	 * @param nameLabelIconValue
	 *        true to display the icon of the element in labelName
	 * 
	 * @return the command to set the elementIcon to true are false.
	 */
	@Deprecated
	public static RecordingCommand getNameLabelIconCommand(TransactionalEditingDomain domain, EModelElement view, boolean nameLabelIconValue) {
		return AnnotationStyleProvider.getSetElementIconCommand(domain, view, nameLabelIconValue);
	}

}
