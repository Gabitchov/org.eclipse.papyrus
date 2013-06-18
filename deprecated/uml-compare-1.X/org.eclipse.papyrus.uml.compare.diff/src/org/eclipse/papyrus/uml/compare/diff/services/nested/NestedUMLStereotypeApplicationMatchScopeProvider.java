/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.uml.compare.diff.services.nested;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.compare.match.engine.GenericMatchScope;
import org.eclipse.emf.compare.match.engine.IMatchScope;
import org.eclipse.emf.compare.match.engine.IMatchScopeProvider;
import org.eclipse.emf.compare.match.filter.IResourceFilter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Element;

/**
 * 
 * Created to resolve the bug 384490: [UML Compare] Comparison between stereotyped elements doesn't work in the nested Compare Editor
 * 
 */
public class NestedUMLStereotypeApplicationMatchScopeProvider implements IMatchScopeProvider {

	/**
	 * The match scope used for the left side of comparison.
	 * 
	 * @since 1.3
	 */
	final protected IMatchScope leftScope;

	/**
	 * The match scope used for the right side of comparison.
	 * 
	 * @since 1.3
	 */
	final protected IMatchScope rightScope;

	/**
	 * The match scope used for the ancestor side of comparison.
	 * 
	 * @since 1.3
	 */
	protected IMatchScope ancestorScope;

	/**
	 * Constructs a left and right {@link GenericMatchScope} with the given {@link EObject}s. No ancestor
	 * scope will be created, so calls to {@link #getAncestorScope()} will return <code>null</code>.
	 * 
	 * @param leftObject
	 *        the {@link EObject}, which will be used to construct the left scope
	 * @param rightObject
	 *        the {@link EObject}, which will be used to construct the right scope
	 */
	public NestedUMLStereotypeApplicationMatchScopeProvider(EObject leftObject, EObject rightObject) {
		final List<EObject> leftSte = new ArrayList<EObject>();
		final List<EObject> rightSte = new ArrayList<EObject>();
		if(leftObject instanceof Element) {
			leftSte.addAll(((Element)leftObject).getStereotypeApplications());
			if(((Element)leftObject).getNearestPackage() != null) {
				leftSte.addAll(((Element)leftObject).getNearestPackage().getAllProfileApplications());
			}
		}
		if(rightObject instanceof Element) {
			rightSte.addAll(((Element)rightObject).getStereotypeApplications());
			if(((Element)rightObject).getNearestPackage() != null) {
				rightSte.addAll(((Element)rightObject).getNearestPackage().getAllProfileApplications());
			}
		}
		if(leftObject.eResource() != null) {
			this.leftScope = new NestedUMLStereotypeApplicationMatchScope(leftObject.eResource(), leftSte);
		} else {
			this.leftScope = new NestedUMLStereotypeApplicationMatchScope(leftObject, leftSte);
		}
		
		if(rightObject.eResource() != null) {
			this.rightScope = new NestedUMLStereotypeApplicationMatchScope(rightObject.eResource(), rightSte);
		} else {
			this.rightScope = new NestedUMLStereotypeApplicationMatchScope(rightObject, rightSte);
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.match.engine.IMatchScopeProvider#getAncestorScope()
	 */
	public IMatchScope getAncestorScope() {
		return ancestorScope;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.match.engine.IMatchScopeProvider#getLeftScope()
	 */
	public IMatchScope getLeftScope() {
		return leftScope;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.match.engine.IMatchScopeProvider#getRightScope()
	 */
	public IMatchScope getRightScope() {
		return rightScope;
	}

	/**
	 * Allows to apply an {@link IResourceFilter} to the contained scopes, to reduce them respectively. This
	 * will only have an effect, if this scope provider was instantiated using either a {@link Resource} or a {@link ResourceSet}, but not in case an
	 * {@link EObject} was used.
	 * 
	 * @param filter
	 *        the filter to apply to the resources of the left, right and (if provided) ancestor scope.
	 */
	@SuppressWarnings("unchecked")
	public void applyResourceFilter(IResourceFilter filter) {
		if(ancestorScope != null) {
			applyExternalFilter(filter, ((GenericMatchScope)leftScope).getResourcesInScope(), ((GenericMatchScope)rightScope).getResourcesInScope(), ((GenericMatchScope)ancestorScope).getResourcesInScope());
		} else {
			applyExternalFilter(filter, ((GenericMatchScope)leftScope).getResourcesInScope(), ((GenericMatchScope)rightScope).getResourcesInScope());
		}
	}

	/**
	 * Applies the given filter to the list of resources.
	 * 
	 * @param filter
	 *        the filter to apply.
	 * @param resources
	 *        the list of resources to be filtered (in place).
	 */
	private static void applyExternalFilter(IResourceFilter filter, List<Resource>... resources) {
		if(resources.length == 2) {
			filter.filter(resources[0], resources[1]);
		} else {
			filter.filter(resources[0], resources[1], resources[2]);
		}
	}

}
