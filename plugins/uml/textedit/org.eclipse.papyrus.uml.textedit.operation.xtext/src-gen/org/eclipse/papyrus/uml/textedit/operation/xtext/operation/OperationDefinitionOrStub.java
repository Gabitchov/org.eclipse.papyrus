/**
 */
package org.eclipse.papyrus.uml.textedit.operation.xtext.operation;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.uml.alf.alf.Block;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Definition Or Stub</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDefinitionOrStub#getDeclaration <em>Declaration</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDefinitionOrStub#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage#getOperationDefinitionOrStub()
 * @model
 * @generated
 */
public interface OperationDefinitionOrStub extends EObject
{
  /**
   * Returns the value of the '<em><b>Declaration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Declaration</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Declaration</em>' containment reference.
   * @see #setDeclaration(OperationDeclaration)
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage#getOperationDefinitionOrStub_Declaration()
   * @model containment="true"
   * @generated
   */
  OperationDeclaration getDeclaration();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDefinitionOrStub#getDeclaration <em>Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Declaration</em>' containment reference.
   * @see #getDeclaration()
   * @generated
   */
  void setDeclaration(OperationDeclaration value);

  /**
   * Returns the value of the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Body</em>' containment reference.
   * @see #setBody(Block)
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage#getOperationDefinitionOrStub_Body()
   * @model containment="true"
   * @generated
   */
  Block getBody();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDefinitionOrStub#getBody <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' containment reference.
   * @see #getBody()
   * @generated
   */
  void setBody(Block value);

} // OperationDefinitionOrStub
