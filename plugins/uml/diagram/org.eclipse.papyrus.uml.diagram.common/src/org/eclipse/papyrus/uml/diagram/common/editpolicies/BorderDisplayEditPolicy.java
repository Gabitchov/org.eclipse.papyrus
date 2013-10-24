/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import java.util.List;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.OneLineBorder;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.diagram.common.editparts.NamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.common.figure.node.NodeNamedElementFigure;
import org.eclipse.uml2.uml.NamedElement;

/**
 * this edit policy has in charge to display tthe border of node NodeNamedElement
 * associated figure has to be a {@link NodeNamedElementFigure}
 */
public class BorderDisplayEditPolicy extends GraphicalEditPolicy implements NotificationListener, IPapyrusListener {

	public static final String DISPLAY_BORDER = "BorderDisplay";

	/** key for this edit policy */
	public final static String BORDER_DISPLAY_EDITPOLICY = "BORDER_DISPLAY_EDITPOLICY";

	/** host semantic element */
	protected NamedElement hostSemanticNamedElement;

	/**
	 * The parent listeners list
	 */
	protected List<Object> parentListeners;

	private Border defaultBorder;

	/**
	 * Creates a new QualifiedNameDisplayEditPolicy
	 */
	public BorderDisplayEditPolicy() {
		super();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void activate() {
		// retrieve the view and the element managed by the edit part
		View view = (View)getHost().getModel();
		if(view == null) {
			return;
		}

		// adds a listener on the view and the element controlled by the
		// editpart
		getDiagramEventBroker().addNotificationListener(view, this);

		EObject semanticElement = EMFHelper.getEObject(getHost());
		if(semanticElement instanceof NamedElement) {
			hostSemanticNamedElement = (NamedElement)semanticElement;
		}

		if(hostSemanticNamedElement == null) {
			return;
		}
		getDiagramEventBroker().addNotificationListener(hostSemanticNamedElement, this);
		if(getHost() instanceof NamedElementEditPart) {
			NamedElementEditPart namedElementEditPart = (NamedElementEditPart)getHost();
			defaultBorder=namedElementEditPart.getPrimaryShape().getBorder();
				
		}
		refreshBorder();
	}

	/**
	 * refresh the qualified name
	 */
	protected void refreshBorder() {
		if(getHost() instanceof NamedElementEditPart) {
			NamedElementEditPart namedElementEditPart = (NamedElementEditPart)getHost();
			BooleanValueStyle boderStyle = getBorderStyle(namedElementEditPart.getNotationView());
			if(boderStyle != null && boderStyle.isBooleanValue() == false) {
				namedElementEditPart.getPrimaryShape().setBorder(null);
				for(Object currentEditPart : namedElementEditPart.getChildren()) {
					if(currentEditPart instanceof ResizableCompartmentEditPart) {
						((ResizableCompartmentEditPart)currentEditPart).getFigure().setBorder(null);
					}

				}

			} else {
				namedElementEditPart.getPrimaryShape().setBorder(defaultBorder);
				for(Object currentEditPart : namedElementEditPart.getChildren()) {
					if(currentEditPart instanceof ResizableCompartmentEditPart) {
						((ResizableCompartmentEditPart)currentEditPart).getFigure().setBorder(new OneLineBorder());
					}

				}
			}
		}
	}

	/**
	 * 
	 * @param currentView
	 * @return the current Style that repersent the boder
	 */
	protected BooleanValueStyle getBorderStyle(View currentView) {
		return (BooleanValueStyle)currentView.getNamedStyle(NotationPackage.eINSTANCE.getBooleanValueStyle(), DISPLAY_BORDER);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void deactivate() {
		// retrieve the view and the element managed by the edit part
		View view = (View)getHost().getModel();
		if(view == null) {
			return;
		}
		// remove notification on element and view
		getDiagramEventBroker().removeNotificationListener(view, this);

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
	 * 
	 * {@inheritDoc}
	 */
	public void notifyChanged(Notification notification) {
		refreshBorder();
	}


	/**
	 * Remove all parents listeners
	 */
	public void removeParentListeners() {
		for(Object listener : parentListeners) {
			getDiagramEventBroker().removeNotificationListener((EObject)listener, this);
		}
	}
}
