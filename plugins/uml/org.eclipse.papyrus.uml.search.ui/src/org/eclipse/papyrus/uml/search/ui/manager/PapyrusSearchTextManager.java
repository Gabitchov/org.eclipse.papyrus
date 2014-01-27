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
package org.eclipse.papyrus.uml.search.ui.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.uml.search.ui.Messages;
import org.eclipse.papyrus.uml.search.ui.providers.ParticipantTypeAttribute;
import org.eclipse.papyrus.uml.search.ui.providers.ParticipantTypeElement;
import org.eclipse.papyrus.uml.search.ui.query.PapyrusAdvancedQuery;
import org.eclipse.papyrus.uml.search.ui.query.PapyrusQuery;
import org.eclipse.papyrus.views.search.scope.ScopeEntry;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.swt.widgets.Display;

/**
 *Manage the search depending on user choices.
 *
 */
public class PapyrusSearchTextManager {

	private Collection<ScopeEntry> fScopeEntries;

	private boolean fIsCaseSensitive;

	private boolean fIsRegularExpression;

	private String fQueryText;

	public PapyrusSearchTextManager(Collection<ScopeEntry> scopeEntries, boolean isCaseSensitive, boolean isRegularExpression, String queryText) {
		fScopeEntries = scopeEntries;
		fIsCaseSensitive = isCaseSensitive;
		fIsRegularExpression = isRegularExpression;
		fQueryText = queryText;
	}

	public ISearchQuery manageSimpleSearch(boolean searchAllStrings, Object[] umlMetaClassesArray) {
		if(fQueryText.isEmpty()) {
			MessageDialog.openError(Display.getCurrent().getActiveShell(), Messages.PapyrusSearchPage_29, Messages.PapyrusSearchPage_30);
			return null;
		} else {
			PapyrusQuery query = new PapyrusQuery(fQueryText, fIsCaseSensitive, fIsRegularExpression, fScopeEntries, umlMetaClassesArray, searchAllStrings);
			return query;
		}

	}

	public ISearchQuery manageAdvancedSearch(HashMap<ParticipantTypeElement, List<ParticipantTypeAttribute>> participantsList, Object[] checkedElements, boolean searchForAllSter) {
		List<ParticipantTypeElement> participantsToEvaluate = getParticipantsToEvaluate(participantsList);


		if(participantsToEvaluate.size() == 0) {

			MessageDialog.openError(Display.getCurrent().getActiveShell(), Messages.PapyrusSearchPage_31, Messages.PapyrusSearchPage_32);
			return null;
		} else {
			if(fQueryText.isEmpty()) {
				for(Object participantChecked : checkedElements) {
					if(participantChecked instanceof ParticipantTypeAttribute) {
						MessageDialog.openError(Display.getCurrent().getActiveShell(), Messages.PapyrusSearchPage_33, Messages.PapyrusSearchPage_34);
						return null;
					}
				}
			}

			PapyrusAdvancedQuery query = new PapyrusAdvancedQuery(fQueryText, fIsCaseSensitive, fIsRegularExpression, fScopeEntries, participantsToEvaluate.toArray(), searchForAllSter);
			return query;
		}
	}

	private List<ParticipantTypeElement> getParticipantsToEvaluate(HashMap<ParticipantTypeElement, List<ParticipantTypeAttribute>> participantsList) {
		List<ParticipantTypeElement> participantsToEvaluate = new ArrayList<ParticipantTypeElement>();

		for(ParticipantTypeElement element : participantsList.keySet()) {
			if(element.isChecked()) {
				participantsToEvaluate.add(element);
				for(ParticipantTypeAttribute attributesToEvaluate : participantsList.get(element)) {
					if(attributesToEvaluate.isChecked()) {
						participantsToEvaluate.add(attributesToEvaluate);
					}
				}
			}
		}
		return participantsToEvaluate;
	}
}
