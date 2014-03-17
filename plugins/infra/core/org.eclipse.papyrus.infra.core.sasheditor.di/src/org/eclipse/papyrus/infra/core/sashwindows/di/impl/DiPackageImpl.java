/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.infra.core.sashwindows.di.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.infra.core.sashwindows.di.AbstractPage;
import org.eclipse.papyrus.infra.core.sashwindows.di.AbstractPanel;
import org.eclipse.papyrus.infra.core.sashwindows.di.DiFactory;
import org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageList;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.core.sashwindows.di.PanelParent;
import org.eclipse.papyrus.infra.core.sashwindows.di.Position;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashModel;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashPanel;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;
import org.eclipse.papyrus.infra.core.sashwindows.di.Size;
import org.eclipse.papyrus.infra.core.sashwindows.di.TabFolder;
import org.eclipse.papyrus.infra.core.sashwindows.di.Window;

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
	private EClass panelParentEClass = null;

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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.infra.core.sashwindows.di.DiPackage#eNS_URI
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
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link DiPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DiPackage init() {
		if (isInited) return (DiPackage)EPackage.Registry.INSTANCE.getEPackage(DiPackage.eNS_URI);

		// Obtain or create and register package
		DiPackageImpl theDiPackage = (DiPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DiPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DiPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDiPackage.createPackageContents();

		// Initialize created meta-data
		theDiPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDiPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DiPackage.eNS_URI, theDiPackage);
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
	public EReference getWindow_Position() {
		return (EReference)windowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWindow_Size() {
		return (EReference)windowEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWindow_Panel() {
		return (EReference)windowEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPanelParent() {
		return panelParentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPanelParent_Children() {
		return (EReference)panelParentEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getSashPanel_SashPosition() {
		return (EAttribute)sashPanelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSashPanel_Direction() {
		return (EAttribute)sashPanelEClass.getEStructuralFeatures().get(1);
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
		createEReference(windowEClass, WINDOW__POSITION);
		createEReference(windowEClass, WINDOW__SIZE);
		createEReference(windowEClass, WINDOW__PANEL);

		panelParentEClass = createEClass(PANEL_PARENT);
		createEReference(panelParentEClass, PANEL_PARENT__CHILDREN);

		abstractPanelEClass = createEClass(ABSTRACT_PANEL);
		createEReference(abstractPanelEClass, ABSTRACT_PANEL__PARENT);

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
		booleanEDataType = createEDataType(BOOLEAN);
		floatEDataType = createEDataType(FLOAT);
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
		windowEClass.getESuperTypes().add(this.getPanelParent());
		tabFolderEClass.getESuperTypes().add(this.getAbstractPanel());
		sashPanelEClass.getESuperTypes().add(this.getAbstractPanel());
		sashPanelEClass.getESuperTypes().add(this.getPanelParent());

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
		addEParameter(op, this.getint(), "targetIndex", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(sashModelEClass, null, "insertFolder", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getTabFolder(), "folderToInsert", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getTabFolder(), "refFolder", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getint(), "refFolderSide", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(sashModelEClass, null, "movePage", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getTabFolder(), "srcParentFolder", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getint(), "srcIndex", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getTabFolder(), "targetParentFolder", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(sashModelEClass, null, "removeEmptyFolder", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getTabFolder(), "folder", 1, 1, IS_UNIQUE, !IS_ORDERED);

		addEOperation(sashModelEClass, null, "removeAllPages", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(sashModelEClass, null, "removeOtherPages", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getJavaObject(), "pageIdentifier", 1, 1, IS_UNIQUE, !IS_ORDERED);

		addEOperation(sashModelEClass, this.getWindow(), "lookupFirstWindow", 1, 1, IS_UNIQUE, !IS_ORDERED);

		addEOperation(sashModelEClass, this.getTabFolder(), "lookupFirstFolder", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(sashModelEClass, null, "removePageAndEmptyFolder", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getJavaObject(), "pageIdentifier", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(sashModelEClass, null, "setCurrentSelectionSilently", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getTabFolder(), "selection", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(windowEClass, Window.class, "Window", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWindow_Position(), this.getPosition(), null, "position", null, 1, 1, Window.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getWindow_Size(), this.getSize(), null, "size", null, 1, 1, Window.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getWindow_Panel(), this.getAbstractPanel(), null, "panel", null, 1, 1, Window.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

		initEClass(panelParentEClass, PanelParent.class, "PanelParent", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPanelParent_Children(), this.getAbstractPanel(), this.getAbstractPanel_Parent(), "children", null, 2, 2, PanelParent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(panelParentEClass, null, "replaceChild", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getAbstractPanel(), "oldChild", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getAbstractPanel(), "newChild", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(abstractPanelEClass, AbstractPanel.class, "AbstractPanel", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractPanel_Parent(), this.getPanelParent(), this.getPanelParent_Children(), "parent", null, 1, 1, AbstractPanel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(positionEClass, Position.class, "Position", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPosition_X(), this.getint(), "x", null, 1, 1, Position.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPosition_Y(), this.getint(), "y", null, 1, 1, Position.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(sizeEClass, Size.class, "Size", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSize_Width(), this.getint(), "width", null, 1, 1, Size.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSize_Length(), this.getint(), "length", null, 1, 1, Size.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(tabFolderEClass, TabFolder.class, "TabFolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTabFolder_Children(), this.getPageRef(), this.getPageRef_Parent(), "children", null, 0, -1, TabFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(tabFolderEClass, null, "movePage", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getint(), "oldIndex", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getint(), "newIndex", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(tabFolderEClass, null, "addPage", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getJavaObject(), "pageIdentifier", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(tabFolderEClass, null, "removePage", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getint(), "pageIndex", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(pageRefEClass, PageRef.class, "PageRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPageRef_EmfPageIdentifier(), theEcorePackage.getEObject(), null, "emfPageIdentifier", null, 1, 1, PageRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPageRef_PageIdentifier(), this.getJavaObject(), "pageIdentifier", null, 1, 1, PageRef.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPageRef_ObjectPageIdentifier(), this.getJavaObject(), "objectPageIdentifier", null, 1, 1, PageRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPageRef_Parent(), this.getTabFolder(), this.getTabFolder_Children(), "parent", null, 0, 1, PageRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(pageRefEClass, this.getboolean(), "isForIdentifier", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getJavaObject(), "pageIdentifier", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(sashPanelEClass, SashPanel.class, "SashPanel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSashPanel_SashPosition(), this.getFloat(), "sashPosition", null, 1, 1, SashPanel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSashPanel_Direction(), this.getint(), "direction", null, 1, 1, SashPanel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(sashPanelEClass, null, "setChildren", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getAbstractPanel(), "leftChild", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getAbstractPanel(), "rightChild", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getint(), "direction", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(sashPanelEClass, null, "delete", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getAbstractPanel(), "childToDelete", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(abstractPageEClass, AbstractPage.class, "AbstractPage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractPage_PageIdentifier(), this.getJavaObject(), "pageIdentifier", null, 1, 1, AbstractPage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(pageListEClass, PageList.class, "PageList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPageList_AvailablePage(), this.getPageRef(), null, "availablePage", null, 0, -1, PageList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(pageListEClass, null, "addPage", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getJavaObject(), "pageIdentifier", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(pageListEClass, null, "removePage", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getJavaObject(), "pageIdentifier", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(sashWindowsMngrEClass, SashWindowsMngr.class, "SashWindowsMngr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSashWindowsMngr_PageList(), this.getPageList(), null, "pageList", null, 0, 1, SashWindowsMngr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSashWindowsMngr_SashModel(), this.getSashModel(), null, "sashModel", null, 1, 1, SashWindowsMngr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize data types
		initEDataType(intEDataType, int.class, "int", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(javaObjectEDataType, Object.class, "JavaObject", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(booleanEDataType, boolean.class, "boolean", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(floatEDataType, float.class, "Float", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// resource=XMI
		createResourceXMIAnnotations();
	}

	/**
	 * Initializes the annotations for <b>resource=XMI</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createResourceXMIAnnotations() {
		String source = "resource=XMI";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
		   });
	}

} //DiPackageImpl
