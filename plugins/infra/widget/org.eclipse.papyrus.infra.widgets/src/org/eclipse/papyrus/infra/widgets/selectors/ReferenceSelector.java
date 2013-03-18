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
package org.eclipse.papyrus.infra.widgets.selectors;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;
import org.eclipse.papyrus.infra.widgets.editors.IElementSelectionListener;
import org.eclipse.papyrus.infra.widgets.editors.IElementSelector;
import org.eclipse.papyrus.infra.widgets.providers.EncapsulatedContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IGraphicalContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.strategy.ProviderBasedBrowseStrategy;
import org.eclipse.papyrus.infra.widgets.strategy.StrategyBasedContentProvider;
import org.eclipse.papyrus.infra.widgets.strategy.TreeBrowseStrategy;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.dialogs.PatternFilter;


/**
 * A Selector for Multiple Reference values, with a filter
 * 
 * This selector is compatible with {@link org.eclipse.papyrus.infra.widgets.providers.IAdaptableContentProvider}
 * 
 * @author Camille Letavernier
 * 
 */
public class ReferenceSelector implements IElementSelector {

	/**
	 * The tree viewer
	 */
	protected TreeViewer treeViewer;

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


	protected final List<ICommitListener> commitListeners;


	private Set<IElementSelectionListener> elementSelectionListeners = new HashSet<IElementSelectionListener>();

	/**
	 * The set of selected elements. If the selector is marked as "unique",
	 * these elements will be filtered in the Tree.
	 * 
	 * The Elements are in their container form
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
		commitListeners = new LinkedList<ICommitListener>();
	}

	/**
	 * 
	 * Constructor.
	 * Builds a new ReferenceSelector for a single element
	 * 
	 */
	public ReferenceSelector() {
		this(false);
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getSelectedElements() {
		ISelection selection = treeViewer.getSelection();

		if(selection instanceof IStructuredSelection) {
			Object[] containerElementsToMove = getElementsToMove(((IStructuredSelection)selection).toArray());
			Object[] semanticElementsToMove = getSemanticElements(containerElementsToMove);
			addSelectedElements(semanticElementsToMove);
			return semanticElementsToMove;
		}

		return new Object[0];
	}

	/**
	 * This method is used for handling correctly the IAdaptableContentProvider
	 * The objects can be in two different forms :
	 * - The semantic element
	 * - The container element
	 * 
	 * This methods returns an array of semantic elements from an array of
	 * container elements. This is useful for retrieving the semantic elements
	 * from a viewer's selection when the viewer uses an IAdaptableContentProvider
	 * 
	 * @param containerElements
	 *        The array of elements wrapped in their container
	 * @return
	 *         The array of semantic elements to be converted
	 * 
	 * @see #getContainerElements(Object[])
	 * @see org.eclipse.papyrus.infra.widgets.providers.IAdaptableContentProvider
	 */
	private Object[] getSemanticElements(Object[] containerElements) {
		Object[] semanticElements = new Object[containerElements.length];
		int i = 0;
		for(Object containerElement : containerElements) {
			semanticElements[i++] = contentProvider.getAdaptedValue(containerElement);
		}
		return semanticElements;
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
	 * @see org.eclipse.papyrus.infra.widgets.providers.IHierarchicContentProvider#isValidValue(Object)
	 */
	protected Object[] getElementsToMove(Object[] selection) {
		List<Object> elementsToMove = new LinkedList<Object>();

		for(Object element : selection) {
			if(contentProvider.isValidValue(element)) {
				elementsToMove.add(element);
			}
		}

		notifyCommitListeners();
		return elementsToMove.toArray();
	}

	/**
	 * Adds elements to the list of selected elements. If the values are
	 * unique, the specified elements won't be displayed
	 * 
	 * @param elements
	 */
	private void addSelectedElements(Object[] semanticElements) {
		if(semanticElements.length > 0) {
			selectedElements.addAll(Arrays.asList(semanticElements));
			refresh();
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

		Collection<Object> visibleElements = new LinkedList<Object>();
		for(TreeItem rootItem : treeViewer.getTree().getItems()) {
			visibleElements.add(getElement(rootItem));
			if(rootItem.getExpanded()) {
				fillVisibleElements(rootItem, visibleElements);
			}
		}

		Object[] containerElementsToMove = getElementsToMove(visibleElements.toArray());
		Object[] semanticElementsToMove = getSemanticElements(containerElementsToMove);
		addSelectedElements(semanticElementsToMove);

		return semanticElementsToMove;
	}

	private void fillVisibleElements(TreeItem item, Collection<Object> visibleElements) {
		for(TreeItem childItem : item.getItems()) {
			visibleElements.add(getElement(childItem));
			if(childItem.getExpanded()) {
				fillVisibleElements(childItem, visibleElements);
			}
		}
	}

	private Object getElement(TreeItem item) {
		return item.getData();
	}

	/**
	 * Sets the list of selected elements. If the values are
	 * unique, the specified elements won't be displayed
	 * 
	 * @param elements
	 */
	public void setSelectedElements(Object[] semanticElements) {
		selectedElements.clear();
		selectedElements.addAll(Arrays.asList(semanticElements));
		refresh();
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
		((SelectionFilteredBrowseStrategy)contentProvider.getBrowseStrategy()).refresh();
		treeViewer.refresh();
	}

	/**
	 * Sets this selector's label provider. The label provider is used
	 * to display the reference values
	 * 
	 * @param labelProvider
	 */
	public void setLabelProvider(ILabelProvider labelProvider) {
		this.labelProvider = labelProvider;
		if(treeViewer != null) {
			treeViewer.setLabelProvider(labelProvider);
		}
	}

	/**
	 * Sets this selector's content provider. The content provider
	 * is used to select the available values for this property
	 * 
	 * @param staticContentProvider
	 */
	public void setContentProvider(IStaticContentProvider staticContentProvider) {

		ITreeContentProvider provider = new EncapsulatedContentProvider(staticContentProvider);

		TreeBrowseStrategy filteredBrowseStrategy = new SelectionFilteredBrowseStrategy(provider);

		TreeBrowseStrategy revealBrowseStrategy = new ProviderBasedBrowseStrategy(provider);

		this.contentProvider = new StrategyBasedContentProvider(filteredBrowseStrategy, revealBrowseStrategy);

		if(treeViewer != null) {
			treeViewer.setContentProvider(contentProvider);
			treeViewer.setInput(""); //$NON-NLS-1$
		}

		if(contentProvider instanceof ICommitListener) {
			commitListeners.add(contentProvider);
		}
	}

	/**
	 * Strategy to hide tree elements which are already selected, when the selector is defined as unique
	 * 
	 * @author Camille Letavernier
	 * 
	 */
	private class SelectionFilteredBrowseStrategy extends ProviderBasedBrowseStrategy {

		public SelectionFilteredBrowseStrategy(ITreeContentProvider provider) {
			super(provider);
		}

		@Override
		public boolean isValidValue(Object element) {
			if(!unique) {
				return super.isValidValue(element);
			}

			if(!super.isValidValue(element)) {
				return false;
			}

			return !selectedElements.contains(getAdaptedValue(element));
		}

		public void refresh() {
			if(unique) {
				clearCache();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void createControls(Composite parent) {
		Composite content = new Composite(parent, SWT.NONE);
		content.setLayout(new GridLayout(1, true));

		treeViewer = new TreeViewer(content, SWT.BORDER | SWT.MULTI);
		treeViewer.setFilters(new ViewerFilter[]{ new PatternFilter() });

		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.minimumHeight = 300;
		data.minimumWidth = 300;
		treeViewer.getTree().setLayoutData(data);

		if(labelProvider != null) {
			treeViewer.setLabelProvider(labelProvider);
		}

		if(contentProvider != null) {
			treeViewer.setContentProvider(contentProvider);
			treeViewer.setInput(""); //$NON-NLS-1$
		}

		if(contentProvider instanceof IGraphicalContentProvider) {
			IGraphicalContentProvider graphicalContentProvider = contentProvider;

			Composite beforeTreeComposite = new Composite(content, SWT.NONE);
			beforeTreeComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
			FillLayout layout = new FillLayout();
			layout.marginHeight = 0;
			layout.marginWidth = 0;
			beforeTreeComposite.setLayout(layout);
			graphicalContentProvider.createBefore(beforeTreeComposite);

			beforeTreeComposite.moveAbove(treeViewer.getTree());

			Composite afterTreeComposite = new Composite(content, SWT.NONE);
			layout = new FillLayout();
			layout.marginHeight = 0;
			layout.marginWidth = 0;
			afterTreeComposite.setLayout(layout);
			afterTreeComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
			graphicalContentProvider.createAfter(afterTreeComposite);
		}

		//Adds double-click support
		treeViewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				if(!elementSelectionListeners.isEmpty()) {
					Object[] selectedElements = getSelectedElements();
					if(selectedElements.length > 0) {
						notifyCommitListeners();
						for(IElementSelectionListener listener : elementSelectionListeners) {
							listener.addElements(selectedElements);
						}
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

	public void removeElementSelectionListener(IElementSelectionListener listener) {
		elementSelectionListeners.remove(listener);
	}

	protected void notifyCommitListeners() {
		for(ICommitListener commitListener : commitListeners) {
			commitListener.commit(null);
		}
	}

}
