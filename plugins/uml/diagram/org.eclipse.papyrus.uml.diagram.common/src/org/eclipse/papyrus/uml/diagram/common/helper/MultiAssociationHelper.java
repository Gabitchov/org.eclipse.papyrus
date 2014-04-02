/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.helper;

import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Property;


public class MultiAssociationHelper extends ElementHelper {

	protected static final String SEMANTIC_BRANCH = "Semantic_Branch_Style"; //$NON-NLS-1$

	public static Property getSemanticBranchEnd(View view) {
		org.eclipse.gmf.runtime.notation.EObjectValueStyle semanticStyle = (org.eclipse.gmf.runtime.notation.EObjectValueStyle)view.getNamedStyle(NotationPackage.eINSTANCE.getEObjectValueStyle(), SEMANTIC_BRANCH);
		return semanticStyle == null ? null : (Property)semanticStyle.getEObjectValue();
	}

	public static void setSemanticBranchEnd(View view, Property end) {
		org.eclipse.gmf.runtime.notation.EObjectValueStyle semanticStyle = (org.eclipse.gmf.runtime.notation.EObjectValueStyle)view.getNamedStyle(NotationPackage.eINSTANCE.getEObjectValueStyle(), SEMANTIC_BRANCH);
		semanticStyle.setEObjectValue(end);
	}
}
