/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.parser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.papyrus.gmf.diagram.common.parser.IMaskManagedSemanticParser;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.MaskLabelHelper;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Semantic Parser for {@link NamedElement} name.
 */
public class NamedElementLabelParser implements IMaskManagedSemanticParser {

	/**
	 * {@inheritDoc}
	 */
	public String getEditString(IAdaptable element, int flags) {
		String editString = "";

		EObject eObject = (EObject)element.getAdapter(EObject.class);
		if((eObject != null) && (eObject instanceof NamedElement)) {
			NamedElement semElement = (NamedElement)eObject;
			if(semElement.isSetName()) {
				editString = semElement.getName();
			}
		}
		return editString;
	}

	/**
	 * {@inheritDoc}
	 */
	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		return ParserEditStatus.EDITABLE_STATUS;
	}

	/**
	 * {@inheritDoc}
	 */
	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {

		ICommand command = UnexecutableCommand.INSTANCE;

		EObject objectToEdit = (EObject)element.getAdapter(EObject.class);
		if(objectToEdit == null) {
			return UnexecutableCommand.INSTANCE;
		}

		try {
			command = ElementEditServiceUtils.getEditServiceProvider().getEditService(objectToEdit).getEditCommand(new SetRequest(objectToEdit, UMLPackage.eINSTANCE.getNamedElement_Name(), newString));
		} catch (ServiceException e) {
			Activator.log.error(e);
		}

		return command;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getPrintString(IAdaptable element, int flags) {
		String result = "";
		EObject eObject = (EObject)element.getAdapter(EObject.class);

		if(eObject instanceof NamedElement) {
			return ((NamedElement)eObject).getName();
		}

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isAffectingEvent(Object event, int flags) {

		if(event instanceof Notification) {
			Object feature = ((Notification)event).getFeature();
			if(feature instanceof EStructuralFeature) {
				return EcorePackage.eINSTANCE.getEAnnotation_Details().equals(feature) || UMLPackage.eINSTANCE.getNamedElement_Name().equals(feature);
			}
		}

		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<EObject> getSemanticElementsBeingParsed(EObject element) {
		List<EObject> semanticElementsBeingParsed = new ArrayList<EObject>();
		semanticElementsBeingParsed.add(element);

		return semanticElementsBeingParsed;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean areSemanticElementsAffected(EObject listener, Object notification) {
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public Map<String, String> getMasks() {
		return Collections.emptyMap();
	}

	protected Collection<String> getMaskValues(IAdaptable element) {
		View view = (View)element.getAdapter(View.class);
		if(view == null) {
			return Collections.emptySet();
		}

		return MaskLabelHelper.getMaskValues(view);
	}
}
