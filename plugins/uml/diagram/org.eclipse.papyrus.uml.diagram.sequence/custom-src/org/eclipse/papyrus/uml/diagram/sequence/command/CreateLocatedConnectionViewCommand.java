package org.eclipse.papyrus.uml.diagram.sequence.command;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.Type;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.NotificationBuilder;
import org.eclipse.papyrus.uml.diagram.common.commands.CommonDeferredCreateConnectionViewCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.part.Messages;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;

/**
 * This class is used to create a connection view which source and target locations are defined. This is useful for connections linked to an
 * Occurrence Specification, which is located at a particular predefined point.
 * 
 * @author vhemery
 */
public class CreateLocatedConnectionViewCommand extends CommonDeferredCreateConnectionViewCommand {

	/** Point where source must be drawn */
	private Point sourceLocation;

	/** Point where target must be drawn */
	private Point targetLocation;

	/**
	 * {@inheritDoc}
	 */
	public CreateLocatedConnectionViewCommand(TransactionalEditingDomain editingDomain, String semanticHint, IAdaptable sourceViewAdapter, IAdaptable targetViewAdapter, EditPartViewer viewer, PreferencesHint preferencesHint, ConnectionViewDescriptor viewDescriptor, ICommand command) {
		super(editingDomain, semanticHint, sourceViewAdapter, targetViewAdapter, viewer, preferencesHint, viewDescriptor, command);
	}

	/**
	 * {@inheritDoc}
	 */
	public CreateLocatedConnectionViewCommand(TransactionalEditingDomain editingDomain, EObject element, IAdaptable sourceViewAdapter, IAdaptable targetViewAdapter, EditPartViewer viewer, PreferencesHint preferencesHint, ICommand command) {
		super(editingDomain, element, sourceViewAdapter, targetViewAdapter, viewer, preferencesHint, command);
	}

	/**
	 * Creates a connection view between the source and target.
	 * 
	 * @throws ExecutionException
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info, IGraphicalEditPart sourceEditPart, IGraphicalEditPart targetEditPart) throws ExecutionException {

		// If these are null, then the diagram's editparts may not
		// have been refreshed yet.
		Assert.isNotNull(sourceEditPart);
		Assert.isNotNull(targetEditPart);

		// use the String semanticHint to create a view
		// modification in order to fix the bug
		CreateConnectionViewRequest createRequest = new CreateConnectionViewRequest(viewDescriptor);
		createConnectionCmd = getCreateCommand(createRequest, sourceEditPart, targetEditPart);

		if(createConnectionCmd != null && createConnectionCmd.canExecute()) {
			createConnectionCmd.execute();
			if(element != null) {
				((View)(createRequest.getConnectionViewDescriptor().getAdapter(View.class))).setElement(element);
			}
		} else {
			// connection can not be created
			handleErrorMessage(createRequest, sourceEditPart, targetEditPart);
		}
		viewer = null;// for garbage collection
		return CommandResult.newOKCommandResult();
	}

	/**
	 * Method getCreateCommand Gets the command given a request, source and target edit parts. (No semantic element required.)
	 * This method is similar to {@link CreateConnectionViewRequest#getCreateCommand(CreateConnectionViewRequest, EditPart, EditPart)}, except it
	 * fixes source and target locations
	 * 
	 * @param request
	 *        creation request
	 * @param sourceEditPart
	 *        source edit part
	 * @param targetEditPart
	 *        target edit part
	 * @return <code>Command</code> to create the connection at appropriate locations
	 */
	protected Command getCreateCommand(CreateConnectionViewRequest request, EditPart sourceEditPart, EditPart targetEditPart) {
		EditPart newSourceEditPart = sourceEditPart;
		// set appropriated source edit part
		if(sourceEditPart instanceof LifelineEditPart && sourceLocation != null) {
			newSourceEditPart = SequenceUtil.findPartToReconnectTo((LifelineEditPart)sourceEditPart, sourceLocation);
		}
		EditPart newTargetEditPart = targetEditPart;
		// set appropriated target edit part
		if(targetEditPart instanceof LifelineEditPart && targetLocation != null) {
			newTargetEditPart = SequenceUtil.findPartToReconnectTo((LifelineEditPart)targetEditPart, targetLocation);
		}

		Assert.isNotNull(request);
		Assert.isNotNull(sourceEditPart);
		Assert.isNotNull(targetEditPart);
		Assert.isNotNull(newSourceEditPart);
		Assert.isNotNull(newTargetEditPart);

		request.setSourceEditPart(sourceEditPart);
		request.setTargetEditPart(targetEditPart);

		request.setType(RequestConstants.REQ_CONNECTION_START);
		// set source location
		request.setLocation(sourceLocation);
		newSourceEditPart.getCommand(request);

		request.setType(RequestConstants.REQ_CONNECTION_END);
		// set target location
		request.setLocation(targetLocation);
		return newTargetEditPart.getCommand(request);
	}

	/**
	 * Set the locations where source and target points must be drawn.
	 * 
	 * @param sourcePoint
	 *        point where to draw source or null
	 * @param targetPoint
	 *        point where to draw target or null
	 */
	public void setLocations(Point sourcePoint, Point targetPoint) {
		sourceLocation = sourcePoint;
		targetLocation = targetPoint;
	}

	/**
	 * Handle the failure by reporting an adequate error message
	 * 
	 * @param createRequest
	 *        the creation request that didn't success
	 * @param sourceEditPart
	 *        the link source edit part
	 * @param targetEditPart
	 *        the target source edit part
	 */
	private void handleErrorMessage(CreateConnectionViewRequest createRequest, IGraphicalEditPart sourceEditPart, IGraphicalEditPart targetEditPart) {
		String hint = createRequest.getConnectionViewDescriptor().getSemanticHint();
		boolean isMessage = isMessageHint(hint);
		boolean uphill = sourceLocation != null && targetLocation != null && sourceLocation.y > targetLocation.y;
		if(isMessage && uphill) {
			reportCanNotDropUphillMessage(sourceLocation.y - targetLocation.y, sourceEditPart, targetEditPart);
		} else {
			reportDefaultMessage(sourceEditPart, targetEditPart);
		}
	}

	/**
	 * Test if hint is for a message creation
	 * 
	 * @param hint
	 *        hint to test
	 * @return true if message hint
	 */
	private boolean isMessageHint(String hint) {
		List<String> messageHints = new ArrayList<String>(7);
		String messageHint = ((IHintedType)UMLElementTypes.Message_4003).getSemanticHint();
		messageHints.add(messageHint);
		messageHint = ((IHintedType)UMLElementTypes.Message_4004).getSemanticHint();
		messageHints.add(messageHint);
		messageHint = ((IHintedType)UMLElementTypes.Message_4005).getSemanticHint();
		messageHints.add(messageHint);
		messageHint = ((IHintedType)UMLElementTypes.Message_4006).getSemanticHint();
		messageHints.add(messageHint);
		messageHint = ((IHintedType)UMLElementTypes.Message_4007).getSemanticHint();
		messageHints.add(messageHint);
		messageHint = ((IHintedType)UMLElementTypes.Message_4008).getSemanticHint();
		messageHints.add(messageHint);
		messageHint = ((IHintedType)UMLElementTypes.Message_4009).getSemanticHint();
		messageHints.add(messageHint);
		return messageHints.contains(hint);
	}

	/**
	 * Report a message telling that the message can not be dropped because it goes uphill.
	 * 
	 * @param delta
	 *        the missing delta between the two lifelines
	 * @param sourceEditPart
	 *        the source of the message
	 * @param targetEditPart
	 *        the target of the message
	 */
	private void reportCanNotDropUphillMessage(int delta, IGraphicalEditPart sourceEditPart, IGraphicalEditPart targetEditPart) {
		EObject source = sourceEditPart.resolveSemanticElement();
		String sourceText = EMFCoreUtil.getQualifiedName(source, true);
		EObject target = targetEditPart.resolveSemanticElement();
		String targetText = EMFCoreUtil.getQualifiedName(target, true);
		String txt = NLS.bind(Messages.DropError_UphillMessageTxt, new Object[]{ sourceText, targetText, delta });
		NotificationBuilder notif = NotificationBuilder.createAsyncPopup(Messages.DropError_UphillMessageTitle, txt);
		notif.setType(Type.WARNING);
		notif.run();
	}

	/**
	 * Report a message telling that the link drop unexpectedly failed.
	 * 
	 * @param sourceEditPart
	 *        the source of the link
	 * @param targetEditPart
	 *        the target of the link
	 */
	private void reportDefaultMessage(IGraphicalEditPart sourceEditPart, IGraphicalEditPart targetEditPart) {
		EObject source = sourceEditPart.resolveSemanticElement();
		String sourceText = EMFCoreUtil.getQualifiedName(source, true);
		EObject target = targetEditPart.resolveSemanticElement();
		String targetText = EMFCoreUtil.getQualifiedName(target, true);
		String txt = NLS.bind(Messages.DropError_DefaultTxt, sourceText, targetText);
		NotificationBuilder notif = NotificationBuilder.createAsyncPopup(Messages.DropError_DefaultTitle, txt);
		notif.setType(Type.ERROR);
		notif.run();
	}

}
