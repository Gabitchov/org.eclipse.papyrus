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
package org.eclipse.papyrus.uml.search.ui.query;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.viewersearch.impl.ViewerSearchService;
import org.eclipse.papyrus.uml.search.ui.Activator;
import org.eclipse.papyrus.uml.search.ui.Messages;
import org.eclipse.papyrus.uml.search.ui.results.PapyrusSearchResult;
import org.eclipse.papyrus.uml.search.ui.validator.ParticipantValidator;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.views.search.regex.PatternHelper;
import org.eclipse.papyrus.views.search.results.AbstractResultEntry;
import org.eclipse.papyrus.views.search.results.AttributeMatch;
import org.eclipse.papyrus.views.search.results.ModelMatch;
import org.eclipse.papyrus.views.search.results.ViewerMatch;
import org.eclipse.papyrus.views.search.scope.ScopeEntry;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * 
 * Papyrus specific search query
 * 
 */
public class PapyrusQuery extends AbstractPapyrusQuery {

	public boolean isCaseSensitive() {
		return isCaseSensitive;
	}

	public boolean isRegularExpression() {
		return isRegularExpression;
	}

	private String searchQueryText;

	private boolean isCaseSensitive;

	private boolean isRegularExpression;

	private Collection<ScopeEntry> scopeEntries;

	private Object[] participantsTypes;

	private PapyrusSearchResult results;

	private boolean searchAllStringAttributes;

	protected Set<AbstractResultEntry> fResults = null;



	public PapyrusQuery(String searchQueryText, boolean isCaseSensitive, boolean isRegularExpression, Collection<ScopeEntry> scopeEntries, Object[] participantsTypes, boolean searchAllStringAttributes) {
		this.searchQueryText = searchQueryText;
		this.isCaseSensitive = isCaseSensitive;
		this.isRegularExpression = isRegularExpression;
		this.scopeEntries = scopeEntries;
		this.participantsTypes = participantsTypes;
		this.searchAllStringAttributes = searchAllStringAttributes;

		results = new PapyrusSearchResult(this);
		fResults = new HashSet<AbstractResultEntry>();
	}

	public IStatus run(IProgressMonitor monitor) throws OperationCanceledException {
		results.removeAll();
		fResults.clear();

		for(ScopeEntry scopeEntry : scopeEntries) {
			try {

				if(scopeEntry.getModelSet() != null) {

					UmlModel umlModel = (UmlModel)scopeEntry.getModelSet().getModelChecked(UmlModel.MODEL_ID);

					EObject root = umlModel.lookupRoot();

					Collection<EObject> participants = ParticipantValidator.getInstance().getParticipants(root, participantsTypes);

					evaluate(participants, scopeEntry);
				}
			} catch (NotFoundException e) {
				Activator.log.error(Messages.PapyrusQuery_0 + scopeEntry.getModelSet(), e);
			}
		}
		monitor.done();

		return Status.OK_STATUS;
	}

	/**
	 * Evaluate if the value matches the pattern
	 * 
	 * @param value
	 *        the value to evaluate
	 * @param attribute
	 *        the attribute has the value
	 * @param pattern
	 *        the pattern that is searched
	 * @param participant
	 *        the element that contains the value
	 * @param scopeEntry
	 *        the scopeEntry that contains the participant
	 */
	protected void evaluateAndAddToResult(String value, Object attribute, Pattern pattern, Object participant, ScopeEntry scopeEntry, Stereotype stereotype) {

		value = value != null ? value : ""; //$NON-NLS-1$

		Matcher m = pattern.matcher(value);

		if(isRegularExpression) {
			if(m.matches()) {
				int start = m.start();
				int end = m.end();
				ModelMatch match = new AttributeMatch(start, end, participant, scopeEntry, attribute, stereotype);

				fResults.add(match);
			}
		} else {
			while(m.find()) {
				int start = m.start();
				int end = m.end();
				AttributeMatch match = new AttributeMatch(start, end, participant, scopeEntry, attribute, stereotype);
				fResults.add(match);
			}
		}

		//		if(PatternHelper.getInstance().evaluate(m, isRegularExpression)) {
		//			int start = m.start();
		//			int end = m.end();
		//			ModelMatch match = new AttributeMatch(start, end, participant, scopeEntry, attribute);
		//
		//			fResults.add(match);
		//		}
	}

	/**
	 * Try to find elements that match in the participants
	 * 
	 * @param participants
	 * @param scopeEntry
	 */
	protected void evaluate(Collection<EObject> participants, ScopeEntry scopeEntry) {

		for(EObject participant : participants) {

			String query = searchQueryText;
			if(searchQueryText.equals("")) { //$NON-NLS-1$
				query = ".*"; //$NON-NLS-1$
			}

			Pattern pattern = PatternHelper.getInstance().createPattern(query, isCaseSensitive, isRegularExpression);

			if(pattern != null) {
				if(searchAllStringAttributes) {

					for(EAttribute attribute : participant.eClass().getEAllAttributes()) {
						Object value = participant.eGet(attribute);

						if(value instanceof String) {
							String stringValue = (String)value;
							evaluateAndAddToResult(stringValue, attribute, pattern, participant, scopeEntry, null);
						}
					}

					if(participant instanceof Element) {
						EList<Stereotype> stereotypes = ((Element)participant).getAppliedStereotypes();
						for(Stereotype stereotype : stereotypes) {
							for(Property stereotypeProperty : stereotype.getAllAttributes()) {
								if(!stereotypeProperty.getName().startsWith("base_")) { //$NON-NLS-1$
									Object value = ((Element)participant).getValue(stereotype, stereotypeProperty.getName());

									if(value instanceof String) {
										String stringValue = (String)value;
										evaluateAndAddToResult(stringValue, stereotypeProperty, pattern, participant, scopeEntry, stereotype);
									}
								}
							}
						}
					}

				} else {
					if(participant instanceof NamedElement) {
						String umlElementName = ((NamedElement)participant).getName();
						umlElementName = umlElementName != null ? umlElementName : ""; //$NON-NLS-1$

						evaluateAndAddToResult(umlElementName, UMLPackage.eINSTANCE.getNamedElement_Name(), pattern, participant, scopeEntry, null);
					}
				}


			}
		}

		//		Now, find in diagram and others the elements we found
		ViewerSearchService viewerSearcherService = new ViewerSearchService();
		try {
			viewerSearcherService.startService();

			//Get sources elements that matched
			Set<Object> sources = new HashSet<Object>();
			for(AbstractResultEntry match : fResults) {
				if(match instanceof AttributeMatch) {
					sources.add(((AttributeMatch)match).getSource());
				} else {
					sources.add(match.getSource());
				}
			}

			//Get viewer of these sources
			Map<Object, Map<Object, Object>> viewersMappings = viewerSearcherService.getViewers(sources, scopeEntry.getModelSet());

			//Add viewers to results
			for(Object containingModelSet : viewersMappings.keySet()) {
				for(Object view : viewersMappings.get(containingModelSet).keySet()) {
					Object semanticElement = viewersMappings.get(containingModelSet).get(view);
					ViewerMatch viewMatch = new ViewerMatch(view, scopeEntry, semanticElement);
					fResults.add(viewMatch);
				}
			}

		} catch (ServiceException e) {
			Activator.log.error(Messages.PapyrusQuery_5 + scopeEntry.getModelSet(), e);
		}
	}


	public Set<AbstractResultEntry> getResults() {
		return fResults;
	}

	public String getLabel() {
		return Messages.PapyrusQuery_6;
	}

	public boolean canRerun() {
		return false;
	}

	public boolean canRunInBackground() {
		return true;
	}

	public ISearchResult getSearchResult() {
		for(AbstractResultEntry match : fResults) {
			results.addMatch(match);
		}
		return results;
	}

	/**
	 * Getter for the text query
	 * 
	 * @return the the query text
	 */
	public String getSearchQueryText() {
		return searchQueryText;
	}

}
