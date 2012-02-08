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
 *   Arthur Daussy - arthur.daussy@atos.net - 365889: [Activity diagram] The deletion of a StructuredActivityNode not delete edges incoming or outgoing the region.
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.diagram.common.commands.DestroyElementPapyrusCommand;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.StructuredActivityNode;

/**
 * StructuredActivityNodeEditHelper used for:
 * 	-> Delete incoming and outcoming edge when deleted
 * @author adaussy
 *
 */
public class StructuredActivityNodeEditHelper extends ElementEditHelper {

	@Override
	protected ICommand getDestroyElementCommand(DestroyElementRequest req) {
		DestroyElementCommand cmd = req.getBasicDestroyCommand();
		CompositeTransactionalCommand cc = new CompositeTransactionalCommand(req.getEditingDomain(), "Destroy ActivityNodeParameter Command");////$NON-NLS-1$
		if ( cmd != null && cmd.canExecute()){
			cc.compose(cmd);
		}
		cc.compose(cmd);
		EObject strucutredActivityNode_ = req.getElementToDestroy();
		if (strucutredActivityNode_ instanceof StructuredActivityNode){
			Set<ActivityEdge> edgesToDestroy = new HashSet<ActivityEdge>();
			StructuredActivityNode activityStructuredNode = (StructuredActivityNode)strucutredActivityNode_;
			//Destroy incoming edge
			for (ActivityEdge activityEdge :  activityStructuredNode.getIncomings()){
				if ( activityEdge != null){
					edgesToDestroy.add(activityEdge);
				}
			}
			//Destroy outgoing edge
			for (ActivityEdge activityEdge :  activityStructuredNode.getOutgoings()){
				if ( activityEdge != null){
					edgesToDestroy.add(activityEdge);
				}
			}
			for ( ActivityEdge edgeToDstroy : edgesToDestroy){
				DestroyElementCommand destroyCommand = new DestroyElementPapyrusCommand(new DestroyElementRequest(req.getEditingDomain(), edgeToDstroy, false));
				if ( destroyCommand != null && destroyCommand.canExecute()){
					cc.compose(destroyCommand);
				}
			}
		}
		return cc;
	}

	

}
