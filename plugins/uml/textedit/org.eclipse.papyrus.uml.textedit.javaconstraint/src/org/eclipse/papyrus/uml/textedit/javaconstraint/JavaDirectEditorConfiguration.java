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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.textedit.javaconstraint;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.extensionpoints.editors.configuration.DefaultDirectEditorConfiguration;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.UMLFactory;


/**
 * this class provides a means to display a an editor to write content into JAVA specification
 * 
 */
public class JavaDirectEditorConfiguration extends DefaultDirectEditorConfiguration {


	/**
	 * 
	 * Constructor.
	 * 
	 */
	public JavaDirectEditorConfiguration() {
	}

	@Override
	public String getTextToEdit(Object editedObject) {
		Constraint umlConstraint = (Constraint)editedObject;
		String value = "";
		if(umlConstraint.getSpecification() != null) {
			if(umlConstraint.getSpecification() instanceof LiteralString) {
				if(((LiteralString)umlConstraint.getSpecification()).getValue() != null) {
					value += ((LiteralString)umlConstraint.getSpecification()).getValue();
				}
			} else if(umlConstraint.getSpecification() instanceof org.eclipse.uml2.uml.OpaqueExpression) {
				int indexOfOCLBody = -1;
				org.eclipse.uml2.uml.OpaqueExpression opaqueExpression = (org.eclipse.uml2.uml.OpaqueExpression)umlConstraint.getSpecification();
				for(int i = 0; i < opaqueExpression.getLanguages().size() && indexOfOCLBody == -1; i++) {
					if(opaqueExpression.getLanguages().get(i).equals("JAVA")) {
						value += opaqueExpression.getBodies().get(i);
						indexOfOCLBody = i;
					}
				}
			}
		}
		return value;
	}


	@Override
	public Object postEditAction(Object objectToEdit, String newText) {
		TransactionalEditingDomain editingDomain = org.eclipse.emf.transaction.util.TransactionUtil.getEditingDomain((org.eclipse.uml2.uml.Constraint)objectToEdit);

		UpdateConstraintCommand updateCommand = new UpdateConstraintCommand(editingDomain, (org.eclipse.uml2.uml.Constraint)objectToEdit, newText);
		editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(updateCommand));
		return updateCommand;
	}

	/**
	 * the command to save the content of the OCL constraint into the body of the UML constraint element
	 * 
	 */
	protected class UpdateConstraintCommand extends AbstractTransactionalCommand {

		protected final org.eclipse.uml2.uml.Constraint constraint;

		protected final String newTextualRepresentation;

		public UpdateConstraintCommand(TransactionalEditingDomain editingDomain, org.eclipse.uml2.uml.Constraint constraint, String newTextualRepresentation) {
			super(editingDomain, "Constraint Update", getWorkspaceFiles(constraint));
			this.constraint = constraint;
			this.newTextualRepresentation = newTextualRepresentation;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor arg0, IAdaptable arg1) throws ExecutionException {
			org.eclipse.uml2.uml.OpaqueExpression opaqueExpression = null;
			int indexOfOCLBody = -1;
			if(constraint.getSpecification() == null || !(constraint.getSpecification() instanceof org.eclipse.uml2.uml.OpaqueExpression)) {
				opaqueExpression = UMLFactory.eINSTANCE.createOpaqueExpression();
			} else {
				opaqueExpression = (org.eclipse.uml2.uml.OpaqueExpression)constraint.getSpecification();
				for(int i = 0; i < opaqueExpression.getLanguages().size() && indexOfOCLBody == -1; i++) {
					if(opaqueExpression.getLanguages().get(i).equals("JAVA")) {
						indexOfOCLBody = i;
					}
				}
			}
			if(indexOfOCLBody == -1) {
				opaqueExpression.getLanguages().add("JAVA");
				opaqueExpression.getBodies().add(newTextualRepresentation);
			} else {
				opaqueExpression.getBodies().remove(indexOfOCLBody);
				opaqueExpression.getBodies().add(indexOfOCLBody, newTextualRepresentation);
			}
			constraint.setSpecification(opaqueExpression);
			return CommandResult.newOKCommandResult(constraint);
		}
	}



}
