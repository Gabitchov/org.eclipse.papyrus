/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.clazz.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;
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
import org.eclipse.papyrus.uml.diagram.clazz.custom.policies.ClassDiagramDragDropEditPolicy;
import org.eclipse.papyrus.uml.diagram.clazz.custom.policies.ClazzDiagramChangeStereotypedShapeEditpolicy;
import org.eclipse.papyrus.uml.diagram.clazz.custom.policies.CustomGraphicalNodeEditPolicy;
import org.eclipse.papyrus.uml.diagram.clazz.custom.policies.itemsemantic.CustomClassItemSemanticEditPolicyCN;
import org.eclipse.papyrus.uml.diagram.clazz.edit.policies.ClassItemSemanticEditPolicyCN;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.uml.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.common.editparts.ClassifierEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.BorderItemResizableEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ChangeStereotypedShapeEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ConstrainedItemBorderLayoutEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.HyperLinkPopupBarEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.PapyrusCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.QualifiedNameDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ShowHideClassifierContentsEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.ShowHideCompartmentEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.node.ClassifierFigure;
import org.eclipse.papyrus.uml.diagram.common.helper.PreferenceInitializerForElementHelper;
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
		installEditPolicy(EditPolicyRoles.POPUPBAR_ROLE, new HyperLinkPopupBarEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new CustomGraphicalNodeEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomClassItemSemanticEditPolicyCN());
		installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeNodeLabelDisplayEditPolicy());
		installEditPolicy(QualifiedNameDisplayEditPolicy.QUALIFIED_NAME_POLICY, new QualifiedNameDisplayEditPolicy());
		installEditPolicy(ChangeStereotypedShapeEditPolicy.CHANGE_SHAPE_POLICY, new ClazzDiagramChangeStereotypedShapeEditpolicy());
		installEditPolicy(ShowHideCompartmentEditPolicy.SHOW_HIDE_COMPARTMENT_POLICY, new ShowHideCompartmentEditPolicy());
		installEditPolicy(ShowHideClassifierContentsEditPolicy.SHOW_HIDE_CLASSIFIER_CONTENTS_POLICY, new ShowHideClassifierContentsEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new ClassDiagramDragDropEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
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
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new ClassifierFigure();
	}

	/**
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
		String prefElementId = "Class";
		IPreferenceStore store = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();
		String preferenceConstantWitdh = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferenceConstantHelper.WIDTH);
		String preferenceConstantHeight = PreferenceInitializerForElementHelper.getpreferenceKey(getNotationView(), prefElementId, PreferenceConstantHelper.HEIGHT);
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(store.getInt(preferenceConstantWitdh), store.getInt(preferenceConstantHeight));
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(ClassNameEditPartCN.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(14);
		types.add(UMLElementTypes.AssociationClass_4017);
		types.add(UMLElementTypes.Association_4001);
		types.add(UMLElementTypes.Association_4019);
		types.add(UMLElementTypes.Generalization_4002);
		types.add(UMLElementTypes.InterfaceRealization_4003);
		types.add(UMLElementTypes.Substitution_4004);
		types.add(UMLElementTypes.Realization_4005);
		types.add(UMLElementTypes.Abstraction_4006);
		types.add(UMLElementTypes.Usage_4007);
		types.add(UMLElementTypes.Dependency_4008);
		types.add(UMLElementTypes.Dependency_4018);
		types.add(UMLElementTypes.ElementImport_4009);
		types.add(UMLElementTypes.PackageImport_4010);
		types.add(UMLElementTypes.TemplateBinding_4015);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(targetEditPart instanceof AssociationClassEditPart) {
			types.add(UMLElementTypes.AssociationClass_4017);
		}
		if(targetEditPart instanceof AssociationNodeEditPart) {
			types.add(UMLElementTypes.AssociationClass_4017);
		}
		if(targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.AssociationClass_4017);
		}
		if(targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.AssociationClass_4017);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.AssociationClass_4017);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.AssociationClass_4017);
		}
		if(targetEditPart instanceof InformationItemEditPart) {
			types.add(UMLElementTypes.AssociationClass_4017);
		}
		if(targetEditPart instanceof ClassEditPart) {
			types.add(UMLElementTypes.AssociationClass_4017);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.AssociationClass_4017);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.AssociationClass_4017);
		}
		if(targetEditPart instanceof ComponentEditPartCN) {
			types.add(UMLElementTypes.AssociationClass_4017);
		}
		if(targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.AssociationClass_4017);
		}
		if(targetEditPart instanceof InterfaceEditPartCN) {
			types.add(UMLElementTypes.AssociationClass_4017);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.AssociationClass_4017);
		}
		if(targetEditPart instanceof InformationItemEditPartCN) {
			types.add(UMLElementTypes.AssociationClass_4017);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPartCN) {
			types.add(UMLElementTypes.AssociationClass_4017);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.AssociationClass_4017);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.AssociationClass_4017);
		}
		if(targetEditPart instanceof AssociationClassEditPart) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof AssociationNodeEditPart) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof InformationItemEditPart) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof ClassEditPart) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof ComponentEditPartCN) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof InterfaceEditPartCN) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof InformationItemEditPartCN) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPartCN) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Association_4001);
		}
		if(targetEditPart instanceof AssociationClassEditPart) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof AssociationNodeEditPart) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof InformationItemEditPart) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof ClassEditPart) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof ComponentEditPartCN) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof InterfaceEditPartCN) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof InformationItemEditPartCN) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPartCN) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Association_4019);
		}
		if(targetEditPart instanceof AssociationClassEditPart) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof AssociationNodeEditPart) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof InformationItemEditPart) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof ClassEditPart) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof ComponentEditPartCN) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof InterfaceEditPartCN) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof InformationItemEditPartCN) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPartCN) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Generalization_4002);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.InterfaceRealization_4003);
		}
		if(targetEditPart instanceof InterfaceEditPartCN) {
			types.add(UMLElementTypes.InterfaceRealization_4003);
		}
		if(targetEditPart instanceof AssociationClassEditPart) {
			types.add(UMLElementTypes.Substitution_4004);
		}
		if(targetEditPart instanceof AssociationNodeEditPart) {
			types.add(UMLElementTypes.Substitution_4004);
		}
		if(targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Substitution_4004);
		}
		if(targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.Substitution_4004);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Substitution_4004);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Substitution_4004);
		}
		if(targetEditPart instanceof InformationItemEditPart) {
			types.add(UMLElementTypes.Substitution_4004);
		}
		if(targetEditPart instanceof ClassEditPart) {
			types.add(UMLElementTypes.Substitution_4004);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.Substitution_4004);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Substitution_4004);
		}
		if(targetEditPart instanceof ComponentEditPartCN) {
			types.add(UMLElementTypes.Substitution_4004);
		}
		if(targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.Substitution_4004);
		}
		if(targetEditPart instanceof InterfaceEditPartCN) {
			types.add(UMLElementTypes.Substitution_4004);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.Substitution_4004);
		}
		if(targetEditPart instanceof InformationItemEditPartCN) {
			types.add(UMLElementTypes.Substitution_4004);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPartCN) {
			types.add(UMLElementTypes.Substitution_4004);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.Substitution_4004);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Substitution_4004);
		}
		if(targetEditPart instanceof DependencyNodeEditPart) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if(targetEditPart instanceof AssociationClassEditPart) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if(targetEditPart instanceof AssociationNodeEditPart) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if(targetEditPart instanceof InstanceSpecificationEditPart) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if(targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if(targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if(targetEditPart instanceof ModelEditPartTN) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if(targetEditPart instanceof PackageEditPart) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if(targetEditPart instanceof InformationItemEditPart) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if(targetEditPart instanceof ClassEditPart) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if(targetEditPart instanceof DefaultNamedElementEditPart) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if(targetEditPart instanceof ShapeNamedElementEditPart) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if(targetEditPart instanceof RedefinableTemplateSignatureEditPart) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if(targetEditPart instanceof InstanceSpecificationEditPartCN) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if(targetEditPart instanceof ComponentEditPartCN) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if(targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if(targetEditPart instanceof InterfaceEditPartCN) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if(targetEditPart instanceof ModelEditPartCN) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if(targetEditPart instanceof InformationItemEditPartCN) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPartCN) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			types.add(UMLElementTypes.Realization_4005);
		}
		if(targetEditPart instanceof DependencyNodeEditPart) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if(targetEditPart instanceof AssociationClassEditPart) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if(targetEditPart instanceof AssociationNodeEditPart) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if(targetEditPart instanceof InstanceSpecificationEditPart) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if(targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if(targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if(targetEditPart instanceof ModelEditPartTN) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if(targetEditPart instanceof PackageEditPart) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if(targetEditPart instanceof InformationItemEditPart) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if(targetEditPart instanceof ClassEditPart) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if(targetEditPart instanceof DefaultNamedElementEditPart) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if(targetEditPart instanceof ShapeNamedElementEditPart) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if(targetEditPart instanceof RedefinableTemplateSignatureEditPart) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if(targetEditPart instanceof InstanceSpecificationEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if(targetEditPart instanceof ComponentEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if(targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if(targetEditPart instanceof InterfaceEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if(targetEditPart instanceof ModelEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if(targetEditPart instanceof InformationItemEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			types.add(UMLElementTypes.Abstraction_4006);
		}
		if(targetEditPart instanceof DependencyNodeEditPart) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if(targetEditPart instanceof AssociationClassEditPart) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if(targetEditPart instanceof AssociationNodeEditPart) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if(targetEditPart instanceof InstanceSpecificationEditPart) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if(targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if(targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if(targetEditPart instanceof ModelEditPartTN) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if(targetEditPart instanceof PackageEditPart) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if(targetEditPart instanceof InformationItemEditPart) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if(targetEditPart instanceof ClassEditPart) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if(targetEditPart instanceof DefaultNamedElementEditPart) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if(targetEditPart instanceof ShapeNamedElementEditPart) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if(targetEditPart instanceof RedefinableTemplateSignatureEditPart) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if(targetEditPart instanceof InstanceSpecificationEditPartCN) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if(targetEditPart instanceof ComponentEditPartCN) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if(targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if(targetEditPart instanceof InterfaceEditPartCN) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if(targetEditPart instanceof ModelEditPartCN) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if(targetEditPart instanceof InformationItemEditPartCN) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPartCN) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			types.add(UMLElementTypes.Usage_4007);
		}
		if(targetEditPart instanceof DependencyNodeEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof AssociationClassEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof AssociationNodeEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof InstanceSpecificationEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof ModelEditPartTN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof PackageEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof InformationItemEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof ClassEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof DefaultNamedElementEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof ShapeNamedElementEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof RedefinableTemplateSignatureEditPart) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof InstanceSpecificationEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof ComponentEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof InterfaceEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof ModelEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof InformationItemEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			types.add(UMLElementTypes.Dependency_4008);
		}
		if(targetEditPart instanceof DependencyNodeEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof AssociationClassEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof AssociationNodeEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof InstanceSpecificationEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof ModelEditPartTN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof PackageEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof InformationItemEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof ClassEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof DefaultNamedElementEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof ShapeNamedElementEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof RedefinableTemplateSignatureEditPart) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof InstanceSpecificationEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof ComponentEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof InterfaceEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof ModelEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof InformationItemEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			types.add(UMLElementTypes.Dependency_4018);
		}
		if(targetEditPart instanceof DependencyNodeEditPart) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if(targetEditPart instanceof AssociationClassEditPart) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if(targetEditPart instanceof AssociationNodeEditPart) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if(targetEditPart instanceof InstanceSpecificationEditPart) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if(targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if(targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if(targetEditPart instanceof ModelEditPartTN) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if(targetEditPart instanceof PackageEditPart) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if(targetEditPart instanceof InformationItemEditPart) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if(targetEditPart instanceof ClassEditPart) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if(targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if(targetEditPart instanceof DurationObservationEditPart) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if(targetEditPart instanceof TimeObservationEditPart) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if(targetEditPart instanceof InstanceSpecificationEditPartCN) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if(targetEditPart instanceof ComponentEditPartCN) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if(targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if(targetEditPart instanceof InterfaceEditPartCN) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if(targetEditPart instanceof ModelEditPartCN) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if(targetEditPart instanceof InformationItemEditPartCN) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPartCN) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if(targetEditPart instanceof ConstraintEditPartCN) {
			types.add(UMLElementTypes.ElementImport_4009);
		}
		if(targetEditPart instanceof ModelEditPartTN) {
			types.add(UMLElementTypes.PackageImport_4010);
		}
		if(targetEditPart instanceof PackageEditPart) {
			types.add(UMLElementTypes.PackageImport_4010);
		}
		if(targetEditPart instanceof ModelEditPartCN) {
			types.add(UMLElementTypes.PackageImport_4010);
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.PackageImport_4010);
		}
		if(targetEditPart instanceof AssociationClassEditPart) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if(targetEditPart instanceof AssociationNodeEditPart) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if(targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if(targetEditPart instanceof SignalEditPart) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if(targetEditPart instanceof InterfaceEditPart) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if(targetEditPart instanceof ModelEditPartTN) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if(targetEditPart instanceof EnumerationEditPart) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if(targetEditPart instanceof PackageEditPart) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if(targetEditPart instanceof InformationItemEditPart) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if(targetEditPart instanceof ClassEditPart) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPart) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if(targetEditPart instanceof DataTypeEditPart) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if(targetEditPart instanceof ComponentEditPartCN) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if(targetEditPart instanceof SignalEditPartCN) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if(targetEditPart instanceof InterfaceEditPartCN) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if(targetEditPart instanceof ModelEditPartCN) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if(targetEditPart instanceof EnumerationEditPartCN) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if(targetEditPart instanceof PackageEditPartCN) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if(targetEditPart instanceof InformationItemEditPartCN) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if(targetEditPart instanceof org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPartCN) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if(targetEditPart instanceof PrimitiveTypeEditPartCN) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		if(targetEditPart instanceof DataTypeEditPartCN) {
			types.add(UMLElementTypes.TemplateBinding_4015);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(relationshipType == UMLElementTypes.AssociationClass_4017) {
			types.add(UMLElementTypes.AssociationClass_2013);
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Signal_2003);
			types.add(UMLElementTypes.Interface_2004);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.InformationItem_2099);
			types.add(UMLElementTypes.Class_2008);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.Component_3021);
			types.add(UMLElementTypes.Signal_3022);
			types.add(UMLElementTypes.Interface_3023);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.InformationItem_3040);
			types.add(UMLElementTypes.Class_3010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
		} else if(relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.AssociationClass_2013);
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Signal_2003);
			types.add(UMLElementTypes.Interface_2004);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.InformationItem_2099);
			types.add(UMLElementTypes.Class_2008);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.Component_3021);
			types.add(UMLElementTypes.Signal_3022);
			types.add(UMLElementTypes.Interface_3023);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.InformationItem_3040);
			types.add(UMLElementTypes.Class_3010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
		} else if(relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.AssociationClass_2013);
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Signal_2003);
			types.add(UMLElementTypes.Interface_2004);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.InformationItem_2099);
			types.add(UMLElementTypes.Class_2008);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.Component_3021);
			types.add(UMLElementTypes.Signal_3022);
			types.add(UMLElementTypes.Interface_3023);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.InformationItem_3040);
			types.add(UMLElementTypes.Class_3010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
		} else if(relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.AssociationClass_2013);
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Signal_2003);
			types.add(UMLElementTypes.Interface_2004);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.InformationItem_2099);
			types.add(UMLElementTypes.Class_2008);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.Component_3021);
			types.add(UMLElementTypes.Signal_3022);
			types.add(UMLElementTypes.Interface_3023);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.InformationItem_3040);
			types.add(UMLElementTypes.Class_3010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
		} else if(relationshipType == UMLElementTypes.InterfaceRealization_4003) {
			types.add(UMLElementTypes.Interface_2004);
			types.add(UMLElementTypes.Interface_3023);
		} else if(relationshipType == UMLElementTypes.Substitution_4004) {
			types.add(UMLElementTypes.AssociationClass_2013);
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Signal_2003);
			types.add(UMLElementTypes.Interface_2004);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.InformationItem_2099);
			types.add(UMLElementTypes.Class_2008);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.Component_3021);
			types.add(UMLElementTypes.Signal_3022);
			types.add(UMLElementTypes.Interface_3023);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.InformationItem_3040);
			types.add(UMLElementTypes.Class_3010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
		} else if(relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Dependency_2014);
			types.add(UMLElementTypes.AssociationClass_2013);
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.InstanceSpecification_2001);
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Signal_2003);
			types.add(UMLElementTypes.Interface_2004);
			types.add(UMLElementTypes.Model_2005);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.Package_2007);
			types.add(UMLElementTypes.InformationItem_2099);
			types.add(UMLElementTypes.Class_2008);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.Constraint_2011);
			types.add(UMLElementTypes.DurationObservation_2095);
			types.add(UMLElementTypes.TimeObservation_2096);
			types.add(UMLElementTypes.NamedElement_2097);
			types.add(UMLElementTypes.NamedElement_2098);
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			types.add(UMLElementTypes.InstanceSpecification_3020);
			types.add(UMLElementTypes.Component_3021);
			types.add(UMLElementTypes.Signal_3022);
			types.add(UMLElementTypes.Interface_3023);
			types.add(UMLElementTypes.Model_3024);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.Package_3009);
			types.add(UMLElementTypes.InformationItem_3040);
			types.add(UMLElementTypes.Class_3010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
			types.add(UMLElementTypes.Constraint_3029);
		} else if(relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Dependency_2014);
			types.add(UMLElementTypes.AssociationClass_2013);
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.InstanceSpecification_2001);
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Signal_2003);
			types.add(UMLElementTypes.Interface_2004);
			types.add(UMLElementTypes.Model_2005);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.Package_2007);
			types.add(UMLElementTypes.InformationItem_2099);
			types.add(UMLElementTypes.Class_2008);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.Constraint_2011);
			types.add(UMLElementTypes.DurationObservation_2095);
			types.add(UMLElementTypes.TimeObservation_2096);
			types.add(UMLElementTypes.NamedElement_2097);
			types.add(UMLElementTypes.NamedElement_2098);
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			types.add(UMLElementTypes.InstanceSpecification_3020);
			types.add(UMLElementTypes.Component_3021);
			types.add(UMLElementTypes.Signal_3022);
			types.add(UMLElementTypes.Interface_3023);
			types.add(UMLElementTypes.Model_3024);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.Package_3009);
			types.add(UMLElementTypes.InformationItem_3040);
			types.add(UMLElementTypes.Class_3010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
			types.add(UMLElementTypes.Constraint_3029);
		} else if(relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Dependency_2014);
			types.add(UMLElementTypes.AssociationClass_2013);
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.InstanceSpecification_2001);
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Signal_2003);
			types.add(UMLElementTypes.Interface_2004);
			types.add(UMLElementTypes.Model_2005);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.Package_2007);
			types.add(UMLElementTypes.InformationItem_2099);
			types.add(UMLElementTypes.Class_2008);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.Constraint_2011);
			types.add(UMLElementTypes.DurationObservation_2095);
			types.add(UMLElementTypes.TimeObservation_2096);
			types.add(UMLElementTypes.NamedElement_2097);
			types.add(UMLElementTypes.NamedElement_2098);
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			types.add(UMLElementTypes.InstanceSpecification_3020);
			types.add(UMLElementTypes.Component_3021);
			types.add(UMLElementTypes.Signal_3022);
			types.add(UMLElementTypes.Interface_3023);
			types.add(UMLElementTypes.Model_3024);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.Package_3009);
			types.add(UMLElementTypes.InformationItem_3040);
			types.add(UMLElementTypes.Class_3010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
			types.add(UMLElementTypes.Constraint_3029);
		} else if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Dependency_2014);
			types.add(UMLElementTypes.AssociationClass_2013);
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.InstanceSpecification_2001);
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Signal_2003);
			types.add(UMLElementTypes.Interface_2004);
			types.add(UMLElementTypes.Model_2005);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.Package_2007);
			types.add(UMLElementTypes.InformationItem_2099);
			types.add(UMLElementTypes.Class_2008);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.Constraint_2011);
			types.add(UMLElementTypes.DurationObservation_2095);
			types.add(UMLElementTypes.TimeObservation_2096);
			types.add(UMLElementTypes.NamedElement_2097);
			types.add(UMLElementTypes.NamedElement_2098);
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			types.add(UMLElementTypes.InstanceSpecification_3020);
			types.add(UMLElementTypes.Component_3021);
			types.add(UMLElementTypes.Signal_3022);
			types.add(UMLElementTypes.Interface_3023);
			types.add(UMLElementTypes.Model_3024);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.Package_3009);
			types.add(UMLElementTypes.InformationItem_3040);
			types.add(UMLElementTypes.Class_3010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
			types.add(UMLElementTypes.Constraint_3029);
		} else if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Dependency_2014);
			types.add(UMLElementTypes.AssociationClass_2013);
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.InstanceSpecification_2001);
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Signal_2003);
			types.add(UMLElementTypes.Interface_2004);
			types.add(UMLElementTypes.Model_2005);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.Package_2007);
			types.add(UMLElementTypes.InformationItem_2099);
			types.add(UMLElementTypes.Class_2008);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.Constraint_2011);
			types.add(UMLElementTypes.DurationObservation_2095);
			types.add(UMLElementTypes.TimeObservation_2096);
			types.add(UMLElementTypes.NamedElement_2097);
			types.add(UMLElementTypes.NamedElement_2098);
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			types.add(UMLElementTypes.InstanceSpecification_3020);
			types.add(UMLElementTypes.Component_3021);
			types.add(UMLElementTypes.Signal_3022);
			types.add(UMLElementTypes.Interface_3023);
			types.add(UMLElementTypes.Model_3024);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.Package_3009);
			types.add(UMLElementTypes.InformationItem_3040);
			types.add(UMLElementTypes.Class_3010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
			types.add(UMLElementTypes.Constraint_3029);
		} else if(relationshipType == UMLElementTypes.ElementImport_4009) {
			types.add(UMLElementTypes.Dependency_2014);
			types.add(UMLElementTypes.AssociationClass_2013);
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.InstanceSpecification_2001);
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Signal_2003);
			types.add(UMLElementTypes.Interface_2004);
			types.add(UMLElementTypes.Model_2005);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.Package_2007);
			types.add(UMLElementTypes.InformationItem_2099);
			types.add(UMLElementTypes.Class_2008);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.Constraint_2011);
			types.add(UMLElementTypes.DurationObservation_2095);
			types.add(UMLElementTypes.TimeObservation_2096);
			types.add(UMLElementTypes.InstanceSpecification_3020);
			types.add(UMLElementTypes.Component_3021);
			types.add(UMLElementTypes.Signal_3022);
			types.add(UMLElementTypes.Interface_3023);
			types.add(UMLElementTypes.Model_3024);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.Package_3009);
			types.add(UMLElementTypes.InformationItem_3040);
			types.add(UMLElementTypes.Class_3010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
			types.add(UMLElementTypes.Constraint_3029);
		} else if(relationshipType == UMLElementTypes.PackageImport_4010) {
			types.add(UMLElementTypes.Model_2005);
			types.add(UMLElementTypes.Package_2007);
			types.add(UMLElementTypes.Model_3024);
			types.add(UMLElementTypes.Package_3009);
		} else if(relationshipType == UMLElementTypes.TemplateBinding_4015) {
			types.add(UMLElementTypes.AssociationClass_2013);
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Signal_2003);
			types.add(UMLElementTypes.Interface_2004);
			types.add(UMLElementTypes.Model_2005);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.Package_2007);
			types.add(UMLElementTypes.InformationItem_2099);
			types.add(UMLElementTypes.Class_2008);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.Component_3021);
			types.add(UMLElementTypes.Signal_3022);
			types.add(UMLElementTypes.Interface_3023);
			types.add(UMLElementTypes.Model_3024);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.Package_3009);
			types.add(UMLElementTypes.InformationItem_3040);
			types.add(UMLElementTypes.Class_3010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(16);
		types.add(UMLElementTypes.AssociationClass_4017);
		types.add(UMLElementTypes.Association_4001);
		types.add(UMLElementTypes.Association_4019);
		types.add(UMLElementTypes.Generalization_4002);
		types.add(UMLElementTypes.Substitution_4004);
		types.add(UMLElementTypes.Realization_4005);
		types.add(UMLElementTypes.Abstraction_4006);
		types.add(UMLElementTypes.Usage_4007);
		types.add(UMLElementTypes.Dependency_4008);
		types.add(UMLElementTypes.Dependency_4018);
		types.add(UMLElementTypes.ElementImport_4009);
		types.add(UMLElementTypes.CommentAnnotatedElement_4013);
		types.add(UMLElementTypes.ConstraintConstrainedElement_4014);
		types.add(UMLElementTypes.TemplateBinding_4015);
		types.add(UMLElementTypes.TimeObservationEvent_4024);
		types.add(UMLElementTypes.DurationObservationEvent_4025);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(relationshipType == UMLElementTypes.AssociationClass_4017) {
			types.add(UMLElementTypes.AssociationClass_2013);
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Signal_2003);
			types.add(UMLElementTypes.Interface_2004);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.InformationItem_2099);
			types.add(UMLElementTypes.Class_2008);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.Component_3021);
			types.add(UMLElementTypes.Signal_3022);
			types.add(UMLElementTypes.Interface_3023);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.InformationItem_3040);
			types.add(UMLElementTypes.Class_3010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
		} else if(relationshipType == UMLElementTypes.Association_4001) {
			types.add(UMLElementTypes.AssociationClass_2013);
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Signal_2003);
			types.add(UMLElementTypes.Interface_2004);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.InformationItem_2099);
			types.add(UMLElementTypes.Class_2008);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.Component_3021);
			types.add(UMLElementTypes.Signal_3022);
			types.add(UMLElementTypes.Interface_3023);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.InformationItem_3040);
			types.add(UMLElementTypes.Class_3010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
		} else if(relationshipType == UMLElementTypes.Association_4019) {
			types.add(UMLElementTypes.AssociationClass_2013);
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Signal_2003);
			types.add(UMLElementTypes.Interface_2004);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.InformationItem_2099);
			types.add(UMLElementTypes.Class_2008);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.Component_3021);
			types.add(UMLElementTypes.Signal_3022);
			types.add(UMLElementTypes.Interface_3023);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.InformationItem_3040);
			types.add(UMLElementTypes.Class_3010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
		} else if(relationshipType == UMLElementTypes.Generalization_4002) {
			types.add(UMLElementTypes.AssociationClass_2013);
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Signal_2003);
			types.add(UMLElementTypes.Interface_2004);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.InformationItem_2099);
			types.add(UMLElementTypes.Class_2008);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.Component_3021);
			types.add(UMLElementTypes.Signal_3022);
			types.add(UMLElementTypes.Interface_3023);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.InformationItem_3040);
			types.add(UMLElementTypes.Class_3010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
		} else if(relationshipType == UMLElementTypes.Substitution_4004) {
			types.add(UMLElementTypes.AssociationClass_2013);
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Signal_2003);
			types.add(UMLElementTypes.Interface_2004);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.InformationItem_2099);
			types.add(UMLElementTypes.Class_2008);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.Component_3021);
			types.add(UMLElementTypes.Signal_3022);
			types.add(UMLElementTypes.Interface_3023);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.InformationItem_3040);
			types.add(UMLElementTypes.Class_3010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
		} else if(relationshipType == UMLElementTypes.Realization_4005) {
			types.add(UMLElementTypes.Dependency_2014);
			types.add(UMLElementTypes.AssociationClass_2013);
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.InstanceSpecification_2001);
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Signal_2003);
			types.add(UMLElementTypes.Interface_2004);
			types.add(UMLElementTypes.Model_2005);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.Package_2007);
			types.add(UMLElementTypes.InformationItem_2099);
			types.add(UMLElementTypes.Class_2008);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.Constraint_2011);
			types.add(UMLElementTypes.DurationObservation_2095);
			types.add(UMLElementTypes.TimeObservation_2096);
			types.add(UMLElementTypes.NamedElement_2097);
			types.add(UMLElementTypes.NamedElement_2098);
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			types.add(UMLElementTypes.InstanceSpecification_3020);
			types.add(UMLElementTypes.Component_3021);
			types.add(UMLElementTypes.Signal_3022);
			types.add(UMLElementTypes.Interface_3023);
			types.add(UMLElementTypes.Model_3024);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.Package_3009);
			types.add(UMLElementTypes.InformationItem_3040);
			types.add(UMLElementTypes.Class_3010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
			types.add(UMLElementTypes.Constraint_3029);
		} else if(relationshipType == UMLElementTypes.Abstraction_4006) {
			types.add(UMLElementTypes.Dependency_2014);
			types.add(UMLElementTypes.AssociationClass_2013);
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.InstanceSpecification_2001);
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Signal_2003);
			types.add(UMLElementTypes.Interface_2004);
			types.add(UMLElementTypes.Model_2005);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.Package_2007);
			types.add(UMLElementTypes.InformationItem_2099);
			types.add(UMLElementTypes.Class_2008);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.Constraint_2011);
			types.add(UMLElementTypes.DurationObservation_2095);
			types.add(UMLElementTypes.TimeObservation_2096);
			types.add(UMLElementTypes.NamedElement_2097);
			types.add(UMLElementTypes.NamedElement_2098);
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			types.add(UMLElementTypes.InstanceSpecification_3020);
			types.add(UMLElementTypes.Component_3021);
			types.add(UMLElementTypes.Signal_3022);
			types.add(UMLElementTypes.Interface_3023);
			types.add(UMLElementTypes.Model_3024);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.Package_3009);
			types.add(UMLElementTypes.InformationItem_3040);
			types.add(UMLElementTypes.Class_3010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
			types.add(UMLElementTypes.Constraint_3029);
		} else if(relationshipType == UMLElementTypes.Usage_4007) {
			types.add(UMLElementTypes.Dependency_2014);
			types.add(UMLElementTypes.AssociationClass_2013);
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.InstanceSpecification_2001);
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Signal_2003);
			types.add(UMLElementTypes.Interface_2004);
			types.add(UMLElementTypes.Model_2005);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.Package_2007);
			types.add(UMLElementTypes.InformationItem_2099);
			types.add(UMLElementTypes.Class_2008);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.Constraint_2011);
			types.add(UMLElementTypes.DurationObservation_2095);
			types.add(UMLElementTypes.TimeObservation_2096);
			types.add(UMLElementTypes.NamedElement_2097);
			types.add(UMLElementTypes.NamedElement_2098);
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			types.add(UMLElementTypes.InstanceSpecification_3020);
			types.add(UMLElementTypes.Component_3021);
			types.add(UMLElementTypes.Signal_3022);
			types.add(UMLElementTypes.Interface_3023);
			types.add(UMLElementTypes.Model_3024);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.Package_3009);
			types.add(UMLElementTypes.InformationItem_3040);
			types.add(UMLElementTypes.Class_3010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
			types.add(UMLElementTypes.Constraint_3029);
		} else if(relationshipType == UMLElementTypes.Dependency_4008) {
			types.add(UMLElementTypes.Dependency_2014);
			types.add(UMLElementTypes.AssociationClass_2013);
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.InstanceSpecification_2001);
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Signal_2003);
			types.add(UMLElementTypes.Interface_2004);
			types.add(UMLElementTypes.Model_2005);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.Package_2007);
			types.add(UMLElementTypes.InformationItem_2099);
			types.add(UMLElementTypes.Class_2008);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.Constraint_2011);
			types.add(UMLElementTypes.DurationObservation_2095);
			types.add(UMLElementTypes.TimeObservation_2096);
			types.add(UMLElementTypes.NamedElement_2097);
			types.add(UMLElementTypes.NamedElement_2098);
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			types.add(UMLElementTypes.InstanceSpecification_3020);
			types.add(UMLElementTypes.Component_3021);
			types.add(UMLElementTypes.Signal_3022);
			types.add(UMLElementTypes.Interface_3023);
			types.add(UMLElementTypes.Model_3024);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.Package_3009);
			types.add(UMLElementTypes.InformationItem_3040);
			types.add(UMLElementTypes.Class_3010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
			types.add(UMLElementTypes.Constraint_3029);
		} else if(relationshipType == UMLElementTypes.Dependency_4018) {
			types.add(UMLElementTypes.Dependency_2014);
			types.add(UMLElementTypes.AssociationClass_2013);
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.InstanceSpecification_2001);
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Signal_2003);
			types.add(UMLElementTypes.Interface_2004);
			types.add(UMLElementTypes.Model_2005);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.Package_2007);
			types.add(UMLElementTypes.InformationItem_2099);
			types.add(UMLElementTypes.Class_2008);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.Constraint_2011);
			types.add(UMLElementTypes.DurationObservation_2095);
			types.add(UMLElementTypes.TimeObservation_2096);
			types.add(UMLElementTypes.NamedElement_2097);
			types.add(UMLElementTypes.NamedElement_2098);
			types.add(UMLElementTypes.RedefinableTemplateSignature_3015);
			types.add(UMLElementTypes.InstanceSpecification_3020);
			types.add(UMLElementTypes.Component_3021);
			types.add(UMLElementTypes.Signal_3022);
			types.add(UMLElementTypes.Interface_3023);
			types.add(UMLElementTypes.Model_3024);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.Package_3009);
			types.add(UMLElementTypes.InformationItem_3040);
			types.add(UMLElementTypes.Class_3010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
			types.add(UMLElementTypes.Constraint_3029);
		} else if(relationshipType == UMLElementTypes.ElementImport_4009) {
			types.add(UMLElementTypes.AssociationClass_2013);
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Signal_2003);
			types.add(UMLElementTypes.Interface_2004);
			types.add(UMLElementTypes.Model_2005);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.Package_2007);
			types.add(UMLElementTypes.InformationItem_2099);
			types.add(UMLElementTypes.Class_2008);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.Component_3021);
			types.add(UMLElementTypes.Signal_3022);
			types.add(UMLElementTypes.Interface_3023);
			types.add(UMLElementTypes.Model_3024);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.Package_3009);
			types.add(UMLElementTypes.InformationItem_3040);
			types.add(UMLElementTypes.Class_3010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
		} else if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4013) {
			types.add(UMLElementTypes.Comment_2012);
			types.add(UMLElementTypes.Comment_3028);
		} else if(relationshipType == UMLElementTypes.ConstraintConstrainedElement_4014) {
			types.add(UMLElementTypes.Constraint_2011);
			types.add(UMLElementTypes.Constraint_3029);
		} else if(relationshipType == UMLElementTypes.TemplateBinding_4015) {
			types.add(UMLElementTypes.AssociationClass_2013);
			types.add(UMLElementTypes.Association_2015);
			types.add(UMLElementTypes.Component_2002);
			types.add(UMLElementTypes.Signal_2003);
			types.add(UMLElementTypes.Interface_2004);
			types.add(UMLElementTypes.Model_2005);
			types.add(UMLElementTypes.Enumeration_2006);
			types.add(UMLElementTypes.Package_2007);
			types.add(UMLElementTypes.InformationItem_2099);
			types.add(UMLElementTypes.Class_2008);
			types.add(UMLElementTypes.PrimitiveType_2009);
			types.add(UMLElementTypes.DataType_2010);
			types.add(UMLElementTypes.Component_3021);
			types.add(UMLElementTypes.Signal_3022);
			types.add(UMLElementTypes.Interface_3023);
			types.add(UMLElementTypes.Model_3024);
			types.add(UMLElementTypes.Enumeration_3025);
			types.add(UMLElementTypes.Package_3009);
			types.add(UMLElementTypes.InformationItem_3040);
			types.add(UMLElementTypes.Class_3010);
			types.add(UMLElementTypes.PrimitiveType_3026);
			types.add(UMLElementTypes.DataType_3027);
		} else if(relationshipType == UMLElementTypes.TimeObservationEvent_4024) {
			types.add(UMLElementTypes.TimeObservation_2096);
		} else if(relationshipType == UMLElementTypes.DurationObservationEvent_4025) {
			types.add(UMLElementTypes.DurationObservation_2095);
		}
		return types;
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
		}
		return super.getTargetEditPart(request);
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
				prefColor = PreferenceConstantHelper.getElementConstant("Class", PreferenceConstantHelper.COLOR_LINE);
			} else if(feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("Class", PreferenceConstantHelper.COLOR_FONT);
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("Class", PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore)preferenceStore, prefColor));
		} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency() || feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant("Class", PreferenceConstantHelper.COLOR_GRADIENT);
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
