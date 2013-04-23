/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.providers;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.widgets.editors.AbstractEditor;
import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;
import org.eclipse.papyrus.infra.widgets.editors.StringEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;


/**
 * A generic implementation for a IGraphicalContentProvider.
 * This class doesn't provide any element, and should be extended.
 * 
 * It implements a filter for List or Tree elements, based on the label
 * provided by the viewer's label provider (Or Object#toString() if the viewer
 * doesn't have a label provider).
 * 
 * A Text widget is added before the display control to insert the filter
 * pattern. An element is matched if at least one of these conditions is
 * matched :
 * - The element's name matches the pattern
 * - One of the element's children matches the pattern
 * - One of the element's parent matches the pattern
 * 
 * The elements' hierarchy is obtained via the viewer's ContentProvider.
 * 
 * @author Camille Letavernier
 */
public class FilteredContentProvider extends EncapsulatedContentProvider {

	protected StructuredViewer viewer;

	private StringEditor filterPattern;

	private PatternViewerFilter filter;

	public static final String BASE_PATTERN = "*"; //$NON-NLS-1$

	protected boolean showIfHasVisibleParent = false;

	public FilteredContentProvider(IStructuredContentProvider encapsulated) {
		super(encapsulated);
	}

	public FilteredContentProvider() {
		super();
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		super.inputChanged(viewer, oldInput, newInput);
		if(viewer instanceof StructuredViewer) {
			this.viewer = (StructuredViewer)viewer;
			updateFilter();
		}
	}

	private void updateFilter() {
		if(this.viewer != null && filterPattern != null) {
			addViewerFilter(viewer, filter);
		}
	}

	@Override
	public void createBefore(Composite parent) {
		super.createBefore(parent);
		filterPattern = new StringEditor(parent, SWT.NONE, "Filter : "); //$NON-NLS-1$
		filterPattern.setValidateOnDelay(true);
		filterPattern.setValue(BASE_PATTERN);
		filter = getViewerFilter();
		filterPattern.addCommitListener(new ICommitListener() {

			public void commit(AbstractEditor editor) {
				filter.setPattern((String)filterPattern.getValue());
				if(viewer != null) {
					viewer.refresh();
				}
			}

		});
		updateFilter();
	}

	protected PatternViewerFilter getViewerFilter() {
		PatternViewerFilter filter = new PatternViewerFilter();
		filter.setStrict(false);
		filter.setPattern(BASE_PATTERN);
		filter.setShowIfHasVisibleParent(showIfHasVisibleParent);
		return filter;
	}

}
