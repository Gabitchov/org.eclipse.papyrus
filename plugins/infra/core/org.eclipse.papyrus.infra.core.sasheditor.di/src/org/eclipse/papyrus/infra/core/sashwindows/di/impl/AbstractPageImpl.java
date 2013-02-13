/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.core.sashwindows.di.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.infra.core.sashwindows.di.AbstractPage;
import org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Page</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.core.sashwindows.di.impl.AbstractPageImpl#getPageIdentifier <em>Page Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AbstractPageImpl extends EObjectImpl implements AbstractPage {

	/**
	 * The default value of the '{@link #getPageIdentifier() <em>Page Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final Object PAGE_IDENTIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPageIdentifier() <em>Page Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageIdentifier()
	 * @generated
	 * @ordered
	 */
	protected Object pageIdentifier = PAGE_IDENTIFIER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractPageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiPackage.Literals.ABSTRACT_PAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getPageIdentifier() {
		return pageIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPageIdentifier(Object newPageIdentifier) {
		Object oldPageIdentifier = pageIdentifier;
		pageIdentifier = newPageIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiPackage.ABSTRACT_PAGE__PAGE_IDENTIFIER, oldPageIdentifier, pageIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiPackage.ABSTRACT_PAGE__PAGE_IDENTIFIER:
				return getPageIdentifier();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DiPackage.ABSTRACT_PAGE__PAGE_IDENTIFIER:
				setPageIdentifier(newValue);
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
			case DiPackage.ABSTRACT_PAGE__PAGE_IDENTIFIER:
				setPageIdentifier(PAGE_IDENTIFIER_EDEFAULT);
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
			case DiPackage.ABSTRACT_PAGE__PAGE_IDENTIFIER:
				return PAGE_IDENTIFIER_EDEFAULT == null ? pageIdentifier != null : !PAGE_IDENTIFIER_EDEFAULT.equals(pageIdentifier);
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
		result.append(" (pageIdentifier: ");
		result.append(pageIdentifier);
		result.append(')');
		return result.toString();
	}

} //AbstractPageImpl
