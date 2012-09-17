/*******************************************************************************
 * Copyright (c) 2000, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 		IBM Corporation - initial API and implementation (org.eclipse.swt.layout.GridLayout)
 *		Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Default values for GridData
 *******************************************************************************/
package org.eclipse.papyrus.views.properties.widgets.layout;

import org.eclipse.papyrus.views.properties.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Scrollable;

/**
 * Layout based on {@link org.eclipse.swt.layout.GridLayout} This layout is basically the same as GridLayout, except for default values (Especially
 * the default GridData)
 * If an element doesn't have a GridData, a default one is created, which takes as much horizontal space as possible.
 * The goal is to enable a nice layout for the Property View, without requiring each Control to have an explicit GridData
 * However, explicit GridData are still supported.
 * 
 * Instances of this class lay out the control children of a <code>Composite</code> in a grid.
 * <p>
 * <code>GridLayout</code> has a number of configuration fields, and the controls it lays out can have an associated layout data object, called
 * <code>GridData</code>. The power of <code>GridLayout</code> lies in the ability to configure <code>GridData</code> for each control in the layout.
 * </p>
 * <p>
 * The following code creates a shell managed by a <code>GridLayout</code> with 3 columns:
 * 
 * <pre>
 * Display display = new Display();
 * Shell shell = new Shell(display);
 * GridLayout gridLayout = new GridLayout();
 * gridLayout.numColumns = 3;
 * shell.setLayout(gridLayout);
 * </pre>
 * 
 * The <code>numColumns</code> field is the most important field in a <code>GridLayout</code>. Widgets are laid out in columns from left to right, and
 * a new row is created when <code>numColumns</code> + 1 controls are added to the <code>Composite<code>.
 * </p>
 * 
 * @see GridData
 * @see <a href="http://www.eclipse.org/swt/snippets/#gridlayout">GridLayout snippets</a>
 * @see <a href="http://www.eclipse.org/swt/examples.php">SWT Example: LayoutExample</a>
 * @see <a href="http://www.eclipse.org/swt/">Sample code and further information</a>
 * @see org.eclipse.swt.layout.GridLayout
 */
public class PropertiesLayout extends Layout {

	/**
	 * numColumns specifies the number of cell columns in the layout.
	 * If numColumns has a value less than 1, the layout will not
	 * set the size and position of any controls.
	 * 
	 * The default value is 1.
	 */
	public int numColumns = 1;

	/**
	 * The adjusted number of columns
	 * If the number of controls is lower than the number of columns,
	 * some columns will be removed to let these controls take all
	 * the available space
	 * GridData#horizontalSpan is taken into account
	 */
	private int adjustedNumColumns = 1;

	/**
	 * makeColumnsEqualWidth specifies whether all columns in the layout
	 * will be forced to have the same width.
	 * 
	 * The default value is true.
	 */
	public boolean makeColumnsEqualWidth = true;

	/**
	 * marginWidth specifies the number of pixels of horizontal margin
	 * that will be placed along the left and right edges of the layout.
	 * 
	 * The default value is 5.
	 */
	public int marginWidth = 5;

	/**
	 * marginHeight specifies the number of pixels of vertical margin
	 * that will be placed along the top and bottom edges of the layout.
	 * 
	 * The default value is 0.
	 */
	public int marginHeight = 0;

	/**
	 * marginLeft specifies the number of pixels of horizontal margin
	 * that will be placed along the left edge of the layout.
	 * 
	 * The default value is 0.
	 * 
	 * @since 3.1
	 */
	public int marginLeft = 0;

	/**
	 * marginTop specifies the number of pixels of vertical margin
	 * that will be placed along the top edge of the layout.
	 * 
	 * The default value is 0.
	 * 
	 * @since 3.1
	 */
	public int marginTop = 0;

	/**
	 * marginRight specifies the number of pixels of horizontal margin
	 * that will be placed along the right edge of the layout.
	 * 
	 * The default value is 0.
	 * 
	 * @since 3.1
	 */
	public int marginRight = 0;

	/**
	 * marginBottom specifies the number of pixels of vertical margin
	 * that will be placed along the bottom edge of the layout.
	 * 
	 * The default value is 0.
	 * 
	 * @since 3.1
	 */
	public int marginBottom = 0;

	/**
	 * horizontalSpacing specifies the number of pixels between the right
	 * edge of one cell and the left edge of its neighbouring cell to
	 * the right.
	 * 
	 * The default value is 5.
	 */
	public int horizontalSpacing = 5;

	/**
	 * verticalSpacing specifies the number of pixels between the bottom
	 * edge of one cell and the top edge of its neighbouring cell underneath.
	 * 
	 * The default value is 0.
	 */
	public int verticalSpacing = 0;

	/**
	 * Constructs a new instance of this class.
	 */
	public PropertiesLayout() {
		this(false);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param useMargins
	 *        If false, there won't be any margin. If true, default margins
	 *        will be used
	 */
	public PropertiesLayout(boolean useMargins) {
		if(!useMargins) {
			marginHeight = 0;
			marginWidth = 0;
		}
	}

	/**
	 * Constructs a new instance of this class given the
	 * number of columns, and whether or not the columns
	 * should be forced to have the same width.
	 * If numColumns has a value less than 1, the layout will not
	 * set the size and position of any controls.
	 * 
	 * @param numColumns
	 *        the number of columns in the grid
	 * @param makeColumnsEqualWidth
	 *        whether or not the columns will have equal width
	 * 
	 * @since 2.0
	 */
	public PropertiesLayout(int numColumns, boolean makeColumnsEqualWidth) {
		this(numColumns, makeColumnsEqualWidth, false);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param numColumns
	 *        the number of columns in the grid
	 * @param makeColumnsEqualWidth
	 *        whether or not the columns will have equal width
	 * @param useMargins
	 *        If false, there won't be any margin. If true, default margins
	 *        will be used
	 */
	public PropertiesLayout(int numColumns, boolean makeColumnsEqualWidth, boolean useMargins) {
		this(useMargins);
		this.numColumns = numColumns;
		this.makeColumnsEqualWidth = makeColumnsEqualWidth;
	}

	@Override
	protected Point computeSize(Composite composite, int wHint, int hHint, boolean flushCache) {
		Point size = layout(composite, false, 0, 0, wHint, hHint, flushCache);
		if(wHint != SWT.DEFAULT) {
			size.x = wHint;
		}
		if(hHint != SWT.DEFAULT) {
			size.y = hHint;
		}
		return size;
	}

	@Override
	protected boolean flushCache(Control control) {
		GridData data = getLayoutData(control);
		if(data != null) {
			data.flushCache();
		}
		return true;
	}

	protected GridData getData(Control[][] grid, int row, int column, int rowCount, int columnCount, boolean first) {
		Control control = grid[row][column];
		if(control != null) {
			GridData data = getLayoutData(control);
			int hSpan = Math.max(1, Math.min(data.horizontalSpan, columnCount));
			int vSpan = Math.max(1, data.verticalSpan);
			int i = first ? row + vSpan - 1 : row - vSpan + 1;
			int j = first ? column + hSpan - 1 : column - hSpan + 1;
			if(0 <= i && i < rowCount) {
				if(0 <= j && j < columnCount) {
					if(control == grid[i][j]) {
						return data;
					}
				}
			}
		}
		return null;
	}

	@Override
	protected void layout(Composite composite, boolean flushCache) {
		Rectangle rect = composite.getClientArea();
		layout(composite, true, rect.x, rect.y, rect.width, rect.height, flushCache);
	}

	/**
	 * Removes columns when there are less controls than columns,
	 * to take all the available space
	 * 
	 * @param composite
	 */
	protected void adjustColumns(Composite composite) {
		int numChildren = composite.getChildren().length;
		adjustedNumColumns = numColumns;

		if(numChildren < numColumns) {
			int totalColumns = 0;

			for(Control child : composite.getChildren()) {
				GridData data = getLayoutData(child);
				totalColumns += data.horizontalSpan;
			}

			if(totalColumns < numColumns) {
				adjustedNumColumns = totalColumns;
			}
		}

		if(adjustedNumColumns < 1) {
			adjustedNumColumns = 1;
		}
	}

	protected Point layout(Composite composite, boolean move, int x, int y, int width, int height, boolean flushCache) {
		adjustColumns(composite);

		Control[] children = composite.getChildren();
		int count = 0;

		for(int i = 0; i < children.length; i++) {
			Control control = children[i];
			GridData data = getLayoutData(control);
			if(data == null || !data.exclude) {
				children[count++] = children[i];
			}
		}

		if(count == 0) {
			return new Point(marginLeft + marginWidth * 2 + marginRight, marginTop + marginHeight * 2 + marginBottom);
		}
		for(int i = 0; i < count; i++) {
			Control child = children[i];
			GridData data = getLayoutData(child);
			if(data == null) {
				child.setLayoutData(data = new GridData());
			}
			if(flushCache) {
				data.flushCache();
			}
			data.computeSize(child, data.widthHint, data.heightHint, flushCache);
			if(data.grabExcessHorizontalSpace && data.minimumWidth > 0) {
				if(data.cacheWidth < data.minimumWidth) {
					int trim = 0;
					//TEMPORARY CODE
					if(child instanceof Scrollable) {
						Rectangle rect = ((Scrollable)child).computeTrim(0, 0, 0, 0);
						trim = rect.width;
					} else {
						trim = child.getBorderWidth() * 2;
					}
					data.cacheWidth = data.cacheHeight = SWT.DEFAULT;
					data.computeSize(child, Math.max(0, data.minimumWidth - trim), data.heightHint, false);
				}
			}
			if(data.grabExcessVerticalSpace && data.minimumHeight > 0) {
				data.cacheHeight = Math.max(data.cacheHeight, data.minimumHeight);
			}
		}

		/* Build the grid */
		int row = 0, column = 0, rowCount = 0, columnCount = adjustedNumColumns;
		Control[][] grid = new Control[4][columnCount];
		for(int i = 0; i < count; i++) {
			Control child = children[i];
			GridData data = getLayoutData(child);
			int hSpan = Math.max(1, Math.min(data.horizontalSpan, columnCount));
			int vSpan = Math.max(1, data.verticalSpan);
			while(true) {
				int lastRow = row + vSpan;
				if(lastRow >= grid.length) {
					Control[][] newGrid = new Control[lastRow + 4][columnCount];
					System.arraycopy(grid, 0, newGrid, 0, grid.length);
					grid = newGrid;
				}
				if(grid[row] == null) {
					grid[row] = new Control[columnCount];
				}
				while(column < columnCount && grid[row][column] != null) {
					column++;
				}
				int endCount = column + hSpan;
				if(endCount <= columnCount) {
					int index = column;
					while(index < endCount && grid[row][index] == null) {
						index++;
					}
					if(index == endCount) {
						break;
					}
					column = index;
				}
				if(column + hSpan >= columnCount) {
					column = 0;
					row++;
				}
			}
			for(int j = 0; j < vSpan; j++) {
				if(grid[row + j] == null) {
					grid[row + j] = new Control[columnCount];
				}
				for(int k = 0; k < hSpan; k++) {
					grid[row + j][column + k] = child;
				}
			}
			rowCount = Math.max(rowCount, row + vSpan);
			column += hSpan;
		}

		/* Column widths */
		int availableWidth = width - horizontalSpacing * (columnCount - 1) - (marginLeft + marginWidth * 2 + marginRight);
		int expandCount = 0;
		int[] widths = new int[columnCount];
		int[] minWidths = new int[columnCount];
		boolean[] expandColumn = new boolean[columnCount];
		for(int j = 0; j < columnCount; j++) {
			for(int i = 0; i < rowCount; i++) {
				GridData data = getData(grid, i, j, rowCount, columnCount, true);
				if(data != null) {
					int hSpan = Math.max(1, Math.min(data.horizontalSpan, columnCount));
					if(hSpan == 1) {
						int w = data.cacheWidth + data.horizontalIndent;
						widths[j] = Math.max(widths[j], w);
						if(data.grabExcessHorizontalSpace) {
							if(!expandColumn[j]) {
								expandCount++;
							}
							expandColumn[j] = true;
						}
						if(!data.grabExcessHorizontalSpace || data.minimumWidth != 0) {
							w = !data.grabExcessHorizontalSpace || data.minimumWidth == SWT.DEFAULT ? data.cacheWidth : data.minimumWidth;
							w += data.horizontalIndent;
							minWidths[j] = Math.max(minWidths[j], w);
						}
					}
				}
			}
			for(int i = 0; i < rowCount; i++) {
				GridData data = getData(grid, i, j, rowCount, columnCount, false);
				if(data != null) {
					int hSpan = Math.max(1, Math.min(data.horizontalSpan, columnCount));
					if(hSpan > 1) {
						int spanWidth = 0, spanMinWidth = 0, spanExpandCount = 0;
						for(int k = 0; k < hSpan; k++) {
							spanWidth += widths[j - k];
							spanMinWidth += minWidths[j - k];
							if(expandColumn[j - k]) {
								spanExpandCount++;
							}
						}
						if(data.grabExcessHorizontalSpace && spanExpandCount == 0) {
							expandCount++;
							expandColumn[j] = true;
						}
						int w = data.cacheWidth + data.horizontalIndent - spanWidth - (hSpan - 1) * horizontalSpacing;
						if(w > 0) {
							if(makeColumnsEqualWidth) {
								int equalWidth = (w + spanWidth) / hSpan;
								int remainder = (w + spanWidth) % hSpan, last = -1;
								for(int k = 0; k < hSpan; k++) {
									widths[last = j - k] = Math.max(equalWidth, widths[j - k]);
								}
								if(last > -1) {
									widths[last] += remainder;
								}
							} else {
								if(spanExpandCount == 0) {
									widths[j] += w;
								} else {
									int delta = w / spanExpandCount;
									int remainder = w % spanExpandCount, last = -1;
									for(int k = 0; k < hSpan; k++) {
										if(expandColumn[j - k]) {
											widths[last = j - k] += delta;
										}
									}
									if(last > -1) {
										widths[last] += remainder;
									}
								}
							}
						}
						if(!data.grabExcessHorizontalSpace || data.minimumWidth != 0) {
							w = !data.grabExcessHorizontalSpace || data.minimumWidth == SWT.DEFAULT ? data.cacheWidth : data.minimumWidth;
							w += data.horizontalIndent - spanMinWidth - (hSpan - 1) * horizontalSpacing;
							if(w > 0) {
								if(spanExpandCount == 0) {
									minWidths[j] += w;
								} else {
									int delta = w / spanExpandCount;
									int remainder = w % spanExpandCount, last = -1;
									for(int k = 0; k < hSpan; k++) {
										if(expandColumn[j - k]) {
											minWidths[last = j - k] += delta;
										}
									}
									if(last > -1) {
										minWidths[last] += remainder;
									}
								}
							}
						}
					}
				}
			}
		}
		if(makeColumnsEqualWidth) {
			int minColumnWidth = 0;
			int columnWidth = 0;
			for(int i = 0; i < columnCount; i++) {
				minColumnWidth = Math.max(minColumnWidth, minWidths[i]);
				columnWidth = Math.max(columnWidth, widths[i]);
			}
			columnWidth = width == SWT.DEFAULT || expandCount == 0 ? columnWidth : Math.max(minColumnWidth, availableWidth / columnCount);
			for(int i = 0; i < columnCount; i++) {
				expandColumn[i] = expandCount > 0;
				widths[i] = columnWidth;
			}
		} else {
			if(width != SWT.DEFAULT && expandCount > 0) {
				int totalWidth = 0;
				for(int i = 0; i < columnCount; i++) {
					totalWidth += widths[i];
				}
				int c = expandCount;
				int delta = (availableWidth - totalWidth) / c;
				int remainder = (availableWidth - totalWidth) % c;
				int last = -1;
				while(totalWidth != availableWidth) {
					for(int j = 0; j < columnCount; j++) {
						if(expandColumn[j]) {
							if(widths[j] + delta > minWidths[j]) {
								widths[last = j] = widths[j] + delta;
							} else {
								widths[j] = minWidths[j];
								expandColumn[j] = false;
								c--;
							}
						}
					}
					if(last > -1) {
						widths[last] += remainder;
					}

					for(int j = 0; j < columnCount; j++) {
						for(int i = 0; i < rowCount; i++) {
							GridData data = getData(grid, i, j, rowCount, columnCount, false);
							if(data != null) {
								int hSpan = Math.max(1, Math.min(data.horizontalSpan, columnCount));
								if(hSpan > 1) {
									if(!data.grabExcessHorizontalSpace || data.minimumWidth != 0) {
										int spanWidth = 0, spanExpandCount = 0;
										for(int k = 0; k < hSpan; k++) {
											spanWidth += widths[j - k];
											if(expandColumn[j - k]) {
												spanExpandCount++;
											}
										}
										int w = !data.grabExcessHorizontalSpace || data.minimumWidth == SWT.DEFAULT ? data.cacheWidth : data.minimumWidth;
										w += data.horizontalIndent - spanWidth - (hSpan - 1) * horizontalSpacing;
										if(w > 0) {
											if(spanExpandCount == 0) {
												widths[j] += w;
											} else {
												int delta2 = w / spanExpandCount;
												int remainder2 = w % spanExpandCount, last2 = -1;
												for(int k = 0; k < hSpan; k++) {
													if(expandColumn[j - k]) {
														widths[last2 = j - k] += delta2;
													}
												}
												if(last2 > -1) {
													widths[last2] += remainder2;
												}
											}
										}
									}
								}
							}
						}
					}
					if(c == 0) {
						break;
					}
					totalWidth = 0;
					for(int i = 0; i < columnCount; i++) {
						totalWidth += widths[i];
					}
					delta = (availableWidth - totalWidth) / c;
					remainder = (availableWidth - totalWidth) % c;
					last = -1;
				}
			}
		}

		/* Wrapping */
		GridData[] flush = null;
		int flushLength = 0;
		if(width != SWT.DEFAULT) {
			for(int j = 0; j < columnCount; j++) {
				for(int i = 0; i < rowCount; i++) {
					GridData data = getData(grid, i, j, rowCount, columnCount, false);
					if(data != null) {
						if(data.heightHint == SWT.DEFAULT) {
							Control child = grid[i][j];
							//TEMPORARY CODE
							int hSpan = Math.max(1, Math.min(data.horizontalSpan, columnCount));
							int currentWidth = 0;
							for(int k = 0; k < hSpan; k++) {
								currentWidth += widths[j - k];
							}
							currentWidth += (hSpan - 1) * horizontalSpacing - data.horizontalIndent;
							if((currentWidth != data.cacheWidth && data.horizontalAlignment == SWT.FILL) || (data.cacheWidth > currentWidth)) {
								int trim = 0;
								if(child instanceof Scrollable) {
									Rectangle rect = ((Scrollable)child).computeTrim(0, 0, 0, 0);
									trim = rect.width;
								} else {
									trim = child.getBorderWidth() * 2;
								}
								data.cacheWidth = data.cacheHeight = SWT.DEFAULT;
								data.computeSize(child, Math.max(0, currentWidth - trim), data.heightHint, false);
								if(data.grabExcessVerticalSpace && data.minimumHeight > 0) {
									data.cacheHeight = Math.max(data.cacheHeight, data.minimumHeight);
								}
								if(flush == null) {
									flush = new GridData[count];
								}
								flush[flushLength++] = data;
							}
						}
					}
				}
			}
		}

		/* Row heights */
		int availableHeight = height - verticalSpacing * (rowCount - 1) - (marginTop + marginHeight * 2 + marginBottom);
		expandCount = 0;
		int[] heights = new int[rowCount];
		int[] minHeights = new int[rowCount];
		boolean[] expandRow = new boolean[rowCount];
		for(int i = 0; i < rowCount; i++) {
			for(int j = 0; j < columnCount; j++) {
				GridData data = getData(grid, i, j, rowCount, columnCount, true);
				if(data != null) {
					int vSpan = Math.max(1, Math.min(data.verticalSpan, rowCount));
					if(vSpan == 1) {
						int h = data.cacheHeight + data.verticalIndent;
						heights[i] = Math.max(heights[i], h);
						if(data.grabExcessVerticalSpace) {
							if(!expandRow[i]) {
								expandCount++;
							}
							expandRow[i] = true;
						}
						if(!data.grabExcessVerticalSpace || data.minimumHeight != 0) {
							h = !data.grabExcessVerticalSpace || data.minimumHeight == SWT.DEFAULT ? data.cacheHeight : data.minimumHeight;
							h += data.verticalIndent;
							minHeights[i] = Math.max(minHeights[i], h);
						}
					}
				}
			}
			for(int j = 0; j < columnCount; j++) {
				GridData data = getData(grid, i, j, rowCount, columnCount, false);
				if(data != null) {
					int vSpan = Math.max(1, Math.min(data.verticalSpan, rowCount));
					if(vSpan > 1) {
						int spanHeight = 0, spanMinHeight = 0, spanExpandCount = 0;
						for(int k = 0; k < vSpan; k++) {
							spanHeight += heights[i - k];
							spanMinHeight += minHeights[i - k];
							if(expandRow[i - k]) {
								spanExpandCount++;
							}
						}
						if(data.grabExcessVerticalSpace && spanExpandCount == 0) {
							expandCount++;
							expandRow[i] = true;
						}
						int h = data.cacheHeight + data.verticalIndent - spanHeight - (vSpan - 1) * verticalSpacing;
						if(h > 0) {
							if(spanExpandCount == 0) {
								heights[i] += h;
							} else {
								int delta = h / spanExpandCount;
								int remainder = h % spanExpandCount, last = -1;
								for(int k = 0; k < vSpan; k++) {
									if(expandRow[i - k]) {
										heights[last = i - k] += delta;
									}
								}
								if(last > -1) {
									heights[last] += remainder;
								}
							}
						}
						if(!data.grabExcessVerticalSpace || data.minimumHeight != 0) {
							h = !data.grabExcessVerticalSpace || data.minimumHeight == SWT.DEFAULT ? data.cacheHeight : data.minimumHeight;
							h += data.verticalIndent - spanMinHeight - (vSpan - 1) * verticalSpacing;
							if(h > 0) {
								if(spanExpandCount == 0) {
									minHeights[i] += h;
								} else {
									int delta = h / spanExpandCount;
									int remainder = h % spanExpandCount, last = -1;
									for(int k = 0; k < vSpan; k++) {
										if(expandRow[i - k]) {
											minHeights[last = i - k] += delta;
										}
									}
									if(last > -1) {
										minHeights[last] += remainder;
									}
								}
							}
						}
					}
				}
			}
		}
		if(height != SWT.DEFAULT && expandCount > 0) {
			int totalHeight = 0;
			for(int i = 0; i < rowCount; i++) {
				totalHeight += heights[i];
			}
			int c = expandCount;
			int delta = (availableHeight - totalHeight) / c;
			int remainder = (availableHeight - totalHeight) % c;
			int last = -1;
			while(totalHeight != availableHeight) {
				for(int i = 0; i < rowCount; i++) {
					if(expandRow[i]) {
						if(heights[i] + delta > minHeights[i]) {
							heights[last = i] = heights[i] + delta;
						} else {
							heights[i] = minHeights[i];
							expandRow[i] = false;
							c--;
						}
					}
				}
				if(last > -1) {
					heights[last] += remainder;
				}

				for(int i = 0; i < rowCount; i++) {
					for(int j = 0; j < columnCount; j++) {
						GridData data = getData(grid, i, j, rowCount, columnCount, false);
						if(data != null) {
							int vSpan = Math.max(1, Math.min(data.verticalSpan, rowCount));
							if(vSpan > 1) {
								if(!data.grabExcessVerticalSpace || data.minimumHeight != 0) {
									int spanHeight = 0, spanExpandCount = 0;
									for(int k = 0; k < vSpan; k++) {
										spanHeight += heights[i - k];
										if(expandRow[i - k]) {
											spanExpandCount++;
										}
									}
									int h = !data.grabExcessVerticalSpace || data.minimumHeight == SWT.DEFAULT ? data.cacheHeight : data.minimumHeight;
									h += data.verticalIndent - spanHeight - (vSpan - 1) * verticalSpacing;
									if(h > 0) {
										if(spanExpandCount == 0) {
											heights[i] += h;
										} else {
											int delta2 = h / spanExpandCount;
											int remainder2 = h % spanExpandCount, last2 = -1;
											for(int k = 0; k < vSpan; k++) {
												if(expandRow[i - k]) {
													heights[last2 = i - k] += delta2;
												}
											}
											if(last2 > -1) {
												heights[last2] += remainder2;
											}
										}
									}
								}
							}
						}
					}
				}
				if(c == 0) {
					break;
				}
				totalHeight = 0;
				for(int i = 0; i < rowCount; i++) {
					totalHeight += heights[i];
				}
				delta = (availableHeight - totalHeight) / c;
				remainder = (availableHeight - totalHeight) % c;
				last = -1;
			}
		}

		/* Position the controls */
		if(move) {
			int gridY = y + marginTop + marginHeight;
			for(int i = 0; i < rowCount; i++) {
				int gridX = x + marginLeft + marginWidth;
				for(int j = 0; j < columnCount; j++) {
					GridData data = getData(grid, i, j, rowCount, columnCount, true);
					if(data != null) {
						int hSpan = Math.max(1, Math.min(data.horizontalSpan, columnCount));
						int vSpan = Math.max(1, data.verticalSpan);
						int cellWidth = 0, cellHeight = 0;
						for(int k = 0; k < hSpan; k++) {
							cellWidth += widths[j + k];
						}
						for(int k = 0; k < vSpan; k++) {
							cellHeight += heights[i + k];
						}
						cellWidth += horizontalSpacing * (hSpan - 1);
						int childX = gridX + data.horizontalIndent;
						int childWidth = Math.min(data.cacheWidth, cellWidth);
						switch(data.horizontalAlignment) {
						case SWT.CENTER:
						case GridData.CENTER:
							childX += Math.max(0, (cellWidth - data.horizontalIndent - childWidth) / 2);
							break;
						case SWT.RIGHT:
						case SWT.END:
						case GridData.END:
							childX += Math.max(0, cellWidth - data.horizontalIndent - childWidth);
							break;
						case SWT.FILL:
							childWidth = cellWidth - data.horizontalIndent;
							break;
						}
						cellHeight += verticalSpacing * (vSpan - 1);
						int childY = gridY + data.verticalIndent;
						int childHeight = Math.min(data.cacheHeight, cellHeight);
						switch(data.verticalAlignment) {
						case SWT.CENTER:
						case GridData.CENTER:
							childY += Math.max(0, (cellHeight - data.verticalIndent - childHeight) / 2);
							break;
						case SWT.BOTTOM:
						case SWT.END:
						case GridData.END:
							childY += Math.max(0, cellHeight - data.verticalIndent - childHeight);
							break;
						case SWT.FILL:
							childHeight = cellHeight - data.verticalIndent;
							break;
						}
						Control child = grid[i][j];
						if(child != null) {
							child.setBounds(childX, childY, childWidth, childHeight);
						}
					}
					gridX += widths[j] + horizontalSpacing;
				}
				gridY += heights[i] + verticalSpacing;
			}
		}

		// clean up cache
		for(int i = 0; i < flushLength; i++) {
			flush[i].cacheWidth = flush[i].cacheHeight = -1;
		}

		int totalDefaultWidth = 0;
		int totalDefaultHeight = 0;
		for(int i = 0; i < columnCount; i++) {
			totalDefaultWidth += widths[i];
		}
		for(int i = 0; i < rowCount; i++) {
			totalDefaultHeight += heights[i];
		}
		totalDefaultWidth += horizontalSpacing * (columnCount - 1) + marginLeft + marginWidth * 2 + marginRight;
		totalDefaultHeight += verticalSpacing * (rowCount - 1) + marginTop + marginHeight * 2 + marginBottom;
		return new Point(totalDefaultWidth, totalDefaultHeight);
	}

	protected String getName() {
		String string = getClass().getName();
		int index = string.lastIndexOf('.');
		if(index == -1) {
			return string;
		}
		return string.substring(index + 1, string.length());
	}

	/**
	 * Returns a string containing a concise, human-readable
	 * description of the receiver.
	 * 
	 * @return a string representation of the layout
	 */
	@Override
	public String toString() {
		String string = getName() + " {"; //$NON-NLS-1$
		if(numColumns != 1) {
			string += "numColumns=" + numColumns + " "; //$NON-NLS-1$ //$NON-NLS-2$
		}
		if(makeColumnsEqualWidth) {
			string += "makeColumnsEqualWidth=" + makeColumnsEqualWidth + " "; //$NON-NLS-1$ //$NON-NLS-2$
		}
		if(marginWidth != 0) {
			string += "marginWidth=" + marginWidth + " "; //$NON-NLS-1$ //$NON-NLS-2$
		}
		if(marginHeight != 0) {
			string += "marginHeight=" + marginHeight + " "; //$NON-NLS-1$ //$NON-NLS-2$
		}
		if(marginLeft != 0) {
			string += "marginLeft=" + marginLeft + " "; //$NON-NLS-1$ //$NON-NLS-2$
		}
		if(marginRight != 0) {
			string += "marginRight=" + marginRight + " "; //$NON-NLS-1$ //$NON-NLS-2$
		}
		if(marginTop != 0) {
			string += "marginTop=" + marginTop + " "; //$NON-NLS-1$ //$NON-NLS-2$
		}
		if(marginBottom != 0) {
			string += "marginBottom=" + marginBottom + " "; //$NON-NLS-1$ //$NON-NLS-2$
		}
		if(horizontalSpacing != 0) {
			string += "horizontalSpacing=" + horizontalSpacing + " "; //$NON-NLS-1$ //$NON-NLS-2$
		}
		if(verticalSpacing != 0) {
			string += "verticalSpacing=" + verticalSpacing + " "; //$NON-NLS-1$ //$NON-NLS-2$
		}
		string = string.trim();
		string += "}"; //$NON-NLS-1$
		return string;
	}

	protected GridData getLayoutData(Control control) {
		Object layoutData = control.getLayoutData();

		GridData data = null;
		if(layoutData == null) { //We create a new default GridData
			data = createDefaultLayoutData();
		} else if(layoutData instanceof org.eclipse.swt.layout.GridData) { //We convert it to our own GridData class (For visibility matters)
			data = new GridData((org.eclipse.swt.layout.GridData)layoutData);
		} else if(layoutData instanceof GridData) {
			data = (GridData)layoutData;
		} else {
			data = createDefaultLayoutData();
			Activator.log.warn("Unknown LayoutData : " + layoutData); //$NON-NLS-1$
		}

		control.setLayoutData(data);

		return data;
	}

	protected GridData createDefaultLayoutData() {
		return new GridData(SWT.FILL, SWT.BEGINNING, true, false);
	}

	/**
	 * Sets the number of columns for this layout
	 * 
	 * @param numColumns
	 */
	public void setNumColumns(int numColumns) {
		this.numColumns = numColumns;
	}

	/**
	 * 
	 * @return the number of columns for this layout
	 */
	public int getNumColumns() {
		return numColumns;
	}

	/**
	 * Indicates if all columns should have the same width
	 * 
	 * @param makeColumnsEqualWidth
	 */
	public void setMakeColumnsEqualWidth(boolean makeColumnsEqualWidth) {
		this.makeColumnsEqualWidth = makeColumnsEqualWidth;
	}

	/**
	 * 
	 * @return true if all columns should have the same width
	 */
	public boolean getMakeColumnsEqualWidth() {
		return makeColumnsEqualWidth;
	}
}
