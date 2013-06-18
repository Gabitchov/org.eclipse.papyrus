/**
 * Copyright (c) 2012 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *   Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 * 
 * 
 */
package org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffPackage;
import org.eclipse.emf.compare.diff.metamodel.DifferenceKind;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChange;
import org.eclipse.emf.compare.diff.metamodel.UpdateReference;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.GeneralizationTargetChangedExtension;
import org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.Uml_diff_extensionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generalization Target Changed Extension</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl.GeneralizationTargetChangedExtensionImpl#getSubDiffElements <em>Sub Diff Elements</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl.GeneralizationTargetChangedExtensionImpl#getIsHiddenBy <em>Is Hidden By</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl.GeneralizationTargetChangedExtensionImpl#isConflicting <em>Conflicting</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl.GeneralizationTargetChangedExtensionImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl.GeneralizationTargetChangedExtensionImpl#isRemote <em>Remote</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl.GeneralizationTargetChangedExtensionImpl#getRequires <em>Requires</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl.GeneralizationTargetChangedExtensionImpl#getRequiredBy <em>Required By</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl.GeneralizationTargetChangedExtensionImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl.GeneralizationTargetChangedExtensionImpl#getRightElement <em>Right Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl.GeneralizationTargetChangedExtensionImpl#getLeftElement <em>Left Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl.GeneralizationTargetChangedExtensionImpl#getLeftTarget <em>Left Target</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl.GeneralizationTargetChangedExtensionImpl#getRightTarget <em>Right Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GeneralizationTargetChangedExtensionImpl extends UMLDiffExtensionImpl implements GeneralizationTargetChangedExtension {
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
	 * The cached value of the '{@link #getRequires() <em>Requires</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequires()
	 * @generated
	 * @ordered
	 */
	protected EList<DiffElement> requires;

	/**
	 * The cached value of the '{@link #getRequiredBy() <em>Required By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredBy()
	 * @generated
	 * @ordered
	 */
	protected EList<DiffElement> requiredBy;

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
	 * The cached value of the '{@link #getLeftTarget() <em>Left Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftTarget()
	 * @generated
	 * @ordered
	 */
	protected EObject leftTarget;

	/**
	 * The cached value of the '{@link #getRightTarget() <em>Right Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightTarget()
	 * @generated
	 * @ordered
	 */
	protected EObject rightTarget;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneralizationTargetChangedExtensionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Uml_diff_extensionPackage.Literals.GENERALIZATION_TARGET_CHANGED_EXTENSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DiffElement> getSubDiffElements() {
		if (subDiffElements == null) {
			subDiffElements = new EObjectContainmentEList<DiffElement>(DiffElement.class, this, Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__SUB_DIFF_ELEMENTS);
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
			isHiddenBy = new EObjectWithInverseResolvingEList.ManyInverse<AbstractDiffExtension>(AbstractDiffExtension.class, this, Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__IS_HIDDEN_BY, DiffPackage.ABSTRACT_DIFF_EXTENSION__HIDE_ELEMENTS);
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
			eNotify(new ENotificationImpl(this, Notification.SET, Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__REMOTE, oldRemote, remote));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DiffElement> getRequires() {
		if (requires == null) {
			requires = new EObjectWithInverseResolvingEList.ManyInverse<DiffElement>(DiffElement.class, this, Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__REQUIRES, DiffPackage.DIFF_ELEMENT__REQUIRED_BY);
		}
		return requires;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DiffElement> getRequiredBy() {
		if (requiredBy == null) {
			requiredBy = new EObjectWithInverseResolvingEList.ManyInverse<DiffElement>(DiffElement.class, this, Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__REQUIRED_BY, DiffPackage.DIFF_ELEMENT__REQUIRES);
		}
		return requiredBy;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__REFERENCE, oldReference, reference));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__REFERENCE, oldReference, reference));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__RIGHT_ELEMENT, oldRightElement, rightElement));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__RIGHT_ELEMENT, oldRightElement, rightElement));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__LEFT_ELEMENT, oldLeftElement, leftElement));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__LEFT_ELEMENT, oldLeftElement, leftElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getLeftTarget() {
		if (leftTarget != null && leftTarget.eIsProxy()) {
			InternalEObject oldLeftTarget = (InternalEObject)leftTarget;
			leftTarget = eResolveProxy(oldLeftTarget);
			if (leftTarget != oldLeftTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__LEFT_TARGET, oldLeftTarget, leftTarget));
			}
		}
		return leftTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetLeftTarget() {
		return leftTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftTarget(EObject newLeftTarget) {
		EObject oldLeftTarget = leftTarget;
		leftTarget = newLeftTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__LEFT_TARGET, oldLeftTarget, leftTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getRightTarget() {
		if (rightTarget != null && rightTarget.eIsProxy()) {
			InternalEObject oldRightTarget = (InternalEObject)rightTarget;
			rightTarget = eResolveProxy(oldRightTarget);
			if (rightTarget != oldRightTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__RIGHT_TARGET, oldRightTarget, rightTarget));
			}
		}
		return rightTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetRightTarget() {
		return rightTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRightTarget(EObject newRightTarget) {
		EObject oldRightTarget = rightTarget;
		rightTarget = newRightTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__RIGHT_TARGET, oldRightTarget, rightTarget));
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
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__IS_HIDDEN_BY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIsHiddenBy()).basicAdd(otherEnd, msgs);
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__REQUIRES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRequires()).basicAdd(otherEnd, msgs);
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__REQUIRED_BY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRequiredBy()).basicAdd(otherEnd, msgs);
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
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__SUB_DIFF_ELEMENTS:
				return ((InternalEList<?>)getSubDiffElements()).basicRemove(otherEnd, msgs);
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__IS_HIDDEN_BY:
				return ((InternalEList<?>)getIsHiddenBy()).basicRemove(otherEnd, msgs);
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__REQUIRES:
				return ((InternalEList<?>)getRequires()).basicRemove(otherEnd, msgs);
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__REQUIRED_BY:
				return ((InternalEList<?>)getRequiredBy()).basicRemove(otherEnd, msgs);
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
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__SUB_DIFF_ELEMENTS:
				return getSubDiffElements();
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__IS_HIDDEN_BY:
				return getIsHiddenBy();
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__CONFLICTING:
				return isConflicting();
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__KIND:
				return getKind();
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__REMOTE:
				return isRemote();
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__REQUIRES:
				return getRequires();
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__REQUIRED_BY:
				return getRequiredBy();
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__REFERENCE:
				if (resolve) return getReference();
				return basicGetReference();
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__RIGHT_ELEMENT:
				if (resolve) return getRightElement();
				return basicGetRightElement();
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__LEFT_ELEMENT:
				if (resolve) return getLeftElement();
				return basicGetLeftElement();
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__LEFT_TARGET:
				if (resolve) return getLeftTarget();
				return basicGetLeftTarget();
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__RIGHT_TARGET:
				if (resolve) return getRightTarget();
				return basicGetRightTarget();
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
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__SUB_DIFF_ELEMENTS:
				getSubDiffElements().clear();
				getSubDiffElements().addAll((Collection<? extends DiffElement>)newValue);
				return;
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__IS_HIDDEN_BY:
				getIsHiddenBy().clear();
				getIsHiddenBy().addAll((Collection<? extends AbstractDiffExtension>)newValue);
				return;
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__REMOTE:
				setRemote((Boolean)newValue);
				return;
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__REQUIRES:
				getRequires().clear();
				getRequires().addAll((Collection<? extends DiffElement>)newValue);
				return;
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__REQUIRED_BY:
				getRequiredBy().clear();
				getRequiredBy().addAll((Collection<? extends DiffElement>)newValue);
				return;
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__REFERENCE:
				setReference((EReference)newValue);
				return;
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__RIGHT_ELEMENT:
				setRightElement((EObject)newValue);
				return;
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__LEFT_ELEMENT:
				setLeftElement((EObject)newValue);
				return;
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__LEFT_TARGET:
				setLeftTarget((EObject)newValue);
				return;
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__RIGHT_TARGET:
				setRightTarget((EObject)newValue);
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
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__SUB_DIFF_ELEMENTS:
				getSubDiffElements().clear();
				return;
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__IS_HIDDEN_BY:
				getIsHiddenBy().clear();
				return;
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__REMOTE:
				setRemote(REMOTE_EDEFAULT);
				return;
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__REQUIRES:
				getRequires().clear();
				return;
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__REQUIRED_BY:
				getRequiredBy().clear();
				return;
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__REFERENCE:
				setReference((EReference)null);
				return;
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__RIGHT_ELEMENT:
				setRightElement((EObject)null);
				return;
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__LEFT_ELEMENT:
				setLeftElement((EObject)null);
				return;
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__LEFT_TARGET:
				setLeftTarget((EObject)null);
				return;
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__RIGHT_TARGET:
				setRightTarget((EObject)null);
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
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__SUB_DIFF_ELEMENTS:
				return subDiffElements != null && !subDiffElements.isEmpty();
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__IS_HIDDEN_BY:
				return isHiddenBy != null && !isHiddenBy.isEmpty();
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__CONFLICTING:
				return conflicting != CONFLICTING_EDEFAULT;
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__KIND:
				return kind != KIND_EDEFAULT;
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__REMOTE:
				return remote != REMOTE_EDEFAULT;
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__REQUIRES:
				return requires != null && !requires.isEmpty();
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__REQUIRED_BY:
				return requiredBy != null && !requiredBy.isEmpty();
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__REFERENCE:
				return reference != null;
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__RIGHT_ELEMENT:
				return rightElement != null;
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__LEFT_ELEMENT:
				return leftElement != null;
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__LEFT_TARGET:
				return leftTarget != null;
			case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__RIGHT_TARGET:
				return rightTarget != null;
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
				case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__SUB_DIFF_ELEMENTS: return DiffPackage.DIFF_ELEMENT__SUB_DIFF_ELEMENTS;
				case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__IS_HIDDEN_BY: return DiffPackage.DIFF_ELEMENT__IS_HIDDEN_BY;
				case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__CONFLICTING: return DiffPackage.DIFF_ELEMENT__CONFLICTING;
				case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__KIND: return DiffPackage.DIFF_ELEMENT__KIND;
				case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__REMOTE: return DiffPackage.DIFF_ELEMENT__REMOTE;
				case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__REQUIRES: return DiffPackage.DIFF_ELEMENT__REQUIRES;
				case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__REQUIRED_BY: return DiffPackage.DIFF_ELEMENT__REQUIRED_BY;
				default: return -1;
			}
		}
		if (baseClass == ReferenceChange.class) {
			switch (derivedFeatureID) {
				case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__REFERENCE: return DiffPackage.REFERENCE_CHANGE__REFERENCE;
				case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__RIGHT_ELEMENT: return DiffPackage.REFERENCE_CHANGE__RIGHT_ELEMENT;
				case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__LEFT_ELEMENT: return DiffPackage.REFERENCE_CHANGE__LEFT_ELEMENT;
				default: return -1;
			}
		}
		if (baseClass == UpdateReference.class) {
			switch (derivedFeatureID) {
				case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__LEFT_TARGET: return DiffPackage.UPDATE_REFERENCE__LEFT_TARGET;
				case Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__RIGHT_TARGET: return DiffPackage.UPDATE_REFERENCE__RIGHT_TARGET;
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
				case DiffPackage.DIFF_ELEMENT__SUB_DIFF_ELEMENTS: return Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__SUB_DIFF_ELEMENTS;
				case DiffPackage.DIFF_ELEMENT__IS_HIDDEN_BY: return Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__IS_HIDDEN_BY;
				case DiffPackage.DIFF_ELEMENT__CONFLICTING: return Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__CONFLICTING;
				case DiffPackage.DIFF_ELEMENT__KIND: return Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__KIND;
				case DiffPackage.DIFF_ELEMENT__REMOTE: return Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__REMOTE;
				case DiffPackage.DIFF_ELEMENT__REQUIRES: return Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__REQUIRES;
				case DiffPackage.DIFF_ELEMENT__REQUIRED_BY: return Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__REQUIRED_BY;
				default: return -1;
			}
		}
		if (baseClass == ReferenceChange.class) {
			switch (baseFeatureID) {
				case DiffPackage.REFERENCE_CHANGE__REFERENCE: return Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__REFERENCE;
				case DiffPackage.REFERENCE_CHANGE__RIGHT_ELEMENT: return Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__RIGHT_ELEMENT;
				case DiffPackage.REFERENCE_CHANGE__LEFT_ELEMENT: return Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__LEFT_ELEMENT;
				default: return -1;
			}
		}
		if (baseClass == UpdateReference.class) {
			switch (baseFeatureID) {
				case DiffPackage.UPDATE_REFERENCE__LEFT_TARGET: return Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__LEFT_TARGET;
				case DiffPackage.UPDATE_REFERENCE__RIGHT_TARGET: return Uml_diff_extensionPackage.GENERALIZATION_TARGET_CHANGED_EXTENSION__RIGHT_TARGET;
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

} //GeneralizationTargetChangedExtensionImpl
