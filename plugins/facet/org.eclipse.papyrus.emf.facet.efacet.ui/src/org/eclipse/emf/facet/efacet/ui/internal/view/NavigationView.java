/*******************************************************************************
 * Copyright (c) 2010, 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Bros (Mia-Software)
 *     Gregoire Dupe (Mia-Software) - Bug 364325 - [Restructuring] The user must be able to navigate into a model using the Facet.
 *     Vincent Lorenzo (CEA-LIST) -  Bug 372644 - Create Customizable tooltips for the TreeViewer using a CustomizableLabelProvider
 *     Gregoire Dupe (Mia-Software) - Bug 364325 - [Restructuring] The user must be able to navigate into a model using the Facet.
 *     Gregoire Dupe (Mia-Software) - Bug 373510 - EditingDomain, ResourceSet, Catalogs, etc. have to be properly managed between editors and views
 *     Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *     Gregoire Dupe (Mia-Software) - Bug 372626 - Aggregates
 *     Olivier Remaud (Soft-Maint) - Bug 377615 - Query View filtering
 *     Gregoire Dupe (Mia-Software) - Bug 378498 - Navigation view sometimes lacks an EditingDomain
 *     Nicolas Bros (Mia-Software) - Bug 379395 - Navigate should replace elements 
 *******************************************************************************/
package org.eclipse.emf.facet.efacet.ui.internal.view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.emf.facet.custom.core.ICustomizationManagerFactory;
import org.eclipse.emf.facet.custom.ui.ICustomizedLabelProviderFactory;
import org.eclipse.emf.facet.efacet.core.FacetUtils;
import org.eclipse.emf.facet.efacet.core.IFacetManager;
import org.eclipse.emf.facet.efacet.core.IFacetManagerFactory;
import org.eclipse.emf.facet.efacet.core.IFacetSetCatalogManager;
import org.eclipse.emf.facet.efacet.core.IFacetSetCatalogManagerFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementResult;
import org.eclipse.emf.facet.efacet.ui.IETypedElementResultDisplayer;
import org.eclipse.emf.facet.efacet.ui.IETypedElementResultDisplayerOpener;
import org.eclipse.emf.facet.efacet.ui.internal.Activator;
import org.eclipse.emf.facet.efacet.ui.internal.Messages;
import org.eclipse.emf.facet.efacet.ui.internal.exported.view.INavigationView;
import org.eclipse.emf.facet.efacet.ui.internal.exported.widget.IETypedElementSelectionWidget;
import org.eclipse.emf.facet.efacet.ui.internal.exported.widget.IETypedElementSelectionWidgetFactory;
import org.eclipse.emf.facet.efacet.ui.internal.view.DropAdapter.DropAction;
import org.eclipse.emf.facet.util.core.Logger;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.part.WorkbenchPart;

//Copied from org.eclipse.emf.facet.infra.query.ui.views.queryExecution.internal.QueryExecutionView
public class NavigationView extends ViewPart implements INavigationView {

	/**
	 * Execution button minimal width.
	 */
	private static final int EXEC_BT_MIN_WIDTH = 100;

	private TreeViewer contextViewer;
	private Composite mainComposite;
	private Composite parentComposite;

	private final Set<EObject> fContext = new HashSet<EObject>();
	private LayoutStyle layoutStyle = NavigationView.LayoutStyle.Horizontal;
	private IETypedElementSelectionWidget navSelection;
	private Combo comboDisplayer;
	private EditingDomain editingDomain = null;
	private ILabelProvider labelProvider;
	private final IContentProvider contextCP = new ITreeContentProvider() {

		public void inputChanged(final Viewer viewer, final Object oldInput,
				final Object newInput) {
			// nothing
		}

		public void dispose() {
			// nothing
		}

		public Object[] getElements(final Object inputElement) {
			Object[] result = new Object[0];
			if (inputElement instanceof Set<?>) {
				final Set<?> set = ((Set<?>) inputElement);
				if (set.isEmpty()) {
					result = new Object[] { Messages.QueryExecutionView_dragAndDropHint };
				} else {
					result = set.toArray();
				}
			}
			return result;
		}

		public boolean hasChildren(final Object element) {
			return false;
		}

		public Object getParent(final Object element) {
			return null;
		}

		public Object[] getChildren(final Object parentElement) {
			return new Object[]{};
		}
	};
	
	private enum LayoutStyle {
		Horizontal, Vertical
	}

	public NavigationView() {
		super();
		updateEditingDomain();
	}

	@Override
	public void createPartControl(final Composite parent) {
		this.parentComposite = parent;
		parent.setLayout(gridLayoutWithNoMargins());
		this.layoutStyle = NavigationView.LayoutStyle.Horizontal;
		createMainComposite();
		parent.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(final ControlEvent event) {
				NavigationView.this.controlResized(parent);
			}
		});
		createContextMenu();
	}

	public void controlResized(final Composite parent) {
		final LayoutStyle oldLayoutStyle = NavigationView.this.layoutStyle;
		final Point size = parent.getSize();
		if (size.x > size.y) {
			this.layoutStyle = NavigationView.LayoutStyle.Horizontal;
		} else {
			this.layoutStyle = NavigationView.LayoutStyle.Vertical;
		}
		if (this.layoutStyle != oldLayoutStyle) {
			createMainComposite();
		}
	}

	protected static void createContextMenu() {
		final MenuManager contextMenu = new MenuManager("#PopUp"); //$NON-NLS-1$
		contextMenu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void createMainComposite() {
		if (this.mainComposite != null) {
			this.mainComposite.dispose();
		}
		this.mainComposite = new Composite(this.parentComposite, SWT.NONE);
		this.mainComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		this.mainComposite.setLayout(gridLayoutWithNoMargins());

		int direction;
		if (this.layoutStyle == NavigationView.LayoutStyle.Horizontal) {
			direction = SWT.HORIZONTAL;
		} else {
			direction = SWT.VERTICAL;
		}

		final SashForm sashForm = new SashForm(this.mainComposite, SWT.SMOOTH
				| direction);
		sashForm.setLayout(new FillLayout());
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		createContextGroup(sashForm);
		// createQueryGroup(sashForm);
		final Composite lastGroup = new Composite(sashForm, SWT.NONE);
		createQueryGroup(lastGroup);
		lastGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		GridLayout gridLayout;
		if (this.layoutStyle == NavigationView.LayoutStyle.Horizontal) {
			gridLayout = new GridLayout(2, false);
		} else {
			gridLayout = new GridLayout();
		}
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		lastGroup.setLayout(gridLayout);
		// TODO: implement parameters (hidden in the meantime)
		// /!\ when it is added back, put the QueryGroup back in the sashForm
		// instead of lastGroup
		// createParametersGroup(lastGroup);
		createExecuteGroup(lastGroup);
	}

	private static GridLayout gridLayoutWithNoMargins() {
		final GridLayout gridLayout = new GridLayout();
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		return gridLayout;
	}

	private void createQueryGroup(final Composite parent) {
		final Group queryGroup = new Group(parent, SWT.NONE);
		queryGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		queryGroup.setText(Messages.QueryExecutionView_ETypedElementsGroup);
		final GridLayout groupLayout = new GridLayout();
		queryGroup.setLayout(groupLayout);
		final Collection<ETypedElement> eTypedElements = new ArrayList<ETypedElement>(
				FacetUtils.getETypedElements(getResourceSet()));
		final Collection<? extends EObject> knownEPackages = IFacetSetCatalogManagerFactory.DEFAULT
				.getOrCreateFacetSetCatalogManager(this.getResourceSet())
				.getRegisteredFacetSets();
		this.navSelection = IETypedElementSelectionWidgetFactory.DEFAULT
				.createETypedElementSelectionWidget(
						1,
						false,
						queryGroup,
						getCustomizationManager(),
						knownEPackages);
		this.navSelection.setAvailableETypedElements(eTypedElements);
	}

	private void createContextGroup(final Composite parent) {
		final Group contextGroup = new Group(parent, SWT.NONE);
		contextGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		contextGroup.setText(Messages.QueryExecutionView_Context);
		final GridLayout groupLayout = new GridLayout();
		contextGroup.setLayout(groupLayout);
		createContextViewer(contextGroup);
	}

	private void createContextViewer(final Group contextGroup) {
		this.contextViewer = new TreeViewer(contextGroup, SWT.MULTI | SWT.BORDER);
		final GridData listData = new GridData(SWT.FILL, SWT.FILL, true, true);
		this.contextViewer.getTree().setLayoutData(listData);
		addDropSupport(this.contextViewer);
		createContextMenu(this.contextViewer);
		this.contextViewer.setContentProvider(this.contextCP);
		changeEditingDomain(this.editingDomain);
		this.contextViewer.setLabelProvider(this.labelProvider);
		this.contextViewer.setInput(this.fContext);
		this.contextViewer.setComparator(new ViewerComparator() {
			@Override
			public int compare(final Viewer viewer, final Object object1,
					final Object object2) {
				return NavigationView.this.compare(object1, object2);
			}
		});
	}

	protected int compare(final Object object1, final Object object2) {
		final String label1 = this.labelProvider.getText(object1);
		final String label2 = this.labelProvider.getText(object2);
		return label1.compareToIgnoreCase(label2);
	}
	
	private EditableContext createEditableContext() {
		return new EditableContext() {
			public void add(final EObject eObject) {
				NavigationView.this.dropEObject(eObject);
			}

			public void remove(final EObject eObject) {
				NavigationView.this.removeEObject(eObject);
			}

			public void clear() {
				NavigationView.this.removeAllEObjects();
			}

			public void done() {
				NavigationView.this.refreshContextViewer();
			}
		};
	}

	protected void dropEObject(final EObject eObject) {
		this.fContext.add(eObject);
	}

	/** Create a context menu on the context pane */
	private void createContextMenu(final TreeViewer treeViewer) {
		final ContextPaneMenuManager menuManager = new ContextPaneMenuManager(this,
				createEditableContext(), treeViewer);
		final Menu menu = menuManager.createContextMenu(treeViewer.getTree());
		treeViewer.getTree().setMenu(menu);
	}

	private void addDropSupport(final TreeViewer viewer) {
		final DropTargetListener dropListener = new DropAdapter(
				new DropAction() {
			@Override
			public void dropped(final Set<EObject> eObjects) {
				addEObjects(eObjects);
			}
		});
		final int dndOperations = DND.DROP_LINK | DND.DROP_COPY | DND.DROP_MOVE;
		final Transfer[] transfers = new Transfer[] { LocalTransfer
				.getInstance() };
		viewer.addDropSupport(dndOperations, transfers, dropListener);
	}

	protected final void refreshContextViewer() {
		if (this.contextViewer != null) {
			this.contextViewer.refresh();
			final Set<EObject> toBeRemoved = new HashSet<EObject>();
			for (EObject eObject : this.fContext) {
				if (eObject.eResource().getResourceSet() != getResourceSet()) {
					toBeRemoved.add(eObject);
				}
			}
			this.fContext.remove(toBeRemoved);
			this.contextViewer.setInput(this.fContext);
			this.contextViewer.setLabelProvider(this.labelProvider);
			updateQueriesInput();
		}
	}

	private void updateQueriesInput() {
		final Collection<ETypedElement> result = new ArrayList<ETypedElement>();
		final ResourceSet resourceSet = this.editingDomain.getResourceSet();
		final IFacetSetCatalogManager catalog = IFacetSetCatalogManagerFactory.DEFAULT
				.getOrCreateFacetSetCatalogManager(resourceSet);
		final Collection<FacetSet> registeredFS = catalog
				.getRegisteredFacetSets();
		for (FacetSet facetSet : registeredFS) {
			result.addAll(getETypedElements(facetSet));
		}
		this.navSelection.setAvailableETypedElements(result);
	}

	private Collection<? extends ETypedElement> getETypedElements(
			final FacetSet facetSet) {
		final Collection<ETypedElement> result = new ArrayList<ETypedElement>();
		for (EClassifier eClassifier : facetSet.getEClassifiers()) {
			if (eClassifier instanceof Facet) {
				final Facet facet = (Facet) eClassifier;
				if (isApplicableFacet(facet)) {
					result.addAll(facet.getFacetElements());
					result.addAll(facet.getFacetOperations());
				}
			}
		}
		for (FacetSet subFacetSet : facetSet.getFacetSets()) {
			result.addAll(getETypedElements(subFacetSet));
		}
		for (EPackage subPackage : facetSet.getESubpackages()) {
			if (subPackage instanceof FacetSet) {
				final FacetSet subFacetSet = (FacetSet) subPackage;
				result.addAll(getETypedElements(subFacetSet));
			}
		}
		return result;
	}

	private void createExecuteGroup(final Composite parent) {
		final Group executeGroup = new Group(parent, SWT.NONE);
		executeGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		executeGroup.setText(Messages.QueryExecutionView_ExecuteGroup);
		executeGroup.setLayout(new GridLayout());
		createDisplayStyleComposite(executeGroup);
		final Button buttonExecute = new Button(executeGroup, SWT.PUSH);
		buttonExecute.setText(Messages.QueryExecutionView_ExecuteButton);
		final GridData buttonData = new GridData(SWT.CENTER, SWT.NONE, true,
				false);
		buttonData.minimumWidth = NavigationView.EXEC_BT_MIN_WIDTH;
		buttonExecute.setLayoutData(buttonData);
		buttonExecute.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent event) {
				executeClicked();
			}
		});
	}

	protected void executeClicked() {
		final ETypedElement selectedQuery = getSelectedQuery();
		if (selectedQuery == null) {
			MessageDialog.openInformation(getSite().getShell(),
					Messages.QueryExecutionView_NoQuerySelected,
					Messages.QueryExecutionView_SelectQueryToExecute);
		} else {
			try {
				final IFacetManager facetMgr = IFacetManagerFactory.DEFAULT
						.getOrCreateFacetManager(getResourceSet());
				final List<ETypedElementResult> results = facetMgr
						.batchGetOrInvoke(this.fContext, selectedQuery,
								Object.class);
				if (checkResult(results)) {
					displayResult(results);
				}
			} catch (final Exception e) {
				final StackTraceElement[] stackTrace = e.getStackTrace();
				String stack = ""; //$NON-NLS-1$
				if (stackTrace.length > 0) {
					stack = "\nat:" + stackTrace[0].toString(); //$NON-NLS-1$
				}
				String message;
				if (e.getMessage() == null) {
					message = ""; //$NON-NLS-1$
				} else {
					message = " : " + e.getMessage(); //$NON-NLS-1$
				}
				MessageDialog.openError(getSite().getShell(),
						Messages.QueryExecutionView_ErrorExecutingQuery, e.getClass()
								.getSimpleName() + message + stack);
				Logger.logError(e, Activator.getDefault());
			}
		}
	}

	private boolean checkResult(final List<ETypedElementResult> results) {
		boolean result = true;
		for (ETypedElementResult modelQueryResult : results) {
			final Throwable exc = modelQueryResult.getException();
			if (exc != null) {
				Logger.logError(exc, "Query exception", Activator.getDefault()); //$NON-NLS-1$
				MessageDialog.openError(this.mainComposite.getShell(),
						Messages.QueryExecutionView_QueryException, exc.getClass().getSimpleName()
								+ " : " + exc.getMessage()); //$NON-NLS-1$
				result = false;
				break;
			}
		}
		return result;
	}

	private void displayResult(final List<ETypedElementResult> result) {
		final String displayerName = this.comboDisplayer.getText();
		final IETypedElementResultDisplayer displayer = QueryResultDisplayersRegistry
				.getInstance().getQueryResultDisplayer(displayerName);
		if (displayer == null) {
			final String message = NLS
					.bind("Query Displayer with name \"{0}\" not found", displayerName); //$NON-NLS-1$
			Logger.logError(message, Activator.getDefault());
			MessageDialog.openWarning(getSite().getShell(),
					Messages.QueryExecutionView_NoQueryDisplayer, message);
		} else {
			displayer.displayETypedElementResults(result, this.editingDomain);
		}
	}

	private ETypedElement getSelectedQuery() {
		final ETypedElement selectedQuery = this.navSelection
				.getSelectedETypedElements().get(0);
		return selectedQuery;
	}

	private void createDisplayStyleComposite(final Group executeGroup) {
		final Composite displayStyle = new Composite(executeGroup,
				SWT.NONE);
		displayStyle.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));
		displayStyle.setLayout(new GridLayout(2, false));
		final Label label = new Label(displayStyle, SWT.NONE);
		label.setText(Messages.QueryExecutionView_DisplayResultIn);
		this.comboDisplayer = new Combo(displayStyle, SWT.DROP_DOWN | SWT.READ_ONLY);

		final List<IETypedElementResultDisplayer> resultDisplayers = QueryResultDisplayersRegistry
				.getInstance().getQueryResultDisplayers();
		for (IETypedElementResultDisplayer namedQueryResultDisplayer : resultDisplayers) {
			this.comboDisplayer.add(namedQueryResultDisplayer.getName());
		}

		this.comboDisplayer.select(0);
		this.comboDisplayer.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));
	}

	@Override
	public void setFocus() {
		updateEditingDomain();
		this.refreshContextViewer();
	}

	private void updateEditingDomain() {
		final IWorkbenchPage activePage = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		if (activePage != null) {
			final IWorkbenchPart part = activePage.getActivePart();
			if (part instanceof IEditingDomainProvider) {
				final IEditingDomainProvider edProvider = (IEditingDomainProvider) part;
				final EditingDomain newEditingDomain = edProvider
						.getEditingDomain();
				if ((this.editingDomain != newEditingDomain)
						|| (this.editingDomain == null)) {
					changeEditingDomain(newEditingDomain);
				}
			}
		}
	}

	private void changeEditingDomain(final EditingDomain newEditingDomain) {
		this.editingDomain = newEditingDomain;
		if (this.editingDomain == null) {
			final ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
					ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
			final BasicCommandStack commandStack = new BasicCommandStack();
			this.editingDomain = new AdapterFactoryEditingDomain(
					adapterFactory, commandStack,
					new HashMap<Resource, Boolean>());
		}
		final ICustomizationManager customMgr = ICustomizationManagerFactory.DEFAULT
				.getOrCreateICustomizationManager(this.editingDomain
						.getResourceSet());
		this.labelProvider = ICustomizedLabelProviderFactory.DEFAULT
				.createCustomizedLabelProvider(customMgr);
	}

	public void setContext(final List<EObject> selectedEObjects) {
		this.fContext.clear();
		this.fContext.addAll(selectedEObjects);
		refreshContextViewer();
	}

	public void setSelectedQueries(final List<ETypedElement> queries) {
		this.navSelection.setSelectedETypedElements(queries);
	}

	public ContextInfo getContextInfo() {
		final ContextInfo contextInfo = new ContextInfo(
				new ArrayList<EObject>(this.fContext));
		final ISelection selection = this.contextViewer.getSelection();
		if (selection instanceof IStructuredSelection) {
			final IStructuredSelection structSelection = (IStructuredSelection) selection;
			final Iterator<?> iterator = structSelection.iterator();
			while (iterator.hasNext()) {
				final Object selectedElement = iterator.next();
				if (selectedElement instanceof EObject) {
					final EObject eObject = (EObject) selectedElement;
					contextInfo.addSelectedEObject(eObject);
				}
			}
		}
		return contextInfo;
	}

	public final class ContextInfo {
		private final List<EObject> eObjects;
		private final List<EObject> selectedEObjects = new ArrayList<EObject>();

		public ContextInfo(final List<EObject> eObjects) {
			this.eObjects = eObjects;
		}

		public List<EObject> getEObjects() {
			return this.eObjects;
		}

		public void addSelectedEObject(final EObject eObject) {
			this.selectedEObjects.add(eObject);
		}

		public List<EObject> getSelectedEObjects() {
			return this.selectedEObjects;
		}

	}

	public void addEObjects(final Collection<? extends EObject> eObjects) {
		updateEditingDomain();
		for (EObject eObject : eObjects) {
			final ResourceSet eObjectRS = eObject.eResource().getResourceSet();
			final ResourceSet currentRS = getResourceSet();
			if (!eObjectRS.equals(currentRS)) {
				throw new IllegalStateException("Invalid resourceSet"); //$NON-NLS-1$
			}
		}
		this.fContext.addAll(eObjects);
		refreshContextViewer();
	}

	public void removeEObject(final EObject eObject) {
		this.fContext.remove(eObject);
	}

	public void removeEObjects(final List<? extends EObject> eObjects) {
		this.fContext.removeAll(eObjects);
	}

	public void removeAllEObjects() {
		this.fContext.clear();
	}

	public List<EClassifier> getUsableEClassifiers() {
		// TODO Auto-generated method stub
		return null;
	}

	public void selectETypedElement(final ETypedElement eTypedElement) {
		// TODO Auto-generated method stub
		
	}

	public ETypedElement getSelectedETypedElement() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<IETypedElementResultDisplayerOpener> getAvailableSelectedDisplayers() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setSelectDisplayer(final IETypedElementResultDisplayerOpener resultDisplayer) {
		// TODO Auto-generated method stub
		
	}

	public IETypedElementResultDisplayerOpener getSelectedDisplayer() {
		// TODO Auto-generated method stub
		return null;
	}

	public WorkbenchPart preform() {
		// TODO Auto-generated method stub
		return null;
	}

	private ResourceSet getResourceSet() {
		return this.editingDomain.getResourceSet();
	}

	private ICustomizationManager getCustomizationManager() {
		return ICustomizationManagerFactory.DEFAULT
				.getOrCreateICustomizationManager(getResourceSet());
	}

	private boolean isApplicableFacet(final Facet facet) {
		final EClass eobjectClass = EcorePackage.eINSTANCE.getEObject();
		boolean result = false;
		for (final EObject object : this.fContext) {
			if 	(facet.getExtendedMetaclass() == null 
					|| facet.getExtendedMetaclass() == eobjectClass
					|| facet.getExtendedMetaclass().isSuperTypeOf(object.eClass())
				) {
				result = true;
				break;
			}
		}
		return result;
	}
	
}
