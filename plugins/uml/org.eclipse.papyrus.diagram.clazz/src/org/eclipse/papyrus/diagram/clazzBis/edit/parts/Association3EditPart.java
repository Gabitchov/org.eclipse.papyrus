package org.eclipse.papyrus.diagram.clazzBis.edit.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.figure.edge.CAssociationBranchFigure;

/**
 * @generated
 */
public class Association3EditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3004;

	/**
	 * @generated
	 */
	public Association3EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new org.eclipse.papyrus.diagram.clazzBis.edit.policies.Association3ItemSemanticEditPolicy());
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
		return new AssociationBranchDescriptor();
	}

	/**
	 * @generated
	 */
	public AssociationBranchDescriptor getPrimaryShape() {
		return (AssociationBranchDescriptor) getFigure();
	}

	/**
	 * @generated
	 */
	public class AssociationBranchDescriptor extends CAssociationBranchFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fRoleLabel;

		/**
		 * @generated
		 */
		private WrappingLabel fMultiplicityLabel;

		/**
		 * @generated
		 */
		public AssociationBranchDescriptor() {

			this.setForegroundColor(ColorConstants.black);
			this.setBackgroundColor(ColorConstants.black);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fRoleLabel = new WrappingLabel();
			fRoleLabel.setText("");

			this.add(fRoleLabel);

			fMultiplicityLabel = new WrappingLabel();
			fMultiplicityLabel.setText("");

			this.add(fMultiplicityLabel);

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
		public WrappingLabel getRoleLabel() {
			return fRoleLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getMultiplicityLabel() {
			return fMultiplicityLabel;
		}

	}

}
