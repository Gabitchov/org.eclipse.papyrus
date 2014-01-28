/**
 */
package org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfigurationPackage;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.FeatureToSet;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.StereotypeToApply;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stereotype To Apply</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.StereotypeToApplyImpl#getStereotypeQualifiedName <em>Stereotype Qualified Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.StereotypeToApplyImpl#isUpdateName <em>Update Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.StereotypeToApplyImpl#getRequiredProfiles <em>Required Profiles</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl.StereotypeToApplyImpl#getFeaturesToSet <em>Features To Set</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StereotypeToApplyImpl extends EObjectImpl implements StereotypeToApply {
	/**
	 * The default value of the '{@link #getStereotypeQualifiedName() <em>Stereotype Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotypeQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected static final String STEREOTYPE_QUALIFIED_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStereotypeQualifiedName() <em>Stereotype Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotypeQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected String stereotypeQualifiedName = STEREOTYPE_QUALIFIED_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isUpdateName() <em>Update Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUpdateName()
	 * @generated
	 * @ordered
	 */
	protected static final boolean UPDATE_NAME_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUpdateName() <em>Update Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUpdateName()
	 * @generated
	 * @ordered
	 */
	protected boolean updateName = UPDATE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRequiredProfiles() <em>Required Profiles</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredProfiles()
	 * @generated
	 * @ordered
	 */
	protected EList<String> requiredProfiles;

	/**
	 * The cached value of the '{@link #getFeaturesToSet() <em>Features To Set</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeaturesToSet()
	 * @generated
	 * @ordered
	 */
	protected EList<FeatureToSet> featuresToSet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StereotypeToApplyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ApplyStereotypeActionConfigurationPackage.Literals.STEREOTYPE_TO_APPLY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStereotypeQualifiedName() {
		return stereotypeQualifiedName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStereotypeQualifiedName(String newStereotypeQualifiedName) {
		String oldStereotypeQualifiedName = stereotypeQualifiedName;
		stereotypeQualifiedName = newStereotypeQualifiedName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplyStereotypeActionConfigurationPackage.STEREOTYPE_TO_APPLY__STEREOTYPE_QUALIFIED_NAME, oldStereotypeQualifiedName, stereotypeQualifiedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUpdateName() {
		return updateName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpdateName(boolean newUpdateName) {
		boolean oldUpdateName = updateName;
		updateName = newUpdateName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ApplyStereotypeActionConfigurationPackage.STEREOTYPE_TO_APPLY__UPDATE_NAME, oldUpdateName, updateName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getRequiredProfiles() {
		if (requiredProfiles == null) {
			requiredProfiles = new EDataTypeUniqueEList<String>(String.class, this, ApplyStereotypeActionConfigurationPackage.STEREOTYPE_TO_APPLY__REQUIRED_PROFILES);
		}
		return requiredProfiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FeatureToSet> getFeaturesToSet() {
		if (featuresToSet == null) {
			featuresToSet = new EObjectContainmentEList<FeatureToSet>(FeatureToSet.class, this, ApplyStereotypeActionConfigurationPackage.STEREOTYPE_TO_APPLY__FEATURES_TO_SET);
		}
		return featuresToSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ApplyStereotypeActionConfigurationPackage.STEREOTYPE_TO_APPLY__FEATURES_TO_SET:
				return ((InternalEList<?>)getFeaturesToSet()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ApplyStereotypeActionConfigurationPackage.STEREOTYPE_TO_APPLY__STEREOTYPE_QUALIFIED_NAME:
				return getStereotypeQualifiedName();
			case ApplyStereotypeActionConfigurationPackage.STEREOTYPE_TO_APPLY__UPDATE_NAME:
				return isUpdateName();
			case ApplyStereotypeActionConfigurationPackage.STEREOTYPE_TO_APPLY__REQUIRED_PROFILES:
				return getRequiredProfiles();
			case ApplyStereotypeActionConfigurationPackage.STEREOTYPE_TO_APPLY__FEATURES_TO_SET:
				return getFeaturesToSet();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ApplyStereotypeActionConfigurationPackage.STEREOTYPE_TO_APPLY__STEREOTYPE_QUALIFIED_NAME:
				setStereotypeQualifiedName((String)newValue);
				return;
			case ApplyStereotypeActionConfigurationPackage.STEREOTYPE_TO_APPLY__UPDATE_NAME:
				setUpdateName((Boolean)newValue);
				return;
			case ApplyStereotypeActionConfigurationPackage.STEREOTYPE_TO_APPLY__REQUIRED_PROFILES:
				getRequiredProfiles().clear();
				getRequiredProfiles().addAll((Collection<? extends String>)newValue);
				return;
			case ApplyStereotypeActionConfigurationPackage.STEREOTYPE_TO_APPLY__FEATURES_TO_SET:
				getFeaturesToSet().clear();
				getFeaturesToSet().addAll((Collection<? extends FeatureToSet>)newValue);
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
			case ApplyStereotypeActionConfigurationPackage.STEREOTYPE_TO_APPLY__STEREOTYPE_QUALIFIED_NAME:
				setStereotypeQualifiedName(STEREOTYPE_QUALIFIED_NAME_EDEFAULT);
				return;
			case ApplyStereotypeActionConfigurationPackage.STEREOTYPE_TO_APPLY__UPDATE_NAME:
				setUpdateName(UPDATE_NAME_EDEFAULT);
				return;
			case ApplyStereotypeActionConfigurationPackage.STEREOTYPE_TO_APPLY__REQUIRED_PROFILES:
				getRequiredProfiles().clear();
				return;
			case ApplyStereotypeActionConfigurationPackage.STEREOTYPE_TO_APPLY__FEATURES_TO_SET:
				getFeaturesToSet().clear();
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
			case ApplyStereotypeActionConfigurationPackage.STEREOTYPE_TO_APPLY__STEREOTYPE_QUALIFIED_NAME:
				return STEREOTYPE_QUALIFIED_NAME_EDEFAULT == null ? stereotypeQualifiedName != null : !STEREOTYPE_QUALIFIED_NAME_EDEFAULT.equals(stereotypeQualifiedName);
			case ApplyStereotypeActionConfigurationPackage.STEREOTYPE_TO_APPLY__UPDATE_NAME:
				return updateName != UPDATE_NAME_EDEFAULT;
			case ApplyStereotypeActionConfigurationPackage.STEREOTYPE_TO_APPLY__REQUIRED_PROFILES:
				return requiredProfiles != null && !requiredProfiles.isEmpty();
			case ApplyStereotypeActionConfigurationPackage.STEREOTYPE_TO_APPLY__FEATURES_TO_SET:
				return featuresToSet != null && !featuresToSet.isEmpty();
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
		result.append(" (stereotypeQualifiedName: ");
		result.append(stereotypeQualifiedName);
		result.append(", updateName: ");
		result.append(updateName);
		result.append(", requiredProfiles: ");
		result.append(requiredProfiles);
		result.append(')');
		return result.toString();
	}

} //StereotypeToApplyImpl
