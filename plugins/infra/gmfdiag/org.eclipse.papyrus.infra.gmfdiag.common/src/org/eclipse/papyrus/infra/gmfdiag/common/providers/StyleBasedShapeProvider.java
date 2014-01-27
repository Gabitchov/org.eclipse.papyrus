/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.providers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.draw2d.ui.render.RenderedImage;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.StringValueStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.Activator;
import org.eclipse.papyrus.infra.gmfdiag.common.service.shape.AbstractShapeProvider;
import org.eclipse.papyrus.infra.gmfdiag.common.service.shape.ProviderNotificationManager;
import org.w3c.dom.svg.SVGDocument;

/**
 * Shape provider based on the applied style
 * 
 * @author Laurent Wouters
 */
public class StyleBasedShapeProvider extends AbstractShapeProvider {

	protected static final String STYLE_PROPERTY = "svgFile";

	private ProviderNotificationManager manager;

	private List<SVGDocument> listEmptySVG;
	private List<RenderedImage> listEmptyRendered;
	private List<SVGDocument> listSingletonSVG;
	private List<RenderedImage> listSingletonRendered;

	public StyleBasedShapeProvider() {
		listEmptySVG = new ArrayList<SVGDocument>(0);
		listEmptyRendered = new ArrayList<RenderedImage>(0);
		listSingletonSVG = new ArrayList<SVGDocument>(1);
		listSingletonSVG.add(null);
		listSingletonRendered = new ArrayList<RenderedImage>(1);
		listSingletonRendered.add(null);
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.service.shape.IShapeProvider#getShapes(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public List<RenderedImage> getShapes(EObject view) {
		if (!(view instanceof View))
			return listEmptyRendered;
		View v = (View) view;
		String svgFile = extract((StringValueStyle) v.getNamedStyle(NotationPackage.eINSTANCE.getStringValueStyle(), STYLE_PROPERTY));
		if (svgFile == null)
			return listEmptyRendered;
		SVGDocument svg = getSVGDocument(view, svgFile);
		RenderedImage img = null;
		try {
			img = renderSVGDocument(view, svg);
		} catch (IOException e) {
			Activator.log.error("Failed to render the svg file: " + svgFile, e);
		}
		listSingletonRendered.set(0, img);
		return listSingletonRendered;
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.service.shape.IShapeProvider#getSVGDocument(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public List<SVGDocument> getSVGDocument(EObject view) {
		if (!(view instanceof View))
			return listEmptySVG;
		View v = (View) view;
		String svgFile = extract((StringValueStyle) v.getNamedStyle(NotationPackage.eINSTANCE.getStringValueStyle(), STYLE_PROPERTY));
		if (svgFile == null)
			return listEmptySVG;
		SVGDocument svg = getSVGDocument(view, svgFile);
		listSingletonSVG.set(0, svg);
		return listSingletonSVG;
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.service.shape.IShapeProvider#providesShapes(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public boolean providesShapes(EObject view) {
		if (!(view instanceof View))
			return false;
		View v = (View) view;
		String svgFile = extract((StringValueStyle) v.getNamedStyle(NotationPackage.eINSTANCE.getStringValueStyle(), STYLE_PROPERTY));
		return (svgFile != null);
	}

	/**
	 * Extracts the primitive value from the given style
	 * 
	 * @param style
	 *            The style
	 * @return The primitive value
	 */
	private String extract(StringValueStyle style) {
		if (style == null || style.getStringValue() == null || style.getStringValue().isEmpty()) {
			return null;
		}
		return style.getStringValue();
	}

	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.service.shape.IShapeProvider#createProviderNotificationManager(org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker, org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener)
	 */
	@Override
	public ProviderNotificationManager createProviderNotificationManager(DiagramEventBroker diagramEventBroker, EObject view, NotificationListener notificationListener) {
		if (manager != null)
			return manager;
		manager = new ProviderNotificationManager(diagramEventBroker, view, notificationListener) {
			@Override
			protected void registerListeners() {

			}
		};
		return manager;
	}
}
