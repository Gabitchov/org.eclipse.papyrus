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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.ShapeDisplayCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.common.editparts.NamedElementEditPart;
import org.eclipse.papyrus.uml.diagram.common.figure.node.NodeNamedElementFigure;
import org.eclipse.uml2.uml.NamedElement;

/**
 * this edit policy has in charge to set the ratio of the symbol if is displayed
 * associated figure has to be a {@link NodeNamedElementFigure}
 */
public class MaintainSymbolRatioEditPolicy extends GraphicalEditPolicy implements NotificationListener, IPapyrusListener {

	public static final String MAINTAIN_SYMBOL_RATIO = "MaintainSymbolRatio";

	/** key for this edit policy */
	public final static String MAINTAIN_SYMBOL_RATIO_EDITPOLICY = "MAINTAIN_SYMBOL_RATIO_EDITPOLICY";

	/** host semantic element */
	protected NamedElement hostSemanticNamedElement;

	/**
	 * The parent listeners list
	 */
	protected List<Object> parentListeners;

	/**
	 * Creates a new QualifiedNameDisplayEditPolicy
	 */
	public MaintainSymbolRatioEditPolicy() {
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

		// adds a listener on the view and the element controlled by the
		// editpart
		getDiagramEventBroker().addNotificationListener(view, this);

		if(hostSemanticNamedElement == null) {
			return;
		}
		getDiagramEventBroker().addNotificationListener(hostSemanticNamedElement, this);

		refreshSymbolCompartment();
	}

	/**
	 * refresh the qualified name
	 */
	protected void refreshSymbolCompartment() {
		if(getHost() instanceof NamedElementEditPart) {
			NamedElementEditPart namedElementEditPart=(NamedElementEditPart)getHost();
			BooleanValueStyle maintainRatio=getMaintainSymbolRatioStyle(namedElementEditPart.getNotationView());
			if(maintainRatio!=null && maintainRatio.isBooleanValue()==false){
				for(Object currentEditPart : namedElementEditPart.getChildren()) {
					if(currentEditPart instanceof ShapeDisplayCompartmentEditPart){
						((ShapeDisplayCompartmentEditPart)currentEditPart).maintainRatio(false);
					}
				}
				
			}
			else{
				for(Object currentEditPart : namedElementEditPart.getChildren()) {
					if(currentEditPart instanceof ShapeDisplayCompartmentEditPart){
						((ShapeDisplayCompartmentEditPart)currentEditPart).maintainRatio(true);
					}
					
				}
			}
		}
	}

/**
 * 
 * @param currentView
 * @return the current Style that reperesent the boder
 */
	protected BooleanValueStyle getMaintainSymbolRatioStyle(View currentView){
		List<?> viewStyle=currentView.getStyles();
		for(Object currentStyle : viewStyle) {
			if( currentStyle instanceof BooleanValueStyle){
				if(((BooleanValueStyle)currentStyle).getName().equals(MAINTAIN_SYMBOL_RATIO)){
					return (BooleanValueStyle)currentStyle;
					}
				}
			}
		
		return null;

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
		refreshSymbolCompartment();
	}


}
