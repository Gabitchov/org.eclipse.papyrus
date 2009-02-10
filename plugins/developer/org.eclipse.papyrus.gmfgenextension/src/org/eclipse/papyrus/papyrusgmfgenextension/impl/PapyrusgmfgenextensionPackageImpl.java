/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.papyrusgmfgenextension.impl;

import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;

import org.eclipse.papyrus.papyrusgmfgenextension.AlternateCanvas;
import org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenLink;
import org.eclipse.papyrus.papyrusgmfgenextension.AlternateGenTopLevelNode;
import org.eclipse.papyrus.papyrusgmfgenextension.CommentedElement;
import org.eclipse.papyrus.papyrusgmfgenextension.ExtendedGenNode;
import org.eclipse.papyrus.papyrusgmfgenextension.ExternalHook;
import org.eclipse.papyrus.papyrusgmfgenextension.MutatingCanvas;
import org.eclipse.papyrus.papyrusgmfgenextension.PapyrusExtensionRootNode;
import org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionFactory;
import org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage;
import org.eclipse.papyrus.papyrusgmfgenextension.PropertyRefreshHook;
import org.eclipse.papyrus.papyrusgmfgenextension.SpecificLocator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PapyrusgmfgenextensionPackageImpl extends EPackageImpl implements PapyrusgmfgenextensionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extendedGenNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commentedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyRefreshHookEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalHookEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specificLocatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass papyrusExtensionRootNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass alternateCanvasEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass alternateGenTopLevelNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass alternateGenLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mutatingCanvasEClass = null;

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
	 * @see org.eclipse.papyrus.papyrusgmfgenextension.PapyrusgmfgenextensionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PapyrusgmfgenextensionPackageImpl() {
		super(eNS_URI, PapyrusgmfgenextensionFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PapyrusgmfgenextensionPackage init() {
		if (isInited) return (PapyrusgmfgenextensionPackage)EPackage.Registry.INSTANCE.getEPackage(PapyrusgmfgenextensionPackage.eNS_URI);

		// Obtain or create and register package
		PapyrusgmfgenextensionPackageImpl thePapyrusgmfgenextensionPackage = (PapyrusgmfgenextensionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof PapyrusgmfgenextensionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new PapyrusgmfgenextensionPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		GMFGenPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		thePapyrusgmfgenextensionPackage.createPackageContents();

		// Initialize created meta-data
		thePapyrusgmfgenextensionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePapyrusgmfgenextensionPackage.freeze();

		return thePapyrusgmfgenextensionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtendedGenNode() {
		return extendedGenNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendedGenNode_GenNode() {
		return (EReference)extendedGenNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendedGenNode_IsAbstract() {
		return (EAttribute)extendedGenNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendedGenNode_SuperGenNodes() {
		return (EReference)extendedGenNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendedGenNode_PropRefreshHook() {
		return (EReference)extendedGenNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendedGenNode_Name() {
		return (EAttribute)extendedGenNodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommentedElement() {
		return commentedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommentedElement_Comment() {
		return (EAttribute)commentedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyRefreshHook() {
		return propertyRefreshHookEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyRefreshHook_TriggeringCondition() {
		return (EAttribute)propertyRefreshHookEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyRefreshHook_Action() {
		return (EAttribute)propertyRefreshHookEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalHook() {
		return externalHookEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExternalHook_Classpath() {
		return (EAttribute)externalHookEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpecificLocator() {
		return specificLocatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificLocator_GenChildSideAffixedNode() {
		return (EReference)specificLocatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPapyrusExtensionRootNode() {
		return papyrusExtensionRootNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPapyrusExtensionRootNode_ExtensionNodes() {
		return (EReference)papyrusExtensionRootNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAlternateCanvas() {
		return alternateCanvasEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlternateCanvas_DomainDiagramElement() {
		return (EReference)alternateCanvasEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlternateCanvas_AlternateTopLevelNodes() {
		return (EReference)alternateCanvasEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlternateCanvas_AlternateLinkNodes() {
		return (EReference)alternateCanvasEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlternateCanvas_Diagram() {
		return (EReference)alternateCanvasEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAlternateGenTopLevelNode() {
		return alternateGenTopLevelNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlternateGenTopLevelNode_GenTopLevelNode() {
		return (EReference)alternateGenTopLevelNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlternateGenTopLevelNode_TypeModelFacet() {
		return (EReference)alternateGenTopLevelNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAlternateGenLink() {
		return alternateGenLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlternateGenLink_GenLinkNode() {
		return (EReference)alternateGenLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlternateGenLink_TypeModelFacet() {
		return (EReference)alternateGenLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMutatingCanvas() {
		return mutatingCanvasEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMutatingCanvas_AlternateCanvases() {
		return (EReference)mutatingCanvasEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PapyrusgmfgenextensionFactory getPapyrusgmfgenextensionFactory() {
		return (PapyrusgmfgenextensionFactory)getEFactoryInstance();
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
		extendedGenNodeEClass = createEClass(EXTENDED_GEN_NODE);
		createEReference(extendedGenNodeEClass, EXTENDED_GEN_NODE__GEN_NODE);
		createEAttribute(extendedGenNodeEClass, EXTENDED_GEN_NODE__IS_ABSTRACT);
		createEReference(extendedGenNodeEClass, EXTENDED_GEN_NODE__SUPER_GEN_NODES);
		createEReference(extendedGenNodeEClass, EXTENDED_GEN_NODE__PROP_REFRESH_HOOK);
		createEAttribute(extendedGenNodeEClass, EXTENDED_GEN_NODE__NAME);

		commentedElementEClass = createEClass(COMMENTED_ELEMENT);
		createEAttribute(commentedElementEClass, COMMENTED_ELEMENT__COMMENT);

		propertyRefreshHookEClass = createEClass(PROPERTY_REFRESH_HOOK);
		createEAttribute(propertyRefreshHookEClass, PROPERTY_REFRESH_HOOK__TRIGGERING_CONDITION);
		createEAttribute(propertyRefreshHookEClass, PROPERTY_REFRESH_HOOK__ACTION);

		externalHookEClass = createEClass(EXTERNAL_HOOK);
		createEAttribute(externalHookEClass, EXTERNAL_HOOK__CLASSPATH);

		specificLocatorEClass = createEClass(SPECIFIC_LOCATOR);
		createEReference(specificLocatorEClass, SPECIFIC_LOCATOR__GEN_CHILD_SIDE_AFFIXED_NODE);

		papyrusExtensionRootNodeEClass = createEClass(PAPYRUS_EXTENSION_ROOT_NODE);
		createEReference(papyrusExtensionRootNodeEClass, PAPYRUS_EXTENSION_ROOT_NODE__EXTENSION_NODES);

		alternateCanvasEClass = createEClass(ALTERNATE_CANVAS);
		createEReference(alternateCanvasEClass, ALTERNATE_CANVAS__DOMAIN_DIAGRAM_ELEMENT);
		createEReference(alternateCanvasEClass, ALTERNATE_CANVAS__ALTERNATE_TOP_LEVEL_NODES);
		createEReference(alternateCanvasEClass, ALTERNATE_CANVAS__ALTERNATE_LINK_NODES);
		createEReference(alternateCanvasEClass, ALTERNATE_CANVAS__DIAGRAM);

		alternateGenTopLevelNodeEClass = createEClass(ALTERNATE_GEN_TOP_LEVEL_NODE);
		createEReference(alternateGenTopLevelNodeEClass, ALTERNATE_GEN_TOP_LEVEL_NODE__GEN_TOP_LEVEL_NODE);
		createEReference(alternateGenTopLevelNodeEClass, ALTERNATE_GEN_TOP_LEVEL_NODE__TYPE_MODEL_FACET);

		alternateGenLinkEClass = createEClass(ALTERNATE_GEN_LINK);
		createEReference(alternateGenLinkEClass, ALTERNATE_GEN_LINK__GEN_LINK_NODE);
		createEReference(alternateGenLinkEClass, ALTERNATE_GEN_LINK__TYPE_MODEL_FACET);

		mutatingCanvasEClass = createEClass(MUTATING_CANVAS);
		createEReference(mutatingCanvasEClass, MUTATING_CANVAS__ALTERNATE_CANVASES);
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
		GMFGenPackage theGMFGenPackage = (GMFGenPackage)EPackage.Registry.INSTANCE.getEPackage(GMFGenPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		GenModelPackage theGenModelPackage = (GenModelPackage)EPackage.Registry.INSTANCE.getEPackage(GenModelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		extendedGenNodeEClass.getESuperTypes().add(this.getCommentedElement());
		propertyRefreshHookEClass.getESuperTypes().add(this.getExternalHook());
		externalHookEClass.getESuperTypes().add(this.getCommentedElement());
		specificLocatorEClass.getESuperTypes().add(this.getExternalHook());
		papyrusExtensionRootNodeEClass.getESuperTypes().add(this.getCommentedElement());
		alternateCanvasEClass.getESuperTypes().add(this.getCommentedElement());
		alternateGenTopLevelNodeEClass.getESuperTypes().add(this.getCommentedElement());
		alternateGenLinkEClass.getESuperTypes().add(this.getCommentedElement());
		mutatingCanvasEClass.getESuperTypes().add(this.getCommentedElement());

		// Initialize classes and features; add operations and parameters
		initEClass(extendedGenNodeEClass, ExtendedGenNode.class, "ExtendedGenNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExtendedGenNode_GenNode(), theGMFGenPackage.getGenCommonBase(), null, "genNode", null, 1, -1, ExtendedGenNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getExtendedGenNode_IsAbstract(), ecorePackage.getEBoolean(), "isAbstract", null, 1, 1, ExtendedGenNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExtendedGenNode_SuperGenNodes(), theGMFGenPackage.getGenCommonBase(), null, "superGenNodes", null, 0, -1, ExtendedGenNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExtendedGenNode_PropRefreshHook(), this.getPropertyRefreshHook(), null, "propRefreshHook", null, 0, 1, ExtendedGenNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getExtendedGenNode_Name(), theEcorePackage.getEString(), "name", null, 0, 1, ExtendedGenNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(commentedElementEClass, CommentedElement.class, "CommentedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCommentedElement_Comment(), ecorePackage.getEString(), "comment", null, 1, 1, CommentedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(propertyRefreshHookEClass, PropertyRefreshHook.class, "PropertyRefreshHook", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPropertyRefreshHook_TriggeringCondition(), ecorePackage.getEString(), "triggeringCondition", null, 1, 1, PropertyRefreshHook.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPropertyRefreshHook_Action(), ecorePackage.getEString(), "action", null, 1, 1, PropertyRefreshHook.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(externalHookEClass, ExternalHook.class, "ExternalHook", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExternalHook_Classpath(), ecorePackage.getEString(), "classpath", null, 0, 1, ExternalHook.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(specificLocatorEClass, SpecificLocator.class, "SpecificLocator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpecificLocator_GenChildSideAffixedNode(), theGMFGenPackage.getGenChildSideAffixedNode(), null, "genChildSideAffixedNode", null, 0, 1, SpecificLocator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(papyrusExtensionRootNodeEClass, PapyrusExtensionRootNode.class, "PapyrusExtensionRootNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPapyrusExtensionRootNode_ExtensionNodes(), this.getExtendedGenNode(), null, "extensionNodes", null, 0, -1, PapyrusExtensionRootNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(alternateCanvasEClass, AlternateCanvas.class, "AlternateCanvas", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAlternateCanvas_DomainDiagramElement(), theGenModelPackage.getGenClass(), null, "domainDiagramElement", null, 1, 1, AlternateCanvas.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAlternateCanvas_AlternateTopLevelNodes(), this.getAlternateGenTopLevelNode(), null, "alternateTopLevelNodes", null, 0, -1, AlternateCanvas.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAlternateCanvas_AlternateLinkNodes(), this.getAlternateGenLink(), null, "alternateLinkNodes", null, 0, -1, AlternateCanvas.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAlternateCanvas_Diagram(), theGMFGenPackage.getGenDiagram(), null, "diagram", null, 1, 1, AlternateCanvas.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(alternateGenTopLevelNodeEClass, AlternateGenTopLevelNode.class, "AlternateGenTopLevelNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAlternateGenTopLevelNode_GenTopLevelNode(), theGMFGenPackage.getGenTopLevelNode(), null, "genTopLevelNode", null, 1, 1, AlternateGenTopLevelNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAlternateGenTopLevelNode_TypeModelFacet(), theGMFGenPackage.getTypeModelFacet(), null, "typeModelFacet", null, 1, 1, AlternateGenTopLevelNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(alternateGenLinkEClass, AlternateGenLink.class, "AlternateGenLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAlternateGenLink_GenLinkNode(), theGMFGenPackage.getGenLink(), null, "genLinkNode", null, 1, 1, AlternateGenLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAlternateGenLink_TypeModelFacet(), theGMFGenPackage.getTypeModelFacet(), null, "typeModelFacet", null, 1, 1, AlternateGenLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mutatingCanvasEClass, MutatingCanvas.class, "MutatingCanvas", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMutatingCanvas_AlternateCanvases(), this.getAlternateCanvas(), null, "alternateCanvases", null, 0, -1, MutatingCanvas.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //PapyrusgmfgenextensionPackageImpl
