/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.service.palette;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.util.EditPartUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.command.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.diagram.common.service.IPapyrusPaletteConstant;
import org.eclipse.papyrus.diagram.common.wizards.PaletteEntryProxy;
import org.eclipse.papyrus.umlutils.ui.helper.AppliedStereotypeHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.uml2.uml.Profile;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Post action that manages the display of applied stereotypes.
 */
public class DisplayAppliedStereotypePostAction extends GraphicalPostAction {

	/** list of stereotypes to display with their names */
	protected List<String> stereotypesToDisplay = new ArrayList<String>();

	/** list of stereotypes to display with their qualified names */
	protected List<String> stereotypesQNToDisplay = new ArrayList<String>();

	/** entry proxy "parent" of this action when configuring the action */
	protected PaletteEntryProxy entryProxy;

	/** list of applied profiles */
	protected List<Profile> appliedProfiles;

	/**
	 * @{inheritDoc
	 */
	@Override
	public void init(Node configurationNode, IAspectActionProvider factory) {
		super.init(configurationNode, factory);
		if(configurationNode == null) {
			return;
		}
		NodeList childNodes = configurationNode.getChildNodes();
		for(int i = 0; i < childNodes.getLength(); i++) {
			String nodeName = childNodes.item(i).getNodeName();
			if("displayName".equals(nodeName)) {
				Node stereotypeNameNode = childNodes.item(i).getAttributes().getNamedItem(IPapyrusPaletteConstant.NAME);
				if(stereotypeNameNode != null) {
					stereotypesToDisplay.add(stereotypeNameNode.getNodeValue());
				}
			} else if("displayQualifiedName".equals(nodeName)) {
				Node stereotypeNameNode = childNodes.item(i).getAttributes().getNamedItem(IPapyrusPaletteConstant.NAME);
				if(stereotypeNameNode != null) {
					stereotypesQNToDisplay.add(stereotypeNameNode.getNodeValue());
				}
			}
		}
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	public void run(EditPart editPart) {

		final CompositeCommand compositeCommand = new CompositeCommand("Modify Stereotype Display");
		View view = (View)editPart.getModel();
		TransactionalEditingDomain editingDomain = org.eclipse.papyrus.core.utils.EditorUtils.getTransactionalEditingDomain();

		// creates the commands to display simple stereotypes name
		for(String stereotypeName : stereotypesToDisplay) {
			String presentationKind = AppliedStereotypeHelper.getAppliedStereotypePresentationKind(view);
			RecordingCommand command = AppliedStereotypeHelper.getAddAppliedStereotypeCommand(editingDomain, view, stereotypeName, presentationKind);
			compositeCommand.add(new EMFtoGMFCommandWrapper(command));
		}

		// creates the commands to display qualified names of stereotypes 
		for(String stereotypeName : stereotypesQNToDisplay) {
			RecordingCommand command = AppliedStereotypeHelper.getAddAppliedStereotypeToDisplayWithQNCommand(editingDomain, view, stereotypeName);
			compositeCommand.add(new EMFtoGMFCommandWrapper(command));
		}
		compositeCommand.reduce();

		if(compositeCommand.canExecute()) {
			boolean isActivating = true;
			Map<String, Boolean> options = null;
			// use the viewer to determine if we are still initializing the diagram
			// do not use the DiagramEditPart.isActivating since ConnectionEditPart's
			// parent will not be a diagram edit part
			EditPartViewer viewer = editPart.getViewer();
			if(viewer instanceof DiagramGraphicalViewer) {
				isActivating = ((DiagramGraphicalViewer)viewer).isInitializing();
			}

			if(isActivating || !EditPartUtil.isWriteTransactionInProgress((IGraphicalEditPart)editPart, false, false)) {
				options = Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE);
			}

			AbstractEMFOperation operation = new AbstractEMFOperation(((IGraphicalEditPart)editPart).getEditingDomain(), StringStatics.BLANK, options) {

				protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

					compositeCommand.execute(monitor, info);

					return Status.OK_STATUS;
				}
			};
			try {
				operation.execute(new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				Activator.log.error(e);
			}
		} else {
			Activator.log.error("Impossible to execute graphical post action " + propertiesToUpdate, null);
		}
	}

	/**
	 * @{inheritDoc
	 */
	@Override
	public Control createConfigurationComposite(Composite parent, PaletteEntryProxy entryProxy, List<Profile> appliedProfiles) {
		this.appliedProfiles = appliedProfiles;
		this.entryProxy = entryProxy;
		Label label = new Label(parent, SWT.BORDER);
		label.setText("Choose applied stereotypes to display");
		return label;
	}
}
