/**
 */
package org.eclipse.papyrus.facademapping;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stereotyped Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.facademapping.StereotypedMapping#getAppliedStereotypes <em>Applied Stereotypes</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facademapping.StereotypedMapping#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.facademapping.FacademappingPackage#getStereotypedMapping()
 * @model
 * @generated
 */
public interface StereotypedMapping extends Mapping {
	/**
	 * Returns the value of the '<em><b>Applied Stereotypes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applied Stereotypes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Applied Stereotypes</em>' reference list.
	 * @see org.eclipse.papyrus.facademapping.FacademappingPackage#getStereotypedMapping_AppliedStereotypes()
	 * @model required="true"
	 * @generated
	 */
	EList<EObject> getAppliedStereotypes();

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.facademapping.ExtensionDefinitionKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.papyrus.facademapping.ExtensionDefinitionKind
	 * @see #setKind(ExtensionDefinitionKind)
	 * @see org.eclipse.papyrus.facademapping.FacademappingPackage#getStereotypedMapping_Kind()
	 * @model
	 * @generated
	 */
	ExtensionDefinitionKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.facademapping.StereotypedMapping#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.papyrus.facademapping.ExtensionDefinitionKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(ExtensionDefinitionKind value);

} // StereotypedMapping
