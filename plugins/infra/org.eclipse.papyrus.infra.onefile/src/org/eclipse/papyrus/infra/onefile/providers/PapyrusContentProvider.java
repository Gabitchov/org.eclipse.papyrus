/*****************************************************************************
 * Copyright (c) 2011 Atos Origin Integration - CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (Atos Origin Integration) tristan.faure@atosorigin.com - Initial API and implementation
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.infra.onefile.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.onefile.matcher.OnlyDiFilter;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;
import org.eclipse.papyrus.infra.onefile.model.PapyrusModelHelper;
import org.eclipse.papyrus.infra.onefile.utils.OneFileUtils;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.navigator.CommonViewer;

/**
 * Content provider able to retrieve Papyrus children from an {@link IContainer}
 * 
 * @author Tristan FAURE
 * 
 */
public class PapyrusContentProvider extends WorkbenchContentProvider {


	private CommonViewer common;


	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		super.inputChanged(viewer, oldInput, newInput);
		if(viewer instanceof CommonViewer) {
			common = (CommonViewer)viewer;
		}
	}

	/**
	 * Determine if the current navigator is filtered or not
	 * 
	 * @return true if the viewer is filtered
	 */
	public boolean isFiltered() {
		return common != null && common.getNavigatorContentService() != null && common.getNavigatorContentService().getFilterService() != null && common.getNavigatorContentService().getFilterService().isActive(OnlyDiFilter.FILTER_ID);
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public Object[] getElements(Object inputElement) {
		if(inputElement instanceof IWorkspaceRoot) {
			return null;
		}
		List<Object> result = new LinkedList<Object>();
		try {
			if(isFiltered()) {
				if(inputElement instanceof IPapyrusFile) {
					IPapyrusFile file = (IPapyrusFile)inputElement;
					for(IResource r : file.getAssociatedResources()) {
						result.add(PapyrusModelHelper.getPapyrusModelFactory().createISubResourceFile(file, (IFile)r));
					}
				} else {
					IResource[] members = null;
					if(inputElement instanceof IContainer) {
						members = ((IContainer)inputElement).members();
					}
					if(members != null) {
						for(IResource r : members) {
							if(r instanceof IContainer && !(r instanceof IProject)) {
								IContainer cont = (IContainer)r;
								result.add(cont);
							} else if(r instanceof IFile) {
								if(OneFileUtils.isDi(r)) {
									IPapyrusFile createIPapyrusFile = PapyrusModelHelper.getPapyrusModelFactory().createIPapyrusFile((IFile)r);
									result.add(createIPapyrusFile);
								} else {
									if(!OneFileUtils.diExists(r.getName(), r.getParent())) {
										result.add(r);
									}
								}
							} else {
								result.add(r);
							}
						}
					}
				}

			}
		} catch (CoreException e) {
		}
		return result.isEmpty() ? null : result.toArray();
	}

	@Override
	public Object[] getChildren(Object inputElement) {
		return getElements(inputElement);
	}

	@Override
	public Object getParent(Object element) {
		if(element instanceof IPapyrusFile) {
			IPapyrusFile papyFile = (IPapyrusFile)element;
			return papyFile.getParent();
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return OneFileUtils.hasChildren(element);
	}

	@Override
	protected void processDelta(IResourceDelta delta) {
		super.processDelta(delta);
		if(!isFiltered()) {
			return;
		}
		Control ctrl = common.getControl();
		if(ctrl == null || ctrl.isDisposed()) {
			return;
		}


		final Collection<Runnable> runnables = new ArrayList<Runnable>();
		processPapyrusDelta(delta, runnables);

		if(runnables.isEmpty()) {
			return;
		}

		//Are we in the UIThread? If so spin it until we are done
		ctrl.getDisplay().asyncExec(new Runnable() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see java.lang.Runnable#run()
			 */
			public void run() {
				//Abort if this happens after disposes
				Control ctrl = common.getControl();
				if(ctrl == null || ctrl.isDisposed()) {
					return;
				}
				runUpdates(runnables);
			}
		});

	}

	private void runUpdates(Collection<?> runnables) {
		Iterator<?> runnableIterator = runnables.iterator();
		while(runnableIterator.hasNext()) {
			((Runnable)runnableIterator.next()).run();
		}

	}

	protected void processPapyrusDelta(IResourceDelta delta, Collection<Runnable> runnables) {
		IResourceDelta[] affectedChildren = delta.getAffectedChildren(IResourceDelta.CHANGED);

		// Handle changed children .
		for(int i = 0; i < affectedChildren.length; i++) {
			processPapyrusDelta(affectedChildren[i], runnables);
		}

		IResourceDelta[] addedChildren = delta.getAffectedChildren(IResourceDelta.ADDED);

		IResourceDelta[] removedChildren = delta.getAffectedChildren(IResourceDelta.REMOVED);

		final Object[] addedObjects;

		final Object[] removedObjects;

		// Process additions before removals as to not cause selection
		// preservation prior to new objects being added
		// Handle added children. Issue one update for all insertions.
		if(addedChildren.length > 0) {
			addedObjects = new Object[addedChildren.length];
			for(int i = 0; i < addedChildren.length; i++) {
				addedObjects[i] = addedChildren[i].getResource();
			}
		} else {
			addedObjects = new Object[0];
		}

		removedObjects = new Object[removedChildren.length];
		int i = 0;
		for(IResourceDelta removeDelta : removedChildren) {
			removedObjects[i++] = removeDelta.getResource();
		}

		// Handle removed children. Issue one update for all removals.
		// heuristic test for items moving within same folder (i.e. renames)
		Runnable addAndRemove = new Runnable() {

			public void run() {
				if(common instanceof AbstractTreeViewer) {
					// Disable redraw until the operation is finished so we don't
					// get a flash of both the new and old item (in the case of
					// rename)
					// Only do this if we're both adding and removing files (the
					// rename case)
					try {
						// need to handle resource addition
						if(addedObjects.length > 0) {
							Set<Object> toRefresh = new HashSet<Object>();
							Set<IPapyrusFile> toAdd = new HashSet<IPapyrusFile>(addedObjects.length);
							for(Object r : addedObjects) {
								if(r instanceof IResource) {
									IResource current = (IResource)r;
									if(OneFileUtils.diExists(current.getName(), current.getParent())) {
										IPapyrusFile oneFile = PapyrusModelHelper.getPapyrusModelFactory().createIPapyrusFile(OneFileUtils.getDi(current.getName(), current.getParent()));
										toRefresh.add(oneFile);
										toRefresh.add(oneFile.getParent());
									}

									if(OneFileUtils.isDi(current)) {
										toAdd.add(PapyrusModelHelper.getPapyrusModelFactory().createIPapyrusFile((IFile)current));
									}
								}
							}

							for(IPapyrusFile o : toAdd) {
								common.add(o.getParent(), o);
							}

							for(Object o : toRefresh) {
								common.refresh(o);
							}
						}

						if(removedObjects.length > 0) {

							Set<Object> toRefresh = new HashSet<Object>();
							Set<Object> toRemove = new HashSet<Object>();

							for(Object r : removedObjects) {
								if(r instanceof IResource) {
									IResource current = (IResource)r;
									if(OneFileUtils.isDi(current)) {
										toRemove.add(PapyrusModelHelper.getPapyrusModelFactory().createIPapyrusFile((IFile)current));
										toRefresh.add(current.getParent());
									} else if(OneFileUtils.diExists(current.getName(), current.getParent())) {
										IPapyrusFile oneFile = PapyrusModelHelper.getPapyrusModelFactory().createIPapyrusFile(OneFileUtils.getDi(current.getName(), current.getParent()));
										toRefresh.add(oneFile);
										toRemove.add(PapyrusModelHelper.getPapyrusModelFactory().createISubResourceFile(oneFile, (IFile)current));
									}
								}
							}

							common.remove(toRemove.toArray());

							for(Object o : toRefresh) {
								common.refresh(o);
							}
						}
					} finally {

					}
				}
			}
		};
		runnables.add(addAndRemove);
	}

	//	@Override
	//	protected ITreeContentProvider getDelegateContentProvider() {
	//		if(provider == null) {
	//			provider = new WorkbenchContentProvider();
	//		}
	//		return provider;
	//	}
	//
	//	@Override
	//	protected String getModelProviderId() {
	//		return OneFileModelProvider.MODEL_PROVIDER_ID;
	//	}
	//
	//	@Override
	//	protected Object getModelRoot() {
	//		return null;
	//	}

	//	@Override
	//	protected ResourceTraversal[] getTraversals(ISynchronizationContext context, Object object) {
	//		return null;
	//	}

}
