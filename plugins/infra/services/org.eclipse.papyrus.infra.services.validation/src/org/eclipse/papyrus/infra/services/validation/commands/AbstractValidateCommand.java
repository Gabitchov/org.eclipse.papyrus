/*****************************************************************************
 * Copyright (c) 2010, 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - refactor for non-workspace abstraction of problem markers (CDO)
 *  Patrick Tessier (CEA LIST) refacor to add allowing adding validation specific to UML
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.validation.commands;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.EMFEditUIPlugin;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.papyrus.infra.services.validation.EcoreDiagnostician;
import org.eclipse.papyrus.infra.services.validation.IPapyrusDiagnostician;
import org.eclipse.papyrus.infra.services.validation.ValidationTool;
import org.eclipse.papyrus.infra.services.validation.ValidationUtils;
import org.eclipse.papyrus.infra.services.validation.preferences.PreferenceUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

/**
 * Abstract validation command. While being abstract (and refined by concrete validation commands)
 * it contains all validation related code.
 * 
 * 
 * @author Ansgar Radermacher (CEA LIST)
 */
abstract public class AbstractValidateCommand extends AbstractTransactionalCommand {

	final String modelValidationViewID = "org.eclipse.papyrus.views.validation.ModelValidationView"; //$NON-NLS-1$

	protected TransactionalEditingDomain domain;

	protected EObject selectedElement;

	/**
	 * Current diagnostic within a validation run
	 */
	protected Diagnostic diagnostic;
	
	protected IPapyrusDiagnostician diagnostician;

	protected boolean showUIfeedback;
	
	/**
	 * Creates a new ValidationCommand
	 *
	 * @param label
	 *        the command label
	 * @param domain
	 *        the editing domain
	 * @param selectedElement the selected element
	 */
	public AbstractValidateCommand(String label, TransactionalEditingDomain domain, EObject selectedElement) {
		this(label, domain, selectedElement, new EcoreDiagnostician());
	}
	
	/**
	 * Creates a new ImportLibraryFromRepositoryCommand
	 * 
	 * @param label
	 *        the command label
	 * @param domain
	 *        the editing domain
	 * @param selectedElement
	 *        the selected element
	 * @param diagnostician
	 *        a diagnocstician adapted to a domain see {@link IPapyrusDiagnostician}
	 */
	public AbstractValidateCommand(String label, TransactionalEditingDomain domain, EObject selectedElement, IPapyrusDiagnostician diagnostician) {
		super(domain, label, Collections.EMPTY_LIST);
		this.domain = domain;
		this.selectedElement = selectedElement;
		this.diagnostician= diagnostician;
		this.showUIfeedback = true;	// default is true;
	}

	/**
	 * don't use a progress monitor to show validation progress. This is quite useful
	 * for diagnostics that are executed on a (shallow) subtree and do not take much time.
	 */
	public void disableUIFeedback() {
		this.showUIfeedback = false;
	}
	
	/**
	 * @return The resource on which markers should be applied.
	 */
	protected Resource getValidationResource() {
		return ValidationUtils.getValidationResource(selectedElement);
	}

	protected void runValidation(final EObject validateElement) {
		final Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

		IRunnableWithProgress runValidationWithProgress = new IRunnableWithProgress()
		{

			public void run(final IProgressMonitor progressMonitor) throws InvocationTargetException, InterruptedException
			{
				try {
					diagnostic = validate(progressMonitor, validateElement);
				}
				finally {
					progressMonitor.done();
				}
			}
		};

		IRunnableWithProgress createMarkersWithProgress = new IRunnableWithProgress()
		{

			public void run(final IProgressMonitor progressMonitor) throws InvocationTargetException, InterruptedException
			{
				try {
					handleDiagnostic(progressMonitor, diagnostic, validateElement, shell);
					
				}
				finally {
					progressMonitor.done();
				}
			}
		};

		createMarkersWithProgress = new ValidationTool(validateElement)
			.wrap(createMarkersWithProgress);

		try {
			// runs the operation, and shows progress.
			diagnostic = null;
			if (showUIfeedback) {
				new ProgressMonitorDialog(shell).run(true, true, runValidationWithProgress);
			}
			else {
				runValidationWithProgress.run(new NullProgressMonitor());
			}
			if(diagnostic != null) {
				int markersToCreate = diagnostic.getChildren().size();
				if((markersToCreate > 0) && PreferenceUtils.getAutoShowValidation()) {
					// activate model view, if activated in configuration
					// IViewRegistry viewRegistry = PlatformUI.getWorkbench().getViewRegistry();
					// IViewDescriptor desc = viewRegistry.find(modelValidationViewID);
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(modelValidationViewID);
					// HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().showView(modelValidationViewID);
					
				}
				// don't fork this dialog, i.e. run it in the UI thread. This avoids that the diagrams are constantly refreshing *while*
				// markers/decorations are changing. This greatly enhances update performance. See also bug 400593
				if (showUIfeedback) {
					new ProgressMonitorDialog(shell).run(false, true, createMarkersWithProgress);
				}
				else {
					createMarkersWithProgress.run(new NullProgressMonitor());
				}
			}
		} catch (Exception exception) {
			EMFEditUIPlugin.INSTANCE.log(exception);
		}
	}

	/**
	 * This simply executes the command.
	 */
	protected Diagnostic validate(IProgressMonitor progressMonitor, EObject validateElement)
	{
		int validationSteps = 0;
		for(Iterator<?> i = validateElement.eAllContents(); i.hasNext(); i.next()) {
			++validationSteps;
		}

		progressMonitor.beginTask("", validationSteps); //$NON-NLS-1$
		AdapterFactory adapterFactory =
			domain instanceof AdapterFactoryEditingDomain ? ((AdapterFactoryEditingDomain)domain).getAdapterFactory() : null;
		diagnostician.initialize(adapterFactory, progressMonitor);

		BasicDiagnostic diagnostic = diagnostician.createDefaultDiagnostic(validateElement);
		Map<Object, Object> context = diagnostician.createDefaultContext();

		progressMonitor.setTaskName(EMFEditUIPlugin.INSTANCE.getString("_UI_Validating_message", new Object[]{ diagnostician.getObjectLabel(validateElement) })); //$NON-NLS-1$
		diagnostician.validate(validateElement, diagnostic, context);

		if(progressMonitor.isCanceled()) {
			return null;
		}
		return diagnostic;
	}




	protected void handleDiagnostic(IProgressMonitor monitor, Diagnostic diagnostic, final EObject validateElement, final Shell shell)
	{
		// Do not show a dialog, as in the original version since the user sees the result directly
		// in the model explorer
		Resource resource = getValidationResource();
		// final Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		if(resource != null) {
			if(validateElement != null) {
				SubMonitor sub = SubMonitor.convert(monitor, 2);
				
				ValidationTool vt = new ValidationTool(validateElement, resource);
				int markersToCreate = diagnostic.getChildren().size();

				sub.beginTask("Delete existing markers", 1);
				flushDisplayEvents(shell.getDisplay());

				vt.deleteSubMarkers(sub.newChild(1));

				monitor.setTaskName("Create markers (total: " + markersToCreate + " markers) and refresh diagrams"); //$NON-NLS-1$
				flushDisplayEvents(shell.getDisplay());

				vt.createMarkers(diagnostic, sub.newChild(1));
				
				sub.done();
			}
		}
	}

	protected void flushDisplayEvents(Display display) {
		while (display.readAndDispatch());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canExecute() {
		return (selectedElement != null);
	}
}
