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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.papyrus.domaincontextcodegen.AdviceBinding;
import org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage;
import org.eclipse.papyrus.domaincontextcodegen.ElementType;
import org.eclipse.papyrus.domaincontextcodegen.InheritanceKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Advice Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.AdviceBindingImpl#getAdvicePath <em>Advice Path</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.AdviceBindingImpl#getAdviceID <em>Advice ID</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.AdviceBindingImpl#getInheritance <em>Inheritance</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.AdviceBindingImpl#getElementTypeRef <em>Element Type Ref</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.AdviceBindingImpl#getElementTypeIDref <em>Element Type IDref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AdviceBindingImpl extends EObjectImpl implements AdviceBinding {
	/**
	 * The default value of the '{@link #getAdvicePath() <em>Advice Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdvicePath()
	 * @generated
	 * @ordered
	 */
	protected static final String ADVICE_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAdvicePath() <em>Advice Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdvicePath()
	 * @generated
	 * @ordered
	 */
	protected String advicePath = ADVICE_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getAdviceID() <em>Advice ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdviceID()
	 * @generated
	 * @ordered
	 */
	protected static final String ADVICE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAdviceID() <em>Advice ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdviceID()
	 * @generated
	 * @ordered
	 */
	protected String adviceID = ADVICE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getInheritance() <em>Inheritance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritance()
	 * @generated
	 * @ordered
	 */
	protected static final InheritanceKind INHERITANCE_EDEFAULT = InheritanceKind.NONE;

	/**
	 * The cached value of the '{@link #getInheritance() <em>Inheritance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritance()
	 * @generated
	 * @ordered
	 */
	protected InheritanceKind inheritance = INHERITANCE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getElementTypeRef() <em>Element Type Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementTypeRef()
	 * @generated
	 * @ordered
	 */
	protected ElementType elementTypeRef;

	/**
	 * The default value of the '{@link #getElementTypeIDref() <em>Element Type IDref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementTypeIDref()
	 * @generated
	 * @ordered
	 */
	protected static final String ELEMENT_TYPE_IDREF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getElementTypeIDref() <em>Element Type IDref</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementTypeIDref()
	 * @generated
	 * @ordered
	 */
	protected String elementTypeIDref = ELEMENT_TYPE_IDREF_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdviceBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DomaincontextcodegenPackage.Literals.ADVICE_BINDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAdvicePath() {
		return advicePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdvicePath(String newAdvicePath) {
		String oldAdvicePath = advicePath;
		advicePath = newAdvicePath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.ADVICE_BINDING__ADVICE_PATH, oldAdvicePath, advicePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAdviceID() {
		return adviceID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdviceID(String newAdviceID) {
		String oldAdviceID = adviceID;
		adviceID = newAdviceID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.ADVICE_BINDING__ADVICE_ID, oldAdviceID, adviceID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InheritanceKind getInheritance() {
		return inheritance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInheritance(InheritanceKind newInheritance) {
		InheritanceKind oldInheritance = inheritance;
		inheritance = newInheritance == null ? INHERITANCE_EDEFAULT : newInheritance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.ADVICE_BINDING__INHERITANCE, oldInheritance, inheritance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementType getElementTypeRef() {
		if (elementTypeRef != null && elementTypeRef.eIsProxy()) {
			InternalEObject oldElementTypeRef = (InternalEObject)elementTypeRef;
			elementTypeRef = (ElementType)eResolveProxy(oldElementTypeRef);
			if (elementTypeRef != oldElementTypeRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DomaincontextcodegenPackage.ADVICE_BINDING__ELEMENT_TYPE_REF, oldElementTypeRef, elementTypeRef));
			}
		}
		return elementTypeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementType basicGetElementTypeRef() {
		return elementTypeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementTypeRef(ElementType newElementTypeRef) {
		ElementType oldElementTypeRef = elementTypeRef;
		elementTypeRef = newElementTypeRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.ADVICE_BINDING__ELEMENT_TYPE_REF, oldElementTypeRef, elementTypeRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getElementTypeIDref() {
		return elementTypeIDref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementTypeIDref(String newElementTypeIDref) {
		String oldElementTypeIDref = elementTypeIDref;
		elementTypeIDref = newElementTypeIDref;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.ADVICE_BINDING__ELEMENT_TYPE_IDREF, oldElementTypeIDref, elementTypeIDref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DomaincontextcodegenPackage.ADVICE_BINDING__ADVICE_PATH:
				return getAdvicePath();
			case DomaincontextcodegenPackage.ADVICE_BINDING__ADVICE_ID:
				return getAdviceID();
			case DomaincontextcodegenPackage.ADVICE_BINDING__INHERITANCE:
				return getInheritance();
			case DomaincontextcodegenPackage.ADVICE_BINDING__ELEMENT_TYPE_REF:
				if (resolve) return getElementTypeRef();
				return basicGetElementTypeRef();
			case DomaincontextcodegenPackage.ADVICE_BINDING__ELEMENT_TYPE_IDREF:
				return getElementTypeIDref();
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
			case DomaincontextcodegenPackage.ADVICE_BINDING__ADVICE_PATH:
				setAdvicePath((String)newValue);
				return;
			case DomaincontextcodegenPackage.ADVICE_BINDING__ADVICE_ID:
				setAdviceID((String)newValue);
				return;
			case DomaincontextcodegenPackage.ADVICE_BINDING__INHERITANCE:
				setInheritance((InheritanceKind)newValue);
				return;
			case DomaincontextcodegenPackage.ADVICE_BINDING__ELEMENT_TYPE_REF:
				setElementTypeRef((ElementType)newValue);
				return;
			case DomaincontextcodegenPackage.ADVICE_BINDING__ELEMENT_TYPE_IDREF:
				setElementTypeIDref((String)newValue);
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
			case DomaincontextcodegenPackage.ADVICE_BINDING__ADVICE_PATH:
				setAdvicePath(ADVICE_PATH_EDEFAULT);
				return;
			case DomaincontextcodegenPackage.ADVICE_BINDING__ADVICE_ID:
				setAdviceID(ADVICE_ID_EDEFAULT);
				return;
			case DomaincontextcodegenPackage.ADVICE_BINDING__INHERITANCE:
				setInheritance(INHERITANCE_EDEFAULT);
				return;
			case DomaincontextcodegenPackage.ADVICE_BINDING__ELEMENT_TYPE_REF:
				setElementTypeRef((ElementType)null);
				return;
			case DomaincontextcodegenPackage.ADVICE_BINDING__ELEMENT_TYPE_IDREF:
				setElementTypeIDref(ELEMENT_TYPE_IDREF_EDEFAULT);
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
			case DomaincontextcodegenPackage.ADVICE_BINDING__ADVICE_PATH:
				return ADVICE_PATH_EDEFAULT == null ? advicePath != null : !ADVICE_PATH_EDEFAULT.equals(advicePath);
			case DomaincontextcodegenPackage.ADVICE_BINDING__ADVICE_ID:
				return ADVICE_ID_EDEFAULT == null ? adviceID != null : !ADVICE_ID_EDEFAULT.equals(adviceID);
			case DomaincontextcodegenPackage.ADVICE_BINDING__INHERITANCE:
				return inheritance != INHERITANCE_EDEFAULT;
			case DomaincontextcodegenPackage.ADVICE_BINDING__ELEMENT_TYPE_REF:
				return elementTypeRef != null;
			case DomaincontextcodegenPackage.ADVICE_BINDING__ELEMENT_TYPE_IDREF:
				return ELEMENT_TYPE_IDREF_EDEFAULT == null ? elementTypeIDref != null : !ELEMENT_TYPE_IDREF_EDEFAULT.equals(elementTypeIDref);
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
		result.append(" (advicePath: ");
		result.append(advicePath);
		result.append(", adviceID: ");
		result.append(adviceID);
		result.append(", inheritance: ");
		result.append(inheritance);
		result.append(", elementTypeIDref: ");
		result.append(elementTypeIDref);
		result.append(')');
		return result.toString();
	}

} //AdviceBindingImpl
