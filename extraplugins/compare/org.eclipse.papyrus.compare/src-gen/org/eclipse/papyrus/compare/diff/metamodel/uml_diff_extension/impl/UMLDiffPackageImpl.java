/**
 * 
 *  Copyright (c) 2010 CEA LIST.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Tatiana Fesenko(CEA LIST) - initial API and implementation
 */
package org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.impl;

import org.eclipse.emf.compare.diff.metamodel.DiffPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.AddStereotypeApplication;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.RemoveStereotypeApplication;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.StereotypeChange;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.TaggedValueChange;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.TaggedValueChangeLeftTarget;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.TaggedValueChangeRightTarget;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UMLDiffExtension;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UMLDiffFactory;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UMLDiffPackage;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UpdateTaggedValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UMLDiffPackageImpl extends EPackageImpl implements UMLDiffPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass umlDiffExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stereotypeChangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taggedValueChangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taggedValueChangeLeftTargetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taggedValueChangeRightTargetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass updateTaggedValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addStereotypeApplicationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass removeStereotypeApplicationEClass = null;

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
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UMLDiffPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UMLDiffPackageImpl() {
		super(eNS_URI, UMLDiffFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link UMLDiffPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UMLDiffPackage init() {
		if (isInited) return (UMLDiffPackage)EPackage.Registry.INSTANCE.getEPackage(UMLDiffPackage.eNS_URI);

		// Obtain or create and register package
		UMLDiffPackageImpl theUMLDiffPackage = (UMLDiffPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UMLDiffPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new UMLDiffPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		DiffPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theUMLDiffPackage.createPackageContents();

		// Initialize created meta-data
		theUMLDiffPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUMLDiffPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UMLDiffPackage.eNS_URI, theUMLDiffPackage);
		return theUMLDiffPackage;
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
	public EClass getStereotypeChange() {
		return stereotypeChangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTaggedValueChange() {
		return taggedValueChangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTaggedValueChangeLeftTarget() {
		return taggedValueChangeLeftTargetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTaggedValueChangeRightTarget() {
		return taggedValueChangeRightTargetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUpdateTaggedValue() {
		return updateTaggedValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddStereotypeApplication() {
		return addStereotypeApplicationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemoveStereotypeApplication() {
		return removeStereotypeApplicationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLDiffFactory getUMLDiffFactory() {
		return (UMLDiffFactory)getEFactoryInstance();
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
		umlDiffExtensionEClass = createEClass(UML_DIFF_EXTENSION);

		stereotypeChangeEClass = createEClass(STEREOTYPE_CHANGE);

		taggedValueChangeEClass = createEClass(TAGGED_VALUE_CHANGE);

		taggedValueChangeLeftTargetEClass = createEClass(TAGGED_VALUE_CHANGE_LEFT_TARGET);

		taggedValueChangeRightTargetEClass = createEClass(TAGGED_VALUE_CHANGE_RIGHT_TARGET);

		updateTaggedValueEClass = createEClass(UPDATE_TAGGED_VALUE);

		addStereotypeApplicationEClass = createEClass(ADD_STEREOTYPE_APPLICATION);

		removeStereotypeApplicationEClass = createEClass(REMOVE_STEREOTYPE_APPLICATION);
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
		umlDiffExtensionEClass.getESuperTypes().add(theDiffPackage.getAbstractDiffExtension());
		stereotypeChangeEClass.getESuperTypes().add(this.getUMLDiffExtension());
		taggedValueChangeEClass.getESuperTypes().add(theDiffPackage.getAttributeChange());
		taggedValueChangeLeftTargetEClass.getESuperTypes().add(theDiffPackage.getAttributeChangeLeftTarget());
		taggedValueChangeRightTargetEClass.getESuperTypes().add(theDiffPackage.getAttributeChangeRightTarget());
		updateTaggedValueEClass.getESuperTypes().add(theDiffPackage.getUpdateAttribute());
		addStereotypeApplicationEClass.getESuperTypes().add(this.getStereotypeChange());
		removeStereotypeApplicationEClass.getESuperTypes().add(this.getStereotypeChange());

		// Initialize classes and features; add operations and parameters
		initEClass(umlDiffExtensionEClass, UMLDiffExtension.class, "UMLDiffExtension", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stereotypeChangeEClass, StereotypeChange.class, "StereotypeChange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(taggedValueChangeEClass, TaggedValueChange.class, "TaggedValueChange", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(taggedValueChangeLeftTargetEClass, TaggedValueChangeLeftTarget.class, "TaggedValueChangeLeftTarget", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(taggedValueChangeRightTargetEClass, TaggedValueChangeRightTarget.class, "TaggedValueChangeRightTarget", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(updateTaggedValueEClass, UpdateTaggedValue.class, "UpdateTaggedValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(addStereotypeApplicationEClass, AddStereotypeApplication.class, "AddStereotypeApplication", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(removeStereotypeApplicationEClass, RemoveStereotypeApplication.class, "RemoveStereotypeApplication", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //UMLDiffPackageImpl
