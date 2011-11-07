/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.uml.diagram.paletteconfiguration;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.Configuration#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.Configuration#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.Configuration#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.Configuration#getIcon <em>Icon</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteconfigurationPackage#getConfiguration()
 * @model abstract="true"
 * @generated
 */
public interface Configuration extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * unique identifier of the configuration, used by the tool to retrieve the configuration
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteconfigurationPackage#getConfiguration_Id()
	 * @model required="true"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.Configuration#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * label of the configuration, used only for display
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteconfigurationPackage#getConfiguration_Label()
	 * @model required="true"
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.Configuration#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Description of the configuration.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteconfigurationPackage#getConfiguration_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.Configuration#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Icon</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Icon</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Icon</em>' containment reference.
	 * @see #setIcon(IconDescriptor)
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteconfigurationPackage#getConfiguration_Icon()
	 * @model containment="true"
	 * @generated
	 */
	IconDescriptor getIcon();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.Configuration#getIcon <em>Icon</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icon</em>' containment reference.
	 * @see #getIcon()
	 * @generated
	 */
	void setIcon(IconDescriptor value);

} // Configuration
