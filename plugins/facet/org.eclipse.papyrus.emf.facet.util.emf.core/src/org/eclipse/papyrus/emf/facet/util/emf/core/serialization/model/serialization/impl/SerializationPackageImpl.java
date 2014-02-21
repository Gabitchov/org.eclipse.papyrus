/**
 * Copyright (c) 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 */
package org.eclipse.emf.facet.util.emf.core.serialization.model.serialization.impl;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.facet.util.emf.core.serialization.model.serialization.SerializationFactory;
import org.eclipse.emf.facet.util.emf.core.serialization.model.serialization.SerializationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SerializationPackageImpl extends EPackageImpl implements SerializationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType extensibleSerializableJavaObjectEDataType = null;

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
	 * @see org.eclipse.emf.facet.util.emf.core.serialization.model.serialization.SerializationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SerializationPackageImpl() {
		super(SerializationPackage.eNS_URI, SerializationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SerializationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SerializationPackage init() {
		if (SerializationPackageImpl.isInited) {
			return (SerializationPackage)EPackage.Registry.INSTANCE.getEPackage(SerializationPackage.eNS_URI);
		}

		// Obtain or create and register package
		SerializationPackageImpl theSerializationPackage = (SerializationPackageImpl)(EPackage.Registry.INSTANCE.get(SerializationPackage.eNS_URI) instanceof SerializationPackageImpl ? EPackage.Registry.INSTANCE.get(SerializationPackage.eNS_URI) : new SerializationPackageImpl());

		SerializationPackageImpl.isInited = true;

		// Create package meta-data objects
		theSerializationPackage.createPackageContents();

		// Initialize created meta-data
		theSerializationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSerializationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SerializationPackage.eNS_URI, theSerializationPackage);
		return theSerializationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getExtensibleSerializableJavaObject() {
		return this.extensibleSerializableJavaObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SerializationFactory getSerializationFactory() {
		return (SerializationFactory)getEFactoryInstance();
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
		if (this.isCreated) {
			return;
		}
		this.isCreated = true;

		// Create data types
		this.extensibleSerializableJavaObjectEDataType = createEDataType(SerializationPackage.EXTENSIBLE_SERIALIZABLE_JAVA_OBJECT);
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
		if (this.isInitialized) {
			return;
		}
		this.isInitialized = true;

		// Initialize package
		setName(SerializationPackage.eNAME);
		setNsPrefix(SerializationPackage.eNS_PREFIX);
		setNsURI(SerializationPackage.eNS_URI);

		// Initialize data types
		initEDataType(this.extensibleSerializableJavaObjectEDataType, Object.class, "ExtensibleSerializableJavaObject", EPackageImpl.IS_SERIALIZABLE, !EPackageImpl.IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(SerializationPackage.eNS_URI);
	}

} //SerializationPackageImpl
