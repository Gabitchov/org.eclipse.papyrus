/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.sashwindows.di.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.sashwindows.di.AbstractNode;
import org.eclipse.papyrus.sashwindows.di.AbstractPage;
import org.eclipse.papyrus.sashwindows.di.AbstractPanel;
import org.eclipse.papyrus.sashwindows.di.DiFactory;
import org.eclipse.papyrus.sashwindows.di.DiPackage;
import org.eclipse.papyrus.sashwindows.di.PageList;
import org.eclipse.papyrus.sashwindows.di.PageRef;
import org.eclipse.papyrus.sashwindows.di.Position;
import org.eclipse.papyrus.sashwindows.di.SashModel;
import org.eclipse.papyrus.sashwindows.di.SashPanel;
import org.eclipse.papyrus.sashwindows.di.SashWindowsMngr;
import org.eclipse.papyrus.sashwindows.di.Size;
import org.eclipse.papyrus.sashwindows.di.TabFolder;
import org.eclipse.papyrus.sashwindows.di.Window;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DiPackageImpl extends EPackageImpl implements DiPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sashModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass windowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractPanelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass positionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sizeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tabFolderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pageRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sashPanelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractPageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pageListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sashWindowsMngrEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType intEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType javaObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType floatEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType booleanEDataType = null;

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
	 * @see org.eclipse.papyrus.sashwindows.di.DiPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DiPackageImpl() {
		super(eNS_URI, DiFactory.eINSTANCE);
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
	public static DiPackage init() {
		if (isInited) return (DiPackage)EPackage.Registry.INSTANCE.getEPackage(DiPackage.eNS_URI);

		// Obtain or create and register package
		DiPackageImpl theDiPackage = (DiPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof DiPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new DiPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDiPackage.createPackageContents();

		// Initialize created meta-data
		theDiPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDiPackage.freeze();

		return theDiPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSashModel() {
		return sashModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSashModel_Windows() {
		return (EReference)sashModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSashModel_CurrentSelection() {
		return (EReference)sashModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWindow() {
		return windowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWindow_Panel() {
		return (EReference)windowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWindow_Position() {
		return (EReference)windowEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWindow_Size() {
		return (EReference)windowEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractNode() {
		return abstractNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractPanel() {
		return abstractPanelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractPanel_Parent() {
		return (EReference)abstractPanelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractPanel_Window() {
		return (EReference)abstractPanelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPosition() {
		return positionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPosition_X() {
		return (EAttribute)positionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPosition_Y() {
		return (EAttribute)positionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSize() {
		return sizeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSize_Width() {
		return (EAttribute)sizeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSize_Length() {
		return (EAttribute)sizeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTabFolder() {
		return tabFolderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTabFolder_Children() {
		return (EReference)tabFolderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPageRef() {
		return pageRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPageRef_EmfPageIdentifier() {
		return (EReference)pageRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPageRef_PageIdentifier() {
		return (EAttribute)pageRefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPageRef_ObjectPageIdentifier() {
		return (EAttribute)pageRefEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPageRef_Parent() {
		return (EReference)pageRefEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSashPanel() {
		return sashPanelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSashPanel_Children() {
		return (EReference)sashPanelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSashPanel_SashPosition() {
		return (EAttribute)sashPanelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSashPanel_Direction() {
		return (EAttribute)sashPanelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractPage() {
		return abstractPageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractPage_PageIdentifier() {
		return (EAttribute)abstractPageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPageList() {
		return pageListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPageList_AvailablePage() {
		return (EReference)pageListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSashWindowsMngr() {
		return sashWindowsMngrEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSashWindowsMngr_PageList() {
		return (EReference)sashWindowsMngrEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSashWindowsMngr_SashModel() {
		return (EReference)sashWindowsMngrEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getint() {
		return intEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getJavaObject() {
		return javaObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getFloat() {
		return floatEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getboolean() {
		return booleanEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiFactory getDiFactory() {
		return (DiFactory)getEFactoryInstance();
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
		sashModelEClass = createEClass(SASH_MODEL);
		createEReference(sashModelEClass, SASH_MODEL__WINDOWS);
		createEReference(sashModelEClass, SASH_MODEL__CURRENT_SELECTION);

		windowEClass = createEClass(WINDOW);
		createEReference(windowEClass, WINDOW__PANEL);
		createEReference(windowEClass, WINDOW__POSITION);
		createEReference(windowEClass, WINDOW__SIZE);

		abstractNodeEClass = createEClass(ABSTRACT_NODE);

		abstractPanelEClass = createEClass(ABSTRACT_PANEL);
		createEReference(abstractPanelEClass, ABSTRACT_PANEL__PARENT);
		createEReference(abstractPanelEClass, ABSTRACT_PANEL__WINDOW);

		positionEClass = createEClass(POSITION);
		createEAttribute(positionEClass, POSITION__X);
		createEAttribute(positionEClass, POSITION__Y);

		sizeEClass = createEClass(SIZE);
		createEAttribute(sizeEClass, SIZE__WIDTH);
		createEAttribute(sizeEClass, SIZE__LENGTH);

		tabFolderEClass = createEClass(TAB_FOLDER);
		createEReference(tabFolderEClass, TAB_FOLDER__CHILDREN);

		pageRefEClass = createEClass(PAGE_REF);
		createEReference(pageRefEClass, PAGE_REF__EMF_PAGE_IDENTIFIER);
		createEAttribute(pageRefEClass, PAGE_REF__PAGE_IDENTIFIER);
		createEAttribute(pageRefEClass, PAGE_REF__OBJECT_PAGE_IDENTIFIER);
		createEReference(pageRefEClass, PAGE_REF__PARENT);

		sashPanelEClass = createEClass(SASH_PANEL);
		createEReference(sashPanelEClass, SASH_PANEL__CHILDREN);
		createEAttribute(sashPanelEClass, SASH_PANEL__SASH_POSITION);
		createEAttribute(sashPanelEClass, SASH_PANEL__DIRECTION);

		abstractPageEClass = createEClass(ABSTRACT_PAGE);
		createEAttribute(abstractPageEClass, ABSTRACT_PAGE__PAGE_IDENTIFIER);

		pageListEClass = createEClass(PAGE_LIST);
		createEReference(pageListEClass, PAGE_LIST__AVAILABLE_PAGE);

		sashWindowsMngrEClass = createEClass(SASH_WINDOWS_MNGR);
		createEReference(sashWindowsMngrEClass, SASH_WINDOWS_MNGR__PAGE_LIST);
		createEReference(sashWindowsMngrEClass, SASH_WINDOWS_MNGR__SASH_MODEL);

		// Create data types
		intEDataType = createEDataType(INT);
		javaObjectEDataType = createEDataType(JAVA_OBJECT);
		floatEDataType = createEDataType(FLOAT);
		booleanEDataType = createEDataType(BOOLEAN);
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
		windowEClass.getESuperTypes().add(this.getAbstractNode());
		abstractPanelEClass.getESuperTypes().add(this.getAbstractNode());
		tabFolderEClass.getESuperTypes().add(this.getAbstractPanel());
		sashPanelEClass.getESuperTypes().add(this.getAbstractPanel());

		// Initialize classes and features; add operations and parameters
		initEClass(sashModelEClass, SashModel.class, "SashModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSashModel_Windows(), this.getWindow(), null, "windows", null, 0, -1, SashModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSashModel_CurrentSelection(), this.getTabFolder(), null, "currentSelection", null, 1, 1, SashModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = addEOperation(sashModelEClass, null, "addPage", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getJavaObject(), "pageIdentifier", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(sashModelEClass, null, "removePage", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getJavaObject(), "pageIdentifier", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(sashModelEClass, this.getPageRef(), "lookupPage", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getJavaObject(), "pageIdentifier", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(sashModelEClass, null, "movePage", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getTabFolder(), "srcParentFolder", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getint(), "srcIndex", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getTabFolder(), "targetParentFolder", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "targetIndex", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(windowEClass, Window.class, "Window", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWindow_Panel(), this.getAbstractPanel(), this.getAbstractPanel_Window(), "panel", null, 1, 1, Window.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getWindow_Position(), this.getPosition(), null, "position", null, 1, 1, Window.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getWindow_Size(), this.getSize(), null, "size", null, 1, 1, Window.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(abstractNodeEClass, AbstractNode.class, "AbstractNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(abstractPanelEClass, AbstractPanel.class, "AbstractPanel", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractPanel_Parent(), this.getAbstractNode(), null, "parent", null, 1, 1, AbstractPanel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAbstractPanel_Window(), this.getWindow(), this.getWindow_Panel(), "window", null, 1, 1, AbstractPanel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(positionEClass, Position.class, "Position", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPosition_X(), ecorePackage.getEInt(), "x", null, 1, 1, Position.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPosition_Y(), this.getint(), "y", null, 1, 1, Position.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(sizeEClass, Size.class, "Size", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSize_Width(), this.getint(), "width", null, 1, 1, Size.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSize_Length(), this.getint(), "length", null, 1, 1, Size.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(tabFolderEClass, TabFolder.class, "TabFolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTabFolder_Children(), this.getPageRef(), this.getPageRef_Parent(), "children", null, 0, -1, TabFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(tabFolderEClass, null, "movePage", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "oldIndex", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getint(), "newIndex", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(tabFolderEClass, null, "addPage", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getJavaObject(), "pageIdentifier", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(tabFolderEClass, null, "removePage", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getint(), "pageIndex", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(pageRefEClass, PageRef.class, "PageRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPageRef_EmfPageIdentifier(), theEcorePackage.getEObject(), null, "emfPageIdentifier", null, 1, 1, PageRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPageRef_PageIdentifier(), this.getJavaObject(), "pageIdentifier", null, 1, 1, PageRef.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPageRef_ObjectPageIdentifier(), this.getJavaObject(), "objectPageIdentifier", null, 1, 1, PageRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPageRef_Parent(), this.getTabFolder(), this.getTabFolder_Children(), "parent", null, 1, 1, PageRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(pageRefEClass, ecorePackage.getEBoolean(), "isForIdentifier", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getJavaObject(), "pageIdentifier", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(sashPanelEClass, SashPanel.class, "SashPanel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSashPanel_Children(), this.getAbstractPanel(), null, "children", null, 2, 2, SashPanel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSashPanel_SashPosition(), this.getFloat(), "sashPosition", null, 1, 1, SashPanel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSashPanel_Direction(), ecorePackage.getEInt(), "direction", null, 1, 1, SashPanel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(abstractPageEClass, AbstractPage.class, "AbstractPage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractPage_PageIdentifier(), this.getJavaObject(), "pageIdentifier", null, 1, 1, AbstractPage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(pageListEClass, PageList.class, "PageList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPageList_AvailablePage(), this.getPageRef(), null, "availablePage", null, 0, -1, PageList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(pageListEClass, null, "addPage", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getJavaObject(), "pageIdentifier", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(pageListEClass, null, "removePage", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getJavaObject(), "pageIdentifier", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(sashWindowsMngrEClass, SashWindowsMngr.class, "SashWindowsMngr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSashWindowsMngr_PageList(), this.getPageList(), null, "pageList", null, 1, 1, SashWindowsMngr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSashWindowsMngr_SashModel(), this.getSashModel(), null, "sashModel", null, 1, 1, SashWindowsMngr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize data types
		initEDataType(intEDataType, int.class, "int", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(javaObjectEDataType, Object.class, "JavaObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(floatEDataType, float.class, "Float", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(booleanEDataType, boolean.class, "boolean", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //DiPackageImpl
