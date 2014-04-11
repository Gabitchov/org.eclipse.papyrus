/**
 */
package org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Constraint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Validation Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getSeverity <em>Severity</em>}</li>
 *   <li>{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getMode <em>Mode</em>}</li>
 *   <li>{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#isEnabledByDefault <em>Is Enabled By Default</em>}</li>
 *   <li>{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getBase_Constraint <em>Base Constraint</em>}</li>
 *   <li>{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getStatusCode <em>Status Code</em>}</li>
 *   <li>{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getMessage <em>Message</em>}</li>
 *   <li>{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getClass_ <em>Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.PapyrusDSMLValidationRulePackage#getValidationRule()
 * @model
 * @generated
 */
public interface ValidationRule extends EObject {
	/**
	 * Returns the value of the '<em><b>Severity</b></em>' attribute.
	 * The default value is <code>"ERROR"</code>.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.Severity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Severity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Severity</em>' attribute.
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.Severity
	 * @see #setSeverity(Severity)
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.PapyrusDSMLValidationRulePackage#getValidationRule_Severity()
	 * @model default="ERROR" required="true" ordered="false"
	 * @generated
	 */
	Severity getSeverity();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getSeverity <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Severity</em>' attribute.
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.Severity
	 * @see #getSeverity()
	 * @generated
	 */
	void setSeverity(Severity value);

	/**
	 * Returns the value of the '<em><b>Mode</b></em>' attribute.
	 * The default value is <code>"Batch"</code>.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.Mode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' attribute.
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.Mode
	 * @see #setMode(Mode)
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.PapyrusDSMLValidationRulePackage#getValidationRule_Mode()
	 * @model default="Batch" required="true" ordered="false"
	 * @generated
	 */
	Mode getMode();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.Mode
	 * @see #getMode()
	 * @generated
	 */
	void setMode(Mode value);

	/**
	 * Returns the value of the '<em><b>Is Enabled By Default</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Enabled By Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Enabled By Default</em>' attribute.
	 * @see #setIsEnabledByDefault(boolean)
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.PapyrusDSMLValidationRulePackage#getValidationRule_IsEnabledByDefault()
	 * @model default="true" dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isEnabledByDefault();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#isEnabledByDefault <em>Is Enabled By Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Enabled By Default</em>' attribute.
	 * @see #isEnabledByDefault()
	 * @generated
	 */
	void setIsEnabledByDefault(boolean value);

	/**
	 * Returns the value of the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Constraint</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Constraint</em>' reference.
	 * @see #setBase_Constraint(Constraint)
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.PapyrusDSMLValidationRulePackage#getValidationRule_Base_Constraint()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Constraint getBase_Constraint();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getBase_Constraint <em>Base Constraint</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Constraint</em>' reference.
	 * @see #getBase_Constraint()
	 * @generated
	 */
	void setBase_Constraint(Constraint value);

	/**
	 * Returns the value of the '<em><b>Status Code</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status Code</em>' attribute.
	 * @see #setStatusCode(int)
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.PapyrusDSMLValidationRulePackage#getValidationRule_StatusCode()
	 * @model default="1" dataType="org.eclipse.uml2.types.Integer" required="true" ordered="false"
	 * @generated
	 */
	int getStatusCode();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getStatusCode <em>Status Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status Code</em>' attribute.
	 * @see #getStatusCode()
	 * @generated
	 */
	void setStatusCode(int value);

	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.PapyrusDSMLValidationRulePackage#getValidationRule_Message()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.PapyrusDSMLValidationRulePackage#getValidationRule_Description()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' attribute list.
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.PapyrusDSMLValidationRulePackage#getValidationRule_Target()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	EList<String> getTarget();

	/**
	 * Returns the value of the '<em><b>Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' attribute.
	 * @see #setClass_(String)
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.PapyrusDSMLValidationRulePackage#getValidationRule_Class()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getClass_();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getClass_ <em>Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' attribute.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass_(String value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.PapyrusDSMLValidationRulePackage#getValidationRule_Id()
	 * @model dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.dsml.validation.PapyrusDSMLValidationRule.ValidationRule#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

} // ValidationRule
