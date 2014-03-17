/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.uml.diagram.paletteconfiguration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.*;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.DrawerConfiguration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.ElementDescriptor;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.IconDescriptor;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteConfiguration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteconfigurationFactory;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteconfigurationPackage;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.SeparatorConfiguration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.StackConfiguration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.ToolConfiguration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.ToolKind;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PaletteconfigurationFactoryImpl extends EFactoryImpl implements PaletteconfigurationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PaletteconfigurationFactory init() {
		try {
			PaletteconfigurationFactory thePaletteconfigurationFactory = (PaletteconfigurationFactory)EPackage.Registry.INSTANCE.getEFactory(PaletteconfigurationPackage.eNS_URI);
			if (thePaletteconfigurationFactory != null) {
				return thePaletteconfigurationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PaletteconfigurationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PaletteconfigurationFactoryImpl() {
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
			case PaletteconfigurationPackage.PALETTE_CONFIGURATION: return createPaletteConfiguration();
			case PaletteconfigurationPackage.TOOL_CONFIGURATION: return createToolConfiguration();
			case PaletteconfigurationPackage.STACK_CONFIGURATION: return createStackConfiguration();
			case PaletteconfigurationPackage.DRAWER_CONFIGURATION: return createDrawerConfiguration();
			case PaletteconfigurationPackage.ICON_DESCRIPTOR: return createIconDescriptor();
			case PaletteconfigurationPackage.ELEMENT_DESCRIPTOR: return createElementDescriptor();
			case PaletteconfigurationPackage.SEPARATOR_CONFIGURATION: return createSeparatorConfiguration();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case PaletteconfigurationPackage.TOOL_KIND:
				return createToolKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case PaletteconfigurationPackage.TOOL_KIND:
				return convertToolKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PaletteConfiguration createPaletteConfiguration() {
		PaletteConfigurationImpl paletteConfiguration = new PaletteConfigurationImpl();
		return paletteConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToolConfiguration createToolConfiguration() {
		ToolConfigurationImpl toolConfiguration = new ToolConfigurationImpl();
		return toolConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StackConfiguration createStackConfiguration() {
		StackConfigurationImpl stackConfiguration = new StackConfigurationImpl();
		return stackConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DrawerConfiguration createDrawerConfiguration() {
		DrawerConfigurationImpl drawerConfiguration = new DrawerConfigurationImpl();
		return drawerConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IconDescriptor createIconDescriptor() {
		IconDescriptorImpl iconDescriptor = new IconDescriptorImpl();
		return iconDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementDescriptor createElementDescriptor() {
		ElementDescriptorImpl elementDescriptor = new ElementDescriptorImpl();
		return elementDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SeparatorConfiguration createSeparatorConfiguration() {
		SeparatorConfigurationImpl separatorConfiguration = new SeparatorConfigurationImpl();
		return separatorConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToolKind createToolKindFromString(EDataType eDataType, String initialValue) {
		ToolKind result = ToolKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToolKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PaletteconfigurationPackage getPaletteconfigurationPackage() {
		return (PaletteconfigurationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PaletteconfigurationPackage getPackage() {
		return PaletteconfigurationPackage.eINSTANCE;
	}

} //PaletteconfigurationFactoryImpl
