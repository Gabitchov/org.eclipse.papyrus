/**
 * Copyright (c) 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *    Nicolas Bros (Mia-Software) - Bug 338907 - expose serialization services from SerializationFactoryImpl
 */
package org.eclipse.emf.facet.util.emf.core.serialization.model.serialization.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.facet.util.emf.core.serialization.ISerializationService;
import org.eclipse.emf.facet.util.emf.core.serialization.model.serialization.SerializationFactory;
import org.eclipse.emf.facet.util.emf.core.serialization.model.serialization.SerializationPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class SerializationFactoryImpl extends EFactoryImpl implements SerializationFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static SerializationFactory init() {
		try {
			SerializationFactory theSerializationFactory = (SerializationFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://www.eclipse.org/emf/facet/serialization/0.1.incubation"); //$NON-NLS-1$ 
			if (theSerializationFactory != null) {
				return theSerializationFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SerializationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SerializationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(final EClass eClass) {
		switch (eClass.getClassifierID()) {
		default:
			throw new IllegalArgumentException(
					"The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object createFromString(final EDataType eDataType, final String initialValue) {
		switch (eDataType.getClassifierID()) {
		case SerializationPackage.EXTENSIBLE_SERIALIZABLE_JAVA_OBJECT:
			return createExtensibleSerializableJavaObjectFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException(
					"The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String convertToString(final EDataType eDataType, final Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case SerializationPackage.EXTENSIBLE_SERIALIZABLE_JAVA_OBJECT:
			return convertExtensibleSerializableJavaObjectToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException(
					"The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> Deserializes a value.
	 * 
	 * @param eDataType
	 *            the datatype
	 * @param initialValue
	 *            the serialized value to deserialize <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static Object createExtensibleSerializableJavaObjectFromString(
			final EDataType eDataType, final String initialValue) {
		return ISerializationService.INSTANCE.deserialize(initialValue);
	}

	/**
	 * <!-- begin-user-doc --> Serializes a value.
	 * 
	 * @param eDataType
	 *            the datatype
	 * @param instanceValue
	 *            the value to serialize <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static String convertExtensibleSerializableJavaObjectToString(final EDataType eDataType,
			final Object instanceValue) {
		return ISerializationService.INSTANCE.serialize(instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SerializationPackage getSerializationPackage() {
		return (SerializationPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SerializationPackage getPackage() {
		return SerializationPackage.eINSTANCE;
	}

} // SerializationFactoryImpl
