/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Olivier Mélois (Atos Origin) olivier.melois@atos.net
 *
 *****************************************************************************/

package org.eclipse.papyrus.diagram.common.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.ui.hyperlinkshell.HyperLinkDiagram;
import org.eclipse.papyrus.diagram.common.ui.hyperlinkshell.HyperlinkObject;
import org.eclipse.papyrus.navigation.ExistingNavigableElement;
import org.eclipse.papyrus.navigation.NavigableElement;
import org.eclipse.papyrus.navigation.NavigationHelper;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class EditPartHyperLinkHelper {

	private View view;

	public EditPartHyperLinkHelper(View view) {
		this.view = view;
	}

	/**
	 * Gets the diagrams that contain references to the element.
	 * 
	 * @param element
	 */
	private Iterable<Diagram> getAssociatedDiagramsIterable(ExistingNavigableElement navigableElement) {

		EObject element = navigableElement.getElement();
		final int finalMode = navigableElement.getNavigationMode();

		if(element == null || element.eResource() == null) {
			return Collections.emptyList();
		}

		// google collect predicate used to filter the list of pointing
		// elements.
		Predicate<Setting> filter = new Predicate<Setting>() {

			public boolean apply(Setting setting) {
				boolean keep = false;
				if(finalMode == ExistingNavigableElement.DIRECT_LINKS_MODE) {
					keep = (setting.getEObject() instanceof Diagram);
				} else if(finalMode == ExistingNavigableElement.CONTAINED_LINKS_MODE) {
					keep = (setting.getEObject() instanceof View);
				}
				return keep;
			};
		};

		// google collect function used to get the diagrams from the filtered
		// list of pointing elements.
		Function<Setting, Diagram> getDiagram = new Function<Setting, Diagram>() {

			public Diagram apply(Setting setting) {
				if(finalMode == ExistingNavigableElement.CONTAINED_LINKS_MODE) {
					return ((View)setting.getEObject()).getDiagram();
				} else {
					// (finalMode == ExistingNavigableElement.DIRECT_LINKS_MODE)
					return ((Diagram)setting.getEObject());
				}
			}
		};

		ECrossReferenceAdapter crossReferencer = ECrossReferenceAdapter.getCrossReferenceAdapter(element.eResource().getResourceSet());
		// The element is a type. Therefore, we need all the references to this
		// type.
		List<Setting> settings = new LinkedList<Setting>(crossReferencer.getInverseReferences(element));
		// filtering the eObjects to get only the views, and getting their
		// diagrams.
		Iterable<Setting> sortedSettings = Iterables.filter(settings, filter);
		Iterable<Diagram> diagrams = Iterables.transform(sortedSettings, getDiagram);

		return diagrams;
	}

	/**
	 * Gets the diagrams that contain references to the element, as a list.
	 * 
	 * @param element
	 * @param navigationMode
	 * @return
	 */
	public List<Diagram> getAssociatedDiagrams(ExistingNavigableElement navigableElement) {
		return Lists.newArrayList(getAssociatedDiagramsIterable(navigableElement));
	}

	/**
	 * Gets hyperlinks pointing to diagrams associated to the element, that are
	 * going to be added to list of hyperlinks.
	 * 
	 * @param navigableElement
	 * @param existingHyperlinks
	 */
	public Iterable<HyperlinkObject> getAssociatedDiagramHyperlinksToAdd(Iterable<Diagram> diagrams, Iterable<HyperlinkObject> existingHyperlinks) {

		// google collect function used to get a hyperlink from a diagram.
		Function<Diagram, HyperlinkObject> getHyperlink = new Function<Diagram, HyperlinkObject>() {

			public HyperlinkObject apply(Diagram diagram) {
				HyperlinkObject hyperLinkDiagram = new HyperLinkDiagram();
				((HyperLinkDiagram)hyperLinkDiagram).setDiagram(diagram);
				hyperLinkDiagram.setTooltipText(diagram.getName() + " (found by heuristic)");
				return hyperLinkDiagram;
			};
		};

		final Iterable<HyperlinkObject> finalExistingHyperlinks = existingHyperlinks;
		// Predicate to keep only the diagrams that are not pointed at
		// already in existingHyperlinks.
		Predicate<Diagram> discardAlreadyPointedDiagrams = new Predicate<Diagram>() {

			public boolean apply(Diagram diagram) {
				final Diagram finalDiagram = diagram;
				Predicate<HyperlinkObject> pointsAtDiagram = new Predicate<HyperlinkObject>() {

					public boolean apply(HyperlinkObject hyperlinkObject) {
						return hyperlinkObject.getObject().equals(finalDiagram);
					};
				};
				return !Iterables.any(finalExistingHyperlinks, pointsAtDiagram);
			}
		};

		final Iterable<Diagram> finalDiagrams = diagrams;
		// Predicate used to discard the hyperlinks that are not relevant
		// anymore (for example, if a diagram was deleted).
		Predicate<HyperlinkObject> discardIrrelevantHyperlinks = new Predicate<HyperlinkObject>() {

			public boolean apply(HyperlinkObject hyperlinkObject) {
				return hyperlinkObject.getObject() != null;
				//return Iterables.contains(finalDiagrams, hyperlinkObject.getObject());
			};
		};

		Iterable<Diagram> newlyPointedDiagrams = Iterables.filter(diagrams, discardAlreadyPointedDiagrams);
		Iterable<HyperlinkObject> relevantExistingHyperlinks = Iterables.filter(existingHyperlinks, discardIrrelevantHyperlinks);
		Iterable<HyperlinkObject> newHyperLinkDiagrams = Iterables.transform(newlyPointedDiagrams, getHyperlink);
		//Concatenation of the relevant existing hyperlinks and the newly computed ones.
		Iterable<HyperlinkObject> hyperLinkDiagramsToAdd = Iterables.concat(newHyperLinkDiagrams, relevantExistingHyperlinks);

		return hyperLinkDiagramsToAdd;
	}

	/**
	 * Gets all hyperlinks from the editPart.
	 * 
	 * @param hyperlinkHelperFactory
	 *        a factory of hyperlinkHelpers used to perform the cross-referencing.
	 * 
	 * @return the list of the hyperlinks "belonging" to the editPart.
	 */
	public List<HyperlinkObject> getHyperlinksFromEditPart(HyperlinkHelperFactory hyperlinkHelperFactory) {

		List<HyperlinkObject> existingHyperLinks = new ArrayList<HyperlinkObject>();
		List<HyperlinkObject> result = null;

		try {
			existingHyperLinks = (ArrayList<HyperlinkObject>)hyperlinkHelperFactory.getAllreferenced(view);

			Predicate<HyperlinkObject> keepHyperLinkDiagrams = new Predicate<HyperlinkObject>() {

				public boolean apply(HyperlinkObject hyperlinkObject) {
					return hyperlinkObject instanceof HyperLinkDiagram;
				}
			};
			Predicate<HyperlinkObject> discardHyperLinkDiagrams = Predicates.not(keepHyperLinkDiagrams);

			// Separating hyperlinkDiagrams from others.
			Iterable<HyperlinkObject> existingHyperLinkDiagrams = Iterables.filter(existingHyperLinks, keepHyperLinkDiagrams);
			Iterable<HyperlinkObject> existingOtherHyperLinks = Iterables.filter(existingHyperLinks, discardHyperLinkDiagrams);

			final EObject semanticElement = view.getElement();
			if(semanticElement != null) {
				// Getting the list of navigable elements.
				List<NavigableElement> navElements = NavigationHelper.getInstance().getAllNavigableElements(semanticElement);

				// Fetching the list of diagrams we want to obtain hyperlinks
				// for.
				List<Diagram> currentDiagramsToAdd = new ArrayList<Diagram>();
				for(NavigableElement navElement : navElements) {
					if(navElement instanceof ExistingNavigableElement) {
						Iterable<Diagram> diagramsToAdd = this.getAssociatedDiagrams((ExistingNavigableElement)navElement);
						for(Diagram diagram : diagramsToAdd) {
							if(!Iterables.contains(currentDiagramsToAdd, diagram)) {
								currentDiagramsToAdd.add(diagram);
							}
						}

					}
				}
				// Getting the hyperlinks out of the diagram list.
				Iterable<HyperlinkObject> hyperLinksToAdd = this.getAssociatedDiagramHyperlinksToAdd(currentDiagramsToAdd, existingHyperLinkDiagrams);

				final Diagram currentDiagram = view.getDiagram();
				Predicate<HyperlinkObject> discardCurrentDiagram = new Predicate<HyperlinkObject>() {

					public boolean apply(HyperlinkObject hyperlinkObject) {
						return !hyperlinkObject.getObject().equals(currentDiagram);
					}
				};

				// Removing all the hyperlinks pointing at the current diagram.
				Iterable<HyperlinkObject> finalHyperLinksToAdd = Iterables.filter(hyperLinksToAdd, discardCurrentDiagram);
				// The result is the concatenation of the computed
				// hyperlinkDiagrams and the other existing hyperlinks.
				result = Lists.newArrayList(Iterables.concat(existingOtherHyperLinks, finalHyperLinksToAdd));
			}
		} catch (Exception e) {
			org.eclipse.papyrus.diagram.common.Activator.log.error("Impossible to load hyperlinks", e);
		}

		return result;
	}
}
