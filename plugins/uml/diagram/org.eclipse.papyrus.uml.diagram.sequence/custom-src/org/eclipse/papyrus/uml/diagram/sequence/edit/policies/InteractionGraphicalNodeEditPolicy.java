/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionAnchorsCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionEndsCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandUtilities;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateViewAndOptionallyElementCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.requests.SuppressibleUIRequest;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.command.CreateGateViewCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionInteractionCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.GateHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionUse;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;

/**
 * 1. Create a Lifeline if the target of Message Created is not selected.
 * See: https://bugs.eclipse.org/bugs/show_bug.cgi?id=403134
 * 
 * 2. Redirect the source from CombinedFragment, Interaction and InteractionUse to a Graphical Gate.
 * See: https://bugs.eclipse.org/bugs/show_bug.cgi?id=389531
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class InteractionGraphicalNodeEditPolicy extends GatesHolderGraphicalNodeEditPolicy {

	/**
	 * Constructor.
	 * 
	 */
	public InteractionGraphicalNodeEditPolicy() {
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.policies.SequenceGraphicalNodeEditPolicy#getTargetEditPart(org.eclipse.gef.Request)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	public EditPart getTargetEditPart(Request request) {
		if(REQ_CONNECTION_END.equals(request.getType()) && isCreateConnectionRequest(request, UMLElementTypes.Message_4006)) {
			return getHost();
		}
		return super.getTargetEditPart(request);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy#getCommand(org.eclipse.gef.Request)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	public Command getCommand(Request request) {
		if(REQ_CONNECTION_END.equals(request.getType()) && isCreateConnectionRequest(request, UMLElementTypes.Message_4006)) {
			return getMessageCreateAndLifelineCommands((CreateConnectionRequest)request);
		}
		return super.getCommand(request);
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.policies.SequenceGraphicalNodeEditPolicy#getConnectionCompleteCommand(org.eclipse.gef.requests.CreateConnectionRequest)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
		Command command = super.getConnectionCompleteCommand(request);
		if(command != null && command.canExecute() && REQ_CONNECTION_END.equals(request.getType()) && isCreateConnectionRequest(request, UMLElementTypes.Message_4008)) {
			EditPart sourceEditPart = request.getSourceEditPart();
			EObject source = ViewUtil.resolveSemanticElement((View)sourceEditPart.getModel());
			if(source instanceof CombinedFragment || source instanceof Interaction || source instanceof InteractionUse) {
				Point location = null;
				IGraphicalEditPart adapter = (IGraphicalEditPart)sourceEditPart.getAdapter(IGraphicalEditPart.class);
				TransactionalEditingDomain editingDomain = null;
				if(adapter != null) {
					location = GateHelper.computeGateLocation(request.getLocation(), adapter.getFigure(), null);
					editingDomain = adapter.getEditingDomain();
				}
				ConnectionViewDescriptor edgeAdaptor = null;
				if(request instanceof CreateConnectionViewRequest) {
					edgeAdaptor = ((CreateConnectionViewRequest)request).getConnectionViewDescriptor();
				} else if(request instanceof CreateUnspecifiedTypeConnectionRequest) {
					List elementTypes = ((CreateUnspecifiedTypeConnectionRequest)request).getElementTypes();
					if(elementTypes.size() == 1) {
						CreateRequest realRequest = ((CreateUnspecifiedTypeConnectionRequest)request).getRequestForType((IElementType)elementTypes.get(0));
						if(realRequest instanceof CreateConnectionViewRequest) {
							edgeAdaptor = ((CreateConnectionViewRequest)realRequest).getConnectionViewDescriptor();
						}
					}
				}
				if(edgeAdaptor != null) {
					final IAdaptable elementAdapter = edgeAdaptor.getElementAdapter();
					if(elementAdapter != null) {
						CompoundCommand cc = new CompoundCommand("Redirect to Gate");
						cc.add(command);
						IAdaptable gateAdaptor = new IAdaptable() {

							public Object getAdapter(Class adapter) {
								if(Gate.class == adapter) {
									Message message = (Message)elementAdapter.getAdapter(Message.class);
									MessageEnd sendEvent = message.getSendEvent();
									if(sendEvent instanceof Gate) {
										return sendEvent;
									}
								}
								return null;
							}
						};
						CreateGateViewCommand createGateCommand = new CreateGateViewCommand(editingDomain, sourceEditPart, location, gateAdaptor);
						cc.add(new ICommandProxy(createGateCommand));
						SetConnectionEndsCommand resetSourceCommand = new SetConnectionEndsCommand(editingDomain, null);
						resetSourceCommand.setEdgeAdaptor(edgeAdaptor);
						resetSourceCommand.setNewSourceAdaptor(createGateCommand.getResult());
						cc.add(new ICommandProxy(resetSourceCommand));
						SetConnectionAnchorsCommand resetSourceAnchorsCommand = new SetConnectionAnchorsCommand(editingDomain, null);
						resetSourceAnchorsCommand.setEdgeAdaptor(edgeAdaptor);
						resetSourceAnchorsCommand.setNewSourceTerminal("(1, 0.5)");
						cc.add(new ICommandProxy(resetSourceAnchorsCommand));
						return cc.unwrap();
					}
				}
			}
		}
		return command;
	}

	protected Command getMessageCreateAndLifelineCommands(CreateConnectionRequest request) {
		InteractionEditPart iep = (InteractionEditPart)getHost();
		IGraphicalEditPart container = iep.getChildBySemanticHint("" + InteractionInteractionCompartmentEditPart.VISUAL_ID);
		CompoundCommand cc = new CompoundCommand(DiagramUIMessages.Command_CreateRelationship_Label);
		//1. Create a Lifeline.
		CreateViewAndOptionallyElementCommand createOtherEndCmd = new CreateViewAndOptionallyElementCommand(UMLElementTypes.Lifeline_3001, container, request.getLocation(), iep.getDiagramPreferencesHint());
		cc.add(new ICommandProxy(createOtherEndCmd));
		//2. Create message to the Lifeline.
		ICommand connectionCmd = new CreateMessageCreateWithLifelineCommand(request, UMLElementTypes.Message_4006, request.getSourceEditPart(), createOtherEndCmd.getResult(), iep.getViewer());
		cc.add(new ICommandProxy(connectionCmd));
		return cc;
	}

	/**
	 * This class is copied from DeferredCreateConnectionViewAndElementCommand.
	 * 
	 * But to fixed bugs about creating Message:
	 * 
	 * 1. Set the location for CreateConnectionViewRequest with created Lifeline.
	 * 2. Update targetContainer with created Lifeline.
	 * 
	 * @author Jin Liu (jin.liu@soyatec.com)
	 */
	private static class CreateMessageCreateWithLifelineCommand extends AbstractCommand {

		private CreateRequest request = null;

		private IAdaptable typeInfoAdapter = null;

		private IAdaptable sourceViewAdapter = null;

		private IAdaptable targetViewAdapter = null;

		private Command command = null;

		private EditPartViewer viewer = null;

		public CreateMessageCreateWithLifelineCommand(CreateRequest request, IAdaptable typeInfoAdapter, IAdaptable sourceViewAdapter, IAdaptable targetViewAdapter, EditPartViewer currentViewer) {
			super(DiagramUIMessages.Commands_CreateCommand_Connection_Label, null);
			Assert.isNotNull(currentViewer, "currentViewer is null");
			this.request = request;
			this.typeInfoAdapter = typeInfoAdapter;
			this.sourceViewAdapter = sourceViewAdapter;
			this.targetViewAdapter = targetViewAdapter;
			this.viewer = currentViewer;
		}

		@SuppressWarnings("rawtypes")
		public List getAffectedFiles() {
			if(viewer != null) {
				EditPart editpart = viewer.getRootEditPart().getContents();
				if(editpart instanceof IGraphicalEditPart) {
					View view = (View)editpart.getModel();
					if(view != null) {
						IFile f = WorkspaceSynchronizer.getFile(view.eResource());
						return f != null ? Collections.singletonList(f) : Collections.EMPTY_LIST;
					}
				}
			}
			return super.getAffectedFiles();
		}

		public boolean canUndo() {
			return command != null && command.canUndo();
		}

		public boolean canRedo() {
			return CommandUtilities.canRedo(command);
		}

		/**
		 * gives access to the connection source edit part, which is the edit part
		 * of the connection's source <code>View</code>
		 * 
		 * @return the source edit part
		 */
		protected EditPart getSourceEditPart() {
			return (IGraphicalEditPart)viewer.getEditPartRegistry().get(sourceViewAdapter.getAdapter(View.class));
		}

		/**
		 * gives access to the connection target edit part, which is the edit part
		 * of the connection's target <code>View</code>
		 * 
		 * @return the source edit part
		 */
		protected EditPart getTargetEditPart() {
			return (IGraphicalEditPart)viewer.getEditPartRegistry().get(targetViewAdapter.getAdapter(View.class));
		}

		public boolean canExecute() {
			if(!(request instanceof CreateConnectionViewRequest) && !(request instanceof CreateUnspecifiedTypeConnectionRequest))
				return false;
			if(request instanceof CreateUnspecifiedTypeConnectionRequest) {
				if(typeInfoAdapter == null)
					return false;
				final IElementType typeInfo = (IElementType)typeInfoAdapter.getAdapter(IElementType.class);
				if(typeInfo != null) {
					if(((CreateUnspecifiedTypeConnectionRequest)request).getRequestForType(typeInfo) == null)
						return false;
				}
			}
			return true;
		}

		@SuppressWarnings({ "restriction", "unchecked" })
		protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
			CreateConnectionViewRequest req = null;
			if(request != null) {
				if(request instanceof CreateConnectionViewRequest) {
					req = (CreateConnectionViewRequest)request;
				}
			} else {
				return CommandResult.newErrorCommandResult(getLabel());
			}
			if(typeInfoAdapter != null) {
				IElementType typeInfo = (IElementType)typeInfoAdapter.getAdapter(IElementType.class);
				if(typeInfo == null) {
					return CommandResult.newErrorCommandResult(getLabel());
				}
				if(request instanceof CreateUnspecifiedTypeConnectionRequest) {
					req = ((CreateConnectionViewRequest)((CreateUnspecifiedTypeConnectionRequest)request).getRequestForType(typeInfo));
				}
			}
			// Suppressing UI if the target edit part has not been created yet
			// this is so that if we are creating a new target the connection
			// creation will just take default data instead of prompting
			// For Defect RATLC00524293
			if(targetViewAdapter.getAdapter(IGraphicalEditPart.class) == null && req instanceof SuppressibleUIRequest)
				((SuppressibleUIRequest)req).setSuppressibleUI(true);
			EditPart sourceEP = getSourceEditPart();
			EditPart targetEP = getTargetEditPart();
			if(targetEP instanceof IGraphicalEditPart) {
				Rectangle absoluteBounds = SequenceUtil.getAbsoluteBounds((IGraphicalEditPart)targetEP);
				if(absoluteBounds != null) {
					req.setLocation(absoluteBounds.getLocation());
				}
			} else {
				req.setLocation(null);
			}
			// There are situations where src or target can be null and we must
			// check for these
			// ie. When a Select Existing Dialog is presnetd to the user and the
			// user presses
			// cancel either the src or target can be null.
			// So the following assertions have been replaced with a check for null
			// on the editparts.
			// old code ... Assert.isNotNull(sourceEP); Assert.isNotNull(targetEP);
			if((sourceEP == null) || (targetEP == null))
				return null;
			if(req instanceof CreateConnectionViewAndElementRequest) {
				req.getExtendedData().put(SequenceRequestConstant.TARGET_MODEL_CONTAINER, SequenceUtil.findInteractionFragmentContainerAt(req.getLocation(), getTargetEditPart()));
				command = CreateConnectionViewAndElementRequest.getCreateCommand(req, sourceEP, targetEP);
			} else {
				command = CreateConnectionViewRequest.getCreateCommand(req, sourceEP, targetEP);
			}
			if(command != null && command.canExecute()) {
				command.execute();
			}
			viewer = null;// for garbage collection
			View view = (View)req.getConnectionViewDescriptor().getAdapter(View.class);
			if(null == view) {
				return CommandResult.newCancelledCommandResult();
			}
			return CommandResult.newOKCommandResult(req.getNewObject());
		}

		public String getLabel() {
			if(command != null) {
				return command.getLabel();
			}
			return null;
		}

		protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
			if(command != null) {
				command.redo();
			}
			return CommandResult.newOKCommandResult();
		}

		protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
			if(command != null) {
				command.undo();
			}
			return CommandResult.newOKCommandResult();
		}
	}
}
