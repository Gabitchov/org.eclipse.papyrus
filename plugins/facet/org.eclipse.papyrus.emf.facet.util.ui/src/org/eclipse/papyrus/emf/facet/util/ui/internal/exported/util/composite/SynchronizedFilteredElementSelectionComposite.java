/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.emf.facet.util.ui.internal.exported.util.composite;

import org.eclipse.emf.facet.util.ui.internal.exported.composite.IFilteredElementSelectionComposite;
import org.eclipse.emf.facet.util.ui.internal.exported.displaysync.AbstractExceptionFreeRunnable;
import org.eclipse.emf.facet.util.ui.internal.exported.displaysync.AbstractVoidExceptionFreeRunnable;
import org.eclipse.emf.facet.util.ui.internal.exported.displaysync.SynchronizedObject;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.FilteredList;

/**
 * @since 0.3
 */
public class SynchronizedFilteredElementSelectionComposite<T extends IFilteredElementSelectionComposite>
		extends SynchronizedObject<T> implements
		IFilteredElementSelectionComposite {

	/**
	 * @param object
	 * @param display
	 */
	public SynchronizedFilteredElementSelectionComposite(final T object,
			final Display display) {
		super(object, display);
	}

	public void setElements(final Object[] elements) {
		this.voidExceptionFreeRunnable(new AbstractVoidExceptionFreeRunnable() {
			@Override
			public void voidSafeRun() {
				SynchronizedFilteredElementSelectionComposite.this
						.getSynchronizedObject().setElements(elements);
			}
		});
	}

	public Object getFirstSelectedElement() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<Object>() {
			@Override
			public Object safeRun() {
				return SynchronizedFilteredElementSelectionComposite.this
						.getSynchronizedObject().getFirstSelectedElement();
			}
		});
	}

	public Object[] getSelectedElements() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<Object[]>() {
			@Override
			public Object[] safeRun() {
				return SynchronizedFilteredElementSelectionComposite.this
						.getSynchronizedObject().getSelectedElements();
			}
		});
	}

	public FilteredList getFilteredList() {
		return this
				.safeSyncExec(new AbstractExceptionFreeRunnable<FilteredList>() {
					@Override
					public FilteredList safeRun() {
						return SynchronizedFilteredElementSelectionComposite.this
								.getSynchronizedObject().getFilteredList();
					}
				});
	}

	public Text getFilterText() {
		return this.safeSyncExec(new AbstractExceptionFreeRunnable<Text>() {
			@Override
			public Text safeRun() {
				return SynchronizedFilteredElementSelectionComposite.this
						.getSynchronizedObject().getFilterText();
			}
		});
	}

}
