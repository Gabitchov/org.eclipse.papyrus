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
 * A representation of the model object '<em><b>Diagram Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.diagramtemplate.DiagramDefinition#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.diagramtemplate.DiagramDefinition#getFromRoot <em>From Root</em>}</li>
 *   <li>{@link org.eclipse.papyrus.diagramtemplate.DiagramDefinition#getSelection <em>Selection</em>}</li>
 *   <li>{@link org.eclipse.papyrus.diagramtemplate.DiagramDefinition#getDiagramKind <em>Diagram Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.diagramtemplate.DiagramDefinition#getLayoutToApply <em>Layout To Apply</em>}</li>
 *   <li>{@link org.eclipse.papyrus.diagramtemplate.DiagramDefinition#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.papyrus.diagramtemplate.DiagramDefinition#getPrefix <em>Prefix</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.diagramtemplate.DiagramTemplatePackage#getDiagramDefinition()
 * @model
 * @generated
 */
public interface DiagramDefinition extends EObject {
	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipse.papyrus.diagramtemplate.DiagramTemplatePackage#getDiagramDefinition_Description()
	 * @model required="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.diagramtemplate.DiagramDefinition#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>From Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Root</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Root</em>' reference.
	 * @see #setFromRoot(EObject)
	 * @see org.eclipse.papyrus.diagramtemplate.DiagramTemplatePackage#getDiagramDefinition_FromRoot()
	 * @model
	 * @generated
	 */
	EObject getFromRoot();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.diagramtemplate.DiagramDefinition#getFromRoot <em>From Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Root</em>' reference.
	 * @see #getFromRoot()
	 * @generated
	 */
	void setFromRoot(EObject value);

	/**
	 * Returns the value of the '<em><b>Selection</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.diagramtemplate.Selection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selection</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selection</em>' containment reference list.
	 * @see org.eclipse.papyrus.diagramtemplate.DiagramTemplatePackage#getDiagramDefinition_Selection()
	 * @model containment="true"
	 * @generated
	 */
	EList<Selection> getSelection();

	/**
	 * Returns the value of the '<em><b>Diagram Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagram Kind</em>' attribute.
	 * @see #setDiagramKind(String)
	 * @see org.eclipse.papyrus.diagramtemplate.DiagramTemplatePackage#getDiagramDefinition_DiagramKind()
	 * @model
	 * @generated
	 */
	String getDiagramKind();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.diagramtemplate.DiagramDefinition#getDiagramKind <em>Diagram Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagram Kind</em>' attribute.
	 * @see #getDiagramKind()
	 * @generated
	 */
	void setDiagramKind(String value);

	/**
	 * Returns the value of the '<em><b>Layout To Apply</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layout To Apply</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layout To Apply</em>' attribute.
	 * @see #setLayoutToApply(String)
	 * @see org.eclipse.papyrus.diagramtemplate.DiagramTemplatePackage#getDiagramDefinition_LayoutToApply()
	 * @model
	 * @generated
	 */
	String getLayoutToApply();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.diagramtemplate.DiagramDefinition#getLayoutToApply <em>Layout To Apply</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layout To Apply</em>' attribute.
	 * @see #getLayoutToApply()
	 * @generated
	 */
	void setLayoutToApply(String value);

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
	 * @see org.eclipse.papyrus.diagramtemplate.DiagramTemplatePackage#getDiagramDefinition_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.diagramtemplate.DiagramDefinition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prefix</em>' attribute.
	 * @see #setPrefix(String)
	 * @see org.eclipse.papyrus.diagramtemplate.DiagramTemplatePackage#getDiagramDefinition_Prefix()
	 * @model required="true"
	 * @generated
	 */
	String getPrefix();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.diagramtemplate.DiagramDefinition#getPrefix <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prefix</em>' attribute.
	 * @see #getPrefix()
	 * @generated
	 */
	void setPrefix(String value);

} // DiagramDefinition
