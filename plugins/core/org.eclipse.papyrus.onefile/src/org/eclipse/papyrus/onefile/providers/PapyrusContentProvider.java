/*****************************************************************************
 * Copyright (c) 2011 Atos Origin Integration.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (Atos Origin Integration) tristan.faure@atosorigin.com - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.onefile.providers;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.mapping.ResourceTraversal;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.onefile.matcher.OnlyDiFilter;
import org.eclipse.papyrus.onefile.model.IPapyrusFile;
import org.eclipse.papyrus.onefile.model.PapyrusModelHelper;
import org.eclipse.papyrus.onefile.utils.OneFileUtils;
import org.eclipse.team.core.mapping.ISynchronizationContext;
import org.eclipse.team.ui.mapping.SynchronizationContentProvider;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;

/**
 * Content provider able to retrieve Papyrus children from an {@link IContainer}
 * 
 * @author tfaure
 * 
 */
public class PapyrusContentProvider extends SynchronizationContentProvider {

	private ITreeContentProvider provider = null;

	private CommonViewer common;

	@Override
	public void init(ICommonContentExtensionSite site) {
		super.init(site);
	}

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
									result.add(PapyrusModelHelper.getPapyrusModelFactory().createIPapyrusFile((IFile)r));
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

	public Object[] getChildren(Object inputElement) {
		return getElements(inputElement);
	}

	public Object getParent(Object element) {
		if(element instanceof IPapyrusFile) {
			IPapyrusFile papyFile = (IPapyrusFile)element;
			return papyFile.getParent();
		}
		return null;
	}

	public boolean hasChildren(Object element) {
		return OneFileUtils.hasChildren(element);
	}

	@Override
	protected ITreeContentProvider getDelegateContentProvider() {
		if(provider == null) {
			provider = new WorkbenchContentProvider();
		}
		return provider;
	}

	@Override
	protected String getModelProviderId() {
		return OneFileModelProvider.MODEL_PROVIDER_ID;
	}

	@Override
	protected Object getModelRoot() {
		return null;
	}

	@Override
	protected ResourceTraversal[] getTraversals(ISynchronizationContext context, Object object) {
		return null;
	}

}
