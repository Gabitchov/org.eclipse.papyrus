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
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.message.xtext.ui.contributions;


import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.extensionpoints.editors.ui.IPopupEditorHelper;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.gmfdiag.xtext.glue.PopupEditorConfiguration;
import org.eclipse.papyrus.infra.gmfdiag.xtext.glue.edit.part.DefaultXtextSemanticValidator;
import org.eclipse.papyrus.infra.gmfdiag.xtext.glue.edit.part.IXtextEMFReconciler;
import org.eclipse.papyrus.uml.textedit.message.xtext.ui.internal.UmlMessageActivator;
import org.eclipse.papyrus.uml.textedit.message.xtext.umlMessage.MessageRule;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Message;

import com.google.inject.Injector;



// TODO: Auto-generated Javadoc
/**
 * The Class MessagePopupEditor.
 */
public class MessagePopupEditor extends PopupEditorConfiguration {

	/**
	 * Instantiates a new message popup editor.
	 */
	public MessagePopupEditor() {
		super();
	}

	/** The message. */
	private Message message;

	/** The new name. */
	private String newName = "";

	/** The new sequence term list. */
	private String newSequenceTermList = "";

	//private org.eclipse.uml2.uml.VisibilityKind newVisibility ;



	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.xtext.glue.PopupEditorConfiguration#getTextToEdit(java.lang.Object)
	 * 
	 * @param editedObject
	 * @return the text to edit
	 */

	@SuppressWarnings("rawtypes")
	@Override
	public String getTextToEdit(Object editedObject) {

		if(editedObject instanceof Message) {
			String texttoedit = ((Message)editedObject).getName().trim();


			Interaction interaction = ((Message)editedObject).getInteraction();

			int sequencenumber = 0;
			for(Iterator it = interaction.getMessages().iterator(); it.hasNext();) {
				sequencenumber++;
				Message childElement = (Message)it.next();
				if(childElement.equals(editedObject)) {
					if((texttoedit.charAt(0) >= 48) && (texttoedit.charAt(0) <= 57)) {
						return texttoedit;
					} else {
						return texttoedit = sequencenumber + ":" + texttoedit;
					}
				}
			}
		}

		return "not a Message";
	}


	/**
	 * @see org.eclipse.papyrus.infra.gmfdiag.xtext.glue.PopupEditorConfiguration#createPopupEditorHelper(java.lang.Object)
	 * 
	 * @param editPart
	 * @return the popup editor helper
	 */

	@Override
	public IPopupEditorHelper createPopupEditorHelper(Object editPart) {
		// resolves the edit part, and the associated semantic element
		IGraphicalEditPart graphicalEditPart = null;
		if(!(editPart instanceof IGraphicalEditPart)) {
			return null;
		}
		graphicalEditPart = (IGraphicalEditPart)editPart;
		if(!(graphicalEditPart.getTopGraphicEditPart().resolveSemanticElement() instanceof Message)) {
			return null;
		}
		message = (Message)graphicalEditPart.getTopGraphicEditPart().resolveSemanticElement();
		// retrieves the XText injector
		Injector injector = UmlMessageActivator.getInstance().getInjector("org.eclipse.papyrus.uml.textedit.message.xtext.UmlMessage");

		// builds the text content and extension for a temporary file, to be edited by the xtext editor
		String textToEdit = "" + this.getTextToEdit(message);
		String fileExtension = "" + ".umlmessage";

		// builds a new IXtextEMFReconciler.
		// Its purpose is to extract any relevant information from the textual specification,
		// and then merge it in the context UML model if necessary
		IXtextEMFReconciler reconciler = new IXtextEMFReconciler() {

			public void reconcile(EObject modelObject, EObject xtextObject) {
				// first: retrieves / determines if the xtextObject is a MessageRule object
				EObject modifiedObject = xtextObject;
				if(!(modelObject instanceof Message)) {
					return;
				}
				while(xtextObject != null && !(xtextObject instanceof MessageRule)) {
					modifiedObject = modifiedObject.eContainer();
				}
				if(modifiedObject == null) {
					return;
				}
				MessageRule messageRuleObject = (MessageRule)xtextObject;

				// Retrieves the information to be populated in modelObject
				newName = "" + messageRuleObject.getName();


				int ocnumber = messageRuleObject.getSequenceTerm().get(0).getSequencialOrder();


				String ocname = "";

				newSequenceTermList = "";
				int i = 0;
				String recurrence;
				for(i = 0; i < messageRuleObject.getSequenceTerm().size(); i++) {
					if(messageRuleObject.getSequenceTerm().get(i).getSequenceName() != null) {
						ocname = messageRuleObject.getSequenceTerm().get(i).getSequenceName().toString();
					}
					ocnumber = messageRuleObject.getSequenceTerm().get(i).getSequencialOrder();
					if(messageRuleObject.getSequenceTerm().get(i).getRecurrence() != null) {
						recurrence = messageRuleObject.getSequenceTerm().get(i).getRecurrence().trim();
					}
					if((i == 0)) {
						newSequenceTermList = newSequenceTermList + ocnumber + ocname;
					} else {
						newSequenceTermList = newSequenceTermList + '.' + ocnumber + ocname;
					}
				}

				// Creates and executes the update command
				UpdateUMLMessageCommand updateCommand = new UpdateUMLMessageCommand(message);

				TransactionalEditingDomain domain = getEditingDomain(modelObject);
				domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(updateCommand));

			}



		};
		return super.createPopupEditorHelper(graphicalEditPart, injector, reconciler, textToEdit, fileExtension, new DefaultXtextSemanticValidator());
	}

	/**
	 * The Class UpdateUMLMessageCommand.
	 */
	protected class UpdateUMLMessageCommand extends org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand {

		/** The message. */
		private Message message;

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor
		 * , org.eclipse.core.runtime.IAdaptable)
		 */
		/**
		 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
		 *      org.eclipse.core.runtime.IAdaptable)
		 * 
		 * @param arg0
		 * @param arg1
		 * @return
		 * @throws ExecutionException
		 */

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor arg0, IAdaptable arg1) throws ExecutionException {


			this.message.setName(newSequenceTermList + ':' + newName);

			return CommandResult.newOKCommandResult(message);
		}

		/**
		 * Instantiates a new update uml message command.
		 * 
		 * @param message
		 *        the message
		 */
		public UpdateUMLMessageCommand(Message message) {
			super(MessagePopupEditor.getEditingDomain(message), "Message Update", getWorkspaceFiles(message));
			this.message = message;
		}

	}

	static TransactionalEditingDomain getEditingDomain(EObject context) {
		try {
			return ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(context);
		} catch (ServiceException ex) {
			ex.printStackTrace(System.err);
		}
		return null;
	}

}
