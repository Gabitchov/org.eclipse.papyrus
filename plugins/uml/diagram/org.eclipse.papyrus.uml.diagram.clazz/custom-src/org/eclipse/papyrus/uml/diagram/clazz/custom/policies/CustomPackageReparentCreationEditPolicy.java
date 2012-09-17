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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.policies;

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
import org.eclipse.papyrus.uml.diagram.clazz.custom.edit.part.CModelEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ModelEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PackageEditPart;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.PapyrusCreationEditPolicy;
import org.eclipse.uml2.uml.Element;

public class CustomPackageReparentCreationEditPolicy extends PapyrusCreationEditPolicy {

	/**
	 * return a command to reparent both the semantic and view elements.
	 * 
	 * @param request
	 *        the request
	 * @return command
	 */
	protected Command getReparentCommand(ChangeBoundsRequest request) {
		Iterator editParts = request.getEditParts().iterator();
		View container = (View)getHost().getAdapter(View.class);
		EObject context = container == null ? null : ViewUtil.resolveSemanticElement(container);
		CompositeCommand cc = new CompositeCommand(DiagramUIMessages.AddCommand_Label);
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		int index = 0;

		while(editParts.hasNext()) {
			EditPart ep = (EditPart)editParts.next();
			View view = (View)ep.getAdapter(View.class);
			EObject semantic = ViewUtil.resolveSemanticElement(view);


			if(ep instanceof LabelEditPart) {
				continue;
			}
			if(ep instanceof GroupEditPart) {
				cc.compose(getReparentGroupCommand((GroupEditPart)ep));
			}
			if(ep instanceof PackageEditPart || ep instanceof CModelEditPart || ep instanceof PackageEditPartCN || ep instanceof ModelEditPartCN) {
				if(context != null) {
					cc.compose(getReparentCommand((IGraphicalEditPart)ep));

				}
			} else {
				//if ( context != null && shouldReparent(semantic, context)){
				ChangeBoundsRequest req = new ChangeBoundsRequest();
				req.setEditParts(ep);
				return super.getReparentCommand((ChangeBoundsRequest)req);
				// }
			}

		}
		return cc.isEmpty() ? null : new ICommandProxy(cc.reduce());
	}



	protected ICommand getReparentCommand(IGraphicalEditPart gep) {

		//1.******************************************** Variables initialization

		CompositeCommand cc = new CompositeCommand(DiagramUIMessages.AddCommand_Label);
		View container = (View)getHost().getModel();
		EObject context = ViewUtil.resolveSemanticElement(container);
		View view = (View)gep.getModel();
		EObject element = ViewUtil.resolveSemanticElement(view);
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		EditPart modelRootEditPart = null;
		EditPart rootEditPart = gep.getRoot();
		Iterator<EditPart> rootEditPartIterator = rootEditPart.getChildren().iterator();
		while(rootEditPartIterator.hasNext()) {
			EditPart editPart = (EditPart)rootEditPartIterator.next();
			if(editPart instanceof ModelEditPart) {
				modelRootEditPart = editPart;
			}

		}

		org.eclipse.uml2.uml.Package modelElementRoot = (org.eclipse.uml2.uml.Package)((View)modelRootEditPart.getModel()).getElement();


		//2.********************************** Move the semantic element with his graphical view

		// Copied Code :semantic
		if(element != null) {
			Command moveSemanticCmd = getHost().getCommand(new EditCommandRequestWrapper(new MoveRequest(editingDomain, context, element)));

			// Added code
			// if the element is a Package and if it is contained by an other package which is not a Model, we return an UnexecutableCommand to execute a specific Drop command
			if(element instanceof org.eclipse.uml2.uml.Package && ((Element)element).getOwner() instanceof org.eclipse.uml2.uml.Package && !(((Element)element).getOwner().equals(modelElementRoot))) {

				return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
			}

			// Copied Code :semantic
			if(moveSemanticCmd == null) {
				return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
			}
			cc.compose(new CommandProxy(moveSemanticCmd));
		}

		// Copied Code :notation
		cc.compose(getReparentViewCommand(gep));
		return cc;
	}


}
