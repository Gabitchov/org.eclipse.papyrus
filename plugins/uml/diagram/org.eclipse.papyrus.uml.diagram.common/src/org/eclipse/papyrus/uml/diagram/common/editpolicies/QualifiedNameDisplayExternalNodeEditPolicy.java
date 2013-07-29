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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.emf.appearance.helper.QualifiedNameHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeNamedElementFigure;

/**
 * this edit policy has in charge to display the qualified name of an elementin a external label.
 * To display it, the editpart must be a {@link IPapyrusEditPart} and the
 * associated figure has to be a {@link NodeNamedElementFigure}
 */
public class QualifiedNameDisplayExternalNodeEditPolicy extends QualifiedNameDisplayEditPolicy {



	/**
	 * Creates a new QualifiedNameDisplayEditPolicy
	 */
	public QualifiedNameDisplayExternalNodeEditPolicy() {
		super();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void activate() {
		// retrieve the view and the element managed by the edit part
		View view = (View)getHost().getParent().getModel();
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
			if(((IPapyrusEditPart)getHost()).getPrimaryShape() instanceof IPapyrusNodeNamedElementFigure) {
				IPapyrusNodeNamedElementFigure nodeNamedElementFigure = (IPapyrusNodeNamedElementFigure)((IPapyrusEditPart)getHost()).getPrimaryShape();
				refreshQualifiedNameDepth(nodeNamedElementFigure);
				refreshQualifiedName(nodeNamedElementFigure);
			}
		}

	}


	/**
	 * refresh the editpart with a depth for the qualified name
	 * 
	 * @param nodeNamedElementFigure
	 *        the associated figure to the editpart
	 */
	protected void refreshQualifiedNameDepth(IPapyrusNodeNamedElementFigure nodeNamedElementFigure) {
		nodeNamedElementFigure.setDepth(QualifiedNameHelper.getQualifiedNameDepth((View)(getHost().getParent()).getModel()));
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void deactivate() {
		// retrieve the view and the element managed by the edit part
		View view = (View)(getHost().getParent()).getModel();
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

}
