/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.diagramtemplate.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.diagramtemplate.AbstractSelection;
import org.eclipse.papyrus.diagramtemplate.DiagramDefinition;
import org.eclipse.papyrus.diagramtemplate.DiagramTemplateFactory;
import org.eclipse.papyrus.diagramtemplate.DiagramTemplatePackage;
import org.eclipse.papyrus.diagramtemplate.Selection;
import org.eclipse.papyrus.diagramtemplate.SelectionKind;
import org.eclipse.papyrus.diagramtemplate.SelectionRef;
import org.eclipse.papyrus.diagramtemplate.Template;
import org.eclipse.papyrus.diagramtemplate.diagramtemplate.AbstractSelection;
import org.eclipse.papyrus.diagramtemplate.diagramtemplate.DiagramDefinition;
import org.eclipse.papyrus.diagramtemplate.diagramtemplate.DiagramTemplateFactory;
import org.eclipse.papyrus.diagramtemplate.diagramtemplate.DiagramTemplatePackage;
import org.eclipse.papyrus.diagramtemplate.diagramtemplate.Selection;
import org.eclipse.papyrus.diagramtemplate.diagramtemplate.SelectionKind;
import org.eclipse.papyrus.diagramtemplate.diagramtemplate.SelectionRef;
import org.eclipse.papyrus.diagramtemplate.diagramtemplate.Template;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DiagramTemplatePackageImpl extends EPackageImpl implements DiagramTemplatePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass diagramDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selectionRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractSelectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum selectionKindEEnum = null;

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
	 * @see org.eclipse.papyrus.diagramtemplate.DiagramTemplatePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DiagramTemplatePackageImpl() {
		super(eNS_URI, DiagramTemplateFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DiagramTemplatePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DiagramTemplatePackage init() {
		if (isInited) return (DiagramTemplatePackage)EPackage.Registry.INSTANCE.getEPackage(DiagramTemplatePackage.eNS_URI);

		// Obtain or create and register package
		DiagramTemplatePackageImpl theDiagramTemplatePackage = (DiagramTemplatePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DiagramTemplatePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DiagramTemplatePackageImpl());

		isInited = true;

		// Create package meta-data objects
		theDiagramTemplatePackage.createPackageContents();

		// Initialize created meta-data
		theDiagramTemplatePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDiagramTemplatePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DiagramTemplatePackage.eNS_URI, theDiagramTemplatePackage);
		return theDiagramTemplatePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiagramDefinition() {
		return diagramDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiagramDefinition_Description() {
		return (EAttribute)diagramDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDiagramDefinition_FromRoot() {
		return (EReference)diagramDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDiagramDefinition_Selection() {
		return (EReference)diagramDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiagramDefinition_DiagramKind() {
		return (EAttribute)diagramDefinitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiagramDefinition_LayoutToApply() {
		return (EAttribute)diagramDefinitionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiagramDefinition_Name() {
		return (EAttribute)diagramDefinitionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDiagramDefinition_Prefix() {
		return (EAttribute)diagramDefinitionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSelection() {
		return selectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSelection_Recursively() {
		return (EAttribute)selectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSelectionRef() {
		return selectionRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSelectionRef_EReference() {
		return (EReference)selectionRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplate() {
		return templateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplate_DiagramDefinitions() {
		return (EReference)templateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplate_TargetRoot() {
		return (EReference)templateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractSelection() {
		return abstractSelectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractSelection_Element() {
		return (EReference)abstractSelectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSelection_Kind() {
		return (EAttribute)abstractSelectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractSelection_SelectionRef() {
		return (EReference)abstractSelectionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSelection_SubTypes() {
		return (EAttribute)abstractSelectionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractSelection_StereotypedBy() {
		return (EAttribute)abstractSelectionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSelectionKind() {
		return selectionKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramTemplateFactory getDiagramTemplateFactory() {
		return (DiagramTemplateFactory)getEFactoryInstance();
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
		diagramDefinitionEClass = createEClass(DIAGRAM_DEFINITION);
		createEAttribute(diagramDefinitionEClass, DIAGRAM_DEFINITION__DESCRIPTION);
		createEReference(diagramDefinitionEClass, DIAGRAM_DEFINITION__FROM_ROOT);
		createEReference(diagramDefinitionEClass, DIAGRAM_DEFINITION__SELECTION);
		createEAttribute(diagramDefinitionEClass, DIAGRAM_DEFINITION__DIAGRAM_KIND);
		createEAttribute(diagramDefinitionEClass, DIAGRAM_DEFINITION__LAYOUT_TO_APPLY);
		createEAttribute(diagramDefinitionEClass, DIAGRAM_DEFINITION__NAME);
		createEAttribute(diagramDefinitionEClass, DIAGRAM_DEFINITION__PREFIX);

		selectionEClass = createEClass(SELECTION);
		createEAttribute(selectionEClass, SELECTION__RECURSIVELY);

		selectionRefEClass = createEClass(SELECTION_REF);
		createEReference(selectionRefEClass, SELECTION_REF__EREFERENCE);

		templateEClass = createEClass(TEMPLATE);
		createEReference(templateEClass, TEMPLATE__DIAGRAM_DEFINITIONS);
		createEReference(templateEClass, TEMPLATE__TARGET_ROOT);

		abstractSelectionEClass = createEClass(ABSTRACT_SELECTION);
		createEReference(abstractSelectionEClass, ABSTRACT_SELECTION__ELEMENT);
		createEAttribute(abstractSelectionEClass, ABSTRACT_SELECTION__KIND);
		createEReference(abstractSelectionEClass, ABSTRACT_SELECTION__SELECTION_REF);
		createEAttribute(abstractSelectionEClass, ABSTRACT_SELECTION__SUB_TYPES);
		createEAttribute(abstractSelectionEClass, ABSTRACT_SELECTION__STEREOTYPED_BY);

		// Create enums
		selectionKindEEnum = createEEnum(SELECTION_KIND);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		selectionEClass.getESuperTypes().add(this.getAbstractSelection());
		selectionRefEClass.getESuperTypes().add(this.getAbstractSelection());

		// Initialize classes and features; add operations and parameters
		initEClass(diagramDefinitionEClass, DiagramDefinition.class, "DiagramDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDiagramDefinition_Description(), ecorePackage.getEString(), "description", null, 1, 1, DiagramDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDiagramDefinition_FromRoot(), ecorePackage.getEObject(), null, "fromRoot", null, 0, 1, DiagramDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDiagramDefinition_Selection(), this.getSelection(), null, "selection", null, 0, -1, DiagramDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagramDefinition_DiagramKind(), ecorePackage.getEString(), "diagramKind", null, 0, 1, DiagramDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagramDefinition_LayoutToApply(), ecorePackage.getEString(), "layoutToApply", null, 0, 1, DiagramDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagramDefinition_Name(), ecorePackage.getEString(), "name", null, 1, 1, DiagramDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagramDefinition_Prefix(), ecorePackage.getEString(), "prefix", null, 1, 1, DiagramDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(selectionEClass, Selection.class, "Selection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSelection_Recursively(), ecorePackage.getEBoolean(), "recursively", null, 1, 1, Selection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(selectionRefEClass, SelectionRef.class, "SelectionRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSelectionRef_EReference(), ecorePackage.getEObject(), null, "eReference", null, 0, 1, SelectionRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(templateEClass, Template.class, "Template", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTemplate_DiagramDefinitions(), this.getDiagramDefinition(), null, "diagramDefinitions", null, 0, -1, Template.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTemplate_TargetRoot(), ecorePackage.getEObject(), null, "targetRoot", null, 0, 1, Template.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractSelectionEClass, AbstractSelection.class, "AbstractSelection", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractSelection_Element(), ecorePackage.getEObject(), null, "element", null, 0, 1, AbstractSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSelection_Kind(), this.getSelectionKind(), "kind", null, 1, 1, AbstractSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractSelection_SelectionRef(), this.getSelectionRef(), null, "selectionRef", null, 0, -1, AbstractSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSelection_SubTypes(), ecorePackage.getEBoolean(), "subTypes", null, 1, 1, AbstractSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractSelection_StereotypedBy(), ecorePackage.getEString(), "stereotypedBy", null, 1, 1, AbstractSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(selectionKindEEnum, SelectionKind.class, "SelectionKind");
		addEEnumLiteral(selectionKindEEnum, SelectionKind.FOR_ALL);
		addEEnumLiteral(selectionKindEEnum, SelectionKind.SPECIFIC);
		addEEnumLiteral(selectionKindEEnum, SelectionKind.QUERY);

		// Create resource
		createResource(eNS_URI);
	}

} //DiagramTemplatePackageImpl
