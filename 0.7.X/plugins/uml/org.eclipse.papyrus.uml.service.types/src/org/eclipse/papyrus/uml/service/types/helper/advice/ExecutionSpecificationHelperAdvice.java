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
 * 
 * 		Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper.advice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.core.utils.PapyrusEcoreUtils;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.OccurrenceSpecification;

/**
 * Helper advice for all {@link ExecutionSpecification} elements.
 */
public class ExecutionSpecificationHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * <pre>
	 * Add a command to associated {@link OccurrenceSpecification} and {@link Message}.
	 * This command is only added if the start - finish referenced {@link OccurrenceSpecification} is not 
	 * referenced by another element.
	 * </pre>
	 * 
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getBeforeDestroyDependentsCommand(org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest)
	 * 
	 * @param request
	 *        the request
	 * @return the command to execute before the edit helper work is done
	 */
	protected ICommand getBeforeDestroyDependentsCommand(DestroyDependentsRequest request) {

		List<EObject> dependentsToDestroy = new ArrayList<EObject>();

		ExecutionSpecification es = (ExecutionSpecification)request.getElementToDestroy();

		Collection<Setting> usages = PapyrusEcoreUtils.getUsages(es);

		// add visually linked messages
		for(Setting usage : usages) {
			if(usage.getEObject() instanceof View) {
				dependentsToDestroy.addAll(getLinkedMessagesFromView((View)usage.getEObject()));
			}
		}

		// Add start - finish referenced OccurrenceSpecification to the dependents list
		// if they are not used by another element.
		OccurrenceSpecification osStart = es.getStart();
		if((osStart != null) && (PapyrusEcoreUtils.isOnlyUsage(osStart, es))) {
			dependentsToDestroy.add(osStart);
		}

		OccurrenceSpecification osFinish = es.getFinish();
		if((osFinish != null) && (PapyrusEcoreUtils.isOnlyUsage(osFinish, es))) {
			dependentsToDestroy.add(osFinish);
		}

		// return command to destroy dependents
		if(!dependentsToDestroy.isEmpty()) {
			return request.getDestroyDependentsCommand(dependentsToDestroy);
		}

		return null;
	}

	/**
	 * Messages are not linked to the ES in the UML model, but they are visually.
	 * Use this "visual" information from the notation model to complete the destroy with all linked messages.
	 * 
	 * @param view
	 *        the view
	 * @return the linked messages
	 */
	@SuppressWarnings("unchecked")
	public static Set<Message> getLinkedMessagesFromView(View view) {
		Set<Message> linkedMessages = new HashSet<Message>();

		HashSet<Edge> edges = new HashSet<Edge>();
		edges.addAll(view.getSourceEdges());
		edges.addAll(view.getTargetEdges());

		for(Edge edge : edges) {
			EObject elem = edge.getElement();
			if(elem instanceof Message) {
				linkedMessages.add((Message)elem);
			}
		}

		return linkedMessages;
	}
}
