/**
 */
package org.eclipse.papyrus.uml.alf.alf;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qualified Name Path</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.alf.alf.QualifiedNamePath#getNamespace <em>Namespace</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getQualifiedNamePath()
 * @model
 * @generated
 */
public interface QualifiedNamePath extends EObject
{
  /**
   * Returns the value of the '<em><b>Namespace</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.uml.alf.alf.UnqualifiedName}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Namespace</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Namespace</em>' containment reference list.
   * @see org.eclipse.papyrus.uml.alf.alf.AlfPackage#getQualifiedNamePath_Namespace()
   * @model containment="true"
   * @generated
   */
  EList<UnqualifiedName> getNamespace();

} // QualifiedNamePath
