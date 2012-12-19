/**
 */
package org.eclipse.papyrus.uml.textedit.operation.xtext.operation;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.uml.alf.alf.QualifiedNameList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Redefinition Clause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.RedefinitionClause#getRedefinedOperations <em>Redefined Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage#getRedefinitionClause()
 * @model
 * @generated
 */
public interface RedefinitionClause extends EObject
{
  /**
   * Returns the value of the '<em><b>Redefined Operations</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Redefined Operations</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Redefined Operations</em>' containment reference.
   * @see #setRedefinedOperations(QualifiedNameList)
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage#getRedefinitionClause_RedefinedOperations()
   * @model containment="true"
   * @generated
   */
  QualifiedNameList getRedefinedOperations();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.RedefinitionClause#getRedefinedOperations <em>Redefined Operations</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Redefined Operations</em>' containment reference.
   * @see #getRedefinedOperations()
   * @generated
   */
  void setRedefinedOperations(QualifiedNameList value);

} // RedefinitionClause
