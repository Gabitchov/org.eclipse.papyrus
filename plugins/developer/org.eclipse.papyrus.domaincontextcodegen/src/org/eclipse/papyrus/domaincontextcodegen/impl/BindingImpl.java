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
import org.eclipse.papyrus.domaincontextcodegen.Binding;
import org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.BindingImpl#getAdvice <em>Advice</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.BindingImpl#getElementTypePattern <em>Element Type Pattern</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.BindingImpl#getAdviceID <em>Advice ID</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class BindingImpl extends EObjectImpl implements Binding {

	/**
	 * The cached value of the '{@link #getAdvice() <em>Advice</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getAdvice()
	 * @generated
	 * @ordered
	 */
	protected AdviceBinding advice;

	/**
	 * The default value of the '{@link #getElementTypePattern() <em>Element Type Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getElementTypePattern()
	 * @generated
	 * @ordered
	 */
	protected static final String ELEMENT_TYPE_PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getElementTypePattern() <em>Element Type Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getElementTypePattern()
	 * @generated
	 * @ordered
	 */
	protected String elementTypePattern = ELEMENT_TYPE_PATTERN_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected BindingImpl() {
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
		return DomaincontextcodegenPackage.Literals.BINDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AdviceBinding getAdvice() {
		if(advice != null && advice.eIsProxy()) {
			InternalEObject oldAdvice = (InternalEObject)advice;
			advice = (AdviceBinding)eResolveProxy(oldAdvice);
			if(advice != oldAdvice) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DomaincontextcodegenPackage.BINDING__ADVICE, oldAdvice, advice));
			}
		}
		return advice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AdviceBinding basicGetAdvice() {
		return advice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setAdvice(AdviceBinding newAdvice) {
		AdviceBinding oldAdvice = advice;
		advice = newAdvice;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.BINDING__ADVICE, oldAdvice, advice));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getElementTypePattern() {
		return elementTypePattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setElementTypePattern(String newElementTypePattern) {
		String oldElementTypePattern = elementTypePattern;
		elementTypePattern = newElementTypePattern;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.BINDING__ELEMENT_TYPE_PATTERN, oldElementTypePattern, elementTypePattern));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.BINDING__ADVICE_ID, oldAdviceID, adviceID));
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
		case DomaincontextcodegenPackage.BINDING__ADVICE:
			if(resolve)
				return getAdvice();
			return basicGetAdvice();
		case DomaincontextcodegenPackage.BINDING__ELEMENT_TYPE_PATTERN:
			return getElementTypePattern();
		case DomaincontextcodegenPackage.BINDING__ADVICE_ID:
			return getAdviceID();
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
		case DomaincontextcodegenPackage.BINDING__ADVICE:
			setAdvice((AdviceBinding)newValue);
			return;
		case DomaincontextcodegenPackage.BINDING__ELEMENT_TYPE_PATTERN:
			setElementTypePattern((String)newValue);
			return;
		case DomaincontextcodegenPackage.BINDING__ADVICE_ID:
			setAdviceID((String)newValue);
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
		case DomaincontextcodegenPackage.BINDING__ADVICE:
			setAdvice((AdviceBinding)null);
			return;
		case DomaincontextcodegenPackage.BINDING__ELEMENT_TYPE_PATTERN:
			setElementTypePattern(ELEMENT_TYPE_PATTERN_EDEFAULT);
			return;
		case DomaincontextcodegenPackage.BINDING__ADVICE_ID:
			setAdviceID(ADVICE_ID_EDEFAULT);
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
		case DomaincontextcodegenPackage.BINDING__ADVICE:
			return advice != null;
		case DomaincontextcodegenPackage.BINDING__ELEMENT_TYPE_PATTERN:
			return ELEMENT_TYPE_PATTERN_EDEFAULT == null ? elementTypePattern != null : !ELEMENT_TYPE_PATTERN_EDEFAULT.equals(elementTypePattern);
		case DomaincontextcodegenPackage.BINDING__ADVICE_ID:
			return ADVICE_ID_EDEFAULT == null ? adviceID != null : !ADVICE_ID_EDEFAULT.equals(adviceID);
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
		result.append(" (elementTypePattern: ");
		result.append(elementTypePattern);
		result.append(", adviceID: ");
		result.append(adviceID);
		result.append(')');
		return result.toString();
	}

} //BindingImpl
