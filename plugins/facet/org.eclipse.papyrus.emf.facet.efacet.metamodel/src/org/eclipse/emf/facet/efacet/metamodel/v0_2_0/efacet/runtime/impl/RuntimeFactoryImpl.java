/**
 *  Copyright (c) 2011, 2012 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 * 	Gregoire Dupe (Mia-Software) - Design
 * 	Nicolas Guyomar (Mia-Software) - Implementation
 * 	Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values. 
 * 	Nicolas Bros (Mia-Software) - Bug 361823 - [Restructuring] eFacet2 meta-model
 *       Gregoire Dupe (Mia-Software) - Bug 366055 - NavigationQuery
 *       Gregoire Dupe (Mia-Software) - Bug 369673 - [Facet] IsOneOfQuery
 *       Olivier Remaud (Soft-Maint) - Bug 369824 - Add a simple way to return string literal constants from a customization query
 *       Gregoire Dupe (Mia-software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *       Gregoire Dupe (Mia-software) - Bug 364325 - [Restructuring] The user must be able to navigate into a model using the Facet.
 */
package org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.*;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementEObjectListResult;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementEObjectResult;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementPrimitiveTypeListResult;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementPrimitiveTypeResult;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.RuntimeFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.RuntimePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RuntimeFactoryImpl extends EFactoryImpl implements RuntimeFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RuntimeFactory init() {
		try {
			RuntimeFactory theRuntimeFactory = (RuntimeFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/emf/facet/efacet/0.2.incubation/efacet/runtime"); //$NON-NLS-1$ 
			if (theRuntimeFactory != null) {
				return theRuntimeFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RuntimeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimeFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case RuntimePackage.ETYPED_ELEMENT_PRIMITIVE_TYPE_RESULT: return createETypedElementPrimitiveTypeResult();
			case RuntimePackage.ETYPED_ELEMENT_EOBJECT_RESULT: return createETypedElementEObjectResult();
			case RuntimePackage.ETYPED_ELEMENT_PRIMITIVE_TYPE_LIST_RESULT: return createETypedElementPrimitiveTypeListResult();
			case RuntimePackage.ETYPED_ELEMENT_EOBJECT_LIST_RESULT: return createETypedElementEObjectListResult();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case RuntimePackage.JAVA_EXCEPTION:
				return createJavaExceptionFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case RuntimePackage.JAVA_EXCEPTION:
				return convertJavaExceptionToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T> ETypedElementPrimitiveTypeResult<T> createETypedElementPrimitiveTypeResult() {
		ETypedElementPrimitiveTypeResultImpl<T> eTypedElementPrimitiveTypeResult = new ETypedElementPrimitiveTypeResultImpl<T>();
		return eTypedElementPrimitiveTypeResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T extends EObject> ETypedElementEObjectResult<T> createETypedElementEObjectResult() {
		ETypedElementEObjectResultImpl<T> eTypedElementEObjectResult = new ETypedElementEObjectResultImpl<T>();
		return eTypedElementEObjectResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T> ETypedElementPrimitiveTypeListResult<T> createETypedElementPrimitiveTypeListResult() {
		ETypedElementPrimitiveTypeListResultImpl<T> eTypedElementPrimitiveTypeListResult = new ETypedElementPrimitiveTypeListResultImpl<T>();
		return eTypedElementPrimitiveTypeListResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public <T extends EObject> ETypedElementEObjectListResult<T> createETypedElementEObjectListResult() {
		ETypedElementEObjectListResultImpl<T> eTypedElementEObjectListResult = new ETypedElementEObjectListResultImpl<T>();
		return eTypedElementEObjectListResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Throwable createJavaExceptionFromString(EDataType eDataType, String initialValue) {
		return (Throwable)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJavaExceptionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimePackage getRuntimePackage() {
		return (RuntimePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RuntimePackage getPackage() {
		return RuntimePackage.eINSTANCE;
	}

} //RuntimeFactoryImpl
