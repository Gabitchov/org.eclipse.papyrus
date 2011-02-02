/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.util.DisplayUtils;
import org.eclipse.gmf.runtime.diagram.ui.actions.internal.ShowConnectionLabelsAction;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionLabelsEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.ToggleConnectionLabelsRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.diagram.common.commands.ShowHideConnectionLabelsRequest;
import org.eclipse.papyrus.diagram.common.providers.EditorLabelProvider;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.menu.messages.Messages;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.dialogs.CheckedTreeSelectionDialog;

/**
 * Adapted code from {@link ShowConnectionLabelsAction}
 * 
 * This action allows to manage connection labels. 3 parameters are available for this actio :
 * <ul>
 * <li> {@link #HIDE_PARAMETER} : hide all labels for the selected elements</li>
 * <li>  {@link #SHOW_PARAMETER} : show all labels for the selected elements</li>
 * <li> {@link #MANAGE_PARAMETER} : open a dialog to choose labels to display and labels to hide for the selected element</li>
 * </ul>
 * 
 */
public class ShowHideConnectionLabelsAction extends AbstractGraphicalParametricAction {

	/**
	 * Parameters for this action
	 */
	public static final String MANAGE_PARAMETER = "manage"; //$NON-NLS-1$

	public static final String HIDE_PARAMETER = "hide"; //$NON-NLS-1$

	public static final String SHOW_PARAMETER = "show"; //$NON-NLS-1$

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parameter
	 *        the parameter for this action
	 * @param selectedEditPart
	 *        the list of selected {@link EditPart}
	 */
	public ShowHideConnectionLabelsAction(String parameter, List<IGraphicalEditPart> selectedEditPart) {
		super(parameter, selectedEditPart);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.menu.actions.AbstractGraphicalParametricAction#getBuildedCommand()
	 * 
	 * @return
	 */
	@Override
	protected Command getBuildedCommand() {
		List<ConnectionEditPart> connections = getConnections();
		CompoundCommand cmd = new CompoundCommand("ShowHideConnectionLabelCommand"); //$NON-NLS-1$
		if(getParameter().equals(MANAGE_PARAMETER)) {
			ManageConnectorLabelsAction action = new ManageConnectorLabelsAction(Messages.ShowHideConnectionLabelsAction_LabelsManager, Messages.ShowHideConnectionLabelsAction_SelectTheLabelToDisplay, getConnections());
			cmd.add(action.getActionCommand());
		} else {
			Request req = null;
			if(getParameter().equals(HIDE_PARAMETER)) {
				req = new ToggleConnectionLabelsRequest(false);
			} else if(getParameter().equals(SHOW_PARAMETER)) {
				req = new ToggleConnectionLabelsRequest(true);
			}
			if(req != null) {
				for(ConnectionEditPart current : connections) {
					Command command = current.getCommand(req);
					if(command != null) {
						cmd.add(command);
					}
				}
			}
		}
		return (cmd.canExecute() && !cmd.isEmpty()) ? cmd : UnexecutableCommand.INSTANCE;
	}

	/**
	 * Returns the selected connections for the actions
	 * 
	 * @return
	 *         the selected connections for the actions
	 */
	protected List<ConnectionEditPart> getConnections() {
		List<ConnectionEditPart> connections = new ArrayList<ConnectionEditPart>();
		for(IGraphicalEditPart current : getSelection()) {
			if(current instanceof DiagramEditPart && getSelection().size() == 1) {
				connections.addAll(((DiagramEditPart)current).getConnections());
				break;
			} else if(current instanceof ConnectionEditPart) {
				connections.add((ConnectionEditPart)current);
			}
		}
		return connections;
	}

	/**
	 * This code comes from {@link ConnectionLabelsEditPolicy}
	 * 
	 * determines if the passed view is a label view or not
	 * the default provided implementation is just an educated/generic guss
	 * clients can override this method to provide more specific response
	 * 
	 * @param node
	 * @return
	 */
	protected boolean isLabelView(EditPart containerEditPart, View parentView, View view) {
		// labels are not compartments
		// labels contained by Node Shape Edit Parts or connection edit parts
		// labels had location constrain
		// labels had the string Type set on them 
		if((containerEditPart instanceof ShapeNodeEditPart || containerEditPart instanceof ConnectionEditPart) && view instanceof Node) {
			Node node = (Node)view;
			String nodeType = node.getType();
			if(!isCompartment(node) && (nodeType != null && nodeType.length() > 0)) {
				LayoutConstraint lContraint = node.getLayoutConstraint();
				if(lContraint instanceof Location) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * This code comes from {@link ConnectionLabelsEditPolicy}
	 * 
	 * determines if the passed view is a compartment view or not
	 * the default provided implementation is just an educated/generic guss
	 * clients can override this method to provide more specific response
	 * 
	 * @param node
	 * @return
	 */
	protected boolean isCompartment(Node node) {
		if(node.getStyle(NotationPackage.eINSTANCE.getDrawerStyle()) != null) {
			return true;
		}
		return false;
	}

	/**
	 * This class provides a dialog to manage the displaying of the labels for connections
	 * 
	 * 
	 * 
	 */
	public class ManageConnectorLabelsAction {

		/**
		 * This map is used to store the new states of the labels
		 * the {@link View} are the keys for this map and the associated value is a {@link Boolean}.
		 * This Boolean represents the new value for the display state.
		 */
		protected Map<View, Boolean> viewStatus = new HashMap<View, Boolean>();

		/** Title for the dialog */
		private String title;

		/** Message for the dialog */
		private String message;

		/** the list of connections to manage */
		private List<ConnectionEditPart> connections;

		/**
		 * 
		 * Constructor.
		 * 
		 * @param title
		 * @param message
		 * @param editPolicyKey
		 */
		public ManageConnectorLabelsAction(String title, String message, List<ConnectionEditPart> connections) {
			this.title = title;
			this.message = message;
			this.connections = connections;
			initMap();
		}

		/**
		 * Returns the command for this action
		 * 
		 * @return
		 *         the command for this action
		 */
		protected Command getActionCommand() {
			CompoundCommand cmd = new CompoundCommand("Manage Conection Labels "); //$NON-NLS-1$

			DiagramEditPart diagramEP = DiagramEditPartsUtil.getDiagramEditPart(connections.get(0));

			CheckedTreeSelectionDialog selectionDialog = new CheckedTreeSelectionDialog(DisplayUtils.getDisplay().getActiveShell(), new CustomEditorLabelProvider(diagramEP), new ContentProvider(diagramEP));
			selectionDialog.setTitle(this.title);
			selectionDialog.setMessage(this.message);
			selectionDialog.setContainerMode(true);
			selectionDialog.setInput(connections);
			selectionDialog.setExpandedElements(connections.toArray());
			selectionDialog.setInitialElementSelections(getInitialSelection());
			selectionDialog.open();
			if(selectionDialog.getReturnCode() == Dialog.OK) {
				Object[] userSelection = selectionDialog.getResult();
				//fill the map with the new values
				for(Object current : userSelection) {
					if(current instanceof EditPart) {
						//do nothing
					} else if(current instanceof View) {
						viewStatus.put((View)current, new Boolean(true));
					}
				}

				/**
				 * Creates the commands for this action
				 */
				for(View view : viewStatus.keySet()) {
					boolean oldStatus = view.isVisible();
					boolean newStatus = viewStatus.get(view).booleanValue();
					if(oldStatus == newStatus) {
						//do nothing
					} else {
						ShowHideConnectionLabelsRequest request = new ShowHideConnectionLabelsRequest(newStatus, view);
						EditPart ep = DiagramEditPartsUtil.getEditPartFromView(view, getConnections().get(0));
						Command command = ep.getParent().getCommand(request);
						if(command != null) {
							cmd.add(command);
						}
					}
				}

				return cmd;
			}
			return UnexecutableCommand.INSTANCE;
		}

		/**
		 * Returns the initial selection
		 * 
		 * @return
		 *         the initial selection : the view that are currently displayed
		 */
		public List<View> getInitialSelection() {
			List<View> selection = new ArrayList<View>();
			for(ConnectionEditPart current : getConnections()) {
				View model = (View)(current).getModel();
				Iterator<?> iter = model.getChildren().iterator();
				while(iter.hasNext()) {
					View childView = (View)iter.next();
					if(isLabelView(current, model, childView)) {
						if(childView.isVisible()) {
							selection.add(childView);
						}
					}
				}
			}
			return selection;
		}

		/**
		 * put all the available views in the map, with the value <code>false</code>
		 */
		public void initMap() {
			viewStatus.clear();
			for(EditPart current : getConnections()) {
				View model = (View)((ConnectionEditPart)current).getModel();
				Iterator<?> iter = model.getChildren().iterator();
				while(iter.hasNext()) {
					View childView = (View)iter.next();
					if(isLabelView(current, model, childView)) {
						viewStatus.put(childView, new Boolean(false));
					}
				}
			}
		}
	}

	/**
	 * 
	 * Provide the label for the selected element
	 * 
	 */
	protected class CustomEditorLabelProvider extends EditorLabelProvider {

		/**
		 * the diagram EditPart. It's used to find the editpart corresponding to a view
		 */
		private DiagramEditPart diagramEP;

		/**
		 * 
		 * Constructor.
		 * 
		 * @param diagramEP
		 *        the current diagram for this action
		 */
		public CustomEditorLabelProvider(DiagramEditPart diagramEP) {
			this.diagramEP = diagramEP;
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
			if(element instanceof View) {
				EditPart ep = DiagramEditPartsUtil.getEditPartFromView((View)element, diagramEP);
				if(ep instanceof GraphicalEditPart) {
					IFigure figure = ((GraphicalEditPart)ep).getFigure();
					if(figure instanceof WrappingLabel) {
						return ((WrappingLabel)figure).getText();
					}
				}
			}
			return super.getText(element);
		}

		/**
		 * 
		 * @see org.eclipse.papyrus.diagram.common.providers.EditorLabelProvider#getImage(java.lang.Object)
		 * 
		 * @param element
		 * @return
		 */
		@Override
		public Image getImage(Object element) {
			if(element instanceof View) {
				/*
				 * TODO : when the generation template will be modified, we will have a way to get easily the function of the label.
				 * so we will display something like that :
				 * multiplicity role icon + source multiplicity + value of the multiplicity
				 */

				//				EditPart ep = DiagramEditPartsUtil.getEditPartFromView((View)element, diagramEP);
				//				if(ep instanceof IAdaptable) {
				//					Object property = ep.getAdapter(IPropertySource.class);
				//					if(property != null) {
				//						//its a label for a property!
				//						return super.getImage(property);
				//					}
				//				}
				return null;
			}
			return super.getImage(element);
		}
	}

	/**
	 * 
	 * Provide the element to fill the tree
	 * 
	 */
	protected class ContentProvider implements ITreeContentProvider {

		/**
		 * the diagram EditPart. It's used to find the editpart corresponding to a view
		 */
		private DiagramEditPart diagramEP;

		/**
		 * 
		 * Constructor.
		 * 
		 * @param diagramEP
		 *        the diagram editpart. Used to find editpart corresponding to a view
		 */
		public ContentProvider(DiagramEditPart diagramEP) {
			this.diagramEP = diagramEP;
		}

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
			List<View> children = new ArrayList<View>();
			if(parentElement instanceof ConnectionEditPart) {
				View model = (View)((ConnectionEditPart)parentElement).getModel();
				Iterator<?> iter = model.getChildren().iterator();
				while(iter.hasNext()) {
					View childView = (View)iter.next();
					if(isLabelView((EditPart)parentElement, model, childView)) {
						children.add(childView);
					}
				}
			}
			return children.toArray();
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
		 * 
		 * @param element
		 * @return
		 */
		public Object getParent(Object element) {
			if(element instanceof View) {
				EditPart part = DiagramEditPartsUtil.getEditPartFromView((View)element, diagramEP);
				return part.getParent();
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
