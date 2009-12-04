/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.papyrusgmfgenextension;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mutating Canvas</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.MutatingCanvas#getAlternateCanvases <em>Alternate Canvases</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getMutatingCanvas()
 * @model
 * @generated
 */
public interface MutatingCanvas extends CommentedElement {

	/**
	 * Returns the value of the '<em><b>Alternate Canvases</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateCanvas}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alternate Canvases</em>' containment reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Alternate Canvases</em>' containment reference list.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getMutatingCanvas_AlternateCanvases()
	 * @model containment="true"
	 * @generated
	 */
	EList<AlternateCanvas> getAlternateCanvases();

} // MutatingCanvas
