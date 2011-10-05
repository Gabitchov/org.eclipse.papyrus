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

import org.eclipse.gmf.runtime.notation.View;


/**
 * @generated
 */
public class OperationEditPart extends

org.eclipse.papyrus.diagram.clazz.edit.parts.OperationEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3102;

	/**
	 * @generated
	 */
	public OperationEditPart(View view) {
		super(view);
	}

	//	/**
	//	 * @generated
	//	 */
	//	protected IFigure contentPane;
	//
	//	/**
	//	 * @generated
	//	 */
	//	protected IFigure primaryShape;
	//
	//	/**
	//	 * @generated
	//	 */
	//	public OperationEditPart(View view) {
	//		super(view);
	//	}
	//
	//	/**
	//	 * @generated
	//	 */
	//	protected void createDefaultEditPolicies() {
	//		super.createDefaultEditPolicies();
	//		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new OperationItemSemanticEditPolicy());
	//		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
	//		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
	//		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	//	}
	//
	//	/**
	//	 * @generated
	//	 */
	//	protected LayoutEditPolicy createLayoutEditPolicy() {
	//		LayoutEditPolicy lep = new LayoutEditPolicy() {
	//
	//			protected EditPolicy createChildEditPolicy(EditPart child) {
	//				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
	//				if(result == null) {
	//					result = new NonResizableEditPolicy();
	//				}
	//				return result;
	//			}
	//
	//			protected Command getMoveChildrenCommand(Request request) {
	//				return null;
	//			}
	//
	//			protected Command getCreateCommand(CreateRequest request) {
	//				return null;
	//			}
	//		};
	//		return lep;
	//	}
	//
	//	/**
	//	 * @generated
	//	 */
	//	protected IFigure createNodeShape() {
	//		OperationFigureDescriptor figure = new OperationFigureDescriptor();
	//		return primaryShape = figure;
	//	}
	//
	//	/**
	//	 * @generated
	//	 */
	//	public OperationFigureDescriptor getPrimaryShape() {
	//		return (OperationFigureDescriptor)primaryShape;
	//	}
	//
	//	/**
	//	 * @generated
	//	 */
	//	protected NodeFigure createNodePlate() {
	//		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
	//		return result;
	//	}
	//
	//	/**
	//	 * Creates figure for this edit part.
	//	 * 
	//	 * Body of this method does not depend on settings in generation model
	//	 * so you may safely remove <i>generated</i> tag and modify it.
	//	 * 
	//	 * @generated
	//	 */
	//	protected NodeFigure createNodeFigure() {
	//		NodeFigure figure = createNodePlate();
	//		figure.setLayoutManager(new StackLayout());
	//		IFigure shape = createNodeShape();
	//		figure.add(shape);
	//		contentPane = setupContentPane(shape);
	//		return figure;
	//	}
	//
	//	/**
	//	 * Default implementation treats passed figure as content pane.
	//	 * Respects layout one may have set for generated figure.
	//	 * 
	//	 * @param nodeShape
	//	 *        instance of generated figure class
	//	 * @generated
	//	 */
	//	protected IFigure setupContentPane(IFigure nodeShape) {
	//		return nodeShape; // use nodeShape itself as contentPane
	//	}
	//
	//	/**
	//	 * @generated
	//	 */
	//	public IFigure getContentPane() {
	//		if(contentPane != null) {
	//			return contentPane;
	//		}
	//		return super.getContentPane();
	//	}
	//
	//	/**
	//	 * @generated
	//	 */
	//	protected void setForegroundColor(Color color) {
	//		if(primaryShape != null) {
	//			primaryShape.setForegroundColor(color);
	//		}
	//	}
	//
	//	/**
	//	 * @generated
	//	 */
	//	protected void setLineWidth(int width) {
	//		if(primaryShape instanceof Shape) {
	//			((Shape)primaryShape).setLineWidth(width);
	//		}
	//	}
	//
	//	/**
	//	 * @generated
	//	 */
	//	protected void setLineType(int style) {
	//		if(primaryShape instanceof Shape) {
	//			((Shape)primaryShape).setLineStyle(style);
	//		}
	//	}
	//
	//	/**
	//	 * @generated
	//	 */
	//	public class OperationFigureDescriptor extends WrappingLabel {
	//
	//		/**
	//		 * @generated
	//		 */
	//		public OperationFigureDescriptor() {
	//			this.setText("");
	//
	//			this.setFont(THIS_FONT);
	//
	//		}
	//
	//	}
	//
	//	/**
	//	 * @generated
	//	 */
	//	static final Font THIS_FONT = new Font(Display.getCurrent(), "Arial", 10, SWT.NORMAL);
	//
	//	/**
	//	 * @generated
	//	 */
	//	@Override
	//	public Object getPreferredValue(EStructuralFeature feature) {
	//		IPreferenceStore preferenceStore = (IPreferenceStore)getDiagramPreferencesHint().getPreferenceStore();
	//		Object result = null;
	//
	//		if(feature == NotationPackage.eINSTANCE.getLineStyle_LineColor() || feature == NotationPackage.eINSTANCE.getFontStyle_FontColor() || feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
	//			String prefColor = null;
	//			if(feature == NotationPackage.eINSTANCE.getLineStyle_LineColor()) {
	//				prefColor = PreferenceConstantHelper.getElementConstant("Operation", PreferenceConstantHelper.COLOR_LINE);
	//			} else if(feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
	//				prefColor = PreferenceConstantHelper.getElementConstant("Operation", PreferenceConstantHelper.COLOR_FONT);
	//			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
	//				prefColor = PreferenceConstantHelper.getElementConstant("Operation", PreferenceConstantHelper.COLOR_FILL);
	//			}
	//			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore)preferenceStore, prefColor));
	//		} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency() || feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
	//			String prefGradient = PreferenceConstantHelper.getElementConstant("Operation", PreferenceConstantHelper.COLOR_GRADIENT);
	//			GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(preferenceStore.getString(prefGradient));
	//			if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency()) {
	//				result = new Integer(gradientPreferenceConverter.getTransparency());
	//			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
	//				result = gradientPreferenceConverter.getGradientData();
	//			}
	//		}
	//
	//		if(result == null) {
	//			result = getStructuralFeatureValue(feature);
	//		}
	//		return result;
	//	}
}
