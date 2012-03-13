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

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.infra.query.core.exception.ModelQueryExecutionException;
import org.eclipse.emf.facet.infra.query.core.java.IJavaModelQuery;
import org.eclipse.emf.facet.infra.query.core.java.ParameterValueList;
import org.eclipse.emf.facet.infra.query.runtime.ModelQueryParameterValue;
import org.eclipse.emf.facet.widgets.nattable.tableconfiguration.InstantiationMethodParameters;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Assign;
import org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;


@SuppressWarnings("restriction")
/**
 * Query to create a comment with the Assign Stereotype.
 * @author omelois
 *
 */
public class CreateAssignCommentQuery implements IJavaModelQuery<EObject, Comment> {

	public Comment evaluate(EObject context, ParameterValueList parameterValues) throws ModelQueryExecutionException {
		EditingDomain editingDomain = null;
		ModelQueryParameterValue model = parameterValues.getParameterValueByName(InstantiationMethodParameters.getEditingDomainParameter().getName());
		if(model != null) {
			if(model.getValue() instanceof EditingDomain) {
				editingDomain = (EditingDomain)model.getValue();
			}
		}
		if(editingDomain != null) {
			if(context != null) {
				//Everything is performed by a command.
				final org.eclipse.uml2.uml.Package p = (org.eclipse.uml2.uml.Package)context;
				final Comment comment = UMLFactory.eINSTANCE.createComment();
				CompositeCommand compo = new CompositeCommand("Apply and add");//$NON-NLS-1$


				//Creation of the command that will apply the Marte profile if needed.
				AbstractTransactionalCommand applyProfileCommand = new AbstractTransactionalCommand((TransactionalEditingDomain)editingDomain, "Apply marte profile", null) {

					@Override
					protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

						Resource r = p.eResource();
						if(r != null) {
							ResourceSet set = r.getResourceSet();
							if(set != null) {
								Resource allocResource = set.getResource(URI.createURI("pathmap://Papyrus_PROFILES/MARTE.profile.uml"), true);//$NON-NLS-1$
								final Profile profile = (Profile)allocResource.getEObject("_ar8OsAPMEdyuUt-4qHuVvQ");//$NON-NLS-1$
								p.applyProfile(profile);
							}
						}

						return CommandResult.newOKCommandResult();
					}

					@Override
					public boolean canExecute() {
						Stereotype stereotype = comment.getApplicableStereotype("MARTE::MARTE_Foundations::Alloc::Assign");//$NON-NLS-1$
						return stereotype == null;
					}
				};
				//END OF COMMAND

				compo.add(applyProfileCommand);
				compo.add(new EMFtoGMFCommandWrapper(new AddCommand(editingDomain, p, UMLPackage.Literals.ELEMENT__OWNED_COMMENT, comment)));

				//Command that applies the stereotype apply.
				AbstractTransactionalCommand applyStereotypeCommand = new AbstractTransactionalCommand((TransactionalEditingDomain)editingDomain, "Apply assign stereotype", null) {//$NON-NLS-1$

					@Override
					protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
						Stereotype stereotype = comment.getApplicableStereotype("MARTE::MARTE_Foundations::Alloc::Assign");//$NON-NLS-1$
						Assign assign = (Assign)comment.applyStereotype(stereotype);
						return CommandResult.newOKCommandResult(assign);
					}
				};
				//END OF COMMAND


				compo.add(applyStereotypeCommand);
				//Executing the command
				editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(compo));
				//Getting the assign thjat was created by applying the stereotype on the command.
				Object commandResult = applyStereotypeCommand.getCommandResult().getReturnValue();

				//Returning the comment
				if(commandResult instanceof Assign) {
					return comment;
				}
			}
		}
		return null;
	}

}
