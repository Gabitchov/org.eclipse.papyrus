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
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.impl.NattablePackageImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.NattableaxisPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.impl.NattableaxisPackageImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.impl.NattableaxisconfigurationPackageImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.NattableaxisproviderPackage;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.impl.NattableaxisproviderPackageImpl;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.NattablecellPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.impl.NattablecellPackageImpl;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.CellEditorDeclaration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableNamedElement;

import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.util.NattableconfigurationValidator;

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
public class NattableconfigurationPackageImpl extends EPackageImpl implements NattableconfigurationPackage {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass tableNamedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass tableConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum cellEditorDeclarationEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package
	 * package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.NattableconfigurationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private NattableconfigurationPackageImpl() {
		super(eNS_URI, NattableconfigurationFactory.eINSTANCE);
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
	 * This method is used to initialize {@link NattableconfigurationPackage#eINSTANCE} when that field is accessed. Clients should not invoke it
	 * directly. Instead, they should simply access that field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static NattableconfigurationPackage init() {
		if(isInited)
			return (NattableconfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(NattableconfigurationPackage.eNS_URI);

		// Obtain or create and register package
		NattableconfigurationPackageImpl theNattableconfigurationPackage = (NattableconfigurationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof NattableconfigurationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new NattableconfigurationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		NattablePackageImpl theNattablePackage = (NattablePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NattablePackage.eNS_URI) instanceof NattablePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NattablePackage.eNS_URI) : NattablePackage.eINSTANCE);
		NattableaxisproviderPackageImpl theNattableaxisproviderPackage = (NattableaxisproviderPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NattableaxisproviderPackage.eNS_URI) instanceof NattableaxisproviderPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NattableaxisproviderPackage.eNS_URI) : NattableaxisproviderPackage.eINSTANCE);
		NattablelabelproviderPackageImpl theNattablelabelproviderPackage = (NattablelabelproviderPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NattablelabelproviderPackage.eNS_URI) instanceof NattablelabelproviderPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NattablelabelproviderPackage.eNS_URI) : NattablelabelproviderPackage.eINSTANCE);
		NattableaxisconfigurationPackageImpl theNattableaxisconfigurationPackage = (NattableaxisconfigurationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NattableaxisconfigurationPackage.eNS_URI) instanceof NattableaxisconfigurationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NattableaxisconfigurationPackage.eNS_URI) : NattableaxisconfigurationPackage.eINSTANCE);
		NattabletesterPackageImpl theNattabletesterPackage = (NattabletesterPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NattabletesterPackage.eNS_URI) instanceof NattabletesterPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NattabletesterPackage.eNS_URI) : NattabletesterPackage.eINSTANCE);
		NattableaxisPackageImpl theNattableaxisPackage = (NattableaxisPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NattableaxisPackage.eNS_URI) instanceof NattableaxisPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NattableaxisPackage.eNS_URI) : NattableaxisPackage.eINSTANCE);
		NattablecellPackageImpl theNattablecellPackage = (NattablecellPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NattablecellPackage.eNS_URI) instanceof NattablecellPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NattablecellPackage.eNS_URI) : NattablecellPackage.eINSTANCE);
		NattableproblemPackageImpl theNattableproblemPackage = (NattableproblemPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NattableproblemPackage.eNS_URI) instanceof NattableproblemPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NattableproblemPackage.eNS_URI) : NattableproblemPackage.eINSTANCE);

		// Create package meta-data objects
		theNattableconfigurationPackage.createPackageContents();
		theNattablePackage.createPackageContents();
		theNattableaxisproviderPackage.createPackageContents();
		theNattablelabelproviderPackage.createPackageContents();
		theNattableaxisconfigurationPackage.createPackageContents();
		theNattabletesterPackage.createPackageContents();
		theNattableaxisPackage.createPackageContents();
		theNattablecellPackage.createPackageContents();
		theNattableproblemPackage.createPackageContents();

		// Initialize created meta-data
		theNattableconfigurationPackage.initializePackageContents();
		theNattablePackage.initializePackageContents();
		theNattableaxisproviderPackage.initializePackageContents();
		theNattablelabelproviderPackage.initializePackageContents();
		theNattableaxisconfigurationPackage.initializePackageContents();
		theNattabletesterPackage.initializePackageContents();
		theNattableaxisPackage.initializePackageContents();
		theNattablecellPackage.initializePackageContents();
		theNattableproblemPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put(theNattableconfigurationPackage, new EValidator.Descriptor() {

			public EValidator getEValidator() {
				return NattableconfigurationValidator.INSTANCE;
			}
		});

		// Mark meta-data to indicate it can't be changed
		theNattableconfigurationPackage.freeze();


		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(NattableconfigurationPackage.eNS_URI, theNattableconfigurationPackage);
		return theNattableconfigurationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getTableNamedElement() {
		return tableNamedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getTableNamedElement_Description() {
		return (EAttribute)tableNamedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getTableNamedElement_Name() {
		return (EAttribute)tableNamedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getTableConfiguration() {
		return tableConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getTableConfiguration_Type() {
		return (EAttribute)tableConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getTableConfiguration_IconPath() {
		return (EAttribute)tableConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getTableConfiguration_CreationTester() {
		return (EReference)tableConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getTableConfiguration_CellEditorDeclaration() {
		return (EAttribute)tableConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getTableConfiguration_RowHeaderAxisConfiguration() {
		return (EReference)tableConfigurationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getTableConfiguration_ColumnHeaderAxisConfiguration() {
		return (EReference)tableConfigurationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getTableConfiguration_ColumnAxisProviders() {
		return (EReference)tableConfigurationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getTableConfiguration_RowAxisProviders() {
		return (EReference)tableConfigurationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getTableConfiguration_DefaultRowAxisProvider() {
		return (EReference)tableConfigurationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getTableConfiguration_DefaultColumnAxisProvider() {
		return (EReference)tableConfigurationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getCellEditorDeclaration() {
		return cellEditorDeclarationEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NattableconfigurationFactory getNattableconfigurationFactory() {
		return (NattableconfigurationFactory)getEFactoryInstance();
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
		tableNamedElementEClass = createEClass(TABLE_NAMED_ELEMENT);
		createEAttribute(tableNamedElementEClass, TABLE_NAMED_ELEMENT__DESCRIPTION);
		createEAttribute(tableNamedElementEClass, TABLE_NAMED_ELEMENT__NAME);

		tableConfigurationEClass = createEClass(TABLE_CONFIGURATION);
		createEAttribute(tableConfigurationEClass, TABLE_CONFIGURATION__TYPE);
		createEAttribute(tableConfigurationEClass, TABLE_CONFIGURATION__ICON_PATH);
		createEReference(tableConfigurationEClass, TABLE_CONFIGURATION__CREATION_TESTER);
		createEAttribute(tableConfigurationEClass, TABLE_CONFIGURATION__CELL_EDITOR_DECLARATION);
		createEReference(tableConfigurationEClass, TABLE_CONFIGURATION__ROW_HEADER_AXIS_CONFIGURATION);
		createEReference(tableConfigurationEClass, TABLE_CONFIGURATION__COLUMN_HEADER_AXIS_CONFIGURATION);
		createEReference(tableConfigurationEClass, TABLE_CONFIGURATION__COLUMN_AXIS_PROVIDERS);
		createEReference(tableConfigurationEClass, TABLE_CONFIGURATION__ROW_AXIS_PROVIDERS);
		createEReference(tableConfigurationEClass, TABLE_CONFIGURATION__DEFAULT_ROW_AXIS_PROVIDER);
		createEReference(tableConfigurationEClass, TABLE_CONFIGURATION__DEFAULT_COLUMN_AXIS_PROVIDER);

		// Create enums
		cellEditorDeclarationEEnum = createEEnum(CELL_EDITOR_DECLARATION);
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
		NattabletesterPackage theNattabletesterPackage = (NattabletesterPackage)EPackage.Registry.INSTANCE.getEPackage(NattabletesterPackage.eNS_URI);
		NattableaxisconfigurationPackage theNattableaxisconfigurationPackage = (NattableaxisconfigurationPackage)EPackage.Registry.INSTANCE.getEPackage(NattableaxisconfigurationPackage.eNS_URI);
		NattableaxisproviderPackage theNattableaxisproviderPackage = (NattableaxisproviderPackage)EPackage.Registry.INSTANCE.getEPackage(NattableaxisproviderPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		tableNamedElementEClass.getESuperTypes().add(ecorePackage.getEModelElement());
		tableConfigurationEClass.getESuperTypes().add(this.getTableNamedElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(tableNamedElementEClass, TableNamedElement.class, "TableNamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getTableNamedElement_Description(), ecorePackage.getEString(), "description", null, 0, 1, TableNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTableNamedElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, TableNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(tableConfigurationEClass, TableConfiguration.class, "TableConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getTableConfiguration_Type(), ecorePackage.getEString(), "type", null, 1, 1, TableConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTableConfiguration_IconPath(), ecorePackage.getEString(), "iconPath", null, 0, 1, TableConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTableConfiguration_CreationTester(), theNattabletesterPackage.getAbstractTableTester(), null, "creationTester", null, 0, 1, TableConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTableConfiguration_CellEditorDeclaration(), this.getCellEditorDeclaration(), "cellEditorDeclaration", "COLUMN", 1, 1, TableConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEReference(getTableConfiguration_RowHeaderAxisConfiguration(), theNattableaxisconfigurationPackage.getTableHeaderAxisConfiguration(), null, "rowHeaderAxisConfiguration", null, 1, 1, TableConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTableConfiguration_ColumnHeaderAxisConfiguration(), theNattableaxisconfigurationPackage.getTableHeaderAxisConfiguration(), null, "columnHeaderAxisConfiguration", null, 1, 1, TableConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTableConfiguration_ColumnAxisProviders(), theNattableaxisproviderPackage.getAbstractAxisProvider(), null, "columnAxisProviders", null, 1, -1, TableConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTableConfiguration_RowAxisProviders(), theNattableaxisproviderPackage.getAbstractAxisProvider(), null, "rowAxisProviders", null, 1, -1, TableConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTableConfiguration_DefaultRowAxisProvider(), theNattableaxisproviderPackage.getAbstractAxisProvider(), null, "defaultRowAxisProvider", null, 1, 1, TableConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTableConfiguration_DefaultColumnAxisProvider(), theNattableaxisproviderPackage.getAbstractAxisProvider(), null, "defaultColumnAxisProvider", null, 1, 1, TableConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(cellEditorDeclarationEEnum, CellEditorDeclaration.class, "CellEditorDeclaration"); //$NON-NLS-1$
		addEEnumLiteral(cellEditorDeclarationEEnum, CellEditorDeclaration.COLUMN);
		addEEnumLiteral(cellEditorDeclarationEEnum, CellEditorDeclaration.ROW);
		addEEnumLiteral(cellEditorDeclarationEEnum, CellEditorDeclaration.CELL);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
		createPivotAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore"; //$NON-NLS-1$		
		addAnnotation(this, source, new String[]{ "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot", //$NON-NLS-1$ //$NON-NLS-2$
		"settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot", //$NON-NLS-1$ //$NON-NLS-2$
		"validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot" //$NON-NLS-1$ //$NON-NLS-2$
		});
		addAnnotation(tableConfigurationEClass, source, new String[]{ "constraints", "defaultRowAxisProviderExistsInCollection defaultColumnAxisProviderExistsInCollection" //$NON-NLS-1$ //$NON-NLS-2$
		});
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void createPivotAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot"; //$NON-NLS-1$							
		addAnnotation(tableConfigurationEClass, source, new String[]{ "defaultRowAxisProviderExistsInCollection", "rowAxisProviders->includes(defaultRowAxisProvider)", //$NON-NLS-1$ //$NON-NLS-2$
		"defaultColumnAxisProviderExistsInCollection", "columnAxisProviders->includes(defaultColumnAxisProvider)" //$NON-NLS-1$ //$NON-NLS-2$
		});
	}

} //NattableconfigurationPackageImpl
