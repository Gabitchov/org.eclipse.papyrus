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
package org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.infrastructure.datatypes.CompositeDatatype;
import org.eclipse.papyrus.eastadl.infrastructure.datatypes.DatatypesPackage;
import org.eclipse.papyrus.eastadl.infrastructure.datatypes.EADatatypePrototype;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Datatype</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.impl.CompositeDatatypeImpl#getDatatypePrototype <em>Datatype Prototype</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompositeDatatypeImpl extends EADatatypeImpl implements CompositeDatatype {
	/**
	 * The cached value of the '{@link #getDatatypePrototype() <em>Datatype Prototype</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatatypePrototype()
	 * @generated
	 * @ordered
	 */
	protected EList<EADatatypePrototype> datatypePrototype;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeDatatypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DatatypesPackage.COMPOSITE_DATATYPE__DATATYPE_PROTOTYPE:
				return getDatatypePrototype();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DatatypesPackage.COMPOSITE_DATATYPE__DATATYPE_PROTOTYPE:
				return datatypePrototype != null && !datatypePrototype.isEmpty();
		}
		return super.eIsSet(featureID);
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
			case DatatypesPackage.COMPOSITE_DATATYPE__DATATYPE_PROTOTYPE:
				getDatatypePrototype().clear();
				getDatatypePrototype().addAll((Collection<? extends EADatatypePrototype>)newValue);
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
	protected EClass eStaticClass() {
		return DatatypesPackage.Literals.COMPOSITE_DATATYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DatatypesPackage.COMPOSITE_DATATYPE__DATATYPE_PROTOTYPE:
				getDatatypePrototype().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EADatatypePrototype> getDatatypePrototype() {
		if (datatypePrototype == null) {
			datatypePrototype = new EObjectResolvingEList<EADatatypePrototype>(EADatatypePrototype.class, this, DatatypesPackage.COMPOSITE_DATATYPE__DATATYPE_PROTOTYPE);
		}
		return datatypePrototype;
	}

} //CompositeDatatypeImpl
