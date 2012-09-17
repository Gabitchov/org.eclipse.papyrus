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
package org.eclipse.papyrus.sysml.table.allocation.queries;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.emf.facet.infra.query.runtime.ModelQueryParameterValue;
import org.eclipse.emf.facet.widgets.celleditors.ICommandFactoriesRegistry;
import org.eclipse.emf.facet.widgets.celleditors.ICommandFactory;
import org.eclipse.emf.facet.widgets.nattable.tableconfiguration.InstantiationMethodParameters;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/** Create a new Abstraction */
//FIXME: Use an element type to create the Abstraction. Remove the dependency to uml.diagram.common
public class CreateAbstractionQuery implements IJavaModelQuery<Package, Abstraction> {

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
	public Abstraction evaluate(final Package context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
		EditingDomain editingDomain = null;
		ModelQueryParameterValue model = parameterValues.getParameterValueByName(InstantiationMethodParameters.getEditingDomainParameter().getName());
		if(model != null) {
			if(model.getValue() instanceof EditingDomain) {
				editingDomain = (EditingDomain)model.getValue();
			}
		}
		if(editingDomain != null) {
			ICommandFactory commandFactory = ICommandFactoriesRegistry.INSTANCE.getCommandFactoryFor(editingDomain);

			if(context != null) {
				Abstraction abstraction = UMLFactory.eINSTANCE.createAbstraction();

				String name = org.eclipse.papyrus.uml.diagram.common.helper.NamedElementHelper.EINSTANCE.getNewUMLElementName(context, abstraction.eClass());
				abstraction.setName(name);
				Command command = commandFactory.createAddCommand(editingDomain, context, UMLPackage.eINSTANCE.getPackage_PackagedElement(), abstraction);

				editingDomain.getCommandStack().execute(command);
				return abstraction;
			}
		}

		return null;
	}
}
