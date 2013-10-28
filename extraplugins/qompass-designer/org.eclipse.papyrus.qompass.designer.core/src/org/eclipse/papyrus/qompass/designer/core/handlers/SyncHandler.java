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
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.FCM.DeploymentPlan;
import org.eclipse.papyrus.qompass.designer.core.CommandSupport;
import org.eclipse.papyrus.qompass.designer.core.RunnableWithResult;
import org.eclipse.papyrus.qompass.designer.core.Utils;
import org.eclipse.papyrus.qompass.designer.core.sync.CompImplSync;
import org.eclipse.papyrus.qompass.designer.core.sync.DepPlanSync;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationRTException;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;

/**
 * Handler for synchronizing derived elements. Will do different
 * things, depending on the currently selected object.
 */
public class SyncHandler extends CmdHandler {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnabled() {
		updateSelectedEObject();
		// if a property is selected, use the associated type
		if(selectedEObject instanceof Property) {
			selectedEObject = ((Property)selectedEObject).getType();
		}
		
		if(selectedEObject instanceof Class) {
			if(Utils.isComponent((Class)selectedEObject)) {
				return true;
			}
		}
		else if(selectedEObject instanceof Package) {
			if(StereotypeUtil.isApplied((Package)selectedEObject, DeploymentPlan.class)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// if a property is selected, use the associated type
		if(selectedEObject instanceof Property) {
			selectedEObject = ((Property)selectedEObject).getType();
		}
		
		if(selectedEObject instanceof Class) {
			final Class selectedClass = (Class)selectedEObject;
			if(Utils.isCompImpl(selectedClass)) {
				CommandSupport.exec("Synchronize component via implementation", event, new RunnableWithResult() {
					
					public CommandResult run() {
						CompImplSync.updatePorts(selectedClass);
						try {
							CompImplSync.syncRealizations(selectedClass);
						}
						catch (TransformationRTException e) {
							MessageDialog.openWarning(new Shell(), "Problems during synchronization", e.getMessage());
							return CommandResult.newErrorCommandResult(e.getMessage());
						}

						// CompImplSync.syncContextOps (selectedClass, true);
						CompImplSync.interfaceModifications(selectedClass, null);
						return CommandResult.newOKCommandResult();
					}
				});
			} else if(Utils.isCompType(selectedClass)) {
				CommandSupport.exec("Synchronize component via type", event, new Runnable() {

					public void run() {
						if(!CompImplSync.syncViaType(selectedClass, false)) {
							MessageDialog.openWarning(new Shell(), "Warning: ineffective command", "Synchronization applied on a component type (abstract class) will synchronize all implementations, i.e. non-abstract classes inheriting from it. However, the selected type has no implementations");
						}
						// CompImplSync.syncContextOps (selectedClass, true);
					}
				});
			}
		}
		else if(selectedEObject instanceof Package) {
			final Package selectedPkg = (Package)selectedEObject;
			CommandSupport.exec("Synchronize deployment plan", event, new RunnableWithResult() {

				public CommandResult run() {
					try {
						DepPlanSync.syncDepPlan(selectedPkg);
						return CommandResult.newOKCommandResult();
					}
					catch (TransformationRTException e) {
						Shell shell = new Shell();
						MessageDialog.openError(shell, "Can not synchronize deployment plan", e.getMessage());
						return CommandResult.newErrorCommandResult(e.getMessage());
					}
				}
			});
		}
		return null;
	}
}
