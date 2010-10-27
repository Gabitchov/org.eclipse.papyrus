package org.eclipse.papyrus.diagram.communication.custom.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.commands.CommonDeferredCreateConnectionViewCommand;
import org.eclipse.papyrus.diagram.communication.edit.parts.MessageNameEditPart;
import org.eclipse.papyrus.diagram.communication.part.UMLVisualIDRegistry;


public class CommunicationDeferredCreateConnectionViewCommand extends CommonDeferredCreateConnectionViewCommand {




	public CommunicationDeferredCreateConnectionViewCommand(TransactionalEditingDomain editingDomain, String semanticHint, IAdaptable sourceViewAdapter, IAdaptable targetViewAdapter, EditPartViewer viewer, PreferencesHint preferencesHint, ConnectionViewDescriptor viewDescriptor, ICommand command) {
		super(editingDomain, semanticHint, sourceViewAdapter, targetViewAdapter, viewer, preferencesHint, viewDescriptor, command);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Creates a connection view between the source and target.
	 * 
	 * @throws ExecutionException
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info, IGraphicalEditPart sourceEditPart, IGraphicalEditPart targetEditPart) throws ExecutionException {

		// If these are null, then the diagram's editparts may not
		// have been refreshed yet.
		Assert.isNotNull(sourceEditPart);
		Assert.isNotNull(targetEditPart);

		// use the String semanticHint to create a view
		// modification in order to fix the bug
		CreateConnectionViewRequest createRequest = new CreateConnectionViewRequest(viewDescriptor);
		createConnectionCmd = CreateConnectionViewRequest.getCreateCommand(createRequest, sourceEditPart, targetEditPart);

		if(createConnectionCmd.canExecute()) {
			createConnectionCmd.execute();
		}
		if(element != null) {
			//setElement of the connector to null
			((View)(createRequest.getConnectionViewDescriptor().getAdapter(View.class))).setElement(null);

			//set element of the label of the connector to element
			if(((View)(createRequest.getConnectionViewDescriptor().getAdapter(View.class))).getChildren().size() > 1) {

				for(int i = 0; i < ((View)(createRequest.getConnectionViewDescriptor().getAdapter(View.class))).getChildren().size(); i++) {
					// ---------------------------------------------------------
					// help to debug
					//System.err.println("Child of connector view :" + (((View)(createRequest.getConnectionViewDescriptor().getAdapter(View.class))).getChildren().get(i)));
					//System.err.println("VisualID of Child of connector view :" + UMLVisualIDRegistry.getType(MessageNameEditPart.VISUAL_ID));
					//System.err.println("VisualID  of MessageNameEditPart :" + ((View)(((View)(createRequest.getConnectionViewDescriptor().getAdapter(View.class))).getChildren().get(i))).getType());
					// ---------------------------------------------------------
					if(((View)(((View)(createRequest.getConnectionViewDescriptor().getAdapter(View.class))).getChildren().get(i))).getType().equals(UMLVisualIDRegistry.getType(MessageNameEditPart.VISUAL_ID))) {//this is the label that coresponds to the message
						((View)(((View)(createRequest.getConnectionViewDescriptor().getAdapter(View.class))).getChildren().get(i))).setElement(element);
						System.err.println("VisualID  of MessageNameEditPart == VisualID of Child of connector view ");
					}
				}
			}

		}

		viewer = null;// for garbage collection
		return CommandResult.newOKCommandResult();
	}
}
