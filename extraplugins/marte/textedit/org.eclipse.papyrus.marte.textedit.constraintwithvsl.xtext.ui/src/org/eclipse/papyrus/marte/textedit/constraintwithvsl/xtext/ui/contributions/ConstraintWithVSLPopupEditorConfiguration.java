/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.marte.textedit.constraintwithvsl.xtext.ui.contributions;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.extensionpoints.editors.configuration.ICustomDirectEditorConfiguration;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.marte.textedit.constraintwithvsl.xtext.constraintWithVSLl.ConstraintRule;
import org.eclipse.papyrus.marte.textedit.constraintwithvsl.xtext.constraintWithVSLl.ConstraintSpecification;
import org.eclipse.papyrus.marte.textedit.constraintwithvsl.xtext.ui.internal.ConstraintWithVSLlActivator;
import org.eclipse.papyrus.marte.vsl.extensions.VSLSerializationUtil;
import org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.UMLFactory;

import com.google.inject.Injector;

public class ConstraintWithVSLPopupEditorConfiguration extends DefaultXtextDirectEditorConfiguration implements ICustomDirectEditorConfiguration {

	public ConstraintWithVSLPopupEditorConfiguration() {
		super();
	}


	@Override
	public String getTextToEdit(Object editedObject) {
		if(editedObject instanceof Constraint) {
			Constraint theConstraint = (Constraint)editedObject;
			if(theConstraint.getSpecification() != null && theConstraint.getSpecification() instanceof OpaqueExpression) {
				OpaqueExpression spec = (OpaqueExpression)theConstraint.getSpecification();
				int indexOfVSLExpression = -1;
				int i = 0;
				for(String language : spec.getLanguages()) {
					if(language.equals("VSL")) {
						indexOfVSLExpression = i;
					}
					i++;
				}
				return indexOfVSLExpression != -1 ? spec.getBodies().get(indexOfVSLExpression) : "";
			} else {
				return "";
			}
		} else {
			return "Not a Constraint";
		}
	}

	/**
	 * @author CEA LIST
	 *
	 *         A command for updating the context UML model
	 */
	protected class UpdateConstraintWithVSLCommand extends AbstractTransactionalCommand {

		private Constraint theConstraint;

		private String newBody;

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor
		 * , org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor arg0, IAdaptable arg1) throws ExecutionException {

			theConstraint.setSpecification(null);

			OpaqueExpression opaqueExp = UMLFactory.eINSTANCE.createOpaqueExpression();
			opaqueExp.getLanguages().add("VSL");
			opaqueExp.getBodies().add(newBody);

			theConstraint.setSpecification(opaqueExp);

			return CommandResult.newOKCommandResult(theConstraint);
		}

		public UpdateConstraintWithVSLCommand(Constraint constraint, String newBody) {
			super((TransactionalEditingDomain)EMFHelper.resolveEditingDomain(constraint), "Constraint Update", getWorkspaceFiles(constraint));
			this.theConstraint = constraint;
			this.newBody = newBody;
		}
	}

	@Override
	public Injector getInjector() {
		return ConstraintWithVSLlActivator.getInstance().getInjector("org.eclipse.papyrus.marte.textedit.constraintwithvsl.xtext.ConstraintWithVSLl");
	}


	@Override
	protected ICommand getParseCommand(EObject umlObject, EObject xtextObject) {
		ConstraintSpecification newSpecification = null;

		ConstraintRule rule = (ConstraintRule)xtextObject;
		newSpecification = rule.getSpecification();
		String newBody = null;
		if(newSpecification != null) {
			newBody = VSLSerializationUtil.printExpression(newSpecification.getExpression());
		}

		if(!(umlObject instanceof Constraint)) {
			return UnexecutableCommand.INSTANCE;
		}

		if(newBody == null) {
			return UnexecutableCommand.INSTANCE;
		}

		Constraint constraint = (Constraint)umlObject;

		UpdateConstraintWithVSLCommand updateCommand = new UpdateConstraintWithVSLCommand(constraint, newBody);

		return updateCommand;
	}

}
