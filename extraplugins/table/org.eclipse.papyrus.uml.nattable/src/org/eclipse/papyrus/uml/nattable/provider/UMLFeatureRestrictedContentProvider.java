/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.nattable.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.EObjectAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;
import org.eclipse.papyrus.infra.widgets.providers.AbstractRestrictedContentProvider;
import org.eclipse.papyrus.uml.nattable.manager.axis.UMLFeatureAxisManager;
import org.eclipse.uml2.uml.UMLPackage;

public class UMLFeatureRestrictedContentProvider extends AbstractRestrictedContentProvider {

	private final UMLFeatureAxisManager umlFeatureAxisManager;

	public UMLFeatureRestrictedContentProvider(UMLFeatureAxisManager umlFeatureAxisManager, boolean isRestricted) {
		super(isRestricted);
		this.umlFeatureAxisManager = umlFeatureAxisManager;
	}

	public Object[] getElements(Object inputElement) {
		final AbstractAxisProvider secondAxisProvider = getSecondAxisProvider();
		final List<?> elements = umlFeatureAxisManager.getTableManager().getElementsList(secondAxisProvider);
		if(this.isRestricted && elements.isEmpty()) {//we must returns nothing when the table is empty
			return new Object[0];
		} else {
			return this.umlFeatureAxisManager.getAllPossibleAxis().toArray();
		}
	}

	protected AbstractAxisProvider getManagedAxisProvider() {
		return this.umlFeatureAxisManager.getRepresentedContentProvider();
	}

	protected AbstractAxisProvider getSecondAxisProvider() {
		AbstractAxisProvider secondAxisProvider = this.umlFeatureAxisManager.getTableManager().getVerticalAxisProvider();
		if(secondAxisProvider == this.umlFeatureAxisManager) {
			secondAxisProvider = this.umlFeatureAxisManager.getTableManager().getHorizontalAxisProvider();
		}
		return secondAxisProvider;
	}

	public Object[] getChildren(Object parentElement) {
		List<Object> asList = new ArrayList<Object>();
		if(parentElement instanceof EClass) {
			EClass eClass = (EClass)parentElement;
			asList.addAll(eClass.getEStructuralFeatures());
			return asList.toArray();
		} else if(parentElement instanceof EPackage) {
			EPackage ePackage = (EPackage)parentElement;
			Collection<EClassifier> eClassifiers = null;
			if(this.isRestricted) {
				eClassifiers = new HashSet<EClassifier>();
				AbstractAxisProvider axisProvider = ((INattableModelManager)this.umlFeatureAxisManager.getTableManager()).getHorizontalAxisProvider();
				if(axisProvider == this.umlFeatureAxisManager.getRepresentedContentProvider()) {
					axisProvider = ((INattableModelManager)this.umlFeatureAxisManager.getTableManager()).getVerticalAxisProvider();
				}
				List<Object> elementsList = this.umlFeatureAxisManager.getTableManager().getElementsList(axisProvider);
				for(Object object : elementsList) {
					if(object instanceof EObject) {
						EObject eObject = (EObject)object;
						if(eObject instanceof EObjectAxis) {
							eObject = ((EObjectAxis)eObject).getElement();
						}
						EClass eClass = eObject.eClass();
						eClassifiers.add(eClass);
						eClassifiers.addAll(eClass.getEAllSuperTypes());
					}
				}
			} else {
				eClassifiers = ePackage.getEClassifiers();
			}
			for(EClassifier eClassifier : eClassifiers) {
				if(eClassifier instanceof EClass) {
					asList.add(eClassifier);
				}
			}
			return asList.toArray();
		}
		return null;

	}

	public Object getParent(Object element) {
		if(element instanceof EStructuralFeature) {
			EStructuralFeature feature = (EStructuralFeature)element;
			return feature.getEContainingClass();
		} else if(element instanceof EClass) {
			EClass eClass = (EClass)element;
			return eClass.getEPackage();
		}
		return null;
	}

	public boolean hasChildren(Object element) {
		if(element instanceof EClass) {
			EClass eClass = (EClass)element;
			boolean hasChildren = !eClass.getEStructuralFeatures().isEmpty();
			return hasChildren;
		} else if(element instanceof EPackage) {
			EPackage ePackage = (EPackage)element;
			EList<EClassifier> eClassifiers = ePackage.getEClassifiers();
			for(EClassifier eClassifier : eClassifiers) {
				if(eClassifier instanceof EClass) {
					return true;
				}
			}
			return false;
		} else if(element instanceof EStructuralFeature) {
			return false;
		}
		return false;
	}

	public Object[] getElements() {
		return getElements(null);
	}

	public boolean isValidValue(Object element) {
		return element instanceof EStructuralFeature && UMLPackage.eINSTANCE.eContents().contains(((EObject)element).eContainer());
	}
}
