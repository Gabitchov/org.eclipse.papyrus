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
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQueryWithEditingDomain;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.emf.facet.infra.query.runtime.ModelQueryParameterValue;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Stereotype;

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
		final Stereotype ste = context.getAppliedStereotype(SysmlResource.REQUIREMENT_ID);
		if(ste != null && editingDomain instanceof TransactionalEditingDomain) {
			if(parameter.size() != 0) {
				final ModelQueryParameterValue newValue = parameter.get(0);
				if(newValue != null && newValue.getValue() instanceof String) {
					RecordingCommand command = new RecordingCommand((TransactionalEditingDomain)editingDomain) {

						@Override
						protected void doExecute() {
							context.setValue(ste, SysmlResource.REQUIREMENT_TEXT_ID, newValue.getValue());
						}
					};
					if(command.canExecute()) {
						editingDomain.getCommandStack().execute(command);
					}
				}
			}
		}
		return context;
	}
}
