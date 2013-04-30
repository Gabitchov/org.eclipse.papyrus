/**
 */
package org.eclipse.papyrus.alf.alf;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tagged Value List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.alf.alf.TaggedValueList#getTaggedValue <em>Tagged Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.alf.alf.AlfPackage#getTaggedValueList()
 * @model
 * @generated
 */
public interface TaggedValueList extends TaggedValues
{
  /**
   * Returns the value of the '<em><b>Tagged Value</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.papyrus.alf.alf.TaggedValue}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tagged Value</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tagged Value</em>' containment reference list.
   * @see org.eclipse.papyrus.alf.alf.AlfPackage#getTaggedValueList_TaggedValue()
   * @model containment="true"
   * @generated
   */
  EList<TaggedValue> getTaggedValue();

} // TaggedValueList
