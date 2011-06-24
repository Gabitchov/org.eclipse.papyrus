/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.conversion.di2;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Semantic Model Bridge</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.conversion.di2.SemanticModelBridge#getPresentation <em>
 * Presentation</em>}</li>
 * <li>{@link org.eclipse.papyrus.conversion.di2.SemanticModelBridge#getGraphElement <em>Graph
 * Element</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getSemanticModelBridge()
 * @model
 * @generated
 */
public interface SemanticModelBridge extends EObject {

	/**
	 * Returns the value of the '<em><b>Presentation</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Presentation</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Presentation</em>' attribute.
	 * @see #setPresentation(String)
	 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getSemanticModelBridge_Presentation()
	 * @model dataType="org.eclipse.uml2.uml.String"
	 * @generated
	 */
	String getPresentation();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.conversion.di2.SemanticModelBridge#getPresentation
	 * <em>Presentation</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Presentation</em>' attribute.
	 * @see #getPresentation()
	 * @generated
	 */
	void setPresentation(String value);

	/**
	 * Returns the value of the '<em><b>Graph Element</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph Element</em>' reference isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Graph Element</em>' reference.
	 * @see #setGraphElement(GraphElement)
	 * @see org.eclipse.papyrus.conversion.di2.Di2Package#getSemanticModelBridge_GraphElement()
	 * @model
	 * @generated
	 */
	GraphElement getGraphElement();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.papyrus.conversion.di2.SemanticModelBridge#getGraphElement
	 * <em>Graph Element</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Graph Element</em>' reference.
	 * @see #getGraphElement()
	 * @generated
	 */
	void setGraphElement(GraphElement value);

} // SemanticModelBridge
