/*****************************************************************************
 * Copyright (c) 2011 Nicolas Deblock & Manuel Giles.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Nicolas Deblock  nico.deblock@gmail.com  - Initial API and implementation
 * 	Manuel Giles	 giles.manu@live.fr		 - Initial API and implementation
 * 	Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Idea of the java generator project & help for the conception 
 *
 *****************************************************************************/

package org.eclipse.papyrus.java.generator.ui.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.papyrus.java.generator.jdtsynchronizer.RunGenerator;
import org.eclipse.papyrus.java.generator.metamodel.jdt.jdtmm.visitor.JDTVisitorException;
import org.eclipse.papyrus.java.generator.ui.Activator;
import org.eclipse.papyrus.java.generator.ui.preference.GeneratorPreferenceImpl;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.NamedElement;

/**
 * Handler used to launch Java code generation from a selected UML element.
 * 
 * @author Cedric dumoulin
 * 
 */
public class GenerateJavaCodeHandler extends AbstractHandler implements IHandler {


	/**
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * @param event
	 * @return
	 * @throws ExecutionException
	 * 
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		// Get selection
		// Can't be done in the job.
		List<Object> objects = lookupSelectedElements();
		// Execute handler
		doExecute(objects);

		return null;
	}

	/**
	 * Get the name used in the {@link RecordingCommand}. This name will be visible in
	 * undo/redo.
	 * 
	 * @return The command name to show.
	 */
	public String getCommandName() {
		return "Generate Java Code";
	}

	/**
	 * Return a list of selected domain (UML) elements.
	 * 
	 * @return
	 */
	protected List<NamedElement> getSelectedUmlObject() {
		List<Object> selections = lookupSelectedElements();

		List<NamedElement> results = new ArrayList<NamedElement>();

		// create model with EList<EObject> objects
		for(Object obj : selections) {
			// Adapt object to NamedElement
			NamedElement ele = null;
			if(obj instanceof IAdaptable) {
				ele = (NamedElement)((IAdaptable)obj).getAdapter(NamedElement.class);
			}
			if(ele == null) {
				ele = (NamedElement)Platform.getAdapterManager().getAdapter(obj, NamedElement.class);
			}

			// Add uml element if found
			if(ele != null) {
				results.add(ele);
			}

		}

		return results;
	}

	/**
	 * Do the execution of the command.
	 * 
	 * @param objects
	 *        List of object to generate Java code from.
	 */
	protected void doExecute(final List<Object> objects) {

		Job job = new Job("Generate java classes ") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				// execute the task ...

				try {
					IStatus status = doExecute(monitor, objects);
					monitor.done();
					return status;
				}
				catch (Exception e) {
					return new Status(Status.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
				}
				finally {

				}


			}
		};

		job.setUser(true);
		job.schedule();

	}

	/**
	 * Do the execution of the command.
	 * 
	 * @param objects
	 *        List of object to generate Java code from.
	 */
	protected IStatus doExecute(IProgressMonitor monitor, List<Object> objects) {
		monitor.beginTask("Generate ...", 3);

		// create a EList<EObject> who is the model
		EList<EObject> model = new BasicEList<EObject>();

		// create model with EList<EObject> objects
		for(Object obj : objects) {
			// Adapt object to NamedElement
			NamedElement ele = null;
			if(obj instanceof IAdaptable) {
				ele = (NamedElement)((IAdaptable)obj).getAdapter(NamedElement.class);
			}
			if(ele == null) {
				ele = (NamedElement)Platform.getAdapterManager().getAdapter(obj, NamedElement.class);
			}

			// Add uml element if found
			if(ele != null) {
				model.add(ele);
			}

		}
		monitor.worked(1);

		// recover window
		//		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();		

		// Check if there is a right selection
		if(model.size() <= 0) {
			String msg = "No UML element selected. Please select one or more UML element to generate";
			//			MessageDialog.openInformation(window.getShell(),"No Selection", msg);

			return new Status(Status.ERROR, Activator.PLUGIN_ID, msg);

		}

		// error message
		String message = "";


		try {
			// run code generator
			RunGenerator runGen = new RunGenerator(model);
			runGen.runGeneration(new GeneratorPreferenceImpl());
		} catch (JDTVisitorException e) {
			// error message
			StringBuffer stackTrace = new StringBuffer();
			for(StackTraceElement trace : e.getStackTrace()) {
				stackTrace.append("at " + trace.getMethodName() + "(" + trace.getClassName() + ":" + trace.getLineNumber() + ")\n");
			}

			IStatus status = new Status(Status.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
			//			ErrorDialog errDg = new ErrorDialog(window.getShell(), "Error encountered during code generation", 
			//													"Error encountered during code generation", 
			//													status,
			//													Status.ERROR);
			//			errDg.open();
			return status;
		}

		//		if(message.isEmpty()) message = "Code generated successfully!";

		monitor.worked(2);
		//		MessageDialog.openInformation(window.getShell(),"Code generation",message);

		return Status.OK_STATUS;
	}

	/**
	 * Lookup selected objects in UI.
	 * 
	 * @return
	 */
	private List<Object> lookupSelectedElements() {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		ISelection selection = page.getSelection();
		//		System.out.println("check " + selection);
		if(selection instanceof IStructuredSelection)
		{
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			return structuredSelection.toList();
		}
		else if(selection instanceof TreeSelection) {
			TreeSelection treeSelection = (TreeSelection)selection;
			return treeSelection.toList();

		}
		return null;
	}
}
