/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.gmf.diagram.common.edit.policy;

import java.util.Iterator;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;

/**
 * Avoid forcing (-1, -1) dimension in set bounds command (let the view factories deal with 
 * size initialization if needed).
 */
public class DefaultXYLayoutEditPolicy extends XYLayoutEditPolicy {

	/**
	 * Called in response to a <tt>REQ_CREATE</tt> request. Returns a command
	 * to set each created element bounds and auto-size properties.
	 * 
	 * @param request a create request (understands instances of {@link CreateViewRequest}).
	 * @return a command to satisfy the request; <tt>null</tt> if the request is not
	 * understood.
	 */
	protected Command getCreateCommand(CreateRequest request) {
		CreateViewRequest req = (CreateViewRequest) request;
        

        TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
            .getEditingDomain();

		CompositeTransactionalCommand cc = new CompositeTransactionalCommand(
            editingDomain, DiagramUIMessages.AddCommand_Label);
        Iterator<?> iter = req.getViewDescriptors().iterator();

		final Rectangle BOUNDS = (Rectangle) getConstraintFor(request);



		while (iter.hasNext()) {
			CreateViewRequest.ViewDescriptor viewDescriptor = (CreateViewRequest.ViewDescriptor)iter.next(); 
			Rectangle rect = getBoundsOffest(req, BOUNDS,viewDescriptor);
			
			if (rect.getSize().isEmpty()) {
				// Only set location and let the ViewFactory deal with dimension.
				cc.compose(new SetBoundsCommand(editingDomain, 
					DiagramUIMessages.SetLocationCommand_Label_Resize,
					viewDescriptor,
					rect.getLocation().getCopy()));
			
			} else {
				// Default set bounds command.
				cc.compose(new SetBoundsCommand(editingDomain, 
					DiagramUIMessages.SetLocationCommand_Label_Resize,
					viewDescriptor,
					rect));
				
			}
			
		}
		
		if( cc.reduce() == null )
			return null;

		return chainGuideAttachmentCommands( request,
			new ICommandProxy(cc.reduce()));
	}
}
