/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.di.impl;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.papyrus.di.*;

import org.eclipse.swt.graphics.RGB;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class DiFactoryImpl extends EFactoryImpl implements DiFactory {

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static DiFactory init() {
		try {
			DiFactory theDiFactory = (DiFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/papyrus/0.7.0/di");
			if(theDiFactory != null) {
				return theDiFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DiFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DiFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch(eClass.getClassifierID()) {
		case DiPackage.DIAGRAM_ELEMENT:
			return createDiagramElement();
		case DiPackage.GRAPH_ELEMENT:
			return createGraphElement();
		case DiPackage.REFERENCE:
			return createReference();
		case DiPackage.PROPERTY:
			return createProperty();
		case DiPackage.GRAPH_EDGE:
			return createGraphEdge();
		case DiPackage.GRAPH_CONNECTOR:
			return createGraphConnector();
		case DiPackage.GRAPH_NODE:
			return createGraphNode();
		case DiPackage.DIAGRAM_LINK:
			return createDiagramLink();
		case DiPackage.DIAGRAM:
			return createDiagram();
		case DiPackage.SEMANTIC_MODEL_BRIDGE:
			return createSemanticModelBridge();
		case DiPackage.SIMPLE_SEMANTIC_MODEL_ELEMENT:
			return createSimpleSemanticModelElement();
		case DiPackage.UML1_SEMANTIC_MODEL_BRIDGE:
			return createUml1SemanticModelBridge();
		case DiPackage.CORE_SEMANTIC_MODEL_BRIDGE:
			return createCoreSemanticModelBridge();
		case DiPackage.LEAF_ELEMENT:
			return createLeafElement();
		case DiPackage.TEXT_ELEMENT:
			return createTextElement();
		case DiPackage.IMAGE:
			return createImage();
		case DiPackage.GRAPHIC_PRIMITIVE:
			return createGraphicPrimitive();
		case DiPackage.POLILYNE:
			return createPolilyne();
		case DiPackage.ELLIPSE:
			return createEllipse();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch(eDataType.getClassifierID()) {
		case DiPackage.PAPYRUS_KEY_ENUMERATION:
			return createPapyrusKeyEnumerationFromString(eDataType, initialValue);
		case DiPackage.POINT:
			return createPointFromString(eDataType, initialValue);
		case DiPackage.DIMENSION:
			return createDimensionFromString(eDataType, initialValue);
		case DiPackage.DOUBLE:
			return createDoubleFromString(eDataType, initialValue);
		case DiPackage.RGB:
			return createRGBFromString(eDataType, initialValue);
		case DiPackage.STRING:
			return createStringFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch(eDataType.getClassifierID()) {
		case DiPackage.PAPYRUS_KEY_ENUMERATION:
			return convertPapyrusKeyEnumerationToString(eDataType, instanceValue);
		case DiPackage.POINT:
			return convertPointToString(eDataType, instanceValue);
		case DiPackage.DIMENSION:
			return convertDimensionToString(eDataType, instanceValue);
		case DiPackage.DOUBLE:
			return convertDoubleToString(eDataType, instanceValue);
		case DiPackage.RGB:
			return convertRGBToString(eDataType, instanceValue);
		case DiPackage.STRING:
			return convertStringToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DiagramElement createDiagramElement() {
		DiagramElementImpl diagramElement = new DiagramElementImpl();
		return diagramElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GraphElement createGraphElement() {
		GraphElementImpl graphElement = new GraphElementImpl();
		return graphElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Reference createReference() {
		ReferenceImpl reference = new ReferenceImpl();
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Property createProperty() {
		PropertyImpl property = new PropertyImpl();
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GraphEdge createGraphEdge() {
		GraphEdgeImpl graphEdge = new GraphEdgeImpl();
		return graphEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GraphConnector createGraphConnector() {
		GraphConnectorImpl graphConnector = new GraphConnectorImpl();
		return graphConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GraphNode createGraphNode() {
		GraphNodeImpl graphNode = new GraphNodeImpl();
		return graphNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DiagramLink createDiagramLink() {
		DiagramLinkImpl diagramLink = new DiagramLinkImpl();
		return diagramLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Diagram createDiagram() {
		DiagramImpl diagram = new DiagramImpl();
		return diagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SemanticModelBridge createSemanticModelBridge() {
		SemanticModelBridgeImpl semanticModelBridge = new SemanticModelBridgeImpl();
		return semanticModelBridge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SimpleSemanticModelElement createSimpleSemanticModelElement() {
		SimpleSemanticModelElementImpl simpleSemanticModelElement = new SimpleSemanticModelElementImpl();
		return simpleSemanticModelElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Uml1SemanticModelBridge createUml1SemanticModelBridge() {
		Uml1SemanticModelBridgeImpl uml1SemanticModelBridge = new Uml1SemanticModelBridgeImpl();
		return uml1SemanticModelBridge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CoreSemanticModelBridge createCoreSemanticModelBridge() {
		CoreSemanticModelBridgeImpl coreSemanticModelBridge = new CoreSemanticModelBridgeImpl();
		return coreSemanticModelBridge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public LeafElement createLeafElement() {
		LeafElementImpl leafElement = new LeafElementImpl();
		return leafElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TextElement createTextElement() {
		TextElementImpl textElement = new TextElementImpl();
		return textElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Image createImage() {
		ImageImpl image = new ImageImpl();
		return image;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public GraphicPrimitive createGraphicPrimitive() {
		GraphicPrimitiveImpl graphicPrimitive = new GraphicPrimitiveImpl();
		return graphicPrimitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Polilyne createPolilyne() {
		PolilyneImpl polilyne = new PolilyneImpl();
		return polilyne;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Ellipse createEllipse() {
		EllipseImpl ellipse = new EllipseImpl();
		return ellipse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PapyrusKeyEnumeration createPapyrusKeyEnumerationFromString(EDataType eDataType, String initialValue) {
		PapyrusKeyEnumeration result = PapyrusKeyEnumeration.get(initialValue);
		if(result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertPapyrusKeyEnumerationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Point createPointFromString(EDataType eDataType, String initialValue) {
		//return (Point)super.createFromString(eDataType, initialValue);
		if(initialValue == null)
			return null;
		java.util.StringTokenizer st = new java.util.StringTokenizer(initialValue, ":");
		return new Point(new Double(st.nextToken()).doubleValue(), new Double(st.nextToken()).doubleValue());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String convertPointToString(EDataType eDataType, Object instanceValue) {
		//return super.convertToString(eDataType, instanceValue);
		if(instanceValue == null)
			return null;

		return "" + ((Point)(instanceValue)).x + ":" + ((Point)(instanceValue)).y;

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Dimension createDimensionFromString(EDataType eDataType, String initialValue) {
		//return (Dimension)super.createFromString(eDataType, initialValue);
		if(initialValue == null)
			return null;
		java.util.StringTokenizer st = new java.util.StringTokenizer(initialValue, ":");
		return new Dimension(new Integer(st.nextToken()).intValue(), new Integer(st.nextToken()).intValue());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String convertDimensionToString(EDataType eDataType, Object instanceValue) {
		//return super.convertToString(eDataType, instanceValue);
		if(instanceValue == null)
			return null;

		return "" + ((Dimension)(instanceValue)).width + ":" + ((Dimension)(instanceValue)).height;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Double createDoubleFromString(EDataType eDataType, String initialValue) {
		return (Double)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertDoubleToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public RGB createRGBFromString(EDataType eDataType, String initialValue) {
		//return (RGB)super.createFromString(eDataType, initialValue);
		if(initialValue == null)
			return null;
		java.util.StringTokenizer st = new java.util.StringTokenizer(initialValue, ":");
		return new RGB(new Integer(st.nextToken()).intValue(), new Integer(st.nextToken()).intValue(), new Integer(st.nextToken()).intValue());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String convertRGBToString(EDataType eDataType, Object instanceValue) {
		//return super.convertToString(eDataType, instanceValue);
		if(instanceValue == null)
			return null;

		return "" + ((RGB)(instanceValue)).red + ":" + ((RGB)(instanceValue)).green + ":" + ((RGB)(instanceValue)).blue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String createStringFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertStringToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DiPackage getDiPackage() {
		return (DiPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DiPackage getPackage() {
		return DiPackage.eINSTANCE;
	}

} //DiFactoryImpl
