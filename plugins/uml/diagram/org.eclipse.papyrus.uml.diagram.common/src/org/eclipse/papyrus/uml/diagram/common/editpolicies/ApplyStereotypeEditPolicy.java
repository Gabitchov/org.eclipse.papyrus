/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.common.core.util.Trace;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIDebugOptions;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIPlugin;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIStatusCodes;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.util.EditPartUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.infra.core.utils.PapyrusTrace;
import org.eclipse.papyrus.uml.appearance.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.uml.diagram.common.commands.DefferedAppliedStereotypeToDisplayCommand;
import org.eclipse.papyrus.uml.diagram.common.editparts.IUMLEditPart;
import org.eclipse.papyrus.uml.diagram.common.helper.NamedElementHelper;
import org.eclipse.papyrus.uml.diagram.common.service.ApplyStereotypeRequest;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;

/**
 * Apply Stereotype edit policy.
 * <P>
 * Edit policy in charge of applying stereotypes on uml elements
 * </P>
 */
public class ApplyStereotypeEditPolicy extends AbstractEditPolicy {

	/**
	 * Creates a new ApplyStereotypeEditPolicy.
	 */
	public ApplyStereotypeEditPolicy() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Command getCommand(Request request) {
		if(understandsRequest(request)) {
			executeCommand(getApplyStereotypeCommand((ApplyStereotypeRequest)request));
			return null;
		} else
			return super.getCommand(request);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean understandsRequest(Request req) {
		if(ApplyStereotypeRequest.APPLY_STEREOTYPE_REQUEST.equals(req.getType())) {
			return true;
		}
		return super.understandsRequest(req);
	}

	//
	// /**
	// * {@inheritDoc}
	// */
	// @Override
	// public Command getCommand(Request request) {
	// // command should be a composed command: apply stereotype, display
	// stereotype and eventually
	// // change the name of the semantic element
	// if
	// (ApplyStereotypeRequest.APPLY_STEREOTYPE_REQUEST.equals(request.getType()))
	// return getApplyStereotypeCommand((ApplyStereotypeRequest) request);
	//
	// return super.getCommand(request);
	// }

	/**
	 * Executes the supplied command inside an <code>unchecked action</code>
	 * 
	 * @param cmd
	 *        command that can be executed (i.e., cmd.canExecute() == true)
	 */
	protected void executeCommand(final Command cmd) {
		Map<String, Boolean> options = null;
		EditPart ep = getHost();
		boolean isActivating = true;
		// use the viewer to determine if we are still initializing the diagram
		// do not use the DiagramEditPart.isActivating since
		// ConnectionEditPart's
		// parent will not be a diagram edit part
		EditPartViewer viewer = ep.getViewer();
		if(viewer instanceof DiagramGraphicalViewer) {
			isActivating = ((DiagramGraphicalViewer)viewer).isInitializing();
		}

		if(isActivating || !EditPartUtil.isWriteTransactionInProgress((IGraphicalEditPart)getHost(), false, false))
			options = Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE);

		AbstractEMFOperation operation = new AbstractEMFOperation(((IGraphicalEditPart)getHost()).getEditingDomain(), StringStatics.BLANK, options) {

			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

				cmd.execute();

				return Status.OK_STATUS;
			}
		};
		try {
			operation.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			Trace.catching(DiagramUIPlugin.getInstance(), DiagramUIDebugOptions.EXCEPTIONS_CATCHING, getClass(), "executeCommand", e); //$NON-NLS-1$
			Log.warning(DiagramUIPlugin.getInstance(), DiagramUIStatusCodes.IGNORED_EXCEPTION_WARNING, "executeCommand", e); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EditPart getTargetEditPart(Request request) {
		if(understandsRequest(request)) {
			return getHost();
		}
		return super.getTargetEditPart(request);
	}

	/**
	 * Returns the <code>Command</code> contribution for the given <code>ApplyStereotypeRequest</code>
	 * 
	 * @param request
	 *        the request linked to this edit policy
	 * @return the command that applies the stereotype or <code>null</code>
	 */
	protected Command getApplyStereotypeCommand(ApplyStereotypeRequest request) {
		final ApplyStereotypeRequest _request = request;
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		CompositeTransactionalCommand cc = new CompositeTransactionalCommand(editingDomain, "Apply Stereotype");
		final List<EObject> result = new ArrayList<EObject>();
		final Element element = (Element)(((View)getHost().getModel()).getElement());

		// 1. apply stereotypes
		cc.compose(new AbstractTransactionalCommand(editingDomain, "Apply Stereotype", null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

				// retrieves the edit part on which stereotype request is made
				if(getHost() instanceof IUMLEditPart || ((getHost().getModel() instanceof View) && (((View)getHost().getModel()).getElement()) instanceof Element)) {
					if(element == null) {
						return null;
					}
					// retrieves the list of stereotypes to be applied
					List<String> stereotypeQNames = _request.getStereotypesToApply();
					for(String stereotypeQName : stereotypeQNames) {
						// retrieve the stereotype to apply
						Stereotype stereotype = element.getApplicableStereotype(stereotypeQName);
						if(stereotype == null) {
							// stereotype has no been found. should ask for
							// profile application ?
							PapyrusTrace.log(IStatus.WARNING, "impossible to retrieve the stereotype " + stereotypeQName);
						} else {
							result.add(element.applyStereotype(stereotype));
						}
					}

				}
				return CommandResult.newOKCommandResult(result);
			}
		});

		// check if the name of base element must be changed (don't bother what
		// is the value of the
		// element, only the key is needed
		Object newName = request.getExtendedData().get(ApplyStereotypeRequest.NEW_EDIT_PART_NAME);
		if(newName != null) {
			cc.compose(new AbstractTransactionalCommand(editingDomain, "Edit Base Element Name", null) {

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

					// retrieves the edit part on which stereotype request is
					// made
					if(getHost() instanceof IUMLEditPart || ((getHost().getModel() instanceof View) && (((View)getHost().getModel()).getElement()) instanceof Element)) {
						if(!(element instanceof NamedElement)) {
							return null;
						}

						// retrieves the list of stereotypes to be applied
						// (qualified names)
						List<String> stereotypeQNames = _request.getStereotypesToApply();
						String stereotypeName = NamedElementUtil.getNameFromQualifiedName(stereotypeQNames.get(0));
						// find a new name for the element
						String name = NamedElementHelper.EINSTANCE.getNewUMLElementName(element.getOwner(), stereotypeName);
						((NamedElement)element).setName(name);

					}
					return CommandResult.newOKCommandResult(result);
				}
			});
		}

		// 2. display stereotypes
		String presentationKind = AppliedStereotypeHelper.getAppliedStereotypePresentationKind(element);
		// should display real applied stereotypes and not the list of
		// stereotypes to apply...
		cc.compose(new EMFtoGMFCommandWrapper(new DefferedAppliedStereotypeToDisplayCommand(editingDomain, getHost(), "", presentationKind)));

		return new ICommandProxy(cc.reduce());
	}

	/**
	 * Returns the list of stereotypes to display
	 * 
	 * @param request
	 *        the request that triggers this policy
	 * @return the list of stereotypes to display
	 */
	public String getStereotypeList(ApplyStereotypeRequest request) {
		// transforms the list of stereotypes in the request into a string
		// corresponding to the
		// string input of the display stereotype command.
		StringBuffer buffer = new StringBuffer();
		Iterator<String> it = request.getStereotypesToApply().iterator();
		while(it.hasNext()) {
			String stereotypeQN = it.next();
			buffer.append(stereotypeQN);
			if(it.hasNext()) {
				buffer.append(", ");
			}
		}
		return buffer.toString();
	}
}
