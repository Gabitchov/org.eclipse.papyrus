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
public class ShadowFigureHelper {

	/**
	 * get the shadow figure indication true or false
	 * 
	 * @param modelElement
	 *        the view where is attach the element
	 */
	@Deprecated
	public static boolean getShadowFigureValue(EModelElement modelElement) {
		return AppearanceHelper.showShadow(modelElement);
	}

	/**
	 * Gets the command to set the shadow figure to true are false.
	 * 
	 * @param domain
	 *        the domain
	 * @param view
	 *        the view
	 * @param shadowFigureValue
	 *        true to display the shadow on the figure
	 * 
	 * @return the command to set the shadow to true or false.
	 */
	@Deprecated
	public static RecordingCommand getShadowColorCommand(TransactionalEditingDomain domain, EModelElement view, boolean shadowFigureValue) {
		return AnnotationStyleProvider.getSetShadowCommand(domain, view, shadowFigureValue);
	}

}
