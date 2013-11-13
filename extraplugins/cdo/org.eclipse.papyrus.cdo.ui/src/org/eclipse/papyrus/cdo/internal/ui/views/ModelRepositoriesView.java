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
package org.eclipse.papyrus.cdo.internal.ui.views;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.cdo.admin.CDOAdminClientManager;
import org.eclipse.emf.cdo.eresource.CDOResourceLeaf;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.ui.CDOEditorUtil;
import org.eclipse.emf.cdo.util.CommitException;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.net4j.util.container.IContainer;
import org.eclipse.net4j.util.ui.views.ContainerItemProvider;
import org.eclipse.net4j.util.ui.views.ContainerView;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.core.admin.IPapyrusRepositoryAdminListener;
import org.eclipse.papyrus.cdo.core.admin.PapyrusRepositoryAdminManager;
import org.eclipse.papyrus.cdo.internal.core.IInternalPapyrusRepository;
import org.eclipse.papyrus.cdo.internal.core.IInternalPapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.internal.core.PapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.eclipse.papyrus.cdo.internal.ui.actions.AbstractRepositoryAction;
import org.eclipse.papyrus.cdo.internal.ui.actions.AddRepositoryAction;
import org.eclipse.papyrus.cdo.internal.ui.actions.ChangePasswordAction;
import org.eclipse.papyrus.cdo.internal.ui.actions.ConnectRepositoryAction;
import org.eclipse.papyrus.cdo.internal.ui.actions.CreateFolderAction;
import org.eclipse.papyrus.cdo.internal.ui.actions.DeleteModelAction;
import org.eclipse.papyrus.cdo.internal.ui.actions.DisconnectRepositoryAction;
import org.eclipse.papyrus.cdo.internal.ui.actions.LinkWithEditorAction;
import org.eclipse.papyrus.cdo.internal.ui.actions.OpenPapyrusModelAction;
import org.eclipse.papyrus.cdo.internal.ui.actions.RemoveRepositoryAction;
import org.eclipse.papyrus.cdo.internal.ui.actions.RenameModelAction;
import org.eclipse.papyrus.cdo.internal.ui.admin.RepositoryAdminListener;
import org.eclipse.papyrus.cdo.internal.ui.dnd.ResourceDragAdapter;
import org.eclipse.papyrus.cdo.internal.ui.dnd.ResourceDropAdapter;
import org.eclipse.papyrus.cdo.internal.ui.l10n.Messages;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.dialogs.PropertyDialogAction;
import org.eclipse.ui.statushandlers.IStatusAdapterConstants;
import org.eclipse.ui.statushandlers.StatusAdapter;
import org.eclipse.ui.statushandlers.StatusManager;

import com.google.common.base.Strings;

/**
 * This is the ModelRepositoriesView type. Enjoy.
 */
public class ModelRepositoriesView extends ContainerView {

	public final static String ID = "org.eclipse.papyrus.cdo.ui.ModelRepositoriesView"; //$NON-NLS-1$

	public static final int LINK_WITH_EDITOR_PROPERTY = 0x10000;

	private static final String STATE_LINKING = "linkWithEditor"; //$NON-NLS-1$

	private final IInternalPapyrusRepositoryManager repositoryManager;

	private final PapyrusRepositoryAdminManager adminManager;

	private CDOAdminClientManager clientManager;

	private IPapyrusRepositoryAdminListener adminListener;

	private AddRepositoryAction addRepositoryAction;

	private LinkWithEditorAction linkWithEditorAction;

	private AbstractRepositoryAction connectRepositoryAction;

	private AbstractRepositoryAction disconnectRepositoryAction;

	private ChangePasswordAction changePasswordAction;

	private RemoveRepositoryAction removeRepositoryAction;

	private OpenPapyrusModelAction openModelAction;

	private PropertyDialogAction propertyDialogAction;

	private CreateFolderAction createFolderAction;

	private RenameModelAction renameModelAction;

	private DeleteModelAction deleteModelAction;

	private boolean isLinkWithEditor;

	private LinkingHelper linkingHelper;

	public ModelRepositoriesView() {
		super();

		repositoryManager = PapyrusRepositoryManager.INSTANCE;
		adminManager = new PapyrusRepositoryAdminManager();
	}

	@Override
	protected IContainer<?> getContainer() {
		return (IContainer<?>)repositoryManager;
	}

	@Override
	public void init(IViewSite site, IMemento memento) throws PartInitException {

		super.init(site, memento);

		// link by default
		Boolean linking = (memento == null) ? Boolean.TRUE : memento.getBoolean(STATE_LINKING);
		setLinkWithEditor(!Boolean.FALSE.equals(linking));

		// attach the admin manager
		clientManager = Activator.getCDOAdminClientManager();
		if(clientManager != null) {
			adminManager.install(clientManager);
			adminListener = new RepositoryAdminListener(repositoryManager);
			adminManager.addRepositoryAdminListener(adminListener);
		}
	}

	@Override
	public void dispose() {
		try {
			if(clientManager != null) {
				adminManager.removeRepositoryAdminListener(adminListener);
				clientManager.removeListener(adminManager);
				clientManager = null;
			}
		} finally {
			super.dispose();
		}
	}

	@Override
	public void saveState(IMemento memento) {
		memento.putBoolean(STATE_LINKING, isLinkWithEditor());
		super.saveState(memento);
	}

	public boolean isLinkWithEditor() {
		return isLinkWithEditor;
	}

	public void setLinkWithEditor(boolean link) {
		if(isLinkWithEditor != link) {
			isLinkWithEditor = link;

			if(linkingHelper != null) {
				linkingHelper.setLinkWithEditor(link);
			}

			firePropertyChange(LINK_WITH_EDITOR_PROPERTY);
		}
	}

	@Override
	protected Control createUI(Composite parent) {
		createActions();

		Control result = super.createUI(parent);

		// don't show drop feed-back because the viewer sorts alphabetically
		// (ordering of resource nodes has no meaning)
		ResourceDragAdapter.install(getViewer());
		ResourceDropAdapter.install(getViewer()).setFeedbackEnabled(false);

		return result;
	}

	@Override
	protected void createdUI() {
		super.createdUI();

		linkingHelper = new LinkingHelper(getSite(), repositoryManager, getViewer());
		linkingHelper.setLinkWithEditor(isLinkWithEditor());

		ISelectionProvider selectionProvider = getSite().getSelectionProvider();
		selectionProvider.addSelectionChangedListener(openModelAction);
		selectionProvider.addSelectionChangedListener(connectRepositoryAction);
		selectionProvider.addSelectionChangedListener(disconnectRepositoryAction);
		selectionProvider.addSelectionChangedListener(changePasswordAction);
		selectionProvider.addSelectionChangedListener(removeRepositoryAction);
		selectionProvider.addSelectionChangedListener(createFolderAction);
		selectionProvider.addSelectionChangedListener(renameModelAction);
		selectionProvider.addSelectionChangedListener(deleteModelAction);

		// have to create this one after building the UI
		propertyDialogAction = new PropertyDialogAction(getSite(), selectionProvider);
		propertyDialogAction.setActionDefinitionId(IWorkbenchCommandConstants.FILE_PROPERTIES);
	}

	protected void createActions() {
		addRepositoryAction = new AddRepositoryAction(this);
		linkWithEditorAction = new LinkWithEditorAction(this);
		connectRepositoryAction = new ConnectRepositoryAction(this);
		disconnectRepositoryAction = new DisconnectRepositoryAction(this);
		changePasswordAction = new ChangePasswordAction(this);
		removeRepositoryAction = new RemoveRepositoryAction(this);
		openModelAction = new OpenPapyrusModelAction(this);
		createFolderAction = new CreateFolderAction(this.getSite());
		renameModelAction = new RenameModelAction(this);
		deleteModelAction = new DeleteModelAction(this);

		IActionBars actionBars = getViewSite().getActionBars();
		actionBars.setGlobalActionHandler(ActionFactory.RENAME.getId(), renameModelAction);
		actionBars.setGlobalActionHandler(ActionFactory.DELETE.getId(), deleteModelAction);
	}

	@Override
	protected void fillLocalToolBar(IToolBarManager manager) {
		manager.add(addRepositoryAction);
		manager.add(linkWithEditorAction);

		super.fillLocalToolBar(manager);
	}

	@Override
	protected void fillContextMenu(IMenuManager manager, ITreeSelection selection) {

		manager.add(new GroupMarker("createActions")); //$NON-NLS-1$

		if(!selection.isEmpty()) {
			Object selected = selection.getFirstElement();

			if(selected instanceof DIModel) {
				manager.add(openModelAction);
				manager.add(renameModelAction);
				manager.add(deleteModelAction);
			}

			if(selected instanceof IPapyrusRepository) {
				if(((IPapyrusRepository)selected).isConnected()) {
					manager.add(createFolderAction);
				}

				manager.add(connectRepositoryAction);
				manager.add(disconnectRepositoryAction);

				if(selected instanceof IInternalPapyrusRepository) {
					CDOSession session = ((IInternalPapyrusRepository)selected).getCDOSession();
					if((session != null) && !Strings.isNullOrEmpty(session.getUserID())) {
						manager.add(changePasswordAction);
					}
				}

				manager.add(removeRepositoryAction);
				manager.add(propertyDialogAction);
			}
		}

		super.fillContextMenu(manager, selection);
	}

	@Override
	protected void doubleClicked(Object object) {
		if(object instanceof DIModel) {
			invoke(openModelAction);
		} else if(object instanceof IPapyrusRepository) {
			invoke(connectRepositoryAction);
		} else if(object instanceof CDOResourceLeaf) {
			openCDOEditor((CDOResourceLeaf)object);
		} else {
			super.doubleClicked(object);
		}
	}

	protected void invoke(Action action) {
		if(action.isEnabled()) {
			action.run();
		}
	}

	@Override
	protected ContainerItemProvider<IContainer<Object>> createContainerItemProvider() {
		return new ModelRepositoryItemProvider(getSite().getPage());
	}

	protected void openCDOEditor(CDOResourceLeaf res) {
		String editorID = CDOEditorUtil.getEffectiveEditorID(res);
		if(editorID != null) {
			final CDOTransaction trans = res.cdoView().getSession().openTransaction();
			res = trans.getObject(res);
			IEditorInput input = CDOEditorUtil.createEditorInput(editorID, res, false);
			try {
				final IEditorPart editor = getSite().getPage().openEditor(input, editorID, true);
				editor.addPropertyListener(new IPropertyListener() {

					@Override
					public void propertyChanged(Object source, int propId) {
						if((propId == IEditorPart.PROP_DIRTY) && !editor.isDirty()) {
							// editor was saved.  Commit changes
							try {
								trans.commit();
							} catch (CommitException e) {
								StatusAdapter adapter = new StatusAdapter(new Status(IStatus.ERROR, Activator.PLUGIN_ID, Messages.ModelRepositoriesView_commitSaveFailed, e));
								adapter.setProperty(IStatusAdapterConstants.TIMESTAMP_PROPERTY, System.currentTimeMillis());
								adapter.setProperty(IStatusAdapterConstants.TITLE_PROPERTY, Messages.ModelRepositoriesView_commitSaveError);
								StatusManager.getManager().handle(adapter);
							}
						}
					}
				});
				getSite().getPage().addPartListener(new IPartListener() {

					@Override
					public void partClosed(IWorkbenchPart part) {
						if(part == editor) {
							trans.close();
						}
					}

					@Override
					public void partOpened(IWorkbenchPart part) {
						// pass
					}

					@Override
					public void partDeactivated(IWorkbenchPart part) {
						// pass
					}

					@Override
					public void partBroughtToTop(IWorkbenchPart part) {
						// pass
					}

					@Override
					public void partActivated(IWorkbenchPart part) {
						// pass
					}
				});
			} catch (PartInitException e) {
				trans.close();
				StatusManager.getManager().handle(e.getStatus(), StatusManager.SHOW);
			}
		}

	}
}
