/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.uml.diagram.menu.actions;

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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/


import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.ui.util.DisplayUtils;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.util.ViewServiceUtil;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.CheckedTreeSelectionDialog;
import org.eclipse.uml2.uml.Element;

/**
 * 
 * Super Class for the ShowHide action
 * 
 */
public abstract class AbstractShowHideAction implements IActionDelegate, IWorkbenchWindowActionDelegate {

	/** the selected elements */
	protected List<EditPart> selectedElements;

	/** the initial selection */
	protected List<Object> initialSelection;

	/** key for the EditPolicy providing the action */
	private String editPolicyKey = null;

	/** title for the window */
	private String title = null;

	/** message for the window */
	private String message = null;

	/** label provider */
	private ILabelProvider labelProvider = null;

	/** content provider */
	private ITreeContentProvider contentProvider = null;

	/** the list of the views to destroy */
	protected List<Object> viewsToDestroy;

	/** the list of the view to create */
	protected List<Object> viewsToCreate;

	/**
	 * the list of the {@link EditPartRepresentation}
	 */
	protected List<EditPartRepresentation> representations;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param title
	 *        title for the dialog
	 * @param message
	 *        message for the dialog
	 * @param editPolicyKey
	 *        the EditPolicy used for this action
	 */
	public AbstractShowHideAction(String title, String message, String editPolicyKey) {
		this.editPolicyKey = editPolicyKey;
		this.title = title;
		this.message = message;
		/* for further information, see bug 302555 */
		ViewServiceUtil.forceLoad();
	}

	/**
	 * 
	 * @see org.eclipse.ui.IWorkbenchWindowActionDelegate#dispose()
	 * 
	 */
	public void dispose() {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * @see org.eclipse.ui.IWorkbenchWindowActionDelegate#init(org.eclipse.ui.IWorkbenchWindow)
	 * 
	 * @param window
	 */
	public void init(IWorkbenchWindow window) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 * 
	 * @param action
	 */
	public void run(IAction action) {

		if(!canRun()) {
			return;
		}
		initAction();
		buildInitialSelection();

		CheckedTreeSelectionDialog selectionDialog = new CheckedTreeSelectionDialog(DisplayUtils.getDisplay().getActiveShell(), labelProvider, contentProvider);
		selectionDialog.setTitle(title);
		selectionDialog.setMessage(message);
		selectionDialog.setContainerMode(true);
		selectionDialog.setInput(getInput());
		selectionDialog.setExpandedElements(getInput().toArray());
		selectionDialog.setInitialElementSelections(this.initialSelection);
		selectionDialog.open();
		if(selectionDialog.getReturnCode() == Dialog.OK) {
			buildShowHideElementsList(selectionDialog.getResult());
			final Command command = getActionCommand();
			final TransactionalEditingDomain domain = ((IGraphicalEditPart)this.selectedElements.get(0)).getEditingDomain();
			if(command.canExecute()) {
				try {
					domain.runExclusive(new Runnable() {

						public void run() {
							PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {

								//executing the command
								public void run() {
									domain.getCommandStack().execute(new GEFtoEMFCommandWrapper(command));
								}
							});
						}
					});
				} catch (InterruptedException e) {
					Activator.log.error(e);
				}
			}
		}

	}

	/**
	 * 
	 * Test if the action can be run!
	 * Useful when we press F4 and it's the first action in Papyrus
	 * 
	 * @return
	 *         if the action can be run or not
	 */
	public boolean canRun() {

		if(this.selectedElements.isEmpty()) {
			return false;
		}
		for(Object object : this.selectedElements) {
			if(!(object instanceof EditPart)) {
				return false;
			} else {
				EditPolicy policy = ((EditPart)object).getEditPolicy(editPolicyKey);
				if(policy == null) {
					return false;
				}
			}
		}


		return true;
	}

	/**
	 * 
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
	 * 
	 * @param action
	 *        the current action
	 * @param selection
	 *        the current selection
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		boolean enabled = false;
		if(editPolicyKey != null) {
			selectedElements = new ArrayList<EditPart>();
			if(selection instanceof StructuredSelection) {
				for(Object current : ((StructuredSelection)selection).toArray()) {
					if(current instanceof EditPart) {
						selectedElements.add((EditPart)current);
						EditPolicy policy = ((EditPart)current).getEditPolicy(editPolicyKey);
						if(policy != null) {
							enabled = true;
							break;
						}
					}
				}
			}

		}
		if(action != null) {
			action.setEnabled(enabled);
		}
	}

	/**
	 * Initialize
	 * <ul>
	 * <li>{@link #labelProvider}</li>
	 * <li> {@link #representations}</li>
	 * </ul>
	 * 
	 * This method should be override by subclasses to initialize {@link #contentProvider} for example.
	 * 
	 */
	protected void initAction() {
		this.labelProvider = new UMLLabelProvider();
		this.representations = new ArrayList<AbstractShowHideAction.EditPartRepresentation>();
	}


	/**
	 * Returns the initial selection for the Tree Dialog.
	 * 
	 * @return
	 *         The initial selection for the Tree Dialog
	 */
	public List<Object> getInitialSelection() {
		return this.initialSelection;

	}

	/**
	 * Build the initial selection for the tree
	 */
	protected void buildInitialSelection() {
		this.initialSelection = new ArrayList<Object>();
		for(EditPartRepresentation current : this.representations) {
			initialSelection.addAll(current.getInitialSelection());
		}
	}

	/**
	 * Returns the input for the TreeDialog
	 * 
	 * @return
	 *         the input for the TreeDialog
	 */
	abstract protected List<Object> getInput();

	/**
	 * Fill the following fields with the elements to show and the elements to hide
	 * <ul>
	 * <li>{@link #viewsToCreate}</li>
	 * <li> {@link #viewsToDestroy}</li>
	 * </ul>
	 * 
	 * @param result
	 *        the interesting element selected in the tree
	 */
	protected void buildShowHideElementsList(Object[] result) {
		this.viewsToCreate = new ArrayList<Object>();
		this.viewsToDestroy = new ArrayList<Object>();
	}

	/**
	 * Returns the command done by this action
	 * 
	 * @return
	 *         the command done by this action
	 */
	abstract protected Command getActionCommand();

	protected void setEditorLabelProvider(ILabelProvider provider) {
		this.labelProvider = provider;
	}

	/**
	 * Setter for {@link #contentProvider}
	 * 
	 * @param provider
	 *        the provider for the tree
	 */
	protected void setContentProvider(ITreeContentProvider provider) {
		this.contentProvider = provider;
	}

	/**
	 * Setter for {@link #selectedElements}.
	 * When this action is called by a popup menu, {@link #selectedElements} is filled by {@link #selectionChanged(IAction, ISelection)} When this
	 * action is called by a Handler, {@link #selectedElements} is filled with this method
	 * 
	 * @param selection
	 *        the current selection
	 */
	public void setSelection(List<EditPart> selection) {
		this.selectedElements = selection;
	}

	/**
	 * Getter for {@link AbstractShowHideAction#editPolicyKey}
	 * 
	 * @return
	 * 
	 *         {@link AbstractShowHideAction#editPolicyKey}
	 */
	public String getEditPolicyKey() {
		return this.editPolicyKey;
	}

	/**
	 * 
	 * This class provides some facilities to build the action.
	 * 
	 */
	protected class EditPartRepresentation {

		/** the editpart represented by this class */
		protected EditPart representedEditPart;

		/** the initial selection */
		protected List<Object> initialSelection;

		/** the possible element to show/hide */
		protected List<Object> elementsToSelect;

		/** the UML element represented by the EditPart */
		protected Element UMLElement;

		/**
		 * 
		 * Constructor.
		 * 
		 * @param representedEditPart
		 *        the represented EditPart
		 * @param umlElement
		 *        the UMLElement represented by EditPartRepresentation
		 */
		public EditPartRepresentation(EditPart representedEditPart, Element umlElement) {
			this.representedEditPart = representedEditPart;
			this.UMLElement = umlElement;
			initRepresentation();
		}

		/**
		 * Getter for {@link #representedEditPart}
		 * 
		 * @return
		 *         the represented editpart, {@link #representedEditPart}
		 */
		public EditPart getRepresentedEditPart() {
			return this.representedEditPart;
		}

		/**
		 * Getter for {@link #UMLElement}
		 * 
		 * @return
		 *         {@link #UMLElement}
		 */
		public Element getUMLElement() {
			return this.UMLElement;
		}

		/**
		 * Getter for {@link #initialSelection}
		 * 
		 * @return
		 *         {@link #initialSelection}
		 */
		public List<Object> getInitialSelection() {
			return this.initialSelection;
		}

		/**
		 * initialize the following fields
		 * <ul>
		 * <li> {@link #initialSelection}</li>
		 * <li>{@link #elementsToSelect}</li>
		 * </ul>
		 */
		protected void initRepresentation() {
			this.initialSelection = new ArrayList<Object>();
			this.elementsToSelect = new ArrayList<Object>();
		}

		/**
		 * Setter for {@link #elementsToSelect}
		 * 
		 * @return
		 *         {@link #elementsToSelect}
		 */
		public List<Object> getPossibleElement() {
			return this.elementsToSelect;
		}
	}
}
