/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.customization.model.customization.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.customization.model.customization.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CustomizationFactoryImpl extends EFactoryImpl implements CustomizationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CustomizationFactory init() {
		try {
			CustomizationFactory theCustomizationFactory = (CustomizationFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/customization"); 
			if (theCustomizationFactory != null) {
				return theCustomizationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CustomizationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomizationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CustomizationPackage.CUSTOMIZATION_CONFIGURATION: return createCustomizationConfiguration();
			case CustomizationPackage.PROPERTY_VIEW: return createPropertyView();
			case CustomizationPackage.UI_CUSTOM: return createUICustom();
			case CustomizationPackage.MODEL_TEMPLATE: return createModelTemplate();
			case CustomizationPackage.PALETTE: return createPalette();
			case CustomizationPackage.PROFILE: return createProfile();
			case CustomizationPackage.UML_MODEL: return createUMLModel();
			case CustomizationPackage.ENVIRONMENT: return createEnvironment();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomizationConfiguration createCustomizationConfiguration() {
		CustomizationConfigurationImpl customizationConfiguration = new CustomizationConfigurationImpl();
		return customizationConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyView createPropertyView() {
		PropertyViewImpl propertyView = new PropertyViewImpl();
		return propertyView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UICustom createUICustom() {
		UICustomImpl uiCustom = new UICustomImpl();
		return uiCustom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelTemplate createModelTemplate() {
		ModelTemplateImpl modelTemplate = new ModelTemplateImpl();
		return modelTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Palette createPalette() {
		PaletteImpl palette = new PaletteImpl();
		return palette;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Profile createProfile() {
		ProfileImpl profile = new ProfileImpl();
		return profile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLModel createUMLModel() {
		UMLModelImpl umlModel = new UMLModelImpl();
		return umlModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Environment createEnvironment() {
		EnvironmentImpl environment = new EnvironmentImpl();
		return environment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomizationPackage getCustomizationPackage() {
		return (CustomizationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CustomizationPackage getPackage() {
		return CustomizationPackage.eINSTANCE;
	}

} //CustomizationFactoryImpl
