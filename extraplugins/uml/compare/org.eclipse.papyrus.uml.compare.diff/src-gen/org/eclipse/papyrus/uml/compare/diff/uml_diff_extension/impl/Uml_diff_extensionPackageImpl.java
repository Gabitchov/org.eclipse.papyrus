/**
 * Copyright (c) 2012 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *   Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 * 
 * 
 */
package org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.impl;

import org.eclipse.emf.compare.diff.metamodel.DiffPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.GeneralizationSourceChangedExtension;
import org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.GeneralizationTargetChangedExtension;
import org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.UMLDiffExtension;
import org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.Uml_diff_extensionFactory;
import org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.Uml_diff_extensionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Uml_diff_extensionPackageImpl extends EPackageImpl implements Uml_diff_extensionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass generalizationTargetChangedExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass generalizationSourceChangedExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass umlDiffExtensionEClass = null;

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
	 * @see org.eclipse.papyrus.uml.compare.diff.uml_diff_extension.Uml_diff_extensionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Uml_diff_extensionPackageImpl() {
		super(eNS_URI, Uml_diff_extensionFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link Uml_diff_extensionPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Uml_diff_extensionPackage init() {
		if (isInited) return (Uml_diff_extensionPackage)EPackage.Registry.INSTANCE.getEPackage(Uml_diff_extensionPackage.eNS_URI);

		// Obtain or create and register package
		Uml_diff_extensionPackageImpl theUml_diff_extensionPackage = (Uml_diff_extensionPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Uml_diff_extensionPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Uml_diff_extensionPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		DiffPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theUml_diff_extensionPackage.createPackageContents();

		// Initialize created meta-data
		theUml_diff_extensionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUml_diff_extensionPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Uml_diff_extensionPackage.eNS_URI, theUml_diff_extensionPackage);
		return theUml_diff_extensionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeneralizationTargetChangedExtension() {
		return generalizationTargetChangedExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeneralizationSourceChangedExtension() {
		return generalizationSourceChangedExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUMLDiffExtension() {
		return umlDiffExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Uml_diff_extensionFactory getUml_diff_extensionFactory() {
		return (Uml_diff_extensionFactory)getEFactoryInstance();
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
		generalizationTargetChangedExtensionEClass = createEClass(GENERALIZATION_TARGET_CHANGED_EXTENSION);

		generalizationSourceChangedExtensionEClass = createEClass(GENERALIZATION_SOURCE_CHANGED_EXTENSION);

		umlDiffExtensionEClass = createEClass(UML_DIFF_EXTENSION);
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
		DiffPackage theDiffPackage = (DiffPackage)EPackage.Registry.INSTANCE.getEPackage(DiffPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		generalizationTargetChangedExtensionEClass.getESuperTypes().add(this.getUMLDiffExtension());
		generalizationTargetChangedExtensionEClass.getESuperTypes().add(theDiffPackage.getUpdateReference());
		generalizationSourceChangedExtensionEClass.getESuperTypes().add(this.getUMLDiffExtension());
		generalizationSourceChangedExtensionEClass.getESuperTypes().add(theDiffPackage.getMoveModelElement());
		umlDiffExtensionEClass.getESuperTypes().add(theDiffPackage.getAbstractDiffExtension());

		// Initialize classes and features; add operations and parameters
		initEClass(generalizationTargetChangedExtensionEClass, GeneralizationTargetChangedExtension.class, "GeneralizationTargetChangedExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(generalizationSourceChangedExtensionEClass, GeneralizationSourceChangedExtension.class, "GeneralizationSourceChangedExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(umlDiffExtensionEClass, UMLDiffExtension.class, "UMLDiffExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //Uml_diff_extensionPackageImpl
