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
package org.eclipse.papyrus.views.validation.internal;

import java.util.Collections;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.ui.IMemento;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * This is the ViewSettings type. Enjoy.
 */
class ViewSettings {

	// the Element column is 2
	private static int DEFAULT_SORT_COLUMN = 2;

	private static int DEFAULT_SORT_DIRECTION = SWT.UP;

	// negative values indicate relative weights
	private static Integer[] DEFAULT_COLUMN_WIDTHS = {0, -30, -25, -30, -15};

	private static int DEFAULT_COLUMN_WIDTH = 30;

	private List<Integer> columnWidths;

	private int sortColumn;

	private int sortDirection;

	public ViewSettings(IMemento memento) {
		if (memento != null) {
			load(memento);
		} else {
			initDefaults();
		}
	}

	public int getSortColumn() {
		return sortColumn;
	}

	public void setSortColumn(int index) {
		sortColumn = index;
	}

	public int getSortDirection() {
		return sortDirection;
	}

	public void setSortDirection(int direction) {
		sortDirection = (direction == SWT.DOWN)
			? SWT.DOWN
			: SWT.UP;
	}

	public int getColumnWidth(int index) {
		int result = DEFAULT_COLUMN_WIDTH;

		if ((index >= 0) && (index < columnWidths.size())) {
			result = columnWidths.get(index);
		}

		return result;
	}

	public void setColumnWidth(int index, int weight) {
		if (index >= 0) {
			if (index < columnWidths.size()) {
				columnWidths.set(index, weight);
			} else {
				if (index > columnWidths.size()) {
					// pad
					columnWidths.addAll(Collections.nCopies(index
						- columnWidths.size(), DEFAULT_COLUMN_WIDTH));
				}
				columnWidths.add(weight);
			}
		}
	}

	public void save(IMemento memento) {
		setIntegerList(memento, "columnWidths", columnWidths);
		memento.putInteger("sortColumn", sortColumn);
		memento.putInteger("sortDirection", sortDirection);
	}

	private void load(IMemento memento) {
		columnWidths = getIntegerList(memento, "columnWidths",
			DEFAULT_COLUMN_WIDTHS);
		sortColumn = getInt(memento, "sortColumn", DEFAULT_SORT_COLUMN);
		sortDirection = getInt(memento, "sortDirection", DEFAULT_SORT_DIRECTION);
	}

	private void initDefaults() {
		columnWidths = Lists.newArrayList(DEFAULT_COLUMN_WIDTHS);
		sortColumn = DEFAULT_SORT_COLUMN;
		sortDirection = DEFAULT_SORT_DIRECTION;
	}

	private int getInt(IMemento memento, String key, int defaultValue) {
		Integer value = memento.getInteger(key);

		return (value == null)
			? defaultValue
			: value.intValue();
	}

	private List<Integer> getIntegerList(IMemento memento, String key,
			Integer[] defaultValue) {

		List<Integer> result;

		String stringValue = memento.getString(key);
		if (stringValue == null) {
			result = Lists.newArrayList(defaultValue);
		} else {
			result = Lists.newArrayList(Iterables.transform(Splitter.on(',')
				.trimResults().split(stringValue),
				new Function<String, Integer>() {

					public Integer apply(String input) {
						return "".equals(input)
							? DEFAULT_COLUMN_WIDTH
							: Integer.valueOf(input);
					}
				}));
		}

		return result;
	}

	private void setIntegerList(IMemento memento, String key,
			Iterable<Integer> values) {

		memento.putString(key, Joiner.on(',').join(values));
	}
}
