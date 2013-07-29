/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Vincent Hemery (Atos Origin) vincent.hemery@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.helper;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;

/**
 * This helper provides interesting features for InteractionFragment objects
 * 
 * @author vhemery
 * 
 */
public class InteractionFragmentHelper {

	/**
	 * Find the fragment happening just before this one.
	 * 
	 * @param interactionFragment
	 *        interaction fragment to search the one before
	 * @param uppestContainerToSearchInto
	 *        the container which we will not search further if encountered
	 *        (may be null)
	 * @return the fragment found happening just before, or null
	 */
	public static InteractionFragment findPreviousFragment(InteractionFragment interactionFragment, EObject uppestContainerToSearchInto) {
		if (interactionFragment == null) {
			return null;
		}

		Element paramElement;
		if(uppestContainerToSearchInto instanceof Element) {
			paramElement = (Element)uppestContainerToSearchInto;
		} else {
			// search in the parent interaction.
			paramElement = interactionFragment;
			while(paramElement.getOwner() != null && !(paramElement instanceof Interaction)) {
				paramElement = paramElement.getOwner();
			}
		}
		return findInteractionFragment(paramElement, true, interactionFragment, false);
	}

	/**
	 * Find the fragment happening just after this one.
	 * 
	 * @param interactionFragment
	 *        interaction fragment to search the one after
	 * @param uppestContainerToSearchInto
	 *        the container which we will not search further if encountered
	 *        (may be null)
	 * @return the fragment found happening just after, or null
	 */
	public static InteractionFragment findNextFragment(InteractionFragment interactionFragment, EObject uppestContainerToSearchInto) {
		if (interactionFragment == null) {
			return null;
		}

		Element paramElement;
		if(uppestContainerToSearchInto instanceof Element) {
			paramElement = (Element)uppestContainerToSearchInto;
		} else {
			// search in the parent interaction.
			paramElement = interactionFragment;
			while(paramElement.getOwner() != null && !(paramElement instanceof Interaction)) {
				paramElement = paramElement.getOwner();
			}
		}
		return findInteractionFragment(paramElement, false, interactionFragment, false);
	}

	/**
	 * Find the next or previous interaction fragment
	 * 
	 * @param uppestContainerToSearchInto
	 *        the container in which we restrain our search
	 * @param reverseOrder
	 *        true if we search the fragment before, false for the one after
	 * @param fragmentToStartFrom
	 *        the reference fragment
	 * @param startFragmentFound
	 *        use false for an external call, true for recursive internal
	 *        call when the fragmentToStartFrom has already been found
	 * @return the found interaction fragment or null if it is not in
	 *         uppestContainerToSearchInto
	 */
	private static InteractionFragment findInteractionFragment(Element uppestContainerToSearchInto, boolean reverseOrder, InteractionFragment fragmentToStartFrom, boolean startFragmentFound) {
		List<? extends Element> listToSearchInto;
		if(uppestContainerToSearchInto instanceof InteractionOperand) {
			listToSearchInto = ((InteractionOperand)uppestContainerToSearchInto).getFragments();
		} else if(uppestContainerToSearchInto instanceof Interaction) {
			listToSearchInto = ((Interaction)uppestContainerToSearchInto).getFragments();
		} else {
			listToSearchInto = uppestContainerToSearchInto.getOwnedElements();
		}
		// search recursively in all the child tree.
		for(int i = 0; i < listToSearchInto.size(); i++) {
			int searchIndex = i;
			if(reverseOrder) {
				searchIndex = listToSearchInto.size() - 1 - i;
			}
			Element searchElement = listToSearchInto.get(searchIndex);

			if(fragmentToStartFrom.equals(searchElement)) {
				startFragmentFound = true;
				if(reverseOrder) {
					// search in the previous child
					continue;
				} else {
					// search deeper for children (which we consider they come
					// after)
				}
			} else if(!startFragmentFound) {
				// go quicker to skip every node until we find the appropriate
				// starting fragment
				if(!EcoreUtil.isAncestor(searchElement, fragmentToStartFrom)) {
					continue;
				} else {
					// search deeper for starting fragment
					// startFragmentFound == false
				}
			} else if(searchElement instanceof InteractionFragment && !reverseOrder) {
				// next fragment found, do not search deeper
				return (InteractionFragment)searchElement;
			}
			// search deeper for a fragment
			InteractionFragment fragment = findInteractionFragment(searchElement, reverseOrder, fragmentToStartFrom, startFragmentFound);
			if(fragment != null) {
				return fragment;
			} else if(reverseOrder && searchElement instanceof InteractionFragment) {
				// we searched ineffectively in the children, stop here and
				// return the element
				return (InteractionFragment)searchElement;
			}
			// else, continue
		}
		return null;
	}
}
