/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.actions;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest;
import org.eclipse.papyrus.diagram.common.part.CustomMessages;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;


// TODO: Auto-generated Javadoc
/**
 * The Class ApplyStereotypeAction.
 */
public class ApplyStereotypeAction extends DiagramAction {

	/** The Constant EMPTY_NAME. */
	private static final String EMPTY_NAME = CustomMessages.ApplyStereotypeAction_empty_name;

	/** The my element. */
	private Element myElement;

	/** The my stereotype. */
	private Stereotype myStereotype;

	/**
	 * Instantiates a new apply stereotype action.
	 * 
	 * @param workbenchPage
	 *            the workbench page
	 * @param element
	 *            the element
	 * @param stereotype
	 *            the stereotype
	 */
	public ApplyStereotypeAction(IWorkbenchPage workbenchPage, Element element, Stereotype stereotype) {
		super(workbenchPage);
		myElement = element;
		myStereotype = stereotype;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#createTargetRequest()
	 */
	@Override
	protected Request createTargetRequest() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#isSelectionListener()
	 */
	@Override
	protected boolean isSelectionListener() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#getCommand()
	 */
	@Override
	protected Command getCommand() {
		final IGraphicalEditPart elementEditPart = getElementEditPart();
		if (elementEditPart == null) {
			return UnexecutableCommand.INSTANCE;
		}
		TransactionalEditingDomain editingDomain = elementEditPart.getEditingDomain();
		StereotypeRequest request = new StereotypeRequest(editingDomain);
		request.setApplyNotUnapply(!isStereotypeAppliedTo(myElement, myStereotype));
		request.setElement(myElement);
		request.setStereotype(myStereotype);

		CompoundCommand command = new CompoundCommand();
		command.add(new ICommandProxy(new StereotypeCommand(request)));
		command.add(new Command() {

			@Override
			public void execute() {
				// there are no clear ways for parser to locate this change and
				// update label
				// for (Object nextChildEP : elementEditPart.getChildren()){
				// if (nextChildEP instanceof ITextAwareEditPart){
				// ((ITextAwareEditPart)nextChildEP).refresh();
				// }
				// }
				DiagramEditPartsUtil.refreshITextAwareEditParts(elementEditPart);
			}
		});
		return command;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		return getElementEditPart() != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#refresh()
	 */
	@Override
	public void refresh() {
		super.refresh();
		setText(calculateText());
		setChecked(calculateChecked());
	}

	/**
	 * Calculate text.
	 * 
	 * @return the string
	 */
	private String calculateText() {
		String name = myStereotype.getQualifiedName();
		return name != null ? name : EMPTY_NAME;
	}

	/**
	 * Calculate checked.
	 * 
	 * @return true, if successful
	 */
	private boolean calculateChecked() {
		return isStereotypeAppliedTo(myElement, myStereotype);
	}

	/**
	 * Gets the element edit part.
	 * 
	 * @return the element edit part
	 */
	private IGraphicalEditPart getElementEditPart() {
		for (Object next : getSelectedObjects()) {
			if (next instanceof IGraphicalEditPart) {
				IGraphicalEditPart elementEditPart = (IGraphicalEditPart) next;
				return elementEditPart;
			}
		}
		return null;
	}

	/**
	 * Checks if is stereotype applied to.
	 * 
	 * @param element
	 *            the element
	 * @param stereotype
	 *            the stereotype
	 * 
	 * @return true, if is stereotype applied to
	 */
	private boolean isStereotypeAppliedTo(Element element, Stereotype stereotype) {
		return element.isStereotypeApplied(stereotype);
	}

	/**
	 * The Class StereotypeCommand.
	 */
	private class StereotypeCommand extends EditElementCommand {

		/**
		 * Instantiates a new stereotype command.
		 * 
		 * @param request
		 *            the request
		 */
		protected StereotypeCommand(StereotypeRequest request) {
			super(request.isApplyNotUnapply() ? CustomMessages.ApplyStereotypeAction_apply_stereotype_command : CustomMessages.ApplyStereotypeAction_annapply_stereotype_command, request.getElement(),
					request);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			StereotypeRequest request = (StereotypeRequest) getRequest();
			if (request.isApplyNotUnapply()) {
				request.getElement().applyStereotype(request.getStereotype());
			} else {
				request.getElement().unapplyStereotype(request.getStereotype());
			}

			return CommandResult.newOKCommandResult(request.getElement());
		}
	}

	/**
	 * The Class StereotypeRequest.
	 */
	private static class StereotypeRequest extends AbstractEditCommandRequest {

		/** The my element. */
		private Element myElement;

		/** The my apply not unapply. */
		private boolean myApplyNotUnapply;

		/** The my stereotype. */
		private Stereotype myStereotype;

		/**
		 * Instantiates a new stereotype request.
		 * 
		 * @param domain
		 *            the domain
		 */
		public StereotypeRequest(TransactionalEditingDomain domain) {
			super(domain);
		}

		/**
		 * Sets the apply not unapply.
		 * 
		 * @param applyNotUnapply
		 *            the new apply not unapply
		 */
		public void setApplyNotUnapply(boolean applyNotUnapply) {
			myApplyNotUnapply = applyNotUnapply;
		}

		/**
		 * Sets the element.
		 * 
		 * @param element
		 *            the new element
		 */
		public void setElement(Element element) {
			myElement = element;
		}

		/**
		 * Sets the stereotype.
		 * 
		 * @param stereotype
		 *            the new stereotype
		 */
		public void setStereotype(Stereotype stereotype) {
			myStereotype = stereotype;
		}

		/**
		 * Gets the stereotype.
		 * 
		 * @return the stereotype
		 */
		public Stereotype getStereotype() {
			return myStereotype;
		}

		/**
		 * Gets the element.
		 * 
		 * @return the element
		 */
		public Element getElement() {
			return myElement;
		}

		/**
		 * Checks if is apply not unapply.
		 * 
		 * @return true, if is apply not unapply
		 */
		public boolean isApplyNotUnapply() {
			return myApplyNotUnapply;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest#getEditHelperContext()
		 */
		public Object getEditHelperContext() {
			return null;
		}

	}
}
