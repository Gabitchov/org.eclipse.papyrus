/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.uml.diagram.paletteconfiguration;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteconfigurationPackage
 * @generated
 */
public interface PaletteconfigurationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PaletteconfigurationFactory eINSTANCE = org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.PaletteconfigurationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Palette Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Palette Configuration</em>'.
	 * @generated
	 */
	PaletteConfiguration createPaletteConfiguration();

	/**
	 * Returns a new object of class '<em>Tool Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tool Configuration</em>'.
	 * @generated
	 */
	ToolConfiguration createToolConfiguration();

	/**
	 * Returns a new object of class '<em>Stack Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stack Configuration</em>'.
	 * @generated
	 */
	StackConfiguration createStackConfiguration();

	/**
	 * Returns a new object of class '<em>Drawer Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Drawer Configuration</em>'.
	 * @generated
	 */
	DrawerConfiguration createDrawerConfiguration();

	/**
	 * Returns a new object of class '<em>Icon Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Icon Descriptor</em>'.
	 * @generated
	 */
	IconDescriptor createIconDescriptor();

	/**
	 * Returns a new object of class '<em>Element Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Element Descriptor</em>'.
	 * @generated
	 */
	ElementDescriptor createElementDescriptor();

	/**
	 * Returns a new object of class '<em>Separator Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Separator Configuration</em>'.
	 * @generated
	 */
	SeparatorConfiguration createSeparatorConfiguration();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PaletteconfigurationPackage getPaletteconfigurationPackage();

} //PaletteconfigurationFactory
