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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package extensions.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.compare.ReferenceChange;
import org.eclipse.emf.compare.diagram.internal.extensions.NodeChange;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import extensions.ExtensionsPackage;
import extensions.PapyrusGeneralizationChange;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Papyrus Generalization Change</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link extensions.impl.PapyrusGeneralizationChangeImpl#getGeneralizationChange <em>Generalization Change</em>}</li>
 *   <li>{@link extensions.impl.PapyrusGeneralizationChangeImpl#getInheritedFeatureNodeChange <em>Inherited Feature Node Change</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("restriction")
public class PapyrusGeneralizationChangeImpl extends PapyrusDiffImpl implements PapyrusGeneralizationChange {
	/**
	 * The cached value of the '{@link #getGeneralizationChange() <em>Generalization Change</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneralizationChange()
	 * @generated
	 * @ordered
	 */
	protected ReferenceChange generalizationChange;

	/**
	 * The cached value of the '{@link #getInheritedFeatureNodeChange() <em>Inherited Feature Node Change</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritedFeatureNodeChange()
	 * @generated
	 * @ordered
	 */
	protected NodeChange inheritedFeatureNodeChange;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PapyrusGeneralizationChangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExtensionsPackage.Literals.PAPYRUS_GENERALIZATION_CHANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceChange getGeneralizationChange() {
		if (generalizationChange != null && generalizationChange.eIsProxy()) {
			InternalEObject oldGeneralizationChange = (InternalEObject)generalizationChange;
			generalizationChange = (ReferenceChange)eResolveProxy(oldGeneralizationChange);
			if (generalizationChange != oldGeneralizationChange) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExtensionsPackage.PAPYRUS_GENERALIZATION_CHANGE__GENERALIZATION_CHANGE, oldGeneralizationChange, generalizationChange));
			}
		}
		return generalizationChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceChange basicGetGeneralizationChange() {
		return generalizationChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeneralizationChange(ReferenceChange newGeneralizationChange) {
		ReferenceChange oldGeneralizationChange = generalizationChange;
		generalizationChange = newGeneralizationChange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtensionsPackage.PAPYRUS_GENERALIZATION_CHANGE__GENERALIZATION_CHANGE, oldGeneralizationChange, generalizationChange));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeChange getInheritedFeatureNodeChange() {
		if (inheritedFeatureNodeChange != null && inheritedFeatureNodeChange.eIsProxy()) {
			InternalEObject oldInheritedFeatureNodeChange = (InternalEObject)inheritedFeatureNodeChange;
			inheritedFeatureNodeChange = (NodeChange)eResolveProxy(oldInheritedFeatureNodeChange);
			if (inheritedFeatureNodeChange != oldInheritedFeatureNodeChange) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExtensionsPackage.PAPYRUS_GENERALIZATION_CHANGE__INHERITED_FEATURE_NODE_CHANGE, oldInheritedFeatureNodeChange, inheritedFeatureNodeChange));
			}
		}
		return inheritedFeatureNodeChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeChange basicGetInheritedFeatureNodeChange() {
		return inheritedFeatureNodeChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInheritedFeatureNodeChange(NodeChange newInheritedFeatureNodeChange) {
		NodeChange oldInheritedFeatureNodeChange = inheritedFeatureNodeChange;
		inheritedFeatureNodeChange = newInheritedFeatureNodeChange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExtensionsPackage.PAPYRUS_GENERALIZATION_CHANGE__INHERITED_FEATURE_NODE_CHANGE, oldInheritedFeatureNodeChange, inheritedFeatureNodeChange));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExtensionsPackage.PAPYRUS_GENERALIZATION_CHANGE__GENERALIZATION_CHANGE:
				if (resolve) return getGeneralizationChange();
				return basicGetGeneralizationChange();
			case ExtensionsPackage.PAPYRUS_GENERALIZATION_CHANGE__INHERITED_FEATURE_NODE_CHANGE:
				if (resolve) return getInheritedFeatureNodeChange();
				return basicGetInheritedFeatureNodeChange();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExtensionsPackage.PAPYRUS_GENERALIZATION_CHANGE__GENERALIZATION_CHANGE:
				setGeneralizationChange((ReferenceChange)newValue);
				return;
			case ExtensionsPackage.PAPYRUS_GENERALIZATION_CHANGE__INHERITED_FEATURE_NODE_CHANGE:
				setInheritedFeatureNodeChange((NodeChange)newValue);
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
			case ExtensionsPackage.PAPYRUS_GENERALIZATION_CHANGE__GENERALIZATION_CHANGE:
				setGeneralizationChange((ReferenceChange)null);
				return;
			case ExtensionsPackage.PAPYRUS_GENERALIZATION_CHANGE__INHERITED_FEATURE_NODE_CHANGE:
				setInheritedFeatureNodeChange((NodeChange)null);
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
			case ExtensionsPackage.PAPYRUS_GENERALIZATION_CHANGE__GENERALIZATION_CHANGE:
				return generalizationChange != null;
			case ExtensionsPackage.PAPYRUS_GENERALIZATION_CHANGE__INHERITED_FEATURE_NODE_CHANGE:
				return inheritedFeatureNodeChange != null;
		}
		return super.eIsSet(featureID);
	}

} //PapyrusGeneralizationChangeImpl
