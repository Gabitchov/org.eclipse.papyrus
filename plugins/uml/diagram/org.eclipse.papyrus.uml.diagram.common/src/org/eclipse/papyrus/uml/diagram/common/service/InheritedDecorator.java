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
package org.eclipse.papyrus.uml.diagram.common.service;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.Locator;
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
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.DescriptionStyle;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.layout.OverlayLocator;
import org.eclipse.papyrus.uml.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.uml.diagram.common.util.Util;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * 
 * The decorator to represent inherited element This decorator adds a small
 * image ( the generalization icon) next to the UML Element which are inherited.
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
	public static final String pluginID = "org.eclipse.papyrus.uml.diagram.common"; //$NON-NLS-1$

	/** the image path */
	public static final String imagePath = "/icons/hyperlink_13x13.gif"; //$NON-NLS-1$

	/** the image used added to represent an inherited element */
	private static final Image ICON_HYPERLINK = Activator.getPluginIconImage(pluginID, imagePath);

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
	 * @return node Node if IDecoratorTarget can be supported, null otherwise.
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
		IGraphicalEditPart gep = (IGraphicalEditPart)getDecoratorTarget().getAdapter(IGraphicalEditPart.class);

		if(node != null) {
			DescriptionStyle descStyle = getDescriptionStyle(node);

			if(descStyle != null) {
				if(isInherited(node)) {
					// if(Util.isAffixedChildNode(gep)) {

					// setDecoration(getDecoratorTarget().addDecoration(figure,
					// locator, false));
					// } else {
					// setDecoration(getDecoratorTarget().addShapeDecoration(figure,
					// getDirection(node), -1, false));
					// }

					if(gep != null && gep.getRoot() != null) {// if the gep has
																// no parent, we
																// can't test if
																// the container
																// is a
																// compartment
																// list
																// (because, we
																// call the
																// method
																// DiagramEditPartsUtil.getEditPartFromView((View)container,
																// gep);
						IFigure figure = getFigure(ICON_HYPERLINK);
						if(isInCompartmentList(node) && !Util.isAffixedChildNode(gep)) {
							setDecoration(getDecoratorTarget().addShapeDecoration(figure, getDirection(node), -1, false));
						} else {
							Locator locator = new OverlayLocator(gep.getFigure(), getDirection(node));
							setDecoration(getDecoratorTarget().addDecoration(figure, locator, false));
						}
					}

				}
			}
		}
	}

	/**
	 * Returns a figure corresponding to this image
	 * 
	 * @param image
	 *        a image
	 * @return a figure corresponding to this image
	 */
	public IFigure getFigure(Image image) {
		IMapMode mm = MapModeUtil.getMapMode(((IGraphicalEditPart)getDecoratorTarget().getAdapter(IGraphicalEditPart.class)).getFigure());
		ImageFigure fig = new ImageFigure();
		fig.setImage(image);
		fig.setSize(mm.DPtoLP(image.getBounds().width), mm.DPtoLP(image.getBounds().height));
		return fig;
	}

	/**
	 * Returns the direction to set the decorator for the node
	 * 
	 * @param node
	 *        the node
	 * @return the direction to set the decorator for the node direction can be
	 *         :
	 *         <ul>
	 *         <li> {@link PositionConstants#NORTH_WEST} or {@link PositionConstants#SOUTH_EAST}</li> if the node is an Affixed Child Node
	 *         <li>{@link PositionConstants#EAST}</li> if the node is in a compartment list
	 *         <li>{@link PositionConstants#SOUTH_EAST}</li> in other cases
	 *         </ul>
	 */
	protected Direction getDirection(Node node) {
		IGraphicalEditPart gep = (IGraphicalEditPart)getDecoratorTarget().getAdapter(IGraphicalEditPart.class);
		assert gep != null;
		// test if its an affixed ChildNode
		// if(Util.isAffixedChildNode(gep)) {
		//
		// IBorderItemLocator loc =
		// ((BorderNamedElementEditPart)gep).getBorderItemLocator();
		// int location = loc.getCurrentSideOfParent();
		// if(PositionConstants.NONE == location) { //sometimes
		// getBorderItemLocator doesn't work correctly!
		// location = PositionConstants.NORTH_WEST;
		// }
		// switch(location) {
		// case PositionConstants.NORTH:
		// case PositionConstants.NORTH_WEST:
		// case PositionConstants.WEST:
		// case PositionConstants.SOUTH_WEST:
		// // return IDecoratorTarget.Direction.NORTH_WEST;
		// default:
		// return IDecoratorTarget.Direction.SOUTH_EAST;
		// }
		// }
		if(gep.getParent() != null) {
			if(isInCompartmentList(node) && !Util.isAffixedChildNode(gep)) {
				return IDecoratorTarget.Direction.EAST;
			}
		}
		return IDecoratorTarget.Direction.SOUTH_WEST;
	}

	/**
	 * Tests if the compartment is a compartment list
	 * 
	 * @param node
	 *        the node on which we want add an Overlay
	 * @return <code>true</code> if the compartment is managed by an {@link XYLayoutEditPolicy}
	 */
	protected boolean isInCompartmentList(Node node) {
		IGraphicalEditPart gep = (IGraphicalEditPart)getDecoratorTarget().getAdapter(IGraphicalEditPart.class);
		if(gep != null && gep.getRoot() != null) {
			EObject container = node.eContainer();
			if(container instanceof View) {
				EditPart EP = DiagramEditPartsUtil.getEditPartFromView((View)container, gep);
				EditPolicy editPolicy = EP.getEditPolicy(EditPolicy.LAYOUT_ROLE);
				if(!(editPolicy instanceof XYLayoutEditPolicy)) {// we are in a
																	// compartment
																	// list
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Tests if the node is an inherited element
	 * 
	 * @param node
	 *        a node
	 * @return <code>true</code> if the node is an inherited element <code>false</code> if not
	 */
	protected boolean isInherited(Node node) {
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
	 * getDescriptionStyle Accessor to retrieve the description style from a
	 * Node.
	 * 
	 * @param node
	 *        Node to retrieve the description style from.
	 * @return DescriptionStyle style object
	 */
	protected DescriptionStyle getDescriptionStyle(Node node) {
		return (DescriptionStyle)node.getStyle(NotationPackage.eINSTANCE.getDescriptionStyle());
	}

	/**
	 * A listener used to listen the change of location and type (for Property)
	 */
	private NotificationListener notificationListener = new NotificationListener() {

		/**
		 * 
		 * @see org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener#notifyChanged(org.eclipse.emf.common.notify.Notification)
		 * 
		 * @param notification
		 */
		public void notifyChanged(Notification notification) {

			if(notification.getEventType() == Notification.REMOVE) {
				if(notification.getNotifier() instanceof Classifier) {
					IGraphicalEditPart gep = (IGraphicalEditPart)getDecoratorTarget().getAdapter(IGraphicalEditPart.class);
					assert gep != null;
					// we remove the listener on the container (because it's
					// changing
					DiagramEventBroker.getInstance(gep.getEditingDomain()).removeNotificationListener((EObject)notification.getNotifier(), notificationListener);
				}
			}
			// we update the listeners It's useful when an Element with overlay
			// changes of parent
			deactivate();
			activate();
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
			// the location of the decorator can change if it's an Affixed Child
			// Node
			if(isInherited((Node)view) && Util.isAffixedChildNode(gep)) {
				DiagramEventBroker.getInstance(gep.getEditingDomain()).addNotificationListener(gep.getNotationView(), notificationListener);
			}
		}

		// if the graphical parent is a Property, we add a listener on the type
		// of the property, to refresh the decoration
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

		/*
		 * We listen the changes on the UML parent, in order to know if the
		 * element is changing of parent Adding a listener using the following
		 * EReference doesn't work UMLPackage.eINSTANCE.getElement_Owner();
		 * UMLPackage.eINSTANCE.getProperty_Class();
		 * UMLPackage.eINSTANCE.getNamedElement_Namespace(); that's why we
		 * listen the parent
		 */
		if(view.getElement() instanceof Element) {
			Element semanticElement = (Element)view.getElement();

			/*
			 * We need add a listener only if the element is an element which
			 * can be inherited, like Property, Operation, Signal, Classifier...
			 */
			if(semanticElement != null && canBeInherited(semanticElement)) {
				// we listen if the container of the element changes!
				if(semanticElement.eContainer() != null) {
					DiagramEventBroker.getInstance(gep.getEditingDomain()).addNotificationListener(semanticElement.eContainer(), notificationListener);
				}
			}
		}
	}

	/**
	 * Tests if the element can be inherited
	 * 
	 * @param semanticElement
	 *        the element to test
	 * @return <code>true</code> if the element can be inherited
	 */
	protected boolean canBeInherited(Element semanticElement) {
		/*
		 * maybe we could replace these tests by RedefinableElement? or not?
		 */

		if(semanticElement instanceof Classifier) {
			return true;
		} else if(semanticElement instanceof Property) {
			return true;
		} else if(semanticElement instanceof Operation) {
			return true;
		}
		return false;
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

		EObject parent = view.eContainer();
		if(parent instanceof View) {
			EObject el = ((View)parent).getElement();
			if(el instanceof Property) {
				DiagramEventBroker.getInstance(gep.getEditingDomain()).removeNotificationListener(el, UMLPackage.eINSTANCE.getTypedElement_Type(), notificationListener);
			}
		}

		if(view.getElement() instanceof Element) {
			Element semanticElement = (Element)view.getElement();
			if(semanticElement != null) {
				if(semanticElement.eContainer() != null) {
					DiagramEventBroker.getInstance(gep.getEditingDomain()).removeNotificationListener(semanticElement.eContainer(), notificationListener);
				}
			}
		}
	}
}
