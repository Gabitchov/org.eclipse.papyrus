package org.eclipse.papyrus.uml.diagram.common.service.shape;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.draw2d.ui.render.RenderedImage;
import org.eclipse.gmf.runtime.draw2d.ui.render.factory.RenderedImageFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.Activator;
import org.eclipse.papyrus.infra.gmfdiag.common.service.shape.AbstractShapeProvider;
import org.eclipse.papyrus.infra.gmfdiag.common.service.shape.ProviderNotificationManager;
import org.eclipse.papyrus.infra.gmfdiag.common.service.shape.ShapeService;
import org.eclipse.papyrus.uml.appearance.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.uml.appearance.helper.UMLVisualInformationPapyrusConstant;
import org.eclipse.papyrus.uml.tools.utils.ElementUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * This provider is linked to the {@link ShapeService}. It returns the shapes for a given element corresponding to the stereotypes applied on the
 * business element.
 */
public class StereotypedElementShapeProvider extends AbstractShapeProvider {

	private static final String SHAPE_CONSTANT = "shape";

	/**
	 * {@inheritDoc}
	 */
	public List<RenderedImage> getShapes(EObject view) {
		if(!(view instanceof View)) {
			return null;
		}
		EObject element = ((View)view).getElement();
		if(element instanceof Element) {
			List<RenderedImage> images = new ArrayList<RenderedImage>();
			// it has already been checked that 
			URL url;
			try {
				String stereotypesToDisplay = AppliedStereotypeHelper.getStereotypesToDisplay((View)view);
				StringTokenizer tokenizer = new StringTokenizer(stereotypesToDisplay, ",");
				while(tokenizer.hasMoreTokens()) {
					String stereotypeName = tokenizer.nextToken();
					Stereotype stereotype = ((Element)element).getAppliedStereotype(stereotypeName);
					org.eclipse.uml2.uml.Image icon = ElementUtil.getStereotypeImage(((Element)element), stereotype, SHAPE_CONSTANT);
					if(icon != null) {
						if(icon.getLocation() != "" && icon.getLocation() != null) {
							url = new URL(icon.getLocation());
							images.add(RenderedImageFactory.getInstance(url));
						}
					}
				}

				return images;
			} catch (MalformedURLException e) {
				Activator.log.error(e);
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean providesShapes(EObject view) {
		if(!(view instanceof View)) {
			return false;
		}

		EObject element = ((View)view).getElement();
		if(element instanceof Element) {

			// This is an element. does it have stereotypes ? If yes, do the stereotypes have shapes associated ?
			String stereotypesToDisplay = AppliedStereotypeHelper.getStereotypesToDisplay((View)view);
			StringTokenizer tokenizer = new StringTokenizer(stereotypesToDisplay, ",");
			if(tokenizer.hasMoreTokens()) {
				String firstStereotypeName = tokenizer.nextToken();
				Stereotype stereotype = ((Element)element).getAppliedStereotype(firstStereotypeName);
				org.eclipse.uml2.uml.Image icon = ElementUtil.getStereotypeImage(((Element)element), stereotype, SHAPE_CONSTANT);
				if(icon != null) {
					if(icon.getLocation() != "" && icon.getLocation() != null) {
						return true;
					}
				}
			}
		}

		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public ProviderNotificationManager createProviderNotificationManager(DiagramEventBroker diagramEventBroker, EObject view, NotificationListener listener) {
		// retrieve semantic element from the view and add a notification listener on the Type feature if the semantic element is a TypedElement
		if(view == null || !(view instanceof View)) {
			return null;
		}

		StereotypedElementShapeProviderNotificationManager notificationManager = new StereotypedElementShapeProviderNotificationManager(diagramEventBroker, view, listener);
		return notificationManager;
	}

	/**
	 * Notification Manager for the {@link StereotypedElementShapeProvider}.
	 */
	public class StereotypedElementShapeProviderNotificationManager extends ProviderNotificationManager implements NotificationListener {

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
		public StereotypedElementShapeProviderNotificationManager(DiagramEventBroker diagramEventBroker, EObject view, NotificationListener listener) {
			super(diagramEventBroker, view, listener);
		}

		/**
		 * {@inheritDoc}
		 */
		protected void registerListeners() {
			if(view == null || !(view instanceof View)) {
				return;
			}
			diagramEventBroker.addNotificationListener(view, this);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void dispose() {
			if(view == null || !(view instanceof View)) {
				return;
			}
			diagramEventBroker.removeNotificationListener(view, this);
			super.dispose();
		}

		/**
		 * {@inheritDoc}
		 */
		public void notifyChanged(Notification notification) {
			if(listener == null) {
				return;
			}
			if(EcorePackage.eINSTANCE.getEModelElement_EAnnotations().equals(notification.getFeature())) {
				Object newValue = notification.getNewValue();
				if(newValue instanceof EAnnotation && UMLVisualInformationPapyrusConstant.STEREOTYPE_ANNOTATION.equals(((EAnnotation)newValue).getSource())) {
					// the stereotype annotation was modified => refresh
					listener.notifyChanged(notification);
				}
			}
		}
	}

}
