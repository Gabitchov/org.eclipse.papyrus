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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.editor;

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
