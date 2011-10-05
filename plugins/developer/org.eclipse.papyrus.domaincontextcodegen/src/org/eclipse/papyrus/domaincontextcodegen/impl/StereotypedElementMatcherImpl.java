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
import org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage;
import org.eclipse.papyrus.domaincontextcodegen.StereotypedElementMatcher;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stereotyped Element Matcher</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.StereotypedElementMatcherImpl#getStereotypeName <em>Stereotype Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.StereotypedElementMatcherImpl#getStereotypePackage <em>Stereotype Package</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.StereotypedElementMatcherImpl#getBaseElementName <em>Base Element Name</em>}</li>
 * <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.StereotypedElementMatcherImpl#getBaseElementPackage <em>Base Element Package</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class StereotypedElementMatcherImpl extends GenMatcherImpl implements StereotypedElementMatcher {

	/**
	 * The default value of the '{@link #getStereotypeName() <em>Stereotype Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getStereotypeName()
	 * @generated
	 * @ordered
	 */
	protected static final String STEREOTYPE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStereotypeName() <em>Stereotype Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getStereotypeName()
	 * @generated
	 * @ordered
	 */
	protected String stereotypeName = STEREOTYPE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getStereotypePackage() <em>Stereotype Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getStereotypePackage()
	 * @generated
	 * @ordered
	 */
	protected static final String STEREOTYPE_PACKAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStereotypePackage() <em>Stereotype Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getStereotypePackage()
	 * @generated
	 * @ordered
	 */
	protected String stereotypePackage = STEREOTYPE_PACKAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getBaseElementName() <em>Base Element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBaseElementName()
	 * @generated
	 * @ordered
	 */
	protected static final String BASE_ELEMENT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBaseElementName() <em>Base Element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBaseElementName()
	 * @generated
	 * @ordered
	 */
	protected String baseElementName = BASE_ELEMENT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getBaseElementPackage() <em>Base Element Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBaseElementPackage()
	 * @generated
	 * @ordered
	 */
	protected static final String BASE_ELEMENT_PACKAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBaseElementPackage() <em>Base Element Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBaseElementPackage()
	 * @generated
	 * @ordered
	 */
	protected String baseElementPackage = BASE_ELEMENT_PACKAGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected StereotypedElementMatcherImpl() {
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
		return DomaincontextcodegenPackage.Literals.STEREOTYPED_ELEMENT_MATCHER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getStereotypeName() {
		return stereotypeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setStereotypeName(String newStereotypeName) {
		String oldStereotypeName = stereotypeName;
		stereotypeName = newStereotypeName;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.STEREOTYPED_ELEMENT_MATCHER__STEREOTYPE_NAME, oldStereotypeName, stereotypeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getStereotypePackage() {
		return stereotypePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setStereotypePackage(String newStereotypePackage) {
		String oldStereotypePackage = stereotypePackage;
		stereotypePackage = newStereotypePackage;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.STEREOTYPED_ELEMENT_MATCHER__STEREOTYPE_PACKAGE, oldStereotypePackage, stereotypePackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getBaseElementName() {
		return baseElementName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBaseElementName(String newBaseElementName) {
		String oldBaseElementName = baseElementName;
		baseElementName = newBaseElementName;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.STEREOTYPED_ELEMENT_MATCHER__BASE_ELEMENT_NAME, oldBaseElementName, baseElementName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getBaseElementPackage() {
		return baseElementPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBaseElementPackage(String newBaseElementPackage) {
		String oldBaseElementPackage = baseElementPackage;
		baseElementPackage = newBaseElementPackage;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.STEREOTYPED_ELEMENT_MATCHER__BASE_ELEMENT_PACKAGE, oldBaseElementPackage, baseElementPackage));
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
		case DomaincontextcodegenPackage.STEREOTYPED_ELEMENT_MATCHER__STEREOTYPE_NAME:
			return getStereotypeName();
		case DomaincontextcodegenPackage.STEREOTYPED_ELEMENT_MATCHER__STEREOTYPE_PACKAGE:
			return getStereotypePackage();
		case DomaincontextcodegenPackage.STEREOTYPED_ELEMENT_MATCHER__BASE_ELEMENT_NAME:
			return getBaseElementName();
		case DomaincontextcodegenPackage.STEREOTYPED_ELEMENT_MATCHER__BASE_ELEMENT_PACKAGE:
			return getBaseElementPackage();
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
		case DomaincontextcodegenPackage.STEREOTYPED_ELEMENT_MATCHER__STEREOTYPE_NAME:
			setStereotypeName((String)newValue);
			return;
		case DomaincontextcodegenPackage.STEREOTYPED_ELEMENT_MATCHER__STEREOTYPE_PACKAGE:
			setStereotypePackage((String)newValue);
			return;
		case DomaincontextcodegenPackage.STEREOTYPED_ELEMENT_MATCHER__BASE_ELEMENT_NAME:
			setBaseElementName((String)newValue);
			return;
		case DomaincontextcodegenPackage.STEREOTYPED_ELEMENT_MATCHER__BASE_ELEMENT_PACKAGE:
			setBaseElementPackage((String)newValue);
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
		case DomaincontextcodegenPackage.STEREOTYPED_ELEMENT_MATCHER__STEREOTYPE_NAME:
			setStereotypeName(STEREOTYPE_NAME_EDEFAULT);
			return;
		case DomaincontextcodegenPackage.STEREOTYPED_ELEMENT_MATCHER__STEREOTYPE_PACKAGE:
			setStereotypePackage(STEREOTYPE_PACKAGE_EDEFAULT);
			return;
		case DomaincontextcodegenPackage.STEREOTYPED_ELEMENT_MATCHER__BASE_ELEMENT_NAME:
			setBaseElementName(BASE_ELEMENT_NAME_EDEFAULT);
			return;
		case DomaincontextcodegenPackage.STEREOTYPED_ELEMENT_MATCHER__BASE_ELEMENT_PACKAGE:
			setBaseElementPackage(BASE_ELEMENT_PACKAGE_EDEFAULT);
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
		case DomaincontextcodegenPackage.STEREOTYPED_ELEMENT_MATCHER__STEREOTYPE_NAME:
			return STEREOTYPE_NAME_EDEFAULT == null ? stereotypeName != null : !STEREOTYPE_NAME_EDEFAULT.equals(stereotypeName);
		case DomaincontextcodegenPackage.STEREOTYPED_ELEMENT_MATCHER__STEREOTYPE_PACKAGE:
			return STEREOTYPE_PACKAGE_EDEFAULT == null ? stereotypePackage != null : !STEREOTYPE_PACKAGE_EDEFAULT.equals(stereotypePackage);
		case DomaincontextcodegenPackage.STEREOTYPED_ELEMENT_MATCHER__BASE_ELEMENT_NAME:
			return BASE_ELEMENT_NAME_EDEFAULT == null ? baseElementName != null : !BASE_ELEMENT_NAME_EDEFAULT.equals(baseElementName);
		case DomaincontextcodegenPackage.STEREOTYPED_ELEMENT_MATCHER__BASE_ELEMENT_PACKAGE:
			return BASE_ELEMENT_PACKAGE_EDEFAULT == null ? baseElementPackage != null : !BASE_ELEMENT_PACKAGE_EDEFAULT.equals(baseElementPackage);
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
		result.append(" (stereotypeName: ");
		result.append(stereotypeName);
		result.append(", stereotypePackage: ");
		result.append(stereotypePackage);
		result.append(", baseElementName: ");
		result.append(baseElementName);
		result.append(", baseElementPackage: ");
		result.append(baseElementPackage);
		result.append(')');
		return result.toString();
	}

} //StereotypedElementMatcherImpl
