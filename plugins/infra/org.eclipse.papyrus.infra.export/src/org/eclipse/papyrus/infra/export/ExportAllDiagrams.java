/*******************************************************************************
 * Copyright (c) 2007, 2014 Anyware Technologies, CEA, and others.
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and implementation
 * Thibault Landre (Atos Origin) - refactor to extract the exportAllDiagram from ExportAllDiagramsAction
 * Alexia Allanic (Atos Origin) - Add margin to not truncate images
 * Anass Radouani (AtoS) - add use GMF exporting tool and remove manual extraction
 * Christian W. Damus (CEA) - bug 431411
 * Christian W. Damus (CEA) - bug 410346
 * 
 ******************************************************************************/
package org.eclipse.papyrus.infra.export;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.ui.dialogs.DiagnosticDialog;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.image.ImageFileFormat;
import org.eclipse.gmf.runtime.diagram.ui.render.util.CopyToImageUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.export.internal.Activator;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;
import org.eclipse.papyrus.infra.onefile.model.PapyrusModelHelper;
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

	private boolean qualifiedName;

	private BasicDiagnostic diagnostic = new BasicDiagnostic(Diagnostic.OK, "", 0, Messages.ExportAllDiagrams_18, null); //$NON-NLS-1$

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
	public ExportAllDiagrams(IFile file, String outputDirectoryPath, String extension, boolean qualifiedName) {
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
		this.qualifiedName = qualifiedName;
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
					Activator.log.error(e);
				} catch (InterruptedException e) {
					Activator.log.error(e);
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
			final ResourceSetImpl resourceSet = new ResourceSetImpl();
			TransactionalEditingDomain editingDomain = null;
			try {
				resourceSet.getLoadOptions().put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, true);
				resourceSet.getLoadOptions().put(XMLResource.OPTION_DEFER_ATTACHMENT, true);
				
				// Since the *.di file is empty as of Luna, we cannot rely on it to find all diagrams by resolving cross-references
				IPapyrusFile logical = PapyrusModelHelper.getPapyrusModelFactory().createIPapyrusFile(file);
				if(logical != null) {
					for(IResource component : logical.getAssociatedResources()) {
						if(component.getType() == IResource.FILE) {
							resourceSet.getResource(URI.createPlatformResourceURI(component.getFullPath().toString(), true), true);
						}
					}
				}
				
				// create transactional editing domain
				editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(resourceSet);
	
				AbstractTransactionalCommand com = new AbstractTransactionalCommand(editingDomain, "Resolve", Collections.emptyList()) {
	
					@Override
					protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
						EcoreUtil.resolveAll(resourceSet);
						return null;
					}
				};
	
				// bypass all the transaction/validate/notification mechanisms, it is a lot faster and it has no impact
				// since we do not modify the model
				CommandStack commandStack = editingDomain.getCommandStack();
				if(commandStack instanceof TransactionalCommandStack) {
					TransactionalCommandStack stack = (TransactionalCommandStack)commandStack;
					Map<Object, Object> options = new HashMap<Object, Object>();
					options.put(Transaction.OPTION_NO_NOTIFICATIONS, Boolean.TRUE);
					options.put(Transaction.OPTION_NO_UNDO, Boolean.TRUE);
					options.put(Transaction.OPTION_UNPROTECTED, Boolean.TRUE);
					options.put(Transaction.OPTION_IS_UNDO_REDO_TRANSACTION, Boolean.FALSE);
					options.put(Transaction.OPTION_NO_TRIGGERS, Boolean.TRUE);
					options.put(Transaction.OPTION_VALIDATE_EDIT, Boolean.FALSE);
					options.put(Transaction.OPTION_VALIDATE_EDIT_CONTEXT, Boolean.FALSE);
					try {
						stack.execute(new GMFtoEMFCommandWrapper(com), options);
					} catch (InterruptedException e) {
					} catch (RollbackException e) {
					}
				} else {
					Activator.log.warn("no transactional editing domain found");
				}
	
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
			} finally {
				// Unload the resource set so that we don't leak loads of UML content in the CacheAdapter
				unload(resourceSet);
				if(editingDomain != null) {
					editingDomain.dispose();
				}
			}
		} else {
			Activator.log.warn(Messages.ExportAllDiagrams_3);
		}

	}

	private void unload(ResourceSet resourceSet) {
		for (Resource next : resourceSet.getResources()) {
			next.unload();
			next.eAdapters().clear();
		}
		
		resourceSet.getResources().clear();
		resourceSet.eAdapters().clear();
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

				BasicDiagnostic newDiagnostic = new BasicDiagnostic(Diagnostic.WARNING, "", 0, message, null); //$NON-NLS-1$
				diagnostic.add(newDiagnostic);

			} else {
				Activator.log.info(message);
			}

		}
		int severity = diagnostic.recomputeSeverity();
		if(severity == Diagnostic.ERROR) {
			BasicDiagnostic oldDiagnostic = diagnostic;
			diagnostic = new BasicDiagnostic(Diagnostic.ERROR, "", 0, Messages.ExportAllDiagrams_22, null); //$NON-NLS-1$
			diagnostic.addAll(oldDiagnostic);
		} else if(severity == Diagnostic.WARNING) {
			BasicDiagnostic oldDiagnostic = diagnostic;
			diagnostic = new BasicDiagnostic(Diagnostic.WARNING, "", 0, Messages.ExportAllDiagrams_24, null); //$NON-NLS-1$
			diagnostic.addAll(oldDiagnostic);
		} else if(severity == Diagnostic.OK) {
			if(workbenchWindow != null && workbenchWindow.getShell() != null) {
				Display.getDefault().syncExec(new Runnable() {

					public void run() {
						MessageDialog.openInformation(Activator.getActiveWorkbenchShell(), Messages.ExportAllDiagrams_25, Messages.ExportAllDiagrams_26 + outputDirectoryPath);
					}
				});
			}
		}

		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				DiagnosticDialog.open(Activator.getActiveWorkbenchShell(), Messages.ExportAllDiagrams_27, "", diagnostic); //$NON-NLS-1$
			}
		});

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
		boolean nameCut = false;
		try {
			List<String> diagramNames = new ArrayList<String>();
			try {
				newMonitor.beginTask(Messages.ExportAllDiagrams_7, diagrams.size());
				for(final Diagram diagram : diagrams) {
					if(newMonitor.isCanceled()) {
						break;
					}
					String label = ""; //$NON-NLS-1$
					if(qualifiedName) {
						ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
						composedAdapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
						
						try {
							IItemLabelProvider itemLabelFactory = (IItemLabelProvider)composedAdapterFactory.adapt(diagram.getElement(), IItemLabelProvider.class);
							label = itemLabelFactory.getText(diagram.getElement()).replace(Messages.ExportAllDiagrams_16, "") + "_"; //$NON-NLS-1$//$NON-NLS-2$ 
						} finally {
							// Don't leak the adapters created by this factory
							composedAdapterFactory.dispose();
						}
					}
					String uniqueFileName = encodeFileName(label + diagram.getName());
					if(uniqueFileName.length() > 150) {
						nameCut = true;
						uniqueFileName = uniqueFileName.substring(0, 150);
					}
					if(diagramNames.contains(uniqueFileName)) {
						duplicates = true;
						uniqueFileName = getFirstAvailableName(uniqueFileName, diagramNames, 1);
					}

					if(nameCut) {

						BasicDiagnostic newDiagnostic = new BasicDiagnostic(Diagnostic.WARNING, "", 0, Messages.ExportAllDiagrams_10 + uniqueFileName, null); //$NON-NLS-1$
						diagnostic.add(newDiagnostic);

						nameCut = false;
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
				Activator.log.error(message, new Exception(message, e));
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
			BasicDiagnostic newDiagnostic = new BasicDiagnostic(Diagnostic.ERROR, "", 0, String.format(Messages.ExportAllDiagrams_11, uniqueFileName, diagram.eResource().getURI().toString()), null); //$NON-NLS-1$
			diagnostic.add(newDiagnostic);
			String errorMessage = String.format(Messages.ExportAllDiagrams_11, uniqueFileName, diagram.eResource().getURI().toString());
			Activator.log.error(errorMessage, e);
		}
	}

	public void unloadResources(IProgressMonitor newMonitor, List<Diagram> diagrams) {
		if(newMonitor == null) {
			newMonitor = new NullProgressMonitor();
		}
		newMonitor.subTask(Messages.ExportAllDiagrams_12);
		if(diagrams != null && !diagrams.isEmpty()) {
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
		pathName = pathName.replaceAll(Messages.ExportAllDiagrams_14, Messages.ExportAllDiagrams_15);
		pathName = pathName.replaceAll("_-_", "-"); //$NON-NLS-1$ //$NON-NLS-2$
		while(pathName.contains("__")) { //$NON-NLS-1$
			pathName = pathName.replaceAll("__", "_"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		if(pathName.startsWith("_")) { //$NON-NLS-1$
			pathName = pathName.replaceFirst("_", ""); //$NON-NLS-1$ //$NON-NLS-2$
		}
		if(pathName.endsWith("_")) { //$NON-NLS-1$
			pathName = pathName.substring(0, pathName.length() - 1);
		}

		return pathName;
		// return URLEncoder.encode(pathName, "UTF-8").replaceAll("[*]", "_");
	}

	private String getFirstAvailableName(String commonBasis, List<String> existingNames, int cpt) {
		if(existingNames.contains(commonBasis + cpt)) {
			return getFirstAvailableName(commonBasis, existingNames, cpt + 1);
		}
		return commonBasis + cpt;
	}
}
