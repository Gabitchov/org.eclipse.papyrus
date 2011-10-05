/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.domaincontextcodegen.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.domaincontextcodegen.Binding;
import org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage;
import org.eclipse.papyrus.domaincontextcodegen.ElementTypeBindings;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Type Bindings</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.ElementTypeBindingsImpl#getClientContextID <em>Client Context ID</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.ElementTypeBindingsImpl#getBindings <em>Bindings</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ElementTypeBindingsImpl extends EObjectImpl implements ElementTypeBindings {

	/**
	 * The default value of the '{@link #getClientContextID() <em>Client Context ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getClientContextID()
	 * @generated
	 * @ordered
	 */
	protected static final String CLIENT_CONTEXT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClientContextID() <em>Client Context ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getClientContextID()
	 * @generated
	 * @ordered
	 */
	protected String clientContextID = CLIENT_CONTEXT_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBindings() <em>Bindings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBindings()
	 * @generated
	 * @ordered
	 */
	protected EList<Binding> bindings;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ElementTypeBindingsImpl() {
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
		return DomaincontextcodegenPackage.Literals.ELEMENT_TYPE_BINDINGS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getClientContextID() {
		return clientContextID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setClientContextID(String newClientContextID) {
		String oldClientContextID = clientContextID;
		clientContextID = newClientContextID;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.ELEMENT_TYPE_BINDINGS__CLIENT_CONTEXT_ID, oldClientContextID, clientContextID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Binding> getBindings() {
		if(bindings == null) {
			bindings = new EObjectContainmentWithInverseEList<Binding>(Binding.class, this, DomaincontextcodegenPackage.ELEMENT_TYPE_BINDINGS__BINDINGS, DomaincontextcodegenPackage.BINDING__OWNER);
		}
		return bindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
		case DomaincontextcodegenPackage.ELEMENT_TYPE_BINDINGS__BINDINGS:
			return ((InternalEList<InternalEObject>)(InternalEList<?>)getBindings()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
		case DomaincontextcodegenPackage.ELEMENT_TYPE_BINDINGS__BINDINGS:
			return ((InternalEList<?>)getBindings()).basicRemove(otherEnd, msgs);
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
		case DomaincontextcodegenPackage.ELEMENT_TYPE_BINDINGS__CLIENT_CONTEXT_ID:
			return getClientContextID();
		case DomaincontextcodegenPackage.ELEMENT_TYPE_BINDINGS__BINDINGS:
			return getBindings();
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
		case DomaincontextcodegenPackage.ELEMENT_TYPE_BINDINGS__CLIENT_CONTEXT_ID:
			setClientContextID((String)newValue);
			return;
		case DomaincontextcodegenPackage.ELEMENT_TYPE_BINDINGS__BINDINGS:
			getBindings().clear();
			getBindings().addAll((Collection<? extends Binding>)newValue);
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
		case DomaincontextcodegenPackage.ELEMENT_TYPE_BINDINGS__CLIENT_CONTEXT_ID:
			setClientContextID(CLIENT_CONTEXT_ID_EDEFAULT);
			return;
		case DomaincontextcodegenPackage.ELEMENT_TYPE_BINDINGS__BINDINGS:
			getBindings().clear();
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
		case DomaincontextcodegenPackage.ELEMENT_TYPE_BINDINGS__CLIENT_CONTEXT_ID:
			return CLIENT_CONTEXT_ID_EDEFAULT == null ? clientContextID != null : !CLIENT_CONTEXT_ID_EDEFAULT.equals(clientContextID);
		case DomaincontextcodegenPackage.ELEMENT_TYPE_BINDINGS__BINDINGS:
			return bindings != null && !bindings.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if(eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (clientContextID: ");
		result.append(clientContextID);
		result.append(')');
		return result.toString();
	}

} //ElementTypeBindingsImpl
