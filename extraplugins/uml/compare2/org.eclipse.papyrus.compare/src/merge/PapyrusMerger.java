package merge;

import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceSource;
import org.eclipse.emf.compare.DifferenceState;
import org.eclipse.emf.compare.merge.AbstractMerger;

import extensions.PapyrusDiff;


public class PapyrusMerger extends AbstractMerger {
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.merge.IMerger#isMergerFor(org.eclipse.emf.compare.Diff)
	 */
	public boolean isMergerFor(Diff target) {
		return target instanceof PapyrusDiff;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.merge.IMerger#copyLeftToRight(org.eclipse.emf.compare.Diff,
	 *      org.eclipse.emf.common.util.Monitor)
	 */
	public void copyLeftToRight(Diff target, Monitor monitor) {
		// Don't merge an already merged (or discarded) diff
		if (target.getState() != DifferenceState.UNRESOLVED) {
			return;
		}
		final PapyrusDiff diff = (PapyrusDiff)target;

		setEquivalentDiffAsMerged(diff);

		// Change the diff's state before we actually merge it : this allows us to avoid requirement cycles.
		diff.setState(DifferenceState.MERGED);
		// for (Diff refining : diff.getRefinedBy()) {
		// mergeDiff(refining, false, monitor);
		// }

		if (diff.getSource() == DifferenceSource.LEFT) {
			// merge all "requires" diffs
			mergeRequires(diff, false, monitor);
		} else {
			// merge all "required by" diffs
			mergeRequiredBy(diff, false, monitor);
		}

		for (Diff refining : diff.getRefinedBy()) {
			mergeDiff(refining, false, monitor);
		}
	}

	public void copyRightToLeft(Diff target, Monitor monitor) {
		// Don't merge an already merged (or discarded) diff
		if (target.getState() != DifferenceState.UNRESOLVED) {
			return;
		}
		final PapyrusDiff diff = (PapyrusDiff)target;

		setEquivalentDiffAsMerged(diff);

		// Change the diff's state before we actually merge it : this allows us to avoid requirement cycles.
		diff.setState(DifferenceState.MERGED);
		// for (Diff refining : diff.getRefinedBy()) {
		// mergeDiff(refining, true, monitor);
		// }

		if (diff.getSource() == DifferenceSource.LEFT) {
			// merge all "required by" diffs
			mergeRequiredBy(diff, true, monitor);
		} else {
			mergeRequires(diff, true, monitor);
		}

		for (Diff refining : diff.getRefinedBy()) {
			mergeDiff(refining, true, monitor);
		}
	}

	/**
	 * Iterates over the differences equivalent to {@code diff} and sets them as
	 * {@link DifferenceState#MERGED}.
	 * 
	 * @param diff
	 *            Diff which equivalences are to be considered merged.
	 */
	private void setEquivalentDiffAsMerged(PapyrusDiff diff) {
		if (diff.getEquivalence() != null) {
			for (Diff equivalent : diff.getEquivalence().getDifferences()) {
				equivalent.setState(DifferenceState.MERGED);
			}
		}
	}
}
