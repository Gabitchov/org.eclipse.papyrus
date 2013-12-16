/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import java.lang.reflect.Field;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.LocationRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderedNodeFigure;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.BaseSlidableAnchor;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.LayoutConstraint;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;
import org.eclipse.papyrus.uml.diagram.common.figure.node.InteractionRectangleFigure;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.uml.diagram.common.providers.UIAdapterImpl;
import org.eclipse.papyrus.uml.diagram.common.util.MessageDirection;
import org.eclipse.papyrus.uml.diagram.sequence.edit.helpers.AnchorHelper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.GateCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.InteractionFragmentsCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.InteractionGraphicalNodeEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.semantic.CustomInteractionItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.locator.GateLocator;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.CommandHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.NotificationHelper;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomInteractionEditPart extends InteractionEditPart {

	/**
	 * Notfier for listen and unlistend model element.
	 */
	private NotificationHelper notifier = null;

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public CustomInteractionEditPart(View view) {
		super(view);
	}

	/**
	 * Try to use the notifier from super class, if not exist, create new one.
	 */
	protected NotificationHelper getNotifier() {
		if(notifier == null) {
			try {
				Field f = InteractionEditPart.class.getDeclaredField("notifier");
				f.setAccessible(true);
				notifier = (NotificationHelper)f.get(this);
			} catch (Exception e) {
				notifier = new NotificationHelper(new UIAdapterImpl() {

					@Override
					protected void safeNotifyChanged(Notification msg) {
						handleNotificationEvent(msg);
					}
				});
			}
		}
		return notifier;
	}

	/**
	 * @Override
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomInteractionItemSemanticEditPolicy());
		//Fixed bugs: https://bugs.eclipse.org/bugs/show_bug.cgi?id=403134 and https://bugs.eclipse.org/bugs/show_bug.cgi?id=389531
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new InteractionGraphicalNodeEditPolicy());
		//Create gate: https://bugs.eclipse.org/bugs/show_bug.cgi?id=389531
		installEditPolicy("Gate Creation Edit Policy", new GateCreationEditPolicy());
		//Ordering fragments after creation, See https://bugs.eclipse.org/bugs/show_bug.cgi?id=403233
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new InteractionFragmentsCreationEditPolicy());
		//Install custom PrimaryDragEditPolicy to preserve anchors for lost and found.
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new ResizableShapeEditPolicy() {

			@Override
			protected Command getResizeCommand(ChangeBoundsRequest request) {
				Rectangle newBounds = getInitialFeedbackBounds().getCopy();
				Dimension sizeDelta = request.getSizeDelta();
				newBounds.width += sizeDelta.width;
				newBounds.height += sizeDelta.height;
				Dimension minimumSize = getFigure().getMinimumSize();
				//Avoid to update model when the new size is less than the minimum one.
				if(newBounds.width < minimumSize.width || newBounds.height < minimumSize.height) {
					return UnexecutableCommand.INSTANCE;
				}
				Command command = super.getResizeCommand(request);
				/** Anchors for Lost/Found message were updated, there's no need to preserve positions after resize. */
				//if(command != null && command.canExecute()) {
				//if(newBounds.width >= minimumSize.width && newBounds.height >= minimumSize.height) {
				//command = command.chain(new ICommandProxy(new PreserveAnchorsPositionCommand(CustomInteractionEditPart.this, sizeDelta, PreserveAnchorsPositionCommand.PRESERVE_XY)));
				//}
				//}
				return command;
			}
		});
	}

	/**
	 * @Override
	 */
	@Override
	protected IFigure createNodeShape() {
		return primaryShape = new InteractionRectangleFigure() {

			@Override
			public Dimension getMinimumSize(int wHint, int hHint) {
				Rectangle bounds = new Rectangle();
				for(Object child : CustomInteractionEditPart.this.getChildren()) {
					if(child instanceof InteractionInteractionCompartmentEditPart) {
						InteractionInteractionCompartmentEditPart childEditPart = (InteractionInteractionCompartmentEditPart)child;
						for(Object grandChild : childEditPart.getChildren()) {
							GraphicalEditPart editPart = (GraphicalEditPart)grandChild;
							IFigure figure = editPart.getFigure();
							bounds.union(figure.getBounds());
						}
						IFigure figure = childEditPart.getFigure();
						Rectangle rectangle = figure.getBounds();
						IFigure parentfigure = CustomInteractionEditPart.this.getFigure();
						Rectangle parentRectangle = parentfigure.getBounds();
						bounds.width += parentRectangle.width - rectangle.width + 10; // border 2x5
						bounds.height += parentRectangle.height - rectangle.height + 16; // border 2x5 + 2x3
						break;
					}
				}
				return bounds.getSize();
			}
		};
	}

	/**
	 * The changement in the background color of the Container must set the forground color of the
	 * ContainerCompartiment to avoid the separation line betewen the Compartiment and the
	 * ContainerLablel.
	 * 
	 * @Override-not
	 */
	@Override
	protected void setBackgroundColor(Color color) {
		if(primaryShape != null) {
			primaryShape.setBackgroundColor(color);
			if(primaryShape instanceof InteractionRectangleFigure) {
				InteractionRectangleFigure irf = (InteractionRectangleFigure)primaryShape;
				if(irf.getCompartmentFigure() != null) {
					irf.getCompartmentFigure().setForegroundColor(color);
				}
			}
		}
	}

	@Override
	protected void refreshFont() {
		super.refreshFont();
		refreshBounds();
	}

	/**
	 * Handle formal gate's name
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {
		final NotificationHelper notifier = getNotifier();
		Object feature = notification.getFeature();
		if(UMLPackage.eINSTANCE.getInteraction_FormalGate().equals(feature)) {
			// Handle formal gate
			notifier.unlistenObject((Notifier)notification.getOldValue());
			notifier.listenObject((Notifier)notification.getNewValue());
		} else if(UMLPackage.eINSTANCE.getNamedElement_Name().equals(feature) && notification.getNotifier() instanceof Gate) {
			// Handle modification of formal gate's name
			Gate gate = (Gate)notification.getNotifier();
			String oldStringValue = notification.getOldStringValue();
			String newStringValue = notification.getNewStringValue();
			if(oldStringValue != null && newStringValue != null) {
				String oldPrefix = oldStringValue.split("_")[0];
				String newPrefix = newStringValue.split("_")[0];
				if(!oldPrefix.equals(newPrefix) && (oldPrefix.equals(MessageDirection.IN.getName()) || oldPrefix.equals(MessageDirection.OUT.getName()))) {
					notifier.unlistenObject(gate);
					gate.setName(oldPrefix + "_" + gate.getName());
					notifier.listenObject(gate);
				}
			}
		}
		super.handleNotificationEvent(notification);
		if(!notification.isTouch()) {
			synchronizeSize();
		}
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart#refreshBounds()
	 * 
	 */

	@Override
	protected void refreshBounds() {
		super.refreshBounds();
		//Add size updater at the beginning of showing this edit part.
		getViewer().getControl().getDisplay().asyncExec(new Runnable() {

			public void run() {
				synchronizeSize();
			}
		});
	}

	/**
	 * Synchronize real figure size to model of Interaction.
	 * 1. At most time, the size of mode is very important when calculate the bounds of a EditPart, see SequenceUtil.getAbsoluteBounds().
	 * 2. This method would be invoked when the figure size increased automatically, the interaction always allow to show all children, see
	 * primaryShape.getMinimumSize().
	 * 3. In order to avoid update after changes of model, we only care the minimum size of figure.
	 */
	private void synchronizeSize() {
		View view = getNotationView();
		if(view instanceof Shape) {
			LayoutConstraint c = ((Shape)view).getLayoutConstraint();
			if(c instanceof Size) {
				final Size size = (Size)c;
				Dimension realSize = getFigure().getMinimumSize();
				final Dimension sizeDelta = new Dimension();
				if(size.getWidth() != -1 && realSize.width > size.getWidth()) {
					sizeDelta.width = realSize.width;
				}
				if(size.getHeight() != -1 && realSize.height > size.getHeight()) {
					sizeDelta.height = realSize.height;
				}
				if(sizeDelta.width != 0 || sizeDelta.height != 0) {
					AbstractCommand cmd = new AbstractCommand() {

						public boolean canExecute() {
							return true;
						}

						public boolean canUndo() {
							return false;
						}

						public void execute() {
							if(sizeDelta.width != 0) {
								size.setWidth(sizeDelta.width);
							}
							if(sizeDelta.height != 0) {
								size.setHeight(sizeDelta.height);
							}
						}

						public void redo() {
							execute();
						}
					};
					CommandHelper.executeCommandWithoutHistory(getEditingDomain(), cmd, true);
				}
			}
		}
	}

	/**
	 * Activate a listener for the interactionUse to Handle notification in the refered Interaction
	 */
	@Override
	public void activate() {
		super.activate();
		final NotificationHelper notifier = getNotifier();
		Interaction interaction = (Interaction)resolveSemanticElement();
		if(interaction != null) {
			for(Gate formalGate : interaction.getFormalGates()) {
				notifier.listenObject(formalGate);
			}
		}
	}

	/**
	 * Deactivate a listener for the interactionUse to Handle notification in the refered
	 * Interaction
	 */
	@Override
	public void deactivate() {
		super.deactivate();
		if(notifier != null) {
			notifier.unlistenAll();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeNotify() {
		if(notifier != null) {
			notifier.unlistenAll();
		}
		super.removeNotify();
	}

	/**
	 * Handle found message
	 */
	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		ConnectionAnchor sourceAnchor = createAnchor(request, UMLElementTypes.Message_4009, Message7EditPart.VISUAL_ID, Message7EditPart.class);
		if(sourceAnchor == null) {
			sourceAnchor = super.getSourceConnectionAnchor(request);
		}
		return sourceAnchor;
	}

	/**
	 * Handle found message
	 */
	@Override
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connEditPart) {
		if(connEditPart instanceof Message7EditPart) {
			String terminal = AnchorHelper.getAnchorId(getEditingDomain(), connEditPart, true);
			if(terminal.length() > 0) {
				PrecisionPoint pt = BaseSlidableAnchor.parseTerminalString(terminal);
				return new AnchorHelper.InnerPointAnchor(getFigure(), pt);
			}
		}
		ConnectionAnchor sourceConnectionAnchor = super.getSourceConnectionAnchor(connEditPart);
		//		Point referencePoint = sourceConnectionAnchor.getReferencePoint();
		//		if(connEditPart instanceof Message7EditPart && referencePoint.x != 0 && referencePoint.y != 0) {
		//			sourceConnectionAnchor = new XYAnchor(referencePoint);
		//		}
		return sourceConnectionAnchor;
	}

	/**
	 * Handle lost message
	 */
	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		ConnectionAnchor targetAnchor = createAnchor(request, UMLElementTypes.Message_4008, Message6EditPart.VISUAL_ID, Message6EditPart.class);
		if(targetAnchor == null) {
			//Enabled to find Anchor for MessageCreate, this would be useful when showing feedbacks.
			//Fixed bug: https://bugs.eclipse.org/bugs/show_bug.cgi?id=403134
			targetAnchor = createAnchor(request, UMLElementTypes.Message_4006, Message4EditPart.VISUAL_ID, Message4EditPart.class);
		}
		if(targetAnchor == null) {
			targetAnchor = super.getTargetConnectionAnchor(request);
		}
		return targetAnchor;
	}

	/**
	 * Handle lost message
	 */
	@Override
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connEditPart) {
		//Enabled to find Anchor for MessageCreate, this would be useful when showing feedbacks.
		//Fixed bug: https://bugs.eclipse.org/bugs/show_bug.cgi?id=403134
		if(connEditPart instanceof Message6EditPart || connEditPart instanceof Message4EditPart) {
			String terminal = AnchorHelper.getAnchorId(getEditingDomain(), connEditPart, false);
			if(terminal.length() > 0) {
				PrecisionPoint pt = BaseSlidableAnchor.parseTerminalString(terminal);
				return new AnchorHelper.InnerPointAnchor(getFigure(), pt);
			}
		}
		ConnectionAnchor targetConnectionAnchor = super.getTargetConnectionAnchor(connEditPart);
		//		Point referencePoint = targetConnectionAnchor.getReferencePoint();
		//		if(connEditPart instanceof Message6EditPart && referencePoint.x != 0 && referencePoint.y != 0) {
		//			targetConnectionAnchor = new XYAnchor(referencePoint);
		//		}		
		return targetConnectionAnchor;
	}

	/**
	 * Create Anchor
	 * 
	 * @param request
	 *        The request
	 * @param elementType
	 *        The element type of the message
	 * @param visualId
	 *        The visual ID of the message
	 * @param messageType
	 *        The type of the message
	 * @return The connection anchor
	 */
	private ConnectionAnchor createAnchor(Request request, IElementType elementType, int visualId, Class<?> messageType) {
		if(request instanceof CreateUnspecifiedTypeConnectionRequest) {
			CreateUnspecifiedTypeConnectionRequest createRequest = (CreateUnspecifiedTypeConnectionRequest)request;
			List<?> relationshipTypes = createRequest.getElementTypes();
			for(Object obj : relationshipTypes) {
				if(elementType.equals(obj)) {
					return createAnchor(createRequest.getLocation().getCopy());
				}
			}
		} else if(request instanceof CreateConnectionViewRequest) {
			CreateConnectionViewRequest createRequest = (CreateConnectionViewRequest)request;
			ConnectionViewDescriptor connectionViewDescriptor = createRequest.getConnectionViewDescriptor();
			if(connectionViewDescriptor != null) {
				if(String.valueOf(visualId).equals(connectionViewDescriptor.getSemanticHint())) {
					return createAnchor(createRequest.getLocation().getCopy());
				}
			}
		} else if(request instanceof ReconnectRequest) {
			ReconnectRequest reconnectRequest = (ReconnectRequest)request;
			ConnectionEditPart connectionEditPart = reconnectRequest.getConnectionEditPart();
			//Fixed bug creating anchors for MessageLost and MessageFound.
			if(messageType.isInstance(connectionEditPart) && request instanceof LocationRequest) {
				return createAnchor(((LocationRequest)request).getLocation().getCopy());
			}
		}
		return null;
	}

	/**
	 * Create Anchor
	 * 
	 * @param location
	 *        The location
	 * @return The connection anchor
	 */
	private ConnectionAnchor createAnchor(Point location) {
		//return new SlidableAnchor(getFigure(), BaseSlidableAnchor.getAnchorRelativeLocation(location, getFigure().getBounds()));
		return AnchorHelper.InnerPointAnchor.createAnchorAtLocation(getFigure(), new PrecisionPoint(location));
	}

	@Override
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof InteractionNameEditPart) {
			return true;
		}
		if(childEditPart instanceof InteractionInteractionCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((InteractionInteractionCompartmentEditPart)childEditPart).getFigure());
			return true;
		} else if(childEditPart instanceof GateEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((GateEditPart)childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * Create a BorderedNodeFigure for holding Gates.
	 */
	protected NodeFigure createNodeFigure() {
		return new BorderedNodeFigure(super.createNodeFigure());
	}

	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if(editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return getContentPane();
	}

	public final BorderedNodeFigure getBorderedFigure() {
		return (BorderedNodeFigure)getFigure();
	}

	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof GateEditPart) {
			getBorderedFigure().getBorderItemContainer().add(((GateEditPart)childEditPart).getFigure(), new GateLocator((GateEditPart)childEditPart, getFigure()));
			return true;
		}
		return super.addFixedChild(childEditPart);
	}

	@Override
	protected NodeFigure createNodePlate() {
		String prefElementId = "Interaction";
		IPreferenceStore store = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
		String preferenceConstantWitdh = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferencesConstantsHelper.WIDTH);
		String preferenceConstantHeight = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferencesConstantsHelper.HEIGHT);
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(store.getInt(preferenceConstantWitdh), store.getInt(preferenceConstantHeight)) {

			@Override
			protected ConnectionAnchor createAnchor(PrecisionPoint p) {
				if(p == null) {
					// If the old terminal for the connection anchor cannot be resolved (by SlidableAnchor) a null
					// PrecisionPoint will passed in - this is handled here
					return createDefaultAnchor();
				}
				return new AnchorHelper.IntersectionPointAnchor(this, p);
			}
		};
		return result;
	}
}
