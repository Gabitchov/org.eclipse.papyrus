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
package org.eclipse.papyrus.diagram.communication.custom.advices;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.core.util.CrossReferenceAdapter;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.communication.edit.parts.ModelEditPart;
import org.eclipse.uml2.uml.Message;


/**
 * The Class DestroyMessageAdvice.
 */
public class DestroyMessageAdvice extends AbstractEditHelperAdvice {

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

		Set<EObject> set = null;
		if(destructee instanceof Message) {
			//get all view for the destructee
			CrossReferenceAdapter crossReferenceAdapter = getCrossReferenceAdapter(request, destructee);
			if(crossReferenceAdapter != null) {
				Collection<Setting> revRefs = crossReferenceAdapter.getNonNavigableInverseReferences(destructee);
				if(!revRefs.isEmpty()) {
					for(Setting current : revRefs) {
						//test if the view is linked with the removed message
						if(current.getEObject() instanceof View) {
							View view = (View)current.getEObject();
							//we remove the view only if they are owned by the CompositeStructureDiagram
							if(isOwnedByCommunicationDiagram(view)) {
								if(set == null) {
									set = new HashSet<EObject>();
								}
								set.add(view);
								if(isLastMessageOnConnection(view)) {
									//remove the connector
									set.add((View)view.eContainer());
								}


							}
						}
					}

				}
			}
		}
		//return the command to destroy all these views
		if(set != null) {
			return request.getDestroyDependentsCommand(set);
		}
		return null;
	}

	/**
	 * Returns the {@link CrossReferenceAdapter} corresponding to the element to destroy
	 * 
	 * @param request
	 *        the request
	 * @param destructee
	 *        the destroyed element
	 * @return
	 *         the {@link CrossReferenceAdapter} corresponding to this element
	 */
	protected CrossReferenceAdapter getCrossReferenceAdapter(DestroyDependentsRequest request, EObject destructee) {

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
	 * Tests if the view is owned by the CommunicationDiagram
	 * 
	 * @param view
	 *        a view
	 * @return
	 *         <code>true</code> if the view is owned by the CompositeStructureDiagram, <code>false</code> if not
	 */
	protected boolean isOwnedByCommunicationDiagram(View view) {
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
	 * @return
	 *         <code>true</code> if the view is is the last label (ie. message) on the connection, <code>false</code> if not
	 */

	protected boolean isLastMessageOnConnection(View view) {
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
			//Local variable messageChildren to count the number of labels ( representing a message) on the connection
			Integer messageChildren = 0;
			done: for(View child : children) {
				if((child instanceof DecorationNode) && (child.getElement() instanceof Message)) {
					messageChildren++;
					if(messageChildren > 1) {
						//System.err.println("+-> not the last message on the connection");
						break done;
					}
				}
			}
			//if this is the last message on the connection, return true.
			return messageChildren == 1;
		}

		return false;
	}
}
