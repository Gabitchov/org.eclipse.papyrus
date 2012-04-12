package org.eclipse.papyrus.uml.merger.provider;

import org.eclipse.emf.compare.diff.internal.merge.impl.DiffGroupMerger;
import org.eclipse.papyrus.uml.compare.merger.utils.MergerUtils;


public class CDiffGroupMerger extends DiffGroupMerger {
	@Override
	public void doUndoInTarget() {
		if(MergerUtils.usePapyrusMerger()) {
			throw new UnsupportedOperationException();
		} else {
			super.doUndoInTarget();
		}
	}

	@Override
	public void doApplyInOrigin() {
		if(MergerUtils.usePapyrusMerger()) {
			throw new UnsupportedOperationException();
		} else {
			super.doApplyInOrigin();
		}
	}
}
