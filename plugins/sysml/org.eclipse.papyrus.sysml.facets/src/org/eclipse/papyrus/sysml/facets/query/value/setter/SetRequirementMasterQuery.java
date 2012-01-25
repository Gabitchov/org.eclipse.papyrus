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
import org.eclipse.papyrus.sysml.requirements.Copy;
import org.eclipse.papyrus.sysml.requirements.Requirement;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.util.UMLUtil;

/** Query to set the derived attribute "master" of the requirement */
public class SetRequirementMasterQuery implements IJavaModelQueryWithEditingDomain<Class, EObject> {

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
	 * @param parameterValues
	 * @param editingDomain
	 * @return
	 * @throws ModelQueryExecutionException
	 */
	public EObject evaluate(Class context, ParameterValueList parameterValues, EditingDomain editingDomain) throws ModelQueryExecutionException {
		CompositeCommand cmd = new CompositeCommand("Edit the derived attribute /master"); //$NON-NLS-1$
		ModelQueryParameterValue object = parameterValues.get(0);
		Object value = object.getValue();
		Class newMaster = null;
		if(UMLUtil.getStereotypeApplication(context, Requirement.class) != null) {
			if(value != null) {
				Assert.isTrue(value instanceof Class);
				newMaster = (Class)value;
			}
			Assert.isTrue(UMLUtil.getStereotypeApplication(context, Requirement.class) != null);

			EList<Dependency> dependencies = context.getClientDependencies();

			//we destroy the unnecessary Copy
			for(DirectedRelationship current : dependencies) {
				if(UMLUtil.getStereotypeApplication(current, Copy.class) != null) {
					EList<NamedElement> target = ((Dependency)current).getSuppliers();
					//we assume that there is only one client
					if(target.size() == 1) {
						NamedElement client = target.get(0);
						if(newMaster != client) {//we destroy this dependency
							IElementEditService provider = ElementEditServiceUtils.getCommandProvider(current);
							DestroyElementRequest request = new DestroyElementRequest(current, false);
							ICommand destroyCommand = provider.getEditCommand(request);
							cmd.add(destroyCommand);
						}
					}
				}
			}

			if(newMaster != null) {
				if(UMLUtil.getStereotypeApplication(newMaster, Requirement.class) != null) {
					//we create the Element Copy
					IElementEditService provider = ElementEditServiceUtils.getCommandProvider(context);
					CreateElementRequest createRequest = new CreateRelationshipRequest(context.getNearestPackage(), context, newMaster, SysMLElementTypes.COPY);
					cmd.add(provider.getEditCommand(createRequest));
				} else {
					cmd.add(new IdentityCommandWithNotification(Messages.SetRequirementTextQuery_AssignmentCantBeDone, NLS.bind(Messages.SetRequirementMasterQuery_CopyCantBeCreated, context.getName(), ((NamedElement)newMaster).getName()), Type.ERROR));
				}
			}
		} else {
			cmd.add(new IdentityCommandWithNotification(Messages.SetRequirementTextQuery_AssignmentCantBeDone, Messages.SetRequirementTextQuery_NotASysMLRequirement, Type.ERROR));
		}
		editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(cmd));
		return null;
	}
}
