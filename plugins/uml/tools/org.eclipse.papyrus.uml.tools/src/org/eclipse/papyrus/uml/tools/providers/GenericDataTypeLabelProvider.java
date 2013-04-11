/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.providers;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.emf.providers.EMFLabelProvider;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.services.labelprovider.service.IFilteredLabelProvider;
import org.eclipse.papyrus.uml.tools.utils.DataTypeUtil;
import org.eclipse.swt.graphics.Image;

/**
 * A generic Label Provider for EObjects which are instances of UML DataTypes (Defined as EClasses)
 * 
 * @author Camille Letavernier
 * 
 * @see {@link DataTypeUtil#isDataTypeDefinition(EClass)}
 */
public class GenericDataTypeLabelProvider extends EMFLabelProvider implements IFilteredLabelProvider {

	/**
	 * {@inheritDoc}
	 */
	public boolean accept(Object element) {
		if(element instanceof Collection<?>) {
			for(Object item : ((Collection<?>)element)) {
				if(!accept(item)) {
					return false;
				}
			}
			return !((Collection<?>)element).isEmpty();
		}

		EObject eObject = EMFHelper.getEObject(element);
		if(eObject == null) {
			return false;
		}
		EClass definition = eObject.eClass();
		if(definition == null) {
			return false;
		}

		return DataTypeUtil.isDataTypeDefinition(definition);
	}

	@Override
	public String getText(Object element) {
		//Initial implementation. TODO: Improve the label
		if(element instanceof Collection<?> && !(((Collection)element).isEmpty())) {
			Set<EClass> allEClasses = new HashSet<EClass>();
			for(Object item : (Collection<?>)element) {
				EObject eObject = EMFHelper.getEObject(item);
				if(eObject != null) {
					allEClasses.add(eObject.eClass());
				}
			}

			if(allEClasses.size() == 1) {
				return "Multiple " + allEClasses.iterator().next().getName() + ": " + ((Collection<?>)element).size();
			}
			return "Multiple DataTypeInstances: " + ((Collection<?>)element).size();
		} else {
			EObject dataTypeInstance = EMFHelper.getEObject(element);
			if(dataTypeInstance != null) {
				EClass dataTypeDefinition = dataTypeInstance.eClass();
				if(dataTypeDefinition != null) {
					return dataTypeDefinition.getName();
				}
			}
		}
		return "Generic DataTypeInstance";
	}

	@Override
	public Image getImage(Object element) {
		return null;
	}
}
