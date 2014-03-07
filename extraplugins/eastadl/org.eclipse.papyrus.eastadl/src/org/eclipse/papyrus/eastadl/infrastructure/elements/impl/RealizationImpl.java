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
package org.eclipse.papyrus.eastadl.infrastructure.elements.impl;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement;
import org.eclipse.papyrus.eastadl.infrastructure.elements.ElementsPackage;
import org.eclipse.papyrus.eastadl.infrastructure.elements.Realization;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.util.UMLUtil;


/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Realization</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.elements.impl.RealizationImpl#getRealized <em>Realized</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.elements.impl.RealizationImpl#getRealizedBy <em>Realized By</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.elements.impl.RealizationImpl#getBase_Realization <em>Base Realization</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.elements.impl.RealizationImpl#getRealizedBy_path <em>Realized By path</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.elements.impl.RealizationImpl#getRealized_path <em>Realized path</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class RealizationImpl extends RelationshipImpl implements Realization {

	/**
	 * The cached value of the '{@link #getBase_Realization() <em>Base Realization</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBase_Realization()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Realization base_Realization;

	/**
	 * The cached value of the '{@link #getRealizedBy_path() <em>Realized By path</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRealizedBy_path()
	 * @generated
	 * @ordered
	 */
	protected EList<NamedElement> realizedBy_path;

	/**
	 * The cached value of the '{@link #getRealized_path() <em>Realized path</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRealized_path()
	 * @generated
	 * @ordered
	 */
	protected EList<NamedElement> realized_path;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected RealizationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case ElementsPackage.REALIZATION__REALIZED:
			return getRealized();
		case ElementsPackage.REALIZATION__REALIZED_BY:
			return getRealizedBy();
		case ElementsPackage.REALIZATION__BASE_REALIZATION:
			if(resolve)
				return getBase_Realization();
			return basicGetBase_Realization();
		case ElementsPackage.REALIZATION__REALIZED_BY_PATH:
			return getRealizedBy_path();
		case ElementsPackage.REALIZATION__REALIZED_PATH:
			return getRealized_path();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case ElementsPackage.REALIZATION__REALIZED:
			return !getRealized().isEmpty();
		case ElementsPackage.REALIZATION__REALIZED_BY:
			return !getRealizedBy().isEmpty();
		case ElementsPackage.REALIZATION__BASE_REALIZATION:
			return base_Realization != null;
		case ElementsPackage.REALIZATION__REALIZED_BY_PATH:
			return realizedBy_path != null && !realizedBy_path.isEmpty();
		case ElementsPackage.REALIZATION__REALIZED_PATH:
			return realized_path != null && !realized_path.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case ElementsPackage.REALIZATION__BASE_REALIZATION:
			setBase_Realization((org.eclipse.uml2.uml.Realization)newValue);
			return;
		case ElementsPackage.REALIZATION__REALIZED_BY_PATH:
			getRealizedBy_path().clear();
			getRealizedBy_path().addAll((Collection<? extends NamedElement>)newValue);
			return;
		case ElementsPackage.REALIZATION__REALIZED_PATH:
			getRealized_path().clear();
			getRealized_path().addAll((Collection<? extends NamedElement>)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ElementsPackage.Literals.REALIZATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case ElementsPackage.REALIZATION__BASE_REALIZATION:
			setBase_Realization((org.eclipse.uml2.uml.Realization)null);
			return;
		case ElementsPackage.REALIZATION__REALIZED_BY_PATH:
			getRealizedBy_path().clear();
			return;
		case ElementsPackage.REALIZATION__REALIZED_PATH:
			getRealized_path().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<EAElement> getRealized() {
		EList<EAElement> results = new BasicEList<EAElement>();
		EAElement entity;

		if(getBase_Realization() != null) {
			// Parse owned Properties
			Iterator<Element> it = getBase_Realization().getTargets().iterator();
			while(it.hasNext()) {
				Element current = it.next();

				// Test if current is stereotyped eaelement
				entity = (EAElement)UMLUtil.getStereotypeApplication(current, EAElement.class);

				if(entity != null) {
					results.add(entity);
				}
			}
		}

		// Convert to InternalEList<?>
		return new BasicInternalEList<EAElement>(EAElement.class, results.size(), results.toArray());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<NamedElement> getRealizedBy() {
		EList<NamedElement> results = new BasicEList<NamedElement>();

		if(getBase_Realization() != null) {
			// Parse owned Properties
			Iterator<NamedElement> it = getBase_Realization().getClients().iterator();
			while(it.hasNext()) {
				NamedElement current = it.next();
				results.add(current);
			}
		}

		// Convert to InternalEList<?>
		return new BasicInternalEList<NamedElement>(NamedElement.class, results.size(), results.toArray());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.Realization getBase_Realization() {
		if(base_Realization != null && base_Realization.eIsProxy()) {
			InternalEObject oldBase_Realization = (InternalEObject)base_Realization;
			base_Realization = (org.eclipse.uml2.uml.Realization)eResolveProxy(oldBase_Realization);
			if(base_Realization != oldBase_Realization) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ElementsPackage.REALIZATION__BASE_REALIZATION, oldBase_Realization, base_Realization));
			}
		}
		return base_Realization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.Realization basicGetBase_Realization() {
		return base_Realization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_Realization(org.eclipse.uml2.uml.Realization newBase_Realization) {
		org.eclipse.uml2.uml.Realization oldBase_Realization = base_Realization;
		base_Realization = newBase_Realization;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementsPackage.REALIZATION__BASE_REALIZATION, oldBase_Realization, base_Realization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<NamedElement> getRealizedBy_path() {
		if(realizedBy_path == null) {
			realizedBy_path = new EObjectResolvingEList<NamedElement>(NamedElement.class, this, ElementsPackage.REALIZATION__REALIZED_BY_PATH);
		}
		return realizedBy_path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<NamedElement> getRealized_path() {
		if(realized_path == null) {
			realized_path = new EObjectResolvingEList<NamedElement>(NamedElement.class, this, ElementsPackage.REALIZATION__REALIZED_PATH);
		}
		return realized_path;
	}

} // RealizationImpl
