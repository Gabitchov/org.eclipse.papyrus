/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.facets.query.value.setter;

import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.papyrus.sysml.facets.messages.Messages;
import org.eclipse.papyrus.sysml.requirements.Requirement;
import org.eclipse.papyrus.sysml.requirements.RequirementsPackage;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.util.UMLUtil;

/** Query to set the attribute "text" of the requirement */
public class SetRequirementTextQuery implements IJavaModelQueryWithEditingDomain<Class, EObject> {

	/**
	 * 
	 * @see org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery#evaluate(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.facet.infra.query.core.java.ParameterValueList)
	 * 
	 * @param context
	 * @param parameterValues
	 * @return
	 * @throws ModelQueryExecutionException
	 */
	public EObject evaluate(final Class context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
		// nothing to do
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.emf.facet.infra.query.core.java.IJavaModelQueryWithEditingDomain#evaluate(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.facet.infra.query.core.java.ParameterValueList, org.eclipse.emf.edit.domain.EditingDomain)
	 * 
	 * @param context
	 * @param parameter
	 * @param editingDomain
	 * @return
	 * @throws ModelQueryExecutionException
	 */
	public EObject evaluate(final Class context, final ParameterValueList parameter, final EditingDomain editingDomain) throws ModelQueryExecutionException {
		Requirement requirement = UMLUtil.getStereotypeApplication(context, Requirement.class);

		if(requirement != null) {
			if(!((parameter.isEmpty()) || (parameter.get(0) == null))) {

				// Retrieve new value from parameter and update if the property value has changed.
				String newValue = (parameter.get(0).getValue() instanceof String) ? (String)parameter.get(0).getValue() : null;
				if(newValue != requirement.getId()) {

					try {

						TransactionalEditingDomain domain = ServiceUtilsForEObject.getInstance().getTransactionalEditingDomain(context);
						SetCommand command = new SetCommand(domain, requirement, RequirementsPackage.eINSTANCE.getRequirement_Text(), newValue);
						if(command.canExecute()) {
							domain.getCommandStack().execute(command);
						}

					} catch (ServiceException e) {
						throw new ModelQueryExecutionException(e);
					}

				}
			}
		} else {
			editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(new IdentityCommandWithNotification(Messages.SetRequirementTextQuery_AssignmentCantBeDone, Messages.SetRequirementTextQuery_NotASysMLRequirement, Type.ERROR)));
		}
		return context;
	}
}
