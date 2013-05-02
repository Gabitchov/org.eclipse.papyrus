/**
 */
package org.eclipse.papyrus.C_Cpp;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Generalization;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visibility</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.Visibility#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.Visibility#getBase_generalization <em>Base generalization</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getVisibility()
 * @model
 * @generated
 */
public interface Visibility extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getVisibility_Value()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.C_Cpp.Visibility#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Base generalization</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base generalization</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base generalization</em>' reference.
	 * @see #setBase_generalization(Generalization)
	 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getVisibility_Base_generalization()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Generalization getBase_generalization();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.C_Cpp.Visibility#getBase_generalization <em>Base generalization</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base generalization</em>' reference.
	 * @see #getBase_generalization()
	 * @generated
	 */
	void setBase_generalization(Generalization value);

} // Visibility
