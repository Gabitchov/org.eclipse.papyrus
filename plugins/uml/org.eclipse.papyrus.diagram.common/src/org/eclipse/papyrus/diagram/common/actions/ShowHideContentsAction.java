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
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.BasicCompartment;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.diagram.common.Messages;
import org.eclipse.papyrus.diagram.common.commands.ShowHideElementsRequest;
import org.eclipse.papyrus.diagram.common.editpolicies.ShowHideClassifierContentsEditPolicy;
import org.eclipse.papyrus.diagram.common.providers.EditorLabelProvider;
import org.eclipse.papyrus.diagram.common.util.ViewServiceUtil;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.dialogs.CheckedTreeSelectionDialog;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.NamedElement;

/**
 * 
 * This class provides an action to show/hide the owned members and the inherited members for a Classifier
 * 
 */
public class ShowHideContentsAction extends AbstractShowHideAction implements IActionDelegate, IWorkbenchWindowActionDelegate {

	/** title for the dialog */
	private final static String title = Messages.ShowHideContentsAction_Title;

	/** title for the message */
	private final static String message = Messages.ShowHideContentsAction_Message;

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public ShowHideContentsAction() {
		super(title, message, ShowHideClassifierContentsEditPolicy.SHOW_HIDE_CLASSIFIER_CONTENTS_POLICY);
	}


	/**
	 * 
	 * @see org.eclipse.ui.IWorkbenchWindowActionDelegate#dispose()
	 * 
	 */
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}

	/**
	 * 
	 * @see org.eclipse.ui.IWorkbenchWindowActionDelegate#init(org.eclipse.ui.IWorkbenchWindow)
	 * 
	 * @param window
	 */
	@Override
	public void init(IWorkbenchWindow window) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 * 
	 * @param action
	 */
	@Override
	public void run(IAction action) {
		super.run(action);
	}

	/**
	 * We can use the show/hide contents action, only if there 1 selected object
	 * 
	 * @see org.eclipse.papyrus.diagram.common.actions.AbstractShowHideAction#selectionChanged(org.eclipse.jface.action.IAction,
	 *      org.eclipse.jface.viewers.ISelection)
	 * 
	 * @param action
	 *        the current action
	 * @param selection
	 *        the current selection
	 */
	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		if(selection instanceof StructuredSelection) {
			if(((StructuredSelection)selection).size() > 1) {
				action.setEnabled(false);
				return;
			}
		}
		super.selectionChanged(action, selection);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.common.actions.AbstractShowHideAction#initAction()
	 * 
	 */
	@Override
	protected void initAction() {
		super.initAction();
		for(EditPart current : this.selectedElements) {
			//the selected elements which aren't Classifier are ignored
			if(((View)current.getModel()).getElement() instanceof Classifier) {
				this.representations.add(new CustomEditPartRepresentation(current));
			}
		}
		this.setEditorLabelProvider(new CustomEditorLabelProvider());
		this.setContentProvider(new ContentProvider());
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.common.actions.AbstractShowHideAction#getActionCommand()
	 * 
	 * @return
	 */
	@Override
	protected Command getActionCommand() {
		/* for further information, see bug 302555 */
		ViewServiceUtil.forceLoad();

		ShowHideElementsRequest req = null;
		CompoundCommand completeCmd = new CompoundCommand("Show/Hide Inherited Elements Command"); //$NON-NLS-1$

		/*
		 * the command to hide element
		 * we need the corresponding editpart
		 */
		for(Object current : this.viewsToDestroy) {
			EditPart ep = findEditPart(current);
			if(ep != null) {
				req = new ShowHideElementsRequest(ep);
				EditPart parent = ep.getParent();
				if(parent instanceof CompartmentEditPart) {
					parent = parent.getParent();
				}
				Command cmd = parent.getCommand(req);
				if(cmd != null && cmd.canExecute()) {
					completeCmd.add(cmd);
				}
			}
		}

		//the command to show element
		for(Object current : this.viewsToCreate) {
			EditPartRepresentation rep = findEditPartRepresentation(current);
			if(rep == null) {
				continue;
			}
			EditPart ep = findEditPartRepresentation(current).getRepresentedEditPart();
			if(ep != null) {
				BasicCompartment compartment = getCompartmentToCreate(ep, (EObject)current);
				if(compartment != null && ep != null) {
					req = new ShowHideElementsRequest(compartment, (EObject)current);
					Command cmd = ep.getCommand(req);

					if(cmd != null && cmd.canExecute()) {
						completeCmd.add(cmd);
					}
				}
			}

		}
		return completeCmd;
	}

	/**
	 * 
	 * @param ep
	 *        an editpart
	 * @return
	 *         the EditParts owned by this EditParts.
	 *         When the owned EditPart are CompartmentEditPart, we return their contents
	 */
	protected List<EditPart> getChildrenEditPart(EditPart ep) {
		List<EditPart> children = new ArrayList<EditPart>();
		List<?> tmp = ep.getChildren();
		for(Object current : tmp) {
			//we don't want the compartment used for the name
			if(current instanceof ITextAwareEditPart) {
				continue;
				//if it's a compartment, we want it's children
			} else if(current instanceof CompartmentEditPart) {
				children.addAll(((CompartmentEditPart)current).getChildren());
				//it's an affixed child node?!
			} else {
				children.add((EditPart)current);
			}
		}

		return children;
	}

	/**
	 * Return the compartment which allows the creation of this object
	 * 
	 * @param editPart
	 *        an editpart
	 * @param child
	 *        an object to create
	 * @return
	 *         the compartment which allows the creation of this object
	 */
	protected BasicCompartment getCompartmentToCreate(EditPart editPart, EObject child) {
		TransactionalEditingDomain domain = ((IGraphicalEditPart)editPart).getEditingDomain();
		ViewDescriptor viewDescriptor = new ViewDescriptor(new EObjectAdapter(child), Node.class, null, ViewUtil.APPEND, false, ((IGraphicalEditPart)editPart).getDiagramPreferencesHint());
		List<BasicCompartment> visibleCompartments = getVisibleCompartment(editPart);
		for(BasicCompartment currentComp : visibleCompartments) {
			CreateCommand cmd = new CreateCommand(domain, viewDescriptor, currentComp);
			if(cmd.canExecute()) {
				return currentComp;
			}
		}
		return null;
	}


	private EditPart findEditPart(Object obj) {
		EditPart ep = null;
		Iterator<EditPartRepresentation> it = representations.iterator();
		while(ep == null && it.hasNext()) {
			List<EditPart> children = getChildrenEditPart(it.next().getRepresentedEditPart());
			for(EditPart editPart : children) {
				if(((View)editPart.getModel()).getElement() == obj) {
					return editPart;
				}
			}
		}
		return null;
	}

	@Override
	protected void buildShowHideElementsList(Object[] results) {
		super.buildShowHideElementsList(results);
		List<Object> result = new ArrayList<Object>();

		//we remove the EditPartRepresentation from the result
		for(int i = 0; i < results.length; i++) {
			if((results[i] instanceof EditPartRepresentation) || (results[i] instanceof ClassifierRepresentation)) {
				continue;
			} else {
				result.add(results[i]);
			}
		}

		//we are looking for the object to show
		for(Object element : result) {
			if(initialSelection.contains(element)) {
				//we do nothing
				continue;
			} else {
				viewsToCreate.add(element);
			}
		}


		//we are looking for the view to destroy
		for(Object current : this.initialSelection) {
			if(!result.contains(current)) {
				viewsToDestroy.add(current);
			}
		}
	}

	/**
	 * 
	 * @param ep
	 * @return
	 */
	protected List<Object> getSemanticChildren(EditPart ep) {
		List<EditPart> childrenEP = new ArrayList<EditPart>();
		List<Object> semanticChildren = new ArrayList<Object>();
		List<?> tmp = ep.getChildren();
		for(Object current : tmp) {
			//we don't want the compartment used for the name
			if(current instanceof ITextAwareEditPart) {
				continue;
				//if it's a compartment, we want it's children
			} else if(current instanceof CompartmentEditPart) {
				childrenEP.addAll(((CompartmentEditPart)current).getChildren());
				//it's an affixed child node?!
			} else {
				childrenEP.add((EditPart)current);
			}
		}
		Iterator<EditPart> it = childrenEP.iterator();
		while(it.hasNext()) {
			semanticChildren.add(((View)it.next().getModel()).getElement());
		}

		return semanticChildren;
	}




	/**
	 * Return the list containing the elements which can effectively be displayed
	 * 
	 * @param possibleChildren
	 *        a list containing elements which could be displayed
	 * @param editpart
	 *        the editpart which owns the possibleChildren
	 * @return
	 *         the list containing the elements which can effectively be displayed
	 */
	public List<Object> getPossibleChildren(List<Object> possibleChildren, EditPart editpart) {
		ViewServiceUtil.forceLoad();
		List<Object> children = new ArrayList<Object>();
		List<BasicCompartment> visibleCompartments = getVisibleCompartment(editpart);
		TransactionalEditingDomain domain = ((IGraphicalEditPart)editpart).getEditingDomain();

		//we test each semantic children to know if we can draw it on the diagram
		for(Object child : possibleChildren) {
			ViewDescriptor viewDescriptor = new ViewDescriptor(new EObjectAdapter((EObject)child), Node.class, null, ViewUtil.APPEND, false, ((IGraphicalEditPart)editpart).getDiagramPreferencesHint());
			for(BasicCompartment currentComp : visibleCompartments) {
				CreateCommand cmd = new CreateCommand(domain, viewDescriptor, currentComp);
				if(cmd.canExecute()) {
					children.add(child);
					break;
				}
			}
		}
		return children;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.common.actions.AbstractShowHideAction#getInput()
	 * 
	 * @return
	 */
	@Override
	protected List<Object> getInput() {
		List<Object> list = new ArrayList<Object>();
		list.addAll(representations);
		for(EditPartRepresentation current : representations) {
			list.addAll(((CustomEditPartRepresentation)current).getSuperClasses());
		}


		return list;
	}


	/**
	 * Return the visible compartments for this EditParts
	 * 
	 * @param ep
	 *        an EditPart
	 * @return
	 *         the visible compartments for this EditPart
	 */
	public List<BasicCompartment> getVisibleCompartment(EditPart ep) {
		List<BasicCompartment> visibleCompartments = new ArrayList<BasicCompartment>();
		for(Object current : ep.getChildren()) {
			if(current instanceof CompartmentEditPart && !(current instanceof ITextAwareEditPart)) {
				visibleCompartments.add((BasicCompartment)((EditPart)current).getModel());
			}
		}
		return visibleCompartments;
	}

	/**
	 * Return a list containing the semantic element owned by the EditPart
	 * 
	 * @param representedEditPart
	 * @return
	 *         a list containing the semantic element owned by the EditPart
	 */
	public List<Object> getAllSemanticChildren(EditPart editpart) {
		List<Object> semanticChildren = new ArrayList<Object>();
		EObject eobject = ((View)editpart.getModel()).getElement();
		if(eobject instanceof Classifier) {
			EList<NamedElement> members = ((Classifier)eobject).getMembers();
			Iterator<?> it = members.iterator();
			while(it.hasNext()) {
				semanticChildren.add(it.next());
			}
		}
		return semanticChildren;
	}

	/**
	 * Return the editpart represention owning the element
	 * 
	 * @param element
	 *        the element which we are looking for
	 * @return
	 *         the editpart represention owning the element
	 */
	protected EditPartRepresentation findEditPartRepresentation(Object element) {
		for(EditPartRepresentation current : representations) {
			if(current.getPossibleElement().contains(element)) {
				return current;
			}
		}
		return null;
	}

	/**
	 * 
	 * EditorLabelProvider for the {@link CheckedTreeSelectionDialog}
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
				element = ((View)((EditPartRepresentation)element).getRepresentedEditPart().getModel()).getElement();
			} else if(element instanceof ClassifierRepresentation) {
				element = ((ClassifierRepresentation)element).getRepresentedClassifier();
			}
			return super.getImage(element);
		}

		/**
		 * 
		 * @see org.eclipse.papyrus.diagram.common.providers.EditorLabelProvider#getText(java.lang.Object)
		 * 
		 * @param element
		 * @return
		 */
		@Override
		public String getText(Object element) {
			if(element instanceof EditPartRepresentation) {
				element = ((View)((EditPartRepresentation)element).getRepresentedEditPart().getModel()).getElement();
			} else if(element instanceof ClassifierRepresentation) {
				element = ((ClassifierRepresentation)element).getRepresentedClassifier();
			}
			return super.getText(element);

		}


	}

	/**
	 * 
	 * Content provider for the {@link CheckedTreeSelectionDialog}
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
			EList<NamedElement> members = null;
			if(parentElement instanceof EditPartRepresentation) {
				EObject myClassifier = ((View)((EditPartRepresentation)parentElement).getRepresentedEditPart().getModel()).getElement();
				if(myClassifier instanceof Classifier) {
					members = ((Classifier)myClassifier).getOwnedMembers();
				}
			} else if(parentElement instanceof ClassifierRepresentation) {
				members = ((ClassifierRepresentation)parentElement).getRepresentedClassifier().getOwnedMembers();
			}
			return (members == null) ? null : members.toArray();

		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
		 * 
		 * @param element
		 * @return
		 */
		public Object getParent(Object element) {
			if(!(element instanceof EditPartRepresentation)) {
				EditPartRepresentation rep = findEditPartRepresentation(element);
				Classifier classifier = (Classifier)((View)rep.getRepresentedEditPart().getModel()).getElement();
				if(classifier.getOwnedMembers().contains(element)) {
					return rep;
				} else {
					for(ClassifierRepresentation classRep : ((CustomEditPartRepresentation)rep).getSuperClasses()) {
						if(classRep.ownsElement(element)) {
							return classRep;
						}
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
			if(getChildren(element) != null && getChildren(element).length > 0) {
				return true;
			}
			return false;
		}

	}

	/**
	 * 
	 * The custom EditPartRepresentation for this action
	 * 
	 */
	protected class CustomEditPartRepresentation extends EditPartRepresentation {

		/** this list contains the representation of all classifier which are superclass of the classifier represented by EditPartRepresentaiton */
		protected List<ClassifierRepresentation> superClasses;

		/**
		 * 
		 * Constructor.
		 * 
		 * @param representedEditPart
		 */
		public CustomEditPartRepresentation(EditPart representedEditPart) {
			super(representedEditPart);
		}

		/**
		 * 
		 * @see org.eclipse.papyrus.diagram.common.actions.AbstractShowHideAction.EditPartRepresentation#initRepresentation()
		 * 
		 */
		@Override
		protected void initRepresentation() {
			super.initRepresentation();
			this.initialSelection.addAll(getSemanticChildren(this.representedEditPart));
			List<Object> possibleChildren = getAllSemanticChildren(this.representedEditPart);

			this.possibleElement.addAll(getPossibleChildren(possibleChildren, this.representedEditPart));
			this.superClasses = new ArrayList<ShowHideContentsAction.ClassifierRepresentation>();
			EObject myClassifier = ((View)representedEditPart.getModel()).getElement();
			if(myClassifier instanceof Classifier) {
				EList<Classifier> parents = ((Classifier)myClassifier).allParents();
				for(Classifier classifier : parents) {
					superClasses.add(new ClassifierRepresentation(classifier));
				}
			}

		}

		/**
		 * 
		 * @return
		 *         a list containing the {@link ClassifierRepresentation} for each superclass of the {@link #representedEditPart}
		 */
		public List<ClassifierRepresentation> getSuperClasses() {
			return this.superClasses;
		}
	}

	/**
	 * 
	 * This class is used to do easily the difference between the nested classifiers and the mother class of the selected class in the Tree
	 * 
	 */
	protected class ClassifierRepresentation {

		/** the represented classifier */
		protected Classifier representedClassifier;

		/**
		 * 
		 * Constructor.
		 * 
		 * @param representedClassifier
		 *        the represented classifier
		 */
		public ClassifierRepresentation(Classifier representedClassifier) {
			this.representedClassifier = representedClassifier;
		}

		public boolean ownsElement(Object element) {
			if(representedClassifier.getOwnedMembers().contains(element)) {
				return true;
			}
			return false;
		}


		/**
		 * Getter for {@link #representedClassifier}
		 * 
		 * @return
		 *         {@link #representedClassifier}
		 */
		public Classifier getRepresentedClassifier() {
			return this.representedClassifier;
		}
	}
}
