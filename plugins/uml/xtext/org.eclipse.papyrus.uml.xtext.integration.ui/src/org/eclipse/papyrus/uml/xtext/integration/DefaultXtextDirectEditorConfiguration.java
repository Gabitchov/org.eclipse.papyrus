/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Andreas Muelder - muelder@itemis.de -  Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.xtext.integration;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.papyrus.extensionpoints.editors.configuration.DefaultDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.ICustomDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConfiguration;
import org.eclipse.papyrus.infra.services.validation.EcoreDiagnostician;
import org.eclipse.papyrus.infra.services.validation.commands.ValidateSubtreeCommand;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter.IContextElementProvider;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter.IContextElementProviderWithInit;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.StringInputStream;

import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;

/**
 * 
 * abstract base implementation of {@link ICustomDirectEditorConfiguration}
 * 
 * @author andreas muelder - Initial contribution and API
 *         Ansgar Radermacher - Added possibility to configure context provider
 * 
 */
public abstract class DefaultXtextDirectEditorConfiguration extends DefaultDirectEditorConfiguration implements ICustomDirectEditorConfiguration {

	public static final String ANNOTATION_SOURCE = "expression_source";

	public static final String ANNOTATION_DETAIL = "expression";

	/**
	 * returns the UI Injector for the Xtext language
	 * 
	 */
	public abstract Injector getInjector();

	/**
	 * returns the {@link ICommand} used to update the UML Model
	 * 
	 * @param umlObject
	 * @param xtextObject
	 * @return
	 */
	protected abstract ICommand getParseCommand(EObject umlObject, EObject xtextObject);

	/**
	 * Clients may override to change style to {@link SWT}.MULTI
	 */
	@Override
	public int getStyle() {
		return SWT.SINGLE;
	}

	/**
	 * Clients may override, if the objectToEdit is not equal to the context element
	 * @return the context provider
	 */
	public IContextElementProvider getContextProvider() {
		return new IContextElementProvider() {

			public EObject getContextObject() {
				if (objectToEdit instanceof EObject) {
					return (EObject) objectToEdit;
				}
				return null;
			}
		};
	}
	
	public DirectEditManager createDirectEditManager(final ITextAwareEditPart host) {
		IContextElementProvider provider;
		if (objectToEdit != null) {
			provider = getContextProvider();
		}
		else {
			provider = new IContextElementProvider() {

				public EObject getContextObject() {
					if(host instanceof IGraphicalEditPart) {
						return ((IGraphicalEditPart)host).resolveSemanticElement();
					}
					return null;
				}
			};
		}
		return new XtextDirectEditManager(host, getInjector(), getStyle(), this);
	}

	/**
	 * Adapts {@link IDirectEditorConfiguration} to gmfs {@link IParser} interface for reuse in GMF direct editing infrastructure.
	 */
	public IParser createParser(final EObject semanticObject) {
		if (objectToEdit == null) {
			objectToEdit = semanticObject;
		}
		return new IParser() {

			public String getEditString(IAdaptable element, int flags) {
				return DefaultXtextDirectEditorConfiguration.this.getTextToEditInternal(semanticObject);
			}

			public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
				CompositeCommand result = new CompositeCommand("validation"); //$NON-NLS-1$
				IContextElementProvider provider = getContextProvider();

				XtextFakeResourceContext context = new XtextFakeResourceContext(getInjector());
				context.getFakeResource().eAdapters().add(new ContextElementAdapter(provider));
				try {
					context.getFakeResource().load(new StringInputStream(newString), Collections.EMPTY_MAP);
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (provider instanceof IContextElementProviderWithInit) {
					((IContextElementProviderWithInit) provider).initResource(context.getFakeResource());
				}
				EcoreUtil2.resolveLazyCrossReferences(context.getFakeResource(), CancelIndicator.NullImpl);
				if(!context.getFakeResource().getParseResult().hasSyntaxErrors() && context.getFakeResource().getErrors().size() == 0) {
					EObject xtextObject = context.getFakeResource().getParseResult().getRootASTElement();
					result.add(DefaultXtextDirectEditorConfiguration.this.getParseCommand(semanticObject, xtextObject));
				} else {
					result.add(createInvalidStringCommand(newString, semanticObject));
				}
				ValidateSubtreeCommand validationCommand = new ValidateSubtreeCommand(semanticObject, new EcoreDiagnostician());
				validationCommand.disableUIFeedback();
				result.add(validationCommand);
				return result;
			}

			public String getPrintString(IAdaptable element, int flags) {
				return DefaultXtextDirectEditorConfiguration.this.getTextToEdit(semanticObject);
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

	protected String getTextToEditInternal(EObject semanticObject) {
		if(semanticObject instanceof Element) {
			String textualRepresentation = InvalidStringUtil.getTextualRepresentation((Element)semanticObject);
			if(textualRepresentation != null) {
				return textualRepresentation;
			}
		}
		return getTextToEdit(semanticObject);
	}

	protected ICommand createInvalidStringCommand(final String newString, EObject semanticElement) {
		if(semanticElement instanceof Element) {
			registerInvalidStringAdapter(semanticElement);
			final Element element = (Element)semanticElement;
			return new AbstractTransactionalCommand(TransactionUtil.getEditingDomain(semanticElement), "", Collections.emptyList()) {

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					String languageName = getInjector().getInstance(Key.get(String.class, Names.named(Constants.LANGUAGE_NAME)));
					Comment comment = InvalidStringUtil.getTextualRepresentationComment(element);
					if(comment == null) {
						comment = InvalidStringUtil.createTextualRepresentationComment(element, languageName);
					}
					comment.setBody(newString);
					return CommandResult.newOKCommandResult();
				}
			};

		}
		return UnexecutableCommand.INSTANCE;
	}

	protected void registerInvalidStringAdapter(EObject semanticElement) {
		Adapter existingAdapter = EcoreUtil.getExistingAdapter(semanticElement, InvalidSyntaxAdapter.class);
		if(existingAdapter == null) {
			semanticElement.eAdapters().add(new InvalidSyntaxAdapter());
		}
	}

	public CellEditor createCellEditor(Composite parent, final EObject semanticObject) {
		IContextElementProvider provider = getContextProvider();
		XtextStyledTextCellEditorEx cellEditor = new XtextStyledTextCellEditorEx(SWT.MULTI | SWT.BORDER, getInjector(), provider) {

			// This is a workaround for bug
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=412732
			// We can not create SWT.SINGLE CellEditor here, so we have to hook
			// into the StyledTextListener to disable new line. Delete this when
			// the bug is fixed
			@Override
			protected StyledText createStyledText(Composite parent) {
				StyledText text = super.createStyledText(parent);
				text.addListener(3005, new Listener() {

					public void handleEvent(Event event) {
						if(event.character == SWT.CR && !completionProposalAdapter.isProposalPopupOpen()) {
							focusLost();
						}
					}
				});
				return text;
			}
			// Workaround end
		};
		cellEditor.create(parent);
		return cellEditor;
	}
}
