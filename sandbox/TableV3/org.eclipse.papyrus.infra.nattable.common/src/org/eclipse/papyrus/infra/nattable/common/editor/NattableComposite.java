package org.eclipse.papyrus.infra.nattable.common.editor;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.swt.widgets.Composite;


public class NattableComposite extends Composite implements ISelectionProvider {//should extends composite or not?

	public NattableComposite(final Composite parent, final int style) {
		super(parent, style);
	}



	private NatTable nattable;



	//	public NattableComposite(final Composite parent) {
	//		// TODO Auto-generated constructor stub
	//	}




	public void addSelectionChangedListener(final ISelectionChangedListener listener) {
		// TODO Auto-generated method stub

	}

	public ISelection getSelection() {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeSelectionChangedListener(final ISelectionChangedListener listener) {
		// TODO Auto-generated method stub

	}

	public void setSelection(final ISelection selection) {
		// TODO Auto-generated method stub

	}

}
