/**
 */
package org.eclipse.papyrus.uml.alf.alf;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Create Or Destroy Link Operation Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.CreateOrDestroyLinkOperationExpression#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.CreateOrDestroyLinkOperationExpression#getTuple <em>Tuple</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getCreateOrDestroyLinkOperationExpression()
 * @model
 * @generated
 */
public interface CreateOrDestroyLinkOperationExpression extends LinkOperationExpression
{
  /**
   * Returns the value of the '<em><b>Kind</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.papyrus.uml.alf.alf.LinkOperationKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Kind</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Kind</em>' attribute.
   * @see org.eclipse.papyrus.uml.alf.alf.LinkOperationKind
   * @see #setKind(LinkOperationKind)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getCreateOrDestroyLinkOperationExpression_Kind()
   * @model
   * @generated
   */
  LinkOperationKind getKind();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.CreateOrDestroyLinkOperationExpression#getKind <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Kind</em>' attribute.
   * @see org.eclipse.papyrus.uml.alf.alf.LinkOperationKind
   * @see #getKind()
   * @generated
   */
  void setKind(LinkOperationKind value);

  /**
   * Returns the value of the '<em><b>Tuple</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tuple</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tuple</em>' containment reference.
   * @see #setTuple(LinkOperationTuple)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getCreateOrDestroyLinkOperationExpression_Tuple()
   * @model containment="true"
   * @generated
   */
  LinkOperationTuple getTuple();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.CreateOrDestroyLinkOperationExpression#getTuple <em>Tuple</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tuple</em>' containment reference.
   * @see #getTuple()
   * @generated
   */
  void setTuple(LinkOperationTuple value);

} // CreateOrDestroyLinkOperationExpression
