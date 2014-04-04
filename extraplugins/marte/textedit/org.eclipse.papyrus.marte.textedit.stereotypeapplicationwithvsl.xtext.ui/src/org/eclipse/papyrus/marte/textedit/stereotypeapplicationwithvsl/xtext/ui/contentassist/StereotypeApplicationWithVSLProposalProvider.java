/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.ui.contentassist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.stereotypeApplicationWithVSL.StereotypeApplicationRule;
import org.eclipse.papyrus.marte.textedit.stereotypeapplicationwithvsl.xtext.stereotypeApplicationWithVSL.TagSpecificationRule;
import org.eclipse.papyrus.marte.vsl.ui.contentassist.VSLProposalUtils;
import org.eclipse.papyrus.uml.xtext.integration.CompletionProposalUtils;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
public class StereotypeApplicationWithVSLProposalProvider extends AbstractStereotypeApplicationWithVSLProposalProvider {

	@Override
	public void completeTagSpecificationRule_Property(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		List<NamedElement> visibleProperties = getVisibleProperties(model);
		visibleProperties = this.sortByKindAndName(visibleProperties);
		for(EObject o : visibleProperties) {
			NamedElement namedElement = (NamedElement)o;
			if(namedElement.getName().toLowerCase().contains(context.getPrefix().toLowerCase())) {
				String completionString = context.getPrefix() + namedElement.getName().substring(context.getPrefix().length()) + " = ";
				String displayString = namedElement.getName();
				if(namedElement instanceof TypedElement) {
					TypedElement typedElement = (TypedElement)namedElement;
					displayString += typedElement.getType() != null ? " : " + typedElement.getType().getName() : "";
				}
				ICompletionProposal completionProposal = CompletionProposalUtils.createCompletionProposalWithReplacementOfPrefix(namedElement, completionString, displayString, context);
				acceptor.accept(completionProposal);
			}
		}
	}

	private List<NamedElement> getVisibleProperties(EObject rule) {
		List<NamedElement> visibleProperties = new ArrayList<NamedElement>();
		// first retrieves the context stereotype
		EObject context = rule;
		while(context != null && !(context instanceof StereotypeApplicationRule)) {
			context = context.eContainer();
		}
		if(context != null) {
			// retrieves the stereotype which is applied
			StereotypeApplicationRule stAppRule = (StereotypeApplicationRule)context;
			if(stAppRule.getStereotype() != null) {
				// add all the available properties for this stereotype
				visibleProperties.addAll(stAppRule.getStereotype().getAllAttributes());
				// removes derived properties or those which name starts with "base_"
				List<Property> filteredList = new ArrayList<Property>(stAppRule.getStereotype().getAllAttributes());
				for(Property p : filteredList) {
					if(p.getName() == null || p.getName().startsWith("base_") || p.isDerived()) {
						visibleProperties.remove(p);
					}
				}
				// removes the ones which have already been used
				if(stAppRule.getTagSpecification() != null) {
					for(TagSpecificationRule tag : stAppRule.getTagSpecification()) {
						if(tag.getProperty() != null && visibleProperties.contains(tag.getProperty())) {
							visibleProperties.remove(tag.getProperty());
						}
					}
				}
			}
		}
		return visibleProperties;
	}

	@Override
	public void completeExpressionValueRule_Expression(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if(model.eContainer() == null || !(model.eContainer() instanceof TagSpecificationRule)) {
			return;
		}
		TagSpecificationRule tagSpecificationRule = (TagSpecificationRule)model.eContainer();

		if(tagSpecificationRule.getProperty() == null || tagSpecificationRule.getProperty().getType() == null) {
			return;
		}

		Property p = tagSpecificationRule.getProperty();

		Map<String, Element> allProposals = VSLProposalUtils.buildProposalForType((Classifier)p.getType(), p);

		// List<String> allProposals = ProposalUtils.buildProposalForType((Classifier)p.getType()) ;
		for(String s : allProposals.keySet()) {
			String completionString = s.substring(context.getPrefix().length());
			String displayString = s;
			ICompletionProposal completionProposal = null;
			if(allProposals.get(s) == null) {
				completionString = s.substring(context.getPrefix().length());
				displayString = s;
				completionProposal = CompletionProposalUtils.createCompletionProposal(completionString, displayString, context);
				acceptor.accept(completionProposal);
			} else {
				if(!s.contains("|")) {
					displayString = s;
					completionString = s;
				} else {
					completionString = s.substring(0, s.indexOf("|"));
					displayString = s.substring(s.indexOf("|") + 1);
				}
				if(displayString.contains(context.getPrefix())) {
					completionProposal = CompletionProposalUtils.createCompletionProposalWithReplacementOfPrefix((NamedElement)allProposals.get(s), completionString, displayString, context);
					acceptor.accept(completionProposal);
				}
			}
		}
		//super.completeExpressionValueRule_Expression(model, assignment, context,
		//		acceptor);
	}

	/* *************************************************
	 * 
	 * Private utility method for sorting a list of NamedElement by kind and name
	 * 
	 * ************************************************
	 */

	protected List<NamedElement> sortByKindAndName(List<NamedElement> list) {
		List<NamedElement> sortedList = new ArrayList<NamedElement>();
		HashMap<EClass, List<NamedElement>> namedElementGroups = new HashMap<EClass, List<NamedElement>>();

		for(NamedElement n : list) {
			if(!namedElementGroups.containsKey(n.eClass())) {
				List<NamedElement> group = new ArrayList<NamedElement>();
				group.add(n);
				namedElementGroups.put(n.eClass(), group);
			} else {
				List<NamedElement> group = namedElementGroups.get(n.eClass());
				boolean inserted = false;
				for(int i = 0; inserted == false && i < group.size(); i++) {
					if(group.get(i).getName().compareTo(n.getName()) > 0) {
						group.add(i, n);
						inserted = true;
					}
				}
				if(!inserted) {
					group.add(n);
				}
				namedElementGroups.put(n.eClass(), group);
			}
		}

		for(EClass c : namedElementGroups.keySet()) {
			List<NamedElement> group = namedElementGroups.get(c);
			sortedList.addAll(group);
		}

		return sortedList;
	}
}
