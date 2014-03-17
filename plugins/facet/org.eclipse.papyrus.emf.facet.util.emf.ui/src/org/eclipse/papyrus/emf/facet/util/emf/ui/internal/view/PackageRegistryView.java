/*******************************************************************************
 * Copyright (c) 2009, 2010, 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Gregoire Dupe (Mia-Software) - initial API and implementation
 *    Nicolas Bros (Mia-Software)
 *    Nicolas Guyomar (Mia-Software) - Bug 333652 Extension point offering the possibility to declare an EPackage browser
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.util.emf.ui.internal.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.papyrus.emf.facet.util.core.Logger;
import org.eclipse.papyrus.emf.facet.util.emf.core.IBrowserRegistry;
import org.eclipse.papyrus.emf.facet.util.emf.ui.internal.Activator;
import org.eclipse.papyrus.emf.facet.util.emf.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.util.emf.ui.internal.utils.ImageUtils;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.emf.facet.common.ui.internal.views.AbstractTreeView;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IWorkbenchActionConstants;

/**
 * An Eclipse view that displays a list of available Ecore meta-models.
 */
public class PackageRegistryView extends AbstractTreeView implements IMenuListener {

	private static final String NAME_COLUMN = "PackageRegistryView_NameColumn"; //$NON-NLS-1$
	private static final String NSURI_COLUMN = "PackageRegistryView_NsURIColumn"; //$NON-NLS-1$

	private static final int COLUMN_WIDTH = 200;

	private static final String DEBUG_ID = "org.eclipse.papyrus.emf.facet.infra.common.ui/debug/PackageRegistryView/event_debug"; //$NON-NLS-1$
	private static final boolean DEBUG = Activator.getDefault().isDebugging()
			&& new Boolean(Platform.getDebugOption(PackageRegistryView.DEBUG_ID)).booleanValue();

	@Override
	public void createPartControl(final Composite parent) {
		super.createPartControl(parent);
		createContextMenu();
	}

	@Override
	protected void createContextMenu() {
		final MenuManager contextMenu = new MenuManager("#PopUp"); //$NON-NLS-1$
		contextMenu.add(this.actionCopyNsURI);
		contextMenu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		contextMenu.addMenuListener(this);
		final Menu menu = contextMenu.createContextMenu(getViewer().getControl());
		getViewer().getControl().setMenu(menu);
		getSite().registerContextMenu(contextMenu, getViewer());
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	protected void createColumns() {
		createNameColumn();
		createNsUriColumn();
	}

	private void createNameColumn() {
		ColumnLabelProvider columnLabelProvider = new ColumnLabelProvider() {
			@Override
			public String getText(final Object element) {
				if (element instanceof EPackage) {
					EPackage ePackage = (EPackage) element;
					return ePackage.getName();
				} else if (element instanceof String) {
					return (String) element;
				}
				return ""; //$NON-NLS-1$
			}

			@Override
			public Image getImage(final Object element) {
				return ImageUtils.getImage(element);
			}
		};
		createColumn(Messages.PackageRegistryView_Name, PackageRegistryView.NAME_COLUMN,
				PackageRegistryView.COLUMN_WIDTH, columnLabelProvider);
	}

	private void createNsUriColumn() {
		ColumnLabelProvider columnLabelProvider = new ColumnLabelProvider() {
			@Override
			public String getText(final Object element) {
				if (!(element instanceof EPackage)) {
					return ""; //$NON-NLS-1$
				}
				EPackage ePackage = (EPackage) element;
				return ePackage.getNsURI();
			}
		};
		createColumn(Messages.PackageRegistryView_nsURI, PackageRegistryView.NSURI_COLUMN,
				PackageRegistryView.COLUMN_WIDTH * 2, columnLabelProvider);
	}

	/**
	 * Reads the registry in a non-UI thread, so that the UI thread will be able to access it faster
	 * 
	 * @param registry
	 *            the registry to preload
	 */
	private static void preloadRegistry(final Registry registry) {
		// avoid ConcurrentModificationException
		List<String> keys = new ArrayList<String>();
		keys.addAll(registry.keySet());
		for (String nsURI : keys) {
			try {
				registry.getEPackage(nsURI);
			} catch (Exception e) {
				Logger.logWarning(e,
						"An error happened while loading an EPackage from Package.Registry.INSTANCE: " //$NON-NLS-1$
								+ nsURI, Activator.getDefault());
			} catch (LinkageError e) {
				Logger.logError(e, "An error prevented an EPackage from being loaded: " //$NON-NLS-1$
						+ nsURI, Activator.getDefault());
			}
		}
	}

	/**
	 * An {@link EObject} was added to the package registry
	 * 
	 * @param eObject
	 * @param file
	 */
	public void added(final EObject eObject, final IFile file) {
		if (PackageRegistryView.DEBUG) {
			System.out.println(this.getClass().getSimpleName() + ".added(EObject,IFile)"); //$NON-NLS-1$
		}
		refresh(true);
	}

	/**
	 * An {@link EObject} was changed in the package registry
	 * 
	 * @param eObject
	 * @param file
	 */
	public void changed(final EObject eObject, final IFile file) {
		if (PackageRegistryView.DEBUG) {
			System.out.println(this.getClass().getSimpleName() + ".changed(EObject,IFile)"); //$NON-NLS-1$
		}
		refresh(true);
	}

	/**
	 * A file was removed from the package registry
	 * 
	 * @param file
	 */
	public void removed(final IFile file) {
		if (PackageRegistryView.DEBUG) {
			System.out.println(this.getClass().getSimpleName() + ".removed(EObject,IFile)"); //$NON-NLS-1$
		}
		refresh(true);
	}

	@Override
	protected IContentProvider getContentProvider() {
		return new ITreeContentProvider() {
			public Object[] getElements(final Object inputElement) {
				if (inputElement instanceof EPackage.Registry) {
					EPackage.Registry registry = (EPackage.Registry) inputElement;
					List<EPackage> ePackages = new ArrayList<EPackage>();
					// avoid a ConcurrentModificationException
					List<String> keys = new ArrayList<String>();
					keys.addAll(registry.keySet());
					for (String nsURI : keys) {
						try {
							EPackage ePackage = registry.getEPackage(nsURI);
							if (ePackage == null) {
								throw new Exception("ePackage is null for : " //$NON-NLS-1$
										+ nsURI);
							}
							ePackages.add(ePackage);
						} catch (Exception e) {
							Logger.logWarning(e,
									"An error happened while loading an EPackage from Package.Registry.INSTANCE: " //$NON-NLS-1$
											+ nsURI, Activator.getDefault());
						}
					}
					return ePackages.toArray();
				} else if (inputElement == null) {
					return new Object[] {};
				} else if (inputElement instanceof String) {
					String message = (String) inputElement;
					return new Object[] { message };
				} else {
					throw new RuntimeException("Unexpected element type: " //$NON-NLS-1$
							+ inputElement.getClass().getName());
				}
			}

			public void inputChanged(final Viewer viewer, final Object oldInput,
					final Object newInput) {
				// Nothing to do
			}

			public Object[] getChildren(final Object parentElement) {
				if (parentElement instanceof EPackage.Registry) {
					EPackage.Registry registry = (EPackage.Registry) parentElement;
					return registry.values().toArray();
				} else if (parentElement == null || parentElement instanceof String) {
					return new Object[] {};
				} else {
					throw new RuntimeException("Unexpected element type: " //$NON-NLS-1$
							+ parentElement.getClass().getName());
				}
			}

			public Object getParent(final Object element) {
				return null;
			}

			public boolean hasChildren(final Object element) {
				if (element instanceof EPackage.Registry) {
					return true;
				}
				return false;
			}

			public void dispose() {
				// Nothing to do
			}
		};
	}

	@Override
	protected void openElement(final Object element) {
		if (element instanceof EPackage) {
			EPackage ePackage = (EPackage) element;
			IBrowserRegistry.INSTANCE.browseEPackage(ePackage);
		}
	}

	@Override
	protected String getRefreshMessage() {
		return Messages.PackageRegistryView_RefreshingPackageRegistryView;
	}

	@Override
	protected void doRefresh() {
		// display a message while initializing
		// (initialization can take a while)
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				getViewer().setInput(Messages.PackageRegistryView_initializing);
			}
		});
		final EPackage.Registry registry = EPackage.Registry.INSTANCE;
		// Read a first time in a non-UI thread so as to avoid
		// blocking. Then it will be cached for the UI thread.
		preloadRegistry(registry);
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				// the control might be disposed if the view was closed
				// in the meantime
				if (!getViewer().getControl().isDisposed()) {
					getViewer().setInput(registry);
					getViewer().refresh();
				}
			}
		});
	}

	@Override
	protected Object getInput() {
		return EPackage.Registry.INSTANCE;
	}

	private final Action actionCopyNsURI = new Action(Messages.PackageRegistryView_copyNsURI,
			IAction.AS_PUSH_BUTTON) {
		@Override
		public void run() {
			EPackage selectedPackage = PackageRegistryView.this.getSelectedPackage();
			if (selectedPackage != null) {
				String nsURI = selectedPackage.getNsURI();
				Clipboard clipboard = new Clipboard(Display.getDefault());
				clipboard.setContents(new Object[] { nsURI },
						new Transfer[] { TextTransfer.getInstance() });
				clipboard.dispose();
			}
		}
	};

	protected EPackage getSelectedPackage() {
		ISelection selection = getViewer().getSelection();
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			Object element = structuredSelection.getFirstElement();
			if (element instanceof EPackage) {
				EPackage ePackage = (EPackage) element;
				return ePackage;
			}
		}
		return null;
	}

	public void menuAboutToShow(final IMenuManager manager) {
		this.actionCopyNsURI.setEnabled(getSelectedPackage() != null);
	}
}
