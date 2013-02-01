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
package org.eclipse.papyrus.uml.compare.subelement.editor.input.copy;

import java.util.List;

import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSetSnapshot;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSnapshot;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.DiffResourceSet;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.metamodel.MatchResourceSet;
import org.eclipse.emf.compare.ui.ICompareInputDetailsProvider;
import org.eclipse.emf.compare.ui.ModelCompareInput;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.compare.diff.service.TransactionalMergeService;

/**
 * 
 * This input allows to use the Papyrus TransactionalMergeService
 * 
 */
public class ModelCompareInputWithTwoEditingDomain extends ModelCompareInput {

	/**
	 * The editing domain used to do the merge differences to the left side
	 */
	final private TransactionalEditingDomain leftEditingDomain;

	/**
	 * The editing domain used to do the merge differences to the right side
	 */

	final private TransactionalEditingDomain rightEditingDomain;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param leftEditingDomain
	 * @param rightEditingDomain
	 * @param matchResourceSet
	 * @param diffResourceSet
	 */
	public ModelCompareInputWithTwoEditingDomain(final TransactionalEditingDomain leftEditingDomain, TransactionalEditingDomain rightEditingDomain, MatchResourceSet matchResourceSet, DiffResourceSet diffResourceSet) {
		super(matchResourceSet, diffResourceSet);
		this.leftEditingDomain = leftEditingDomain;
		this.rightEditingDomain = rightEditingDomain;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param leftEditingDomain
	 * @param rightEditingDomain
	 * @param snapshot
	 */
	public ModelCompareInputWithTwoEditingDomain(final TransactionalEditingDomain leftEditingDomain, TransactionalEditingDomain rightEditingDomain, ComparisonResourceSetSnapshot snapshot) {
		super(snapshot);
		this.leftEditingDomain = leftEditingDomain;
		this.rightEditingDomain = rightEditingDomain;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param leftEditingDomain
	 * @param rightEditingDomain
	 * @param snapshot
	 */
	public ModelCompareInputWithTwoEditingDomain(final TransactionalEditingDomain leftEditingDomain, TransactionalEditingDomain rightEditingDomain, ComparisonResourceSnapshot snapshot) {
		super(snapshot);
		this.leftEditingDomain = leftEditingDomain;
		this.rightEditingDomain = rightEditingDomain;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param leftEditingDomain
	 * @param rightEditingDomain
	 * @param matchModel
	 * @param diffModel
	 * @param provider
	 */
	public ModelCompareInputWithTwoEditingDomain(final TransactionalEditingDomain leftEditingDomain, TransactionalEditingDomain rightEditingDomain, MatchModel matchModel, DiffModel diffModel, ICompareInputDetailsProvider provider) {
		super(matchModel, diffModel, provider);
		this.leftEditingDomain = leftEditingDomain;
		this.rightEditingDomain = rightEditingDomain;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param leftEditingDomain
	 * @param rightEditingDomain
	 * @param matchResourceset
	 * @param diffResourceSet
	 * @param provider
	 */
	public ModelCompareInputWithTwoEditingDomain(final TransactionalEditingDomain leftEditingDomain, TransactionalEditingDomain rightEditingDomain, MatchResourceSet matchResourceset, DiffResourceSet diffResourceSet, ICompareInputDetailsProvider provider) {
		super(matchResourceset, diffResourceSet, provider);
		this.leftEditingDomain = leftEditingDomain;
		this.rightEditingDomain = rightEditingDomain;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param leftEditingDomain
	 * @param rightEditingDomain
	 * @param match
	 * @param diff
	 */
	public ModelCompareInputWithTwoEditingDomain(final TransactionalEditingDomain leftEditingDomain, TransactionalEditingDomain rightEditingDomain, MatchModel match, DiffModel diff) {
		super(match, diff);
		this.leftEditingDomain = leftEditingDomain;
		this.rightEditingDomain = rightEditingDomain;
	}

	/**
	 * Applies the changes implied by a given {@link DiffElement} in the
	 * direction specified by <code>leftToRight</code>.
	 * 
	 * @param element
	 *        {@link DiffElement} containing the copy information.
	 * @param leftToRight
	 *        <code>True</code> if the changes must be applied from the left
	 *        to the right model, <code>False</code> otherwise.
	 */
	protected void doCopy(DiffElement element, boolean leftToRight) {
		if(leftToRight) {
			TransactionalMergeService.merge(rightEditingDomain, element, leftToRight);
		} else {
			TransactionalMergeService.merge(leftEditingDomain, element, leftToRight);
		}
	}

	/**
	 * Applies the changes implied by a list of {@link DiffElement} in the
	 * direction specified by <code>leftToRight</code>.
	 * 
	 * @param elements
	 *        {@link DiffElement}s containing the copy information.
	 * @param leftToRight
	 *        <code>True</code> if the changes must be applied from the left
	 *        to the right model, <code>False</code> otherwise.
	 */
	protected void doCopy(List<DiffElement> elements, boolean leftToRight) {
		if(leftToRight) {
			TransactionalMergeService.merge(rightEditingDomain, elements, leftToRight);
		} else {
			TransactionalMergeService.merge(leftEditingDomain, elements, leftToRight);
		}
	}
}
