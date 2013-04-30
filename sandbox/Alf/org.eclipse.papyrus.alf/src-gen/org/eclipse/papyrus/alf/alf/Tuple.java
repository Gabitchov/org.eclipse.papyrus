/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tuple</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.Tuple#getNamedTupleExpressionList <em>Named Tuple Expression List</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.Tuple#getPositionalTupleExpressionList <em>Positional Tuple Expression List</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getTuple()
 * @model
 * @generated
 */
public interface Tuple extends EObject
{
  /**
   * Returns the value of the '<em><b>Named Tuple Expression List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Named Tuple Expression List</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Named Tuple Expression List</em>' containment reference.
   * @see #setNamedTupleExpressionList(NamedTupleExpressionList)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getTuple_NamedTupleExpressionList()
   * @model containment="true"
   * @generated
   */
  NamedTupleExpressionList getNamedTupleExpressionList();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.Tuple#getNamedTupleExpressionList <em>Named Tuple Expression List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Named Tuple Expression List</em>' containment reference.
   * @see #getNamedTupleExpressionList()
   * @generated
   */
  void setNamedTupleExpressionList(NamedTupleExpressionList value);

  /**
   * Returns the value of the '<em><b>Positional Tuple Expression List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Positional Tuple Expression List</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Positional Tuple Expression List</em>' containment reference.
   * @see #setPositionalTupleExpressionList(PositionalTupleExpressionList)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getTuple_PositionalTupleExpressionList()
   * @model containment="true"
   * @generated
   */
  PositionalTupleExpressionList getPositionalTupleExpressionList();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.Tuple#getPositionalTupleExpressionList <em>Positional Tuple Expression List</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Positional Tuple Expression List</em>' containment reference.
   * @see #getPositionalTupleExpressionList()
   * @generated
   */
  void setPositionalTupleExpressionList(PositionalTupleExpressionList value);

} // Tuple
