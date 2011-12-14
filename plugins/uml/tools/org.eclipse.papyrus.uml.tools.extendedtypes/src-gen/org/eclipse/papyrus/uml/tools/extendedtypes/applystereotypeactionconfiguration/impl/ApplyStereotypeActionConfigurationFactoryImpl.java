/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfiguration;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfigurationFactory;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfigurationPackage;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.StereotypeToApply;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ApplyStereotypeActionConfigurationFactoryImpl extends EFactoryImpl implements ApplyStereotypeActionConfigurationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ApplyStereotypeActionConfigurationFactory init() {
		try {
			ApplyStereotypeActionConfigurationFactory theApplyStereotypeActionConfigurationFactory = (ApplyStereotypeActionConfigurationFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/diagram/types/applystereotypeactionconfiguration/0.7"); 
			if (theApplyStereotypeActionConfigurationFactory != null) {
				return theApplyStereotypeActionConfigurationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ApplyStereotypeActionConfigurationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplyStereotypeActionConfigurationFactoryImpl() {
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
			case ApplyStereotypeActionConfigurationPackage.APPLY_STEREOTYPE_ACTION_CONFIGURATION: return createApplyStereotypeActionConfiguration();
			case ApplyStereotypeActionConfigurationPackage.STEREOTYPE_TO_APPLY: return createStereotypeToApply();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplyStereotypeActionConfiguration createApplyStereotypeActionConfiguration() {
		ApplyStereotypeActionConfigurationImpl applyStereotypeActionConfiguration = new ApplyStereotypeActionConfigurationImpl();
		return applyStereotypeActionConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StereotypeToApply createStereotypeToApply() {
		StereotypeToApplyImpl stereotypeToApply = new StereotypeToApplyImpl();
		return stereotypeToApply;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplyStereotypeActionConfigurationPackage getApplyStereotypeActionConfigurationPackage() {
		return (ApplyStereotypeActionConfigurationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ApplyStereotypeActionConfigurationPackage getPackage() {
		return ApplyStereotypeActionConfigurationPackage.eINSTANCE;
	}

} //ApplyStereotypeActionConfigurationFactoryImpl
