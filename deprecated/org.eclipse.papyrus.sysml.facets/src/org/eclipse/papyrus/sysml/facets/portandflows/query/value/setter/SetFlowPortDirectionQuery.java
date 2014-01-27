/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.sysml.facets.portandflows.query.value.setter;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQueryWithEditingDomain;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.gmf.diagram.common.commands.IdentityCommandWithNotification;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.Type;
import org.eclipse.papyrus.sysml.facets.extendedsysml.extendedsysml.portandflows.NAFlowPortDirection;
import org.eclipse.papyrus.sysml.facets.messages.Messages;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.papyrus.sysml.portandflows.PortandflowsPackage;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.util.UMLUtil;

/** Query to qet the attribute "Direction" of the FlowPort */
public class SetFlowPortDirectionQuery implements IJavaModelQueryWithEditingDomain<Port, Enumerator> {

	public Enumerator evaluate(final Port context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
		//nothing to do
		return null;
	}


	public Enumerator evaluate(Port context, ParameterValueList parameterValues, EditingDomain editingDomain) throws ModelQueryExecutionException {
		FlowPort flowPort = UMLUtil.getStereotypeApplication(context, FlowPort.class);

		if(flowPort != null) {
			if(!((parameterValues.isEmpty()) || (parameterValues.get(0) == null))) {



				// Retrieve new value from parameter and update if the property value has changed.
				Enumerator newValue = (parameterValues.get(0).getValue() instanceof Enumerator) ? (Enumerator)parameterValues.get(0).getValue() : null;
				if(!(newValue instanceof NAFlowPortDirection)) {//we do nothing in this case
					if(newValue != flowPort.getDirection()) {
						try {
							TransactionalEditingDomain domain = ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(flowPort);
							SetCommand command = new SetCommand(domain, flowPort, PortandflowsPackage.eINSTANCE.getFlowPort_Direction(), newValue);
							if(command.canExecute()) {
								domain.getCommandStack().execute(command);
							}

						} catch (ServiceException e) {
							throw new ModelQueryExecutionException(e);
						}

					}
				}
			}
		} else {
			editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(new IdentityCommandWithNotification(Messages.SetRequirementTextQuery_AssignmentCantBeDone, "The edited element is not a SysML FlowPort.", Type.ERROR)));
		}
		return null;
	}
}
