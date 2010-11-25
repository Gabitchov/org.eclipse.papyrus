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
package org.eclipse.papyrus.diagram.menu.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.EditPartService;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.ListCompartment;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.diagram.common.actions.AbstractShowHideAction;
import org.eclipse.papyrus.diagram.common.commands.ShowHideCompartmentRequest;
import org.eclipse.papyrus.diagram.common.editpolicies.ShowHideCompartmentEditPolicy;
import org.eclipse.papyrus.diagram.common.providers.EditorLabelProvider;
import org.eclipse.papyrus.diagram.common.util.ViewServiceUtil;
import org.eclipse.papyrus.diagram.menu.messages.Messages;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.dialogs.CheckedTreeSelectionDialog;
import org.eclipse.uml2.uml.Element;

/**
 * 
 * This class provides the Action Show/Hide compartments.
 * This action allows to choose the compartment to display for each EditPart owning CompartmentEditPart
 * 
 */
public class ShowHideCompartmentAction extends AbstractShowHideAction {


	/** String used when the name of an element was not found */
	public static final String NO_NAME = Messages.ShowHideCompartmentAction_No_Name;
	
	private static final String SHOW_NAME_OF_COMPARTMENT = "Show name of the compartment";

	/** the transactional editing domain */
	protected TransactionalEditingDomain domain;

	//	/** %Title for the ShowHideCompartment Action */
	//	public static String ShowHideCompartmentAction_Title;
	//
	//	/** Message for the ShowHideCompartment Action */
	//	public static String ShowHideCompartmentAction_Message;
	//	ShowHideCompartmentAction_Message=Choose the compartments to show
	//	ShowHideAction_No_Name=No Name
	//	ShowHideCompartmentAction_Title=Show/Hide compartments

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
	
	@Override
	protected CheckedTreeSelectionDialog getSelectionDialog() {
		CheckedTreeSelectionDialog selectionDialog = super.getSelectionDialog();
		selectionDialog.setContainerMode(false);
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

		//we remove the Element from the result
		for(int i = 0; i < results.length; i++) {
			if(results[i] instanceof Element) {
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
			if(!result.contains(current)) {
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
		this.setEditorLabelProvider(new CustomEditorLabelProvider());
		this.domain = ((IGraphicalEditPart)this.selectedElements.get(0)).getEditingDomain();
		for(EditPart current : this.selectedElements) {
			CustomEditPartRepresentation rep = new CustomEditPartRepresentation(current);
			representations.add(rep);
		}
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
		Iterator<EditPartRepresentation> it = this.representations.iterator();
		List<Object> input = new ArrayList<Object>();
		while(it.hasNext()) {
			input.add(it.next());
		}
		return input;
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
				CustomEditPartRepresentation rep = findRepresentation(((View)current).getElement(), representations);
				if(rep != null) {
					EditPart ep = rep.getRepresentedEditPart();
					req = new ShowHideCompartmentRequest(ShowHideCompartmentRequest.HIDE, ((View)current).getType());
					req.setType(ShowHideCompartmentRequest.SHOW_HIDE_COMPARTMENT);
					Command tmp = ep.getCommand(req);
					if(tmp != null && tmp.canExecute()) {
						completeCmd.add(tmp);
					}
				}
			}
		}

		//the command to show compartment
		for(Object current : this.viewsToCreate) {
			if(current instanceof View) {
				CustomEditPartRepresentation rep = findRepresentation(((View)current).getElement(), representations);
				if(rep != null) {
					EditPart ep = rep.getRepresentedEditPart();
					req = new ShowHideCompartmentRequest(ShowHideCompartmentRequest.SHOW, ((View)current).getType());
					req.setType(ShowHideCompartmentRequest.SHOW_HIDE_COMPARTMENT);
					Command tmp = ep.getCommand(req);
					if(tmp != null && tmp.canExecute()) {
						completeCmd.add(tmp);
					}
				}
			}
		}

		return completeCmd;
	}


	/**
	 * 
	 * @param element
	 *        an element
	 * @param representationList
	 *        a list of {@link CustomEditPartRepresentation}
	 * @return
	 *         <ul>
	 *         <li>the {@link CustomEditPartRepresentation}</li> owning the element, if it's found
	 *         <li> <code>null</code> if not</li>
	 *         </ul>
	 */
	protected CustomEditPartRepresentation findRepresentation(Object element, List<EditPartRepresentation> representationList) {
		for(EditPartRepresentation current : representationList) {
			if(((CustomEditPartRepresentation)current).getSemanticElement() == element) {
				return (CustomEditPartRepresentation)current;
			} else if(((CustomEditPartRepresentation)current).getAllPossibleCompartment().contains(element)) {
				return (CustomEditPartRepresentation)current;

			}
		}
		return null;
	}



	/**
	 * 
	 * Provide the label for the selected element
	 * 
	 */
	protected class CustomEditorLabelProvider extends EditorLabelProvider {

		/**
		 * 
		 * @see org.eclipse.papyrus.diagram.common.providers.EditorLabelProvider#getImage(java.lang.Object)
		 * 
		 * @param element
		 * @return
		 */
		@Override
		public Image getImage(Object element) {
			if(element instanceof EditPartRepresentation) {
				element = ((EditPartRepresentation)element).getUMLElement();
			}
			return super.getImage(element);
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
		 * 
		 * @param element
		 * @return
		 *         the name of the element or
		 */
		@Override
		public String getText(Object element) {
			if(element instanceof EditPartRepresentation) {
				element = ((EditPartRepresentation)element).getUMLElement();
			}

			/*
			 * if(element instanceof BasicCompartment) {
			 * CustomEditPartRepresentation rep = findRepresentation(element, representations);
			 * if(rep != null) {
			 * String name = rep.getName(element);
			 * if(name != null) {
			 * return name;
			 * }
			 * }
			 * }
			 */
			if(element instanceof BasicCompartment || element instanceof DecorationNode) {
				CustomEditPartRepresentation rep = findRepresentation(element, representations);
				if(rep != null) {
					String name = rep.getName(element);
					if(name != null) {
						return name;
					}
				}
			}
			if (element instanceof ShowNameOfCompartmentItem) {
				return ((ShowNameOfCompartmentItem)element).getText();
			}
			return super.getText(element);
		}
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
			// TODO Auto-generated method stub
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
			// TODO Auto-generated method stub
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
			if(parentElement instanceof CustomEditPartRepresentation) {
				return ((CustomEditPartRepresentation)parentElement).getAllPossibleCompartment().toArray();
			}
			if (parentElement instanceof View) {
				return new Object[]{new ShowNameOfCompartmentItem((View)parentElement)};
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
			if (element instanceof ShowNameOfCompartmentItem) {
				return ((ShowNameOfCompartmentItem)element).compartment;
			}
			//it's a basicCompartment
				for(EditPartRepresentation rep : representations) {
					List<?> init = rep.getInitialSelection();
					if(init.contains(element)) {
						return rep;
					}
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



	/**
	 * 
	 * This class provides some facilities to build this action.
	 * 
	 */
	protected class CustomEditPartRepresentation extends EditPartRepresentation {

		/** the initial compartment visible for this editpart, represented by their Visual ID */
		protected List<String> initialCompartments = new ArrayList<String>();

		/** the possible compartment */
		protected List<View> possibleCompartments = new ArrayList<View>();

		/** the initial selection */
		protected List<View> initialSelection = new ArrayList<View>();

		/**
		 * 
		 * Constructor.
		 * 
		 * @param editpart
		 */
		public CustomEditPartRepresentation(EditPart editpart) {
			super(editpart, (Element)((View)editpart.getModel()).getElement());
			init();

		}

		/**
		 * Initialize the following fields:
		 * <ul>
		 * <li>{@link #initialCompartments}</li>
		 * <li>{@link #possibleCompartments}</li>
		 * <li>{@link #initialSelection}</li>
		 * </ul>
		 */
		protected void init() {
			List<?> localChildren = representedEditPart.getChildren();

			//fill this.initialCompartments
			for(Object current : localChildren) {
				if(current instanceof CompartmentEditPart) {
					initialCompartments.add(((View)((CompartmentEditPart)current).getModel()).getType());
				}
			}

			//fill this.possibleCompartments
			View notationView = ((GraphicalEditPart)representedEditPart).getNotationView();
			List<?> graphicalChildren = notationView.getChildren();
			for(Object child : graphicalChildren) {
				// Only add compartment
				if(child instanceof BasicCompartment) {
					this.possibleCompartments.add((View)child);
				} else if(child instanceof DecorationNode) {
					this.possibleCompartments.add((View)child);
				}
			}


			//fill this.initialSelection
			if(this.possibleCompartments != null && !this.possibleCompartments.isEmpty()) {
				for(View view : this.possibleCompartments) {
					if(!this.isCompartmentName(view)) {
						String type = view.getType();
						if(this.initialCompartments.contains(type)) {
							this.initialSelection.add(view);
						}
					}
				}
			}
			
			
			
		}
		
		private List<ShowNameOfCompartmentItem> getCompartmentsWithShownName() {
			List<ShowNameOfCompartmentItem> result = new ArrayList<ShowNameOfCompartmentItem>();
			View notationView = ((GraphicalEditPart)representedEditPart).getNotationView();
			for (Object next: notationView.getChildren()) {
				if (next instanceof ListCompartment) {
					ListCompartment compartment = (ListCompartment)next;
					if (compartment.isShowTitle()) {
						result.add(new ShowNameOfCompartmentItem(compartment));
					}
					
				}
			}
			return result;
		}


		/**
		 * Returns the name of the element.
		 * 
		 * @param element
		 *        the element for which we are looking for its name
		 * @return
		 *         <ul>
		 *         <li>the name of the element</li>
		 *         <li><code>null</code> if the name has not been found</li>
		 *         </ul>
		 */
		public String getName(Object element) {

			String name = null;
			String type = null;
			if(element instanceof View) {
				type = ((View)element).getType();
				View view = findViewForThisType(type);
				if(view != null) {
					EditPart dummyEP = EditPartService.getInstance().createGraphicEditPart(view);
					IGraphicalEditPart epp = (IGraphicalEditPart)dummyEP;
					//					IFigure fig1 = epp.getFigure();
					//					if(fig1 instanceof ResizableCompartmentFigure) {//TODO not useful to use the figure?
					//						name = ((ResizableCompartmentFigure)fig1).getCompartmentTitle();
					//					} else if(fig1 == null) {
					if(dummyEP instanceof ResizableCompartmentEditPart) {
						name = ((ResizableCompartmentEditPart)dummyEP).getCompartmentName();
					}
					//					}
					dummyEP = null;
				}
			}
			return name;
		}

		/**
		 * Return the corresponding view or null, if the view was not found
		 * 
		 * @param type
		 *        the type for which we are looking for the view
		 * @return
		 *         The corresponding view or null, if the view was not found
		 */
		protected View findViewForThisType(String type) {
			for(Object current : this.possibleCompartments) {
				if(current instanceof View) {
					if(((View)current).getType().equals(type)) {
						return (View)current;
					}
				}
			}
			return null;

		}

		/**
		 * Getter for {@link #initialSelection}
		 * 
		 * @return
		 *         {@link #initialSelection}
		 */
		@Override
		public List getInitialSelection() {
			ArrayList result = new ArrayList(initialSelection);
			result.addAll(getCompartmentsWithShownName());
			return result;
		}

		/**
		 * Returns the semantic element represented by {@link #representedEditPart}
		 * 
		 * @return
		 *         the semantic element represented by {@link #representedEditPart}
		 */
		public Element getSemanticElement() {
			return (Element)((View)representedEditPart.getModel()).getElement();
		}

		/**
		 * Return the views representing the possible compartment for the editpart
		 * 
		 * @return
		 *         the views representing the possible compartment for the editpart
		 */
		public List<View> getAllPossibleCompartment() {
			List<View> children = new ArrayList<View>();
			for(View view : this.possibleCompartments) {
				if(!isCompartmentName(view)) {
					children.add(view);
				}
			}
			return children;
		}

		/**
		 * Test if the view represents a compartment name
		 * 
		 * @param view
		 *        the view to test
		 * @return
		 *         <ul>
		 *         <li>
		 *         <code>true</code> if the view represents a compartment name</li>
		 *         <li><code>false</code> if not</li>
		 *         </ul>
		 */
		public boolean isCompartmentName(View view) {
			List<?> chilrenEP = this.representedEditPart.getChildren();
			for(Object current : chilrenEP) {//the name compartment is never hide!
				if(((View)((EditPart)current).getModel()).getType().equals(view.getType())) {
					if(current instanceof CompartmentEditPart && current instanceof ITextAwareEditPart) {
						return true;
					}
				}
			}
			return false;
		}
	}
	
	private class ShowNameOfCompartmentItem {
		
		protected final View compartment;
		
		public ShowNameOfCompartmentItem(View compartment) {
			this.compartment = compartment;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			}
			if (false == obj instanceof ShowNameOfCompartmentItem) {
				return false;
			}
			return this.compartment.equals(((ShowNameOfCompartmentItem)obj).compartment);
		}
		
		@Override
		public int hashCode() {
			return 3 * SHOW_NAME_OF_COMPARTMENT.hashCode() + 5 * compartment.hashCode();
		}
		
		@Override
		public String toString() {
			return SHOW_NAME_OF_COMPARTMENT + ": " + compartment;
		}
		
		public String getText() {
			return SHOW_NAME_OF_COMPARTMENT;
		}
		
	}

}
