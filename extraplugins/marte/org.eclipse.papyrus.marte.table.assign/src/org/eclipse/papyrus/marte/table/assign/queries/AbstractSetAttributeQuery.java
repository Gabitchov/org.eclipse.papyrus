/*****************************************************************************
 * Copyright (c) 2012 ATOS
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Olivier Mélois (ATOS) olivier.melois@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.marte.table.assign.queries;

import java.util.Collection;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQueryWithEditingDomain;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.emf.facet.infra.query.runtime.ModelQueryParameterValue;
import org.eclipse.emf.facet.widgets.nattable.tableconfiguration.InstantiationMethodParameters;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;
import org.eclipse.uml2.uml.Element;

import com.google.common.collect.Iterables;


@SuppressWarnings("restriction")
/**
 * Query to assign values to an attribute of an element.
 * @author omelois
 *
 */
public abstract class AbstractSetAttributeQuery<T extends Element> implements IJavaModelQueryWithEditingDomain<T, Collection<Element>> {

	/**
	 * @see IJavaModelQueryWithEditingDomain
	 */
	public Collection<Element> evaluate(T context, ParameterValueList parameterValues, EditingDomain editingDomain) 
		throws ModelQueryExecutionException {

		if(editingDomain != null) {

			//Getting the reference of the feature we want to set.
			EReference ref = getNeededStructuralFeature();
			if(ref.isMany()) {

				final Collection<Element> attributeAsList = getAttributeAsList(context);
				final ParameterValueList finalParameterValues = parameterValues;


				//Command used to modify the model.
				AbstractTransactionalCommand modifyAttribute = new AbstractTransactionalCommand((TransactionalEditingDomain)editingDomain, "Modify attribute", null) {

					@SuppressWarnings("unchecked")
					@Override
					protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
						attributeAsList.clear();
						//Retrieving the new list of elements in the attribute.
						for(ModelQueryParameterValue queryParamValue : finalParameterValues) {
							Object value = queryParamValue.getValue();
							if(value instanceof Iterable<?>) {
								Iterables.addAll(attributeAsList, (Iterable<Element>)value);
							}
						}

						return CommandResult.newOKCommandResult();
					}
				};
				//Command execution
				editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(modifyAttribute));
				return attributeAsList;

			} else {
				Object attribute = context.eGet(ref);
				//TODO: implement the case when the attribute is a not a collection.
			}
		}
		return null;
	}


	/**
	 * @see IJavaModelQueryWithEditingDomain
	 */
	public Collection<Element> evaluate(T context, ParameterValueList parameterValues) throws ModelQueryExecutionException {
		EditingDomain editingDomain = null;
		ModelQueryParameterValue model = parameterValues.getParameterValueByName(InstantiationMethodParameters.getEditingDomainParameter().getName());
		if(model != null) {
			if(model.getValue() instanceof EditingDomain) {
				editingDomain = (EditingDomain)model.getValue();
			}
		}
		return this.evaluate(context, parameterValues, editingDomain);
	}


	/**
	 * Gets the structuralFeature describing the attribute we want to set.
	 * 
	 * @return
	 */
	protected abstract EReference getNeededStructuralFeature();


	/**
	 * Gets the elements that define a specific attribute of an element.
	 * 
	 * @param e
	 *        the element we need the attribute of.
	 * @param structuralFeature
	 *        , describing the needed attribute.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Collection<Element> getAttributeAsList(Element e){
		EReference structuralFeature = getNeededStructuralFeature();
		Collection<Element> result = null;
		if (structuralFeature.isMany()){
			Assign assign = (Assign)e.getStereotypeApplication(e.getAppliedStereotype("MARTE::MARTE_Foundations::Alloc::Assign"));//$NON-NLS-1$
			if (assign != null){
				result = (Collection<Element>) assign.eGet(structuralFeature);
			}
		}
		return result;
	}

}
