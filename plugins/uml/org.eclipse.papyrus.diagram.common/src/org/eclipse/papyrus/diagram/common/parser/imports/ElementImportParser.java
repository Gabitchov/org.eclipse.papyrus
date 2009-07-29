/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.parser.imports;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.papyrus.diagram.common.Messages;
import org.eclipse.papyrus.diagram.common.parser.ElementProvider;
import org.eclipse.papyrus.diagram.common.parser.assist.EObjectCompletionProcessor;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.UMLPackage;

public class ElementImportParser implements ISemanticParser {

	private final ElementProvider myElementProvider;

	private final CompletionProcessor myCompletionProcessor = new CompletionProcessor();

	private static final String UNDEFINED_VALUE = Messages.ElementImportParser_undefined_value;

	public ElementImportParser() {
		this(new ElementImportProvider());
	}

	public ElementImportParser(ElementProvider elementProvider) {
		myElementProvider = elementProvider;
	}

	@SuppressWarnings("serial")
	public List<?> getSemanticElementsBeingParsed(EObject eObject) {
		ElementImport immport = (ElementImport) eObject;
		List<EObject> result = new LinkedList<EObject>() {

			@Override
			public boolean add(EObject o) {
				if (o == null) {
					return false;
				}
				return super.add(o);
			}
		};
		result.add(immport);
		result.add(immport.getImportedElement());
		return result;
	}

	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		myCompletionProcessor.setContext(doAdapt(element));
		return myCompletionProcessor;
	}

	public String getEditString(IAdaptable element, int flags) {
		StringBuffer result = new StringBuffer();
		ElementImport subject = doAdapt(element);
		PackageableElement importedElement = subject.getImportedElement();
		if (importedElement != null) {
			String fqn = importedElement.getQualifiedName();
			if (isEmpty(fqn)) {
				fqn = importedElement.getName();
			}
			if (!isEmpty(fqn)) {
				result.append(fqn);
			}
		} else {
			result.append(UNDEFINED_VALUE);
		}
		String alias = subject.getAlias();
		if (!isEmpty(alias)) {
			result.append(" as "); //$NON-NLS-1$
			result.append(alias);
		}
		return result.toString();
	}

	public String getPrintString(IAdaptable element, int flags) {
		return getEditString(element, flags);
	}

	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		PackageableElement imported = findElement(element, newString);
		if (imported == null) {
			return UnexecutableCommand.INSTANCE;
		}
		ElementImport elementImport = doAdapt(element);
		if (imported.equals(elementImport.getImportedElement())) {
			return UnexecutableCommand.INSTANCE;
		}
		return new SetValueCommand(new SetRequest(elementImport, UMLPackage.eINSTANCE
				.getElementImport_ImportedElement(), imported));
	}

	public boolean areSemanticElementsAffected(EObject listener, Object notification) {
		return isAffectingEvent(notification);
	}

	public boolean isAffectingEvent(Object event, int flags) {
		return isAffectingEvent(event);
	}

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		PackageableElement imported = findElement(element, editString);
		if (imported == null) {
			return new ParserEditStatus(IStatus.ERROR, PLUGIN_ID, IParserEditStatus.UNEDITABLE,
					"Unknown metaclass: " + editString, null); //$NON-NLS-1$
		}
		return ParserEditStatus.EDITABLE_STATUS;
	}

	private PackageableElement findElement(IAdaptable parserElement, String editString) {
		if (editString == null) {
			return null;
		}
		editString = editString.trim();
		if (editString.length() == 0) {
			return null;
		}
		return myElementProvider.findElement(doAdapt(parserElement), editString);
	}

	private ElementImport doAdapt(IAdaptable adaptable) {
		ElementImport element = (ElementImport) adaptable.getAdapter(EObject.class);
		return element;
	}

	private boolean isEmpty(String text) {
		return text == null || text.length() == 0;
	}

	private boolean isAffectingEvent(Object notification) {
		if (notification instanceof Notification) {
			Object feature = ((Notification) notification).getFeature();
			return feature == UMLPackage.eINSTANCE.getNamedElement_Name()
					|| feature == UMLPackage.eINSTANCE.getElementImport_Alias()
					|| feature == UMLPackage.eINSTANCE.getElementImport_ImportedElement();
		}
		return false;
	}

	private class CompletionProcessor extends EObjectCompletionProcessor {

		@Override
		protected Iterable<String> computeContextProposals(EObject context) {
			return myElementProvider.getElementNames(context);
		}
	}

	private static final String PLUGIN_ID = "org.eclipse.papyrus.diagram.common.common"; //$NON-NLS-1$

}
