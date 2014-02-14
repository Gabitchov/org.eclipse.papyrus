/**
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 */
package org.eclipse.emf.facet.widgets.celleditors.modelCellEditor.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.facet.widgets.celleditors.modelCellEditor.AbstractModelCellEditor;
import org.eclipse.emf.facet.widgets.celleditors.modelCellEditor.BasicCellEditor;
import org.eclipse.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorDeclarations;
import org.eclipse.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorFactory;
import org.eclipse.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorPackage;
import org.eclipse.emf.facet.widgets.celleditors.modelCellEditor.NaryFeatureCellEditor;
import org.eclipse.emf.facet.widgets.celleditors.modelCellEditor.UnaryReferenceCellEditor;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class ModelCellEditorPackageImpl extends EPackageImpl implements ModelCellEditorPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass modelCellEditorDeclarationsEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass abstractModelCellEditorEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass basicCellEditorEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass unaryReferenceCellEditorEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass naryFeatureCellEditorEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory
	 * method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.emf.facet.widgets.celleditors.modelCellEditor.ModelCellEditorPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModelCellEditorPackageImpl() {
		super(ModelCellEditorPackage.eNS_URI, ModelCellEditorFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model,
	 * and for any others upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize
	 * {@link ModelCellEditorPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access
	 * that field to obtain the package. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ModelCellEditorPackage init() {
		if (ModelCellEditorPackageImpl.isInited) {
			return (ModelCellEditorPackage) EPackage.Registry.INSTANCE
					.getEPackage(ModelCellEditorPackage.eNS_URI);
		}

		// Obtain or create and register package
		ModelCellEditorPackageImpl theModelCellEditorPackage = (ModelCellEditorPackageImpl) (EPackage.Registry.INSTANCE
				.get(ModelCellEditorPackage.eNS_URI) instanceof ModelCellEditorPackageImpl ? EPackage.Registry.INSTANCE
				.get(ModelCellEditorPackage.eNS_URI) : new ModelCellEditorPackageImpl());

		ModelCellEditorPackageImpl.isInited = true;

		// Create package meta-data objects
		theModelCellEditorPackage.createPackageContents();

		// Initialize created meta-data
		theModelCellEditorPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModelCellEditorPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ModelCellEditorPackage.eNS_URI, theModelCellEditorPackage);
		return theModelCellEditorPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getModelCellEditorDeclarations() {
		return this.modelCellEditorDeclarationsEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getModelCellEditorDeclarations_ModelCellEditors() {
		return (EReference) this.modelCellEditorDeclarationsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getAbstractModelCellEditor() {
		return this.abstractModelCellEditorEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getAbstractModelCellEditor_CellType() {
		return (EReference) this.abstractModelCellEditorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getAbstractModelCellEditor_CellId() {
		return (EAttribute) this.abstractModelCellEditorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getBasicCellEditor() {
		return this.basicCellEditorEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getBasicCellEditor_BasicCellEditorImpl() {
		return (EAttribute) this.basicCellEditorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getUnaryReferenceCellEditor() {
		return this.unaryReferenceCellEditorEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getUnaryReferenceCellEditor_UnaryReferenceCellEditorImpl() {
		return (EAttribute) this.unaryReferenceCellEditorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getNaryFeatureCellEditor() {
		return this.naryFeatureCellEditorEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getNaryFeatureCellEditor_NaryFeatureCellEditorImpl() {
		return (EAttribute) this.naryFeatureCellEditorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelCellEditorFactory getModelCellEditorFactory() {
		return (ModelCellEditorFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is guarded to
	 * have no affect on any invocation but its first. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if (this.isCreated) {
			return;
		}
		this.isCreated = true;

		// Create classes and their features
		this.modelCellEditorDeclarationsEClass = createEClass(ModelCellEditorPackage.MODEL_CELL_EDITOR_DECLARATIONS);
		createEReference(this.modelCellEditorDeclarationsEClass,
				ModelCellEditorPackage.MODEL_CELL_EDITOR_DECLARATIONS__MODEL_CELL_EDITORS);

		this.abstractModelCellEditorEClass = createEClass(ModelCellEditorPackage.ABSTRACT_MODEL_CELL_EDITOR);
		createEReference(this.abstractModelCellEditorEClass,
				ModelCellEditorPackage.ABSTRACT_MODEL_CELL_EDITOR__CELL_TYPE);
		createEAttribute(this.abstractModelCellEditorEClass,
				ModelCellEditorPackage.ABSTRACT_MODEL_CELL_EDITOR__CELL_ID);

		this.basicCellEditorEClass = createEClass(ModelCellEditorPackage.BASIC_CELL_EDITOR);
		createEAttribute(this.basicCellEditorEClass,
				ModelCellEditorPackage.BASIC_CELL_EDITOR__BASIC_CELL_EDITOR_IMPL);

		this.unaryReferenceCellEditorEClass = createEClass(ModelCellEditorPackage.UNARY_REFERENCE_CELL_EDITOR);
		createEAttribute(
				this.unaryReferenceCellEditorEClass,
				ModelCellEditorPackage.UNARY_REFERENCE_CELL_EDITOR__UNARY_REFERENCE_CELL_EDITOR_IMPL);

		this.naryFeatureCellEditorEClass = createEClass(ModelCellEditorPackage.NARY_FEATURE_CELL_EDITOR);
		createEAttribute(this.naryFeatureCellEditorEClass,
				ModelCellEditorPackage.NARY_FEATURE_CELL_EDITOR__NARY_FEATURE_CELL_EDITOR_IMPL);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if (this.isInitialized) {
			return;
		}
		this.isInitialized = true;

		// Initialize package
		setName(ModelCellEditorPackage.eNAME);
		setNsPrefix(ModelCellEditorPackage.eNS_PREFIX);
		setNsURI(ModelCellEditorPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		this.basicCellEditorEClass.getESuperTypes().add(getAbstractModelCellEditor());
		this.unaryReferenceCellEditorEClass.getESuperTypes().add(getAbstractModelCellEditor());
		this.naryFeatureCellEditorEClass.getESuperTypes().add(getAbstractModelCellEditor());

		// Initialize classes and features; add operations and parameters
		initEClass(
				this.modelCellEditorDeclarationsEClass,
				ModelCellEditorDeclarations.class,
				"ModelCellEditorDeclarations", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, //$NON-NLS-1$
				EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelCellEditorDeclarations_ModelCellEditors(),
				getAbstractModelCellEditor(), null, "modelCellEditors", null, 0, -1, //$NON-NLS-1$
				ModelCellEditorDeclarations.class, !EPackageImpl.IS_TRANSIENT,
				!EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE,
				!EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE,
				EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

		initEClass(
				this.abstractModelCellEditorEClass,
				AbstractModelCellEditor.class,
				"AbstractModelCellEditor", EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(
				getAbstractModelCellEditor_CellType(),
				this.ecorePackage.getEClassifier(),
				null,
				"cellType", null, 1, 1, AbstractModelCellEditor.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, //$NON-NLS-1$
				EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE,
				EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE,
				EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
		initEAttribute(
				getAbstractModelCellEditor_CellId(),
				this.ecorePackage.getEString(),
				"cellId", //$NON-NLS-1$
				null, 1, 1, AbstractModelCellEditor.class, !EPackageImpl.IS_TRANSIENT,
				!EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE,
				!EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED,
				EPackageImpl.IS_ORDERED);

		addEOperation(this.abstractModelCellEditorEClass, this.ecorePackage.getEString(),
				"getModelCellEditorImpl", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED); //$NON-NLS-1$

		initEClass(this.basicCellEditorEClass, BasicCellEditor.class,
				"BasicCellEditor", !EPackageImpl.IS_ABSTRACT, //$NON-NLS-1$
				!EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(
				getBasicCellEditor_BasicCellEditorImpl(),
				this.ecorePackage.getEString(),
				"basicCellEditorImpl", null, 1, 1, BasicCellEditor.class, !EPackageImpl.IS_TRANSIENT, //$NON-NLS-1$
				!EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE,
				!EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED,
				EPackageImpl.IS_ORDERED);

		initEClass(this.unaryReferenceCellEditorEClass, UnaryReferenceCellEditor.class,
				"UnaryReferenceCellEditor", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, //$NON-NLS-1$
				EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnaryReferenceCellEditor_UnaryReferenceCellEditorImpl(),
				this.ecorePackage.getEString(), "unaryReferenceCellEditorImpl", null, 1, 1, //$NON-NLS-1$
				UnaryReferenceCellEditor.class, !EPackageImpl.IS_TRANSIENT,
				!EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE,
				!EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED,
				EPackageImpl.IS_ORDERED);

		initEClass(
				this.naryFeatureCellEditorEClass,
				NaryFeatureCellEditor.class,
				"NaryFeatureCellEditor", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getNaryFeatureCellEditor_NaryFeatureCellEditorImpl(),
				this.ecorePackage.getEString(), "naryFeatureCellEditorImpl", null, 1, 1, //$NON-NLS-1$
				NaryFeatureCellEditor.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE,
				EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID,
				EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

		// Create resource
		createResource(ModelCellEditorPackage.eNS_URI);
	}

} // ModelCellEditorPackageImpl
