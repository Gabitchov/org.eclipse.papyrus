/**
 */
package org.eclipse.papyrus.uml.textedit.operation.xtext.operation;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.uml.alf.alf.QualifiedNameWithBinding;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Name</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.TypeName#getQualifiedName <em>Qualified Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage#getTypeName()
 * @model
 * @generated
 */
public interface TypeName extends EObject
{
  /**
   * Returns the value of the '<em><b>Qualified Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Qualified Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Qualified Name</em>' containment reference.
   * @see #setQualifiedName(QualifiedNameWithBinding)
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage#getTypeName_QualifiedName()
   * @model containment="true"
   * @generated
   */
  QualifiedNameWithBinding getQualifiedName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.TypeName#getQualifiedName <em>Qualified Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Qualified Name</em>' containment reference.
   * @see #getQualifiedName()
   * @generated
   */
  void setQualifiedName(QualifiedNameWithBinding value);

} // TypeName
