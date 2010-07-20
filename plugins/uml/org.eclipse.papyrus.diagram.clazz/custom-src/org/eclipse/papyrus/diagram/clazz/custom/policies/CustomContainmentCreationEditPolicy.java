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
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.custom.policies;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.AddCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GroupEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.custom.helper.ContainmentHelper;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationClassEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.AssociationNodeEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Class5EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.Dependency2EditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPartCN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ModelEditPartTN;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.PackageEditPartCN;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.uml2.uml.Element;


/**
 * The Class CustomContainmentCreationEditPolicy.
 */
public class CustomContainmentCreationEditPolicy extends CreationEditPolicy {

	private static List<Integer> ourCanHaveContainmentLinks = Arrays.asList(new Integer[]{ Class5EditPart.VISUAL_ID, ClassEditPartCN.VISUAL_ID, PackageEditPartCN.VISUAL_ID, ModelEditPartCN.VISUAL_ID, ModelEditPartTN.VISUAL_ID, ClassEditPart.VISUAL_ID, PackageEditPart.VISUAL_ID });

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy#getReparentCommand(org.eclipse.gef.requests.ChangeBoundsRequest)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected Command getReparentCommand(ChangeBoundsRequest request) {
		Iterator editParts = request.getEditParts().iterator();
		View container = (View)getHost().getAdapter(View.class);
		EObject context = container == null ? null : ViewUtil.resolveSemanticElement(container);
		CompositeCommand cc = new CompositeCommand(DiagramUIMessages.AddCommand_Label);
		while(editParts.hasNext()) {
			EditPart ep = (EditPart)editParts.next();
			if(ep instanceof LabelEditPart) {
				continue;
			}
			if(ep instanceof GroupEditPart) {
				cc.compose(getReparentGroupCommand((GroupEditPart)ep));
			}
			View view = (View)ep.getAdapter(View.class);
			if(view == null) {
				continue;
			}

			EObject semantic = ViewUtil.resolveSemanticElement(view);
			if(semantic == null) {
				cc.compose(getReparentViewCommand((IGraphicalEditPart)ep));
			} else if(context != null && hasContainmentLink(view)) {
				return getDropWithContainmentCommand((IGraphicalEditPart)ep);
			} else if(context != null && shouldReparent(semantic, context)) {
				cc.compose(getReparentCommand((IGraphicalEditPart)ep));
			}
		}
		return cc.isEmpty() ? null : new ICommandProxy(cc.reduce());
	}

	private boolean hasContainmentLink(View movedView) {
		return ourCanHaveContainmentLinks.contains(UMLVisualIDRegistry.getVisualID(movedView));
	}

	private Command getDropWithContainmentCommand(IGraphicalEditPart ep) {
		View hostView = (View)getHost().getModel();
		View movedView = (View)ep.getModel();
		return getDropWithContainmentCommand(ep.getEditingDomain(), hostView, movedView);
	}

	private Command getDropWithContainmentCommand(TransactionalEditingDomain domain, View hostView, View movedView) {
		EObject hostElement = hostView.getElement();
		if(isMoveToParent(hostView, movedView)) {
			ContainmentHelper containmentHelper = new ContainmentHelper(domain);
			CompositeCommand cmd = new CompositeCommand("Move Element");
			cmd.add(new AddCommand(domain, new EObjectAdapter(hostView), new EObjectAdapter(movedView)));
			containmentHelper.deleteIncomingContainmentLinksFor(cmd, movedView);
			return new ICommandProxy(cmd);
		} else if(isMoveToChild(hostView, movedView)) {
			ContainmentHelper containmentHelper = new ContainmentHelper(domain);
			CompositeCommand cmd = new CompositeCommand("Move Element");
			Element parent = (Element)ViewUtil.resolveSemanticElement((View)getHost().getParent().getParent().getModel());
			Element child1 = (Element)hostElement;
			Element child2 = (Element)ViewUtil.resolveSemanticElement(movedView);
			cmd.add(new MoveElementCommand(domain, containmentHelper, parent, child1));
			cmd.add(new MoveElementCommand(domain, containmentHelper, child1, child2));
			cmd.add(new AddCommand(domain, new EObjectAdapter(hostView), new EObjectAdapter(movedView)));
			containmentHelper.deleteOutgoingContainmentLinksFor(cmd, movedView);
			return new ICommandProxy(cmd);
		} else if(ContainmentHelper.hasIncomingContainmentLink(movedView)) {
			ContainmentHelper containmentHelper = new ContainmentHelper(domain);
			CompositeCommand cmd = new CompositeCommand("Move Element");
			Element parent = (Element)hostElement;
			Element child = (Element)movedView.getElement();
			cmd.add(new MoveElementCommand(domain, containmentHelper, parent, child));
			cmd.add(new AddCommand(domain, new EObjectAdapter(hostView), new EObjectAdapter(movedView)));
			containmentHelper.deleteIncomingContainmentLinksFor(cmd, movedView);
			return new ICommandProxy(cmd);
		} else if(ContainmentHelper.hasOutgoingContainmentLink(movedView)) {
			// move contained element into a correct place
			return UnexecutableCommand.INSTANCE;
		}
		return null;
	}

	private boolean isMoveToChild(View hostView, View movedElementView) {
		return EcoreUtil.isAncestor(movedElementView.getElement(), hostView.getElement());
	}

	private boolean isMoveToParent(View hostView, View movedElementView) {
		return hostView.getElement().equals(movedElementView.getElement().eContainer());
		//		return EcoreUtil.isAncestor(hostView.getElement(), movedElementView.getElement());
	}
	
	private static class MoveElementCommand extends AbstractTransactionalCommand {

		private final ContainmentHelper myHelper;

		private final Element myTarget;

		private final Element myMoved;

		public MoveElementCommand(TransactionalEditingDomain domain, ContainmentHelper helper, Element target, Element moved) {
			super(domain, "Move Element", Collections.emptyList());
			myHelper = helper;
			myMoved = moved;
			myTarget = target;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			myHelper.move(myMoved, myTarget);
			return CommandResult.newOKCommandResult();
		}
	}

}
