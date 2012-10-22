/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.validation.commands;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.EMFEditUIPlugin;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.papyrus.infra.services.validation.ValidationTool;
import org.eclipse.papyrus.infra.services.validation.ValidationUtils;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

/**
 * Action used for pasting either a model element or a shape (i.e. the model element represented
 * by the shape). Delegates to PasteShapeOrElementCommand
 * 
 * @author Ansgar Radermacher (CEA LIST)
 */
abstract public class AbstractValidateCommand extends AbstractTransactionalCommand {

	protected TransactionalEditingDomain domain;

	protected EObject selectedElement;

	/**
	 * Creates a new ImportLibraryFromRepositoryCommand
	 * 
	 * @param editingDomain
	 *        editing domain that manages the changed objects
	 * @param runnable
	 *        process that executes the modifications
	 * @param label
	 *        the label of the command
	 * @param description
	 *        description of the command
	 */

	public AbstractValidateCommand(String label, TransactionalEditingDomain domain, EObject selectedElement) {
		super(domain, label, Collections.EMPTY_LIST);
		this.domain = domain;
		this.selectedElement = selectedElement;
	}

	protected void handleDiagnostic(Diagnostic diagnostic)
	{
		// Do not show a dialog, as in the original version since the user sees the result directly
		// in the model explorer
		Resource resource = getValidationResource();
		if(resource != null) {
			if(selectedElement != null) {
				ValidationTool vt = new ValidationTool(selectedElement, resource);
				vt.deleteSubMarkers();
			}

			// IPath path = new Path(resource.getURI().toPlatformString (false));
			// IWorkspaceRoot wsRoot = ResourcesPlugin.getWorkspace().getRoot();
			// IFile file = wsRoot.getFile(path);
			// eclipseResourcesUtil.deleteMarkers (file);

			for(Diagnostic childDiagnostic : diagnostic.getChildren()) {
				ValidationUtils.eclipseResourcesUtil.createMarkers(resource, childDiagnostic);
				// createMarkersOnDi (file, childDiagnostic);
			}
		}
	}

	/**
	 * @return The resource on which markers should be applied.
	 *         Currently, the function simply returns the first resource of the resource-set which happens to be the
	 *         "notation" resource. This might change in the future.
	 */
	protected Resource getValidationResource() {
		return ValidationUtils.getValidationResourceViaDomain(domain);
	}

	protected void runValidation(final EObject validateElement) {
		final Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		IRunnableWithProgress runnableWithProgress = new IRunnableWithProgress()
		{

			public void run(final IProgressMonitor progressMonitor) throws InvocationTargetException, InterruptedException
			{
				try {
					final Diagnostic diagnostic = validate(progressMonitor, validateElement);
					shell.getDisplay().asyncExec(new Runnable() {

						public void run()
						{
							if(progressMonitor.isCanceled()) {
								handleDiagnostic(Diagnostic.CANCEL_INSTANCE);
							}
							else {
								handleDiagnostic(diagnostic);
							}
						}
					});
				}
				finally {
					progressMonitor.done();
				}
			}
		};

		if(ValidationUtils.eclipseResourcesUtil != null) {
			runnableWithProgress = ValidationUtils.eclipseResourcesUtil.getWorkspaceModifyOperation(runnableWithProgress);
		}

		try {
			// This runs the operation, and shows progress.
			// (It appears to be a bad thing to fork this onto another thread.)
			new ProgressMonitorDialog(shell).run(true, true, runnableWithProgress);
		} catch (Exception exception) {
			EMFEditUIPlugin.INSTANCE.log(exception);
		}
	}

	/**
	 * This simply executes the command.
	 */
	protected Diagnostic validate(IProgressMonitor progressMonitor, EObject validateElement)
	{
		int count = 0;
		for(Iterator<?> i = validateElement.eAllContents(); i.hasNext(); i.next()) {
			++count;
		}

		progressMonitor.beginTask("", count);

		AdapterFactory adapterFactory =
			domain instanceof AdapterFactoryEditingDomain ? ((AdapterFactoryEditingDomain)domain).getAdapterFactory() : null;
		Diagnostician diagnostician = createDiagnostician(adapterFactory, progressMonitor);

		BasicDiagnostic diagnostic = diagnostician.createDefaultDiagnostic(validateElement);
		Map<Object, Object> context = diagnostician.createDefaultContext();

		progressMonitor.setTaskName(EMFEditUIPlugin.INSTANCE.getString("_UI_Validating_message", new Object[]{ diagnostician.getObjectLabel(validateElement) }));
		diagnostician.validate(validateElement, diagnostic, context);

		return diagnostic;
	}

	protected Diagnostician createDiagnostician(final AdapterFactory adapterFactory, final IProgressMonitor progressMonitor)
	{
		return new Diagnostician() {

			@Override
			public String getObjectLabel(EObject eObject) {
				if(adapterFactory != null && !eObject.eIsProxy())
				{
					IItemLabelProvider itemLabelProvider = (IItemLabelProvider)adapterFactory.adapt(eObject, IItemLabelProvider.class);
					if(itemLabelProvider != null) {
						return itemLabelProvider.getText(eObject);
					}
				}
				return super.getObjectLabel(eObject);
			}

			@Override
			public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
				progressMonitor.worked(1);
				return super.validate(eClass, eObject, diagnostics, context);
			}
		};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canExecute() {
		return (selectedElement != null);
	}
}
