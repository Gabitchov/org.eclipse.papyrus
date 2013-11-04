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

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.apache.batik.dom.svg.SVGOMDocument;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.draw2d.ui.render.RenderedImage;
import org.eclipse.gmf.runtime.draw2d.ui.render.factory.RenderedImageFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.service.shape.AbstractShapeProvider;
import org.eclipse.papyrus.infra.gmfdiag.common.service.shape.ProviderNotificationManager;
import org.eclipse.papyrus.infra.gmfdiag.common.service.shape.ShapeService;
import org.eclipse.papyrus.uml.diagram.symbols.Activator;
import org.eclipse.papyrus.uml.diagram.symbols.IPapyrusInternalProfileConstants;
import org.eclipse.papyrus.uml.tools.listeners.PapyrusStereotypeListener.StereotypeCustomNotification;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This provider is linked to the {@link ShapeService}. It returns the shapes for a given typed element corresponding to the stereotypes applied on
 * the business element.
 */
public class TypedElementShapeProvider extends AbstractShapeProvider {

	/**
	 * {@inheritDoc}
	 */
	public List<RenderedImage> getShapes(EObject view) {
		Type type = getType(view);
		String path = getSymbolPath(type);
		if(path != null && path.length() > 0) {
			URL url;
			try {
				url = new URL(path);
				return Arrays.asList(RenderedImageFactory.getInstance(url));
			} catch (MalformedURLException e) {
				URI typeResourceURI = type.eResource().getURI();
				if(typeResourceURI != null) {
					String workspaceRelativeFolderPath = typeResourceURI.trimSegments(1).toPlatformString(true);
					try {
						url = new URL("platform:/resource/" + workspaceRelativeFolderPath + File.separatorChar + path);
						return Arrays.asList(RenderedImageFactory.getInstance(url));
					} catch (MalformedURLException e1) {
						Activator.log.error(e1);
					}
				}
			}
		}
		return null;
	}


	public List<SVGOMDocument> getSVGOMDocument(EObject view) {
		Type type = getType(view);
		String path = getSymbolPath(type);
		if(path != null && path.length() > 0) {
			URL url;
			try {
				url = new URL(path);
				SVGOMDocument document=getSVGDocument(path);
				if(document!=null){
					return Arrays.asList(document);
				}
				return Arrays.asList(getSVGDocument(path));
			} catch (MalformedURLException e) {
				URI typeResourceURI = type.eResource().getURI();
				if(typeResourceURI != null) {
					String workspaceRelativeFolderPath = typeResourceURI.trimSegments(1).toPlatformString(true);
					String newPath = "platform:/resource/" + workspaceRelativeFolderPath + File.separatorChar + path;
					SVGOMDocument document=getSVGDocument(newPath);
					if(document!=null){
						return Arrays.asList(document);
					}
				}
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean providesShapes(EObject view) {
		Type type = getType(view);
		String path = getSymbolPath(type);
		if(path != null && path.length() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the type associated to the semantic element linkerd to the view
	 * 
	 * @param view
	 *        the view from which type should be looked
	 * @return the type of the semantic element or <code>null</code> if none was found
	 */
	protected Type getType(EObject view) {
		if(!(view instanceof View)) {
			return null;
		}

		Object element = ((View)view).getElement();
		if(element instanceof Type) {
			return (Type)element;
		} else if(element instanceof TypedElement) {
			// retrieve type and tries to find a shape for it
			return ((TypedElement)element).getType();
		}
		return null;
	}

	/**
	 * Returns the path for the symbol associated to the element
	 * 
	 * @param view
	 * @return
	 */
	protected String getSymbolPath(Type type) {
		if(type == null) {
			return null;
		}

		// type is not null. Look for the stereotype symbol definition
		Stereotype stereotype = type.getAppliedStereotype(IPapyrusInternalProfileConstants.TYPE_SYMBOL_DEFINITION_QUALIFIED_NAME);
		if(stereotype == null) {
			return null;
		}

		Object path = type.getValue(stereotype, IPapyrusInternalProfileConstants.TYPE_SYMBOL_DEFINITION_SYMBOL_PATH);
		if(path instanceof String && ((String)path).length() > 0) {
			return path.toString();
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public ProviderNotificationManager createProviderNotificationManager(DiagramEventBroker diagramEventBroker, EObject view, NotificationListener listener) {
		if(view == null || !(view instanceof View)) {
			return null;
		}
		TypedElementShapeProviderNotificationManager notificationManager = new TypedElementShapeProviderNotificationManager(diagramEventBroker, view, listener);
		return notificationManager;
	}

	/**
	 * Notification Manager for the {@link TypedElementShapeProvider}.
	 */
	public class TypedElementShapeProviderNotificationManager extends ProviderNotificationManager implements NotificationListener {

		/**
		 * Creates a new StereotypedElementShapeProviderNotificationManager.
		 * 
		 * @param diagramEventBroker
		 *        event broker specific to the diargam displaying the shapes.
		 * @param view
		 *        the view from which all elements to listen will be computed.
		 * @param listener
		 *        the listener to which notifications will be forwarded.
		 */
		public TypedElementShapeProviderNotificationManager(DiagramEventBroker diagramEventBroker, EObject view, NotificationListener listener) {
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
			// should register this listener on the type, to listen for stereotype modification
			// should listen to new value of the typedElement_type feature, in order to remove/add the stereotype listener...
			Object semanticElement = ((View)view).getElement();
			if(semanticElement instanceof Type) {
				diagramEventBroker.addNotificationListener((Type)semanticElement, this);
			} else if(semanticElement instanceof TypedElement) {
				diagramEventBroker.addNotificationListener((TypedElement)semanticElement, this);
				Type type = ((TypedElement)semanticElement).getType();
				if(type != null) {
					diagramEventBroker.addNotificationListener(type, this);
				}
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
			Object semanticElement = ((View)view).getElement();
			if(semanticElement instanceof Type) {
				diagramEventBroker.removeNotificationListener((Type)semanticElement, this);
			} else if(semanticElement instanceof TypedElement) {
				diagramEventBroker.removeNotificationListener((TypedElement)semanticElement, this);

				Type type = ((TypedElement)semanticElement).getType();
				if(type != null) {
					diagramEventBroker.removeNotificationListener(type, this);
				}
			}
			super.dispose();
		}

		/**
		 * {@inheritDoc}
		 */
		public void notifyChanged(Notification notification) {
			if(listener == null) {
				return;
			}

			if(UMLPackage.eINSTANCE.getTypedElement_Type().equals(notification.getFeature())) {
				listener.notifyChanged(notification);
				// add/remove stereotype listener if needed...
				Object oldValue = notification.getOldValue();
				if(oldValue instanceof Type) {
					// a type was removed => remove the listener from this old type
					diagramEventBroker.removeNotificationListener((Type)oldValue, this);
				}
				Object newValue = notification.getNewValue();
				if(newValue instanceof Type) {
					// a type was added => adds the listener from this new type
					diagramEventBroker.removeNotificationListener((Type)newValue, this);
				}
			} else if(notification instanceof StereotypeCustomNotification) {
				// call refresh for all stereotype notifications. could target specific modification on the stereotype Symbol definition
				listener.notifyChanged(notification);
			}

		}
	}

}
