/**
 *  Copyright (c) 2012 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] New customization meta-model
 *  
 *  
 */
package org.eclipse.emf.facet.custom.metamodel.v0_2_0.custompt.impl;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.facet.custom.metamodel.custompt.IColor;
import org.eclipse.emf.facet.custom.metamodel.custompt.IImage;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custompt.Alignment;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custompt.CustomptFactory;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custompt.CustomptPackage;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custompt.Shadow;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CustomptPackageImpl extends EPackageImpl implements CustomptPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum shadowEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum alignmentEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType imageEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType colorEDataType = null;

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
	 * @see org.eclipse.emf.facet.custom.metamodel.v0_2_0.custompt.CustomptPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CustomptPackageImpl() {
		super(eNS_URI, CustomptFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CustomptPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CustomptPackage init() {
		if (isInited) return (CustomptPackage)EPackage.Registry.INSTANCE.getEPackage(CustomptPackage.eNS_URI);

		// Obtain or create and register package
		CustomptPackageImpl theCustomptPackage = (CustomptPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CustomptPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CustomptPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theCustomptPackage.createPackageContents();

		// Initialize created meta-data
		theCustomptPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCustomptPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CustomptPackage.eNS_URI, theCustomptPackage);
		return theCustomptPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getShadow() {
		return shadowEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAlignment() {
		return alignmentEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getImage() {
		return imageEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getColor() {
		return colorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomptFactory getCustomptFactory() {
		return (CustomptFactory)getEFactoryInstance();
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

		// Create enums
		shadowEEnum = createEEnum(SHADOW);
		alignmentEEnum = createEEnum(ALIGNMENT);

		// Create data types
		imageEDataType = createEDataType(IMAGE);
		colorEDataType = createEDataType(COLOR);
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

		// Initialize enums and add enum literals
		initEEnum(shadowEEnum, Shadow.class, "Shadow");
		addEEnumLiteral(shadowEEnum, Shadow.NONE);
		addEEnumLiteral(shadowEEnum, Shadow.IN);
		addEEnumLiteral(shadowEEnum, Shadow.OUT);

		initEEnum(alignmentEEnum, Alignment.class, "Alignment");
		addEEnumLiteral(alignmentEEnum, Alignment.LEFT);
		addEEnumLiteral(alignmentEEnum, Alignment.CENTER);
		addEEnumLiteral(alignmentEEnum, Alignment.RIGHT);

		// Initialize data types
		initEDataType(imageEDataType, IImage.class, "Image", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(colorEDataType, IColor.class, "Color", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //CustomptPackageImpl
