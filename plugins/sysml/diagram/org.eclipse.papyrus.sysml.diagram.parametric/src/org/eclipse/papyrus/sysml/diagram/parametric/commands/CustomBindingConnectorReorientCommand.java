/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Régis CHEVREL: chevrel.regis <at> gmail.com
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.commands;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.DefaultSemanticEditPolicy;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.sysml.blocks.Block;
import org.eclipse.papyrus.sysml.blocks.BlocksPackage;
import org.eclipse.papyrus.sysml.blocks.NestedConnectorEnd;
import org.eclipse.papyrus.sysml.diagram.common.utils.ConstraintBlockHelper;
import org.eclipse.papyrus.sysml.service.types.utils.ConnectorUtils;
import org.eclipse.papyrus.uml.diagram.common.util.CrossReferencerUtil;
import org.eclipse.papyrus.uml.service.types.command.ConnectorReorientCommand;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.uml2.uml.util.UMLUtil.StereotypeApplicationHelper;

public class CustomBindingConnectorReorientCommand extends ConnectorReorientCommand {

	private final EObject source;

	private final EObject target;

	public CustomBindingConnectorReorientCommand(ReorientReferenceRelationshipRequestWithGraphical request) {
		super(request);
		source = reorientDirection == ReorientReferenceRelationshipRequest.REORIENT_SOURCE ? request.getNewRelationshipEnd() : request.getReferenceOwner();
		target = reorientDirection == ReorientReferenceRelationshipRequest.REORIENT_SOURCE ? request.getReferenceOwner() : request.getNewRelationshipEnd();
	}


	/**
	 * A BindingConnector could be reoriented in Parametric only if at least one end is a ConstraintParameter.
	 * Also check Block.isEncapsulated (could not cross a Block which is encapsulted)
	 * @return 
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
				boolean hasEncapsulationViolation = !checkEncapsulationCrossing();		
				
				return hasEncapsulationViolation ? false :
						// one of the end must be a ConstraintParameter	
						ConstraintBlockHelper.isConstraintParameter((Element)source, sourceView)
						|| ConstraintBlockHelper.isConstraintParameter((Element)target, targetView);
			}			
		}
		return false;
	}

	/**
	 * Check that BindingConnector do not cross a "Block.isEncapsulated" Part/Reference/ConstraintProperty
	 * @return true no encapsulation problem, false else
	 */
	private boolean checkEncapsulationCrossing() {
		org.eclipse.papyrus.sysml.service.types.utils.ConnectorUtils util = new org.eclipse.papyrus.sysml.service.types.utils.ConnectorUtils();
		// source end - get the nestedPath	
		List<Property> nestedPropertyPath = util.getNestedPropertyPath(getSourceView(), getTargetView());
		// check for each level of path if crossing an isEncapsultaed Block 
		for (Property property : nestedPropertyPath) {
			Type type = property.getType();
			Block stereotypeApplication = UMLUtil.getStereotypeApplication(type, Block.class);
			if (stereotypeApplication != null) {
				if (stereotypeApplication.isEncapsulated()) {
					return false;
				}
			}
		}
		
		// target end - get the nestedPath	
		nestedPropertyPath = util.getNestedPropertyPath(getTargetView(), getSourceView());
		// check for each level of path if crossing an isEncapsultaed Block 
		for (Property property : nestedPropertyPath) {
			Type type = property.getType();
			Block stereotypeApplication = UMLUtil.getStereotypeApplication(type, Block.class);
			if (stereotypeApplication != null) {
				if (stereotypeApplication.isEncapsulated()) {
					return false;
				}
			}
		}
		return true;
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
	protected Property findNewOppositePartWithPort() {
		// no Port allowed in Parametric
		return null;
	}

	@Override
	protected Property findNewPartWithPort() {
		// no Port allowed in Parametric
		return null;
	}

	/**
	 * Reorient connector - recalculate nestedPath - remove connector deprecated representations (all diagrams) 
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		CommandResult result = super.doExecuteWithResult(monitor, info);
		
		// apply or update NestedConnectorEnd stereotype and its PropertyPath if needed
		Connector connector = getLink();
		if (connector.getEnds().size() == 2) {
			updateNestedPropertyPath(connector.getEnds().get(0), getSourceView(), getTargetView());
			updateNestedPropertyPath(connector.getEnds().get(1), getTargetView(), getSourceView());
		}
		
		Set<View> memberViewsToDestroy = getMemberViewsToDestroy(connector);
		// Suppress Connector representation which are not coherant with the new ConnectorEnd 
		for (View view : memberViewsToDestroy) {
			// exclude reoriented connector representation
			if (view != getConnectorView()) { 
				// Check Connector View ends matches with semantic ConnectorEnds
				View sourceNode = ((org.eclipse.gmf.runtime.notation.Connector)view).getSource();
				View targetNode = ((org.eclipse.gmf.runtime.notation.Connector)view).getTarget();
	
				EObject sourceElement = sourceNode.getElement();
				EObject targetElement = targetNode.getElement();
				
				EList<ConnectorEnd> ends = connector.getEnds();
				boolean isSameEnds = true;
				for (ConnectorEnd connectorEnd : ends) {
					if (connectorEnd.getRole() != sourceElement && connectorEnd.getRole() != targetElement) {
						isSameEnds = false;
						break;
					}
				}
				
				// if no matching between graphical and semantic, we destroy the representation
				if (!isSameEnds) {
					final DestroyElementRequest destroyRequest = new DestroyElementRequest(getRequest().getEditingDomain(), view, false);
					final IElementEditService commandProvider = ElementEditServiceUtils.getCommandProvider(view);
					ICommand editCommand = commandProvider.getEditCommand(destroyRequest);
					editCommand.execute(monitor, info);
				}
			}
		}

		return result;
	}

	
	protected Set<View> getMemberViewsToDestroy(final Connector connector) {
		Set<View> viewsToDestroy = new HashSet<View>();

		// Find Views in Composite Structure Diagram that are referencing current member
		Iterator<View> viewIt = CrossReferencerUtil.getCrossReferencingViews(connector, null).iterator();
		while(viewIt.hasNext()) {
			View view = viewIt.next();
			viewsToDestroy.add(view);
		}

		return viewsToDestroy;
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
