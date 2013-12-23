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
package org.eclipse.papyrus.layers.stackmodel.layers.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.layers.stackmodel.BadStateException;
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.NotFoundException;

import org.eclipse.papyrus.layers.stackmodel.command.ComputePropertyValueCommand;
import org.eclipse.papyrus.layers.stackmodel.layers.*;
import org.eclipse.papyrus.layers.stackmodel.operators.CustomPropertyOperatorsInstance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LayersFactoryImpl extends EFactoryImpl implements LayersFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LayersFactory init() {
		try {
			LayersFactory theLayersFactory = (LayersFactory)EPackage.Registry.INSTANCE.getEFactory(LayersPackage.eNS_URI);
			if (theLayersFactory != null) {
				return theLayersFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LayersFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayersFactoryImpl() {
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
			case LayersPackage.LAYER_NAMED_STYLE: return createLayerNamedStyle();
			case LayersPackage.LAYERS_STACK: return createLayersStack();
			case LayersPackage.LAYERS_STACK_APPLICATION: return createLayersStackApplication();
			case LayersPackage.LAYER_STACK_DESCRIPTOR_REGISTRY: return createLayerStackDescriptorRegistry();
			case LayersPackage.PROPERTY_REGISTRY: return createPropertyRegistry();
			case LayersPackage.PROPERTY: return createProperty();
			case LayersPackage.METAMODEL: return createMetamodel();
			case LayersPackage.TYPE_REGISTRY: return createTypeRegistry();
			case LayersPackage.STRING_TO_TYPE_MAP: return (EObject)createStringToTypeMap();
			case LayersPackage.LAYER_DESCRIPTOR_REGISTRY: return createLayerDescriptorRegistry();
			case LayersPackage.LAYER_DESCRIPTOR: return createLayerDescriptor();
			case LayersPackage.LAYER_APPLICATION_FACTORY: return createLayerApplicationFactory();
			case LayersPackage.PROPERTY_SETTER_REGISTRY: return createPropertySetterRegistry();
			case LayersPackage.STRING_TO_PROPERTY_SETTER: return (EObject)createStringToPropertySetter();
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR_REGISTRY: return createLayerOperatorDescriptorRegistry();
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR: return createLayerOperatorDescriptor();
			case LayersPackage.PROPERTY_OPERATOR: return createPropertyOperator();
			case LayersPackage.DEFAULT_PROPERTY_OPERATOR: return createDefaultPropertyOperator();
			case LayersPackage.STRING_TO_TYPE_INSTANCE_MAP: return (EObject)createStringToTypeInstanceMap();
			case LayersPackage.FOLDER: return createFolder();
			case LayersPackage.INT_INSTANCE: return createIntInstance();
			case LayersPackage.BOOLEAN_INSTANCE: return createBooleanInstance();
			case LayersPackage.STRING_INSTANCE: return createStringInstance();
			case LayersPackage.INT_TYPE: return createIntType();
			case LayersPackage.BOOLEAN_TYPE: return createBooleanType();
			case LayersPackage.STRING_TYPE: return createStringType();
			case LayersPackage.CUSTOM_TYPE: return createCustomType();
			case LayersPackage.TOP_LAYER_OPERATOR: return createTopLayerOperator();
			case LayersPackage.STACKED_LAYER_OPERATOR: return createStackedLayerOperator();
			case LayersPackage.CUSTOM_LAYER_OPERATOR: return createCustomLayerOperator();
			case LayersPackage.PROPERTY_INDEX: return createPropertyIndex();
			case LayersPackage.STRING_TO_PROPERTY_INDEX_MAP: return (EObject)createStringToPropertyIndexMap();
			case LayersPackage.SIMPLE_LAYER_DESCRIPTOR: return createSimpleLayerDescriptor();
			case LayersPackage.REG_EXP_LAYER_DESCRIPTOR: return createRegExpLayerDescriptor();
			case LayersPackage.NULL_INSTANCE: return createNullInstance();
			case LayersPackage.REG_EXP_LAYER: return createRegExpLayer();
			case LayersPackage.LAYER: return createLayer();
			case LayersPackage.COLOR: return createColor();
			case LayersPackage.COLOR_INSTANCE: return createColorInstance();
			case LayersPackage.FILL_INSTANCE: return createFillInstance();
			case LayersPackage.FILL: return createFill();
			case LayersPackage.FILL_PROPERTY_SETTER: return createFillPropertySetter();
			case LayersPackage.IS_VALID_PROPERTY_SETTER: return createIsValidPropertySetter();
			case LayersPackage.NULL_PROPERTY_SETTER: return createNullPropertySetter();
			case LayersPackage.LINE_TYPE: return createLineType();
			case LayersPackage.LINE_INSTANCE: return createLineInstance();
			case LayersPackage.LINE_PROPERTY_SETTER: return createLinePropertySetter();
			case LayersPackage.FONT_PROPERTY_SETTER: return createFontPropertySetter();
			case LayersPackage.FONT_INSTANCE: return createFontInstance();
			case LayersPackage.FONT_TYPE: return createFontType();
			case LayersPackage.IS_VISIBLE_PROPERTY_SETTER: return createIsVisiblePropertySetter();
			case LayersPackage.TOP_LAYER_OPERATOR_DESCRIPTOR: return createTopLayerOperatorDescriptor();
			case LayersPackage.STACKED_LAYER_OPERATOR_DESCRIPTOR: return createStackedLayerOperatorDescriptor();
			case LayersPackage.CUSTOM_PROPERTY_OPERATOR: return createCustomPropertyOperator();
			case LayersPackage.AND_STACKED_LAYER_OPERATOR_DESCRIPTOR: return createAndStackedLayerOperatorDescriptor();
			case LayersPackage.OR_STACKED_LAYER_OPERATOR_DESCRIPTOR: return createOrStackedLayerOperatorDescriptor();
			case LayersPackage.IS_ABSTRACT_UML_SETTER: return createIsAbstractUmlSetter();
			case LayersPackage.ALL_VIEWS_DERIVED_LAYER: return createAllViewsDerivedLayer();
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
			case LayersPackage.EVENT_LEVEL:
				return createEventLevelFromString(eDataType, initialValue);
			case LayersPackage.STRING:
				return createStringFromString(eDataType, initialValue);
			case LayersPackage.BOOLEAN:
				return createbooleanFromString(eDataType, initialValue);
			case LayersPackage.EPACKAGE:
				return createEPackageFromString(eDataType, initialValue);
			case LayersPackage.LAYERS_EXCEPTION:
				return createLayersExceptionFromString(eDataType, initialValue);
			case LayersPackage.INT:
				return createintFromString(eDataType, initialValue);
			case LayersPackage.BAD_STATE_EXCEPTION:
				return createBadStateExceptionFromString(eDataType, initialValue);
			case LayersPackage.NOT_FOUND_EXCEPTION:
				return createNotFoundExceptionFromString(eDataType, initialValue);
			case LayersPackage.COMPUTE_PROPERTY_VALUE_COMMAND:
				return createComputePropertyValueCommandFromString(eDataType, initialValue);
			case LayersPackage.OBJECT:
				return createObjectFromString(eDataType, initialValue);
			case LayersPackage.CUSTOM_PROPERTY_OPERTOR_INSTANCE:
				return createCustomPropertyOpertorInstanceFromString(eDataType, initialValue);
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
			case LayersPackage.EVENT_LEVEL:
				return convertEventLevelToString(eDataType, instanceValue);
			case LayersPackage.STRING:
				return convertStringToString(eDataType, instanceValue);
			case LayersPackage.BOOLEAN:
				return convertbooleanToString(eDataType, instanceValue);
			case LayersPackage.EPACKAGE:
				return convertEPackageToString(eDataType, instanceValue);
			case LayersPackage.LAYERS_EXCEPTION:
				return convertLayersExceptionToString(eDataType, instanceValue);
			case LayersPackage.INT:
				return convertintToString(eDataType, instanceValue);
			case LayersPackage.BAD_STATE_EXCEPTION:
				return convertBadStateExceptionToString(eDataType, instanceValue);
			case LayersPackage.NOT_FOUND_EXCEPTION:
				return convertNotFoundExceptionToString(eDataType, instanceValue);
			case LayersPackage.COMPUTE_PROPERTY_VALUE_COMMAND:
				return convertComputePropertyValueCommandToString(eDataType, instanceValue);
			case LayersPackage.OBJECT:
				return convertObjectToString(eDataType, instanceValue);
			case LayersPackage.CUSTOM_PROPERTY_OPERTOR_INSTANCE:
				return convertCustomPropertyOpertorInstanceToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerNamedStyle createLayerNamedStyle() {
		LayerNamedStyleImpl layerNamedStyle = new LayerNamedStyleImpl();
		return layerNamedStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayersStack createLayersStack() {
		LayersStackImpl layersStack = new LayersStackImpl();
		return layersStack;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayersStackApplication createLayersStackApplication() {
		LayersStackApplicationImpl layersStackApplication = new LayersStackApplicationImpl();
		return layersStackApplication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerStackDescriptorRegistry createLayerStackDescriptorRegistry() {
		LayerStackDescriptorRegistryImpl layerStackDescriptorRegistry = new LayerStackDescriptorRegistryImpl();
		return layerStackDescriptorRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyRegistry createPropertyRegistry() {
		PropertyRegistryImpl propertyRegistry = new PropertyRegistryImpl();
		return propertyRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property createProperty() {
		PropertyImpl property = new PropertyImpl();
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Metamodel createMetamodel() {
		MetamodelImpl metamodel = new MetamodelImpl();
		return metamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeRegistry createTypeRegistry() {
		TypeRegistryImpl typeRegistry = new TypeRegistryImpl();
		return typeRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, Type> createStringToTypeMap() {
		StringToTypeMapImpl stringToTypeMap = new StringToTypeMapImpl();
		return stringToTypeMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerDescriptorRegistry createLayerDescriptorRegistry() {
		LayerDescriptorRegistryImpl layerDescriptorRegistry = new LayerDescriptorRegistryImpl();
		return layerDescriptorRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerDescriptor createLayerDescriptor() {
		LayerDescriptorImpl layerDescriptor = new LayerDescriptorImpl();
		return layerDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerApplicationFactory createLayerApplicationFactory() {
		LayerApplicationFactoryImpl layerApplicationFactory = new LayerApplicationFactoryImpl();
		return layerApplicationFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertySetterRegistry createPropertySetterRegistry() {
		PropertySetterRegistryImpl propertySetterRegistry = new PropertySetterRegistryImpl();
		return propertySetterRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, PropertySetter> createStringToPropertySetter() {
		StringToPropertySetterImpl stringToPropertySetter = new StringToPropertySetterImpl();
		return stringToPropertySetter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, TypeInstance> createStringToTypeInstanceMap() {
		StringToTypeInstanceMapImpl stringToTypeInstanceMap = new StringToTypeInstanceMapImpl();
		return stringToTypeInstanceMap;
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
	public IntInstance createIntInstance() {
		IntInstanceImpl intInstance = new IntInstanceImpl();
		return intInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanInstance createBooleanInstance() {
		BooleanInstanceImpl booleanInstance = new BooleanInstanceImpl();
		return booleanInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringInstance createStringInstance() {
		StringInstanceImpl stringInstance = new StringInstanceImpl();
		return stringInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntType createIntType() {
		IntTypeImpl intType = new IntTypeImpl();
		return intType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanType createBooleanType() {
		BooleanTypeImpl booleanType = new BooleanTypeImpl();
		return booleanType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringType createStringType() {
		StringTypeImpl stringType = new StringTypeImpl();
		return stringType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomType createCustomType() {
		CustomTypeImpl customType = new CustomTypeImpl();
		return customType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerOperatorDescriptor createLayerOperatorDescriptor() {
		LayerOperatorDescriptorImpl layerOperatorDescriptor = new LayerOperatorDescriptorImpl();
		return layerOperatorDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyOperator createPropertyOperator() {
		PropertyOperatorImpl propertyOperator = new PropertyOperatorImpl();
		return propertyOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultPropertyOperator createDefaultPropertyOperator() {
		DefaultPropertyOperatorImpl defaultPropertyOperator = new DefaultPropertyOperatorImpl();
		return defaultPropertyOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopLayerOperator createTopLayerOperator() {
		TopLayerOperatorImpl topLayerOperator = new TopLayerOperatorImpl();
		return topLayerOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StackedLayerOperator createStackedLayerOperator() {
		StackedLayerOperatorImpl stackedLayerOperator = new StackedLayerOperatorImpl();
		return stackedLayerOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomLayerOperator createCustomLayerOperator() {
		CustomLayerOperatorImpl customLayerOperator = new CustomLayerOperatorImpl();
		return customLayerOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyIndex createPropertyIndex() {
		PropertyIndexImpl propertyIndex = new PropertyIndexImpl();
		return propertyIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, PropertyIndex> createStringToPropertyIndexMap() {
		StringToPropertyIndexMapImpl stringToPropertyIndexMap = new StringToPropertyIndexMapImpl();
		return stringToPropertyIndexMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleLayerDescriptor createSimpleLayerDescriptor() {
		SimpleLayerDescriptorImpl simpleLayerDescriptor = new SimpleLayerDescriptorImpl();
		return simpleLayerDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegExpLayerDescriptor createRegExpLayerDescriptor() {
		RegExpLayerDescriptorImpl regExpLayerDescriptor = new RegExpLayerDescriptorImpl();
		return regExpLayerDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NullInstance createNullInstance() {
		NullInstanceImpl nullInstance = new NullInstanceImpl();
		return nullInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RegExpLayer createRegExpLayer() {
		RegExpLayerImpl regExpLayer = new RegExpLayerImpl();
		return regExpLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Layer createLayer() {
		LayerImpl layer = new LayerImpl();
		return layer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Color createColor() {
		ColorImpl color = new ColorImpl();
		return color;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColorInstance createColorInstance() {
		ColorInstanceImpl colorInstance = new ColorInstanceImpl();
		return colorInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FillInstance createFillInstance() {
		FillInstanceImpl fillInstance = new FillInstanceImpl();
		return fillInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fill createFill() {
		FillImpl fill = new FillImpl();
		return fill;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FillPropertySetter createFillPropertySetter() {
		FillPropertySetterImpl fillPropertySetter = new FillPropertySetterImpl();
		return fillPropertySetter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsValidPropertySetter createIsValidPropertySetter() {
		IsValidPropertySetterImpl isValidPropertySetter = new IsValidPropertySetterImpl();
		return isValidPropertySetter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NullPropertySetter createNullPropertySetter() {
		NullPropertySetterImpl nullPropertySetter = new NullPropertySetterImpl();
		return nullPropertySetter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LineType createLineType() {
		LineTypeImpl lineType = new LineTypeImpl();
		return lineType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LineInstance createLineInstance() {
		LineInstanceImpl lineInstance = new LineInstanceImpl();
		return lineInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinePropertySetter createLinePropertySetter() {
		LinePropertySetterImpl linePropertySetter = new LinePropertySetterImpl();
		return linePropertySetter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FontPropertySetter createFontPropertySetter() {
		FontPropertySetterImpl fontPropertySetter = new FontPropertySetterImpl();
		return fontPropertySetter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FontInstance createFontInstance() {
		FontInstanceImpl fontInstance = new FontInstanceImpl();
		return fontInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FontType createFontType() {
		FontTypeImpl fontType = new FontTypeImpl();
		return fontType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsVisiblePropertySetter createIsVisiblePropertySetter() {
		IsVisiblePropertySetterImpl isVisiblePropertySetter = new IsVisiblePropertySetterImpl();
		return isVisiblePropertySetter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayerOperatorDescriptorRegistry createLayerOperatorDescriptorRegistry() {
		LayerOperatorDescriptorRegistryImpl layerOperatorDescriptorRegistry = new LayerOperatorDescriptorRegistryImpl();
		return layerOperatorDescriptorRegistry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TopLayerOperatorDescriptor createTopLayerOperatorDescriptor() {
		TopLayerOperatorDescriptorImpl topLayerOperatorDescriptor = new TopLayerOperatorDescriptorImpl();
		return topLayerOperatorDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StackedLayerOperatorDescriptor createStackedLayerOperatorDescriptor() {
		StackedLayerOperatorDescriptorImpl stackedLayerOperatorDescriptor = new StackedLayerOperatorDescriptorImpl();
		return stackedLayerOperatorDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomPropertyOperator createCustomPropertyOperator() {
		CustomPropertyOperatorImpl customPropertyOperator = new CustomPropertyOperatorImpl();
		return customPropertyOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AndStackedLayerOperatorDescriptor createAndStackedLayerOperatorDescriptor() {
		AndStackedLayerOperatorDescriptorImpl andStackedLayerOperatorDescriptor = new AndStackedLayerOperatorDescriptorImpl();
		return andStackedLayerOperatorDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrStackedLayerOperatorDescriptor createOrStackedLayerOperatorDescriptor() {
		OrStackedLayerOperatorDescriptorImpl orStackedLayerOperatorDescriptor = new OrStackedLayerOperatorDescriptorImpl();
		return orStackedLayerOperatorDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsAbstractUmlSetter createIsAbstractUmlSetter() {
		IsAbstractUmlSetterImpl isAbstractUmlSetter = new IsAbstractUmlSetterImpl();
		return isAbstractUmlSetter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllViewsDerivedLayer createAllViewsDerivedLayer() {
		AllViewsDerivedLayerImpl allViewsDerivedLayer = new AllViewsDerivedLayerImpl();
		return allViewsDerivedLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventLevel createEventLevelFromString(EDataType eDataType, String initialValue) {
		EventLevel result = EventLevel.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEventLevelToString(EDataType eDataType, Object instanceValue) {
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
	public Boolean createbooleanFromString(EDataType eDataType, String initialValue) {
		return (Boolean)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertbooleanToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage createEPackageFromString(EDataType eDataType, String initialValue) {
		return (EPackage)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEPackageToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BadStateException createBadStateExceptionFromString(EDataType eDataType, String initialValue) {
		return (BadStateException)createLayersExceptionFromString(LayersPackage.Literals.LAYERS_EXCEPTION, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBadStateExceptionToString(EDataType eDataType, Object instanceValue) {
		return convertLayersExceptionToString(LayersPackage.Literals.LAYERS_EXCEPTION, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayersException createLayersExceptionFromString(EDataType eDataType, String initialValue) {
		return (LayersException)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLayersExceptionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotFoundException createNotFoundExceptionFromString(EDataType eDataType, String initialValue) {
		return (NotFoundException)createLayersExceptionFromString(LayersPackage.Literals.LAYERS_EXCEPTION, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNotFoundExceptionToString(EDataType eDataType, Object instanceValue) {
		return convertLayersExceptionToString(LayersPackage.Literals.LAYERS_EXCEPTION, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputePropertyValueCommand createComputePropertyValueCommandFromString(EDataType eDataType, String initialValue) {
		return (ComputePropertyValueCommand)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertComputePropertyValueCommandToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer createintFromString(EDataType eDataType, String initialValue) {
		return (Integer)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertintToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createObjectFromString(EDataType eDataType, String initialValue) {
		return super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertObjectToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomPropertyOperatorsInstance createCustomPropertyOpertorInstanceFromString(EDataType eDataType, String initialValue) {
		return (CustomPropertyOperatorsInstance)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCustomPropertyOpertorInstanceToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayersPackage getLayersPackage() {
		return (LayersPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LayersPackage getPackage() {
		return LayersPackage.eINSTANCE;
	}

} //LayersFactoryImpl
