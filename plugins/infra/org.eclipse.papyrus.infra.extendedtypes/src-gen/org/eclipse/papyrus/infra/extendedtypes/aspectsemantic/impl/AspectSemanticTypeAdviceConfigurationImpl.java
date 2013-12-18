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
package org.eclipse.papyrus.infra.extendedtypes.aspectsemantic.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.infra.extendedtypes.SemanticActionConfiguration;

import org.eclipse.papyrus.infra.extendedtypes.aspectsemantic.AspectSemanticPackage;
import org.eclipse.papyrus.infra.extendedtypes.aspectsemantic.AspectSemanticTypeAdviceConfiguration;

import org.eclipse.papyrus.infra.extendedtypes.impl.SemanticTypeAdviceConfigurationImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Type Advice Configuration</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.papyrus.infra.extendedtypes.aspectsemantic.impl.AspectSemanticTypeAdviceConfigurationImpl#getPreActionConfiguration
 * <em>Pre Action Configuration</em>}</li>
 * <li>
 * {@link org.eclipse.papyrus.infra.extendedtypes.aspectsemantic.impl.AspectSemanticTypeAdviceConfigurationImpl#getPostActionConfiguration
 * <em>Post Action Configuration</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class AspectSemanticTypeAdviceConfigurationImpl extends
		SemanticTypeAdviceConfigurationImpl implements
		AspectSemanticTypeAdviceConfiguration {
	/**
	 * The cached value of the '{@link #getPreActionConfiguration()
	 * <em>Pre Action Configuration</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPreActionConfiguration()
	 * @generated
	 * @ordered
	 */
	protected EList<SemanticActionConfiguration> preActionConfiguration;

	/**
	 * The cached value of the '{@link #getPostActionConfiguration()
	 * <em>Post Action Configuration</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPostActionConfiguration()
	 * @generated
	 * @ordered
	 */
	protected EList<SemanticActionConfiguration> postActionConfiguration;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AspectSemanticTypeAdviceConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AspectSemanticPackage.eINSTANCE
				.getAspectSemanticTypeAdviceConfiguration();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<SemanticActionConfiguration> getPreActionConfiguration() {
		if (preActionConfiguration == null) {
			preActionConfiguration = new EObjectContainmentEList<SemanticActionConfiguration>(
					SemanticActionConfiguration.class,
					this,
					AspectSemanticPackage.ASPECT_SEMANTIC_TYPE_ADVICE_CONFIGURATION__PRE_ACTION_CONFIGURATION);
		}
		return preActionConfiguration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<SemanticActionConfiguration> getPostActionConfiguration() {
		if (postActionConfiguration == null) {
			postActionConfiguration = new EObjectContainmentEList<SemanticActionConfiguration>(
					SemanticActionConfiguration.class,
					this,
					AspectSemanticPackage.ASPECT_SEMANTIC_TYPE_ADVICE_CONFIGURATION__POST_ACTION_CONFIGURATION);
		}
		return postActionConfiguration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case AspectSemanticPackage.ASPECT_SEMANTIC_TYPE_ADVICE_CONFIGURATION__PRE_ACTION_CONFIGURATION:
			return ((InternalEList<?>) getPreActionConfiguration())
					.basicRemove(otherEnd, msgs);
		case AspectSemanticPackage.ASPECT_SEMANTIC_TYPE_ADVICE_CONFIGURATION__POST_ACTION_CONFIGURATION:
			return ((InternalEList<?>) getPostActionConfiguration())
					.basicRemove(otherEnd, msgs);
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
		case AspectSemanticPackage.ASPECT_SEMANTIC_TYPE_ADVICE_CONFIGURATION__PRE_ACTION_CONFIGURATION:
			return getPreActionConfiguration();
		case AspectSemanticPackage.ASPECT_SEMANTIC_TYPE_ADVICE_CONFIGURATION__POST_ACTION_CONFIGURATION:
			return getPostActionConfiguration();
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
		case AspectSemanticPackage.ASPECT_SEMANTIC_TYPE_ADVICE_CONFIGURATION__PRE_ACTION_CONFIGURATION:
			getPreActionConfiguration().clear();
			getPreActionConfiguration()
					.addAll((Collection<? extends SemanticActionConfiguration>) newValue);
			return;
		case AspectSemanticPackage.ASPECT_SEMANTIC_TYPE_ADVICE_CONFIGURATION__POST_ACTION_CONFIGURATION:
			getPostActionConfiguration().clear();
			getPostActionConfiguration()
					.addAll((Collection<? extends SemanticActionConfiguration>) newValue);
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
		case AspectSemanticPackage.ASPECT_SEMANTIC_TYPE_ADVICE_CONFIGURATION__PRE_ACTION_CONFIGURATION:
			getPreActionConfiguration().clear();
			return;
		case AspectSemanticPackage.ASPECT_SEMANTIC_TYPE_ADVICE_CONFIGURATION__POST_ACTION_CONFIGURATION:
			getPostActionConfiguration().clear();
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
		case AspectSemanticPackage.ASPECT_SEMANTIC_TYPE_ADVICE_CONFIGURATION__PRE_ACTION_CONFIGURATION:
			return preActionConfiguration != null
					&& !preActionConfiguration.isEmpty();
		case AspectSemanticPackage.ASPECT_SEMANTIC_TYPE_ADVICE_CONFIGURATION__POST_ACTION_CONFIGURATION:
			return postActionConfiguration != null
					&& !postActionConfiguration.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // AspectSemanticTypeAdviceConfigurationImpl
