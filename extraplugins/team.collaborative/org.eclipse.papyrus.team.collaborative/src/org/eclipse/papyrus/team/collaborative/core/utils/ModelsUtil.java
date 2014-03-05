/**
 * Copyright (c) 2010-2012 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 * 
 */
package org.eclipse.papyrus.team.collaborative.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;


/**
 * A utility class related to the structure of models.
 * 
 * @author Olivier Constant
 */
public final class ModelsUtil {

	/**
	 * An interface defining filters for model elements
	 */
	public static interface IElementFilter {

		/**
		 * Return whether the given element is accepted by this filter
		 * 
		 * @param element_p
		 *        a non-null element
		 */
		boolean accepts(EObject element_p);
	}


	/**
	 * Constructor
	 */
	private ModelsUtil() {
		// Forbids instantiation
	}

	/**
	 * From a set of elements, return all the elements of their containment trees in
	 * depth-first order
	 * Postcondition: elements_p is not modified.
	 * 
	 * @param elements_p
	 *        a non-null collection
	 * @param filter_p
	 *        an optional filter
	 * @return a non-null, modifiable list
	 */
	private static List<EObject> getAllContentsDF(Collection<? extends EObject> elements_p, IElementFilter filter_p) {
		List<EObject> result = new ArrayList<EObject>();
		for(EObject element : elements_p) {
			result.addAll(getAllContentsDF(element, filter_p));
		}
		return result;
	}

	/**
	 * Return all the elements of the containment tree of the given element in depth-first
	 * order
	 * 
	 * @param element_p
	 *        a non-null element
	 * @param filter_p
	 *        an optional filter
	 * @return a non-null, modifiable list
	 */
	private static List<EObject> getAllContentsDF(EObject element_p, IElementFilter filter_p) {
		List<EObject> result = new ArrayList<EObject>();
		if(filter_p == null || filter_p.accepts(element_p))
			result.add(element_p);
		TreeIterator<EObject> it = element_p.eAllContents();
		while(it.hasNext()) {
			EObject current = it.next();
			if(filter_p == null || filter_p.accepts(current))
				result.add(current);
		}
		return result;
	}

	/**
	 * From a set of elements, build a list of all the elements of their containment trees in
	 * breadth-first order
	 * Postcondition: elements_p is not modified.
	 * We use a LinkedList for queuing behavior.
	 * 
	 * @param elements_p
	 *        a non-null, modifiable, potentially empty queue of the roots
	 * @param result_p
	 *        the non-null modifiable result being built
	 * @param filter_p
	 *        an optional filter
	 */
	private static void getAllContentsBF(LinkedList<EObject> elements_p, List<EObject> result_p, IElementFilter filter_p) {
		if(!elements_p.isEmpty()) {
			EObject current = elements_p.poll();
			if(filter_p == null || filter_p.accepts(current)) {
				result_p.add(current);
				elements_p.addAll(current.eContents());
			}
			getAllContentsBF(elements_p, result_p, filter_p);
		}
	}

	/**
	 * Return all the elements in the containment tree of the given element
	 * 
	 * @param element_p
	 *        a non-null element
	 * @param depthFirst_p
	 *        whether the elements must be returned in breadth-first order or in
	 *        depth-first order
	 * @param filter_p
	 *        an optional filter
	 * @return a non-null, modifiable list
	 */
	public static List<EObject> getAllContents(EObject element_p, boolean depthFirst_p, IElementFilter filter_p) {
		return getAllContents(Collections.singletonList(element_p), depthFirst_p, filter_p);
	}

	/**
	 * From a set of elements, return all the elements in their containment trees
	 * Postcondition: elements_p is not modified.
	 * 
	 * @param elements_p
	 *        a non-null collection
	 * @param depthFirst_p
	 *        whether the elements must be returned in breadth-first order or in
	 *        depth-first order
	 * @param filter_p
	 *        an optional filter
	 * @return a non-null, modifiable list
	 */
	public static List<EObject> getAllContents(Collection<? extends EObject> elements_p, boolean depthFirst_p, IElementFilter filter_p) {
		List<EObject> result;
		if(depthFirst_p) {
			result = getAllContentsDF(elements_p, filter_p);
		} else {
			result = new ArrayList<EObject>();
			getAllContentsBF(new LinkedList<EObject>(elements_p), result, filter_p);
		}
		return result;
	}

	/**
	 * Return the list of ancestors including self, from higher to deeper.
	 * The result is not immutable but modifying it has no impact whatsoever.
	 * 
	 * @param element_p
	 *        a potentially null element
	 * @return a non-null, modifiable ordered set
	 */
	public static List<EObject> getAncestors(EObject element_p) {
		if(element_p == null)
			return new ArrayList<EObject>();
		List<EObject> containerList = getAncestors(element_p.eContainer());
		containerList.add(element_p);
		return containerList;
	}

	/**
	 * Return the lowest common ancestor in the containment hierarchy, if any,
	 * of the given set of elements
	 * 
	 * @param acceptSelf_p
	 *        whether the result can be any of the given elements
	 * @return a potentially null element
	 */
	public static EObject getCommonAncestor(Collection<? extends EObject> elements_p, boolean acceptSelf_p) {
		if(elements_p == null || elements_p.isEmpty())
			return null;
		Iterator<? extends EObject> it = elements_p.iterator();
		List<EObject> commonHierarchy = getAncestors(it.next());
		while(it.hasNext()) {
			List<EObject> currentHierarchy = getAncestors(it.next());
			// Compute intersection of ancestors
			commonHierarchy.retainAll(currentHierarchy);
		}
		// Exclude the given elements
		if(!acceptSelf_p)
			commonHierarchy.removeAll(elements_p);
		// Take lowest ancestor in common hierarchy
		if(commonHierarchy.isEmpty())
			return null;
		return commonHierarchy.get(commonHierarchy.size() - 1);
	}

	/**
	 * Return the lowest common ancestor, in the containment hierarchy,
	 * of the two given elements (inclusive)
	 * 
	 * @param first_p
	 *        a non-null element
	 * @param second_p
	 *        a non-null element
	 * @return a potentially null element
	 */
	public static EObject getCommonAncestor(EObject first_p, EObject second_p) {
		if(null == first_p || null == second_p)
			return null;
		return getCommonAncestor(Arrays.asList(new EObject[]{ first_p, second_p }), true);
	}

	/**
	 * Given a set of elements, find their lowest common meta-class
	 * 
	 * @param elements_p
	 *        a non-null collection of model elements
	 * @return a meta-class which is not null if elements_p is not empty
	 */
	public static EClass getCommonType(Collection<? extends EObject> elements_p) {
		EClass result = null;
		if(!elements_p.isEmpty()) {
			List<EClass> common = new ArrayList<EClass>(getSuperTypes(elements_p.iterator().next().eClass()));
			for(EObject elt : elements_p) {
				common.retainAll(getSuperTypes(elt.eClass()));
			}
			if(!common.isEmpty()) {
				result = common.get(common.size() - 1);
			}
		}
		return result;
	}

	/**
	 * Return the depth in the containment tree of the given element
	 * 
	 * @param element_p
	 *        a potentially null element
	 * @return 0 if null, a strictly positive integer otherwise
	 */
	public static int getDepth(EObject element_p) {
		if(element_p == null)
			return 0;
		return 1 + getDepth(element_p.eContainer());
	}

	/**
	 * Return the overall depth in the containment tree of the given collection of elements,
	 * where overall means maximum if max_p is true, or minimum otherwise
	 * 
	 * @param elements_p
	 *        a non-null, potentially empty collection of elements
	 */
	public static int getDepth(Iterable<? extends EObject> elements_p, boolean max_p) {
		int result = max_p ? 0 : Integer.MAX_VALUE;
		for(EObject element : elements_p) {
			int depth = getDepth(element);
			result = max_p ? Math.max(result, depth) : Math.min(result, depth);
		}
		return result;
	}

	/**
	 * From a set of elements, return all the leaves in their containment trees
	 * 
	 * @param elements_p
	 *        a non-null collection
	 * @return a non-null list
	 */
	public static List<EObject> getLeaves(Collection<? extends EObject> elements_p) {
		List<EObject> result = new ArrayList<EObject>();
		for(EObject element : elements_p) {
			result.addAll(getLeaves(element));
		}
		return result;
	}

	/**
	 * Return all the leaves in the containment tree of the given element
	 * 
	 * @param element_p
	 *        a non-null element
	 * @return a non-null list
	 */
	public static List<EObject> getLeaves(EObject element_p) {
		List<EObject> result;
		if(element_p.eContents().isEmpty()) {
			result = Collections.singletonList(element_p);
		} else {
			result = getLeaves(element_p.eContents());
		}
		return result;
	}

	/**
	 * From a set of elements, filter out those which are transitively contained
	 * in others
	 * 
	 * @param elements_p
	 *        a non-null collection
	 * @return a non-null list
	 */
	public static <T extends EObject> List<T> getRoots(Collection<? extends T> elements_p) {
		List<T> result = new ArrayList<T>();
		Collection<T> elements = new HashSet<T>(elements_p);
		for(T element : elements) {
			if(!result.contains(element) && isRootAmong(element, elements))
				result.add(element);
		}
		return result;
	}

	/**
	 * Return the super types of the given meta-class including the class itself,
	 * ordered from higher to lower in the hierarchy
	 * 
	 * @param class_p
	 *        a non-null meta-class
	 * @return a non-null, non-empty, unmodifiable list
	 */
	private static List<EClass> getSuperTypes(EClass class_p) {
		List<EClass> allButSelf = class_p.getEAllSuperTypes();
		List<EClass> result = new ArrayList<EClass>(allButSelf.size() + 1);
		result.addAll(allButSelf);
		result.add(class_p);
		return Collections.unmodifiableList(result);
	}

	/**
	 * Return whether the given element is not transitively contained by any
	 * of the given elements, unless it is one of the given elements
	 * 
	 * @param element_p
	 *        a non-null element
	 * @param elements_p
	 *        a non-null collection
	 */
	private static boolean isRootAmong(EObject element_p, Collection<? extends EObject> elements_p) {
		Collection<EObject> filtered = new HashSet<EObject>(elements_p);
		filtered.remove(element_p);
		return !EcoreUtil.isAncestor(filtered, element_p);
	}

}
