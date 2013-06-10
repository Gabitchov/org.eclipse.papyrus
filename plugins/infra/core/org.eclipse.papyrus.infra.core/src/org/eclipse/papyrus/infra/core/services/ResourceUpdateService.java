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
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.services;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.infra.core.Activator;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.lifecycleevents.DoSaveEvent;
import org.eclipse.papyrus.infra.core.lifecycleevents.ILifeCycleEventsProvider;
import org.eclipse.papyrus.infra.core.lifecycleevents.ISaveAndDirtyService;
import org.eclipse.papyrus.infra.core.lifecycleevents.ISaveEventListener;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;

/**
 * A Service to check workspace modifications on current resources
 * 
 * @author Camille Letavernier
 * 
 */
public class ResourceUpdateService implements IService, IPartListener {

	protected ServicesRegistry registry;

	protected ModelSet modelSet;

	static int[] handledTypes = new int[]{ IResourceChangeEvent.POST_CHANGE, IResourceChangeEvent.PRE_DELETE, IResourceChangeEvent.PRE_CLOSE };

	protected boolean isSaving;

	private final ISaveEventListener preSaveListener = new ISaveEventListener() {

		public void doSaveAs(DoSaveEvent event) {
			isSaving = true;
		}

		public void doSave(DoSaveEvent event) {
			isSaving = true;
		}
	};

	private final ISaveEventListener postSaveListener = new ISaveEventListener() {

		public void doSaveAs(DoSaveEvent event) {
			isSaving = false;
		}

		public void doSave(DoSaveEvent event) {
			isSaving = false;
		}
	};

	public void init(ServicesRegistry servicesRegistry) throws ServiceException {
		this.registry = servicesRegistry;
	}

	public void startService() throws ServiceException {
		ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceChangeListener, IResourceChangeEvent.POST_CHANGE);
		modelSet = registry.getService(ModelSet.class);
		registry.getService(ILifeCycleEventsProvider.class).addAboutToDoSaveListener(preSaveListener);
		registry.getService(ILifeCycleEventsProvider.class).addPostDoSaveListener(postSaveListener);
	}

	public void disposeService() throws ServiceException {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceChangeListener);
		modelSet = null;
	}

	protected void closeEditor() {
		closeEditor(false, false);
	}

	protected void closeEditor(final boolean save, final boolean reopen) {
		try {
			final IMultiDiagramEditor editor = registry.getService(IMultiDiagramEditor.class);
			if(editor != null) {
				editor.getSite().getShell().getDisplay().syncExec(new Runnable() {

					public void run() {
						final IWorkbenchPage page = editor.getSite().getPage();
						final IEditorInput currentInput = editor.getEditorInput();


						final String editorId = editor.getSite().getId();

						if(save) {
							editor.doSave(new NullProgressMonitor());
						}
						page.closeEditor(editor, save);
						if(reopen) {
							Display.getCurrent().asyncExec(new Runnable() {

								public void run() {
									try {
										IDE.openEditor(page, currentInput, editorId);
									} catch (PartInitException ex) {
										Activator.log.error(ex);
									}
								}
							});
						}
					}
				});
			}

		} catch (ServiceException ex) {
			//Nothing
		}
	}

	protected void handleResourcesRemoved(Collection<Resource> emfResources) {
		try {
			if(!registry.getService(ISaveAndDirtyService.class).isDirty()) {
				closeEditor();
				return;
			}

		} catch (ServiceException ex) {
			//Ignored
		}

		if(isAllReadOnly(emfResources)) {
			//Only read-only models have changed. We (most likely) won't save them within this current editor. As they are already loaded, we can just continue.
			Display.getDefault().syncExec(new Runnable() {

				public void run() {
					Shell parentShell = Display.getCurrent().getActiveShell();
					MessageDialog dialog = new MessageDialog(parentShell, "Resources changed", null, "Some resources used by '" + modelSet.getURIWithoutExtension().lastSegment() + "' have been removed. Note: all these resources are loaded in read-only mode and won't be overriden if you choose to save. Unsaved changes will be lost.", MessageDialog.QUESTION, new String[]{ "Close editor", "Save and close", "Ignore" }, 1);

					switch(dialog.open()) {
					case 0: //Close editor
						closeEditor(false, false);
						break;
					case 1: //Save & close
						closeEditor(true, false);
						break;
					case 2: //Ignore;
						break; //Do nothing
					}

				}
			});

		} else {
			//At least one read-write resource has changed. Potential conflicts.
			Display.getDefault().syncExec(new Runnable() {

				public void run() {
					if(MessageDialog.openConfirm(Display.getCurrent().getActiveShell(), "Resources removed", "Some resources used by '" + modelSet.getURIWithoutExtension().lastSegment() + "' have been removed. Do you wish to close the current editor? Unsaved changes will be lost.")) {
						closeEditor();
					}
				}
			});
		}

		return;
	}

	protected boolean isAllReadOnly(Collection<Resource> resources) {
		for(Resource resource : resources) {
			EditingDomain domain = TransactionUtil.getEditingDomain(resource);
			if(domain == null) {
				System.out.println("Cannot find domain for " + resource.getURI());
				return false;
			}
			if(!domain.isReadOnly(resource)) {
				return false;
			}
		}

		return true;
	}

	//ID for Close (or reopen) without save
	protected static final int CLOSE_WITHOUT_SAVE = 0;

	//ID for Save and close (or reopen)
	protected static final int SAVE_AND_CLOSE = 1;

	//ID for ignoring the modifications
	protected static final int IGNORE = 2;

	protected void handleResourceChanged(Collection<Resource> emfResources) {
		try {
			if(!registry.getService(ISaveAndDirtyService.class).isDirty()) {
				closeEditor(false, true);
				return;
			}
		} catch (ServiceException ex) {
			//Ignored
		}

		boolean allReadOnly = isAllReadOnly(emfResources);

		if(allReadOnly) {
			//Only read-only models have changed. We (most likely) won't save them within this current editor. As they are already loaded, we can just continue.
			Display.getDefault().syncExec(new Runnable() {

				public void run() {
					Shell parentShell = Display.getCurrent().getActiveShell();
					MessageDialog dialog = new MessageDialog(parentShell, "Resources changed", null, "Some resources used by '" + modelSet.getURIWithoutExtension().lastSegment() + "' have changed. Note: all these resources are loaded in read-only mode and won't be overriden if you choose to save. Unsaved changes will be lost.", MessageDialog.WARNING, new String[]{ "Reopen editor", "Save and reopen", "Ignore" }, 1);

					switch(dialog.open()) {
					case CLOSE_WITHOUT_SAVE:
						closeEditor(false, true);
						break;
					case SAVE_AND_CLOSE:
						closeEditor(true, true);
						break;
					case IGNORE:
						break; //Do nothing
					}

				}
			});

		} else {
			//At least one read-write resource has changed. Potential conflicts.
			Display.getDefault().syncExec(new Runnable() {

				public void run() {
					final Shell parentShell = Display.getCurrent().getActiveShell();
					if(MessageDialog.openConfirm(parentShell, "Resources changed", "Some resources used by the model '" + modelSet.getURIWithoutExtension().lastSegment() + "' have changed. Do you want to reopen the current editor? Unsaved changes will be lost.")) {
						closeEditor(false, true);
					}
				}
			});
		}
	}

	//Copied from org.eclipse.emf.ecore.presentation.EcoreEditor
	protected IResourceChangeListener resourceChangeListener = new IResourceChangeListener() {

		public void resourceChanged(IResourceChangeEvent event) {
			IResourceDelta delta = event.getDelta();
			try {
				class ResourceDeltaVisitor implements IResourceDeltaVisitor {

					protected Collection<Resource> changedResources = new ArrayList<Resource>();

					protected Collection<Resource> removedResources = new ArrayList<Resource>();

					public boolean visit(final IResourceDelta delta) {
						if(delta.getResource().getType() == IResource.FILE) {
							if(delta.getKind() == IResourceDelta.REMOVED || delta.getKind() == IResourceDelta.CHANGED) {
								final Resource resource = modelSet.getResource(URI.createPlatformResourceURI(delta.getFullPath().toString(), true), false);
								if(resource != null) {
									if(delta.getKind() == IResourceDelta.REMOVED) {
										removedResources.add(resource);
									} else {
										if((delta.getFlags() & IResourceDelta.MARKERS) != 0) {
											//Skip markers
											//DiagnosticDecorator.DiagnosticAdapter.update(resource, markerHelper.getMarkerDiagnostics(resource, (IFile)delta.getResource()));
										}
										if((delta.getFlags() & IResourceDelta.CONTENT) != 0) {
											//if(!savedResources.remove(resource)) {
											//		changedResources.add(resource);
											//}
											if(!isSaving) {
												changedResources.add(resource);
											}
										}
									}
								}
							}
							return false;
						}

						return true;
					}

					public Collection<Resource> getChangedResources() {
						return changedResources;
					}

					public Collection<Resource> getRemovedResources() {
						return removedResources;
					}
				}

				final ResourceDeltaVisitor visitor = new ResourceDeltaVisitor();

				delta.accept(visitor);

				if(!visitor.getRemovedResources().isEmpty()) {
					handleResourcesRemoved(visitor.getRemovedResources());
				}

				if(!visitor.getChangedResources().isEmpty()) {
					handleResourceChanged(visitor.getChangedResources());
				}
			} catch (CoreException exception) {
				Activator.log.error(exception);
			}
		}
	};

	public void partActivated(IWorkbenchPart part) {
		//Nothing
	}

	public void partBroughtToTop(IWorkbenchPart part) {
		//Nothing
	}

	public void partClosed(IWorkbenchPart part) {
		//Nothing
	}

	public void partDeactivated(IWorkbenchPart part) {
		//Nothing
	}

	public void partOpened(IWorkbenchPart part) {
		//Nothing
	}

}
