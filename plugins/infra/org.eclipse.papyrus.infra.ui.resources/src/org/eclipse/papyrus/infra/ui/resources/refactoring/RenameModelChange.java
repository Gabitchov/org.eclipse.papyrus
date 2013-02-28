/*****************************************************************************
 * Copyright (c) 2009 Atos Origin - CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  <a href="mailto:thomas.szadel@atosorigin.com">Thomas Szadel</a> - Initial API and implementation
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.ui.resources.refactoring;

import static org.eclipse.papyrus.infra.ui.resources.Activator.log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.modelsetquery.IModelSetQueryAdapter;
import org.eclipse.papyrus.infra.core.modelsetquery.ModelSetQuery;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ModelsReader;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModelUtils;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.infra.services.controlmode.mm.history.ControledResource;
import org.eclipse.papyrus.infra.services.controlmode.mm.history.historyPackage;
import org.eclipse.papyrus.infra.ui.resources.Activator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.part.FileEditorInput;

/**
 * Rename the model.<BR>
 * <b>Note</b>: That change should be called inside a rename operation as it assumes that a {@link RenameResourceChange} occured.
 * 
 * @author tszadel
 * 
 */
public class RenameModelChange extends Change {

	private final Map<URI, URI> uriMap = new HashMap<URI, URI>();

	private final IFile oldFile;

	private final IFile newFile;

	private final Set<IResource> relatedFiles;

	private final Collection<? extends IResource> impacted;

	private TransactionalEditingDomain domain;

	private ModelSet resourceSet;

	private List<IMultiDiagramEditor> openedEditors;

	private boolean isUndoOperation;

	/**
	 * Constructor.
	 * 
	 * @param resourceSet
	 *        The resource set being changed.
	 * @param oldFile
	 *        The old file.
	 * @param newFile
	 *        The new file.
	 * @param impacted
	 */
	public RenameModelChange(IFile oldFile, IFile newFile, Collection<? extends IResource> impacted) {
		this.oldFile = oldFile;
		this.newFile = newFile;
		this.impacted = impacted;

		IPath newPathWithoutExt = newFile.getFullPath().removeFileExtension();

		// Create the map of URI that are being modified in the resource set
		relatedFiles = ModelParticipantHelpers.getRelatedFiles(oldFile);
		relatedFiles.add(oldFile);
		for(IResource file : relatedFiles) {
			IPath path = file.getFullPath();
			URI oldURI = getPlatformURI(path);
			URI newURI = getPlatformURI(newPathWithoutExt.addFileExtension(path.getFileExtension()));
			uriMap.put(oldURI, newURI);
		}
	}

	/**
	 * Overrides getModifiedElement.
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ltk.core.refactoring.Change#getModifiedElement()
	 */
	@Override
	public Object getModifiedElement() {
		return oldFile;
	}

	/**
	 * Overrides getName.
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ltk.core.refactoring.Change#getName()
	 */
	@Override
	public String getName() {
		return Messages.bind(Messages.RenameModelChange_Name, oldFile.getName());
	}

	/**
	 * Overrides initializeValidationData.
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ltk.core.refactoring.Change#initializeValidationData(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void initializeValidationData(IProgressMonitor pm) {
		// Nothing
	}

	/**
	 * Overrides isValid.
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ltk.core.refactoring.Change#isValid(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		// That change assumes that the model resource has already been renamed
		// So, the first thing to do is to get the new file, to restore it in order
		// to change all the resources.
		pm.subTask(Messages.RenameModelChange_LoadingEMF);

		pm.subTask(Messages.RenameModelChange_DaveDirtyEditor);
		// We need to get the current workbench... so we have to use the UI-Thread!
		openedEditors = new ArrayList<IMultiDiagramEditor>();
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				IMultiDiagramEditor[] multiEditors = EditorUtils.getRelatedEditors(oldFile);
				if(multiEditors != null && multiEditors.length > 0) {
					for(IMultiDiagramEditor editor : multiEditors) {
						if(editor.isDirty()) {
							editor.doSave(new NullProgressMonitor());
						}
						openedEditors.add(editor);
					}
				}
			}
		});
		pm.worked(10);

		/*
		 * Load ModelSet
		 */
		resourceSet = new ModelSet();
		try {
			ModelsReader reader = new ModelsReader();
			reader.readModel(resourceSet);
			resourceSet.loadModels(oldFile);
			for(IResource r : impacted) {
				if(r instanceof IFile) {
					IFile file = (IFile)r;
					try {
						resourceSet.getResource(URI.createPlatformResourceURI(file.getFullPath().toString(), true), true);
					} catch (Exception e) {
						// to avoid load errors 
					}
				}
			}
		} catch (Exception e) {
			Activator.log.error(e);
		}

		// Force EMF resolve and load all the resources
		try {
			EcoreUtil.resolveAll(resourceSet);
		} catch (Exception ex) {
			// the resolve all does not have to break the operation
		}

		pm.worked(4);
		domain = resourceSet.getTransactionalEditingDomain();

		// TODO improve when impact analysis will be effective
		return manageResourceSet(pm, resourceSet);
	}

	/**
	 * Get a platform resource URI of the given path
	 * 
	 * @param path
	 *        the path
	 * @return the uri
	 */
	private URI getPlatformURI(IPath path) {
		return URI.createPlatformResourceURI(path.toString(), true);
	}


	/**
	 * Overrides perform.
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ltk.core.refactoring.Change#perform(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public Change perform(IProgressMonitor pm) throws CoreException {

		String lMsg = Messages.bind(Messages.RenameModelChange_Change, oldFile.getName(), newFile.getName());
		isUndoOperation = oldFile.exists() && !newFile.exists();

		if(!isUndoOperation) {
			//The file has already been renamed. Undo the rename change, then do the full refactoring in the resource set
			newFile.move(oldFile.getFullPath(), true, new SubProgressMonitor(pm, 1));
		}

		Set<IResource> revertImpactedFiles = getRevertImpactedResources();

		pm.beginTask(lMsg, 30);
		try {
			doRun(pm, resourceSet, domain);
			// Now, save all the resources
			pm.subTask(Messages.RenameModelChange_savingResource);
			for(Resource res : resourceSet.getResources()) {
				if(res.getURI().isPlatformResource()) {
					try {
						res.save(null);
					} catch (Exception e) {
						log.error(Messages.bind(Messages.RenameModelChange_ErrorLoading, res.getURI()), e);
					}
				}
			}
			pm.worked(5);

			// Do not forget to unload all the resources to avoid memory leak
			pm.subTask(Messages.RenameModelChange_Unloading);
			resourceSet.unload();
			pm.worked(1);

			// Now, notify the editor of the change
			if(!openedEditors.isEmpty()) {
				Display.getDefault().syncExec(new Runnable() {

					public void run() {
						// Get the DI file as the rename could occur on any model's file.
						IFile newDiFile = DiModelUtils.getRelatedDiFile(newFile);
						for(IMultiDiagramEditor editor : openedEditors) {
							try {
								ModelSet diRes = editor.getServicesRegistry().getService(ModelSet.class);
								if(diRes != null) {
									diRes.saveAs(newFile.getFullPath());
								}
								editor.setEditorInput(new FileEditorInput(newDiFile));

							} catch (ServiceException e) {
								log.error(e);
							} catch (IOException e) {
								log.error(e);
							}
						}
					}
				});
			}

			// Then, remove the old model files
			pm.subTask(Messages.RenameModelChange_RemoveOldFile);
			for(IResource file : relatedFiles) {
				if(file.exists()) {
					file.delete(true, new NullProgressMonitor());
				}
			}
			pm.worked(4);

			RenameModelChange undoChange = new RenameModelChange(newFile, oldFile, revertImpactedFiles);

			if(isUndoOperation) {
				//Restore the expected state for the basic rename change
				newFile.move(oldFile.getFullPath(), true, new SubProgressMonitor(pm, 1));
			}

			//Invert the change
			return undoChange;
		} finally {
			pm.done();
		}
	}

	private Set<IResource> getRevertImpactedResources() {
		Set<IResource> result = new HashSet<IResource>();

		Set<IResource> relatedFiles = ModelParticipantHelpers.getRelatedFiles(oldFile);
		relatedFiles.add(oldFile);

		for(IResource initialResource : impacted) {
			if(relatedFiles.contains(initialResource)) {
				IResource invertedResource = invertFileName(initialResource);
				result.add(invertedResource); //Participant model (the file is renamed)
			} else {
				result.add(initialResource); //Client model (only links are modified)
			}
		}

		return result;
	}

	private IResource invertFileName(IResource initialResource) {
		String newName;

		IPath pathWithoutExtension = newFile.getFullPath().removeFileExtension();
		IPath pathWithExtension = pathWithoutExtension.addFileExtension(initialResource.getFileExtension());
		newName = pathWithExtension.lastSegment();

		IFile newFile = oldFile.getParent().getFile(new Path(newName));

		return newFile;
	}

	private RefactoringStatus manageResourceSet(final IProgressMonitor pm, final ModelSet resourceSet) {

		final Collection<Resource> readOnlies = new HashSet<Resource>();
		// for each object of the resources renamed, the refactor will search if a resource is read only or not
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				for(URI uri : uriMap.keySet()) {
					Resource r = resourceSet.getResource(uri, false);
					ECrossReferenceAdapter adapter = ECrossReferenceAdapter.getCrossReferenceAdapter(resourceSet);
					if(adapter == null) {
						adapter = new ECrossReferenceAdapter();
						adapter.setTarget(resourceSet);
					}
					if(r != null) {
						for(Iterator<EObject> i = EcoreUtil.getAllProperContents(r, false); i.hasNext();) {
							EObject e = i.next();
							Collection<Setting> references = adapter.getInverseReferences(e);
							for(Setting s : references) {
								EObject eObject = s.getEObject();
								if(eObject != null && eObject.eResource() != null && domain.isReadOnly(eObject.eResource())) {
									readOnlies.add(eObject.eResource());
								}
							}
						}
					}
				}

			}
		});
		// if read only => error to the user
		if(!readOnlies.isEmpty()) {
			StringBuffer buffer = new StringBuffer("The resources listed are read only, the rename process can not continue : ");
			int i = 0;
			for(Resource r : readOnlies) {
				if(i != 0) {
					buffer.append(", ");
				}
				buffer.append(r.getURI().toString());
				i++;
			}
			return RefactoringStatus.create(new Status(IStatus.ERROR, Activator.PLUGIN_ID, buffer.toString()));
		}
		return new RefactoringStatus();

	}

	private void doRun(final IProgressMonitor pm, final ModelSet resourceSet, final TransactionalEditingDomain domain) {
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				// Manage Controlled map to ensure consistent history
				// TODO change this code when history will be useless
				URI modifiedURI = URI.createPlatformResourceURI(oldFile.getFullPath().removeFileExtension().toString(), true);
				IModelSetQueryAdapter controledResourcesAdapter = ModelSetQuery.getExistingTypeCacheAdapter(resourceSet);
				if(controledResourcesAdapter != null) {
					EObject first = null;
					for(Iterator<Notifier> i = resourceSet.getAllContents(); i.hasNext();) {
						Notifier n = i.next();
						if(n instanceof EObject) {
							first = (EObject)n;
							break;
						}
					}
					if(first != null) {
						Collection<EObject> resources = null;
						try {
							resources = controledResourcesAdapter.getReachableObjectsOfType(first, historyPackage.Literals.CONTROLED_RESOURCE);
						} catch (RuntimeException e) {
							// in case of errors integrity must be valid 
							// even performances are bad
							resources = new LinkedList<EObject>();
							for(int i = 0; i < resourceSet.getResources().size(); i++) {
								Resource r = resourceSet.getResources().get(i);
								for(Iterator<EObject> it = r.getAllContents(); it.hasNext();) {
									EObject tmp = it.next();
									if(tmp instanceof ControledResource) {
										ControledResource controled = (ControledResource)tmp;
										resources.add(controled);
									}
								}
							}
						}
						for(EObject e : resources) {
							if(e instanceof ControledResource) {
								ControledResource controled = (ControledResource)e;
								URI baseURI = URI.createURI(e.eResource().getURI().trimSegments(1).trimFragment().toString() + "/");
								URI resolvedURI = URI.createURI(controled.getResourceURL()).resolve(baseURI);
								if(resolvedURI.trimFileExtension().equals(modifiedURI.trimFileExtension())) {
									String ext = resolvedURI.fileExtension();
									URI newURL = URI.createURI(resolvedURI.trimSegments(1).toString() + "/" + newFile.getFullPath().removeFileExtension().lastSegment().toString() + "." + ext);
									controled.setResourceURL(newURL.deresolve(baseURI).toString());
								}
							}
						}
					}
				}
			}
		});
		// Change the uri of the files
		pm.subTask(Messages.RenameModelChange_ModifyURI);
		for(Resource res : resourceSet.getResources()) {
			if(res.getURI().isPlatformResource()) {
				URI newURI = uriMap.get(res.getURI());
				if(newURI != null) {
					if(log.isDebugEnabled()) {
						log.debug(Messages.bind(Messages.RenameModelChange_6, Arrays.asList(res.getURI(), newURI)));
					}
					res.setURI(newURI);
				}
			}

		}
		pm.worked(5);


	}
}
