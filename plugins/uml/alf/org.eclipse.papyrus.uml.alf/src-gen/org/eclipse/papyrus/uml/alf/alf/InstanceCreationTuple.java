/**
 */
package org.eclipse.papyrus.uml.alf.alf;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instance Creation Tuple</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.InstanceCreationTuple#getInstanceCreationTupleElement <em>Instance Creation Tuple Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getInstanceCreationTuple()
 * @model
 * @generated
 */
public interface InstanceCreationTuple extends EObject
{
  /**
   * Returns the value of the '<em><b>Instance Creation Tuple Element</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.uml.alf.alf.InstanceCreationTupleElement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Instance Creation Tuple Element</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Instance Creation Tuple Element</em>' containment reference list.
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getInstanceCreationTuple_InstanceCreationTupleElement()
   * @model containment="true"
   * @generated
   */
  EList<InstanceCreationTupleElement> getInstanceCreationTupleElement();

} // InstanceCreationTuple
