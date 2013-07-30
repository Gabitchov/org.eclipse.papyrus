/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.actions;

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

import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.emf.providers.EMFLabelProvider;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.util.ViewServiceUtil;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.CheckedTreeSelectionDialog;
import org.eclipse.ui.dialogs.SelectionDialog;

/**
 * 
 * Super Class for the ShowHide action
 * 
 */
public abstract class AbstractShowHideAction implements IActionDelegate, IWorkbenchWindowActionDelegate {

	/** the selected elements */
	protected List<IGraphicalEditPart> selectedElements;

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
	protected List<EditPartRepresentation> viewsToDestroy;

	/** the list of the view to create */
	protected List<EditPartRepresentation> viewsToCreate;

	/** the list of the {@link EditPartRepresentation} */
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
		// ViewServiceUtil.forceLoad();
	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		// nothing here
	}

	/**
	 * {@inheritDoc}
	 */
	public void init(IWorkbenchWindow window) {
		// nothing here
	}

	/**
	 * {@inheritDoc}
	 */
	public void run(IAction action) {

		if(!canRun()) {
			return;
		}
		initAction();
		buildInitialSelection();
		SelectionDialog selectionDialog = getSelectionDialog();
		selectionDialog.open();
		if(selectionDialog.getReturnCode() == Dialog.OK) {
			buildShowHideElementsList(selectionDialog.getResult());
			final Command command = getActionCommand();
			final TransactionalEditingDomain domain = this.selectedElements.get(0).getEditingDomain();
			if(command.canExecute()) {
				try {
					domain.runExclusive(new Runnable() {

						public void run() {
							PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {

								// executing the command
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
	 * Creates and returns the selection dialog displayed by this action
	 * 
	 * @return the created selection dialog
	 */
	protected SelectionDialog getSelectionDialog() {
		CheckedTreeSelectionDialog selectionDialog = new CheckedTreeSelectionDialog(DisplayUtils.getDisplay().getActiveShell(), getEditorLabelProvider(), getContentProvider());
		selectionDialog.setTitle(title);
		selectionDialog.setMessage(message);
		selectionDialog.setContainerMode(true);
		selectionDialog.setInput(getInput());
		selectionDialog.setExpandedElements(getExpandedElements());
		selectionDialog.setInitialElementSelections(getInitialSelection());
		return selectionDialog;
	}

	/**
	 * Returns the list of all elements
	 * 
	 * @return the list of all elements
	 */
	protected Object[] getExpandedElements() {
		List<Object> allElements = new ArrayList<Object>();
		for(EditPartRepresentation current : this.representations) {
			allElements.add(current);
			allElements.addAll(current.getPossibleElement());
		}
		return allElements.toArray();
	}

	/**
	 * 
	 * Test if the action can be run! Useful when we press F4 and it's the first
	 * action in Papyrus
	 * 
	 * @return if the action can be run or not
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
			selectedElements = new ArrayList<IGraphicalEditPart>();
			if(selection instanceof StructuredSelection) {
				for(Object current : ((StructuredSelection)selection).toArray()) {
					if(current instanceof IGraphicalEditPart) {
						selectedElements.add((IGraphicalEditPart)current);
						EditPolicy policy = ((IGraphicalEditPart)current).getEditPolicy(editPolicyKey);
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
		this.labelProvider = new EditPartRepresentationLabelProvider();
		this.representations = new ArrayList<AbstractShowHideAction.EditPartRepresentation>();
	}

	/**
	 * Returns the initial selection for the Tree Dialog.
	 * 
	 * @return The initial selection for the Tree Dialog
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
			contributeToInitialSelection(initialSelection, current);
		}
	}

	/**
	 * Complete the list of initial selection for the given representation and its potential children
	 * 
	 * @param listToComplete
	 *        the list of selected elements to complete
	 * @param representation
	 *        the edit part representation that completes the list
	 */
	protected void contributeToInitialSelection(List<Object> listToComplete, EditPartRepresentation representation) {
		listToComplete.addAll(representation.getInitialSelection());
		List<EditPartRepresentation> children = representation.getPossibleElement();
		if(children != null) {
			for(EditPartRepresentation child : children) {
				contributeToInitialSelection(listToComplete, child);
			}
		}
	}

	/**
	 * Returns the input for the TreeDialog
	 * 
	 * @return the input for the TreeDialog
	 */
	abstract protected List<Object> getInput();

	/**
	 * Fill the following fields with the elements to show and the elements to
	 * hide
	 * <ul>
	 * <li>{@link #viewsToCreate}</li>
	 * <li> {@link #viewsToDestroy}</li>
	 * </ul>
	 * 
	 * @param result
	 *        the interesting element selected in the tree
	 */
	protected void buildShowHideElementsList(Object[] result) {
		this.viewsToCreate = new ArrayList<EditPartRepresentation>();
		this.viewsToDestroy = new ArrayList<EditPartRepresentation>();
	}

	/**
	 * Returns the command done by this action
	 * 
	 * @return the command done by this action
	 */
	abstract protected Command getActionCommand();

	/**
	 * Setter for {@link #labelProvider}
	 * 
	 * @param provider
	 *        the label provider for the tree
	 */
	protected void setEditorLabelProvider(ILabelProvider provider) {
		this.labelProvider = provider;
	}

	/**
	 * Returns the label provider used by the dialog
	 * 
	 * @return the labelProvider
	 */
	protected ILabelProvider getEditorLabelProvider() {
		return labelProvider;
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
	 * Returns the content provider for the selection dialog
	 * 
	 * @return the contentProvider
	 */
	protected ITreeContentProvider getContentProvider() {
		return contentProvider;
	}

	/**
	 * Setter for {@link #selectedElements}. When this action is called by a
	 * popup menu, {@link #selectedElements} is filled by {@link #selectionChanged(IAction, ISelection)} When this action is called
	 * by a Handler, {@link #selectedElements} is filled with this method
	 * 
	 * @param selection
	 *        the current selection
	 */
	public void setSelection(List<IGraphicalEditPart> selection) {
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
	public class EditPartRepresentation {

		/** the editpart represented by this class */
		private IGraphicalEditPart representedEditPart;

		/** the initial selection */
		protected List<EditPartRepresentation> initialSelection;

		/** the possible element to show/hide */
		protected List<EditPartRepresentation> elementsToSelect;

		/** the semantic element represented by the EditPart */
		protected EObject eObject;

		/** parent edit part representation */
		final private EditPartRepresentation parentRepresentation;

		/**
		 * Constructor.
		 * 
		 * @param representedEditPart
		 *        the represented EditPart
		 * @param eObject
		 *        the semantic element represented by EditPartRepresentation
		 */
		public EditPartRepresentation(IGraphicalEditPart representedEditPart, EObject eObject) {
			this(representedEditPart, eObject, null);
		}

		/**
		 * 
		 * Constructor.
		 * 
		 * @param representedEditPart
		 *        the represented EditPart
		 * @param eObject
		 *        the semantic element represented by EditPartRepresentation
		 * @param parentRepresentation
		 *        parent representation of this edit part representation
		 */
		public EditPartRepresentation(IGraphicalEditPart representedEditPart, EObject eObject, EditPartRepresentation parentRepresentation) {
			this.setRepresentedEditPart(representedEditPart);
			this.eObject = eObject;
			this.parentRepresentation = parentRepresentation;
			initRepresentation();
		}

		/**
		 * Getter for {@link #representedEditPart}
		 * 
		 * @return the represented editpart, {@link #representedEditPart}
		 */
		public IGraphicalEditPart getRepresentedEditPart() {
			return this.representedEditPart;
		}

		/**
		 * Getter for {@link #eObject}
		 * 
		 * @return {@link #eObject}
		 */
		public EObject getSemanticElement() {
			return this.eObject;
		}

		/**
		 * Getter for {@link #initialSelection}
		 * 
		 * @return {@link #initialSelection}
		 */
		public List<EditPartRepresentation> getInitialSelection() {
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
			this.initialSelection = new ArrayList<EditPartRepresentation>();
			this.elementsToSelect = new ArrayList<EditPartRepresentation>();
		}

		/**
		 * Setter for {@link #elementsToSelect}
		 * 
		 * @return {@link #elementsToSelect}
		 */
		public List<EditPartRepresentation> getPossibleElement() {
			return this.elementsToSelect;
		}

		/**
		 * Returns the parent representation of this edit part representation
		 * 
		 * @return the parent representation of this edit part representation
		 */
		public EditPartRepresentation getParentRepresentation() {
			return parentRepresentation;
		}

		/**
		 * Setter for the {@link #representedEditPart}
		 * 
		 * @param representedEditPart
		 *        {@link #representedEditPart}
		 */
		public void setRepresentedEditPart(IGraphicalEditPart representedEditPart) {
			this.representedEditPart = representedEditPart;
		}

		/**
		 * Returns the display label for this edit part representation
		 * 
		 * @return the display label for this edit part representation
		 */
		public String getLabel() {
			EObject semanticElement = getSemanticElement();
			if(isElementInherited()) {
				StringBuffer buffer = new StringBuffer();
				buffer.append(getEditorLabelProvider().getText(getSemanticElement()));
				buffer.append(" ");
				buffer.append("(from ");
				buffer.append(getEditorLabelProvider().getText(getSemanticElement().eContainer()));
				buffer.append(")");
				return buffer.toString();
			}
			return getEditorLabelProvider().getText(semanticElement);
		}

		/**
		 * Returns the display label for this edit part representation
		 * 
		 * @return the display label for this edit part representation
		 */
		public Image getImage() {
			return getEditorLabelProvider().getImage(getSemanticElement());
		}

		/**
		 * Checks if the parent of the element linked to the given edit part representation is similar to the element of the parent representation
		 * 
		 * @param representation
		 *        the edit part representation to check
		 * @return <code>true</code> if the element is inherited
		 */
		protected boolean isElementInherited() {
			EditPartRepresentation parentRepresentation = getParentRepresentation();
			if(parentRepresentation == null) { // no parent => can not be inherited
				return false;
			}

			// no uml element in representation, can not check
			if(getSemanticElement() == null) {
				return false;
			}

			EObject parentElement = parentRepresentation.getSemanticElement();
			EObject elementOwner = getSemanticElement().eContainer(); // Null for rer.getUMLElement was already check before.
			if(parentElement == null || elementOwner == null) { // no element in the parent representation
				return false;
			}

			if(!parentElement.equals(elementOwner)) {
				return true;
			}
			return false;
		}
	}

	/**
	 * label provider that delegates to the edit part representation the label
	 */
	protected class EditPartRepresentationLabelProvider extends LabelProvider {

		/** editor label provider */
		protected EMFLabelProvider editorLabelProvider;

		/**
		 * Constructor.
		 */
		public EditPartRepresentationLabelProvider() {
			this.editorLabelProvider = new EMFLabelProvider();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String getText(Object element) {
			if(element instanceof EditPartRepresentation) {
				return ((EditPartRepresentation)element).getLabel();
			}
			return editorLabelProvider.getText(element);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Image getImage(Object element) {
			if(element instanceof EditPartRepresentation) {
				return ((EditPartRepresentation)element).getImage();
			}
			return editorLabelProvider.getImage(element);
		}
	}

	//	/**
	//	 * 
	//	 * EditorLabelProvider for the {@link CheckedTreeSelectionDialog}
	//	 * 
	//	 */
	//	public class CustomEditorLabelProvider extends EditorLabelProvider {
	//
	//		/**
	//		 * {@inheritDoc}
	//		 */
	//		@Override
	//		public Image getImage(Object element) {
	//			if(element instanceof EditPartRepresentation) {
	//				element = ((EditPartRepresentation)element).getSemanticElement();
	//			}
	//			return super.getImage(element);
	//		}
	//
	//		/**
	//		 * {@inheritDoc}
	//		 */
	//		@Override
	//		public String getText(Object element) {
	//			if(element instanceof CompartmentEditPartRepresentation) {
	//				return ((CompartmentEditPartRepresentation)element).getCompartmentName();
	//			} else if(element instanceof EditPartRepresentation) {
	//				EObject semanticElement = ((EditPartRepresentation)element).getSemanticElement();
	//				if(isElementInherited((EditPartRepresentation)element)) {
	//					StringBuffer buffer = new StringBuffer();
	//					buffer.append(super.getText(semanticElement));
	//					buffer.append(" ");
	//					buffer.append("(from ");
	//					buffer.append(super.getText(((EditPartRepresentation)element).getSemanticElement().eContainer()));
	//					buffer.append(")");
	//					return buffer.toString();
	//				} else {
	//					return super.getText(semanticElement);
	//				}
	//			}
	//			return super.getText(element);
	//		}
	//	}

}
