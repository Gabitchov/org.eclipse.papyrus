/*******************************************************************************
 * Copyright (c) 2007 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 * Thibault Landre (Atos Origin) - refactor to extract the exportAllDiagram from ExportAllDiagramsAction
 * Alexia Allanic (Atos Origin) - Add margin to not truncate images
 * Anass Radouani (AtoS) - add use GMF exporting tool and remove manual extraction
 * 
 ******************************************************************************/
package org.eclipse.papyrus.export;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain.Factory;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.image.ImageFileFormat;
import org.eclipse.gmf.runtime.diagram.ui.render.util.CopyToImageUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.papyrus.export.internal.Activator;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

public class ExportAllDiagrams {

	private IFile file;

	private String extension;

	private String outputDirectoryPath;

	private IWorkbenchWindow workbenchWindow;

	private boolean displayRenamingInformation;

	private static boolean useDisplayRunnable = true;

	/**
	 * Constructor
	 * 
	 * @param file
	 *        the *.*di file where the diagrams are stored, can be null if
	 *        you use export method with diagrams in parameter
	 * @param outputDirectoryPath
	 *        the directory in which the images will be saved
	 * @param extension
	 *        the image extension
	 * @param imageExporter
	 *        the image exporter used. The image exporter should be coherent
	 *        with the file extension
	 */
	public ExportAllDiagrams(IFile file, String outputDirectoryPath, String extension) {
		this.file = file;
		this.extension = extension;
		this.outputDirectoryPath = outputDirectoryPath;
		try {
			this.workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		} catch (IllegalStateException e) {
			this.workbenchWindow = null;
			// is normal in batch mode
		}
		this.displayRenamingInformation = true;
	}

	/**
	 * Run the export of all diagrams of a *.*di file into images in the given
	 * format.
	 */
	public void exportDiagramsToImages() {
		final IRunnableWithProgress op = new WorkspaceModifyOperation() {

			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
				if(monitor == null) {
					monitor = new NullProgressMonitor();
				}
				final IProgressMonitor newMonitor = monitor;
				export(newMonitor);
			}

		};
		Job job = new Job(Messages.ExportAllDiagrams_0) {

			@Override
			public IStatus run(IProgressMonitor monitor) {
				try {
					op.run(monitor);
				} catch (InvocationTargetException e) {
				} catch (InterruptedException e) {
				}
				return Status.OK_STATUS;
			}
		};
		job.setUser(true);
		job.schedule();

	}


	/**
	 * Export all diagrams of the IFile
	 * 
	 * @param newMonitor
	 */
	private void export(IProgressMonitor newMonitor) {
		// Then iterates on all the diagrams and export them one by one
		newMonitor.beginTask(Messages.ExportAllDiagrams_1, 10);
		newMonitor.subTask(Messages.ExportAllDiagrams_2);
		if(file != null) {
			ResourceSetImpl resourceSet = new ResourceSetImpl();
			resourceSet.getLoadOptions().put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, true);
			resourceSet.getLoadOptions().put(XMLResource.OPTION_DEFER_ATTACHMENT, true);
			resourceSet.getResource(URI.createPlatformResourceURI(file.getFullPath().toString(), true), true);

			// create transactional editing domain

			if(TransactionUtil.getEditingDomain(resourceSet) == null) {
				Factory factory = TransactionalEditingDomain.Factory.INSTANCE;
				factory.createEditingDomain(resourceSet);
			}

			EcoreUtil.resolveAll(resourceSet);
			List<Diagram> diagrams = new ArrayList<Diagram>();
			if(newMonitor.isCanceled()) {
				return;
			}
			for(Iterator<Notifier> i = resourceSet.getAllContents(); i.hasNext();) {
				Notifier n = i.next();
				if(n instanceof Diagram) {
					diagrams.add((Diagram)n);
				}
			}
			if(newMonitor.isCanceled()) {
				return;
			}
			newMonitor.worked(1);
			export(new SubProgressMonitor(newMonitor, 9), diagrams);
		} else {
			Activator.log(new Status(Status.ERROR, Activator.PLUGIN_ID, Messages.ExportAllDiagrams_3));
		}

	}

	/**
	 * export all the diagrams in image
	 * 
	 * @param newMonitor
	 *        , the monitor
	 * @param diagrams
	 *        , the emf element diagrams
	 */
	public void export(IProgressMonitor newMonitor, List<Diagram> diagrams) {
		boolean duplicates;
		newMonitor.beginTask(Messages.ExportAllDiagrams_4, 10);
		duplicates = createDiagramFiles(new SubProgressMonitor(newMonitor, 9), diagrams);
		unloadResources(new SubProgressMonitor(newMonitor, 1), diagrams);

		// Alert the user that file names have been changed to avoid duplicates
		if(duplicates && displayRenamingInformation) {
			final String message = Messages.ExportAllDiagrams_5;
			if(workbenchWindow != null && workbenchWindow.getShell() != null) {
				Display.getDefault().syncExec(new Runnable() {

					public void run() {
						MessageDialog.openInformation(Activator.getActiveWorkbenchShell(), Messages.ExportAllDiagrams_6, message);
					}
				});
			} else {
				Activator.log(new Status(Status.INFO, Activator.PLUGIN_ID, message));
			}
		}
	}

	/**
	 * Browse all the diagrams and export them
	 * 
	 * @param newMonitor
	 * @param findAllDiagrams
	 * @return
	 */
	private boolean createDiagramFiles(final IProgressMonitor newMonitor, List<Diagram> diagrams) {
		boolean duplicates = false;
		try {
			List<String> diagramNames = new ArrayList<String>();
			try {
				newMonitor.beginTask(Messages.ExportAllDiagrams_7, diagrams.size());
				for(final Diagram diagram : diagrams) {
					if(newMonitor.isCanceled()) {
						break;
					}
					String uniqueFileName = encodeFileName(diagram.getName());
					if(diagramNames.contains(uniqueFileName)) {
						duplicates = true;
						uniqueFileName = getFirstAvailableName(uniqueFileName, diagramNames, 1);
					}
					final String finalUniqueFileName = uniqueFileName;
					diagramNames.add(uniqueFileName);
					newMonitor.subTask(Messages.ExportAllDiagrams_8 + uniqueFileName);
					if(useDisplayRunnable) {
						Display.getDefault().syncExec(new Runnable() {

							public void run() {
								exportDiagram(finalUniqueFileName, diagram, newMonitor);
							}
						});
					} else {
						exportDiagram(uniqueFileName, diagram, newMonitor);
					}
					newMonitor.worked(1);
				}
			} catch (SWTError e) {
				String message = Messages.ExportAllDiagrams_9;
				Activator.log(new Exception(message, e));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return duplicates;
	}

	private void exportDiagram(String uniqueFileName, Diagram diagram, IProgressMonitor newMonitor) {
		CopyToImageUtil copyImageUtil = new CopyToImageUtil();
		try {
			copyImageUtil.copyToImage(diagram, new Path(outputDirectoryPath + File.separator + uniqueFileName + "." //$NON-NLS-1$
				+ ImageFileFormat.resolveImageFormat(extension)), ImageFileFormat.resolveImageFormat(extension), new SubProgressMonitor(newMonitor, 1), PreferencesHint.USE_DEFAULTS);
		} catch (Throwable e) {
			Activator.log(String.format(Messages.ExportAllDiagrams_11, uniqueFileName, diagram.eResource().getURI().toString()), IStatus.ERROR, e);
		}
	}

	public void unloadResources(IProgressMonitor newMonitor, List<Diagram> diagrams) {
		if(newMonitor == null) {
			newMonitor = new NullProgressMonitor();
		}
		newMonitor.subTask(Messages.ExportAllDiagrams_12);
		if(diagrams != null) {
			ResourceSet resourceSet2 = diagrams.get(0).eResource().getResourceSet();
			newMonitor.beginTask(Messages.ExportAllDiagrams_13, resourceSet2.getResources().size());
			for(int i = resourceSet2.getResources().size() - 1; i >= 0; i--) {
				try {
					Resource r = resourceSet2.getResources().get(i);
					if(r.isLoaded()) {
						r.unload();
					}
				} catch (Exception e) {
					// not very clean but it sometimes occurs
				}
				newMonitor.worked(1);
			}
		}

	}

	/**
	 * Escape all characters that may result in a wrong file name
	 * 
	 * @param pathName
	 *        a file name to encode
	 * @return The encoded file name
	 */
	private String encodeFileName(String pathName) {
		pathName = pathName.trim();
		return pathName.replaceAll(Messages.ExportAllDiagrams_14, Messages.ExportAllDiagrams_15);
		// return URLEncoder.encode(pathName, "UTF-8").replaceAll("[*]", "_");
	}

	private String getFirstAvailableName(String commonBasis, List<String> existingNames, int cpt) {
		if(existingNames.contains(commonBasis + cpt)) {
			return getFirstAvailableName(commonBasis, existingNames, cpt + 1);
		}
		return commonBasis + cpt;
	}
}
