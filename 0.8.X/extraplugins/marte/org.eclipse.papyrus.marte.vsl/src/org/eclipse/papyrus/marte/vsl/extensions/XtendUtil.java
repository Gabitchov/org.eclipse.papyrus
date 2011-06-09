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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.marte.vsl.extensions;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.uml2.uml.UMLPackage;

public class XtendUtil {
	public static EClass getTypeEClass() {
		return UMLPackage.eINSTANCE.getType() ;
	}
	
	public static EClass getNamespaceEClass() {
		return UMLPackage.eINSTANCE.getNamespace() ;
	}
	
	public static EClass getElementEClass() {
		return UMLPackage.eINSTANCE.getElement() ;
	}
	
	public static EClass getEClassEClass() {
		return EcorePackage.eINSTANCE.getEClass() ;
	}
	
	public static EClass getEObjectEClass() {
		return EcorePackage.eINSTANCE.getEObject() ;
	}
	
}
