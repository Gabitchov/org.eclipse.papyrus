/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.domaincontextcodegen.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage;
import org.eclipse.papyrus.domaincontextcodegen.MetaClassType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Meta Class Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.MetaClassTypeImpl#getMetaClass <em>Meta Class</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class MetaClassTypeImpl extends ElementTypeImpl implements MetaClassType {

	/**
	 * The cached value of the '{@link #getMetaClass() <em>Meta Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getMetaClass()
	 * @generated
	 * @ordered
	 */
	protected EClass metaClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MetaClassTypeImpl() {
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
		return DomaincontextcodegenPackage.Literals.META_CLASS_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getMetaClass() {
		if(metaClass != null && metaClass.eIsProxy()) {
			InternalEObject oldMetaClass = (InternalEObject)metaClass;
			metaClass = (EClass)eResolveProxy(oldMetaClass);
			if(metaClass != oldMetaClass) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DomaincontextcodegenPackage.META_CLASS_TYPE__META_CLASS, oldMetaClass, metaClass));
			}
		}
		return metaClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass basicGetMetaClass() {
		return metaClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setMetaClass(EClass newMetaClass) {
		EClass oldMetaClass = metaClass;
		metaClass = newMetaClass;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.META_CLASS_TYPE__META_CLASS, oldMetaClass, metaClass));
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
		case DomaincontextcodegenPackage.META_CLASS_TYPE__META_CLASS:
			if(resolve)
				return getMetaClass();
			return basicGetMetaClass();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case DomaincontextcodegenPackage.META_CLASS_TYPE__META_CLASS:
			setMetaClass((EClass)newValue);
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
		case DomaincontextcodegenPackage.META_CLASS_TYPE__META_CLASS:
			setMetaClass((EClass)null);
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
		case DomaincontextcodegenPackage.META_CLASS_TYPE__META_CLASS:
			return metaClass != null;
		}
		return super.eIsSet(featureID);
	}

} //MetaClassTypeImpl
