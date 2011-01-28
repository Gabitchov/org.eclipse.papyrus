/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.diagramtemplate;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.diagramtemplate.Template#getDiagramDefinitions <em>Diagram Definitions</em>}</li>
 *   <li>{@link org.eclipse.papyrus.diagramtemplate.Template#getTargetRoot <em>Target Root</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.diagramtemplate.DiagramTemplatePackage#getTemplate()
 * @model
 * @generated
 */
public interface Template extends EObject {
	/**
	 * Returns the value of the '<em><b>Diagram Definitions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.diagramtemplate.DiagramDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram Definitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagram Definitions</em>' containment reference list.
	 * @see org.eclipse.papyrus.diagramtemplate.DiagramTemplatePackage#getTemplate_DiagramDefinitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<DiagramDefinition> getDiagramDefinitions();

	/**
	 * Returns the value of the '<em><b>Target Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Root</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Root</em>' reference.
	 * @see #setTargetRoot(EObject)
	 * @see org.eclipse.papyrus.diagramtemplate.DiagramTemplatePackage#getTemplate_TargetRoot()
	 * @model
	 * @generated
	 */
	EObject getTargetRoot();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.diagramtemplate.Template#getTargetRoot <em>Target Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Root</em>' reference.
	 * @see #getTargetRoot()
	 * @generated
	 */
	void setTargetRoot(EObject value);

} // Template
