package org.eclipse.papyrus.diagram.statemachine.edit.parts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.BorderedBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.commands.AnnotateNodeStyleCommand;
import org.eclipse.papyrus.diagram.common.edit.policies.DeleteOnlyViewComponentEditPolicy;
import org.eclipse.papyrus.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.statemachine.edit.policies.ConnectionPointReference2ItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ConnectionPointReference2EditPart extends
		BorderedBorderItemEditPart implements PrimaryShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2007;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public ConnectionPointReference2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE,
				getPrimaryDragEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ConnectionPointReference2ItemSemanticEditPolicy());
		// ** install new ComponentEditPolicy
		installEditPolicy(EditPolicy.COMPONENT_ROLE,
				new DeleteOnlyViewComponentEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				// Commented to show the "virtual" link that links the two nodes
				// if (child instanceof org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart) {
				// 	return new org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy();
				// }
				EditPolicy result = child
						.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if(result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		ExitPointFigure figure = new ExitPointFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public ExitPointFigure getPrimaryShape() {
		return (ExitPointFigure)primaryShape;
	}

	/**
	 * @generated
	 */
	@Override
	protected void addBorderItem(IFigure borderItemContainer,
			IBorderItemEditPart borderItemEditPart) {
		// Modify the BorderItemLocator to remove the snap of the labels
		if(borderItemEditPart instanceof LabelEditPart) {
			BorderItemLocator locator = new BorderItemLocator(getMainFigure(),
					PositionConstants.NSEW) {

				@Override
				public void relocate(IFigure borderItem) {
					Dimension size = getSize(borderItem);
					Rectangle rectSuggested = new Rectangle(
							getPreferredLocation(borderItem), size);
					int closestSide = findClosestSideOfParent(rectSuggested,
							getParentBorder());
					setPreferredSideOfParent(closestSide);

					borderItem.setBounds(rectSuggested);

					setCurrentSideOfParent(findClosestSideOfParent(
							rectSuggested, getParentBorder()));
				}

				@Override
				protected Point getPreferredLocation(int side,
						IFigure borderItem) {
					Point p = super.getPreferredLocation(side, borderItem);
					if(side == PositionConstants.NORTH
							|| side == PositionConstants.SOUTH) {
						Dimension borderItemSize = getSize(borderItem);
						p.x = p.x - borderItemSize.width / 2;
					} else if(side == PositionConstants.EAST
							|| side == PositionConstants.WEST) {
						Dimension borderItemSize = getSize(borderItem);
						p.y = p.y - borderItemSize.height / 2;
					}
					return p;
				}

			};

			if(borderItemEditPart instanceof ConnectionPointReferenceName2EditPart)
				locatorConnectionPointReferenceName2EditPart(locator);

			borderItemContainer.add(borderItemEditPart.getFigure(), locator);
		} else if(borderItemEditPart instanceof ConnectionPointReferenceName2EditPart) {
			BorderItemLocator locator = new BorderItemLocator(getMainFigure(),
					PositionConstants.SOUTH);
			locator.setBorderItemOffset(new Dimension(-20, -20));
			borderItemContainer.add(borderItemEditPart.getFigure(), locator);
		} else {
			super.addBorderItem(borderItemContainer, borderItemEditPart);
		}
	}

	/**
	 * @generated NOT
	 */
	protected void locatorConnectionPointReferenceName2EditPart(
			BorderItemLocator locator) {
		locator.setBorderItemOffset(new Dimension(0, 0));
		locator.setPreferredSideOfParent(PositionConstants.EAST);
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode()
				.DPtoLP(15), getMapMode().DPtoLP(15));

		//FIXME: workaround for #154536
		result.getBounds().setSize(result.getPreferredSize());
		return result;
	}

	/**
	 * @generated
	 */
	@Override
	public EditPolicy getPrimaryDragEditPolicy() {
		EditPolicy result = super.getPrimaryDragEditPolicy();
		if(result instanceof ResizableEditPolicy) {
			ResizableEditPolicy ep = (ResizableEditPolicy)result;
			ep.setResizeDirections(PositionConstants.NONE);
		}
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so
	 * you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	@Override
	protected NodeFigure createMainFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane. Respects
	 * layout one may have set for generated figure.
	 * 
	 * @param nodeShape
	 *        instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	@Override
	public IFigure getContentPane() {
		if(contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	@Override
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(UMLVisualIDRegistry
				.getType(ConnectionPointReferenceName2EditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	@Override
	protected void handleNotificationEvent(Notification event) {
		if(event.getNotifier() instanceof ShapeStyle) {
			super.handleNotificationEvent(event);

			// Propagate style
			for(Iterator i = getChildren().iterator(); i.hasNext();) {
				java.lang.Object obj = i.next();
				if(!(obj instanceof GraphicalEditPart))
					continue;
				GraphicalEditPart ep = (GraphicalEditPart)obj;

				if(ep.resolveSemanticElement() != resolveSemanticElement())
					continue;

				ShapeStyle style = (ShapeStyle)((View)ep.getModel())
						.getStyle(NotationPackage.eINSTANCE.getShapeStyle());
				if(style != null) {
					style.eSet((EStructuralFeature)event.getFeature(), event
							.getNewValue());
					ep.refresh();
				}
			}

		} else {
			super.handleNotificationEvent(event);
		}

		List<EStructuralFeature> features = new ArrayList<EStructuralFeature>();
		features.add(UMLPackage.eINSTANCE.getElement_OwnedComment());
		DiagramEditPartsUtil
				.handleNotificationForDiagram(this, event, features);
	}

	/**
	 * @generated
	 */
	public class ExitPointFigure extends Ellipse {

		/**
		 * @generated
		 */
		public ExitPointFigure() {
			this.setLayoutManager(new StackLayout());
			this.setForegroundColor(ColorConstants.black);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(15),
					getMapMode().DPtoLP(15)));
			this.setMaximumSize(new Dimension(getMapMode().DPtoLP(15),
					getMapMode().DPtoLP(15)));
			this.setMinimumSize(new Dimension(getMapMode().DPtoLP(15),
					getMapMode().DPtoLP(15)));
			this.setBorder(new MarginBorder(getMapMode().DPtoLP(2),
					getMapMode().DPtoLP(2), getMapMode().DPtoLP(2),
					getMapMode().DPtoLP(2)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			class ExitPointFigure_Cross0Class extends Shape {

				/**
				 * @generated
				 */
				private final PointList myTemplate = new PointList();

				/**
				 * @generated
				 */
				private Rectangle myTemplateBounds;

				/**
				 * @generated
				 */
				public void addPoint(Point point) {
					myTemplate.addPoint(point);
					myTemplateBounds = null;
				}

				/**
				 * @generated
				 */
				protected void fillShape(Graphics graphics) {
					Rectangle bounds = getBounds();
					graphics.pushState();
					graphics.translate(bounds.x, bounds.y);
					graphics.fillPolygon(scalePointList());
					graphics.popState();
				}

				/**
				 * @generated
				 */
				protected void outlineShape(Graphics graphics) {
					Rectangle bounds = getBounds();
					graphics.pushState();
					graphics.translate(bounds.x, bounds.y);
					graphics.drawPolygon(scalePointList());
					graphics.popState();
				}

				/**
				 * @generated
				 */
				private Rectangle getTemplateBounds() {
					if(myTemplateBounds == null) {
						myTemplateBounds = myTemplate.getBounds().getCopy()
								.union(0, 0);
						//just safety -- we are going to use this as divider 
						if(myTemplateBounds.width < 1) {
							myTemplateBounds.width = 1;
						}
						if(myTemplateBounds.height < 1) {
							myTemplateBounds.height = 1;
						}
					}
					return myTemplateBounds;
				}

				/**
				 * @generated
				 */
				private int[] scalePointList() {
					Rectangle pointsBounds = getTemplateBounds();
					Rectangle actualBounds = getBounds();

					float xScale = ((float)actualBounds.width)
							/ pointsBounds.width;
					float yScale = ((float)actualBounds.height)
							/ pointsBounds.height;

					if(xScale == 1 && yScale == 1) {
						return myTemplate.toIntArray();
					}
					int[] scaled = (int[])myTemplate.toIntArray().clone();
					for(int i = 0; i < scaled.length; i += 2) {
						scaled[i] = (int)Math.floor(scaled[i] * xScale);
						scaled[i + 1] = (int)Math
								.floor(scaled[i + 1] * yScale);
					}
					return scaled;
				}
			};
			ExitPointFigure_Cross0Class exitPointFigure_Cross0 = new ExitPointFigure_Cross0Class();

			exitPointFigure_Cross0.addPoint(new Point(getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(0)));
			exitPointFigure_Cross0.addPoint(new Point(getMapMode().DPtoLP(40),
					getMapMode().DPtoLP(40)));
			exitPointFigure_Cross0.addPoint(new Point(getMapMode().DPtoLP(20),
					getMapMode().DPtoLP(20)));
			exitPointFigure_Cross0.addPoint(new Point(getMapMode().DPtoLP(40),
					getMapMode().DPtoLP(0)));
			exitPointFigure_Cross0.addPoint(new Point(getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(40)));
			exitPointFigure_Cross0.addPoint(new Point(getMapMode().DPtoLP(20),
					getMapMode().DPtoLP(20)));
			exitPointFigure_Cross0.setFill(true);

			this.add(exitPointFigure_Cross0);

		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = true;

		/**
		 * @generated
		 */
		@Override
		protected boolean useLocalCoordinates() {
			return myUseLocalCoordinates;
		}

		/**
		 * @generated
		 */
		protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
			myUseLocalCoordinates = useLocalCoordinates;
		}

	}

	/**
	 * @generated
	 */
	protected EAnnotation getAppearenceEAnnotation() {
		EAnnotation eAnn = getPrimaryView().getEAnnotation(
				AnnotateNodeStyleCommand.APPEARANCE_EANNOTATION_NAME);
		return eAnn;
	}

	/**
	 * @generated
	 */
	private List<EObject> changesFromDefaultStyle() {
		EAnnotation eAnn = getAppearenceEAnnotation();
		if(eAnn == null)
			return new ArrayList<EObject>();
		else
			return eAnn.getReferences();
	}

	/**
	 * @generated
	 */
	public static boolean isLabel(IFigure figure) {
		if(figure instanceof Label) {
			return true;
		}
		if(figure instanceof WrappingLabel) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean isFigureFromChildEditPart(IFigure figure) {
		for(Iterator i = getChildren().iterator(); i.hasNext();) {
			java.lang.Object obj = i.next();
			if(obj instanceof AbstractGraphicalEditPart) {
				AbstractGraphicalEditPart gEP = (AbstractGraphicalEditPart)obj;
				if(gEP.getFigure() == figure) {
					// Check if semantic elements are different
					if(gEP instanceof GraphicalEditPart
							&& ((GraphicalEditPart)gEP)
							.resolveSemanticElement() == resolveSemanticElement()) {
						return false;
					}
					return true;
				} else {
					// Check if it is a child figure of the editpart
					for(java.lang.Object child : gEP.getChildren()) {
						if(child instanceof GraphicalEditPart) {
							GraphicalEditPart childEP = (GraphicalEditPart)child;
							if(childEP.getFigure() == figure) {
								if(childEP.resolveSemanticElement() != resolveSemanticElement())
									return true;
								else
									return false;
							}
						}
					}
				} // end else
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	@Override
	protected void setBackgroundColor(Color color) {
		// Only update if the Node doesn't have the default style
		if(changesFromDefaultStyle().contains(
				NotationPackage.Literals.FILL_STYLE__FILL_COLOR)) {
			setOwnedFiguresBackgroundColor(getFigure(), color);
		} else
			super.setBackgroundColor(color);

	}

	/**
	 * @generated
	 */
	public void setOwnedFiguresBackgroundColor(IFigure parent, Color color) {
		parent.setBackgroundColor(color);
		for(Iterator i = parent.getChildren().iterator(); i.hasNext();) {
			Object obj = i.next();
			if(obj instanceof IFigure
					&& !isFigureFromChildEditPart((IFigure)obj)) {
				setOwnedFiguresBackgroundColor((IFigure)obj, color);
			}
		}
	}

	/**
	 * @generated
	 */
	@Override
	protected void setForegroundColor(Color color) {
		// Only update if the Node doesn't have the default style
		if(changesFromDefaultStyle().contains(
				NotationPackage.Literals.LINE_STYLE__LINE_COLOR)) {
			setOwnedFiguresForegroundColor(getFigure(), color);
		} else
			super.setForegroundColor(color);

	}

	/**
	 * @generated
	 */
	public void setOwnedFiguresForegroundColor(IFigure parent, Color color) {
		if(!isLabel(parent))
			parent.setForegroundColor(color);
		for(Iterator i = parent.getChildren().iterator(); i.hasNext();) {
			java.lang.Object obj = i.next();
			if(obj instanceof IFigure && !isLabel((IFigure)obj)
					&& !isFigureFromChildEditPart((IFigure)obj)) {
				setOwnedFiguresForegroundColor((IFigure)obj, color);
			}
		}
	}

	/**
	 * @generated
	 */

	@Override
	protected void setFontColor(Color color) {
		// Only update if the Node doesn't have the default style
		if(changesFromDefaultStyle().contains(
				NotationPackage.Literals.LINE_STYLE__LINE_COLOR)) {
			setOwnedFiguresFontColor(getFigure(), color);
		} else
			super.setFontColor(color);

	}

	/**
	 * @generated
	 */
	public void setOwnedFiguresFontColor(IFigure parent, Color color) {
		if(isLabel(parent))
			parent.setForegroundColor(color);
		for(Iterator i = parent.getChildren().iterator(); i.hasNext();) {
			Object obj = i.next();
			if(obj instanceof IFigure && isLabel((IFigure)obj)
					&& !isFigureFromChildEditPart((IFigure)obj)) {
				setOwnedFiguresFontColor((IFigure)obj, color);
			}
		}
	}

}
