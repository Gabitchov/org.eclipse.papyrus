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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.gmf.diagram.common.commands.IdentityCommandWithNotification;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.Type;
import org.eclipse.papyrus.sysml.facets.messages.Messages;
import org.eclipse.papyrus.sysml.requirements.Requirement;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.profile.l2.L2Package;
import org.eclipse.uml2.uml.profile.l2.Trace;
import org.eclipse.uml2.uml.util.UMLUtil;

/** Query to set the derived attribute "tracedTo" of the requirement */
public class SetRequirementTracedToQuery implements IJavaModelQueryWithEditingDomain<NamedElement, EObject> {


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
		CompositeCommand cmd = new CompositeCommand("Edit the feature /TracedTo"); //$NON-NLS-1$
		int result = MessageDialog.OK;
		if(UMLUtil.getStereotypeApplication(context, Requirement.class) != null) {
			if(!context.getNearestPackage().isProfileApplied(UMLUtil.getProfile(L2Package.eINSTANCE))) {
				cmd.add(new IdentityCommandWithNotification(Messages.SetRequirementTextQuery_AssignmentCantBeDone, Messages.SetRequirementRefinedByQuery_StandardIsNotAppliedOnTheModel, Type.ERROR));
			} else {
				Requirement req = UMLUtil.getStereotypeApplication(context, Requirement.class);
				EList<DirectedRelationship> dependencies = context.getTargetDirectedRelationships();

				EList<?> currentTracedTo = req.getTracedTo();

				ModelQueryParameterValue object = parameterValues.get(0);
				Object values = object.getValue();
				Assert.isTrue(values instanceof List<?>);
				List<?> newTracedTo = (List<?>)values;

				//we destroy the unnecessary tracedTo 
				for(DirectedRelationship current : dependencies) {
					if(UMLUtil.getStereotypeApplication(current, Trace.class) != null && isStricteTrace(current)) {
						EList<NamedElement> clients = ((Dependency)current).getClients();
						//we assume that there is only one client
						if(clients.size() == 1) {
							NamedElement client = clients.get(0);
							if(!newTracedTo.contains(client)) {//we destroy this dependencies
								IElementEditService provider = ElementEditServiceUtils.getCommandProvider(current);
								DestroyElementRequest request = new DestroyElementRequest(current, false);
								ICommand desroyCommand = provider.getEditCommand(request);
								cmd.add(desroyCommand);
							}

						}
					}
				}

				for(Object current : (List<?>)values) {
					//we create the Trace only if it doesn't exist
					Assert.isTrue(current instanceof NamedElement);
					if(!currentTracedTo.contains(current)) {
						IElementEditService provider = ElementEditServiceUtils.getCommandProvider(context);
						CreateRelationshipRequest createRequest = new CreateRelationshipRequest(context.getNearestPackage(), (NamedElement)current, context, UMLElementTypes.TRACE);
						cmd.add(provider.getEditCommand(createRequest));
					}
				}
			}
		} else {
			cmd.add(new IdentityCommandWithNotification(Messages.SetRequirementTextQuery_AssignmentCantBeDone, Messages.SetRequirementTextQuery_NotASysMLRequirement, Type.ERROR));
		}
		if(result == MessageDialog.OK) {
			editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(cmd));
		}
		return null;
	}

	/**
	 * 
	 * @param link
	 *        a {@link DirectedRelationship}
	 * @return
	 *         <code>true</code> if the link is Stereotyped with Trace (and <code>false</code> if the link is stereotyped with a subtype of Trace
	 */
	private boolean isStricteTrace(DirectedRelationship link) {
		EList<Stereotype> appliedStereotypes = link.getAppliedStereotypes();
		for(Stereotype ste : appliedStereotypes) {
			if((ste instanceof Trace)) {
				EObject stereotypeApplication = link.getStereotypeApplication(ste);
				if(Trace.class.isInstance(stereotypeApplication)) {
					return true;
				}
			}
		}
		return false;
	}
}
