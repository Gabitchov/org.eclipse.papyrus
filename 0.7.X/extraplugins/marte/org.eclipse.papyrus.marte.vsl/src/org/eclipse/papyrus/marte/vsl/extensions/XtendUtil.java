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
