/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.facade.codegen.ui.launcher;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.codegen.ecore.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.eef.codegen.flow.Step;
import org.eclipse.emf.eef.codegen.flow.Workflow;
import org.eclipse.papyrus.facade.codegen.FacadeCodeGenPlugin;
import org.eclipse.papyrus.facade.codegen.GenFacade.GenFacade;
import org.eclipse.papyrus.facade.codegen.util.EEFGeneratorAdapter;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class GenerateFacadeAction extends GenerateCodeAction {

	/**
	 * {@inheritDoc}
	 * 
	 * @see GenerateCodeAction#initEMFGenFlow()
	 */
	protected Workflow initEMFGenFlow() {
		final Workflow flow = new Workflow("Generate Facade code ", shell);
		for(final org.eclipse.emf.codegen.ecore.genmodel.GenModel emfGenModel : emfGenModels) {
			String s2 = "Generate Facade code for " + emfGenModel.eResource().getURI().toString();
			flow.addStep(s2, new Step("FACADE MODEL") {

				@Override
				public IStatus execute(IProgressMonitor monitor) {
					// create the model project
					IProject modelProject = extractProject(emfGenModel.getModelProjectDirectory());
					if(modelProject == null) {
						return Status.OK_STATUS;
					}
					List<IProject> referencedProjects = new UniqueEList<IProject>();
					if(!workspace.getRoot().exists(modelProject.getFullPath())) {
						// TODO Manage the case when the model project has been deleted from the workspace but is still present on disk ?
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
				// TODO Ne rafraichir avant le formatage que si le folder demand� n'est pas accessible
				// FIXME IMPORTANT !!! Virer le double refresh, fait � l'arrache par LDE qui sait pas comment faire autrement
				// TODO D�terminer pourquoi il reste des diff�rences de formatage avec EMF
				// TODO D�terminer pourquoi quand on fait clic-droit -> Source -> format sur le code g�n�r�, le code est modifi�
				// (cas o� le projet vient d'�tre cr�� par exemple)
				String s1b = "Refreshing workspace " + emfGenModel.eResource().getURI().toString();
				flow.addStep(s1b, new Step("REFRESH") {

					@Override
					public IStatus execute(IProgressMonitor monitor) {
						// refresh model project
						IProject modelProject = extractProject(emfGenModel.getModelProjectDirectory());
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

				String s2prime = "Formatting generated files";
				flow.addStep(s2prime, new Step(s2prime) {

					@Override
					public IStatus execute(IProgressMonitor monitor) {
						EEFGeneratorAdapter eefGen = new EEFGeneratorAdapter();
						eefGen.generate(emfGenModel, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, BasicMonitor.toMonitor(new SubProgressMonitor(monitor, IProgressMonitor.UNKNOWN)));
						return Status.OK_STATUS;
					}
				});
			}

			String s3 = "Refreshing workspace " + emfGenModel.eResource().getURI().toString();
			flow.addStep(s3, new Step("REFRESH") {

				@Override
				public IStatus execute(IProgressMonitor monitor) {
					// refresh model project
					IProject modelProject = extractProject(emfGenModel.getModelProjectDirectory());
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
		return flow;
	}

}
