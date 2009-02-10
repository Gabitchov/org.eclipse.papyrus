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
import org.eclipse.papyrus.diagram.clazz.custom.policies.RemoveOphanConnectionViewClazzPolicy;
import org.eclipse.papyrus.diagram.clazz.custom.policies.RemoveOrphanNodeViewPolicy;
import org.eclipse.papyrus.diagram.clazz.edit.policies.Model3ItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.clazz.edit.policies.OpenDiagramEditPolicy;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.common.editpolicies.BorderItemResizableEditPolicy;
import org.eclipse.papyrus.diagram.common.editpolicies.ConstrainedItemBorderLayoutEditPolicy;
import org.eclipse.papyrus.diagram.common.figure.node.CPackageFigure;
import org.eclipse.papyrus.diagram.common.figure.node.PackageNodeFigure;
import org.eclipse.papyrus.diagram.common.locator.TemplateBorderItemLocator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

/**
 * @generated
 */
public class Model3EditPart extends AbstractBorderedShapeEditPart {

	/**
	 * @generated
	 */
	public class PackageFigureDescriptor extends CPackageFigure {

		/**
		 * @generated
		 */
		private RectangleFigure fPackageableElementFigure;

		/**
		 * @generated
		 */
		private WrappingLabel fPackageNameLabel;

		/**
		 * @generated
		 */
		private WrappingLabel fPackageQualifiedNameLabel;

		/**
		 * @generated
		 */
		private WrappingLabel fStereotypesLabel;

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = false;

		/**
		 * @generated
		 */
		public PackageFigureDescriptor() {

			this.setForegroundColor(THIS_FORE);
			this.setBackgroundColor(THIS_BACK);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fStereotypesLabel = new WrappingLabel();
			fStereotypesLabel.setText("");

			fStereotypesLabel.setFont(FSTEREOTYPESLABEL_FONT);

			this.add(fStereotypesLabel);

			fPackageNameLabel = new WrappingLabel();
			fPackageNameLabel.setText("");

			fPackageNameLabel.setFont(FPACKAGENAMELABEL_FONT);

			this.add(fPackageNameLabel);

			fPackageQualifiedNameLabel = new WrappingLabel();
			fPackageQualifiedNameLabel.setText("");

			fPackageQualifiedNameLabel.setFont(FPACKAGEQUALIFIEDNAMELABEL_FONT);

			this.add(fPackageQualifiedNameLabel);

			fPackageableElementFigure = new RectangleFigure();

			this.add(fPackageableElementFigure);

		}

		/**
		 * @generated
		 */
		public RectangleFigure getPackageableElementFigure() {
			return fPackageableElementFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getPackageNameLabel() {
			return fPackageNameLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getPackageQualifiedNameLabel() {
			return fPackageQualifiedNameLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getStereotypesLabel() {
			return fStereotypesLabel;
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
	static final Font FPACKAGENAMELABEL_FONT = new Font(Display.getCurrent(), "Arial", 10, SWT.BOLD);

	/**
	 * @generated
	 */
	static final Font FPACKAGEQUALIFIEDNAMELABEL_FONT = new Font(Display.getCurrent(), "Arial", 8, SWT.ITALIC);

	/**
	 * @generated
	 */
	static final Font FSTEREOTYPESLABEL_FONT = new Font(Display.getCurrent(), "Arial", 8, SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 255, 199, 143);

	/**
	 * @generated
	 */
	static final Color THIS_FORE = new Color(null, 233, 164, 96);

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3024;

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
	public Model3EditPart(View view) {
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
		if (childEditPart instanceof ModelName3EditPart) {
			((ModelName3EditPart) childEditPart).setLabel(getPrimaryShape().getStereotypesLabel());
			return true;
		}
		if (childEditPart instanceof ModelName4EditPart) {
			((ModelName4EditPart) childEditPart).setLabel(getPrimaryShape().getPackageNameLabel());
			return true;
		}
		if (childEditPart instanceof ModelQualifiedName2EditPart) {
			((ModelQualifiedName2EditPart) childEditPart).setLabel(getPrimaryShape().getPackageQualifiedNameLabel());
			return true;
		}
		if (childEditPart instanceof ModelPackageableElementCompartment2EditPart) {
			IFigure pane = getPrimaryShape().getPackageableElementFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
			pane.add(((ModelPackageableElementCompartment2EditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof RedefinableTemplateSignatureEditPart) {
			// BorderItemLocator locator = new BorderItemLocator(getMainFigure(), PositionConstants.NORTH);
			BorderItemLocator locator = new TemplateBorderItemLocator(getMainFigure(), PositionConstants.NORTH);

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
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new Model3ItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());

		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new RemoveOrphanNodeViewPolicy());
		installEditPolicy("canonicalConnection", new RemoveOphanConnectionViewClazzPolicy());

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
		DefaultSizeNodeFigure result = new PackageNodeFigure(getMapMode().DPtoLP(40), getMapMode().DPtoLP(40));
		return result;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		PackageFigureDescriptor figure = new PackageFigureDescriptor();
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

		if (editPart instanceof ModelPackageableElementCompartment2EditPart) {
			return getPrimaryShape().getPackageableElementFigure();
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(ModelName3EditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public PackageFigureDescriptor getPrimaryShape() {
		return (PackageFigureDescriptor) primaryShape;
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

		if (childEditPart instanceof ModelPackageableElementCompartment2EditPart) {
			IFigure pane = getPrimaryShape().getPackageableElementFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
			pane.remove(((ModelPackageableElementCompartment2EditPart) childEditPart).getFigure());
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
