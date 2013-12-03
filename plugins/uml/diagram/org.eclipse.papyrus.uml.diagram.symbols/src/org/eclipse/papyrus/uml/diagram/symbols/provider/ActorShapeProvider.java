/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.symbols.provider;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.draw2d.ui.render.RenderedImage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.utils.BusinessModelResolver;
import org.eclipse.papyrus.infra.gmfdiag.common.service.shape.AbstractShapeProvider;
import org.eclipse.papyrus.infra.gmfdiag.common.service.shape.ProviderNotificationManager;
import org.eclipse.papyrus.uml.diagram.symbols.Activator;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.UMLPackage;
import org.w3c.dom.svg.SVGDocument;


/**
 * Shape Provider for {@link Actor} or for {@link TypedElement} that are typed by an {@link Actor}.
 */
public class ActorShapeProvider extends AbstractShapeProvider {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<RenderedImage> getShapes(EObject view) {
		if(providesShapes(view)) {
			List<SVGDocument> documents = getSVGDocument(view);

			if(documents != null) {
				List<RenderedImage> result = new LinkedList<RenderedImage>();
				for(SVGDocument document : documents) {
					try {
						result.add(renderSVGDocument(view, document));
					} catch (IOException ex) {
						Activator.log.error(ex);
						continue;
					}
				}
				return result;
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean providesShapes(EObject view) {
		if(!(view instanceof View)) {
			return false;
		}

		EObject element = ((View)view).getElement();

		if(element instanceof Actor || (element instanceof TypedElement && ((TypedElement)element).getType() instanceof Actor)) {
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProviderNotificationManager createProviderNotificationManager(DiagramEventBroker diagramEventBroker, EObject view, NotificationListener listener) {
		// retrieve semantic element from the view and add a notification listener on the Type feature if the semantic element is a TypedElement
		if(view == null || !(view instanceof View)) {
			return null;
		}

		ActorShapeProviderNotificationManager notificationManager = new ActorShapeProviderNotificationManager(diagramEventBroker, view, listener);
		return notificationManager;
	}

	/**
	 * Notification Manager for the {@link ActorShapeProvider}.
	 */
	public class ActorShapeProviderNotificationManager extends ProviderNotificationManager implements NotificationListener {

		/**
		 * Creates a new ActorShapeProviderNotificationManager.
		 * 
		 * @param diagramEventBroker
		 *        event broker specific to the diargam displaying the shapes.
		 * @param view
		 *        the view from which all elements to listen will be computed.
		 * @param listener
		 *        the listener to which notifications will be forwarded.
		 */
		public ActorShapeProviderNotificationManager(DiagramEventBroker diagramEventBroker, EObject view, NotificationListener listener) {
			super(diagramEventBroker, view, listener);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected void registerListeners() {
			if(view == null || !(view instanceof View)) {
				return;
			}
			Object semanticElement = BusinessModelResolver.getInstance().getBusinessModel(view);
			if(semanticElement instanceof Element) {
				diagramEventBroker.addNotificationListener((Element)semanticElement, this);
			}
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void dispose() {
			if(view == null || !(view instanceof View)) {
				return;
			}
			Object semanticElement = BusinessModelResolver.getInstance().getBusinessModel(view);
			if(semanticElement instanceof Element) {
				diagramEventBroker.removeNotificationListener((Element)semanticElement, this);
			}
			super.dispose();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void notifyChanged(Notification notification) {
			if(listener == null) {
				return;
			}
			if(UMLPackage.eINSTANCE.getTypedElement_Type().equals(notification.getFeature())) {
				listener.notifyChanged(notification);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<SVGDocument> getSVGDocument(EObject view) {
		if(providesShapes(view)) {
			URI uri = URI.createPlatformPluginURI(org.eclipse.papyrus.uml.diagram.common.Activator.ID + "/icons/symbols/actor.svg", true);
			String path = uri.toString();
			SVGDocument document = getSVGDocument(path);
			if(document == null) {
				return null;
			}
			return Arrays.asList(getSVGDocument(path));
		}
		return null;
	}
}
