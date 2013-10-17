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
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.EObjectAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;
import org.eclipse.papyrus.infra.widgets.providers.AbstractRestrictedContentProvider;
import org.eclipse.papyrus.uml.nattable.manager.axis.UMLFeatureAxisManager;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * 
 * @author vl222926
 * 
 */
public class UMLFeatureRestrictedContentProvider extends AbstractRestrictedContentProvider {

	/** the uml feature axis manager */
	private final UMLFeatureAxisManager axisManager;


	/**
	 * 
	 * Constructor.
	 * boolean fields are initialized to false
	 * 
	 * @param axisManager
	 *        the axis manager used by this content provider
	 */
	public UMLFeatureRestrictedContentProvider(final UMLFeatureAxisManager axisManager) {
		this(axisManager, false);
	}

	/**
	 * 
	 * Constructor.
	 * Inits {@link #ignoreInheritedFeatures} to true
	 * others boolean fields are initialized to false
	 * 
	 * @param axisManager
	 *        the axis manager used by this content provider
	 * @param isRestricted
	 *        if <code>true</code> we return only elements accessible from the current contents of the table
	 */
	public UMLFeatureRestrictedContentProvider(UMLFeatureAxisManager axisManager, boolean isRestricted) {
		super(isRestricted);
		this.axisManager = axisManager;
		setIgnoreInheritedElements(false);
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getElements(java.lang.Object)
	 * 
	 * @param inputElement
	 * @return
	 */
	public Object[] getElements(Object inputElement) {
		if(isRestricted()) {
			final boolean columnManager = axisManager.isUsedAsColumnManager();
			final List<?> elements;
			if(columnManager) {
				elements = this.axisManager.getTableManager().getRowElementsList();
			} else {
				elements = this.axisManager.getTableManager().getColumnElementsList();
			}
			if(elements.isEmpty()) {//we returns nothing in restricted mode when the table is empty
				return new Object[0];
			}
		}
		return new Object[]{ UMLPackage.eINSTANCE };

		//		if(isRestricted() && elements.isEmpty()) {//we must returns nothing when the table is empty
		//			return new Object[0];
		//		} else {
		//			return this.axisManager.getAllPossibleAxis().toArray();
		//		}
	}

	/**
	 * 
	 * @return
	 */
	protected AbstractAxisProvider getManagedAxisProvider() {
		return this.axisManager.getRepresentedContentProvider();
	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 * 
	 * @param parentElement
	 * @return
	 */
	public Object[] getChildren(Object parentElement) {
		List<Object> asList = new ArrayList<Object>();
		if(parentElement instanceof EClass) {
			EClass eClass = (EClass)parentElement;
			if(isIgnoringInheritedElements()) {
				asList.addAll(eClass.getEStructuralFeatures());
			} else {
				asList.addAll(eClass.getEAllStructuralFeatures());
			}
			return asList.toArray();
		} else if(parentElement instanceof EPackage) {
			EPackage ePackage = (EPackage)parentElement;
			Collection<EClassifier> eClassifiers = null;
			if(isRestricted()) {
				eClassifiers = new HashSet<EClassifier>();
				AbstractAxisProvider axisProvider = ((INattableModelManager)this.axisManager.getTableManager()).getHorizontalAxisProvider();
				if(axisProvider == this.axisManager.getRepresentedContentProvider()) {
					axisProvider = ((INattableModelManager)this.axisManager.getTableManager()).getVerticalAxisProvider();
				}
				boolean isColumnManager = this.axisManager.isUsedAsColumnManager();
				final List<Object> elementsList;
				if(isColumnManager) {
					elementsList = this.axisManager.getTableManager().getRowElementsList();
				} else {
					elementsList = this.axisManager.getTableManager().getColumnElementsList();
				}
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
			eClassifiers.remove(EcorePackage.eINSTANCE.getEModelElement());

			for(EClassifier eClassifier : eClassifiers) {
				if(eClassifier instanceof EClass && eClassifier != EcorePackage.eINSTANCE.getEModelElement()) {
					asList.add(eClassifier);//we returns EClass with no EStructural feature too
				}
			}
			return asList.toArray();
		}
		return null;

	}

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
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

	/**
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
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

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider#getElements()
	 * 
	 * @return
	 */
	public Object[] getElements() {
		return getElements(null);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.widgets.providers.IHierarchicContentProvider#isValidValue(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 *         <code>true</code> if the element is a UML Feature
	 */
	public boolean isValidValue(Object element) {
		return element instanceof EStructuralFeature && UMLPackage.eINSTANCE.eContents().contains(((EObject)element).eContainer());
	}
}
