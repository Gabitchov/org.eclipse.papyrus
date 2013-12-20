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
package org.eclipse.papyrus.uml.search.ui.actions;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.refactoring.refactoringOnElement.ITransformationOnElement;
import org.eclipse.papyrus.uml.search.ui.query.AbstractPapyrusQuery;
import org.eclipse.papyrus.views.search.regex.PatternHelper;
import org.eclipse.papyrus.views.search.results.AbstractResultEntry;
import org.eclipse.papyrus.views.search.results.AttributeMatch;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;


public class ReplaceTransformationOnElement implements ITransformationOnElement {

	/**
	 * The {@link AbstractResultEntry} list representing textual matches with the String pattern to be replaced.
	 */
	private Set<AbstractResultEntry> fAttributeMatchList;

	/**
	 * The {@link AbstractPapyrusQuery} representing the search of matches.
	 */
	private AbstractPapyrusQuery fQuery;

	/**
	 * The string that should replace the String pattern to be replaced.
	 */
	private String fNewString;


	public ReplaceTransformationOnElement(Set<AbstractResultEntry> toProcess, AbstractPapyrusQuery query, String newString) {
		fAttributeMatchList = toProcess;
		fQuery = query;
		fNewString = newString;
	}


	public void transformationToExecute(EObject element) {
		for(AbstractResultEntry match : fAttributeMatchList) {
			if(match.getSource() instanceof EObject && match instanceof AttributeMatch){
				AttributeMatch attributeMatch=(AttributeMatch) match;
				if(EcoreUtil.equals(element, (EObject)match.getSource())) {

					if(attributeMatch.getMetaAttribute() instanceof EAttribute) {
						Object value = element.eGet((EAttribute)attributeMatch.getMetaAttribute());
						if(value != null) {
							if(value instanceof String) {
								String originalvalue = (String)value;
								Pattern pattern = PatternHelper.getInstance().createPattern(fQuery.getSearchQueryText(), fQuery.isCaseSensitive(), fQuery.isRegularExpression());

								String newValue = computeReplacementString(pattern, originalvalue, fNewString);

								element.eSet((EAttribute)attributeMatch.getMetaAttribute(), newValue);

							}
						}
					}

					else if(attributeMatch.getMetaAttribute() instanceof Property) {
						Property source = (Property)attributeMatch.getMetaAttribute();
						Class containingClass = source.getClass_();
						if(containingClass instanceof Stereotype) {
							if(element instanceof Element) {
								Stereotype stereotype = ((Element)element).getAppliedStereotype(containingClass.getQualifiedName());
								Object tagValue = ((Element)element).getValue(stereotype, source.getName());
								if(tagValue instanceof String) {
									Object value = tagValue;

									if(value != null) {
										if(value instanceof String) {
											String originalvalue = (String)value;
											Pattern pattern = PatternHelper.getInstance().createPattern(fQuery.getSearchQueryText(), fQuery.isCaseSensitive(), fQuery.isRegularExpression());

											String newValue = computeReplacementString(pattern, originalvalue, fNewString);

											((Element)element).setValue(stereotype, source.getName(), newValue);

										}
									}

								}
							}
						}
					}
				}
		}
		}
	}


	/**
	 * Compute the replacement.
	 * @param pattern The pattern that we will us to compute the replacement. 
	 * @param originalText The String to be modified.
	 * @param replacementText The String to append.
	 * @return The new String.
	 */
	private String computeReplacementString(Pattern pattern, String originalText, String replacementText) throws PatternSyntaxException {
		if(pattern != null) {
			try {

				Matcher matcher = pattern.matcher(originalText);
				StringBuffer sb = new StringBuffer();
				matcher.reset();
				if(matcher.find()) {
					matcher.appendReplacement(sb, replacementText);
				} else {
					return null;
				}
				matcher.appendTail(sb);
				return sb.toString();
			} catch (IndexOutOfBoundsException ex) {
				throw new PatternSyntaxException(ex.getLocalizedMessage(), replacementText, -1);
			}
		}
		return replacementText;
	}

}
