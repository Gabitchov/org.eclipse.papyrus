/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.handlers;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.cdo.dawn.spi.IDawnEditingSupport;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * This is the UIHandlerUtil type. Enjoy.
 */
public class UIHandlerUtil {

	private UIHandlerUtil() {
		super();
	}

	public static <T> Collection<T> getSelection(ExecutionEvent event,
			Class<T> type)
			throws ExecutionException {

		ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);
		Collection<T> result = Collections.emptyList();

		if (selection instanceof IStructuredSelection) {
			Collection<?> selected = ((IStructuredSelection) selection)
				.toList();
			result = ImmutableList.copyOf(Iterables.filter(selected, type));
		}

		return result;
	}

	/**
	 * The return type is {@code List<Object>} because that is the type required
	 * by the Dawn {@link IDawnEditingSupport#lockObjects(java.util.List)} API.
	 */
	public static List<Object> getSelection(ExecutionEvent event)
			throws ExecutionException {

		return (List<Object>) getSelection(event, Object.class);
	}

}
