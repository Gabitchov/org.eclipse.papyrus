/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primary Expression Completion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.PrimaryExpressionCompletion#getContent <em>Content</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPrimaryExpressionCompletion()
 * @model
 * @generated
 */
public interface PrimaryExpressionCompletion extends EObject
{
  /**
   * Returns the value of the '<em><b>Content</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.alf.alf.Feature_Or_SequenceOperationOrReductionOrExpansion_Or_Index}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Content</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Content</em>' containment reference list.
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getPrimaryExpressionCompletion_Content()
   * @model containment="true"
   * @generated
   */
  EList<Feature_Or_SequenceOperationOrReductionOrExpansion_Or_Index> getContent();

} // PrimaryExpressionCompletion
