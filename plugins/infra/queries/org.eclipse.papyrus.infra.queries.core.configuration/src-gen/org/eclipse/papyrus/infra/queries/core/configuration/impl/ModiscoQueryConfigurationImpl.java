/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.queries.core.configuration.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.facet.infra.query.ModelQuery;
import org.eclipse.papyrus.infra.queries.core.configuration.ConfigurationPackage;
import org.eclipse.papyrus.infra.queries.core.configuration.ModiscoQueryConfiguration;
import org.eclipse.papyrus.infra.queries.core.configuration.ParameterValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Modisco Query Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.queries.core.configuration.impl.ModiscoQueryConfigurationImpl#getQuery <em>Query</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.queries.core.configuration.impl.ModiscoQueryConfigurationImpl#getParameterValues <em>Parameter Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModiscoQueryConfigurationImpl extends QueryConfigurationImpl implements ModiscoQueryConfiguration {
	/**
	 * The cached value of the '{@link #getQuery() <em>Query</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuery()
	 * @generated
	 * @ordered
	 */
	protected ModelQuery query;

	/**
	 * The cached value of the '{@link #getParameterValues() <em>Parameter Values</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterValues()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterValue> parameterValues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModiscoQueryConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.MODISCO_QUERY_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelQuery getQuery() {
		if (query != null && query.eIsProxy()) {
			InternalEObject oldQuery = (InternalEObject)query;
			query = (ModelQuery)eResolveProxy(oldQuery);
			if (query != oldQuery) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ConfigurationPackage.MODISCO_QUERY_CONFIGURATION__QUERY, oldQuery, query));
			}
		}
		return query;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelQuery basicGetQuery() {
		return query;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuery(ModelQuery newQuery) {
		ModelQuery oldQuery = query;
		query = newQuery;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.MODISCO_QUERY_CONFIGURATION__QUERY, oldQuery, query));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterValue> getParameterValues() {
		if (parameterValues == null) {
			parameterValues = new EObjectContainmentEList<ParameterValue>(ParameterValue.class, this, ConfigurationPackage.MODISCO_QUERY_CONFIGURATION__PARAMETER_VALUES);
		}
		return parameterValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ConfigurationPackage.MODISCO_QUERY_CONFIGURATION__PARAMETER_VALUES:
				return ((InternalEList<?>)getParameterValues()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigurationPackage.MODISCO_QUERY_CONFIGURATION__QUERY:
				if (resolve) return getQuery();
				return basicGetQuery();
			case ConfigurationPackage.MODISCO_QUERY_CONFIGURATION__PARAMETER_VALUES:
				return getParameterValues();
		}
		return super.eGet(featureID, resolve, coreType);
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
			case ConfigurationPackage.MODISCO_QUERY_CONFIGURATION__QUERY:
				setQuery((ModelQuery)newValue);
				return;
			case ConfigurationPackage.MODISCO_QUERY_CONFIGURATION__PARAMETER_VALUES:
				getParameterValues().clear();
				getParameterValues().addAll((Collection<? extends ParameterValue>)newValue);
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
			case ConfigurationPackage.MODISCO_QUERY_CONFIGURATION__QUERY:
				setQuery((ModelQuery)null);
				return;
			case ConfigurationPackage.MODISCO_QUERY_CONFIGURATION__PARAMETER_VALUES:
				getParameterValues().clear();
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
			case ConfigurationPackage.MODISCO_QUERY_CONFIGURATION__QUERY:
				return query != null;
			case ConfigurationPackage.MODISCO_QUERY_CONFIGURATION__PARAMETER_VALUES:
				return parameterValues != null && !parameterValues.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ModiscoQueryConfigurationImpl
