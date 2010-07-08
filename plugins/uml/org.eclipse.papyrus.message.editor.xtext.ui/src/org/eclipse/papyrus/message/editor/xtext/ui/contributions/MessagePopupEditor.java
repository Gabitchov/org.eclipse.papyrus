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
package org.eclipse.papyrus.message.editor.xtext.ui.contributions;


import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.extensionpoints.editors.ui.IPopupEditorHelper;
import org.eclipse.papyrus.log.LogHelper;
import org.eclipse.papyrus.message.editor.xtext.scoping.UmlMessageScopeProvider;
import org.eclipse.papyrus.message.editor.xtext.ui.editor.ContextEditorUtil;
import org.eclipse.papyrus.message.editor.xtext.ui.internal.UmlMessageActivator;
import org.eclipse.papyrus.message.editor.xtext.umlMessage.MessageRule;
import org.eclipse.papyrus.properties.runtime.Activator;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Message;
import org.eclipse.xtext.gmf.glue.PopupEditorConfiguration;
import org.eclipse.xtext.gmf.glue.edit.part.IEObjectContextUpdater;
import org.eclipse.xtext.gmf.glue.edit.part.IXTextEditorContextUpdater;
import org.eclipse.xtext.gmf.glue.edit.part.IXtextEMFReconciler;
import org.eclipse.xtext.ui.editor.XtextEditor;

import com.google.inject.Injector;



public class MessagePopupEditor extends PopupEditorConfiguration {

	public MessagePopupEditor() {
		super();
	}

	private Message message;

	private String newName = "";

	private String newSequenceTermList = "";

	//private org.eclipse.uml2.uml.VisibilityKind newVisibility ;



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
					if(((int)texttoedit.charAt(0) >= 48) && ((int)texttoedit.charAt(0) <= 57))

						return texttoedit;
					else
						return texttoedit = sequencenumber + ":" + texttoedit;
				}
			}
		}

		return "not a Message";
	}


	@Override
	public IPopupEditorHelper createPopupEditorHelper(Object editPart) {
		IGraphicalEditPart graphicalEditPart = null;
		if(!(editPart instanceof IGraphicalEditPart))
			return null;
		graphicalEditPart = (IGraphicalEditPart)editPart;
		if(!(graphicalEditPart.getTopGraphicEditPart().resolveSemanticElement() instanceof Message)) {
			return null;
		} //else System.out.print("semantic element message \n");
		message = (Message)graphicalEditPart.getTopGraphicEditPart().resolveSemanticElement();
		Injector injector = UmlMessageActivator.getInstance().getInjector("org.eclipse.papyrus.message.editor.xtext.UmlMessage");
		String textToEdit = "" + this.getTextToEdit(message);
		String fileExtension = "" + ".umlmessage";

		IEObjectContextUpdater eobjectContextUpdater = new IEObjectContextUpdater() {

			public void updateContext(EObject context) {
				UmlMessageScopeProvider.context = context;
			}
		};

		IXTextEditorContextUpdater xtextEditorContextUpdater = new IXTextEditorContextUpdater() {

			public void updateCurrentEditor(XtextEditor context) {
				ContextEditorUtil.currentEditor = context;
			}
		};

		IXtextEMFReconciler eobjectUpdater = new IXtextEMFReconciler() {

			public void reconcile(EObject modelObject, EObject xtextObject) {
				// first: retrieves / determines if the xtextObject is a MessageRule object
				EObject modifiedObject = xtextObject;
				if(!(modelObject instanceof Message))
					return;
				while(xtextObject != null && !(xtextObject instanceof MessageRule)) {
					modifiedObject = modifiedObject.eContainer();
				}
				if(modifiedObject == null)
					return;
				MessageRule messageRuleObject = (MessageRule)xtextObject;

				newName = "" + messageRuleObject.getName();

				//the following code is intended to remove the last characters in the new name, because the new name finishes by the first sequencenumber of the message!!!
				int ocnumber;
				ocnumber = messageRuleObject.getSequenceTerm().get(0).getSequencialOrder();
				double base10 = Math.log(10);
				int dignum = 1 + (int)(Math.log(ocnumber) / base10); //the number of digits in the first sequencenumber

				StringBuffer buffer = new StringBuffer(newName);
				buffer = buffer.reverse();
				for(int j = 0; j < dignum; j++) {
					buffer.deleteCharAt(0);
				}
				buffer.reverse();

				newName = buffer.toString();


				// 
				String ocname = "";

				newSequenceTermList = "";
				int i = 0;
				String recurrence;
				for(i = 0; i < messageRuleObject.getSequenceTerm().size(); i++) {
					if(messageRuleObject.getSequenceTerm().get(i).getSequenceName() != null)
						ocname = messageRuleObject.getSequenceTerm().get(i).getSequenceName().toString();
					ocnumber = messageRuleObject.getSequenceTerm().get(i).getSequencialOrder();
					if(messageRuleObject.getSequenceTerm().get(i).getRecurrence() != null)
						recurrence = messageRuleObject.getSequenceTerm().get(i).getRecurrence().trim();
					if((i == 0))
						newSequenceTermList = newSequenceTermList + ocnumber + ocname;
					else
						newSequenceTermList = newSequenceTermList + '.' + ocnumber + ocname;
				}


				UpdateUMLMessageCommand updateCommand = new UpdateUMLMessageCommand(message);

				try {
					OperationHistoryFactory.getOperationHistory().execute(updateCommand, new NullProgressMonitor(), null);
				} catch (ExecutionException e) {
					((LogHelper)Activator.log).error(e);
				}

			}



		};
		return super.createPopupEditorHelper(graphicalEditPart, injector, eobjectContextUpdater, xtextEditorContextUpdater, eobjectUpdater, textToEdit, fileExtension);
	}

	protected class UpdateUMLMessageCommand extends org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand {

		private Message message;

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor
		 * , org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor arg0, IAdaptable arg1) throws ExecutionException {


			this.message.setName(newSequenceTermList + ':' + newName);

			return CommandResult.newOKCommandResult(message);
		}

		public UpdateUMLMessageCommand(Message message) {
			super(EditorUtils.getTransactionalEditingDomain(), "Message Update", getWorkspaceFiles(message));
			this.message = message;
		}

	}

}
