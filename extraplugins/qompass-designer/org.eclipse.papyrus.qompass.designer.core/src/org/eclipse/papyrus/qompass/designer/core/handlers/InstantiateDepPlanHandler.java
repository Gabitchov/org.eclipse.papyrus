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
 *  Ansgar Radermacher  ansgar.radermacher@cea.fr  
 *
 *****************************************************************************/

package org.eclipse.papyrus.qompass.designer.core.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.papyrus.FCM.Configuration;
import org.eclipse.papyrus.FCM.DeploymentPlan;
import org.eclipse.papyrus.qompass.designer.core.ProjectManagement;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.papyrus.qompass.designer.core.dialogs.GenerationOptionsDialog;
import org.eclipse.papyrus.qompass.designer.core.transformations.InstantiateDepPlan;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

/**
 * handler for instantiating a deployment plan
 */
public class InstantiateDepPlanHandler extends CmdHandler {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnabled() {
		updateSelectedEObject();
		EObject selectedObj = getSelectedEObject();
		if(selectedObj instanceof Element) {
			if(StereotypeUtil.isApplied((Element)selectedObj, DeploymentPlan.class) ||
				StereotypeUtil.isApplied((Element)selectedObj, Configuration.class)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// only one model is selected
		EObject selectedObj = getSelectedEObject();
		selectedCDP = null;
		if((selectedObj instanceof Package) || (selectedObj instanceof Class)) {
			selectedCDP = (Element)getSelectedEObject();
		} else {
			return null;
		}
		project = ProjectManagement.getCurrentProject();

		GenerationOptionsDialog optionsDialog = new GenerationOptionsDialog(new Shell());
		optionsDialog.open();
		if(optionsDialog.getReturnCode() == IDialogConstants.OK_ID) {

			final int genOptions = (Integer)optionsDialog.getResult()[0];
			Job job = new Job("Create deployment model (OO)") {

				@Override
				protected IStatus run(IProgressMonitor monitor) {
					// execute the task ...
					InstantiateDepPlan.instantiate(selectedCDP, monitor, project, genOptions);
					monitor.done();
					return Status.OK_STATUS;
				}
			};
			job.setUser(true);
			job.schedule();
		}

		return null;
	}

	private Element selectedCDP;

	private IProject project;
}
