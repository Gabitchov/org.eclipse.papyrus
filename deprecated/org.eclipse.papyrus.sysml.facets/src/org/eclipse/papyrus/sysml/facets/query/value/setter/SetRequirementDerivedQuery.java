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

import java.util.ArrayList;
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
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.gmf.diagram.common.commands.IdentityCommandWithNotification;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.Type;
import org.eclipse.papyrus.sysml.facets.messages.Messages;
import org.eclipse.papyrus.sysml.requirements.DeriveReqt;
import org.eclipse.papyrus.sysml.requirements.Requirement;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.util.UMLUtil;

/** Query to set the derived attribute "derived" of the requirement */
public class SetRequirementDerivedQuery implements IJavaModelQueryWithEditingDomain<Class, EObject> {

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
	public EObject evaluate(Class context, ParameterValueList parameterValues) throws ModelQueryExecutionException {
		//nothing to do
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
	public EObject evaluate(Class context, ParameterValueList parameter, EditingDomain editingDomain) throws ModelQueryExecutionException {
		CompositeCommand cmd = new CompositeCommand("Edit the feature /Derived"); //$NON-NLS-1$
		if(UMLUtil.getStereotypeApplication(context, Requirement.class) != null) {
			Requirement req = UMLUtil.getStereotypeApplication(context, Requirement.class);

			EList<DirectedRelationship> dependencies = context.getTargetDirectedRelationships();
			EList<Requirement> currentDerived = req.getDerived();
			List<Class> currentDerived_base_Class = new ArrayList<Class>();
			for(Requirement currentReq : currentDerived) {
				currentDerived_base_Class.add(currentReq.getBase_Class());
			}


			ModelQueryParameterValue object = parameter.get(0);
			Object values = object.getValue();
			Assert.isTrue(values instanceof List<?>);
			List<?> newDerivedFrom = (List<?>)values;

			//we destroy the unnecessary Derive_Reqt
			for(DirectedRelationship current : dependencies) {
				if(UMLUtil.getStereotypeApplication(current, DeriveReqt.class) != null) {
					EList<NamedElement> clients = ((Dependency)current).getClients();
					//we assume that there is only one client
					if(clients.size() == 1) {
						NamedElement supplier = clients.get(0);
						if(!newDerivedFrom.contains(supplier)) {//we destroy this dependencies
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
				if(!currentDerived_base_Class.contains(current)) {
					if(UMLUtil.getStereotypeApplication(context, Requirement.class) != null) {
						IElementEditService provider = ElementEditServiceUtils.getCommandProvider(context);

						CreateElementRequest createRequest = new CreateRelationshipRequest(context.getNearestPackage(), (EObject)current, context, SysMLElementTypes.DERIVE_REQT);
						cmd.add(provider.getEditCommand(createRequest));
					} else {
						cmd.add(new IdentityCommandWithNotification(Messages.SetRequirementTextQuery_AssignmentCantBeDone, NLS.bind(Messages.SetRequirementDerivedQuery_DeriveReqtCanBeCreated, context.getName(), ((NamedElement)current).getName()), Type.ERROR));
					}
				}

			}
		} else {
			cmd.add(new IdentityCommandWithNotification(Messages.SetRequirementTextQuery_AssignmentCantBeDone, Messages.SetRequirementTextQuery_NotASysMLRequirement, Type.ERROR));
		}
		editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(cmd));
		return null;
	}
}
