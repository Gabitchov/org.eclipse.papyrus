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
import org.eclipse.papyrus.domaincontextcodegen.Advice;
import org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage;
import org.eclipse.papyrus.domaincontextcodegen.ElementType;
import org.eclipse.papyrus.domaincontextcodegen.InheritanceKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Advice</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.AdviceImpl#getAdviceID <em>Advice ID</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.AdviceImpl#getRef <em>Ref</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.AdviceImpl#getAdvicePath <em>Advice Path</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.AdviceImpl#getInheritance <em>Inheritance</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class AdviceImpl extends EObjectImpl implements Advice {

	/**
	 * The default value of the '{@link #getAdviceID() <em>Advice ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getAdviceID()
	 * @generated
	 * @ordered
	 */
	protected static final String ADVICE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAdviceID() <em>Advice ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getAdviceID()
	 * @generated
	 * @ordered
	 */
	protected String adviceID = ADVICE_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getRef()
	 * @generated
	 * @ordered
	 */
	protected ElementType ref;

	/**
	 * The default value of the '{@link #getAdvicePath() <em>Advice Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getAdvicePath()
	 * @generated
	 * @ordered
	 */
	protected static final String ADVICE_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAdvicePath() <em>Advice Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getAdvicePath()
	 * @generated
	 * @ordered
	 */
	protected String advicePath = ADVICE_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getInheritance() <em>Inheritance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getInheritance()
	 * @generated
	 * @ordered
	 */
	protected static final InheritanceKind INHERITANCE_EDEFAULT = InheritanceKind.NONE;

	/**
	 * The cached value of the '{@link #getInheritance() <em>Inheritance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getInheritance()
	 * @generated
	 * @ordered
	 */
	protected InheritanceKind inheritance = INHERITANCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AdviceImpl() {
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
		return DomaincontextcodegenPackage.Literals.ADVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getAdviceID() {
		return adviceID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAdviceID(String newAdviceID) {
		String oldAdviceID = adviceID;
		adviceID = newAdviceID;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.ADVICE__ADVICE_ID, oldAdviceID, adviceID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ElementType getRef() {
		if(ref != null && ref.eIsProxy()) {
			InternalEObject oldRef = (InternalEObject)ref;
			ref = (ElementType)eResolveProxy(oldRef);
			if(ref != oldRef) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DomaincontextcodegenPackage.ADVICE__REF, oldRef, ref));
			}
		}
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ElementType basicGetRef() {
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setRef(ElementType newRef) {
		ElementType oldRef = ref;
		ref = newRef;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.ADVICE__REF, oldRef, ref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getAdvicePath() {
		return advicePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAdvicePath(String newAdvicePath) {
		String oldAdvicePath = advicePath;
		advicePath = newAdvicePath;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.ADVICE__ADVICE_PATH, oldAdvicePath, advicePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InheritanceKind getInheritance() {
		return inheritance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setInheritance(InheritanceKind newInheritance) {
		InheritanceKind oldInheritance = inheritance;
		inheritance = newInheritance == null ? INHERITANCE_EDEFAULT : newInheritance;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.ADVICE__INHERITANCE, oldInheritance, inheritance));
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
		case DomaincontextcodegenPackage.ADVICE__ADVICE_ID:
			return getAdviceID();
		case DomaincontextcodegenPackage.ADVICE__REF:
			if(resolve)
				return getRef();
			return basicGetRef();
		case DomaincontextcodegenPackage.ADVICE__ADVICE_PATH:
			return getAdvicePath();
		case DomaincontextcodegenPackage.ADVICE__INHERITANCE:
			return getInheritance();
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
		case DomaincontextcodegenPackage.ADVICE__ADVICE_ID:
			setAdviceID((String)newValue);
			return;
		case DomaincontextcodegenPackage.ADVICE__REF:
			setRef((ElementType)newValue);
			return;
		case DomaincontextcodegenPackage.ADVICE__ADVICE_PATH:
			setAdvicePath((String)newValue);
			return;
		case DomaincontextcodegenPackage.ADVICE__INHERITANCE:
			setInheritance((InheritanceKind)newValue);
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
		case DomaincontextcodegenPackage.ADVICE__ADVICE_ID:
			setAdviceID(ADVICE_ID_EDEFAULT);
			return;
		case DomaincontextcodegenPackage.ADVICE__REF:
			setRef((ElementType)null);
			return;
		case DomaincontextcodegenPackage.ADVICE__ADVICE_PATH:
			setAdvicePath(ADVICE_PATH_EDEFAULT);
			return;
		case DomaincontextcodegenPackage.ADVICE__INHERITANCE:
			setInheritance(INHERITANCE_EDEFAULT);
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
		case DomaincontextcodegenPackage.ADVICE__ADVICE_ID:
			return ADVICE_ID_EDEFAULT == null ? adviceID != null : !ADVICE_ID_EDEFAULT.equals(adviceID);
		case DomaincontextcodegenPackage.ADVICE__REF:
			return ref != null;
		case DomaincontextcodegenPackage.ADVICE__ADVICE_PATH:
			return ADVICE_PATH_EDEFAULT == null ? advicePath != null : !ADVICE_PATH_EDEFAULT.equals(advicePath);
		case DomaincontextcodegenPackage.ADVICE__INHERITANCE:
			return inheritance != INHERITANCE_EDEFAULT;
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
		result.append(" (adviceID: ");
		result.append(adviceID);
		result.append(", advicePath: ");
		result.append(advicePath);
		result.append(", inheritance: ");
		result.append(inheritance);
		result.append(')');
		return result.toString();
	}

} //AdviceImpl
