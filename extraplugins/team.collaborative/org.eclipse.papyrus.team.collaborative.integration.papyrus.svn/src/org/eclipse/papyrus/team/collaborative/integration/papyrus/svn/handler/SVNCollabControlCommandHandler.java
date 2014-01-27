/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *     Philippe Roland (Atos) philippe.roland@atos.net - minor change to the 
 *         default naming algorithm to ensure it suggests a valid name
 *******************************************************************************/
package org.eclipse.papyrus.team.collaborative.integration.papyrus.svn.handler;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.ModelElementItem;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeManager;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeRequest;
import org.eclipse.papyrus.infra.services.controlmode.IControlModeManager;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.NotificationBuilder;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.svn.ui.CreateCollabModelFragmentDialog;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.ui.dialogs.PreviewDialog;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.ui.providers.ExtensivePartitionNameLabelProvider;
import org.eclipse.papyrus.team.collaborative.integration.papyrus.utils.UIUtils;
import org.eclipse.papyrus.views.modelexplorer.handler.AbstractModelExplorerHandler;
import org.eclipse.swt.widgets.Display;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;


/**
 * The Class SVNCollabControlCommandHandler.
 * Specific handler for fragment creation.
 * This handler retrict the {@link URI} of the new target {@link Resource}
 */
public class SVNCollabControlCommandHandler extends AbstractModelExplorerHandler {

	private static final String PARTITION_PREFIX = "__Partition";

	private static final String ILLEGAL_CHARACTERS = "[^a-zA-Z0-9_]";

	private static final String EMPTY_STRING = "";

	public Object execute(ExecutionEvent event) throws ExecutionException {

		List<EObject> selection = getCurrentSelectionAdaptedToType(event, EObject.class);
		if(selection == null || selection.isEmpty() || selection.size() > 1) {
			NotificationBuilder.createInfoPopup("Nothing to control").run();
			return null;
		}
		EObject eObjectToControl = selection.get(0);
		Resource eResource = eObjectToControl.eResource();
		CreateCollabModelFragmentDialog dialog = new CreateCollabModelFragmentDialog(Display.getDefault().getActiveShell(), eResource, getDefaultName(event));
		if(dialog.open() == CreateCollabModelFragmentDialog.OK) {
			ControlModeRequest controlRequest = ControlModeRequest.createUIControlModelRequest(getEditingDomain(), eObjectToControl, dialog.getURI());
			IControlModeManager controlMng = ControlModeManager.getInstance();
			ICommand controlCommand = controlMng.getControlCommand(controlRequest);
			getEditingDomain().getCommandStack().execute(new GMFtoEMFCommandWrapper(controlCommand));
			PreviewDialog partitionDialog = new PreviewDialog(Display.getDefault().getActiveShell(), new ExtensivePartitionNameLabelProvider( UIUtils.getModelExplorerLavelProvider()), "Model Partition", EMPTY_STRING);
			if(selection != null && !selection.isEmpty()) {
				partitionDialog.setObjectsToReveal(Collections.singleton(eObjectToControl));
			}
			partitionDialog.open();
		}
		return null;
	}

	/**
	 * Create the default resource name from the selected element
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	protected String getDefaultName(ExecutionEvent event) throws ExecutionException {
		List<ModelElementItem> selection = getCurrentSelectionAdaptedToType(event, ModelElementItem.class);
		if(selection != null && !selection.isEmpty()) {
			String label = selection.get(0).getText().trim() + PARTITION_PREFIX;
			label = label.replaceAll(ILLEGAL_CHARACTERS, "");
			return label;
		}
		return EMPTY_STRING;
	}


}
