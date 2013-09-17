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
package org.eclipse.papyrus.layers.stackmodel.layers.impl;

import java.util.Map;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.layers.stackmodel.BadStateException;
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.NotFoundException;
import org.eclipse.papyrus.layers.stackmodel.command.ComputePropertyValueCommand;
import org.eclipse.papyrus.layers.stackmodel.layers.AbstractLayer;
import org.eclipse.papyrus.layers.stackmodel.layers.AbstractLayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.AndStackedLayerOperatorDescriptor;
import org.eclipse.papyrus.layers.stackmodel.layers.ApplicationDependantElement;
import org.eclipse.papyrus.layers.stackmodel.layers.BooleanInstance;
import org.eclipse.papyrus.layers.stackmodel.layers.BooleanType;
import org.eclipse.papyrus.layers.stackmodel.layers.Color;
import org.eclipse.papyrus.layers.stackmodel.layers.ColorInstance;
import org.eclipse.papyrus.layers.stackmodel.layers.CustomLayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.CustomPropertyOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.CustomType;
import org.eclipse.papyrus.layers.stackmodel.layers.DefaultPropertyOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.Fill;
import org.eclipse.papyrus.layers.stackmodel.layers.FillInstance;
import org.eclipse.papyrus.layers.stackmodel.layers.FillPropertySetter;
import org.eclipse.papyrus.layers.stackmodel.layers.Folder;
import org.eclipse.papyrus.layers.stackmodel.layers.FolderElement;
import org.eclipse.papyrus.layers.stackmodel.layers.FontInstance;
import org.eclipse.papyrus.layers.stackmodel.layers.FontPropertySetter;
import org.eclipse.papyrus.layers.stackmodel.layers.FontType;
import org.eclipse.papyrus.layers.stackmodel.layers.IntInstance;
import org.eclipse.papyrus.layers.stackmodel.layers.IntType;
import org.eclipse.papyrus.layers.stackmodel.layers.IsAbstractUmlSetter;
import org.eclipse.papyrus.layers.stackmodel.layers.IsValidPropertySetter;
import org.eclipse.papyrus.layers.stackmodel.layers.IsVisiblePropertySetter;
import org.eclipse.papyrus.layers.stackmodel.layers.Layer;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerApplicationFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerDescriptor;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerDescriptorRegistry;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerExpression;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerNamedStyle;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptor;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptorRegistry;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerStackDescriptorRegistry;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;
import org.eclipse.papyrus.layers.stackmodel.layers.LineInstance;
import org.eclipse.papyrus.layers.stackmodel.layers.LinePropertySetter;
import org.eclipse.papyrus.layers.stackmodel.layers.LineType;
import org.eclipse.papyrus.layers.stackmodel.layers.Metamodel;
import org.eclipse.papyrus.layers.stackmodel.layers.NullInstance;
import org.eclipse.papyrus.layers.stackmodel.layers.NullPropertySetter;
import org.eclipse.papyrus.layers.stackmodel.layers.OrStackedLayerOperatorDescriptor;
import org.eclipse.papyrus.layers.stackmodel.layers.Property;
import org.eclipse.papyrus.layers.stackmodel.layers.PropertyIndex;
import org.eclipse.papyrus.layers.stackmodel.layers.PropertyOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.PropertyRegistry;
import org.eclipse.papyrus.layers.stackmodel.layers.PropertySetter;
import org.eclipse.papyrus.layers.stackmodel.layers.PropertySetterRegistry;
import org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayer;
import org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayerDescriptor;
import org.eclipse.papyrus.layers.stackmodel.layers.SimpleLayerDescriptor;
import org.eclipse.papyrus.layers.stackmodel.layers.StackedLayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.StackedLayerOperatorDescriptor;
import org.eclipse.papyrus.layers.stackmodel.layers.StringInstance;
import org.eclipse.papyrus.layers.stackmodel.layers.StringType;
import org.eclipse.papyrus.layers.stackmodel.layers.TopLayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.TopLayerOperatorDescriptor;
import org.eclipse.papyrus.layers.stackmodel.layers.Type;
import org.eclipse.papyrus.layers.stackmodel.layers.TypeInstance;
import org.eclipse.papyrus.layers.stackmodel.layers.TypeRegistry;
import org.eclipse.papyrus.layers.stackmodel.operators.CustomPropertyOperatorsInstance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LayersPackageImpl extends EPackageImpl implements LayersPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layerNamedStyleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layersStackEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layerExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass applicationDependantElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layersStackApplicationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass folderElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layerStackDescriptorRegistryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyRegistryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metamodelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass computePropertyValueCommandItfEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeRegistryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringToTypeMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layerDescriptorRegistryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layerDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layerApplicationFactoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertySetterRegistryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertySetterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringToPropertySetterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractLayerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringToTypeInstanceMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass folderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass customTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layerOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractLayerOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layerOperatorDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass defaultPropertyOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topLayerOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stackedLayerOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass customLayerOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyIndexEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringToPropertyIndexMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleLayerDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass regExpLayerDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nullInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass regExpLayerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass colorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass colorInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fillInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fillEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fillPropertySetterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass isValidPropertySetterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nullPropertySetterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lineTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lineInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linePropertySetterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fontPropertySetterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fontInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fontTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass isVisiblePropertySetterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass layerOperatorDescriptorRegistryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topLayerOperatorDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stackedLayerOperatorDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass customPropertyOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass andStackedLayerOperatorDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orStackedLayerOperatorDescriptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass isAbstractUmlSetterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType stringEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType booleanEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType ePackageEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType badStateExceptionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType layersExceptionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType notFoundExceptionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType computePropertyValueCommandEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType intEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType objectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType customPropertyOpertorInstanceEDataType = null;

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
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LayersPackageImpl() {
		super(eNS_URI, LayersFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link LayersPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LayersPackage init() {
		if (isInited) return (LayersPackage)EPackage.Registry.INSTANCE.getEPackage(LayersPackage.eNS_URI);

		// Obtain or create and register package
		LayersPackageImpl theLayersPackage = (LayersPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof LayersPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new LayersPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		NotationPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theLayersPackage.createPackageContents();

		// Initialize created meta-data
		theLayersPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLayersPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(LayersPackage.eNS_URI, theLayersPackage);
		return theLayersPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayerNamedStyle() {
		return layerNamedStyleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayerNamedStyle_LayersStack() {
		return (EReference)layerNamedStyleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayersStack() {
		return layersStackEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayersStack_Layers() {
		return (EReference)layersStackEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayersStack_Name() {
		return (EAttribute)layersStackEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayersStack_Description() {
		return (EAttribute)layersStackEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayersStack_Diagram() {
		return (EReference)layersStackEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayersStack__GetComputePropertyValueCommand__View_Property() {
		return layersStackEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayersStack__GetPropertiesComputePropertyValueCommand__View_EList() {
		return layersStackEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayersStack__GetViewsComputePropertyValueCommand__EList_Property() {
		return layersStackEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayerExpression() {
		return layerExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayerExpression_Name() {
		return (EAttribute)layerExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayerExpression_Description() {
		return (EAttribute)layerExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayerExpression_IsEnabled() {
		return (EAttribute)layerExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayerExpression_IsUserEnabled() {
		return (EAttribute)layerExpressionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerExpression__GetComputePropertyValueCommand__View_Property() {
		return layerExpressionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerExpression__GetViewsComputePropertyValueCommand__EList_Property() {
		return layerExpressionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerExpression__GetPropertiesComputePropertyValueCommand__View_EList() {
		return layerExpressionEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerExpression__GetLayersStack() {
		return layerExpressionEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getApplicationDependantElement() {
		return applicationDependantElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getApplicationDependantElement_Application() {
		return (EReference)applicationDependantElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayersStackApplication() {
		return layersStackApplicationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayersStackApplication_LayersStacks() {
		return (EReference)layersStackApplicationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayersStackApplication_LayerStackRegistry() {
		return (EReference)layersStackApplicationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayersStackApplication_PropertyRegistry() {
		return (EReference)layersStackApplicationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayersStackApplication_LayerDescriptorRegistry() {
		return (EReference)layersStackApplicationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayersStackApplication_Factory() {
		return (EReference)layersStackApplicationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayersStackApplication_PropertySetterRegistry() {
		return (EReference)layersStackApplicationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayersStackApplication_LayerOperatorDescriptorRegistry() {
		return (EReference)layersStackApplicationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayersStackApplication__GetLayersStackFor__Diagram() {
		return layersStackApplicationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayersStackApplication__RemoveLayersStackFor__Diagram() {
		return layersStackApplicationEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayersStackApplication__IsLayersStackAttachedFor__Diagram() {
		return layersStackApplicationEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayersStackApplication__CreateLayersStackFor__Diagram() {
		return layersStackApplicationEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayersStackApplication__LookupLayersStackFor__Diagram() {
		return layersStackApplicationEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFolderElement() {
		return folderElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayerStackDescriptorRegistry() {
		return layerStackDescriptorRegistryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyRegistry() {
		return propertyRegistryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyRegistry_Properties() {
		return (EReference)propertyRegistryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyRegistry_TypeRegistry() {
		return (EReference)propertyRegistryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyRegistry_PropertiesCount() {
		return (EAttribute)propertyRegistryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertyRegistry__GetPropertyIndex__String() {
		return propertyRegistryEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertyRegistry__GetProperty__String() {
		return propertyRegistryEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertyRegistry__AddProperty__Property() {
		return propertyRegistryEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProperty() {
		return propertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProperty_Type() {
		return (EReference)propertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProperty_DefaultValue() {
		return (EReference)propertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Name() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Description() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Index() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getProperty__CreateInstance() {
		return propertyEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getType() {
		return typeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getType_Metamodel() {
		return (EReference)typeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getType_Name() {
		return (EAttribute)typeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getType_Description() {
		return (EAttribute)typeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getType__CreateInstance() {
		return typeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetamodel() {
		return metamodelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetamodel_Name() {
		return (EAttribute)metamodelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetamodel_Description() {
		return (EAttribute)metamodelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetamodel_Nsuri() {
		return (EAttribute)metamodelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetamodel_PluginID() {
		return (EAttribute)metamodelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetamodel_EPackageInstanceName() {
		return (EAttribute)metamodelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetamodel_IsTypeValid() {
		return (EAttribute)metamodelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMetamodel__GetEPackage() {
		return metamodelEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeInstance() {
		return typeInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComputePropertyValueCommandItf() {
		return computePropertyValueCommandItfEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getComputePropertyValueCommandItf__GetCmdValue() {
		return computePropertyValueCommandItfEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeRegistry() {
		return typeRegistryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeRegistry_Types() {
		return (EReference)typeRegistryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringToTypeMap() {
		return stringToTypeMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStringToTypeMap_Value() {
		return (EReference)stringToTypeMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringToTypeMap_Key() {
		return (EAttribute)stringToTypeMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayerDescriptorRegistry() {
		return layerDescriptorRegistryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayerDescriptorRegistry_LayerDescriptors() {
		return (EReference)layerDescriptorRegistryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayerDescriptor() {
		return layerDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayerDescriptor_PropertyRegistry() {
		return (EReference)layerDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayerApplicationFactory() {
		return layerApplicationFactoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayerApplicationFactory_Application() {
		return (EReference)layerApplicationFactoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertySetterRegistry() {
		return propertySetterRegistryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertySetterRegistry_PropertySetters() {
		return (EReference)propertySetterRegistryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertySetterRegistry_SetterMap() {
		return (EReference)propertySetterRegistryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertySetterRegistry_Application() {
		return (EReference)propertySetterRegistryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertySetterRegistry__GetPropertySetter__Property() {
		return propertySetterRegistryEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertySetterRegistry__GetPropertySetter__String() {
		return propertySetterRegistryEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertySetterRegistry__AddPropertySetter__PropertySetter() {
		return propertySetterRegistryEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertySetter() {
		return propertySetterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertySetter_Property() {
		return (EReference)propertySetterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertySetter_PropertyName() {
		return (EAttribute)propertySetterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertySetter__SetValue__View_TypeInstance() {
		return propertySetterEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringToPropertySetter() {
		return stringToPropertySetterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringToPropertySetter_Key() {
		return (EAttribute)stringToPropertySetterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStringToPropertySetter_Value() {
		return (EReference)stringToPropertySetterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractLayer() {
		return abstractLayerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractLayer_PropertyValues() {
		return (EReference)abstractLayerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractLayer_PropertyValueMap() {
		return (EReference)abstractLayerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractLayer_LayerDescriptor() {
		return (EReference)abstractLayerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractLayer_Views() {
		return (EReference)abstractLayerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractLayer_AttachedProperties() {
		return (EReference)abstractLayerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractLayer__AddPropertyInstance__Property() {
		return abstractLayerEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractLayer__RemovePropertyInstance__Property() {
		return abstractLayerEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractLayer__GetPropertyInstance__Property() {
		return abstractLayerEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractLayer__GetPropertyInstance__String() {
		return abstractLayerEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringToTypeInstanceMap() {
		return stringToTypeInstanceMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringToTypeInstanceMap_Key() {
		return (EAttribute)stringToTypeInstanceMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStringToTypeInstanceMap_Value() {
		return (EReference)stringToTypeInstanceMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFolder() {
		return folderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFolder_Elements() {
		return (EReference)folderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFolder_Name() {
		return (EAttribute)folderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntInstance() {
		return intInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntInstance_Value() {
		return (EAttribute)intInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanInstance() {
		return booleanInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanInstance_Value() {
		return (EAttribute)booleanInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringInstance() {
		return stringInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringInstance_Value() {
		return (EAttribute)stringInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntType() {
		return intTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanType() {
		return booleanTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringType() {
		return stringTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCustomType() {
		return customTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCustomType_Classifier() {
		return (EAttribute)customTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayerOperator() {
		return layerOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayerOperator_Layers() {
		return (EReference)layerOperatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractLayerOperator() {
		return abstractLayerOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractLayerOperator_LayerOperatorDescriptor() {
		return (EReference)abstractLayerOperatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractLayerOperator_LayerOperatorDescriptorName() {
		return (EAttribute)abstractLayerOperatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractLayerOperator__IsDescriptorSet() {
		return abstractLayerOperatorEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractLayerOperator__ResetDescriptor() {
		return abstractLayerOperatorEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayerOperatorDescriptor() {
		return layerOperatorDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayerOperatorDescriptor_PropertyOperators() {
		return (EReference)layerOperatorDescriptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayerOperatorDescriptor_Name() {
		return (EAttribute)layerOperatorDescriptorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerOperatorDescriptor__GetPropertyOperator__Property() {
		return layerOperatorDescriptorEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerOperatorDescriptor__SetPropertyOperator__Property_PropertyOperator() {
		return layerOperatorDescriptorEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerOperatorDescriptor__CreateLayerOperator() {
		return layerOperatorDescriptorEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerOperatorDescriptor__SetPropertyCollectionSize__int_DefaultPropertyOperator() {
		return layerOperatorDescriptorEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyOperator() {
		return propertyOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyOperator_Name() {
		return (EAttribute)propertyOperatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPropertyOperator__GetComputePropertyValueCommand__EList() {
		return propertyOperatorEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefaultPropertyOperator() {
		return defaultPropertyOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTopLayerOperator() {
		return topLayerOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStackedLayerOperator() {
		return stackedLayerOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCustomLayerOperator() {
		return customLayerOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyIndex() {
		return propertyIndexEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyIndex_Property() {
		return (EReference)propertyIndexEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyIndex_Index() {
		return (EAttribute)propertyIndexEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringToPropertyIndexMap() {
		return stringToPropertyIndexMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStringToPropertyIndexMap_Value() {
		return (EReference)stringToPropertyIndexMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringToPropertyIndexMap_Key() {
		return (EAttribute)stringToPropertyIndexMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleLayerDescriptor() {
		return simpleLayerDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRegExpLayerDescriptor() {
		return regExpLayerDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNullInstance() {
		return nullInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNullInstance__GetInstance() {
		return nullInstanceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRegExpLayer() {
		return regExpLayerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRegExpLayer_Expr() {
		return (EAttribute)regExpLayerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRegExpLayer_Language() {
		return (EAttribute)regExpLayerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRegExpLayer__Activate__AbstractLayerOperator() {
		return regExpLayerEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRegExpLayer__Deactivate__AbstractLayerOperator() {
		return regExpLayerEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRegExpLayer__EvaluateExpr() {
		return regExpLayerEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayer() {
		return layerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getColor() {
		return colorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getColorInstance() {
		return colorInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getColorInstance_Value() {
		return (EAttribute)colorInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFillInstance() {
		return fillInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFillInstance_Transparency() {
		return (EAttribute)fillInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFillInstance_FillColor() {
		return (EReference)fillInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFill() {
		return fillEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFillPropertySetter() {
		return fillPropertySetterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIsValidPropertySetter() {
		return isValidPropertySetterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNullPropertySetter() {
		return nullPropertySetterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLineType() {
		return lineTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLineInstance() {
		return lineInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLineInstance_LineColor() {
		return (EAttribute)lineInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLineInstance_LineWith() {
		return (EAttribute)lineInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinePropertySetter() {
		return linePropertySetterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFontPropertySetter() {
		return fontPropertySetterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFontInstance() {
		return fontInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFontInstance_FontColor() {
		return (EAttribute)fontInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFontInstance_FontName() {
		return (EAttribute)fontInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFontInstance_FontHeigh() {
		return (EAttribute)fontInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFontInstance_Bold() {
		return (EAttribute)fontInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFontType() {
		return fontTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIsVisiblePropertySetter() {
		return isVisiblePropertySetterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLayerOperatorDescriptorRegistry() {
		return layerOperatorDescriptorRegistryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayerOperatorDescriptorRegistry_Descriptors() {
		return (EReference)layerOperatorDescriptorRegistryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayerOperatorDescriptorRegistry_PropertyOperators() {
		return (EReference)layerOperatorDescriptorRegistryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLayerOperatorDescriptorRegistry_PropertyCollectionSize() {
		return (EAttribute)layerOperatorDescriptorRegistryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLayerOperatorDescriptorRegistry_DefaultOperator() {
		return (EReference)layerOperatorDescriptorRegistryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerOperatorDescriptorRegistry__AddLayerOperatorDescriptor__LayerOperatorDescriptor() {
		return layerOperatorDescriptorRegistryEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerOperatorDescriptorRegistry__GetLayerOperatorDescriptor__String() {
		return layerOperatorDescriptorRegistryEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerOperatorDescriptorRegistry__AddPropertyOperator__PropertyOperator() {
		return layerOperatorDescriptorRegistryEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerOperatorDescriptorRegistry__GetPropertyOperator__String() {
		return layerOperatorDescriptorRegistryEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerOperatorDescriptorRegistry__AttachOperatorToDescriptor__Property_String_String() {
		return layerOperatorDescriptorRegistryEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLayerOperatorDescriptorRegistry__CreateLayerOperator__String() {
		return layerOperatorDescriptorRegistryEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTopLayerOperatorDescriptor() {
		return topLayerOperatorDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStackedLayerOperatorDescriptor() {
		return stackedLayerOperatorDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCustomPropertyOperator() {
		return customPropertyOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCustomPropertyOperator_Classname() {
		return (EAttribute)customPropertyOperatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCustomPropertyOperator_OperatorInstance() {
		return (EAttribute)customPropertyOperatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCustomPropertyOperator_ClassBundleID() {
		return (EAttribute)customPropertyOperatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getCustomPropertyOperator__ResetOperatorInstance() {
		return customPropertyOperatorEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAndStackedLayerOperatorDescriptor() {
		return andStackedLayerOperatorDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrStackedLayerOperatorDescriptor() {
		return orStackedLayerOperatorDescriptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIsAbstractUmlSetter() {
		return isAbstractUmlSetterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getString() {
		return stringEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getboolean() {
		return booleanEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEPackage() {
		return ePackageEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getBadStateException() {
		return badStateExceptionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLayersException() {
		return layersExceptionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getNotFoundException() {
		return notFoundExceptionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getComputePropertyValueCommand() {
		return computePropertyValueCommandEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getint() {
		return intEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getObject() {
		return objectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getCustomPropertyOpertorInstance() {
		return customPropertyOpertorInstanceEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LayersFactory getLayersFactory() {
		return (LayersFactory)getEFactoryInstance();
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

		// Create classes and their features
		layerNamedStyleEClass = createEClass(LAYER_NAMED_STYLE);
		createEReference(layerNamedStyleEClass, LAYER_NAMED_STYLE__LAYERS_STACK);

		layersStackEClass = createEClass(LAYERS_STACK);
		createEReference(layersStackEClass, LAYERS_STACK__LAYERS);
		createEAttribute(layersStackEClass, LAYERS_STACK__NAME);
		createEAttribute(layersStackEClass, LAYERS_STACK__DESCRIPTION);
		createEReference(layersStackEClass, LAYERS_STACK__DIAGRAM);
		createEOperation(layersStackEClass, LAYERS_STACK___GET_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_PROPERTY);
		createEOperation(layersStackEClass, LAYERS_STACK___GET_PROPERTIES_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_ELIST);
		createEOperation(layersStackEClass, LAYERS_STACK___GET_VIEWS_COMPUTE_PROPERTY_VALUE_COMMAND__ELIST_PROPERTY);

		layerExpressionEClass = createEClass(LAYER_EXPRESSION);
		createEAttribute(layerExpressionEClass, LAYER_EXPRESSION__NAME);
		createEAttribute(layerExpressionEClass, LAYER_EXPRESSION__DESCRIPTION);
		createEAttribute(layerExpressionEClass, LAYER_EXPRESSION__IS_ENABLED);
		createEAttribute(layerExpressionEClass, LAYER_EXPRESSION__IS_USER_ENABLED);
		createEOperation(layerExpressionEClass, LAYER_EXPRESSION___GET_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_PROPERTY);
		createEOperation(layerExpressionEClass, LAYER_EXPRESSION___GET_VIEWS_COMPUTE_PROPERTY_VALUE_COMMAND__ELIST_PROPERTY);
		createEOperation(layerExpressionEClass, LAYER_EXPRESSION___GET_PROPERTIES_COMPUTE_PROPERTY_VALUE_COMMAND__VIEW_ELIST);
		createEOperation(layerExpressionEClass, LAYER_EXPRESSION___GET_LAYERS_STACK);

		applicationDependantElementEClass = createEClass(APPLICATION_DEPENDANT_ELEMENT);
		createEReference(applicationDependantElementEClass, APPLICATION_DEPENDANT_ELEMENT__APPLICATION);

		layersStackApplicationEClass = createEClass(LAYERS_STACK_APPLICATION);
		createEReference(layersStackApplicationEClass, LAYERS_STACK_APPLICATION__LAYERS_STACKS);
		createEReference(layersStackApplicationEClass, LAYERS_STACK_APPLICATION__LAYER_STACK_REGISTRY);
		createEReference(layersStackApplicationEClass, LAYERS_STACK_APPLICATION__PROPERTY_REGISTRY);
		createEReference(layersStackApplicationEClass, LAYERS_STACK_APPLICATION__LAYER_DESCRIPTOR_REGISTRY);
		createEReference(layersStackApplicationEClass, LAYERS_STACK_APPLICATION__FACTORY);
		createEReference(layersStackApplicationEClass, LAYERS_STACK_APPLICATION__PROPERTY_SETTER_REGISTRY);
		createEReference(layersStackApplicationEClass, LAYERS_STACK_APPLICATION__LAYER_OPERATOR_DESCRIPTOR_REGISTRY);
		createEOperation(layersStackApplicationEClass, LAYERS_STACK_APPLICATION___GET_LAYERS_STACK_FOR__DIAGRAM);
		createEOperation(layersStackApplicationEClass, LAYERS_STACK_APPLICATION___REMOVE_LAYERS_STACK_FOR__DIAGRAM);
		createEOperation(layersStackApplicationEClass, LAYERS_STACK_APPLICATION___IS_LAYERS_STACK_ATTACHED_FOR__DIAGRAM);
		createEOperation(layersStackApplicationEClass, LAYERS_STACK_APPLICATION___CREATE_LAYERS_STACK_FOR__DIAGRAM);
		createEOperation(layersStackApplicationEClass, LAYERS_STACK_APPLICATION___LOOKUP_LAYERS_STACK_FOR__DIAGRAM);

		folderElementEClass = createEClass(FOLDER_ELEMENT);

		layerStackDescriptorRegistryEClass = createEClass(LAYER_STACK_DESCRIPTOR_REGISTRY);

		propertyRegistryEClass = createEClass(PROPERTY_REGISTRY);
		createEReference(propertyRegistryEClass, PROPERTY_REGISTRY__PROPERTIES);
		createEReference(propertyRegistryEClass, PROPERTY_REGISTRY__TYPE_REGISTRY);
		createEAttribute(propertyRegistryEClass, PROPERTY_REGISTRY__PROPERTIES_COUNT);
		createEOperation(propertyRegistryEClass, PROPERTY_REGISTRY___GET_PROPERTY_INDEX__STRING);
		createEOperation(propertyRegistryEClass, PROPERTY_REGISTRY___GET_PROPERTY__STRING);
		createEOperation(propertyRegistryEClass, PROPERTY_REGISTRY___ADD_PROPERTY__PROPERTY);

		propertyEClass = createEClass(PROPERTY);
		createEReference(propertyEClass, PROPERTY__TYPE);
		createEReference(propertyEClass, PROPERTY__DEFAULT_VALUE);
		createEAttribute(propertyEClass, PROPERTY__NAME);
		createEAttribute(propertyEClass, PROPERTY__DESCRIPTION);
		createEAttribute(propertyEClass, PROPERTY__INDEX);
		createEOperation(propertyEClass, PROPERTY___CREATE_INSTANCE);

		typeEClass = createEClass(TYPE);
		createEReference(typeEClass, TYPE__METAMODEL);
		createEAttribute(typeEClass, TYPE__NAME);
		createEAttribute(typeEClass, TYPE__DESCRIPTION);
		createEOperation(typeEClass, TYPE___CREATE_INSTANCE);

		metamodelEClass = createEClass(METAMODEL);
		createEAttribute(metamodelEClass, METAMODEL__NAME);
		createEAttribute(metamodelEClass, METAMODEL__DESCRIPTION);
		createEAttribute(metamodelEClass, METAMODEL__NSURI);
		createEAttribute(metamodelEClass, METAMODEL__PLUGIN_ID);
		createEAttribute(metamodelEClass, METAMODEL__EPACKAGE_INSTANCE_NAME);
		createEAttribute(metamodelEClass, METAMODEL__IS_TYPE_VALID);
		createEOperation(metamodelEClass, METAMODEL___GET_EPACKAGE);

		typeInstanceEClass = createEClass(TYPE_INSTANCE);

		computePropertyValueCommandItfEClass = createEClass(COMPUTE_PROPERTY_VALUE_COMMAND_ITF);
		createEOperation(computePropertyValueCommandItfEClass, COMPUTE_PROPERTY_VALUE_COMMAND_ITF___GET_CMD_VALUE);

		typeRegistryEClass = createEClass(TYPE_REGISTRY);
		createEReference(typeRegistryEClass, TYPE_REGISTRY__TYPES);

		stringToTypeMapEClass = createEClass(STRING_TO_TYPE_MAP);
		createEReference(stringToTypeMapEClass, STRING_TO_TYPE_MAP__VALUE);
		createEAttribute(stringToTypeMapEClass, STRING_TO_TYPE_MAP__KEY);

		layerDescriptorRegistryEClass = createEClass(LAYER_DESCRIPTOR_REGISTRY);
		createEReference(layerDescriptorRegistryEClass, LAYER_DESCRIPTOR_REGISTRY__LAYER_DESCRIPTORS);

		layerDescriptorEClass = createEClass(LAYER_DESCRIPTOR);
		createEReference(layerDescriptorEClass, LAYER_DESCRIPTOR__PROPERTY_REGISTRY);

		layerApplicationFactoryEClass = createEClass(LAYER_APPLICATION_FACTORY);
		createEReference(layerApplicationFactoryEClass, LAYER_APPLICATION_FACTORY__APPLICATION);

		propertySetterRegistryEClass = createEClass(PROPERTY_SETTER_REGISTRY);
		createEReference(propertySetterRegistryEClass, PROPERTY_SETTER_REGISTRY__PROPERTY_SETTERS);
		createEReference(propertySetterRegistryEClass, PROPERTY_SETTER_REGISTRY__SETTER_MAP);
		createEReference(propertySetterRegistryEClass, PROPERTY_SETTER_REGISTRY__APPLICATION);
		createEOperation(propertySetterRegistryEClass, PROPERTY_SETTER_REGISTRY___GET_PROPERTY_SETTER__PROPERTY);
		createEOperation(propertySetterRegistryEClass, PROPERTY_SETTER_REGISTRY___GET_PROPERTY_SETTER__STRING);
		createEOperation(propertySetterRegistryEClass, PROPERTY_SETTER_REGISTRY___ADD_PROPERTY_SETTER__PROPERTYSETTER);

		propertySetterEClass = createEClass(PROPERTY_SETTER);
		createEReference(propertySetterEClass, PROPERTY_SETTER__PROPERTY);
		createEAttribute(propertySetterEClass, PROPERTY_SETTER__PROPERTY_NAME);
		createEOperation(propertySetterEClass, PROPERTY_SETTER___SET_VALUE__VIEW_TYPEINSTANCE);

		stringToPropertySetterEClass = createEClass(STRING_TO_PROPERTY_SETTER);
		createEAttribute(stringToPropertySetterEClass, STRING_TO_PROPERTY_SETTER__KEY);
		createEReference(stringToPropertySetterEClass, STRING_TO_PROPERTY_SETTER__VALUE);

		layerOperatorDescriptorRegistryEClass = createEClass(LAYER_OPERATOR_DESCRIPTOR_REGISTRY);
		createEReference(layerOperatorDescriptorRegistryEClass, LAYER_OPERATOR_DESCRIPTOR_REGISTRY__DESCRIPTORS);
		createEReference(layerOperatorDescriptorRegistryEClass, LAYER_OPERATOR_DESCRIPTOR_REGISTRY__PROPERTY_OPERATORS);
		createEAttribute(layerOperatorDescriptorRegistryEClass, LAYER_OPERATOR_DESCRIPTOR_REGISTRY__PROPERTY_COLLECTION_SIZE);
		createEReference(layerOperatorDescriptorRegistryEClass, LAYER_OPERATOR_DESCRIPTOR_REGISTRY__DEFAULT_OPERATOR);
		createEOperation(layerOperatorDescriptorRegistryEClass, LAYER_OPERATOR_DESCRIPTOR_REGISTRY___ADD_LAYER_OPERATOR_DESCRIPTOR__LAYEROPERATORDESCRIPTOR);
		createEOperation(layerOperatorDescriptorRegistryEClass, LAYER_OPERATOR_DESCRIPTOR_REGISTRY___GET_LAYER_OPERATOR_DESCRIPTOR__STRING);
		createEOperation(layerOperatorDescriptorRegistryEClass, LAYER_OPERATOR_DESCRIPTOR_REGISTRY___ADD_PROPERTY_OPERATOR__PROPERTYOPERATOR);
		createEOperation(layerOperatorDescriptorRegistryEClass, LAYER_OPERATOR_DESCRIPTOR_REGISTRY___GET_PROPERTY_OPERATOR__STRING);
		createEOperation(layerOperatorDescriptorRegistryEClass, LAYER_OPERATOR_DESCRIPTOR_REGISTRY___ATTACH_OPERATOR_TO_DESCRIPTOR__PROPERTY_STRING_STRING);
		createEOperation(layerOperatorDescriptorRegistryEClass, LAYER_OPERATOR_DESCRIPTOR_REGISTRY___CREATE_LAYER_OPERATOR__STRING);

		layerOperatorDescriptorEClass = createEClass(LAYER_OPERATOR_DESCRIPTOR);
		createEReference(layerOperatorDescriptorEClass, LAYER_OPERATOR_DESCRIPTOR__PROPERTY_OPERATORS);
		createEAttribute(layerOperatorDescriptorEClass, LAYER_OPERATOR_DESCRIPTOR__NAME);
		createEOperation(layerOperatorDescriptorEClass, LAYER_OPERATOR_DESCRIPTOR___GET_PROPERTY_OPERATOR__PROPERTY);
		createEOperation(layerOperatorDescriptorEClass, LAYER_OPERATOR_DESCRIPTOR___SET_PROPERTY_OPERATOR__PROPERTY_PROPERTYOPERATOR);
		createEOperation(layerOperatorDescriptorEClass, LAYER_OPERATOR_DESCRIPTOR___CREATE_LAYER_OPERATOR);
		createEOperation(layerOperatorDescriptorEClass, LAYER_OPERATOR_DESCRIPTOR___SET_PROPERTY_COLLECTION_SIZE__INT_DEFAULTPROPERTYOPERATOR);

		propertyOperatorEClass = createEClass(PROPERTY_OPERATOR);
		createEAttribute(propertyOperatorEClass, PROPERTY_OPERATOR__NAME);
		createEOperation(propertyOperatorEClass, PROPERTY_OPERATOR___GET_COMPUTE_PROPERTY_VALUE_COMMAND__ELIST);

		abstractLayerOperatorEClass = createEClass(ABSTRACT_LAYER_OPERATOR);
		createEReference(abstractLayerOperatorEClass, ABSTRACT_LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR);
		createEAttribute(abstractLayerOperatorEClass, ABSTRACT_LAYER_OPERATOR__LAYER_OPERATOR_DESCRIPTOR_NAME);
		createEOperation(abstractLayerOperatorEClass, ABSTRACT_LAYER_OPERATOR___IS_DESCRIPTOR_SET);
		createEOperation(abstractLayerOperatorEClass, ABSTRACT_LAYER_OPERATOR___RESET_DESCRIPTOR);

		layerOperatorEClass = createEClass(LAYER_OPERATOR);
		createEReference(layerOperatorEClass, LAYER_OPERATOR__LAYERS);

		defaultPropertyOperatorEClass = createEClass(DEFAULT_PROPERTY_OPERATOR);

		abstractLayerEClass = createEClass(ABSTRACT_LAYER);
		createEReference(abstractLayerEClass, ABSTRACT_LAYER__PROPERTY_VALUES);
		createEReference(abstractLayerEClass, ABSTRACT_LAYER__PROPERTY_VALUE_MAP);
		createEReference(abstractLayerEClass, ABSTRACT_LAYER__LAYER_DESCRIPTOR);
		createEReference(abstractLayerEClass, ABSTRACT_LAYER__VIEWS);
		createEReference(abstractLayerEClass, ABSTRACT_LAYER__ATTACHED_PROPERTIES);
		createEOperation(abstractLayerEClass, ABSTRACT_LAYER___ADD_PROPERTY_INSTANCE__PROPERTY);
		createEOperation(abstractLayerEClass, ABSTRACT_LAYER___REMOVE_PROPERTY_INSTANCE__PROPERTY);
		createEOperation(abstractLayerEClass, ABSTRACT_LAYER___GET_PROPERTY_INSTANCE__PROPERTY);
		createEOperation(abstractLayerEClass, ABSTRACT_LAYER___GET_PROPERTY_INSTANCE__STRING);

		stringToTypeInstanceMapEClass = createEClass(STRING_TO_TYPE_INSTANCE_MAP);
		createEAttribute(stringToTypeInstanceMapEClass, STRING_TO_TYPE_INSTANCE_MAP__KEY);
		createEReference(stringToTypeInstanceMapEClass, STRING_TO_TYPE_INSTANCE_MAP__VALUE);

		folderEClass = createEClass(FOLDER);
		createEReference(folderEClass, FOLDER__ELEMENTS);
		createEAttribute(folderEClass, FOLDER__NAME);

		intInstanceEClass = createEClass(INT_INSTANCE);
		createEAttribute(intInstanceEClass, INT_INSTANCE__VALUE);

		booleanInstanceEClass = createEClass(BOOLEAN_INSTANCE);
		createEAttribute(booleanInstanceEClass, BOOLEAN_INSTANCE__VALUE);

		stringInstanceEClass = createEClass(STRING_INSTANCE);
		createEAttribute(stringInstanceEClass, STRING_INSTANCE__VALUE);

		intTypeEClass = createEClass(INT_TYPE);

		booleanTypeEClass = createEClass(BOOLEAN_TYPE);

		stringTypeEClass = createEClass(STRING_TYPE);

		customTypeEClass = createEClass(CUSTOM_TYPE);
		createEAttribute(customTypeEClass, CUSTOM_TYPE__CLASSIFIER);

		topLayerOperatorEClass = createEClass(TOP_LAYER_OPERATOR);

		stackedLayerOperatorEClass = createEClass(STACKED_LAYER_OPERATOR);

		customLayerOperatorEClass = createEClass(CUSTOM_LAYER_OPERATOR);

		propertyIndexEClass = createEClass(PROPERTY_INDEX);
		createEReference(propertyIndexEClass, PROPERTY_INDEX__PROPERTY);
		createEAttribute(propertyIndexEClass, PROPERTY_INDEX__INDEX);

		stringToPropertyIndexMapEClass = createEClass(STRING_TO_PROPERTY_INDEX_MAP);
		createEReference(stringToPropertyIndexMapEClass, STRING_TO_PROPERTY_INDEX_MAP__VALUE);
		createEAttribute(stringToPropertyIndexMapEClass, STRING_TO_PROPERTY_INDEX_MAP__KEY);

		simpleLayerDescriptorEClass = createEClass(SIMPLE_LAYER_DESCRIPTOR);

		regExpLayerDescriptorEClass = createEClass(REG_EXP_LAYER_DESCRIPTOR);

		nullInstanceEClass = createEClass(NULL_INSTANCE);
		createEOperation(nullInstanceEClass, NULL_INSTANCE___GET_INSTANCE);

		regExpLayerEClass = createEClass(REG_EXP_LAYER);
		createEAttribute(regExpLayerEClass, REG_EXP_LAYER__EXPR);
		createEAttribute(regExpLayerEClass, REG_EXP_LAYER__LANGUAGE);
		createEOperation(regExpLayerEClass, REG_EXP_LAYER___ACTIVATE__ABSTRACTLAYEROPERATOR);
		createEOperation(regExpLayerEClass, REG_EXP_LAYER___DEACTIVATE__ABSTRACTLAYEROPERATOR);
		createEOperation(regExpLayerEClass, REG_EXP_LAYER___EVALUATE_EXPR);

		layerEClass = createEClass(LAYER);

		colorEClass = createEClass(COLOR);

		colorInstanceEClass = createEClass(COLOR_INSTANCE);
		createEAttribute(colorInstanceEClass, COLOR_INSTANCE__VALUE);

		fillInstanceEClass = createEClass(FILL_INSTANCE);
		createEAttribute(fillInstanceEClass, FILL_INSTANCE__TRANSPARENCY);
		createEReference(fillInstanceEClass, FILL_INSTANCE__FILL_COLOR);

		fillEClass = createEClass(FILL);

		fillPropertySetterEClass = createEClass(FILL_PROPERTY_SETTER);

		isValidPropertySetterEClass = createEClass(IS_VALID_PROPERTY_SETTER);

		nullPropertySetterEClass = createEClass(NULL_PROPERTY_SETTER);

		lineTypeEClass = createEClass(LINE_TYPE);

		lineInstanceEClass = createEClass(LINE_INSTANCE);
		createEAttribute(lineInstanceEClass, LINE_INSTANCE__LINE_COLOR);
		createEAttribute(lineInstanceEClass, LINE_INSTANCE__LINE_WITH);

		linePropertySetterEClass = createEClass(LINE_PROPERTY_SETTER);

		fontPropertySetterEClass = createEClass(FONT_PROPERTY_SETTER);

		fontInstanceEClass = createEClass(FONT_INSTANCE);
		createEAttribute(fontInstanceEClass, FONT_INSTANCE__FONT_COLOR);
		createEAttribute(fontInstanceEClass, FONT_INSTANCE__FONT_NAME);
		createEAttribute(fontInstanceEClass, FONT_INSTANCE__FONT_HEIGH);
		createEAttribute(fontInstanceEClass, FONT_INSTANCE__BOLD);

		fontTypeEClass = createEClass(FONT_TYPE);

		isVisiblePropertySetterEClass = createEClass(IS_VISIBLE_PROPERTY_SETTER);

		topLayerOperatorDescriptorEClass = createEClass(TOP_LAYER_OPERATOR_DESCRIPTOR);

		stackedLayerOperatorDescriptorEClass = createEClass(STACKED_LAYER_OPERATOR_DESCRIPTOR);

		customPropertyOperatorEClass = createEClass(CUSTOM_PROPERTY_OPERATOR);
		createEAttribute(customPropertyOperatorEClass, CUSTOM_PROPERTY_OPERATOR__CLASSNAME);
		createEAttribute(customPropertyOperatorEClass, CUSTOM_PROPERTY_OPERATOR__OPERATOR_INSTANCE);
		createEAttribute(customPropertyOperatorEClass, CUSTOM_PROPERTY_OPERATOR__CLASS_BUNDLE_ID);
		createEOperation(customPropertyOperatorEClass, CUSTOM_PROPERTY_OPERATOR___RESET_OPERATOR_INSTANCE);

		andStackedLayerOperatorDescriptorEClass = createEClass(AND_STACKED_LAYER_OPERATOR_DESCRIPTOR);

		orStackedLayerOperatorDescriptorEClass = createEClass(OR_STACKED_LAYER_OPERATOR_DESCRIPTOR);

		isAbstractUmlSetterEClass = createEClass(IS_ABSTRACT_UML_SETTER);

		// Create data types
		stringEDataType = createEDataType(STRING);
		booleanEDataType = createEDataType(BOOLEAN);
		ePackageEDataType = createEDataType(EPACKAGE);
		layersExceptionEDataType = createEDataType(LAYERS_EXCEPTION);
		intEDataType = createEDataType(INT);
		badStateExceptionEDataType = createEDataType(BAD_STATE_EXCEPTION);
		notFoundExceptionEDataType = createEDataType(NOT_FOUND_EXCEPTION);
		computePropertyValueCommandEDataType = createEDataType(COMPUTE_PROPERTY_VALUE_COMMAND);
		objectEDataType = createEDataType(OBJECT);
		customPropertyOpertorInstanceEDataType = createEDataType(CUSTOM_PROPERTY_OPERTOR_INSTANCE);
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

		// Obtain other dependent packages
		NotationPackage theNotationPackage = (NotationPackage)EPackage.Registry.INSTANCE.getEPackage(NotationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		layerNamedStyleEClass.getESuperTypes().add(theNotationPackage.getNamedStyle());
		layerExpressionEClass.getESuperTypes().add(this.getApplicationDependantElement());
		layersStackApplicationEClass.getESuperTypes().add(this.getFolderElement());
		propertyEClass.getESuperTypes().add(this.getFolderElement());
		typeEClass.getESuperTypes().add(this.getFolderElement());
		metamodelEClass.getESuperTypes().add(this.getFolderElement());
		typeInstanceEClass.getESuperTypes().add(this.getComputePropertyValueCommandItf());
		abstractLayerOperatorEClass.getESuperTypes().add(this.getLayerOperator());
		layerOperatorEClass.getESuperTypes().add(this.getLayerExpression());
		defaultPropertyOperatorEClass.getESuperTypes().add(this.getPropertyOperator());
		abstractLayerEClass.getESuperTypes().add(this.getLayerExpression());
		folderEClass.getESuperTypes().add(this.getFolderElement());
		intInstanceEClass.getESuperTypes().add(this.getTypeInstance());
		booleanInstanceEClass.getESuperTypes().add(this.getTypeInstance());
		stringInstanceEClass.getESuperTypes().add(this.getTypeInstance());
		intTypeEClass.getESuperTypes().add(this.getType());
		booleanTypeEClass.getESuperTypes().add(this.getType());
		stringTypeEClass.getESuperTypes().add(this.getType());
		customTypeEClass.getESuperTypes().add(this.getType());
		topLayerOperatorEClass.getESuperTypes().add(this.getAbstractLayerOperator());
		stackedLayerOperatorEClass.getESuperTypes().add(this.getAbstractLayerOperator());
		customLayerOperatorEClass.getESuperTypes().add(this.getLayerOperator());
		simpleLayerDescriptorEClass.getESuperTypes().add(this.getLayerDescriptor());
		regExpLayerDescriptorEClass.getESuperTypes().add(this.getLayerDescriptor());
		nullInstanceEClass.getESuperTypes().add(this.getTypeInstance());
		regExpLayerEClass.getESuperTypes().add(this.getAbstractLayer());
		layerEClass.getESuperTypes().add(this.getAbstractLayer());
		colorEClass.getESuperTypes().add(this.getType());
		colorInstanceEClass.getESuperTypes().add(this.getTypeInstance());
		fillInstanceEClass.getESuperTypes().add(this.getTypeInstance());
		fillEClass.getESuperTypes().add(this.getType());
		fillPropertySetterEClass.getESuperTypes().add(this.getPropertySetter());
		isValidPropertySetterEClass.getESuperTypes().add(this.getPropertySetter());
		nullPropertySetterEClass.getESuperTypes().add(this.getPropertySetter());
		lineTypeEClass.getESuperTypes().add(this.getType());
		lineInstanceEClass.getESuperTypes().add(this.getTypeInstance());
		linePropertySetterEClass.getESuperTypes().add(this.getPropertySetter());
		fontPropertySetterEClass.getESuperTypes().add(this.getPropertySetter());
		fontInstanceEClass.getESuperTypes().add(this.getTypeInstance());
		fontTypeEClass.getESuperTypes().add(this.getType());
		isVisiblePropertySetterEClass.getESuperTypes().add(this.getPropertySetter());
		topLayerOperatorDescriptorEClass.getESuperTypes().add(this.getLayerOperatorDescriptor());
		stackedLayerOperatorDescriptorEClass.getESuperTypes().add(this.getLayerOperatorDescriptor());
		customPropertyOperatorEClass.getESuperTypes().add(this.getPropertyOperator());
		andStackedLayerOperatorDescriptorEClass.getESuperTypes().add(this.getStackedLayerOperatorDescriptor());
		orStackedLayerOperatorDescriptorEClass.getESuperTypes().add(this.getStackedLayerOperatorDescriptor());
		isAbstractUmlSetterEClass.getESuperTypes().add(this.getPropertySetter());

		// Initialize classes, features, and operations; add parameters
		initEClass(layerNamedStyleEClass, LayerNamedStyle.class, "LayerNamedStyle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLayerNamedStyle_LayersStack(), this.getLayersStack(), null, "layersStack", null, 0, -1, LayerNamedStyle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(layersStackEClass, LayersStack.class, "LayersStack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLayersStack_Layers(), this.getLayerExpression(), null, "layers", null, 0, 1, LayersStack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLayersStack_Name(), this.getString(), "name", null, 1, 1, LayersStack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLayersStack_Description(), this.getString(), "description", null, 1, 1, LayersStack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getLayersStack_Diagram(), theNotationPackage.getDiagram(), null, "diagram", null, 0, 1, LayersStack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = initEOperation(getLayersStack__GetComputePropertyValueCommand__View_Property(), this.getComputePropertyValueCommand(), "getComputePropertyValueCommand", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theNotationPackage.getView(), "view", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getProperty(), "property", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEException(op, this.getLayersException());

		op = initEOperation(getLayersStack__GetPropertiesComputePropertyValueCommand__View_EList(), this.getComputePropertyValueCommand(), "getPropertiesComputePropertyValueCommand", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theNotationPackage.getView(), "view", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getProperty(), "property", 1, -1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getLayersException());

		op = initEOperation(getLayersStack__GetViewsComputePropertyValueCommand__EList_Property(), this.getComputePropertyValueCommand(), "getViewsComputePropertyValueCommand", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theNotationPackage.getView(), "view", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getProperty(), "property", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEException(op, this.getLayersException());

		initEClass(layerExpressionEClass, LayerExpression.class, "LayerExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLayerExpression_Name(), this.getString(), "name", null, 1, 1, LayerExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLayerExpression_Description(), this.getString(), "description", null, 1, 1, LayerExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLayerExpression_IsEnabled(), this.getboolean(), "isEnabled", null, 1, 1, LayerExpression.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLayerExpression_IsUserEnabled(), this.getboolean(), "isUserEnabled", "true", 1, 1, LayerExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = initEOperation(getLayerExpression__GetComputePropertyValueCommand__View_Property(), this.getComputePropertyValueCommand(), "getComputePropertyValueCommand", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theNotationPackage.getView(), "view", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getProperty(), "property", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEException(op, this.getLayersException());

		op = initEOperation(getLayerExpression__GetViewsComputePropertyValueCommand__EList_Property(), this.getComputePropertyValueCommand(), "getViewsComputePropertyValueCommand", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theNotationPackage.getView(), "view", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getProperty(), "property", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEException(op, this.getLayersException());

		op = initEOperation(getLayerExpression__GetPropertiesComputePropertyValueCommand__View_EList(), this.getComputePropertyValueCommand(), "getPropertiesComputePropertyValueCommand", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theNotationPackage.getView(), "view", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getProperty(), "property", 1, -1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getLayersException());

		op = initEOperation(getLayerExpression__GetLayersStack(), this.getLayersStack(), "getLayersStack", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEException(op, this.getNotFoundException());

		initEClass(applicationDependantElementEClass, ApplicationDependantElement.class, "ApplicationDependantElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getApplicationDependantElement_Application(), this.getLayersStackApplication(), null, "application", null, 0, 1, ApplicationDependantElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(layersStackApplicationEClass, LayersStackApplication.class, "LayersStackApplication", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLayersStackApplication_LayersStacks(), this.getLayersStack(), null, "layersStacks", null, 0, -1, LayersStackApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getLayersStackApplication_LayerStackRegistry(), this.getLayerStackDescriptorRegistry(), null, "layerStackRegistry", null, 1, 1, LayersStackApplication.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getLayersStackApplication_PropertyRegistry(), this.getPropertyRegistry(), null, "propertyRegistry", null, 1, 1, LayersStackApplication.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getLayersStackApplication_LayerDescriptorRegistry(), this.getLayerDescriptorRegistry(), null, "layerDescriptorRegistry", null, 1, 1, LayersStackApplication.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getLayersStackApplication_Factory(), this.getLayerApplicationFactory(), this.getLayerApplicationFactory_Application(), "factory", null, 1, 1, LayersStackApplication.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getLayersStackApplication_PropertySetterRegistry(), this.getPropertySetterRegistry(), this.getPropertySetterRegistry_Application(), "propertySetterRegistry", null, 0, 1, LayersStackApplication.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getLayersStackApplication_LayerOperatorDescriptorRegistry(), this.getLayerOperatorDescriptorRegistry(), null, "layerOperatorDescriptorRegistry", null, 0, 1, LayersStackApplication.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = initEOperation(getLayersStackApplication__GetLayersStackFor__Diagram(), this.getLayersStack(), "getLayersStackFor", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theNotationPackage.getDiagram(), "diagram", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = initEOperation(getLayersStackApplication__RemoveLayersStackFor__Diagram(), null, "removeLayersStackFor", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theNotationPackage.getDiagram(), "diagram", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = initEOperation(getLayersStackApplication__IsLayersStackAttachedFor__Diagram(), this.getboolean(), "isLayersStackAttachedFor", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theNotationPackage.getDiagram(), "diagram", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = initEOperation(getLayersStackApplication__CreateLayersStackFor__Diagram(), this.getLayersStack(), "createLayersStackFor", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theNotationPackage.getDiagram(), "diagram", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = initEOperation(getLayersStackApplication__LookupLayersStackFor__Diagram(), this.getLayersStack(), "lookupLayersStackFor", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theNotationPackage.getDiagram(), "diagram", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEException(op, this.getNotFoundException());

		initEClass(folderElementEClass, FolderElement.class, "FolderElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(layerStackDescriptorRegistryEClass, LayerStackDescriptorRegistry.class, "LayerStackDescriptorRegistry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(propertyRegistryEClass, PropertyRegistry.class, "PropertyRegistry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyRegistry_Properties(), this.getProperty(), null, "properties", null, 0, -1, PropertyRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyRegistry_TypeRegistry(), this.getTypeRegistry(), null, "typeRegistry", null, 0, 1, PropertyRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPropertyRegistry_PropertiesCount(), this.getint(), "propertiesCount", null, 1, 1, PropertyRegistry.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

		op = initEOperation(getPropertyRegistry__GetPropertyIndex__String(), this.getint(), "getPropertyIndex", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getString(), "propertyName", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEException(op, this.getNotFoundException());

		op = initEOperation(getPropertyRegistry__GetProperty__String(), this.getProperty(), "getProperty", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getString(), "propertyName", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEException(op, this.getNotFoundException());

		op = initEOperation(getPropertyRegistry__AddProperty__Property(), null, "addProperty", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getProperty(), "property", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(propertyEClass, Property.class, "Property", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProperty_Type(), this.getType(), null, "type", null, 1, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getProperty_DefaultValue(), this.getTypeInstance(), null, "defaultValue", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getProperty_Name(), this.getString(), "name", null, 1, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getProperty_Description(), this.getString(), "description", null, 1, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getProperty_Index(), this.getint(), "index", "-1", 1, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = initEOperation(getProperty__CreateInstance(), this.getTypeInstance(), "createInstance", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEException(op, this.getBadStateException());

		initEClass(typeEClass, Type.class, "Type", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getType_Metamodel(), this.getMetamodel(), null, "metamodel", null, 1, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getType_Name(), this.getString(), "name", null, 1, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getType_Description(), this.getString(), "description", null, 1, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEOperation(getType__CreateInstance(), this.getTypeInstance(), "createInstance", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(metamodelEClass, Metamodel.class, "Metamodel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMetamodel_Name(), this.getString(), "name", null, 1, 1, Metamodel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMetamodel_Description(), this.getString(), "description", null, 1, 1, Metamodel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMetamodel_Nsuri(), this.getString(), "nsuri", null, 1, 1, Metamodel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMetamodel_PluginID(), this.getString(), "pluginID", null, 1, 1, Metamodel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMetamodel_EPackageInstanceName(), this.getString(), "ePackageInstanceName", null, 1, 1, Metamodel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMetamodel_IsTypeValid(), this.getboolean(), "isTypeValid", null, 1, 1, Metamodel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEOperation(getMetamodel__GetEPackage(), this.getEPackage(), "getEPackage", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(typeInstanceEClass, TypeInstance.class, "TypeInstance", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(computePropertyValueCommandItfEClass, ComputePropertyValueCommand.class, "ComputePropertyValueCommandItf", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getComputePropertyValueCommandItf__GetCmdValue(), this.getTypeInstance(), "getCmdValue", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEException(op, this.getLayersException());

		initEClass(typeRegistryEClass, TypeRegistry.class, "TypeRegistry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeRegistry_Types(), this.getStringToTypeMap(), null, "types", null, 0, -1, TypeRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(stringToTypeMapEClass, Map.Entry.class, "StringToTypeMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStringToTypeMap_Value(), this.getType(), null, "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStringToTypeMap_Key(), this.getString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(layerDescriptorRegistryEClass, LayerDescriptorRegistry.class, "LayerDescriptorRegistry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLayerDescriptorRegistry_LayerDescriptors(), this.getLayerDescriptor(), null, "layerDescriptors", null, 0, -1, LayerDescriptorRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(layerDescriptorEClass, LayerDescriptor.class, "LayerDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLayerDescriptor_PropertyRegistry(), this.getPropertyRegistry(), null, "propertyRegistry", null, 1, 1, LayerDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(layerApplicationFactoryEClass, LayerApplicationFactory.class, "LayerApplicationFactory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLayerApplicationFactory_Application(), this.getLayersStackApplication(), this.getLayersStackApplication_Factory(), "application", null, 0, 1, LayerApplicationFactory.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(propertySetterRegistryEClass, PropertySetterRegistry.class, "PropertySetterRegistry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertySetterRegistry_PropertySetters(), this.getPropertySetter(), null, "propertySetters", null, 0, -1, PropertySetterRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertySetterRegistry_SetterMap(), this.getStringToPropertySetter(), null, "setterMap", null, 0, -1, PropertySetterRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPropertySetterRegistry_Application(), this.getLayersStackApplication(), this.getLayersStackApplication_PropertySetterRegistry(), "application", null, 0, 1, PropertySetterRegistry.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = initEOperation(getPropertySetterRegistry__GetPropertySetter__Property(), this.getPropertySetter(), "getPropertySetter", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getProperty(), "property", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEException(op, this.getNotFoundException());

		op = initEOperation(getPropertySetterRegistry__GetPropertySetter__String(), this.getPropertySetter(), "getPropertySetter", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getString(), "property", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEException(op, this.getNotFoundException());

		op = initEOperation(getPropertySetterRegistry__AddPropertySetter__PropertySetter(), null, "addPropertySetter", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getPropertySetter(), "setter", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(propertySetterEClass, PropertySetter.class, "PropertySetter", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertySetter_Property(), this.getProperty(), null, "property", null, 0, 1, PropertySetter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPropertySetter_PropertyName(), this.getString(), "propertyName", null, 1, 1, PropertySetter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = initEOperation(getPropertySetter__SetValue__View_TypeInstance(), null, "setValue", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, theNotationPackage.getView(), "view", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getTypeInstance(), "value", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(stringToPropertySetterEClass, Map.Entry.class, "StringToPropertySetter", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringToPropertySetter_Key(), this.getString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getStringToPropertySetter_Value(), this.getPropertySetter(), null, "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(layerOperatorDescriptorRegistryEClass, LayerOperatorDescriptorRegistry.class, "LayerOperatorDescriptorRegistry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLayerOperatorDescriptorRegistry_Descriptors(), this.getLayerOperatorDescriptor(), null, "descriptors", null, 0, -1, LayerOperatorDescriptorRegistry.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getLayerOperatorDescriptorRegistry_PropertyOperators(), this.getPropertyOperator(), null, "propertyOperators", null, 0, -1, LayerOperatorDescriptorRegistry.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayerOperatorDescriptorRegistry_PropertyCollectionSize(), this.getint(), "propertyCollectionSize", null, 1, 1, LayerOperatorDescriptorRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getLayerOperatorDescriptorRegistry_DefaultOperator(), this.getDefaultPropertyOperator(), null, "defaultOperator", null, 1, 1, LayerOperatorDescriptorRegistry.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = initEOperation(getLayerOperatorDescriptorRegistry__AddLayerOperatorDescriptor__LayerOperatorDescriptor(), null, "addLayerOperatorDescriptor", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getLayerOperatorDescriptor(), "descriptor", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = initEOperation(getLayerOperatorDescriptorRegistry__GetLayerOperatorDescriptor__String(), this.getLayerOperatorDescriptor(), "getLayerOperatorDescriptor", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getString(), "name", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEException(op, this.getNotFoundException());

		op = initEOperation(getLayerOperatorDescriptorRegistry__AddPropertyOperator__PropertyOperator(), null, "addPropertyOperator", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getPropertyOperator(), "operator", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = initEOperation(getLayerOperatorDescriptorRegistry__GetPropertyOperator__String(), this.getPropertyOperator(), "getPropertyOperator", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getString(), "name", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEException(op, this.getNotFoundException());

		op = initEOperation(getLayerOperatorDescriptorRegistry__AttachOperatorToDescriptor__Property_String_String(), null, "attachOperatorToDescriptor", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getProperty(), "property", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getString(), "operatorName", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getString(), "layerDescriptorName", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEException(op, this.getNotFoundException());

		op = initEOperation(getLayerOperatorDescriptorRegistry__CreateLayerOperator__String(), this.getAbstractLayerOperator(), "createLayerOperator", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getString(), "layerOperatorID", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEException(op, this.getLayersException());

		initEClass(layerOperatorDescriptorEClass, LayerOperatorDescriptor.class, "LayerOperatorDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLayerOperatorDescriptor_PropertyOperators(), this.getPropertyOperator(), null, "propertyOperators", null, 0, -1, LayerOperatorDescriptor.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLayerOperatorDescriptor_Name(), this.getString(), "name", null, 1, 1, LayerOperatorDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = initEOperation(getLayerOperatorDescriptor__GetPropertyOperator__Property(), this.getPropertyOperator(), "getPropertyOperator", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getProperty(), "property", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEException(op, this.getNotFoundException());

		op = initEOperation(getLayerOperatorDescriptor__SetPropertyOperator__Property_PropertyOperator(), null, "setPropertyOperator", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getProperty(), "property", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getPropertyOperator(), "operator", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getLayerOperatorDescriptor__CreateLayerOperator(), this.getAbstractLayerOperator(), "createLayerOperator", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = initEOperation(getLayerOperatorDescriptor__SetPropertyCollectionSize__int_DefaultPropertyOperator(), null, "setPropertyCollectionSize", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getint(), "size", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getDefaultPropertyOperator(), "defaultPropertyOperator", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(propertyOperatorEClass, PropertyOperator.class, "PropertyOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPropertyOperator_Name(), this.getString(), "name", null, 1, 1, PropertyOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = initEOperation(getPropertyOperator__GetComputePropertyValueCommand__EList(), this.getComputePropertyValueCommand(), "getComputePropertyValueCommand", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getComputePropertyValueCommand(), "property", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getLayersException());

		initEClass(abstractLayerOperatorEClass, AbstractLayerOperator.class, "AbstractLayerOperator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractLayerOperator_LayerOperatorDescriptor(), this.getLayerOperatorDescriptor(), null, "layerOperatorDescriptor", null, 1, 1, AbstractLayerOperator.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAbstractLayerOperator_LayerOperatorDescriptorName(), this.getString(), "layerOperatorDescriptorName", null, 1, 1, AbstractLayerOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEOperation(getAbstractLayerOperator__IsDescriptorSet(), this.getboolean(), "isDescriptorSet", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getAbstractLayerOperator__ResetDescriptor(), null, "resetDescriptor", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(layerOperatorEClass, LayerOperator.class, "LayerOperator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLayerOperator_Layers(), this.getLayerExpression(), null, "layers", null, 0, -1, LayerOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(defaultPropertyOperatorEClass, DefaultPropertyOperator.class, "DefaultPropertyOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(abstractLayerEClass, AbstractLayer.class, "AbstractLayer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractLayer_PropertyValues(), this.getTypeInstance(), null, "propertyValues", null, 0, -1, AbstractLayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractLayer_PropertyValueMap(), this.getStringToTypeInstanceMap(), null, "propertyValueMap", null, 0, -1, AbstractLayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAbstractLayer_LayerDescriptor(), this.getLayerDescriptor(), null, "layerDescriptor", null, 1, 1, AbstractLayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAbstractLayer_Views(), theNotationPackage.getView(), null, "views", null, 0, -1, AbstractLayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getAbstractLayer_AttachedProperties(), this.getProperty(), null, "attachedProperties", null, 0, -1, AbstractLayer.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

		op = initEOperation(getAbstractLayer__AddPropertyInstance__Property(), this.getTypeInstance(), "addPropertyInstance", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getProperty(), "property", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEException(op, this.getLayersException());

		op = initEOperation(getAbstractLayer__RemovePropertyInstance__Property(), null, "removePropertyInstance", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getProperty(), "property", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = initEOperation(getAbstractLayer__GetPropertyInstance__Property(), this.getTypeInstance(), "getPropertyInstance", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getProperty(), "property", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEException(op, this.getLayersException());

		op = initEOperation(getAbstractLayer__GetPropertyInstance__String(), this.getTypeInstance(), "getPropertyInstance", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getString(), "property", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEException(op, this.getLayersException());

		initEClass(stringToTypeInstanceMapEClass, Map.Entry.class, "StringToTypeInstanceMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringToTypeInstanceMap_Key(), this.getString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getStringToTypeInstanceMap_Value(), this.getTypeInstance(), null, "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(folderEClass, Folder.class, "Folder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFolder_Elements(), this.getFolderElement(), null, "elements", null, 0, -1, Folder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFolder_Name(), this.getString(), "name", null, 1, 1, Folder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(intInstanceEClass, IntInstance.class, "IntInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntInstance_Value(), this.getint(), "value", null, 1, 1, IntInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(booleanInstanceEClass, BooleanInstance.class, "BooleanInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanInstance_Value(), this.getboolean(), "value", null, 1, 1, BooleanInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(stringInstanceEClass, StringInstance.class, "StringInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringInstance_Value(), this.getString(), "value", null, 1, 1, StringInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(intTypeEClass, IntType.class, "IntType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(booleanTypeEClass, BooleanType.class, "BooleanType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stringTypeEClass, StringType.class, "StringType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(customTypeEClass, CustomType.class, "CustomType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCustomType_Classifier(), this.getString(), "classifier", null, 1, 1, CustomType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(topLayerOperatorEClass, TopLayerOperator.class, "TopLayerOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stackedLayerOperatorEClass, StackedLayerOperator.class, "StackedLayerOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(customLayerOperatorEClass, CustomLayerOperator.class, "CustomLayerOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(propertyIndexEClass, PropertyIndex.class, "PropertyIndex", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyIndex_Property(), this.getProperty(), null, "property", null, 1, 1, PropertyIndex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPropertyIndex_Index(), this.getint(), "index", null, 1, 1, PropertyIndex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(stringToPropertyIndexMapEClass, Map.Entry.class, "StringToPropertyIndexMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStringToPropertyIndexMap_Value(), this.getPropertyIndex(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStringToPropertyIndexMap_Key(), this.getString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(simpleLayerDescriptorEClass, SimpleLayerDescriptor.class, "SimpleLayerDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(regExpLayerDescriptorEClass, RegExpLayerDescriptor.class, "RegExpLayerDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nullInstanceEClass, NullInstance.class, "NullInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getNullInstance__GetInstance(), this.getNullInstance(), "getInstance", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(regExpLayerEClass, RegExpLayer.class, "RegExpLayer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRegExpLayer_Expr(), this.getString(), "expr", null, 1, 1, RegExpLayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRegExpLayer_Language(), this.getString(), "language", null, 1, 1, RegExpLayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = initEOperation(getRegExpLayer__Activate__AbstractLayerOperator(), null, "activate", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getAbstractLayerOperator(), "newParentLayer", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = initEOperation(getRegExpLayer__Deactivate__AbstractLayerOperator(), null, "deactivate", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getAbstractLayerOperator(), "oldParentLayer", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEOperation(getRegExpLayer__EvaluateExpr(), theNotationPackage.getView(), "evaluateExpr", 0, -1, IS_UNIQUE, !IS_ORDERED);

		initEClass(layerEClass, Layer.class, "Layer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(colorEClass, Color.class, "Color", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(colorInstanceEClass, ColorInstance.class, "ColorInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getColorInstance_Value(), this.getint(), "value", null, 1, 1, ColorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(fillInstanceEClass, FillInstance.class, "FillInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFillInstance_Transparency(), this.getint(), "transparency", null, 1, 1, FillInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFillInstance_FillColor(), this.getColorInstance(), null, "fillColor", null, 1, 1, FillInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(fillEClass, Fill.class, "Fill", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fillPropertySetterEClass, FillPropertySetter.class, "FillPropertySetter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(isValidPropertySetterEClass, IsValidPropertySetter.class, "IsValidPropertySetter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nullPropertySetterEClass, NullPropertySetter.class, "NullPropertySetter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lineTypeEClass, LineType.class, "LineType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lineInstanceEClass, LineInstance.class, "LineInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLineInstance_LineColor(), this.getint(), "lineColor", null, 1, 1, LineInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLineInstance_LineWith(), this.getint(), "lineWith", null, 1, 1, LineInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(linePropertySetterEClass, LinePropertySetter.class, "LinePropertySetter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fontPropertySetterEClass, FontPropertySetter.class, "FontPropertySetter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fontInstanceEClass, FontInstance.class, "FontInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFontInstance_FontColor(), this.getint(), "fontColor", "15053796", 1, 1, FontInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFontInstance_FontName(), this.getString(), "fontName", "Segoe UI", 1, 1, FontInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFontInstance_FontHeigh(), this.getint(), "fontHeigh", "9", 1, 1, FontInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFontInstance_Bold(), this.getboolean(), "bold", "true", 1, 1, FontInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(fontTypeEClass, FontType.class, "FontType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(isVisiblePropertySetterEClass, IsVisiblePropertySetter.class, "IsVisiblePropertySetter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(topLayerOperatorDescriptorEClass, TopLayerOperatorDescriptor.class, "TopLayerOperatorDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stackedLayerOperatorDescriptorEClass, StackedLayerOperatorDescriptor.class, "StackedLayerOperatorDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(customPropertyOperatorEClass, CustomPropertyOperator.class, "CustomPropertyOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCustomPropertyOperator_Classname(), this.getString(), "classname", null, 1, 1, CustomPropertyOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCustomPropertyOperator_OperatorInstance(), this.getCustomPropertyOpertorInstance(), "operatorInstance", null, 1, 1, CustomPropertyOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCustomPropertyOperator_ClassBundleID(), this.getString(), "classBundleID", null, 1, 1, CustomPropertyOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = initEOperation(getCustomPropertyOperator__ResetOperatorInstance(), null, "resetOperatorInstance", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEException(op, this.getLayersException());

		initEClass(andStackedLayerOperatorDescriptorEClass, AndStackedLayerOperatorDescriptor.class, "AndStackedLayerOperatorDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(orStackedLayerOperatorDescriptorEClass, OrStackedLayerOperatorDescriptor.class, "OrStackedLayerOperatorDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(isAbstractUmlSetterEClass, IsAbstractUmlSetter.class, "IsAbstractUmlSetter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize data types
		initEDataType(stringEDataType, String.class, "String", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(booleanEDataType, boolean.class, "boolean", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(ePackageEDataType, EPackage.class, "EPackage", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(layersExceptionEDataType, LayersException.class, "LayersException", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(intEDataType, int.class, "int", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(badStateExceptionEDataType, BadStateException.class, "BadStateException", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(notFoundExceptionEDataType, NotFoundException.class, "NotFoundException", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(computePropertyValueCommandEDataType, ComputePropertyValueCommand.class, "ComputePropertyValueCommand", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(objectEDataType, Object.class, "Object", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(customPropertyOpertorInstanceEDataType, CustomPropertyOperatorsInstance.class, "CustomPropertyOpertorInstance", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
		addAnnotation
		  (badStateExceptionEDataType, 
		   source, 
		   new String[] {
			 "baseType", "LayersException"
		   });		
		addAnnotation
		  (notFoundExceptionEDataType, 
		   source, 
		   new String[] {
			 "baseType", "LayersException"
		   });
	}

} //LayersPackageImpl
