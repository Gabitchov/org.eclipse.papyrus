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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.impl.NattablePackageImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.NattableconfigurationPackageImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.DefaultContentProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.EMFFeatureContentProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.IAxisContentsProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.ISynchronizedAxisContentProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.NattablecontentproviderFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.NattablecontentproviderPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NattablecontentproviderPackageImpl extends EPackageImpl implements NattablecontentproviderPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iAxisContentsProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass defaultContentProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass emfFeatureContentProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iSynchronizedAxisContentProviderEClass = null;

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
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattablecontentprovider.NattablecontentproviderPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private NattablecontentproviderPackageImpl() {
		super(eNS_URI, NattablecontentproviderFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link NattablecontentproviderPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static NattablecontentproviderPackage init() {
		if (isInited) return (NattablecontentproviderPackage)EPackage.Registry.INSTANCE.getEPackage(NattablecontentproviderPackage.eNS_URI);

		// Obtain or create and register package
		NattablecontentproviderPackageImpl theNattablecontentproviderPackage = (NattablecontentproviderPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof NattablecontentproviderPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new NattablecontentproviderPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		NattablePackageImpl theNattablePackage = (NattablePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NattablePackage.eNS_URI) instanceof NattablePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NattablePackage.eNS_URI) : NattablePackage.eINSTANCE);
		NattableconfigurationPackageImpl theNattableconfigurationPackage = (NattableconfigurationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NattableconfigurationPackage.eNS_URI) instanceof NattableconfigurationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NattableconfigurationPackage.eNS_URI) : NattableconfigurationPackage.eINSTANCE);

		// Create package meta-data objects
		theNattablecontentproviderPackage.createPackageContents();
		theNattablePackage.createPackageContents();
		theNattableconfigurationPackage.createPackageContents();

		// Initialize created meta-data
		theNattablecontentproviderPackage.initializePackageContents();
		theNattablePackage.initializePackageContents();
		theNattableconfigurationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theNattablecontentproviderPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(NattablecontentproviderPackage.eNS_URI, theNattablecontentproviderPackage);
		return theNattablecontentproviderPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIAxisContentsProvider() {
		return iAxisContentsProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIAxisContentsProvider_JavaContentProviderIds() {
		return (EAttribute)iAxisContentsProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getIAxisContentsProvider__GetAxis() {
		return iAxisContentsProviderEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefaultContentProvider() {
		return defaultContentProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDefaultContentProvider_Axis() {
		return (EReference)defaultContentProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEMFFeatureContentProvider() {
		return emfFeatureContentProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEMFFeatureContentProvider_Feature() {
		return (EReference)emfFeatureContentProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getISynchronizedAxisContentProvider() {
		return iSynchronizedAxisContentProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NattablecontentproviderFactory getNattablecontentproviderFactory() {
		return (NattablecontentproviderFactory)getEFactoryInstance();
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
		iAxisContentsProviderEClass = createEClass(IAXIS_CONTENTS_PROVIDER);
		createEAttribute(iAxisContentsProviderEClass, IAXIS_CONTENTS_PROVIDER__JAVA_CONTENT_PROVIDER_IDS);
		createEOperation(iAxisContentsProviderEClass, IAXIS_CONTENTS_PROVIDER___GET_AXIS);

		defaultContentProviderEClass = createEClass(DEFAULT_CONTENT_PROVIDER);
		createEReference(defaultContentProviderEClass, DEFAULT_CONTENT_PROVIDER__AXIS);

		emfFeatureContentProviderEClass = createEClass(EMF_FEATURE_CONTENT_PROVIDER);
		createEReference(emfFeatureContentProviderEClass, EMF_FEATURE_CONTENT_PROVIDER__FEATURE);

		iSynchronizedAxisContentProviderEClass = createEClass(ISYNCHRONIZED_AXIS_CONTENT_PROVIDER);
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
		NattablePackage theNattablePackage = (NattablePackage)EPackage.Registry.INSTANCE.getEPackage(NattablePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		iAxisContentsProviderEClass.getESuperTypes().add(theEcorePackage.getEModelElement());
		defaultContentProviderEClass.getESuperTypes().add(this.getIAxisContentsProvider());
		emfFeatureContentProviderEClass.getESuperTypes().add(this.getDefaultContentProvider());
		emfFeatureContentProviderEClass.getESuperTypes().add(this.getISynchronizedAxisContentProvider());
		iSynchronizedAxisContentProviderEClass.getESuperTypes().add(this.getIAxisContentsProvider());

		// Initialize classes, features, and operations; add parameters
		initEClass(iAxisContentsProviderEClass, IAxisContentsProvider.class, "IAxisContentsProvider", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getIAxisContentsProvider_JavaContentProviderIds(), ecorePackage.getEString(), "javaContentProviderIds", null, 1, -1, IAxisContentsProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEOperation(getIAxisContentsProvider__GetAxis(), theNattablePackage.getIAxis(), "getAxis", 0, -1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(defaultContentProviderEClass, DefaultContentProvider.class, "DefaultContentProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getDefaultContentProvider_Axis(), theNattablePackage.getIAxis(), null, "axis", null, 0, -1, DefaultContentProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(emfFeatureContentProviderEClass, EMFFeatureContentProvider.class, "EMFFeatureContentProvider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getEMFFeatureContentProvider_Feature(), theEcorePackage.getEReference(), null, "feature", null, 1, 1, EMFFeatureContentProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(iSynchronizedAxisContentProviderEClass, ISynchronizedAxisContentProvider.class, "ISynchronizedAxisContentProvider", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
	}

} //NattablecontentproviderPackageImpl
