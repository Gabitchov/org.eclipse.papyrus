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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQueryWithEditingDomain;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.emf.facet.infra.query.runtime.ModelQueryParameterValue;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Stereotype;

/** Query to set the attribute "id" of the requirement */
public class SetRequirementIdQuery implements IJavaModelQueryWithEditingDomain<Class, EObject> {

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
	 * @param arg0
	 * @param parameter
	 * @param arg2
	 * @return
	 * @throws ModelQueryExecutionException
	 */
	public EObject evaluate(final Class context, final ParameterValueList parameter, final EditingDomain editingDomain) throws ModelQueryExecutionException {
		final Stereotype ste = context.getAppliedStereotype(SysmlResource.REQUIREMENT_ID);
		if(ste != null) {
			if(parameter.size() != 0) {
				final ModelQueryParameterValue newValue = parameter.get(0);
				if(newValue != null && newValue.getValue() instanceof String) {
					Command command = null;
					TransactionalEditingDomain domain = null;
					if(!(editingDomain instanceof TransactionalEditingDomain)) {
						//if we work with a uml file, it is possible to get a UML2AdapterFactoryEditingDomain instead of TransactionEditingDomain
						domain = TransactionUtil.getEditingDomain(context);
					} else {
						domain = (TransactionalEditingDomain)editingDomain;
					}
					if(domain != null) {
						command = new RecordingCommand(domain) {

							@Override
							protected void doExecute() {
								context.setValue(ste, SysmlResource.REQUIREMENT_ID_ID, newValue.getValue());
							}
						};
					}
					if(command != null && command.canExecute()) {
						domain.getCommandStack().execute(command);
					}
				}
			}
		}
		return context;
	}

}
