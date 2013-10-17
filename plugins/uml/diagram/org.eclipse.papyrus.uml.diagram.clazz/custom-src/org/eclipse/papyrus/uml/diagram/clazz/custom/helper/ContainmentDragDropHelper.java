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
package org.eclipse.papyrus.uml.diagram.clazz.custom.helper;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.AddCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.Element;

public class ContainmentDragDropHelper extends ContainmentHelper {

	/**
	 * Instantiates a new containment drag drop helper.
	 * 
	 * @param editDomain
	 *        the edit domain
	 */
	public ContainmentDragDropHelper(TransactionalEditingDomain editDomain) {
		super(editDomain);
	}

	/**
	 * Gets the drop with containment command.
	 * 
	 * @param domain
	 *        the domain
	 * @param hostView
	 *        the host view
	 * @param movedView
	 *        the moved view
	 * @return the drop with containment command
	 */
	public Command getDropWithContainmentCommand(View hostView, View movedView) {
		if(isMoveToParent(hostView, movedView)) {
			return moveToParent(hostView, movedView);
		} else if(isMoveToChild(hostView, movedView)) {
			return moveToChild(hostView, movedView);
		} else if(hasIncomingContainmentLink(movedView)) {
			return moveWithIncomingContainmentLink(hostView, movedView);
		} else if(ContainmentHelper.hasOutgoingContainmentLink(movedView)) {
			return moveWithOutgoingContainmentLink();
		}
		return null;
	}

	private Command moveWithOutgoingContainmentLink() {
		// move contained element into a correct place
		return UnexecutableCommand.INSTANCE;
	}

	private Command moveWithIncomingContainmentLink(View hostView, View movedView) {
		CompositeCommand cmd = new CompositeCommand("Move Element");
		Element parent = (Element)hostView.getElement();
		Element child = (Element)movedView.getElement();
		cmd.add(new MoveElementCommand(parent, child));
		cmd.add(new AddCommand(getEditingDomain(), new EObjectAdapter(hostView), new EObjectAdapter(movedView)));
		deleteIncomingContainmentLinksFor(cmd, movedView);
		return new ICommandProxy(cmd);
	}

	private Command moveToChild(View hostView, View movedView) {
		CompositeCommand cmd = new CompositeCommand("Move Element");
		Element parent = (Element)ViewUtil.resolveSemanticElement((View)hostView.eContainer().eContainer());
		Element child1 = (Element)hostView.getElement();
		Element child2 = (Element)ViewUtil.resolveSemanticElement(movedView);
		cmd.add(new MoveElementCommand(parent, child1));
		cmd.add(new MoveElementCommand(child1, child2));
		cmd.add(new AddCommand(getEditingDomain(), new EObjectAdapter(hostView), new EObjectAdapter(movedView)));
		deleteOutgoingContainmentLinksFor(cmd, movedView);
		return new ICommandProxy(cmd);
	}

	private Command moveToParent(View hostView, View movedView) {
		CompositeCommand cmd = new CompositeCommand("Move Element");
		cmd.add(new AddCommand(getEditingDomain(), new EObjectAdapter(hostView), new EObjectAdapter(movedView)));
		deleteIncomingContainmentLinksFor(cmd, movedView);
		return new ICommandProxy(cmd);
	}

	private boolean isMoveToChild(View hostView, View movedElementView) {
		return EcoreUtil.isAncestor(movedElementView.getElement(), hostView.getElement());
	}

	private boolean isMoveToParent(View hostView, View movedElementView) {
		return hostView.getElement().equals(movedElementView.getElement().eContainer());
		//		return EcoreUtil.isAncestor(hostView.getElement(), movedElementView.getElement());
	}

	private class MoveElementCommand extends AbstractTransactionalCommand {

		private final Element myTarget;

		private final Element myMoved;

		public MoveElementCommand(Element target, Element moved) {
			super(ContainmentDragDropHelper.this.getEditingDomain(), "Move Element", Collections.emptyList());
			myMoved = moved;
			myTarget = target;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			move(myMoved, myTarget);
			return CommandResult.newOKCommandResult();
		}
	}
}
