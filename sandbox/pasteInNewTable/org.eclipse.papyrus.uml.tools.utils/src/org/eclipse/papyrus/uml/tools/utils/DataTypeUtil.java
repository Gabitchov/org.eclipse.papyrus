/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.utils;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * this class contains util methods about UML DataType
 *
 */
public class DataTypeUtil {

	/**
	 * test if the eclass is a definition of a dataType
	 * @param eclass the eclass that will be tested
	 * @return true if this is a definition of a DataType else false
	 */
	public static boolean isDataTypeDefinition(EClass eclass){
		if(eclass.getEAnnotations().size() > 0) {
			UMLPackage.eINSTANCE.getNsURI();
			EAnnotation eAnnotation = eclass.getEAnnotation(UMLUtil.UML2_UML_PACKAGE_2_0_NS_URI);
			if(eAnnotation!=null) {
				if((eAnnotation.getReferences().get(0) instanceof org.eclipse.uml2.uml.DataType)) {
					return true;
				}
			}

		}
		return false;

	}
}