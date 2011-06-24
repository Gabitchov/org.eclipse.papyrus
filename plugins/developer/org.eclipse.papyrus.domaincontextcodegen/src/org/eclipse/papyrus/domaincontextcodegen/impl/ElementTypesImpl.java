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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.domaincontextcodegen.DomainContext;
import org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage;
import org.eclipse.papyrus.domaincontextcodegen.ElementType;
import org.eclipse.papyrus.domaincontextcodegen.ElementTypes;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Types</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.ElementTypesImpl#getTypes <em>Types</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.ElementTypesImpl#getDomain <em>Domain</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ElementTypesImpl extends EObjectImpl implements ElementTypes {

	/**
	 * The cached value of the '{@link #getTypes() <em>Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<ElementType> types;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ElementTypesImpl() {
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
		return DomaincontextcodegenPackage.Literals.ELEMENT_TYPES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<ElementType> getTypes() {
		if(types == null) {
			types = new EObjectContainmentWithInverseEList<ElementType>(ElementType.class, this, DomaincontextcodegenPackage.ELEMENT_TYPES__TYPES, DomaincontextcodegenPackage.ELEMENT_TYPE__OWNER);
		}
		return types;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DomainContext getDomain() {
		if(eContainerFeatureID() != DomaincontextcodegenPackage.ELEMENT_TYPES__DOMAIN)
			return null;
		return (DomainContext)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetDomain(DomainContext newDomain, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDomain, DomaincontextcodegenPackage.ELEMENT_TYPES__DOMAIN, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDomain(DomainContext newDomain) {
		if(newDomain != eInternalContainer() || (eContainerFeatureID() != DomaincontextcodegenPackage.ELEMENT_TYPES__DOMAIN && newDomain != null)) {
			if(EcoreUtil.isAncestor(this, newDomain))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if(newDomain != null)
				msgs = ((InternalEObject)newDomain).eInverseAdd(this, DomaincontextcodegenPackage.DOMAIN_CONTEXT__ELEMENT_TYPES, DomainContext.class, msgs);
			msgs = basicSetDomain(newDomain, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.ELEMENT_TYPES__DOMAIN, newDomain, newDomain));
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
		case DomaincontextcodegenPackage.ELEMENT_TYPES__TYPES:
			return ((InternalEList<InternalEObject>)(InternalEList<?>)getTypes()).basicAdd(otherEnd, msgs);
		case DomaincontextcodegenPackage.ELEMENT_TYPES__DOMAIN:
			if(eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetDomain((DomainContext)otherEnd, msgs);
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
		case DomaincontextcodegenPackage.ELEMENT_TYPES__TYPES:
			return ((InternalEList<?>)getTypes()).basicRemove(otherEnd, msgs);
		case DomaincontextcodegenPackage.ELEMENT_TYPES__DOMAIN:
			return basicSetDomain(null, msgs);
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch(eContainerFeatureID()) {
		case DomaincontextcodegenPackage.ELEMENT_TYPES__DOMAIN:
			return eInternalContainer().eInverseRemove(this, DomaincontextcodegenPackage.DOMAIN_CONTEXT__ELEMENT_TYPES, DomainContext.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
		case DomaincontextcodegenPackage.ELEMENT_TYPES__TYPES:
			return getTypes();
		case DomaincontextcodegenPackage.ELEMENT_TYPES__DOMAIN:
			return getDomain();
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
		case DomaincontextcodegenPackage.ELEMENT_TYPES__TYPES:
			getTypes().clear();
			getTypes().addAll((Collection<? extends ElementType>)newValue);
			return;
		case DomaincontextcodegenPackage.ELEMENT_TYPES__DOMAIN:
			setDomain((DomainContext)newValue);
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
		case DomaincontextcodegenPackage.ELEMENT_TYPES__TYPES:
			getTypes().clear();
			return;
		case DomaincontextcodegenPackage.ELEMENT_TYPES__DOMAIN:
			setDomain((DomainContext)null);
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
		case DomaincontextcodegenPackage.ELEMENT_TYPES__TYPES:
			return types != null && !types.isEmpty();
		case DomaincontextcodegenPackage.ELEMENT_TYPES__DOMAIN:
			return getDomain() != null;
		}
		return super.eIsSet(featureID);
	}

} //ElementTypesImpl
