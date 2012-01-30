/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.prototype.infra.gmfdiag.css.factory;

import org.eclipse.gmf.runtime.notation.ArrowStyle;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.BasicDecorationNode;
import org.eclipse.gmf.runtime.notation.BasicSemanticCompartment;
import org.eclipse.gmf.runtime.notation.BooleanListValueStyle;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.ByteArrayValueStyle;
import org.eclipse.gmf.runtime.notation.CanonicalStyle;
import org.eclipse.gmf.runtime.notation.Compartment;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.ConnectorStyle;
import org.eclipse.gmf.runtime.notation.DataTypeStyle;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.DescriptionStyle;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.DiagramLinkStyle;
import org.eclipse.gmf.runtime.notation.DiagramStyle;
import org.eclipse.gmf.runtime.notation.DoubleListValueStyle;
import org.eclipse.gmf.runtime.notation.DoubleValueStyle;
import org.eclipse.gmf.runtime.notation.DrawerStyle;
import org.eclipse.gmf.runtime.notation.EObjectListValueStyle;
import org.eclipse.gmf.runtime.notation.EObjectValueStyle;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.FilteringStyle;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.Guide;
import org.eclipse.gmf.runtime.notation.GuideStyle;
import org.eclipse.gmf.runtime.notation.HintedDiagramLinkStyle;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.Image;
import org.eclipse.gmf.runtime.notation.ImageBufferStyle;
import org.eclipse.gmf.runtime.notation.ImageStyle;
import org.eclipse.gmf.runtime.notation.IntListValueStyle;
import org.eclipse.gmf.runtime.notation.IntValueStyle;
import org.eclipse.gmf.runtime.notation.LineStyle;
import org.eclipse.gmf.runtime.notation.LineTypeStyle;
import org.eclipse.gmf.runtime.notation.ListCompartment;
import org.eclipse.gmf.runtime.notation.ListValueStyle;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.MultiDiagramLinkStyle;
import org.eclipse.gmf.runtime.notation.NamedStyle;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.PageStyle;
import org.eclipse.gmf.runtime.notation.PropertiesSetStyle;
import org.eclipse.gmf.runtime.notation.PropertyValue;
import org.eclipse.gmf.runtime.notation.Ratio;
import org.eclipse.gmf.runtime.notation.RelativeBendpoints;
import org.eclipse.gmf.runtime.notation.RoundedCornersStyle;
import org.eclipse.gmf.runtime.notation.RoutingStyle;
import org.eclipse.gmf.runtime.notation.SemanticListCompartment;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.SingleValueStyle;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.gmf.runtime.notation.SortingStyle;
import org.eclipse.gmf.runtime.notation.StandardDiagram;
import org.eclipse.gmf.runtime.notation.StringListValueStyle;
import org.eclipse.gmf.runtime.notation.StringValueStyle;
import org.eclipse.gmf.runtime.notation.TextStyle;
import org.eclipse.gmf.runtime.notation.TitleStyle;
import org.eclipse.gmf.runtime.notation.impl.NotationFactoryImpl;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSArrowStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSBasicCompartment;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSBasicDecorationNode;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSBasicSemanticCompartment;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSBooleanListValueStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSBooleanValueStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSBounds;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSByteArrayValueStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSCanonicalStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSCompartment;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSConnector;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSConnectorStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSDataTypeStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSDecorationNode;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSDescriptionStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSDiagram;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSDiagramLinkStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSDiagramStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSDoubleListValueStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSDoubleValueStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSDrawerStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSEObjectListValueStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSEObjectValueStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSEdge;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSFillStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSFilteringStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSFontStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSGuide;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSGuideStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSHintedDiagramLinkStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSIdentityAnchor;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSImage;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSImageBufferStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSImageStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSIntListValueStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSIntValueStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSLineStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSLineTypeStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSListCompartment;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSListValueStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSLocation;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSMultiDiagramLinkStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSNamedStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSNode;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSNodeEntry;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSPageStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSPropertiesSetStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSPropertyValue;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSRatio;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSRelativeBendpoints;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSRoundedCornersStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSRoutingStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSSemanticListCompartment;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSShape;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSShapeStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSSingleValueStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSSize;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSSortingStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSStandardDiagram;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSStringListValueStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSStringToPropertyValueMapEntry;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSStringValueStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSTextStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.GMFCSSTitleStyle;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.engine.ExtendedCSSEngine;

public class GMFCSSFactory extends NotationFactoryImpl {

	public static GMFCSSFactory eINSTANCE = (GMFCSSFactory)NotationFactory.eINSTANCE;


	@Override
	public Edge createEdge() {
		Edge edge = new GMFCSSEdge(getCSSEngine());
		return edge;
	}


	@Override
	public Node createNode() {
		Node node = new GMFCSSNode(getCSSEngine());
		return node;
	}


	@Override
	public FillStyle createFillStyle() {
		FillStyle fillStyle = new GMFCSSFillStyle(getCSSEngine());
		return fillStyle;
	}


	@Override
	public LineStyle createLineStyle() {
		LineStyle lineStyle = new GMFCSSLineStyle(getCSSEngine());
		return lineStyle;
	}


	@Override
	public FontStyle createFontStyle() {
		FontStyle fontStyle = new GMFCSSFontStyle(getCSSEngine());
		return fontStyle;
	}


	@Override
	public TitleStyle createTitleStyle() {
		TitleStyle titleStyle = new GMFCSSTitleStyle(getCSSEngine());
		return titleStyle;
	}


	@Override
	public SortingStyle createSortingStyle() {
		SortingStyle sortingStyle = new GMFCSSSortingStyle(getCSSEngine());
		return sortingStyle;
	}


	@Override
	public DescriptionStyle createDescriptionStyle() {
		DescriptionStyle descriptionStyle = new GMFCSSDescriptionStyle(getCSSEngine());
		return descriptionStyle;
	}


	@Override
	public Size createSize() {
		Size size = new GMFCSSSize(getCSSEngine());
		return size;
	}


	@Override
	public Location createLocation() {
		Location location = new GMFCSSLocation(getCSSEngine());
		return location;
	}


	@Override
	public Bounds createBounds() {
		Bounds bounds = new GMFCSSBounds(getCSSEngine());
		return bounds;
	}


	@Override
	public Ratio createRatio() {
		Ratio ratio = new GMFCSSRatio(getCSSEngine());
		return ratio;
	}


	@Override
	public IdentityAnchor createIdentityAnchor() {
		IdentityAnchor identityAnchor = new GMFCSSIdentityAnchor(getCSSEngine());
		return identityAnchor;
	}


	@Override
	public RoutingStyle createRoutingStyle() {
		RoutingStyle routingStyle = new GMFCSSRoutingStyle(getCSSEngine());
		return routingStyle;
	}


	@Override
	public RelativeBendpoints createRelativeBendpoints() {
		RelativeBendpoints relativeBendpoints = new GMFCSSRelativeBendpoints(getCSSEngine());
		return relativeBendpoints;
	}


	@Override
	public Diagram createDiagram() {
		Diagram diagram = new GMFCSSDiagram(getCSSEngine());
		return diagram;
	}


	@Override
	public Image createImage() {
		Image image = new GMFCSSImage(getCSSEngine());
		return image;
	}


	@Override
	public CanonicalStyle createCanonicalStyle() {
		CanonicalStyle canonicalStyle = new GMFCSSCanonicalStyle(getCSSEngine());
		return canonicalStyle;
	}


	@Override
	public ShapeStyle createShapeStyle() {
		ShapeStyle shapeStyle = new GMFCSSShapeStyle(getCSSEngine());
		return shapeStyle;
	}


	@Override
	public ConnectorStyle createConnectorStyle() {
		ConnectorStyle connectorStyle = new GMFCSSConnectorStyle(getCSSEngine());
		return connectorStyle;
	}


	@Override
	public PageStyle createPageStyle() {
		PageStyle pageStyle = new GMFCSSPageStyle(getCSSEngine());
		return pageStyle;
	}


	@Override
	public DrawerStyle createDrawerStyle() {
		DrawerStyle drawerStyle = new GMFCSSDrawerStyle(getCSSEngine());
		return drawerStyle;
	}


	@Override
	public GuideStyle createGuideStyle() {
		GuideStyle guideStyle = new GMFCSSGuideStyle(getCSSEngine());
		return guideStyle;
	}


	@Override
	public Guide createGuide() {
		Guide guide = new GMFCSSGuide(getCSSEngine());
		return guide;
	}


	@Override
	public java.util.Map.Entry createNodeEntry() {
		java.util.Map.Entry nodeEntry = new GMFCSSNodeEntry(getCSSEngine());
		return nodeEntry;
	}


	@Override
	public FilteringStyle createFilteringStyle() {
		FilteringStyle filteringStyle = new GMFCSSFilteringStyle(getCSSEngine());
		return filteringStyle;
	}


	@Override
	public DiagramStyle createDiagramStyle() {
		DiagramStyle diagramStyle = new GMFCSSDiagramStyle(getCSSEngine());
		return diagramStyle;
	}


	@Override
	public ImageStyle createImageStyle() {
		ImageStyle imageStyle = new GMFCSSImageStyle(getCSSEngine());
		return imageStyle;
	}


	@Override
	public ImageBufferStyle createImageBufferStyle() {
		ImageBufferStyle imageBufferStyle = new GMFCSSImageBufferStyle(getCSSEngine());
		return imageBufferStyle;
	}


	@Override
	public PropertiesSetStyle createPropertiesSetStyle() {
		PropertiesSetStyle propertiesSetStyle = new GMFCSSPropertiesSetStyle(getCSSEngine());
		return propertiesSetStyle;
	}


	@Override
	public java.util.Map.Entry createStringToPropertyValueMapEntry() {
		java.util.Map.Entry stringToPropertyValueMapEntry = new GMFCSSStringToPropertyValueMapEntry(getCSSEngine());
		return stringToPropertyValueMapEntry;
	}


	@Override
	public PropertyValue createPropertyValue() {
		PropertyValue propertyValue = new GMFCSSPropertyValue(getCSSEngine());
		return propertyValue;
	}


	@Override
	public SingleValueStyle createSingleValueStyle() {
		SingleValueStyle singleValueStyle = new GMFCSSSingleValueStyle(getCSSEngine());
		return singleValueStyle;
	}


	@Override
	public ListValueStyle createListValueStyle() {
		ListValueStyle listValueStyle = new GMFCSSListValueStyle(getCSSEngine());
		return listValueStyle;
	}


	@Override
	public NamedStyle createNamedStyle() {
		NamedStyle namedStyle = new GMFCSSNamedStyle(getCSSEngine());
		return namedStyle;
	}


	@Override
	public DataTypeStyle createDataTypeStyle() {
		DataTypeStyle dataTypeStyle = new GMFCSSDataTypeStyle(getCSSEngine());
		return dataTypeStyle;
	}


	@Override
	public IntValueStyle createIntValueStyle() {
		IntValueStyle intValueStyle = new GMFCSSIntValueStyle(getCSSEngine());
		return intValueStyle;
	}


	@Override
	public IntListValueStyle createIntListValueStyle() {
		IntListValueStyle intListValueStyle = new GMFCSSIntListValueStyle(getCSSEngine());
		return intListValueStyle;
	}


	@Override
	public BooleanValueStyle createBooleanValueStyle() {
		BooleanValueStyle booleanValueStyle = new GMFCSSBooleanValueStyle(getCSSEngine());
		return booleanValueStyle;
	}


	@Override
	public DoubleValueStyle createDoubleValueStyle() {
		DoubleValueStyle doubleValueStyle = new GMFCSSDoubleValueStyle(getCSSEngine());
		return doubleValueStyle;
	}


	@Override
	public DoubleListValueStyle createDoubleListValueStyle() {
		DoubleListValueStyle doubleListValueStyle = new GMFCSSDoubleListValueStyle(getCSSEngine());
		return doubleListValueStyle;
	}


	@Override
	public StringValueStyle createStringValueStyle() {
		StringValueStyle stringValueStyle = new GMFCSSStringValueStyle(getCSSEngine());
		return stringValueStyle;
	}


	@Override
	public StringListValueStyle createStringListValueStyle() {
		StringListValueStyle stringListValueStyle = new GMFCSSStringListValueStyle(getCSSEngine());
		return stringListValueStyle;
	}


	@Override
	public EObjectValueStyle createEObjectValueStyle() {
		EObjectValueStyle eObjectValueStyle = new GMFCSSEObjectValueStyle(getCSSEngine());
		return eObjectValueStyle;
	}


	@Override
	public EObjectListValueStyle createEObjectListValueStyle() {
		EObjectListValueStyle eObjectListValueStyle = new GMFCSSEObjectListValueStyle(getCSSEngine());
		return eObjectListValueStyle;
	}


	@Override
	public ByteArrayValueStyle createByteArrayValueStyle() {
		ByteArrayValueStyle byteArrayValueStyle = new GMFCSSByteArrayValueStyle(getCSSEngine());
		return byteArrayValueStyle;
	}


	@Override
	public BooleanListValueStyle createBooleanListValueStyle() {
		BooleanListValueStyle booleanListValueStyle = new GMFCSSBooleanListValueStyle(getCSSEngine());
		return booleanListValueStyle;
	}


	@Override
	public HintedDiagramLinkStyle createHintedDiagramLinkStyle() {
		HintedDiagramLinkStyle hintedDiagramLinkStyle = new GMFCSSHintedDiagramLinkStyle(getCSSEngine());
		return hintedDiagramLinkStyle;
	}


	@Override
	public DiagramLinkStyle createDiagramLinkStyle() {
		DiagramLinkStyle diagramLinkStyle = new GMFCSSDiagramLinkStyle(getCSSEngine());
		return diagramLinkStyle;
	}


	@Override
	public MultiDiagramLinkStyle createMultiDiagramLinkStyle() {
		MultiDiagramLinkStyle multiDiagramLinkStyle = new GMFCSSMultiDiagramLinkStyle(getCSSEngine());
		return multiDiagramLinkStyle;
	}


	@Override
	public TextStyle createTextStyle() {
		TextStyle textStyle = new GMFCSSTextStyle(getCSSEngine());
		return textStyle;
	}


	@Override
	public LineTypeStyle createLineTypeStyle() {
		LineTypeStyle lineTypeStyle = new GMFCSSLineTypeStyle(getCSSEngine());
		return lineTypeStyle;
	}


	@Override
	public ArrowStyle createArrowStyle() {
		ArrowStyle arrowStyle = new GMFCSSArrowStyle(getCSSEngine());
		return arrowStyle;
	}


	@Override
	public Shape createShape() {
		Shape shape = new GMFCSSShape(getCSSEngine());
		return shape;
	}


	@Override
	public Compartment createCompartment() {
		Compartment compartment = new GMFCSSCompartment(getCSSEngine());
		return compartment;
	}


	@Override
	public ListCompartment createListCompartment() {
		ListCompartment listCompartment = new GMFCSSListCompartment(getCSSEngine());
		return listCompartment;
	}


	@Override
	public Connector createConnector() {
		Connector connector = new GMFCSSConnector(getCSSEngine());
		return connector;
	}


	@Override
	public StandardDiagram createStandardDiagram() {
		StandardDiagram standardDiagram = new GMFCSSStandardDiagram(getCSSEngine());
		return standardDiagram;
	}


	@Override
	public DecorationNode createDecorationNode() {
		DecorationNode decorationNode = new GMFCSSDecorationNode(getCSSEngine());
		return decorationNode;
	}


	@Override
	public BasicDecorationNode createBasicDecorationNode() {
		BasicDecorationNode basicDecorationNode = new GMFCSSBasicDecorationNode(getCSSEngine());
		return basicDecorationNode;
	}


	@Override
	public BasicCompartment createBasicCompartment() {
		BasicCompartment basicCompartment = new GMFCSSBasicCompartment(getCSSEngine());
		return basicCompartment;
	}


	@Override
	public BasicSemanticCompartment createBasicSemanticCompartment() {
		BasicSemanticCompartment basicSemanticCompartment = new GMFCSSBasicSemanticCompartment(getCSSEngine());
		return basicSemanticCompartment;
	}


	@Override
	public SemanticListCompartment createSemanticListCompartment() {
		SemanticListCompartment semanticListCompartment = new GMFCSSSemanticListCompartment(getCSSEngine());
		return semanticListCompartment;
	}


	@Override
	public RoundedCornersStyle createRoundedCornersStyle() {
		RoundedCornersStyle roundedCornersStyle = new GMFCSSRoundedCornersStyle(getCSSEngine());
		return roundedCornersStyle;
	}


	public ExtendedCSSEngine getCSSEngine() {
		return ExtendedCSSEngine.instance;
	}
}
