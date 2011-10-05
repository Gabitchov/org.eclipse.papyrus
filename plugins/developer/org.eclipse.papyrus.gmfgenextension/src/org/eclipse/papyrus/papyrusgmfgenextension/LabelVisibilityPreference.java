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
 * A representation of the model object '<em><b>Label Visibility Preference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This element is always linked with link Label and External Node Label.
 * role : the role of the Label (Stereotype, Source Multiplicity, Target Multiplicity, Name, ...)
 * iconPath : an icon illustrating the role of the Label
 * visibleByDefault : if false, the label is not visible when the element is created
 * 
 * These informations are used by the action Show/Hide Label.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.LabelVisibilityPreference#getRole <em>Role</em>}</li>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.LabelVisibilityPreference#getIconPathRole <em>Icon Path Role</em>}</li>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.LabelVisibilityPreference#getLinkLabels <em>Link Labels</em>}</li>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.LabelVisibilityPreference#getExternalNodeLabels <em>External Node Labels</em>}</li>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.LabelVisibilityPreference#isVisibleByDefault <em>Visible By Default</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getLabelVisibilityPreference()
 * @model
 * @generated
 */
public interface LabelVisibilityPreference extends CommentedElement {
	/**
	 * Returns the value of the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role</em>' attribute.
	 * @see #setRole(String)
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getLabelVisibilityPreference_Role()
	 * @model required="true"
	 * @generated
	 */
	String getRole();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.papyrusgmfgenextension.LabelVisibilityPreference#getRole <em>Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role</em>' attribute.
	 * @see #getRole()
	 * @generated
	 */
	void setRole(String value);

	/**
	 * Returns the value of the '<em><b>Icon Path Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon Path Role</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon Path Role</em>' attribute.
	 * @see #setIconPathRole(String)
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getLabelVisibilityPreference_IconPathRole()
	 * @model
	 * @generated
	 */
	String getIconPathRole();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.papyrusgmfgenextension.LabelVisibilityPreference#getIconPathRole <em>Icon Path Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon Path Role</em>' attribute.
	 * @see #getIconPathRole()
	 * @generated
	 */
	void setIconPathRole(String value);

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
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getLabelVisibilityPreference_LinkLabels()
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
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getLabelVisibilityPreference_ExternalNodeLabels()
	 * @model
	 * @generated
	 */
	EList<GenExternalNodeLabel> getExternalNodeLabels();

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
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getLabelVisibilityPreference_VisibleByDefault()
	 * @model default="true"
	 * @generated
	 */
	boolean isVisibleByDefault();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.papyrusgmfgenextension.LabelVisibilityPreference#isVisibleByDefault <em>Visible By Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visible By Default</em>' attribute.
	 * @see #isVisibleByDefault()
	 * @generated
	 */
	void setVisibleByDefault(boolean value);

} // LabelVisibilityPreference
