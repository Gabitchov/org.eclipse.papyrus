/**
 */
package org.eclipse.papyrus.uml.textedit.operation.xtext.operation;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Formal Parameters</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameters#getFormalParameterList <em>Formal Parameter List</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage#getFormalParameters()
 * @model
 * @generated
 */
public interface FormalParameters extends EObject
{
  /**
   * Returns the value of the '<em><b>Formal Parameter List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Formal Parameter List</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Formal Parameter List</em>' containment reference.
   * @see #setFormalParameterList(FormalParameterList)
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage#getFormalParameters_FormalParameterList()
   * @model containment="true"
   * @generated
   */
  FormalParameterList getFormalParameterList();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.FormalParameters#getFormalParameterList <em>Formal Parameter List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Formal Parameter List</em>' containment reference.
   * @see #getFormalParameterList()
   * @generated
   */
  void setFormalParameterList(FormalParameterList value);

} // FormalParameters
