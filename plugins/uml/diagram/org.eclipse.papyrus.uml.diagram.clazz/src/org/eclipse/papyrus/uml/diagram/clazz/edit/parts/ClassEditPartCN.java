/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.clazz.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
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
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SelectableBorderedNodeFigure;
import org.eclipse.papyrus.uml.diagram.clazz.custom.policies.ClassDiagramDragDropEditPolicy;
import org.eclipse.papyrus.uml.diagram.clazz.custom.policies.CustomGraphicalNodeEditPolicy;
import org.eclipse.papyrus.uml.diagram.clazz.custom.policies.itemsemantic.CustomClassItemSemanticEditPolicyCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.policies.ClassItemSemanticEditPolicyCN;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.editparts.ClassifierEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.BorderItemResizableEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ConstrainedItemBorderLayoutEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.PapyrusCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.QualifiedNameDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ShowHideClassifierContentsEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ShowHideCompartmentEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.node.ClassifierFigure;
import org.eclipse.papyrus.uml.diagram.common.locator.TemplateBorderItemLocator;
import org.eclipse.swt.graphics.Color;

/**
 * @generated
 */
public class ClassEditPartCN extends ClassifierEditPart {

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
	public ClassEditPartCN(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new PapyrusCreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ClassItemSemanticEditPolicyCN());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		//in Papyrus diagrams are not strongly synchronised
		//installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CANONICAL_ROLE, new org.eclipse.papyrus.uml.diagram.clazz.edit.policies.ClassCanonicalEditPolicyCN());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy("RESIZE_BORDER_ITEMS", new ConstrainedItemBorderLayoutEditPolicy()); //$NON-NLS-1$
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new CustomGraphicalNodeEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomClassItemSemanticEditPolicyCN());
		installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeNodeLabelDisplayEditPolicy());
		installEditPolicy(QualifiedNameDisplayEditPolicy.QUALIFIED_NAME_POLICY, new QualifiedNameDisplayEditPolicy());
		installEditPolicy(ShowHideCompartmentEditPolicy.SHOW_HIDE_COMPARTMENT_POLICY, new ShowHideCompartmentEditPolicy());
		installEditPolicy(ShowHideClassifierContentsEditPolicy.SHOW_HIDE_CLASSIFIER_CONTENTS_POLICY, new ShowHideClassifierContentsEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new ClassDiagramDragDropEditPolicy());
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
				case RedefinableTemplateSignatureEditPart.VISUAL_ID:
					return new BorderItemResizableEditPolicy();
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
	 * Papyrus codeGen
	 *
	 * @generated
	 **/
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);
		//set the figure active when the feature of the of a class is true
		if(resolveSemanticElement() != null) {
			if(resolveSemanticElement().equals(event.getNotifier()) && (event.getFeature() instanceof EAttribute) && ((EAttribute)(event.getFeature())).getName().equals("isActive")) {
				((ClassifierFigure)getPrimaryShape()).setActive(event.getNewBooleanValue());
				refreshVisuals();
			}
		}
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new ClassifierFigure();
	}

	/**
	 * org.eclipse.papyrus.uml.diagram.common.figure.node.ClassifierFigure
	 * 
	 * @generated
	 */
	public ClassifierFigure getPrimaryShape() {
		return (ClassifierFigure)primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof ClassNameEditPartCN) {
			((ClassNameEditPartCN)childEditPart).setLabel(getPrimaryShape().getNameLabel());
			return true;
		}
		if(childEditPart instanceof ClassAttributeCompartmentEditPartCN) {
			IFigure pane = getPrimaryShape().getAttributeCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((ClassAttributeCompartmentEditPartCN)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof ClassOperationCompartmentEditPartCN) {
			IFigure pane = getPrimaryShape().getOperationCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((ClassOperationCompartmentEditPartCN)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof ClassNestedClassifierCompartmentEditPartCN) {
			IFigure pane = getPrimaryShape().getNestedClassifierFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((ClassNestedClassifierCompartmentEditPartCN)childEditPart).getFigure());
			return true;
		}
		//Papyrus Gencode :precise the locator for a template signature
		if(childEditPart instanceof RedefinableTemplateSignatureEditPart) {
			IBorderItemLocator locator = new TemplateBorderItemLocator(getMainFigure(), PositionConstants.EAST);
			getBorderedFigure().getBorderItemContainer().add(((RedefinableTemplateSignatureEditPart)childEditPart).getFigure(), locator);
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof ClassNameEditPartCN) {
			return true;
		}
		if(childEditPart instanceof ClassAttributeCompartmentEditPartCN) {
			IFigure pane = getPrimaryShape().getAttributeCompartmentFigure();
			pane.remove(((ClassAttributeCompartmentEditPartCN)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof ClassOperationCompartmentEditPartCN) {
			IFigure pane = getPrimaryShape().getOperationCompartmentFigure();
			pane.remove(((ClassOperationCompartmentEditPartCN)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof ClassNestedClassifierCompartmentEditPartCN) {
			IFigure pane = getPrimaryShape().getNestedClassifierFigure();
			pane.remove(((ClassNestedClassifierCompartmentEditPartCN)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof RedefinableTemplateSignatureEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((RedefinableTemplateSignatureEditPart)childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if(addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if(removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if(editPart instanceof ClassAttributeCompartmentEditPartCN) {
			return getPrimaryShape().getAttributeCompartmentFigure();
		}
		if(editPart instanceof ClassOperationCompartmentEditPartCN) {
			return getPrimaryShape().getOperationCompartmentFigure();
		}
		if(editPart instanceof ClassNestedClassifierCompartmentEditPartCN) {
			return getPrimaryShape().getNestedClassifierFigure();
		}
		if(editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(100, 100);
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
		return new SelectableBorderedNodeFigure(createMainFigureWithSVG());
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
		if(nodeShape.getLayoutManager() == null) {
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
		super.setLineWidth(width);
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if(primaryShape instanceof NodeFigure) {
			((NodeFigure)primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(ClassNameEditPartCN.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public EditPart getTargetEditPart(Request request) {
		if(request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest)request).getViewAndElementDescriptor().getCreateElementRequestAdapter();
			IElementType type = (IElementType)adapter.getAdapter(IElementType.class);
			if(type == UMLElementTypes.Property_3012) {
				return getChildBySemanticHint(UMLVisualIDRegistry.getType(ClassAttributeCompartmentEditPartCN.VISUAL_ID));
			}
			if(type == UMLElementTypes.Reception_3011) {
				return getChildBySemanticHint(UMLVisualIDRegistry.getType(ClassOperationCompartmentEditPartCN.VISUAL_ID));
			}
			if(type == UMLElementTypes.Operation_3013) {
				return getChildBySemanticHint(UMLVisualIDRegistry.getType(ClassOperationCompartmentEditPartCN.VISUAL_ID));
			}
			if(type == UMLElementTypes.Class_3014) {
				return getChildBySemanticHint(UMLVisualIDRegistry.getType(ClassNestedClassifierCompartmentEditPartCN.VISUAL_ID));
			}
			if(type == UMLElementTypes.Interface_3036) {
				return getChildBySemanticHint(UMLVisualIDRegistry.getType(ClassNestedClassifierCompartmentEditPartCN.VISUAL_ID));
			}
			if(type == UMLElementTypes.Enumeration_3052) {
				return getChildBySemanticHint(UMLVisualIDRegistry.getType(ClassNestedClassifierCompartmentEditPartCN.VISUAL_ID));
			}
			if(type == UMLElementTypes.PrimitiveType_3047) {
				return getChildBySemanticHint(UMLVisualIDRegistry.getType(ClassNestedClassifierCompartmentEditPartCN.VISUAL_ID));
			}
			if(type == UMLElementTypes.DataType_3044) {
				return getChildBySemanticHint(UMLVisualIDRegistry.getType(ClassNestedClassifierCompartmentEditPartCN.VISUAL_ID));
			}
			if(type == UMLElementTypes.Signal_3050) {
				return getChildBySemanticHint(UMLVisualIDRegistry.getType(ClassNestedClassifierCompartmentEditPartCN.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
	}
}
