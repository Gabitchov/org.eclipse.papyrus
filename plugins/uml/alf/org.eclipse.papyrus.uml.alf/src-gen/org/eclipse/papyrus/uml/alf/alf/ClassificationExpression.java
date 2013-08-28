/**
 */
package org.eclipse.papyrus.uml.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Classification Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.ClassificationExpression#getExp <em>Exp</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.ClassificationExpression#getOp <em>Op</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.ClassificationExpression#getTypeName <em>Type Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getClassificationExpression()
 * @model
 * @generated
 */
public interface ClassificationExpression extends EObject
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
   * @see #setExp(RelationalExpression)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getClassificationExpression_Exp()
   * @model containment="true"
   * @generated
   */
  RelationalExpression getExp();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.ClassificationExpression#getExp <em>Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exp</em>' containment reference.
   * @see #getExp()
   * @generated
   */
  void setExp(RelationalExpression value);

  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Op</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see #setOp(String)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getClassificationExpression_Op()
   * @model
   * @generated
   */
  String getOp();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.ClassificationExpression#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see #getOp()
   * @generated
   */
  void setOp(String value);

  /**
   * Returns the value of the '<em><b>Type Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Name</em>' containment reference.
   * @see #setTypeName(NameExpression)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getClassificationExpression_TypeName()
   * @model containment="true"
   * @generated
   */
  NameExpression getTypeName();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.ClassificationExpression#getTypeName <em>Type Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Name</em>' containment reference.
   * @see #getTypeName()
   * @generated
   */
  void setTypeName(NameExpression value);

} // ClassificationExpression
