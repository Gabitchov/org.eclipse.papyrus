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
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.internal.core.refactoring.resource.RenameResourceProcessor;
import org.eclipse.ltk.internal.ui.refactoring.RefactoringUIMessages;
import org.eclipse.ltk.ui.refactoring.RefactoringWizardOpenOperation;
import org.eclipse.ltk.ui.refactoring.UserInputWizardPage;
import org.eclipse.ltk.ui.refactoring.resource.RenameResourceWizard;
import org.eclipse.papyrus.infra.onefile.Activator;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;
import org.eclipse.papyrus.infra.onefile.utils.OneFileUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.DeleteResourceAction;
import org.eclipse.ui.actions.MoveResourceAction;
import org.eclipse.ui.actions.RefreshAction;
import org.eclipse.ui.actions.RenameResourceAction;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonMenuConstants;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;
import org.eclipse.ui.part.FileEditorInput;

/**
 * Actions available through an {@link IPapyrusFile}
 * 
 * @author tfaure
 * 
 */
@SuppressWarnings({ "restriction", "rawtypes" })
public class PapyrusModelActionProvider extends CommonActionProvider {

	private boolean fInViewPart = false;

	private ICommonViewerWorkbenchSite workbenchSite;

	private Action openAction;

	private Action deleteAction;

	//Disabled. The CopyResourceAction may create inconsistent changes (i.e. it renames files without editing the links).
	//We need to use a CopyToClipboard action instead
	//@unused
	private Action copyAction;

	private Action renameAction;

	private Action refreshAction;

	private Action moveAction;

	public PapyrusModelActionProvider() {

	}

	@Override
	protected boolean filterAction(IAction action) {
		return super.filterAction(action);
	}

	@Override
	public void fillActionBars(IActionBars actionBars) {
		if(fInViewPart) {
			actionBars.setGlobalActionHandler(ICommonActionConstants.OPEN, openAction);
			actionBars.setGlobalActionHandler(ActionFactory.DELETE.getId(), deleteAction);
			actionBars.setGlobalActionHandler(ActionFactory.RENAME.getId(), renameAction);
			actionBars.setGlobalActionHandler(ActionFactory.MOVE.getId(), moveAction);
			//			actionBars.setGlobalActionHandler(ActionFactory.COPY.getId(), copyAction);
			actionBars.setGlobalActionHandler(ActionFactory.REFRESH.getId(), refreshAction);

		}
		super.fillActionBars(actionBars);
	}

	@Override
	public void fillContextMenu(IMenuManager menu) {
		super.fillContextMenu(menu);
		appendToGroup(menu, openAction, ICommonMenuConstants.GROUP_OPEN);
		appendToGroup(menu, deleteAction, ICommonMenuConstants.GROUP_EDIT);
		appendToGroup(menu, moveAction, ICommonMenuConstants.GROUP_EDIT);
		//		appendToGroup(menu, copyAction, ICommonMenuConstants.GROUP_EDIT);
		appendToGroup(menu, renameAction, ICommonMenuConstants.GROUP_EDIT);
		appendToGroup(menu, refreshAction, ICommonMenuConstants.GROUP_EDIT);
	}

	private void appendToGroup(IMenuManager menu, IAction action, String id) {
		if(action != null && action.isEnabled()) {
			menu.appendToGroup(id, action);
		}
	}

	@Override
	public void init(ICommonActionExtensionSite site) {
		if(site.getViewSite() instanceof ICommonViewerWorkbenchSite) {
			workbenchSite = (ICommonViewerWorkbenchSite)site.getViewSite();
		}
		if(workbenchSite != null) {
			if(workbenchSite.getPart() != null && workbenchSite.getPart() instanceof IViewPart) {
				fInViewPart = true;
			}
			makeActions();
		}
	}

	private void makeActions() {
		final IWorkbenchPartSite provider = workbenchSite.getSite();
		final ActionHelper helper = new ActionHelper();
		openAction = new Action() {

			@Override
			public void run() {
				if(getIFile() != null) {
					try {
						IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
						page.openEditor(new FileEditorInput(getIFile()), "org.eclipse.papyrus.infra.core.papyrusEditor", true, IWorkbenchPage.MATCH_ID | IWorkbenchPage.MATCH_INPUT);
					} catch (WorkbenchException e) {
						Activator.log.error(e);
					}
				}
			}

			public IFile getIFile() {
				return helper.getIFile(getContext());
			}

			@Override
			public boolean isEnabled() {
				return getIFile() != null;
			}

			@Override
			public String getText() {
				return IDEWorkbenchMessages.OpenFileAction_text;
			}
		};

		deleteAction = new DeleteResourceAction(provider) {

			@Override
			public boolean isEnabled() {
				return getSelectedResources() != null && getSelectedResources().size() > 0 && OneFileUtils.isDi((IResource)getSelectedResources().get(0));

			}

			@Override
			public IStructuredSelection getStructuredSelection() {
				return helper.getStructuredSelection(getContext());
			}

			@Override
			protected List getSelectedResources() {
				return helper.getSelectedResources(getContext());
			}
		};

		moveAction = new MoveResourceAction(provider) {

			@Override
			public IStructuredSelection getStructuredSelection() {
				return helper.getStructuredSelection(getContext());
			}

			@Override
			protected List getSelectedResources() {
				return helper.getSelectedResources(getContext());
			}
		};


		//FIXME: The CopyResourceAction is actually a copy + paste
		//It fails when the target folder is the same as the source folder (Because it needs to rename the copied files)
		//Replace this action with a Copy to Clipboard action
		//		copyAction = new CopyResourceAction(provider) {
		//
		//			@Override
		//			public IStructuredSelection getStructuredSelection() {
		//				return helper.getStructuredSelection(getContext());
		//			}
		//
		//			@Override
		//			protected List getSelectedResources() {
		//				return helper.getSelectedResources(getContext());
		//			}
		//		};

		renameAction = new OneFileRenameAction(provider);

		refreshAction = new RefreshAction(provider) {

			@Override
			public void run() {
				super.run();
			}

		};

		makeAction(openAction, ICommonActionConstants.OPEN, ISharedImages.IMG_TOOL_COPY, ISharedImages.IMG_TOOL_COPY_DISABLED);
		makeAction(deleteAction, IWorkbenchCommandConstants.EDIT_DELETE, ISharedImages.IMG_TOOL_DELETE, ISharedImages.IMG_TOOL_DELETE_DISABLED);
		makeAction(moveAction, ActionFactory.MOVE.getId(), null, null);
		//		makeAction(copyAction, IWorkbenchCommandConstants.EDIT_CUT, ISharedImages.IMG_TOOL_CUT, ISharedImages.IMG_TOOL_CUT_DISABLED);
		//		makeAction(copyAction, IWorkbenchCommandConstants.EDIT_COPY, ISharedImages.IMG_TOOL_COPY, ISharedImages.IMG_TOOL_COPY_DISABLED);
		makeAction(refreshAction, ActionFactory.REFRESH.getCommandId(), null, null);
	}

	/**
	 * A Rename action applying to an IPapyrusFile
	 * The action will rename only the *.di file
	 * (Refactoring from infra.ui.resources will rename related files and fix URIs)
	 * 
	 * The user won't be asked for a file extension (*.di will be kept)
	 * 
	 * @author Camille Letavernier
	 */
	public class OneFileRenameAction extends RenameResourceAction {

		final ActionHelper helper = new ActionHelper();

		private IWorkbenchPartSite partSiteProvider;

		public OneFileRenameAction(IWorkbenchPartSite provider) {
			super(provider);
			this.partSiteProvider = provider;
		}

		private Shell getShell() {
			return partSiteProvider.getShell();
		}

		@Override
		public void run() {

			ISelection selection = partSiteProvider.getSelectionProvider().getSelection();

			if(selection instanceof IStructuredSelection) {
				IStructuredSelection structuredSelection = (IStructuredSelection)selection;
				if(structuredSelection.size() != 1) {
					return;
				}

				Object selectedElement = structuredSelection.getFirstElement();
				if(selectedElement instanceof IPapyrusFile) {
					IPapyrusFile modelToRename = (IPapyrusFile)selectedElement;

					RenamePapyrusModelWizard refactoringWizard = new RenamePapyrusModelWizard(modelToRename);
					RefactoringWizardOpenOperation op = new RefactoringWizardOpenOperation(refactoringWizard);
					try {
						op.run(getShell(), RefactoringUIMessages.RenameResourceHandler_title);
					} catch (InterruptedException e) {
						// do nothing
					}
				}
			}
		}
	}

	private static class RenamePapyrusModelWizard extends RenameResourceWizard {

		private IPapyrusFile papyrusFile;

		public RenamePapyrusModelWizard(IPapyrusFile papyrusFile) {
			super(papyrusFile.getMainFile());
			this.papyrusFile = papyrusFile;
		}

		@Override
		protected void addUserInputPages() {
			RenameResourceProcessor processor = (RenameResourceProcessor)getRefactoring().getAdapter(RenameResourceProcessor.class);
			addPage(new RenamePapyrusModelPage(processor));
		}

		private class RenamePapyrusModelPage extends UserInputWizardPage {

			private final RenameResourceProcessor fRefactoringProcessor;

			private Text fNameField;

			public RenamePapyrusModelPage(RenameResourceProcessor processor) {
				super("RenamePapyrusModelRefactoringInputPage"); //$NON-NLS-1$
				fRefactoringProcessor = processor;
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
			 */
			public void createControl(Composite parent) {
				Composite composite = new Composite(parent, SWT.NONE);
				composite.setLayout(new GridLayout(2, false));
				composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
				composite.setFont(parent.getFont());

				Label label = new Label(composite, SWT.NONE);
				label.setText(RefactoringUIMessages.RenameResourceWizard_name_field_label);
				label.setLayoutData(new GridData());

				fNameField = new Text(composite, SWT.BORDER);
				fNameField.setText(papyrusFile.getMainFile().getFullPath().removeFileExtension().lastSegment());
				fNameField.setFont(composite.getFont());
				fNameField.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false));
				fNameField.addModifyListener(new ModifyListener() {

					public void modifyText(ModifyEvent e) {
						validatePage();
					}
				});

				fNameField.selectAll();
				setPageComplete(false);
				setControl(composite);
			}

			@Override
			public void setVisible(boolean visible) {
				if(visible) {
					fNameField.setFocus();
				}
				super.setVisible(visible);
			}

			protected final void validatePage() {
				String text = fNameField.getText() + ".di";
				RefactoringStatus status = fRefactoringProcessor.validateNewElementName(text);
				setPageComplete(status);
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.ltk.ui.refactoring.UserInputWizardPage#performFinish()
			 */
			@Override
			protected boolean performFinish() {
				initializeRefactoring();
				storeSettings();
				return super.performFinish();
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.ltk.ui.refactoring.UserInputWizardPage#getNextPage()
			 */
			@Override
			public IWizardPage getNextPage() {
				initializeRefactoring();
				storeSettings();
				return super.getNextPage();
			}

			private void storeSettings() {
			}

			private void initializeRefactoring() {
				fRefactoringProcessor.setNewResourceName(fNameField.getText() + ".di");
			}
		}
	}

	protected void makeAction(Action action, String id, String imgTool, String imgToolDisabled) {
		if(action != null) {
			ISharedImages images = PlatformUI.getWorkbench().getSharedImages();
			if(id != null) {
				action.setId(id);
				action.setActionDefinitionId(id);
			}
			if(imgTool != null) {
				action.setImageDescriptor(images.getImageDescriptor(imgTool));
			}
			if(imgToolDisabled != null) {
				action.setDisabledImageDescriptor(images.getImageDescriptor(imgToolDisabled));
			}
		}
	}

	public static class ActionHelper {

		public IStructuredSelection getStructuredSelection(ActionContext context) {
			return new StructuredSelection(getSelectedResources(context));
		}

		public List getOneSelectedResources(ActionContext context) {
			List selectedResources = getSelectedResources(context);
			if(selectedResources.size() > 0) {
				for(Iterator<?> i = selectedResources.iterator(); i.hasNext();) {
					Object o = i.next();
					if(o instanceof IFile) {
						IFile file = (IFile)o;
						if(!OneFileUtils.isDi(file)) {
							i.remove();
						}
					}
				}
				return selectedResources;
			}
			return Collections.EMPTY_LIST;
		}

		public IStructuredSelection getOneStructuredSelection(ActionContext context) {
			List selectedResources = getOneSelectedResources(context);
			if(selectedResources.size() > 0) {
				return new StructuredSelection(selectedResources);
			}
			return null;
		}

		protected List getSelectedResources(ActionContext context) {
			ISelection selec = context.getSelection();
			List<IResource> resources = new ArrayList<IResource>();
			if(selec instanceof IStructuredSelection) {
				IStructuredSelection struc = (IStructuredSelection)selec;
				for(Iterator<Object> i = struc.iterator(); i.hasNext();) {
					Object o = i.next();
					if(o instanceof IPapyrusFile) {
						IPapyrusFile papy = (IPapyrusFile)o;
						resources.addAll(Arrays.asList(papy.getAssociatedResources()));
					}
				}
			}
			return resources;
		}

		public IFile getIFile(ActionContext context) {
			ISelection selec = context.getSelection();
			if(selec instanceof IStructuredSelection) {
				IStructuredSelection struc = (IStructuredSelection)selec;
				Object firstElement = struc.getFirstElement();
				if(firstElement instanceof IFile) {
					IFile file = (IFile)firstElement;
					return file;
				} else if(firstElement instanceof IPapyrusFile) {
					return ((IPapyrusFile)firstElement).getMainFile();
				}
			}
			return null;
		}
	}

}
