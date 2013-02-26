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
package org.eclipse.papyrus.sysml.service.types.stereotype.helper.advice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.sysml.blocks.Block;
import org.eclipse.papyrus.sysml.blocks.BlocksPackage;
import org.eclipse.papyrus.sysml.blocks.NestedConnectorEnd;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <pre>
 * This advice is used to remove inconsistent {@link Connector} when a related {@link Block} 
 * is set as encapsulated ({@link Block#isEncapsulated()} property).
 * </pre>
 */
public class BlockEditHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * <pre>
	 * {@inheritDoc}
	 * 
	 * Returns the command to destroy any {@link Connector} breaking encapsulation rules.
	 * </pre>
	 * 
	 * @param request
	 *        the request to modify the model
	 * @return
	 *         the command to destroy the views of the parts which are not owned by the new type
	 * 
	 */
	@Override
	protected ICommand getBeforeSetCommand(SetRequest request) {
		ICommand setCommand = super.getBeforeSetCommand(request);
		Set<Connector> connectorToDelete = new HashSet<Connector>();

		EObject elementToEdit = request.getElementToEdit();
		if((elementToEdit instanceof Block) && (request.getFeature() == BlocksPackage.eINSTANCE.getBlock_IsEncapsulated())) {

			Block blockApp = (Block)elementToEdit;
			Boolean setAsEncapsulated = (request.getValue() instanceof Boolean) ? (Boolean)request.getValue() : false;
			if(!blockApp.isEncapsulated() && setAsEncapsulated) {
				
				for (Property property : getPropertyTypedByBlock(blockApp)) {
					for (NestedConnectorEnd nestedEnd : getRelatedNestedConnectorEnd(property)) {
						ConnectorEnd end = nestedEnd.getBase_ConnectorEnd();
						Connector connector = (end != null) ? (Connector) end.eContainer() : null;
						if (connector != null) {
							connectorToDelete.add(connector);	
						}
					}
				}
			}
		}

		// Add connector destroy command if needed
		if(!(connectorToDelete.isEmpty())) {
			DestroyDependentsRequest req = new DestroyDependentsRequest(request.getEditingDomain(), elementToEdit, false);
			req.setClientContext(request.getClientContext());
			req.addParameters(request.getParameters());
			ICommand connectorDestroyCommand = req.getDestroyDependentsCommand(connectorToDelete);
			if(connectorDestroyCommand != null) {
				setCommand = CompositeCommand.compose(connectorDestroyCommand, setCommand);
			}
		}

		return setCommand;
	}

	/**
	 * Get any {@link Property} typed by the given {@link Block} (its base class).
	 * @param block the block.
	 * @return a collection of {@link Property} 
	 */
	@SuppressWarnings("unchecked")
	private Collection<Property> getPropertyTypedByBlock(Block block) {
		EReference[] eRefs = new EReference[]{ UMLPackage.eINSTANCE.getTypedElement_Type() };
		 
		Collection<Property> references = (Collection<Property>) EMFCoreUtil.getReferencers(block.getBase_Class(), eRefs);
		return (references != null) ? references : Collections.unmodifiableList(new ArrayList<Property>());
	}
	
	/**
	 * Get any {@link NestedConnectorEnd} stereotype application that holds the property in its path.
	 * @param property the property that should be in the path.
	 * @return a collection of {@link NestedConnectorEnd} 
	 */
	@SuppressWarnings("unchecked")
	private Collection<NestedConnectorEnd> getRelatedNestedConnectorEnd(Property property) {
		EReference[] eRefs = new EReference[]{ BlocksPackage.eINSTANCE.getNestedConnectorEnd_PropertyPath() };
	
		Collection<NestedConnectorEnd> references = (Collection<NestedConnectorEnd>) EMFCoreUtil.getReferencers(property, eRefs);
		return (references != null) ? references : Collections.unmodifiableList(new ArrayList<NestedConnectorEnd>());
	}
}
