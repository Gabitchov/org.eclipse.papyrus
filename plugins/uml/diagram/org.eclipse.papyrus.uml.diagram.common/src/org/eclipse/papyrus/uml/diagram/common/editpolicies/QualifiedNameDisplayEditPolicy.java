/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.infra.emf.appearance.helper.QualifiedNameHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeNamedElementFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.NodeNamedElementFigure;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * this edit policy has in charge to display the qualified name of an element.
 * To display it, the editpart must be a {@link IPapyrusEditPart} and the
 * associated figure has to be a {@link NodeNamedElementFigure}
 */
public class QualifiedNameDisplayEditPolicy extends GraphicalEditPolicy implements NotificationListener, IPapyrusListener {

	/** key for this edit policy */
	public final static String QUALIFIED_NAME_POLICY = "Qualified_name_editpolicy";

	/** host semantic element */
	protected NamedElement hostSemanticNamedElement;

	/**
	 * The parent listeners list
	 */
	protected List<Object> parentListeners;

	/**
	 * Creates a new QualifiedNameDisplayEditPolicy
	 */
	public QualifiedNameDisplayEditPolicy() {
		super();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void activate() {
		// retrieve the view and the element managed by the edit part
		View view = (View)getHost().getModel();
		if(view == null) {
			return;
		}

		hostSemanticNamedElement = getNamedElement();
		if(hostSemanticNamedElement != null) {
			// adds a listener on the view and the element controlled by the
			// editpart
			getDiagramEventBroker().addNotificationListener(view, this);

			if(hostSemanticNamedElement == null) {
				return;
			}
			getDiagramEventBroker().addNotificationListener(hostSemanticNamedElement, this);

			refreshQualifiedNameDisplay();
		}
		addParentListeners();
	}

	/**
	 * refresh the qualified name
	 */
	protected void refreshQualifiedNameDisplay() {
		if(getHost() instanceof IPapyrusEditPart) {
			if(((IPapyrusEditPart)getHost()).getPrimaryShape() instanceof NodeNamedElementFigure) {
				NodeNamedElementFigure nodeNamedElementFigure = (NodeNamedElementFigure)((IPapyrusEditPart)getHost()).getPrimaryShape();
				refreshQualifiedNameDepth(nodeNamedElementFigure);
				refreshQualifiedName(nodeNamedElementFigure);
			}
		}

	}

	/**
	 * set the qualified name to display
	 * 
	 * @param nodeNamedElementFigure
	 *        the associated figure to the editpart
	 */
	protected void refreshQualifiedName(IPapyrusNodeNamedElementFigure nodeNamedElementFigure) {
		nodeNamedElementFigure.setQualifiedName(hostSemanticNamedElement.getQualifiedName());
	}

	/**
	 * refresh the editpart with a depth for the qualified name
	 * 
	 * @param nodeNamedElementFigure
	 *        the associated figure to the editpart
	 */
	protected void refreshQualifiedNameDepth(NodeNamedElementFigure nodeNamedElementFigure) {
		nodeNamedElementFigure.setDepth(QualifiedNameHelper.getQualifiedNameDepth((View)getHost().getModel()));
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void deactivate() {
		// retrieve the view and the element managed by the edit part
		View view = (View)getHost().getModel();
		if(view == null) {
			return;
		}
		if(hostSemanticNamedElement != null) {
			// remove notification on element and view
			getDiagramEventBroker().removeNotificationListener(view, this);
			getDiagramEventBroker().removeNotificationListener(hostSemanticNamedElement, this);
		}

		// removes the reference to the semantic element
		hostSemanticNamedElement = null;
		removeParentListeners();
	}

	/**
	 * 
	 * @return the associated named element to the editpart. it can return null
	 *         if this not a named element
	 */
	protected NamedElement getNamedElement() {
		View view = (View)getHost().getModel();
		if(view == null) {
			return null;
		}
		if(view.getElement() != null && view.getElement() instanceof NamedElement) {
			return (NamedElement)view.getElement();
		}
		return null;
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
		if(UMLPackage.eINSTANCE.getNamedElement_Name().equals(notification.getFeatureID(NamedElement.class)) || notification.getNotifier() instanceof EAnnotation) {
			refreshQualifiedNameDisplay();
		} else if(UMLPackage.eINSTANCE.getNamedElement_Name().equals(notification.getFeature())) {
			if(parentListeners.contains(notification.getNotifier()) || getNamedElement().equals(notification.getNotifier())) {
				refreshQualifiedNameDisplay();
			}
		} else if(notification.getFeature() instanceof EReference) {
			EReference ref = (EReference)notification.getFeature();
			if(ref.isContainment()) {
				if(parentListeners.contains(notification.getNotifier()))
					removeParentListeners();
				addParentListeners();
				refreshQualifiedNameDisplay();
			}
		}
	}

	/**
	 * Add listeners for all parents
	 */
	private void addParentListeners() {
		DiagramEventBroker diagramEventBroker = getDiagramEventBroker();
		if(diagramEventBroker != null) {
			if(parentListeners == null) {
				parentListeners = new ArrayList<Object>();
			}
			if(getNamedElement() != null) {
				EObject parentEOBject = getNamedElement().eContainer();
				while(parentEOBject != null) {
					diagramEventBroker.addNotificationListener(parentEOBject, this);
					parentListeners.add(parentEOBject);
					parentEOBject = parentEOBject.eContainer();
				}
			}
		}
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
