/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.customization.model.customization;

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
 * @see org.eclipse.papyrus.customization.model.customization.CustomizationFactory
 * @model kind="package"
 * @generated
 */
public interface CustomizationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "customization";

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
	CustomizationPackage eINSTANCE = org.eclipse.papyrus.customization.model.customization.impl.CustomizationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.customization.model.customization.impl.CustomizationConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.customization.model.customization.impl.CustomizationConfigurationImpl
	 * @see org.eclipse.papyrus.customization.model.customization.impl.CustomizationPackageImpl#getCustomizationConfiguration()
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
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMIZATION_CONFIGURATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.customization.model.customization.impl.CustomizableElementImpl <em>Customizable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.customization.model.customization.impl.CustomizableElementImpl
	 * @see org.eclipse.papyrus.customization.model.customization.impl.CustomizationPackageImpl#getCustomizableElement()
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
	 * The meta object id for the '{@link org.eclipse.papyrus.customization.model.customization.impl.FileBasedCustomizableElementImpl <em>File Based Customizable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.customization.model.customization.impl.FileBasedCustomizableElementImpl
	 * @see org.eclipse.papyrus.customization.model.customization.impl.CustomizationPackageImpl#getFileBasedCustomizableElement()
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
	 * The meta object id for the '{@link org.eclipse.papyrus.customization.model.customization.impl.PropertyViewImpl <em>Property View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.customization.model.customization.impl.PropertyViewImpl
	 * @see org.eclipse.papyrus.customization.model.customization.impl.CustomizationPackageImpl#getPropertyView()
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
	 * The meta object id for the '{@link org.eclipse.papyrus.customization.model.customization.impl.UICustomImpl <em>UI Custom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.customization.model.customization.impl.UICustomImpl
	 * @see org.eclipse.papyrus.customization.model.customization.impl.CustomizationPackageImpl#getUICustom()
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
	 * The meta object id for the '{@link org.eclipse.papyrus.customization.model.customization.impl.ModelTemplateImpl <em>Model Template</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.customization.model.customization.impl.ModelTemplateImpl
	 * @see org.eclipse.papyrus.customization.model.customization.impl.CustomizationPackageImpl#getModelTemplate()
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
	 * The meta object id for the '{@link org.eclipse.papyrus.customization.model.customization.impl.PaletteImpl <em>Palette</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.customization.model.customization.impl.PaletteImpl
	 * @see org.eclipse.papyrus.customization.model.customization.impl.CustomizationPackageImpl#getPalette()
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
	 * The meta object id for the '{@link org.eclipse.papyrus.customization.model.customization.impl.ProfileImpl <em>Profile</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.customization.model.customization.impl.ProfileImpl
	 * @see org.eclipse.papyrus.customization.model.customization.impl.CustomizationPackageImpl#getProfile()
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
	 * The meta object id for the '{@link org.eclipse.papyrus.customization.model.customization.impl.UMLModelImpl <em>UML Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.customization.model.customization.impl.UMLModelImpl
	 * @see org.eclipse.papyrus.customization.model.customization.impl.CustomizationPackageImpl#getUMLModel()
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
	 * Returns the meta object for class '{@link org.eclipse.papyrus.customization.model.customization.CustomizationConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see org.eclipse.papyrus.customization.model.customization.CustomizationConfiguration
	 * @generated
	 */
	EClass getCustomizationConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.model.customization.CustomizationConfiguration#getPlugin <em>Plugin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Plugin</em>'.
	 * @see org.eclipse.papyrus.customization.model.customization.CustomizationConfiguration#getPlugin()
	 * @see #getCustomizationConfiguration()
	 * @generated
	 */
	EAttribute getCustomizationConfiguration_Plugin();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.papyrus.customization.model.customization.CustomizationConfiguration#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.eclipse.papyrus.customization.model.customization.CustomizationConfiguration#getElements()
	 * @see #getCustomizationConfiguration()
	 * @generated
	 */
	EReference getCustomizationConfiguration_Elements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.customization.model.customization.CustomizableElement <em>Customizable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Customizable Element</em>'.
	 * @see org.eclipse.papyrus.customization.model.customization.CustomizableElement
	 * @generated
	 */
	EClass getCustomizableElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.customization.model.customization.FileBasedCustomizableElement <em>File Based Customizable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Based Customizable Element</em>'.
	 * @see org.eclipse.papyrus.customization.model.customization.FileBasedCustomizableElement
	 * @generated
	 */
	EClass getFileBasedCustomizableElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.model.customization.FileBasedCustomizableElement#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File</em>'.
	 * @see org.eclipse.papyrus.customization.model.customization.FileBasedCustomizableElement#getFile()
	 * @see #getFileBasedCustomizableElement()
	 * @generated
	 */
	EAttribute getFileBasedCustomizableElement_File();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.customization.model.customization.PropertyView <em>Property View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property View</em>'.
	 * @see org.eclipse.papyrus.customization.model.customization.PropertyView
	 * @generated
	 */
	EClass getPropertyView();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.customization.model.customization.UICustom <em>UI Custom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UI Custom</em>'.
	 * @see org.eclipse.papyrus.customization.model.customization.UICustom
	 * @generated
	 */
	EClass getUICustom();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.model.customization.UICustom#isLoadByDefault <em>Load By Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Load By Default</em>'.
	 * @see org.eclipse.papyrus.customization.model.customization.UICustom#isLoadByDefault()
	 * @see #getUICustom()
	 * @generated
	 */
	EAttribute getUICustom_LoadByDefault();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.customization.model.customization.ModelTemplate <em>Model Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Template</em>'.
	 * @see org.eclipse.papyrus.customization.model.customization.ModelTemplate
	 * @generated
	 */
	EClass getModelTemplate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.model.customization.ModelTemplate#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see org.eclipse.papyrus.customization.model.customization.ModelTemplate#getLanguage()
	 * @see #getModelTemplate()
	 * @generated
	 */
	EAttribute getModelTemplate_Language();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.model.customization.ModelTemplate#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.customization.model.customization.ModelTemplate#getName()
	 * @see #getModelTemplate()
	 * @generated
	 */
	EAttribute getModelTemplate_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.model.customization.ModelTemplate#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.papyrus.customization.model.customization.ModelTemplate#getId()
	 * @see #getModelTemplate()
	 * @generated
	 */
	EAttribute getModelTemplate_Id();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.customization.model.customization.Palette <em>Palette</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Palette</em>'.
	 * @see org.eclipse.papyrus.customization.model.customization.Palette
	 * @generated
	 */
	EClass getPalette();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.customization.model.customization.Profile <em>Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Profile</em>'.
	 * @see org.eclipse.papyrus.customization.model.customization.Profile
	 * @generated
	 */
	EClass getProfile();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.model.customization.Profile#getQualifiednames <em>Qualifiednames</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualifiednames</em>'.
	 * @see org.eclipse.papyrus.customization.model.customization.Profile#getQualifiednames()
	 * @see #getProfile()
	 * @generated
	 */
	EAttribute getProfile_Qualifiednames();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.model.customization.Profile#getIconpath <em>Iconpath</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Iconpath</em>'.
	 * @see org.eclipse.papyrus.customization.model.customization.Profile#getIconpath()
	 * @see #getProfile()
	 * @generated
	 */
	EAttribute getProfile_Iconpath();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.model.customization.Profile#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.customization.model.customization.Profile#getDescription()
	 * @see #getProfile()
	 * @generated
	 */
	EAttribute getProfile_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.model.customization.Profile#getProvider <em>Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provider</em>'.
	 * @see org.eclipse.papyrus.customization.model.customization.Profile#getProvider()
	 * @see #getProfile()
	 * @generated
	 */
	EAttribute getProfile_Provider();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.model.customization.Profile#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.customization.model.customization.Profile#getName()
	 * @see #getProfile()
	 * @generated
	 */
	EAttribute getProfile_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.customization.model.customization.UMLModel <em>UML Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UML Model</em>'.
	 * @see org.eclipse.papyrus.customization.model.customization.UMLModel
	 * @generated
	 */
	EClass getUMLModel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.model.customization.UMLModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.papyrus.customization.model.customization.UMLModel#getName()
	 * @see #getUMLModel()
	 * @generated
	 */
	EAttribute getUMLModel_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.model.customization.UMLModel#getIconpath <em>Iconpath</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Iconpath</em>'.
	 * @see org.eclipse.papyrus.customization.model.customization.UMLModel#getIconpath()
	 * @see #getUMLModel()
	 * @generated
	 */
	EAttribute getUMLModel_Iconpath();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.model.customization.UMLModel#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.papyrus.customization.model.customization.UMLModel#getDescription()
	 * @see #getUMLModel()
	 * @generated
	 */
	EAttribute getUMLModel_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.customization.model.customization.UMLModel#getProvider <em>Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provider</em>'.
	 * @see org.eclipse.papyrus.customization.model.customization.UMLModel#getProvider()
	 * @see #getUMLModel()
	 * @generated
	 */
	EAttribute getUMLModel_Provider();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CustomizationFactory getCustomizationFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.customization.model.customization.impl.CustomizationConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.customization.model.customization.impl.CustomizationConfigurationImpl
		 * @see org.eclipse.papyrus.customization.model.customization.impl.CustomizationPackageImpl#getCustomizationConfiguration()
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
		 * The meta object literal for the '{@link org.eclipse.papyrus.customization.model.customization.impl.CustomizableElementImpl <em>Customizable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.customization.model.customization.impl.CustomizableElementImpl
		 * @see org.eclipse.papyrus.customization.model.customization.impl.CustomizationPackageImpl#getCustomizableElement()
		 * @generated
		 */
		EClass CUSTOMIZABLE_ELEMENT = eINSTANCE.getCustomizableElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.customization.model.customization.impl.FileBasedCustomizableElementImpl <em>File Based Customizable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.customization.model.customization.impl.FileBasedCustomizableElementImpl
		 * @see org.eclipse.papyrus.customization.model.customization.impl.CustomizationPackageImpl#getFileBasedCustomizableElement()
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
		 * The meta object literal for the '{@link org.eclipse.papyrus.customization.model.customization.impl.PropertyViewImpl <em>Property View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.customization.model.customization.impl.PropertyViewImpl
		 * @see org.eclipse.papyrus.customization.model.customization.impl.CustomizationPackageImpl#getPropertyView()
		 * @generated
		 */
		EClass PROPERTY_VIEW = eINSTANCE.getPropertyView();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.customization.model.customization.impl.UICustomImpl <em>UI Custom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.customization.model.customization.impl.UICustomImpl
		 * @see org.eclipse.papyrus.customization.model.customization.impl.CustomizationPackageImpl#getUICustom()
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
		 * The meta object literal for the '{@link org.eclipse.papyrus.customization.model.customization.impl.ModelTemplateImpl <em>Model Template</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.customization.model.customization.impl.ModelTemplateImpl
		 * @see org.eclipse.papyrus.customization.model.customization.impl.CustomizationPackageImpl#getModelTemplate()
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
		 * The meta object literal for the '{@link org.eclipse.papyrus.customization.model.customization.impl.PaletteImpl <em>Palette</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.customization.model.customization.impl.PaletteImpl
		 * @see org.eclipse.papyrus.customization.model.customization.impl.CustomizationPackageImpl#getPalette()
		 * @generated
		 */
		EClass PALETTE = eINSTANCE.getPalette();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.customization.model.customization.impl.ProfileImpl <em>Profile</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.customization.model.customization.impl.ProfileImpl
		 * @see org.eclipse.papyrus.customization.model.customization.impl.CustomizationPackageImpl#getProfile()
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
		 * The meta object literal for the '{@link org.eclipse.papyrus.customization.model.customization.impl.UMLModelImpl <em>UML Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.customization.model.customization.impl.UMLModelImpl
		 * @see org.eclipse.papyrus.customization.model.customization.impl.CustomizationPackageImpl#getUMLModel()
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

	}

} //CustomizationPackage
