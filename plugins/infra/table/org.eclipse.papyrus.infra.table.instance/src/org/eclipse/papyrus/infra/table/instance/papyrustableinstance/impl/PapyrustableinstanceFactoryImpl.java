/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.table.instance.papyrustableinstance.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PapyrustableinstanceFactoryImpl extends EFactoryImpl implements PapyrustableinstanceFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PapyrustableinstanceFactory init() {
		try {
			PapyrustableinstanceFactory thePapyrustableinstanceFactory = (PapyrustableinstanceFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/Papyrus/Table/0.8.0/papyrustableinstance"); 
			if (thePapyrustableinstanceFactory != null) {
				return thePapyrustableinstanceFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PapyrustableinstanceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PapyrustableinstanceFactoryImpl() {
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
			case PapyrustableinstancePackage.PAPYRUS_TABLE_INSTANCE: return createPapyrusTableInstance();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PapyrusTableInstance createPapyrusTableInstance() {
		PapyrusTableInstanceImpl papyrusTableInstance = new PapyrusTableInstanceImpl();
		return papyrusTableInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PapyrustableinstancePackage getPapyrustableinstancePackage() {
		return (PapyrustableinstancePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PapyrustableinstancePackage getPackage() {
		return PapyrustableinstancePackage.eINSTANCE;
	}

} //PapyrustableinstanceFactoryImpl
