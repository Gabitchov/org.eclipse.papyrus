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
 *  Saadia Dhouib saadia.dhouib@cea.fr  - Initial API and Implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.communication.custom.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
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



/**
 * The Class CommunicationDeferredCreateConnectionViewCommand is intended to create a new message link between two lifelines.
 * This class is only used in the case of Drop of a message
 */
public class CommunicationDeferredCreateConnectionViewCommand extends CommonDeferredCreateConnectionViewCommand {

	/** the element for the connection's label semantic element */
	protected EObject labelElement = null;


	/**
	 * Instantiates a new communication deferred create connection view command.
	 * 
	 * @param editingDomain
	 *        the editing domain
	 * @param semanticHint
	 *        the semantic hint
	 * @param sourceViewAdapter
	 *        the source view adapter
	 * @param targetViewAdapter
	 *        the target view adapter
	 * @param viewer
	 *        the viewer
	 * @param preferencesHint
	 *        the preferences hint
	 * @param viewDescriptor
	 *        the view descriptor
	 * @param command
	 *        the command
	 */
	public CommunicationDeferredCreateConnectionViewCommand(TransactionalEditingDomain editingDomain, String semanticHint, IAdaptable sourceViewAdapter, IAdaptable targetViewAdapter, EditPartViewer viewer, PreferencesHint preferencesHint, ConnectionViewDescriptor viewDescriptor, ICommand command, EObject labelElement) {
		super(editingDomain, semanticHint, sourceViewAdapter, targetViewAdapter, viewer, preferencesHint, viewDescriptor, command);
		this.labelElement = labelElement;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Creates a connection view between the source and target.
	 * 
	 * @param progressMonitor
	 *        the progress monitor
	 * @param info
	 *        the info
	 * @param sourceEditPart
	 *        the source edit part
	 * @param targetEditPart
	 *        the target edit part
	 * @return the command result
	 * @throws ExecutionException
	 *         the execution exception
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info, IGraphicalEditPart sourceEditPart, IGraphicalEditPart targetEditPart) throws ExecutionException {

		// If these are null, then the diagram's editparts may not
		// have been refreshed yet.
		Assert.isNotNull(sourceEditPart);
		Assert.isNotNull(targetEditPart);


		CreateConnectionViewRequest createRequest = new CreateConnectionViewRequest(viewDescriptor);
		createConnectionCmd = CreateConnectionViewRequest.getCreateCommand(createRequest, sourceEditPart, targetEditPart);

		if(createConnectionCmd.canExecute()) {
			createConnectionCmd.execute();
		}
		if(labelElement != null) {

			/*
			 * Code Commented to no more set the the semantic element of the connector
			 * 
			 * //Set element of the connector to Interaction !! This has to be changed in the next release, because it is incoherent !!!
			 * //If setElement(null) , I can not do the reorient anymore !!
			 * // View temp = (View)(createRequest.getConnectionViewDescriptor().getAdapter(View.class));
			 * // if(temp instanceof Connector) {
			 * // if(((View)((Connector)temp).getTarget().eContainer()).getElement() instanceof Interaction) {
			 * //
			 * ((View)(createRequest.getConnectionViewDescriptor().getAdapter(View.class))).setElement(((View)((Connector)temp).getTarget().eContainer
			 * ()).getElement());
			 * // } else {
			 * // ((View)(createRequest.getConnectionViewDescriptor().getAdapter(View.class))).setElement(null); // in this case, the reorient does
			 * not work anymore !! :((
			 * // }
			 * // }
			 */

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
						((View)(((View)(createRequest.getConnectionViewDescriptor().getAdapter(View.class))).getChildren().get(i))).setElement(labelElement);
						//System.err.println("VisualID  of MessageNameEditPart == VisualID of Child of connector view ");
					}
				}
			}

		}

		viewer = null;// for garbage collection
		return CommandResult.newOKCommandResult();
	}
}
