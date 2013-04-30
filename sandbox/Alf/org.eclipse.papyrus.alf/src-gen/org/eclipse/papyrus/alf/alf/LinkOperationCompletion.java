/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Operation Completion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.LinkOperationCompletion#getLinkOperation <em>Link Operation</em>}</li>
 *   <li>{@link org.eclipse.papyrus.alf.alf.LinkOperationCompletion#getLinkOperationTuple <em>Link Operation Tuple</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLinkOperationCompletion()
 * @model
 * @generated
 */
public interface LinkOperationCompletion extends EObject
{
  /**
   * Returns the value of the '<em><b>Link Operation</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.papyrus.alf.alf.LinkOperation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Link Operation</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Link Operation</em>' attribute.
   * @see org.eclipse.papyrus.alf.alf.LinkOperation
   * @see #setLinkOperation(LinkOperation)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLinkOperationCompletion_LinkOperation()
   * @model
   * @generated
   */
  LinkOperation getLinkOperation();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.LinkOperationCompletion#getLinkOperation <em>Link Operation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Link Operation</em>' attribute.
   * @see org.eclipse.papyrus.alf.alf.LinkOperation
   * @see #getLinkOperation()
   * @generated
   */
  void setLinkOperation(LinkOperation value);

  /**
   * Returns the value of the '<em><b>Link Operation Tuple</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Link Operation Tuple</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Link Operation Tuple</em>' containment reference.
   * @see #setLinkOperationTuple(LinkOperationTuple)
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getLinkOperationCompletion_LinkOperationTuple()
   * @model containment="true"
   * @generated
   */
  LinkOperationTuple getLinkOperationTuple();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.alf.alf.LinkOperationCompletion#getLinkOperationTuple <em>Link Operation Tuple</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Link Operation Tuple</em>' containment reference.
   * @see #getLinkOperationTuple()
   * @generated
   */
  void setLinkOperationTuple(LinkOperationTuple value);

} // LinkOperationCompletion
