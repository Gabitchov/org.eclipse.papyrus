/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.diagram.paletteconfiguration;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stack Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.diagram.paletteconfiguration.StackConfiguration#getToolConfigurations <em>Tool Configurations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.diagram.paletteconfiguration.PaletteconfigurationPackage#getStackConfiguration()
 * @model
 * @generated
 */
public interface StackConfiguration extends ChildConfiguration {
	/**
	 * Returns the value of the '<em><b>Tool Configurations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.diagram.paletteconfiguration.ToolConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tool Configurations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tool Configurations</em>' containment reference list.
	 * @see org.eclipse.papyrus.diagram.paletteconfiguration.PaletteconfigurationPackage#getStackConfiguration_ToolConfigurations()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ToolConfiguration> getToolConfigurations();

} // StackConfiguration
