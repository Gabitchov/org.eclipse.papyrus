package org.eclipse.papyrus.widgets.databinding;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.widgets.editors.ReferenceDialog;
import org.eclipse.swt.custom.CLabel;


public class ReferenceDialogObservableValue extends CLabelObservableValue {

	private ReferenceDialog referenceDialog;

	public ReferenceDialogObservableValue(ReferenceDialog dialog, CLabel label, IObservableValue modelObservable) {
		this(dialog, label, modelObservable, null);
	}

	public ReferenceDialogObservableValue(ReferenceDialog dialog, CLabel label, IObservableValue modelObservable, ILabelProvider labelProvider) {
		super(label, modelObservable, labelProvider);
		this.referenceDialog = dialog;
	}

	@Override
	protected void doSetValue(Object value) {
		super.doSetValue(value);
		referenceDialog.update();
	}

}
