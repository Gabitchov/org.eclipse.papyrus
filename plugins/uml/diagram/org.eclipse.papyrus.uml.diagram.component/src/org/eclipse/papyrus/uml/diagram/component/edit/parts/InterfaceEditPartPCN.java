package org.eclipse.papyrus.uml.diagram.component.edit.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.infra.gmfdiag.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.uml.diagram.common.locator.ExternalLabelPositionLocator;
import org.eclipse.papyrus.uml.diagram.component.custom.edit.policies.CustomDiagramDragDropEditPolicy;
import org.eclipse.papyrus.uml.diagram.component.custom.edit.policies.RemoveOrphanViewPolicy;
import org.eclipse.papyrus.uml.diagram.component.edit.policies.InterfaceItemSemanticEditPolicyPCN;
import org.eclipse.papyrus.uml.diagram.component.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.component.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class InterfaceEditPartPCN extends AbstractBorderedShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3072;

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
	public InterfaceEditPartPCN(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new InterfaceItemSemanticEditPolicyPCN());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy("REMOVE_ORPHAN_VIEW", new RemoveOrphanViewPolicy()); //$NON-NLS-1$
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new CustomDiagramDragDropEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View)child.getModel();
				switch(UMLVisualIDRegistry.getVisualID(childView)) {
				case InterfaceNameEditPartPCN.VISUAL_ID:
					return new BorderItemSelectionEditPolicy() {

						protected List createSelectionHandles() {
							MoveHandle mh = new MoveHandle((GraphicalEditPart)getHost());
							mh.setBorder(null);
							return Collections.singletonList(mh);
						}
					};
				}
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
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
		return primaryShape = new InterfaceAsCercle();
	}

	/**
	 * @generated
	 */
	public InterfaceAsCercle getPrimaryShape() {
		return (InterfaceAsCercle)primaryShape;
	}

	/**
	 * @generated
	 */
	protected void addBorderItem(IFigure borderItemContainer, IBorderItemEditPart borderItemEditPart) {
		if(borderItemEditPart instanceof InterfaceNameEditPartPCN) {
			IBorderItemLocator locator = new ExternalLabelPositionLocator(getMainFigure());
			borderItemContainer.add(borderItemEditPart.getFigure(), locator);
		} else {
			super.addBorderItem(borderItemContainer, borderItemEditPart);
		}
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		String prefElementId = "Interface";
		IPreferenceStore store = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
		String preferenceConstantWitdh = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferenceConstantHelper.WIDTH);
		String preferenceConstantHeight = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferenceConstantHelper.HEIGHT);
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(store.getInt(preferenceConstantWitdh), store.getInt(preferenceConstantHeight));
		return result;
	}

	/**
	 * @generated
	 */
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
	public IFigure getContentPane() {
		if(contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if(primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if(primaryShape instanceof Shape) {
			((Shape)primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if(primaryShape instanceof Shape) {
			((Shape)primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(InterfaceNameEditPartPCN.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(8);
		types.add(UMLElementTypes.Usage_4001);
		types.add(UMLElementTypes.InterfaceRealization_4006);
		types.add(UMLElementTypes.Generalization_4003);
		types.add(UMLElementTypes.Substitution_4012);
		types.add(UMLElementTypes.Manifestation_4014);
		types.add(UMLElementTypes.ComponentRealization_4007);
		types.add(UMLElementTypes.Abstraction_4013);
		types.add(UMLElementTypes.Dependency_4010);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Usage_4001);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Usage_4001);
		}
		if(targetEditPart instanceof PackageEditPart) {
			types.add(UMLElementTypes.Usage_4001);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Usage_4001);
		}
		if(targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.Usage_4001);
		}
		if(targetEditPart instanceof ComponentEditPartCN) {
			types.add(UMLElementTypes.Usage_4001);
		}
		if(targetEditPart instanceof ComponentEditPartPCN) {
			types.add(UMLElementTypes.Usage_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPartPCN) {
			types.add(UMLElementTypes.Usage_4001);
		}
		if(targetEditPart instanceof ConstraintEditPartPCN) {
			types.add(UMLElementTypes.Usage_4001);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4006);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPartPCN) {
			types.add(UMLElementTypes.InterfaceRealization_4006);
		}
		if(targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Generalization_4003);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Generalization_4003);
		}
		if(targetEditPart instanceof ComponentEditPartCN) {
			types.add(UMLElementTypes.Generalization_4003);
		}
		if(targetEditPart instanceof ComponentEditPartPCN) {
			types.add(UMLElementTypes.Generalization_4003);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPartPCN) {
			types.add(UMLElementTypes.Generalization_4003);
		}
		if(targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Substitution_4012);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Substitution_4012);
		}
		if(targetEditPart instanceof PackageEditPart) {
			types.add(UMLElementTypes.Substitution_4012);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Substitution_4012);
		}
		if(targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.Substitution_4012);
		}
		if(targetEditPart instanceof ComponentEditPartCN) {
			types.add(UMLElementTypes.Substitution_4012);
		}
		if(targetEditPart instanceof ComponentEditPartPCN) {
			types.add(UMLElementTypes.Substitution_4012);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPartPCN) {
			types.add(UMLElementTypes.Substitution_4012);
		}
		if(targetEditPart instanceof ConstraintEditPartPCN) {
			types.add(UMLElementTypes.Substitution_4012);
		}
		if(targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Manifestation_4014);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Manifestation_4014);
		}
		if(targetEditPart instanceof PackageEditPart) {
			types.add(UMLElementTypes.Manifestation_4014);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Manifestation_4014);
		}
		if(targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.Manifestation_4014);
		}
		if(targetEditPart instanceof ComponentEditPartCN) {
			types.add(UMLElementTypes.Manifestation_4014);
		}
		if(targetEditPart instanceof ComponentEditPartPCN) {
			types.add(UMLElementTypes.Manifestation_4014);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPartPCN) {
			types.add(UMLElementTypes.Manifestation_4014);
		}
		if(targetEditPart instanceof ConstraintEditPartPCN) {
			types.add(UMLElementTypes.Manifestation_4014);
		}
		if(targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4007);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4007);
		}
		if(targetEditPart instanceof PackageEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4007);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4007);
		}
		if(targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.ComponentRealization_4007);
		}
		if(targetEditPart instanceof ComponentEditPartCN) {
			types.add(UMLElementTypes.ComponentRealization_4007);
		}
		if(targetEditPart instanceof ComponentEditPartPCN) {
			types.add(UMLElementTypes.ComponentRealization_4007);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPartPCN) {
			types.add(UMLElementTypes.ComponentRealization_4007);
		}
		if(targetEditPart instanceof ConstraintEditPartPCN) {
			types.add(UMLElementTypes.ComponentRealization_4007);
		}
		if(targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Abstraction_4013);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Abstraction_4013);
		}
		if(targetEditPart instanceof PackageEditPart) {
			types.add(UMLElementTypes.Abstraction_4013);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Abstraction_4013);
		}
		if(targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.Abstraction_4013);
		}
		if(targetEditPart instanceof ComponentEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4013);
		}
		if(targetEditPart instanceof ComponentEditPartPCN) {
			types.add(UMLElementTypes.Abstraction_4013);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPartPCN) {
			types.add(UMLElementTypes.Abstraction_4013);
		}
		if(targetEditPart instanceof ConstraintEditPartPCN) {
			types.add(UMLElementTypes.Abstraction_4013);
		}
		if(targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof PackageEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof PortEditPart) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof ComponentEditPartCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof ComponentEditPartPCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPartPCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		if(targetEditPart instanceof ConstraintEditPartPCN) {
			types.add(UMLElementTypes.Dependency_4010);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(relationshipType == UMLElementTypes.Usage_4001) {
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Interface_2003);
			types.add(UMLElementTypes.Package_3200);
			types.add(UMLElementTypes.Constraint_3199);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Component_3070);
			types.add(UMLElementTypes.Component_3071);
			types.add(UMLElementTypes.Interface_3072);
			types.add(UMLElementTypes.Constraint_3075);
		} else if(relationshipType == UMLElementTypes.InterfaceRealization_4006) {
			types.add(UMLElementTypes.Interface_2003);
			types.add(UMLElementTypes.Interface_3072);
		} else if(relationshipType == UMLElementTypes.Generalization_4003) {
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Interface_2003);
			types.add(UMLElementTypes.Component_3070);
			types.add(UMLElementTypes.Component_3071);
			types.add(UMLElementTypes.Interface_3072);
		} else if(relationshipType == UMLElementTypes.Substitution_4012) {
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Interface_2003);
			types.add(UMLElementTypes.Package_3200);
			types.add(UMLElementTypes.Constraint_3199);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Component_3070);
			types.add(UMLElementTypes.Component_3071);
			types.add(UMLElementTypes.Interface_3072);
			types.add(UMLElementTypes.Constraint_3075);
		} else if(relationshipType == UMLElementTypes.Manifestation_4014) {
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Interface_2003);
			types.add(UMLElementTypes.Package_3200);
			types.add(UMLElementTypes.Constraint_3199);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Component_3070);
			types.add(UMLElementTypes.Component_3071);
			types.add(UMLElementTypes.Interface_3072);
			types.add(UMLElementTypes.Constraint_3075);
		} else if(relationshipType == UMLElementTypes.ComponentRealization_4007) {
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Interface_2003);
			types.add(UMLElementTypes.Package_3200);
			types.add(UMLElementTypes.Constraint_3199);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Component_3070);
			types.add(UMLElementTypes.Component_3071);
			types.add(UMLElementTypes.Interface_3072);
			types.add(UMLElementTypes.Constraint_3075);
		} else if(relationshipType == UMLElementTypes.Abstraction_4013) {
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Interface_2003);
			types.add(UMLElementTypes.Package_3200);
			types.add(UMLElementTypes.Constraint_3199);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Component_3070);
			types.add(UMLElementTypes.Component_3071);
			types.add(UMLElementTypes.Interface_3072);
			types.add(UMLElementTypes.Constraint_3075);
		} else if(relationshipType == UMLElementTypes.Dependency_4010) {
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Interface_2003);
			types.add(UMLElementTypes.Package_3200);
			types.add(UMLElementTypes.Constraint_3199);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Component_3070);
			types.add(UMLElementTypes.Component_3071);
			types.add(UMLElementTypes.Interface_3072);
			types.add(UMLElementTypes.Constraint_3075);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(10);
		types.add(UMLElementTypes.Usage_4001);
		types.add(UMLElementTypes.InterfaceRealization_4006);
		types.add(UMLElementTypes.Generalization_4003);
		types.add(UMLElementTypes.Substitution_4012);
		types.add(UMLElementTypes.Manifestation_4014);
		types.add(UMLElementTypes.ComponentRealization_4007);
		types.add(UMLElementTypes.Abstraction_4013);
		types.add(UMLElementTypes.CommentAnnotatedElement_4015);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4009);
		types.add(UMLElementTypes.Dependency_4010);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(relationshipType == UMLElementTypes.Usage_4001) {
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Interface_2003);
			types.add(UMLElementTypes.Package_3200);
			types.add(UMLElementTypes.Constraint_3199);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Component_3070);
			types.add(UMLElementTypes.Component_3071);
			types.add(UMLElementTypes.Interface_3072);
			types.add(UMLElementTypes.Constraint_3075);
		} else if(relationshipType == UMLElementTypes.InterfaceRealization_4006) {
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Interface_2003);
			types.add(UMLElementTypes.Package_3200);
			types.add(UMLElementTypes.Constraint_3199);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Component_3070);
			types.add(UMLElementTypes.Component_3071);
			types.add(UMLElementTypes.Interface_3072);
			types.add(UMLElementTypes.Constraint_3075);
		} else if(relationshipType == UMLElementTypes.Generalization_4003) {
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Interface_2003);
			types.add(UMLElementTypes.Component_3070);
			types.add(UMLElementTypes.Component_3071);
			types.add(UMLElementTypes.Interface_3072);
		} else if(relationshipType == UMLElementTypes.Substitution_4012) {
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Interface_2003);
			types.add(UMLElementTypes.Package_3200);
			types.add(UMLElementTypes.Constraint_3199);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Component_3070);
			types.add(UMLElementTypes.Component_3071);
			types.add(UMLElementTypes.Interface_3072);
			types.add(UMLElementTypes.Constraint_3075);
		} else if(relationshipType == UMLElementTypes.Manifestation_4014) {
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Interface_2003);
			types.add(UMLElementTypes.Package_3200);
			types.add(UMLElementTypes.Constraint_3199);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Component_3070);
			types.add(UMLElementTypes.Component_3071);
			types.add(UMLElementTypes.Interface_3072);
			types.add(UMLElementTypes.Constraint_3075);
		} else if(relationshipType == UMLElementTypes.ComponentRealization_4007) {
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Interface_2003);
			types.add(UMLElementTypes.Package_3200);
			types.add(UMLElementTypes.Constraint_3199);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Component_3070);
			types.add(UMLElementTypes.Component_3071);
			types.add(UMLElementTypes.Interface_3072);
			types.add(UMLElementTypes.Constraint_3075);
		} else if(relationshipType == UMLElementTypes.Abstraction_4013) {
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Interface_2003);
			types.add(UMLElementTypes.Package_3200);
			types.add(UMLElementTypes.Constraint_3199);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Component_3070);
			types.add(UMLElementTypes.Component_3071);
			types.add(UMLElementTypes.Interface_3072);
			types.add(UMLElementTypes.Constraint_3075);
		} else if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4015) {
			types.add(UMLElementTypes.Comment_3201);
			types.add(UMLElementTypes.Comment_3074);
		} else if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4009) {
			types.add(UMLElementTypes.Constraint_3199);
			types.add(UMLElementTypes.Constraint_3075);
		} else if(relationshipType == UMLElementTypes.Dependency_4010) {
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Interface_2003);
			types.add(UMLElementTypes.Package_3200);
			types.add(UMLElementTypes.Constraint_3199);
			types.add(UMLElementTypes.Port_3069);
			types.add(UMLElementTypes.Component_3070);
			types.add(UMLElementTypes.Component_3071);
			types.add(UMLElementTypes.Interface_3072);
			types.add(UMLElementTypes.Constraint_3075);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class InterfaceAsCercle extends Ellipse {

		/**
		 * @generated
		 */
		public InterfaceAsCercle() {
			this.setFill(false);
			this.setForegroundColor(ColorConstants.black);
		}
	}

	/**
	 * @generated
	 */
	@Override
	public Object getPreferredValue(EStructuralFeature feature) {
		IPreferenceStore preferenceStore = (IPreferenceStore)getDiagramPreferencesHint().getPreferenceStore();
		Object result = null;
		if(feature == NotationPackage.eINSTANCE.getLineStyle_LineColor() || feature == NotationPackage.eINSTANCE.getFontStyle_FontColor() || feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
			String prefColor = null;
			if(feature == NotationPackage.eINSTANCE.getLineStyle_LineColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("Interface", PreferenceConstantHelper.COLOR_LINE);
			} else if(feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("Interface", PreferenceConstantHelper.COLOR_FONT);
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("Interface", PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore)preferenceStore, prefColor));
		} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency() || feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant("Interface", PreferenceConstantHelper.COLOR_GRADIENT);
			GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(preferenceStore.getString(prefGradient));
			if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency()) {
				result = new Integer(gradientPreferenceConverter.getTransparency());
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
				result = gradientPreferenceConverter.getGradientData();
			}
		}
		if(result == null) {
			result = getStructuralFeatureValue(feature);
		}
		return result;
	}
}
