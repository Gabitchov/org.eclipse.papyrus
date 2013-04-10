/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.InternalTransaction;
import org.eclipse.emf.transaction.impl.InternalTransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.EObjectValueStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.listenerservice.IPapyrusListener;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;

/**
 * this editpolicy attached to StereotypeCommentEdipart has in charge to prevent the remove form model
 *  and launch command of deletion if it detect that any properties of applied stereotype are displayed
 *
 */
public class CommentShapeForAppliedStereotypeEditPolicy extends GraphicalEditPolicy implements NotificationListener, IPapyrusListener {

	public void notifyChanged(Notification notification) {
		View commentNode=getView();
		final TransactionalEditingDomain domain=	TransactionUtil.getEditingDomain(commentNode);
		if(getUMLElement()==null){
			executeAppliedStereotypeCommentDeletion(domain, commentNode);
		}
		final int eventType = notification.getEventType();
		if(eventType==Notification.SET && notification.getFeature().equals(NotationPackage.eINSTANCE.getView_Visible())){

			if(getView()!=null){
				
				if (getvisibleAppliedStereotypeCompartment(commentNode, getUMLElement())==0){
					
					executeAppliedStereotypeCommentDeletion(domain, commentNode);

				}
			}
		}
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
		if(getView().getNamedStyle(NotationPackage.eINSTANCE.getEObjectValueStyle(), "BASE_ELEMENT")!=null){
			EObjectValueStyle eObjectValueStyle=(EObjectValueStyle)getView().getNamedStyle(NotationPackage.eINSTANCE.getEObjectValueStyle(), "BASE_ELEMENT");
				return (Element)eObjectValueStyle.getEObjectValue();
		}
		return null;
	}
	@Override
	public Command getCommand(Request request) {
		if(request instanceof EditCommandRequestWrapper){
			if(((EditCommandRequestWrapper)(request)).getEditCommandRequest() instanceof DestroyElementRequest){
				return UnexecutableCommand.INSTANCE;
			}
		}
		return super.getCommand(request);
	}


	protected void executeAppliedStereotypeCommentDeletion( final TransactionalEditingDomain domain, final View commentNode) {
		try {
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
		} catch (Exception e) {
			Activator.log.error(e);
		}
	}
	protected int getvisibleAppliedStereotypeCompartment(View view, EObject eobject){
		int nbVisibleCompartment=0;
		Iterator<View> iteratorView= view.getChildren().iterator();
		while(iteratorView.hasNext()) {
			View subview = (View)iteratorView.next();
			if(  subview.isVisible()==true){
				nbVisibleCompartment++;
			}
		}
		return nbVisibleCompartment;
	}


	@Override
	public void activate() {
		// retrieve the view and the element managed by the edit part
		View view = getView();
		if(view == null) {
			return;
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
}
