/*****************************************************************************
 * Copyright (c) 2013 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.papyrus.uml.appearance.helper.UMLVisualInformationPapyrusConstant;
import org.eclipse.papyrus.uml.tools.listeners.PapyrusStereotypeListener;
import org.eclipse.papyrus.uml.tools.listeners.PapyrusStereotypeListener.StereotypeCustomNotification;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;


/**
 * Ignore the impact layout when the head get changed.
 * 1. Font of head label changes.
 * 2. Stereotype changes.
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public abstract class AbstractHeadImpactLayoutEditPolicy extends GraphicalEditPolicy implements NotificationListener, IPapyrusListener {

	public static final String HEAD_IMPACT_LAYOUT_POLICY = "HeadImpactLayoutEditPolicy";

	/** host semantic element */
	protected Element hostSemanticElement;

	protected int currentHeadHeight = -1;

	public void activate() {
		// retrieve the view and the element managed by the edit part
		View view = getView();
		if(view == null) {
			return;
		}
		hostSemanticElement = getUMLElement();
		// adds a listener on the view and the element controlled by the
		// editpart
		getDiagramEventBroker().addNotificationListener(view, this);
		if(hostSemanticElement == null) {
			return;
		}
		getDiagramEventBroker().addNotificationListener(hostSemanticElement, this);
		// adds the listener for stereotype application and applied stereotypes
		// add listener to react to the application and remove of a stereotype
		// add a lister to each already applied stereotyped
		for(EObject stereotypeApplication : hostSemanticElement.getStereotypeApplications()) {
			getDiagramEventBroker().addNotificationListener(stereotypeApplication, this);
		}
		currentHeadHeight = getHeadHeight();
	}

	/**
	 * Fix positions after impact layout.
	 */
	public void impactLayout() {
		int headHeight = getHeadHeight();
		if(currentHeadHeight > 0 && headHeight != currentHeadHeight) {
			doImpactLayout(headHeight - currentHeadHeight);
		}
		currentHeadHeight = headHeight;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void deactivate() {
		// retrieve the view and the element managed by the edit part
		View view = getView();
		if(view == null) {
			return;
		}
		getDiagramEventBroker().removeNotificationListener(view, this);
		if(hostSemanticElement == null) {
			return;
		}
		// remove listeners to applied stereotyped
		for(EObject stereotypeApplication : hostSemanticElement.getStereotypeApplications()) {
			getDiagramEventBroker().removeNotificationListener(stereotypeApplication, this);
		}
		// remove notification on element
		getDiagramEventBroker().removeNotificationListener(hostSemanticElement, this);
		// removes the reference to the semantic element
		hostSemanticElement = null;
	}

	/**
	 * Gets the diagram event broker from the editing domain.
	 * 
	 * @return the diagram event broker
	 */
	protected DiagramEventBroker getDiagramEventBroker() {
		TransactionalEditingDomain theEditingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		if(theEditingDomain != null) {
			return DiagramEventBroker.getInstance(theEditingDomain);
		}
		return null;
	}

	/**
	 * Returns the uml element controlled by the host edit part
	 * 
	 * @return the uml element controlled by the host edit part
	 */
	protected Element getUMLElement() {
		EObject element = getView().getElement();
		if(element instanceof Element) {
			return (Element)element;
		}
		return null;
	}

	/**
	 * Returns the view controlled by the host edit part
	 * 
	 * @return the view controlled by the host edit part
	 */
	protected View getView() {
		return (View)getHost().getModel();
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 * 
	 * @param notification
	 */
	public void notifyChanged(Notification notification) {
		Object feature = notification.getFeature();
		boolean headChanged = false;
		if(NotationPackage.eINSTANCE.getFontStyle_FontHeight().equals(feature) || NotationPackage.eINSTANCE.getFontStyle_FontName().equals(feature) || NotationPackage.eINSTANCE.getFontStyle_Bold().equals(feature) || NotationPackage.eINSTANCE.getFontStyle_Italic().equals(feature)) {
			headChanged = true;
		} else if(notification.getNotifier() instanceof EAnnotation && UMLVisualInformationPapyrusConstant.STEREOTYPE_ANNOTATION == ((EAnnotation)notification.getNotifier()).getSource()) {
			headChanged = true;
		} else if((notification.getNotifier() instanceof DynamicEObjectImpl) && (hostSemanticElement != null) && (hostSemanticElement.getStereotypeApplications().contains(notification.getNotifier()))) {
			headChanged = true;
		} else if(PapyrusStereotypeListener.MODIFIED_STEREOTYPE == notification.getEventType()) {
			headChanged = true;
		} else if(notification instanceof StereotypeCustomNotification) {
			headChanged = true;
		}
		if(headChanged) {
			Display.getDefault().asyncExec(new Runnable() {

				public void run() {
					impactLayout();
				}
			});
		}
	}

	protected Rectangle getBoundsRect() {
		Rectangle r = new Rectangle();
		View view = getView();
		if(view instanceof Node) {
			LayoutConstraint layoutConstraint = ((Node)view).getLayoutConstraint();
			if(layoutConstraint instanceof Bounds) {
				Bounds b = (Bounds)layoutConstraint;
				r.x = b.getX();
				r.y = b.getY();
				r.width = b.getWidth();
				r.height = b.getHeight();
			}
		}
		Rectangle bounds = getHostFigure().getBounds();
		if(r.x == -1) {
			r.x = bounds.x;
		}
		if(r.y == -1) {
			r.y = bounds.y;
		}
		if(r.width == -1) {
			r.width = bounds.width;
		}
		if(r.height == -1) {
			r.height = bounds.height;
		}
		Dimension preferredSize = getHostFigure().getPreferredSize();
		if(r.width == 0) {
			r.width = preferredSize.width;
		}
		if(r.height == 0) {
			r.height = preferredSize.height;
		}
		return r;
	}

	protected IFigure getPrimaryShape() {
		if(getHost() instanceof IPapyrusEditPart) {
			return ((IPapyrusEditPart)getHost()).getPrimaryShape();
		}
		return getHostFigure();
	}

	protected TransactionalEditingDomain getEditingDomain() {
		EditPart host = getHost();
		if(host instanceof IGraphicalEditPart) {
			return ((IGraphicalEditPart)host).getEditingDomain();
		}
		return null;
	}

	/**
	 * Compute the height of the head.
	 */
	protected abstract int getHeadHeight();

	/**
	 * Layout contents when the height of head has been changed.
	 * 
	 * @param resizeDelta
	 */
	protected abstract void doImpactLayout(int resizeDelta);

}
