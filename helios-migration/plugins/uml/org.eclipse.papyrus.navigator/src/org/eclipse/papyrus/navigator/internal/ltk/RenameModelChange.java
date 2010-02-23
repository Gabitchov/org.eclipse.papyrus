/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  <a href="mailto:thomas.szadel@atosorigin.com">Thomas Szadel</a> - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.navigator.internal.ltk;

import static org.eclipse.papyrus.navigator.internal.Activator.log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.resource.RenameResourceChange;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.core.utils.EditorUtils;
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

	/**
	 * Constructor.
	 * 
	 * @param resourceSet
	 *        The resource set being changed.
	 * @param oldFile
	 *        The old file.
	 * @param newFile
	 *        The new file.
	 */
	public RenameModelChange(IFile oldFile, IFile newFile) {
		this.oldFile = oldFile;
		this.newFile = newFile;

		IPath oldPathWithoutExt = oldFile.getFullPath().removeFileExtension();
		IPath newPathWithoutExt = newFile.getFullPath().removeFileExtension();

		// Create the map of URI that are being modified in the resource set
		for(String ext : IModelParticipantConstants.MODEL_EXTENSIONS) {
			URI oldURI = getPlatformURI(oldPathWithoutExt.addFileExtension(ext));
			URI newURI = getPlatformURI(newPathWithoutExt.addFileExtension(ext));
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
		return "Update all resources related to " + oldFile.getName();
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
		return new RefactoringStatus();
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
		String lMsg = "Rename " + oldFile.getName() + " to " + newFile.getName();
		log.info(lMsg);
		pm.beginTask(lMsg, 30);
		try {
			// That change assumes that the model resource has already been renamed
			// So, the first thing to do is to get the new file, to restore it in order
			// to change all the resources.
			pm.subTask("Loading EMF model into memory");

			boolean isUndoOperation = oldFile.exists() && !newFile.exists();
			if(!isUndoOperation) {
				newFile.move(oldFile.getFullPath(), true, new SubProgressMonitor(pm, 1));
			}

			pm.subTask("Saving dirty editors");
			// We need to get the current workbench... so we have to use the UI-Thread!
			final List<IMultiDiagramEditor> openedEditors = new ArrayList<IMultiDiagramEditor>();
			Display.getDefault().syncExec(new Runnable() {

				public void run() {
					IMultiDiagramEditor[] multiEditors = EditorUtils.getRelatedEditors(oldFile);
					if(multiEditors != null) {
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

			// Then, we can load the resource set as the file structure is now correct
			DiResourceSet resourceSet = new DiResourceSet();
			resourceSet.loadResources(oldFile);
			// Force EMF resolve and load all the resources
			EcoreUtil.resolveAll(resourceSet);
			pm.worked(4);

			// Change the URIs of modified resources
			pm.subTask("Modifying resources' URI");
			for(Resource res : resourceSet.getResources()) {
				URI newURI = uriMap.get(res.getURI());
				if(newURI != null) {
					if(log.isDebugEnabled()) {
						log.debug("Changing URI " + res.getURI() + " into " + newURI);
					}
					res.setURI(newURI);
				}
			}
			pm.worked(5);

			// Now, save all the resources
			Map<?, ?> options = new HashMap();
			pm.subTask("Saving resources");
			for(Resource res : resourceSet.getResources()) {
				try {
					res.save(options);
				} catch (IOException e) {
					log.error("Error while loading resource " + res.getURI(), e);
				}
			}
			pm.worked(5);

			// Do not forget to unload all the resources to avoid memory leak
			pm.subTask("Unloading model");
			resourceSet.unload();
			pm.worked(1);

			// Now, notify the editor of the change
			if(!openedEditors.isEmpty()) {
				Display.getDefault().syncExec(new Runnable() {

					public void run() {
						// Get the DI file as the rename could occur on any model's file.
						IFile newDiFile = DiResourceSet.getRelatedDiFile(newFile);
						for(IMultiDiagramEditor editor : openedEditors) {
							try {
								DiResourceSet diRes = editor.getServicesRegistry().getService(DiResourceSet.class);
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
			IContainer parent = oldFile.getParent();
			IPath oldPathWithoutExt = oldFile.getFullPath().removeFileExtension().makeRelativeTo(parent.getFullPath());
			pm.subTask("Removing old files");
			for(String ext : IModelParticipantConstants.MODEL_EXTENSIONS) {
				IFile file = parent.getFile(oldPathWithoutExt.addFileExtension(ext));
				// Do not remove the file that is being renamed
				if(file.exists()) {
					file.delete(true, new NullProgressMonitor());
				}
			}
			pm.worked(4);

			if(isUndoOperation) {
				newFile.move(oldFile.getFullPath(), true, new SubProgressMonitor(pm, 1));
			}

			return new RenameModelChange(newFile, oldFile);
		} finally {
			pm.done();
		}
	}
}
