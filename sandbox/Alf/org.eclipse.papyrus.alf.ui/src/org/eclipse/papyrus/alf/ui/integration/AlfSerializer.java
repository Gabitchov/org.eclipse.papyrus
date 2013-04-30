/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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

package org.eclipse.papyrus.alf.ui.integration;

import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.alf.compiler.IAlfCompiler;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;

/**
 * A default, abstract reconciliation strategy for Alf.
 * Introduces a new method reconcileWithError, which only adds a textual representation comment to the edited element 
 * 
 * @author CEA LIST - Initial contribution and API 
 *
 */
public class AlfSerializer {

	/**
	 * Adds a textual representation comment to the edit modelObject, if this eObject is a uml Element
	 * 
	 * @param graphicalEditPart
	 * @param modelObject
	 * @param newTextualRepresentation
	 */
	public boolean serialize(Element contextElement, String newTextualRepresentation, Object[] args) {
		TransactionalEditingDomain domain = (TransactionalEditingDomain)EMFHelper.resolveEditingDomain(contextElement) ;
		CompileCommand updateCommand = new CompileCommand(contextElement, newTextualRepresentation, args, domain);
		domain.getCommandStack().execute(updateCommand) ;
		return updateCommand.getCompileResult() ;
	}

	/**
	 * @author CEA LIST
	 * 
	 *         A command for updating the context UML model
	 */
	protected class CompileCommand extends RecordingCommand {

		protected Element element ;
		protected String textualRepresentation ;
		protected Object[] args ;
		protected boolean compileResult = false ;

		public CompileCommand(Element element, String textualRepresentation, Object[] args, TransactionalEditingDomain domain) {
			super(domain) ;
			this.element = element ;
			this.textualRepresentation = textualRepresentation ;
			this.args = args ;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor
		 * , org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected void doExecute() {
			// first tries to compile the textual representation
			IAlfCompiler alfCompiler = AlfEditorUtils.getAlfCompiler() ;
			if (alfCompiler != null) {
				this.compileResult = alfCompiler.compile(element, textualRepresentation, args) ;
			}
			else {
				MessageDialog.open(MessageDialog.ERROR, Display.getCurrent().getActiveShell(), "Validation info", "No registered Alf Compiler", SWT.NONE) ;
			}
			// Then generates a textual representation comment, indenpently of compilation results
			Comment textualRepresentationComment = null ;
			List<Comment> allComments = element.getOwnedComments() ;
			if (!allComments.isEmpty()) {
				for (Comment comment : allComments) {
					if (AlfEditorUtils.isATextualRepresentationComment(comment)) {
						textualRepresentationComment = comment ;
					}
				}
			}
			if (textualRepresentationComment == null) {
				// A textual representation comment has to be created
				textualRepresentationComment = AlfEditorUtils.createTextualRepresentationComment(this.element) ;
			}
			textualRepresentationComment.setBody(this.textualRepresentation) ;
		}

		public boolean getCompileResult() {
			return this.compileResult ;
		}
		
	}

	/**
	 * Adds a textual representation comment to the edit modelObject, if this eObject is a uml Element
	 * 
	 * @param graphicalEditPart
	 * @param modelObject
	 * @param newTextualRepresentation
	 */
	public boolean validate(Element contextElement, String newTextualRepresentation, Object[] args) {
		TransactionalEditingDomain domain = (TransactionalEditingDomain)EMFHelper.resolveEditingDomain(contextElement) ;
		ValidateCommand updateCommand = new ValidateCommand(contextElement, newTextualRepresentation, args, domain);
		domain.getCommandStack().execute(updateCommand) ;
		return updateCommand.getValidationResult() ;
	}

	/**
	 * @author CEA LIST
	 * 
	 *         A command for updating the context UML model
	 */
	protected class ValidateCommand extends RecordingCommand {

		protected Element element ;
		protected String textualRepresentation ;
		protected Object[] args ;
		protected boolean validationResult = false ;

		public ValidateCommand(Element element, String textualRepresentation, Object[] args, TransactionalEditingDomain domain) {
			super(domain) ;
			this.element = element ;
			this.textualRepresentation = textualRepresentation ;
			this.args = args ;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor
		 * , org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected void doExecute() {
			// first tries to compile the textual representation
			IAlfCompiler alfCompiler = AlfEditorUtils.getAlfCompiler() ;
			if (alfCompiler != null) {
				this.validationResult = alfCompiler.validate(element, textualRepresentation, args) ;
			}
			else {
				MessageDialog.open(MessageDialog.ERROR, Display.getCurrent().getActiveShell(), "Validation info", "No registered Alf Compiler", SWT.NONE) ;
			}
		}

		public boolean getValidationResult() {
			return this.validationResult ;
		}
		
	}
}
