/*****************************************************************************
 * Copyright (c) 2009-2010 CEA LIST.
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
package org.eclipse.papyrus.diagram.common.service;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoration;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget.Direction;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.DescriptionStyle;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.editparts.BorderNamedElementEditPart;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.common.util.Util;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * 
 * The decorator to represent inherited element
 * This decorator adds a small image ( the generalization icon) next to the UML Element which are inherited.
 * 3 positions are defined for the decoration :
 * <ul>
 * <li>if the UML Element is represented like an affixed child node : in {@link PositionConstants#NORTH_WEST} or {@link PositionConstants#SOUTH_EAST}
 * following its position/parent and margin =1</li>
 * <li>else if the element is in a compartment list : {@link PositionConstants#EAST} and margin =-1</li>
 * <li>else {@link PositionConstants#SOUTH_EAST} and margin = -1</li>
 * </ul>
 */
public class InheritedDecorator implements IDecorator {

	/** the object to be decorated */
	private IDecoratorTarget decoratorTarget;

	/** the decoration being displayed */
	private IDecoration decoration;

	/** the plugin where owning the icons for the UML Element */
	public static final String pluginID = "org.eclipse.papyrus.diagram.common"; //$NON-NLS-1$

	/** folder where are the UML Icon - We use a 15x15 image, because 16x16 is to big to be displayed in the compartment list with a police size to 8 */
	public static final String imagePath = "/icons/Generalization-15x15.gif"; //$NON-NLS-1$

	/** the image used added to represent an inherited element */
	private static final Image ICON_GENERALIZATION = Activator.getPluginIconImage(pluginID, imagePath);


	/**
	 * Creates a new <code>AbstractDecorator</code> for the decorator target
	 * passed in.
	 * 
	 * @param decoratorTarget
	 *        the object to be decorated
	 */
	public InheritedDecorator(IDecoratorTarget decoratorTarget) {
		this.decoratorTarget = decoratorTarget;
	}

	/**
	 * Gets the object to be decorated.
	 * 
	 * @return Returns the object to be decorated
	 */
	protected IDecoratorTarget getDecoratorTarget() {
		return decoratorTarget;
	}

	/**
	 * @return Returns the decoration.
	 */
	public IDecoration getDecoration() {
		return decoration;
	}

	/**
	 * @param decoration
	 *        The decoration to set.
	 */
	public void setDecoration(IDecoration decoration) {
		this.decoration = decoration;
	}

	/**
	 * Removes the decoration if it exists and sets it to null.
	 */
	protected void removeDecoration() {
		if(decoration != null) {
			decoratorTarget.removeDecoration(decoration);
			decoration = null;
		}
	}

	/**
	 * getDecoratorTargetClassifier Utility method to determine if the
	 * decoratorTarget is a supported type for this decorator and return the
	 * associated Classifier element.
	 * 
	 * @param decoratorTarget
	 *        IDecoratorTarget to check and return valid Classifier target.
	 * @return node Node if IDecoratorTarget can be supported, null
	 *         otherwise.
	 */
	static public Node getDecoratorTargetNode(IDecoratorTarget decoratorTarget) {
		DescriptionStyle descStyle = null;
		View node = (View)decoratorTarget.getAdapter(View.class);
		if(node != null && !(node instanceof Diagram)) {
			descStyle = (DescriptionStyle)node.getStyle(NotationPackage.eINSTANCE.getDescriptionStyle());

			if(descStyle != null) {
				return (Node)node;
			}
		}
		return null;

	}


	/**
	 * Creates the appropriate review decoration if all the criteria is
	 * satisfied by the view passed in.
	 */

	public void refresh() {
		removeDecoration();

		Node node = getDecoratorTargetNode(getDecoratorTarget());

		if(node != null) {

			DescriptionStyle descStyle = getDescriptionStyle(node);
			if(descStyle != null) {
				if(isInherited(node)) {
					setDecoration(getDecoratorTarget().addShapeDecoration(ICON_GENERALIZATION, getDirection(node), getMargin(node), false));
				}
			}
		}
	}

	/**
	 * Returns the margin to set the decorator for the node
	 * 
	 * @param node
	 *        the node
	 * @return
	 *         the margin to set the decorator for the node
	 *         margin can value :
	 *         <ul>
	 *         <li>0 : if the node is an Affixed Child Node</li>
	 *         <li>-1 : in other case</li>
	 *         </ul>
	 */
	private int getMargin(Node node) {
		IGraphicalEditPart gep = (IGraphicalEditPart)getDecoratorTarget().getAdapter(IGraphicalEditPart.class);
		assert gep != null;
		//test if its an affixed child node
		if(Util.isAffixedChildNode(gep)) {
			return 0;
		}
		return -1;
	}

	/**
	 * Returns the direction to set the decorator for the node
	 * 
	 * @param node
	 *        the node
	 * @return
	 *         the direction to set the decorator for the node
	 *         direction can be :
	 *         <ul>
	 *         <li> {@link PositionConstants#NORTH_WEST} or {@link PositionConstants#SOUTH_EAST}</li> if the node is an Affixed Child Node
	 *         <li>{@link PositionConstants#EAST}</li> if the node is in a compartment list
	 *         <li>{@link PositionConstants#SOUTH_EAST}</li> in other cases
	 *         </ul>
	 */
	private Direction getDirection(Node node) {
		IGraphicalEditPart gep = (IGraphicalEditPart)getDecoratorTarget().getAdapter(IGraphicalEditPart.class);
		assert gep != null;
		//test if its an affixed ChildNode
		if(Util.isAffixedChildNode(gep)) {

			IBorderItemLocator loc = ((BorderNamedElementEditPart)gep).getBorderItemLocator();
			int location = loc.getCurrentSideOfParent();
			if(PositionConstants.NONE == location) { //sometimes getBorderItemLocator doesn't work correctly!
				location = PositionConstants.NORTH_WEST;
			}
			switch(location) {
			case PositionConstants.NORTH:
			case PositionConstants.NORTH_WEST:
			case PositionConstants.WEST:
			case PositionConstants.SOUTH_WEST:
				return IDecoratorTarget.Direction.NORTH_WEST;
			default:
				return IDecoratorTarget.Direction.SOUTH_EAST;
			}
		}


		EObject container = node.eContainer();
		if(container instanceof View) {
			EditPart EP = DiagramEditPartsUtil.getEditPartFromView((View)container, gep);
			EditPolicy editPolicy = EP.getEditPolicy(EditPolicy.LAYOUT_ROLE);
			if(!(editPolicy instanceof XYLayoutEditPolicy)) {//we are in a compartment list
				return IDecoratorTarget.Direction.EAST;
			}
		}
		return IDecoratorTarget.Direction.SOUTH_EAST;
	}

	/**
	 * Tests if the node is an inherited element
	 * 
	 * @param node
	 *        a node
	 * @return
	 *         <code>true</code> if the node is an inherited element <code>false</code> if not
	 */
	private boolean isInherited(Node node) {
		EObject element = node.getElement();
		if(element instanceof Element) {
			EObject container = node.eContainer();
			EObject graphicalParent = null;
			if(container instanceof DecorationNode) {
				graphicalParent = ((DecorationNode)container).getElement();
			} else if(container instanceof View) {
				graphicalParent = ((View)container).getElement();
			}
			if(graphicalParent instanceof Property || graphicalParent instanceof Classifier) {
				Classifier classifier = null;
				if(graphicalParent instanceof Property) {
					Type type = ((Property)graphicalParent).getType();
					if(type instanceof Classifier) {
						classifier = (Classifier)type;
					}
				} else {
					classifier = (Classifier)graphicalParent;
				}
				if(classifier != null) {
					EList<NamedElement> inheritedMembers = classifier.getInheritedMembers();
					return inheritedMembers.contains(element);
				}
			}
		}
		return false;
	}

	/**
	 * getDescriptionStyle
	 * Accessor to retrieve the description style from a Node.
	 * 
	 * @param node
	 *        Node to retrieve the description style from.
	 * @return DescriptionStyle style object
	 */
	private DescriptionStyle getDescriptionStyle(Node node) {
		return (DescriptionStyle)node.getStyle(NotationPackage.eINSTANCE.getDescriptionStyle());
	}

	private NotificationListener notificationListener = new NotificationListener() {

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener#notifyChanged(org.eclipse.emf.common.notify.Notification)
		 */

		public void notifyChanged(Notification notification) {
			refresh();
		}
	};


	/**
	 * Adds listeners on
	 * <ul>
	 * <li>Affixed Child Node</li>
	 * <li>graphical parent, when its a {@link Property} (we add the listener on its Type)</li>
	 * </ul>
	 */
	public void activate() {

		IGraphicalEditPart gep = (IGraphicalEditPart)getDecoratorTarget().getAdapter(IGraphicalEditPart.class);
		assert gep != null;
		View view = ((View)gep.getModel());
		if(view instanceof Node) {
			//the location of the decorator can change if it's an Affixed Child Node
			if(isInherited((Node)view) && Util.isAffixedChildNode(gep)) {
				DiagramEventBroker.getInstance(gep.getEditingDomain()).addNotificationListener(gep.getNotationView(), notificationListener);
			}
		}

		//if the graphical parent is a Property, we add a listener on the type of the property, to refresh the decoration
		EObject parent = view.eContainer();
		if(parent instanceof DecorationNode) {
			parent = parent.eContainer();
		}
		if(parent instanceof View) {
			EObject el = ((View)parent).getElement();
			if(el instanceof Property) {
				DiagramEventBroker.getInstance(gep.getEditingDomain()).addNotificationListener(el, UMLPackage.eINSTANCE.getTypedElement_Type(), notificationListener);
			}
		}

	}

	/**
	 * Removes the listeners and the decorations
	 */
	public void deactivate() {
		removeDecoration();

		IGraphicalEditPart gep = (IGraphicalEditPart)getDecoratorTarget().getAdapter(IGraphicalEditPart.class);
		assert gep != null;
		DiagramEventBroker.getInstance(gep.getEditingDomain()).removeNotificationListener(gep.getNotationView(), notificationListener);
		View view = ((View)gep.getModel());
		if(view instanceof Node) {
			//the location of the decorator can change if it's an Affixed Child Node
			if(isInherited((Node)view) && Util.isAffixedChildNode(gep)) {
				DiagramEventBroker.getInstance(gep.getEditingDomain()).removeNotificationListener(gep.getNotationView(), notificationListener);
			}
		}
		EObject parent = view.eContainer();
		if(parent instanceof View) {
			EObject el = ((View)parent).getElement();
			if(el instanceof Property) {
				DiagramEventBroker.getInstance(gep.getEditingDomain()).removeNotificationListener(el, UMLPackage.eINSTANCE.getTypedElement_Type(), notificationListener);
			}
		}
	}

}
