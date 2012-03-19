/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos - Initial API and implementation
 *   Bug 366159 - [ActivityDiagram] Activity Diagram should be able to handle correctly Interruptible Edge
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.edit.helper.advice;

import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.diagram.common.commands.DestroyElementPapyrusCommand;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;

import com.google.common.collect.Sets;

/**
 * Delete all incoming and outgoing edges of an activity node when this node is deleted
 * @author adaussy
 *
 */
public class ActivityNodeEditHelperAdvice extends AbstractEditHelperAdvice {



	@Override
	protected ICommand getBeforeDestroyDependentsCommand(DestroyDependentsRequest request) {
		EObject eObject = request.getElementToDestroy();
		if (eObject instanceof ActivityNode){
			ActivityNode activityNode = (ActivityNode)eObject;
			HashSet<ActivityEdge> edges = Sets.newHashSet(activityNode.getIncomings());
			edges.addAll(activityNode.getOutgoings());
			if (!edges.isEmpty()){
				CompositeCommand cc = new CompositeCommand("Detele Incomings and outgoings edges from activity node");////$NON-NLS-1$
				for (ActivityEdge e : edges){
					DestroyElementRequest destroyRequest =  new DestroyElementRequest(e, false);
					DestroyElementPapyrusCommand destroyCommand = new DestroyElementPapyrusCommand(destroyRequest);
					if ( destroyCommand!= null && destroyCommand.canExecute()){
						cc.compose(destroyCommand);
					}
					
				}
				return cc;
			}
		}
		return super.getAfterDestroyDependentsCommand(request);
	}
	
}
