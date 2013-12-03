/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.robotml.deployment.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.RobotML.DeploymentPlan;
import org.eclipse.papyrus.RobotML.Environment;
import org.eclipse.papyrus.robotml.deployment.CommandSupport;
import org.eclipse.papyrus.robotml.deployment.DepCreation;
import org.eclipse.papyrus.robotml.deployment.DepPlanSync;
import org.eclipse.papyrus.robotml.deployment.DepPlanUtils;
import org.eclipse.papyrus.robotml.deployment.RunnableWithResult;
import org.eclipse.papyrus.robotml.deployment.StUtils;
import org.eclipse.papyrus.robotml.deployment.TransformationException;
import org.eclipse.papyrus.robotml.deployment.Utils;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;

public class CreateDepPlanHandler extends CmdHandler {

	private final String DepPlanPostfix = "DepPlan";

	private Package depPlans;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnabled() {
		updateSelectedEObject();
		EObject selectedObj = getSelectedEObject();
		if((selectedObj instanceof Class) && Utils.isCompImpl((Class)selectedObj) && isEnvironment((Class)selectedObj)) {
			return true;
		}
		return false;
	}

	private boolean isEnvironment(Class elt){
		Environment environment = UMLUtil.getStereotypeApplication(elt, Environment.class);
		if (environment != null){
			return true;
		}
		
		return false;
		
	}
	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) {
		if(!(getSelectedEObject() instanceof Class)) {
			return null;
		}
		final Class selectedComposite = (Class)getSelectedEObject();

		CommandSupport.exec("Create deployment plans", new Runnable() {

			public void run() {
				// execute with transaction support
				depPlans = DepPlanUtils.getDepPlanRoot(selectedComposite);
			}
		});

		try {
			String name = selectedComposite.getName() + DepPlanPostfix;
			if(depPlans.getMember(name) != null) {
				Shell shell = new Shell();
				String dialogButtonLabels[] = new String[]{
					"Cancel",
					"Synchronize",
					"create new (auto number name)"
				};
				MessageDialog dialog = new MessageDialog(shell, "What should I do?", null,
					"Deployment plan with name \"" + name + "\" exists already. You can always synchronize an " +
						"existing deployment plan via the context menu \"Synchronize derived elements\"",
					MessageDialog.QUESTION, dialogButtonLabels, 0);
				int result = dialog.open();
				if(result == 0) {
					return null;
				}
				else if(result == 1) {
					NamedElement existing = depPlans.getMember(name);
					if(existing instanceof Package) {
						DepPlanSync.syncDepPlan((Package)existing);
					}
					else {
						MessageDialog.openError(shell, "Cannot synchronize", "Element with name \"" + name + "\" exists, but is not a package");
					}
				}
				else {
					for(int i = 2;; i++) {
						name = selectedComposite.getName() + DepPlanPostfix + i;
						if(depPlans.getMember(name) == null)
							break;
					}

				}
			}
			final String depPlanName = name;

			CommandSupport.exec("Create deployment plan", new RunnableWithResult() {

				public CommandResult run() {
					Package cdp = depPlans.createNestedPackage(depPlanName);
					Stereotype st = StUtils.apply(cdp, DeploymentPlan.class);
					if(st == null) {
						MessageDialog.openInformation(new Shell(), "Cannot create deployment plan",
							"Application of stereotype \"RobotML::DeploymentPlan\" failed. Check, if RobotML profile is applied");
						return CommandResult.newErrorCommandResult("cannot create deployment plan");
					}
					try {
						InstanceSpecification newRootIS =
							DepCreation.createDepPlan(cdp, selectedComposite, "mainInstance", true);
						DepCreation.initAutoValues(newRootIS);
						return CommandResult.newOKCommandResult();
					}
					catch (TransformationException e) {
						MessageDialog.openInformation(new Shell(), "Error during deployment plan creation",
							e.getMessage());
						return CommandResult.newErrorCommandResult(e.getMessage());
					}
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
