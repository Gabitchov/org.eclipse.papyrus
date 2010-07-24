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
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.edit.parts;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.RootComponentEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.diagram.activity.edit.policies.ActivityCanonicalEditPolicy;
import org.eclipse.papyrus.diagram.activity.edit.policies.ActivityItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.activity.edit.policies.RemoveOrphanViewPolicy;
import org.eclipse.papyrus.diagram.activity.edit.policies.ResizeActivityEditPolicy;
import org.eclipse.papyrus.diagram.activity.locator.ActivityParameterNodePositionLocator;
import org.eclipse.papyrus.diagram.activity.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.common.editpolicies.BorderItemResizableEditPolicy;
import org.eclipse.papyrus.diagram.common.helper.PreferenceInitializerForElementHelper;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

/**
 * @generated
 */
public class ActivityEditPart extends

AbstractBorderedShapeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2001;

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
	public ActivityEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ActivityItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());


		//in Papyrus diagrams are not strongly synchronised
		//installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CANONICAL_ROLE, new org.eclipse.papyrus.diagram.activity.edit.policies.ActivityCanonicalEditPolicy());

		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new RootComponentEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new ResizeActivityEditPolicy());
		installEditPolicy("RemoveOrphanView", new RemoveOrphanViewPolicy()); //$NON-NLS-1$
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new ActivityCanonicalEditPolicy());
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
				case ActivityParameterNodeEditPart.VISUAL_ID:

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
		return primaryShape = new CustomActivityRectangleFigure();
	}

	/**
	 * @generated
	 */
	public CustomActivityRectangleFigure getPrimaryShape() {
		return (CustomActivityRectangleFigure)primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof ActivityNameEditPart) {
			((ActivityNameEditPart)childEditPart).setLabel(getPrimaryShape().getHeaderLabel());
			return true;
		}
		if(childEditPart instanceof ActivityIsSingleExecutionEditPart) {
			((ActivityIsSingleExecutionEditPart)childEditPart).setLabel(getPrimaryShape().getHeaderSingleExecution());
			return true;
		}


		if(childEditPart instanceof ActivityActivityParametersCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getActivityParametersCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((ActivityActivityParametersCompartmentEditPart)childEditPart).getFigure());
			return true;
		}

		if(childEditPart instanceof ActivityActivityPreConditionsCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getActivityPreconditionsCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((ActivityActivityPreConditionsCompartmentEditPart)childEditPart).getFigure());
			return true;
		}

		if(childEditPart instanceof ActivityActivityPostConditionsCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getActivityPostconditionsCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((ActivityActivityPostConditionsCompartmentEditPart)childEditPart).getFigure());
			return true;
		}

		if(childEditPart instanceof ActivityActivityContentCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((ActivityActivityContentCompartmentEditPart)childEditPart).getFigure());
			return true;
		}





		//Papyrus Gencode :Affixed Activity Parameter Node locator for Activity
		if(childEditPart instanceof ActivityParameterNodeEditPart) {
			IBorderItemLocator locator = new ActivityParameterNodePositionLocator(getMainFigure(), PositionConstants.NONE);
			getBorderedFigure().getBorderItemContainer().add(((ActivityParameterNodeEditPart)childEditPart).getFigure(), locator);
			return true;
		}




		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof ActivityNameEditPart) {
			return true;
		}
		if(childEditPart instanceof ActivityIsSingleExecutionEditPart) {
			return true;
		}
		if(childEditPart instanceof ActivityActivityParametersCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getActivityParametersCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((ActivityActivityParametersCompartmentEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof ActivityActivityPreConditionsCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getActivityPreconditionsCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((ActivityActivityPreConditionsCompartmentEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof ActivityActivityPostConditionsCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getActivityPostconditionsCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((ActivityActivityPostConditionsCompartmentEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof ActivityActivityContentCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getCompartmentFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((ActivityActivityContentCompartmentEditPart)childEditPart).getFigure());
			return true;
		}
		if(childEditPart instanceof ActivityParameterNodeEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(((ActivityParameterNodeEditPart)childEditPart).getFigure());
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
		if(editPart instanceof ActivityActivityParametersCompartmentEditPart) {
			return getPrimaryShape().getActivityParametersCompartment();
		}
		if(editPart instanceof ActivityActivityPreConditionsCompartmentEditPart) {
			return getPrimaryShape().getActivityPreconditionsCompartment();
		}
		if(editPart instanceof ActivityActivityPostConditionsCompartmentEditPart) {
			return getPrimaryShape().getActivityPostconditionsCompartment();
		}
		if(editPart instanceof ActivityActivityContentCompartmentEditPart) {
			return getPrimaryShape().getCompartmentFigure();
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
		String prefElementId = "Activity";
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(ActivityNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public EditPart getTargetEditPart(Request request) {
		if(request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest)request).getViewAndElementDescriptor().getCreateElementRequestAdapter();
			IElementType type = (IElementType)adapter.getAdapter(IElementType.class);
			if(type == UMLElementTypes.Parameter_3001) {
				return getChildBySemanticHint(UMLVisualIDRegistry.getType(ActivityActivityParametersCompartmentEditPart.VISUAL_ID));
			}
			if(type == UMLElementTypes.Constraint_3002) {
				return getChildBySemanticHint(UMLVisualIDRegistry.getType(ActivityActivityPreConditionsCompartmentEditPart.VISUAL_ID));
			}
			if(type == UMLElementTypes.Constraint_3003) {
				return getChildBySemanticHint(UMLVisualIDRegistry.getType(ActivityActivityPostConditionsCompartmentEditPart.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
	}

	/**
	 * @generated
	 */
	public class CustomActivityRectangleFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fHeaderLabel;

		/**
		 * @generated
		 */
		private RectangleFigure fActivityParametersCompartment;

		/**
		 * @generated
		 */
		private RectangleFigure fActivityPreconditionsCompartment;

		/**
		 * @generated
		 */
		private RectangleFigure fActivityPostconditionsCompartment;

		/**
		 * @generated
		 */
		private WrappingLabel fHeaderSingleExecution;

		/**
		 * @generated
		 */
		private RectangleFigure fCompartmentFigure;

		/**
		 * @generated
		 */
		public CustomActivityRectangleFigure() {

			BorderLayout layoutThis = new BorderLayout();
			layoutThis.setHorizontalSpacing(0);// TODO mapMode?
			layoutThis.setVerticalSpacing(0);
			this.setLayoutManager(layoutThis);

			this.setFill(false);
			this.setOutline(false);
			this.setLineWidth(0);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(857), getMapMode().DPtoLP(757)));
			this.setBorder(new MarginBorder(getMapMode().DPtoLP(30), getMapMode().DPtoLP(30), getMapMode().DPtoLP(30), getMapMode().DPtoLP(30)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {


			RoundedRectangle activityBorderFigure0 = new RoundedRectangle();
			activityBorderFigure0.setCornerDimensions(new Dimension(getMapMode().DPtoLP(8), getMapMode().DPtoLP(8)));

			this.add(activityBorderFigure0, BorderLayout.CENTER);

			GridLayout layoutActivityBorderFigure0 = new GridLayout();
			layoutActivityBorderFigure0.numColumns = 3;
			layoutActivityBorderFigure0.makeColumnsEqualWidth = false;
			layoutActivityBorderFigure0.horizontalSpacing = 0;
			layoutActivityBorderFigure0.verticalSpacing = 0;
			layoutActivityBorderFigure0.marginWidth = 0;
			layoutActivityBorderFigure0.marginHeight = 0;
			activityBorderFigure0.setLayoutManager(layoutActivityBorderFigure0);



			RectangleFigure labelAndParameter1 = new RectangleFigure();
			labelAndParameter1.setFill(false);
			labelAndParameter1.setOutline(false);
			labelAndParameter1.setLineWidth(0);


			GridData constraintLabelAndParameter1 = new GridData();
			constraintLabelAndParameter1.verticalAlignment = GridData.CENTER;
			constraintLabelAndParameter1.horizontalAlignment = GridData.BEGINNING;
			constraintLabelAndParameter1.horizontalIndent = 0;
			constraintLabelAndParameter1.horizontalSpan = 1;
			constraintLabelAndParameter1.verticalSpan = 1;
			constraintLabelAndParameter1.grabExcessHorizontalSpace = true;
			constraintLabelAndParameter1.grabExcessVerticalSpace = false;
			activityBorderFigure0.add(labelAndParameter1, constraintLabelAndParameter1);


			GridLayout layoutLabelAndParameter1 = new GridLayout();
			layoutLabelAndParameter1.numColumns = 1;
			layoutLabelAndParameter1.makeColumnsEqualWidth = true;
			labelAndParameter1.setLayoutManager(layoutLabelAndParameter1);



			fHeaderLabel = new WrappingLabel();
			fHeaderLabel.setText("ActivityName");

			fHeaderLabel.setFont(FHEADERLABEL_FONT);




			GridData constraintFHeaderLabel = new GridData();
			constraintFHeaderLabel.verticalAlignment = GridData.CENTER;
			constraintFHeaderLabel.horizontalAlignment = GridData.BEGINNING;
			constraintFHeaderLabel.horizontalIndent = 4;
			constraintFHeaderLabel.horizontalSpan = 1;
			constraintFHeaderLabel.verticalSpan = 1;
			constraintFHeaderLabel.grabExcessHorizontalSpace = true;
			constraintFHeaderLabel.grabExcessVerticalSpace = false;
			labelAndParameter1.add(fHeaderLabel, constraintFHeaderLabel);




			fActivityParametersCompartment = new RectangleFigure();
			fActivityParametersCompartment.setFill(false);
			fActivityParametersCompartment.setOutline(false);
			fActivityParametersCompartment.setLineWidth(0);


			GridData constraintFActivityParametersCompartment = new GridData();
			constraintFActivityParametersCompartment.verticalAlignment = GridData.CENTER;
			constraintFActivityParametersCompartment.horizontalAlignment = GridData.BEGINNING;
			constraintFActivityParametersCompartment.horizontalIndent = 0;
			constraintFActivityParametersCompartment.horizontalSpan = 1;
			constraintFActivityParametersCompartment.verticalSpan = 1;
			constraintFActivityParametersCompartment.grabExcessHorizontalSpace = true;
			constraintFActivityParametersCompartment.grabExcessVerticalSpace = false;
			labelAndParameter1.add(fActivityParametersCompartment, constraintFActivityParametersCompartment);

			fActivityParametersCompartment.setLayoutManager(new StackLayout());




			RectangleFigure prePostContions1 = new RectangleFigure();
			prePostContions1.setFill(false);
			prePostContions1.setOutline(false);
			prePostContions1.setLineWidth(0);


			GridData constraintPrePostContions1 = new GridData();
			constraintPrePostContions1.verticalAlignment = GridData.CENTER;
			constraintPrePostContions1.horizontalAlignment = GridData.BEGINNING;
			constraintPrePostContions1.horizontalIndent = 0;
			constraintPrePostContions1.horizontalSpan = 1;
			constraintPrePostContions1.verticalSpan = 1;
			constraintPrePostContions1.grabExcessHorizontalSpace = true;
			constraintPrePostContions1.grabExcessVerticalSpace = false;
			activityBorderFigure0.add(prePostContions1, constraintPrePostContions1);


			GridLayout layoutPrePostContions1 = new GridLayout();
			layoutPrePostContions1.numColumns = 1;
			layoutPrePostContions1.makeColumnsEqualWidth = true;
			prePostContions1.setLayoutManager(layoutPrePostContions1);



			fActivityPreconditionsCompartment = new RectangleFigure();
			fActivityPreconditionsCompartment.setFill(false);
			fActivityPreconditionsCompartment.setOutline(false);
			fActivityPreconditionsCompartment.setLineWidth(0);


			GridData constraintFActivityPreconditionsCompartment = new GridData();
			constraintFActivityPreconditionsCompartment.verticalAlignment = GridData.CENTER;
			constraintFActivityPreconditionsCompartment.horizontalAlignment = GridData.BEGINNING;
			constraintFActivityPreconditionsCompartment.horizontalIndent = 0;
			constraintFActivityPreconditionsCompartment.horizontalSpan = 1;
			constraintFActivityPreconditionsCompartment.verticalSpan = 1;
			constraintFActivityPreconditionsCompartment.grabExcessHorizontalSpace = true;
			constraintFActivityPreconditionsCompartment.grabExcessVerticalSpace = false;
			prePostContions1.add(fActivityPreconditionsCompartment, constraintFActivityPreconditionsCompartment);

			fActivityPreconditionsCompartment.setLayoutManager(new StackLayout());



			fActivityPostconditionsCompartment = new RectangleFigure();
			fActivityPostconditionsCompartment.setFill(false);
			fActivityPostconditionsCompartment.setOutline(false);
			fActivityPostconditionsCompartment.setLineWidth(0);


			GridData constraintFActivityPostconditionsCompartment = new GridData();
			constraintFActivityPostconditionsCompartment.verticalAlignment = GridData.CENTER;
			constraintFActivityPostconditionsCompartment.horizontalAlignment = GridData.BEGINNING;
			constraintFActivityPostconditionsCompartment.horizontalIndent = 0;
			constraintFActivityPostconditionsCompartment.horizontalSpan = 1;
			constraintFActivityPostconditionsCompartment.verticalSpan = 1;
			constraintFActivityPostconditionsCompartment.grabExcessHorizontalSpace = true;
			constraintFActivityPostconditionsCompartment.grabExcessVerticalSpace = false;
			prePostContions1.add(fActivityPostconditionsCompartment, constraintFActivityPostconditionsCompartment);

			fActivityPostconditionsCompartment.setLayoutManager(new StackLayout());




			fHeaderSingleExecution = new WrappingLabel();
			fHeaderSingleExecution.setText("");
			fHeaderSingleExecution.setBorder(new MarginBorder(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0), getMapMode().DPtoLP(0), getMapMode().DPtoLP(8)));


			GridData constraintFHeaderSingleExecution = new GridData();
			constraintFHeaderSingleExecution.verticalAlignment = GridData.CENTER;
			constraintFHeaderSingleExecution.horizontalAlignment = GridData.BEGINNING;
			constraintFHeaderSingleExecution.horizontalIndent = 0;
			constraintFHeaderSingleExecution.horizontalSpan = 1;
			constraintFHeaderSingleExecution.verticalSpan = 2;
			constraintFHeaderSingleExecution.grabExcessHorizontalSpace = false;
			constraintFHeaderSingleExecution.grabExcessVerticalSpace = false;
			activityBorderFigure0.add(fHeaderSingleExecution, constraintFHeaderSingleExecution);




			fCompartmentFigure = new RectangleFigure();
			fCompartmentFigure.setFill(false);
			fCompartmentFigure.setOutline(false);
			fCompartmentFigure.setLineWidth(0);
			fCompartmentFigure.setBorder(new MarginBorder(getMapMode().DPtoLP(0), getMapMode().DPtoLP(4), getMapMode().DPtoLP(4), getMapMode().DPtoLP(4)));


			GridData constraintFCompartmentFigure = new GridData();
			constraintFCompartmentFigure.verticalAlignment = GridData.FILL;
			constraintFCompartmentFigure.horizontalAlignment = GridData.FILL;
			constraintFCompartmentFigure.horizontalIndent = 0;
			constraintFCompartmentFigure.horizontalSpan = 3;
			constraintFCompartmentFigure.verticalSpan = 1;
			constraintFCompartmentFigure.grabExcessHorizontalSpace = true;
			constraintFCompartmentFigure.grabExcessVerticalSpace = true;
			activityBorderFigure0.add(fCompartmentFigure, constraintFCompartmentFigure);




		}

		/**
		 * @generated
		 */
		public WrappingLabel getHeaderLabel() {
			return fHeaderLabel;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getActivityParametersCompartment() {
			return fActivityParametersCompartment;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getActivityPreconditionsCompartment() {
			return fActivityPreconditionsCompartment;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getActivityPostconditionsCompartment() {
			return fActivityPostconditionsCompartment;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getHeaderSingleExecution() {
			return fHeaderSingleExecution;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getCompartmentFigure() {
			return fCompartmentFigure;
		}

	}

	/**
	 * @generated
	 */
	static final Font FHEADERLABEL_FONT = new Font(Display.getCurrent(), Display.getDefault().getSystemFont().getFontData()[0].getName(), 8, SWT.BOLD);

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
				prefColor = PreferenceConstantHelper.getElementConstant("Activity", PreferenceConstantHelper.COLOR_LINE);
			} else if(feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("Activity", PreferenceConstantHelper.COLOR_FONT);
			} else if(feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
				prefColor = PreferenceConstantHelper.getElementConstant("Activity", PreferenceConstantHelper.COLOR_FILL);
			}
			result = FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore)preferenceStore, prefColor));
		} else if(feature == NotationPackage.eINSTANCE.getFillStyle_Transparency() || feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
			String prefGradient = PreferenceConstantHelper.getElementConstant("Activity", PreferenceConstantHelper.COLOR_GRADIENT);
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
