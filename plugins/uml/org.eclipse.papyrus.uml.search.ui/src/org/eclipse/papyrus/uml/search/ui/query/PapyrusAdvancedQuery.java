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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.resource.NotFoundException;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.services.viewersearch.impl.ViewerSearchService;
import org.eclipse.papyrus.uml.search.ui.Activator;
import org.eclipse.papyrus.uml.search.ui.Messages;
import org.eclipse.papyrus.uml.search.ui.providers.ParticipantTypeAttribute;
import org.eclipse.papyrus.uml.search.ui.providers.ParticipantTypeElement;
import org.eclipse.papyrus.uml.search.ui.results.PapyrusSearchResult;
import org.eclipse.papyrus.uml.search.ui.validator.ParticipantValidator;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.views.search.regex.PatternHelper;
import org.eclipse.papyrus.views.search.results.AbstractResultEntry;
import org.eclipse.papyrus.views.search.results.AttributeMatch;
import org.eclipse.papyrus.views.search.results.ModelElementMatch;
import org.eclipse.papyrus.views.search.results.ModelMatch;
import org.eclipse.papyrus.views.search.results.ViewerMatch;
import org.eclipse.papyrus.views.search.scope.ScopeEntry;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * 
 * Papyrus specific search query
 * 
 */
public class PapyrusAdvancedQuery extends AbstractPapyrusQuery {

	public boolean isCaseSensitive() {
		return isCaseSensitive;
	}

	public boolean isRegularExpression() {
		return isRegularExpression;
	}

	private Set<Object> sources;

	private String searchQueryText;

	private boolean isCaseSensitive;

	private boolean isRegularExpression;

	private Collection<ScopeEntry> scopeEntries;

	private Object[] participantsChecked;

	private PapyrusSearchResult results;

	private HashMap<EObject, List<EAttribute>> participantsList;

	protected Set<AbstractResultEntry> fResults = null;



	private HashMap<Stereotype, ArrayList<Property>> stereotypeList;

	private List<EAttribute> attributesList;

	private List<Property> propertyList;





	public PapyrusAdvancedQuery(String searchQueryText, boolean isCaseSensitive, boolean isRegularExpression, Collection<ScopeEntry> scopeEntries, Object[] participantsChecked) {
		this.propertyList = new ArrayList<Property>();
		this.sources = new HashSet<Object>();
		this.searchQueryText = searchQueryText;
		this.isCaseSensitive = isCaseSensitive;
		this.isRegularExpression = isRegularExpression;
		this.scopeEntries = scopeEntries;
		this.participantsChecked = participantsChecked;
		results = new PapyrusSearchResult(this);

		participantsList = new HashMap<EObject, List<EAttribute>>();
		stereotypeList = new HashMap<Stereotype, ArrayList<Property>>();
		for(Object participant : this.participantsChecked) {
			if(participant instanceof ParticipantTypeElement) {
				if(((ParticipantTypeElement)participant).getElement() instanceof ENamedElement) {
					List<EAttribute> attributesChecked = new ArrayList<EAttribute>();
					for(Object attributesFound : this.participantsChecked) {
						if(attributesFound instanceof ParticipantTypeAttribute) {
							if(((ParticipantTypeAttribute)attributesFound).getParent() == participant)
								attributesChecked.add((EAttribute)((ParticipantTypeAttribute)attributesFound).getElement());
						}
					}
					participantsList.put((EObject)((ParticipantTypeElement)participant).getElement(), attributesChecked);

				} else if(((ParticipantTypeElement)participant).getElement() instanceof Stereotype) {

					ArrayList<Property> attributesChecked = new ArrayList<Property>();
					for(Object attributesFound : this.participantsChecked) {
						if(attributesFound instanceof ParticipantTypeAttribute) {
							if(((ParticipantTypeAttribute)attributesFound).getParent() == participant)
								attributesChecked.add((Property)((ParticipantTypeAttribute)attributesFound).getElement());
						}
					}
					stereotypeList.put((Stereotype)((ParticipantTypeElement)participant).getElement(), attributesChecked);
				}
			}
		}

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

					Collection<EObject> participants = ParticipantValidator.getInstance().getParticipants(root, participantsList.keySet().toArray());


					evaluate(participants, scopeEntry);

					Collection<EObject> stereotypesParticipants = ParticipantValidator.getInstance().getParticipantsStereotype(root, stereotypeList.keySet().toArray());


					evaluateStereotypes(stereotypesParticipants, scopeEntry);
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
	protected void evaluateAndAddToResult(String value, Object attribute, Pattern pattern, Object participant, ScopeEntry scopeEntry) {

		value = value != null ? value : ""; //$NON-NLS-1$

		Matcher m = pattern.matcher(value);

		if(isRegularExpression) {
			if(m.matches()) {
				int start = m.start();
				int end = m.end();
				ModelMatch match = new AttributeMatch(start, end, participant, scopeEntry, attribute);

				fResults.add(match);
			}
		} else {
			while(m.find()) {
				int start = m.start();
				int end = m.end();
				AttributeMatch match = new AttributeMatch(start, end, participant, scopeEntry, attribute);
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

			if(searchQueryText.equals("")) { //$NON-NLS-1$


				fResults.add(new ModelElementMatch(participant, scopeEntry));

			} else {
				String query = searchQueryText;
				if(searchQueryText.equals("")) { //$NON-NLS-1$
					query = ".*"; //$NON-NLS-1$
				}

				Pattern pattern = PatternHelper.getInstance().createPattern(query, isCaseSensitive, isRegularExpression);

				if(pattern != null) {
					if(participantsList.get(participant.eClass()).size() == 0) {
						attributesList = participant.eClass().getEAllAttributes();




					} else {

						attributesList = participantsList.get(participant.eClass());

					}

					for(EAttribute attribute : attributesList) {

						Object value = participant.eGet(attribute);

						if(value instanceof String) {
							String stringValue = (String)value;
							evaluateAndAddToResult(stringValue, attribute, pattern, participant, scopeEntry);
						} else {
							String stringValue = String.valueOf(value);
							evaluateAndAddToResult(stringValue, attribute, pattern, participant, scopeEntry);
						}
					}
				}


			}
		}
		findAndShow(scopeEntry);

	}


	protected void evaluateStereotypes(Collection<EObject> participants, ScopeEntry scopeEntry) {

		for(EObject participant : participants) {

			if(searchQueryText.equals("")) { //$NON-NLS-1$
				fResults.add(new ModelElementMatch(participant, scopeEntry));

			} else {
				String query = searchQueryText;
				if(searchQueryText.equals("")) { //$NON-NLS-1$
					query = ".*"; //$NON-NLS-1$
				}

				Pattern pattern = PatternHelper.getInstance().createPattern(query, isCaseSensitive, isRegularExpression);

				if(pattern != null) {
					EList<Stereotype> stereotypesApplied = ((Element)participant).getAppliedStereotypes();
					for(Stereotype stereotype : stereotypesApplied) {
						for(Stereotype stereotypeSelected : stereotypeList.keySet()) {
							if(stereotype.getName().equals(stereotypeSelected.getName())) {
								if(stereotypeList.get(stereotypeSelected).size() == 0) {

									propertyList = this.getStereotypesAttributes(stereotype);
									for(Property property : propertyList) {

										Object value = ((Element)participant).getValue(stereotype, property.getName());
										if(value != null) {
											if(value instanceof String) {
												String stringValue = (String)value;
												evaluateAndAddToResult(stringValue, property, pattern, participant, scopeEntry);
											} else {
												String stringValue = String.valueOf(value);
												evaluateAndAddToResult(stringValue, property, pattern, participant, scopeEntry);
											}
										}
									}
								} else {
									propertyList = this.getStereotypesAttributes(stereotype);
									for(Property property : propertyList) {
										for(Property property2 : (stereotypeList.get(stereotypeSelected))) {
											if(property.getName().equals(property2.getName())) {
												Object value = ((Element)participant).getValue(stereotype, property.getName());
												if(value != null) {
													if(value instanceof String) {
														String stringValue = (String)value;
														evaluateAndAddToResult(stringValue, property, pattern, participant, scopeEntry);
													} else {
														String stringValue = String.valueOf(value);
														evaluateAndAddToResult(stringValue, property, pattern, participant, scopeEntry);
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
			}


		}
		findAndShow(scopeEntry);

	}

	public List<Property> getStereotypesAttributes(Object parentElement) {
		List<Property> result = new ArrayList<Property>();
		if(parentElement instanceof Stereotype) {

			for(Property property : ((Stereotype)parentElement).getAllAttributes()) {

				if(!property.getName().startsWith("base_")) { //$NON-NLS-1$
					if(property.getType() instanceof Element) {

						if(UMLUtil.isBoolean(property.getType()) || UMLUtil.isString(property.getType()) || UMLUtil.isInteger(property.getType()) || UMLUtil.isReal(property.getType()) || UMLUtil.isUnlimitedNatural(property.getType()) || property.getType() instanceof Enumeration) {
							result.add(property);


						}
					}
				}
			}

		}



		return result;
	}

	protected void findAndShow(ScopeEntry scopeEntry) {
		//Now, find in diagram and others the elements we found
		ViewerSearchService viewerSearcherService = new ViewerSearchService();
		try {
			viewerSearcherService.startService();

			//Get sources elements that matched

			for(AbstractResultEntry match : fResults) {
				if(match instanceof AttributeMatch) {
					sources.add(((AttributeMatch)match).getTarget());
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
