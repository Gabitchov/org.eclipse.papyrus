/**
 * 
 *  Copyright (c) 2010 CEA LIST.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Tatiana Fesenko(CEA LIST) - initial API and implementation
 */
package org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.DiffPackage;
import org.eclipse.emf.compare.util.AdapterUtils;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.compare.UMLCompareUtils;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.CompareTwoElementsDiffModel;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UMLDiffPackage;
import org.eclipse.papyrus.compare.ui.PapyrusLabelProvider;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compare Two Elements Diff Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.CompareTwoElementsDiffModelImpl#getOwnedElements <em>Owned Elements</em>}</li>
 *   <li>{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.CompareTwoElementsDiffModelImpl#getLeftRoots <em>Left Roots</em>}</li>
 *   <li>{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.CompareTwoElementsDiffModelImpl#getRightRoots <em>Right Roots</em>}</li>
 *   <li>{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.CompareTwoElementsDiffModelImpl#getAncestorRoots <em>Ancestor Roots</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompareTwoElementsDiffModelImpl extends UMLDiffExtensionImpl implements CompareTwoElementsDiffModel {
	/**
	 * The cached value of the '{@link #getOwnedElements() <em>Owned Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedElements()
	 * @generated
	 * @ordered
	 */
	protected EList<DiffElement> ownedElements;

	/**
	 * The cached value of the '{@link #getLeftRoots() <em>Left Roots</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftRoots()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> leftRoots;

	/**
	 * The cached value of the '{@link #getRightRoots() <em>Right Roots</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightRoots()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> rightRoots;

	/**
	 * The cached value of the '{@link #getAncestorRoots() <em>Ancestor Roots</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAncestorRoots()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> ancestorRoots;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompareTwoElementsDiffModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLDiffPackage.Literals.COMPARE_TWO_ELEMENTS_DIFF_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DiffElement> getOwnedElements() {
		if (ownedElements == null) {
			ownedElements = new EObjectContainmentEList<DiffElement>(DiffElement.class, this, UMLDiffPackage.COMPARE_TWO_ELEMENTS_DIFF_MODEL__OWNED_ELEMENTS);
		}
		return ownedElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getLeftRoots() {
		if (leftRoots == null) {
			leftRoots = new EObjectResolvingEList<EObject>(EObject.class, this, UMLDiffPackage.COMPARE_TWO_ELEMENTS_DIFF_MODEL__LEFT_ROOTS);
		}
		return leftRoots;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getRightRoots() {
		if (rightRoots == null) {
			rightRoots = new EObjectResolvingEList<EObject>(EObject.class, this, UMLDiffPackage.COMPARE_TWO_ELEMENTS_DIFF_MODEL__RIGHT_ROOTS);
		}
		return rightRoots;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getAncestorRoots() {
		if (ancestorRoots == null) {
			ancestorRoots = new EObjectResolvingEList<EObject>(EObject.class, this, UMLDiffPackage.COMPARE_TWO_ELEMENTS_DIFF_MODEL__ANCESTOR_ROOTS);
		}
		return ancestorRoots;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSubchanges() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DiffElement> getDifferences(EObject modelElement) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DiffElement> getDifferences() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLDiffPackage.COMPARE_TWO_ELEMENTS_DIFF_MODEL__OWNED_ELEMENTS:
				return ((InternalEList<?>)getOwnedElements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLDiffPackage.COMPARE_TWO_ELEMENTS_DIFF_MODEL__OWNED_ELEMENTS:
				return getOwnedElements();
			case UMLDiffPackage.COMPARE_TWO_ELEMENTS_DIFF_MODEL__LEFT_ROOTS:
				return getLeftRoots();
			case UMLDiffPackage.COMPARE_TWO_ELEMENTS_DIFF_MODEL__RIGHT_ROOTS:
				return getRightRoots();
			case UMLDiffPackage.COMPARE_TWO_ELEMENTS_DIFF_MODEL__ANCESTOR_ROOTS:
				return getAncestorRoots();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UMLDiffPackage.COMPARE_TWO_ELEMENTS_DIFF_MODEL__OWNED_ELEMENTS:
				getOwnedElements().clear();
				getOwnedElements().addAll((Collection<? extends DiffElement>)newValue);
				return;
			case UMLDiffPackage.COMPARE_TWO_ELEMENTS_DIFF_MODEL__LEFT_ROOTS:
				getLeftRoots().clear();
				getLeftRoots().addAll((Collection<? extends EObject>)newValue);
				return;
			case UMLDiffPackage.COMPARE_TWO_ELEMENTS_DIFF_MODEL__RIGHT_ROOTS:
				getRightRoots().clear();
				getRightRoots().addAll((Collection<? extends EObject>)newValue);
				return;
			case UMLDiffPackage.COMPARE_TWO_ELEMENTS_DIFF_MODEL__ANCESTOR_ROOTS:
				getAncestorRoots().clear();
				getAncestorRoots().addAll((Collection<? extends EObject>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case UMLDiffPackage.COMPARE_TWO_ELEMENTS_DIFF_MODEL__OWNED_ELEMENTS:
				getOwnedElements().clear();
				return;
			case UMLDiffPackage.COMPARE_TWO_ELEMENTS_DIFF_MODEL__LEFT_ROOTS:
				getLeftRoots().clear();
				return;
			case UMLDiffPackage.COMPARE_TWO_ELEMENTS_DIFF_MODEL__RIGHT_ROOTS:
				getRightRoots().clear();
				return;
			case UMLDiffPackage.COMPARE_TWO_ELEMENTS_DIFF_MODEL__ANCESTOR_ROOTS:
				getAncestorRoots().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case UMLDiffPackage.COMPARE_TWO_ELEMENTS_DIFF_MODEL__OWNED_ELEMENTS:
				return ownedElements != null && !ownedElements.isEmpty();
			case UMLDiffPackage.COMPARE_TWO_ELEMENTS_DIFF_MODEL__LEFT_ROOTS:
				return leftRoots != null && !leftRoots.isEmpty();
			case UMLDiffPackage.COMPARE_TWO_ELEMENTS_DIFF_MODEL__RIGHT_ROOTS:
				return rightRoots != null && !rightRoots.isEmpty();
			case UMLDiffPackage.COMPARE_TWO_ELEMENTS_DIFF_MODEL__ANCESTOR_ROOTS:
				return ancestorRoots != null && !ancestorRoots.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == DiffModel.class) {
			switch (derivedFeatureID) {
				case UMLDiffPackage.COMPARE_TWO_ELEMENTS_DIFF_MODEL__OWNED_ELEMENTS: return DiffPackage.DIFF_MODEL__OWNED_ELEMENTS;
				case UMLDiffPackage.COMPARE_TWO_ELEMENTS_DIFF_MODEL__LEFT_ROOTS: return DiffPackage.DIFF_MODEL__LEFT_ROOTS;
				case UMLDiffPackage.COMPARE_TWO_ELEMENTS_DIFF_MODEL__RIGHT_ROOTS: return DiffPackage.DIFF_MODEL__RIGHT_ROOTS;
				case UMLDiffPackage.COMPARE_TWO_ELEMENTS_DIFF_MODEL__ANCESTOR_ROOTS: return DiffPackage.DIFF_MODEL__ANCESTOR_ROOTS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == DiffModel.class) {
			switch (baseFeatureID) {
				case DiffPackage.DIFF_MODEL__OWNED_ELEMENTS: return UMLDiffPackage.COMPARE_TWO_ELEMENTS_DIFF_MODEL__OWNED_ELEMENTS;
				case DiffPackage.DIFF_MODEL__LEFT_ROOTS: return UMLDiffPackage.COMPARE_TWO_ELEMENTS_DIFF_MODEL__LEFT_ROOTS;
				case DiffPackage.DIFF_MODEL__RIGHT_ROOTS: return UMLDiffPackage.COMPARE_TWO_ELEMENTS_DIFF_MODEL__RIGHT_ROOTS;
				case DiffPackage.DIFF_MODEL__ANCESTOR_ROOTS: return UMLDiffPackage.COMPARE_TWO_ELEMENTS_DIFF_MODEL__ANCESTOR_ROOTS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @NOT-generated
	 */
	@Override
	public String getText() {
		String message = "%s change(s) between elements [%s] and [%s]";
		int subchanges = ((DiffGroup)getOwnedElements().get(0)).getSubchanges();
		PapyrusLabelProvider labelProvider =  UMLCompareUtils.getInstance().getStyledPapyrusLabelProvider();
		EObject leftElement = getLeftRoots().get(0);
		String leftName = labelProvider.getText(leftElement);
		EObject rightElement = getRightRoots().get(0);
		String rightName = labelProvider.getText(rightElement);
		return String.format(message, subchanges, leftName, rightName);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @NOT-generated
	 */
	@Override
	public Object getImage() {
		// TODO Auto-generated method stub
		return super.getImage();
	}

} //CompareTwoElementsDiffModelImpl
