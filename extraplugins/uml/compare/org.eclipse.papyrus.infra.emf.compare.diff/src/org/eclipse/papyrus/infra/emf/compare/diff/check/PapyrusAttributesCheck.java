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
import org.eclipse.emf.compare.diff.engine.check.AttributesCheck;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.match.metamodel.Match2Elements;
import org.eclipse.emf.compare.match.metamodel.Match3Elements;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;


public class PapyrusAttributesCheck extends AttributesCheck {

	/**
	 * a checker used to manage diff configuration
	 */
	private final FeaturesCheck checker;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param matchManager
	 * @param featuresCheck
	 *        the checker used to manage diff configuration
	 */
	public PapyrusAttributesCheck(final IMatchManager matchManager, final FeaturesCheck featuresCheck) {
		super(matchManager);
		this.checker = featuresCheck;
	}

	/**
	 * 
	 * @see org.eclipse.emf.compare.diff.engine.check.AttributesCheck#shouldBeIgnored(org.eclipse.emf.ecore.EAttribute)
	 * 
	 * @param attribute
	 * @return
	 */
	@Override
	protected boolean shouldBeIgnored(final EAttribute attribute) {
		boolean shouldBeIgnored = super.shouldBeIgnored(attribute);
		return shouldBeIgnored || this.checker.shouldBeIgnored(attribute);
	}

	/**
	 * return <code>true</code> if the attribute should be ignored in this context
	 * 
	 * @param attribute
	 *        an attribute
	 * @param context
	 *        the context of this attribute
	 * @return
	 */
	protected boolean shouldBeIgnored(final EAttribute attribute, final EObject context) {
		return this.checker.shouldBeIgnored(attribute, context);
	}

	/**
	 * 
	 * @see org.eclipse.emf.compare.diff.engine.check.AttributesCheck#checkAttributesUpdates(org.eclipse.emf.compare.diff.metamodel.DiffGroup, org.eclipse.emf.compare.match.metamodel.Match2Elements)
	 *
	 * @param root
	 * @param mapping
	 * @throws FactoryException
	 */
	@Override
	public void checkAttributesUpdates(DiffGroup root, Match2Elements mapping) throws FactoryException {
		final EClass eClass = mapping.getLeftElement().eClass();

		final List<EAttribute> eclassAttributes = eClass.getEAllAttributes();
		// for each feature, compare the value
		final Iterator<EAttribute> it = eclassAttributes.iterator();
		while(it.hasNext()) {
			final EAttribute next = it.next();
			if(!shouldBeIgnored(next) && !shouldBeIgnored(next, mapping.getLeftElement())) {
				checkAttributeUpdates(root, mapping, next);
			}
		}
	}

	/**
	 * This will iterate through all the attributes of the <code>mapping</code>'s three elements to check if
	 * any of them has been modified.
	 * 
	 * @param root
	 *        {@link DiffGroup root} of the {@link DiffElement} to create if one of the attribute has
	 *        actually been changed.
	 * @param mapping
	 *        This contains the mapping information about the elements we need to check for a move.
	 * @throws FactoryException
	 *         Thrown if one of the checks fails.
	 */
	public void checkAttributesUpdates(DiffGroup root, Match3Elements mapping) throws FactoryException {
		// Ignores matchElements when they don't have origin (no updates on
		// these)
		if(mapping.getOriginElement() == null)
			return;
		final EClass eClass = mapping.getOriginElement().eClass();

		final List<EAttribute> eclassAttributes = eClass.getEAllAttributes();
		// for each feature, compare the value
		final Iterator<EAttribute> it = eclassAttributes.iterator();
		while(it.hasNext()) {
			final EAttribute next = it.next();
			if(!shouldBeIgnored(next) && !shouldBeIgnored(next, mapping.getOriginElement())) {
				checkAttributeUpdates(root, mapping, next);
			}
		}
	}
}
