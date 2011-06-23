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
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.utils.ServiceUtilsForActionHandlers;
import org.eclipse.papyrus.sysml.requirements.Requirement;
import org.eclipse.papyrus.sysml.requirements.RequirementsPackage;
import org.eclipse.papyrus.sysml.util.ElementUtil;
import org.eclipse.uml2.uml.Class;

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
		// TODO Auto-generated method stub
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
		Requirement requirement = ElementUtil.getStereotypeApplication(context, Requirement.class);
		
		if ((requirement == null) || (parameter.isEmpty()) || (parameter.get(0) == null)) {
			return context; // Abort.
		}
		
		// Retrieve new value from parameter and update if the property value has changed.
		String newValue = (parameter.get(0).getValue() instanceof String) ? (String) parameter.get(0).getValue() : null;
		if (newValue != requirement.getId()) {
			
			try {
				
				TransactionalEditingDomain domain = ServiceUtilsForActionHandlers.getInstance().getTransactionalEditingDomain();
				SetCommand command = new SetCommand(domain, requirement, RequirementsPackage.eINSTANCE.getRequirement_Text(), newValue);
				if (command.canExecute()) {
					domain.getCommandStack().execute(command);
				}
				
			} catch (ServiceException e) {
				throw new ModelQueryExecutionException(e);
			}
			
		}
		
		return context;
	}
}
