/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.papyrusgmfgenextension;

import org.eclipse.emf.common.util.EList;

import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extended Gen Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This element is always linked to a genNode (topLevel, or child)
 * Used set if an editPart is abstract.
 * SuperGenNodes is a list of all superEditPart.
 * 
 * Thanks to this, it is possible to factorize code and to decrease the number of generated classes.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenNode#getGenNode <em>Gen Node</em>}</li>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenNode#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenNode#getSuperGenNodes <em>Super Gen Nodes</em>}</li>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenNode#getPropRefreshHook <em>Prop Refresh Hook</em>}</li>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenNode#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenNode#getSuperOwnedEditPart <em>Super Owned Edit Part</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getExtendedGenNode()
 * @model
 * @generated
 */
public interface ExtendedGenNode extends CommentedElement {
	/**
	 * Returns the value of the '<em><b>Gen Node</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.codegen.gmfgen.GenCommonBase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen Node</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gen Node</em>' reference list.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getExtendedGenNode_GenNode()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<GenCommonBase> getGenNode();

	/**
	 * Returns the value of the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Abstract</em>' attribute.
	 * @see #setIsAbstract(boolean)
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getExtendedGenNode_IsAbstract()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsAbstract();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenNode#isIsAbstract <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Abstract</em>' attribute.
	 * @see #isIsAbstract()
	 * @generated
	 */
	void setIsAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Super Gen Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.codegen.gmfgen.GenCommonBase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Gen Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Gen Nodes</em>' reference list.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getExtendedGenNode_SuperGenNodes()
	 * @model ordered="false"
	 * @generated
	 */
	EList<GenCommonBase> getSuperGenNodes();

	/**
	 * Returns the value of the '<em><b>Prop Refresh Hook</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prop Refresh Hook</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prop Refresh Hook</em>' containment reference.
	 * @see #setPropRefreshHook(PropertyRefreshHook)
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getExtendedGenNode_PropRefreshHook()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	PropertyRefreshHook getPropRefreshHook();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenNode#getPropRefreshHook <em>Prop Refresh Hook</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prop Refresh Hook</em>' containment reference.
	 * @see #getPropRefreshHook()
	 * @generated
	 */
	void setPropRefreshHook(PropertyRefreshHook value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getExtendedGenNode_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenNode#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Super Owned Edit Part</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Owned Edit Part</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Owned Edit Part</em>' attribute.
	 * @see #setSuperOwnedEditPart(String)
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getExtendedGenNode_SuperOwnedEditPart()
	 * @model
	 * @generated
	 */
	String getSuperOwnedEditPart();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenNode#getSuperOwnedEditPart <em>Super Owned Edit Part</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Owned Edit Part</em>' attribute.
	 * @see #getSuperOwnedEditPart()
	 * @generated
	 */
	void setSuperOwnedEditPart(String value);

} // ExtendedGenNode
