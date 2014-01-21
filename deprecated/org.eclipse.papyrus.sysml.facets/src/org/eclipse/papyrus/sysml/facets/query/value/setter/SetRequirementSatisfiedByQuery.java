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

import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQueryWithEditingDomain;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.emf.facet.infra.query.runtime.ModelQueryParameterValue;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.gmf.diagram.common.commands.IdentityCommandWithNotification;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.Type;
import org.eclipse.papyrus.sysml.facets.messages.Messages;
import org.eclipse.papyrus.sysml.requirements.Requirement;
import org.eclipse.papyrus.sysml.requirements.Satisfy;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.util.UMLUtil;

/** Query to set the derived attribute "satisfiedBy" of the requirement */
public class SetRequirementSatisfiedByQuery implements IJavaModelQueryWithEditingDomain<NamedElement, EObject> {

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
	public EObject evaluate(final NamedElement context, final ParameterValueList parameterValues) throws ModelQueryExecutionException {
		// nothing to do
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.emf.facet.infra.query.core.java.IJavaModelQueryWithEditingDomain#evaluate(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.facet.infra.query.core.java.ParameterValueList, org.eclipse.emf.edit.domain.EditingDomain)
	 * 
	 * @param context
	 * @param parameterValues
	 * @param editingDomain
	 * @return
	 * @throws ModelQueryExecutionException
	 */
	public EObject evaluate(NamedElement context, ParameterValueList parameterValues, EditingDomain editingDomain) throws ModelQueryExecutionException {
		CompositeCommand cmd = new CompositeCommand("Edit the derived attribute /SatisfiedBy"); //$NON-NLS-1$
		if(UMLUtil.getStereotypeApplication(context, Requirement.class) != null) {

			Requirement req = UMLUtil.getStereotypeApplication(context, Requirement.class);
			EList<DirectedRelationship> dependencies = context.getTargetDirectedRelationships();
			EList<NamedElement> currentSatisfiedBy = req.getSatisfiedBy();



			ModelQueryParameterValue object = parameterValues.get(0);
			Object values = object.getValue();
			Assert.isTrue(values instanceof List<?>);
			List<?> newSatisfiedBy = (List<?>)values;

			//we destroy the unnecessary Satisfy
			for(DirectedRelationship current : dependencies) {
				if(UMLUtil.getStereotypeApplication(current, Satisfy.class) != null) {
					EList<NamedElement> clients = ((Dependency)current).getClients();
					//we assume that there is only one client
					if(clients.size() == 1) {
						NamedElement client = clients.get(0);
						if(!newSatisfiedBy.contains(client)) {//we destroy this dependencies
							IElementEditService provider = ElementEditServiceUtils.getCommandProvider(current);
							DestroyElementRequest request = new DestroyElementRequest(current, false);
							ICommand desroyCommand = provider.getEditCommand(request);
							cmd.add(desroyCommand);
						}
					}
				}
			}

			for(Object current : (List<?>)values) {
				//we create the derive_reqt only if it doesn't exist
				Assert.isTrue(current instanceof NamedElement);
				if(!currentSatisfiedBy.contains(current)) {
					IElementEditService provider = ElementEditServiceUtils.getCommandProvider(context);
					CreateRelationshipRequest createRequest = new CreateRelationshipRequest(context.getNearestPackage(), (NamedElement)current, context, SysMLElementTypes.SATISFY);
					cmd.add(provider.getEditCommand(createRequest));
				}
			}
		} else {
			cmd.add(new IdentityCommandWithNotification(Messages.SetRequirementTextQuery_AssignmentCantBeDone, Messages.SetRequirementTextQuery_NotASysMLRequirement, Type.ERROR));
		}
		editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(cmd));
		return null;
	}
}
