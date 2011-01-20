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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffPackage;
import org.eclipse.emf.compare.diff.metamodel.DifferenceKind;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChange;
import org.eclipse.emf.compare.util.AdapterUtils;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.TaggedValueReferenceChange;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UMLDiffPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tagged Value Reference Change</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.TaggedValueReferenceChangeImpl#getSubDiffElements <em>Sub Diff Elements</em>}</li>
 *   <li>{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.TaggedValueReferenceChangeImpl#getIsHiddenBy <em>Is Hidden By</em>}</li>
 *   <li>{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.TaggedValueReferenceChangeImpl#isConflicting <em>Conflicting</em>}</li>
 *   <li>{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.TaggedValueReferenceChangeImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.TaggedValueReferenceChangeImpl#isRemote <em>Remote</em>}</li>
 *   <li>{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.TaggedValueReferenceChangeImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.TaggedValueReferenceChangeImpl#getRightElement <em>Right Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.TaggedValueReferenceChangeImpl#getLeftElement <em>Left Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TaggedValueReferenceChangeImpl extends UMLDiffExtensionImpl implements TaggedValueReferenceChange {
	/**
	 * The cached value of the '{@link #getSubDiffElements() <em>Sub Diff Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubDiffElements()
	 * @generated
	 * @ordered
	 */
	protected EList<DiffElement> subDiffElements;

	/**
	 * The cached value of the '{@link #getIsHiddenBy() <em>Is Hidden By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsHiddenBy()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractDiffExtension> isHiddenBy;

	/**
	 * The default value of the '{@link #isConflicting() <em>Conflicting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConflicting()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONFLICTING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isConflicting() <em>Conflicting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConflicting()
	 * @generated
	 * @ordered
	 */
	protected boolean conflicting = CONFLICTING_EDEFAULT;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final DifferenceKind KIND_EDEFAULT = DifferenceKind.ADDITION;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected DifferenceKind kind = KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #isRemote() <em>Remote</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRemote()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REMOTE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRemote() <em>Remote</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRemote()
	 * @generated
	 * @ordered
	 */
	protected boolean remote = REMOTE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReference() <em>Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected EReference reference;

	/**
	 * The cached value of the '{@link #getRightElement() <em>Right Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightElement()
	 * @generated
	 * @ordered
	 */
	protected EObject rightElement;

	/**
	 * The cached value of the '{@link #getLeftElement() <em>Left Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftElement()
	 * @generated
	 * @ordered
	 */
	protected EObject leftElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaggedValueReferenceChangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLDiffPackage.Literals.TAGGED_VALUE_REFERENCE_CHANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DiffElement> getSubDiffElements() {
		if (subDiffElements == null) {
			subDiffElements = new EObjectContainmentEList<DiffElement>(DiffElement.class, this, UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__SUB_DIFF_ELEMENTS);
		}
		return subDiffElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractDiffExtension> getIsHiddenBy() {
		if (isHiddenBy == null) {
			isHiddenBy = new EObjectWithInverseResolvingEList.ManyInverse<AbstractDiffExtension>(AbstractDiffExtension.class, this, UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__IS_HIDDEN_BY, DiffPackage.ABSTRACT_DIFF_EXTENSION__HIDE_ELEMENTS);
		}
		return isHiddenBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isConflicting() {
		return conflicting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DifferenceKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRemote() {
		return remote;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemote(boolean newRemote) {
		boolean oldRemote = remote;
		remote = newRemote;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__REMOTE, oldRemote, remote));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReference() {
		if (reference != null && reference.eIsProxy()) {
			InternalEObject oldReference = (InternalEObject)reference;
			reference = (EReference)eResolveProxy(oldReference);
			if (reference != oldReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__REFERENCE, oldReference, reference));
			}
		}
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetReference() {
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReference(EReference newReference) {
		EReference oldReference = reference;
		reference = newReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__REFERENCE, oldReference, reference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getRightElement() {
		if (rightElement != null && rightElement.eIsProxy()) {
			InternalEObject oldRightElement = (InternalEObject)rightElement;
			rightElement = eResolveProxy(oldRightElement);
			if (rightElement != oldRightElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__RIGHT_ELEMENT, oldRightElement, rightElement));
			}
		}
		return rightElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetRightElement() {
		return rightElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRightElement(EObject newRightElement) {
		EObject oldRightElement = rightElement;
		rightElement = newRightElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__RIGHT_ELEMENT, oldRightElement, rightElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getLeftElement() {
		if (leftElement != null && leftElement.eIsProxy()) {
			InternalEObject oldLeftElement = (InternalEObject)leftElement;
			leftElement = eResolveProxy(oldLeftElement);
			if (leftElement != oldLeftElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__LEFT_ELEMENT, oldLeftElement, leftElement));
			}
		}
		return leftElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetLeftElement() {
		return leftElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftElement(EObject newLeftElement) {
		EObject oldLeftElement = leftElement;
		leftElement = newLeftElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__LEFT_ELEMENT, oldLeftElement, leftElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__IS_HIDDEN_BY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIsHiddenBy()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__SUB_DIFF_ELEMENTS:
				return ((InternalEList<?>)getSubDiffElements()).basicRemove(otherEnd, msgs);
			case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__IS_HIDDEN_BY:
				return ((InternalEList<?>)getIsHiddenBy()).basicRemove(otherEnd, msgs);
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
			case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__SUB_DIFF_ELEMENTS:
				return getSubDiffElements();
			case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__IS_HIDDEN_BY:
				return getIsHiddenBy();
			case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__CONFLICTING:
				return isConflicting();
			case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__KIND:
				return getKind();
			case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__REMOTE:
				return isRemote();
			case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__REFERENCE:
				if (resolve) return getReference();
				return basicGetReference();
			case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__RIGHT_ELEMENT:
				if (resolve) return getRightElement();
				return basicGetRightElement();
			case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__LEFT_ELEMENT:
				if (resolve) return getLeftElement();
				return basicGetLeftElement();
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
			case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__SUB_DIFF_ELEMENTS:
				getSubDiffElements().clear();
				getSubDiffElements().addAll((Collection<? extends DiffElement>)newValue);
				return;
			case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__IS_HIDDEN_BY:
				getIsHiddenBy().clear();
				getIsHiddenBy().addAll((Collection<? extends AbstractDiffExtension>)newValue);
				return;
			case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__REMOTE:
				setRemote((Boolean)newValue);
				return;
			case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__REFERENCE:
				setReference((EReference)newValue);
				return;
			case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__RIGHT_ELEMENT:
				setRightElement((EObject)newValue);
				return;
			case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__LEFT_ELEMENT:
				setLeftElement((EObject)newValue);
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
			case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__SUB_DIFF_ELEMENTS:
				getSubDiffElements().clear();
				return;
			case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__IS_HIDDEN_BY:
				getIsHiddenBy().clear();
				return;
			case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__REMOTE:
				setRemote(REMOTE_EDEFAULT);
				return;
			case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__REFERENCE:
				setReference((EReference)null);
				return;
			case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__RIGHT_ELEMENT:
				setRightElement((EObject)null);
				return;
			case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__LEFT_ELEMENT:
				setLeftElement((EObject)null);
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
			case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__SUB_DIFF_ELEMENTS:
				return subDiffElements != null && !subDiffElements.isEmpty();
			case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__IS_HIDDEN_BY:
				return isHiddenBy != null && !isHiddenBy.isEmpty();
			case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__CONFLICTING:
				return conflicting != CONFLICTING_EDEFAULT;
			case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__KIND:
				return kind != KIND_EDEFAULT;
			case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__REMOTE:
				return remote != REMOTE_EDEFAULT;
			case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__REFERENCE:
				return reference != null;
			case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__RIGHT_ELEMENT:
				return rightElement != null;
			case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__LEFT_ELEMENT:
				return leftElement != null;
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
		if (baseClass == DiffElement.class) {
			switch (derivedFeatureID) {
				case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__SUB_DIFF_ELEMENTS: return DiffPackage.DIFF_ELEMENT__SUB_DIFF_ELEMENTS;
				case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__IS_HIDDEN_BY: return DiffPackage.DIFF_ELEMENT__IS_HIDDEN_BY;
				case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__CONFLICTING: return DiffPackage.DIFF_ELEMENT__CONFLICTING;
				case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__KIND: return DiffPackage.DIFF_ELEMENT__KIND;
				case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__REMOTE: return DiffPackage.DIFF_ELEMENT__REMOTE;
				default: return -1;
			}
		}
		if (baseClass == ReferenceChange.class) {
			switch (derivedFeatureID) {
				case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__REFERENCE: return DiffPackage.REFERENCE_CHANGE__REFERENCE;
				case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__RIGHT_ELEMENT: return DiffPackage.REFERENCE_CHANGE__RIGHT_ELEMENT;
				case UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__LEFT_ELEMENT: return DiffPackage.REFERENCE_CHANGE__LEFT_ELEMENT;
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
		if (baseClass == DiffElement.class) {
			switch (baseFeatureID) {
				case DiffPackage.DIFF_ELEMENT__SUB_DIFF_ELEMENTS: return UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__SUB_DIFF_ELEMENTS;
				case DiffPackage.DIFF_ELEMENT__IS_HIDDEN_BY: return UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__IS_HIDDEN_BY;
				case DiffPackage.DIFF_ELEMENT__CONFLICTING: return UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__CONFLICTING;
				case DiffPackage.DIFF_ELEMENT__KIND: return UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__KIND;
				case DiffPackage.DIFF_ELEMENT__REMOTE: return UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__REMOTE;
				default: return -1;
			}
		}
		if (baseClass == ReferenceChange.class) {
			switch (baseFeatureID) {
				case DiffPackage.REFERENCE_CHANGE__REFERENCE: return UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__REFERENCE;
				case DiffPackage.REFERENCE_CHANGE__RIGHT_ELEMENT: return UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__RIGHT_ELEMENT;
				case DiffPackage.REFERENCE_CHANGE__LEFT_ELEMENT: return UMLDiffPackage.TAGGED_VALUE_REFERENCE_CHANGE__LEFT_ELEMENT;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (conflicting: ");
		result.append(conflicting);
		result.append(", kind: ");
		result.append(kind);
		result.append(", remote: ");
		result.append(remote);
		result.append(')');
		return result.toString();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @NOT-generated
	 */
	@Override
	public Object getImage() {
		return super.getImage();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @NOT-generated
	 */
	@Override
	public String getText() {
		final String referenceLabel = AdapterUtils.getItemProviderText(getReference());
		final String elementLabel = AdapterUtils.getItemProviderText(getLeftElement());
		final Object leftValue = getLeftElement().eGet(getReference());
		final Object rightValue = getRightElement().eGet(getReference());

		final String diffLabel;
		if(isRemote()) {
			diffLabel = String.format("Tagged reference value %s : remote = %s, local = %s", elementLabel, leftValue, rightValue);
		} else {
			diffLabel = String.format("Tagged reference value %s: %s -> %s", referenceLabel, rightValue, leftValue);
		}
		return diffLabel;
	};

} //TaggedValueReferenceChangeImpl
