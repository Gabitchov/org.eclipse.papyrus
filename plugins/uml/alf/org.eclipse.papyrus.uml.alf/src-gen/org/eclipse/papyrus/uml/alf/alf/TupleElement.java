/**
 */
package org.eclipse.papyrus.uml.alf.alf;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tuple Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.TupleElement#getArgument <em>Argument</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getTupleElement()
 * @model
 * @generated
 */
public interface TupleElement extends EObject
{
  /**
   * Returns the value of the '<em><b>Argument</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Argument</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Argument</em>' containment reference.
   * @see #setArgument(Expression)
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getTupleElement_Argument()
   * @model containment="true"
   * @generated
   */
  Expression getArgument();

  /**
   * Sets the value of the '{@link org.eclipse.papyrus.uml.alf.alf.TupleElement#getArgument <em>Argument</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Argument</em>' containment reference.
   * @see #getArgument()
   * @generated
   */
  void setArgument(Expression value);

} // TupleElement
