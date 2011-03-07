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
import org.eclipse.emf.compare.diff.metamodel.AttributeChangeRightTarget;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.diff.merge.IMerger;
import org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.DiffPackage;
import org.eclipse.emf.compare.diff.metamodel.impl.AttributeChangeRightTargetImpl;
import org.eclipse.emf.compare.util.AdapterUtils;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.papyrus.compare.UMLCompareUtils;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.TaggedValueChange;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.TaggedValueChangeRightTarget;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UMLDiffExtension;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UMLDiffPackage;
import org.eclipse.swt.graphics.Image;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tagged Value Change Right Target</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl.TaggedValueChangeRightTargetImpl#getRightTarget <em>Right Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TaggedValueChangeRightTargetImpl extends TaggedValueChangeImpl implements TaggedValueChangeRightTarget {
	/**
	 * The default value of the '{@link #getRightTarget() <em>Right Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightTarget()
	 * @generated
	 * @ordered
	 */
	protected static final Object RIGHT_TARGET_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getRightTarget() <em>Right Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightTarget()
	 * @generated
	 * @ordered
	 */
	protected Object rightTarget = RIGHT_TARGET_EDEFAULT;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TaggedValueChangeRightTargetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLDiffPackage.Literals.TAGGED_VALUE_CHANGE_RIGHT_TARGET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getRightTarget() {
		return rightTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRightTarget(Object newRightTarget) {
		Object oldRightTarget = rightTarget;
		rightTarget = newRightTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLDiffPackage.TAGGED_VALUE_CHANGE_RIGHT_TARGET__RIGHT_TARGET, oldRightTarget, rightTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getText() {
		return UMLCompareUtils.getInstance().getText(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object getImage() {
		AdapterFactoryLabelProvider adapterProvider = new AdapterFactoryLabelProvider(AdapterUtils.getAdapterFactory());
		Image labelImage = adapterProvider.getImage(getAttribute());
		return labelImage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLDiffPackage.TAGGED_VALUE_CHANGE_RIGHT_TARGET__RIGHT_TARGET:
				return getRightTarget();
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
			case UMLDiffPackage.TAGGED_VALUE_CHANGE_RIGHT_TARGET__RIGHT_TARGET:
				setRightTarget(newValue);
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
			case UMLDiffPackage.TAGGED_VALUE_CHANGE_RIGHT_TARGET__RIGHT_TARGET:
				setRightTarget(RIGHT_TARGET_EDEFAULT);
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
			case UMLDiffPackage.TAGGED_VALUE_CHANGE_RIGHT_TARGET__RIGHT_TARGET:
				return RIGHT_TARGET_EDEFAULT == null ? rightTarget != null : !RIGHT_TARGET_EDEFAULT.equals(rightTarget);
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
		if (baseClass == AttributeChangeRightTarget.class) {
			switch (derivedFeatureID) {
				case UMLDiffPackage.TAGGED_VALUE_CHANGE_RIGHT_TARGET__RIGHT_TARGET: return DiffPackage.ATTRIBUTE_CHANGE_RIGHT_TARGET__RIGHT_TARGET;
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
		if (baseClass == AttributeChangeRightTarget.class) {
			switch (baseFeatureID) {
				case DiffPackage.ATTRIBUTE_CHANGE_RIGHT_TARGET__RIGHT_TARGET: return UMLDiffPackage.TAGGED_VALUE_CHANGE_RIGHT_TARGET__RIGHT_TARGET;
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
		result.append(" (rightTarget: ");
		result.append(rightTarget);
		result.append(')');
		return result.toString();
	}

} //TaggedValueChangeRightTargetImpl
