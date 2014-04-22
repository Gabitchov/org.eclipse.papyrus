/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.uml.diagram.paletteconfiguration;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteconfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface PaletteconfigurationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "paletteconfiguration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/diagram/paletteconfiguration/0.7";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "paletteconfiguration";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PaletteconfigurationPackage eINSTANCE = org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.PaletteconfigurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.ConfigurationImpl
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.PaletteconfigurationPackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__ID = 0;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__LABEL = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__ICON = 3;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.PaletteConfigurationImpl <em>Palette Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.PaletteConfigurationImpl
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.PaletteconfigurationPackageImpl#getPaletteConfiguration()
	 * @generated
	 */
	int PALETTE_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PALETTE_CONFIGURATION__ID = CONFIGURATION__ID;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PALETTE_CONFIGURATION__LABEL = CONFIGURATION__LABEL;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PALETTE_CONFIGURATION__DESCRIPTION = CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PALETTE_CONFIGURATION__ICON = CONFIGURATION__ICON;

	/**
	 * The feature id for the '<em><b>Drawer Configurations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PALETTE_CONFIGURATION__DRAWER_CONFIGURATIONS = CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Required Profiles</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PALETTE_CONFIGURATION__REQUIRED_PROFILES = CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Palette Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PALETTE_CONFIGURATION_FEATURE_COUNT = CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.ChildConfigurationImpl <em>Child Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.ChildConfigurationImpl
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.PaletteconfigurationPackageImpl#getChildConfiguration()
	 * @generated
	 */
	int CHILD_CONFIGURATION = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_CONFIGURATION__ID = CONFIGURATION__ID;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_CONFIGURATION__LABEL = CONFIGURATION__LABEL;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_CONFIGURATION__DESCRIPTION = CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_CONFIGURATION__ICON = CONFIGURATION__ICON;

	/**
	 * The number of structural features of the '<em>Child Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_CONFIGURATION_FEATURE_COUNT = CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.LeafConfigurationImpl <em>Leaf Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.LeafConfigurationImpl
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.PaletteconfigurationPackageImpl#getLeafConfiguration()
	 * @generated
	 */
	int LEAF_CONFIGURATION = 9;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_CONFIGURATION__ID = CHILD_CONFIGURATION__ID;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_CONFIGURATION__LABEL = CHILD_CONFIGURATION__LABEL;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_CONFIGURATION__DESCRIPTION = CHILD_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_CONFIGURATION__ICON = CHILD_CONFIGURATION__ICON;

	/**
	 * The number of structural features of the '<em>Leaf Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAF_CONFIGURATION_FEATURE_COUNT = CHILD_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.ToolConfigurationImpl <em>Tool Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.ToolConfigurationImpl
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.PaletteconfigurationPackageImpl#getToolConfiguration()
	 * @generated
	 */
	int TOOL_CONFIGURATION = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_CONFIGURATION__ID = LEAF_CONFIGURATION__ID;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_CONFIGURATION__LABEL = LEAF_CONFIGURATION__LABEL;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_CONFIGURATION__DESCRIPTION = LEAF_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_CONFIGURATION__ICON = LEAF_CONFIGURATION__ICON;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_CONFIGURATION__KIND = LEAF_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Element Descriptors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_CONFIGURATION__ELEMENT_DESCRIPTORS = LEAF_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Tool Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_CONFIGURATION_FEATURE_COUNT = LEAF_CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.StackConfigurationImpl <em>Stack Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.StackConfigurationImpl
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.PaletteconfigurationPackageImpl#getStackConfiguration()
	 * @generated
	 */
	int STACK_CONFIGURATION = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_CONFIGURATION__ID = CHILD_CONFIGURATION__ID;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_CONFIGURATION__LABEL = CHILD_CONFIGURATION__LABEL;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_CONFIGURATION__DESCRIPTION = CHILD_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_CONFIGURATION__ICON = CHILD_CONFIGURATION__ICON;

	/**
	 * The feature id for the '<em><b>Owned Configurations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_CONFIGURATION__OWNED_CONFIGURATIONS = CHILD_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Stack Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STACK_CONFIGURATION_FEATURE_COUNT = CHILD_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.DrawerConfigurationImpl <em>Drawer Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.DrawerConfigurationImpl
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.PaletteconfigurationPackageImpl#getDrawerConfiguration()
	 * @generated
	 */
	int DRAWER_CONFIGURATION = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAWER_CONFIGURATION__ID = CONFIGURATION__ID;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAWER_CONFIGURATION__LABEL = CONFIGURATION__LABEL;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAWER_CONFIGURATION__DESCRIPTION = CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAWER_CONFIGURATION__ICON = CONFIGURATION__ICON;

	/**
	 * The feature id for the '<em><b>Owned Configurations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAWER_CONFIGURATION__OWNED_CONFIGURATIONS = CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Drawer Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DRAWER_CONFIGURATION_FEATURE_COUNT = CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.IconDescriptorImpl <em>Icon Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.IconDescriptorImpl
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.PaletteconfigurationPackageImpl#getIconDescriptor()
	 * @generated
	 */
	int ICON_DESCRIPTOR = 6;

	/**
	 * The feature id for the '<em><b>Plugin ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICON_DESCRIPTOR__PLUGIN_ID = 0;

	/**
	 * The feature id for the '<em><b>Icon Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICON_DESCRIPTOR__ICON_PATH = 1;

	/**
	 * The number of structural features of the '<em>Icon Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ICON_DESCRIPTOR_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.ElementDescriptorImpl <em>Element Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.ElementDescriptorImpl
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.PaletteconfigurationPackageImpl#getElementDescriptor()
	 * @generated
	 */
	int ELEMENT_DESCRIPTOR = 7;

	/**
	 * The feature id for the '<em><b>Element Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_DESCRIPTOR__ELEMENT_TYPE_ID = 0;

	/**
	 * The feature id for the '<em><b>Graphical Hints</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_DESCRIPTOR__GRAPHICAL_HINTS = 1;

	/**
	 * The number of structural features of the '<em>Element Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_DESCRIPTOR_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.SeparatorConfigurationImpl <em>Separator Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.SeparatorConfigurationImpl
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.PaletteconfigurationPackageImpl#getSeparatorConfiguration()
	 * @generated
	 */
	int SEPARATOR_CONFIGURATION = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEPARATOR_CONFIGURATION__ID = LEAF_CONFIGURATION__ID;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEPARATOR_CONFIGURATION__LABEL = LEAF_CONFIGURATION__LABEL;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEPARATOR_CONFIGURATION__DESCRIPTION = LEAF_CONFIGURATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Icon</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEPARATOR_CONFIGURATION__ICON = LEAF_CONFIGURATION__ICON;

	/**
	 * The number of structural features of the '<em>Separator Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEPARATOR_CONFIGURATION_FEATURE_COUNT = LEAF_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.ToolKind <em>Tool Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.ToolKind
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.PaletteconfigurationPackageImpl#getToolKind()
	 * @generated
	 */
	int TOOL_KIND = 10;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteConfiguration <em>Palette Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Palette Configuration</em>'.
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteConfiguration
	 * @generated
	 */
	EClass getPaletteConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteConfiguration#getDrawerConfigurations <em>Drawer Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Drawer Configurations</em>'.
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteConfiguration#getDrawerConfigurations()
	 * @see #getPaletteConfiguration()
	 * @generated
	 */
	EReference getPaletteConfiguration_DrawerConfigurations();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteConfiguration#getRequiredProfiles <em>Required Profiles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Required Profiles</em>'.
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteConfiguration#getRequiredProfiles()
	 * @see #getPaletteConfiguration()
	 * @generated
	 */
	EAttribute getPaletteConfiguration_RequiredProfiles();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.ToolConfiguration <em>Tool Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tool Configuration</em>'.
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.ToolConfiguration
	 * @generated
	 */
	EClass getToolConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.ToolConfiguration#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.ToolConfiguration#getKind()
	 * @see #getToolConfiguration()
	 * @generated
	 */
	EAttribute getToolConfiguration_Kind();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.ToolConfiguration#getElementDescriptors <em>Element Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Element Descriptors</em>'.
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.ToolConfiguration#getElementDescriptors()
	 * @see #getToolConfiguration()
	 * @generated
	 */
	EReference getToolConfiguration_ElementDescriptors();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.StackConfiguration <em>Stack Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stack Configuration</em>'.
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.StackConfiguration
	 * @generated
	 */
	EClass getStackConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.StackConfiguration#getOwnedConfigurations <em>Owned Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Configurations</em>'.
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.StackConfiguration#getOwnedConfigurations()
	 * @see #getStackConfiguration()
	 * @generated
	 */
	EReference getStackConfiguration_OwnedConfigurations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.ChildConfiguration <em>Child Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Child Configuration</em>'.
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.ChildConfiguration
	 * @generated
	 */
	EClass getChildConfiguration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.DrawerConfiguration <em>Drawer Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Drawer Configuration</em>'.
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.DrawerConfiguration
	 * @generated
	 */
	EClass getDrawerConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.DrawerConfiguration#getOwnedConfigurations <em>Owned Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Configurations</em>'.
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.DrawerConfiguration#getOwnedConfigurations()
	 * @see #getDrawerConfiguration()
	 * @generated
	 */
	EReference getDrawerConfiguration_OwnedConfigurations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.Configuration#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.Configuration#getId()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.Configuration#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.Configuration#getLabel()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Label();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.Configuration#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.Configuration#getDescription()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Description();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.Configuration#getIcon <em>Icon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Icon</em>'.
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.Configuration#getIcon()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_Icon();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.IconDescriptor <em>Icon Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Icon Descriptor</em>'.
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.IconDescriptor
	 * @generated
	 */
	EClass getIconDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.IconDescriptor#getPluginID <em>Plugin ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plugin ID</em>'.
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.IconDescriptor#getPluginID()
	 * @see #getIconDescriptor()
	 * @generated
	 */
	EAttribute getIconDescriptor_PluginID();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.IconDescriptor#getIconPath <em>Icon Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Icon Path</em>'.
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.IconDescriptor#getIconPath()
	 * @see #getIconDescriptor()
	 * @generated
	 */
	EAttribute getIconDescriptor_IconPath();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.ElementDescriptor <em>Element Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Descriptor</em>'.
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.ElementDescriptor
	 * @generated
	 */
	EClass getElementDescriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.ElementDescriptor#getElementTypeId <em>Element Type Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Element Type Id</em>'.
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.ElementDescriptor#getElementTypeId()
	 * @see #getElementDescriptor()
	 * @generated
	 */
	EAttribute getElementDescriptor_ElementTypeId();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.ElementDescriptor#getGraphicalHints <em>Graphical Hints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Graphical Hints</em>'.
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.ElementDescriptor#getGraphicalHints()
	 * @see #getElementDescriptor()
	 * @generated
	 */
	EAttribute getElementDescriptor_GraphicalHints();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.SeparatorConfiguration <em>Separator Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Separator Configuration</em>'.
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.SeparatorConfiguration
	 * @generated
	 */
	EClass getSeparatorConfiguration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.LeafConfiguration <em>Leaf Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Leaf Configuration</em>'.
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.LeafConfiguration
	 * @generated
	 */
	EClass getLeafConfiguration();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.ToolKind <em>Tool Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Tool Kind</em>'.
	 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.ToolKind
	 * @generated
	 */
	EEnum getToolKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PaletteconfigurationFactory getPaletteconfigurationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.PaletteConfigurationImpl <em>Palette Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.PaletteConfigurationImpl
		 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.PaletteconfigurationPackageImpl#getPaletteConfiguration()
		 * @generated
		 */
		EClass PALETTE_CONFIGURATION = eINSTANCE.getPaletteConfiguration();

		/**
		 * The meta object literal for the '<em><b>Drawer Configurations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PALETTE_CONFIGURATION__DRAWER_CONFIGURATIONS = eINSTANCE.getPaletteConfiguration_DrawerConfigurations();

		/**
		 * The meta object literal for the '<em><b>Required Profiles</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PALETTE_CONFIGURATION__REQUIRED_PROFILES = eINSTANCE.getPaletteConfiguration_RequiredProfiles();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.ToolConfigurationImpl <em>Tool Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.ToolConfigurationImpl
		 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.PaletteconfigurationPackageImpl#getToolConfiguration()
		 * @generated
		 */
		EClass TOOL_CONFIGURATION = eINSTANCE.getToolConfiguration();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOOL_CONFIGURATION__KIND = eINSTANCE.getToolConfiguration_Kind();

		/**
		 * The meta object literal for the '<em><b>Element Descriptors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOOL_CONFIGURATION__ELEMENT_DESCRIPTORS = eINSTANCE.getToolConfiguration_ElementDescriptors();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.StackConfigurationImpl <em>Stack Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.StackConfigurationImpl
		 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.PaletteconfigurationPackageImpl#getStackConfiguration()
		 * @generated
		 */
		EClass STACK_CONFIGURATION = eINSTANCE.getStackConfiguration();

		/**
		 * The meta object literal for the '<em><b>Owned Configurations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STACK_CONFIGURATION__OWNED_CONFIGURATIONS = eINSTANCE.getStackConfiguration_OwnedConfigurations();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.ChildConfigurationImpl <em>Child Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.ChildConfigurationImpl
		 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.PaletteconfigurationPackageImpl#getChildConfiguration()
		 * @generated
		 */
		EClass CHILD_CONFIGURATION = eINSTANCE.getChildConfiguration();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.DrawerConfigurationImpl <em>Drawer Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.DrawerConfigurationImpl
		 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.PaletteconfigurationPackageImpl#getDrawerConfiguration()
		 * @generated
		 */
		EClass DRAWER_CONFIGURATION = eINSTANCE.getDrawerConfiguration();

		/**
		 * The meta object literal for the '<em><b>Owned Configurations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DRAWER_CONFIGURATION__OWNED_CONFIGURATIONS = eINSTANCE.getDrawerConfiguration_OwnedConfigurations();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.ConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.ConfigurationImpl
		 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.PaletteconfigurationPackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__ID = eINSTANCE.getConfiguration_Id();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__LABEL = eINSTANCE.getConfiguration_Label();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__DESCRIPTION = eINSTANCE.getConfiguration_Description();

		/**
		 * The meta object literal for the '<em><b>Icon</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__ICON = eINSTANCE.getConfiguration_Icon();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.IconDescriptorImpl <em>Icon Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.IconDescriptorImpl
		 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.PaletteconfigurationPackageImpl#getIconDescriptor()
		 * @generated
		 */
		EClass ICON_DESCRIPTOR = eINSTANCE.getIconDescriptor();

		/**
		 * The meta object literal for the '<em><b>Plugin ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ICON_DESCRIPTOR__PLUGIN_ID = eINSTANCE.getIconDescriptor_PluginID();

		/**
		 * The meta object literal for the '<em><b>Icon Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ICON_DESCRIPTOR__ICON_PATH = eINSTANCE.getIconDescriptor_IconPath();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.ElementDescriptorImpl <em>Element Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.ElementDescriptorImpl
		 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.PaletteconfigurationPackageImpl#getElementDescriptor()
		 * @generated
		 */
		EClass ELEMENT_DESCRIPTOR = eINSTANCE.getElementDescriptor();

		/**
		 * The meta object literal for the '<em><b>Element Type Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_DESCRIPTOR__ELEMENT_TYPE_ID = eINSTANCE.getElementDescriptor_ElementTypeId();

		/**
		 * The meta object literal for the '<em><b>Graphical Hints</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_DESCRIPTOR__GRAPHICAL_HINTS = eINSTANCE.getElementDescriptor_GraphicalHints();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.SeparatorConfigurationImpl <em>Separator Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.SeparatorConfigurationImpl
		 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.PaletteconfigurationPackageImpl#getSeparatorConfiguration()
		 * @generated
		 */
		EClass SEPARATOR_CONFIGURATION = eINSTANCE.getSeparatorConfiguration();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.LeafConfigurationImpl <em>Leaf Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.LeafConfigurationImpl
		 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.PaletteconfigurationPackageImpl#getLeafConfiguration()
		 * @generated
		 */
		EClass LEAF_CONFIGURATION = eINSTANCE.getLeafConfiguration();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.uml.diagram.paletteconfiguration.ToolKind <em>Tool Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.ToolKind
		 * @see org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl.PaletteconfigurationPackageImpl#getToolKind()
		 * @generated
		 */
		EEnum TOOL_KIND = eINSTANCE.getToolKind();

	}

} //PaletteconfigurationPackage
