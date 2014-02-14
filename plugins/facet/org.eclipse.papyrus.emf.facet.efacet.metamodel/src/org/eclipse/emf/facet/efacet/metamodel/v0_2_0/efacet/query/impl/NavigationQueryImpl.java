/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 * 	Gregoire Dupe (Mia-Software) - Design
 * 	Nicolas Guyomar (Mia-Software) - Implementation
 * 	Emmanuelle RouillÃ© (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values. 
 * 	Nicolas Bros (Mia-Software) - Bug 361823 - [Restructuring] eFacet2 meta-model
 *       Gregoire Dupe (Mia-Software) - Bug 366055 - NavigationQuery
 */
package org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.impl.QueryImpl;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.NavigationQuery;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.QueryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Navigation Query</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.NavigationQueryImpl#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.query.impl.NavigationQueryImpl#isFailOnError <em>Fail On Error</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NavigationQueryImpl extends QueryImpl implements NavigationQuery {
	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected EList<ETypedElement> path;

	/**
	 * The default value of the '{@link #isFailOnError() <em>Fail On Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFailOnError()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FAIL_ON_ERROR_EDEFAULT = true;
	/**
	 * The cached value of the '{@link #isFailOnError() <em>Fail On Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFailOnError()
	 * @generated
	 * @ordered
	 */
	protected boolean failOnError = FAIL_ON_ERROR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NavigationQueryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QueryPackage.Literals.NAVIGATION_QUERY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ETypedElement> getPath() {
		if (path == null) {
			path = new EObjectResolvingEList<ETypedElement>(ETypedElement.class, this, QueryPackage.NAVIGATION_QUERY__PATH);
		}
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFailOnError() {
		return failOnError;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFailOnError(boolean newFailOnError) {
		boolean oldFailOnError = failOnError;
		failOnError = newFailOnError;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QueryPackage.NAVIGATION_QUERY__FAIL_ON_ERROR, oldFailOnError, failOnError));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QueryPackage.NAVIGATION_QUERY__PATH:
				return getPath();
			case QueryPackage.NAVIGATION_QUERY__FAIL_ON_ERROR:
				return isFailOnError();
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
			case QueryPackage.NAVIGATION_QUERY__PATH:
				getPath().clear();
				getPath().addAll((Collection<? extends ETypedElement>)newValue);
				return;
			case QueryPackage.NAVIGATION_QUERY__FAIL_ON_ERROR:
				setFailOnError((Boolean)newValue);
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
			case QueryPackage.NAVIGATION_QUERY__PATH:
				getPath().clear();
				return;
			case QueryPackage.NAVIGATION_QUERY__FAIL_ON_ERROR:
				setFailOnError(FAIL_ON_ERROR_EDEFAULT);
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
			case QueryPackage.NAVIGATION_QUERY__PATH:
				return path != null && !path.isEmpty();
			case QueryPackage.NAVIGATION_QUERY__FAIL_ON_ERROR:
				return failOnError != FAIL_ON_ERROR_EDEFAULT;
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
		result.append(" (failOnError: "); //$NON-NLS-1$
		result.append(failOnError);
		result.append(')');
		return result.toString();
	}

} //NavigationQueryImpl
