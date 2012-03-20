/**
 */
package org.eclipse.papyrus.uml.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional Test Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.ConditionalTestExpression#getExp <em>Exp</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.ConditionalTestExpression#getWhenTrue <em>When True</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.ConditionalTestExpression#getWhenFalse <em>When False</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getConditionalTestExpression()
 * @model
 * @generated
 */
public interface ConditionalTestExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exp</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exp</em>' containment reference.
   * @see #setExp(ConditionalOrExpression)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getConditionalTestExpression_Exp()
   * @model containment="true"
   * @generated
   */
  ConditionalOrExpression getExp();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.ConditionalTestExpression#getExp <em>Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exp</em>' containment reference.
   * @see #getExp()
   * @generated
   */
  void setExp(ConditionalOrExpression value);

  /**
   * Returns the value of the '<em><b>When True</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>When True</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>When True</em>' containment reference.
   * @see #setWhenTrue(ConditionalTestExpression)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getConditionalTestExpression_WhenTrue()
   * @model containment="true"
   * @generated
   */
  ConditionalTestExpression getWhenTrue();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.ConditionalTestExpression#getWhenTrue <em>When True</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>When True</em>' containment reference.
   * @see #getWhenTrue()
   * @generated
   */
  void setWhenTrue(ConditionalTestExpression value);

  /**
   * Returns the value of the '<em><b>When False</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>When False</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>When False</em>' containment reference.
   * @see #setWhenFalse(ConditionalTestExpression)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getConditionalTestExpression_WhenFalse()
   * @model containment="true"
   * @generated
   */
  ConditionalTestExpression getWhenFalse();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.ConditionalTestExpression#getWhenFalse <em>When False</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>When False</em>' containment reference.
   * @see #getWhenFalse()
   * @generated
   */
  void setWhenFalse(ConditionalTestExpression value);

} // ConditionalTestExpression
