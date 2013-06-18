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
package org.eclipse.papyrus.infra.emf.compare.diff.check;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.diff.engine.IMatchManager;
import org.eclipse.emf.compare.diff.engine.check.ReferencesCheck;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.match.metamodel.Match2Elements;
import org.eclipse.emf.compare.match.metamodel.Match3Elements;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * 
 * This reference checker allows to ignore differences on features for the comparison
 * 
 */
public class PapyrusReferencesCheck extends ReferencesCheck {

	/**
	 * the checker used to take in account the ignored features for the Diff
	 */
	private final FeaturesCheck checker;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param matchManager
	 * @param checker
	 *        the checker used to take in account the ignored features for the Diff
	 */
	public PapyrusReferencesCheck(final IMatchManager matchManager, final FeaturesCheck checker) {
		super(matchManager);
		this.checker = checker;
	}

	/**
	 * 
	 * @see org.eclipse.emf.compare.diff.engine.check.ReferencesCheck#shouldBeIgnored(org.eclipse.emf.ecore.EReference)
	 * 
	 * @param reference
	 * @return
	 */
	@Override
	protected boolean shouldBeIgnored(final EReference reference) {
		boolean shouldBeIgnored = super.shouldBeIgnored(reference);
		return shouldBeIgnored || this.checker.shouldBeIgnored(reference);
	}

	/**
	 * return <code>true</code> if the attribute should be ignored in this context
	 * 
	 * @param reference
	 *        a reference
	 * @param context
	 *        the context of this reference
	 * @return
	 */
	protected boolean shouldBeIgnored(final EReference reference, final EObject context) {
		return this.checker.shouldBeIgnored(reference, context);
	}

	/**
	 * Checks if there's been references updates in the model.<br/>
	 * <p>
	 * A reference is considered updated if its value(s) has been changed (either removal or addition of an element if the reference is multi-valued
	 * or update of a single-valued reference) between the left and the right model.
	 * </p>
	 * 
	 * @param root
	 *        {@link DiffGroup root} of the {@link DiffElement} to create.
	 * @param mapping
	 *        Contains informations about the left and right model elements we have to compare.
	 * @throws FactoryException
	 *         Thrown if we cannot fetch the references' values.
	 */
	public void checkReferencesUpdates(DiffGroup root, Match2Elements mapping) throws FactoryException {
		final EClass eClass = mapping.getLeftElement().eClass();
		final List<EReference> eclassReferences = eClass.getEAllReferences();

		final Iterator<EReference> it = eclassReferences.iterator();
		while(it.hasNext()) {
			final EReference next = it.next();
			if(!shouldBeIgnored(next, mapping.getLeftElement())) {
				if(!shouldBeIgnored(next)) {
					checkReferenceUpdates(root, mapping, next);
				} else if(next.isContainment() && next.isOrdered()) {
					checkContainmentReferenceOrderChange(root, mapping, next);
				}
			}
		}
	}

	/**
	 * Checks if there's been references updates in the model.<br/>
	 * <p>
	 * A reference is considered updated if its value(s) has been changed (either removal or addition of an element if the reference is multi-valued
	 * or update of a single-valued reference) between the left and the ancestor model, the right and the ancestor or between the left and the right
	 * model.
	 * </p>
	 * 
	 * @param root
	 *        {@link DiffGroup root} of the {@link DiffElement} to create.
	 * @param mapping
	 *        Contains informations about the left, right and origin model elements we have to compare.
	 * @throws FactoryException
	 *         Thrown if we cannot fetch the references' values.
	 */
	public void checkReferencesUpdates(DiffGroup root, Match3Elements mapping) throws FactoryException {
		// Ignores matchElements when they don't have origin (no updates on these)
		if(mapping.getOriginElement() == null)
			return;
		final EClass eClass = mapping.getOriginElement().eClass();
		final List<EReference> eclassReferences = eClass.getEAllReferences();

		final Iterator<EReference> it = eclassReferences.iterator();
		while(it.hasNext()) {
			final EReference next = it.next();
			if(!shouldBeIgnored(next, mapping.getLeftElement())) {
				if(!shouldBeIgnored(next)) {
					checkReferenceUpdates(root, mapping, next);
				} else if(next.isContainment() && next.isOrdered()) {
					checkContainmentReferenceOrderChange(root, mapping, next);
				}
			}
		}
	}


}
