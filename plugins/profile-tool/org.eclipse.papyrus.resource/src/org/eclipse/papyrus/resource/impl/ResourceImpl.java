/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (Atos Origin) tristan.faure@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.resource.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.resource.Resource;
import org.eclipse.papyrus.resource.ResourcePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Resource</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.resource.impl.ResourceImpl#getEobjects <em>Eobjects</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ResourceImpl extends EObjectImpl implements Resource {

	/**
	 * Map to register the managed EMF resources with the papyrus resource TODO don't forget to
	 * unload your resource after using it.
	 */
	private static Map<org.eclipse.emf.ecore.resource.Resource, Resource> resources = new HashMap<org.eclipse.emf.ecore.resource.Resource, Resource>();

	private org.eclipse.emf.ecore.resource.Resource eobjectResource = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResourcePackage.Literals.RESOURCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<EObject> getEobjects() {
		if (eobjectResource != null) {
			return eobjectResource.getContents();
		}
		return new BasicEList<EObject>();
	}
	
	/**
	 * Gets the Papyrus resource from the EMF resource
	 * 
	 * @param r the EMF resource
	 * 
	 * @return the Papyrus resource
	 */
	public static Resource getResource(org.eclipse.emf.ecore.resource.Resource r) {
		return resources.get(r);
	}

	/**
	 * <!-- begin-user-doc --> Register the EMF resource <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setResource(org.eclipse.emf.ecore.resource.Resource r) {
		eobjectResource = r;
		resources.put(r, this);
	}

	/**
	 * Unregister the EMF resource
	 * 
	 * @param r
	 *            the resource
	 */
	public static void dispose(org.eclipse.emf.ecore.resource.Resource r) {
		resources.remove(r);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ResourcePackage.RESOURCE__EOBJECTS:
			return ((InternalEList<?>) getEobjects()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ResourcePackage.RESOURCE__EOBJECTS:
			return getEobjects();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ResourcePackage.RESOURCE__EOBJECTS:
			getEobjects().clear();
			getEobjects().addAll((Collection<? extends EObject>) newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
		case ResourcePackage.RESOURCE__EOBJECTS:
			getEobjects().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ResourcePackage.RESOURCE__EOBJECTS:
			return !getEobjects().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // ResourceImpl
