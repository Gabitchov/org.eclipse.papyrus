/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.uml.diagram.common.dialogs.CreateOrShowExistingLinkDialog;
import org.eclipse.papyrus.uml.diagram.common.messages.Messages;
import org.eclipse.papyrus.uml.diagram.common.util.EdgeEndsMapper;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * 
 * This class provides command to restore existing link instead of create new ones
 * 
 * 
 * 
 * @author VL222926
 * 
 */
public class CreateOrShowExistingElementHelper {


	/**
	 * the link helper to use. Will be used in the future
	 */
	protected final ILinkMappingHelper linkMappingHelper;

	/**
	 * preferences used to know if the dialog must be displayed or not
	 */
	public static final String DISPLAY_DIALOG_FOR_CREATE_OR_RESTORE_ELEMENT = "Display Dialog For Create Or Restore Element"; //$NON-NLS-1$

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public CreateOrShowExistingElementHelper() {
		this(new ILinkMappingHelper() {

			public Collection<?> getTarget(Element link) {
				return LinkMappingHelper.getTarget(link);
			}

			public Collection<?> getSource(Element link) {
				return LinkMappingHelper.getSource(link);
			}
		});
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param linkHelper
	 *        the mapping helper to use to find sources and targets
	 */
	public CreateOrShowExistingElementHelper(final ILinkMappingHelper linkHelper) {
		this.linkMappingHelper = linkHelper;
	}

	/**
	 * 
	 * @param req
	 *        the create request
	 * @param defaultCommand
	 *        the default command for this request
	 * @param existingElements
	 *        the list of the link already existing between the source and the target for this kind of link
	 * @return
	 */
	public Command getCreateOrRestoreElementCommand(final CreateRelationshipRequest req, final Command defaultCommand, final IElementType linkElementType) {
		if(showDialogAccordingPreferences() && defaultCommand.canExecute()) {
			final EObject container = req.getContainer();
			if(container instanceof Element) {
				final List<EdgeEndsMapper> existingElements = getExistingLinksBetweenSourceAndTarget(req, linkElementType);
				if(existingElements.size() > 0) {
					final String className = getIElementTypeNameToDisplay(linkElementType);
					final String dialogTitle = NLS.bind(Messages.CreateOrShowExistingElementHelper_CreateOrRestoreX, className);
					final String dialogMessage = NLS.bind(Messages.CreateOrShowExistingElementHelper_XBetweenTheseElementAlreadyExists, className);
					CreateOrShowExistingLinkDialog dialog = new CreateOrShowExistingLinkDialog(dialogTitle, dialogMessage, existingElements);
					return new ICommandProxy(getOpenLinkDialogCommand(req, defaultCommand, dialog, existingElements));
				}
			}
		}
		return defaultCommand;
	}

	/**
	 * 
	 * @param element
	 *        an element
	 * @param elementType
	 *        an element type
	 * @return
	 *         <code>true</code> if the element has the wanted type according to the element type
	 */
	protected boolean hasWantedType(final EObject element, final IElementType elementType) {
		return element.eClass() == elementType.getEClass();
	}

	/**
	 * Returns the preferences AND Create the preference if it doesn't yet exist
	 * 
	 * @return
	 *         the preference to know if a dialog must ask to the use if he wants create a new edge or restore an existing edge
	 */
	protected boolean showDialogAccordingPreferences() {
		final IPreferenceStore store = org.eclipse.papyrus.uml.diagram.common.Activator.getDefault().getPreferenceStore();
		boolean contains = store.contains(DISPLAY_DIALOG_FOR_CREATE_OR_RESTORE_ELEMENT);
		if(!contains) {
			store.setValue(DISPLAY_DIALOG_FOR_CREATE_OR_RESTORE_ELEMENT, MessageDialogWithToggle.ALWAYS);
			store.setDefault(DISPLAY_DIALOG_FOR_CREATE_OR_RESTORE_ELEMENT, MessageDialogWithToggle.NEVER);
		}
		return store.getString(DISPLAY_DIALOG_FOR_CREATE_OR_RESTORE_ELEMENT).equals(MessageDialogWithToggle.ALWAYS);
	}

	/**
	 * 
	 * @param elementType
	 *        an element type
	 * @return
	 *         the element type to display in the dialog
	 */
	protected String getIElementTypeNameToDisplay(final IElementType elementType) {
		return elementType.getEClass().getName();
	}

	/**
	 * 
	 * @param request
	 *        the request to create the element
	 * @param wantedEClass
	 * @return
	 *         a list of {@link EdgeEndsMapper} referencing the existing links between the source and the target
	 */
	protected List<EdgeEndsMapper> getExistingLinksBetweenSourceAndTarget(final CreateRelationshipRequest request, final IElementType wantedElementType) {
		final List<EdgeEndsMapper> existingElement = new ArrayList<EdgeEndsMapper>();
		for(final Element current : ((Element)request.getContainer()).getOwnedElements()) {
			if(hasWantedType(current, wantedElementType)) {
				final Collection<?> sources = this.linkMappingHelper.getSource(current);
				final Collection<?> targets = this.linkMappingHelper.getTarget(current);
				if(sources.contains(request.getSource()) && targets.contains(request.getTarget())) {
					final EClass wantedEClass = wantedElementType.getEClass();
					if((wantedEClass == UMLPackage.eINSTANCE.getConnector()) || (wantedEClass == UMLPackage.eINSTANCE.getAssociation())) {
						existingElement.add(new EdgeEndsMapper(current, sources, null, null));
					} else {
						existingElement.add(new EdgeEndsMapper(current, null, sources, targets));
					}
				}
			}
		}
		return existingElement;
	}

	/**
	 * 
	 * @param request
	 *        the request (can't be <code>null</code>)
	 * @param defaultCommand
	 *        the default command to use to create the semantic element (can't be <code>null</code>)
	 * @param dialog
	 *        the dialog to open (can't be <code>null</code>)
	 * @param existingEObject
	 *        the list of the existing objects (can't be null, neither empty
	 * @return
	 *         the command to open the dialog AND do the selected action
	 */
	public static final ICommand getOpenLinkDialogCommand(final CreateRelationshipRequest request, final Command defaultCommand, final CreateOrShowExistingLinkDialog dialog, final List<EdgeEndsMapper> existingEObject) {
		final AbstractTransactionalCommand compoundCommand = new AbstractTransactionalCommand(request.getEditingDomain(), "", null) { //$NON-NLS-1$

			/**
			 * 
			 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
			 *      org.eclipse.core.runtime.IAdaptable)
			 * 
			 * @param monitor
			 * @param info
			 * @return
			 * @throws ExecutionException
			 */
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				int result = dialog.open();
				switch(result) {
				case CreateOrShowExistingLinkDialog.CREATE:
					//we execute the default command
					defaultCommand.execute();
					return CommandResult.newOKCommandResult(request.getNewElement());
				case CreateOrShowExistingLinkDialog.RESTORE_SELECTED_LINK:
					final EObject selectedElement = dialog.getResult();
					if(selectedElement != null) {//must always be true
						request.setNewElement(selectedElement);
						return CommandResult.newOKCommandResult(selectedElement);
					} else {
						return CommandResult.newErrorCommandResult("The selected element in the dialog is null"); //$NON-NLS-1$
					}
				default:
					return CommandResult.newCancelledCommandResult();
				}
			}

			/**
			 * 
			 * @see org.eclipse.core.commands.operations.AbstractOperation#canExecute()
			 * 
			 * @return
			 */
			@Override
			public boolean canExecute() {
				return defaultCommand.canExecute();
			}
		};
		return compoundCommand;
	}

	/**
	 * 
	 * @return
	 *         the link mapping helper to use
	 */
	public ILinkMappingHelper getLinkMappingHelper() {
		return linkMappingHelper;
	}

}
