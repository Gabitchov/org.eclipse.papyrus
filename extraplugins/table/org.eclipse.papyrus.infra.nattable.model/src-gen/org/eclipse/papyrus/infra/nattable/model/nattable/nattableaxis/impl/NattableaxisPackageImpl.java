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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.impl.NattablePackageImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.EObjectAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.EStructuralFeatureAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.FeatureAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.FeatureIdAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IdAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.NattableaxisFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.NattableaxisPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.ObjectAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.ObjectIdAxis;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.NattableaxisproviderPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.NattableaxisproviderPackageImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.NattablecellPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.impl.NattablecellPackageImpl;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl.NattableconfigurationPackageImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.NattablelabelproviderPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.impl.NattablelabelproviderPackageImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.NattableproblemPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.impl.NattableproblemPackageImpl;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattabletester.NattabletesterPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattabletester.impl.NattabletesterPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class NattableaxisPackageImpl extends EPackageImpl implements NattableaxisPackage {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass iAxisEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass idAxisEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass eObjectAxisEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass featureAxisEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass objectAxisEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass featureIdAxisEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass eStructuralFeatureAxisEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass objectIdAxisEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package
	 * package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.NattableaxisPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private NattableaxisPackageImpl() {
		super(eNS_URI, NattableaxisFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link NattableaxisPackage#eINSTANCE} when that field is accessed. Clients should not invoke it directly.
	 * Instead, they should simply access that field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static NattableaxisPackage init() {
		if(isInited)
			return (NattableaxisPackage)EPackage.Registry.INSTANCE.getEPackage(NattableaxisPackage.eNS_URI);

		// Obtain or create and register package
		NattableaxisPackageImpl theNattableaxisPackage = (NattableaxisPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof NattableaxisPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new NattableaxisPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		NattablePackageImpl theNattablePackage = (NattablePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NattablePackage.eNS_URI) instanceof NattablePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NattablePackage.eNS_URI) : NattablePackage.eINSTANCE);
		NattableconfigurationPackageImpl theNattableconfigurationPackage = (NattableconfigurationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NattableconfigurationPackage.eNS_URI) instanceof NattableconfigurationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NattableconfigurationPackage.eNS_URI) : NattableconfigurationPackage.eINSTANCE);
		NattableaxisproviderPackageImpl theNattableaxisproviderPackage = (NattableaxisproviderPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NattableaxisproviderPackage.eNS_URI) instanceof NattableaxisproviderPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NattableaxisproviderPackage.eNS_URI) : NattableaxisproviderPackage.eINSTANCE);
		NattablelabelproviderPackageImpl theNattablelabelproviderPackage = (NattablelabelproviderPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NattablelabelproviderPackage.eNS_URI) instanceof NattablelabelproviderPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NattablelabelproviderPackage.eNS_URI) : NattablelabelproviderPackage.eINSTANCE);
		NattableaxisconfigurationPackageImpl theNattableaxisconfigurationPackage = (NattableaxisconfigurationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NattableaxisconfigurationPackage.eNS_URI) instanceof NattableaxisconfigurationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NattableaxisconfigurationPackage.eNS_URI) : NattableaxisconfigurationPackage.eINSTANCE);
		NattabletesterPackageImpl theNattabletesterPackage = (NattabletesterPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NattabletesterPackage.eNS_URI) instanceof NattabletesterPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NattabletesterPackage.eNS_URI) : NattabletesterPackage.eINSTANCE);
		NattablecellPackageImpl theNattablecellPackage = (NattablecellPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NattablecellPackage.eNS_URI) instanceof NattablecellPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NattablecellPackage.eNS_URI) : NattablecellPackage.eINSTANCE);
		NattableproblemPackageImpl theNattableproblemPackage = (NattableproblemPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NattableproblemPackage.eNS_URI) instanceof NattableproblemPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NattableproblemPackage.eNS_URI) : NattableproblemPackage.eINSTANCE);

		// Create package meta-data objects
		theNattableaxisPackage.createPackageContents();
		theNattablePackage.createPackageContents();
		theNattableconfigurationPackage.createPackageContents();
		theNattableaxisproviderPackage.createPackageContents();
		theNattablelabelproviderPackage.createPackageContents();
		theNattableaxisconfigurationPackage.createPackageContents();
		theNattabletesterPackage.createPackageContents();
		theNattablecellPackage.createPackageContents();
		theNattableproblemPackage.createPackageContents();

		// Initialize created meta-data
		theNattableaxisPackage.initializePackageContents();
		theNattablePackage.initializePackageContents();
		theNattableconfigurationPackage.initializePackageContents();
		theNattableaxisproviderPackage.initializePackageContents();
		theNattablelabelproviderPackage.initializePackageContents();
		theNattableaxisconfigurationPackage.initializePackageContents();
		theNattabletesterPackage.initializePackageContents();
		theNattablecellPackage.initializePackageContents();
		theNattableproblemPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theNattableaxisPackage.freeze();


		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(NattableaxisPackage.eNS_URI, theNattableaxisPackage);
		return theNattableaxisPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getIAxis() {
		return iAxisEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getIAxis_Manager() {
		return (EReference)iAxisEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getIAxis_Alias() {
		return (EAttribute)iAxisEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EOperation getIAxis__GetElement() {
		return iAxisEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EOperation getIAxis__GetLocalLabelConfiguration() {
		return iAxisEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getIdAxis() {
		return idAxisEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getIdAxis_Element() {
		return (EAttribute)idAxisEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getEObjectAxis() {
		return eObjectAxisEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getEObjectAxis_Element() {
		return (EReference)eObjectAxisEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getFeatureAxis() {
		return featureAxisEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getFeatureAxis_LocalLabelConfiguration() {
		return (EReference)featureAxisEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getObjectAxis() {
		return objectAxisEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getObjectAxis_LocalLabelConfiguration() {
		return (EReference)objectAxisEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getFeatureIdAxis() {
		return featureIdAxisEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getEStructuralFeatureAxis() {
		return eStructuralFeatureAxisEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getEStructuralFeatureAxis_Element() {
		return (EReference)eStructuralFeatureAxisEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getObjectIdAxis() {
		return objectIdAxisEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NattableaxisFactory getNattableaxisFactory() {
		return (NattableaxisFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if(isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		iAxisEClass = createEClass(IAXIS);
		createEReference(iAxisEClass, IAXIS__MANAGER);
		createEAttribute(iAxisEClass, IAXIS__ALIAS);
		createEOperation(iAxisEClass, IAXIS___GET_ELEMENT);
		createEOperation(iAxisEClass, IAXIS___GET_LOCAL_LABEL_CONFIGURATION);

		idAxisEClass = createEClass(ID_AXIS);
		createEAttribute(idAxisEClass, ID_AXIS__ELEMENT);

		eObjectAxisEClass = createEClass(EOBJECT_AXIS);
		createEReference(eObjectAxisEClass, EOBJECT_AXIS__ELEMENT);

		featureAxisEClass = createEClass(FEATURE_AXIS);
		createEReference(featureAxisEClass, FEATURE_AXIS__LOCAL_LABEL_CONFIGURATION);

		objectAxisEClass = createEClass(OBJECT_AXIS);
		createEReference(objectAxisEClass, OBJECT_AXIS__LOCAL_LABEL_CONFIGURATION);

		featureIdAxisEClass = createEClass(FEATURE_ID_AXIS);

		eStructuralFeatureAxisEClass = createEClass(ESTRUCTURAL_FEATURE_AXIS);
		createEReference(eStructuralFeatureAxisEClass, ESTRUCTURAL_FEATURE_AXIS__ELEMENT);

		objectIdAxisEClass = createEClass(OBJECT_ID_AXIS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if(isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		NattableaxisconfigurationPackage theNattableaxisconfigurationPackage = (NattableaxisconfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(NattableaxisconfigurationPackage.eNS_URI);
		NattablelabelproviderPackage theNattablelabelproviderPackage = (NattablelabelproviderPackage)EPackage.Registry.INSTANCE.getEPackage(NattablelabelproviderPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		idAxisEClass.getESuperTypes().add(this.getIAxis());
		eObjectAxisEClass.getESuperTypes().add(this.getObjectAxis());
		featureAxisEClass.getESuperTypes().add(this.getIAxis());
		objectAxisEClass.getESuperTypes().add(this.getIAxis());
		featureIdAxisEClass.getESuperTypes().add(this.getIdAxis());
		featureIdAxisEClass.getESuperTypes().add(this.getFeatureAxis());
		eStructuralFeatureAxisEClass.getESuperTypes().add(this.getFeatureAxis());
		objectIdAxisEClass.getESuperTypes().add(this.getIdAxis());
		objectIdAxisEClass.getESuperTypes().add(this.getObjectAxis());

		// Initialize classes, features, and operations; add parameters
		initEClass(iAxisEClass, IAxis.class, "IAxis", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getIAxis_Manager(), theNattableaxisconfigurationPackage.getAxisManagerRepresentation(), null, "manager", null, 1, 1, IAxis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getIAxis_Alias(), ecorePackage.getEString(), "alias", null, 0, 1, IAxis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEOperation(getIAxis__GetElement(), ecorePackage.getEJavaObject(), "getElement", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEOperation(getIAxis__GetLocalLabelConfiguration(), theNattablelabelproviderPackage.getILabelProviderConfiguration(), "getLocalLabelConfiguration", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(idAxisEClass, IdAxis.class, "IdAxis", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getIdAxis_Element(), ecorePackage.getEString(), "element", null, 1, 1, IdAxis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(eObjectAxisEClass, EObjectAxis.class, "EObjectAxis", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getEObjectAxis_Element(), ecorePackage.getEObject(), null, "element", null, 1, 1, EObjectAxis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(featureAxisEClass, FeatureAxis.class, "FeatureAxis", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getFeatureAxis_LocalLabelConfiguration(), theNattablelabelproviderPackage.getFeatureLabelProviderConfiguration(), null, "localLabelConfiguration", null, 0, 1, FeatureAxis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(objectAxisEClass, ObjectAxis.class, "ObjectAxis", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getObjectAxis_LocalLabelConfiguration(), theNattablelabelproviderPackage.getObjectLabelProviderConfiguration(), null, "localLabelConfiguration", null, 0, 1, ObjectAxis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(featureIdAxisEClass, FeatureIdAxis.class, "FeatureIdAxis", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(eStructuralFeatureAxisEClass, EStructuralFeatureAxis.class, "EStructuralFeatureAxis", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getEStructuralFeatureAxis_Element(), ecorePackage.getEStructuralFeature(), null, "element", null, 1, 1, EStructuralFeatureAxis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(objectIdAxisEClass, ObjectIdAxis.class, "ObjectIdAxis", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
	}

} //NattableaxisPackageImpl
