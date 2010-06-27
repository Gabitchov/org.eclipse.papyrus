/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.papyrusgmfgenextension.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.papyrus.papyrusgmfgenextension.AdditionalEditPartCandies;
import org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Additional Edit Part Candies</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.impl.AdditionalEditPartCandiesImpl#getBaseEditHelperPackage <em>Base Edit Helper Package
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class AdditionalEditPartCandiesImpl extends CommentedElementImpl implements AdditionalEditPartCandies {

	/**
	 * The default value of the '{@link #getBaseEditHelperPackage() <em>Base Edit Helper Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBaseEditHelperPackage()
	 * @generated
	 * @ordered
	 */
	protected static final String BASE_EDIT_HELPER_PACKAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBaseEditHelperPackage() <em>Base Edit Helper Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBaseEditHelperPackage()
	 * @generated
	 * @ordered
	 */
	protected String baseEditHelperPackage = BASE_EDIT_HELPER_PACKAGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AdditionalEditPartCandiesImpl() {
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
		return PapyrusgmfgenextensionPackage.Literals.ADDITIONAL_EDIT_PART_CANDIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getBaseEditHelperPackage() {
		return baseEditHelperPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBaseEditHelperPackage(String newBaseEditHelperPackage) {
		String oldBaseEditHelperPackage = baseEditHelperPackage;
		baseEditHelperPackage = newBaseEditHelperPackage;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusgmfgenextensionPackage.ADDITIONAL_EDIT_PART_CANDIES__BASE_EDIT_HELPER_PACKAGE, oldBaseEditHelperPackage, baseEditHelperPackage));
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
		case PapyrusgmfgenextensionPackage.ADDITIONAL_EDIT_PART_CANDIES__BASE_EDIT_HELPER_PACKAGE:
			return getBaseEditHelperPackage();
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
		case PapyrusgmfgenextensionPackage.ADDITIONAL_EDIT_PART_CANDIES__BASE_EDIT_HELPER_PACKAGE:
			setBaseEditHelperPackage((String)newValue);
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
		case PapyrusgmfgenextensionPackage.ADDITIONAL_EDIT_PART_CANDIES__BASE_EDIT_HELPER_PACKAGE:
			setBaseEditHelperPackage(BASE_EDIT_HELPER_PACKAGE_EDEFAULT);
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
		case PapyrusgmfgenextensionPackage.ADDITIONAL_EDIT_PART_CANDIES__BASE_EDIT_HELPER_PACKAGE:
			return BASE_EDIT_HELPER_PACKAGE_EDEFAULT == null ? baseEditHelperPackage != null : !BASE_EDIT_HELPER_PACKAGE_EDEFAULT.equals(baseEditHelperPackage);
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
		result.append(" (baseEditHelperPackage: ");
		result.append(baseEditHelperPackage);
		result.append(')');
		return result.toString();
	}

} //AdditionalEditPartCandiesImpl
