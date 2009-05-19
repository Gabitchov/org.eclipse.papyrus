/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.usecase.edit.policies.UMLTextSelectionEditPolicy;
import org.eclipse.papyrus.diagram.usecase.edit.policies.UseCase2ItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.usecase.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.usecase.providers.UMLElementTypes;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.diagram.common.draw2d.CenterLayout;

/**
 * @generated
 */
public class UseCase2EditPart extends

ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2005;

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
	public UseCase2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new UseCase2ItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {

		ConstrainedToolbarLayoutEditPolicy lep = new ConstrainedToolbarLayoutEditPolicy() {
			protected EditPolicy createChildEditPolicy(EditPart child) {
				if (child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE) == null) {
					if (child instanceof ITextAwareEditPart) {
						return new UMLTextSelectionEditPolicy();
					}
				}
				return super.createChildEditPolicy(child);
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		UseCaseAsClassFigure figure = new UseCaseAsClassFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public UseCaseAsClassFigure getPrimaryShape() {
		return (UseCaseAsClassFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof UseCaseName2EditPart) {
			((UseCaseName2EditPart) childEditPart).setLabel(getPrimaryShape()
					.getUseCaseAsClassFigure_name());
			return true;
		}

		if (childEditPart instanceof UseCaseExtensionpointsEditPart) {
			IFigure pane = getPrimaryShape().getUseCaseAsClass_points();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((UseCaseExtensionpointsEditPart) childEditPart)
					.getFigure());
			return true;
		}

		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof UseCaseName2EditPart) {
			return true;
		}

		if (childEditPart instanceof UseCaseExtensionpointsEditPart) {
			IFigure pane = getPrimaryShape().getUseCaseAsClass_points();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((UseCaseExtensionpointsEditPart) childEditPart)
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

		if (editPart instanceof UseCaseExtensionpointsEditPart) {
			return getPrimaryShape().getUseCaseAsClass_points();
		}

		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {

		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(100, 60);

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
			layout.setSpacing(5);
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
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(UMLVisualIDRegistry
				.getType(UseCaseName2EditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSource() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.Include_4001);
		types.add(UMLElementTypes.Extend_4002);
		types.add(UMLElementTypes.Generalization_4003);
		types.add(UMLElementTypes.Association_4004);
		types.add(UMLElementTypes.Dependency_4006);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (targetEditPart instanceof UseCaseEditPart) {
			types.add(UMLElementTypes.Include_4001);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.usecase.edit.parts.UseCase2EditPart) {
			types.add(UMLElementTypes.Include_4001);
		}
		if (targetEditPart instanceof UseCase3EditPart) {
			types.add(UMLElementTypes.Include_4001);
		}
		if (targetEditPart instanceof UseCase4EditPart) {
			types.add(UMLElementTypes.Include_4001);
		}
		if (targetEditPart instanceof UseCaseEditPart) {
			types.add(UMLElementTypes.Extend_4002);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.usecase.edit.parts.UseCase2EditPart) {
			types.add(UMLElementTypes.Extend_4002);
		}
		if (targetEditPart instanceof UseCase3EditPart) {
			types.add(UMLElementTypes.Extend_4002);
		}
		if (targetEditPart instanceof UseCase4EditPart) {
			types.add(UMLElementTypes.Extend_4002);
		}
		if (targetEditPart instanceof ActorEditPart) {
			types.add(UMLElementTypes.Generalization_4003);
		}
		if (targetEditPart instanceof Actor2EditPart) {
			types.add(UMLElementTypes.Generalization_4003);
		}
		if (targetEditPart instanceof UseCaseEditPart) {
			types.add(UMLElementTypes.Generalization_4003);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.usecase.edit.parts.UseCase2EditPart) {
			types.add(UMLElementTypes.Generalization_4003);
		}
		if (targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Generalization_4003);
		}
		if (targetEditPart instanceof UseCase3EditPart) {
			types.add(UMLElementTypes.Generalization_4003);
		}
		if (targetEditPart instanceof Actor3EditPart) {
			types.add(UMLElementTypes.Generalization_4003);
		}
		if (targetEditPart instanceof UseCase4EditPart) {
			types.add(UMLElementTypes.Generalization_4003);
		}
		if (targetEditPart instanceof ActorEditPart) {
			types.add(UMLElementTypes.Association_4004);
		}
		if (targetEditPart instanceof Actor2EditPart) {
			types.add(UMLElementTypes.Association_4004);
		}
		if (targetEditPart instanceof UseCaseEditPart) {
			types.add(UMLElementTypes.Association_4004);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.usecase.edit.parts.UseCase2EditPart) {
			types.add(UMLElementTypes.Association_4004);
		}
		if (targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Association_4004);
		}
		if (targetEditPart instanceof UseCase3EditPart) {
			types.add(UMLElementTypes.Association_4004);
		}
		if (targetEditPart instanceof Actor3EditPart) {
			types.add(UMLElementTypes.Association_4004);
		}
		if (targetEditPart instanceof UseCase4EditPart) {
			types.add(UMLElementTypes.Association_4004);
		}
		if (targetEditPart instanceof ActorEditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof Actor2EditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof UseCaseEditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.usecase.edit.parts.UseCase2EditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof Package3EditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof UseCase3EditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof Actor3EditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		if (targetEditPart instanceof UseCase4EditPart) {
			types.add(UMLElementTypes.Dependency_4006);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForTarget(
			IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == UMLElementTypes.Include_4001) {
			types.add(UMLElementTypes.UseCase_2004);
		}
		if (relationshipType == UMLElementTypes.Include_4001) {
			types.add(UMLElementTypes.UseCase_2005);
		}
		if (relationshipType == UMLElementTypes.Include_4001) {
			types.add(UMLElementTypes.UseCase_3004);
		}
		if (relationshipType == UMLElementTypes.Include_4001) {
			types.add(UMLElementTypes.UseCase_3006);
		}
		if (relationshipType == UMLElementTypes.Extend_4002) {
			types.add(UMLElementTypes.UseCase_2004);
		}
		if (relationshipType == UMLElementTypes.Extend_4002) {
			types.add(UMLElementTypes.UseCase_2005);
		}
		if (relationshipType == UMLElementTypes.Extend_4002) {
			types.add(UMLElementTypes.UseCase_3004);
		}
		if (relationshipType == UMLElementTypes.Extend_4002) {
			types.add(UMLElementTypes.UseCase_3006);
		}
		if (relationshipType == UMLElementTypes.Generalization_4003) {
			types.add(UMLElementTypes.Actor_2002);
		}
		if (relationshipType == UMLElementTypes.Generalization_4003) {
			types.add(UMLElementTypes.Actor_2003);
		}
		if (relationshipType == UMLElementTypes.Generalization_4003) {
			types.add(UMLElementTypes.UseCase_2004);
		}
		if (relationshipType == UMLElementTypes.Generalization_4003) {
			types.add(UMLElementTypes.UseCase_2005);
		}
		if (relationshipType == UMLElementTypes.Generalization_4003) {
			types.add(UMLElementTypes.Component_2006);
		}
		if (relationshipType == UMLElementTypes.Generalization_4003) {
			types.add(UMLElementTypes.UseCase_3004);
		}
		if (relationshipType == UMLElementTypes.Generalization_4003) {
			types.add(UMLElementTypes.Actor_3005);
		}
		if (relationshipType == UMLElementTypes.Generalization_4003) {
			types.add(UMLElementTypes.UseCase_3006);
		}
		if (relationshipType == UMLElementTypes.Association_4004) {
			types.add(UMLElementTypes.Actor_2002);
		}
		if (relationshipType == UMLElementTypes.Association_4004) {
			types.add(UMLElementTypes.Actor_2003);
		}
		if (relationshipType == UMLElementTypes.Association_4004) {
			types.add(UMLElementTypes.UseCase_2004);
		}
		if (relationshipType == UMLElementTypes.Association_4004) {
			types.add(UMLElementTypes.UseCase_2005);
		}
		if (relationshipType == UMLElementTypes.Association_4004) {
			types.add(UMLElementTypes.Component_2006);
		}
		if (relationshipType == UMLElementTypes.Association_4004) {
			types.add(UMLElementTypes.UseCase_3004);
		}
		if (relationshipType == UMLElementTypes.Association_4004) {
			types.add(UMLElementTypes.Actor_3005);
		}
		if (relationshipType == UMLElementTypes.Association_4004) {
			types.add(UMLElementTypes.UseCase_3006);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Actor_2002);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Actor_2003);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.UseCase_2004);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.UseCase_2005);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Component_2006);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Package_2009);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Constraint_2008);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.UseCase_3004);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Actor_3005);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.UseCase_3006);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.Include_4001);
		types.add(UMLElementTypes.Extend_4002);
		types.add(UMLElementTypes.Generalization_4003);
		types.add(UMLElementTypes.Association_4004);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4005);
		types.add(UMLElementTypes.Dependency_4006);
		types.add(UMLElementTypes.CommentAnnotatedElement_4007);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForSource(
			IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == UMLElementTypes.Include_4001) {
			types.add(UMLElementTypes.UseCase_2004);
		}
		if (relationshipType == UMLElementTypes.Include_4001) {
			types.add(UMLElementTypes.UseCase_2005);
		}
		if (relationshipType == UMLElementTypes.Include_4001) {
			types.add(UMLElementTypes.UseCase_3004);
		}
		if (relationshipType == UMLElementTypes.Include_4001) {
			types.add(UMLElementTypes.UseCase_3006);
		}
		if (relationshipType == UMLElementTypes.Extend_4002) {
			types.add(UMLElementTypes.UseCase_2004);
		}
		if (relationshipType == UMLElementTypes.Extend_4002) {
			types.add(UMLElementTypes.UseCase_2005);
		}
		if (relationshipType == UMLElementTypes.Extend_4002) {
			types.add(UMLElementTypes.UseCase_3004);
		}
		if (relationshipType == UMLElementTypes.Extend_4002) {
			types.add(UMLElementTypes.UseCase_3006);
		}
		if (relationshipType == UMLElementTypes.Generalization_4003) {
			types.add(UMLElementTypes.Actor_2002);
		}
		if (relationshipType == UMLElementTypes.Generalization_4003) {
			types.add(UMLElementTypes.Actor_2003);
		}
		if (relationshipType == UMLElementTypes.Generalization_4003) {
			types.add(UMLElementTypes.UseCase_2004);
		}
		if (relationshipType == UMLElementTypes.Generalization_4003) {
			types.add(UMLElementTypes.UseCase_2005);
		}
		if (relationshipType == UMLElementTypes.Generalization_4003) {
			types.add(UMLElementTypes.Component_2006);
		}
		if (relationshipType == UMLElementTypes.Generalization_4003) {
			types.add(UMLElementTypes.UseCase_3004);
		}
		if (relationshipType == UMLElementTypes.Generalization_4003) {
			types.add(UMLElementTypes.Actor_3005);
		}
		if (relationshipType == UMLElementTypes.Generalization_4003) {
			types.add(UMLElementTypes.UseCase_3006);
		}
		if (relationshipType == UMLElementTypes.Association_4004) {
			types.add(UMLElementTypes.Actor_2002);
		}
		if (relationshipType == UMLElementTypes.Association_4004) {
			types.add(UMLElementTypes.Actor_2003);
		}
		if (relationshipType == UMLElementTypes.Association_4004) {
			types.add(UMLElementTypes.UseCase_2004);
		}
		if (relationshipType == UMLElementTypes.Association_4004) {
			types.add(UMLElementTypes.UseCase_2005);
		}
		if (relationshipType == UMLElementTypes.Association_4004) {
			types.add(UMLElementTypes.Component_2006);
		}
		if (relationshipType == UMLElementTypes.Association_4004) {
			types.add(UMLElementTypes.UseCase_3004);
		}
		if (relationshipType == UMLElementTypes.Association_4004) {
			types.add(UMLElementTypes.Actor_3005);
		}
		if (relationshipType == UMLElementTypes.Association_4004) {
			types.add(UMLElementTypes.UseCase_3006);
		}
		if (relationshipType == UMLElementTypes.ConstraintConstrainedElement_4005) {
			types.add(UMLElementTypes.Constraint_2008);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Actor_2002);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Actor_2003);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.UseCase_2004);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.UseCase_2005);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Component_2006);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Package_2009);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Constraint_2008);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.UseCase_3004);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.Actor_3005);
		}
		if (relationshipType == UMLElementTypes.Dependency_4006) {
			types.add(UMLElementTypes.UseCase_3006);
		}
		if (relationshipType == UMLElementTypes.CommentAnnotatedElement_4007) {
			types.add(UMLElementTypes.Comment_2010);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request)
					.getViewAndElementDescriptor()
					.getCreateElementRequestAdapter();
			IElementType type = (IElementType) adapter
					.getAdapter(IElementType.class);
			if (type == UMLElementTypes.ExtensionPoint_3003) {
				return getChildBySemanticHint(UMLVisualIDRegistry
						.getType(UseCaseExtensionpointsEditPart.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
	}

	/**
	 * @generated
	 */
	public class UseCaseAsClassFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fUseCaseAsClassFigure_stereo;

		/**
		 * @generated
		 */
		private WrappingLabel fUseCaseAsClassFigure_name;

		/**
		 * @generated
		 */
		private RectangleFigure fUseCaseAsClass_points;

		/**
		 * @generated
		 */
		public UseCaseAsClassFigure() {

			ToolbarLayout layoutThis = new ToolbarLayout();
			layoutThis.setStretchMinorAxis(true);
			layoutThis.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);

			layoutThis.setSpacing(0);
			layoutThis.setVertical(true);

			this.setLayoutManager(layoutThis);

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			RectangleFigure useCaseAsClassFigure_Header0 = new RectangleFigure();
			useCaseAsClassFigure_Header0.setBorder(new LineBorder(null,
					getMapMode().DPtoLP(1)));

			this.add(useCaseAsClassFigure_Header0);

			ToolbarLayout layoutUseCaseAsClassFigure_Header0 = new ToolbarLayout();
			layoutUseCaseAsClassFigure_Header0.setStretchMinorAxis(true);
			layoutUseCaseAsClassFigure_Header0
					.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);

			layoutUseCaseAsClassFigure_Header0.setSpacing(0);
			layoutUseCaseAsClassFigure_Header0.setVertical(true);

			useCaseAsClassFigure_Header0
					.setLayoutManager(layoutUseCaseAsClassFigure_Header0);

			RectangleFigure useCaseAsClassFigure_StereoContainer1 = new RectangleFigure();
			useCaseAsClassFigure_StereoContainer1.setOutline(false);

			useCaseAsClassFigure_Header0
					.add(useCaseAsClassFigure_StereoContainer1);

			CenterLayout layoutUseCaseAsClassFigure_StereoContainer1 = new CenterLayout();

			useCaseAsClassFigure_StereoContainer1
					.setLayoutManager(layoutUseCaseAsClassFigure_StereoContainer1);

			fUseCaseAsClassFigure_stereo = new WrappingLabel();
			fUseCaseAsClassFigure_stereo.setText("");

			fUseCaseAsClassFigure_stereo
					.setFont(FUSECASEASCLASSFIGURE_STEREO_FONT);

			fUseCaseAsClassFigure_stereo.setBorder(new MarginBorder(
					getMapMode().DPtoLP(5), getMapMode().DPtoLP(5),
					getMapMode().DPtoLP(0), getMapMode().DPtoLP(5)));

			useCaseAsClassFigure_StereoContainer1
					.add(fUseCaseAsClassFigure_stereo);

			RectangleFigure useCaseAsClassFigure_NameContainer1 = new RectangleFigure();
			useCaseAsClassFigure_NameContainer1.setOutline(false);

			useCaseAsClassFigure_Header0
					.add(useCaseAsClassFigure_NameContainer1);

			CenterLayout layoutUseCaseAsClassFigure_NameContainer1 = new CenterLayout();

			useCaseAsClassFigure_NameContainer1
					.setLayoutManager(layoutUseCaseAsClassFigure_NameContainer1);

			fUseCaseAsClassFigure_name = new WrappingLabel();
			fUseCaseAsClassFigure_name.setText("");

			fUseCaseAsClassFigure_name.setFont(FUSECASEASCLASSFIGURE_NAME_FONT);

			fUseCaseAsClassFigure_name.setBorder(new MarginBorder(getMapMode()
					.DPtoLP(0), getMapMode().DPtoLP(5), getMapMode().DPtoLP(5),
					getMapMode().DPtoLP(5)));

			useCaseAsClassFigure_NameContainer1.add(fUseCaseAsClassFigure_name);

			fUseCaseAsClass_points = new RectangleFigure();

			this.add(fUseCaseAsClass_points);
			fUseCaseAsClass_points.setLayoutManager(new StackLayout());

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
		public WrappingLabel getUseCaseAsClassFigure_stereo() {
			return fUseCaseAsClassFigure_stereo;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getUseCaseAsClassFigure_name() {
			return fUseCaseAsClassFigure_name;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getUseCaseAsClass_points() {
			return fUseCaseAsClass_points;
		}

	}

	/**
	 * @generated
	 */
	static final Font FUSECASEASCLASSFIGURE_STEREO_FONT = new Font(Display
			.getCurrent(),
			Display.getDefault().getSystemFont().getFontData()[0].getName(), 9,
			SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Font FUSECASEASCLASSFIGURE_NAME_FONT = new Font(Display
			.getCurrent(),
			Display.getDefault().getSystemFont().getFontData()[0].getName(), 9,
			SWT.NORMAL);

}
