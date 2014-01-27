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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.facade.codegen.handlers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.codegen.ecore.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.eef.codegen.flow.Step;
import org.eclipse.emf.eef.codegen.flow.Workflow;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.facade.codegen.FacadeCodeGenPlugin;
import org.eclipse.papyrus.facade.codegen.Messages;
import org.eclipse.papyrus.facade.codegen.genfacade.GenFacade;
import org.eclipse.papyrus.facade.codegen.utils.EEFGeneratorAdapter;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Handler to generate Facade code.
 */
public class GenerateFacadeHandler extends AbstractHandler {


	/** The workspace. */
	protected IWorkspace workspace = ResourcesPlugin.getWorkspace();


	/**
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		List<GenModel> emfGenModels = new ArrayList<GenModel>();

		// get workbench window
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		// set selection service
		ISelectionService service = window.getSelectionService();
		// set structured selection
		IStructuredSelection structured = (IStructuredSelection)service.getSelection();

		if(structured != null) {
			for(Object selectedElement : structured.toList()) {
				if(selectedElement instanceof GenModel) {
					emfGenModels.add((GenModel)selectedElement);
				}
			}
		}

		if(emfGenModels != null) {
			final Workflow flow = initEMFGenFlow(emfGenModels);
			flow.prepare();
			Job job = new Job(Messages.GenerateCodeAction_0) {

				@Override
				protected IStatus run(IProgressMonitor monitor) {
					flow.execute(monitor);
					monitor.done();
					return Status.OK_STATUS;
				}

			};
			job.setUser(true);
			job.schedule();
		}

		return null;
	}

	/**
	 * Inits the emf gen flow.
	 * 
	 * @param emfGenModels
	 *        the emf Genmodels to generate the facade for
	 * @return the workflow
	 */
	protected Workflow initEMFGenFlow(List<GenModel> emfGenModels) {
		final Workflow flow = new Workflow(Messages.GenerateFacadeAction_0, Display.getCurrent().getActiveShell());
		for(final org.eclipse.emf.codegen.ecore.genmodel.GenModel emfGenModel : emfGenModels) {
			String s2 = Messages.GenerateFacadeAction_1 + emfGenModel.eResource().getURI().toString();
			flow.addStep(s2, new Step("FACADE MODEL") { //$NON-NLS-1$

				@Override
				public IStatus execute(IProgressMonitor monitor) {
					// create the model project
					IProject modelProject = getProjectFromStringPath(emfGenModel.getModelProjectDirectory());
					if(modelProject == null) {
						return Status.OK_STATUS;
					}
					List<IProject> referencedProjects = new UniqueEList<IProject>();
					if(!workspace.getRoot().exists(modelProject.getFullPath())) {
						if(modelProject.getLocation().toFile().exists()) {
							modelProject.getLocation().toFile().delete();
						}
						modelProject = Generator.createEMFProject(new Path(emfGenModel.getModelDirectory()), modelProject.getLocation(), referencedProjects, new SubProgressMonitor(monitor, IProgressMonitor.UNKNOWN), Generator.EMF_MODEL_PROJECT_STYLE | Generator.EMF_PLUGIN_PROJECT_STYLE);
					} else if(!modelProject.isAccessible()) {
						try {
							modelProject.open(monitor);
						} catch (CoreException e) {
							return new Status(IStatus.ERROR, FacadeCodeGenPlugin.PLUGIN_ID, e.getMessage(), e);
						}
					}
					// generate using acceleo
					List<String> args = new ArrayList<String>();
					File modelDirectory = modelProject.getLocation().toFile();
					try {
						GenFacade generator = new GenFacade(emfGenModel, modelDirectory, args);
						generator.doGenerate(BasicMonitor.toMonitor(new SubProgressMonitor(monitor, IProgressMonitor.UNKNOWN)));
					} catch (IOException e) {
						return new Status(IStatus.ERROR, FacadeCodeGenPlugin.PLUGIN_ID, e.getMessage(), e);
					}
					return Status.OK_STATUS;
				}
			});

			if(emfGenModel.isCodeFormatting()) {
				refresh(emfGenModel, flow);

				String s2prime = Messages.GenerateFacadeAction_5;
				flow.addStep(s2prime, new Step(s2prime) {

					@Override
					public IStatus execute(IProgressMonitor monitor) {
						EEFGeneratorAdapter eefGen = new EEFGeneratorAdapter();
						eefGen.generate(emfGenModel, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, BasicMonitor.toMonitor(new SubProgressMonitor(monitor, IProgressMonitor.UNKNOWN)));
						return Status.OK_STATUS;
					}
				});
			}

			refresh(emfGenModel, flow);
		}
		return flow;
	}

	/**
	 * Refresh.
	 * 
	 * @param emfGenModel
	 *        the emf GenModel that is used to generate facade code for
	 * @param flow
	 *        the flow
	 */
	protected void refresh(final org.eclipse.emf.codegen.ecore.genmodel.GenModel emfGenModel, Workflow flow) {
		String s3 = Messages.GenerateFacadeAction_6 + emfGenModel.eResource().getURI().toString();
		flow.addStep(s3, new Step("REFRESH") { //$NON-NLS-1$

			@Override
			public IStatus execute(IProgressMonitor monitor) {
				// refresh model project
				IProject modelProject = getProjectFromStringPath(emfGenModel.getModelProjectDirectory());
				if(modelProject == null) {
					return Status.OK_STATUS;
				}
				try {
					if(!modelProject.isOpen()) {
						modelProject.open(monitor);
					}
					modelProject.refreshLocal(IResource.DEPTH_INFINITE, monitor);
				} catch (CoreException e) {
					return new Status(IStatus.ERROR, FacadeCodeGenPlugin.PLUGIN_ID, e.getMessage(), e);
				}
				return Status.OK_STATUS;
			}
		});
	}





	/**
	 * Extract project.
	 * 
	 * @param stringPath
	 *        the path to the project encoded as a string
	 * @return the corresponding project
	 */
	protected IProject getProjectFromStringPath(String stringPath) {
		IPath path = new Path(stringPath);
		if(path.isEmpty()) {
			return null;
		}
		return workspace.getRoot().getProject(path.segment(0));
	}



}
