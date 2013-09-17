/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin Cedric.dumoulin@lifl.fr
 ******************************************************************************/
/**
 */
package org.eclipse.papyrus.layers.stackmodel.layers.util;

import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.gmf.runtime.notation.NamedStyle;
import org.eclipse.gmf.runtime.notation.Style;

import org.eclipse.papyrus.layers.stackmodel.command.ComputePropertyValueCommand;
import org.eclipse.papyrus.layers.stackmodel.layers.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage
 * @generated
 */
public class LayersSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static LayersPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayersSwitch() {
		if (modelPackage == null) {
			modelPackage = LayersPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case LayersPackage.LAYER_NAMED_STYLE: {
				LayerNamedStyle layerNamedStyle = (LayerNamedStyle)theEObject;
				T result = caseLayerNamedStyle(layerNamedStyle);
				if (result == null) result = caseNamedStyle(layerNamedStyle);
				if (result == null) result = caseStyle(layerNamedStyle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.LAYERS_STACK: {
				LayersStack layersStack = (LayersStack)theEObject;
				T result = caseLayersStack(layersStack);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.LAYER_EXPRESSION: {
				LayerExpression layerExpression = (LayerExpression)theEObject;
				T result = caseLayerExpression(layerExpression);
				if (result == null) result = caseApplicationDependantElement(layerExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.APPLICATION_DEPENDANT_ELEMENT: {
				ApplicationDependantElement applicationDependantElement = (ApplicationDependantElement)theEObject;
				T result = caseApplicationDependantElement(applicationDependantElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.LAYERS_STACK_APPLICATION: {
				LayersStackApplication layersStackApplication = (LayersStackApplication)theEObject;
				T result = caseLayersStackApplication(layersStackApplication);
				if (result == null) result = caseFolderElement(layersStackApplication);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.FOLDER_ELEMENT: {
				FolderElement folderElement = (FolderElement)theEObject;
				T result = caseFolderElement(folderElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.LAYER_STACK_DESCRIPTOR_REGISTRY: {
				LayerStackDescriptorRegistry layerStackDescriptorRegistry = (LayerStackDescriptorRegistry)theEObject;
				T result = caseLayerStackDescriptorRegistry(layerStackDescriptorRegistry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.PROPERTY_REGISTRY: {
				PropertyRegistry propertyRegistry = (PropertyRegistry)theEObject;
				T result = casePropertyRegistry(propertyRegistry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.PROPERTY: {
				Property property = (Property)theEObject;
				T result = caseProperty(property);
				if (result == null) result = caseFolderElement(property);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.TYPE: {
				Type type = (Type)theEObject;
				T result = caseType(type);
				if (result == null) result = caseFolderElement(type);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.METAMODEL: {
				Metamodel metamodel = (Metamodel)theEObject;
				T result = caseMetamodel(metamodel);
				if (result == null) result = caseFolderElement(metamodel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.TYPE_INSTANCE: {
				TypeInstance typeInstance = (TypeInstance)theEObject;
				T result = caseTypeInstance(typeInstance);
				if (result == null) result = caseComputePropertyValueCommandItf(typeInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.COMPUTE_PROPERTY_VALUE_COMMAND_ITF: {
				ComputePropertyValueCommand computePropertyValueCommandItf = (ComputePropertyValueCommand)theEObject;
				T result = caseComputePropertyValueCommandItf(computePropertyValueCommandItf);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.TYPE_REGISTRY: {
				TypeRegistry typeRegistry = (TypeRegistry)theEObject;
				T result = caseTypeRegistry(typeRegistry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.STRING_TO_TYPE_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<String, Type> stringToTypeMap = (Map.Entry<String, Type>)theEObject;
				T result = caseStringToTypeMap(stringToTypeMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.LAYER_DESCRIPTOR_REGISTRY: {
				LayerDescriptorRegistry layerDescriptorRegistry = (LayerDescriptorRegistry)theEObject;
				T result = caseLayerDescriptorRegistry(layerDescriptorRegistry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.LAYER_DESCRIPTOR: {
				LayerDescriptor layerDescriptor = (LayerDescriptor)theEObject;
				T result = caseLayerDescriptor(layerDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.LAYER_APPLICATION_FACTORY: {
				LayerApplicationFactory layerApplicationFactory = (LayerApplicationFactory)theEObject;
				T result = caseLayerApplicationFactory(layerApplicationFactory);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.PROPERTY_SETTER_REGISTRY: {
				PropertySetterRegistry propertySetterRegistry = (PropertySetterRegistry)theEObject;
				T result = casePropertySetterRegistry(propertySetterRegistry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.PROPERTY_SETTER: {
				PropertySetter propertySetter = (PropertySetter)theEObject;
				T result = casePropertySetter(propertySetter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.STRING_TO_PROPERTY_SETTER: {
				@SuppressWarnings("unchecked") Map.Entry<String, PropertySetter> stringToPropertySetter = (Map.Entry<String, PropertySetter>)theEObject;
				T result = caseStringToPropertySetter(stringToPropertySetter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR_REGISTRY: {
				LayerOperatorDescriptorRegistry layerOperatorDescriptorRegistry = (LayerOperatorDescriptorRegistry)theEObject;
				T result = caseLayerOperatorDescriptorRegistry(layerOperatorDescriptorRegistry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.LAYER_OPERATOR_DESCRIPTOR: {
				LayerOperatorDescriptor layerOperatorDescriptor = (LayerOperatorDescriptor)theEObject;
				T result = caseLayerOperatorDescriptor(layerOperatorDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.PROPERTY_OPERATOR: {
				PropertyOperator propertyOperator = (PropertyOperator)theEObject;
				T result = casePropertyOperator(propertyOperator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.ABSTRACT_LAYER_OPERATOR: {
				AbstractLayerOperator abstractLayerOperator = (AbstractLayerOperator)theEObject;
				T result = caseAbstractLayerOperator(abstractLayerOperator);
				if (result == null) result = caseLayerOperator(abstractLayerOperator);
				if (result == null) result = caseLayerExpression(abstractLayerOperator);
				if (result == null) result = caseApplicationDependantElement(abstractLayerOperator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.LAYER_OPERATOR: {
				LayerOperator layerOperator = (LayerOperator)theEObject;
				T result = caseLayerOperator(layerOperator);
				if (result == null) result = caseLayerExpression(layerOperator);
				if (result == null) result = caseApplicationDependantElement(layerOperator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.DEFAULT_PROPERTY_OPERATOR: {
				DefaultPropertyOperator defaultPropertyOperator = (DefaultPropertyOperator)theEObject;
				T result = caseDefaultPropertyOperator(defaultPropertyOperator);
				if (result == null) result = casePropertyOperator(defaultPropertyOperator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.ABSTRACT_LAYER: {
				AbstractLayer abstractLayer = (AbstractLayer)theEObject;
				T result = caseAbstractLayer(abstractLayer);
				if (result == null) result = caseLayerExpression(abstractLayer);
				if (result == null) result = caseApplicationDependantElement(abstractLayer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.STRING_TO_TYPE_INSTANCE_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<String, TypeInstance> stringToTypeInstanceMap = (Map.Entry<String, TypeInstance>)theEObject;
				T result = caseStringToTypeInstanceMap(stringToTypeInstanceMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.FOLDER: {
				Folder folder = (Folder)theEObject;
				T result = caseFolder(folder);
				if (result == null) result = caseFolderElement(folder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.INT_INSTANCE: {
				IntInstance intInstance = (IntInstance)theEObject;
				T result = caseIntInstance(intInstance);
				if (result == null) result = caseTypeInstance(intInstance);
				if (result == null) result = caseComputePropertyValueCommandItf(intInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.BOOLEAN_INSTANCE: {
				BooleanInstance booleanInstance = (BooleanInstance)theEObject;
				T result = caseBooleanInstance(booleanInstance);
				if (result == null) result = caseTypeInstance(booleanInstance);
				if (result == null) result = caseComputePropertyValueCommandItf(booleanInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.STRING_INSTANCE: {
				StringInstance stringInstance = (StringInstance)theEObject;
				T result = caseStringInstance(stringInstance);
				if (result == null) result = caseTypeInstance(stringInstance);
				if (result == null) result = caseComputePropertyValueCommandItf(stringInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.INT_TYPE: {
				IntType intType = (IntType)theEObject;
				T result = caseIntType(intType);
				if (result == null) result = caseType(intType);
				if (result == null) result = caseFolderElement(intType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.BOOLEAN_TYPE: {
				BooleanType booleanType = (BooleanType)theEObject;
				T result = caseBooleanType(booleanType);
				if (result == null) result = caseType(booleanType);
				if (result == null) result = caseFolderElement(booleanType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.STRING_TYPE: {
				StringType stringType = (StringType)theEObject;
				T result = caseStringType(stringType);
				if (result == null) result = caseType(stringType);
				if (result == null) result = caseFolderElement(stringType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.CUSTOM_TYPE: {
				CustomType customType = (CustomType)theEObject;
				T result = caseCustomType(customType);
				if (result == null) result = caseType(customType);
				if (result == null) result = caseFolderElement(customType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.TOP_LAYER_OPERATOR: {
				TopLayerOperator topLayerOperator = (TopLayerOperator)theEObject;
				T result = caseTopLayerOperator(topLayerOperator);
				if (result == null) result = caseAbstractLayerOperator(topLayerOperator);
				if (result == null) result = caseLayerOperator(topLayerOperator);
				if (result == null) result = caseLayerExpression(topLayerOperator);
				if (result == null) result = caseApplicationDependantElement(topLayerOperator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.STACKED_LAYER_OPERATOR: {
				StackedLayerOperator stackedLayerOperator = (StackedLayerOperator)theEObject;
				T result = caseStackedLayerOperator(stackedLayerOperator);
				if (result == null) result = caseAbstractLayerOperator(stackedLayerOperator);
				if (result == null) result = caseLayerOperator(stackedLayerOperator);
				if (result == null) result = caseLayerExpression(stackedLayerOperator);
				if (result == null) result = caseApplicationDependantElement(stackedLayerOperator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.CUSTOM_LAYER_OPERATOR: {
				CustomLayerOperator customLayerOperator = (CustomLayerOperator)theEObject;
				T result = caseCustomLayerOperator(customLayerOperator);
				if (result == null) result = caseLayerOperator(customLayerOperator);
				if (result == null) result = caseLayerExpression(customLayerOperator);
				if (result == null) result = caseApplicationDependantElement(customLayerOperator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.PROPERTY_INDEX: {
				PropertyIndex propertyIndex = (PropertyIndex)theEObject;
				T result = casePropertyIndex(propertyIndex);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.STRING_TO_PROPERTY_INDEX_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<String, PropertyIndex> stringToPropertyIndexMap = (Map.Entry<String, PropertyIndex>)theEObject;
				T result = caseStringToPropertyIndexMap(stringToPropertyIndexMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.SIMPLE_LAYER_DESCRIPTOR: {
				SimpleLayerDescriptor simpleLayerDescriptor = (SimpleLayerDescriptor)theEObject;
				T result = caseSimpleLayerDescriptor(simpleLayerDescriptor);
				if (result == null) result = caseLayerDescriptor(simpleLayerDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.REG_EXP_LAYER_DESCRIPTOR: {
				RegExpLayerDescriptor regExpLayerDescriptor = (RegExpLayerDescriptor)theEObject;
				T result = caseRegExpLayerDescriptor(regExpLayerDescriptor);
				if (result == null) result = caseLayerDescriptor(regExpLayerDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.NULL_INSTANCE: {
				NullInstance nullInstance = (NullInstance)theEObject;
				T result = caseNullInstance(nullInstance);
				if (result == null) result = caseTypeInstance(nullInstance);
				if (result == null) result = caseComputePropertyValueCommandItf(nullInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.REG_EXP_LAYER: {
				RegExpLayer regExpLayer = (RegExpLayer)theEObject;
				T result = caseRegExpLayer(regExpLayer);
				if (result == null) result = caseAbstractLayer(regExpLayer);
				if (result == null) result = caseLayerExpression(regExpLayer);
				if (result == null) result = caseApplicationDependantElement(regExpLayer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.LAYER: {
				Layer layer = (Layer)theEObject;
				T result = caseLayer(layer);
				if (result == null) result = caseAbstractLayer(layer);
				if (result == null) result = caseLayerExpression(layer);
				if (result == null) result = caseApplicationDependantElement(layer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.COLOR: {
				Color color = (Color)theEObject;
				T result = caseColor(color);
				if (result == null) result = caseType(color);
				if (result == null) result = caseFolderElement(color);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.COLOR_INSTANCE: {
				ColorInstance colorInstance = (ColorInstance)theEObject;
				T result = caseColorInstance(colorInstance);
				if (result == null) result = caseTypeInstance(colorInstance);
				if (result == null) result = caseComputePropertyValueCommandItf(colorInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.FILL_INSTANCE: {
				FillInstance fillInstance = (FillInstance)theEObject;
				T result = caseFillInstance(fillInstance);
				if (result == null) result = caseTypeInstance(fillInstance);
				if (result == null) result = caseComputePropertyValueCommandItf(fillInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.FILL: {
				Fill fill = (Fill)theEObject;
				T result = caseFill(fill);
				if (result == null) result = caseType(fill);
				if (result == null) result = caseFolderElement(fill);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.FILL_PROPERTY_SETTER: {
				FillPropertySetter fillPropertySetter = (FillPropertySetter)theEObject;
				T result = caseFillPropertySetter(fillPropertySetter);
				if (result == null) result = casePropertySetter(fillPropertySetter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.IS_VALID_PROPERTY_SETTER: {
				IsValidPropertySetter isValidPropertySetter = (IsValidPropertySetter)theEObject;
				T result = caseIsValidPropertySetter(isValidPropertySetter);
				if (result == null) result = casePropertySetter(isValidPropertySetter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.NULL_PROPERTY_SETTER: {
				NullPropertySetter nullPropertySetter = (NullPropertySetter)theEObject;
				T result = caseNullPropertySetter(nullPropertySetter);
				if (result == null) result = casePropertySetter(nullPropertySetter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.LINE_TYPE: {
				LineType lineType = (LineType)theEObject;
				T result = caseLineType(lineType);
				if (result == null) result = caseType(lineType);
				if (result == null) result = caseFolderElement(lineType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.LINE_INSTANCE: {
				LineInstance lineInstance = (LineInstance)theEObject;
				T result = caseLineInstance(lineInstance);
				if (result == null) result = caseTypeInstance(lineInstance);
				if (result == null) result = caseComputePropertyValueCommandItf(lineInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.LINE_PROPERTY_SETTER: {
				LinePropertySetter linePropertySetter = (LinePropertySetter)theEObject;
				T result = caseLinePropertySetter(linePropertySetter);
				if (result == null) result = casePropertySetter(linePropertySetter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.FONT_PROPERTY_SETTER: {
				FontPropertySetter fontPropertySetter = (FontPropertySetter)theEObject;
				T result = caseFontPropertySetter(fontPropertySetter);
				if (result == null) result = casePropertySetter(fontPropertySetter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.FONT_INSTANCE: {
				FontInstance fontInstance = (FontInstance)theEObject;
				T result = caseFontInstance(fontInstance);
				if (result == null) result = caseTypeInstance(fontInstance);
				if (result == null) result = caseComputePropertyValueCommandItf(fontInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.FONT_TYPE: {
				FontType fontType = (FontType)theEObject;
				T result = caseFontType(fontType);
				if (result == null) result = caseType(fontType);
				if (result == null) result = caseFolderElement(fontType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.IS_VISIBLE_PROPERTY_SETTER: {
				IsVisiblePropertySetter isVisiblePropertySetter = (IsVisiblePropertySetter)theEObject;
				T result = caseIsVisiblePropertySetter(isVisiblePropertySetter);
				if (result == null) result = casePropertySetter(isVisiblePropertySetter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.TOP_LAYER_OPERATOR_DESCRIPTOR: {
				TopLayerOperatorDescriptor topLayerOperatorDescriptor = (TopLayerOperatorDescriptor)theEObject;
				T result = caseTopLayerOperatorDescriptor(topLayerOperatorDescriptor);
				if (result == null) result = caseLayerOperatorDescriptor(topLayerOperatorDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.STACKED_LAYER_OPERATOR_DESCRIPTOR: {
				StackedLayerOperatorDescriptor stackedLayerOperatorDescriptor = (StackedLayerOperatorDescriptor)theEObject;
				T result = caseStackedLayerOperatorDescriptor(stackedLayerOperatorDescriptor);
				if (result == null) result = caseLayerOperatorDescriptor(stackedLayerOperatorDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.CUSTOM_PROPERTY_OPERATOR: {
				CustomPropertyOperator customPropertyOperator = (CustomPropertyOperator)theEObject;
				T result = caseCustomPropertyOperator(customPropertyOperator);
				if (result == null) result = casePropertyOperator(customPropertyOperator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.AND_STACKED_LAYER_OPERATOR_DESCRIPTOR: {
				AndStackedLayerOperatorDescriptor andStackedLayerOperatorDescriptor = (AndStackedLayerOperatorDescriptor)theEObject;
				T result = caseAndStackedLayerOperatorDescriptor(andStackedLayerOperatorDescriptor);
				if (result == null) result = caseStackedLayerOperatorDescriptor(andStackedLayerOperatorDescriptor);
				if (result == null) result = caseLayerOperatorDescriptor(andStackedLayerOperatorDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.OR_STACKED_LAYER_OPERATOR_DESCRIPTOR: {
				OrStackedLayerOperatorDescriptor orStackedLayerOperatorDescriptor = (OrStackedLayerOperatorDescriptor)theEObject;
				T result = caseOrStackedLayerOperatorDescriptor(orStackedLayerOperatorDescriptor);
				if (result == null) result = caseStackedLayerOperatorDescriptor(orStackedLayerOperatorDescriptor);
				if (result == null) result = caseLayerOperatorDescriptor(orStackedLayerOperatorDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LayersPackage.IS_ABSTRACT_UML_SETTER: {
				IsAbstractUmlSetter isAbstractUmlSetter = (IsAbstractUmlSetter)theEObject;
				T result = caseIsAbstractUmlSetter(isAbstractUmlSetter);
				if (result == null) result = casePropertySetter(isAbstractUmlSetter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Layer Named Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Layer Named Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLayerNamedStyle(LayerNamedStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stack</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stack</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLayersStack(LayersStack object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Layer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Layer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLayer(Layer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Color</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Color</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseColor(Color object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Color Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Color Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseColorInstance(ColorInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fill Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fill Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFillInstance(FillInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fill</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fill</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFill(Fill object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fill Property Setter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fill Property Setter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFillPropertySetter(FillPropertySetter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Is Valid Property Setter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Is Valid Property Setter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIsValidPropertySetter(IsValidPropertySetter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Null Property Setter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Null Property Setter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNullPropertySetter(NullPropertySetter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Line Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Line Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLineType(LineType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Line Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Line Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLineInstance(LineInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Line Property Setter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Line Property Setter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinePropertySetter(LinePropertySetter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Font Property Setter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Font Property Setter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFontPropertySetter(FontPropertySetter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Font Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Font Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFontInstance(FontInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Font Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Font Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFontType(FontType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Is Visible Property Setter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Is Visible Property Setter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIsVisiblePropertySetter(IsVisiblePropertySetter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Layer Operator Descriptor Registry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Layer Operator Descriptor Registry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLayerOperatorDescriptorRegistry(LayerOperatorDescriptorRegistry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Top Layer Operator Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Top Layer Operator Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTopLayerOperatorDescriptor(TopLayerOperatorDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stacked Layer Operator Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stacked Layer Operator Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStackedLayerOperatorDescriptor(StackedLayerOperatorDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Custom Property Operator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Custom Property Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCustomPropertyOperator(CustomPropertyOperator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>And Stacked Layer Operator Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And Stacked Layer Operator Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAndStackedLayerOperatorDescriptor(AndStackedLayerOperatorDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or Stacked Layer Operator Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or Stacked Layer Operator Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrStackedLayerOperatorDescriptor(OrStackedLayerOperatorDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Is Abstract Uml Setter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Is Abstract Uml Setter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIsAbstractUmlSetter(IsAbstractUmlSetter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeInstance(TypeInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compute Property Value Command Itf</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compute Property Value Command Itf</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComputePropertyValueCommandItf(ComputePropertyValueCommand object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String To Type Instance Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String To Type Instance Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringToTypeInstanceMap(Map.Entry<String, TypeInstance> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Layer Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Layer Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLayerDescriptor(LayerDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Layer Application Factory</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Layer Application Factory</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLayerApplicationFactory(LayerApplicationFactory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Setter Registry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Setter Registry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertySetterRegistry(PropertySetterRegistry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Setter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Setter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertySetter(PropertySetter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String To Property Setter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String To Property Setter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringToPropertySetter(Map.Entry<String, PropertySetter> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Layer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Layer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractLayer(AbstractLayer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProperty(Property object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Folder Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Folder Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFolderElement(FolderElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Layer Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Layer Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLayerExpression(LayerExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Application Dependant Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Application Dependant Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseApplicationDependantElement(ApplicationDependantElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseType(Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Metamodel</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Metamodel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMetamodel(Metamodel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Folder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Folder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFolder(Folder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Int Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Int Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntInstance(IntInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanInstance(BooleanInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringInstance(StringInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Int Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Int Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntType(IntType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanType(BooleanType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringType(StringType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Custom Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Custom Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCustomType(CustomType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stack Application</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stack Application</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLayersStackApplication(LayersStackApplication object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Layer Stack Descriptor Registry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Layer Stack Descriptor Registry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLayerStackDescriptorRegistry(LayerStackDescriptorRegistry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Registry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Registry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyRegistry(PropertyRegistry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String To Property Index Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String To Property Index Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringToPropertyIndexMap(Map.Entry<String, PropertyIndex> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Layer Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Layer Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleLayerDescriptor(SimpleLayerDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reg Exp Layer Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reg Exp Layer Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegExpLayerDescriptor(RegExpLayerDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Null Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Null Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNullInstance(NullInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reg Exp Layer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reg Exp Layer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegExpLayer(RegExpLayer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Index</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Index</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyIndex(PropertyIndex object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Registry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Registry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeRegistry(TypeRegistry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String To Type Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String To Type Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringToTypeMap(Map.Entry<String, Type> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Layer Descriptor Registry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Layer Descriptor Registry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLayerDescriptorRegistry(LayerDescriptorRegistry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Layer Operator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Layer Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLayerOperator(LayerOperator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Layer Operator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Layer Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractLayerOperator(AbstractLayerOperator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Layer Operator Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Layer Operator Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLayerOperatorDescriptor(LayerOperatorDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Operator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyOperator(PropertyOperator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Default Property Operator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default Property Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefaultPropertyOperator(DefaultPropertyOperator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Top Layer Operator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Top Layer Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTopLayerOperator(TopLayerOperator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stacked Layer Operator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stacked Layer Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStackedLayerOperator(StackedLayerOperator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Custom Layer Operator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Custom Layer Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCustomLayerOperator(CustomLayerOperator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStyle(Style object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Style</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Style</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedStyle(NamedStyle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //LayersSwitch
