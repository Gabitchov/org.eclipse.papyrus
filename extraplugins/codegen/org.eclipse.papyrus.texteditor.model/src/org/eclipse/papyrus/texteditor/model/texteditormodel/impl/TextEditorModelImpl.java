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
package org.eclipse.papyrus.texteditor.model.texteditormodel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.texteditor.model.texteditormodel.TextEditorModel;
import org.eclipse.papyrus.texteditor.model.texteditormodel.TextEditorModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Text Editor Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.texteditor.model.texteditormodel.impl.TextEditorModelImpl#getEditedObject <em>Edited Object</em>}</li>
 *   <li>{@link org.eclipse.papyrus.texteditor.model.texteditormodel.impl.TextEditorModelImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.texteditor.model.texteditormodel.impl.TextEditorModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.texteditor.model.texteditormodel.impl.TextEditorModelImpl#getSelectedObject <em>Selected Object</em>}</li>
 *   <li>{@link org.eclipse.papyrus.texteditor.model.texteditormodel.impl.TextEditorModelImpl#getLineNumber <em>Line Number</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TextEditorModelImpl extends EModelElementImpl implements TextEditorModel {
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
	 * The cached value of the '{@link #getSelectedObject() <em>Selected Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelectedObject()
	 * @generated
	 * @ordered
	 */
	protected EObject selectedObject;

	/**
	 * The default value of the '{@link #getLineNumber() <em>Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int LINE_NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLineNumber() <em>Line Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineNumber()
	 * @generated
	 * @ordered
	 */
	protected int lineNumber = LINE_NUMBER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TextEditorModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TextEditorModelPackage.Literals.TEXT_EDITOR_MODEL;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TextEditorModelPackage.TEXT_EDITOR_MODEL__EDITED_OBJECT, oldEditedObject, editedObject));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TextEditorModelPackage.TEXT_EDITOR_MODEL__EDITED_OBJECT, oldEditedObject, editedObject));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TextEditorModelPackage.TEXT_EDITOR_MODEL__TYPE, oldType, type));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TextEditorModelPackage.TEXT_EDITOR_MODEL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getSelectedObject() {
		if (selectedObject != null && selectedObject.eIsProxy()) {
			InternalEObject oldSelectedObject = (InternalEObject)selectedObject;
			selectedObject = eResolveProxy(oldSelectedObject);
			if (selectedObject != oldSelectedObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TextEditorModelPackage.TEXT_EDITOR_MODEL__SELECTED_OBJECT, oldSelectedObject, selectedObject));
			}
		}
		return selectedObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetSelectedObject() {
		return selectedObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelectedObject(EObject newSelectedObject) {
		EObject oldSelectedObject = selectedObject;
		selectedObject = newSelectedObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TextEditorModelPackage.TEXT_EDITOR_MODEL__SELECTED_OBJECT, oldSelectedObject, selectedObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLineNumber() {
		return lineNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLineNumber(int newLineNumber) {
		int oldLineNumber = lineNumber;
		lineNumber = newLineNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TextEditorModelPackage.TEXT_EDITOR_MODEL__LINE_NUMBER, oldLineNumber, lineNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TextEditorModelPackage.TEXT_EDITOR_MODEL__EDITED_OBJECT:
				if (resolve) return getEditedObject();
				return basicGetEditedObject();
			case TextEditorModelPackage.TEXT_EDITOR_MODEL__TYPE:
				return getType();
			case TextEditorModelPackage.TEXT_EDITOR_MODEL__NAME:
				return getName();
			case TextEditorModelPackage.TEXT_EDITOR_MODEL__SELECTED_OBJECT:
				if (resolve) return getSelectedObject();
				return basicGetSelectedObject();
			case TextEditorModelPackage.TEXT_EDITOR_MODEL__LINE_NUMBER:
				return getLineNumber();
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
			case TextEditorModelPackage.TEXT_EDITOR_MODEL__EDITED_OBJECT:
				setEditedObject((EObject)newValue);
				return;
			case TextEditorModelPackage.TEXT_EDITOR_MODEL__TYPE:
				setType((String)newValue);
				return;
			case TextEditorModelPackage.TEXT_EDITOR_MODEL__NAME:
				setName((String)newValue);
				return;
			case TextEditorModelPackage.TEXT_EDITOR_MODEL__SELECTED_OBJECT:
				setSelectedObject((EObject)newValue);
				return;
			case TextEditorModelPackage.TEXT_EDITOR_MODEL__LINE_NUMBER:
				setLineNumber((Integer)newValue);
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
			case TextEditorModelPackage.TEXT_EDITOR_MODEL__EDITED_OBJECT:
				setEditedObject((EObject)null);
				return;
			case TextEditorModelPackage.TEXT_EDITOR_MODEL__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case TextEditorModelPackage.TEXT_EDITOR_MODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TextEditorModelPackage.TEXT_EDITOR_MODEL__SELECTED_OBJECT:
				setSelectedObject((EObject)null);
				return;
			case TextEditorModelPackage.TEXT_EDITOR_MODEL__LINE_NUMBER:
				setLineNumber(LINE_NUMBER_EDEFAULT);
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
			case TextEditorModelPackage.TEXT_EDITOR_MODEL__EDITED_OBJECT:
				return editedObject != null;
			case TextEditorModelPackage.TEXT_EDITOR_MODEL__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case TextEditorModelPackage.TEXT_EDITOR_MODEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TextEditorModelPackage.TEXT_EDITOR_MODEL__SELECTED_OBJECT:
				return selectedObject != null;
			case TextEditorModelPackage.TEXT_EDITOR_MODEL__LINE_NUMBER:
				return lineNumber != LINE_NUMBER_EDEFAULT;
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
		result.append(", lineNumber: ");
		result.append(lineNumber);
		result.append(')');
		return result.toString();
	}

} //TextEditorModelImpl
