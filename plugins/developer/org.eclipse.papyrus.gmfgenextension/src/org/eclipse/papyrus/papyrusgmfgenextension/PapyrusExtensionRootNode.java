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
 * A representation of the model object '<em><b>Papyrus Extension Root Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.PapyrusExtensionRootNode#getExtensionNodes <em>Extension Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getPapyrusExtensionRootNode()
 * @model
 * @generated
 */
public interface PapyrusExtensionRootNode extends CommentedElement {

	/**
	 * Returns the value of the '<em><b>Extension Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.papyrusgmfgenextension.CommentedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension Nodes</em>' containment reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension Nodes</em>' containment reference list.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getPapyrusExtensionRootNode_ExtensionNodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<CommentedElement> getExtensionNodes();

} // PapyrusExtensionRootNode
