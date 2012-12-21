package org.eclipse.papyrus.qompass.designer.core.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;

import FCM.DeploymentPlan;

import org.eclipse.papyrus.qompass.designer.core.CommandSupport;
import org.eclipse.papyrus.qompass.designer.core.StUtils;
import org.eclipse.papyrus.qompass.designer.core.Utils;
import org.eclipse.papyrus.qompass.designer.core.sync.CompImplSync;
import org.eclipse.papyrus.qompass.designer.core.sync.DepPlanSync;

public class SyncHandler extends CmdHandler {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnabled() {
		updateSelectedEObject();
		EObject selectedObj = getSelectedEObject();
		if(selectedObj instanceof Property) {
			selectedObj = ((Property)selectedObj).getType();
		}
		if(selectedObj instanceof Class) {
			if(Utils.isComponent((Class)selectedObj)) {
				return true;
			}
		}
		if(selectedObj instanceof Package) {
			if(StUtils.isApplied((Package)selectedObj, DeploymentPlan.class)) {
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
		//only one model is selected
		EObject selectedObj = getSelectedEObject();
		if(selectedObj instanceof Property) {
			selectedObj = ((Property)selectedObj).getType();
		}
		if(selectedObj instanceof Class) {
			final Class selectedClass = (Class)selectedObj;
			if(Utils.isCompImpl(selectedClass)) {
				CommandSupport.exec("Synchronize component via implementation", new Runnable() {

					public void run() {
						try {
							CompImplSync.syncRealizations(selectedClass);
						}
						catch (RuntimeException e) {
							MessageDialog.openWarning(new Shell(), "Problems during synchronization", e.getMessage());
						}

						// CompImplSync.syncContextOps (selectedClass, true);
						CompImplSync.interfaceModifications(selectedClass, null);
					}
				});
			} else if(Utils.isCompType(selectedClass)) {
				CommandSupport.exec("Synchronize component via type", new Runnable() {

					public void run() {
						if(!CompImplSync.syncViaType(selectedClass, false)) {
							MessageDialog.openWarning(new Shell(), "Warning: ineffective command", "Synchronization applied on a component type (abstract class) will synchronize all implementations, i.e. non-abstract classes inheriting from it. However, the selected type has no implementations");
						}
						// CompImplSync.syncContextOps (selectedClass, true);
					}
				});
			}
		}
		else if(selectedObj instanceof Package) {
			final Package selectedPkg = (Package)selectedObj;
			CommandSupport.exec("Synchronize deployment plan", new Runnable() {

				public void run() {
					DepPlanSync.syncDepPlan(selectedPkg);
				}
			});
		}
		return null;
	}
}
