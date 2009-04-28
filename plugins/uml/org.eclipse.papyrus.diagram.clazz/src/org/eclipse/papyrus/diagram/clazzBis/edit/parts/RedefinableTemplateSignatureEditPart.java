package org.eclipse.papyrus.diagram.clazzBis.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class RedefinableTemplateSignatureEditPart extends AbstractBorderItemEditPart {

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
	public RedefinableTemplateSignatureEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, getPrimaryDragEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new org.eclipse.papyrus.diagram.clazzBis.edit.policies.RedefinableTemplateSignatureItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new org.eclipse.papyrus.diagram.clazzBis.edit.policies.OpenDiagramEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 *Papyrus codeGen
	 *@generated
	 **/
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);

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
		TemplateSignatureDescriptor figure = new TemplateSignatureDescriptor();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public TemplateSignatureDescriptor getPrimaryShape() {
		return (TemplateSignatureDescriptor) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureTemplateParameterCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getTemplateParameterRectangle();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureTemplateParameterCompartmentEditPart) childEditPart).getFigure());
			return true;
		}

		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureTemplateParameterCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getTemplateParameterRectangle();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureTemplateParameterCompartmentEditPart) childEditPart).getFigure());
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

		if (editPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureTemplateParameterCompartmentEditPart) {
			return getPrimaryShape().getTemplateParameterRectangle();
		}

		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {

		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);

		//FIXME: workaround for #154536
		result.getBounds().setSize(result.getPreferredSize());
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
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
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * @param nodeShape instance of generated figure class
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
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSource() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForTarget(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_1001);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_1002);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_1003);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_1004);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_1005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_1006);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_1007);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_1008);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_1009);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_1010);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_1011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_1012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_1013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_1014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.RedefinableTemplateSignature_2005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_2011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_2012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_2013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_2014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_2015);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_2016);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_2018);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2019);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_2024);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_2025);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_2029);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_1001);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_1002);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_1003);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_1004);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_1005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_1006);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_1007);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_1008);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_1009);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_1010);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_1011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_1012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_1013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_1014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.RedefinableTemplateSignature_2005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_2011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_2012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_2013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_2014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_2015);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_2016);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_2018);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2019);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_2024);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_2025);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_2029);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_1001);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_1002);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_1003);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_1004);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_1005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_1006);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_1007);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_1008);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_1009);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_1010);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_1011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_1012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_1013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_1014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.RedefinableTemplateSignature_2005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_2011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_2012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_2013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_2014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_2015);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_2016);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_2018);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2019);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_2024);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_2025);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_2029);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_1001);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_1002);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_1003);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_1004);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_1005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_1006);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_1007);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_1008);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_1009);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_1010);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_1011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_1012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_1013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_1014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.RedefinableTemplateSignature_2005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_2011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_2012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_2013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_2014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_2015);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_2016);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_2018);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2019);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_2024);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_2025);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_2029);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_1001);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_1002);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_1003);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_1004);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_1005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_1006);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_1007);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_1008);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_1009);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_1010);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_1011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_1012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_1013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_1014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.RedefinableTemplateSignature_2005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_2011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_2012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_2013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_2014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_2015);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_2016);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_2018);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2019);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_2024);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_2025);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_2029);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.CommentAnnotatedElement_3017);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ConstraintConstrainedElement_3018);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForSource(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_1001);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_1002);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_1003);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_1004);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_1005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_1006);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_1007);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_1008);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_1009);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_1010);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_1011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_1012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_1013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_1014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.RedefinableTemplateSignature_2005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_2011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_2012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_2013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_2014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_2015);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_2016);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_2018);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2019);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_2024);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_2025);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_2029);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_1001);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_1002);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_1003);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_1004);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_1005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_1006);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_1007);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_1008);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_1009);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_1010);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_1011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_1012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_1013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_1014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.RedefinableTemplateSignature_2005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_2011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_2012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_2013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_2014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_2015);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_2016);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_2018);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2019);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_2024);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_2025);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_2029);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_1001);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_1002);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_1003);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_1004);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_1005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_1006);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_1007);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_1008);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_1009);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_1010);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_1011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_1012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_1013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_1014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.RedefinableTemplateSignature_2005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_2011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_2012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_2013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_2014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_2015);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_2016);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_2018);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2019);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_2024);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_2025);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_2029);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_1001);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_1002);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_1003);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_1004);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_1005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_1006);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_1007);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_1008);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_1009);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_1010);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_1011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_1012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_1013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_1014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.RedefinableTemplateSignature_2005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_2011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_2012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_2013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_2014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_2015);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_2016);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_2018);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2019);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_2024);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_2025);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_2029);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_1001);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_1002);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_1003);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_1004);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_1005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_1006);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_1007);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_1008);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_1009);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_1010);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_1011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_1012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_1013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_1014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.RedefinableTemplateSignature_2005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_2011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_2012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_2013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_2014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_2015);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_2016);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_2018);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2019);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_2024);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_2025);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_2029);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.CommentAnnotatedElement_3017) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Comment_1015);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.CommentAnnotatedElement_3017) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Comment_2028);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ConstraintConstrainedElement_3018) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_1014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ConstraintConstrainedElement_3018) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_2029);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_1002);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_1003);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_1005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_1006);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_1007);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_1008);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_1009);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_1010);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_1011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_1012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_1013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_2012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_2013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_2014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_2015);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_2016);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_2018);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2019);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_2024);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_2025);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor().getCreateElementRequestAdapter();
			IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
			if (type == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateParameter_2006) {
				return getChildBySemanticHint(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureTemplateParameterCompartmentEditPart.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
	}

	/**
	 * @generated
	 */
	public class TemplateSignatureDescriptor extends RectangleFigure {

		/**
		 * @generated
		 */
		private RectangleFigure fTemplateParameterRectangle;

		/**
		 * @generated
		 */
		public TemplateSignatureDescriptor() {
			this.setLineWidth(1);
			this.setSize(getMapMode().DPtoLP(100), getMapMode().DPtoLP(60));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fTemplateParameterRectangle = new RectangleFigure();
			fTemplateParameterRectangle.setLineWidth(1);

			this.add(fTemplateParameterRectangle);
			fTemplateParameterRectangle.setLayoutManager(new StackLayout());

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
		public RectangleFigure getTemplateParameterRectangle() {
			return fTemplateParameterRectangle;
		}

	}

}
