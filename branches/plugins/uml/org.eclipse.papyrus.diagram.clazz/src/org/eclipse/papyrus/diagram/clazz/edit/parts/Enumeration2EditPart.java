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
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.policies.Enumeration2ItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.clazz.edit.policies.OpenDiagramEditPolicy;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.common.figure.node.CEnumeration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

/**
 * @generated
 */
public class Enumeration2EditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3025;

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
	public Enumeration2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new Enumeration2ItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenDiagramEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
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
	 * @generated
	 */
	protected IFigure createNodeShape() {
		EnumerationDescriptor figure = new EnumerationDescriptor();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public EnumerationDescriptor getPrimaryShape() {
		return (EnumerationDescriptor) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof AppliedStereotypeChildNodeEnumerationEditPart) {
			((AppliedStereotypeChildNodeEnumerationEditPart) childEditPart).setLabel(getPrimaryShape().getEnumerationStereotypeLabel());
			return true;
		}
		if (childEditPart instanceof EnumerationName4EditPart) {
			((EnumerationName4EditPart) childEditPart).setLabel(getPrimaryShape().getEnumerationNameLabel());
			return true;
		}
		if (childEditPart instanceof EnumerationQualifiedName2EditPart) {
			((EnumerationQualifiedName2EditPart) childEditPart).setLabel(getPrimaryShape().getEnumerationQualifiedNameLabel());
			return true;
		}
		if (childEditPart instanceof EnumerationEnumerationLiteralCompartment2EditPart) {
			IFigure pane = getPrimaryShape().getEnumerationLiteralCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
			pane.add(((EnumerationEnumerationLiteralCompartment2EditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof AppliedStereotypeChildNodeEnumerationEditPart) {
			return true;
		}
		if (childEditPart instanceof EnumerationName4EditPart) {
			return true;
		}
		if (childEditPart instanceof EnumerationQualifiedName2EditPart) {
			return true;
		}
		if (childEditPart instanceof EnumerationEnumerationLiteralCompartment2EditPart) {
			IFigure pane = getPrimaryShape().getEnumerationLiteralCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way
			pane.remove(((EnumerationEnumerationLiteralCompartment2EditPart) childEditPart).getFigure());
			return true;
		}
		return false;
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
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof EnumerationEnumerationLiteralCompartment2EditPart) {
			return getPrimaryShape().getEnumerationLiteralCompartmentFigure();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode().DPtoLP(40), getMapMode().DPtoLP(40));
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
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
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(AppliedStereotypeChildNodeEnumerationEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class EnumerationDescriptor extends CEnumeration {

		/**
		 * @generated
		 */
		private WrappingLabel fEnumerationStereotypeLabel;

		/**
		 * @generated
		 */
		private WrappingLabel fEnumerationNameLabel;

		/**
		 * @generated
		 */
		private WrappingLabel fEnumerationQualifiedNameLabel;

		/**
		 * @generated
		 */
		private RectangleFigure fEnumerationLiteralCompartmentFigure;

		/**
		 * @generated
		 */
		public EnumerationDescriptor() {

			this.setForegroundColor(THIS_FORE);
			this.setBackgroundColor(THIS_BACK);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fEnumerationStereotypeLabel = new WrappingLabel();
			fEnumerationStereotypeLabel.setText("");

			fEnumerationStereotypeLabel.setFont(FENUMERATIONSTEREOTYPELABEL_FONT);

			this.add(fEnumerationStereotypeLabel);

			fEnumerationNameLabel = new WrappingLabel();
			fEnumerationNameLabel.setText("");

			fEnumerationNameLabel.setFont(FENUMERATIONNAMELABEL_FONT);

			this.add(fEnumerationNameLabel);

			fEnumerationQualifiedNameLabel = new WrappingLabel();
			fEnumerationQualifiedNameLabel.setText("");

			fEnumerationQualifiedNameLabel.setFont(FENUMERATIONQUALIFIEDNAMELABEL_FONT);

			this.add(fEnumerationQualifiedNameLabel);

			fEnumerationLiteralCompartmentFigure = new RectangleFigure();
			fEnumerationLiteralCompartmentFigure.setFill(false);

			this.add(fEnumerationLiteralCompartmentFigure);
			fEnumerationLiteralCompartmentFigure.setLayoutManager(new StackLayout());

		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = false;

		/**
		 * @generated
		 */
		protected boolean useLocalCoordinates() {
			return myUseLocalCoordinates;
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
		public WrappingLabel getEnumerationStereotypeLabel() {
			return fEnumerationStereotypeLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getEnumerationNameLabel() {
			return fEnumerationNameLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getEnumerationQualifiedNameLabel() {
			return fEnumerationQualifiedNameLabel;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getEnumerationLiteralCompartmentFigure() {
			return fEnumerationLiteralCompartmentFigure;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_FORE = new Color(null, 204, 204, 204);

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 242, 242, 242);

	/**
	 * @generated
	 */
	static final Font FENUMERATIONSTEREOTYPELABEL_FONT = new Font(Display.getCurrent(), "Arial", 8, SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Font FENUMERATIONNAMELABEL_FONT = new Font(Display.getCurrent(), "Arial", 10, SWT.BOLD);

	/**
	 * @generated
	 */
	static final Font FENUMERATIONQUALIFIEDNAMELABEL_FONT = new Font(Display.getCurrent(), "Arial", 8, SWT.ITALIC);

}
