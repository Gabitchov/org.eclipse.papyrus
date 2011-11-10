/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.runtime.modelhandler.emf;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;


/**
 * Util class for EMF and UML
 */
public class EMFUtils {

	/**
	 * Retrieve a {@link EStructuralFeature} by its name
	 * 
	 * @param objectToEdit
	 *        the object being edited
	 * @param featureName
	 *        the name of the feature to retrieve
	 * @return the feature found <code>null</code> if not found
	 */
	public static EStructuralFeature getFeatureByName(EObject objectToEdit, String featureName) {
		EStructuralFeature feature = objectToEdit.eClass().getEStructuralFeature(featureName);
		if(feature != null) {
			return feature;
		}
		Activator.log.error("impossible to find feature " + featureName + " for object " + objectToEdit, null);
		return null;
	}

	/**
	 * Retrieve the stereotype structural feature
	 * 
	 * @param elementToEdit
	 *        the UML element on which the stereotype is applied
	 * @param stereotype
	 *        the stereotype for which estructural feature is searched
	 * @param featureName
	 *        the name of the feature to find
	 * @return the feature found or <code>null</code>
	 */
	public static EStructuralFeature getStereotypeFeatureByName(Element elementToEdit, Stereotype stereotype, String featureName) {
		EObject eObject = elementToEdit.getStereotypeApplication(stereotype);

		if(eObject == null) {
			Activator.log.error("Impossible to find stereotype application", null);
			return null;
		}

		EClass eClass = eObject.eClass();
		String[] segments = featureName.split(NamedElement.SEPARATOR);

		String segment = segments[0];
		EStructuralFeature eStructuralFeature = null;

		if(segment.indexOf('[') == -1) {
			eStructuralFeature = eClass.getEStructuralFeature(UML2Util.getValidJavaIdentifier(segment));
		} else {
			eStructuralFeature = eClass.getEStructuralFeature(UML2Util.getValidJavaIdentifier(segment.substring(0, segment.indexOf('['))));
		}

		if(eStructuralFeature == null) {
			Activator.log.error("Impossible to find structural feature", null);
			return null;
		}

		return eStructuralFeature;
	}

	/**
	 * Returns the editing domain for a set of elements
	 * 
	 * @param objects
	 *        the objects from which the editing domain can be retrieved
	 * @return the editing domain found or <code>null</code>
	 */
	public static TransactionalEditingDomain getTransactionalEditingDomain(List<? extends Object> objects) {
		TransactionalEditingDomain editingDomain = null;
		Iterator<? extends Object> it2 = objects.iterator();
		while(it2.hasNext() && editingDomain == null) {
			editingDomain = TransactionUtil.getEditingDomain(it2.next());
		}

		// if impossible to find editing domain this way: Tries the Papyrus service
		if(editingDomain == null) {
			editingDomain = EditorUtils.getTransactionalEditingDomain();
		}
		return editingDomain;
	}

}
