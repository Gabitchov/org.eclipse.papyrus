/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 ******************************************************************************/
/**
 */
package org.eclipse.papyrus.layers.configmodel.layersconfig.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.layers.configmodel.layersconfig.*;
import org.eclipse.papyrus.layers.stackmodel.InstanciationException;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptor;
import org.eclipse.papyrus.layers.stackmodel.layers.PropertyOperator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LayersconfigFactoryImpl extends EFactoryImpl implements LayersconfigFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LayersconfigFactory init() {
		try {
			LayersconfigFactory theLayersconfigFactory = (LayersconfigFactory)EPackage.Registry.INSTANCE.getEFactory(LayersconfigPackage.eNS_URI);
			if (theLayersconfigFactory != null) {
				return theLayersconfigFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LayersconfigFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayersconfigFactoryImpl() {
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
			case LayersconfigPackage.FOLDER: return createFolder();
			case LayersconfigPackage.LAYER_OPERATOR_CONFIG: return createLayerOperatorConfig();
			case LayersconfigPackage.OPERATOR_CONFIG: return createOperatorConfig();
			case LayersconfigPackage.PROPERTY_ID: return createPropertyId();
			case LayersconfigPackage.TYPE_CONFIG: return createTypeConfig();
			case LayersconfigPackage.LAYER_OPERATOR_MULTIPLE_BINDING: return createLayerOperatorMultipleBinding();
			case LayersconfigPackage.OPERATOR_BINDING: return createOperatorBinding();
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
			case LayersconfigPackage.CLASSNAME_KIND:
				return createClassnameKindFromString(eDataType, initialValue);
			case LayersconfigPackage.STRING:
				return createStringFromString(eDataType, initialValue);
			case LayersconfigPackage.INSTANCIATION_EXCEPTION:
				return createInstanciationExceptionFromString(eDataType, initialValue);
			case LayersconfigPackage.LAYER_OPERATOR_DESCRIPTOR:
				return createLayerOperatorDescriptorFromString(eDataType, initialValue);
			case LayersconfigPackage.PROPERTY_OPERATOR:
				return createPropertyOperatorFromString(eDataType, initialValue);
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
			case LayersconfigPackage.CLASSNAME_KIND:
				return convertClassnameKindToString(eDataType, instanceValue);
			case LayersconfigPackage.STRING:
				return convertStringToString(eDataType, instanceValue);
			case LayersconfigPackage.INSTANCIATION_EXCEPTION:
				return convertInstanciationExceptionToString(eDataType, instanceValue);
			case LayersconfigPackage.LAYER_OPERATOR_DESCRIPTOR:
				return convertLayerOperatorDescriptorToString(eDataType, instanceValue);
			case LayersconfigPackage.PROPERTY_OPERATOR:
				return convertPropertyOperatorToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Folder createFolder() {
		FolderImpl folder = new FolderImpl();
		return folder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerOperatorConfig createLayerOperatorConfig() {
		LayerOperatorConfigImpl layerOperatorConfig = new LayerOperatorConfigImpl();
		return layerOperatorConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorConfig createOperatorConfig() {
		OperatorConfigImpl operatorConfig = new OperatorConfigImpl();
		return operatorConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyId createPropertyId() {
		PropertyIdImpl propertyId = new PropertyIdImpl();
		return propertyId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeConfig createTypeConfig() {
		TypeConfigImpl typeConfig = new TypeConfigImpl();
		return typeConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerOperatorMultipleBinding createLayerOperatorMultipleBinding() {
		LayerOperatorMultipleBindingImpl layerOperatorMultipleBinding = new LayerOperatorMultipleBindingImpl();
		return layerOperatorMultipleBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorBinding createOperatorBinding() {
		OperatorBindingImpl operatorBinding = new OperatorBindingImpl();
		return operatorBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassnameKind createClassnameKindFromString(EDataType eDataType, String initialValue) {
		ClassnameKind result = ClassnameKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertClassnameKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createStringFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStringToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanciationException createInstanciationExceptionFromString(EDataType eDataType, String initialValue) {
		return (InstanciationException)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertInstanciationExceptionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerOperatorDescriptor createLayerOperatorDescriptorFromString(EDataType eDataType, String initialValue) {
		return (LayerOperatorDescriptor)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLayerOperatorDescriptorToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyOperator createPropertyOperatorFromString(EDataType eDataType, String initialValue) {
		return (PropertyOperator)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPropertyOperatorToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayersconfigPackage getLayersconfigPackage() {
		return (LayersconfigPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LayersconfigPackage getPackage() {
		return LayersconfigPackage.eINSTANCE;
	}

} //LayersconfigFactoryImpl
