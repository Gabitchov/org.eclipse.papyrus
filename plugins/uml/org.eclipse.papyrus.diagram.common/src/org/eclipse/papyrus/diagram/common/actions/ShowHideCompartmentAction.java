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
package org.eclipse.papyrus.diagram.common.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.ui.util.DisplayUtils;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.EditPartService;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.Messages;
import org.eclipse.papyrus.diagram.common.command.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.diagram.common.commands.ShowHideCompartmentRequest;
import org.eclipse.papyrus.diagram.common.editpolicies.ShowHideCompartmentEditPolicy;
import org.eclipse.papyrus.diagram.common.util.ViewServiceUtil;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.CheckedTreeSelectionDialog;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;

/**
 * 
 * This class provides the Action Show/Hide compartments.
 * This action allows to choose the compartment to display for each EditPart owning CompartmentEditPart
 * 
 */
public class ShowHideCompartmentAction implements IActionDelegate, IWorkbenchWindowActionDelegate {


	/** icon for metaclass */
	public static final String ICON_METACLASS = "/icons/Metaclass.gif";//$NON-NLS-1$

	/** icon for a class */
	public static final String ICON_CLASS = "/icons/Class.gif"; //$NON-NLS-1$

	/** icon for a datatype */
	public static final String ICON_DATATYPE = "/icons/DataType.gif"; //$NON-NLS-1$

	/** icon for a stereotype */
	public static final String ICON_STEREOTYPE = "/icons/Stereotype.gif"; //$NON-NLS-1$

	/** icon for a profile */
	public static final String ICON_PROFILE = "/icons/Profile.gif"; //$NON-NLS-1$

	/** icon for a model */
	public static final String ICON_MODEL = "/icons/obj16/Model.gif"; //$NON-NLS-1$

	/** icon for a package */
	public static final String ICON_PACKAGE = "/icons/Package.gif"; //$NON-NLS-1$

	/** icon for a string */
	public static final String ICON_STRING = "icons/obj16/LiteralString.gif"; //$NON-NLS-1$

	/** icon for a compartment */
	public static final String ICON_COMPARTMENT = "/icons/none_comp_vis.gif"; //$NON-NLS-1$

	/** String used when the name of an element was not found */
	public static final String NO_NAME = Messages.ShowHideCompartmentAction_No_Name;

	/** the transactional editing domain */
	protected TransactionalEditingDomain domain;

	/** the list of the views to destroy */
	protected List<View> viewsToDestroy;

	/** the list of the view to create */
	protected List<View> viewsToCreate;

	/** the selected elements */
	protected List<EditPart> selectedElements;

	/** the list of the representation for the {@link #selectedElements} */
	protected List<EditPartRepresentation> representations;

	/** the initial selection */
	protected List<Element> initialSelection;


	/**
	 * 
	 * @see org.eclipse.ui.IWorkbenchWindowActionDelegate#init(org.eclipse.ui.IWorkbenchWindow)
	 * 
	 * @param window
	 */
	public void init(IWorkbenchWindow window) {

	}

	//
	/**
	 * 
	 * @see org.eclipse.ui.IWorkbenchWindowActionDelegate#dispose()
	 * 
	 */
	public void dispose() {
		
	}

	/**
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 * 
	 * @param action
	 */

	public void run(IAction action) {
		initAction();
		CheckedTreeSelectionDialog selectionDialog = new CheckedTreeSelectionDialog(DisplayUtils.getDisplay().getActiveShell(), new EditorLabelProvider(), new ContentProvider());
		selectionDialog.setTitle(Messages.ShowHideCompartmentAction_Title);
		selectionDialog.setMessage(Messages.ShowHideCompartmentAction_Message);
		selectionDialog.setContainerMode(true);
		selectionDialog.setInput(getInput());
		selectionDialog.setExpandedElements(getInput().toArray());
		selectionDialog.setInitialElementSelections(this.initialSelection);
		selectionDialog.open();

		if(selectionDialog.getReturnCode() == Dialog.OK) {
			Object[] results = selectionDialog.getResult();

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
					viewsToCreate.add((View)node);
				}
			}


			//we are looking for the view to destroy
			for(Object current : this.initialSelection) {
				if(!result.contains(current)) {
					viewsToDestroy.add((View)current);
				}
			}

			final Command command = getActionCommand();
			final TransactionalEditingDomain theDomain = domain;
			if(command.canExecute()) {
				try {
					domain.runExclusive(new Runnable() {

						public void run() {
							PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {

								//executing the command
								public void run() {
									theDomain.getCommandStack().execute(new GEFtoEMFCommandWrapper(command));
								}
							});
						}
					});
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
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

	protected void initAction() {
		//set all fields to their default value
		this.viewsToCreate = new ArrayList<View>();
		this.viewsToDestroy = new ArrayList<View>();
		this.representations = new ArrayList<ShowHideCompartmentAction.EditPartRepresentation>();

		this.domain = ((IGraphicalEditPart)this.selectedElements.get(0)).getEditingDomain();
		for(EditPart current : this.selectedElements) {
			EditPartRepresentation rep = new EditPartRepresentation(current);
			representations.add(rep);
		}
		this.initialSelection = getInitialSelection();
	}

	/**
	 * Returns the input for the TreeDialog
	 * 
	 * @return
	 *         the input for the TreeDialog
	 */
	protected List getInput() {
		List<Object> input = new ArrayList<Object>();
		for(EditPartRepresentation current : representations) {
			input.add(current.getSemanticElement());
		}
		return input;
	}

	/**
	 * Returns the command to execute to show/hide the selected compartments
	 * 
	 * @return
	 *         the command to execute to show/hide the selected compartments
	 */

	protected Command getActionCommand() {
		/* for further information, see bug 302555 */
		ViewServiceUtil.forceLoad();

		ShowHideCompartmentRequest req = null;
		CompoundCommand completeCmd = new CompoundCommand("Destroy and Create Compartment Command"); //$NON-NLS-1$

		//the commands to hide compartment
		for(View current : this.viewsToDestroy) {
			EditPartRepresentation rep = findRepresentation(current.getElement(), representations);
			if(rep != null) {
				EditPart ep = rep.getRepresentedEditPart();
				req = new ShowHideCompartmentRequest(ShowHideCompartmentRequest.HIDE, current.getType());
				req.setType(ShowHideCompartmentRequest.SHOW_HIDE_COMPARTMENT);
				Command tmp = ep.getCommand(req);
				if(tmp != null && tmp.canExecute()) {
					completeCmd.add(tmp);
				}

			}
		}

		//the command to show compartment
		for(View current : this.viewsToCreate) {
			EditPartRepresentation rep = findRepresentation(current.getElement(), representations);
			if(rep != null) {
				EditPart ep = rep.getRepresentedEditPart();
				req = new ShowHideCompartmentRequest(ShowHideCompartmentRequest.SHOW, current.getType());
				req.setType(ShowHideCompartmentRequest.SHOW_HIDE_COMPARTMENT);
				Command tmp = ep.getCommand(req);
				if(tmp != null && tmp.canExecute()) {
					completeCmd.add(tmp);
				}
			}
		}

		return completeCmd;
	}


	/**
	 * Returns the initial selection for the Tree Dialog.
	 * 
	 * @return
	 *         The initial selection for the Tree Dialog
	 */
	protected List<Element> getInitialSelection() {
		List<Element> initialSelection2 = new ArrayList<Element>();

		for(EditPartRepresentation current : this.representations) {
			initialSelection2.addAll(current.getInitialSelection());
		}

		return initialSelection2;
	}

	/**
	 * 
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
	 * 
	 * @param action
	 * @param selection
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		//		if(this.action == null) {
		//			this.action = action;
		//		}

		boolean enable = false;
		selectedElements = new ArrayList<EditPart>();
		if(selection instanceof StructuredSelection) {
			selectedElements = ((StructuredSelection)selection).toList();
			for(Object current : this.selectedElements) {
				if(current instanceof EditPart) {
					EditPolicy policy = ((EditPart)current).getEditPolicy(ShowHideCompartmentEditPolicy.SHOW_HIDE_COMPARTMENT_POLICY);
					if(policy != null) {
						enable = true;
						break;
					}
				}
			}
		}


		action.setEnabled(enable);
	}

	/**
	 * 
	 * @param element
	 *        an element
	 * @param representationList
	 *        a list of {@link EditPartRepresentation}
	 * @return
	 *         <ul>
	 *         <li>the {@link EditPartRepresentation}</li> owning the element, if it's found
	 *         <li> <code>null</code> if not</li>
	 *         </ul>
	 */
	protected EditPartRepresentation findRepresentation(Object element, List<EditPartRepresentation> representationList) {
		for(EditPartRepresentation current : representationList) {
			if(current.getSemanticElement() == element) {
				return current;
			} else if(current.getAllPossibleCompartment().contains(element)) {
				return current;

			}
		}
		return null;
	}



	/**
	 * 
	 * Provide the label for the selected element
	 * 
	 */
	protected class EditorLabelProvider implements ILabelProvider {


		/**
		 * 
		 * Constructor.
		 * 
		 */
		public EditorLabelProvider() {

		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
		 * 
		 * @param listener
		 */
		public void addListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
		 * 
		 */
		public void dispose() {
			// TODO Auto-generated method stub
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
		 * 
		 * @param element
		 * @param property
		 * @return
		 */
		public boolean isLabelProperty(Object element, String property) {
			// TODO Auto-generated method stub
			return false;
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
		 * 
		 * @param listener
		 */
		public void removeListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub
		}

		/**
		 * Return the corresponding image for the element
		 * 
		 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
		 * 
		 * @param element
		 * @return
		 */
		public Image getImage(Object element) {
			if(element instanceof Class) {
				if(org.eclipse.papyrus.diagram.common.util.Util.isMetaclass((Type)element)) {
					return Activator.getPluginIconImage(Activator.ID, ICON_METACLASS);
				} else {
					return Activator.getPluginIconImage(Activator.ID, ICON_CLASS);
				}
			} else if(element instanceof DataType) {
				return Activator.getPluginIconImage(Activator.ID, ICON_DATATYPE);
			} else if(element instanceof Stereotype) {
				return Activator.getPluginIconImage(Activator.ID, ICON_STEREOTYPE);
			} else if(element instanceof Profile) {
				return Activator.getPluginIconImage(Activator.ID, ICON_PROFILE);
			} else if(element instanceof Model) {
				return Activator.getPluginIconImage(Activator.ID, ICON_MODEL);
			} else if(element instanceof Package) {
				return Activator.getPluginIconImage(Activator.ID, ICON_PACKAGE);
			} else if(element instanceof View) {
				return Activator.getPluginIconImage(Activator.ID, ICON_COMPARTMENT);
			}
			return null;
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
		 * 
		 * @param element
		 * @return
		 *         the name of the element or
		 */
		public String getText(Object element) {
			if(element instanceof NamedElement) {
				return ((NamedElement)element).getName();
			} else if(element instanceof View) {
				EditPartRepresentation rep = findRepresentation(element, representations);
				if(rep != null) {
					String name = rep.getName(element);
					if(name != null) {
						return name;
					}
				}
			}
			return NO_NAME;
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
				List returnedValues = new ArrayList();
				for(Object obj : (List)inputElement) {
					if(obj instanceof Element) {
						returnedValues.add(obj);
					}
				}
				return returnedValues.toArray();
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
			EditPartRepresentation rep = findRepresentation(parentElement, representations);
			if(rep != null) {
				if(!rep.getAllPossibleCompartment().isEmpty()) {
					return rep.getAllPossibleCompartment().toArray();
				}
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
			} else { //it's a basicCompartment
				for(EditPartRepresentation rep : representations) {
					List init = rep.getInitialSelection();
					if(init.contains(element)) {
						//return rep;
						return rep.getSemanticElement();
					}
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
			if(element instanceof Element) {
				EditPartRepresentation rep = findRepresentation(element, representations);
				if(rep != null) {
					if(!rep.getAllPossibleCompartment().isEmpty()) {
						return true;
					}
				}
			}
			return false;
		}

	}



	/**
	 * 
	 * This class provides some facilities to build this action.
	 * 
	 */
	protected class EditPartRepresentation {

		/** the editpart represented by this class */
		protected EditPart ep = null;

		/** the initial compartment visible for this editpart, represented by their Visual ID */
		protected List<String> initialCompartments = new ArrayList<String>();

		/** the possible compartment */
		protected EList<View> possibleCompartments = null;

		/** the initial selection */
		protected List<View> initialSelection = new ArrayList<View>();

		/**
		 * 
		 * Constructor.
		 * 
		 * @param editpart
		 */
		public EditPartRepresentation(EditPart editpart) {
			this.ep = editpart;
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
			List localChildren = ep.getChildren();

			//fill this.initialCompartments
			for(Object current : localChildren) {
				if(current instanceof CompartmentEditPart) {
					initialCompartments.add(((View)((CompartmentEditPart)current).getModel()).getType());
				}
			}

			//fill this.possibleCompartments
			this.possibleCompartments = ((GraphicalEditPart)ep).getNotationView().getChildren();

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
					IFigure fig1 = epp.getFigure();
					if(fig1 instanceof ResizableCompartmentFigure) {
						name = ((ResizableCompartmentFigure)fig1).getCompartmentTitle();
					}
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
		public List getInitialSelection() {
			return this.initialSelection;
		}

		/**
		 * Returns the semantic element represented by {@link #ep}
		 * 
		 * @return
		 *         the semantic element represented by {@link #ep}
		 */
		public Element getSemanticElement() {
			return (Element)((View)ep.getModel()).getElement();
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
		 * Getter for {@link #ep}
		 * 
		 * @return
		 *         the represented editpart, {@link #ep}
		 */
		public EditPart getRepresentedEditPart() {
			return this.ep;
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
			List chilrenEP = this.ep.getChildren();
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
}
