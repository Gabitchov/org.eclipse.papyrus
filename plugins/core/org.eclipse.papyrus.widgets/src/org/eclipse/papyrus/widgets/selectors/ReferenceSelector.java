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

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.widgets.IElementSelector;
import org.eclipse.papyrus.widgets.providers.EncapsulatedContentProvider;
import org.eclipse.papyrus.widgets.providers.IStaticContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.FilteredList;


/**
 * A Selector for Multiple Refrence values, with a filter
 * 
 * @author Camille Letavernier
 * 
 */
public class ReferenceSelector implements IElementSelector {

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
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getSelectedElements() {
		Object[] selectedElements = fList.getSelection();
		addSelectedElements(selectedElements);
		return selectedElements;
	}

	/**
	 * Adds elements to the list of selected elements. If the values are
	 * unique, the specified elements won't be displayed
	 * 
	 * @param elements
	 */
	private void addSelectedElements(Object[] elements) {
		if(unique && elements.length > 0) {
			contentProvider.addFilteredElements(elements);
			fList.setElements(contentProvider.getElements());
		}
	}

	/**
	 * Returns all the elements that are currently displayed, i.e. matching
	 * the filter
	 * 
	 * @see org.eclipse.papyrus.widgets.IElementSelector#getAllElements()
	 * 
	 * @return all elements matching the filter
	 */
	public Object[] getAllElements() {
		//There is no way to retrieve the filteredElements on a FList
		//We can only retrieve the selected ones
		//Fix : we select everything, then we return the selection
		fList.setSelection(contentProvider.getElements());
		Object[] allElements = fList.getSelection();
		addSelectedElements(allElements);
		return allElements;
	}

	/**
	 * Sets the list of selected elements. If the values are
	 * unique, the specified elements won't be displayed
	 * 
	 * @param elements
	 */
	public void setSelectedElements(Object[] elements) {
		if(unique) {
			contentProvider.setFilteredElements(elements);
			fList.setElements(contentProvider.getElements());
		}
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
		fList.setElements(contentProvider.getElements());
	}

	/**
	 * Sets this selector's label provider. The label provider is used
	 * to display the reference values
	 * 
	 * @param labelProvider
	 */
	public void setLabelProvider(ILabelProvider labelProvider) {
		this.labelProvider = labelProvider;
		if(fList != null) {
			fList.setLabelProvider(labelProvider);
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
		if(fList != null) {
			fList.setElements(contentProvider.getElements());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void createControls(Composite parent) {
		Composite content = new Composite(parent, SWT.BORDER);
		content.setLayout(new GridLayout(1, true));

		filter = new Filter(content, SWT.BORDER);
		filter.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		fList = new FilteredList(content, SWT.MULTI | SWT.BORDER, labelProvider, true, true, true);
		fList.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		if(contentProvider != null) {
			fList.setElements(contentProvider.getElements());
		}

		filter.addChangeListener(new Listener() {

			public void handleEvent(Event event) {
				fList.setFilter(filter.getFilter());
			}
		});
	}

	/**
	 * A Widget to enter a filter as a String, accepting wildcards
	 */
	protected Filter filter;

	/**
	 * The display list
	 */
	protected FilteredList fList;

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
	 * A Text field to let the user type its own filter
	 * 
	 * @author Camille Letavernier
	 * 
	 */
	private class Filter extends Composite implements KeyListener {

		/**
		 * The text box used to edit the filter
		 */
		private Text text;

		/**
		 * @param parent
		 *        The composite in which the filter should be created
		 * @param style
		 *        The style applied to this filter's text box
		 */
		public Filter(Composite parent, int style) {
			super(parent, SWT.NONE);
			setLayout(new FillLayout());
			text = new Text(this, style);
			text.addKeyListener(this);
			listeners = new LinkedList<Listener>();
		}

		/**
		 * @return this filter as a String
		 */
		public String getFilter() {
			return text.getText();
		}

		/**
		 * Adds a listener on this filter. The listener is notified
		 * each time the filter changes
		 * 
		 * @param listener
		 */
		public void addChangeListener(Listener listener) {
			listeners.add(listener);
		}

		/**
		 * Removes the specified Listener from this filter
		 * 
		 * @param listener
		 */
		public void removeChangeListener(Listener listener) {
			listeners.remove(listener);
		}

		/**
		 * Ignored
		 */
		public void keyPressed(KeyEvent e) {
			//Nothing
		}

		/**
		 * Handles the filter change event
		 */
		public void keyReleased(KeyEvent e) {
			for(Listener listener : listeners) {
				listener.handleEvent(null);
			}
		}

		/**
		 * All registered listeners
		 */
		private Collection<Listener> listeners;
	}

}
