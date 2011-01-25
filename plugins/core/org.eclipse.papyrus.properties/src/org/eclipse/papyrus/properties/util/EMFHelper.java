/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.util;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.properties.Activator;

public class EMFHelper {

	public static EClass getEClass(String nsUri, String className) {
		EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(nsUri);
		if(ePackage == null) {
			Activator.log.warn("Cannot find an EPackage matching the nsURI " + nsUri); //$NON-NLS-1$
			return null;
		}
		return getEClass(ePackage, className);
	}

	public static EClass getEClass(EPackage metamodel, String className) {
		EClassifier classifier = metamodel.getEClassifier(className);
		if(classifier == null) {
			Activator.log.warn("Classifier " + className + " not found in metamodel " + metamodel.getName() + " (" + metamodel.getNsURI() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		}
		if(classifier instanceof EClass) {
			return (EClass)classifier;
		} else {
			Activator.log.warn("Classifier " + className + " in " + metamodel.getName() + " (" + metamodel.getNsURI() + ") is not an EClass"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		}

		return null;
	}

	public static boolean isSubclass(EObject element, String className, EPackage metamodel) {

		EClassifier superClass = metamodel.getEClassifier(className);

		if(superClass == null) {
			Activator.log.warn("Class " + className + " not found in Metamodel : " + metamodel.getName() + " (" + metamodel.getNsURI() + ")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
			return false;
		}

		return superClass.isInstance(element);
	}

	public static boolean isSubclass(EClass eClass, EClass fromClass) {
		List<EClass> superTypes = eClass.getESuperTypes();
		if(superTypes.contains(fromClass)) {
			return true;
		} else {
			for(EClass superClass : superTypes) {
				if(isSubclass(superClass, fromClass))
					return true;
			}
		}
		return false;
	}

	/**
	 * Returns the EObject corresponding to the input object
	 * Tests if the input is an EObject, or if it is Adaptable
	 * to an EObject
	 * 
	 * @param source
	 * @return An EObject corresponding to the input source, or null
	 *         if the EObject could not be resolved
	 */
	public static EObject getEObject(Object source) {
		if(source instanceof EObject)
			return (EObject)source;
		else if(source instanceof IAdaptable)
			return (EObject)((IAdaptable)source).getAdapter(EObject.class);

		return null;
	}
}
