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
package org.eclipse.papyrus.diagram.composite.custom.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.ui.util.DisplayUtils;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
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
import org.eclipse.papyrus.diagram.common.command.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.diagram.common.editparts.NamedElementEditPart;
import org.eclipse.papyrus.diagram.common.util.ViewServiceUtil;
import org.eclipse.papyrus.diagram.composite.custom.messages.Messages;
import org.eclipse.papyrus.diagram.composite.part.UMLDiagramEditorPlugin;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.CheckedTreeSelectionDialog;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;



/**
 * 
 * This class provides the action to show Port and Property on a part
 */
public class ShowElementAction implements IActionDelegate {

	/** id used when this action is used on properties, in the composite diagram, to see the part coming from the type of the property */
	public final static String view_part_ID = "View Related"; //$NON-NLS-1$

	/** id used when this action is used on a classifier to view inherited element in this classifier */
	public final static String view_inherited_element_ID = "View Inherited"; //$NON-NLS-1$

	/** the selected edit part */
	protected EditPart selectedEditPart = null;

	/** the class owning the attributes to show */
	protected Classifier firstClass = null;

	/** the list of the views to destroy */
	protected List<EditPart> viewToDestroy;

	/** the list of the view to create */
	protected List<Object> viewToCreate;

	/**
	 * the list of the children editpart for the {@link #selectedEditPart} This list contains th direct children and the children of its
	 * {@link CompartmentEditPart}
	 * */
	protected List<EditPart> childrenEP;

	/** the transactional editing domain */
	protected TransactionalEditingDomain domain;

	/** the compartment if the property editpart */
	protected CompartmentEditPart compartment;

	/** the location to create the view of the property */
	protected Point propertyLocation = null;

	/** the location to create the view of the port */
	protected Point portLocation = null;

	/** This list contains the generalization of the class */
	protected List<Classifier> generalization = new ArrayList<Classifier>();

	/** definition ID for this action */
	private String definitionID;

	/**
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 * 
	 * @param action
	 */

	public void run(IAction action) {
		init();
		if(selectedEditPart != null && domain != null) {

			List<Object> initialSelection = getInitialSelection(this.selectedEditPart);

			CheckedTreeSelectionDialog selectionDialog = new CheckedTreeSelectionDialog(DisplayUtils.getDisplay().getActiveShell(), new EditorLabelProvider(), new ContentProvider());
			selectionDialog.setTitle(Messages.ShowElementAction_Title);
			selectionDialog.setMessage(Messages.ShowElementAction_Message);
			selectionDialog.setContainerMode(true);

			selectionDialog.setInput(this.generalization);
			selectionDialog.setExpandedElements(generalization.toArray());
			selectionDialog.setInitialElementSelections(initialSelection);

			selectionDialog.open();

			if(selectionDialog.getReturnCode() == Dialog.OK) {
				Object[] results = selectionDialog.getResult();

				List<Object> result = new ArrayList<Object>();
				//we remove the class from the result
				for(int i = 0; i < results.length; i++) {
					if(results[i] instanceof Class) {
						continue;
					} else {
						result.add(results[i]);
					}
				}


				//we are looking for the object to show
				for(Object object : result) {
					if(initialSelection.contains(object)) {
						//we do nothing
						continue;
					} else {
						viewToCreate.add(object);
					}
				}


				//we are looking for the view to destroy
				List<EditPart> children = getDependentEditPart(this.selectedEditPart);
				for(EditPart currentEP : children) {
					boolean exist = false;
					//is currentEP still selected?
					for(int i = 0; i < result.size(); i++) {
						Object obj1 = result.get(i);
						EObject eobject = ((View)currentEP.getModel()).getElement();
						if(obj1 == eobject) {
							exist = true;
						}
					}
					if(!exist) {
						//currentEP have to be destroyed
						this.viewToDestroy.add(currentEP);

					}
				}

				final CompositeCommand command = getCommand();
				final TransactionalEditingDomain theDomain = domain;
				if(!command.isEmpty()) {
					try {
						domain.runExclusive(new Runnable() {

							public void run() {
								PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {

									//executing the command
									public void run() {
										theDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(command));
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
	}


/**
	 * Test if the action can be proposed on the menu or not, and set the answer into the action ({@code action.setEnable(boolean))
	 * 
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
	 * 
	 * @param action
	 * the action
	 * 
	 * @param selection
	 * the current selection
	 */

	public void selectionChanged(IAction action, ISelection selection) {
		definitionID = action.getActionDefinitionId();
		boolean enable = false;
		this.selectedEditPart = null;
		if(selection instanceof StructuredSelection) {
			Object object = ((StructuredSelection)selection).getFirstElement();
			if(object instanceof NamedElementEditPart) {
				this.selectedEditPart = (EditPart)object;
				EObject selectedObject = ((View)selectedEditPart.getModel()).getElement();
				if(definitionID.equals(ShowElementAction.view_part_ID)) {
					if(selectedObject instanceof Property) {
						if(((Property)selectedObject).getType() instanceof Classifier) {
							enable = true;
						}
					}
				} else if(definitionID.equals(ShowElementAction.view_inherited_element_ID)) {
					if(selectedObject instanceof Classifier) {
						enable = true;
					}
				}
			}
		}
		action.setEnabled(enable);

	}

	/**
	 * Set all fields to their default value
	 */
	protected void init() {
		//set all fields to their default value
		viewToCreate = new ArrayList<Object>();
		viewToDestroy = new ArrayList<EditPart>();
		this.childrenEP = null;
		this.domain = null;
		this.compartment = null;
		this.generalization = new ArrayList<Classifier>();
		this.portLocation = new Point(-10, -10);
		this.propertyLocation = new Point();
		if(this.selectedEditPart != null) {
			this.childrenEP = getDependentEditPart(this.selectedEditPart);
			this.domain = ((IGraphicalEditPart)selectedEditPart).getEditingDomain();
			EObject selectedObject = ((View)selectedEditPart.getModel()).getElement();
			if(definitionID.equals(ShowElementAction.view_part_ID)) {
				if(selectedObject instanceof Property && ((Property)selectedObject).getType() instanceof Classifier) {
					((Property)selectedObject).getType();
					firstClass = (Classifier)((Property)selectedObject).getType();
				}
			} else if(definitionID.equals(ShowElementAction.view_inherited_element_ID)) {
				if(selectedObject instanceof Classifier) {
					firstClass = (Classifier)selectedObject;
				}
			}

			//we search the compartment of the Property
			for(Object obj : selectedEditPart.getChildren()) {
				if(obj instanceof CompartmentEditPart && !(obj instanceof ITextAwareEditPart)) {
					this.compartment = (CompartmentEditPart)obj;
					break;
				}
			}

			this.generalization.addAll(this.firstClass.getGenerals());
			this.generalization.add(this.firstClass);
		}
	}

	/**
	 * Return the editparts representing interesting uml elements (Port or Property) owned by {@code ep}
	 * 
	 * @param ep
	 *        an editpart owning other editparts
	 * @return
	 *         the editparts representing interesting uml elements (Port or Property) owned by {@code ep}
	 */
	protected List<EditPart> getDependentEditPart(EditPart ep) {
		List<EditPart> list = new ArrayList<EditPart>();
		List<?> children = ep.getChildren();
		for(Object object : children) {
			if(object instanceof CompartmentEditPart && !(object instanceof ITextAwareEditPart)) {
				list.addAll(getDependentEditPart((EditPart)object));
			} else if(!(object instanceof ITextAwareEditPart)) {
				list.add((EditPart)object);
			}
		}
		return list;
	}

	/**
	 * Return the command to remove some views and add some others
	 * 
	 * @return
	 *         the command to remove some views and add some others
	 */
	protected CompositeCommand getCommand() {
		/* for further information, see bug 302555 */
		ViewServiceUtil.forceLoad();

		CompositeCommand completeCmd = new CompositeCommand("Destroy and Create View Command"); //$NON-NLS-1$
		CompositeCommand destroyCmd = getDestroyViewCommand();
		CompositeCommand createCmd = getCreateViewCommand();
		if(destroyCmd.canExecute()) {
			completeCmd.add(destroyCmd);
		}
		if(createCmd.canExecute()) {
			completeCmd.add(createCmd);
		}
		return completeCmd;
	}

	/**
	 * Return the command to destroy views
	 * 
	 * @return
	 *         The command to destroy views
	 */
	protected CompositeCommand getDestroyViewCommand() {
		CompositeCommand destroyCommand = new CompositeCommand("Destroy View Command"); //$NON-NLS-1$
		for(EditPart currentEP : this.viewToDestroy) {
			DeleteCommand cmd = new DeleteCommand(domain, (View)currentEP.getModel());
			if(cmd.canExecute()) {
				destroyCommand.add(cmd);
			}
		}
		return destroyCommand;
	}

	/**
	 * Returns the command to create views
	 * 
	 * @return
	 *         The command to create views
	 */
	protected CompositeCommand getCreateViewCommand() {
		CompositeCommand createCommand = new CompositeCommand("Create View Command"); //$NON-NLS-1$
		Point location = new Point();
		for(Object obj : this.viewToCreate) {
			View containerView = null;

			if(obj instanceof Port) {
				location = portLocation.getCopy();
				portLocation = portLocation.translate(0, 25);
				containerView = (View)this.selectedEditPart.getModel();


			} else if(obj instanceof Property) {
				location = propertyLocation.getCopy();
				propertyLocation = propertyLocation.translate(20, 20);
				containerView = (View)this.compartment.getModel();
			}


			// creation of the node
			ViewDescriptor viewDescriptor = new ViewDescriptor(new EObjectAdapter((EObject)obj), Node.class, null, ViewUtil.APPEND, false, ((IGraphicalEditPart)this.selectedEditPart).getDiagramPreferencesHint());

			CreateCommand cmd = new CreateCommand(this.domain, viewDescriptor, containerView);
			if(cmd.canExecute()) {
				createCommand.add(cmd);

				SetBoundsCommand setBoundsCommand = new SetBoundsCommand(this.domain, "move", (IAdaptable)cmd.getCommandResult().getReturnValue(), location); //$NON-NLS-1$
				if(setBoundsCommand.canExecute()) {
					createCommand.add(setBoundsCommand);
				}
			}


		}
		return createCommand;
	}


	/**
	 * return the elements {@link Property} or {@link Port} owned by the editpart
	 * 
	 * @param editpart
	 *        an editpart containing other editpart representing {@link Property} or {@link Port}
	 * @return
	 *         The elements {@link Property} or {@link Port} owned by the editpart
	 * 
	 */
	protected List<Object> getInitialSelection(EditPart editpart) {
		List<Object> initialSelection = new ArrayList<Object>();
		List<?> childrenEP = editpart.getChildren();
		for(Object object : childrenEP) {
			if(object instanceof CompartmentEditPart) {//the compartment and the PropertyPartNameEditPart
				initialSelection.addAll(getInitialSelection((EditPart)object));
				continue;
			}
			if(object instanceof EditPart) {
				EObject element = ((View)((EditPart)object).getModel()).getElement();
				if(element != null) {
					initialSelection.add(element);
				}
			}
		}
		return initialSelection;
	}


	/**
	 * 
	 * Provide the label for the selected element
	 * 
	 */
	protected class EditorLabelProvider implements ILabelProvider {

		/** port icon path */
		private static final String ICON_PORT = "/icons/port.gif"; //$NON-NLS-1$

		/** property icon path */
		protected static final String ICON_PROPERTY = "/icons/property.gif"; //$NON-NLS-1$

		/** property icon path */
		protected static final String ICON_CLASS = "/icons/Class.gif"; //$NON-NLS-1$

		/** property icon path */
		protected static final String ICON_DATATYPE = "/icons/DataType.gif"; //$NON-NLS-1$

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
		 * 
		 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
		 * 
		 * @param element
		 * @return
		 */
		public Image getImage(Object element) {
			if(element instanceof Port) {
				return Activator.getPluginIconImage(UMLDiagramEditorPlugin.ID, ICON_PORT);
			} else if(element instanceof Property) {
				return Activator.getPluginIconImage(UMLDiagramEditorPlugin.ID, ICON_PROPERTY);
			} else if(element instanceof Class) {
				return Activator.getPluginIconImage(UMLDiagramEditorPlugin.ID, ICON_CLASS);
			} else if(element instanceof Class) {
				return Activator.getPluginIconImage(UMLDiagramEditorPlugin.ID, ICON_DATATYPE);
			}
			return null;
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
		 * 
		 * @param element
		 * @return
		 */
		public String getText(Object element) {
			if(element instanceof Property) {
				return ((Property)element).getName();
			} else if(element instanceof Port) {
				return ((Port)element).getName();
			} else if(element instanceof Class) {
				return ((Class)element).getQualifiedName();
			} else if(element instanceof DataType) {
				return ((DataType)element).getQualifiedName();
			}
			return element.toString();
		}
	}

	/**
	 * 
	 * Provide the attributes to display in the popup
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
			if(parentElement instanceof Classifier) {
				EList<Property> properties = ((Classifier)parentElement).getAttributes();
				return properties.toArray();
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
			if(element instanceof Property) {
				return ((Property)element).eContainer();
			} else if(element instanceof Port) {
				return ((Port)element).eContainer();
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
			if(element instanceof Classifier) {
				if(((Classifier)element).getAttributes().size() > 0) {
					return true;
				}
			}
			return false;
		}

	}

}
