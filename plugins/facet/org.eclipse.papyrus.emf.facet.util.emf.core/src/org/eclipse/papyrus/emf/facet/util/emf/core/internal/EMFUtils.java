/*******************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	  Nicolas Bros (Mia-Software) - Bug 340588 - Least common supertype
 *    Vincent Lorenzo (CEA-LIST) - bug 341328 - We need to be able to specify which column have to be hidden/visible using the customization mechanism
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.util.emf.core.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

public final class EMFUtils {

	private EMFUtils() {
		// prevent instantiation
	}

	/**
	 * Computes the least common supertype of all the given metaclasses. That is, the most derived
	 * type that is a supertype of all the given classes.
	 * 
	 * @param classes
	 *            the list of metaclasses
	 * 
	 * @return the least common supertype of all the given metaclasses, or <code>null</code> if
	 *         there is none, or several. In this case, the only common supertype can be considered
	 *         as {@link EObject} .
	 */
	public static EClass computeLeastCommonSupertype(final Collection<EClass> classes) {
		return computeLeastCommonSupertype(classes, null);
	}

	/**
	 * Computes the least common supertype of all the given metaclasses. That is, the most derived
	 * type that is a supertype of all the given classes.
	 * 
	 * @param classes
	 *            the list of metaclasses
	 * @param feature
	 *            if not <code>null</code>, then only metaclasses that contain this feature will be
	 *            considered
	 * 
	 * @return the least common supertype of all the given metaclasses, or the {@link EObject}
	 *         {@link EClass} if there is none, or several.
	 */
	public static EClass computeLeastCommonSupertype(final Collection<EClass> classes,
			final EStructuralFeature feature) {
		Set<EClass> commonClasses = new HashSet<EClass>();
		Iterator<EClass> iterator = classes.iterator();
		boolean first = true;
		while (iterator.hasNext()) {
			EClass eClass = iterator.next();
			if (first) {
				commonClasses.addAll(eClass.getEAllSuperTypes());
				commonClasses.add(eClass);
				first = false;
			} else {
				List<EClass> filter = new ArrayList<EClass>(eClass.getEAllSuperTypes());
				filter.add(eClass);
				commonClasses.retainAll(filter);
			}
		}

		Collection<EClass> commonClassesFiltered;
		// keep only metaclasses that contain the feature
		if (feature != null) {
			commonClassesFiltered = new ArrayList<EClass>();
			for (EClass eClass : commonClasses) {
				if (eClass.getEAllStructuralFeatures().contains(feature)) {
					commonClassesFiltered.add(eClass);
				}
			}
		} else {
			commonClassesFiltered = commonClasses;
		}

		// handle the easy (and common) cases early
		int size = commonClassesFiltered.size();
		if (size == 0) {
			return EcorePackage.eINSTANCE.getEObject();
		}
		if (size == 1) {
			return commonClassesFiltered.iterator().next();
		}

		// now, remove EClasses that are not a direct or indirect sub- or super-type
		// of all the other classes.
		ArrayList<EClass> list = new ArrayList<EClass>(commonClassesFiltered);
		ListIterator<EClass> listIterator = list.listIterator();
		while (listIterator.hasNext()) {
			EClass eClass = listIterator.next();
			for (EClass eClass2 : commonClassesFiltered) {
				if (eClass != eClass2 && !eClass.isSuperTypeOf(eClass2)
						&& !eClass2.isSuperTypeOf(eClass)) {
					listIterator.remove();
					break;
				}
			}
		}

		int size2 = list.size();
		if (size2 == 0) {
			return EcorePackage.eINSTANCE.getEObject();
		}
		if (size2 == 1) {
			return list.iterator().next();
		}

		// now commonClasses only contains classes in the same hierarchy,
		// so we can sort them using a "is subtype of" comparison operator

		Collections.sort(list, new Comparator<EClass>() {
			public int compare(final EClass e1, final EClass e2) {
				if (e1 == e2) {
					return 0;
				} else if (e1.isSuperTypeOf(e2)) {
					return 1;
				} else if (e2.isSuperTypeOf(e1)) {
					return -1;
				} else {
					throw new IllegalStateException("comparing classes not in the same hierarchy"); //$NON-NLS-1$
				}
			}
		});

		if (list.isEmpty()) {
			return EcorePackage.eINSTANCE.getEObject();
		}
		return list.get(0);
	}
	

	public static Set<EClass> getAllFeatureOwner(final List<EObject> elements,
			final EStructuralFeature feature) {
		Set<EClass> owners = new HashSet<EClass>();
		for (EObject el : elements) {
			if (el.eClass().getEAllStructuralFeatures().contains(feature)) {
				owners.add(el.eClass());
			}
		}
		return owners;
	}
	
}
