/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop Variable Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.LoopVariableDefinition#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.LoopVariableDefinition#getExpression1 <em>Expression1</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.LoopVariableDefinition#getExpression2 <em>Expression2</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.LoopVariableDefinition#getTypeName <em>Type Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.LoopVariableDefinition#getExpression3 <em>Expression3</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLoopVariableDefinition()
 * @model
 * @generated
 */
public interface LoopVariableDefinition extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' containment reference.
   * @see #setName(Name)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLoopVariableDefinition_Name()
   * @model containment="true"
   * @generated
   */
  Name getName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.LoopVariableDefinition#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(Name value);

  /**
   * Returns the value of the '<em><b>Expression1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression1</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression1</em>' containment reference.
   * @see #setExpression1(Expression)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLoopVariableDefinition_Expression1()
   * @model containment="true"
   * @generated
   */
  Expression getExpression1();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.LoopVariableDefinition#getExpression1 <em>Expression1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression1</em>' containment reference.
   * @see #getExpression1()
   * @generated
   */
  void setExpression1(Expression value);

  /**
   * Returns the value of the '<em><b>Expression2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression2</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression2</em>' containment reference.
   * @see #setExpression2(Expression)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLoopVariableDefinition_Expression2()
   * @model containment="true"
   * @generated
   */
  Expression getExpression2();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.LoopVariableDefinition#getExpression2 <em>Expression2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression2</em>' containment reference.
   * @see #getExpression2()
   * @generated
   */
  void setExpression2(Expression value);

  /**
   * Returns the value of the '<em><b>Type Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Name</em>' containment reference.
   * @see #setTypeName(QualifiedName)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLoopVariableDefinition_TypeName()
   * @model containment="true"
   * @generated
   */
  QualifiedName getTypeName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.LoopVariableDefinition#getTypeName <em>Type Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Name</em>' containment reference.
   * @see #getTypeName()
   * @generated
   */
  void setTypeName(QualifiedName value);

  /**
   * Returns the value of the '<em><b>Expression3</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression3</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression3</em>' containment reference.
   * @see #setExpression3(Expression)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLoopVariableDefinition_Expression3()
   * @model containment="true"
   * @generated
   */
  Expression getExpression3();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.LoopVariableDefinition#getExpression3 <em>Expression3</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression3</em>' containment reference.
   * @see #getExpression3()
   * @generated
   */
  void setExpression3(Expression value);

} // LoopVariableDefinition
