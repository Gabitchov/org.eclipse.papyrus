/**
 *  Copyright (c) 2012 CEA LIST.
 * 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  Vincent Lorenzo (CEA-LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.texteditor.model.texteditormodel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.texteditor.model.texteditormodel.TextEditorModel;
import org.eclipse.papyrus.texteditor.model.texteditormodel.TextEditorModelFactory;
import org.eclipse.papyrus.texteditor.model.texteditormodel.TextEditorModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TextEditorModelPackageImpl extends EPackageImpl implements TextEditorModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textEditorModelEClass = null;

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
	 * @see org.eclipse.papyrus.texteditor.model.texteditormodel.TextEditorModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TextEditorModelPackageImpl() {
		super(eNS_URI, TextEditorModelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TextEditorModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TextEditorModelPackage init() {
		if (isInited) return (TextEditorModelPackage)EPackage.Registry.INSTANCE.getEPackage(TextEditorModelPackage.eNS_URI);

		// Obtain or create and register package
		TextEditorModelPackageImpl theTextEditorModelPackage = (TextEditorModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TextEditorModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TextEditorModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theTextEditorModelPackage.createPackageContents();

		// Initialize created meta-data
		theTextEditorModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTextEditorModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TextEditorModelPackage.eNS_URI, theTextEditorModelPackage);
		return theTextEditorModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTextEditorModel() {
		return textEditorModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTextEditorModel_EditedObject() {
		return (EReference)textEditorModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTextEditorModel_Type() {
		return (EAttribute)textEditorModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTextEditorModel_Name() {
		return (EAttribute)textEditorModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTextEditorModel_SelectedObject() {
		return (EReference)textEditorModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTextEditorModel_LineNumber() {
		return (EAttribute)textEditorModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextEditorModelFactory getTextEditorModelFactory() {
		return (TextEditorModelFactory)getEFactoryInstance();
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
		textEditorModelEClass = createEClass(TEXT_EDITOR_MODEL);
		createEReference(textEditorModelEClass, TEXT_EDITOR_MODEL__EDITED_OBJECT);
		createEAttribute(textEditorModelEClass, TEXT_EDITOR_MODEL__TYPE);
		createEAttribute(textEditorModelEClass, TEXT_EDITOR_MODEL__NAME);
		createEReference(textEditorModelEClass, TEXT_EDITOR_MODEL__SELECTED_OBJECT);
		createEAttribute(textEditorModelEClass, TEXT_EDITOR_MODEL__LINE_NUMBER);
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
		textEditorModelEClass.getESuperTypes().add(theEcorePackage.getEModelElement());

		// Initialize classes and features; add operations and parameters
		initEClass(textEditorModelEClass, TextEditorModel.class, "TextEditorModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTextEditorModel_EditedObject(), theEcorePackage.getEObject(), null, "editedObject", null, 0, 1, TextEditorModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTextEditorModel_Type(), ecorePackage.getEString(), "type", null, 0, 1, TextEditorModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTextEditorModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, TextEditorModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTextEditorModel_SelectedObject(), theEcorePackage.getEObject(), null, "selectedObject", null, 0, 1, TextEditorModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTextEditorModel_LineNumber(), ecorePackage.getEInt(), "lineNumber", null, 0, 1, TextEditorModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //TextEditorModelPackageImpl
