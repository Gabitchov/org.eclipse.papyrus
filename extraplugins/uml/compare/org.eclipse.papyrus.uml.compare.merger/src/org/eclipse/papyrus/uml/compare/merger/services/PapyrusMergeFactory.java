package org.eclipse.papyrus.uml.compare.merger.services;

import org.eclipse.emf.compare.diff.merge.IMerger;
import org.eclipse.emf.compare.diff.merge.service.MergeFactory;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.papyrus.uml.compare.merger.internal.merger.DiffGroupTransactionalMerger;


/**
 * 
 * This class replaces the default MergeFactory
 * TODO post a bug to EMF-Compare for the creation of a DiffGroupMerger
 */
public class PapyrusMergeFactory {

	/**
	 * Handles the creation of the merger for a given {@link DiffElement}.
	 * 
	 * @param element
	 *        {@link DiffElement} for which we need a merger.
	 * @return The merger adapted to <code>element</code>, <code>null</code> if it cannot be instantiated.
	 */
	public static IMerger createMerger(DiffElement element) {
		// If the merger provides a default constructor, we instantiate it
		IMerger elementMerger = null;

		if(element instanceof DiffGroup) {
			elementMerger = new DiffGroupTransactionalMerger();
			elementMerger.setDiffElement(element);
			return elementMerger;
		}

		return MergeFactory.createMerger(element);
	}


}
