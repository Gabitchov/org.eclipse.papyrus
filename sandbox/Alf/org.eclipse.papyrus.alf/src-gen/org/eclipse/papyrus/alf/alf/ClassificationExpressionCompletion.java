/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Classification Expression Completion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ClassificationExpressionCompletion#getRelationalExpressionCompletion <em>Relational Expression Completion</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ClassificationExpressionCompletion#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ClassificationExpressionCompletion#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getClassificationExpressionCompletion()
 * @model
 * @generated
 */
public interface ClassificationExpressionCompletion extends EObject
{
  /**
   * Returns the value of the '<em><b>Relational Expression Completion</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Relational Expression Completion</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Relational Expression Completion</em>' containment reference.
   * @see #setRelationalExpressionCompletion(RelationalExpressionCompletion)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getClassificationExpressionCompletion_RelationalExpressionCompletion()
   * @model containment="true"
   * @generated
   */
  RelationalExpressionCompletion getRelationalExpressionCompletion();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ClassificationExpressionCompletion#getRelationalExpressionCompletion <em>Relational Expression Completion</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Relational Expression Completion</em>' containment reference.
   * @see #getRelationalExpressionCompletion()
   * @generated
   */
  void setRelationalExpressionCompletion(RelationalExpressionCompletion value);

  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.papyrus.alf.alf.ClassificationOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see org.eclipse.papyrus.alf.alf.ClassificationOperator
   * @see #setOperator(ClassificationOperator)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getClassificationExpressionCompletion_Operator()
   * @model
   * @generated
   */
  ClassificationOperator getOperator();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ClassificationExpressionCompletion#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see org.eclipse.papyrus.alf.alf.ClassificationOperator
   * @see #getOperator()
   * @generated
   */
  void setOperator(ClassificationOperator value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' containment reference.
   * @see #setName(QualifiedName)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getClassificationExpressionCompletion_Name()
   * @model containment="true"
   * @generated
   */
  QualifiedName getName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.ClassificationExpressionCompletion#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(QualifiedName value);

} // ClassificationExpressionCompletion
