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

import org.apache.commons.lang.WordUtils;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.ocl.examples.pivot.ParserException;
import org.eclipse.ocl.examples.pivot.utilities.BaseResource;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.essentialocl.EssentialOCLRuntimeModule;
import org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter.IContextElementProvider;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter.IContextElementProviderWithInit;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.LiteralString;
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
		// return SWT.SINGLE;
		return SWT.MULTI;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Point getPreferedSize() {
		return new Point(SWT.DEFAULT, SWT.DEFAULT);
	}
	

	/**
	 * the command to save the content of the OCL constraint into the body of the UML constraint element
	 * 
	 */
	protected class UpdateConstraintCommand extends AbstractTransactionalCommand {

		protected final org.eclipse.uml2.uml.Constraint constraint;

		protected final String newTextualRepresentation;

		public UpdateConstraintCommand(TransactionalEditingDomain editingDomain, org.eclipse.uml2.uml.Constraint constraint, String newTextualRepresentation) {
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
				opaqueExpression.getBodies().remove(indexOfOCLBody);
				opaqueExpression.getBodies().add(indexOfOCLBody, newTextualRepresentation);
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
		value = WordUtils.wrap(value, 40);
		return value;
	}

	@Override
	public IContextElementProvider getContextProvider() {
		return new IContextElementProviderWithInit() {

			public EObject getContextObject() {
				if(objectToEdit instanceof Constraint) {
					return ((Constraint)objectToEdit).getConstrainedElements().get(0);
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
	protected ICommand getParseCommand(EObject umlObject, EObject xtextObject) {
		if (!(umlObject instanceof Constraint)) {
			return UnexecutableCommand.INSTANCE;
		}
		Constraint constraint = (Constraint) umlObject;
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(umlObject);
		return new UpdateConstraintCommand(editingDomain, constraint, xtextObject.toString());
	}
}
