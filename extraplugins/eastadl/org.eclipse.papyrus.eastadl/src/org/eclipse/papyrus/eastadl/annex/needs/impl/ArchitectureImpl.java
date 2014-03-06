/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.annex.needs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.eastadl.annex.needs.ArchitecturalDescription;
import org.eclipse.papyrus.eastadl.annex.needs.Architecture;
import org.eclipse.papyrus.eastadl.annex.needs.NeedsPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Architecture</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.annex.needs.impl.ArchitectureImpl#getDescribedBy <em>Described By</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ArchitectureImpl extends ConceptImpl implements Architecture {

	/**
	 * The cached value of the '{@link #getDescribedBy() <em>Described By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getDescribedBy()
	 * @generated
	 * @ordered
	 */
	protected ArchitecturalDescription describedBy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ArchitectureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ArchitecturalDescription basicGetDescribedBy() {
		return describedBy;
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
		case NeedsPackage.ARCHITECTURE__DESCRIBED_BY:
			if(resolve)
				return getDescribedBy();
			return basicGetDescribedBy();
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
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case NeedsPackage.ARCHITECTURE__DESCRIBED_BY:
			return describedBy != null;
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
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case NeedsPackage.ARCHITECTURE__DESCRIBED_BY:
			setDescribedBy((ArchitecturalDescription)newValue);
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
	protected EClass eStaticClass() {
		return NeedsPackage.Literals.ARCHITECTURE;
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
		case NeedsPackage.ARCHITECTURE__DESCRIBED_BY:
			setDescribedBy((ArchitecturalDescription)null);
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
	public ArchitecturalDescription getDescribedBy() {
		if(describedBy != null && describedBy.eIsProxy()) {
			InternalEObject oldDescribedBy = (InternalEObject)describedBy;
			describedBy = (ArchitecturalDescription)eResolveProxy(oldDescribedBy);
			if(describedBy != oldDescribedBy) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NeedsPackage.ARCHITECTURE__DESCRIBED_BY, oldDescribedBy, describedBy));
			}
		}
		return describedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDescribedBy(ArchitecturalDescription newDescribedBy) {
		ArchitecturalDescription oldDescribedBy = describedBy;
		describedBy = newDescribedBy;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NeedsPackage.ARCHITECTURE__DESCRIBED_BY, oldDescribedBy, describedBy));
	}

} //ArchitectureImpl
