package org.eclipse.papyrus.widgets.databinding;

import org.eclipse.core.databinding.observable.value.ValueDiff;


public class UnknownValueDiff extends ValueDiff {

	@Override
	public Object getOldValue() {
		return true;
	}

	@Override
	public Object getNewValue() {
		return false;
	}

}
