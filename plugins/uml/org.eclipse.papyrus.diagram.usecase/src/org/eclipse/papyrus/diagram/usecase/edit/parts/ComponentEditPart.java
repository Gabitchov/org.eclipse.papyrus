/*****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.usecase.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
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
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.usecase.edit.policies.ComponentItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.usecase.part.UMLVisualIDRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.diagram.common.draw2d.CenterLayout;
import org.eclipse.uml2.diagram.common.draw2d.PileLayout;

/**
 * @generated
 */
public class ComponentEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2006;

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
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ComponentItemSemanticEditPolicy());
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
				EditPolicy result = child
						.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
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
		UseCaseSubjectFigure figure = new UseCaseSubjectFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public UseCaseSubjectFigure getPrimaryShape() {
		return (UseCaseSubjectFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ComponentNameEditPart) {
			((ComponentNameEditPart) childEditPart).setLabel(getPrimaryShape()
					.getUseCaseSubjectFigure_name());
			return true;
		}
		if (childEditPart instanceof ComponentUsecasesEditPart) {
			IFigure pane = getPrimaryShape().getUseCaseSubjectFigure_contents();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((ComponentUsecasesEditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ComponentNameEditPart) {
			return true;
		}
		if (childEditPart instanceof ComponentUsecasesEditPart) {
			IFigure pane = getPrimaryShape().getUseCaseSubjectFigure_contents();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane
					.remove(((ComponentUsecasesEditPart) childEditPart)
							.getFigure());
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
		if (editPart instanceof ComponentUsecasesEditPart) {
			return getPrimaryShape().getUseCaseSubjectFigure_contents();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode()
				.DPtoLP(200), getMapMode().DPtoLP(400));
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
		return getChildBySemanticHint(UMLVisualIDRegistry
				.getType(ComponentNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class UseCaseSubjectFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private RectangleFigure fUseCaseSubjectFigure_contents;

		/**
		 * @generated
		 */
		private WrappingLabel fUseCaseSubjectFigure_name;

		/**
		 * @generated
		 */
		public UseCaseSubjectFigure() {

			PileLayout layoutThis = new PileLayout();

			layoutThis.setStretchBottom(true);

			this.setLayoutManager(layoutThis);

			this.setBackgroundColor(THIS_BACK);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			RectangleFigure useCaseSubjectFigure_header0 = new RectangleFigure();

			this.add(useCaseSubjectFigure_header0);

			CenterLayout layoutUseCaseSubjectFigure_header0 = new CenterLayout();

			useCaseSubjectFigure_header0
					.setLayoutManager(layoutUseCaseSubjectFigure_header0);

			fUseCaseSubjectFigure_name = new WrappingLabel();
			fUseCaseSubjectFigure_name.setText("");

			fUseCaseSubjectFigure_name.setFont(FUSECASESUBJECTFIGURE_NAME_FONT);

			fUseCaseSubjectFigure_name.setBorder(new MarginBorder(getMapMode()
					.DPtoLP(0), getMapMode().DPtoLP(5), getMapMode().DPtoLP(5),
					getMapMode().DPtoLP(5)));

			useCaseSubjectFigure_header0.add(fUseCaseSubjectFigure_name);

			fUseCaseSubjectFigure_contents = new RectangleFigure();

			this.add(fUseCaseSubjectFigure_contents);
			fUseCaseSubjectFigure_contents.setLayoutManager(new StackLayout());

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
		public RectangleFigure getUseCaseSubjectFigure_contents() {
			return fUseCaseSubjectFigure_contents;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getUseCaseSubjectFigure_name() {
			return fUseCaseSubjectFigure_name;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 245, 245, 245);

	/**
	 * @generated
	 */
	static final Font FUSECASESUBJECTFIGURE_NAME_FONT = new Font(Display
			.getCurrent(),
			Display.getDefault().getSystemFont().getFontData()[0].getName(), 9,
			SWT.NORMAL);

}
