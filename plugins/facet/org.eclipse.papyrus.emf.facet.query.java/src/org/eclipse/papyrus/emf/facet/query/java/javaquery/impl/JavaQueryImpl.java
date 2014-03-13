/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Nicolas Guyomar (Mia-Software) - Bug 334615 - Java Query for EMF Facet
 *  
 */
package org.eclipse.papyrus.emf.facet.query.java.javaquery.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.emf.facet.efacet.impl.QueryImpl;
import org.eclipse.papyrus.emf.facet.query.java.javaquery.JavaQuery;
import org.eclipse.papyrus.emf.facet.query.java.javaquery.JavaqueryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Java Query</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.emf.facet.query.java.javaquery.impl.JavaQueryImpl#getImplementationClassName <em>Implementation Class Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 * @deprecated cf. https://bugs.eclipse.org/bugs/show_bug.cgi?id=374198
 */
@Deprecated
public class JavaQueryImpl extends QueryImpl implements JavaQuery {
	/**
	 * The default value of the '{@link #getImplementationClassName() <em>Implementation Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementationClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String IMPLEMENTATION_CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImplementationClassName() <em>Implementation Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementationClassName()
	 * @generated
	 * @ordered
	 */
	protected String implementationClassName = JavaQueryImpl.IMPLEMENTATION_CLASS_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JavaQueryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JavaqueryPackage.Literals.JAVA_QUERY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImplementationClassName() {
		return this.implementationClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementationClassName(final String newImplementationClassName) {
		String oldImplementationClassName = this.implementationClassName;
		this.implementationClassName = newImplementationClassName;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, JavaqueryPackage.JAVA_QUERY__IMPLEMENTATION_CLASS_NAME, oldImplementationClassName, this.implementationClassName));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
		switch (featureID) {
			case JavaqueryPackage.JAVA_QUERY__IMPLEMENTATION_CLASS_NAME:
				return getImplementationClassName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(final int featureID, final Object newValue) {
		switch (featureID) {
			case JavaqueryPackage.JAVA_QUERY__IMPLEMENTATION_CLASS_NAME:
				setImplementationClassName((String)newValue);
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
	public void eUnset(final int featureID) {
		switch (featureID) {
			case JavaqueryPackage.JAVA_QUERY__IMPLEMENTATION_CLASS_NAME:
				setImplementationClassName(JavaQueryImpl.IMPLEMENTATION_CLASS_NAME_EDEFAULT);
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
	public boolean eIsSet(final int featureID) {
		switch (featureID) {
			case JavaqueryPackage.JAVA_QUERY__IMPLEMENTATION_CLASS_NAME:
				return JavaQueryImpl.IMPLEMENTATION_CLASS_NAME_EDEFAULT == null ? this.implementationClassName != null : !JavaQueryImpl.IMPLEMENTATION_CLASS_NAME_EDEFAULT.equals(this.implementationClassName);
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
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (implementationClassName: "); //$NON-NLS-1$
		result.append(this.implementationClassName);
		result.append(')');
		return result.toString();
	}

} //JavaQueryImpl
