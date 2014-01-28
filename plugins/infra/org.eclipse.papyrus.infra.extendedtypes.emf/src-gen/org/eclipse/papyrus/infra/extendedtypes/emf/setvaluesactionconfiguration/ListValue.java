/**
 */
package org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.ListValue#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.SetValuesActionConfigurationPackage#getListValue()
 * @model
 * @generated
 */
public interface ListValue extends FeatureValue {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.FeatureValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' reference list.
	 * @see org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration.SetValuesActionConfigurationPackage#getListValue_Values()
	 * @model
	 * @generated
	 */
	EList<FeatureValue> getValues();

} // ListValue
