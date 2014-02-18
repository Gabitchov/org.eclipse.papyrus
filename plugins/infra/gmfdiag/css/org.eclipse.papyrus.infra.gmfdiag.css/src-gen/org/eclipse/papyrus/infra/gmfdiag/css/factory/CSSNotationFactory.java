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
package org.eclipse.papyrus.infra.gmfdiag.css.factory;

import org.eclipse.gmf.runtime.notation.ArrowStyle;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.BasicSemanticCompartment;
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
import org.eclipse.gmf.runtime.notation.DrawerStyle;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.FilteringStyle;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.GuideStyle;
import org.eclipse.gmf.runtime.notation.HintedDiagramLinkStyle;
import org.eclipse.gmf.runtime.notation.ImageBufferStyle;
import org.eclipse.gmf.runtime.notation.ImageStyle;
import org.eclipse.gmf.runtime.notation.LineStyle;
import org.eclipse.gmf.runtime.notation.LineTypeStyle;
import org.eclipse.gmf.runtime.notation.ListCompartment;
import org.eclipse.gmf.runtime.notation.MultiDiagramLinkStyle;
import org.eclipse.gmf.runtime.notation.NamedStyle;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.PageStyle;
import org.eclipse.gmf.runtime.notation.PropertiesSetStyle;
import org.eclipse.gmf.runtime.notation.RoundedCornersStyle;
import org.eclipse.gmf.runtime.notation.RoutingStyle;
import org.eclipse.gmf.runtime.notation.SemanticListCompartment;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.SortingStyle;
import org.eclipse.gmf.runtime.notation.StandardDiagram;
import org.eclipse.gmf.runtime.notation.TextStyle;
import org.eclipse.gmf.runtime.notation.TitleStyle;
import org.eclipse.gmf.runtime.notation.impl.NotationFactoryImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSArrowStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSBasicCompartmentImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSBasicSemanticCompartmentImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSCanonicalStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSCompartmentImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSConnectorImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSConnectorStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSDataTypeStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSDecorationNodeImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSDescriptionStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSDiagramLinkStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSDiagramStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSDrawerStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSEdgeImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSFillStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSFilteringStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSFontStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSGuideStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSHintedDiagramLinkStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSImageBufferStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSImageStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSLineStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSLineTypeStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSListCompartmentImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSMultiDiagramLinkStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSNamedStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSNodeImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSPageStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSPropertiesSetStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSRoundedCornersStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSRoutingStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSSemanticListCompartmentImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSShapeImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSShapeStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSSortingStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSStandardDiagramImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSTextStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSTitleStyleImpl;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagramImpl;

/**
 * This factory overrides the GMF NotationFactory for implementing the Notation model
 *
 * It provides a CSS-Aware implementation of the Notation model.
 *
 * As the only way to use a custom Metamodel Factory is to replace the singleton instance, this factory may introduce
 * noise for all GMF-based components. However, the CSS implementation of the Notation Metamodel is built in such a way
 * that it doesn't introduce any behavioral change for non-CSS diagrams.
 *
 * The CSS Support must be explicitly installed on the ResourceSet in order to activate the CSS-Aware capabilities of
 * this implementation.
 *
 * @see {@link org.eclipse.papyrus.infra.gmfdiag.css.helper.CSSHelper#installCSSSupport(org.eclipse.emf.ecore.resource.ResourceSet)}
 *
 * @author Camille Letavernier
 * 
 */
public class CSSNotationFactory extends NotationFactoryImpl {

	public static CSSNotationFactory eINSTANCE = new CSSNotationFactory();

	@Override
	public Diagram createDiagram() {
		return new CSSDiagramImpl();
	}

	@Override
	public FillStyle createFillStyle() {
		return new CSSFillStyleImpl();
	}

	@Override
	public LineStyle createLineStyle() {
		return new CSSLineStyleImpl();
	}

	@Override
	public FontStyle createFontStyle() {
		return new CSSFontStyleImpl();
	}

	@Override
	public TitleStyle createTitleStyle() {
		return new CSSTitleStyleImpl();
	}

	@Override
	public SortingStyle createSortingStyle() {
		return new CSSSortingStyleImpl();
	}

	@Override
	public DescriptionStyle createDescriptionStyle() {
		return new CSSDescriptionStyleImpl();
	}

	@Override
	public RoutingStyle createRoutingStyle() {
		return new CSSRoutingStyleImpl();
	}

	@Override
	public CanonicalStyle createCanonicalStyle() {
		return new CSSCanonicalStyleImpl();
	}

	@Override
	public ShapeStyle createShapeStyle() {
		return new CSSShapeStyleImpl();
	}

	@Override
	public ConnectorStyle createConnectorStyle() {
		return new CSSConnectorStyleImpl();
	}

	@Override
	public PageStyle createPageStyle() {
		return new CSSPageStyleImpl();
	}

	@Override
	public DrawerStyle createDrawerStyle() {
		return new CSSDrawerStyleImpl();
	}

	@Override
	public GuideStyle createGuideStyle() {
		return new CSSGuideStyleImpl();
	}

	@Override
	public FilteringStyle createFilteringStyle() {
		return new CSSFilteringStyleImpl();
	}

	@Override
	public DiagramStyle createDiagramStyle() {
		return new CSSDiagramStyleImpl();
	}

	@Override
	public ImageStyle createImageStyle() {
		return new CSSImageStyleImpl();
	}

	@Override
	public ImageBufferStyle createImageBufferStyle() {
		return new CSSImageBufferStyleImpl();
	}

	@Override
	public PropertiesSetStyle createPropertiesSetStyle() {
		return new CSSPropertiesSetStyleImpl();
	}

	@Override
	public NamedStyle createNamedStyle() {
		return new CSSNamedStyleImpl();
	}

	@Override
	public DataTypeStyle createDataTypeStyle() {
		return new CSSDataTypeStyleImpl();
	}

	@Override
	public HintedDiagramLinkStyle createHintedDiagramLinkStyle() {
		return new CSSHintedDiagramLinkStyleImpl();
	}

	@Override
	public DiagramLinkStyle createDiagramLinkStyle() {
		return new CSSDiagramLinkStyleImpl();
	}

	@Override
	public MultiDiagramLinkStyle createMultiDiagramLinkStyle() {
		return new CSSMultiDiagramLinkStyleImpl();
	}

	@Override
	public TextStyle createTextStyle() {
		return new CSSTextStyleImpl();
	}

	@Override
	public LineTypeStyle createLineTypeStyle() {
		return new CSSLineTypeStyleImpl();
	}

	@Override
	public ArrowStyle createArrowStyle() {
		return new CSSArrowStyleImpl();
	}

	@Override
	public Shape createShape() {
		return new CSSShapeImpl();
	}

	@Override
	public Compartment createCompartment() {
		return new CSSCompartmentImpl();
	}

	@Override
	public ListCompartment createListCompartment() {
		return new CSSListCompartmentImpl();
	}

	@Override
	public Connector createConnector() {
		return new CSSConnectorImpl();
	}

	@Override
	public StandardDiagram createStandardDiagram() {
		return new CSSStandardDiagramImpl();
	}

	@Override
	public BasicCompartment createBasicCompartment() {
		return new CSSBasicCompartmentImpl();
	}

	@Override
	public BasicSemanticCompartment createBasicSemanticCompartment() {
		return new CSSBasicSemanticCompartmentImpl();
	}

	@Override
	public SemanticListCompartment createSemanticListCompartment() {
		return new CSSSemanticListCompartmentImpl();
	}

	@Override
	public RoundedCornersStyle createRoundedCornersStyle() {
		return new CSSRoundedCornersStyleImpl();
	}

	@Override
	public DecorationNode createDecorationNode() {
		return new CSSDecorationNodeImpl();
	}

	@Override
	public Edge createEdge() {
		return new CSSEdgeImpl();
	}

	@Override
	public Node createNode() {
		return new CSSNodeImpl();
	}

}
