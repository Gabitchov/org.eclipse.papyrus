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
 *   Arthur Daussy - arthur.daussy@atos.net - Bug 369633 - [Activitydiagram] When deleting a pin delete incoming/outgoing edges
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.commands.DestroyElementPapyrusCommand;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.Pin;

/**
 * PinEditHelper. used for:
 * 	-> Delete command should delete incoming and outgoing activity edge from the model
 * @author arthur daussy
 *
 */
public class PinEditHelper extends ElementEditHelper{

	@Override
	protected ICommand getDestroyElementCommand(DestroyElementRequest req) {		
		ICommand cmd = getBasicDestroyElementCommand(req);
		CompositeTransactionalCommand cc = new CompositeTransactionalCommand(req.getEditingDomain(), "Destroy Pin Command");////$NON-NLS-1$
		if ( cmd != null && cmd.canExecute()){
			cc.compose(cmd);
		}
		cc.compose(cmd);
		EObject pin_ = req.getElementToDestroy();
		if (pin_ instanceof Pin){
			Set<ActivityEdge> edgesToDestroy = new HashSet<ActivityEdge>();
			Pin pin = (Pin)pin_;
			//Destroy incoming edge
			for (ActivityEdge activityEdge :  pin.getIncomings()){
				if ( activityEdge != null){
					edgesToDestroy.add(activityEdge);
				}
			}
			//Destroy outgoing edge
			for (ActivityEdge activityEdge :  pin.getOutgoings()){
				if ( activityEdge != null){
					edgesToDestroy.add(activityEdge);
				}
			}
			for ( ActivityEdge edgeToDstroy : edgesToDestroy){
				DestroyElementPapyrusCommand destroyCommand = new DestroyElementPapyrusCommand(new DestroyElementRequest(req.getEditingDomain(), edgeToDstroy, false));
				if ( destroyCommand != null && destroyCommand.canExecute()){
					cc.compose(destroyCommand);
				}
			}
		}
		return cc;
	}
	
	
}
