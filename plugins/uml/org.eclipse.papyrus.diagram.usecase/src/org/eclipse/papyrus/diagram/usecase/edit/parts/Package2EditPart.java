package org.eclipse.papyrus.diagram.usecase.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
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
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.papyrus.diagram.common.figure.node.CPackageFigure;
import org.eclipse.papyrus.diagram.usecase.edit.policies.OpenDiagramEditPolicy;
import org.eclipse.papyrus.diagram.usecase.edit.policies.Package2ItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.usecase.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.usecase.preferences.IPapyrusPreferencesConstant;
import org.eclipse.papyrus.diagram.usecase.providers.UMLElementTypes;
import org.eclipse.papyrus.preferences.utils.GradientPreferenceConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

/**
 * @generated
 */
public class Package2EditPart extends

ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2016;

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
	public Package2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new Package2ItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenDiagramEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
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
		PackageFigureDescriptor figure = new PackageFigureDescriptor();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public PackageFigureDescriptor getPrimaryShape() {
		return (PackageFigureDescriptor) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof PackageNameEditPart) {
			((PackageNameEditPart) childEditPart).setLabel(getPrimaryShape().getPackageNameLabel());
			return true;
		}

		if (childEditPart instanceof PackagePackageableElementCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getPackageableElementFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((PackagePackageableElementCompartmentEditPart) childEditPart).getFigure());
			return true;
		}

		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof PackageNameEditPart) {
			return true;
		}

		if (childEditPart instanceof PackagePackageableElementCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getPackageableElementFigure();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((PackagePackageableElementCompartmentEditPart) childEditPart).getFigure());
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

		if (editPart instanceof PackagePackageableElementCompartmentEditPart) {
			return getPrimaryShape().getPackageableElementFigure();
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
		return getChildBySemanticHint(UMLVisualIDRegistry.getType(PackageNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSource() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.Dependency_4013);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (targetEditPart instanceof ActorEditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if (targetEditPart instanceof Actor2EditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if (targetEditPart instanceof UseCaseEditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if (targetEditPart instanceof UseCase2EditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if (targetEditPart instanceof ComponentEditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if (targetEditPart instanceof org.eclipse.papyrus.diagram.usecase.edit.parts.Package2EditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if (targetEditPart instanceof ConstraintEditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if (targetEditPart instanceof UseCase3EditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if (targetEditPart instanceof Component2EditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if (targetEditPart instanceof Constraint2EditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if (targetEditPart instanceof Actor4EditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if (targetEditPart instanceof Package4EditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if (targetEditPart instanceof Constraint3EditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if (targetEditPart instanceof Actor3EditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if (targetEditPart instanceof UseCase4EditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if (targetEditPart instanceof Component3EditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		if (targetEditPart instanceof Package3EditPart) {
			types.add(UMLElementTypes.Dependency_4013);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForTarget(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Actor_2011);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Actor_2012);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.UseCase_2013);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.UseCase_2014);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Component_2015);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Package_2016);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Constraint_2017);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.UseCase_3009);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Component_3016);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Constraint_3017);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Actor_3018);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Package_3019);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Constraint_3010);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Actor_3011);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.UseCase_3012);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Component_3013);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Package_3014);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(UMLElementTypes.ConstraintConstrainedElement_4012);
		types.add(UMLElementTypes.Dependency_4013);
		types.add(UMLElementTypes.CommentAnnotatedElement_4014);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForSource(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == UMLElementTypes.ConstraintConstrainedElement_4012) {
			types.add(UMLElementTypes.Constraint_2017);
		}
		if (relationshipType == UMLElementTypes.ConstraintConstrainedElement_4012) {
			types.add(UMLElementTypes.Constraint_3017);
		}
		if (relationshipType == UMLElementTypes.ConstraintConstrainedElement_4012) {
			types.add(UMLElementTypes.Constraint_3010);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Actor_2011);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Actor_2012);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.UseCase_2013);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.UseCase_2014);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Component_2015);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Package_2016);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Constraint_2017);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.UseCase_3009);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Component_3016);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Constraint_3017);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Actor_3018);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Package_3019);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Constraint_3010);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Actor_3011);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.UseCase_3012);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Component_3013);
		}
		if (relationshipType == UMLElementTypes.Dependency_4013) {
			types.add(UMLElementTypes.Package_3014);
		}
		if (relationshipType == UMLElementTypes.CommentAnnotatedElement_4014) {
			types.add(UMLElementTypes.Comment_2018);
		}
		if (relationshipType == UMLElementTypes.CommentAnnotatedElement_4014) {
			types.add(UMLElementTypes.Comment_3015);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class PackageFigureDescriptor extends CPackageFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fPackageNameLabel;

		/**
		 * @generated
		 */
		private RectangleFigure fPackageableElementFigure;

		/**
		 * @generated
		 */
		private WrappingLabel fPackageQualifiedNameLabel;

		/**
		 * @generated
		 */
		private WrappingLabel fStereotypesLabel;

		/**
		 * @generated
		 */
		public PackageFigureDescriptor() {

			this.setForegroundColor(THIS_FORE);
			this.setBackgroundColor(THIS_BACK);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fStereotypesLabel = new WrappingLabel();
			fStereotypesLabel.setText("");

			fStereotypesLabel.setFont(FSTEREOTYPESLABEL_FONT);

			this.add(fStereotypesLabel);

			fPackageNameLabel = new WrappingLabel();
			fPackageNameLabel.setText("");

			fPackageNameLabel.setFont(FPACKAGENAMELABEL_FONT);

			this.add(fPackageNameLabel);

			fPackageQualifiedNameLabel = new WrappingLabel();
			fPackageQualifiedNameLabel.setText("");

			fPackageQualifiedNameLabel.setFont(FPACKAGEQUALIFIEDNAMELABEL_FONT);

			this.add(fPackageQualifiedNameLabel);

			fPackageableElementFigure = new RectangleFigure();
			fPackageableElementFigure.setLineWidth(1);

			this.add(fPackageableElementFigure);

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
		public WrappingLabel getPackageNameLabel() {
			return fPackageNameLabel;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getPackageableElementFigure() {
			return fPackageableElementFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getPackageQualifiedNameLabel() {
			return fPackageQualifiedNameLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getStereotypesLabel() {
			return fStereotypesLabel;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_FORE = new Color(null, 233, 164, 96);

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 255, 199, 143);

	/**
	 * @generated
	 */
	static final Font FSTEREOTYPESLABEL_FONT = new Font(Display.getCurrent(), "Arial", 8, SWT.NORMAL);

	/**
	 * @generated
	 */
	static final Font FPACKAGENAMELABEL_FONT = new Font(Display.getCurrent(), "Arial", 10, SWT.BOLD);

	/**
	 * @generated
	 */
	static final Font FPACKAGEQUALIFIEDNAMELABEL_FONT = new Font(Display.getCurrent(), "Arial", 8, SWT.ITALIC);

	/**
	 * @generated
	 */
	@Override
	public Object getPreferredValue(EStructuralFeature feature) {
		IPreferenceStore preferenceStore = (IPreferenceStore) getDiagramPreferencesHint().getPreferenceStore();
		if (preferenceStore instanceof IPreferenceStore) {
			if (feature == NotationPackage.eINSTANCE.getLineStyle_LineColor()) {

				return FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore) preferenceStore, IPapyrusPreferencesConstant.PACKAGE_PREF_LINE_COLOR));

			} else if (feature == NotationPackage.eINSTANCE.getFontStyle_FontColor()) {

				return FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore) preferenceStore, IPapyrusPreferencesConstant.PACKAGE_PREF_FONT_COLOR));

			} else if (feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {

				return FigureUtilities.RGBToInteger(PreferenceConverter.getColor((IPreferenceStore) preferenceStore, IPapyrusPreferencesConstant.PACKAGE_PREF_FILL_COLOR));

			} else if (feature == NotationPackage.eINSTANCE.getFillStyle_Transparency()) {
				GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(preferenceStore.getString(IPapyrusPreferencesConstant.PACKAGE_PREF_GRADIENT_COLOR));

				return new Integer(gradientPreferenceConverter.getTransparency());
			} else if (feature == NotationPackage.eINSTANCE.getFillStyle_Gradient()) {
				GradientPreferenceConverter gradientPreferenceConverter = new GradientPreferenceConverter(preferenceStore.getString(IPapyrusPreferencesConstant.PACKAGE_PREF_GRADIENT_COLOR));

				return gradientPreferenceConverter.getGradientData();
			}
		}

		return getStructuralFeatureValue(feature);

	}

}
