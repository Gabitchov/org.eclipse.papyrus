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
 *  Tatiana Fesenko (CEA LIST) - Bug 331102 - Allow to configure visibility of name of the compartment in the Filter Compartment dialog
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.menu.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.ui.util.DisplayUtils;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.diagram.common.actions.AbstractShowHideAction;
import org.eclipse.papyrus.diagram.common.commands.ShowHideCompartmentRequest;
import org.eclipse.papyrus.diagram.common.commands.ShowHideTitleOfCompartmentCommand;
import org.eclipse.papyrus.diagram.common.editpolicies.ShowHideCompartmentEditPolicy;
import org.eclipse.papyrus.diagram.common.providers.EditorLabelProvider;
import org.eclipse.papyrus.diagram.common.util.CompartmentTitleRepresentation;
import org.eclipse.papyrus.diagram.common.util.CompartmentUtils;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.common.util.ViewServiceUtil;
import org.eclipse.papyrus.diagram.menu.dialogs.ShowHideCompartmentSelectionDialog;
import org.eclipse.papyrus.diagram.menu.messages.Messages;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.dialogs.SelectionDialog;
import org.eclipse.uml2.uml.Element;

/**
 * 
 * This class provides the Action Show/Hide compartments.
 * This action allows to choose the compartment to display for each EditPart owning CompartmentEditPart
 * 
 */
public class ShowHideCompartmentAction extends AbstractShowHideAction {


	/** the transactional editing domain */
	protected TransactionalEditingDomain domain;

	/**
	 * 
	 * Constructor.
	 * 
	 * 
	 */
	public ShowHideCompartmentAction() {
		super(Messages.ShowHideCompartmentAction_Title, Messages.ShowHideCompartmentAction_Messages, ShowHideCompartmentEditPolicy.SHOW_HIDE_COMPARTMENT_POLICY);
	}

	/**
	 * 
	 * @see org.eclipse.ui.IWorkbenchWindowActionDelegate#init(org.eclipse.ui.IWorkbenchWindow)
	 * 
	 * @param window
	 */
	@Override
	public void init(IWorkbenchWindow window) {

	}

	/**
	 * 
	 * @see org.eclipse.ui.IWorkbenchWindowActionDelegate#dispose()
	 * 
	 */
	@Override
	public void dispose() {

	}

	protected List<CompartmentTitleRepresentation> rep;

	protected List<CompartmentTitleRepresentation> visibleTitle;

	/**
	 * Build the initial selection for the tree
	 */
	@Override
	protected void buildInitialSelection() {
		this.initialSelection = new ArrayList<Object>();
		rep = new ArrayList<CompartmentTitleRepresentation>();
		visibleTitle = new ArrayList<CompartmentTitleRepresentation>();
		for(EditPart current : this.selectedElements) {
			//			initialSelection.add(current);
			initialSelection.addAll(CompartmentUtils.getAllVisibleCompartments(current, false));
			//			initialSelection.addAll(getAllVisibleCompartmentName(current));
			for(View view : CompartmentUtils.getAllCompartments(current, false)) {
				CompartmentTitleRepresentation localRep = new CompartmentTitleRepresentation(current, view);
				if(localRep.isTitleVisible()) {

					visibleTitle.add(localRep);
				}
				rep.add(localRep);
			}
		}

		initialSelection.addAll(visibleTitle);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.common.actions.AbstractShowHideAction#getSelectionDialog()
	 * 
	 * @return
	 */
	@Override
	protected SelectionDialog getSelectionDialog() {
		ShowHideCompartmentSelectionDialog selectionDialog = new ShowHideCompartmentSelectionDialog(DisplayUtils.getDisplay().getActiveShell(), new EditorLabelProvider(), new ContentProvider());
		selectionDialog.setTitle(Messages.ShowHideCompartmentAction_Title);
		selectionDialog.setMessage(Messages.ShowHideCompartmentAction_Messages);
		selectionDialog.setContainerMode(true);
		selectionDialog.setInput(selectedElements);
		selectionDialog.setExpandedElements(selectedElements.toArray());
		selectionDialog.setInitialElementSelections(this.initialSelection);
		selectionDialog.setTitleRepresentation(rep);
		return selectionDialog;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.common.actions.AbstractShowHideAction#buildShowHideElementsList(java.lang.Object[])
	 * 
	 * @param results
	 */
	@Override
	protected void buildShowHideElementsList(Object[] results) {
		super.buildShowHideElementsList(results);
		List<Object> result = new ArrayList<Object>();

		//we remove the EditPart from the result
		for(int i = 0; i < results.length; i++) {
			if(results[i] instanceof EditPart) {
				continue;
			} else {
				result.add(results[i]);
			}
		}


		//we are looking for the object to show
		for(Object node : result) {
			if(initialSelection.contains(node)) {
				//we do nothing
				continue;
			} else {
				viewsToCreate.add(node);
			}
		}


		//we are looking for the view to destroy
		for(Object current : this.initialSelection) {
			if(!result.contains(current) && !(current instanceof EditPart)) {
				viewsToDestroy.add(current);
			}
		}
	}

	@Override
	public void run(IAction action) {
		initAction();
		super.run(action);
	}

	/**
	 * Initialize the following fields :
	 * <ul>
	 * <li> {@link #representations}</li>
	 * <li> {@link #viewsToCreate}</li>
	 * <li>{@link #viewsToDestroy}</li>
	 * <li> {@link #domain}</li>
	 * <li> {@link #initialSelection}</li>
	 * </ul>
	 */
	@Override
	protected void initAction() {
		super.initAction();
		if(this.selectedElements.size() < 1) {
			return;
		}
		setContentProvider(new ContentProvider());
		this.setEditorLabelProvider(new EditorLabelProvider());
		this.domain = ((IGraphicalEditPart)this.selectedElements.get(0)).getEditingDomain();
		this.initialSelection = getInitialSelection();
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.common.actions.AbstractShowHideAction#getInput()
	 * 
	 * @return
	 */
	@Override
	protected List<Object> getInput() {
		return this.initialSelection;
	}

	/**
	 * Returns the command to execute to show/hide the selected compartments
	 * 
	 * @return
	 *         the command to execute to show/hide the selected compartments
	 */

	@Override
	protected Command getActionCommand() {
		/* for further information, see bug 302555 */
		ViewServiceUtil.forceLoad();

		ShowHideCompartmentRequest req = null;
		CompoundCommand completeCmd = new CompoundCommand("Destroy and Create Compartment Command"); //$NON-NLS-1$

		//the commands to hide compartment
		for(Object current : this.viewsToDestroy) {
			if(current instanceof View) {
				EditPart ep = DiagramEditPartsUtil.getEditPartFromView((View)current, selectedElements.get(0)).getParent();
				req = new ShowHideCompartmentRequest(ShowHideCompartmentRequest.HIDE, ((View)current).getType());
				req.setType(ShowHideCompartmentRequest.SHOW_HIDE_COMPARTMENT);
				Command tmp = ep.getCommand(req);
				if(tmp != null && tmp.canExecute()) {
					completeCmd.add(tmp);
				}
			} else if(current instanceof CompartmentTitleRepresentation) {
				ShowHideTitleOfCompartmentCommand tmp = new ShowHideTitleOfCompartmentCommand(this.domain, (View)((CompartmentTitleRepresentation)current).getRealObject(), false);
				if(tmp != null && tmp.canExecute()) {
					completeCmd.add(new ICommandProxy(tmp));
				}
			}
		}

		//the command to show compartment
		for(Object current : this.viewsToCreate) {
			if(current instanceof View) {
				EditPart ep = CompartmentUtils.getCompartmentTitleRepresentation(rep, (View)current).getParent();
				req = new ShowHideCompartmentRequest(ShowHideCompartmentRequest.SHOW, ((View)current).getType());
				req.setType(ShowHideCompartmentRequest.SHOW_HIDE_COMPARTMENT);
				Command tmp = ep.getCommand(req);
				if(tmp != null && tmp.canExecute()) {
					completeCmd.add(tmp);
				}
			} else if(current instanceof CompartmentTitleRepresentation) {
				ShowHideTitleOfCompartmentCommand tmp = new ShowHideTitleOfCompartmentCommand(this.domain, (View)((CompartmentTitleRepresentation)current).getRealObject(), true);
				if(tmp != null && tmp.canExecute()) {
					completeCmd.add(new ICommandProxy(tmp));
				}
			}
		}

		return completeCmd;
	}


	/**
	 * 
	 * Provide the element to fill the tree
	 * 
	 */
	protected class ContentProvider implements ITreeContentProvider {

		/**
		 * 
		 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
		 * 
		 */
		public void dispose() {
			//nothing to do
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
		 * 
		 * @param viewer
		 * @param oldInput
		 * @param newInput
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			//nothing to do
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#getElements(java.lang.Object)
		 * 
		 * @param inputElement
		 * @return
		 */
		public Object[] getElements(Object inputElement) {
			if(inputElement instanceof List) {
				return ((List<?>)inputElement).toArray();
			}
			return new Object[0];
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
		 * 
		 * @param parentElement
		 * @return
		 */
		public Object[] getChildren(Object parentElement) {
			if(parentElement instanceof EditPart) {
				return CompartmentUtils.getAllCompartments((EditPart)parentElement, false).toArray();
			}
			return null;
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
		 * 
		 * @param element
		 * @return
		 */
		public Object getParent(Object element) {
			if(element instanceof Element) {
				return null;
			}
			if(element instanceof View) {
				CompartmentTitleRepresentation tmp = CompartmentUtils.getCompartmentTitleRepresentation(rep, (View)element);
				if(tmp != null) {
					return tmp.getParent();
				}

			}
			if(element instanceof CompartmentTitleRepresentation) {
				return ((CompartmentTitleRepresentation)element).getParent();
			}
			return null;
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
		 * 
		 * @param element
		 * @return
		 */
		public boolean hasChildren(Object element) {
			Object[] children = getChildren(element);
			return children != null && children.length != 0;
		}

	}
}
