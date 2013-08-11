/**
 */
package org.eclipse.papyrus.facade.extensiondefinition;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Combination</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.facade.extensiondefinition.Combination#getMembers <em>Members</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionPackage#getCombination()
 * @model
 * @generated
 */
public interface Combination extends EObject {
	/**
	 * Returns the value of the '<em><b>Members</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Members</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Members</em>' reference list.
	 * @see org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionPackage#getCombination_Members()
	 * @model
	 * @generated
	 */
	EList<BaseMetaclass> getMembers();

} // Combination
