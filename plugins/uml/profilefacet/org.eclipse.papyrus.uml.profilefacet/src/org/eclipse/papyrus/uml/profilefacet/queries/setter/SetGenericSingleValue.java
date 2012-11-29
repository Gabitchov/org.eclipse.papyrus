/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.uml.profilefacet.queries.setter;

import java.util.Collection;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.infra.facet.core.FacetContext;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQueryWithEditingDomain;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypeFacet;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypePropertyElement;
import org.eclipse.papyrus.uml.profilefacet.utils.ArgumentUtils;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

public class SetGenericSingleValue<R> implements IJavaModelQueryWithEditingDomain<Element, R> {


	//FIXME : maybe we should implements IJavaModelQueryWithEditingDomain
	public R evaluate(Element source, ParameterValueList parameterValues) throws ModelQueryExecutionException {
		final R newValue = (R)parameterValues.getValueByParameterName(FacetContext.NEW_VALUE);
		final StereotypePropertyElement element = (StereotypePropertyElement)parameterValues.getParameterValueByName(ArgumentUtils.EDITED_FEATURE).getValue();
		if(element != null) {
			final EObject container = element.eContainer();
			assert container instanceof StereotypeFacet;
			final StereotypeFacet facet = (StereotypeFacet)container;
			final String stereotypeQN = facet.getStereotypeQualifiedName();
			final Stereotype appliedStereotype = source.getAppliedStereotype(stereotypeQN);
			final String propertyQN = element.getPropertyQualifiedName();
			final String propertyName = NamedElementUtil.getNameFromQualifiedName(propertyQN);
			if(appliedStereotype != null) {
				source.setValue(appliedStereotype, propertyName, newValue);
			} else if(appliedStereotype == null) {//the property can comes from inheritance...
				for(Stereotype appliedSte : source.getAppliedStereotypes()) {
					final Collection<Stereotype> superClasses = StereotypeUtil.getAllSuperStereotypes(appliedSte);
					for(final Stereotype current : superClasses) {
						if(current.getQualifiedName().equals(stereotypeQN)) {
							source.setValue(appliedSte, propertyName, newValue);
						}
					}
				}

			}
		}

		return null;
	}

	public R evaluate(final Element source, final ParameterValueList parameterValues, final EditingDomain editingDomain) throws ModelQueryExecutionException {
		assert editingDomain != null;
		final R newValue = (R)parameterValues.getValueByParameterName(FacetContext.NEW_VALUE);
		final StereotypePropertyElement element = (StereotypePropertyElement)parameterValues.getParameterValueByName(ArgumentUtils.EDITED_FEATURE).getValue();
		Stereotype foundStereotype = null;
		if(element != null) {
			final EObject container = element.eContainer();
			assert container instanceof StereotypeFacet;
			final StereotypeFacet facet = (StereotypeFacet)container;
			final String stereotypeQN = facet.getStereotypeQualifiedName();
			final Stereotype appliedStereotype = source.getAppliedStereotype(stereotypeQN);
			final String propertyQN = element.getPropertyQualifiedName();
			final String propertyName = NamedElementUtil.getNameFromQualifiedName(propertyQN);
			if(appliedStereotype != null) {
				foundStereotype = appliedStereotype;//source.setValue(appliedStereotype, propertyName, newValue);
			} else if(appliedStereotype == null) {//the property can comes from inheritance...
				loop: for(Stereotype appliedSte : source.getAppliedStereotypes()) {
					final Collection<Stereotype> superClasses = StereotypeUtil.getAllSuperStereotypes(appliedSte);
					for(final Stereotype current : superClasses) {
						if(current.getQualifiedName().equals(stereotypeQN)) {
							foundStereotype = appliedSte;
							break loop;
						}
					}
				}
			}
			if(foundStereotype != null) {
				final Stereotype stereotype = foundStereotype;
				final ICommand setValueCommand = new AbstractTransactionalCommand((TransactionalEditingDomain)editingDomain, "Set Stereotype Value Command", null) {

					@Override
					protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
						source.setValue(stereotype, propertyName, newValue);
						return CommandResult.newOKCommandResult();
					}
				};

				editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(setValueCommand));
			}
		}
		return null;
	}
}
