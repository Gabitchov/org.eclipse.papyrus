/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.dnd;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.util.CDOURIUtil;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.core.util.CDOFunctions;
import org.eclipse.papyrus.cdo.core.util.CDOPredicates;
import org.eclipse.papyrus.cdo.internal.core.IInternalPapyrusRepository;
import org.eclipse.papyrus.cdo.internal.core.PapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.eclipse.papyrus.cdo.internal.ui.handlers.ImportModelsHandler;
import org.eclipse.papyrus.cdo.internal.ui.l10n.Messages;
import org.eclipse.papyrus.cdo.internal.ui.views.DIModel;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;
import org.eclipse.papyrus.infra.onefile.model.PapyrusModelHelper;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.PluginTransfer;
import org.eclipse.ui.part.PluginTransferData;
import org.eclipse.ui.part.ResourceTransfer;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * This is the ResourceDropAdapter type. Enjoy.
 */
public class ResourceDropAdapter extends ViewerDropAdapter {

	private static final Transfer[] TRANSFERS = { ResourceTransfer.getInstance(), LocalSelectionTransfer.getTransfer(), PluginTransfer.getInstance() };

	private final Predicate<Object> validDropTarget = Predicates.or(CDOPredicates.adaptsTo(CDOResourceFolder.class), CDOPredicates.adaptsTo(IPapyrusRepository.class));

	private final Function<Object, CDOResourceNode> asNode = CDOFunctions.adapt(CDOResourceNode.class);

	protected ResourceDropAdapter(StructuredViewer viewer) {
		super(viewer);
	}

	public static ResourceDropAdapter install(StructuredViewer viewer) {
		ResourceDropAdapter result = new ResourceDropAdapter(viewer);

		viewer.addDropSupport(DND.DROP_MOVE | /* DND.DROP_COPY | */DND.DROP_DEFAULT, TRANSFERS, result);

		return result;
	}

	@Override
	public boolean performDrop(Object data) {
		boolean result = false;

		if(data instanceof IResource[]) {
			data = new StructuredSelection((IResource[])data);
		} else if((data instanceof PluginTransferData) && "org.eclipse.ui.navigator.PluginDropAction".equals(((PluginTransferData)data).getExtensionId())) { //$NON-NLS-1$
			String viewerID = new String(((PluginTransferData)data).getData());
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			IViewPart view = page.findView(viewerID);
			if(view != null) {
				data = view.getSite().getSelectionProvider().getSelection();
			}
		}

		CDOResourceNode dropTarget = adaptDropTarget(getCurrentTarget());
		if(dropTarget != null) {
			Iterable<?> toMove = Collections.emptyList();

			// handle resources to move within the repositories view
			if(data instanceof IStructuredSelection) {
				IStructuredSelection selection = (IStructuredSelection)data;
				toMove = getResourceNodeAdaptables(selection);
			} else if(data instanceof PluginTransferData) {
				PluginTransferData ptData = (PluginTransferData)data;
				if(ResourceDropActionDelegate.DROP_ACTION_ID.equals(ptData.getExtensionId())) {
					CDOResourceURITransferData uris = CDOResourceURITransferData.deserialize(ptData.getData());
					toMove = getResourceNodeAdaptables(uris.getURIs());
				}
			}

			if(!Iterables.isEmpty(toMove)) {
				result = moveResourceNodes(dropTarget, toMove);
			} else {
				// handle resources to import from the workspace
				if(data instanceof IStructuredSelection) {
					Iterable<IFile> diFiles = getDIFiles((IStructuredSelection)data);
					if(!Iterables.isEmpty(diFiles)) {
						result = importModels(dropTarget, diFiles);
					}
				}
			}
		}

		return result;
	}

	protected boolean moveResourceNodes(final CDOResourceNode dropTarget, final Iterable<?> resourceNodes) {
		boolean result = false;

		// validate the move before we attempt to move anything
		Iterable<? extends CDOResourceNode> nodes = Iterables.transform(resourceNodes, CDOFunctions.adapt(CDOResourceNode.class));
		for(CDOResourceNode next : nodes) {
			result = true;

			if(contains(dropTarget, next)) {
				result = false;
				break;
			}
		}

		if(result) {
			new Job(Messages.ResourceDropAdapter_1) {

				{
					setUser(true);
				}

				@Override
				protected IStatus run(IProgressMonitor monitor) {
					return doMove(dropTarget, resourceNodes);
				}
			}.schedule();
		}

		return result;
	}

	protected boolean importModels(CDOResourceNode dropTarget, Iterable<IFile> diFiles) {
		boolean result = false;

		IWorkbenchWindow window = null;
		for(IWorkbenchWindow next : PlatformUI.getWorkbench().getWorkbenchWindows()) {
			if(next.getShell() == getViewer().getControl().getShell()) {
				window = next;
				break;
			}
		}

		if(window != null) {
			URI uri = dropTarget.getURI();
			IPapyrusRepository repository = PapyrusRepositoryManager.INSTANCE.getRepositoryForURI(uri);
			if(repository != null) {
				List<IPapyrusFile> papyrusFiles = Lists.newArrayList();
				for(IFile next : diFiles) {
					IPapyrusFile papyrusFile = PapyrusModelHelper.getPapyrusModelFactory().createIPapyrusFile(next);
					if(papyrusFile != null) {
						papyrusFiles.add(papyrusFile);
					}
				}

				if(!papyrusFiles.isEmpty()) {
					result = true;
					ImportModelsHandler.importModels(window, new StructuredSelection(papyrusFiles), repository);
				}
			}
		}

		return result;
	}

	protected IStatus doMove(CDOResourceNode destination, Iterable<?> nodeAdaptables) {
		IStatus result = Status.OK_STATUS;
		CDOTransaction transaction = destination.cdoView().getSession().openTransaction();

		try {
			CDOResourceNode newParent = getCorrespondent(destination, transaction);
			for(Object next : nodeAdaptables) {
				if(next instanceof DIModel) {
					for(CDOResourceNode component : getResourceNodes(Arrays.asList(((DIModel)next).getChildren()))) {
						moveTo(newParent, getCorrespondent(component, transaction));
					}
				} else {
					moveTo(newParent, getCorrespondent(asNode.apply(next), transaction));
				}
			}

			transaction.commit();
		} catch (CoreException e) {
			result = e.getStatus();
		} catch (Exception e) {
			result = error(Messages.ResourceDropAdapter_3, e);
		} finally {
			transaction.close();
		}

		return result;
	}

	protected CDOResourceNode getCorrespondent(CDOResourceNode node, CDOView view) throws CoreException {

		CDOResourceNode result;

		try {
			if(node == null) {
				throw new CoreException(error(Messages.ResourceDropAdapter_2));
			} else if(node instanceof CDOResourceFolder) {
				result = view.getResourceFolder(node.getPath());
			} else if(node instanceof CDOResource) {
				result = view.getResource(node.getPath());
			} else {
				throw new CoreException(error(NLS.bind(Messages.ResourceDropAdapter_4, node.getClass().getName())));
			}
		} catch (CoreException e) {
			throw e;
		} catch (Exception e) {
			throw new CoreException(error(e.getLocalizedMessage(), e));
		}

		return result;
	}

	protected static IStatus error(String message) {
		return error(message, null);
	}

	protected static IStatus error(String message, Throwable exception) {
		return new Status(IStatus.ERROR, Activator.PLUGIN_ID, message, exception);
	}

	protected void moveTo(CDOResourceNode newParent, CDOResourceNode node) throws CoreException {
		String newPath = (node == null) ? null : new Path(newParent.getPath()).append(node.getName()).toString();

		if(node == null) {
			throw new CoreException(error(Messages.ResourceDropAdapter_0));
		} else if(newParent.cdoView().hasResource(newPath)) {
			throw new CoreException(error(NLS.bind(Messages.ResourceDropAdapter_6, newPath)));
		} else {
			// just set the path. The node moves itself
			node.setPath(newPath);
		}
	}

	@Override
	public boolean validateDrop(Object target, int operation, TransferData transferType) {
		boolean result = false;

		LocalSelectionTransfer local = LocalSelectionTransfer.getTransfer();
		if(local.isSupportedType(transferType) && (local.getSelection() instanceof IStructuredSelection) && isValidResourceContainer(target)) {
			IStructuredSelection selection = (IStructuredSelection)local.getSelection();
			CDOResourceNode dropTarget = adaptDropTarget(target);

			// handle drag of files from the Project Explorer. If there's any
			// DI file, that's good enough, because the import wizard handles
			// mapping to repository paths
			if((dropTarget != null) && !Iterables.isEmpty(getDIFiles(selection))) {
				result = true;
			}
		} else if(PluginTransfer.getInstance().isSupportedType(transferType) && isValidResourceContainer(target)) {
			// assume that intra-repository drag of resource nodes will be OK
			result = true;
		} else if(ResourceTransfer.getInstance().isSupportedType(transferType) && isValidResourceContainer(target)) {
			// assume that dragging resources will be OK
			result = true;
		}

		return result;
	}

	protected boolean isValidResourceContainer(Object dropTarget) {
		return validDropTarget.apply(dropTarget);
	}

	protected CDOResourceNode adaptDropTarget(Object dropTarget) {
		CDOResourceNode result = CDOFunctions.adapt(CDOResourceNode.class).apply(dropTarget);

		if(result == null) {
			// must be a repository
			CDOView view = ((IInternalPapyrusRepository)dropTarget).getMasterView();
			if(view != null) {
				result = view.getRootResource();
			}
		}

		return result;
	}

	protected boolean contains(CDOResourceNode parent, CDOResourceNode child) {
		boolean result = false;

		if(parent instanceof CDOResourceFolder) {
			CDOResourceFolder folder = (CDOResourceFolder)parent;
			result = folder.getNodes().contains(child);
		} else if(parent instanceof CDOResource) {
			CDOResource resource = (CDOResource)parent;
			if(resource.isRoot()) {
				result = resource.getContents().contains(child);
			}
		}

		return result;
	}

	protected Iterable<?> getResourceNodeAdaptables(IStructuredSelection selection) {
		return Iterables.filter((List<?>)selection.toList(), CDOPredicates.adaptsTo(CDOResourceNode.class));
	}

	protected Iterable<?> getResourceNodeAdaptables(Iterable<URI> uris) {
		List<Object> result = Lists.newArrayList();

		for(URI next : uris) {
			IPapyrusRepository repo = PapyrusRepositoryManager.INSTANCE.getRepositoryForURI(next);
			if(repo != null) {
				CDOView view = ((IInternalPapyrusRepository)repo).getMasterView();
				if(view != null) { // the repository could be disconnected by now
					String path = CDOURIUtil.extractResourcePath(next);
					try {
						CDOResourceNode node = view.getResourceNode(path);
						if(node instanceof CDOResource) {
							DIModel diModel = DIModel.getInstance((CDOResource)node, false);
							if(diModel != null) {
								result.add(diModel);
							}
						} else if(node instanceof CDOResourceNode) {
							result.add(node);
						}
					} catch (Exception e) {
						// normal in the case that the resource or folder no longer exists
					}
				}
			}
		}

		return result;
	}

	protected Iterable<? extends CDOResourceNode> getResourceNodes(IStructuredSelection selection) {
		return getResourceNodes(selection.toList());
	}

	protected Iterable<? extends CDOResourceNode> getResourceNodes(Iterable<?> objects) {
		return Iterables.filter(Iterables.transform(objects, asNode), Predicates.notNull());
	}

	protected Iterable<IFile> getDIFiles(IStructuredSelection selection) {
		Iterable<IPapyrusFile> papyrusFiles = Iterables.filter(selection.toList(), IPapyrusFile.class);
		Iterable<IFile> files = Iterables.filter(Iterables.filter(selection.toList(), IFile.class), new Predicate<IFile>() {

			@Override
			public boolean apply(IFile input) {
				return PapyrusModelHelper.getPapyrusModelFactory().isDi(input);
			}
		});

		return Iterables.concat(files, Iterables.transform(papyrusFiles, new Function<IPapyrusFile, IFile>() {

			@Override
			public IFile apply(IPapyrusFile input) {
				return input.getMainFile();
			}
		}));
	}
}
