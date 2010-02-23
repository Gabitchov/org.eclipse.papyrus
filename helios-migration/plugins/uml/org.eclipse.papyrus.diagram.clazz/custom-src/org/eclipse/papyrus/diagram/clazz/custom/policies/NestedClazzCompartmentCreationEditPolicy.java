/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
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
package org.eclipse.papyrus.diagram.clazz.custom.policies;

import java.util.ArrayList;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;



/**
 * The Class ClazzCompartmentCreationEditPolicy overload the creation editpolicy in order to manage correctly the drop of a class into a class
 */
public class NestedClazzCompartmentCreationEditPolicy extends CreationEditPolicy {


	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy#getReparentCommand(org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart)
	 * 
	 * @param gep
	 * @return
	 */

	protected ICommand getReparentCommand(IGraphicalEditPart gep) {
		CompositeCommand cc = new CompositeCommand(DiagramUIMessages.AddCommand_Label);
		View container = (View)getHost().getModel();
		EObject context = ViewUtil.resolveSemanticElement(container);
		View view = (View)gep.getModel();
		EObject element = ViewUtil.resolveSemanticElement(view);

		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();

		// graphical Deletion
		Request deleteViewRequest = new GroupRequest(RequestConstants.REQ_DELETE);
		cc.compose(new CommandProxy(gep.getCommand(deleteViewRequest)));

		// semantic reparent
		if(element != null) {
			Command moveSemanticCmd = getHost().getCommand(new EditCommandRequestWrapper(new MoveRequest(editingDomain, context, element)));

			if(moveSemanticCmd == null) {
				return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
			}

			cc.compose(new CommandProxy(moveSemanticCmd));
		}
		// drop of the object
		IAdaptable elementAdapter = new EObjectAdapter(element);
		int nodeVISUALID = UMLVisualIDRegistry.getNodeVisualID(((View)getHost().getModel()), element);
		ViewDescriptor descriptor = new ViewDescriptor(elementAdapter, Node.class, ((IHintedType)UMLElementTypes.getElementType(nodeVISUALID)).getSemanticHint(), ViewUtil.APPEND, false, ((GraphicalEditPart)getHost()).getDiagramPreferencesHint());
		CreateCommand createCommand = new CreateCommand(editingDomain, descriptor, ((View)(getHost().getModel())));
		cc.compose(createCommand);
		return cc;
	}
}
