package org.eclipse.papyrus.diagram.clazzBis.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
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
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
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
import org.eclipse.papyrus.diagram.common.editparts.NamedElementEditPart;
import org.eclipse.papyrus.diagram.common.editpolicies.BorderItemResizableEditPolicy;
import org.eclipse.papyrus.diagram.common.figure.node.CClassifierFigure;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

/**
 * @generated
 */
public class InterfaceEditPart extends NamedElementEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 1007;

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
	public InterfaceEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new org.eclipse.papyrus.diagram.clazzBis.edit.policies.InterfaceItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());

		//in Papyrus diagrams are not strongly synchronised
		//installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CANONICAL_ROLE, new org.eclipse.papyrus.diagram.clazzBis.edit.policies.InterfaceCanonicalEditPolicy());

		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
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
				View childView = (View) child.getModel();
				switch (org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getVisualID(childView)) {
				case org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart.VISUAL_ID:

					//done in GMF gen code
					//return new org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy();
					//done in papyrus gencode to have borderItem resizeable
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
	 * @generated
	 */
	protected IFigure createNodeShape() {
		ClassifierDescriptor figure = new ClassifierDescriptor();
		return primaryShape = figure;
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
	protected boolean addFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceName2EditPart) {
			((org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceName2EditPart) childEditPart).setLabel(getPrimaryShape().getClassifierNameLabel());
			return true;
		}

		if (childEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceQualifiedNameEditPart) {
			((org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceQualifiedNameEditPart) childEditPart).setLabel(getPrimaryShape().getClassifierQualifiedNameLabel());
			return true;
		}

		if (childEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceNameEditPart) {
			((org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceNameEditPart) childEditPart).setLabel(getPrimaryShape().getClassifierStereotypeLabel());
			return true;
		}

		if (childEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceAttributeCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getAttributeCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceAttributeCompartmentEditPart) childEditPart).getFigure());
			return true;
		}

		if (childEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceOperationCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getOperationCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceOperationCompartmentEditPart) childEditPart).getFigure());
			return true;
		}

		if (childEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceNestedClassifierCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getNestedClassifierFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceNestedClassifierCompartmentEditPart) childEditPart).getFigure());
			return true;
		}

		if (childEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart) {
			BorderItemLocator locator = new BorderItemLocator(getMainFigure(), PositionConstants.NORTH);
			getBorderedFigure().getBorderItemContainer().add(((org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart) childEditPart).getFigure(), locator);
			return true;
		}

		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceName2EditPart) {
			return true;
		}
		if (childEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceQualifiedNameEditPart) {
			return true;
		}
		if (childEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceNameEditPart) {
			return true;
		}

		if (childEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceAttributeCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getAttributeCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceAttributeCompartmentEditPart) childEditPart).getFigure());
			return true;
		}

		if (childEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceOperationCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getOperationCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceOperationCompartmentEditPart) childEditPart).getFigure());
			return true;
		}

		if (childEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceNestedClassifierCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getNestedClassifierFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceNestedClassifierCompartmentEditPart) childEditPart).getFigure());
			return true;
		}

		if (childEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart) childEditPart).getFigure());
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

		if (editPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceAttributeCompartmentEditPart) {
			return getPrimaryShape().getAttributeCompartmentFigure();
		}

		if (editPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceOperationCompartmentEditPart) {
			return getPrimaryShape().getOperationCompartmentFigure();
		}

		if (editPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceNestedClassifierCompartmentEditPart) {
			return getPrimaryShape().getNestedClassifierFigure();
		}

		if (editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}

		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {

		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);

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
	protected NodeFigure createMainFigure() {
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
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSource() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PackageImport_3014);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007);
		}
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
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PackageImport_3014);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PackageImport_3014);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PackageImport_3014);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PackageImport_3014);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DependencyEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationClassEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecificationEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ComponentEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.SignalEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ModelEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.EnumerationEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ClassEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveTypeEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataTypeEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.ConstraintEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.CommentEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.SlotEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.RedefinableTemplateSignatureEditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.InstanceSpecification2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Component2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Signal2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Interface2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Model2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Enumeration2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Package3EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Class4EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.PrimitiveType2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.DataType2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Comment2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.Constraint2EditPart) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForTarget(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_1002);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_1003);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_1005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_1006);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_1007);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_1009);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_1011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_1012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_1013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_2012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_2013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_2014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_2016);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2019);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_2024);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_2025);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_1002);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_1003);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_1005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_1006);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_1007);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_1009);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_1011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_1012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_1013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_2012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_2013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_2014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_2016);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2019);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_2024);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_2025);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_1002);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_1003);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_1005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_1006);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_1007);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_1009);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_1011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_1012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_1013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_2012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_2013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_2014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_2016);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2019);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_2024);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_2025);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_1002);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_1003);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_1005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_1006);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_1007);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_1009);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_1011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_1012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_1013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_2012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_2013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_2014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_2016);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2019);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_2024);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_2025);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_1002);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_1003);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_1005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_1006);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_1007);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_1009);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_1011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_1012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_1013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_2012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_2013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_2014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_2016);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2019);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_2024);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_2025);
		}
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
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_1001);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_1002);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_1003);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_1004);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_1005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_1006);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_1007);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_1008);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_1009);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_1010);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_1011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_1012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_1013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_1014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_2011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_2012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_2013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_2014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_2015);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_2016);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_2018);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2019);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_2024);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_2025);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_2029);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PackageImport_3014) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_1008);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PackageImport_3014) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_1010);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PackageImport_3014) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_2015);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PackageImport_3014) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_2018);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_1001);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_1002);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_1003);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_1004);
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
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_1014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Comment_1015);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Slot_2002);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.RedefinableTemplateSignature_2005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InstanceSpecification_2011);
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
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Comment_2028);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.TemplateBinding_3019) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Constraint_2029);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InterfaceRealization_3006);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Realization_3008);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Abstraction_3009);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Usage_3010);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3011);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Dependency_3012);
		types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013);
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
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_1002);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_1003);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_1005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_1006);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_1007);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_1009);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_1011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_1012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_1013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_2012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_2013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_2014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_2016);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2019);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_2024);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_3002) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_2025);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_1002);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_1003);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_1005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_1006);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_1007);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_1009);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_1011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_1012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_1013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_2012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_2013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_2014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_2016);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2019);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_2024);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3003) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_2025);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_1002);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_1003);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_1005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_1006);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_1007);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_1009);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_1011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_1012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_1013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_2012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_2013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_2014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_2016);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2019);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_2024);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_3004) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_2025);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_1002);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_1003);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_1005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_1006);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_1007);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_1009);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_1011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_1012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_1013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_2012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_2013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_2014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_2016);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2019);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_2024);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Generalization_3005) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_2025);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InterfaceRealization_3006) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_1002);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InterfaceRealization_3006) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_1005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InterfaceRealization_3006) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_1011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InterfaceRealization_3006) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_2012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.InterfaceRealization_3006) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2019);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_1002);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_1003);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_1005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_1006);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_1007);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_1009);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_1011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_1012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_1013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_2012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_2013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_2014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_2016);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2019);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_2024);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Substitution_3007) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_2025);
		}
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
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.AssociationClass_1002);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Association_1003);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_1005);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_1006);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_1007);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_1008);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_1009);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_1010);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_1011);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_1012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_1013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Component_2012);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Signal_2013);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Interface_2014);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Model_2015);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Enumeration_2016);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Package_2018);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2019);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.PrimitiveType_2024);
		}
		if (relationshipType == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.ElementImport_3013) {
			types.add(org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.DataType_2025);
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
			if (type == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Property_2008) {
				return getChildBySemanticHint(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceAttributeCompartmentEditPart.VISUAL_ID));
			}
			if (type == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Operation_2009) {
				return getChildBySemanticHint(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceOperationCompartmentEditPart.VISUAL_ID));
			}
			if (type == org.eclipse.papyrus.diagram.clazzBis.providers.UMLElementTypes.Class_2010) {
				return getChildBySemanticHint(org.eclipse.papyrus.diagram.clazzBis.part.UMLVisualIDRegistry
						.getType(org.eclipse.papyrus.diagram.clazzBis.edit.parts.InterfaceNestedClassifierCompartmentEditPart.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
	}

	/**
	 * @generated
	 */
	public class ClassifierDescriptor extends CClassifierFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fClassifierNameLabel;

		/**
		 * @generated
		 */
		private RectangleFigure fAttributeCompartmentFigure;

		/**
		 * @generated
		 */
		private RectangleFigure fOperationCompartmentFigure;

		/**
		 * @generated
		 */
		private WrappingLabel fClassifierStereotypeLabel;

		/**
		 * @generated
		 */
		private WrappingLabel fClassifierQualifiedNameLabel;

		/**
		 * @generated
		 */
		private RectangleFigure fNestedClassifierFigure;

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
			fAttributeCompartmentFigure.setLineWidth(1);

			this.add(fAttributeCompartmentFigure);
			fAttributeCompartmentFigure.setLayoutManager(new StackLayout());

			fOperationCompartmentFigure = new RectangleFigure();
			fOperationCompartmentFigure.setFill(false);
			fOperationCompartmentFigure.setLineWidth(1);

			this.add(fOperationCompartmentFigure);
			fOperationCompartmentFigure.setLayoutManager(new StackLayout());

			fNestedClassifierFigure = new RectangleFigure();
			fNestedClassifierFigure.setFill(false);
			fNestedClassifierFigure.setLineWidth(1);

			this.add(fNestedClassifierFigure);
			fNestedClassifierFigure.setLayoutManager(new StackLayout());

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
		public WrappingLabel getClassifierNameLabel() {
			return fClassifierNameLabel;
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
		public RectangleFigure getOperationCompartmentFigure() {
			return fOperationCompartmentFigure;
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
		public WrappingLabel getClassifierQualifiedNameLabel() {
			return fClassifierQualifiedNameLabel;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getNestedClassifierFigure() {
			return fNestedClassifierFigure;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_FORE = new Color(null, 177, 207, 229);

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 235, 248, 255);

	/**
	 * @generated
	 */
	static final Font FCLASSIFIERSTEREOTYPELABEL_FONT = new Font(Display.getCurrent(), "Arial", 8, SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Font FCLASSIFIERNAMELABEL_FONT = new Font(Display.getCurrent(), "Arial", 10, SWT.BOLD);

	/**
	 * @generated
	 */
	static final Font FCLASSIFIERQUALIFIEDNAMELABEL_FONT = new Font(Display.getCurrent(), "Arial", 8, SWT.ITALIC);

}
