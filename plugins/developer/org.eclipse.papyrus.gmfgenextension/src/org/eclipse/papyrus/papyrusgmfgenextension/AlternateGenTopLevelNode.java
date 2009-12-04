/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.papyrusgmfgenextension;

import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alternate Gen Top Level Node</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenTopLevelNode#getGenTopLevelNode <em>Gen Top Level Node</em>}</li>
 * <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenTopLevelNode#getTypeModelFacet <em>Type Model Facet</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getAlternateGenTopLevelNode()
 * @model
 * @generated
 */
public interface AlternateGenTopLevelNode extends CommentedElement {

	/**
	 * Returns the value of the '<em><b>Gen Top Level Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen Top Level Node</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Gen Top Level Node</em>' reference.
	 * @see #setGenTopLevelNode(GenTopLevelNode)
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getAlternateGenTopLevelNode_GenTopLevelNode()
	 * @model required="true"
	 * @generated
	 */
	GenTopLevelNode getGenTopLevelNode();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenTopLevelNode#getGenTopLevelNode
	 * <em>Gen Top Level Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Gen Top Level Node</em>' reference.
	 * @see #getGenTopLevelNode()
	 * @generated
	 */
	void setGenTopLevelNode(GenTopLevelNode value);

	/**
	 * Returns the value of the '<em><b>Type Model Facet</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Model Facet</em>' containment reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Type Model Facet</em>' containment reference.
	 * @see #setTypeModelFacet(TypeModelFacet)
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getAlternateGenTopLevelNode_TypeModelFacet()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TypeModelFacet getTypeModelFacet();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenTopLevelNode#getTypeModelFacet <em>Type Model Facet</em>}'
	 * containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Type Model Facet</em>' containment reference.
	 * @see #getTypeModelFacet()
	 * @generated
	 */
	void setTypeModelFacet(TypeModelFacet value);

} // AlternateGenTopLevelNode
