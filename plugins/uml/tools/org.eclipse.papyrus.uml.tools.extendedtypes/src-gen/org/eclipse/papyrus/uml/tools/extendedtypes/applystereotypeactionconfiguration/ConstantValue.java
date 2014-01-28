/**
 */
package org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration;

import org.eclipse.uml2.uml.ValueSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constant Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ConstantValue#getValueInstance <em>Value Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfigurationPackage#getConstantValue()
 * @model
 * @generated
 */
public interface ConstantValue extends FeatureValue {
	/**
	 * Returns the value of the '<em><b>Value Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Instance</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Instance</em>' containment reference.
	 * @see #setValueInstance(ValueSpecification)
	 * @see org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfigurationPackage#getConstantValue_ValueInstance()
	 * @model containment="true"
	 * @generated
	 */
	ValueSpecification getValueInstance();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ConstantValue#getValueInstance <em>Value Instance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Instance</em>' containment reference.
	 * @see #getValueInstance()
	 * @generated
	 */
	void setValueInstance(ValueSpecification value);

} // ConstantValue
