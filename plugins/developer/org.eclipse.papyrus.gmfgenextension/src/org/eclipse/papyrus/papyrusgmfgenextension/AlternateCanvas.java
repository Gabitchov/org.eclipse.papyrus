/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.papyrusgmfgenextension;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;

import org.eclipse.emf.common.util.EList;

import org.eclipse.gmf.codegen.gmfgen.GenDiagram;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Alternate Canvas</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateCanvas#getDomainDiagramElement <em>Domain Diagram Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateCanvas#getAlternateTopLevelNodes <em>Alternate Top Level Nodes</em>}</li>
 * <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateCanvas#getAlternateLinkNodes <em>Alternate Link Nodes</em>}</li>
 * <li>{@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateCanvas#getDiagram <em>Diagram</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getAlternateCanvas()
 * @model
 * @generated
 */
public interface AlternateCanvas extends CommentedElement {

	/**
	 * Returns the value of the '<em><b>Domain Diagram Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain Diagram Element</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Domain Diagram Element</em>' reference.
	 * @see #setDomainDiagramElement(GenClass)
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getAlternateCanvas_DomainDiagramElement()
	 * @model required="true"
	 * @generated
	 */
	GenClass getDomainDiagramElement();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateCanvas#getDomainDiagramElement
	 * <em>Domain Diagram Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Domain Diagram Element</em>' reference.
	 * @see #getDomainDiagramElement()
	 * @generated
	 */
	void setDomainDiagramElement(GenClass value);

	/**
	 * Returns the value of the '<em><b>Alternate Top Level Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenTopLevelNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alternate Top Level Nodes</em>' containment reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Alternate Top Level Nodes</em>' containment reference list.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getAlternateCanvas_AlternateTopLevelNodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<AlternateGenTopLevelNode> getAlternateTopLevelNodes();

	/**
	 * Returns the value of the '<em><b>Alternate Link Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alternate Link Nodes</em>' containment reference list isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Alternate Link Nodes</em>' containment reference list.
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getAlternateCanvas_AlternateLinkNodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<AlternateGenLink> getAlternateLinkNodes();

	/**
	 * Returns the value of the '<em><b>Diagram</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Diagram</em>' reference.
	 * @see #setDiagram(GenDiagram)
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#getAlternateCanvas_Diagram()
	 * @model required="true"
	 * @generated
	 */
	GenDiagram getDiagram();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.papyrusgmfgenextension.AlternateCanvas#getDiagram <em>Diagram</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Diagram</em>' reference.
	 * @see #getDiagram()
	 * @generated
	 */
	void setDiagram(GenDiagram value);

} // AlternateCanvas
