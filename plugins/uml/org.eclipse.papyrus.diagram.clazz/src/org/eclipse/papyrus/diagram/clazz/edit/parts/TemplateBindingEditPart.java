package org.eclipse.papyrus.diagram.clazz.edit.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.edit.policies.TemplateBindingItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.common.figure.edge.CInterfaceRealizationFigure;

/**
 * @generated
 */
public class TemplateBindingEditPart extends ConnectionNodeEditPart implements
		ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4015;

	/**
	 * @generated
	 */
	public TemplateBindingEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new TemplateBindingItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabelEditPart) {
			((WrappingLabelEditPart) childEditPart).setLabel(getPrimaryShape()
					.getInterfaceRealizationNameLabel());
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
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabelEditPart) {
			return true;
		}
		return false;
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
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */

	protected Connection createConnectionFigure() {
		return new InterfaceRealizationDescriptor();
	}

	/**
	 * @generated
	 */
	public InterfaceRealizationDescriptor getPrimaryShape() {
		return (InterfaceRealizationDescriptor) getFigure();
	}

	/**
	 * @generated
	 */
	public class InterfaceRealizationDescriptor extends
			CInterfaceRealizationFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fInterfaceRealizationNameLabel;
		/**
		 * @generated
		 */
		private WrappingLabel fAppliedStereotypeLabel;

		/**
		 * @generated
		 */
		public InterfaceRealizationDescriptor() {

			this.setForegroundColor(ColorConstants.black);
			this.setBackgroundColor(ColorConstants.black);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fInterfaceRealizationNameLabel = new WrappingLabel();
			fInterfaceRealizationNameLabel.setText("");

			this.add(fInterfaceRealizationNameLabel);

			fAppliedStereotypeLabel = new WrappingLabel();
			fAppliedStereotypeLabel.setText("");

			this.add(fAppliedStereotypeLabel);

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
		public WrappingLabel getInterfaceRealizationNameLabel() {
			return fInterfaceRealizationNameLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getAppliedStereotypeLabel() {
			return fAppliedStereotypeLabel;
		}

	}

}
