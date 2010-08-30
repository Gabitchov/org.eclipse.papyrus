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
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
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
import org.eclipse.papyrus.diagram.common.util.Util;
import org.eclipse.papyrus.wizards.Activator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.dialogs.CheckedTreeSelectionDialog;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Type;

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

	/** increment for the location of the elements to show(ports and properties) */
	private int increment = 10;

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public ShowHideContentsAction() {
		this(Messages.ShowHideContentsAction_Title, Messages.ShowHideContentsAction_Message, ShowHideClassifierContentsEditPolicy.SHOW_HIDE_CLASSIFIER_CONTENTS_POLICY);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param title
	 *        title for the dialog
	 * @param message
	 *        message for the dialog
	 * @param editPolicyKey
	 *        EditPolicy used for this action
	 */
	public ShowHideContentsAction(String title, String message, String editPolicyKey) {
		super(title, message, editPolicyKey);
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
				this.representations.add(new CustomEditPartRepresentation(current, (Classifier)((View)current.getModel()).getElement()));
			}
		}
		this.setEditorLabelProvider(new CustomEditorLabelProvider());
		this.setContentProvider(new ContentProvider());
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
	 * 
	 * @see org.eclipse.papyrus.diagram.common.actions.AbstractShowHideAction#getActionCommand()
	 * 
	 * @return
	 */
	@Override
	protected Command getActionCommand() {

		ShowHideElementsRequest req = null;
		CompoundCommand completeCmd = new CompoundCommand("Show/Hide Inherited Elements Command"); //$NON-NLS-1$

		/*
		 * the command to hide elements
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
		Point propertyLocation = new Point();
		Point portLocation = new Point(0, -2 * increment + 1);
		for(Object current : this.viewsToCreate) {
			EditPartRepresentation rep = findEditPartRepresentation(current);
			if(rep == null) {
				continue;
			}
			EditPart ep = findEditPartRepresentation(current).getRepresentedEditPart();
			if(ep != null) {
				View compartment = getCompartmentForCreation(ep, (EObject)current);
				if(compartment != null) {
					req = new ShowHideElementsRequest(compartment, (EObject)current);
					if(isXYLayout(compartment, ep)) {
						propertyLocation.x += increment;
						propertyLocation.y += increment;
						req.setLocation(new Point(propertyLocation));

					} else if(isAffixedChildNode(ep, (EObject)current)) {
						portLocation.y += increment;
						req.setLocation(new Point(portLocation));
					}
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
	 * Test if the child is represented by an affixed child node
	 * TODO
	 * This method will not work if we have an UML element E1 which inherits from another element E2 and if E2 is represented by an affixed child node
	 * and not E1!
	 * 
	 * @param ep
	 *        the parent EditPart
	 * @param child
	 *        the child to show
	 * @return
	 *         <ul>
	 *         <li><code>true</code> if child is represented by an affixed child node</li>
	 *         <li> <code>false</code> if not</li>
	 *         </ul>
	 */
	protected boolean isAffixedChildNode(EditPart ep, EObject child) {
		TransactionalEditingDomain domain = ((IGraphicalEditPart)ep).getEditingDomain();
		ViewDescriptor viewDescriptor = new ViewDescriptor(new EObjectAdapter(child), Node.class, null, ViewUtil.APPEND, false, ((IGraphicalEditPart)ep).getDiagramPreferencesHint());
		CreateCommand cmd = new CreateCommand(domain, viewDescriptor, (View)ep.getModel());
		if(cmd.canExecute()) {
			/*
			 * the EditPart can own the child -> it's maybe an affixed child node
			 */
			return true;
		}
		return false;
	}


	/**
	 * Test if the layout for this compartment is a XYLayout
	 * 
	 * @param compartment
	 *        the compartment to test
	 * @param ep
	 *        the editpart owning this compartment
	 * @return
	 *         <ul>
	 *         <li><code>true</code> if the layout for this compartment is a XYLayout</li>
	 *         <li> <code>false</code> if not</li>
	 *         </ul>
	 */
	protected boolean isXYLayout(View compartment, EditPart ep) {
		List<?> children = ep.getChildren();
		for(Object current : children) {
			if(current instanceof EditPart) {
				if(((EditPart)current).getModel() == compartment) {
					EditPolicy editpolicy = ((EditPart)current).getEditPolicy(XYLayoutEditPolicy.LAYOUT_ROLE);
					if(editpolicy != null) {
						return true;
					}
				}
			}
		}
		return false;
	}


	/**
	 * Return the EditParts owned by this EditPart.
	 * When the owned EditPart is a CompartmentEditPart, we return its containing EditPart
	 * 
	 * 
	 * @param ep
	 *        an editpart
	 * @return
	 *         The EditParts owned by this EditPart.
	 *         When the owned EditPart is a CompartmentEditPart, we return its containing EditPart
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
	 * Return the compartment which allows the creation of the EObject
	 * 
	 * @param editPart
	 *        an editpart
	 * @param child
	 *        an object to create
	 * @return
	 *         the compartment which allows the creation of this EObject or <code>null</code>
	 */
	protected View getCompartmentForCreation(EditPart editPart, EObject child) {
		if(isAffixedChildNode(editPart, child)) {
			return (View)editPart.getModel();
		}
		TransactionalEditingDomain domain = ((IGraphicalEditPart)editPart).getEditingDomain();
		ViewDescriptor viewDescriptor = new ViewDescriptor(new EObjectAdapter(child), Node.class, null, ViewUtil.APPEND, false, ((IGraphicalEditPart)editPart).getDiagramPreferencesHint());

		List<View> visibleCompartments = ((IGraphicalEditPart)editPart).getNotationView().getVisibleChildren();
		for(View currentComp : visibleCompartments) {
			CreateCommand cmd = new CreateCommand(domain, viewDescriptor, currentComp);
			if(cmd.canExecute()) {
				return currentComp;
			}
		}
		return null;
	}

	/**
	 * Return the EditPart owning the Object or <code>null</code>
	 * 
	 * @param obj
	 * @return
	 *         the EditPart owning the Object or <code>null</code>
	 */
	protected EditPart findEditPart(Object obj) {
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

	/**
	 * Fill the following fields :
	 * <ul>
	 * <li> {@link AbstractShowHideAction#viewsToDestroy}</li>
	 * <li> {@link AbstractShowHideAction#viewsToCreate}</li>
	 * </ul>
	 * 
	 * @see org.eclipse.papyrus.diagram.common.actions.AbstractShowHideAction#buildShowHideElementsList(java.lang.Object[])
	 * 
	 * @param results
	 */
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

		//we are looking for the objects to show
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
	 * Return the editpart representation owning the element
	 * 
	 * @param element
	 *        the element which we are looking for
	 * @return
	 *         the editpart representation owning the element
	 */
	protected EditPartRepresentation findEditPartRepresentation(Object element) {
		for(EditPartRepresentation current : representations) {
			if(current.getPossibleElement().contains(element)) {
				return current;
			} else {
				EList<?> views = ((IGraphicalEditPart)current.getRepresentedEditPart()).getNotationView().getChildren();
				if(views.contains(element)) {
					return current;
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * EditorLabelProvider for the {@link CheckedTreeSelectionDialog}
	 * 
	 */
	public class CustomEditorLabelProvider extends EditorLabelProvider {

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
				element = ((EditPartRepresentation)element).getUMLElement();
			} else if(element instanceof ClassifierRepresentation) {
				element = ((ClassifierRepresentation)element).getRepresentedClassifier();
			}
			return super.getText(element);

		}


	}

	public class CustomComparator implements Comparator<Object> {

		/** this list contains the name of all the classes which want sort */
		private List<String> classesList;

		/**
		 * 
		 * Constructor.
		 * 
		 * @param members
		 *        the elements to sort
		 */
		public CustomComparator(List<NamedElement> elements) {
			buildList(elements);
		}

		/**
		 * Fill {@link #classesList} with the class name of each element to sort
		 * 
		 * @param elements
		 *        the elements to sort
		 */
		public void buildList(List<NamedElement> elements) {
			this.classesList = new ArrayList<String>();
			for(NamedElement namedElement : elements) {
				this.classesList.add(new String(namedElement.getClass().getSimpleName()));
			}
			Collections.sort(classesList);
		}

		/**
		 * 
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 * 
		 * @param o1
		 * @param o2
		 * @return
		 */
		public int compare(Object o1, Object o2) {

			String name1 = o1.getClass().getSimpleName();
			String name2 = o2.getClass().getSimpleName();
			int index1 = classesList.indexOf(name1);
			int index2 = classesList.indexOf(name2);
			int classIndex = classesList.indexOf("ClassImpl"); //$NON-NLS-1$
			if(index1 == index2 && index1 == classIndex) {
				boolean metaclassO1 = Util.isMetaclass((Type)o1);
				boolean metaclassO2 = Util.isMetaclass((Type)o2);
				if(metaclassO1 && !metaclassO2) {
					return 1;
				} else if(!metaclassO1 && metaclassO2) {
					return -1;
				}
				return 0;
			}
			if(index1 == -1) {
				Activator.log.debug("The class " + name1 + " is unknown by " + this.getClass());//$NON-NLS-1$ //$NON-NLS-2$
				return -1;
			} else if(index1 == index2) {
				return 0;
			} else if(index1 > index2) {
				return 1;
			} else if(index1 < index2) {
				return -1;
			}
			return 0;
		}


	}

	/**
	 * 
	 * Content provider for the {@link CheckedTreeSelectionDialog}
	 * 
	 */
	public class ContentProvider implements ITreeContentProvider {

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
			List<NamedElement> members = new ArrayList<NamedElement>();
			EList<NamedElement> localMembers = null;
			if(parentElement instanceof EditPartRepresentation) {
				EObject myClassifier = ((EditPartRepresentation)parentElement).getUMLElement();
				if(myClassifier instanceof Classifier) {
					localMembers = ((Classifier)myClassifier).getOwnedMembers();
					for(NamedElement namedElement : localMembers) {
						if(((EditPartRepresentation)parentElement).getPossibleElement().contains(namedElement)) {
							members.add(namedElement);
						}
					}
				}
			} else if(parentElement instanceof ClassifierRepresentation) {
				localMembers = ((ClassifierRepresentation)parentElement).getRepresentedClassifier().getMembers();
				for(NamedElement namedElement : localMembers) {
					if(((ClassifierRepresentation)parentElement).getEditPartRepresentation().getPossibleElement().contains(namedElement)) {
						members.add(namedElement);
					}
				}
			}
			Collections.sort(members, new CustomComparator(members));
			return members.toArray();

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
				if(rep != null) {

					Classifier classifier = (Classifier)((EditPartRepresentation)element).getUMLElement();
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
		 * @param classifier
		 */
		public CustomEditPartRepresentation(EditPart representedEditPart, Classifier classifier) {
			super(representedEditPart, classifier);
		}

		/**
		 * 
		 * @see org.eclipse.papyrus.diagram.common.actions.AbstractShowHideAction.EditPartRepresentation#initRepresentation()
		 * 
		 */
		@Override
		protected void initRepresentation() {
			super.initRepresentation();
			this.superClasses = new ArrayList<ShowHideContentsAction.ClassifierRepresentation>();
			if(this.UMLElement instanceof Classifier) {
				EList<Classifier> parents = ((Classifier)UMLElement).allParents();
				for(Classifier classifier : parents) {
					superClasses.add(new ClassifierRepresentation(classifier, this));
				}


				/*
				 * build the list of the elements to select
				 * we suggest only the elements which can be displayed in the shown compartments
				 */
				this.elementsToSelect = new ArrayList<Object>();
				EList<NamedElement> members = ((Classifier)UMLElement).getMembers();
				for(NamedElement namedElement : members) {
					View compartment = getCompartmentForCreation(this.representedEditPart, namedElement);
					if(compartment != null) {
						this.elementsToSelect.add(namedElement);

						//build the initial selection
						EList<?> childrenView = compartment.getVisibleChildren();
						for(Object object : childrenView) {
							if(object instanceof View) {
								if(((View)object).getElement() == namedElement) {
									this.initialSelection.add(namedElement);
									break;
								}
							}
						}
					}
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
	 * This class is used to do easily the difference between the nested classifiers and the superclass of the selected class in the Tree
	 * The superclass are represented with this class
	 */
	protected class ClassifierRepresentation {

		/** the represented classifier */
		protected Classifier representedClassifier;

		/** the CustomEditPartRepresentation owning this classifier */
		protected EditPartRepresentation rep;

		/**
		 * 
		 * Constructor.
		 * 
		 * @param representedClassifier
		 *        the represented classifier
		 */
		public ClassifierRepresentation(Classifier representedClassifier, CustomEditPartRepresentation rep) {
			this.representedClassifier = representedClassifier;
			this.rep = rep;
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

		/**
		 * Getter for {@link #rep}
		 * 
		 * @return
		 *         {@link #rep}
		 */
		public EditPartRepresentation getEditPartRepresentation() {
			return this.rep;
		}

	}
}
