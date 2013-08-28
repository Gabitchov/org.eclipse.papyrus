/**
 */
package org.eclipse.papyrus.uml.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Declaration Completion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.VariableDeclarationCompletion#isMultiplicityIndicator <em>Multiplicity Indicator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.VariableDeclarationCompletion#getVariableName <em>Variable Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.VariableDeclarationCompletion#getInitValue <em>Init Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getVariableDeclarationCompletion()
 * @model
 * @generated
 */
public interface VariableDeclarationCompletion extends EObject
{
  /**
   * Returns the value of the '<em><b>Multiplicity Indicator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Multiplicity Indicator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Multiplicity Indicator</em>' attribute.
   * @see #setMultiplicityIndicator(boolean)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getVariableDeclarationCompletion_MultiplicityIndicator()
   * @model
   * @generated
   */
  boolean isMultiplicityIndicator();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.VariableDeclarationCompletion#isMultiplicityIndicator <em>Multiplicity Indicator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Multiplicity Indicator</em>' attribute.
   * @see #isMultiplicityIndicator()
   * @generated
   */
  void setMultiplicityIndicator(boolean value);

  /**
   * Returns the value of the '<em><b>Variable Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variable Name</em>' attribute.
   * @see #setVariableName(String)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getVariableDeclarationCompletion_VariableName()
   * @model
   * @generated
   */
  String getVariableName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.VariableDeclarationCompletion#getVariableName <em>Variable Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable Name</em>' attribute.
   * @see #getVariableName()
   * @generated
   */
  void setVariableName(String value);

  /**
   * Returns the value of the '<em><b>Init Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Init Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Init Value</em>' containment reference.
   * @see #setInitValue(AssignmentCompletion)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getVariableDeclarationCompletion_InitValue()
   * @model containment="true"
   * @generated
   */
  AssignmentCompletion getInitValue();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.VariableDeclarationCompletion#getInitValue <em>Init Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Init Value</em>' containment reference.
   * @see #getInitValue()
   * @generated
   */
  void setInitValue(AssignmentCompletion value);

} // VariableDeclarationCompletion
