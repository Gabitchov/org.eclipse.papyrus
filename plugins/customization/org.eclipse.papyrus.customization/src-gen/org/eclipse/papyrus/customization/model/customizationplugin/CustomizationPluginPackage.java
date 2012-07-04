/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.model.customizationplugin;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.eclipse.papyrus.customization.model.customizationplugin.CustomizationPluginFactory
 * @model kind="package"
 * @generated
 */
public interface CustomizationPluginPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "customizationplugin";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/customization";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "custom";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CustomizationPluginPackage eINSTANCE = org.eclipse.papyrus.customization.model.customizationplugin.impl.CustomizationPluginPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.customization.model.customizationplugin.impl.CustomizationConfigurationImpl <em>Customization Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.CustomizationConfigurationImpl
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.CustomizationPluginPackageImpl#getCustomizationConfiguration()
	 * @generated
	 */
	int CUSTOMIZATION_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Plugin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMIZATION_CONFIGURATION__PLUGIN = 0;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMIZATION_CONFIGURATION__ELEMENTS = 1;

	/**
	 * The number of structural features of the '<em>Customization Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMIZATION_CONFIGURATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.customization.model.customizationplugin.impl.CustomizableElementImpl <em>Customizable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.CustomizableElementImpl
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.CustomizationPluginPackageImpl#getCustomizableElement()
	 * @generated
	 */
	int CUSTOMIZABLE_ELEMENT = 1;

	/**
	 * The number of structural features of the '<em>Customizable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMIZABLE_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.customization.model.customizationplugin.impl.FileBasedCustomizableElementImpl <em>File Based Customizable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.FileBasedCustomizableElementImpl
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.CustomizationPluginPackageImpl#getFileBasedCustomizableElement()
	 * @generated
	 */
	int FILE_BASED_CUSTOMIZABLE_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_BASED_CUSTOMIZABLE_ELEMENT__FILE = CUSTOMIZABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>File Based Customizable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_BASED_CUSTOMIZABLE_ELEMENT_FEATURE_COUNT = CUSTOMIZABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.customization.model.customizationplugin.impl.PropertyViewImpl <em>Property View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.PropertyViewImpl
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.CustomizationPluginPackageImpl#getPropertyView()
	 * @generated
	 */
	int PROPERTY_VIEW = 3;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VIEW__FILE = FILE_BASED_CUSTOMIZABLE_ELEMENT__FILE;

	/**
	 * The number of structural features of the '<em>Property View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VIEW_FEATURE_COUNT = FILE_BASED_CUSTOMIZABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.customization.model.customizationplugin.impl.UICustomImpl <em>UI Custom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.UICustomImpl
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.CustomizationPluginPackageImpl#getUICustom()
	 * @generated
	 */
	int UI_CUSTOM = 4;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_CUSTOM__FILE = FILE_BASED_CUSTOMIZABLE_ELEMENT__FILE;

	/**
	 * The feature id for the '<em><b>Load By Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_CUSTOM__LOAD_BY_DEFAULT = FILE_BASED_CUSTOMIZABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>UI Custom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_CUSTOM_FEATURE_COUNT = FILE_BASED_CUSTOMIZABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.customization.model.customizationplugin.impl.ModelTemplateImpl <em>Model Template</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.ModelTemplateImpl
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.CustomizationPluginPackageImpl#getModelTemplate()
	 * @generated
	 */
	int MODEL_TEMPLATE = 5;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TEMPLATE__FILE = FILE_BASED_CUSTOMIZABLE_ELEMENT__FILE;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TEMPLATE__LANGUAGE = FILE_BASED_CUSTOMIZABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TEMPLATE__NAME = FILE_BASED_CUSTOMIZABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TEMPLATE__ID = FILE_BASED_CUSTOMIZABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Model Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_TEMPLATE_FEATURE_COUNT = FILE_BASED_CUSTOMIZABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.customization.model.customizationplugin.impl.PaletteImpl <em>Palette</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.PaletteImpl
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.CustomizationPluginPackageImpl#getPalette()
	 * @generated
	 */
	int PALETTE = 6;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PALETTE__FILE = FILE_BASED_CUSTOMIZABLE_ELEMENT__FILE;

	/**
	 * The number of structural features of the '<em>Palette</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PALETTE_FEATURE_COUNT = FILE_BASED_CUSTOMIZABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.customization.model.customizationplugin.impl.ProfileImpl <em>Profile</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.ProfileImpl
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.CustomizationPluginPackageImpl#getProfile()
	 * @generated
	 */
	int PROFILE = 7;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE__FILE = FILE_BASED_CUSTOMIZABLE_ELEMENT__FILE;

	/**
	 * The feature id for the '<em><b>Qualifiednames</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE__QUALIFIEDNAMES = FILE_BASED_CUSTOMIZABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Iconpath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE__ICONPATH = FILE_BASED_CUSTOMIZABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE__DESCRIPTION = FILE_BASED_CUSTOMIZABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE__PROVIDER = FILE_BASED_CUSTOMIZABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE__NAME = FILE_BASED_CUSTOMIZABLE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Profile</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROFILE_FEATURE_COUNT = FILE_BASED_CUSTOMIZABLE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.customization.model.customizationplugin.impl.UMLModelImpl <em>UML Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.UMLModelImpl
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.CustomizationPluginPackageImpl#getUMLModel()
	 * @generated
	 */
	int UML_MODEL = 8;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__FILE = FILE_BASED_CUSTOMIZABLE_ELEMENT__FILE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__NAME = FILE_BASED_CUSTOMIZABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Iconpath</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__ICONPATH = FILE_BASED_CUSTOMIZABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__DESCRIPTION = FILE_BASED_CUSTOMIZABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Provider</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL__PROVIDER = FILE_BASED_CUSTOMIZABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>UML Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UML_MODEL_FEATURE_COUNT = FILE_BASED_CUSTOMIZABLE_ELEMENT_FEATURE_COUNT + 4;


	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.customization.model.customizationplugin.impl.ConstraintsEnvironmentImpl <em>Constraints Environment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.ConstraintsEnvironmentImpl
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.CustomizationPluginPackageImpl#getConstraintsEnvironment()
	 * @generated
	 */
	int CONSTRAINTS_ENVIRONMENT = 9;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINTS_ENVIRONMENT__FILE = FILE_BASED_CUSTOMIZABLE_ELEMENT__FILE;

	/**
	 * The number of structural features of the '<em>Constraints Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINTS_ENVIRONMENT_FEATURE_COUNT = FILE_BASED_CUSTOMIZABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.customization.model.customizationplugin.impl.PropertyViewEnvironmentImpl <em>Property View Environment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.PropertyViewEnvironmentImpl
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.CustomizationPluginPackageImpl#getPropertyViewEnvironment()
	 * @generated
	 */
	int PROPERTY_VIEW_ENVIRONMENT = 10;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VIEW_ENVIRONMENT__FILE = FILE_BASED_CUSTOMIZABLE_ELEMENT__FILE;

	/**
	 * The number of structural features of the '<em>Property View Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_VIEW_ENVIRONMENT_FEATURE_COUNT = FILE_BASED_CUSTOMIZABLE_ELEMENT_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.customization.model.customizationplugin.CustomizationConfiguration <em>Customization Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Customization Configuration</em>'.
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.CustomizationConfiguration
	 * @generated
	 */
	EClass getCustomizationConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.model.customizationplugin.CustomizationConfiguration#getPlugin <em>Plugin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plugin</em>'.
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.CustomizationConfiguration#getPlugin()
	 * @see #getCustomizationConfiguration()
	 * @generated
	 */
	EAttribute getCustomizationConfiguration_Plugin();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.customization.model.customizationplugin.CustomizationConfiguration#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.CustomizationConfiguration#getElements()
	 * @see #getCustomizationConfiguration()
	 * @generated
	 */
	EReference getCustomizationConfiguration_Elements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.customization.model.customizationplugin.CustomizableElement <em>Customizable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Customizable Element</em>'.
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.CustomizableElement
	 * @generated
	 */
	EClass getCustomizableElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.customization.model.customizationplugin.FileBasedCustomizableElement <em>File Based Customizable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Based Customizable Element</em>'.
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.FileBasedCustomizableElement
	 * @generated
	 */
	EClass getFileBasedCustomizableElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.model.customizationplugin.FileBasedCustomizableElement#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File</em>'.
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.FileBasedCustomizableElement#getFile()
	 * @see #getFileBasedCustomizableElement()
	 * @generated
	 */
	EAttribute getFileBasedCustomizableElement_File();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.customization.model.customizationplugin.PropertyView <em>Property View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property View</em>'.
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.PropertyView
	 * @generated
	 */
	EClass getPropertyView();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.customization.model.customizationplugin.UICustom <em>UI Custom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UI Custom</em>'.
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.UICustom
	 * @generated
	 */
	EClass getUICustom();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.model.customizationplugin.UICustom#isLoadByDefault <em>Load By Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Load By Default</em>'.
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.UICustom#isLoadByDefault()
	 * @see #getUICustom()
	 * @generated
	 */
	EAttribute getUICustom_LoadByDefault();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.customization.model.customizationplugin.ModelTemplate <em>Model Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Template</em>'.
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.ModelTemplate
	 * @generated
	 */
	EClass getModelTemplate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.model.customizationplugin.ModelTemplate#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.ModelTemplate#getLanguage()
	 * @see #getModelTemplate()
	 * @generated
	 */
	EAttribute getModelTemplate_Language();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.model.customizationplugin.ModelTemplate#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.ModelTemplate#getName()
	 * @see #getModelTemplate()
	 * @generated
	 */
	EAttribute getModelTemplate_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.model.customizationplugin.ModelTemplate#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.ModelTemplate#getId()
	 * @see #getModelTemplate()
	 * @generated
	 */
	EAttribute getModelTemplate_Id();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.customization.model.customizationplugin.Palette <em>Palette</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Palette</em>'.
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.Palette
	 * @generated
	 */
	EClass getPalette();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.customization.model.customizationplugin.Profile <em>Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Profile</em>'.
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.Profile
	 * @generated
	 */
	EClass getProfile();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.model.customizationplugin.Profile#getQualifiednames <em>Qualifiednames</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualifiednames</em>'.
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.Profile#getQualifiednames()
	 * @see #getProfile()
	 * @generated
	 */
	EAttribute getProfile_Qualifiednames();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.model.customizationplugin.Profile#getIconpath <em>Iconpath</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Iconpath</em>'.
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.Profile#getIconpath()
	 * @see #getProfile()
	 * @generated
	 */
	EAttribute getProfile_Iconpath();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.model.customizationplugin.Profile#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.Profile#getDescription()
	 * @see #getProfile()
	 * @generated
	 */
	EAttribute getProfile_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.model.customizationplugin.Profile#getProvider <em>Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provider</em>'.
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.Profile#getProvider()
	 * @see #getProfile()
	 * @generated
	 */
	EAttribute getProfile_Provider();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.model.customizationplugin.Profile#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.Profile#getName()
	 * @see #getProfile()
	 * @generated
	 */
	EAttribute getProfile_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.customization.model.customizationplugin.UMLModel <em>UML Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UML Model</em>'.
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.UMLModel
	 * @generated
	 */
	EClass getUMLModel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.model.customizationplugin.UMLModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.UMLModel#getName()
	 * @see #getUMLModel()
	 * @generated
	 */
	EAttribute getUMLModel_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.model.customizationplugin.UMLModel#getIconpath <em>Iconpath</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Iconpath</em>'.
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.UMLModel#getIconpath()
	 * @see #getUMLModel()
	 * @generated
	 */
	EAttribute getUMLModel_Iconpath();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.model.customizationplugin.UMLModel#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.UMLModel#getDescription()
	 * @see #getUMLModel()
	 * @generated
	 */
	EAttribute getUMLModel_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.model.customizationplugin.UMLModel#getProvider <em>Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provider</em>'.
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.UMLModel#getProvider()
	 * @see #getUMLModel()
	 * @generated
	 */
	EAttribute getUMLModel_Provider();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.customization.model.customizationplugin.ConstraintsEnvironment <em>Constraints Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraints Environment</em>'.
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.ConstraintsEnvironment
	 * @generated
	 */
	EClass getConstraintsEnvironment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.customization.model.customizationplugin.PropertyViewEnvironment <em>Property View Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property View Environment</em>'.
	 * @see org.eclipse.papyrus.customization.model.customizationplugin.PropertyViewEnvironment
	 * @generated
	 */
	EClass getPropertyViewEnvironment();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CustomizationPluginFactory getCustomizationPluginFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.customization.model.customizationplugin.impl.CustomizationConfigurationImpl <em>Customization Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.CustomizationConfigurationImpl
		 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.CustomizationPluginPackageImpl#getCustomizationConfiguration()
		 * @generated
		 */
		EClass CUSTOMIZATION_CONFIGURATION = eINSTANCE.getCustomizationConfiguration();

		/**
		 * The meta object literal for the '<em><b>Plugin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOMIZATION_CONFIGURATION__PLUGIN = eINSTANCE.getCustomizationConfiguration_Plugin();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CUSTOMIZATION_CONFIGURATION__ELEMENTS = eINSTANCE.getCustomizationConfiguration_Elements();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.customization.model.customizationplugin.impl.CustomizableElementImpl <em>Customizable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.CustomizableElementImpl
		 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.CustomizationPluginPackageImpl#getCustomizableElement()
		 * @generated
		 */
		EClass CUSTOMIZABLE_ELEMENT = eINSTANCE.getCustomizableElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.customization.model.customizationplugin.impl.FileBasedCustomizableElementImpl <em>File Based Customizable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.FileBasedCustomizableElementImpl
		 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.CustomizationPluginPackageImpl#getFileBasedCustomizableElement()
		 * @generated
		 */
		EClass FILE_BASED_CUSTOMIZABLE_ELEMENT = eINSTANCE.getFileBasedCustomizableElement();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_BASED_CUSTOMIZABLE_ELEMENT__FILE = eINSTANCE.getFileBasedCustomizableElement_File();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.customization.model.customizationplugin.impl.PropertyViewImpl <em>Property View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.PropertyViewImpl
		 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.CustomizationPluginPackageImpl#getPropertyView()
		 * @generated
		 */
		EClass PROPERTY_VIEW = eINSTANCE.getPropertyView();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.customization.model.customizationplugin.impl.UICustomImpl <em>UI Custom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.UICustomImpl
		 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.CustomizationPluginPackageImpl#getUICustom()
		 * @generated
		 */
		EClass UI_CUSTOM = eINSTANCE.getUICustom();

		/**
		 * The meta object literal for the '<em><b>Load By Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UI_CUSTOM__LOAD_BY_DEFAULT = eINSTANCE.getUICustom_LoadByDefault();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.customization.model.customizationplugin.impl.ModelTemplateImpl <em>Model Template</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.ModelTemplateImpl
		 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.CustomizationPluginPackageImpl#getModelTemplate()
		 * @generated
		 */
		EClass MODEL_TEMPLATE = eINSTANCE.getModelTemplate();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_TEMPLATE__LANGUAGE = eINSTANCE.getModelTemplate_Language();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_TEMPLATE__NAME = eINSTANCE.getModelTemplate_Name();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_TEMPLATE__ID = eINSTANCE.getModelTemplate_Id();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.customization.model.customizationplugin.impl.PaletteImpl <em>Palette</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.PaletteImpl
		 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.CustomizationPluginPackageImpl#getPalette()
		 * @generated
		 */
		EClass PALETTE = eINSTANCE.getPalette();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.customization.model.customizationplugin.impl.ProfileImpl <em>Profile</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.ProfileImpl
		 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.CustomizationPluginPackageImpl#getProfile()
		 * @generated
		 */
		EClass PROFILE = eINSTANCE.getProfile();

		/**
		 * The meta object literal for the '<em><b>Qualifiednames</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILE__QUALIFIEDNAMES = eINSTANCE.getProfile_Qualifiednames();

		/**
		 * The meta object literal for the '<em><b>Iconpath</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILE__ICONPATH = eINSTANCE.getProfile_Iconpath();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILE__DESCRIPTION = eINSTANCE.getProfile_Description();

		/**
		 * The meta object literal for the '<em><b>Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILE__PROVIDER = eINSTANCE.getProfile_Provider();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROFILE__NAME = eINSTANCE.getProfile_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.customization.model.customizationplugin.impl.UMLModelImpl <em>UML Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.UMLModelImpl
		 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.CustomizationPluginPackageImpl#getUMLModel()
		 * @generated
		 */
		EClass UML_MODEL = eINSTANCE.getUMLModel();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UML_MODEL__NAME = eINSTANCE.getUMLModel_Name();

		/**
		 * The meta object literal for the '<em><b>Iconpath</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UML_MODEL__ICONPATH = eINSTANCE.getUMLModel_Iconpath();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UML_MODEL__DESCRIPTION = eINSTANCE.getUMLModel_Description();

		/**
		 * The meta object literal for the '<em><b>Provider</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UML_MODEL__PROVIDER = eINSTANCE.getUMLModel_Provider();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.customization.model.customizationplugin.impl.ConstraintsEnvironmentImpl <em>Constraints Environment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.ConstraintsEnvironmentImpl
		 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.CustomizationPluginPackageImpl#getConstraintsEnvironment()
		 * @generated
		 */
		EClass CONSTRAINTS_ENVIRONMENT = eINSTANCE.getConstraintsEnvironment();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.customization.model.customizationplugin.impl.PropertyViewEnvironmentImpl <em>Property View Environment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.PropertyViewEnvironmentImpl
		 * @see org.eclipse.papyrus.customization.model.customizationplugin.impl.CustomizationPluginPackageImpl#getPropertyViewEnvironment()
		 * @generated
		 */
		EClass PROPERTY_VIEW_ENVIRONMENT = eINSTANCE.getPropertyViewEnvironment();

	}

} //CustomizationPluginPackage
