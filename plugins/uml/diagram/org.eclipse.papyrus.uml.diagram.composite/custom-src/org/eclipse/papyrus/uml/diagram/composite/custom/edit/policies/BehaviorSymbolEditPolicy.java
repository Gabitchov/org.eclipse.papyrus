/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		Patrick Tessier (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.edit.policies;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.InternalTransaction;
import org.eclipse.emf.transaction.impl.InternalTransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.BehaviorPortLinkEditPart;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;
/**
 * This editpolicy listen the notation node of the PortEditpart, when it is removed the notation representation of the symbol is removed.
 *
 */

public class BehaviorSymbolEditPolicy extends GraphicalEditPolicy implements NotificationListener, IPapyrusListener {
	public static String BEHAVIOR_SYMBOL="BehaviorSymbolEditPolicy";

	public void notifyChanged(Notification notification) {
		View behaviorSymbol=getView();
		final TransactionalEditingDomain domain=	TransactionUtil.getEditingDomain(behaviorSymbol);
		if(getUMLElement()==null){
			executeBehaviorSymbolDeletion(domain, behaviorSymbol);
		}
		final int eventType = notification.getEventType();

		if(eventType==Notification.REMOVE||(eventType==Notification.SET && notification.getFeature().equals(NotationPackage.eINSTANCE.getView_Visible()))){

			if(getView()!=null){

				if(getPortNode()==null)
					executeBehaviorSymbolDeletion(domain, behaviorSymbol);

			}
		}
	}

	/**
	 * return the Port that represents the port
	 * @return may be null if nothing is founded
	 */
	protected Node getPortNode(){
		View SemanticView=(View) getHost().getModel();

		Edge behaviorPortLink= null;
		@SuppressWarnings("unchecked")
		Iterator<Edge>edgeIterator=SemanticView.getTargetEdges().iterator();
		while(edgeIterator.hasNext()) {
			Edge edge = (Edge)edgeIterator.next();
			if (edge.getType().equals(""+BehaviorPortLinkEditPart.VISUAL_ID)){
				behaviorPortLink=edge;
			}

		}
		if(behaviorPortLink== null){
			return null;
		}
		return (Node)behaviorPortLink.getSource();

	}
	/**
	 * Returns the uml element controlled by the host edit part
	 * 
	 * @return the uml element controlled by the host edit part
	 */
	protected Element getUMLElement() {
		if( (Element)getView().getElement()!=null){
			return  (Element)getView().getElement();
		}
		return null;
	}
	@Override
	public void activate() {
		// retrieve the view and the element managed by the edit part
		View view = getView();
		if(view == null) {
			return;
		}
		if(getPortNode()!=null){
			getDiagramEventBroker().addNotificationListener(getPortNode(), this);
		}
		// adds a listener on the view and the element controlled by the
		// editpart
		getDiagramEventBroker().addNotificationListener(view, this);
		
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
		if(getPortNode()!=null){
			getDiagramEventBroker().removeNotificationListener(getPortNode(), this);
		}
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
	 * Returns the view controlled by the host edit part
	 * 
	 * @return the view controlled by the host edit part
	 */
	protected View getView() {
		return (View)getHost().getModel();
	}
	protected void executeBehaviorSymbolDeletion( final TransactionalEditingDomain domain, final View commentNode) {
		try {
			if( domain!=null){
				domain.runExclusive(new Runnable() {

					public void run() {
						Display.getCurrent().syncExec(new Runnable() {

							public void run() {
								//because it is asynchrone the comment node maybe become s null
								if( commentNode!= null&& TransactionUtil.getEditingDomain(commentNode)!=null){
									DeleteCommand command= new DeleteCommand(commentNode);
									Map<String,Boolean> options = new HashMap<String,Boolean>();  
									options.put(Transaction.OPTION_UNPROTECTED, Boolean.TRUE);
									try{
										InternalTransaction it=((InternalTransactionalEditingDomain)  TransactionUtil.getEditingDomain(commentNode)).startTransaction(false, options);
										GMFtoEMFCommandWrapper warpperCmd= new GMFtoEMFCommandWrapper (command);
										warpperCmd.execute();
										it.commit();
									}catch(Exception e){
										System.err.println(e);
									}
								}
							}
						});
					}
				});
			}
		} catch (Exception e) {
			Activator.log.error(e);
		}
	}
}
