/**
 */
package org.eclipse.papyrus.facademapping;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.facademapping.Mapping#getUmlElement <em>Uml Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.facademapping.Mapping#getSpecificDomainElement <em>Specific Domain Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.facademapping.FacademappingPackage#getMapping()
 * @model
 * @generated
 */
public interface Mapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Uml Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uml Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uml Element</em>' reference.
	 * @see #setUmlElement(EObject)
	 * @see org.eclipse.papyrus.facademapping.FacademappingPackage#getMapping_UmlElement()
	 * @model required="true"
	 * @generated
	 */
	EObject getUmlElement();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.facademapping.Mapping#getUmlElement <em>Uml Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uml Element</em>' reference.
	 * @see #getUmlElement()
	 * @generated
	 */
	void setUmlElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Specific Domain Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specific Domain Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specific Domain Element</em>' reference.
	 * @see #setSpecificDomainElement(EObject)
	 * @see org.eclipse.papyrus.facademapping.FacademappingPackage#getMapping_SpecificDomainElement()
	 * @model required="true"
	 * @generated
	 */
	EObject getSpecificDomainElement();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.facademapping.Mapping#getSpecificDomainElement <em>Specific Domain Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specific Domain Element</em>' reference.
	 * @see #getSpecificDomainElement()
	 * @generated
	 */
	void setSpecificDomainElement(EObject value);

} // Mapping
