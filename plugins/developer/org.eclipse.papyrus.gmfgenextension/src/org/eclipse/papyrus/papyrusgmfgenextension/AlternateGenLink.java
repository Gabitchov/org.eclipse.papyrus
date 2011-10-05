/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.papyrusgmfgenextension;

import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alternate Gen Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenLink#getGenLinkNode <em>Gen Link Node</em>}</li>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenLink#getTypeModelFacet <em>Type Model Facet</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getAlternateGenLink()
 * @model
 * @generated
 */
public interface AlternateGenLink extends CommentedElement {

	/**
	 * Returns the value of the '<em><b>Gen Link Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen Link Node</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gen Link Node</em>' reference.
	 * @see #setGenLinkNode(GenLink)
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getAlternateGenLink_GenLinkNode()
	 * @model required="true"
	 * @generated
	 */
	GenLink getGenLinkNode();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenLink#getGenLinkNode <em>Gen Link Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gen Link Node</em>' reference.
	 * @see #getGenLinkNode()
	 * @generated
	 */
	void setGenLinkNode(GenLink value);

	/**
	 * Returns the value of the '<em><b>Type Model Facet</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Model Facet</em>' containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Model Facet</em>' containment reference.
	 * @see #setTypeModelFacet(TypeModelFacet)
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getAlternateGenLink_TypeModelFacet()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TypeModelFacet getTypeModelFacet();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenLink#getTypeModelFacet <em>Type Model Facet</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Model Facet</em>' containment reference.
	 * @see #getTypeModelFacet()
	 * @generated
	 */
	void setTypeModelFacet(TypeModelFacet value);

} // AlternateGenLink
