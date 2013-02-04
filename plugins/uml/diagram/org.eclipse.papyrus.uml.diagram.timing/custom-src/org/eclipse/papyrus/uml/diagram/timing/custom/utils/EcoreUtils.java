/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;

public final class EcoreUtils {

	private EcoreUtils() {
		// utility class
	}

	/**
	 * Replace an EObject instance by another compatible EObject instance (replacement must be either the same type, or
	 * a subtype of original).
	 * 
	 * @param original
	 *        the object to replace
	 * @param replacement
	 *        the replacement object
	 */
	public static void replaceEObjectInstance(final EObject original, final EObject replacement) {
		final Collection<Setting> settings = EcoreUtil.UsageCrossReferencer.find(original, original.eResource().getResourceSet());

		final Set<EStructuralFeature> referencingFeatures = new HashSet<EStructuralFeature>();
		for(final Setting setting : settings) {
			referencingFeatures.add(setting.getEStructuralFeature());
		}

		// copy all the features of the original object to the replacement object
		copyFeatures(original, replacement, referencingFeatures);

		// put the replacement object in all the referencing features of the original object
		for(final Setting setting : settings) {
			final EStructuralFeature feature = setting.getEStructuralFeature();
			if(feature.isChangeable() && !feature.isDerived()) {
				// if it is already in the list, remove it and put it at the right index
				EcoreUtil.remove(setting, replacement);
				// replace the original by the replacement
				EcoreUtil.replace(setting, original, replacement);
			}
		}

		// change the container
		EcoreUtil.replace(original, replacement);
	}

	/**
	 * Copies all the features from the source object to the target object, ignoring the referencingFeatures
	 * 
	 * @param source
	 *        the object that will give its values to the target object
	 * @param target
	 *        the object that will receive its values from the source object
	 * @param referencingFeatures
	 *        features to ignore in the copy
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void copyFeatures(final EObject source, final EObject target, final Set<EStructuralFeature> referencingFeatures) {
		final EList<EStructuralFeature> eAllStructuralFeatures = source.eClass().getEAllStructuralFeatures();

		for(final EStructuralFeature feature : eAllStructuralFeatures) {
			if(referencingFeatures.contains(feature)) {
				// the value will be set through the object referencing the "from" object
				continue;
			}
			if(feature instanceof EReference) {
				final EReference reference = (EReference)feature;
				if(reference.isContainer()) {
					// the container will be set at the end
					continue;
				}
			}
			if(feature.isChangeable() && !feature.isDerived()) {
				if(feature.isMany()) {
					final Object result = source.eGet(feature);
					if(result instanceof List<?>) {
						final List list1 = (List)result;
						final List list2 = (List)target.eGet(feature);
						list2.addAll(list1);
					}
				} else {
					final Object value = source.eGet(feature);
					target.eSet(feature, value);
				}
			}
		}
	}

	/**
	 * Return the first element in the container hierarchy of the given element that is of the given class.
	 * 
	 * @param element
	 *        the starting point
	 * @param clazz
	 *        the class of the parent that is searched
	 * @return the first containing element of the given class, or <code>null</code> if none
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getContaining(final EObject element, final Class<T> clazz) {
		EObject container = element;
		while(container != null) {
			if(clazz.isInstance(container)) {
				return (T)container;
			}
			container = container.eContainer();
		}
		return null;
	}

	public static EStructuralFeature getEStructuralFeature(final Object notification) {
		EStructuralFeature featureImpl = null;
		if(notification instanceof Notification) {
			final Object feature = ((Notification)notification).getFeature();
			if(feature instanceof EStructuralFeature) {
				featureImpl = (EStructuralFeature)feature;
			}
		}
		return featureImpl;
	}
}
