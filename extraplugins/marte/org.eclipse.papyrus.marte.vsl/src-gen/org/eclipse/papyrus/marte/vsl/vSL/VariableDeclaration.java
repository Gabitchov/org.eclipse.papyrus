/**
 */
package org.eclipse.papyrus.marte.vsl.vSL;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.VariableDeclaration#getVariableDeclaration <em>Variable Declaration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.VariableDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.VariableDeclaration#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.marte.vsl.vSL.VariableDeclaration#getInitValue <em>Init Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.marte.vsl.vSL.VSLPackage#getVariableDeclaration()
 * @model
 * @generated
 */
public interface VariableDeclaration extends ValueSpecification
{
  /**
   * Returns the value of the '<em><b>Variable Declaration</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable Declaration</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variable Declaration</em>' attribute.
   * @see #setVariableDeclaration(String)
   * @see org.eclipse.papyrus.marte.vsl.vSL.VSLPackage#getVariableDeclaration_VariableDeclaration()
   * @model
   * @generated
   */
  String getVariableDeclaration();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.marte.vsl.vSL.VariableDeclaration#getVariableDeclaration <em>Variable Declaration</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable Declaration</em>' attribute.
   * @see #getVariableDeclaration()
   * @generated
   */
  void setVariableDeclaration(String value);

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
   * @see org.eclipse.papyrus.marte.vsl.vSL.VSLPackage#getVariableDeclaration_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.marte.vsl.vSL.VariableDeclaration#getName <em>Name</em>}' attribute.
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
   * @see #setType(DataTypeName)
   * @see org.eclipse.papyrus.marte.vsl.vSL.VSLPackage#getVariableDeclaration_Type()
   * @model containment="true"
   * @generated
   */
  DataTypeName getType();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.marte.vsl.vSL.VariableDeclaration#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(DataTypeName value);

  /**
   * Returns the value of the '<em><b>Init Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Init Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Init Value</em>' containment reference.
   * @see #setInitValue(Expression)
   * @see org.eclipse.papyrus.marte.vsl.vSL.VSLPackage#getVariableDeclaration_InitValue()
   * @model containment="true"
   * @generated
   */
  Expression getInitValue();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.marte.vsl.vSL.VariableDeclaration#getInitValue <em>Init Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Init Value</em>' containment reference.
   * @see #getInitValue()
   * @generated
   */
  void setInitValue(Expression value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil.getFilteredParentRule(this, filter) ;'"
   * @generated
   */
  EObject getFilteredParentRule(EClass filter);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil.getExpectedType(this) ;'"
   * @generated
   */
  Type getExpectedType();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return org.eclipse.papyrus.marte.vsl.extensions.VSLContextUtil.getContextElement(this) ;'"
   * @generated
   */
  Element getContextElement();

} // VariableDeclaration
