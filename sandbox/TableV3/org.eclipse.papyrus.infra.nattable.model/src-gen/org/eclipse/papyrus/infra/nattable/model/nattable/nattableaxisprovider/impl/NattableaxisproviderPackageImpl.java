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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.impl.NattablePackageImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.DefaultAxisProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.EMFFeatureValueAxisProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.NattableaxisproviderFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.NattableaxisproviderPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.NattableconfigurationPackageImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.NattablelabelproviderPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.impl.NattablelabelproviderPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NattableaxisproviderPackageImpl extends EPackageImpl implements NattableaxisproviderPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractAxisProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass defaultAxisProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass emfFeatureValueAxisProviderEClass = null;

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
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.NattableaxisproviderPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private NattableaxisproviderPackageImpl() {
		super(eNS_URI, NattableaxisproviderFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link NattableaxisproviderPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static NattableaxisproviderPackage init() {
		if (isInited) return (NattableaxisproviderPackage)EPackage.Registry.INSTANCE.getEPackage(NattableaxisproviderPackage.eNS_URI);

		// Obtain or create and register package
		NattableaxisproviderPackageImpl theNattableaxisproviderPackage = (NattableaxisproviderPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof NattableaxisproviderPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new NattableaxisproviderPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		NattablePackageImpl theNattablePackage = (NattablePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NattablePackage.eNS_URI) instanceof NattablePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NattablePackage.eNS_URI) : NattablePackage.eINSTANCE);
		NattableconfigurationPackageImpl theNattableconfigurationPackage = (NattableconfigurationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NattableconfigurationPackage.eNS_URI) instanceof NattableconfigurationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NattableconfigurationPackage.eNS_URI) : NattableconfigurationPackage.eINSTANCE);
		NattablelabelproviderPackageImpl theNattablelabelproviderPackage = (NattablelabelproviderPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NattablelabelproviderPackage.eNS_URI) instanceof NattablelabelproviderPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NattablelabelproviderPackage.eNS_URI) : NattablelabelproviderPackage.eINSTANCE);
		NattableaxisconfigurationPackageImpl theNattableaxisconfigurationPackage = (NattableaxisconfigurationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NattableaxisconfigurationPackage.eNS_URI) instanceof NattableaxisconfigurationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NattableaxisconfigurationPackage.eNS_URI) : NattableaxisconfigurationPackage.eINSTANCE);

		// Create package meta-data objects
		theNattableaxisproviderPackage.createPackageContents();
		theNattablePackage.createPackageContents();
		theNattableconfigurationPackage.createPackageContents();
		theNattablelabelproviderPackage.createPackageContents();
		theNattableaxisconfigurationPackage.createPackageContents();

		// Initialize created meta-data
		theNattableaxisproviderPackage.initializePackageContents();
		theNattablePackage.initializePackageContents();
		theNattableconfigurationPackage.initializePackageContents();
		theNattablelabelproviderPackage.initializePackageContents();
		theNattableaxisconfigurationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theNattableaxisproviderPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(NattableaxisproviderPackage.eNS_URI, theNattableaxisproviderPackage);
		return theNattableaxisproviderPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractAxisProvider() {
		return abstractAxisProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractAxisProvider_JavaAxisManagerIds() {
		return (EAttribute)abstractAxisProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractAxisProvider_AxisConfiguration() {
		return (EReference)abstractAxisProviderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractAxisProvider_PastedElementTypeId() {
		return (EAttribute)abstractAxisProviderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractAxisProvider_PastedElementContainmentFeature() {
		return (EReference)abstractAxisProviderEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractAxisProvider__GetAxis() {
		return abstractAxisProviderEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefaultAxisProvider() {
		return defaultAxisProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDefaultAxisProvider_Axis() {
		return (EReference)defaultAxisProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEMFFeatureValueAxisProvider() {
		return emfFeatureValueAxisProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEMFFeatureValueAxisProvider_ListenFeature() {
		return (EReference)emfFeatureValueAxisProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NattableaxisproviderFactory getNattableaxisproviderFactory() {
		return (NattableaxisproviderFactory)getEFactoryInstance();
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
		abstractAxisProviderEClass = createEClass(ABSTRACT_AXIS_PROVIDER);
		createEAttribute(abstractAxisProviderEClass, ABSTRACT_AXIS_PROVIDER__JAVA_AXIS_MANAGER_IDS);
		createEReference(abstractAxisProviderEClass, ABSTRACT_AXIS_PROVIDER__AXIS_CONFIGURATION);
		createEAttribute(abstractAxisProviderEClass, ABSTRACT_AXIS_PROVIDER__PASTED_ELEMENT_TYPE_ID);
		createEReference(abstractAxisProviderEClass, ABSTRACT_AXIS_PROVIDER__PASTED_ELEMENT_CONTAINMENT_FEATURE);
		createEOperation(abstractAxisProviderEClass, ABSTRACT_AXIS_PROVIDER___GET_AXIS);

		defaultAxisProviderEClass = createEClass(DEFAULT_AXIS_PROVIDER);
		createEReference(defaultAxisProviderEClass, DEFAULT_AXIS_PROVIDER__AXIS);

		emfFeatureValueAxisProviderEClass = createEClass(EMF_FEATURE_VALUE_AXIS_PROVIDER);
		createEReference(emfFeatureValueAxisProviderEClass, EMF_FEATURE_VALUE_AXIS_PROVIDER__LISTEN_FEATURE);
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
		NattableaxisconfigurationPackage theNattableaxisconfigurationPackage = (NattableaxisconfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(NattableaxisconfigurationPackage.eNS_URI);
		NattablePackage theNattablePackage = (NattablePackage)EPackage.Registry.INSTANCE.getEPackage(NattablePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		abstractAxisProviderEClass.getESuperTypes().add(theEcorePackage.getEModelElement());
		defaultAxisProviderEClass.getESuperTypes().add(this.getAbstractAxisProvider());
		emfFeatureValueAxisProviderEClass.getESuperTypes().add(this.getDefaultAxisProvider());

		// Initialize classes, features, and operations; add parameters
		initEClass(abstractAxisProviderEClass, AbstractAxisProvider.class, "AbstractAxisProvider", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getAbstractAxisProvider_JavaAxisManagerIds(), ecorePackage.getEString(), "javaAxisManagerIds", null, 1, -1, AbstractAxisProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAbstractAxisProvider_AxisConfiguration(), theNattableaxisconfigurationPackage.getAbstractAxisConfiguration(), null, "axisConfiguration", null, 1, 1, AbstractAxisProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getAbstractAxisProvider_PastedElementTypeId(), theEcorePackage.getEString(), "pastedElementTypeId", null, 0, 1, AbstractAxisProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAbstractAxisProvider_PastedElementContainmentFeature(), theEcorePackage.getEReference(), null, "pastedElementContainmentFeature", null, 0, 1, AbstractAxisProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEOperation(getAbstractAxisProvider__GetAxis(), theNattablePackage.getIAxis(), "getAxis", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(defaultAxisProviderEClass, DefaultAxisProvider.class, "DefaultAxisProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getDefaultAxisProvider_Axis(), theNattablePackage.getIAxis(), null, "axis", null, 0, -1, DefaultAxisProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(emfFeatureValueAxisProviderEClass, EMFFeatureValueAxisProvider.class, "EMFFeatureValueAxisProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getEMFFeatureValueAxisProvider_ListenFeature(), theEcorePackage.getEStructuralFeature(), null, "listenFeature", null, 1, 1, EMFFeatureValueAxisProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
	}

} //NattableaxisproviderPackageImpl
