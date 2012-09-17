/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.EventKind;
import org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeInterpretationKind;
import org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeNatureKind;
import org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeStandardKind;
import org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeTypesLibraryFactory;
import org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeTypesLibraryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TimeTypesLibraryFactoryImpl extends EFactoryImpl implements TimeTypesLibraryFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TimeTypesLibraryFactory init() {
		try {
			TimeTypesLibraryFactory theTimeTypesLibraryFactory = (TimeTypesLibraryFactory)EPackage.Registry.INSTANCE.getEFactory("http:///MARTE_Library/TimeTypesLibrary.ecore"); 
			if (theTimeTypesLibraryFactory != null) {
				return theTimeTypesLibraryFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TimeTypesLibraryFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeTypesLibraryFactoryImpl() {
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
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
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
			case TimeTypesLibraryPackage.TIME_NATURE_KIND:
				return createTimeNatureKindFromString(eDataType, initialValue);
			case TimeTypesLibraryPackage.TIME_INTERPRETATION_KIND:
				return createTimeInterpretationKindFromString(eDataType, initialValue);
			case TimeTypesLibraryPackage.EVENT_KIND:
				return createEventKindFromString(eDataType, initialValue);
			case TimeTypesLibraryPackage.TIME_STANDARD_KIND:
				return createTimeStandardKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
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
			case TimeTypesLibraryPackage.TIME_NATURE_KIND:
				return convertTimeNatureKindToString(eDataType, instanceValue);
			case TimeTypesLibraryPackage.TIME_INTERPRETATION_KIND:
				return convertTimeInterpretationKindToString(eDataType, instanceValue);
			case TimeTypesLibraryPackage.EVENT_KIND:
				return convertEventKindToString(eDataType, instanceValue);
			case TimeTypesLibraryPackage.TIME_STANDARD_KIND:
				return convertTimeStandardKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeNatureKind createTimeNatureKindFromString(EDataType eDataType, String initialValue) {
		TimeNatureKind result = TimeNatureKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTimeNatureKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeInterpretationKind createTimeInterpretationKindFromString(EDataType eDataType, String initialValue) {
		TimeInterpretationKind result = TimeInterpretationKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTimeInterpretationKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventKind createEventKindFromString(EDataType eDataType, String initialValue) {
		EventKind result = EventKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEventKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeStandardKind createTimeStandardKindFromString(EDataType eDataType, String initialValue) {
		TimeStandardKind result = TimeStandardKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTimeStandardKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeTypesLibraryPackage getTimeTypesLibraryPackage() {
		return (TimeTypesLibraryPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TimeTypesLibraryPackage getPackage() {
		return TimeTypesLibraryPackage.eINSTANCE;
	}

} //TimeTypesLibraryFactoryImpl
