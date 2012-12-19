/**
 */
package org.eclipse.papyrus.uml.textedit.operation.xtext.operation;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Formal Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameter#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameter#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameter#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage#getFormalParameter()
 * @model
 * @generated
 */
public interface FormalParameter extends EObject
{
  /**
   * Returns the value of the '<em><b>Direction</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.ParameterDirection}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Direction</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Direction</em>' attribute.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.ParameterDirection
   * @see #setDirection(ParameterDirection)
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage#getFormalParameter_Direction()
   * @model
   * @generated
   */
  ParameterDirection getDirection();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameter#getDirection <em>Direction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Direction</em>' attribute.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.ParameterDirection
   * @see #getDirection()
   * @generated
   */
  void setDirection(ParameterDirection value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage#getFormalParameter_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameter#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(TypePart)
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage#getFormalParameter_Type()
   * @model containment="true"
   * @generated
   */
  TypePart getType();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameter#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(TypePart value);

} // FormalParameter
