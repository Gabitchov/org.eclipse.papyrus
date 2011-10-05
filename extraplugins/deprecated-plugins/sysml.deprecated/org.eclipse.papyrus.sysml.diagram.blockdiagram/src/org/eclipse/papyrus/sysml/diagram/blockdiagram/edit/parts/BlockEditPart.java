/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.diagram.clazz.edit.parts.ClassNameEditPart;
import org.eclipse.papyrus.diagram.clazz.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.papyrus.sysml.blocks.Block;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.part.BlockNameEditPart;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.policies.BlockItemSemanticEditPolicy;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.policies.SysMLViewComponentEditPolicy;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.figures.BlockFigure;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.part.SysmlVisualIDRegistry;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.providers.SysmlElementTypes;
import org.eclipse.uml2.uml.Element;

public class BlockEditPart extends ClassEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2001;

	/**
	 * @generated
	 */
	public BlockEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new BlockItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);

		installEditPolicy(EditPolicy.COMPONENT_ROLE, new SysMLViewComponentEditPolicy());
		removeEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
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
	 * @generated NOT
	 */
	protected boolean addFixedChild(EditPart childEditPart) {

		if(childEditPart instanceof BlockNameEditPart) {
			((BlockNameEditPart)childEditPart).setLabel(getPrimaryShape().getNameLabel());
			return true;
		}

		if(childEditPart instanceof BlockOperationCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getOperationCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((BlockOperationCompartmentEditPart)childEditPart).getFigure());
			return true;
		}

		if(childEditPart instanceof BlockConstraintCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getConstraintCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((BlockConstraintCompartmentEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof BlockReferenceCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getReferenceCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((BlockReferenceCompartmentEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof BlockValueCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getValueCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((BlockValueCompartmentEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof BlockPartCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getPartCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((BlockPartCompartmentEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof BlockAttributeCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getAttributeCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((BlockAttributeCompartmentEditPart)childEditPart).getFigure());
			return true;
		}



		return false;
	}

	@Override
	public Element getUMLElement() {
		EObject eobject = resolveSemanticElement();
		if(eobject instanceof Block) {
			Block block = (Block)eobject;
			return block.getBase_Class();
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof BlockNameEditPart) {
			return true;
		}
		if(childEditPart instanceof BlockOperationCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getOperationCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((BlockOperationCompartmentEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof BlockConstraintCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getConstraintCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((BlockConstraintCompartmentEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof BlockReferenceCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getReferenceCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((BlockReferenceCompartmentEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof BlockValueCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getValueCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((BlockValueCompartmentEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof BlockPartCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getPartCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((BlockPartCompartmentEditPart)childEditPart).getFigure());
			return true;
		}

		if(childEditPart instanceof BlockAttributeCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getAttributeCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((BlockAttributeCompartmentEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof BlockOperationCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getOperationCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((BlockOperationCompartmentEditPart)childEditPart).getFigure());
			return true;
		}
		return false;
	}


	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if(editPart instanceof BlockOperationCompartmentEditPart) {
			return getPrimaryShape().getOperationCompartmentFigure();
		}
		if(editPart instanceof BlockConstraintCompartmentEditPart) {
			return getPrimaryShape().getConstraintCompartmentFigure();
		}
		if(editPart instanceof BlockReferenceCompartmentEditPart) {
			return getPrimaryShape().getReferenceCompartmentFigure();
		}
		if(editPart instanceof BlockValueCompartmentEditPart) {
			return getPrimaryShape().getValueCompartmentFigure();
		}
		if(editPart instanceof BlockPartCompartmentEditPart) {
			return getPrimaryShape().getPartCompartmentFigure();
		}
		if(editPart instanceof BlockAttributeCompartmentEditPart) {
			return getPrimaryShape().getAttributeCompartmentFigure();
		}
		return getContentPane();
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
	public EditPart getTargetEditPart(Request request) {
		if(request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest)request).getViewAndElementDescriptor().getCreateElementRequestAdapter();
			IElementType type = (IElementType)adapter.getAdapter(IElementType.class);
			if(type == SysmlElementTypes.Property_3001) {
				return getChildBySemanticHint(SysmlVisualIDRegistry.getType(BlockAttributeCompartmentEditPart.VISUAL_ID));
			}
			if(type == SysmlElementTypes.Operation_3102) {
				return getChildBySemanticHint(SysmlVisualIDRegistry.getType(BlockOperationCompartmentEditPart.VISUAL_ID));
			}
			if(type == UMLElementTypes.Constraint_2011) {
				return getChildBySemanticHint(SysmlVisualIDRegistry.getType(BlockConstraintCompartmentEditPart.VISUAL_ID));
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
				prefColor = PreferenceConstantHelper.getElementConstant("Block", PreferenceConstantHelper.COLOR_LINE);
			} else if(feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("Block", PreferenceConstantHelper.COLOR_FONT);
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("Block", PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor(preferenceStore, prefColor));
		} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency() || feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant("Block", PreferenceConstantHelper.COLOR_GRADIENT);
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

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(ClassNameEditPart.VISUAL_ID));
	}

	/**
	 * Overrides to add the UML element
	 */
	@Override
	protected void addSemanticListeners() {
		super.addSemanticListeners();
		addListenerFilter("SemanticUMLElement", this, getUMLElement());
	}

	/**
	 * Overrides to remove the UML element
	 */
	@Override
	protected void removeSemanticListeners() {
		removeListenerFilter("SemanticUMLElement");
		super.removeSemanticListeners();
	}

	/**
	 * Overrides to add text wrap and text justification
	 */
	@Override
	protected IFigure createNodeShape() {
		BlockFigure blockfigure = new BlockFigure();
		WrappingLabel wrappingLabel = blockfigure.getNameLabel();
		wrappingLabel.setTextWrap(true);
		wrappingLabel.setTextJustification(PositionConstants.CENTER);
		return primaryShape = blockfigure;
	}

	/**
	 * @generated
	 */
	public BlockFigure getPrimaryShape() {
		return (BlockFigure)primaryShape;
	}
}
