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
import org.eclipse.papyrus.infra.emf.appearance.commands.SetNameLabelIconCommand;

public class NameLabelIconHelper {

	/**
	 * get the display name label icon indication true or false
	 * 
	 * @param modelElement
	 *        the view where is attach the element
	 */
	public static boolean showLabelIcon(EModelElement modelElement) {
		EAnnotation displayNameLabelIcon = modelElement.getEAnnotation(VisualInformationPapyrusConstants.DISPLAY_NAMELABELICON);
		if(displayNameLabelIcon != null) {
			EMap<String, String> entries = displayNameLabelIcon.getDetails();
			if(entries != null) {
				String gradientvalueString = entries.get(VisualInformationPapyrusConstants.DISPLAY_NAMELABELICON_VALUE);
				if(gradientvalueString != null) {
					Boolean display = new Boolean(gradientvalueString);
					if(display) {
						return true;
					}
				}
			}
		}

		//CSS Value (TODO : Remove this dependency ; add an extension point)

		//		return UMLCustomStyle.getCSSElementIcon(modelElement);

		return false;
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
	 * @return the command to set the gradient to true are false.
	 */
	// @unused
	public static RecordingCommand getNameLabelIconCommand(TransactionalEditingDomain domain, EModelElement view, boolean nameLabelIconValue) {
		return new SetNameLabelIconCommand(domain, view, nameLabelIconValue);
	}

}
