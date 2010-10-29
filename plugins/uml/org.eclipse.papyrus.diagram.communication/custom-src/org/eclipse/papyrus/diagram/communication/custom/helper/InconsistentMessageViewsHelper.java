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
 *  Saadia Dhouib saadia.dhouib@cea.fr  - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.communication.custom.helper;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.emf.core.util.CrossReferenceAdapter;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.communication.edit.parts.ModelEditPart;
import org.eclipse.uml2.uml.Message;



/**
 * The Class InconsistentMessageViewsHelper is intended to give methods to help searching for inconsistent views of messages xhen they are deleted or
 * re-oriented.
 */
public class InconsistentMessageViewsHelper {

	/**
	 * Tests if the view is owned by the CommunicationDiagram.
	 * 
	 * @param view
	 *        a view
	 * @return true, if is owned by communication diagram <code>true</code> if the view is owned by the CompositeStructureDiagram, <code>false</code>
	 *         if not
	 */
	public static boolean isOwnedByCommunicationDiagram(View view) {
		EObject diagram = view.eContainer();
		while(!(diagram instanceof Diagram)) {
			diagram = diagram.eContainer();
		}
		String type = ((Diagram)diagram).getType();
		return type == ModelEditPart.MODEL_ID;
	}


	/**
	 * Tests if the view is is the last label (ie. message) on the connection
	 * 
	 * @param view
	 *        a view
	 * @return true, if is last message on connection <code>true</code> if the view is is the last label (ie. message) on the connection,
	 *         <code>false</code> if not
	 */

	public static boolean isLastMessageOnConnection(View view) {
		//Verify if this view is the last label (ie. message) on the connection
		//if true remove the parent view (ie. the connector view)
		if(view instanceof DecorationNode) {
			View parentView = (View)view.eContainer();
			// ---------------------------------------------------------
			// help to debug
			//System.err.println("+-> parent View  :" + parentView);
			// ---------------------------------------------------------

			//get children of the parent view
			@SuppressWarnings("unchecked")
			EList<View> children = parentView.getChildren();

			for(View child : children) {
				if((child instanceof DecorationNode) && (child.getElement() instanceof Message)) {

					if(!child.getElement().equals(view.getElement())) {//ouups, there is another child which is different from this view!!!
						return false;
					}
				}
			}
			//This is the last message on the connection, return true.
			return true;
		}

		return false;
	}

	/**
	 * Returns the {@link CrossReferenceAdapter} corresponding to the element to destroy.
	 * 
	 * @param request
	 *        the request
	 * @param destructee
	 *        the destroyed element
	 * @return the cross reference adapter
	 *         the {@link CrossReferenceAdapter} corresponding to this element
	 */
	public static CrossReferenceAdapter getCrossReferenceAdapter(IEditCommandRequest request, EObject destructee) {

		CrossReferenceAdapter crossReferenceAdapter = null;
		@SuppressWarnings("rawtypes")
		Map cacheMaps = (Map)request.getParameter("Cache_Maps");//$NON-NLS-1$ RequestCacheEntries.Cache_Maps
		if(cacheMaps != null) {
			crossReferenceAdapter = (CrossReferenceAdapter)cacheMaps.get("CrossRefAdapter");//$NON-NLS-1$ RequestCacheEntries.CrossRefAdapter
		}

		if(crossReferenceAdapter == null) {
			crossReferenceAdapter = CrossReferenceAdapter.getExistingCrossReferenceAdapter(destructee);
			if(crossReferenceAdapter == null) {
				TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(destructee);
				if(domain != null) {
					crossReferenceAdapter = CrossReferenceAdapter.getCrossReferenceAdapter(domain.getResourceSet());
				}
			}
		}
		return crossReferenceAdapter;
	}

	/**
	 * This method looks for inconsistent views of connectors to delete in case the connector is
	 * re-oriented.
	 * 
	 * 
	 * @param viewsToDestroy
	 *        the set of views of messages to destroy
	 * 
	 * @return the list of {@link View} of the connectors to delete
	 */
	public static Set<View> addConnectorViewsToDestroy(Set<View> viewsToDestroy) {
		//for all the views to destroy, we have to classify them by their own connector, 
		//then we have to verify for each connector that the set of messages (to destroy) on it are the only messages that he contains
		//if yes, we have to add the view of the connector to list of views to destroy

		//the set connectors that are concerned by the deleted to the messages views
		Set<View> connectors = null;
		Set<View> newViewsToDestroy = new HashSet<View>(viewsToDestroy);
		//for all the messages to delete, search for their parent connector
		Iterator<?> it = viewsToDestroy.iterator();
		while(it.hasNext()) {
			View msgView = (View)it.next();
			if((msgView instanceof DecorationNode) && (msgView.getElement() instanceof Message)) {
				if(msgView.eContainer() instanceof Connector) {
					if(connectors == null) {
						connectors = new HashSet<View>();
					}
					connectors.add((View)msgView.eContainer());
				}
			}
		}
		//Now the connectors set contains all the connectors that may have to be deleted
		//we have to check which connector have to be deleted
		if(connectors != null) {
			//for each connector we have to search for the set of its labels views to be destroyed

			Iterator<?> it1 = connectors.iterator();
			while(it1.hasNext()) {
				View conView = (View)it1.next();

				//Construct the list of viewsOfLabelsToDestroy
				Set<View> viewsOfLabelsToDestroy = null;
				Iterator<?> it2 = viewsToDestroy.iterator();
				while(it2.hasNext()) {
					View msgView = (View)it2.next();
					if((msgView instanceof DecorationNode) && (msgView.getElement() instanceof Message)) {
						if((msgView.eContainer() instanceof Connector) && (msgView.eContainer().equals(conView))) {
							if(viewsOfLabelsToDestroy == null) {
								viewsOfLabelsToDestroy = new HashSet<View>();
							}
							viewsOfLabelsToDestroy.add((View)msgView);
						}
					}
				}
				//if the set of viewsOfLabelsToDestroy contains all the real children of the connector 
				//then add the connector to the views to destroy
				@SuppressWarnings("unchecked")
				EList<View> conChildren = conView.getChildren();
				Set<View> comparisonResult = new HashSet<View>(conChildren.size());
				for(Iterator<?> i = conChildren.iterator(); i.hasNext();) {
					View element = (View)i.next();
					if((element instanceof DecorationNode) && (element.getElement() instanceof Message)) {
						if(!viewsOfLabelsToDestroy.contains(element))
							comparisonResult.add(element);
					}
				}

				if(comparisonResult.isEmpty()) {//the set of viewsOfLabelsToDestroy contains all the real children of the connector
					newViewsToDestroy.add(conView);
				}
			}

		}
		return newViewsToDestroy;

	}

	/**
	 * This method looks for inconsistent views to delete in case the message is deleted or
	 * the connector of the message is re-oriented.
	 * 
	 * @param destructee
	 *        the modified message
	 * @param request
	 *        the request to destroy a message or to re-orient a message
	 * 
	 * @return the list of {@link View} to delete
	 */
	public static Set<View> getMemberViewsToDestroy(Message destructee, IEditCommandRequest request) {
		Set<View> viewsToDestroy = new HashSet<View>();
		CrossReferenceAdapter crossReferenceAdapter = InconsistentMessageViewsHelper.getCrossReferenceAdapter(request, destructee);
		if(crossReferenceAdapter != null) {

			Collection<Setting> revRefs = crossReferenceAdapter.getNonNavigableInverseReferences(destructee);
			if(!revRefs.isEmpty()) {
				for(Setting current : revRefs) {
					//test if the view is linked with the removed message
					if(current.getEObject() instanceof View) {
						View view = (View)current.getEObject();
						//we remove the view only if they are owned by the CompositeStructureDiagram
						if(InconsistentMessageViewsHelper.isOwnedByCommunicationDiagram(view)) {

							viewsToDestroy.add(view);
							if(InconsistentMessageViewsHelper.isLastMessageOnConnection(view)) {
								//remove the connector
								//System.err.println("+-> the connector will be deleted : " + (View)view.eContainer());
								//System.err.println("+-> the parent of the connector is : " + (View)view.eContainer().eContainer());
								viewsToDestroy.add((View)view.eContainer());
							}


						}
					}
				}

			}
		}


		return viewsToDestroy;
	}

}
