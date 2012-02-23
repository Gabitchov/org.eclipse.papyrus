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
public class QualifiedNameHelper {

	/**
	 * get the depth to display for the qualified name from a eannotation in the view
	 * 
	 * @param modelElement
	 *        the view where is attach the element
	 * @return the depth
	 */
	@Deprecated
	public static int getQualifiedNameDepth(EModelElement modelElement) {
		return AppearanceHelper.getQualifiedNameDepth(modelElement);
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
	 * @return the set qualified name depth command
	 */
	@Deprecated
	public static RecordingCommand getSetQualifedNameDepthCommand(TransactionalEditingDomain domain, EModelElement view, int depth) {
		return AnnotationStyleProvider.getSetQualifiedNameDepthCommand(domain, view, depth);
	}

}
