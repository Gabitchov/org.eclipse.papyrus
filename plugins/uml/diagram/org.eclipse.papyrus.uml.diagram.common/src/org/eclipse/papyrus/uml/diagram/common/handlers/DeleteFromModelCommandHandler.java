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
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.handlers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.core.resource.IReadOnlyHandler;
import org.eclipse.papyrus.infra.emf.readonly.ReadOnlyManager;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.NotationHelper;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.swt.widgets.Display;

import com.google.common.base.Optional;

/**
 * Command handler for delete from diagram
 */
public class DeleteFromModelCommandHandler extends GraphicalCommandHandler implements IHandler {

	@Override
	protected Command getCommand() {

		TransactionalEditingDomain editingDomain = getEditingDomain();

		if(editingDomain == null) {
			return UnexecutableCommand.INSTANCE;
		}

		// Retrieve currently selected IGraphicalEditPart(s)
		List<IGraphicalEditPart> editParts = getSelectedElements();
		if(editParts.isEmpty()) {
			return UnexecutableCommand.INSTANCE;
		}

		// Iterate over selection and retrieve the deletion command from each
		// edit part
		// Add each returned command to the composite command
		CompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain, "Delete From Model");

		Iterator<IGraphicalEditPart> it = editParts.iterator();
		while(it.hasNext()) {
			IGraphicalEditPart editPart = it.next();

			if(!(editPart instanceof DiagramEditPart)) {
				// Look for the GMF deletion command
				Command curCommand = editPart.getCommand(new EditCommandRequestWrapper(new DestroyElementRequest(false)));
				if(curCommand != null) {
					command.compose(new CommandProxy(curCommand));
				}
			}
		}

		if(command.isEmpty()) {
			return UnexecutableCommand.INSTANCE;
		}

		return new ICommandProxy(command);
	}

	@Override
	protected boolean computeEnabled() {
		TransactionalEditingDomain editingDomain = getEditingDomain();
		IReadOnlyHandler readOnly = ReadOnlyManager.getReadOnlyHandler(editingDomain);

		for(IGraphicalEditPart editPart : getSelectedElements()) {
			EObject semantic = EMFHelper.getEObject(editPart);

			View graphical = NotationHelper.findView(editPart);

			if(readOnly != null) {
				List<URI> uris = new LinkedList<URI>();
				if(semantic == null || semantic == graphical) {
					return false;
				} else {
					if(semantic.eContainer() == null) {
						//Do not delete root semantic element
						return false;
					}
					uris.add(EcoreUtil.getURI(semantic));
				}

				if(graphical != null) {
					uris.add(EcoreUtil.getURI(graphical));
				}

				Optional<Boolean> result = readOnly.anyReadOnly(uris.toArray(new URI[uris.size()]));
				if(result.isPresent() && result.get()) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.handlers.GraphicalCommandHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if(canDoAction()) {//the key binding for Delete and Hide action changed, so we display a message for the users. TODO: Remove for Luna
			return super.execute(event);
		}
		return null;
	}

	private static final String DISPLAY_MESSAGE_FOR_DELETE_ACTION_PREFERENCE_KEY = "displayMessageForDeleteActionPreferenceKey";

	/**
	 * 
	 * @return
	 *         <code>true</code> if the action can be done
	 */
	//TODO: Remove for Luna
	protected boolean canDoAction() {
		final IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		boolean contains = store.contains(DISPLAY_MESSAGE_FOR_DELETE_ACTION_PREFERENCE_KEY);
		if(!contains) {
			store.setValue(DISPLAY_MESSAGE_FOR_DELETE_ACTION_PREFERENCE_KEY, MessageDialogWithToggle.NEVER);
			store.setDefault(DISPLAY_MESSAGE_FOR_DELETE_ACTION_PREFERENCE_KEY, MessageDialogWithToggle.NEVER);
		}
		final String hideValue = store.getString(DISPLAY_MESSAGE_FOR_DELETE_ACTION_PREFERENCE_KEY);
		if(!hideValue.equals(MessageDialogWithToggle.ALWAYS)) {

			final MessageDialogWithToggle toggle = MessageDialogWithToggle.openYesNoQuestion(Display.getDefault().getActiveShell(), "Delete Action", "WARNING! The Shorcuts for Hide and Delete actions have changed. \n \n Do you really want to delete an element of the model?", "Don't show this dialog the next time", false, store, DISPLAY_MESSAGE_FOR_DELETE_ACTION_PREFERENCE_KEY);
			int returnCode = toggle.getReturnCode();
			if(returnCode != IDialogConstants.YES_ID) {
				return false;
			}
		}
		return true;
	}
}
