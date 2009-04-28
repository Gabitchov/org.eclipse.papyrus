package org.eclipse.papyrus.diagram.clazzBis.edit.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.figure.edge.CAssociationFigure;

/**
 * @generated
 */
public class Association2EditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3003;

	/**
	 * @generated
	 */
	public Association2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new org.eclipse.papyrus.diagram.clazzBis.edit.policies.Association2ItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationNameEditPart) {
			((org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationNameEditPart) childEditPart).setLabel(getPrimaryShape().getAppliedStereotypeAssociationLabel());
			return true;
		}
		if (childEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName2EditPart) {
			((org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName2EditPart) childEditPart).setLabel(getPrimaryShape().getAssociationNameLabel());
			return true;
		}
		if (childEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName3EditPart) {
			((org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName3EditPart) childEditPart).setLabel(getPrimaryShape().getRoleSourceLabel());
			return true;
		}
		if (childEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName4EditPart) {
			((org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName4EditPart) childEditPart).setLabel(getPrimaryShape().getMultiplicitySourceLabel());
			return true;
		}
		if (childEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName5EditPart) {
			((org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName5EditPart) childEditPart).setLabel(getPrimaryShape().getMultiplicityTargetLabel());
			return true;
		}
		if (childEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName6EditPart) {
			((org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName6EditPart) childEditPart).setLabel(getPrimaryShape().getRoleTargetLabel());
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
		if (childEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationNameEditPart) {
			return true;
		}
		if (childEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName2EditPart) {
			return true;
		}
		if (childEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName3EditPart) {
			return true;
		}
		if (childEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName4EditPart) {
			return true;
		}
		if (childEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName5EditPart) {
			return true;
		}
		if (childEditPart instanceof org.eclipse.papyrus.diagram.clazzBis.edit.parts.AssociationName6EditPart) {
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
		return new AssociationDescriptor();
	}

	/**
	 * @generated
	 */
	public AssociationDescriptor getPrimaryShape() {
		return (AssociationDescriptor) getFigure();
	}

	/**
	 * @generated
	 */
	public class AssociationDescriptor extends CAssociationFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fAssociationNameLabel;

		/**
		 * @generated
		 */
		private WrappingLabel fAppliedStereotypeAssociationLabel;

		/**
		 * @generated
		 */
		private WrappingLabel fRoleSourceLabel;

		/**
		 * @generated
		 */
		private WrappingLabel fMultiplicitySourceLabel;

		/**
		 * @generated
		 */
		private WrappingLabel fRoleTargetLabel;

		/**
		 * @generated
		 */
		private WrappingLabel fMultiplicityTargetLabel;

		/**
		 * @generated
		 */
		public AssociationDescriptor() {

			this.setForegroundColor(ColorConstants.black);
			this.setBackgroundColor(ColorConstants.black);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fAssociationNameLabel = new WrappingLabel();
			fAssociationNameLabel.setText("");

			this.add(fAssociationNameLabel);

			fAppliedStereotypeAssociationLabel = new WrappingLabel();
			fAppliedStereotypeAssociationLabel.setText("");

			this.add(fAppliedStereotypeAssociationLabel);

			fRoleSourceLabel = new WrappingLabel();
			fRoleSourceLabel.setText("");

			this.add(fRoleSourceLabel);

			fMultiplicitySourceLabel = new WrappingLabel();
			fMultiplicitySourceLabel.setText("");

			this.add(fMultiplicitySourceLabel);

			fRoleTargetLabel = new WrappingLabel();
			fRoleTargetLabel.setText("");

			this.add(fRoleTargetLabel);

			fMultiplicityTargetLabel = new WrappingLabel();
			fMultiplicityTargetLabel.setText("");

			this.add(fMultiplicityTargetLabel);

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
		public WrappingLabel getAssociationNameLabel() {
			return fAssociationNameLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getAppliedStereotypeAssociationLabel() {
			return fAppliedStereotypeAssociationLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getRoleSourceLabel() {
			return fRoleSourceLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getMultiplicitySourceLabel() {
			return fMultiplicitySourceLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getRoleTargetLabel() {
			return fRoleTargetLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getMultiplicityTargetLabel() {
			return fMultiplicityTargetLabel;
		}

	}

}
