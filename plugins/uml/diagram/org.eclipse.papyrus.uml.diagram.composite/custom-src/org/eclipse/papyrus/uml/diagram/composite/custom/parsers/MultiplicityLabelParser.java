/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.custom.parsers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.tools.utils.ValueSpecificationUtil;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Semantic Parser for {@link MultiplicityElement}
 */
public class MultiplicityLabelParser implements ISemanticParser {

	/** The String format for displaying a {@link MultiplicityElement} multiplicity */
	protected static final String MULTIPLICITY_FORMAT = "%s..%s";

	public String getPrintString(IAdaptable element, int flags) {

		String result = "";
		EObject eObject = EMFHelper.getEObject(element);

		if((eObject != null) && (eObject instanceof MultiplicityElement)) {

			MultiplicityElement multiplicity = (MultiplicityElement)eObject;

			// manage multiplicity
			String lower = ValueSpecificationUtil.getSpecificationValue(multiplicity.getLowerValue());
			String upper = ValueSpecificationUtil.getSpecificationValue(multiplicity.getUpperValue());
			if(multiplicity.getLower() != multiplicity.getUpper()) {
				result = String.format(MULTIPLICITY_FORMAT, lower, upper);
			} else {
				result = lower;
			}
		}

		return result;
	}

	public String getEditString(IAdaptable element, int flags) {
		return getPrintString(element, flags);
	}

	public boolean isAffectingEvent(Object event, int flags) {

		if(event instanceof Notification) {
			Object feature = ((Notification)event).getFeature();
			if(feature instanceof EStructuralFeature) {
				return UMLPackage.eINSTANCE.getMultiplicityElement_LowerValue().equals(feature) || UMLPackage.eINSTANCE.getMultiplicityElement_UpperValue().equals(feature);
			}
		}

		return false;
	}

	public List<EObject> getSemanticElementsBeingParsed(EObject element) {
		List<EObject> semanticElementsBeingParsed = new ArrayList<EObject>();

		if((element != null) && (element instanceof MultiplicityElement)) {
			MultiplicityElement semElement = (MultiplicityElement)element;

			semanticElementsBeingParsed.add(semElement);
			if(semElement.getLowerValue() != null) {
				semanticElementsBeingParsed.add(semElement.getLowerValue());
			}
			if(semElement.getUpperValue() != null) {
				semanticElementsBeingParsed.add(semElement.getUpperValue());
			}
		}
		return semanticElementsBeingParsed;
	}

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		return ParserEditStatus.UNEDITABLE_STATUS;
	}

	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		return UnexecutableCommand.INSTANCE;
	}

	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return null;
	}

	public boolean areSemanticElementsAffected(EObject listener, Object notification) {
		return true;
	}

}
