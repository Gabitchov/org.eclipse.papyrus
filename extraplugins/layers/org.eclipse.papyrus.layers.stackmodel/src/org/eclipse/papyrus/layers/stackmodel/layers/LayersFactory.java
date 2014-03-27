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
package org.eclipse.papyrus.layers.stackmodel.layers;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage
 * @generated
 */
public interface LayersFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LayersFactory eINSTANCE = org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Layer Named Style</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Layer Named Style</em>'.
	 * @generated
	 */
	LayerNamedStyle createLayerNamedStyle();

	/**
	 * Returns a new object of class '<em>Stack</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stack</em>'.
	 * @generated
	 */
	LayersStack createLayersStack();

	/**
	 * Returns a new object of class '<em>Layer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Layer</em>'.
	 * @generated
	 */
	Layer createLayer();

	/**
	 * Returns a new object of class '<em>Color</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Color</em>'.
	 * @generated
	 */
	Color createColor();

	/**
	 * Returns a new object of class '<em>Color Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Color Instance</em>'.
	 * @generated
	 */
	ColorInstance createColorInstance();

	/**
	 * Returns a new object of class '<em>Fill Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fill Instance</em>'.
	 * @generated
	 */
	FillInstance createFillInstance();

	/**
	 * Returns a new object of class '<em>Fill</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fill</em>'.
	 * @generated
	 */
	Fill createFill();

	/**
	 * Returns a new object of class '<em>Fill Property Setter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fill Property Setter</em>'.
	 * @generated
	 */
	FillPropertySetter createFillPropertySetter();

	/**
	 * Returns a new object of class '<em>Is Valid Property Setter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Is Valid Property Setter</em>'.
	 * @generated
	 */
	IsValidPropertySetter createIsValidPropertySetter();

	/**
	 * Returns a new object of class '<em>Null Property Setter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Null Property Setter</em>'.
	 * @generated
	 */
	NullPropertySetter createNullPropertySetter();

	/**
	 * Returns a new object of class '<em>Line Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Line Type</em>'.
	 * @generated
	 */
	LineType createLineType();

	/**
	 * Returns a new object of class '<em>Line Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Line Instance</em>'.
	 * @generated
	 */
	LineInstance createLineInstance();

	/**
	 * Returns a new object of class '<em>Line Property Setter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Line Property Setter</em>'.
	 * @generated
	 */
	LinePropertySetter createLinePropertySetter();

	/**
	 * Returns a new object of class '<em>Font Property Setter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Font Property Setter</em>'.
	 * @generated
	 */
	FontPropertySetter createFontPropertySetter();

	/**
	 * Returns a new object of class '<em>Font Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Font Instance</em>'.
	 * @generated
	 */
	FontInstance createFontInstance();

	/**
	 * Returns a new object of class '<em>Font Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Font Type</em>'.
	 * @generated
	 */
	FontType createFontType();

	/**
	 * Returns a new object of class '<em>Is Visible Property Setter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Is Visible Property Setter</em>'.
	 * @generated
	 */
	IsVisiblePropertySetter createIsVisiblePropertySetter();

	/**
	 * Returns a new object of class '<em>Layer Operator Descriptor Registry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Layer Operator Descriptor Registry</em>'.
	 * @generated
	 */
	LayerOperatorDescriptorRegistry createLayerOperatorDescriptorRegistry();

	/**
	 * Returns a new object of class '<em>Top Layer Operator Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Top Layer Operator Descriptor</em>'.
	 * @generated
	 */
	TopLayerOperatorDescriptor createTopLayerOperatorDescriptor();

	/**
	 * Returns a new object of class '<em>Stacked Layer Operator Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stacked Layer Operator Descriptor</em>'.
	 * @generated
	 */
	StackedLayerOperatorDescriptor createStackedLayerOperatorDescriptor();

	/**
	 * Returns a new object of class '<em>Custom Property Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Custom Property Operator</em>'.
	 * @generated
	 */
	CustomPropertyOperator createCustomPropertyOperator();

	/**
	 * Returns a new object of class '<em>And Stacked Layer Operator Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>And Stacked Layer Operator Descriptor</em>'.
	 * @generated
	 */
	AndStackedLayerOperatorDescriptor createAndStackedLayerOperatorDescriptor();

	/**
	 * Returns a new object of class '<em>Or Stacked Layer Operator Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Or Stacked Layer Operator Descriptor</em>'.
	 * @generated
	 */
	OrStackedLayerOperatorDescriptor createOrStackedLayerOperatorDescriptor();

	/**
	 * Returns a new object of class '<em>Is Abstract Uml Setter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Is Abstract Uml Setter</em>'.
	 * @generated
	 */
	IsAbstractUmlSetter createIsAbstractUmlSetter();

	/**
	 * Returns a new object of class '<em>All Views Derived Layer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>All Views Derived Layer</em>'.
	 * @generated
	 */
	AllViewsDerivedLayer createAllViewsDerivedLayer();

	/**
	 * Returns a new object of class '<em>Layer Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Layer Descriptor</em>'.
	 * @generated
	 */
	LayerDescriptor createLayerDescriptor();

	/**
	 * Returns a new object of class '<em>Layer Application Factory</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Layer Application Factory</em>'.
	 * @generated
	 */
	LayerApplicationFactory createLayerApplicationFactory();

	/**
	 * Returns a new object of class '<em>Property Setter Registry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Setter Registry</em>'.
	 * @generated
	 */
	PropertySetterRegistry createPropertySetterRegistry();

	/**
	 * Returns a new object of class '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property</em>'.
	 * @generated
	 */
	Property createProperty();

	/**
	 * Returns a new object of class '<em>Metamodel</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Metamodel</em>'.
	 * @generated
	 */
	Metamodel createMetamodel();

	/**
	 * Returns a new object of class '<em>Folder</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Folder</em>'.
	 * @generated
	 */
	Folder createFolder();

	/**
	 * Returns a new object of class '<em>Int Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Int Instance</em>'.
	 * @generated
	 */
	IntInstance createIntInstance();

	/**
	 * Returns a new object of class '<em>Boolean Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Instance</em>'.
	 * @generated
	 */
	BooleanInstance createBooleanInstance();

	/**
	 * Returns a new object of class '<em>String Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Instance</em>'.
	 * @generated
	 */
	StringInstance createStringInstance();

	/**
	 * Returns a new object of class '<em>Int Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Int Type</em>'.
	 * @generated
	 */
	IntType createIntType();

	/**
	 * Returns a new object of class '<em>Boolean Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Type</em>'.
	 * @generated
	 */
	BooleanType createBooleanType();

	/**
	 * Returns a new object of class '<em>String Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Type</em>'.
	 * @generated
	 */
	StringType createStringType();

	/**
	 * Returns a new object of class '<em>Custom Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Custom Type</em>'.
	 * @generated
	 */
	CustomType createCustomType();

	/**
	 * Returns a new object of class '<em>Layer Operator Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Layer Operator Descriptor</em>'.
	 * @generated
	 */
	LayerOperatorDescriptor createLayerOperatorDescriptor();

	/**
	 * Returns a new object of class '<em>Property Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Operator</em>'.
	 * @generated
	 */
	PropertyOperator createPropertyOperator();

	/**
	 * Returns a new object of class '<em>Default Property Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Default Property Operator</em>'.
	 * @generated
	 */
	DefaultPropertyOperator createDefaultPropertyOperator();

	/**
	 * Returns a new object of class '<em>Stack Application</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stack Application</em>'.
	 * @generated
	 */
	LayersStackApplication createLayersStackApplication();

	/**
	 * Returns a new object of class '<em>Layer Stack Descriptor Registry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Layer Stack Descriptor Registry</em>'.
	 * @generated
	 */
	LayerStackDescriptorRegistry createLayerStackDescriptorRegistry();

	/**
	 * Returns a new object of class '<em>Property Registry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Registry</em>'.
	 * @generated
	 */
	PropertyRegistry createPropertyRegistry();

	/**
	 * Returns a new object of class '<em>Property Index</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Index</em>'.
	 * @generated
	 */
	PropertyIndex createPropertyIndex();

	/**
	 * Returns a new object of class '<em>Simple Layer Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Layer Descriptor</em>'.
	 * @generated
	 */
	SimpleLayerDescriptor createSimpleLayerDescriptor();

	/**
	 * Returns a new object of class '<em>Reg Exp Layer Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reg Exp Layer Descriptor</em>'.
	 * @generated
	 */
	RegExpLayerDescriptor createRegExpLayerDescriptor();

	/**
	 * Returns a new object of class '<em>Null Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Null Instance</em>'.
	 * @generated
	 */
	NullInstance createNullInstance();

	/**
	 * Returns a new object of class '<em>Reg Exp Layer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reg Exp Layer</em>'.
	 * @generated
	 */
	RegExpLayer createRegExpLayer();

	/**
	 * Returns a new object of class '<em>Type Registry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Registry</em>'.
	 * @generated
	 */
	TypeRegistry createTypeRegistry();

	/**
	 * Returns a new object of class '<em>Layer Descriptor Registry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Layer Descriptor Registry</em>'.
	 * @generated
	 */
	LayerDescriptorRegistry createLayerDescriptorRegistry();

	/**
	 * Returns a new object of class '<em>Top Layer Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Top Layer Operator</em>'.
	 * @generated
	 */
	TopLayerOperator createTopLayerOperator();

	/**
	 * Returns a new object of class '<em>Stacked Layer Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stacked Layer Operator</em>'.
	 * @generated
	 */
	StackedLayerOperator createStackedLayerOperator();

	/**
	 * Returns a new object of class '<em>Custom Layer Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Custom Layer Operator</em>'.
	 * @generated
	 */
	CustomLayerOperator createCustomLayerOperator();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	LayersPackage getLayersPackage();

} //LayersFactory
