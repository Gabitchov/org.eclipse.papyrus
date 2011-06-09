/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.di.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.papyrus.di.DiPackage;
import org.eclipse.papyrus.di.DiagramElement;
import org.eclipse.papyrus.di.Reference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.di.impl.ReferenceImpl#isIsIndividualRepresentation <em>Is Individual Representation</em>}</li>
 * <li>{@link org.eclipse.papyrus.di.impl.ReferenceImpl#getReferenced <em>Referenced</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ReferenceImpl extends DiagramElementImpl implements Reference {

	/**
	 * The default value of the '{@link #isIsIndividualRepresentation() <em>Is Individual Representation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isIsIndividualRepresentation()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_INDIVIDUAL_REPRESENTATION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsIndividualRepresentation() <em>Is Individual Representation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isIsIndividualRepresentation()
	 * @generated
	 * @ordered
	 */
	protected boolean isIndividualRepresentation = IS_INDIVIDUAL_REPRESENTATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReferenced() <em>Referenced</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getReferenced()
	 * @generated
	 * @ordered
	 */
	protected DiagramElement referenced;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiPackage.Literals.REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isIsIndividualRepresentation() {
		return isIndividualRepresentation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setIsIndividualRepresentation(boolean newIsIndividualRepresentation) {
		boolean oldIsIndividualRepresentation = isIndividualRepresentation;
		isIndividualRepresentation = newIsIndividualRepresentation;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiPackage.REFERENCE__IS_INDIVIDUAL_REPRESENTATION, oldIsIndividualRepresentation, isIndividualRepresentation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DiagramElement getReferenced() {
		if(referenced != null && referenced.eIsProxy()) {
			InternalEObject oldReferenced = (InternalEObject)referenced;
			referenced = (DiagramElement)eResolveProxy(oldReferenced);
			if(referenced != oldReferenced) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiPackage.REFERENCE__REFERENCED, oldReferenced, referenced));
			}
		}
		return referenced;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DiagramElement basicGetReferenced() {
		return referenced;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setReferenced(DiagramElement newReferenced) {
		DiagramElement oldReferenced = referenced;
		referenced = newReferenced;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiPackage.REFERENCE__REFERENCED, oldReferenced, referenced));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case DiPackage.REFERENCE__IS_INDIVIDUAL_REPRESENTATION:
			return isIsIndividualRepresentation();
		case DiPackage.REFERENCE__REFERENCED:
			if(resolve)
				return getReferenced();
			return basicGetReferenced();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case DiPackage.REFERENCE__IS_INDIVIDUAL_REPRESENTATION:
			setIsIndividualRepresentation((Boolean)newValue);
			return;
		case DiPackage.REFERENCE__REFERENCED:
			setReferenced((DiagramElement)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case DiPackage.REFERENCE__IS_INDIVIDUAL_REPRESENTATION:
			setIsIndividualRepresentation(IS_INDIVIDUAL_REPRESENTATION_EDEFAULT);
			return;
		case DiPackage.REFERENCE__REFERENCED:
			setReferenced((DiagramElement)null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case DiPackage.REFERENCE__IS_INDIVIDUAL_REPRESENTATION:
			return isIndividualRepresentation != IS_INDIVIDUAL_REPRESENTATION_EDEFAULT;
		case DiPackage.REFERENCE__REFERENCED:
			return referenced != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if(eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isIndividualRepresentation: ");
		result.append(isIndividualRepresentation);
		result.append(')');
		return result.toString();
	}

} //ReferenceImpl
