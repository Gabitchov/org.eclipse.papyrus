package org.eclipse.papyrus.qompass.designer.ui.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.papyrus.qompass.designer.core.ProjectManagement;
import org.eclipse.papyrus.qompass.designer.core.transformations.TrafoAndCodegenPackage;
import org.eclipse.uml2.uml.Package;

public class TrafoAndCodegenHandler extends CmdHandler {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnabled() {
		updateSelectedEObject();
		return (selectedEObject instanceof Package);
	}

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// only one model is selected
		selectedPkg = null;
		if(selectedEObject instanceof Package) {
			selectedPkg = (Package)selectedEObject;
		} else {
			return null;
		}
		project = ProjectManagement.getCurrentProject();

		Job job = new Job("Execute transformations and generate code") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				// execute the task ...
				TrafoAndCodegenPackage.instantiate(selectedPkg, monitor, project);
				monitor.done();
				return Status.OK_STATUS;
			}
		};
		job.setUser(true);
		job.schedule();
	
		return null;
	}

	protected Package selectedPkg;
	
	protected IProject project;
}
