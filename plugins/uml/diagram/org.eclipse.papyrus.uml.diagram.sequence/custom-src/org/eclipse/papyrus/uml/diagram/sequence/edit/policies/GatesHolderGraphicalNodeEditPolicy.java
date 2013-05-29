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
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandUtilities;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.requests.SuppressibleUIRequest;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.command.CreateGateElementAndViewCommand;
import org.eclipse.papyrus.uml.diagram.sequence.command.ReconnectToGateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CombinedFragmentEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.GateEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.InteractionUseEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.locator.GateLocator;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.GateHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.uml2.uml.Message;

/**
 * Graphical Presentation of Gate with In/Out
 * 
 * This GraphicalNodeEditPolicy used for CombinedFragment, InteractionUse and Interaction which can have Gates.
 * 
 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=389531
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class GatesHolderGraphicalNodeEditPolicy extends SequenceGraphicalNodeEditPolicy {

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.policies.SequenceGraphicalNodeEditPolicy#getReconnectSourceCommand(org.eclipse.gef.requests.ReconnectRequest)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected Command getReconnectSourceCommand(ReconnectRequest request) {
		ConnectionEditPart connection = request.getConnectionEditPart();
		EditPart source = connection.getSource();
		if(source instanceof GateEditPart) {
			if(getHost() == source.getParent()) {
				return getMoveGateCommand((GateEditPart)source, request);
			} else if(isReconnectMessage(request) && !isRedirectFailed(request)) {
				Point location = GateHelper.computeGateLocation(request.getLocation(), getHostFigure(), null);
				CompositeCommand result = new CompositeCommand("");
				CreateGateElementAndViewCommand createGateCommand = new CreateGateElementAndViewCommand(getEditingDomain(), getHost(), location);
				createGateCommand.setCreateInnerCFGate(getHost() instanceof CombinedFragmentEditPart);
				result.add(createGateCommand);
				ReconnectToGateCommand reconnectTargetCommand = new ReconnectToGateCommand(getEditingDomain(), getHost().getViewer(), createGateCommand.getResult(), request);
				result.add(reconnectTargetCommand);
				return new ICommandProxy(result);
			}
		}
		return super.getReconnectSourceCommand(request);
	}

	/**
	 * @param gateEditPart
	 * @param request
	 * @return
	 */
	protected Command getMoveGateCommand(GateEditPart gateEditPart, ReconnectRequest request) {
		Rectangle newBounds = new Rectangle(request.getLocation(), GateEditPart.DEFAULT_SIZE);
		IFigure hostFigure = getHostFigure();
		hostFigure.translateToRelative(newBounds);
		GateLocator locator = new GateLocator(hostFigure);
		Rectangle validLocation = locator.getValidLocation(newBounds, gateEditPart.getFigure());
		SetBoundsCommand command = new SetBoundsCommand(getEditingDomain(), "Update Gate Location", new EObjectAdapter(gateEditPart.getNotationView()), validLocation.getLocation());
		return new ICommandProxy(command);
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.sequence.edit.policies.SequenceGraphicalNodeEditPolicy#getReconnectTargetCommand(org.eclipse.gef.requests.ReconnectRequest)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected Command getReconnectTargetCommand(ReconnectRequest request) {
		ConnectionEditPart connection = request.getConnectionEditPart();
		EditPart target = connection.getTarget();
		if(target instanceof GateEditPart) {
			if(getHost() == target.getParent()) {
				return getMoveGateCommand((GateEditPart)target, request);
			} else if(isReconnectMessage(request) && !isRedirectFailed(request)) {
				Point location = GateHelper.computeGateLocation(request.getLocation(), getHostFigure(), null);
				CompositeCommand result = new CompositeCommand("");
				CreateGateElementAndViewCommand createGateCommand = new CreateGateElementAndViewCommand(getEditingDomain(), getHost(), location);
				createGateCommand.setCreateInnerCFGate(getHost() instanceof CombinedFragmentEditPart);
				result.add(createGateCommand);
				ReconnectToGateCommand reconnectTargetCommand = new ReconnectToGateCommand(getEditingDomain(), getHost().getViewer(), createGateCommand.getResult(), request);
				result.add(reconnectTargetCommand);
				return new ICommandProxy(result);
			}
		}
		return super.getReconnectTargetCommand(request);
	}

	private boolean isRedirectFailed(ReconnectRequest request) {
		Object data = request.getExtendedData().get(ReconnectToGateCommand.REDIRECT_GATE_FAILED);
		return data != null && "true".equalsIgnoreCase(data.toString());
	}

	private boolean isReconnectMessage(ReconnectRequest request) {
		ConnectionEditPart conn = request.getConnectionEditPart();
		IGraphicalEditPart adapter = (IGraphicalEditPart)conn.getAdapter(IGraphicalEditPart.class);
		return adapter != null && adapter.resolveSemanticElement() instanceof Message;
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy#getCommand(org.eclipse.gef.Request)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	public Command getCommand(Request request) {
		if(REQ_CONNECTION_END.equals(request.getType())) {
			if(isCreatingMessage(request, UMLElementTypes.Message_4004) || isCreatingMessage(request, UMLElementTypes.Message_4005) || isCreatingMessage(request, UMLElementTypes.Message_4009)) {
				return getConnectionEndWithGateCommand((CreateConnectionRequest)request);
			}
		}
		return super.getCommand(request);
	}

	/**
	 * Redirect the message end with a Graphical Gate.
	 * 
	 * @param request
	 * @return
	 */
	protected Command getConnectionEndWithGateCommand(CreateConnectionRequest request) {
		CompoundCommand cc = new CompoundCommand(DiagramUIMessages.Command_CreateRelationship_Label);
		//1. Create Target Gate
		Point targetLocation = GateHelper.computeGateLocation(request.getLocation(), getHostFigure(), null);
		CreateGateElementAndViewCommand createTargetGateCommand = new CreateGateElementAndViewCommand(getEditingDomain(), getHost(), targetLocation);
		createTargetGateCommand.setCreateInnerCFGate(true);
		createTargetGateCommand.setVolatiled(true);
		cc.add(new ICommandProxy(createTargetGateCommand));
		IAdaptable targetViewAdapter = createTargetGateCommand.getResult();
		//2. Create Source Gate if needed.
		EditPart sourceEditPart = request.getSourceEditPart();
		IAdaptable sourceViewAdapter = sourceEditPart;
		//Ignore message found.
		if(!isCreatingMessage(request, UMLElementTypes.Message_4009)) {
			if(sourceEditPart instanceof CombinedFragmentEditPart || sourceEditPart instanceof InteractionEditPart || sourceEditPart instanceof InteractionUseEditPart) {
				IGraphicalEditPart ep = (IGraphicalEditPart)sourceEditPart;
				Point location = request.getLocation();
				Object locationData = request.getExtendedData().get(SequenceRequestConstant.SOURCE_LOCATION_DATA);
				if(locationData instanceof Point) {
					location = (Point)locationData;
				}
				Point sourceLocation = GateHelper.computeGateLocation(location, ep.getFigure(), null);
				CreateGateElementAndViewCommand createSourceGateCommand = new CreateGateElementAndViewCommand(getEditingDomain(), sourceViewAdapter, sourceLocation);
				createSourceGateCommand.setCreateInnerCFGate(true);
				createSourceGateCommand.setVolatiled(true);
				cc.add(new ICommandProxy(createSourceGateCommand));
				sourceViewAdapter = createSourceGateCommand.getResult();
			}
		}
		//3. Create Message.
		ICommand createMessageCommand = createCreateMessageWithGateCommand(request, sourceViewAdapter, targetViewAdapter);
		cc.add(new ICommandProxy(createMessageCommand));
		return cc;
	}

	protected ICommand createCreateMessageWithGateCommand(CreateConnectionRequest request, IAdaptable sourceViewAdapter, IAdaptable targetViewAdapter) {
		if(request instanceof CreateConnectionViewAndElementRequest) {
			return new CreateMessageWithGateCommand((CreateConnectionViewAndElementRequest)request, sourceViewAdapter, targetViewAdapter, getHost().getViewer());
		} else if(request instanceof CreateUnspecifiedTypeConnectionRequest) {
			CreateUnspecifiedTypeConnectionRequest createReq = (CreateUnspecifiedTypeConnectionRequest)request;
			@SuppressWarnings("rawtypes")
			List elementTypes = createReq.getElementTypes();
			if(elementTypes.size() == 1) {
				IElementType elementType = (IElementType)elementTypes.get(0);
				return new CreateMessageWithGateCommand(request, elementType, sourceViewAdapter, targetViewAdapter, getHost().getViewer());
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	protected boolean isCreatingMessage(Request request, IElementType elementType) {
		if(request instanceof CreateUnspecifiedTypeConnectionRequest) {
			return ((CreateUnspecifiedTypeConnectionRequest)request).getElementTypes().contains(elementType);
		} else if(elementType instanceof IHintedType && request instanceof CreateConnectionViewAndElementRequest) {
			return ((IHintedType)elementType).getSemanticHint().equals(((CreateConnectionViewAndElementRequest)request).getConnectionViewDescriptor().getSemanticHint());
		}
		return false;
	}

	protected TransactionalEditingDomain getEditingDomain() {
		return ((GraphicalEditPart)getHost()).getEditingDomain();
	}

	/**
	 * This class is copied from DeferredCreateConnectionViewAndElementCommand.
	 * 
	 * But to fixed bugs about creating Message:
	 * 
	 * 1. Set the location for CreateConnectionViewRequest with created Gate.
	 * 2. Update targetContainer with created Gate.
	 * 
	 * @author Jin Liu (jin.liu@soyatec.com)
	 */
	private static class CreateMessageWithGateCommand extends AbstractCommand {

		private CreateRequest request = null;

		private IAdaptable typeInfoAdapter = null;

		private IAdaptable sourceViewAdapter = null;

		private IAdaptable targetViewAdapter = null;

		private Command command = null;

		private EditPartViewer viewer = null;

		public CreateMessageWithGateCommand(CreateConnectionViewAndElementRequest request, IAdaptable sourceViewAdapter, IAdaptable targetViewAdapter, EditPartViewer currentViewer) {
			super(DiagramUIMessages.Commands_CreateCommand_Connection_Label, null);
			Assert.isNotNull(currentViewer, "currentViewer is null");
			this.request = request;
			this.sourceViewAdapter = sourceViewAdapter;
			this.targetViewAdapter = targetViewAdapter;
			this.viewer = currentViewer;
		}

		public CreateMessageWithGateCommand(CreateRequest request, IAdaptable typeInfoAdapter, IAdaptable sourceViewAdapter, IAdaptable targetViewAdapter, EditPartViewer currentViewer) {
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

		@SuppressWarnings({ "restriction" })
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
			//			if(targetEP instanceof IGraphicalEditPart) {
			//				Rectangle absoluteBounds = SequenceUtil.getAbsoluteBounds((IGraphicalEditPart)targetEP);
			//				if(absoluteBounds != null) {
			//					req.setLocation(absoluteBounds.getLocation());
			//				}
			//			} else {
			//				req.setLocation(null);
			//			}
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
			//			if(req instanceof CreateConnectionViewAndElementRequest) {
			//				command = CreateConnectionViewAndElementRequest.getCreateCommand(req, sourceEP, targetEP);
			command = getCreateCommand((CreateConnectionViewRequest)req, sourceEP, targetEP);
			//			} else {
			//				command = CreateConnectionViewRequest.getCreateCommand(req, sourceEP, targetEP);
			//			}
			if(command != null && command.canExecute()) {
				command.execute();
			}
			viewer = null;// for garbage collection
			View view = (View)req.getConnectionViewDescriptor().getAdapter(View.class);
			if(null == view) {
				return CommandResult.newCancelledCommandResult();
			}
			if(request instanceof CreateConnectionViewRequest) {
				((CreateConnectionViewRequest)request).getConnectionViewDescriptor().setView(view);
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

	/**
	 * Copied from CreateConnectionViewAndElementRequest.getCreateCommand()
	 * 
	 * @param request
	 * @param sourceEditPart
	 * @param targetEditPart
	 * @return
	 */
	public static Command getCreateCommand(CreateConnectionViewRequest request, EditPart sourceEditPart, EditPart targetEditPart) {
		Assert.isNotNull(request);
		Assert.isNotNull(sourceEditPart);
		Assert.isNotNull(targetEditPart);
		request.setSourceEditPart(sourceEditPart);
		request.setTargetEditPart(targetEditPart);
		request.setType(RequestConstants.REQ_CONNECTION_START);
		Object location = request.getExtendedData().get(SequenceRequestConstant.SOURCE_LOCATION_DATA);
		if(location instanceof Point) {
			request.setLocation((Point)location);
		}
		sourceEditPart.showTargetFeedback(request);
		sourceEditPart.getCommand(request);
		sourceEditPart.eraseTargetFeedback(request);
		request.setType(RequestConstants.REQ_CONNECTION_END);
		targetEditPart.showTargetFeedback(request);
		Command command = targetEditPart.getCommand(request);
		targetEditPart.eraseTargetFeedback(request);
		return command;
	}
}
