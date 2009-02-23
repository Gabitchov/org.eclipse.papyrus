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
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.policies.ComponentItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.clazz.edit.policies.OpenDiagramEditPolicy;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
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
public class ComponentEditPart extends AbstractBorderedShapeEditPart {

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

		@Override
		public Color getGradientColor() {
			return THIS_GRADIENT;
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
	public static final int VISUAL_ID = 2002;

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
	public ComponentEditPart(View view) {
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
		if (childEditPart instanceof AppliedStereotypeComponentEditPart) {
			((AppliedStereotypeComponentEditPart) childEditPart).setLabel(getPrimaryShape().getClassifierStereotypeLabel());
			return true;
		}
		if (childEditPart instanceof ComponentName2EditPart) {
			((ComponentName2EditPart) childEditPart).setLabel(getPrimaryShape().getClassifierNameLabel());
			return true;
		}
		if (childEditPart instanceof ComponentQualifiedNameEditPart) {
			((ComponentQualifiedNameEditPart) childEditPart).setLabel(getPrimaryShape().getClassifierQualifiedNameLabel());
			return true;
		}
		if (childEditPart instanceof ComponentAttributeCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getAttributeCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
			pane.add(((ComponentAttributeCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof ComponentOperationCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getOperationCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
			pane.add(((ComponentOperationCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof ComponentNestedClassifierCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getNestedClassifierFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
			pane.add(((ComponentNestedClassifierCompartmentEditPart) childEditPart).getFigure());
			return true;
		}

		// Papyrus Gencode :precise the locator for a template signature
		if (childEditPart instanceof RedefinableTemplateSignatureEditPart) {
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
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ComponentItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());

		// in Papyrus diagrams are not strongly synchronised
		// installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CANONICAL_ROLE, new org.eclipse.papyrus.diagram.clazz.edit.policies.ComponentCanonicalEditPolicy());

		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenDiagramEditPolicy());
		installEditPolicy("RESIZE_BORDER_ITEMS", new ConstrainedItemBorderLayoutEditPolicy()); //$NON-NLS-1$
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View) child.getModel();
				switch (UMLVisualIDRegistry.getVisualID(childView)) {
				case RedefinableTemplateSignatureEditPart.VISUAL_ID:

					// done in GMF gen code
					// return new org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy();
					// done in papyrus gencode to have borderItem resizeable
					return new BorderItemResizableEditPolicy();

				}
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
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
		if (editPart instanceof ComponentAttributeCompartmentEditPart) {
			return getPrimaryShape().getAttributeCompartmentFigure();
		}
		if (editPart instanceof ComponentOperationCompartmentEditPart) {
			return getPrimaryShape().getOperationCompartmentFigure();
		}
		if (editPart instanceof ComponentNestedClassifierCompartmentEditPart) {
			return getPrimaryShape().getNestedClassifierFigure();
		}
		if (editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return getContentPane();
	}

	/**
	 * @generated not
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(ComponentName2EditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public ClassifierDescriptor getPrimaryShape() {
		return (ClassifierDescriptor) primaryShape;
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
		if (childEditPart instanceof AppliedStereotypeComponentEditPart) {
			return true;
		}
		if (childEditPart instanceof ComponentName2EditPart) {
			return true;
		}
		if (childEditPart instanceof ComponentQualifiedNameEditPart) {
			return true;
		}
		if (childEditPart instanceof ComponentAttributeCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getAttributeCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
			pane.remove(((ComponentAttributeCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof ComponentOperationCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getOperationCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
			pane.remove(((ComponentOperationCompartmentEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof ComponentNestedClassifierCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getNestedClassifierFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
			pane.remove(((ComponentNestedClassifierCompartmentEditPart) childEditPart).getFigure());
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
