/**
 *  Copyright (c) 2012 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  Vincent Lorenzo (CEA-LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.text.instance.papyrustextinstance.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.text.instance.papyrustextinstance.PapyrusTextInstance;
import org.eclipse.papyrus.text.instance.papyrustextinstance.PapyrustextinstancePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Papyrus Text Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.text.instance.papyrustextinstance.impl.PapyrusTextInstanceImpl#getEditedObject <em>Edited Object</em>}</li>
 *   <li>{@link org.eclipse.papyrus.text.instance.papyrustextinstance.impl.PapyrusTextInstanceImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.text.instance.papyrustextinstance.impl.PapyrusTextInstanceImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PapyrusTextInstanceImpl extends EModelElementImpl implements PapyrusTextInstance {
	/**
	 * The cached value of the '{@link #getEditedObject() <em>Edited Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditedObject()
	 * @generated
	 * @ordered
	 */
	protected EObject editedObject;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PapyrusTextInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PapyrustextinstancePackage.Literals.PAPYRUS_TEXT_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getEditedObject() {
		if (editedObject != null && editedObject.eIsProxy()) {
			InternalEObject oldEditedObject = (InternalEObject)editedObject;
			editedObject = eResolveProxy(oldEditedObject);
			if (editedObject != oldEditedObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PapyrustextinstancePackage.PAPYRUS_TEXT_INSTANCE__EDITED_OBJECT, oldEditedObject, editedObject));
			}
		}
		return editedObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetEditedObject() {
		return editedObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEditedObject(EObject newEditedObject) {
		EObject oldEditedObject = editedObject;
		editedObject = newEditedObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrustextinstancePackage.PAPYRUS_TEXT_INSTANCE__EDITED_OBJECT, oldEditedObject, editedObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrustextinstancePackage.PAPYRUS_TEXT_INSTANCE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrustextinstancePackage.PAPYRUS_TEXT_INSTANCE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PapyrustextinstancePackage.PAPYRUS_TEXT_INSTANCE__EDITED_OBJECT:
				if (resolve) return getEditedObject();
				return basicGetEditedObject();
			case PapyrustextinstancePackage.PAPYRUS_TEXT_INSTANCE__TYPE:
				return getType();
			case PapyrustextinstancePackage.PAPYRUS_TEXT_INSTANCE__NAME:
				return getName();
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
			case PapyrustextinstancePackage.PAPYRUS_TEXT_INSTANCE__EDITED_OBJECT:
				setEditedObject((EObject)newValue);
				return;
			case PapyrustextinstancePackage.PAPYRUS_TEXT_INSTANCE__TYPE:
				setType((String)newValue);
				return;
			case PapyrustextinstancePackage.PAPYRUS_TEXT_INSTANCE__NAME:
				setName((String)newValue);
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
			case PapyrustextinstancePackage.PAPYRUS_TEXT_INSTANCE__EDITED_OBJECT:
				setEditedObject((EObject)null);
				return;
			case PapyrustextinstancePackage.PAPYRUS_TEXT_INSTANCE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case PapyrustextinstancePackage.PAPYRUS_TEXT_INSTANCE__NAME:
				setName(NAME_EDEFAULT);
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
			case PapyrustextinstancePackage.PAPYRUS_TEXT_INSTANCE__EDITED_OBJECT:
				return editedObject != null;
			case PapyrustextinstancePackage.PAPYRUS_TEXT_INSTANCE__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case PapyrustextinstancePackage.PAPYRUS_TEXT_INSTANCE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		}
		return super.eIsSet(featureID);
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
		result.append(" (type: ");
		result.append(type);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //PapyrusTextInstanceImpl
