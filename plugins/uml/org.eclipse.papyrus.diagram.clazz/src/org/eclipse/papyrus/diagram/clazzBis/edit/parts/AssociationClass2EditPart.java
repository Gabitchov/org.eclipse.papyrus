package org.eclipse.papyrus.diagram.clazzBis.edit.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.figure.edge.CAssociationFigure;

/**
 * @generated
 */
public class AssociationClass2EditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3002;

	/**
	 * @generated
	 */
	public AssociationClass2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new org.eclipse.papyrus.diagram.clazzBis.edit.policies.AssociationClass2ItemSemanticEditPolicy());
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
