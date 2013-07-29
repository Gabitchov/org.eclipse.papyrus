/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.service.types.command;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.sysml.blocks.BlocksPackage;
import org.eclipse.papyrus.sysml.blocks.NestedConnectorEnd;
import org.eclipse.papyrus.sysml.service.types.utils.ConnectorUtils;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.uml2.uml.util.UMLUtil.StereotypeApplicationHelper;

/**
 * <pre>
 * Set SysML {@link NestedConnectorEnd} stereotype information for {@link ConnectorEnd}.
 * </pre>
 */
public class SetNestedPathCommand extends EditElementCommand {

	private ConnectorUtils utils = new ConnectorUtils();

	/**
	 * The ordered list of {@link Property} to follow in order to reach the nested {@link ConnectableElement}.
	 */
	private List<Property> nestedPath;

	/**
	 * Indicates that the source of the {@link Connector} is nested.
	 */
	public final static int NESTED_SOURCE = 1;

	/**
	 * Indicates that the target of the {@link Connector} is nested.
	 */
	public final static int NESTED_TARGET = 2;

	/**
	 * Indicates whether or not the source of the target of the {@link Connector} is nested. 
	 * One of {@link #NESTED_SOURCE} or {@link #NESTED_TARGET}.
	 */
	private final int nestedEndDirection;

	/**
	 * 
	 * Constructor.
	 *
	 * @param label the command label.
	 * @param elementToEdit the element to edit.
	 * @param request the request this command contribute to ({@link CreateRelationshipRequest} or {@link ReorientRelationshipRequest})
	 * @param nestedPath the property path to set (in {@link NestedConnectorEnd#getPropertyPath()} ).
	 * @param nestedEndDirection the direction ({@link #NESTED_SOURCE} or {@link #NESTED_TARGET}) of the {@link ConnectorEnd} to modify.
	 */
	public SetNestedPathCommand(String label, EObject elementToEdit, IEditCommandRequest request, List<Property> nestedPath, int nestedEndDirection) {
		super(label, elementToEdit, request);
		this.nestedPath = nestedPath;
		this.nestedEndDirection = nestedEndDirection;
	}

	/**
	 * Test whether the command can be executed or not.
	 */
	public boolean canExecute() {

		// Verify the kind of request
		if(! (getRequest() instanceof CreateRelationshipRequest) 
			&& ! (getRequest() instanceof ReorientRelationshipRequest)) {
			
			return false;
		}

		// Verify (basic) that the related Connector well-formed.
		// In case of Connector creation, the connector is most probably not created yet
		if ((getConnector() != null)
			&& (getConnector().getEnds().size() != 2)) {
			
			return false; // binary connector expected.
		}
		
		return true;
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if(!canExecute()) {
			throw new ExecutionException("Unexecutable command."); //$NON-NLS-1$
		}

		ConnectorEnd modifiedEnd = getModifiedConnectorEnd();
		NestedConnectorEnd nestedConnectorEnd = UMLUtil.getStereotypeApplication(modifiedEnd, NestedConnectorEnd.class);

		if(nestedPath.isEmpty()) {
			// Remove stereotype if applied
			if(nestedConnectorEnd != null) {
				EcoreUtil.delete(nestedConnectorEnd, true);
			}

		} else {
			// Add stereotype if not applied and set new path if different from existing
			if(nestedConnectorEnd == null) {
				// apply stereotype
				nestedConnectorEnd = (NestedConnectorEnd)StereotypeApplicationHelper.INSTANCE.applyStereotype(modifiedEnd, BlocksPackage.eINSTANCE.getNestedConnectorEnd());
			}

			// Set path
			if(!nestedConnectorEnd.getPropertyPath().equals(nestedPath)) {
				nestedConnectorEnd.getPropertyPath().clear();
				nestedConnectorEnd.getPropertyPath().addAll(nestedPath);
			}
		}
		
		return CommandResult.newOKCommandResult(getConnector());
	}

	/**
	 * Get the {@link ConnectorEnd} currently modified by the command.
	 * @return the modified {@link ConnectorEnd}.
	 */
	private ConnectorEnd getModifiedConnectorEnd() {
		return (nestedEndDirection == NESTED_SOURCE) ? utils.getSourceConnectorEnd(getConnector()) : utils.getTargetConnectorEnd(getConnector());
	}

	/**
	 * Get the {@link Connector} currently under creation or re-orient that hold {@link ConnectorEnd} to update.
	 * @return the related {@link Connector}.
	 */
	private Connector getConnector() {
		Connector connector = null;
		if(getRequest() instanceof CreateRelationshipRequest) {
			connector = (Connector)((CreateRelationshipRequest)getRequest()).getNewElement();
		}

		if(getRequest() instanceof ReorientRelationshipRequest) {
			connector = (Connector)((ReorientRelationshipRequest)getRequest()).getRelationship();
		}
		return connector;
	}
}
