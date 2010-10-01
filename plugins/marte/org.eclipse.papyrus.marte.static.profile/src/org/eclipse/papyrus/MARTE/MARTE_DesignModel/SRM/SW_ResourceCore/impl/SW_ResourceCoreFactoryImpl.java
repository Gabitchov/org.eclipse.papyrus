/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_ResourceCore.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_ResourceCore.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SW_ResourceCoreFactoryImpl extends EFactoryImpl implements SW_ResourceCoreFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SW_ResourceCoreFactory init() {
		try {
			SW_ResourceCoreFactory theSW_ResourceCoreFactory = (SW_ResourceCoreFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/SW_ResourceCore/1"); 
			if (theSW_ResourceCoreFactory != null) {
				return theSW_ResourceCoreFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SW_ResourceCoreFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SW_ResourceCoreFactoryImpl() {
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
			case SW_ResourceCorePackage.SW_ACCESS_SERVICE: return createSwAccessService();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwAccessService createSwAccessService() {
		SwAccessServiceImpl swAccessService = new SwAccessServiceImpl();
		return swAccessService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SW_ResourceCorePackage getSW_ResourceCorePackage() {
		return (SW_ResourceCorePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SW_ResourceCorePackage getPackage() {
		return SW_ResourceCorePackage.eINSTANCE;
	}

} //SW_ResourceCoreFactoryImpl
