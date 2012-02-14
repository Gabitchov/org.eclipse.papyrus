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

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.appearance.commands.SetShadowFigureCommand;

public class ShadowFigureHelper {

	/**
	 * get the shadow figure indication true or false
	 * 
	 * @param modelElement
	 *        the view where is attach the element
	 */
	public static boolean getShadowFigureValue(EModelElement modelElement) {
		EAnnotation shadowAnnotation = modelElement.getEAnnotation(VisualInformationPapyrusConstants.SHADOWFIGURE);
		if(shadowAnnotation != null) {
			EMap<String, String> entries = shadowAnnotation.getDetails();

			if(entries != null) {
				String gradientvalueString = entries.get(VisualInformationPapyrusConstants.SHADOWFIGURE_VALUE);
				if(gradientvalueString != null) {
					Boolean b = new Boolean(gradientvalueString);
					if(b) {
						return true;
					}
				}
			}
		}
		//CSS Value (TODO : Remove this dependency ; add an extension point)

		//		if(modelElement instanceof UMLCustomStyle) {
		//			UMLCustomStyle cssElement = (UMLCustomStyle)modelElement;
		//			return cssElement.getCSSShadow();
		//		}

		return false;
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
	 * @return the command to set the gradient to true are false.
	 */
	// @unused
	public static RecordingCommand getShadowColorCommand(TransactionalEditingDomain domain, EModelElement view, boolean shadowFigureValue) {
		return new SetShadowFigureCommand(domain, view, shadowFigureValue);
	}

}
