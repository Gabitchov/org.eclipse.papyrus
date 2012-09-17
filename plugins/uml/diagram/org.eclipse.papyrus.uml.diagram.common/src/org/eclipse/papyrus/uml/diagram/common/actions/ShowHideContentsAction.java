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
package org.eclipse.papyrus.uml.diagram.common.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
import org.eclipse.gmf.runtime.diagram.ui.editparts.IResizableCompartmentEditPart;
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
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.Messages;
import org.eclipse.papyrus.uml.diagram.common.commands.ShowHideElementsRequest;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AffixedNodeAlignmentEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ShowHideClassifierContentsEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.util.CompartmentUtils;
import org.eclipse.papyrus.uml.diagram.common.util.Util;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Type;

/**
 * 
 * This class provides an action to show/hide the owned members and the
 * inherited members for a Classifier
 * 
 */
public class ShowHideContentsAction extends AbstractShowHideAction implements IActionDelegate, IWorkbenchWindowActionDelegate {

	/** INCREMENT for the location of the elements to show(ports and properties) */
	private static int INCREMENT = 10;

	/**
	 * Constructor.
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
	 * {@inheritDoc}
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
	 * {@inheritDoc}
	 */
	@Override
	protected void initAction() {
		super.initAction();
		for(IGraphicalEditPart current : this.selectedElements) {
			// the selected elements which aren't Classifier are ignored
			if(((View)current.getModel()).getElement() instanceof Classifier) {
				this.representations.add(new RootEditPartRepresentation(current, (Classifier)((View)current.getModel()).getElement()));
			}
		}
		// this.setEditorLabelProvider(new CustomEditorLabelProvider());
		this.setContentProvider(new ContentProvider());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected List<Object> getInput() {
		List<Object> list = new ArrayList<Object>();
		list.addAll(representations);
		return list;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getActionCommand() {

		ShowHideElementsRequest req = null;
		CompoundCommand completeCmd = new CompoundCommand("Show/Hide Inherited Elements Command"); //$NON-NLS-1$

		/*
		 * the command to hide elements we need the corresponding editpart
		 */
		for(EditPartRepresentation current : this.viewsToDestroy) {
			EditPart ep = current.getRepresentedEditPart(); // should not be null, because EP to destroy really exists 
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
			} else {
				Activator.log.error("the edit part for this representation " + current + " should not be null", null);
			}
		}

		// the command to show element
		Point propertyLocation = new Point();
		Point portLocation = new Point(-10, -2 * INCREMENT + 1);
		for(EditPartRepresentation rep : this.viewsToCreate) {
			if(!(rep instanceof OptionalEditPartRepresentation)) {
				continue;
			}
			EditPart ep = ((OptionalEditPartRepresentation)rep).getParentRepresentation().getParentRepresentation().getRepresentedEditPart();
			View compartmentView = ((OptionalEditPartRepresentation)rep).getParentRepresentation().getRepresentedEditPart().getNotationView();
			if(compartmentView != null) {
				req = new ShowHideElementsRequest(compartmentView, ((OptionalEditPartRepresentation)rep).getSemanticElement());
				if(isXYLayout(compartmentView, ep)) {
					propertyLocation.x += INCREMENT;
					propertyLocation.y += INCREMENT;
						req.setLocation(new Point(propertyLocation));

				} else if(isAffixedChildNode(ep, ((OptionalEditPartRepresentation)rep).getSemanticElement())) {
					portLocation.y += INCREMENT;
						req.setLocation(new Point(portLocation));
					}
					Command cmd = ep.getCommand(req);
					if(cmd != null && cmd.canExecute()) {
						completeCmd.add(cmd);
					}
			}
		}
		return completeCmd;
	}

	/**
	 * Test if the child is represented by an affixed child node
	 * TODO This method will not work if we have an UML element E1 which inherits from
	 * another element E2 and if E2 is represented by an affixed child node and
	 * not E1!
	 * 
	 * @param ep
	 *        the parent EditPart
	 * @param child
	 *        the child to show
	 * @return <ul>
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
			 * the EditPart can own the child -> it's maybe an affixed child
			 * node
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
	 * @return <ul>
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
	 * Return the EditParts owned by this EditPart. When the owned EditPart is a
	 * CompartmentEditPart, we return its containing EditPart
	 * 
	 * 
	 * @param ep
	 *        an editpart
	 * @return The EditParts owned by this EditPart. When the owned EditPart is
	 *         a CompartmentEditPart, we return its containing EditPart
	 */
	protected List<EditPart> getChildrenEditPart(EditPart ep) {
		List<EditPart> children = new ArrayList<EditPart>();
		List<?> tmp = ep.getChildren();
		for(Object current : tmp) {
			// we don't want the compartment used for the name
			if(current instanceof ITextAwareEditPart) {
				continue;
				// if it's a compartment, we want it's children
			} else if(current instanceof CompartmentEditPart) {
				children.addAll(((CompartmentEditPart)current).getChildren());
				// it's an affixed child node?!
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
	 * @return the compartment which allows the creation of this EObject or <code>null</code>
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

	//	/**
	//	 * Return the EditPart owning the Object or <code>null</code>
	//	 * 
	//	 * @param obj
	//	 * @return the EditPart owning the Object or <code>null</code>
	//	 */
	//	protected EditPart findEditPart(EditPartRepresentation obj) {
	//		EditPart ep = null;
	//		EditPart parentEditPart = obj.getParentRepresentation().getRepresentedEditPart();
	//		for(Object child : parentEditPart.getChildren()) {
	//			EditPart child = (EditPart)child;
	//		}
	//		
	//		Iterator<EditPartRepresentation> it = representations.iterator();
	//		
	//		while(ep == null && it.hasNext()) {
	//			List<EditPart> children = getChildrenEditPart(it.next().getRepresentedEditPart());
	//			for(EditPart editPart : children) {
	//				if(((View)editPart.getModel()).getElement() == obj) {
	//					return editPart;
	//				}
	//			}
	//		}
	//		return null;
	//	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void buildShowHideElementsList(Object[] results) {
		super.buildShowHideElementsList(results);

		List<Object> result = new ArrayList<Object>();

		// we remove the EditPartRepresentation from the result
		for(int i = 0; i < results.length; i++) {
			if((results[i] instanceof RootEditPartRepresentation || results[i] instanceof CompartmentEditPartRepresentation)) {
				continue;
			} else {
				result.add(results[i]);
			}
		}

		// we are looking for the objects to show
		for(Object element : result) {
			if(initialSelection.contains(element)) {
				// we do nothing
				continue;
			} else if(element instanceof EditPartRepresentation) {
				viewsToCreate.add((EditPartRepresentation)element);
			}
		}

		// we are looking for the view to destroy
		for(Object current : this.initialSelection) {
			if(!result.contains(current) && current instanceof EditPartRepresentation) {
				viewsToDestroy.add((EditPartRepresentation)current);
			}
		}
	}

	/**
	 * Return the editpart representation owning the element
	 * 
	 * @param element
	 *        the element which we are looking for
	 * @return the editpart representation owning the element
	 */
	protected EditPartRepresentation findEditPartRepresentation(Object element) {
		for(EditPartRepresentation current : representations) {
			if(current.getPossibleElement().contains(element)) {
				return current;
			} else {
				EList<?> views = current.getRepresentedEditPart().getNotationView().getChildren();
				if(views.contains(element)) {
					return current;
				}
			}
		}
		return null;
	}

	public class CustomComparator implements Comparator<Object> {

		/** this list contains the name of all the classes which want sort */
		private List<String> classesList;

		/**
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
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
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
	 * Content provider for the {@link CheckedTreeSelectionDialog}
	 */
	public class ContentProvider implements ITreeContentProvider {

		/**
		 * {@inheritDoc}
		 */
		public void dispose() {
			// nothing here
		}

		/**
		 * {@inheritDoc}
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// nothing here
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
			//			if(parentElement instanceof RootEditPartRepresentation) {
			//				RootEditPartRepresentation parentRepresentation = (RootEditPartRepresentation)parentElement;
			//				return parentRepresentation.getPossibleElement().toArray();
			//			} else if(parentElement instanceof CompartmentEditPartRepresentation) {
			//				CompartmentEditPartRepresentation compartmentRepresentation = (CompartmentEditPartRepresentation)parentElement;
			//				return compartmentRepresentation.getPossibleElement().toArray();
			//			}
			if(parentElement instanceof EditPartRepresentation) {
				return ((EditPartRepresentation)parentElement).getPossibleElement().toArray();
			}
			return new Object[0];


			//			// in case of parent is the main edit part => returns all compartment
			//			// if this is a compartment, returns all members that can be displayed
			//			if(parentElement instanceof CompartmentEditPartRepresentation) {
			//				CompartmentEditPartRepresentation compartmentRepresentation = (CompartmentEditPartRepresentation)parentElement;
			//
			//				// case parent is a compartment edit part
			//				EObject myClassifier = compartmentRepresentation.getUMLElement();
			//				if(myClassifier instanceof Classifier) {
			//					// returns all members that can be displayed in this compartment
			//					List<NamedElement> members = new ArrayList<NamedElement>();
			//					EList<NamedElement> localMembers = ((Classifier)myClassifier).getOwnedMembers();
			//					for(NamedElement namedElement : localMembers) {
			//						if(((EditPartRepresentation)parentElement).getPossibleElement().contains(namedElement)) {
			//							members.add(namedElement);
			//						}
			//					}
			//					Collections.sort(members, new CustomComparator(members));
			//					return members.toArray();
			//				}
			//			} else if(parentElement instanceof EditPartRepresentation) {// case parent is the main edit part
			//				EditPartRepresentation parentRepresentation = (EditPartRepresentation)parentElement;
			//				Element element = parentRepresentation.getUMLElement();
			//				if(element instanceof Classifier) {
			//					List<CompartmentEditPartRepresentation> compartmentRepresentations = new ArrayList<CompartmentEditPartRepresentation>();
			//					List<IResizableCompartmentEditPart> compartmentEditParts = CompartmentUtils.getAllCompartmentsEditPart(parentRepresentation.getRepresentedEditPart(), false);
			//					for(IResizableCompartmentEditPart currentEditPart : compartmentEditParts) {
			//						CompartmentEditPartRepresentation representation = new CompartmentEditPartRepresentation(currentEditPart, (Classifier)element);
			//						compartmentRepresentations.add(representation);
			//					}
			//					return compartmentRepresentations.toArray();
			//				}
			//			}
			// return new Object[]{};
		}

		/**
		 * {@inheritDoc}
		 */
		public Object getParent(Object element) {
			if(element instanceof EditPartRepresentation) {
				EditPartRepresentation editPartRepresentation = (EditPartRepresentation)element;
				return editPartRepresentation.getParentRepresentation();
			}

			//			if(!(element instanceof EditPartRepresentation)) {
			//				EditPartRepresentation rep = findEditPartRepresentation(element);
			//				if(rep != null) {
			//
			//					Classifier classifier = (Classifier)(rep).getUMLElement();
			//					if(classifier.getOwnedMembers().contains(element)) {
			//						return rep;
			//					} else {
			//						//						for(ClassifierRepresentation classRep : ((CustomEditPartRepresentation)rep).getSuperClasses()) {
			//						//							if(classRep.ownsElement(element)) {
			//						//								return classRep;
			//						//							}
			//						//						}
			//					}
			//				}
			//			}
			return null;
		}

		/**
		 * {@inheritDoc}
		 */
		public boolean hasChildren(Object element) {
			if(getChildren(element) != null && getChildren(element).length > 0) {
				return true;
			}
			return false;
		}

	}

	/**
	 * Class that represents the root edit part taht contains the compartments
	 */
	protected class RootEditPartRepresentation extends EditPartRepresentation {

		/**
		 * Creates a new {@link RootEditPartRepresentation}
		 * 
		 * @param representedEditPart
		 *        the edit part managed by this representation
		 * @param classifier
		 *        the classifier managed by the represented edit part
		 */
		public RootEditPartRepresentation(IGraphicalEditPart representedEditPart, Classifier classifier) {
			super(representedEditPart, classifier);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Classifier getSemanticElement() {
			return (Classifier)super.getSemanticElement();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected void initRepresentation() {
			super.initRepresentation();

			List<IResizableCompartmentEditPart> compartmentEditParts = CompartmentUtils.getAllCompartmentsEditPart(getRepresentedEditPart(), false);
			for(IResizableCompartmentEditPart currentEditPart : compartmentEditParts) {
				CompartmentEditPartRepresentation representation = new CompartmentEditPartRepresentation(currentEditPart, getSemanticElement(), this);
				elementsToSelect.add(representation);
			}

			// check if the element has a affixed child edit policy => will be treated as a compartment
			EditPolicy policy = getRepresentedEditPart().getEditPolicy(AffixedNodeAlignmentEditPolicy.AFFIXED_CHILD_ALIGNMENT_ROLE);
			if(policy != null) {
				// there can be some affixed children, create a pseudo compartment edit part representation
				AffixedChildrenEditPartRepresentation representation = new AffixedChildrenEditPartRepresentation(getSemanticElement(), this);
				elementsToSelect.add(representation);
			}
		}
	}

	/**
	 * Class that represents the compartment edit parts.
	 */
	protected class CompartmentEditPartRepresentation extends EditPartRepresentation {

		/**
		 * Creates a new {@link CompartmentEditPartRepresentation}
		 * 
		 * @param compartmentEditPart
		 *        the compartment edit part managed by this representation
		 * @param classifier
		 *        the classifier managed by the represented edit part
		 * @param parentRepresentation
		 *        parent presentation of this parent
		 */
		public CompartmentEditPartRepresentation(IResizableCompartmentEditPart compartmentEditPart, Classifier classifier, EditPartRepresentation parentRepresentation) {
			super(compartmentEditPart, classifier, parentRepresentation);
		}

		//		/**
		//		 * Returns the title of the compartment
		//		 * 
		//		 * @return the title of the compartment
		//		 */
		//		public String getCompartmentName() {
		//			if(getRepresentedEditPart() instanceof IResizableCompartmentEditPart) {
		//				return ((IResizableCompartmentEditPart)getRepresentedEditPart()).getCompartmentName();
		//			}
		//			// this is not a  compartment, but the virtual placeholder for border items
		//			return "Not a Compartment";
		//		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String getLabel() {
			if(getRepresentedEditPart() instanceof IResizableCompartmentEditPart) {
				return ((IResizableCompartmentEditPart)getRepresentedEditPart()).getCompartmentName();
			}
			return super.getLabel();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Classifier getSemanticElement() {
			return (Classifier)super.getSemanticElement();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected void initRepresentation() {
			// call super first
			super.initRepresentation();

			EList<NamedElement> members = getSemanticElement().getMembers();
			for(NamedElement namedElement : members) {
				if(canContain(namedElement)) {
					// create the leaf representation
					OptionalEditPartRepresentation editPartRepresentation = new OptionalEditPartRepresentation(null, namedElement, this);
					this.elementsToSelect.add(editPartRepresentation);
					// build the initial selection
					EList<?> childrenView = getRepresentedEditPart().getNotationView().getVisibleChildren();
					for(Object object : childrenView) {
						if(object instanceof View) {
							if(((View)object).getElement() == namedElement) {
								this.initialSelection.add(editPartRepresentation);

								// set the edit part in the optional edit part representation
								for(Object o : getRepresentedEditPart().getChildren()) {
									if(o instanceof IGraphicalEditPart) {
										if(((View)object).equals(((IGraphicalEditPart)o).getNotationView())) {
											editPartRepresentation.setRepresentedEditPart((IGraphicalEditPart)o);
										}
									}
								}
								break;
							}
						}
					}
				}
			}

		}

		/**
		 * REturns <code>true</code> if the associated compartment edit part can contain the given element
		 * 
		 * @param namedElement
		 *        the named element to show/hide
		 * @return <code>true</code> if the compartment can display the element
		 */
		protected boolean canContain(NamedElement namedElement) {
			TransactionalEditingDomain domain = getRepresentedEditPart().getEditingDomain();
			ViewDescriptor viewDescriptor = new ViewDescriptor(new EObjectAdapter(namedElement), Node.class, null, ViewUtil.APPEND, false, getRepresentedEditPart().getDiagramPreferencesHint());

			CreateCommand cmd = new CreateCommand(domain, viewDescriptor, getRepresentedEditPart().getNotationView());
			return (cmd.canExecute());
		}
	}

	/**
	 * Specific edit part representation for edit part that can display affixed children. It extends {@link CompartmentEditPartRepresentation}, as
	 * this is displayed at the same level.
	 */
	protected class AffixedChildrenEditPartRepresentation extends CompartmentEditPartRepresentation {

		/**
		 * Constructor.
		 * 
		 * @param classifier
		 *        uml element linked to this representation
		 * @param parentRepresentation
		 *        the main edit part against which show/hide content action is performed
		 */
		public AffixedChildrenEditPartRepresentation(Classifier classifier, EditPartRepresentation parentRepresentation) {
			super(null, classifier, parentRepresentation);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected boolean canContain(NamedElement namedElement) {
			TransactionalEditingDomain domain = getParentRepresentation().getRepresentedEditPart().getEditingDomain();
			ViewDescriptor viewDescriptor = new ViewDescriptor(new EObjectAdapter(namedElement), Node.class, null, ViewUtil.APPEND, false, getParentRepresentation().getRepresentedEditPart().getDiagramPreferencesHint());

			CreateCommand cmd = new CreateCommand(domain, viewDescriptor, getParentRepresentation().getRepresentedEditPart().getNotationView());
			return (cmd.canExecute());

			//return super.canContain(namedElement);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public IGraphicalEditPart getRepresentedEditPart() {
			return getParentRepresentation().getRepresentedEditPart();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String getLabel() {
			return "Border Items";
		}

		@Override
		protected void initRepresentation() {
			this.initialSelection = new ArrayList<EditPartRepresentation>();
			this.elementsToSelect = new ArrayList<EditPartRepresentation>();

			EList<NamedElement> members = getSemanticElement().getMembers();
			for(NamedElement namedElement : members) {
				if(canContain(namedElement)) {
					// create the leaf representation
					OptionalEditPartRepresentation editPartRepresentation = new OptionalEditPartRepresentation(null, namedElement, this);
					this.elementsToSelect.add(editPartRepresentation);
					// build the initial selection
					EList<?> childrenView = getParentRepresentation().getRepresentedEditPart().getNotationView().getVisibleChildren();
					for(Object object : childrenView) {
						if(object instanceof View) {
							if(((View)object).getElement() == namedElement) {
								this.initialSelection.add(editPartRepresentation);

								// set the edit part in the optional edit part representation
								for(Object o : getParentRepresentation().getRepresentedEditPart().getChildren()) {
									if(o instanceof IGraphicalEditPart) {
										if(((View)object).equals(((IGraphicalEditPart)o).getNotationView())) {
											editPartRepresentation.setRepresentedEditPart((IGraphicalEditPart)o);
											break;
										}
									}
								}
								break;
							}
						}
					}
				}
			}
		}



	}

	/**
	 * Class that manages an element that can not be displayed currently
	 */
	protected class OptionalEditPartRepresentation extends EditPartRepresentation {

		/**
		 * Creates a new {@link OptionalEditPartRepresentation}
		 * 
		 * @param representedEditPart
		 *        the edit part managed by this representation, which can be <code>null</code> in this implementation
		 * @param element
		 *        the semantic element managed by the represented edit part
		 * @param parentRepresentation
		 *        parent representation for this edit part (should be a compartment edit part representation)
		 */
		public OptionalEditPartRepresentation(IGraphicalEditPart representedEditPart, Element element, CompartmentEditPartRepresentation parentRepresentation) {
			super(representedEditPart, element, parentRepresentation);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public CompartmentEditPartRepresentation getParentRepresentation() {
			return (CompartmentEditPartRepresentation)super.getParentRepresentation();
		}

	}

	//	/**
	//	 * The custom EditPartRepresentation for this action
	//	 */
	//	protected class CustomEditPartRepresentation extends EditPartRepresentation {
	//
	//		/**
	//		 * this list contains the representation of all classifiers which are
	//		 * superclass of the classifier represented by EditPartRepresentaiton
	//		 */
	//		protected List<ClassifierRepresentation> superClasses;
	//
	//		/**
	//		 * 
	//		 * Constructor.
	//		 * 
	//		 * @param representedEditPart
	//		 *        the edit part managing the classifier
	//		 * @param classifier
	//		 *        the classifier for which display is customized
	//		 */
	//		public CustomEditPartRepresentation(EditPart representedEditPart, Classifier classifier) {
	//			super(representedEditPart, classifier);
	//		}
	//
	//		/**
	//		 * {@inheritDoc}
	//		 */
	//		@Override
	//		protected void initRepresentation() {
	//			super.initRepresentation();
	//			this.superClasses = new ArrayList<ShowHideContentsAction.ClassifierRepresentation>();
	//			if(this.UMLElement instanceof Classifier) {
	//				EList<Classifier> parents = ((Classifier)UMLElement).allParents();
	//				for(Classifier classifier : parents) {
	//					superClasses.add(new ClassifierRepresentation(classifier, this));
	//				}
	//
	//				/*
	//				 * build the list of the elements to select we suggest only the
	//				 * elements which can be displayed in the shown compartments
	//				 */
	//				EList<NamedElement> members = ((Classifier)UMLElement).getMembers();
	//				for(NamedElement namedElement : members) {
	//					View compartment = getCompartmentForCreation(this.representedEditPart, namedElement);
	//					if(compartment != null) {
	//						this.elementsToSelect.add(namedElement);
	//
	//						// build the initial selection
	//						EList<?> childrenView = compartment.getVisibleChildren();
	//						for(Object object : childrenView) {
	//							if(object instanceof View) {
	//								if(((View)object).getElement() == namedElement) {
	//									this.initialSelection.add(namedElement);
	//									break;
	//								}
	//							}
	//						}
	//					}
	//				}
	//			}
	//		}
	//
	//		/**
	//		 * 
	//		 * @return a list containing the {@link ClassifierRepresentation} for
	//		 *         each superclass of the {@link #representedEditPart}
	//		 */
	//		public List<ClassifierRepresentation> getSuperClasses() {
	//			return this.superClasses;
	//		}
	//
	//	}

	//	/**
	//	 * Extends the edit part representation only for compartments edit part
	//	 */
	//	protected class CompartmentEditPartRepresentation extends EditPartRepresentation {
	//
	//		/**
	//		 * Constructor.
	//		 * 
	//		 * @param compartmentEditPart
	//		 *        the compartment edit part represented
	//		 * @param umlElement
	//		 *        the uml element for which the compartment is displayed
	//		 */
	//		public CompartmentEditPartRepresentation(IResizableCompartmentEditPart compartmentEditPart, Classifier umlElement) {
	//			super(compartmentEditPart, umlElement);
	//		}
	//
	//		/**
	//		 * {@inheritDoc}
	//		 */
	//		@Override
	//		public IResizableCompartmentEditPart getRepresentedEditPart() {
	//			return (IResizableCompartmentEditPart)super.getRepresentedEditPart();
	//		}
	//
	//		/**
	//		 * {@inheritDoc}
	//		 */
	//		@Override
	//		public Classifier getUMLElement() {
	//			return (Classifier)super.getUMLElement();
	//		}
	//
	//		/**
	//		 * {@inheritDoc}
	//		 */
	//		@Override
	//		protected void initRepresentation() {
	//			// call super first
	//			super.initRepresentation();
	//
	//			EList<NamedElement> members = getUMLElement().getMembers();
	//			for(NamedElement namedElement : members) {
	//				if(canContain(namedElement)) {
	//					this.elementsToSelect.add(namedElement);
	//					// build the initial selection
	//					EList<?> childrenView = getRepresentedEditPart().getNotationView().getVisibleChildren();
	//					for(Object object : childrenView) {
	//						if(object instanceof View) {
	//							if(((View)object).getElement() == namedElement) {
	//								this.initialSelection.add(namedElement);
	//								break;
	//							}
	//						}
	//					}
	//				}
	//			}
	//
	//		}
	//
	//		/**
	//		 * REturns <code>true</code> if the associated compartment edit part can contain the given element
	//		 * 
	//		 * @param namedElement
	//		 *        the named element to show/hide
	//		 * @return <code>true</code> if the compartment can display the element
	//		 */
	//		protected boolean canContain(NamedElement namedElement) {
	//			TransactionalEditingDomain domain = getRepresentedEditPart().getEditingDomain();
	//			ViewDescriptor viewDescriptor = new ViewDescriptor(new EObjectAdapter(namedElement), Node.class, null, ViewUtil.APPEND, false, getRepresentedEditPart().getDiagramPreferencesHint());
	//
	//			CreateCommand cmd = new CreateCommand(domain, viewDescriptor, getRepresentedEditPart().getNotationView());
	//				return (cmd.canExecute());
	//		}
	//	}

	//	/**
	//	 * 
	//	 * This class is used to do easily the difference between the nested
	//	 * classifiers and the superclass of the selected class in the Tree The
	//	 * superclass are represented with this class
	//	 */
	//	protected class ClassifierRepresentation {
	//
	//		/** the represented classifier */
	//		protected Classifier representedClassifier;
	//
	//		/** the CustomEditPartRepresentation owning this classifier */
	//		protected EditPartRepresentation rep;
	//
	//		/**
	//		 * Constructor.
	//		 * 
	//		 * @param representedClassifier
	//		 *        the represented classifier
	//		 * @param rep
	//		 *        the representation containing this classifier
	//		 */
	//		public ClassifierRepresentation(Classifier representedClassifier, CustomEditPartRepresentation rep) {
	//			this.representedClassifier = representedClassifier;
	//			this.rep = rep;
	//		}
	//
	//		public boolean ownsElement(Object element) {
	//			if(representedClassifier.getOwnedMembers().contains(element)) {
	//				return true;
	//			}
	//			return false;
	//		}
	//
	//		/**
	//		 * Getter for {@link #representedClassifier}
	//		 * 
	//		 * @return {@link #representedClassifier}
	//		 */
	//		public Classifier getRepresentedClassifier() {
	//			return this.representedClassifier;
	//		}
	//
	//		/**
	//		 * Getter for {@link #rep}
	//		 * 
	//		 * @return {@link #rep}
	//		 */
	//		public EditPartRepresentation getEditPartRepresentation() {
	//			return this.rep;
	//		}
	//
	//	}
}
