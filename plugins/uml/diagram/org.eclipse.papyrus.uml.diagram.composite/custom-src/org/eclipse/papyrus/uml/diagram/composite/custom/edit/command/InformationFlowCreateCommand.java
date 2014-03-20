/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.composite.custom.edit.command;

import java.util.ArrayList;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.extensionpoints.editors.Activator;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.ui.ExtendedDirectEditionDialog;
import org.eclipse.papyrus.extensionpoints.editors.utils.DirectEditorsUtil;
import org.eclipse.papyrus.extensionpoints.editors.utils.IDirectEditorsIds;
import org.eclipse.papyrus.uml.diagram.composite.custom.messages.Messages;
import org.eclipse.papyrus.uml.diagram.composite.custom.ui.InformationItemElementTreeSelectionDialog;
import org.eclipse.papyrus.uml.diagram.composite.custom.ui.InformationItemValidator;
import org.eclipse.papyrus.uml.diagram.composite.custom.ui.NameLabelValidator;
import org.eclipse.papyrus.uml.diagram.composite.providers.ElementInitializers;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InformationFlow;
import org.eclipse.uml2.uml.InformationItem;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * <pre>
 * This class provides a custom creation command for InformationFlow
 * InformationFlow are references toward any {@link InformationItem} in the model
 * </pre>
 */
public class InformationFlowCreateCommand extends org.eclipse.papyrus.uml.diagram.composite.edit.commands.InformationFlowCreateCommand {

	public InformationFlowCreateCommand(CreateRelationshipRequest request, EObject source, EObject target) {
		super(request, source, target);

	}

	/**
	 * <pre>
	 *  The method executes the creation :
	 *  - opens a selection dialog to choose {@link InformationItem} or {@link Classifier} reference as a convoyed Classifier
	 *   by the {@link InformationFlow} type
	 *  - create the InformationFlow between the source and the target
	 *  
	 * {@inheritDoc}
	 * </pre>
	 */
	@Override
	protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {

		// Create and open the selection dialog
		AdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		Shell currentShell = new Shell(Display.getCurrent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		InformationItemElementTreeSelectionDialog dialog = new InformationItemElementTreeSelectionDialog(currentShell, new AdapterFactoryLabelProvider(adapterFactory), new AdapterFactoryContentProvider(adapterFactory));

		// Set dialog parameters
		dialog.setTitle(Messages.InformationFlowSelectionDialog_Title);
		dialog.setMessage(Messages.InformationFlowSelectionDialog_Message);
		dialog.setAllowMultiple(true);
		dialog.setHelpAvailable(false);
		dialog.setInput(getSource().getModel());
		dialog.setValidator(new InformationItemValidator());

		ArrayList<Classifier> initialSelection = new ArrayList<Classifier>();

		// here the dialog.getReturnCode is IDialogConstants.OK_ID
		while(dialog.open() != IDialogConstants.CANCEL_ID) {

			/*
			 * If classifiers have been selected, complete command execution and write the selection
			 * in the conveyed:Classifief Association
			 */
			if(dialog.getReturnCode() == ElementTreeSelectionDialog.OK) {
				Object[] conveyedClassified = dialog.getResult();

				InformationFlow newInformationFlow = UMLFactory.eINSTANCE.createInformationFlow();
				getContainer().getPackagedElements().add(newInformationFlow);
				newInformationFlow.getInformationSources().add(getSource());
				newInformationFlow.getInformationTargets().add(getTarget());

				// add the classifier in the list of conveyed Classifier
				for(int i = 0; i < conveyedClassified.length; i++) {
					newInformationFlow.getConveyeds().add((Classifier)conveyedClassified[i]);
				}

				ElementInitializers.getInstance().init_InformationFlow_4021(newInformationFlow);

				((CreateElementRequest)getRequest()).setNewElement(newInformationFlow);
				return CommandResult.newOKCommandResult(newInformationFlow);

			} else if(dialog.getReturnCode() == InformationItemElementTreeSelectionDialog.newInformationItemButton_ID) {
				// create a new InformationItem
				initialSelection.add((Classifier)createNewInformationItem());
				dialog.setInitialElementSelections(initialSelection);
			}
		}// end of while()

		// No Classifier selected: abort element creation
		return CommandResult.newCancelledCommandResult();
	}

	/**
	 * - Create a new {@link InformationItem}
	 * 
	 * - Ask for the {@link InformationItem}'s name
	 * 
	 * @return the new InformationItem or null if canceled
	 */

	// TODO should be moved?
	private InformationItem createNewInformationItem() {
		// create the new InformationItem
		InformationItem infoItem = UMLFactory.eINSTANCE.createInformationItem();
		getContainer().getPackagedElements().add(infoItem);
		ElementInitializers.getInstance().init_InformationItem_2080(infoItem);

		// ask for the name of the new InformationItem
		// Create the editor
		Shell currentShell = new Shell(Display.getCurrent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		IDirectEditorConfiguration configuration;// = new DefaultDirectEditorConfiguration();
		String languagePreferred = Activator.getDefault().getPreferenceStore().getString(IDirectEditorsIds.EDITOR_FOR_ELEMENT + infoItem.eClass().getInstanceClassName());
		configuration = DirectEditorsUtil.findEditorConfiguration(languagePreferred, infoItem.eClass().getInstanceClassName());
		configuration.preEditAction(infoItem);
		configuration.setInputValidator(new NameLabelValidator(Messages.InformationItemGetNameDialog_Error_Message));
		ExtendedDirectEditionDialog dialog = new ExtendedDirectEditionDialog(currentShell, infoItem, infoItem.getName(), configuration);

		dialog.open();

		if(dialog.getReturnCode() == Window.CANCEL) {
			// We delete the newInformationItem
			int index = getContainer().getPackagedElements().indexOf(infoItem);
			getContainer().getPackagedElements().remove(index);
			return null;
		} else {
			infoItem.setName(dialog.getValue());
			((CreateElementRequest)getRequest()).setNewElement(infoItem);
			return infoItem;
		}
	}

}
