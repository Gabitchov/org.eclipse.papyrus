/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.FCM.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.FCM.FCMPackage;
import org.eclipse.papyrus.FCM.InteractionComponent;
import org.eclipse.uml2.uml.Collaboration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Interaction Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.FCM.impl.InteractionComponentImpl#isForDistribution <em>For Distribution</em>}</li>
 *   <li>{@link org.eclipse.papyrus.FCM.impl.InteractionComponentImpl#getConnectionPattern <em>Connection Pattern</em>}</li>
 *   <li>{@link org.eclipse.papyrus.FCM.impl.InteractionComponentImpl#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InteractionComponentImpl extends EObjectImpl implements InteractionComponent {
	/**
	 * The default value of the '{@link #isForDistribution() <em>For Distribution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isForDistribution()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FOR_DISTRIBUTION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isForDistribution() <em>For Distribution</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isForDistribution()
	 * @generated
	 * @ordered
	 */
	protected boolean forDistribution = FOR_DISTRIBUTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConnectionPattern() <em>Connection Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectionPattern()
	 * @generated
	 * @ordered
	 */
	protected Collaboration connectionPattern;

	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InteractionComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FCMPackage.Literals.INTERACTION_COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isForDistribution() {
		return forDistribution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForDistribution(boolean newForDistribution) {
		boolean oldForDistribution = forDistribution;
		forDistribution = newForDistribution;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FCMPackage.INTERACTION_COMPONENT__FOR_DISTRIBUTION, oldForDistribution, forDistribution));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collaboration getConnectionPattern() {
		if (connectionPattern != null && connectionPattern.eIsProxy()) {
			InternalEObject oldConnectionPattern = (InternalEObject)connectionPattern;
			connectionPattern = (Collaboration)eResolveProxy(oldConnectionPattern);
			if (connectionPattern != oldConnectionPattern) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FCMPackage.INTERACTION_COMPONENT__CONNECTION_PATTERN, oldConnectionPattern, connectionPattern));
			}
		}
		return connectionPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collaboration basicGetConnectionPattern() {
		return connectionPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionPattern(Collaboration newConnectionPattern) {
		Collaboration oldConnectionPattern = connectionPattern;
		connectionPattern = newConnectionPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FCMPackage.INTERACTION_COMPONENT__CONNECTION_PATTERN, oldConnectionPattern, connectionPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if (base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject)base_Class;
			base_Class = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBase_Class);
			if (base_Class != oldBase_Class) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FCMPackage.INTERACTION_COMPONENT__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FCMPackage.INTERACTION_COMPONENT__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FCMPackage.INTERACTION_COMPONENT__FOR_DISTRIBUTION:
				return isForDistribution();
			case FCMPackage.INTERACTION_COMPONENT__CONNECTION_PATTERN:
				if (resolve) return getConnectionPattern();
				return basicGetConnectionPattern();
			case FCMPackage.INTERACTION_COMPONENT__BASE_CLASS:
				if (resolve) return getBase_Class();
				return basicGetBase_Class();
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
			case FCMPackage.INTERACTION_COMPONENT__FOR_DISTRIBUTION:
				setForDistribution((Boolean)newValue);
				return;
			case FCMPackage.INTERACTION_COMPONENT__CONNECTION_PATTERN:
				setConnectionPattern((Collaboration)newValue);
				return;
			case FCMPackage.INTERACTION_COMPONENT__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)newValue);
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
			case FCMPackage.INTERACTION_COMPONENT__FOR_DISTRIBUTION:
				setForDistribution(FOR_DISTRIBUTION_EDEFAULT);
				return;
			case FCMPackage.INTERACTION_COMPONENT__CONNECTION_PATTERN:
				setConnectionPattern((Collaboration)null);
				return;
			case FCMPackage.INTERACTION_COMPONENT__BASE_CLASS:
				setBase_Class((org.eclipse.uml2.uml.Class)null);
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
			case FCMPackage.INTERACTION_COMPONENT__FOR_DISTRIBUTION:
				return forDistribution != FOR_DISTRIBUTION_EDEFAULT;
			case FCMPackage.INTERACTION_COMPONENT__CONNECTION_PATTERN:
				return connectionPattern != null;
			case FCMPackage.INTERACTION_COMPONENT__BASE_CLASS:
				return base_Class != null;
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
		result.append(" (forDistribution: ");
		result.append(forDistribution);
		result.append(')');
		return result.toString();
	}

} //InteractionComponentImpl
