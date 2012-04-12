package org.eclipse.papyrus.uml.merger.provider;

import org.eclipse.emf.compare.diff.internal.merge.impl.AttributeChangeLeftTargetMerger;
import org.eclipse.papyrus.uml.compare.merger.utils.MergerUtils;


public class CAttributeChangeLeftTargetMerger extends AttributeChangeLeftTargetMerger {

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
