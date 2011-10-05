/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.properties.root.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.papyrus.properties.contexts.Context;

import org.eclipse.papyrus.properties.environment.Environment;

import org.eclipse.papyrus.properties.root.PropertiesRoot;
import org.eclipse.papyrus.properties.root.RootPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Properties Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.properties.root.impl.PropertiesRootImpl#getEnvironments <em>Environments</em>}</li>
 * <li>{@link org.eclipse.papyrus.properties.root.impl.PropertiesRootImpl#getContexts <em>Contexts</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class PropertiesRootImpl extends EObjectImpl implements PropertiesRoot {

	/**
	 * The cached value of the '{@link #getEnvironments() <em>Environments</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getEnvironments()
	 * @generated
	 * @ordered
	 */
	protected EList<Environment> environments;

	/**
	 * The cached value of the '{@link #getContexts() <em>Contexts</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getContexts()
	 * @generated
	 * @ordered
	 */
	protected EList<Context> contexts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected PropertiesRootImpl() {
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
		return RootPackage.Literals.PROPERTIES_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Environment> getEnvironments() {
		if(environments == null) {
			environments = new EObjectResolvingEList<Environment>(Environment.class, this, RootPackage.PROPERTIES_ROOT__ENVIRONMENTS);
		}
		return environments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Context> getContexts() {
		if(contexts == null) {
			contexts = new EObjectResolvingEList<Context>(Context.class, this, RootPackage.PROPERTIES_ROOT__CONTEXTS);
		}
		return contexts;
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
		case RootPackage.PROPERTIES_ROOT__ENVIRONMENTS:
			return getEnvironments();
		case RootPackage.PROPERTIES_ROOT__CONTEXTS:
			return getContexts();
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
		case RootPackage.PROPERTIES_ROOT__ENVIRONMENTS:
			getEnvironments().clear();
			getEnvironments().addAll((Collection<? extends Environment>)newValue);
			return;
		case RootPackage.PROPERTIES_ROOT__CONTEXTS:
			getContexts().clear();
			getContexts().addAll((Collection<? extends Context>)newValue);
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
		case RootPackage.PROPERTIES_ROOT__ENVIRONMENTS:
			getEnvironments().clear();
			return;
		case RootPackage.PROPERTIES_ROOT__CONTEXTS:
			getContexts().clear();
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
		case RootPackage.PROPERTIES_ROOT__ENVIRONMENTS:
			return environments != null && !environments.isEmpty();
		case RootPackage.PROPERTIES_ROOT__CONTEXTS:
			return contexts != null && !contexts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PropertiesRootImpl
