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
import org.eclipse.emf.compare.diff.merge.IMerger;
import org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffPackage;
import org.eclipse.emf.compare.diff.metamodel.DifferenceKind;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChange;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeRightTarget;
import org.eclipse.emf.compare.util.AdapterUtils;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.compare.UMLCompareUtils;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.AddStereotypeApplication;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UMLDiffPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Add Stereotype Application</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.AddStereotypeApplicationImpl#getSubDiffElements <em>Sub Diff Elements</em>}</li>
 *   <li>{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.AddStereotypeApplicationImpl#getIsHiddenBy <em>Is Hidden By</em>}</li>
 *   <li>{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.AddStereotypeApplicationImpl#isConflicting <em>Conflicting</em>}</li>
 *   <li>{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.AddStereotypeApplicationImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.AddStereotypeApplicationImpl#isRemote <em>Remote</em>}</li>
 *   <li>{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.AddStereotypeApplicationImpl#getLeftParent <em>Left Parent</em>}</li>
 *   <li>{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.AddStereotypeApplicationImpl#getRightElement <em>Right Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AddStereotypeApplicationImpl extends StereotypeChangeImpl implements AddStereotypeApplication {
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
	 * The cached value of the '{@link #getLeftParent() <em>Left Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftParent()
	 * @generated
	 * @ordered
	 */
	protected EObject leftParent;
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddStereotypeApplicationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLDiffPackage.Literals.ADD_STEREOTYPE_APPLICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DiffElement> getSubDiffElements() {
		if (subDiffElements == null) {
			subDiffElements = new EObjectContainmentEList<DiffElement>(DiffElement.class, this, UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__SUB_DIFF_ELEMENTS);
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
			isHiddenBy = new EObjectWithInverseResolvingEList.ManyInverse<AbstractDiffExtension>(AbstractDiffExtension.class, this, UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__IS_HIDDEN_BY, DiffPackage.ABSTRACT_DIFF_EXTENSION__HIDE_ELEMENTS);
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__REMOTE, oldRemote, remote));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getLeftParent() {
		if (leftParent != null && leftParent.eIsProxy()) {
			InternalEObject oldLeftParent = (InternalEObject)leftParent;
			leftParent = eResolveProxy(oldLeftParent);
			if (leftParent != oldLeftParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__LEFT_PARENT, oldLeftParent, leftParent));
			}
		}
		return leftParent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetLeftParent() {
		return leftParent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftParent(EObject newLeftParent) {
		EObject oldLeftParent = leftParent;
		leftParent = newLeftParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__LEFT_PARENT, oldLeftParent, leftParent));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__RIGHT_ELEMENT, oldRightElement, rightElement));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__RIGHT_ELEMENT, oldRightElement, rightElement));
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
			case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__IS_HIDDEN_BY:
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
			case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__SUB_DIFF_ELEMENTS:
				return ((InternalEList<?>)getSubDiffElements()).basicRemove(otherEnd, msgs);
			case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__IS_HIDDEN_BY:
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
			case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__SUB_DIFF_ELEMENTS:
				return getSubDiffElements();
			case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__IS_HIDDEN_BY:
				return getIsHiddenBy();
			case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__CONFLICTING:
				return isConflicting();
			case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__KIND:
				return getKind();
			case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__REMOTE:
				return isRemote();
			case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__LEFT_PARENT:
				if (resolve) return getLeftParent();
				return basicGetLeftParent();
			case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__RIGHT_ELEMENT:
				if (resolve) return getRightElement();
				return basicGetRightElement();
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
			case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__SUB_DIFF_ELEMENTS:
				getSubDiffElements().clear();
				getSubDiffElements().addAll((Collection<? extends DiffElement>)newValue);
				return;
			case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__IS_HIDDEN_BY:
				getIsHiddenBy().clear();
				getIsHiddenBy().addAll((Collection<? extends AbstractDiffExtension>)newValue);
				return;
			case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__REMOTE:
				setRemote((Boolean)newValue);
				return;
			case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__LEFT_PARENT:
				setLeftParent((EObject)newValue);
				return;
			case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__RIGHT_ELEMENT:
				setRightElement((EObject)newValue);
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
			case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__SUB_DIFF_ELEMENTS:
				getSubDiffElements().clear();
				return;
			case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__IS_HIDDEN_BY:
				getIsHiddenBy().clear();
				return;
			case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__REMOTE:
				setRemote(REMOTE_EDEFAULT);
				return;
			case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__LEFT_PARENT:
				setLeftParent((EObject)null);
				return;
			case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__RIGHT_ELEMENT:
				setRightElement((EObject)null);
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
			case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__SUB_DIFF_ELEMENTS:
				return subDiffElements != null && !subDiffElements.isEmpty();
			case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__IS_HIDDEN_BY:
				return isHiddenBy != null && !isHiddenBy.isEmpty();
			case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__CONFLICTING:
				return conflicting != CONFLICTING_EDEFAULT;
			case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__KIND:
				return kind != KIND_EDEFAULT;
			case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__REMOTE:
				return remote != REMOTE_EDEFAULT;
			case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__LEFT_PARENT:
				return leftParent != null;
			case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__RIGHT_ELEMENT:
				return rightElement != null;
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
				case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__SUB_DIFF_ELEMENTS: return DiffPackage.DIFF_ELEMENT__SUB_DIFF_ELEMENTS;
				case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__IS_HIDDEN_BY: return DiffPackage.DIFF_ELEMENT__IS_HIDDEN_BY;
				case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__CONFLICTING: return DiffPackage.DIFF_ELEMENT__CONFLICTING;
				case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__KIND: return DiffPackage.DIFF_ELEMENT__KIND;
				case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__REMOTE: return DiffPackage.DIFF_ELEMENT__REMOTE;
				default: return -1;
			}
		}
		if (baseClass == ModelElementChange.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ModelElementChangeRightTarget.class) {
			switch (derivedFeatureID) {
				case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__LEFT_PARENT: return DiffPackage.MODEL_ELEMENT_CHANGE_RIGHT_TARGET__LEFT_PARENT;
				case UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__RIGHT_ELEMENT: return DiffPackage.MODEL_ELEMENT_CHANGE_RIGHT_TARGET__RIGHT_ELEMENT;
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
				case DiffPackage.DIFF_ELEMENT__SUB_DIFF_ELEMENTS: return UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__SUB_DIFF_ELEMENTS;
				case DiffPackage.DIFF_ELEMENT__IS_HIDDEN_BY: return UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__IS_HIDDEN_BY;
				case DiffPackage.DIFF_ELEMENT__CONFLICTING: return UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__CONFLICTING;
				case DiffPackage.DIFF_ELEMENT__KIND: return UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__KIND;
				case DiffPackage.DIFF_ELEMENT__REMOTE: return UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__REMOTE;
				default: return -1;
			}
		}
		if (baseClass == ModelElementChange.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ModelElementChangeRightTarget.class) {
			switch (baseFeatureID) {
				case DiffPackage.MODEL_ELEMENT_CHANGE_RIGHT_TARGET__LEFT_PARENT: return UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__LEFT_PARENT;
				case DiffPackage.MODEL_ELEMENT_CHANGE_RIGHT_TARGET__RIGHT_ELEMENT: return UMLDiffPackage.ADD_STEREOTYPE_APPLICATION__RIGHT_ELEMENT;
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
		EObject element = getRightElement();
		String elementLabel = AdapterUtils.getItemProviderText(element);
		if (UMLCompareUtils.isStereotypeApplication(element)) {
			elementLabel = UMLUtil.getStereotype(element).getName(); 
		}
		return String.format("%s stereotype has been added", elementLabel);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @NOT-generated
	 */
	@Override
	public IMerger provideMerger() {
		return null;
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
	
} //AddStereotypeApplicationImpl
