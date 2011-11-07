/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.uml.diagram.paletteconfiguration;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Drawer Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.DrawerConfiguration#getOwnedConfigurations <em>Owned Configurations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteconfigurationPackage#getDrawerConfiguration()
 * @model
 * @generated
 */
public interface DrawerConfiguration extends Configuration {
	/**
	 * Returns the value of the '<em><b>Owned Configurations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.ChildConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Configurations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Configurations</em>' containment reference list.
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteconfigurationPackage#getDrawerConfiguration_OwnedConfigurations()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ChildConfiguration> getOwnedConfigurations();

} // DrawerConfiguration
