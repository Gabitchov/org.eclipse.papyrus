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
 * A representation of the model object '<em><b>Palette Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteConfiguration#getDrawerConfigurations <em>Drawer Configurations</em>}</li>
 *   <li>{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteConfiguration#getRequiredProfiles <em>Required Profiles</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteconfigurationPackage#getPaletteConfiguration()
 * @model
 * @generated
 */
public interface PaletteConfiguration extends Configuration {
	/**
	 * Returns the value of the '<em><b>Drawer Configurations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.DrawerConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Drawer Configurations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Drawer Configurations</em>' containment reference list.
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteconfigurationPackage#getPaletteConfiguration_DrawerConfigurations()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<DrawerConfiguration> getDrawerConfigurations();

	/**
	 * Returns the value of the '<em><b>Required Profiles</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Profiles</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Profiles</em>' attribute list.
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteconfigurationPackage#getPaletteConfiguration_RequiredProfiles()
	 * @model
	 * @generated
	 */
	EList<String> getRequiredProfiles();

} // PaletteConfiguration
