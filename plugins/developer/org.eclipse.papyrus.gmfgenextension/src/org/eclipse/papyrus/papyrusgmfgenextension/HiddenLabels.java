/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.papyrusgmfgenextension;

import org.eclipse.emf.common.util.EList;

import org.eclipse.gmf.codegen.gmfgen.GenExternalNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hidden Labels</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This element is always linked with link Label and External Node Label. This element allows to define the initial status (preferences) for the labels.
 * Labels non referenced by this node will be visible.
 * The attribute visibleByDefault allows to define this behavior.
 * This behavior can be change in the Preference Page by the user.
 * 
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.HiddenLabels#getLinkLabels <em>Link Labels</em>}</li>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.HiddenLabels#getExternalNodeLabels <em>External Node Labels</em>}</li>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.HiddenLabels#isVisibleByDefault <em>Visible By Default</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getHiddenLabels()
 * @model
 * @generated
 */
public interface HiddenLabels extends CommentedElement {
	/**
	 * Returns the value of the '<em><b>Link Labels</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.codegen.gmfgen.GenLinkLabel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link Labels</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link Labels</em>' reference list.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getHiddenLabels_LinkLabels()
	 * @model
	 * @generated
	 */
	EList<GenLinkLabel> getLinkLabels();

	/**
	 * Returns the value of the '<em><b>External Node Labels</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.codegen.gmfgen.GenExternalNodeLabel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External Node Labels</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>External Node Labels</em>' reference list.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getHiddenLabels_ExternalNodeLabels()
	 * @model
	 * @generated
	 */
	EList<GenExternalNodeLabel> getExternalNodeLabels();

	/**
	 * Returns the value of the '<em><b>Visible By Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visible By Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visible By Default</em>' attribute.
	 * @see #setVisibleByDefault(boolean)
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getHiddenLabels_VisibleByDefault()
	 * @model
	 * @generated
	 */
	boolean isVisibleByDefault();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.papyrusgmfgenextension.HiddenLabels#isVisibleByDefault <em>Visible By Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visible By Default</em>' attribute.
	 * @see #isVisibleByDefault()
	 * @generated
	 */
	void setVisibleByDefault(boolean value);

} // HiddenLabels
