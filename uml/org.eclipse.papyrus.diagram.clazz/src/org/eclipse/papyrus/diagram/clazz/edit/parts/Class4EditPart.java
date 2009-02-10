/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.policies.Class4CanonicalEditPolicy;
import org.eclipse.papyrus.diagram.clazz.edit.policies.Class4ItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.clazz.edit.policies.OpenDiagramEditPolicy;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.common.editpolicies.BorderItemResizableEditPolicy;
import org.eclipse.papyrus.diagram.common.editpolicies.ConstrainedItemBorderLayoutEditPolicy;
import org.eclipse.papyrus.diagram.common.figure.node.CClassifierFigure;
import org.eclipse.papyrus.diagram.common.locator.TemplateClassifierBorderItemLocator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

/**
 * @generated
 */
public class Class4EditPart extends AbstractBorderedShapeEditPart {

	/**
	 * @generated
	 */
	public class ClassifierDescriptor extends CClassifierFigure {

		/**
		 * @generated
		 */
		private RectangleFigure fAttributeCompartmentFigure;

		/**
		 * @generated
		 */
		private WrappingLabel fClassifierNameLabel;

		/**
		 * @generated
		 */
		private WrappingLabel fClassifierQualifiedNameLabel;

		/**
		 * @generated
		 */
		private WrappingLabel fClassifierStereotypeLabel;

		/**
		 * @generated
		 */
		private RectangleFigure fNestedClassifierFigure;

		/**
		 * @generated
		 */
		private RectangleFigure fOperationCompartmentFigure;

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = false;

		/**
		 * @generated
		 */
		public ClassifierDescriptor() {

			this.setForegroundColor(THIS_FORE);
			this.setBackgroundColor(THIS_BACK);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fClassifierStereotypeLabel = new WrappingLabel();
			fClassifierStereotypeLabel.setText("");

			fClassifierStereotypeLabel.setFont(FCLASSIFIERSTEREOTYPELABEL_FONT);

			this.add(fClassifierStereotypeLabel);

			fClassifierNameLabel = new WrappingLabel();
			fClassifierNameLabel.setText("");

			fClassifierNameLabel.setFont(FCLASSIFIERNAMELABEL_FONT);

			this.add(fClassifierNameLabel);

			fClassifierQualifiedNameLabel = new WrappingLabel();
			fClassifierQualifiedNameLabel.setText("");

			fClassifierQualifiedNameLabel.setFont(FCLASSIFIERQUALIFIEDNAMELABEL_FONT);

			this.add(fClassifierQualifiedNameLabel);

			fAttributeCompartmentFigure = new RectangleFigure();
			fAttributeCompartmentFigure.setFill(false);

			this.add(fAttributeCompartmentFigure);
			fAttributeCompartmentFigure.setLayoutManager(new StackLayout());

			fOperationCompartmentFigure = new RectangleFigure();
			fOperationCompartmentFigure.setFill(false);

			this.add(fOperationCompartmentFigure);
			fOperationCompartmentFigure.setLayoutManager(new StackLayout());

			fNestedClassifierFigure = new RectangleFigure();
			fNestedClassifierFigure.setFill(false);

			this.add(fNestedClassifierFigure);
			fNestedClassifierFigure.setLayoutManager(new StackLayout());

		}

		/**
		 * @generated
		 */
		public RectangleFigure getAttributeCompartmentFigure() {
			return fAttributeCompartmentFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getClassifierNameLabel() {
			return fClassifierNameLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getClassifierQualifiedNameLabel() {
			return fClassifierQualifiedNameLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getClassifierStereotypeLabel() {
			return fClassifierStereotypeLabel;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getNestedClassifierFigure() {
			return fNestedClassifierFigure;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getOperationCompartmentFigure() {
			return fOperationCompartmentFigure;
		}

		/**
		 * @generated
		 */
		protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
			myUseLocalCoordinates = useLocalCoordinates;
		}

		/**
		 * @generated
		 */
		protected boolean useLocalCoordinates() {
			return myUseLocalCoordinates;
		}

	}

	/**
	 * @generated
	 */
	static final Font FCLASSIFIERNAMELABEL_FONT = new Font(Display.getCurrent(), "Arial", 10, SWT.BOLD);

	/**
	 * @generated
	 */
	static final Font FCLASSIFIERQUALIFIEDNAMELABEL_FONT = new Font(Display.getCurrent(), "Arial", 8, SWT.ITALIC);

	/**
	 * @generated
	 */
	static final Font FCLASSIFIERSTEREOTYPELABEL_FONT = new Font(Display.getCurrent(), "Arial", 8, SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 235, 248, 255);

	/**
	 * @generated
	 */
	static final Color THIS_FORE = new Color(null, 177, 207, 229);

	static final Color THIS_GRADIENT = new Color(null, 177, 207, 229);

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3010;

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
	public Class4EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ClassName3EditPart) {
			((ClassName3EditPart) childEditPart).setLabel(getPrimaryShape().getClassifierStereotypeLabel());
			return true;
		}
		if (childEditPart instanceof ClassName4EditPart) {
			((ClassName4EditPart) childEditPart).setLabel(getPrimaryShape().getClassifierNameLabel());
			return true;
		}
		if (childEditPart instanceof ClassQualifiedName2EditPart) {
			((ClassQualifiedName2EditPart) childEditPart).setLabel(getPrimaryShape().getClassifierQualifiedNameLabel());
			return true;
		}
		if (childEditPart instanceof ClassAttributeCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getAttributeCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
			pane.add(((ClassAttributeCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof ClassOperationCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getOperationCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
			pane.add(((ClassOperationCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof ClassNestedClassifierCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getNestedClassifierFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
			pane.add(((ClassNestedClassifierCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof RedefinableTemplateSignatureEditPart) {
			// BorderItemLocator locator = new BorderItemLocator(getMainFigure(), PositionConstants.NORTH);
			BorderItemLocator locator = new TemplateClassifierBorderItemLocator(getMainFigure(), PositionConstants.NORTH);
			getBorderedFigure().getBorderItemContainer().add(((RedefinableTemplateSignatureEditPart) childEditPart).getFigure(), locator);
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy() {

			public Command getCommand(Request request) {
				if (understandsRequest(request)) {
					if (request instanceof CreateViewAndElementRequest) {
						CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor().getCreateElementRequestAdapter();
						IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
						if (type == UMLElementTypes.Property_3012) {
							EditPart compartmentEditPart = getChildBySemanticHint(UMLVisualIDRegistry.getType(ClassAttributeCompartmentEditPart.VISUAL_ID));
							return compartmentEditPart == null ? null : compartmentEditPart.getCommand(request);
						}
						if (type == UMLElementTypes.Reception_3011) {
							EditPart compartmentEditPart = getChildBySemanticHint(UMLVisualIDRegistry.getType(ClassOperationCompartmentEditPart.VISUAL_ID));
							return compartmentEditPart == null ? null : compartmentEditPart.getCommand(request);
						}
						if (type == UMLElementTypes.Operation_3013) {
							EditPart compartmentEditPart = getChildBySemanticHint(UMLVisualIDRegistry.getType(ClassOperationCompartmentEditPart.VISUAL_ID));
							return compartmentEditPart == null ? null : compartmentEditPart.getCommand(request);
						}
						if (type == UMLElementTypes.Class_3014) {
							EditPart compartmentEditPart = getChildBySemanticHint(UMLVisualIDRegistry.getType(ClassNestedClassifierCompartmentEditPart.VISUAL_ID));
							return compartmentEditPart == null ? null : compartmentEditPart.getCommand(request);
						}
					}
					return super.getCommand(request);
				}
				return null;
			}
		});
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new Class4ItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new Class4CanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenDiagramEditPolicy());
		installEditPolicy("RESIZE_BORDER_ITEMS", new ConstrainedItemBorderLayoutEditPolicy());

		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				if (child instanceof IBorderItemEditPart) {
					// return new BorderItemSelectionEditPolicy();
					return new BorderItemResizableEditPolicy();
				}
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createMainFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode().DPtoLP(40), getMapMode().DPtoLP(40));
		return result;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		ClassifierDescriptor figure = new ClassifierDescriptor();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {

		if (editPart instanceof ClassAttributeCompartmentEditPart) {
			return getPrimaryShape().getAttributeCompartmentFigure();
		}
		if (editPart instanceof ClassOperationCompartmentEditPart) {
			return getPrimaryShape().getOperationCompartmentFigure();
		}
		if (editPart instanceof ClassNestedClassifierCompartmentEditPart) {
			return getPrimaryShape().getNestedClassifierFigure();
		}
		if (editPart instanceof RedefinableTemplateSignatureEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return super.getContentPaneFor(editPart);
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(ClassName3EditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public ClassifierDescriptor getPrimaryShape() {
		return (ClassifierDescriptor) primaryShape;
	}

	// custom code in order to refresh the figure if the class is active
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);
		if (resolveSemanticElement().equals(event.getNotifier()) && (event.getFeature() instanceof EAttribute) && ((EAttribute) (event.getFeature())).getName().equals("isActive")) {
			((CClassifierFigure) getFigure()).setActive(event.getNewBooleanValue());
			refreshVisuals();
		}
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof ClassAttributeCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getAttributeCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
			pane.remove(((ClassAttributeCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof ClassOperationCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getOperationCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
			pane.remove(((ClassOperationCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof ClassNestedClassifierCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getNestedClassifierFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
			pane.remove(((ClassNestedClassifierCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof RedefinableTemplateSignatureEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((RedefinableTemplateSignatureEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * Default implementation treats passed figure as content pane. Respects layout one may have set for generated figure.
	 * 
	 * @param nodeShape
	 *            instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(getMapMode().DPtoLP(5));
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

}
