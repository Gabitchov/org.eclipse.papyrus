package org.eclipse.papyrus.infra.nattable.common.provider;

import java.util.List;

import org.eclipse.jface.viewers.IElementComparer;
import org.eclipse.jface.viewers.StructuredSelection;


public class CrossSelection extends StructuredSelection {

	public CrossSelection() {
		// TODO Auto-generated constructor stub
	}

	public CrossSelection(Object[] elements) {
		super(elements);
		// TODO Auto-generated constructor stub
	}

	public CrossSelection(Object element) {
		super(element);
		// TODO Auto-generated constructor stub
	}

	public CrossSelection(List elements) {
		super(elements);
		// TODO Auto-generated constructor stub
	}

	public CrossSelection(List elements, IElementComparer comparer) {
		super(elements, comparer);
		// TODO Auto-generated constructor stub
	}

}
