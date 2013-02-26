/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib saadia.dhouib@cea.fr  - adapted from composite structure diagram (DestroyGeneralizationAdvice class)
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.communication.custom.advices;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.DecorationNodeImpl;
import org.eclipse.papyrus.uml.diagram.communication.custom.helper.InconsistentMessageViewsHelper;
import org.eclipse.papyrus.uml.diagram.communication.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.Message;

/**
 * The Class DestroyMessageAdvice.
 */
public class MessageHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getBeforeEditCommand(org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest)
	 * 
	 * @param request
	 * @return ICommand
	 */
	@Override
	public ICommand getBeforeEditCommand(IEditCommandRequest request) {
		if(request instanceof DestroyDependentsRequest) {
			return getBeforeDestroyDependentsCommand((DestroyDependentsRequest)request);
		} else if(request instanceof ReorientRelationshipRequest) {
			return getBeforeReorientRelationshipCommand((ReorientRelationshipRequest)request);
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getBeforeDestroyDependentsCommand(org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected ICommand getBeforeDestroyDependentsCommand(DestroyDependentsRequest request) {
		EObject destructee = request.getElementToDestroy();

		Set<View> viewsToDestroy = new HashSet<View>();
		if(destructee instanceof Message) {
			viewsToDestroy = InconsistentMessageViewsHelper.getMemberViewsToDestroy((Message)destructee, request);
		}
		//return the command to destroy all these views
		if(!viewsToDestroy.isEmpty()) {
			// ---------------------------------------------------------
			// help to debug
			//System.err.println("+-> viewsToDestroy  :" + viewsToDestroy);
			// ---------------------------------------------------------
			return request.getDestroyDependentsCommand(viewsToDestroy);
		}
		return null;
	}





	@Override
	protected ICommand getBeforeReorientRelationshipCommand(ReorientRelationshipRequest request) {

		// The list of member views becoming inconsistent after re-orient. They will be deleted.
		Set<View> viewsToDestroy = new HashSet<View>();
		Set<View> viewsToDestroyCopy = new HashSet<View>();
		Object graphicalRconnectedEdge = request.getParameter(UMLBaseItemSemanticEditPolicy.GRAPHICAL_RECONNECTED_EDGE);
		if(graphicalRconnectedEdge instanceof Connector) {

			@SuppressWarnings("rawtypes")
			List children = ((Connector)graphicalRconnectedEdge).getChildren();
			for(int j = 0; j < children.size(); j++) {
				//get the child of the connector,
				if(children.get(j) instanceof DecorationNodeImpl) {
					DecorationNodeImpl label = (DecorationNodeImpl)children.get(j);
					if(label.getElement() instanceof Message) {// if the child of the graphicalRconnectedEdge corresponds to a message on the connector

						Message destructee = (Message)label.getElement();
						//1. search for all the views of the message
						Set<View> viewsOfDestructee = new HashSet<View>();
						viewsOfDestructee = InconsistentMessageViewsHelper.getMemberViewsToDestroy(destructee, request);
						viewsToDestroy.addAll(viewsOfDestructee);
						viewsOfDestructee = null;
						//2. Retrieve from the list the views of the message which are in the diagram where the reorientation is taken place 

						//viewsToDestroyCopy is a copy of the viewsToDestroy List
						viewsToDestroyCopy.clear();
						viewsToDestroyCopy.addAll(viewsToDestroy);
						Iterator<?> it = viewsToDestroy.iterator();

						while(it.hasNext()) {
							View current = (View)it.next();

							if((current.getElement() instanceof Message) && current.getElement().equals(label.getElement())) {//if the two views have the same semantic element
								if(current.eContainer().eContainer().equals(label.eContainer().eContainer())) {//if the views are in the same diagram
									viewsToDestroyCopy.remove(current);
									//remove the parent (connector if it is in the list)
									if(viewsToDestroyCopy.contains(current.eContainer())) {
										viewsToDestroyCopy.remove(current.eContainer());
									}
									//break;
								}
							}
						}
						viewsToDestroy.clear();
						viewsToDestroy.addAll(viewsToDestroyCopy);

					}
				}
			}
		}

		//3.return the command to destroy all these views
		if(!viewsToDestroy.isEmpty()) {

			DestroyDependentsRequest ddr = new DestroyDependentsRequest(request.getEditingDomain(), request.getRelationship(), false);
			ddr.setClientContext(request.getClientContext());
			ddr.addParameters(request.getParameters());
			//search for additional views to destroy (essentially inconsistent connectors that have to be deleted)
			//and return the command to destroy all the inconsistent views
			return ddr.getDestroyDependentsCommand(InconsistentMessageViewsHelper.addConnectorViewsToDestroy(viewsToDestroy));

		}
		return null;
	}





}
