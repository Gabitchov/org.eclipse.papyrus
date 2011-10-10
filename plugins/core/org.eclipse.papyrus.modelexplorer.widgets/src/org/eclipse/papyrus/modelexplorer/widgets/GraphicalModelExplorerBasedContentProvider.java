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
package org.eclipse.papyrus.modelexplorer.widgets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.modelexplorer.SemanticFromModelExplorer;
import org.eclipse.papyrus.resource.ModelSet;
import org.eclipse.papyrus.resource.ModelUtils;
import org.eclipse.papyrus.widgets.editors.AbstractEditor;
import org.eclipse.papyrus.widgets.editors.ICommitListener;
import org.eclipse.papyrus.widgets.editors.StringEditor;
import org.eclipse.papyrus.widgets.providers.IDetailLabelProvider;
import org.eclipse.papyrus.widgets.providers.IGraphicalContentProvider;
import org.eclipse.papyrus.widgets.providers.IHierarchicContentProvider;
import org.eclipse.papyrus.widgets.providers.PatternViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;

/**
 * this is a content provider based on the model explorer on which we can filter wanted meta-classes
 * It can only filter if wantedMetaclass and metaclassNotWanted are Eclass
 */
public class GraphicalModelExplorerBasedContentProvider extends ModelContentProvider implements IMetaclassFilteredContentProvider, IHierarchicContentProvider, IGraphicalContentProvider, ISelectionChangedListener, ICommitListener {


	private static final String DIALOG_SETTINGS = GraphicalModelExplorerBasedContentProvider.class.getName();

	/** The not wanted. */
	protected ArrayList<Object> metaClassNotWantedList = new ArrayList<Object>();

	/** The wanted. */
	protected Object metaClassWanted = null;

	/**
	 * a bridge to find the semantic element behind an object of the model explorer
	 */
	protected SemanticFromModelExplorer brige = new SemanticFromModelExplorer();

	protected String historyId;

	/**
	 * The current metaclass viewer filter
	 */
	protected ViewerFilter currentMetaclassViewerFilter;

	protected ViewerFilter patternFilter;

	private static final String HISTORY_SETTINGS = "History"; //$NON-NLS-1$

	private static final String PREVIOUS_SELECTION = "PreviousSelection";

	protected List<EObject> selectionHistory;

	protected CLabel detailLabel;

	protected Object selectedObject;

	private static final int HISTORY_MAX_SIZE = 5;

	private String currentFilterPattern = ""; //$NON-NLS-1$

	/**
	 * the wanted root of the contentprovider
	 */

	/**
	 * the constructor
	 * 
	 * @param semanticRoot
	 *        the root that we want to display at top
	 */
	public GraphicalModelExplorerBasedContentProvider(EObject semanticRoot, String historyId) {
		super(semanticRoot);
		this.historyId = historyId;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setMetaClassNotWanted(List<Object> metaClassNotWanted) {
		metaClassNotWantedList.clear();
		metaClassNotWantedList.addAll(metaClassNotWanted);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setMetaClassWanted(Object metaClassWanted) {
		this.metaClassWanted = metaClassWanted;
	}


	/**
	 * get Wanted metaclasse
	 * 
	 * @return Eclass that reprensent the wanted metaclass
	 */
	public Object getMetaClassWanted() {
		return metaClassWanted;
	}

	public boolean isValidValue(Object element) {

		//to filter, test if the wanted metaclass is not null
		if(metaClassWanted != null) {
			// get the semantic object form the element
			EObject semanticObject = null;

			if(element instanceof IAdaptable) {
				semanticObject = (EObject)brige.getSemanticElement(element);
			}
			if(element instanceof EObject) {
				semanticObject = (EObject)element;
			}
			//return false for Ereference
			if(element instanceof EReference || semanticObject instanceof EReference) {
				return false;
			}
			//the semantic object is not null
			if(semanticObject != null) {
				//test if this is an Eclass
				if(metaClassWanted instanceof EClass) {
					//test if the semanticobject is instance of metaclassWanted
					// and not an instance of metaclassNotWanted
					if(((EClass)metaClassWanted).isSuperTypeOf(semanticObject.eClass())) {
						if(metaClassNotWantedList.size() > 0) {
							Iterator<Object> iternotwanted = metaClassNotWantedList.iterator();
							while(iternotwanted.hasNext()) {
								Object notWanted = iternotwanted.next();
								if(notWanted instanceof EClass) {
									if(((EClass)notWanted).isSuperTypeOf(semanticObject.eClass())) {
										return false;
									}
								}
							}
						}
						return true;
					}
				}
				return false;
			}

		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public void createBefore(Composite parent) {
		createPatternFilter(parent);
	}

	protected void createPatternFilter(Composite parent) {
		StringEditor editor = new StringEditor(parent, SWT.NONE);
		editor.setLabel("Filter:");
		editor.setToolTipText("Enter the name of the element you're looking for. You can use * as a wildcard");
		editor.setValidateOnDelay(true);
		patternFilter = new PatternViewerFilter();
		((PatternViewerFilter)patternFilter).setPattern(currentFilterPattern);

		editor.addCommitListener(new ICommitListener() {

			public void commit(AbstractEditor editor) {
				String filterPattern = (String)((StringEditor)editor).getValue();
				((PatternViewerFilter)patternFilter).setPattern(filterPattern);
				viewer.refresh();
				if(!("".equals(filterPattern) || currentFilterPattern.equals(filterPattern))) {
					Object firstMatch = getFirstMatchingElement(null);
					if(firstMatch != null) {
						viewer.reveal(firstMatch);
					}
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
		final TableViewer historyViewer = new TableViewer(historyTable);
		historyViewer.setContentProvider(new HistoryContentProvider());
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
					// select the element in the model explorer
					Object containerValue = getContainerValue(eObject);
					if(containerValue == null) {
						viewer.setSelection(StructuredSelection.EMPTY);
					} else {
						viewer.setSelection(new StructuredSelection(containerValue), true);
					}

					// update current selection
					//	ModelElementItem item = (ModelElementItem)((IStructuredSelection)viewer.getSelection()).getFirstElement();
					// 	if(item != null) {
					//		setCurrentValueItem(item);
					//	}
				}
			}
		});
	}

	/**
	 * Inits the History
	 */
	protected void initSelectionHistory() {
		// read the history in the preferences
		ServicesRegistry servicesRegistry = EditorUtils.getServiceRegistry();
		ModelSet modelSet = null;
		selectionHistory = new ArrayList<EObject>(HISTORY_MAX_SIZE + 1);
		try {
			modelSet = ModelUtils.getModelSetChecked(servicesRegistry);
		} catch (ServiceException e) {
			Activator.log.error(e);
			return;
		}

		IDialogSettings historySettings = getDialogSettings().getSection(HISTORY_SETTINGS);
		if(historySettings != null) {
			String[] uriHistory = historySettings.getArray(PREVIOUS_SELECTION);
			// for each element in the list, try to get the EObject by its URI
			if(uriHistory != null) {
				for(String uri : uriHistory) {
					try {
						EObject object = modelSet.getEObject(URI.createURI(uri), true);
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
	 */
	protected void createMetaclassFilter(Composite parent) {
		if(semanticRoot == null) {
			return;
		}

		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(2, false));
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		ResourceSet resourceSet = semanticRoot.eResource().getResourceSet();
		EcoreUtil.resolveAll(resourceSet);

		Label metamodelLabel = new Label(container, SWT.NONE);
		metamodelLabel.setText("Metamodel:");

		ComboViewer metamodelViewer = new ComboViewer(container);
		metamodelViewer.setContentProvider(getMetamodelContentProvider());
		metamodelViewer.setLabelProvider(new EMFObjectLabelProvider());
		metamodelViewer.setInput(semanticRoot);
		metamodelViewer.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		Label metaclassLabel = new Label(container, SWT.NONE);
		metaclassLabel.setText("Metaclass:");

		final ComboViewer metaclassViewer = new ComboViewer(container);
		IStructuredContentProvider metaclassProvider = getMetaclassContentProvider();
		metaclassViewer.setContentProvider(metaclassProvider);
		metaclassViewer.setLabelProvider(new EMFObjectLabelProvider());
		metaclassViewer.getCombo().setEnabled(false);
		metaclassViewer.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		metamodelViewer.setFilters(new ViewerFilter[]{ new MetamodelContentFilter(metaclassProvider) });

		metamodelViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				metaclassViewer.setInput(((IStructuredSelection)event.getSelection()).getFirstElement());
				metaclassViewer.getCombo().setEnabled(true);
			}
		});

		metaclassViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				if(!event.getSelection().isEmpty()) {
					Object selectedObject = ((IStructuredSelection)event.getSelection()).getFirstElement();
					List<ViewerFilter> filters = new LinkedList<ViewerFilter>(Arrays.asList(viewer.getFilters()));
					filters.remove(currentMetaclassViewerFilter);
					currentMetaclassViewerFilter = getMetaclassViewerFilter(selectedObject);
					filters.add(currentMetaclassViewerFilter);
					viewer.setFilters(filters.toArray(new ViewerFilter[filters.size()]));
					viewer.refresh();
				}
			}
		});
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

	protected IStructuredContentProvider getMetamodelContentProvider() {
		return new MetamodelContentProvider();
	}

	protected IStructuredContentProvider getMetaclassContentProvider() {
		return new MetaclassContentProvider((EClass)this.metaClassWanted, this.metaClassNotWantedList);
	}

	protected ILabelProvider getLabelProvider() {
		return new EMFObjectLabelProvider();
	}

	protected ViewerFilter getMetaclassViewerFilter(Object selectedMetaClass) {
		return new MetaclassViewerFilter(selectedMetaClass);
	}

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
	protected void storeDialog(IDialogSettings settings, EObject currentValue) {

		if(selectionHistory.contains(currentValue)) {
			selectionHistory.remove(currentValue);
		}

		selectionHistory.add(0, currentValue);

		//This should loop only once, unless the history was already oversized
		while(selectionHistory.size() > HISTORY_MAX_SIZE) {
			selectionHistory.remove(HISTORY_MAX_SIZE);
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
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		super.inputChanged(viewer, oldInput, newInput);
		if(this.viewer != null && newInput != null && this.viewer.getControl() != null && !this.viewer.getControl().isDisposed()) {
			this.viewer.setFilters(new ViewerFilter[]{ new HierarchicViewerFilter(this) });
			this.viewer.addSelectionChangedListener(this);
		}
	}

	public void selectionChanged(SelectionChangedEvent event) {
		selectedObject = ((IStructuredSelection)event.getSelection()).getFirstElement();
		selectedObject = getAdaptedValue(selectedObject);
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

	public void commit(AbstractEditor editor) {
		if(selectedObject instanceof EObject) {
			storeDialog(getDialogSettings(), (EObject)selectedObject);
		}
	}

	@Override
	public void dispose() {
		viewer.removeSelectionChangedListener(this);
		super.dispose();
	}
}
