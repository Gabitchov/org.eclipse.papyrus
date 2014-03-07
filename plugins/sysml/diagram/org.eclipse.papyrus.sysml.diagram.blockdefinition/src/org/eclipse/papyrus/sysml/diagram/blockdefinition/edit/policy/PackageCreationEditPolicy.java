/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GroupEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.DefaultCreationEditPolicy;

/**
 * this editpolicy allow graphical and semantic reparent for contained elements  
 *
 */

public class PackageCreationEditPolicy extends DefaultCreationEditPolicy {
	
	/**
	 * return a command to reparent both the semantic and view elements. 
	 * @param request the request
	 * @return command
	 */
	protected Command getReparentCommand(ChangeBoundsRequest request) {
		Iterator<EditPart> editParts = request.getEditParts().iterator();
		View container = (View)getHost().getAdapter(View.class);
		EObject context = container == null ? null : ViewUtil.resolveSemanticElement(container);
        CompositeCommand cc = new CompositeCommand(DiagramUIMessages.AddCommand_Label);
		while ( editParts.hasNext() ) {
			EditPart ep = (EditPart)editParts.next();
			if ( ep instanceof LabelEditPart ) {
				continue;
			}
			if (ep instanceof GroupEditPart) {
                cc.compose(getReparentGroupCommand((GroupEditPart) ep));
            }		
			View view = (View)ep.getAdapter(View.class);
			if ( view == null ) {
				continue;
			}
			
			EObject semantic = ViewUtil.resolveSemanticElement(view);
			if ( semantic == null ) {
				cc.compose(getReparentViewCommand((IGraphicalEditPart)ep));
			}
			else if ( context != null && shouldReparent(semantic, context)) {
				cc.compose(getReparentCommand((IGraphicalEditPart)ep));
			}
		}
		return cc.isEmpty() ? null : new ICommandProxy(cc.reduce());
	}
	
	
	/**
	 *change the order of the move, first graphical, then semantic to launch behavior about editservice
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getReparentCommand( IGraphicalEditPart gep ) {
        CompositeCommand cc = new CompositeCommand(DiagramUIMessages.AddCommand_Label); 
		View container = (View)getHost().getModel();
		EObject context = ViewUtil.resolveSemanticElement(container);
		View view = (View)gep.getModel();
		EObject element = ViewUtil.resolveSemanticElement(view);

        TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
            .getEditingDomain();
    	//
		// notation
		cc.compose(getReparentViewCommand(gep));
        //
		// semantic
		if ( element != null ) {
			Command moveSemanticCmd =
				getHost().getCommand(
					new EditCommandRequestWrapper(
						new MoveRequest(editingDomain, context, element)));
            
              if (moveSemanticCmd == null) {
                  return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
              }
			
			cc.compose ( new CommandProxy(moveSemanticCmd) );
		}
	
		return cc;
	}
}
