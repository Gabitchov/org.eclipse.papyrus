/**
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
 */
package org.eclipse.papyrus.infra.extendedtypes.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.extendedtypes.AspectViewTypeAdviceConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage;
import org.eclipse.papyrus.infra.extendedtypes.ViewActionConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aspect View Type Advice Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.extendedtypes.impl.AspectViewTypeAdviceConfigurationImpl#getPreActionConfiguration <em>Pre Action
 * Configuration</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.extendedtypes.impl.AspectViewTypeAdviceConfigurationImpl#getPostActionConfiguration <em>Post Action
 * Configuration</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class AspectViewTypeAdviceConfigurationImpl extends ViewTypeAdviceConfigurationImpl implements AspectViewTypeAdviceConfiguration {

	/**
	 * The cached value of the '{@link #getPreActionConfiguration() <em>Pre Action Configuration</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPreActionConfiguration()
	 * @generated
	 * @ordered
	 */
	protected EList<ViewActionConfiguration> preActionConfiguration;

	/**
	 * The cached value of the '{@link #getPostActionConfiguration() <em>Post Action Configuration</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getPostActionConfiguration()
	 * @generated
	 * @ordered
	 */
	protected EList<ViewActionConfiguration> postActionConfiguration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AspectViewTypeAdviceConfigurationImpl() {
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
		return ExtendedtypesPackage.eINSTANCE.getAspectViewTypeAdviceConfiguration();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ViewActionConfiguration> getPreActionConfiguration() {
		if(preActionConfiguration == null) {
			preActionConfiguration = new EObjectContainmentEList<ViewActionConfiguration>(ViewActionConfiguration.class, this, ExtendedtypesPackage.ASPECT_VIEW_TYPE_ADVICE_CONFIGURATION__PRE_ACTION_CONFIGURATION);
		}
		return preActionConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ViewActionConfiguration> getPostActionConfiguration() {
		if(postActionConfiguration == null) {
			postActionConfiguration = new EObjectContainmentEList<ViewActionConfiguration>(ViewActionConfiguration.class, this, ExtendedtypesPackage.ASPECT_VIEW_TYPE_ADVICE_CONFIGURATION__POST_ACTION_CONFIGURATION);
		}
		return postActionConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
		case ExtendedtypesPackage.ASPECT_VIEW_TYPE_ADVICE_CONFIGURATION__PRE_ACTION_CONFIGURATION:
			return ((InternalEList<?>)getPreActionConfiguration()).basicRemove(otherEnd, msgs);
		case ExtendedtypesPackage.ASPECT_VIEW_TYPE_ADVICE_CONFIGURATION__POST_ACTION_CONFIGURATION:
			return ((InternalEList<?>)getPostActionConfiguration()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
		case ExtendedtypesPackage.ASPECT_VIEW_TYPE_ADVICE_CONFIGURATION__PRE_ACTION_CONFIGURATION:
			return getPreActionConfiguration();
		case ExtendedtypesPackage.ASPECT_VIEW_TYPE_ADVICE_CONFIGURATION__POST_ACTION_CONFIGURATION:
			return getPostActionConfiguration();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case ExtendedtypesPackage.ASPECT_VIEW_TYPE_ADVICE_CONFIGURATION__PRE_ACTION_CONFIGURATION:
			getPreActionConfiguration().clear();
			getPreActionConfiguration().addAll((Collection<? extends ViewActionConfiguration>)newValue);
			return;
		case ExtendedtypesPackage.ASPECT_VIEW_TYPE_ADVICE_CONFIGURATION__POST_ACTION_CONFIGURATION:
			getPostActionConfiguration().clear();
			getPostActionConfiguration().addAll((Collection<? extends ViewActionConfiguration>)newValue);
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
		case ExtendedtypesPackage.ASPECT_VIEW_TYPE_ADVICE_CONFIGURATION__PRE_ACTION_CONFIGURATION:
			getPreActionConfiguration().clear();
			return;
		case ExtendedtypesPackage.ASPECT_VIEW_TYPE_ADVICE_CONFIGURATION__POST_ACTION_CONFIGURATION:
			getPostActionConfiguration().clear();
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
		case ExtendedtypesPackage.ASPECT_VIEW_TYPE_ADVICE_CONFIGURATION__PRE_ACTION_CONFIGURATION:
			return preActionConfiguration != null && !preActionConfiguration.isEmpty();
		case ExtendedtypesPackage.ASPECT_VIEW_TYPE_ADVICE_CONFIGURATION__POST_ACTION_CONFIGURATION:
			return postActionConfiguration != null && !postActionConfiguration.isEmpty();
		}
		return super.eIsSet(featureID);
	}
} //AspectViewTypeAdviceConfigurationImpl
