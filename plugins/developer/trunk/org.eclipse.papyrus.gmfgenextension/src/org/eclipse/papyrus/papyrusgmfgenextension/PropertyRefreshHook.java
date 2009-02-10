/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.papyrusgmfgenextension;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Refresh Hook</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This class is used to refresh the figure by taking in account a property of domain element (in the case of Ecore, it can be an Efeature or EReference)
 * The triggeringCondtion describe the needed condition to launch the action on the figure.  these two properties can be code lines.
 * 
 * For instance we would like to display active class when the efeature class is "active". Or display composite kind of the association when the kind of the property end is "composite".
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.PropertyRefreshHook#getTriggeringCondition <em>Triggering Condition</em>}</li>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.PropertyRefreshHook#getAction <em>Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getPropertyRefreshHook()
 * @model
 * @generated
 */
public interface PropertyRefreshHook extends ExternalHook {
	/**
	 * Returns the value of the '<em><b>Triggering Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Triggering Condition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Triggering Condition</em>' attribute.
	 * @see #setTriggeringCondition(String)
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getPropertyRefreshHook_TriggeringCondition()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getTriggeringCondition();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.papyrusgmfgenextension.PropertyRefreshHook#getTriggeringCondition <em>Triggering Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Triggering Condition</em>' attribute.
	 * @see #getTriggeringCondition()
	 * @generated
	 */
	void setTriggeringCondition(String value);

	/**
	 * Returns the value of the '<em><b>Action</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' attribute.
	 * @see #setAction(String)
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getPropertyRefreshHook_Action()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getAction();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.papyrusgmfgenextension.PropertyRefreshHook#getAction <em>Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' attribute.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(String value);

} // PropertyRefreshHook
