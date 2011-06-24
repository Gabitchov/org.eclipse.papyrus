/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.widgets.selectors;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.widgets.editors.IElementSelectionListener;
import org.eclipse.papyrus.widgets.editors.IElementSelector;
import org.eclipse.papyrus.widgets.providers.EncapsulatedContentProvider;
import org.eclipse.papyrus.widgets.providers.IStaticContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;


/**
 * A Selector for Multiple Reference values, with a filter
 * 
 * @author Camille Letavernier
 * 
 */
public class ReferenceSelector implements IElementSelector {

	//	/**
	//	 * A Widget to enter a filter as a String, accepting wildcards
	//	 */
	//	protected Filter filter;

	/**
	 * The display tree
	 */
	protected FilteredTree fTree;

	/**
	 * The content provider, returning the available reference values
	 */
	protected EncapsulatedContentProvider contentProvider;

	/**
	 * The content provider, returning the available reference labels
	 */
	protected ILabelProvider labelProvider;

	/**
	 * Indicates if the reference values should be unique
	 */
	protected boolean unique;

	/**
	 * Indicates if this selector should be able to return more than one value
	 * at a time.
	 */
	protected boolean multiSelection;


	private Set<IElementSelectionListener> elementSelectionListeners = new HashSet<IElementSelectionListener>();

	/**
	 * The set of selected elements. If the selector is marked as "unique",
	 * these elements will be filtered in the Tree.
	 */
	protected Set<Object> selectedElements = new HashSet<Object>();

	/**
	 * 
	 * Constructor.
	 * 
	 * @param unique
	 *        Indicates if the values are unique. If true, they are removed
	 *        from the list when they are chosen
	 */
	public ReferenceSelector(boolean unique) {
		this.unique = unique;
		this.multiSelection = true;
	}

	/**
	 * 
	 * Constructor.
	 * Builds a new ReferenceSelector for a single element
	 * 
	 */
	public ReferenceSelector() {
		this.unique = false;
		this.multiSelection = false;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getSelectedElements() {
		ISelection selection = fTree.getViewer().getSelection();

		if(selection instanceof IStructuredSelection) {
			Object[] elementsToMove = getElementsToMove(((IStructuredSelection)selection).toArray());

			addSelectedElements(elementsToMove);
			return elementsToMove;
		}

		return new Object[0];
	}

	/**
	 * Filters the selection to return only the objects that can
	 * be selected, according to the content provider.
	 * 
	 * @param selection
	 *        The input array to filter
	 * @return
	 *         The filtered array
	 * 
	 * @see org.eclipse.papyrus.widgets.providers.IHierarchicContentProvider#isValidValue(Object)
	 */
	protected Object[] getElementsToMove(Object[] selection) {
		List<Object> elementsToMove = new LinkedList<Object>();

		for(Object element : selection) {
			if(contentProvider.isValidValue(element)) {
				elementsToMove.add(element);
			}
		}

		return elementsToMove.toArray();
	}

	/**
	 * Adds elements to the list of selected elements. If the values are
	 * unique, the specified elements won't be displayed
	 * 
	 * @param elements
	 */
	private void addSelectedElements(Object[] elements) {
		if(elements.length > 0) {
			selectedElements.addAll(Arrays.asList(elements));
			fTree.getViewer().refresh();
		}
	}

	/**
	 * Returns all the elements that are currently displayed, i.e. matching
	 * the filter
	 * 
	 * {@link IElementSelector#getAllElements()}
	 * 
	 * @return all elements matching the filter
	 */
	public Object[] getAllElements() {
		//There is no way to retrieve the filteredElements on a FList
		//We can only retrieve the selected ones
		//Fix : we select everything, then we return the selection
		if(contentProvider == null) {
			return new Object[0];
		}

		fTree.getViewer().refresh();
		fTree.getViewer().setSelection(new StructuredSelection(contentProvider.getElements()));
		Object[] elementsToMove = getElementsToMove(((IStructuredSelection)fTree.getViewer().getSelection()).toArray());
		addSelectedElements(elementsToMove);
		return elementsToMove;
	}

	/**
	 * Sets the list of selected elements. If the values are
	 * unique, the specified elements won't be displayed
	 * 
	 * @param elements
	 */
	public void setSelectedElements(Object[] elements) {
		selectedElements.clear();
		selectedElements.addAll(Arrays.asList(elements));
		fTree.getViewer().refresh();
	}

	public void newObjectCreated(Object newObject) {
		contentProvider.addTemporaryElement(newObject);
		refresh();
	}

	public void clearTemporaryElements() {
		contentProvider.clearTemporaryElements();
	}

	/**
	 * Refreshes this selector's {@link org.eclipse.swt.widgets.List}
	 */
	public void refresh() {
		fTree.getViewer().refresh();
	}

	/**
	 * Sets this selector's label provider. The label provider is used
	 * to display the reference values
	 * 
	 * @param labelProvider
	 */
	public void setLabelProvider(ILabelProvider labelProvider) {
		this.labelProvider = labelProvider;
		if(fTree != null) {
			fTree.getViewer().setLabelProvider(labelProvider);
		}
	}

	/**
	 * Sets this selector's content provider. The content provider
	 * is used to select the available values for this property
	 * 
	 * @param staticContentProvider
	 */
	public void setContentProvider(IStaticContentProvider staticContentProvider) {
		this.contentProvider = new EncapsulatedContentProvider(staticContentProvider);
		if(fTree != null) {
			fTree.getViewer().setContentProvider(contentProvider);
			fTree.getViewer().setInput(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void createControls(Composite parent) {
		Composite content = new Composite(parent, SWT.BORDER);
		content.setLayout(new GridLayout(1, true));

		//		filter = new Filter(content, SWT.BORDER);
		//		filter.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final PatternFilter filter = new PatternFilter();
		filter.setPattern("*"); //$NON-NLS-1$

		fTree = new FilteredTree(content, SWT.MULTI | SWT.BORDER, new PatternFilter(), true);

		//fList = new FilteredList(content, SWT.MULTI | SWT.BORDER, labelProvider, true, true, true);
		fTree.getViewer().getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		if(contentProvider != null) {
			fTree.getViewer().setContentProvider(contentProvider);
			fTree.getViewer().setInput(""); //$NON-NLS-1$
		}
		if(labelProvider != null) {
			fTree.getViewer().setLabelProvider(labelProvider);
		}
		//
		//		this.filter.addChangeListener(new Listener() {
		//
		//			public void handleEvent(Event event) {
		//				filter.setPattern(ReferenceSelector.this.filter.getFilter());
		//			}
		//		});

		fTree.getViewer().addFilter(new ViewerFilter() {

			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				if(unique) {
					//TODO : check if the selected element has selectable children
					return !selectedElements.contains(element);
				} else {
					return true;
				}
			}
		});

		//Adds double-click support
		fTree.getViewer().getTree().addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				// Nothing
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				if(!elementSelectionListeners.isEmpty()) {
					Object[] selectedElements = getSelectedElements();
					for(IElementSelectionListener listener : elementSelectionListeners) {
						listener.addElements(selectedElements);
					}
				}
			}

		});
	}

	public void setUnique(boolean unique) {
		this.unique = unique;
	}

	public void addElementSelectionListener(IElementSelectionListener listener) {
		elementSelectionListeners.add(listener);
	}

	//	/**
	//	 * A Text field to let the user type its own filter
	//	 * 
	//	 * @author Camille Letavernier
	//	 * 
	//	 */
	//	private class Filter extends Composite implements KeyListener {
	//
	//		/**
	//		 * The text box used to edit the filter
	//		 */
	//		private Text text;
	//
	//		/**
	//		 * @param parent
	//		 *        The composite in which the filter should be created
	//		 * @param style
	//		 *        The style applied to this filter's text box
	//		 */
	//		public Filter(Composite parent, int style) {
	//			super(parent, SWT.NONE);
	//			setLayout(new FillLayout());
	//			text = new Text(this, style);
	//			text.addKeyListener(this);
	//			listeners = new LinkedList<Listener>();
	//		}
	//
	//		/**
	//		 * @return this filter as a String
	//		 */
	//		public String getFilter() {
	//			return text.getText();
	//		}
	//
	//		/**
	//		 * Adds a listener on this filter. The listener is notified
	//		 * each time the filter changes
	//		 * 
	//		 * @param listener
	//		 */
	//		public void addChangeListener(Listener listener) {
	//			listeners.add(listener);
	//		}
	//
	//		/**
	//		 * Ignored
	//		 */
	//		public void keyPressed(KeyEvent e) {
	//			//Nothing
	//		}
	//
	//		/**
	//		 * Handles the filter change event
	//		 */
	//		public void keyReleased(KeyEvent e) {
	//			for(Listener listener : listeners) {
	//				listener.handleEvent(null);
	//			}
	//		}
	//
	//		@Override
	//		public void dispose() {
	//			listeners.clear();
	//			super.dispose();
	//		}
	//
	//		/**
	//		 * All registered listeners
	//		 */
	//		private Collection<Listener> listeners;
	//	}

}
