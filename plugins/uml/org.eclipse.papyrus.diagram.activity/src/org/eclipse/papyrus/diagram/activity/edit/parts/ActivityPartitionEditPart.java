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
package org.eclipse.papyrus.diagram.activity.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EStructuralFeature;
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
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.papyrus.diagram.activity.draw2d.FlowLayoutAdvanced;
import org.eclipse.papyrus.diagram.activity.draw2d.FlowLayoutAdvancedConstraint;
import org.eclipse.papyrus.diagram.activity.edit.policies.ActivityPartitionItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.activity.edit.policies.OpenDiagramEditPolicy;
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.activity.preferences.IActivityPreferenceConstants;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.common.draw2d.LinesBorder;
import org.eclipse.papyrus.diagram.common.editparts.IPapyrusEditPart;
import org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeNodeLabelDisplayEditPolicy;
import org.eclipse.papyrus.diagram.common.editpolicies.ShowHideCompartmentEditPolicy;
import org.eclipse.papyrus.diagram.common.figure.node.CenteredWrappedLabel;
import org.eclipse.papyrus.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.papyrus.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.diagram.common.helper.StereotypeFigureHelper;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

/**
 * @generated NOT (Implement IPapyrusEditPart Used to apply stereotypes)
 */
public class ActivityPartitionEditPart extends

ShapeNodeEditPart implements IPapyrusEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3067;

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
	public ActivityPartitionEditPart(View view) {
		super(view);
	}

	/**
	 * Preferences Store
	 */
	protected IPreferenceStore store = UMLDiagramEditorPlugin.getInstance().getPreferenceStore();

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ActivityPartitionItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenDiagramEditPolicy());
		installEditPolicy(ShowHideCompartmentEditPolicy.SHOW_HIDE_COMPARTMENT_POLICY, new ShowHideCompartmentEditPolicy());
		installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeNodeLabelDisplayEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

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
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new ActivityPartitionDescriptor();
	}

	/**
	 * @generated
	 */
	public ActivityPartitionDescriptor getPrimaryShape() {
		return (ActivityPartitionDescriptor)primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof ActivityPartitionNameEditPart) {
			((ActivityPartitionNameEditPart)childEditPart).setLabel(getPrimaryShape().getPartitionLabel());
			return true;
		}


		if(childEditPart instanceof ActivityPartitionActivityPartitionContentCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getActivityPartitionCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((ActivityPartitionActivityPartitionContentCompartmentEditPart)childEditPart).getFigure());
			return true;
		}

		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof ActivityPartitionNameEditPart) {
			return true;
		}
		if(childEditPart instanceof ActivityPartitionActivityPartitionContentCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getActivityPartitionCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((ActivityPartitionActivityPartitionContentCompartmentEditPart)childEditPart).getFigure());
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
		if(editPart instanceof ActivityPartitionActivityPartitionContentCompartmentEditPart) {
			return getPrimaryShape().getActivityPartitionCompartment();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		String prefElementId = "ActivityPartition";
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(ActivityPartitionNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(1);
		types.add(UMLElementTypes.CommentAnnotatedElement_4006);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if(relationshipType == UMLElementTypes.CommentAnnotatedElement_4006) {
			types.add(UMLElementTypes.Comment_3080);
		}
		return types;
	}

	/**
	 * @generated NOT (Implement IPapyrusNodeUMLElementFigure in order to have stereotypes applied to it)
	 */
	public class ActivityPartitionDescriptor extends RectangleFigure implements IPapyrusNodeUMLElementFigure {

		/**
		 * @generated
		 */
		private RectangleFigure fActivityPartitionCompartment;

		/**
		 * @generated
		 */
		private CenteredWrappedLabel fPartitionLabel;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureCompartmentLabelActivityPartition;

		/** The helper which handles stereotype aspects */
		private StereotypeFigureHelper stereotypeHelper;


		/**
		 * @generated NOT Instanciate stereotypeHelper
		 */
		public ActivityPartitionDescriptor() {

			FlowLayoutAdvanced layoutThis = new FlowLayoutAdvanced();




			layoutThis.setStretchMinorAxis(true);




			layoutThis.setMinorAlignment(FlowLayout.ALIGN_CENTER);




			layoutThis.setMajorAlignment(FlowLayout.ALIGN_TOPLEFT);




			layoutThis.setMajorSpacing(0);




			layoutThis.setMinorSpacing(0);




			layoutThis.setHorizontal(false);


			this.setLayoutManager(layoutThis);
			//Look for the default preference
			this.setAlpha(new Integer(store.getInt(IActivityPreferenceConstants.PREF_ACTIVITY_PARTITION_ALPHA)));
			//Add a listener to update the alpha value from preferences
			store.addPropertyChangeListener(new IPropertyChangeListener() {

				public void propertyChange(PropertyChangeEvent event) {
					if(IActivityPreferenceConstants.PREF_ACTIVITY_PARTITION_ALPHA.equals(event.getProperty())) {
						if(getFigure() != null) {
							setAlpha(store.getInt(IActivityPreferenceConstants.PREF_ACTIVITY_PARTITION_ALPHA));
						}
					}
				}
			});
			this.setFill(true);
			this.setOutline(false);
			this.setBorder(createBorder0());
			createContents();
			/*
			 * Create the helper which will help to display stereotype
			 */
			stereotypeHelper = new StereotypeFigureHelper(this) {

				@Override
				public IMapMode getMapMode() {
					return ActivityPartitionEditPart.this.getMapMode();
				}

				@Override
				public Object getStereotypeRectangleConstraint() {
					/**
					 * FIXME Test to put to null
					 */
					FlowLayoutAdvancedConstraint constraint = new FlowLayoutAdvancedConstraint();
					constraint.setFill(false);
					return constraint;
				}

				@Override
				protected void init() {
					super.init();
					setBottomInset(0);
					setLeftInset(0);
					setTopInset(0);
					setRightInset(0);
					setStereotypeContainerFilled(true);
				}


			};
		}

		/**
		 * Outline the shape without drawing the bottom border
		 * 
		 * @see Shape#outlineShape(Graphics)
		 * @generated NOT
		 */
		protected void outlineShape(Graphics graphics) {
			float lineInset = Math.max(1.0f, getLineWidthFloat()) / 2.0f;
			int inset1 = (int)Math.floor(lineInset);
			int inset2 = (int)Math.ceil(lineInset);

			Rectangle r = Rectangle.SINGLETON.setBounds(getBounds());
			r.x += inset1;
			r.y += inset1;
			r.width -= inset1 + inset2;
			r.height -= inset1 + inset2;

			graphics.drawRectangle(r);
			// draw lines instead of the complete rectangle
			PointList points = new PointList(4);
			points.addPoint(r.getBottomLeft());
			points.addPoint(r.getTopLeft());
			points.addPoint(r.getTopRight());
			points.addPoint(r.getBottomRight());
			graphics.drawPolyline(points);
		}

		/**
		 * @generated
		 */
		private void createContents() {


			fFigureCompartmentLabelActivityPartition = new RectangleFigure();
			fFigureCompartmentLabelActivityPartition.setOutline(false);
			fFigureCompartmentLabelActivityPartition.setLineWidth(0);
			fFigureCompartmentLabelActivityPartition.setBorder(createBorder1());

			this.add(fFigureCompartmentLabelActivityPartition);

			FlowLayout layoutFFigureCompartmentLabelActivityPartition = new FlowLayout();
			layoutFFigureCompartmentLabelActivityPartition.setStretchMinorAxis(true);
			layoutFFigureCompartmentLabelActivityPartition.setMinorAlignment(FlowLayout.ALIGN_CENTER);

			layoutFFigureCompartmentLabelActivityPartition.setMajorAlignment(FlowLayout.ALIGN_CENTER);
			layoutFFigureCompartmentLabelActivityPartition.setMajorSpacing(0);
			layoutFFigureCompartmentLabelActivityPartition.setMinorSpacing(0);
			layoutFFigureCompartmentLabelActivityPartition.setHorizontal(true);

			fFigureCompartmentLabelActivityPartition.setLayoutManager(layoutFFigureCompartmentLabelActivityPartition);



			fPartitionLabel = new CenteredWrappedLabel();



			fFigureCompartmentLabelActivityPartition.add(fPartitionLabel);




			fActivityPartitionCompartment = new RectangleFigure();
			fActivityPartitionCompartment.setFill(false);
			fActivityPartitionCompartment.setOutline(false);
			fActivityPartitionCompartment.setLineWidth(0);

			FlowLayoutAdvancedConstraint constraintFActivityPartitionCompartment = new FlowLayoutAdvancedConstraint();




			constraintFActivityPartitionCompartment.setFill(true);



			this.add(fActivityPartitionCompartment, constraintFActivityPartitionCompartment);


		}

		/**
		 * @generated
		 */
		private Border createBorder0() {
			LinesBorder result = new LinesBorder();




			result.setSides(PositionConstants.TOP | PositionConstants.LEFT | PositionConstants.RIGHT);



			return result;
		}

		/**
		 * @generated
		 */
		private Border createBorder1() {
			LinesBorder result = new LinesBorder();




			result.setSides(PositionConstants.BOTTOM);




			result.setLeftInset(5);




			result.setRightInset(5);




			result.setTopInset(5);




			result.setBottomInset(5);



			return result;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getActivityPartitionCompartment() {
			return fActivityPartitionCompartment;
		}

		/**
		 * @generated
		 */
		public CenteredWrappedLabel getPartitionLabel() {
			return fPartitionLabel;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureCompartmentLabelActivityPartition() {
			return fFigureCompartmentLabelActivityPartition;
		}

		/**
		 * 
		 * @see org.eclipse.papyrus.diagram.common.figure.node.IPapyrusUMLElementFigure#setStereotypeDisplay(java.lang.String,
		 *      org.eclipse.swt.graphics.Image)
		 * 
		 * @param stereotypes
		 * @param image
		 */
		public void setStereotypeDisplay(String stereotypes, Image image) {

			stereotypeHelper.setStereotypeDisplay(stereotypes, image);
			this.layout();


		}

		/**
		 * 
		 * @see org.eclipse.papyrus.diagram.common.figure.node.IPapyrusNodeUMLElementFigure#setStereotypePropertiesInBrace(java.lang.String)
		 * 
		 * @param stereotypeProperties
		 */
		public void setStereotypePropertiesInBrace(String stereotypeProperties) {
			stereotypeHelper.setStereotypePropertiesInBrace(stereotypeProperties);
			this.layout();


		}

		/**
		 * 
		 * @see org.eclipse.papyrus.diagram.common.figure.node.IPapyrusNodeUMLElementFigure#setStereotypePropertiesInCompartment(java.lang.String)
		 * 
		 * @param stereotypeProperties
		 */
		public void setStereotypePropertiesInCompartment(String stereotypeProperties) {

			stereotypeHelper.setStereotypePropertiesInCompartment(stereotypeProperties);
			this.layout();

		}

		/**
		 * 
		 * @see org.eclipse.papyrus.diagram.common.figure.node.IPapyrusNodeUMLElementFigure#getStereotypesLabel()
		 * 
		 * @return
		 */
		@Deprecated
		public Label getStereotypesLabel() {

			return null;
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
				prefColor = PreferenceConstantHelper.getElementConstant("ActivityPartition", PreferenceConstantHelper.COLOR_LINE);
			} else if(feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("ActivityPartition", PreferenceConstantHelper.COLOR_FONT);
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("ActivityPartition", PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore)preferenceStore, prefColor));
		} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency() || feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant("ActivityPartition", PreferenceConstantHelper.COLOR_GRADIENT);
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
