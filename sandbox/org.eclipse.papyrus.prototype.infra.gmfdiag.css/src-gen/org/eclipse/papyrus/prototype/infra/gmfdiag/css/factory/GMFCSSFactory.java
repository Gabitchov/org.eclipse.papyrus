package org.eclipse.papyrus.prototype.infra.gmfdiag.css.factory;

import org.eclipse.e4.ui.css.core.engine.CSSEngine;
import org.eclipse.gmf.runtime.notation.impl.NotationFactoryImpl;
import org.eclipse.gmf.runtime.notation.*;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.*;
import org.eclipse.papyrus.prototype.infra.gmfdiag.css.engine.GMFCSSEngineImpl;

public class GMFCSSFactory extends NotationFactoryImpl {
	
	
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
		public RoutingStyle createRoutingStyle() {
			RoutingStyle routingStyle = new GMFCSSRoutingStyle(getCSSEngine());
			return routingStyle;
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
	

	public CSSEngine getCSSEngine() {
		return GMFCSSEngineImpl.instance;
	}
}
