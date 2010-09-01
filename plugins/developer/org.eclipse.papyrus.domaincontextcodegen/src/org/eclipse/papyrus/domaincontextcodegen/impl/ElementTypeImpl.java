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

import org.eclipse.papyrus.domaincontextcodegen.DomaincontextcodegenPackage;
import org.eclipse.papyrus.domaincontextcodegen.ElementType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.ElementTypeImpl#getMetaClass <em>Meta Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.ElementTypeImpl#getSpecificName <em>Specific Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.ElementTypeImpl#getEdithelper_EditHelperAdvicePath <em>Edithelper Edit Helper Advice Path</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.ElementTypeImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.ElementTypeImpl#getSpecializationof <em>Specializationof</em>}</li>
 *   <li>{@link org.eclipse.papyrus.domaincontextcodegen.impl.ElementTypeImpl#getSpecializationIDof <em>Specialization IDof</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ElementTypeImpl extends EObjectImpl implements ElementType {
	/**
	 * The cached value of the '{@link #getMetaClass() <em>Meta Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaClass()
	 * @generated
	 * @ordered
	 */
	protected EClass metaClass;

	/**
	 * The default value of the '{@link #getSpecificName() <em>Specific Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecificName()
	 * @generated
	 * @ordered
	 */
	protected static final String SPECIFIC_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSpecificName() <em>Specific Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecificName()
	 * @generated
	 * @ordered
	 */
	protected String specificName = SPECIFIC_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getEdithelper_EditHelperAdvicePath() <em>Edithelper Edit Helper Advice Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdithelper_EditHelperAdvicePath()
	 * @generated
	 * @ordered
	 */
	protected static final String EDITHELPER_EDIT_HELPER_ADVICE_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEdithelper_EditHelperAdvicePath() <em>Edithelper Edit Helper Advice Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdithelper_EditHelperAdvicePath()
	 * @generated
	 * @ordered
	 */
	protected String edithelper_EditHelperAdvicePath = EDITHELPER_EDIT_HELPER_ADVICE_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final String KIND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected String kind = KIND_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSpecializationof() <em>Specializationof</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecializationof()
	 * @generated
	 * @ordered
	 */
	protected ElementType specializationof;

	/**
	 * The default value of the '{@link #getSpecializationIDof() <em>Specialization IDof</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecializationIDof()
	 * @generated
	 * @ordered
	 */
	protected static final String SPECIALIZATION_IDOF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSpecializationIDof() <em>Specialization IDof</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecializationIDof()
	 * @generated
	 * @ordered
	 */
	protected String specializationIDof = SPECIALIZATION_IDOF_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DomaincontextcodegenPackage.Literals.ELEMENT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetaClass() {
		if (metaClass != null && metaClass.eIsProxy()) {
			InternalEObject oldMetaClass = (InternalEObject)metaClass;
			metaClass = (EClass)eResolveProxy(oldMetaClass);
			if (metaClass != oldMetaClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DomaincontextcodegenPackage.ELEMENT_TYPE__META_CLASS, oldMetaClass, metaClass));
			}
		}
		return metaClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetMetaClass() {
		return metaClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetaClass(EClass newMetaClass) {
		EClass oldMetaClass = metaClass;
		metaClass = newMetaClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.ELEMENT_TYPE__META_CLASS, oldMetaClass, metaClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSpecificName() {
		return specificName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecificName(String newSpecificName) {
		String oldSpecificName = specificName;
		specificName = newSpecificName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.ELEMENT_TYPE__SPECIFIC_NAME, oldSpecificName, specificName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEdithelper_EditHelperAdvicePath() {
		return edithelper_EditHelperAdvicePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEdithelper_EditHelperAdvicePath(String newEdithelper_EditHelperAdvicePath) {
		String oldEdithelper_EditHelperAdvicePath = edithelper_EditHelperAdvicePath;
		edithelper_EditHelperAdvicePath = newEdithelper_EditHelperAdvicePath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.ELEMENT_TYPE__EDITHELPER_EDIT_HELPER_ADVICE_PATH, oldEdithelper_EditHelperAdvicePath, edithelper_EditHelperAdvicePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(String newKind) {
		String oldKind = kind;
		kind = newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.ELEMENT_TYPE__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementType getSpecializationof() {
		if (specializationof != null && specializationof.eIsProxy()) {
			InternalEObject oldSpecializationof = (InternalEObject)specializationof;
			specializationof = (ElementType)eResolveProxy(oldSpecializationof);
			if (specializationof != oldSpecializationof) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DomaincontextcodegenPackage.ELEMENT_TYPE__SPECIALIZATIONOF, oldSpecializationof, specializationof));
			}
		}
		return specializationof;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementType basicGetSpecializationof() {
		return specializationof;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecializationof(ElementType newSpecializationof) {
		ElementType oldSpecializationof = specializationof;
		specializationof = newSpecializationof;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.ELEMENT_TYPE__SPECIALIZATIONOF, oldSpecializationof, specializationof));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSpecializationIDof() {
		return specializationIDof;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecializationIDof(String newSpecializationIDof) {
		String oldSpecializationIDof = specializationIDof;
		specializationIDof = newSpecializationIDof;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DomaincontextcodegenPackage.ELEMENT_TYPE__SPECIALIZATION_IDOF, oldSpecializationIDof, specializationIDof));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DomaincontextcodegenPackage.ELEMENT_TYPE__META_CLASS:
				if (resolve) return getMetaClass();
				return basicGetMetaClass();
			case DomaincontextcodegenPackage.ELEMENT_TYPE__SPECIFIC_NAME:
				return getSpecificName();
			case DomaincontextcodegenPackage.ELEMENT_TYPE__EDITHELPER_EDIT_HELPER_ADVICE_PATH:
				return getEdithelper_EditHelperAdvicePath();
			case DomaincontextcodegenPackage.ELEMENT_TYPE__KIND:
				return getKind();
			case DomaincontextcodegenPackage.ELEMENT_TYPE__SPECIALIZATIONOF:
				if (resolve) return getSpecializationof();
				return basicGetSpecializationof();
			case DomaincontextcodegenPackage.ELEMENT_TYPE__SPECIALIZATION_IDOF:
				return getSpecializationIDof();
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
			case DomaincontextcodegenPackage.ELEMENT_TYPE__META_CLASS:
				setMetaClass((EClass)newValue);
				return;
			case DomaincontextcodegenPackage.ELEMENT_TYPE__SPECIFIC_NAME:
				setSpecificName((String)newValue);
				return;
			case DomaincontextcodegenPackage.ELEMENT_TYPE__EDITHELPER_EDIT_HELPER_ADVICE_PATH:
				setEdithelper_EditHelperAdvicePath((String)newValue);
				return;
			case DomaincontextcodegenPackage.ELEMENT_TYPE__KIND:
				setKind((String)newValue);
				return;
			case DomaincontextcodegenPackage.ELEMENT_TYPE__SPECIALIZATIONOF:
				setSpecializationof((ElementType)newValue);
				return;
			case DomaincontextcodegenPackage.ELEMENT_TYPE__SPECIALIZATION_IDOF:
				setSpecializationIDof((String)newValue);
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
			case DomaincontextcodegenPackage.ELEMENT_TYPE__META_CLASS:
				setMetaClass((EClass)null);
				return;
			case DomaincontextcodegenPackage.ELEMENT_TYPE__SPECIFIC_NAME:
				setSpecificName(SPECIFIC_NAME_EDEFAULT);
				return;
			case DomaincontextcodegenPackage.ELEMENT_TYPE__EDITHELPER_EDIT_HELPER_ADVICE_PATH:
				setEdithelper_EditHelperAdvicePath(EDITHELPER_EDIT_HELPER_ADVICE_PATH_EDEFAULT);
				return;
			case DomaincontextcodegenPackage.ELEMENT_TYPE__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case DomaincontextcodegenPackage.ELEMENT_TYPE__SPECIALIZATIONOF:
				setSpecializationof((ElementType)null);
				return;
			case DomaincontextcodegenPackage.ELEMENT_TYPE__SPECIALIZATION_IDOF:
				setSpecializationIDof(SPECIALIZATION_IDOF_EDEFAULT);
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
			case DomaincontextcodegenPackage.ELEMENT_TYPE__META_CLASS:
				return metaClass != null;
			case DomaincontextcodegenPackage.ELEMENT_TYPE__SPECIFIC_NAME:
				return SPECIFIC_NAME_EDEFAULT == null ? specificName != null : !SPECIFIC_NAME_EDEFAULT.equals(specificName);
			case DomaincontextcodegenPackage.ELEMENT_TYPE__EDITHELPER_EDIT_HELPER_ADVICE_PATH:
				return EDITHELPER_EDIT_HELPER_ADVICE_PATH_EDEFAULT == null ? edithelper_EditHelperAdvicePath != null : !EDITHELPER_EDIT_HELPER_ADVICE_PATH_EDEFAULT.equals(edithelper_EditHelperAdvicePath);
			case DomaincontextcodegenPackage.ELEMENT_TYPE__KIND:
				return KIND_EDEFAULT == null ? kind != null : !KIND_EDEFAULT.equals(kind);
			case DomaincontextcodegenPackage.ELEMENT_TYPE__SPECIALIZATIONOF:
				return specializationof != null;
			case DomaincontextcodegenPackage.ELEMENT_TYPE__SPECIALIZATION_IDOF:
				return SPECIALIZATION_IDOF_EDEFAULT == null ? specializationIDof != null : !SPECIALIZATION_IDOF_EDEFAULT.equals(specializationIDof);
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
		result.append(" (specificName: ");
		result.append(specificName);
		result.append(", edithelper_EditHelperAdvicePath: ");
		result.append(edithelper_EditHelperAdvicePath);
		result.append(", kind: ");
		result.append(kind);
		result.append(", specializationIDof: ");
		result.append(specializationIDof);
		result.append(')');
		return result.toString();
	}

} //ElementTypeImpl
