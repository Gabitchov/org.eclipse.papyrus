/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.domaincontextcodegen.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage;
import org.eclipse.papyrus.domaincontextcodegen.GenHandlers;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gen Handlers</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.GenHandlersImpl#getHandlerPackage <em>Handler Package</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.GenHandlersImpl#getSuperClass <em>Super Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.GenHandlersImpl#getSuperClassPackage <em>Super Class Package</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.GenHandlersImpl#getElementTypeEnumerator <em>Element Type Enumerator</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.GenHandlersImpl#getElementTypeEnumeratorPackage <em>Element Type Enumerator Package</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class GenHandlersImpl extends EObjectImpl implements GenHandlers {

	/**
	 * The default value of the '{@link #getHandlerPackage() <em>Handler Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getHandlerPackage()
	 * @generated
	 * @ordered
	 */
	protected static final String HANDLER_PACKAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHandlerPackage() <em>Handler Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getHandlerPackage()
	 * @generated
	 * @ordered
	 */
	protected String handlerPackage = HANDLER_PACKAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSuperClass() <em>Super Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSuperClass()
	 * @generated
	 * @ordered
	 */
	protected static final String SUPER_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSuperClass() <em>Super Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSuperClass()
	 * @generated
	 * @ordered
	 */
	protected String superClass = SUPER_CLASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getSuperClassPackage() <em>Super Class Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSuperClassPackage()
	 * @generated
	 * @ordered
	 */
	protected static final String SUPER_CLASS_PACKAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSuperClassPackage() <em>Super Class Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSuperClassPackage()
	 * @generated
	 * @ordered
	 */
	protected String superClassPackage = SUPER_CLASS_PACKAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getElementTypeEnumerator() <em>Element Type Enumerator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getElementTypeEnumerator()
	 * @generated
	 * @ordered
	 */
	protected static final String ELEMENT_TYPE_ENUMERATOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getElementTypeEnumerator() <em>Element Type Enumerator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getElementTypeEnumerator()
	 * @generated
	 * @ordered
	 */
	protected String elementTypeEnumerator = ELEMENT_TYPE_ENUMERATOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getElementTypeEnumeratorPackage() <em>Element Type Enumerator Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getElementTypeEnumeratorPackage()
	 * @generated
	 * @ordered
	 */
	protected static final String ELEMENT_TYPE_ENUMERATOR_PACKAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getElementTypeEnumeratorPackage() <em>Element Type Enumerator Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getElementTypeEnumeratorPackage()
	 * @generated
	 * @ordered
	 */
	protected String elementTypeEnumeratorPackage = ELEMENT_TYPE_ENUMERATOR_PACKAGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected GenHandlersImpl() {
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
		return DomaincontextcodegenPackage.Literals.GEN_HANDLERS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getHandlerPackage() {
		return handlerPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setHandlerPackage(String newHandlerPackage) {
		String oldHandlerPackage = handlerPackage;
		handlerPackage = newHandlerPackage;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.GEN_HANDLERS__HANDLER_PACKAGE, oldHandlerPackage, handlerPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getSuperClass() {
		return superClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSuperClass(String newSuperClass) {
		String oldSuperClass = superClass;
		superClass = newSuperClass;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.GEN_HANDLERS__SUPER_CLASS, oldSuperClass, superClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getSuperClassPackage() {
		return superClassPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSuperClassPackage(String newSuperClassPackage) {
		String oldSuperClassPackage = superClassPackage;
		superClassPackage = newSuperClassPackage;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.GEN_HANDLERS__SUPER_CLASS_PACKAGE, oldSuperClassPackage, superClassPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getElementTypeEnumerator() {
		return elementTypeEnumerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setElementTypeEnumerator(String newElementTypeEnumerator) {
		String oldElementTypeEnumerator = elementTypeEnumerator;
		elementTypeEnumerator = newElementTypeEnumerator;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.GEN_HANDLERS__ELEMENT_TYPE_ENUMERATOR, oldElementTypeEnumerator, elementTypeEnumerator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getElementTypeEnumeratorPackage() {
		return elementTypeEnumeratorPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setElementTypeEnumeratorPackage(String newElementTypeEnumeratorPackage) {
		String oldElementTypeEnumeratorPackage = elementTypeEnumeratorPackage;
		elementTypeEnumeratorPackage = newElementTypeEnumeratorPackage;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.GEN_HANDLERS__ELEMENT_TYPE_ENUMERATOR_PACKAGE, oldElementTypeEnumeratorPackage, elementTypeEnumeratorPackage));
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
		case DomaincontextcodegenPackage.GEN_HANDLERS__HANDLER_PACKAGE:
			return getHandlerPackage();
		case DomaincontextcodegenPackage.GEN_HANDLERS__SUPER_CLASS:
			return getSuperClass();
		case DomaincontextcodegenPackage.GEN_HANDLERS__SUPER_CLASS_PACKAGE:
			return getSuperClassPackage();
		case DomaincontextcodegenPackage.GEN_HANDLERS__ELEMENT_TYPE_ENUMERATOR:
			return getElementTypeEnumerator();
		case DomaincontextcodegenPackage.GEN_HANDLERS__ELEMENT_TYPE_ENUMERATOR_PACKAGE:
			return getElementTypeEnumeratorPackage();
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
		case DomaincontextcodegenPackage.GEN_HANDLERS__HANDLER_PACKAGE:
			setHandlerPackage((String)newValue);
			return;
		case DomaincontextcodegenPackage.GEN_HANDLERS__SUPER_CLASS:
			setSuperClass((String)newValue);
			return;
		case DomaincontextcodegenPackage.GEN_HANDLERS__SUPER_CLASS_PACKAGE:
			setSuperClassPackage((String)newValue);
			return;
		case DomaincontextcodegenPackage.GEN_HANDLERS__ELEMENT_TYPE_ENUMERATOR:
			setElementTypeEnumerator((String)newValue);
			return;
		case DomaincontextcodegenPackage.GEN_HANDLERS__ELEMENT_TYPE_ENUMERATOR_PACKAGE:
			setElementTypeEnumeratorPackage((String)newValue);
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
		case DomaincontextcodegenPackage.GEN_HANDLERS__HANDLER_PACKAGE:
			setHandlerPackage(HANDLER_PACKAGE_EDEFAULT);
			return;
		case DomaincontextcodegenPackage.GEN_HANDLERS__SUPER_CLASS:
			setSuperClass(SUPER_CLASS_EDEFAULT);
			return;
		case DomaincontextcodegenPackage.GEN_HANDLERS__SUPER_CLASS_PACKAGE:
			setSuperClassPackage(SUPER_CLASS_PACKAGE_EDEFAULT);
			return;
		case DomaincontextcodegenPackage.GEN_HANDLERS__ELEMENT_TYPE_ENUMERATOR:
			setElementTypeEnumerator(ELEMENT_TYPE_ENUMERATOR_EDEFAULT);
			return;
		case DomaincontextcodegenPackage.GEN_HANDLERS__ELEMENT_TYPE_ENUMERATOR_PACKAGE:
			setElementTypeEnumeratorPackage(ELEMENT_TYPE_ENUMERATOR_PACKAGE_EDEFAULT);
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
		case DomaincontextcodegenPackage.GEN_HANDLERS__HANDLER_PACKAGE:
			return HANDLER_PACKAGE_EDEFAULT == null ? handlerPackage != null : !HANDLER_PACKAGE_EDEFAULT.equals(handlerPackage);
		case DomaincontextcodegenPackage.GEN_HANDLERS__SUPER_CLASS:
			return SUPER_CLASS_EDEFAULT == null ? superClass != null : !SUPER_CLASS_EDEFAULT.equals(superClass);
		case DomaincontextcodegenPackage.GEN_HANDLERS__SUPER_CLASS_PACKAGE:
			return SUPER_CLASS_PACKAGE_EDEFAULT == null ? superClassPackage != null : !SUPER_CLASS_PACKAGE_EDEFAULT.equals(superClassPackage);
		case DomaincontextcodegenPackage.GEN_HANDLERS__ELEMENT_TYPE_ENUMERATOR:
			return ELEMENT_TYPE_ENUMERATOR_EDEFAULT == null ? elementTypeEnumerator != null : !ELEMENT_TYPE_ENUMERATOR_EDEFAULT.equals(elementTypeEnumerator);
		case DomaincontextcodegenPackage.GEN_HANDLERS__ELEMENT_TYPE_ENUMERATOR_PACKAGE:
			return ELEMENT_TYPE_ENUMERATOR_PACKAGE_EDEFAULT == null ? elementTypeEnumeratorPackage != null : !ELEMENT_TYPE_ENUMERATOR_PACKAGE_EDEFAULT.equals(elementTypeEnumeratorPackage);
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
		result.append(" (handlerPackage: ");
		result.append(handlerPackage);
		result.append(", superClass: ");
		result.append(superClass);
		result.append(", superClassPackage: ");
		result.append(superClassPackage);
		result.append(", elementTypeEnumerator: ");
		result.append(elementTypeEnumerator);
		result.append(", elementTypeEnumeratorPackage: ");
		result.append(elementTypeEnumeratorPackage);
		result.append(')');
		return result.toString();
	}

} //GenHandlersImpl
