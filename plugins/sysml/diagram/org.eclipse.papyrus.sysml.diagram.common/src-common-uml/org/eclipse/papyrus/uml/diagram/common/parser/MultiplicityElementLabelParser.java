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
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
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
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.papyrus.gmf.diagram.common.parser.IMaskManagedSemanticParser;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.MaskLabelHelper;
import org.eclipse.papyrus.sysml.diagram.common.preferences.ILabelPreferenceConstants;
import org.eclipse.papyrus.uml.tools.utils.ValueSpecificationUtil;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Semantic Parser for {@link MultiplicityElement}
 */
public class MultiplicityElementLabelParser implements IMaskManagedSemanticParser {

	/** The String format for displaying a {@link Property} label with multiplicity */
	protected static final String MULTIPLICITY_FORMAT = "[%s..%s]";

	/** The String format for displaying a {@link Property} label with multiplicity */
	protected static final String MULTIPLICITY_FORMAT_ALT = "[%s]";

	/**
	 * {@inheritDoc}
	 */
	public String getEditString(IAdaptable element, int flags) {
		return getPrintString(element, flags);
	}

	/**
	 * {@inheritDoc}
	 */
	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		return ParserEditStatus.UNEDITABLE_STATUS;
	}

	/**
	 * {@inheritDoc}
	 */
	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getPrintString(IAdaptable element, int flags) {

		Collection<String> maskValues = getMaskValues(element);

		if(maskValues.isEmpty()) {
			return MaskedLabel;
		}

		String result = "";
		EObject eObject = (EObject)element.getAdapter(EObject.class);

		if((eObject != null) && (eObject instanceof MultiplicityElement)) {

			MultiplicityElement multElt = (MultiplicityElement)eObject;

			// manage multiplicity
			if((maskValues.contains(ILabelPreferenceConstants.DISP_MULTIPLICITY))) {

				// If multiplicity is [1] (SysML default), only show when explicitly asked.
				// TODO : add a case for default with multiplicity not set.
				String lower = (multElt.getLowerValue() != null) ? ValueSpecificationUtil.getSpecificationValue(multElt.getLowerValue()) : "1";
				String upper = (multElt.getLowerValue() != null) ? ValueSpecificationUtil.getSpecificationValue(multElt.getUpperValue()) : "1";
				if(maskValues.contains(ILabelPreferenceConstants.DISP_DEFAULT_MULTIPLICITY) || !("1".equals(lower) && "1".equals(upper))) {

					if(lower.equals(upper)) {
						result = String.format(MULTIPLICITY_FORMAT_ALT, lower, upper);
					} else {
						result = String.format(MULTIPLICITY_FORMAT, lower, upper);
					}
				}
			}
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
				return EcorePackage.eINSTANCE.getEAnnotation_Details().equals(feature) || UMLPackage.eINSTANCE.getMultiplicityElement_LowerValue().equals(feature) || UMLPackage.eINSTANCE.getMultiplicityElement_UpperValue().equals(feature);
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

	/**
	 * {@inheritDoc}
	 */
	public boolean areSemanticElementsAffected(EObject listener, Object notification) {
		return true;
	}

	public Map<String, String> getMasks() {
		Map<String, String> masks = new HashMap<String, String>();
		masks.put(ILabelPreferenceConstants.DISP_MULTIPLICITY, "Multiplicity");
		masks.put(ILabelPreferenceConstants.DISP_DEFAULT_MULTIPLICITY, "Show default multiplicity");
		return masks;
	}

	protected Collection<String> getMaskValues(IAdaptable element) {
		View view = (View)element.getAdapter(View.class);
		if(view == null) {
			return getDefaultValue(element);
		}

		Collection<String> result = MaskLabelHelper.getMaskValues(view);
		if(result == null) {
			result = getDefaultValue(element);
		}
		return result;
	}

	public Collection<String> getDefaultValue(IAdaptable element) {
		return Arrays.asList(ILabelPreferenceConstants.DISP_MULTIPLICITY);
	}
}
