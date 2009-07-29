/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */

package org.eclipse.papyrus.diagram.common.parser;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.parser.lookup.LookupResolver;
import org.eclipse.papyrus.diagram.common.parser.lookup.LookupResolverImpl;
import org.eclipse.papyrus.diagram.common.parser.lookup.LookupSuite;

public class ParserAdapter implements IParser {

	private static final String NOT_AN_OBJECT = "Unknown";

	private final ExternalParserBase myDelegate;

	private final EObject myTester;

	private final ApplyStrategy myApplier;

	private final ExternalToString myView;

	private final ExternalToString myEdit;

	private final static MessageFormatEscaper ourMessageFormatEscaper = new MessageFormatEscaper();

	public ParserAdapter(ExternalParserBase delegate, ApplyStrategy applier) {
		this(delegate, applier, ExternalToString.NOT_IMPLEMENTED);
	}

	public ParserAdapter(ExternalParserBase delegate, ApplyStrategy applier, ExternalToString viewAndEdit) {
		this(delegate, applier, viewAndEdit, viewAndEdit);
	}

	public ParserAdapter(ExternalParserBase delegate, ApplyStrategy applier, ExternalToString view,
			ExternalToString edit) {
		myDelegate = delegate;
		myApplier = applier;
		myView = view;
		myEdit = edit;
		myTester = myDelegate.createSubjectPrototype();
	}

	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return null;
	}

	public String getEditString(IAdaptable element, int flags) {
		return getToString(element, flags, myEdit);
	}

	public String getPrintString(IAdaptable element, int flags) {
		return getToString(element, flags, myView);
	}

	public final boolean isAffectingEvent(Object event, int flags) {
		return isAffectingEvent(event);
	}

	protected boolean isAffectingEvent(Object event) {
		if (event instanceof Notification) {
			Object feature = ((Notification) event).getFeature();
			return (feature instanceof EStructuralFeature) && myView.isAffectingFeature((EStructuralFeature) feature);
		}
		return false;
	}

	public IParserEditStatus isValidEditString(IAdaptable adapter, String editString) {
		EObject modelObject = (EObject) adapter.getAdapter(EObject.class);
		if (modelObject == null) {
			return new ParserEditStatus(Activator.ID, IParserEditStatus.UNEDITABLE, "Can not find context object");
		}

		LookupSuite oldLookup = myDelegate.getLookupSuite();
		try {
			myDelegate.setLookupSuite(LookupSuite.NULL_SUITE);
			myDelegate.parse(myTester, editString, modelObject);
			return ParserEditStatus.EDITABLE_STATUS;
		} catch (ExternalParserException e) {
			// CellEditor uses MessageFormat to format the message
			// we need to escape '{', '}', '\' to prevent failure while formatting an error
			String message = e.getMessage();
			if (message == null) {
				message = "";
			}
			message = ourMessageFormatEscaper.getEscaped(message);
			return new ParserEditStatus(Activator.ID, IParserEditStatus.UNEDITABLE, "Invalid input: " + message);
		} finally {
			myDelegate.setLookupSuite(oldLookup);
		}
	}

	public ICommand getParseCommand(IAdaptable adapter, String newString, int flags) {
		final EObject modelObject = (EObject) adapter.getAdapter(EObject.class);
		if (modelObject == null) {
			return UnexecutableCommand.INSTANCE;
		}
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(modelObject);
		if (editingDomain == null) {
			return UnexecutableCommand.INSTANCE;
		}

		IGraphicalEditPart diagramEditPart = (DiagramEditPart) adapter.getAdapter(DiagramEditPart.class);
		LookupResolver resolver = LookupResolver.NULL;
		if (diagramEditPart != null) {
			resolver = new LookupResolverImpl(diagramEditPart);
		}
		myDelegate.setLookupResolver(resolver);

		final EObject parsed;
		try {
			parsed = myDelegate.parseNewObject(modelObject, newString);
		} catch (ExternalParserException e) {
			// strange
			// e.printStackTrace();
			return UnexecutableCommand.INSTANCE;
		} finally {
			myDelegate.setLookupResolver(null);
		}

		List commandList = new LinkedList();
		if (resolver.canResolve()) {
			AbstractTransactionalCommand resolveCommand = resolver.getResolveCommand();
			AbstractTransactionalCommand computeAndApplyCommand = new AbstractTransactionalCommand(editingDomain, "",
					null) {

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
						throws ExecutionException {
					for (Iterator applyCommands = myApplier.apply(modelObject, parsed).iterator(); applyCommands
							.hasNext();) {
						ICommand next = (ICommand) applyCommands.next();
						next.execute(monitor, info);
					}
					return CommandResult.newOKCommandResult();
				}
			};
			commandList.add(resolveCommand);
			commandList.add(computeAndApplyCommand);
		} else {
			commandList.addAll(myApplier.apply(modelObject, parsed));
		}
		return new CompositeTransactionalCommand(editingDomain, getCommandLabel(commandList), commandList);
	}

	protected final ExternalToString getViewToString() {
		return myView;
	}

	private String getToString(IAdaptable element, int flags, ExternalToString toString) {
		EObject modelObject = (EObject) element.getAdapter(EObject.class);
		return isValidElement(modelObject) ? toString.getToString(modelObject, flags) : NOT_AN_OBJECT;
	}

	private String getCommandLabel(List/* 1.5 <ICommand> */commandList) {
		return "-not-implemented-";
	}

	protected final boolean isValidElement(Object object) {
		return object != null && myDelegate.getSubjectClass().isInstance(object);
	}

	private static class MessageFormatEscaper {

		private final char S_QUOTE = '\'';

		public String getEscaped(String input) {
			if (!input.contains("'")) {
				return "'" + input + "'";
			}
			StringBuffer result = new StringBuffer(input.length() + 5);
			result.append(S_QUOTE);
			for (int i = 0; i < input.length(); i++) {
				char next = result.charAt(i);
				if (next == S_QUOTE) {
					result.append(S_QUOTE);
				}
				result.append(next);
			}
			result.append(S_QUOTE);
			return result.toString();
		}
	}

}
