package org.eclipse.papyrus.diagram.statemachine.edit.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.StackLayout;
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
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ComponentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.commands.AnnotateNodeStyleCommand;
import org.eclipse.papyrus.diagram.common.commands.RemoveEObjectReferencesFromDiagram;
import org.eclipse.papyrus.diagram.common.editparts.PrimaryShapeEditPart;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.statemachine.edit.policies.Pseudostate4ItemSemanticEditPolicy;
import org.eclipse.swt.graphics.Color;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class Pseudostate4EditPart extends ShapeNodeEditPart implements
		PrimaryShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2012;

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
	public Pseudostate4EditPart(View view) {
		super(view);
	}

	/**
	 * @generated not
	 */
	@Override
	protected void createDefaultEditPolicies() {

		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new Pseudostate4ItemSemanticEditPolicy());
		// ** install new ComponentEditPolicy
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ComponentEditPolicy() {

			@Override
			protected boolean shouldDeleteSemantic() {
				return false;
			}

			@Override
			protected Command getDeleteCommand(GroupRequest request) {
				Command command = super.getDeleteCommand(request);
				command = command
						.chain(new ICommandProxy(
						new RemoveEObjectReferencesFromDiagram(
						getEditingDomain(),
						Pseudostate4EditPart.this
						.getDiagramView(),
						Collections
						.singletonList(resolveSemanticElement()))));
				return command;
			}
		});
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
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
		ForkJoinFigure figure = new ForkJoinFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public ForkJoinFigure getPrimaryShape() {
		return (ForkJoinFigure)primaryShape;
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode()
				.DPtoLP(4), getMapMode().DPtoLP(50));
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
	protected NodeFigure createNodeFigure() {
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
	 * @not-generated
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
	public class ForkJoinFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		public ForkJoinFigure() {
			this.setBackgroundColor(ColorConstants.black);
		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = false;

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
