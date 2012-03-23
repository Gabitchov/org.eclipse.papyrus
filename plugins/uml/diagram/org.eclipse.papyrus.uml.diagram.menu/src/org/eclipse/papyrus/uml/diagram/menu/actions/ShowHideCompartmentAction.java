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
package org.eclipse.papyrus.uml.diagram.menu.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.ui.util.DisplayUtils;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.EditPartService;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.TitleStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.actions.AbstractShowHideAction;
import org.eclipse.papyrus.uml.diagram.common.commands.ShowHideCompartmentRequest;
import org.eclipse.papyrus.uml.diagram.common.commands.ShowHideTitleOfCompartmentCommand;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ShowHideCompartmentEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.util.CompartmentUtils;
import org.eclipse.papyrus.uml.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.uml.diagram.common.util.ViewServiceUtil;
import org.eclipse.papyrus.uml.diagram.menu.dialogs.ShowHideCompartmentSelectionDialog;
import org.eclipse.papyrus.uml.diagram.menu.messages.Messages;
import org.eclipse.ui.dialogs.SelectionDialog;

/**
 * 
 * This class provides the Action Show/Hide compartments.
 * This action allows to choose the compartment to display for each EditPart owning CompartmentEditPart
 * 
 */
public class ShowHideCompartmentAction extends AbstractShowHideAction {

	/** the transactional editing domain */
	//protected TransactionalEditingDomain domain;

	/** list of visible titles */
	protected List<CompartmentEditPartRepresentation> visibleTitle;


	/** the list of the visible views after selection in the dialog, to set title visiblity */
	protected List<CompartmentEditPartRepresentation> visibleRepresentations;

	/**
	 * Constructor.
	 */
	public ShowHideCompartmentAction() {
		super(Messages.ShowHideCompartmentAction_Title, Messages.ShowHideCompartmentAction_Messages, ShowHideCompartmentEditPolicy.SHOW_HIDE_COMPARTMENT_POLICY);
	}

	/**
	 * Edit part representation used as a main element in the tree
	 */
	public class RootEditPartRepresentation extends EditPartRepresentation {

		/**
		 * Constructor.
		 * @param representedEditPart
		 *        the represented EditPart
		 * @param eObject
		 *        the semantic element represented by EditPartRepresentation
		 */
		public RootEditPartRepresentation(IGraphicalEditPart representedEditPart, EObject eObject) {
			super(representedEditPart, eObject);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected void initRepresentation() {
			super.initRepresentation();

			List<View> compartmentViews = CompartmentUtils.getAllCompartments(getRepresentedEditPart(), false);
			List<View> visibleCompartments = CompartmentUtils.getAllVisibleCompartments(getRepresentedEditPart(), false);
			for(View currentView : compartmentViews) {
				CompartmentEditPartRepresentation representation = new CompartmentEditPartRepresentation(null, currentView, getSemanticElement(), this);
				elementsToSelect.add(representation);

				if(visibleCompartments.contains(currentView)) {
					initialSelection.add(representation);
				}

			}
		}
	}

	/**
	 * Edit Part Representation for the compartments.
	 * Warning: if the compartment notation view is not visible, the edit part is not created. So we need to manipulate the view, not the edit part in
	 * this representation
	 */
	public class CompartmentEditPartRepresentation extends EditPartRepresentation {

		/** boolean that indicates if the title should be visible or not */
		private boolean isTitleVisible;

		/** notation view of the compartment */
		final private View compartmentView;

		/**
		 * Constructor.
		 * 
		 * @param representedEditPart
		 *        the represented EditPart. this can be <code>null</code> if the compartment is not visible when the dialog is opened
		 * @param compartmentView
		 *        notation view for this compartment. this should never be <code>null</code>.
		 * @param eObject
		 *        the semantic element represented by EditPartRepresentation
		 * @param parentRepresentation
		 *        parent representation of this edit part representation
		 */
		public CompartmentEditPartRepresentation(IResizableCompartmentEditPart representedEditPart, View compartmentView, EObject eObject, EditPartRepresentation parentRepresentation) {
			super(representedEditPart, eObject, parentRepresentation);
			isTitleVisible = CompartmentUtils.isCompartmentTitleVisible(compartmentView);
			this.compartmentView = compartmentView;
			assert compartmentView != null : "The compartment view should not be null";
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public IResizableCompartmentEditPart getRepresentedEditPart() {
			return (IResizableCompartmentEditPart)super.getRepresentedEditPart();
		}

		/**
		 * 
		 * @return <code>true</code> if the title of the compartment is displayed
		 *         and <code>false</code> if not
		 */
		public boolean isTitleVisible() {
			return isTitleVisible;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String getLabel() {
			if(getRepresentedEditPart() != null) {
				return getRepresentedEditPart().getCompartmentName();
			} else {
				EditPart dummyEP = EditPartService.getInstance().createGraphicEditPart(getCompartmentView());
				if(dummyEP instanceof IResizableCompartmentEditPart) {
					return ((IResizableCompartmentEditPart)dummyEP).getCompartmentName();
				}
			}
			return getEditorLabelProvider().getText(getCompartmentView());
		}

		/**
		 * Sets the visibility of the title of the compartment
		 * 
		 * @param value
		 *        the value to set
		 */
		public void setTitleVisible(boolean value) {
			isTitleVisible = value;
		}

		/**
		 * Returns the view associated to the compartment
		 * 
		 * @return the view associated to the compartment
		 */
		public View getCompartmentView() {
			return compartmentView;
		}
	}

	//	/**
	//	 * {@inheritDoc}
	//	 */
	//	@Override
	//	protected void buildInitialSelection() {
	//		this.initialSelection = new ArrayList<Object>();
	//		rep = new ArrayList<CompartmentEditPartRepresentation>();
	//		visibleTitle = new ArrayList<CompartmentEditPartRepresentation>();
	//		for(EditPart current : this.selectedElements) {
	//			//			initialSelection.add(current);
	//			initialSelection.addAll(CompartmentUtils.getAllVisibleCompartments(current, false));
	//			//			initialSelection.addAll(getAllVisibleCompartmentName(current));
	//			for(View view : CompartmentUtils.getAllCompartments(current, false)) {
	//				CompartmentTitleRepresentation localRep = new CompartmentTitleRepresentation(current, view);
	//				if(localRep.isTitleVisible()) {
	//
	//					visibleTitle.add(localRep);
	//				}
	//				rep.add(localRep);
	//			}
	//		}
	//
	//		initialSelection.addAll(visibleTitle);
	//	}

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.common.actions.AbstractShowHideAction#getSelectionDialog()
	 * 
	 * @return
	 */
	@Override
	protected SelectionDialog getSelectionDialog() {
		ShowHideCompartmentSelectionDialog selectionDialog = new ShowHideCompartmentSelectionDialog(DisplayUtils.getDisplay().getActiveShell(), getEditorLabelProvider(), getContentProvider());
		selectionDialog.setTitle(Messages.ShowHideCompartmentAction_Title);
		selectionDialog.setMessage(Messages.ShowHideCompartmentAction_Messages);
		selectionDialog.setContainerMode(true);
		selectionDialog.setInput(getInput());
		selectionDialog.setExpandedElements(selectedElements.toArray());
		selectionDialog.setInitialElementSelections(getInitialSelection());
		// selectionDialog.setTitleRepresentation(rep);
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
			} else if(node instanceof EditPartRepresentation) {
				viewsToCreate.add((EditPartRepresentation)node);
			}
		}


		//we are looking for the view to destroy
		for(Object current : this.initialSelection) {
			if(!result.contains(current) && (current instanceof EditPartRepresentation)) {
				viewsToDestroy.add((EditPartRepresentation)current);
			}
		}

		// we are looking for visible elements, to set the shown title or hidden title
		for(Object node : result) {
			if(node instanceof CompartmentEditPartRepresentation) {
				visibleRepresentations.add((CompartmentEditPartRepresentation)node);
			}
		}
	}

	//	@Override
	//	public void run(IAction action) {
	//		initAction();
	//		super.run(action);
	//	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initAction() {
		super.initAction();

		visibleRepresentations = new ArrayList<CompartmentEditPartRepresentation>();

		for(IGraphicalEditPart current : this.selectedElements) {
			if(((View)current.getModel()).getElement() != null) {
				this.representations.add(new RootEditPartRepresentation(current, ((View)current.getModel()).getElement()));
			}
		}
		setContentProvider(new ContentProvider());
		// setEditorLabelProvider(new EditorLabelProvider());
		// this.domain = ((IGraphicalEditPart)this.selectedElements.get(0)).getEditingDomain();
		// this.initialSelection = getInitialSelection();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected List<Object> getInput() {
		return new ArrayList<Object>(representations);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getActionCommand() {
		/* for further information, see bug 302555 */
		ViewServiceUtil.forceLoad();

		ShowHideCompartmentRequest req = null;
		CompoundCommand completeCmd = new CompoundCommand("Destroy and Create Compartment Command"); //$NON-NLS-1$

		//the commands to hide compartment
		for(EditPartRepresentation current : this.viewsToDestroy) {
			if(current instanceof CompartmentEditPartRepresentation) {
				CompartmentEditPartRepresentation currentRepresentation = (CompartmentEditPartRepresentation)current;
				View currentView = currentRepresentation.getCompartmentView();
				EditPart currentEditPart = currentRepresentation.getRepresentedEditPart(); // should not be null, because a view to  delete should be visible, and so have an existing associated edit part.
				// if null, try to find it using gmf methods from the view

				if(currentEditPart == null) {
					Activator.log.debug("Warning! An edit part representation wished to destroy a view, but no edit part exists currently!" + current);
					currentEditPart = DiagramEditPartsUtil.getEditPartFromView(currentView, selectedElements.get(0)).getParent();
				}

				if(currentEditPart != null) {
					req = new ShowHideCompartmentRequest(ShowHideCompartmentRequest.HIDE, currentView);
					req.setType(ShowHideCompartmentRequest.SHOW_HIDE_COMPARTMENT);
					Command tmp = currentEditPart.getCommand(req);
					if(tmp != null && tmp.canExecute()) {
						completeCmd.add(tmp);
					}
				} else {
					Activator.log.debug("Impossible to find an edit part for the given representation: " + current);
				}

			}

			//			if(current instanceof View) {
			//				EditPart ep = DiagramEditPartsUtil.getEditPartFromView((View)current, selectedElements.get(0)).getParent();
			//				req = new ShowHideCompartmentRequest(ShowHideCompartmentRequest.HIDE, ((View)current).getType());
			//				req.setType(ShowHideCompartmentRequest.SHOW_HIDE_COMPARTMENT);
			//				Command tmp = ep.getCommand(req);
			//				if(tmp != null && tmp.canExecute()) {
			//					completeCmd.add(tmp);
			//				}
			//			} else if(current instanceof CompartmentTitleRepresentation) {
			//				ShowHideTitleOfCompartmentCommand tmp = new ShowHideTitleOfCompartmentCommand(this.domain, (View)((CompartmentTitleRepresentation)current).getRealObject(), false);
			//				if(tmp != null && tmp.canExecute()) {
			//					completeCmd.add(new ICommandProxy(tmp));
			//				}
			//			}
		}

		//the command to show compartment
		for(EditPartRepresentation current : this.viewsToCreate) {
			if(current instanceof CompartmentEditPartRepresentation) {
				CompartmentEditPartRepresentation currentRepresentation = (CompartmentEditPartRepresentation)current;
				View currentView = currentRepresentation.getCompartmentView();
				EditPartRepresentation parentRepresentation = currentRepresentation.getParentRepresentation();
				IGraphicalEditPart parentEditPart = parentRepresentation.getRepresentedEditPart();
				if(currentView != null && parentEditPart != null) {
					req = new ShowHideCompartmentRequest(ShowHideCompartmentRequest.SHOW, currentView);
					req.setType(ShowHideCompartmentRequest.SHOW_HIDE_COMPARTMENT);
					Command tmp = parentEditPart.getCommand(req);
					if(tmp != null && tmp.canExecute()) {
						completeCmd.add(tmp);
					}
				}
			}

			//			if(current instanceof View) {
			//				EditPart ep = CompartmentUtils.getCompartmentTitleRepresentation(rep, (View)current).getParent();
			//				req = new ShowHideCompartmentRequest(ShowHideCompartmentRequest.SHOW, ((View)current).getType());
			//				req.setType(ShowHideCompartmentRequest.SHOW_HIDE_COMPARTMENT);
			//				Command tmp = ep.getCommand(req);
			//				if(tmp != null && tmp.canExecute()) {
			//					completeCmd.add(tmp);
			//				}
			//			} else if(current instanceof CompartmentTitleRepresentation) {
			//				CompartmentTitleRepresentation compartmentTitleRep = (CompartmentTitleRepresentation)current;
			//				final View view = (View)compartmentTitleRep.getRealObject();
			//				Style style = view.getStyle(NotationPackage.eINSTANCE.getTitleStyle());
			//				if(style == null) {
			//					// style is not existing yet (true for models created with Papyrus 0.7.x) => create now
			//					// See bug 351084
			//					completeCmd.add(new ICommandProxy(new AbstractTransactionalCommand(domain, "Create title style", Collections.EMPTY_LIST) { //$NON-NLS-1$
			//
			//						public CommandResult doExecuteWithResult(IProgressMonitor dummy, IAdaptable info) {
			//							TitleStyle style = (TitleStyle)view.createStyle(NotationPackage.eINSTANCE.getTitleStyle());
			//							style.setShowTitle(false);
			//							return CommandResult.newOKCommandResult();
			//						}
			//					}));
			//				}
			//				ShowHideTitleOfCompartmentCommand tmp = new ShowHideTitleOfCompartmentCommand(this.domain, view, true);
			//				if(tmp != null && tmp.canExecute()) {
			//					completeCmd.add(new ICommandProxy(tmp));
			//				}
			//			}
		}

		// now sets the visibility for all shown views

		for(CompartmentEditPartRepresentation currentRepresentation : visibleRepresentations) {
			final View currentView = currentRepresentation.getCompartmentView();
			boolean newVisibility = currentRepresentation.isTitleVisible();
			boolean oldVisibility = CompartmentUtils.isCompartmentTitleVisible(currentView);

			IGraphicalEditPart parentEditPart = currentRepresentation.getParentRepresentation().getRepresentedEditPart();
			final TransactionalEditingDomain domain = parentEditPart.getEditingDomain();
			// visibility has changed => change the model
			if(newVisibility != oldVisibility) {
				Style style = currentView.getStyle(NotationPackage.eINSTANCE.getTitleStyle());
				if(style == null) {
					// style is not existing yet (true for models created with Papyrus 0.7.x) => create now
					// See bug 351084
					completeCmd.add(new ICommandProxy(new AbstractTransactionalCommand(domain, "Create title style", Collections.EMPTY_LIST) { //$NON-NLS-1$

						@Override
						public CommandResult doExecuteWithResult(IProgressMonitor dummy, IAdaptable info) {
							TitleStyle style = (TitleStyle)currentView.createStyle(NotationPackage.eINSTANCE.getTitleStyle());
							style.setShowTitle(false);
							return CommandResult.newOKCommandResult();
						}
					}));
				}
				ShowHideTitleOfCompartmentCommand tmp = new ShowHideTitleOfCompartmentCommand(domain, currentView, newVisibility);
				if(tmp != null && tmp.canExecute()) {
					completeCmd.add(new ICommandProxy(tmp));
				}
			}
		}

		return completeCmd;
	}


	/**
	 * Provide the element to fill the tree
	 */
	protected class ContentProvider implements ITreeContentProvider {

		/**
		 * {@inheritDoc}
		 */
		public void dispose() {
			//nothing to do
		}

		/**
		 * {@inheritDoc}
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			//nothing to do
		}

		/**
		 * {@inheritDoc}
		 */
		public Object[] getElements(Object inputElement) {
			if(inputElement instanceof List) {
				return ((List<?>)inputElement).toArray();
			}
			return new Object[0];
		}

		/**
		 * {@inheritDoc}
		 */
		public Object[] getChildren(Object parentElement) {
			if(parentElement instanceof EditPartRepresentation) {
				return ((EditPartRepresentation)parentElement).getPossibleElement().toArray();
			}
			return new Object[0];
		}

		/**
		 * {@inheritDoc}
		 */
		public Object getParent(Object element) {
			if(element instanceof EditPartRepresentation) {
				EditPartRepresentation editPartRepresentation = (EditPartRepresentation)element;
				return editPartRepresentation.getParentRepresentation();
			}
			return null;
		}

		/**
		 * {@inheritDoc}
		 */
		public boolean hasChildren(Object element) {
			Object[] children = getChildren(element);
			return children != null && children.length != 0;
		}

	}
}
