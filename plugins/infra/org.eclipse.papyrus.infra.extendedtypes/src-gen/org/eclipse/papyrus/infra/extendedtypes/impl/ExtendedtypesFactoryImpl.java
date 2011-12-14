/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.extendedtypes.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeSet;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesFactory;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedtypesPackage;
import org.eclipse.papyrus.infra.extendedtypes.IconEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExtendedtypesFactoryImpl extends EFactoryImpl implements ExtendedtypesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExtendedtypesFactory init() {
		try {
			ExtendedtypesFactory theExtendedtypesFactory = (ExtendedtypesFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/diagram/types/extendedtypes/0.7"); 
			if (theExtendedtypesFactory != null) {
				return theExtendedtypesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExtendedtypesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedtypesFactoryImpl() {
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
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_SET: return createExtendedElementTypeSet();
			case ExtendedtypesPackage.EXTENDED_ELEMENT_TYPE_CONFIGURATION: return createExtendedElementTypeConfiguration();
			case ExtendedtypesPackage.ICON_ENTRY: return createIconEntry();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedElementTypeSet createExtendedElementTypeSet() {
		ExtendedElementTypeSetImpl extendedElementTypeSet = new ExtendedElementTypeSetImpl();
		return extendedElementTypeSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedElementTypeConfiguration createExtendedElementTypeConfiguration() {
		ExtendedElementTypeConfigurationImpl extendedElementTypeConfiguration = new ExtendedElementTypeConfigurationImpl();
		return extendedElementTypeConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IconEntry createIconEntry() {
		IconEntryImpl iconEntry = new IconEntryImpl();
		return iconEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedtypesPackage getExtendedtypesPackage() {
		return (ExtendedtypesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExtendedtypesPackage getPackage() {
		return ExtendedtypesPackage.eINSTANCE;
	}

} //ExtendedtypesFactoryImpl
