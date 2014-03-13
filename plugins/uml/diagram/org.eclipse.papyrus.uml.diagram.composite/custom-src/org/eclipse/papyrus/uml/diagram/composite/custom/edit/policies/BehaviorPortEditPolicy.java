/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Patrick Tessier (CEA LIST) - Initial API and implementation
 *      Christian W. Damus (CEA) - bug 323802
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.edit.policies;

import java.util.Iterator;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.GMFUnsafe;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.composite.custom.edit.command.CreateBehaviorPortCommand;
import org.eclipse.papyrus.uml.diagram.composite.custom.locators.BehaviorPortLocator;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.BehaviorPortLinkEditPart;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.UMLPackage;

/**
 *This editpolicy is a listener that listen the feature is_behavior of the port. It launches a synchronous thread to create a notation node and the link.
 * This editpolicy calls explicitly BehaviorPortLocator  in order to place the symbol behavior at the good place (inside the composite).
 */
public class BehaviorPortEditPolicy extends GraphicalEditPolicy implements NotificationListener, IPapyrusListener {
	public static String BEHAVIOR_PORT="BehaviorPortPolicy";

	private Port hostSemanticElement;

	public void notifyChanged(Notification notification) {

		if( UMLPackage.eINSTANCE.getPort_IsBehavior().equals(notification.getFeature())){
			udaptePortBehavior();
		}
	}

	protected void udaptePortBehavior() {
		ShapeCompartmentEditPart targetEditPart=getPossibleCompartment(((GraphicalEditPart) getHost()).getParent());
		if(targetEditPart!=null){
			View behaviorPort=getBehaviorPortNode();
			if(hostSemanticElement.isBehavior()&& behaviorPort==null){
				BehaviorPortLocator locator = new BehaviorPortLocator(((GraphicalEditPart) getHost().getParent()).getFigure(), PositionConstants.NONE);
				locator.setBorderItemOffset(60);
				Rectangle rectBehavior =locator.getPreferredLocation(((GraphicalEditPart)getHost()).getFigure().getBounds());
				//obtain coordinate to put the behavior
				Rectangle rectContainer=(targetEditPart).getContentPane().getParent().getBounds();
				rectBehavior=rectBehavior.getTranslated(-rectContainer.x, -rectContainer.y);
				executeBehaviorPortCreation(targetEditPart, ((GraphicalEditPart) getHost()),((GraphicalEditPart) getHost()).getEditingDomain(), rectBehavior);
			}
			else{
				if(!hostSemanticElement.isBehavior()){
					//remove behaviorPort
					executeBehaviorPortDeletion(((GraphicalEditPart) getHost()).getEditingDomain(), behaviorPort);}
			}
		}
	}

	protected void executeBehaviorPortDeletion( final TransactionalEditingDomain domain, final View behaviorNode) {
		if((behaviorNode != null) && (TransactionUtil.getEditingDomain(behaviorNode) == domain)) {
			DeleteCommand command = new DeleteCommand(behaviorNode);
			//use to avoid to put it in the command stack
			try {
				GMFUnsafe.write(domain, command);
			} catch (Exception e) {
				Activator.log.error(e);
			}
		}
	}

	/**
	 * return the comment nodes that represent stereotype properties
	 * @return may be null if nothing is founded
	 */
	protected Node getBehaviorPortNode(){
		View SemanticView=(View) getHost().getModel();

		Edge behaviorPortLink= null;
		@SuppressWarnings("unchecked")
		Iterator<Edge>edgeIterator=SemanticView.getSourceEdges().iterator();
		while(edgeIterator.hasNext()) {
			Edge edge = (Edge)edgeIterator.next();
			if (edge.getType().equals(""+BehaviorPortLinkEditPart.VISUAL_ID)){
				behaviorPortLink=edge;
			}

		}
		if(behaviorPortLink== null){
			return null;
		}
		return (Node)behaviorPortLink.getTarget();

	}

	protected ShapeCompartmentEditPart getPossibleCompartment(EditPart parent){
		ShapeCompartmentEditPart found=null;
		int i=0;
		while(found==null && i < parent.getChildren().size()){
			if( parent.getChildren().get(i) instanceof ShapeCompartmentEditPart){
				found=(ShapeCompartmentEditPart)parent.getChildren().get(i);
			}
			i++;
		}
		return found;
	}

	protected  void executeBehaviorPortCreation(final EditPart editPart, final EditPart port,final TransactionalEditingDomain domain, final Rectangle position){
		CreateBehaviorPortCommand command = new CreateBehaviorPortCommand(domain, (View)editPart.getModel(), (View)port.getModel(), position);
		//use to avoid to put it in the command stack
		try {
			GMFUnsafe.write(domain, command);
		} catch (Exception e) {
			Activator.log.error(e);
		}
	}
	/**
	 * 
	 * {@inheritDoc}
	 */
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
		udaptePortBehavior();
	}
	@Override
	public void deactivate() {
		// TODO Auto-generated method stub
		super.deactivate();
		// remove notification on element
		getDiagramEventBroker().removeNotificationListener(hostSemanticElement, this);

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
	protected Port getUMLElement() {
		EObject element = getView().getElement();
		if(element instanceof Port) {
			return (Port)element;
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
}
