/**
 */
package org.eclipse.papyrus.uml.textedit.operation.xtext.operation;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration#isIsConstructor <em>Is Constructor</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration#isIsDestructor <em>Is Destructor</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration#getVisibilityIndicator <em>Visibility Indicator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration#getFormalParameters <em>Formal Parameters</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration#getRedefinition <em>Redefinition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage#getOperationDeclaration()
 * @model
 * @generated
 */
public interface OperationDeclaration extends EObject
{
  /**
   * Returns the value of the '<em><b>Is Constructor</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Constructor</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Constructor</em>' attribute.
   * @see #setIsConstructor(boolean)
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage#getOperationDeclaration_IsConstructor()
   * @model
   * @generated
   */
  boolean isIsConstructor();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration#isIsConstructor <em>Is Constructor</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Constructor</em>' attribute.
   * @see #isIsConstructor()
   * @generated
   */
  void setIsConstructor(boolean value);

  /**
   * Returns the value of the '<em><b>Is Destructor</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Destructor</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Is Destructor</em>' attribute.
   * @see #setIsDestructor(boolean)
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage#getOperationDeclaration_IsDestructor()
   * @model
   * @generated
   */
  boolean isIsDestructor();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration#isIsDestructor <em>Is Destructor</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Destructor</em>' attribute.
   * @see #isIsDestructor()
   * @generated
   */
  void setIsDestructor(boolean value);

  /**
   * Returns the value of the '<em><b>Visibility Indicator</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.VisibilityIndicator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Visibility Indicator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Visibility Indicator</em>' attribute.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.VisibilityIndicator
   * @see #setVisibilityIndicator(VisibilityIndicator)
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage#getOperationDeclaration_VisibilityIndicator()
   * @model
   * @generated
   */
  VisibilityIndicator getVisibilityIndicator();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration#getVisibilityIndicator <em>Visibility Indicator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Visibility Indicator</em>' attribute.
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.VisibilityIndicator
   * @see #getVisibilityIndicator()
   * @generated
   */
  void setVisibilityIndicator(VisibilityIndicator value);

  /**
   * Returns the value of the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Abstract</em>' attribute.
   * @see #setAbstract(boolean)
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage#getOperationDeclaration_Abstract()
   * @model
   * @generated
   */
  boolean isAbstract();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration#isAbstract <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Abstract</em>' attribute.
   * @see #isAbstract()
   * @generated
   */
  void setAbstract(boolean value);

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
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage#getOperationDeclaration_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Formal Parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Formal Parameters</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Formal Parameters</em>' containment reference.
   * @see #setFormalParameters(FormalParameters)
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage#getOperationDeclaration_FormalParameters()
   * @model containment="true"
   * @generated
   */
  FormalParameters getFormalParameters();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration#getFormalParameters <em>Formal Parameters</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Formal Parameters</em>' containment reference.
   * @see #getFormalParameters()
   * @generated
   */
  void setFormalParameters(FormalParameters value);

  /**
   * Returns the value of the '<em><b>Return Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Return Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Return Type</em>' containment reference.
   * @see #setReturnType(TypePart)
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage#getOperationDeclaration_ReturnType()
   * @model containment="true"
   * @generated
   */
  TypePart getReturnType();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration#getReturnType <em>Return Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Return Type</em>' containment reference.
   * @see #getReturnType()
   * @generated
   */
  void setReturnType(TypePart value);

  /**
   * Returns the value of the '<em><b>Redefinition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Redefinition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Redefinition</em>' containment reference.
   * @see #setRedefinition(RedefinitionClause)
   * @see org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage#getOperationDeclaration_Redefinition()
   * @model containment="true"
   * @generated
   */
  RedefinitionClause getRedefinition();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationDeclaration#getRedefinition <em>Redefinition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Redefinition</em>' containment reference.
   * @see #getRedefinition()
   * @generated
   */
  void setRedefinition(RedefinitionClause value);

} // OperationDeclaration
