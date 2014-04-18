/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Added graphic contributions for the filters
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial History implementation
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - History integration
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.providers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.infra.services.labelprovider.service.IDetailLabelProvider;
import org.eclipse.papyrus.infra.widgets.editors.AbstractEditor;
import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;
import org.eclipse.papyrus.infra.widgets.editors.StringEditor;
import org.eclipse.papyrus.infra.widgets.providers.CollectionContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.EncapsulatedContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.PatternViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;

/**
 * This providers adds a text-filter and an History to EMF-based content providers
 */
//TODO : Extend (Abstract)FilteredContentProvider
public class EMFGraphicalContentProvider extends EncapsulatedContentProvider implements ISelectionChangedListener {

	private static final String DIALOG_SETTINGS = EMFGraphicalContentProvider.class.getName();

	protected String historyId;

	//Unused (yet)
	//TODO : Add a preference or a collapsible composite for this feature (Or both)
	//
	//	/**
	//	 * The current metaclass viewer filter
	//	 */ 
	//	protected ViewerFilter currentMetaclassViewerFilter;

	protected ViewerFilter patternFilter;

	private static final String HISTORY_SETTINGS = "History"; //$NON-NLS-1$

	private static final String PREVIOUS_SELECTION = "PreviousSelection"; //$NON-NLS-1$

	protected List<EObject> selectionHistory;

	protected CLabel detailLabel;

	protected Object selectedObject;

	protected StructuredViewer viewer;

	protected ResourceSet resourceSet;

	private static final int HISTORY_MAX_SIZE = 5;

	private String currentFilterPattern;

	private TableViewer historyViewer;

	/**
	 * the wanted root of the contentprovider
	 */

	/**
	 * the constructor
	 */
	public EMFGraphicalContentProvider(IStructuredContentProvider semanticProvider, ResourceSet resourceSet, String historyId) {
		super(semanticProvider);
		this.historyId = historyId;
		this.resourceSet = resourceSet;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createBefore(Composite parent) {
		createPatternFilter(parent);
	}

	protected void createPatternFilter(Composite parent) {
		StringEditor editor = new StringEditor(parent, SWT.NONE);
		editor.setLabel("Filter:");
		editor.setToolTipText("Enter the name of the element you're looking for. You can use * as a wildcard");
		editor.setValidateOnDelay(true);
		patternFilter = new PatternViewerFilter();
		currentFilterPattern = ""; //$NON-NLS-1$
		((PatternViewerFilter)patternFilter).setPattern(currentFilterPattern);

		editor.addCommitListener(new ICommitListener() {

			public void commit(AbstractEditor editor) {
				String filterPattern = (String)((StringEditor)editor).getValue();
				((PatternViewerFilter)patternFilter).setPattern(filterPattern);
				viewer.refresh();
				if(!("".equals(filterPattern) || currentFilterPattern.equals(filterPattern))) {

					//FIXME: The reveal first match algorithm is not compatible with infinite trees and had bad performances
					//Object firstMatch = getFirstMatchingElement(null);
					//if(firstMatch != null) {
					//		revealSemanticElement(Collections.singletonList(firstMatch));
					//}

					currentFilterPattern = filterPattern;
				}
			}

		});

		List<ViewerFilter> filters = new LinkedList<ViewerFilter>(Arrays.asList(viewer.getFilters()));
		filters.add(patternFilter);
		viewer.setFilters(filters.toArray(new ViewerFilter[filters.size()]));
	}

	/**
	 * Returns the first (encapsulated) element matching the current filters
	 * 
	 * @return
	 */
	protected Object getFirstMatchingElement(Object parent) {
		//Browse from the root element
		if(parent == null) {
			for(Object parentElement : getElements(viewer.getInput())) {
				Object firstMatch = getFirstMatchingElement(parentElement);
				if(firstMatch != null) {
					return firstMatch;
				}
			}
			return null;
		}

		for(ViewerFilter filter : viewer.getFilters()) {
			if(!filter.select(viewer, getParent(parent), parent)) {
				return null;
			}
		}

		//Test the current element
		if(isValidValue(parent)) {
			return parent;
		}

		//Browse the child elements
		for(Object childElement : getChildren(parent)) {
			Object firstMatch = getFirstMatchingElement(childElement);
			if(firstMatch != null) {
				return firstMatch;
			}
		}

		//No match found
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createAfter(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		//		createMetaclassFilter(parent); //Disabled
		createHistory(parent);
		createDetailArea(parent);
	}

	/**
	 * Creates a widget referencing the recently selected elements
	 * 
	 * @param parent
	 *        The composite in which the widget will be created
	 */
	protected void createHistory(Composite parent) {
		initSelectionHistory();

		Group historyGroup = new Group(parent, SWT.NONE);
		historyGroup.setText("Recent selections");
		historyGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		historyGroup.setLayout(new GridLayout(1, true));

		// table
		Table historyTable = new Table(historyGroup, SWT.BORDER | SWT.SINGLE);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, false);
		data.heightHint = 70;
		historyTable.setLayoutData(data);
		historyViewer = new TableViewer(historyTable);
		historyViewer.setContentProvider(CollectionContentProvider.instance);
		historyViewer.setLabelProvider(viewer.getLabelProvider());
		historyViewer.setInput(selectionHistory);
		historyViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection)historyViewer.getSelection();
				Object selectedObject = selection.getFirstElement();
				if(selectedObject instanceof EObject) {
					EObject eObject = ((EObject)selectedObject);
					revealSemanticElement(Collections.singletonList(eObject));
				}
			}
		});
	}

	/**
	 * Inits the History
	 */
	protected void initSelectionHistory() {
		selectionHistory = new ArrayList<EObject>(HISTORY_MAX_SIZE + 1);

		IDialogSettings historySettings = getDialogSettings().getSection(HISTORY_SETTINGS);
		if(historySettings != null && resourceSet != null) {
			String[] uriHistory = historySettings.getArray(PREVIOUS_SELECTION);
			// for each element in the list, try to get the EObject by its URI
			if(uriHistory != null) {
				for(String uri : uriHistory) {
					try {
						EObject object = resourceSet.getEObject(URI.createURI(uri), true);
						if(object != null && !selectionHistory.contains(object)) {
							selectionHistory.add(object);
						}
					} catch (Exception ex) {
						//Ignore : if the resource doesn't exist anymore, we just skip it
					}
				}
			}
		}
	}

	/**
	 * Creates a widget to filter the tree according to the selected
	 * metaclass.
	 * 
	 * @param parent
	 *        The Composite in which the widgets will be created
	 * @deprecated
	 */
	@Deprecated
	protected void createMetaclassFilter(Composite parent) {
		//		if(semanticRoot == null) {
		//			return;
		//		}
		//
		//		Composite container = new Composite(parent, SWT.NONE);
		//		container.setLayout(new GridLayout(2, false));
		//		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		//
		//		ResourceSet resourceSet = semanticRoot.eResource().getResourceSet();
		//		EcoreUtil.resolveAll(resourceSet);
		//
		//		Label metamodelLabel = new Label(container, SWT.NONE);
		//		metamodelLabel.setText("Metamodel:");
		//
		//		ComboViewer metamodelViewer = new ComboViewer(container);
		//		metamodelViewer.setContentProvider(getMetamodelContentProvider());
		//		metamodelViewer.setLabelProvider(new EMFLabelProvider());
		//		metamodelViewer.setInput(semanticRoot);
		//		metamodelViewer.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		//
		//		Label metaclassLabel = new Label(container, SWT.NONE);
		//		metaclassLabel.setText("Metaclass:");
		//
		//		final ComboViewer metaclassViewer = new ComboViewer(container);
		//		IStructuredContentProvider metaclassProvider = getMetaclassContentProvider();
		//		metaclassViewer.setContentProvider(metaclassProvider);
		//		metaclassViewer.setLabelProvider(new EMFLabelProvider());
		//		metaclassViewer.getCombo().setEnabled(false);
		//		metaclassViewer.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		//
		//		metamodelViewer.setFilters(new ViewerFilter[]{ new MetamodelContentFilter(metaclassProvider) });
		//
		//		metamodelViewer.addSelectionChangedListener(new ISelectionChangedListener() {
		//
		//			public void selectionChanged(SelectionChangedEvent event) {
		//				metaclassViewer.setInput(((IStructuredSelection)event.getSelection()).getFirstElement());
		//				metaclassViewer.getCombo().setEnabled(true);
		//			}
		//		});
		//
		//		metaclassViewer.addSelectionChangedListener(new ISelectionChangedListener() {
		//
		//			public void selectionChanged(SelectionChangedEvent event) {
		//				if(!event.getSelection().isEmpty()) {
		//					Object selectedObject = ((IStructuredSelection)event.getSelection()).getFirstElement();
		//					List<ViewerFilter> filters = new LinkedList<ViewerFilter>(Arrays.asList(viewer.getFilters()));
		//					filters.remove(currentMetaclassViewerFilter);
		//					currentMetaclassViewerFilter = getMetaclassViewerFilter(selectedObject);
		//					filters.add(currentMetaclassViewerFilter);
		//					viewer.setFilters(filters.toArray(new ViewerFilter[filters.size()]));
		//					viewer.refresh();
		//				}
		//			}
		//		});
	}

	/**
	 * Creates a label widget to display detailed information on the
	 * current value (Such as fully qualified name, ...)
	 * 
	 * @param parent
	 *        The composite in which the widget will be created
	 */
	protected void createDetailArea(Composite parent) {
		detailLabel = new CLabel(parent, SWT.BORDER);
		detailLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		updateDetailLabel();
	}

	//	@Deprecated
	//	protected IStructuredContentProvider getMetamodelContentProvider() {
	//		return new MetamodelContentProvider();
	//	}
	//
	//	@Deprecated
	//	protected IStructuredContentProvider getMetaclassContentProvider() {
	//		return new MetaclassContentProvider((EClass)this.metaClassWanted, this.metaClassNotWantedList);
	//	}
	//
	//	@Deprecated
	//	protected ILabelProvider getLabelProvider() {
	//		return new EMFObjectLabelProvider();
	//	}
	//
	//	@Deprecated
	//	protected ViewerFilter getMetaclassViewerFilter(Object selectedMetaClass) {
	//		return new MetaclassViewerFilter(selectedMetaClass);
	//	}

	/**
	 * Returns the dialog settings. Returned object can't be null.
	 * 
	 * @return dialog settings for this dialog
	 */
	protected IDialogSettings getDialogSettings() {
		IDialogSettings settings = Activator.getDefault().getDialogSettings().getSection(getDialogSettingsIdentifier());
		if(settings == null) {
			settings = Activator.getDefault().getDialogSettings().addNewSection(getDialogSettingsIdentifier());
		}
		return settings;
	}

	private String getDialogSettingsIdentifier() {
		return DIALOG_SETTINGS + "_" + historyId;
	}

	/**
	 * Stores dialog settings.
	 * 
	 * @param settings
	 *        settings used to store dialog
	 */
	protected void storeDialog(IDialogSettings settings, Collection<EObject> newValues) {
		selectionHistory.removeAll(newValues);

		selectionHistory.addAll(0, newValues);

		//Truncate the history: only keep a sublist of size HISTORY_MAX_SIZE
		if(selectionHistory.size() > HISTORY_MAX_SIZE) {
			selectionHistory = selectionHistory.subList(0, HISTORY_MAX_SIZE);
		}

		List<String> uriList = new ArrayList<String>();

		// convert list of EObject into URI string list
		for(EObject object : selectionHistory) {
			URI uri = EcoreUtil.getURI(object);
			uriList.add(uri.toString());
		}

		IDialogSettings historySettings = settings.getSection(HISTORY_SETTINGS);
		if(historySettings == null) {
			historySettings = settings.addNewSection(HISTORY_SETTINGS);
		}
		historySettings.put(PREVIOUS_SELECTION, uriList.toArray(new String[uriList.size()]));

		historyViewer.setInput(selectionHistory);
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		encapsulated.inputChanged(viewer, oldInput, newInput);

		if(viewer instanceof StructuredViewer) {
			this.viewer = (StructuredViewer)viewer;
			if(newInput != null && viewer.getControl() != null && !viewer.getControl().isDisposed()) {
				this.viewer.addSelectionChangedListener(this);
			}
		} else {
			this.viewer = null;
		}
	}

	public void selectionChanged(SelectionChangedEvent event) {
		selectedObject = ((IStructuredSelection)event.getSelection()).getFirstElement();
		updateDetailLabel();
	}

	private void updateDetailLabel() {
		if(detailLabel == null || detailLabel.isDisposed()) {
			return;
		}
		if(selectedObject == null) {
			detailLabel.setText("");
			detailLabel.setImage(null);
		} else {
			ILabelProvider labelProvider = (ILabelProvider)viewer.getLabelProvider();
			String description;
			if(labelProvider instanceof IDetailLabelProvider) {
				description = ((IDetailLabelProvider)labelProvider).getDetail(selectedObject);
			} else {
				description = labelProvider.getText(selectedObject);
			}
			detailLabel.setText(description);
			detailLabel.setImage(labelProvider.getImage(selectedObject));
		}
		detailLabel.getParent().getParent().layout();
	}

	@Override
	public void commit(AbstractEditor editor) {
		Iterator<?> selectionIterator = ((IStructuredSelection)viewer.getSelection()).iterator();
		Set<EObject> eObjectsToStore = new LinkedHashSet<EObject>();
		while(selectionIterator.hasNext()) {
			Object selectedElement = selectionIterator.next();
			if(isValidValue(selectedElement)) {
				Object semanticObject = getAdaptedValue(selectedElement);
				if(semanticObject instanceof EObject) {
					eObjectsToStore.add((EObject)semanticObject);
				}
			}
		}

		if(!eObjectsToStore.isEmpty()) {
			storeDialog(getDialogSettings(), eObjectsToStore);
		}
	}

	@Override
	public void dispose() {
		super.dispose();
		viewer.removeSelectionChangedListener(this);
	}
}
