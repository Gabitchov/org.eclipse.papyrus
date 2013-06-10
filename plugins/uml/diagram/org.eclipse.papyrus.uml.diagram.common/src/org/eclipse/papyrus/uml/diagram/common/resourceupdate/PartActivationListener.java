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
 *  Vincent Hemery (Atos) - Also take in account modifications for sub-models
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.resourceupdate;

import static org.eclipse.papyrus.uml.diagram.common.Activator.log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.infra.services.resourceloading.util.LoadingUtils;
import org.eclipse.papyrus.uml.diagram.common.Messages;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

/**
 * A listener for part activation. Will ask the user whether to reload when he
 * enters an editor whose underlying resources have changed, used to trigger an
 * update of
 * 
 * @author Ansgar Radermacher (CEA LIST)
 * 
 * @deprecated The equivalent behavior has been implemented in oep.infra.core
 */
@Deprecated
public class PartActivationListener implements IPartListener {

	/**
	 * This class is a simple pair storing a resource delta and whether this delta causes conflict with editor's resource
	 * 
	 * @author vhemery
	 */
	private static class ResourceModification {

		private IResourceDelta delta;

		private boolean conflict;

		public ResourceModification(IResourceDelta resourceDelta, boolean resourceConflicts) {
			delta = resourceDelta;
			conflict = resourceConflicts;
		}
	}

	/** editor to update when activated */
	private IMultiDiagramEditor editor;

	/** paths for modified main resources */
	private List<IPath> changedMainResourcePaths;

	/** modifications performed on all edited resources */
	private Map<IPath, ResourceModification> resourceModifications;

	public PartActivationListener(IMultiDiagramEditor editor) {
		this.editor = editor;
		resourceModifications = new HashMap<IPath, ResourceModification>();
		changedMainResourcePaths = new ArrayList<IPath>();
	}

	/**
	 * Test if main model has changed
	 * 
	 * @return true, when a resource for the underlying editor's main model has been updated
	 * @deprecated use {@link #isMainModelModified()} instead
	 */
	@Deprecated
	public boolean isModied() {
		return isMainModelModified();
	}

	/**
	 * Test if main model has changed
	 * 
	 * @return true, when a resource for the underlying editor's main model has been updated
	 */
	public boolean isMainModelModified() {
		return !changedMainResourcePaths.isEmpty();
	}

	/**
	 * Check if an underlying resource has changed
	 * 
	 * @param resourcePathToTest
	 *        path of resource to check changes for (including file extension)
	 * @return true, when this resource has been updated for this underlying editor
	 */
	public boolean isModified(IPath resourcePathToTest) {
		return resourceModifications.containsKey(resourcePathToTest);
	}

	/**
	 * indicate that the resource for an editor have been modified
	 * 
	 * @param changedResourcePath
	 *        The path to the resource that has been changed
	 * @param delta
	 *        additional information about the change
	 * @deprecated use {@link #setModificationData(IPath, IResourceDelta, boolean)} instead
	 */
	@Deprecated
	public void setModificationData(String changedResourcePath, IResourceDelta delta) {
		IPath path = Path.fromPortableString(changedResourcePath);
		setModificationData(path, delta, true, true);
	}

	/**
	 * Indicates that a resource for an editor has been modified
	 * 
	 * @param changedResourcePath
	 *        The path to the resource that has been changed (including file extension)
	 * @param delta
	 *        additional information about the change
	 * @param isMainResource
	 *        true if resource is part of the main model
	 * @param resourceConflicts
	 *        true if the resource contains modifications that should conflict with these changes
	 */
	public void setModificationData(IPath changedResourcePath, IResourceDelta delta, boolean isMainResource, boolean resourceConflicts) {
		if(resourceModifications.containsKey(changedResourcePath)) {
			//merge two modifications : 1. merge conflicts the pessimistic way
			resourceModifications.get(changedResourcePath).conflict |= resourceConflicts;
			//merge two modifications : 2. take latest delta
			/*
			 * Some delta information is lost, but kind is the best one :
			 * If new delta kind is REMOVED, then ok : resource removed at the end
			 * If new delta kind is ADDED, then there should not be any delta before
			 * If new delta kind is CHANGED, then the action taken for CHANGED is more suitable than others
			 */
			resourceModifications.get(changedResourcePath).delta = delta;
		}
		resourceModifications.put(changedResourcePath, new ResourceModification(delta, resourceConflicts));
		if(isMainResource) {
			changedMainResourcePaths.add(changedResourcePath);
		}
	}

	public void partActivated(IWorkbenchPart part) {
		// don't use (part == editor.getSite().getPart()), since different views
		// (e.g. model explorer or property)
		// of an active editor may actually be selected
		IMultiDiagramEditor activeEditor = EditorUtils.getMultiDiagramEditor();

		if((editor == activeEditor) && !resourceModifications.isEmpty()) {
			// the byte union of all kinds of delta met for main resource
			int mainDeltaKinds = 0;
			if(!changedMainResourcePaths.isEmpty()) {
				// look up deltas for the main model
				for(IPath mainPath : changedMainResourcePaths) {
					ResourceModification modif = resourceModifications.get(mainPath);
					mainDeltaKinds |= modif.delta.getKind();
				}
			}
			// handle change in any resource model (eventually main model or sub-model)
			int deltaKinds = 0;// the byte union of all kinds of delta met for all resources
			Set<String> addedModels = new HashSet<String>();
			Set<String> removedModels = new HashSet<String>();
			// store conflicts in addition for changed models
			Map<String, Boolean> changedModels = new HashMap<String, Boolean>();
			for(Entry<IPath, ResourceModification> entry : resourceModifications.entrySet()) {
				IPath path = entry.getKey();
				ResourceModification modif = entry.getValue();
				deltaKinds |= modif.delta.getKind();
				switch(modif.delta.getKind()) {
				case IResourceDelta.ADDED:
					addedModels.add(path.removeFileExtension().toString());
					break;
				case IResourceDelta.REMOVED:
					removedModels.add(path.removeFileExtension().toString());
					break;
				case IResourceDelta.CHANGED:
					String key = path.removeFileExtension().toString();
					// do not erase value if a conflicting resource has already been met for this model
					if(!changedModels.containsKey(key) || !changedModels.get(key)) {
						changedModels.put(key, modif.conflict);
					}
					break;
				default:
					break;
				}
			}
			handleDeltaKinds(deltaKinds, addedModels, removedModels, changedModels, mainDeltaKinds);
			// reinitialize modifications fields
			changedMainResourcePaths.clear();
			resourceModifications.clear();
		}
	}

	/**
	 * Handle delta kinds with appropriate message and editor action.
	 * 
	 * @param deltaKinds
	 *        the byte union of met deltas (on all resources)
	 * @param addedModels
	 *        the models with added delta (taken in account if (deltaKinds & IResourceDelta.ADDED) > 0)
	 * @param removedModels
	 *        the models with removed delta (taken in account if (deltaKinds & IResourceDelta.REMOVED) > 0)
	 * @param changedModels
	 *        the models with changed delta (taken in account if (deltaKinds & IResourceDelta.CHANGED) > 0) and whether they conflict with current
	 *        editor's changes
	 * @param mainDeltaKinds
	 *        the byte union of met deltas (on main resources only)
	 */
	private void handleDeltaKinds(int deltaKinds, Set<String> addedModels, Set<String> removedModels, Map<String, Boolean> changedModels, int mainDeltaKinds) {
		// use masks to check encountered delta types
		if((deltaKinds & IResourceDelta.ADDED) > 0) {
			// no particular treatment
		}
		if((deltaKinds & IResourceDelta.REMOVED) > 0) {
			// asynchronous notification to avoid that the removal of
			// multiple resource files
			// belonging to the editor (e.g. .uml and .notation) at the same
			// time leads to multiple
			// user feedback.
			String msg = ""; //$NON-NLS-1$
			String list = getModelsListString(removedModels);
			if(removedModels.size() == 1) {
				msg = String.format(Messages.PartActivationListener_RemovedMsg_single, list);
			} else {
				msg = String.format(Messages.PartActivationListener_RemovedMsg_many, list);
			}
			MessageDialog.openInformation(new Shell(), Messages.PartActivationListener_RemovedTitle, msg);
		}
		if((deltaKinds & IResourceDelta.CHANGED) > 0) {
			// reopen the editor asynchronously to avoid that changes of
			// multiple resource files
			// belonging to the editor (e.g. .uml and .notation) lead to
			// multiple reloads.
			// de-activate until user responds to message dialog
			boolean mainChanged = (mainDeltaKinds & IResourceDelta.CHANGED) > 0;
			String msg = ""; //$NON-NLS-1$
			String list = getModelsListString(changedModels.keySet());
			if(changedModels.size() == 1 && mainChanged) {
				msg = String.format(Messages.PartActivationListener_ChangedMainMsg_single, list);
			} else if(mainChanged) {
				msg = String.format(Messages.PartActivationListener_ChangedMainMsg_many, list);
			} else if(changedModels.size() == 1) {
				msg = String.format(Messages.PartActivationListener_ChangedMsg_single, list);
			} else {
				msg = String.format(Messages.PartActivationListener_ChangedMsg_many, list);
			}
			if(editor.isDirty() && mainChanged) {
				msg += System.getProperty("line.separator"); //$NON-NLS-1$
				msg += System.getProperty("line.separator"); //$NON-NLS-1$
				msg += Messages.PartActivationListener_ChangedMainWarning;
			} else if(editor.isDirty()) {
				// select conflicting models only
				HashSet<String> dirtyModels = new HashSet<String>(changedModels.size());
				for(Entry<String, Boolean> entry : changedModels.entrySet()) {
					if(entry.getValue()) {
						dirtyModels.add(entry.getKey());
					}
				}
				if(!dirtyModels.isEmpty()) {
					String dirtyList = getModelsListString(dirtyModels);
					msg += System.getProperty("line.separator"); //$NON-NLS-1$
					msg += System.getProperty("line.separator"); //$NON-NLS-1$
					msg += String.format(Messages.PartActivationListener_ChangedWarning, dirtyList);
				}
			}

			if(MessageDialog.openQuestion(new Shell(), Messages.PartActivationListener_ChangedTitle, msg)) {
				if(mainChanged) {
					// unloading and reloading all resources of the main causes
					// the following problems
					// - since resources are removed during the modelSets unload
					// operation, the call eResource().getContents ()
					// used by the model explorer leads to a null pointer
					// exception
					// - diagrams in model explorer are not shown
					// - would need to reset dirty flags
					// => clean & simple option is to close and reopen the
					// editor.
					Display.getCurrent().asyncExec(new Runnable() {

						public void run() {
							IWorkbench wb = PlatformUI.getWorkbench();
							IWorkbenchPage page = wb.getActiveWorkbenchWindow().getActivePage();
							IEditorInput input = editor.getEditorInput();
							page.closeEditor(editor, false);
							try {
								IEditorDescriptor desc = wb.getEditorRegistry().getDefaultEditor(input.getName());
								page.openEditor(input, desc.getId(), false);
							} catch (PartInitException e) {
								log.error(e);
							}
						}
					});
				} else {
					// sub models can be reloaded on their own without reloading the whole model
					Object dom = editor.getAdapter(EditingDomain.class);
					if(dom instanceof EditingDomain) {
						Command refreshCmd = getRefreshCommand((EditingDomain)dom, changedModels.keySet());
						if(refreshCmd.canExecute()) {
							((EditingDomain)dom).getCommandStack().execute(refreshCmd);
						}
					}
				}
			}
		}
	}

	/**
	 * Get the command to refresh the changed models
	 * 
	 * @param domain
	 *        editing domain
	 * @param changedModels
	 *        the models to refresh
	 * @return the command to refresh all changed models
	 */
	private Command getRefreshCommand(final EditingDomain domain, final Set<String> changedModels) {
		Command refreshCmd = new AbstractCommand() {

			/** Model set in which to refresh models */
			private ModelSet modelSet;

			/** URIs of models to update */
			List<URI> urisToUpdate;

			public void execute() {
				for(URI uri : urisToUpdate) {
					LoadingUtils.unloadResourcesFromModelSet(modelSet, uri, false);
					LoadingUtils.loadResourcesInModelSet(modelSet, uri);
				}
			}

			public void redo() {
				execute();
			}

			@Override
			public void undo() {
				execute();
			}

			@Override
			protected boolean prepare() {
				ResourceSet set = domain.getResourceSet();
				if(set instanceof ModelSet) {
					modelSet = (ModelSet)set;
					urisToUpdate = new ArrayList<URI>(changedModels.size());
					for(String pathString : changedModels) {
						IPath path = Path.fromPortableString(pathString);
						urisToUpdate.add(URI.createPlatformResourceURI(path.toString(), true));
					}
					return true;
				}
				return false;
			}

		};
		return refreshCmd;
	}

	/**
	 * Get formatted string with all models of the set displayed in it, separated with a line separator.
	 * An additional separator is added at the beginning to allow separate display of the list in case there are several elements.
	 * 
	 * @param models
	 *        set of models path
	 * @return formatted list string
	 */
	private String getModelsListString(Set<String> models) {
		StringBuffer list = new StringBuffer();
		Iterator<String> it = models.iterator();
		if(models.size() == 1) {
			return it.next();
		}
		while(it.hasNext()) {
			String model = it.next();
			list.append(System.getProperty("line.separator")); //$NON-NLS-1$
			list.append(model);
		}
		return list.toString();
	}

	public void partDeactivated(IWorkbenchPart part) {
	}

	public void partBroughtToTop(IWorkbenchPart part) {
	}

	public void partClosed(IWorkbenchPart part) {
	}

	public void partOpened(IWorkbenchPart part) {
	}
}
