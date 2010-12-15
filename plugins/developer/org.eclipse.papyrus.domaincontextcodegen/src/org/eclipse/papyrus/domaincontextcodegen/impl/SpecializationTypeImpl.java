/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.domaincontextcodegen.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage;
import org.eclipse.papyrus.domaincontextcodegen.ElementType;
import org.eclipse.papyrus.domaincontextcodegen.GenHelper;
import org.eclipse.papyrus.domaincontextcodegen.GenMatcher;
import org.eclipse.papyrus.domaincontextcodegen.SpecializationType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specialization Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.SpecializationTypeImpl#getRef <em>Ref</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.SpecializationTypeImpl#getMatcher <em>Matcher</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.SpecializationTypeImpl#getGenMatcher <em>Gen Matcher</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.SpecializationTypeImpl#getGenHelper <em>Gen Helper</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class SpecializationTypeImpl extends ElementTypeImpl implements SpecializationType {

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
	 * The default value of the '{@link #getMatcher() <em>Matcher</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getMatcher()
	 * @generated
	 * @ordered
	 */
	protected static final String MATCHER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMatcher() <em>Matcher</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getMatcher()
	 * @generated
	 * @ordered
	 */
	protected String matcher = MATCHER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGenMatcher() <em>Gen Matcher</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getGenMatcher()
	 * @generated
	 * @ordered
	 */
	protected GenMatcher genMatcher;

	/**
	 * The cached value of the '{@link #getGenHelper() <em>Gen Helper</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getGenHelper()
	 * @generated
	 * @ordered
	 */
	protected GenHelper genHelper;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected SpecializationTypeImpl() {
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
		return DomaincontextcodegenPackage.Literals.SPECIALIZATION_TYPE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DomaincontextcodegenPackage.SPECIALIZATION_TYPE__REF, oldRef, ref));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.SPECIALIZATION_TYPE__REF, oldRef, ref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getMatcher() {
		return matcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setMatcher(String newMatcher) {
		String oldMatcher = matcher;
		matcher = newMatcher;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.SPECIALIZATION_TYPE__MATCHER, oldMatcher, matcher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GenMatcher getGenMatcher() {
		return genMatcher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetGenMatcher(GenMatcher newGenMatcher, NotificationChain msgs) {
		GenMatcher oldGenMatcher = genMatcher;
		genMatcher = newGenMatcher;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.SPECIALIZATION_TYPE__GEN_MATCHER, oldGenMatcher, newGenMatcher);
			if(msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setGenMatcher(GenMatcher newGenMatcher) {
		if(newGenMatcher != genMatcher) {
			NotificationChain msgs = null;
			if(genMatcher != null)
				msgs = ((InternalEObject)genMatcher).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DomaincontextcodegenPackage.SPECIALIZATION_TYPE__GEN_MATCHER, null, msgs);
			if(newGenMatcher != null)
				msgs = ((InternalEObject)newGenMatcher).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DomaincontextcodegenPackage.SPECIALIZATION_TYPE__GEN_MATCHER, null, msgs);
			msgs = basicSetGenMatcher(newGenMatcher, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.SPECIALIZATION_TYPE__GEN_MATCHER, newGenMatcher, newGenMatcher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GenHelper getGenHelper() {
		return genHelper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetGenHelper(GenHelper newGenHelper, NotificationChain msgs) {
		GenHelper oldGenHelper = genHelper;
		genHelper = newGenHelper;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.SPECIALIZATION_TYPE__GEN_HELPER, oldGenHelper, newGenHelper);
			if(msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setGenHelper(GenHelper newGenHelper) {
		if(newGenHelper != genHelper) {
			NotificationChain msgs = null;
			if(genHelper != null)
				msgs = ((InternalEObject)genHelper).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DomaincontextcodegenPackage.SPECIALIZATION_TYPE__GEN_HELPER, null, msgs);
			if(newGenHelper != null)
				msgs = ((InternalEObject)newGenHelper).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DomaincontextcodegenPackage.SPECIALIZATION_TYPE__GEN_HELPER, null, msgs);
			msgs = basicSetGenHelper(newGenHelper, msgs);
			if(msgs != null)
				msgs.dispatch();
		} else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.SPECIALIZATION_TYPE__GEN_HELPER, newGenHelper, newGenHelper));
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
		case DomaincontextcodegenPackage.SPECIALIZATION_TYPE__GEN_MATCHER:
			return basicSetGenMatcher(null, msgs);
		case DomaincontextcodegenPackage.SPECIALIZATION_TYPE__GEN_HELPER:
			return basicSetGenHelper(null, msgs);
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
		case DomaincontextcodegenPackage.SPECIALIZATION_TYPE__REF:
			if(resolve)
				return getRef();
			return basicGetRef();
		case DomaincontextcodegenPackage.SPECIALIZATION_TYPE__MATCHER:
			return getMatcher();
		case DomaincontextcodegenPackage.SPECIALIZATION_TYPE__GEN_MATCHER:
			return getGenMatcher();
		case DomaincontextcodegenPackage.SPECIALIZATION_TYPE__GEN_HELPER:
			return getGenHelper();
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
		case DomaincontextcodegenPackage.SPECIALIZATION_TYPE__REF:
			setRef((ElementType)newValue);
			return;
		case DomaincontextcodegenPackage.SPECIALIZATION_TYPE__MATCHER:
			setMatcher((String)newValue);
			return;
		case DomaincontextcodegenPackage.SPECIALIZATION_TYPE__GEN_MATCHER:
			setGenMatcher((GenMatcher)newValue);
			return;
		case DomaincontextcodegenPackage.SPECIALIZATION_TYPE__GEN_HELPER:
			setGenHelper((GenHelper)newValue);
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
		case DomaincontextcodegenPackage.SPECIALIZATION_TYPE__REF:
			setRef((ElementType)null);
			return;
		case DomaincontextcodegenPackage.SPECIALIZATION_TYPE__MATCHER:
			setMatcher(MATCHER_EDEFAULT);
			return;
		case DomaincontextcodegenPackage.SPECIALIZATION_TYPE__GEN_MATCHER:
			setGenMatcher((GenMatcher)null);
			return;
		case DomaincontextcodegenPackage.SPECIALIZATION_TYPE__GEN_HELPER:
			setGenHelper((GenHelper)null);
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
		case DomaincontextcodegenPackage.SPECIALIZATION_TYPE__REF:
			return ref != null;
		case DomaincontextcodegenPackage.SPECIALIZATION_TYPE__MATCHER:
			return MATCHER_EDEFAULT == null ? matcher != null : !MATCHER_EDEFAULT.equals(matcher);
		case DomaincontextcodegenPackage.SPECIALIZATION_TYPE__GEN_MATCHER:
			return genMatcher != null;
		case DomaincontextcodegenPackage.SPECIALIZATION_TYPE__GEN_HELPER:
			return genHelper != null;
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
		result.append(" (matcher: ");
		result.append(matcher);
		result.append(')');
		return result.toString();
	}

} //SpecializationTypeImpl
