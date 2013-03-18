/**
 * Copyright (c) 2013 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.impl.NattablePackageImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.NattableaxisproviderPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.NattableaxisproviderPackageImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.NattableconfigurationPackageImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.EObjectLabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.FeatureLabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.NattablelabelproviderFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.NattablelabelproviderPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NattablelabelproviderPackageImpl extends EPackageImpl implements NattablelabelproviderPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iLabelConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureLabelProviderConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eObjectLabelProviderConfigurationEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.NattablelabelproviderPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private NattablelabelproviderPackageImpl() {
		super(eNS_URI, NattablelabelproviderFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link NattablelabelproviderPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static NattablelabelproviderPackage init() {
		if (isInited) return (NattablelabelproviderPackage)EPackage.Registry.INSTANCE.getEPackage(NattablelabelproviderPackage.eNS_URI);

		// Obtain or create and register package
		NattablelabelproviderPackageImpl theNattablelabelproviderPackage = (NattablelabelproviderPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof NattablelabelproviderPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new NattablelabelproviderPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		NattablePackageImpl theNattablePackage = (NattablePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NattablePackage.eNS_URI) instanceof NattablePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NattablePackage.eNS_URI) : NattablePackage.eINSTANCE);
		NattableconfigurationPackageImpl theNattableconfigurationPackage = (NattableconfigurationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NattableconfigurationPackage.eNS_URI) instanceof NattableconfigurationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NattableconfigurationPackage.eNS_URI) : NattableconfigurationPackage.eINSTANCE);
		NattableaxisproviderPackageImpl theNattableaxisproviderPackage = (NattableaxisproviderPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NattableaxisproviderPackage.eNS_URI) instanceof NattableaxisproviderPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NattableaxisproviderPackage.eNS_URI) : NattableaxisproviderPackage.eINSTANCE);
		NattableaxisconfigurationPackageImpl theNattableaxisconfigurationPackage = (NattableaxisconfigurationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NattableaxisconfigurationPackage.eNS_URI) instanceof NattableaxisconfigurationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NattableaxisconfigurationPackage.eNS_URI) : NattableaxisconfigurationPackage.eINSTANCE);

		// Create package meta-data objects
		theNattablelabelproviderPackage.createPackageContents();
		theNattablePackage.createPackageContents();
		theNattableconfigurationPackage.createPackageContents();
		theNattableaxisproviderPackage.createPackageContents();
		theNattableaxisconfigurationPackage.createPackageContents();

		// Initialize created meta-data
		theNattablelabelproviderPackage.initializePackageContents();
		theNattablePackage.initializePackageContents();
		theNattableconfigurationPackage.initializePackageContents();
		theNattableaxisproviderPackage.initializePackageContents();
		theNattableaxisconfigurationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theNattablelabelproviderPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(NattablelabelproviderPackage.eNS_URI, theNattablelabelproviderPackage);
		return theNattablelabelproviderPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getILabelConfiguration() {
		return iLabelConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getILabelConfiguration_LabelProviderContext() {
		return (EAttribute)iLabelConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureLabelProviderConfiguration() {
		return featureLabelProviderConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureLabelProviderConfiguration_DisplayIsDerived() {
		return (EAttribute)featureLabelProviderConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureLabelProviderConfiguration_DisplayType() {
		return (EAttribute)featureLabelProviderConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureLabelProviderConfiguration_DisplayMultiplicity() {
		return (EAttribute)featureLabelProviderConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEObjectLabelProviderConfiguration() {
		return eObjectLabelProviderConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEObjectLabelProviderConfiguration_DisplayIcon() {
		return (EAttribute)eObjectLabelProviderConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NattablelabelproviderFactory getNattablelabelproviderFactory() {
		return (NattablelabelproviderFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		iLabelConfigurationEClass = createEClass(ILABEL_CONFIGURATION);
		createEAttribute(iLabelConfigurationEClass, ILABEL_CONFIGURATION__LABEL_PROVIDER_CONTEXT);

		featureLabelProviderConfigurationEClass = createEClass(FEATURE_LABEL_PROVIDER_CONFIGURATION);
		createEAttribute(featureLabelProviderConfigurationEClass, FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_IS_DERIVED);
		createEAttribute(featureLabelProviderConfigurationEClass, FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_TYPE);
		createEAttribute(featureLabelProviderConfigurationEClass, FEATURE_LABEL_PROVIDER_CONFIGURATION__DISPLAY_MULTIPLICITY);

		eObjectLabelProviderConfigurationEClass = createEClass(EOBJECT_LABEL_PROVIDER_CONFIGURATION);
		createEAttribute(eObjectLabelProviderConfigurationEClass, EOBJECT_LABEL_PROVIDER_CONFIGURATION__DISPLAY_ICON);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		iLabelConfigurationEClass.getESuperTypes().add(theEcorePackage.getEModelElement());
		featureLabelProviderConfigurationEClass.getESuperTypes().add(this.getILabelConfiguration());
		featureLabelProviderConfigurationEClass.getESuperTypes().add(this.getEObjectLabelProviderConfiguration());
		eObjectLabelProviderConfigurationEClass.getESuperTypes().add(this.getILabelConfiguration());

		// Initialize classes, features, and operations; add parameters
		initEClass(iLabelConfigurationEClass, ILabelConfiguration.class, "ILabelConfiguration", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getILabelConfiguration_LabelProviderContext(), theEcorePackage.getEString(), "labelProviderContext", null, 0, 1, ILabelConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(featureLabelProviderConfigurationEClass, FeatureLabelProviderConfiguration.class, "FeatureLabelProviderConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getFeatureLabelProviderConfiguration_DisplayIsDerived(), theEcorePackage.getEBoolean(), "displayIsDerived", "true", 1, 1, FeatureLabelProviderConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getFeatureLabelProviderConfiguration_DisplayType(), theEcorePackage.getEBoolean(), "displayType", "true", 1, 1, FeatureLabelProviderConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getFeatureLabelProviderConfiguration_DisplayMultiplicity(), theEcorePackage.getEBoolean(), "displayMultiplicity", "true", 1, 1, FeatureLabelProviderConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(eObjectLabelProviderConfigurationEClass, EObjectLabelProviderConfiguration.class, "EObjectLabelProviderConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getEObjectLabelProviderConfiguration_DisplayIcon(), theEcorePackage.getEBoolean(), "displayIcon", "true", 1, 1, EObjectLabelProviderConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
	}

} //NattablelabelproviderPackageImpl
