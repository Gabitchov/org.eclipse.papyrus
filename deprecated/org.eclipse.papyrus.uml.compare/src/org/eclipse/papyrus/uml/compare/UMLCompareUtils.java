/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.compare;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * The Class UMLCompareUtils.
 */
public class UMLCompareUtils {

	/**
	 * Checks if is stereotype application.
	 *
	 * @param eObject the e object
	 * @return true, if is stereotype application
	 */
	public static boolean isStereotypeApplication(EObject eObject) {
		return UMLUtil.getStereotype(eObject) != null;
	}

}
