package org.eclipse.papyrus.sysml.diagram.parametric.commands;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultSemanticEditPolicy;
import org.eclipse.papyrus.sysml.blocks.BlocksPackage;
import org.eclipse.papyrus.sysml.blocks.NestedConnectorEnd;
import org.eclipse.papyrus.sysml.diagram.common.utils.ConstraintBlockHelper;
import org.eclipse.papyrus.sysml.service.types.utils.ConnectorUtils;
import org.eclipse.papyrus.uml.service.types.command.ConnectorReorientCommand;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.uml2.uml.util.UMLUtil.StereotypeApplicationHelper;

public class CustomBindingConnectorReorientCommand extends ConnectorReorientCommand {
	/**
	 * @generated
	 */
	private final int reorientDirection;

	/**
	 * @generated
	 */
	private final EObject source;

	/**
	 * @generated
	 */
	private final EObject target;

	/**
	 * @generated
	 */
	public CustomBindingConnectorReorientCommand(ReorientReferenceRelationshipRequestWithGraphical request) {
		super(request);
		reorientDirection = request.getDirection();
		source = reorientDirection == ReorientReferenceRelationshipRequest.REORIENT_SOURCE ? request.getNewRelationshipEnd() : request.getReferenceOwner();
		target = reorientDirection == ReorientReferenceRelationshipRequest.REORIENT_SOURCE ? request.getReferenceOwner() : request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		
		if(this.source == this.target) {
			return false;
		}
		
		Object connectorView = getRequest().getParameter(DefaultSemanticEditPolicy.GRAPHICAL_RECONNECTED_EDGE);
		if (connectorView instanceof org.eclipse.gmf.runtime.notation.Connector) {
			View sourceView = getSourceView();
			View targetView = getTargetView();
			
			if (this.source != null && this.target != null) {
				return ConstraintBlockHelper.isConstraintParameter((Element)source, sourceView) 
						|| ConstraintBlockHelper.isConstraintParameter((Element)target, targetView);
			}			
		}
		return false;
	}

	@Override
	/**
	 * Get the link to re-orient.
	 * 
	 * @return the edited {@link Connector}
	 */
	protected Connector getLink() {
		return (Connector)(getConnectorView()).getElement();
	}
	
	@Override
	protected void replaceOwner(Connector connector, StructuredClassifier newOwner) {
		
		View sourceView = getSourceView();		
		View targetView = getTargetView();

		StructuredClassifier deducedContainer = new ConnectorUtils().deduceContainer(sourceView, targetView);
		if (connector.getOwner() != deducedContainer) {
			super.replaceOwner(connector, deducedContainer);
		}
	}
	
	private org.eclipse.gmf.runtime.notation.Connector getConnectorView () {
		return  (org.eclipse.gmf.runtime.notation.Connector)getRequest().getParameter(DefaultSemanticEditPolicy.GRAPHICAL_RECONNECTED_EDGE);
	}
	private View getSourceView() {
		return reorientDirection == ReorientReferenceRelationshipRequest.REORIENT_SOURCE ? 
					(View)((ReorientReferenceRelationshipRequestWithGraphical)getRequest()).getSourceEditPart().getModel() :
						getConnectorView().getSource();
	}
	
	private View getTargetView() {
		return reorientDirection == ReorientReferenceRelationshipRequest.REORIENT_TARGET ? 
				(View)((ReorientReferenceRelationshipRequestWithGraphical)getRequest()).getTargetEditPart().getModel() :
					getConnectorView().getTarget();

	}
	@Override
	protected Property getNewOppositePartWithPort() {
		// no Port allowed in Parametric
		return null;
	}
	
	@Override
	protected Property getNewPartWithPort() {
		// no Port allowed in Parametric
		return null;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		CommandResult result = super.doExecuteWithResult(monitor, info);
		
		// apply or update NestedConnectorEnd stereotype and its PropertyPath if needed
		Connector connector = getLink();
		if (connector.getEnds().size() == 2) {
			updateNestedPropertyPath(connector.getEnds().get(0), getSourceView(), getTargetView());
			updateNestedPropertyPath(connector.getEnds().get(1), getTargetView(), getSourceView());
		}

		return result;
	}

	private void updateNestedPropertyPath(ConnectorEnd connectorEnd, View sourceView, View targetView) {
		ConnectorUtils utils = new ConnectorUtils();
		List<Property> nestedPropertyPath = utils.getNestedPropertyPath(sourceView, targetView);
		if (!nestedPropertyPath.isEmpty()) {
			// Search for existing stereotype application
			NestedConnectorEnd nestedConnectorEnd = UMLUtil.getStereotypeApplication(connectorEnd, NestedConnectorEnd.class);
			if (nestedConnectorEnd == null) {
				// apply stereotype if no application found
				nestedConnectorEnd = (NestedConnectorEnd)StereotypeApplicationHelper.INSTANCE.applyStereotype(connectorEnd, BlocksPackage.eINSTANCE.getNestedConnectorEnd());
			}
			// set new path
			nestedConnectorEnd.getPropertyPath().clear();
			nestedConnectorEnd.getPropertyPath().addAll(nestedPropertyPath);
		}
		else {
			// remove all NestedConnectorEnd Stereotype applications
			for (EObject stereotypeApplication : connectorEnd.getStereotypeApplications()) {
				if (NestedConnectorEnd.class.isInstance(stereotypeApplication)) {
					EcoreUtil.delete(stereotypeApplication, true);
				}
			}			
		}		
	}
}
