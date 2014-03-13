/*****************************************************************************
 * Copyright (c) 2011,2012 CEA LIST and others
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  E.D.Willink - Initial API and implementation
 *  CEA LIST - Architecture refactoring
 *  E.D.Willink - Bug 388529
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.textedit.constraintwithessentialocl.xtext;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.utilities.BaseResource;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.essentialocl.EssentialOCLRuntimeModule;
import org.eclipse.papyrus.infra.services.validation.commands.AbstractValidateCommand;
import org.eclipse.papyrus.infra.services.validation.commands.AsyncValidateSubtreeCommand;
import org.eclipse.papyrus.uml.service.validation.UMLDiagnostician;
import org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter.IContextElementProvider;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter.IContextElementProviderWithInit;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.Inject;
import com.google.inject.Injector;


/**
 * this plugin is the configuration of the essential editor
 * 
 */
public class EssentialOCLEditorConfiguration extends DefaultXtextDirectEditorConfiguration { 
 // org.eclipse.papyrus.infra.gmfdiag.xtext.glue.PopupEditorConfiguration {

	private static final String OCL = "OCL"; //$NON-NLS-1$

	@Inject
	protected XtextResource fakeResource;
	
	/**
	 * Clients may override to change style to {@link SWT}.MULTI
	 */
	@Override
	public int getStyle() {
		return SWT.MULTI | SWT.WRAP;
	}
	
	@Override
	public Object preEditAction(Object editedObject) {
		if (editedObject instanceof OpaqueExpression) {
			editedObject = ((OpaqueExpression) editedObject).getOwner(); 
		}
		else if (editedObject instanceof Constraint) {
			Constraint constraint = (Constraint) editedObject;
			if (!(constraint.getSpecification() instanceof OpaqueExpression)) {
				if (constraint.getSpecification().stringValue().length() > 0) {
					MessageDialog.openWarning(new Shell(),
						Messages.EssentialOCLEditorConfiguration_ExistingSpecification,
						Messages.EssentialOCLEditorConfiguration_AlreadyContainsNonEmpty);
				}
			}
		}
		return super.preEditAction(editedObject);
	}

	/**
	 * the command to save the content of the OCL constraint into the body of the UML constraint element
	 * 
	 */
	protected class UpdateConstraintCommand extends AbstractTransactionalCommand {

		protected final Constraint constraint;

		protected final String newTextualRepresentation;

		public UpdateConstraintCommand(TransactionalEditingDomain editingDomain, Constraint constraint, String newTextualRepresentation) {
			super(editingDomain, "Constraint Update", getWorkspaceFiles(constraint)); //$NON-NLS-1$
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
					if(opaqueExpression.getLanguages().get(i).equals(OCL)) {
						indexOfOCLBody = i;
					}
				}
			}
			if(indexOfOCLBody == -1) {
				opaqueExpression.getLanguages().add(OCL);
				opaqueExpression.getBodies().add(newTextualRepresentation);
			} else {
				opaqueExpression.getBodies().set(indexOfOCLBody, newTextualRepresentation);
			}
			constraint.setSpecification(opaqueExpression);
			
			return CommandResult.newOKCommandResult(constraint);
		}
	}
		
	@Override
	public String getTextToEdit(Object editedObject) {
		Constraint umlConstraint = (Constraint)objectToEdit;
		String value = ""; //$NON-NLS-1$
		if(umlConstraint.getSpecification() != null) {
			if(umlConstraint.getSpecification() instanceof LiteralString) {
				if(((LiteralString)umlConstraint.getSpecification()).getValue() != null) {
					value += ((LiteralString)umlConstraint.getSpecification()).getValue();
				}
			} else if(umlConstraint.getSpecification() instanceof org.eclipse.uml2.uml.OpaqueExpression) {
				int indexOfOCLBody = -1;
				org.eclipse.uml2.uml.OpaqueExpression opaqueExpression = (org.eclipse.uml2.uml.OpaqueExpression)umlConstraint.getSpecification();
				for(int i = 0; i < opaqueExpression.getLanguages().size() && indexOfOCLBody == -1; i++) {
					if(opaqueExpression.getLanguages().get(i).equals(OCL)) {
						value += opaqueExpression.getBodies().get(i);
						indexOfOCLBody = i;
					}
				}
			}
		}
		return value;
	}

	@Override
	public IContextElementProvider getContextProvider() {
		return new IContextElementProviderWithInit() {

			public EObject getContextObject() {
				if(objectToEdit instanceof Constraint) {
					return ((Constraint)objectToEdit).getContext();
				}
				return null;
			}

			public void initResource(XtextResource resource) {
				try {
					if (resource instanceof BaseResource) {
						PivotUtil.setParserContext((BaseResource) resource, getContextObject());
					}
				}
				catch (ParserException e) {
				}
			}
		};
	}
		
	@Override
	public Injector getInjector() {
		return UMLConstraintEditorActivator.getInstance().getInjector(EssentialOCLRuntimeModule.LANGUAGE_ID);
	}
	
	@Override
	public IParser createParser(final EObject semanticObject) {
		if (objectToEdit == null) {
			objectToEdit = semanticObject;
		}
		final IParser defaultParser = super.createParser(semanticObject);
		return new IParser() {

			public String getEditString(IAdaptable element, int flags) {
				return defaultParser.getEditString(element, flags);
			}

			public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
				// the superclass creates a comment, if validation fails. This is not useful in case of OCL,
				// since the OCL expression is already stored in opaque form within the constraint.
				CompositeCommand result = new CompositeCommand("validation"); //$NON-NLS-1$
				TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(semanticObject);
				if (semanticObject instanceof Constraint) {
					result.add(new UpdateConstraintCommand(editingDomain, (Constraint) semanticObject, newString));
					final AbstractValidateCommand validationCommand = new AsyncValidateSubtreeCommand(semanticObject, new UMLDiagnostician());
					validationCommand.disableUIFeedback();
					result.add(validationCommand);
				}
				return result;
			}

			public String getPrintString(IAdaptable element, int flags) {
				return defaultParser.getPrintString(element, flags);
			}

			public boolean isAffectingEvent(Object event, int flags) {
				return false;
			}

			public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
				// Not used
				return null;
			}

			public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
				// Not used
				return null;
			}
		};
	}

	@Override
	protected ICommand getParseCommand(EObject umlObject, EObject xtextObject) {
		// this operation is never called, since the parser above will not call it.
		return UnexecutableCommand.INSTANCE;
	}
}
