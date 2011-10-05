/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.papyrusgmfgenextension;

import org.eclipse.emf.common.util.EList;

import org.eclipse.gmf.codegen.gmfgen.GenCompartment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compartment Visibility Preference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This element allows to define the compartments which are hidden (or visible) by default
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.CompartmentVisibilityPreference#isVisibleByDefault <em>Visible By Default</em>}</li>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.CompartmentVisibilityPreference#getCompartments <em>Compartments</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getCompartmentVisibilityPreference()
 * @model
 * @generated
 */
public interface CompartmentVisibilityPreference extends CommentedElement {
	/**
	 * Returns the value of the '<em><b>Visible By Default</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visible By Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visible By Default</em>' attribute.
	 * @see #setVisibleByDefault(boolean)
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getCompartmentVisibilityPreference_VisibleByDefault()
	 * @model default="true"
	 * @generated
	 */
	boolean isVisibleByDefault();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.papyrusgmfgenextension.CompartmentVisibilityPreference#isVisibleByDefault <em>Visible By Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visible By Default</em>' attribute.
	 * @see #isVisibleByDefault()
	 * @generated
	 */
	void setVisibleByDefault(boolean value);

	/**
	 * Returns the value of the '<em><b>Compartments</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.codegen.gmfgen.GenCompartment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compartments</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compartments</em>' reference list.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getCompartmentVisibilityPreference_Compartments()
	 * @model
	 * @generated
	 */
	EList<GenCompartment> getCompartments();

} // CompartmentVisibilityPreference
