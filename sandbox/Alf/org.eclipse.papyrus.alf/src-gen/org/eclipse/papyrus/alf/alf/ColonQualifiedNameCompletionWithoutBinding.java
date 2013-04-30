/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Colon Qualified Name Completion Without Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.ColonQualifiedNameCompletionWithoutBinding#getNames <em>Names</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getColonQualifiedNameCompletionWithoutBinding()
 * @model
 * @generated
 */
public interface ColonQualifiedNameCompletionWithoutBinding extends EObject
{
  /**
   * Returns the value of the '<em><b>Names</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.alf.alf.Name}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Names</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Names</em>' containment reference list.
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getColonQualifiedNameCompletionWithoutBinding_Names()
   * @model containment="true"
   * @generated
   */
  EList<Name> getNames();

} // ColonQualifiedNameCompletionWithoutBinding
