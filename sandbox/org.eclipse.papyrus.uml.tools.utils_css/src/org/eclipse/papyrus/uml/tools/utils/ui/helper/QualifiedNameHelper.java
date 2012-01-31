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
package org.eclipse.papyrus.uml.tools.utils.ui.helper;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.custom.UMLCustomStyle;
import org.eclipse.papyrus.uml.tools.utils.ui.VisualInformationPapyrusConstant;
import org.eclipse.papyrus.uml.tools.utils.ui.command.SetQualifiedNameDepthCommand;

public class QualifiedNameHelper {

	/**
	 * get the depth to display for the qualified name from a eannotation in the view
	 * 
	 * @param modelElement
	 *        the view where is attach the element
	 * @return the depth
	 */
	public static int getQualifiedNameDepth(EModelElement modelElement) {
		EAnnotation stereotypeDisplayKind = modelElement.getEAnnotation(VisualInformationPapyrusConstant.QUALIFIED_NAME);
		if(stereotypeDisplayKind != null) {
			EMap<String, String> entries = stereotypeDisplayKind.getDetails();

			if(entries != null) {
				String depthString = entries.get(VisualInformationPapyrusConstant.QUALIFIED_NAME_DEPTH);
				if(depthString != null) {
					Integer i = new Integer(depthString);
					if(i != 1000) {
						return i.intValue();
					}
				}
			}
		}

		//CSS Value (TODO : Remove this dependency ; add an extension point)

		if(modelElement instanceof UMLCustomStyle) {
			UMLCustomStyle cssElement = (UMLCustomStyle)modelElement;
			return cssElement.getCSSQualifiedNameDepth();
		}

		return 0;
	}

	/**
	 * Gets the sets the qualifed name depth command.
	 * 
	 * @param domain
	 *        the domain
	 * @param view
	 *        the view
	 * @param depth
	 *        the depth
	 * 
	 * @return the sets the qualifed name depth command
	 */
	// @unused
	public static RecordingCommand getSetQualifedNameDepthCommand(TransactionalEditingDomain domain, EModelElement view, int depth) {
		return new SetQualifiedNameDepthCommand(domain, view, depth);
	}

}
