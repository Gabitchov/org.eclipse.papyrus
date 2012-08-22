/*******************************************************************************
 * Copyright (c) 2010, 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - Bug 331203 - table model editor - initial API and implementation
 *    Nicolas Guyomar (Mia-Software) - Bug 331442 - To be able to add and remove lines (model elements) from the table
 *    Nicolas Bros (Mia-Software) - Bug 332226 - To be able to create or delete model element from the table
 *    Nicolas Guyomar (Mia-Software) - Bug 332226 - To be able to create or delete model element from the table
 *    Nicolas Bros (Mia-Software) - Bug 331900 - customizable NatTable
 *    Nicolas Guyomar (Mia-Software) - Bug 332924 - To be able to save the table
 *    Nicolas Guyomar (Mia-Software) - Bug 332998 - To be able to add a column and fill it with the result of a query
 *    Gregoire Dupe (Mia-Software) - Bug 332998 - To be able to add a column and fill it with the result of a query
 *    Nicolas Guyomar (Mia-Software) - Bug 333015 - To be able to hide columns
 *    Nicolas Guyomar (Mia-Software) - Bug 333029 - To be able to save the size of the lines and the columns
 *    Nicolas Guyomar (Mia-Software) - Bug 335154 - Sort Column By Type : Cannot modify resource set without a write transaction
 *    Nicolas Guyomar (Mia-Software) - Bug 335020 - Nattable widget should use the Eclipse framework
 *******************************************************************************/
package org.eclipse.papyrus.infra.table.efacet.common.editor;

import java.util.EventObject;
import java.util.HashMap;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Table;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.ITableWidget;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.ITableWidgetFactory;
import org.eclipse.emf.facet.widgets.table.ui.internal.exported.ITableWidgetProvider;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.table.efacet.common.input.PapyrusTableEditorInput;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;
import org.eclipse.papyrus.infra.widgets.editors.StringLabel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.uml2.uml.util.UMLUtil;

//TODO : remove the dependency on UML
/**
 * Comes from org.eclipse.emf.facet.widget.nattable.workbench.
 * 
 * This class should not be used by others plugins TODO Should be deleted or
 * merge with an other classe
 */
public class NatTableEditor2 extends EditorPart implements ISelectionProvider, IEditingDomainProvider {// , IWorkbenchPartProvider { //TODO this

	// interface should be useful...

	public static final String ID = "org.eclipse.emf.facet.widgets.nattable.workbench.editor.NatTableEditor"; //$NON-NLS-1$

	private PapyrusTableEditorInput tableEditorInput;

	protected ITableWidget natTableWidget;

	private EditingDomain editingDomain;

	private MenuManager menuMgr;

	private StringLabel contextLabel;

	private final CommandStackListener commandListener = new CommandStackListener() {

		public void commandStackChanged(final EventObject event) {
			Display.getCurrent().asyncExec(new Runnable() {

				public void run() {
					firePropertyChange(PROP_DIRTY);
				}
			});
		}
	};

	/**
	 * we listen the context to refresh it in the table if the context change
	 */
	private final Adapter contextListener = new AdapterImpl() {

		/**
		 * 
		 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
		 * 
		 * @param notification
		 */
		@Override
		public void notifyChanged(final Notification notification) {
			NatTableEditor2.this.contextLabel.refreshValue();
			super.notifyChanged(notification);
		}
	};

	@SuppressWarnings("rawtypes")
	// We cannot change the method signature because of the override
	@Override
	public Object getAdapter(final Class adapter) {
		if(adapter == ITableWidgetProvider.class) {
			return new ITableWidgetProvider() {

				public ITableWidget getTableWidget() {
					return NatTableEditor2.this.natTableWidget;
				}
			};
		}
		if(adapter == PapyrusTable.class) {
			return this.natTableWidget.getTable().eContainer();
		} else if(adapter == Table.class) {
			return this.natTableWidget.getTable();
		}
		return null;
	}

	@Override
	public void init(final IEditorSite site, final IEditorInput input) throws PartInitException {
		if(input instanceof PapyrusTableEditorInput) {
			this.tableEditorInput = (PapyrusTableEditorInput)input;
			this.editingDomain = this.tableEditorInput.getEditingDomain();
			initializeEditingDomain();
			setSite(site);
			setInput(this.tableEditorInput);
			setPartName(this.tableEditorInput.getName());
		} else if(input instanceof FileEditorInput) {
			initializeEditingDomain();
			final FileEditorInput fileEditorInput = (FileEditorInput)input;
			final URI uri = URI.createPlatformResourceURI(fileEditorInput.getFile().getFullPath().toString(), false);
			if(uri != null) {
				Resource resource = null;
				if(getEditingDomain() != null) {
					resource = getEditingDomain().loadResource(uri.toString());
				} else {
					final ResourceSet rSet = new ResourceSetImpl();
					resource = rSet.createResource(uri);
				}
				PapyrusTable tableInstance = null;
				for(final EObject eObject : resource.getContents()) {
					if(eObject instanceof PapyrusTable) {
						tableInstance = (PapyrusTable)eObject;
						// One instance of tableInstance per .table file
						break;
					}
				}
				this.tableEditorInput = new PapyrusTableEditorInput(tableInstance, getEditingDomain());
				setSite(site);
				setInput(this.tableEditorInput);
				setPartName(fileEditorInput.getName());
			}

		} else {
			throw new PartInitException("Input should be of type TableEditorInput or a .table file"); //$NON-NLS-1$
		}
	}

	/**
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(final Composite parent) {
		this.menuMgr = new MenuManager("#PopUp", NatTableEditor2.ID); //$NON-NLS-1$
		this.menuMgr.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		this.menuMgr.setRemoveAllWhenShown(true);

		final Composite editorComposite = createCompositeCompositeWthTableBorder(parent);
		// createFirstLine(editorComposite);
		// createDescription(editorComposite);

		// the composite owning the table
		final Composite tableComposite = new Composite(editorComposite, SWT.NONE);
		final GridLayout tableCompositeGridLayout = new GridLayout(1, true);
		tableComposite.setLayout(tableCompositeGridLayout);

		final GridData compositeTableGridLayout = new GridData();
		compositeTableGridLayout.grabExcessHorizontalSpace = true;
		compositeTableGridLayout.grabExcessVerticalSpace = true;
		compositeTableGridLayout.horizontalAlignment = SWT.FILL;
		compositeTableGridLayout.verticalAlignment = SWT.FILL;
		tableComposite.setLayoutData(compositeTableGridLayout);

		this.natTableWidget = createNattableWidget(tableComposite, this, this.tableEditorInput.getPapyrusTable().getTable(), this.menuMgr);

		getSite().setSelectionProvider(this);
		getSite().registerContextMenu(this.menuMgr, this.natTableWidget);
	}

	private ITableWidget createNattableWidget(final Composite tableComposite, final NatTableEditor2 natTableEditor, final Table table, final MenuManager menuMgr2) {
		// the nattable widget itself
		// old instanciation
		// this.natTableWidget =
		// INatTableWidgetFactory.INSTANCE.createNatTableWidget(tableComposite,
		// this, this.tableEditorInput.getPapyrusTableInstance().getTable(),
		// this.menuMgr);
		this.natTableWidget = ITableWidgetFactory.INSTANCE.createTableWidget(tableComposite, this, table, this.menuMgr);
		// new PapyrusNatTableWidget(tableComposite, natTableEditor, table,
		// this.menuMgr);
		final GridData tableGridData = new GridData();
		tableGridData.grabExcessHorizontalSpace = true;
		tableGridData.grabExcessVerticalSpace = true;
		tableGridData.horizontalAlignment = SWT.FILL;
		tableGridData.verticalAlignment = SWT.FILL;
		this.natTableWidget.getComposite().setLayoutData(tableGridData);
		return this.natTableWidget;
	}

	private Composite createCompositeCompositeWthTableBorder(final Composite parent) {
		final Composite editorComposite = new Composite(parent, SWT.BORDER);
		final GridLayout editorGridLayout = new GridLayout(1, true);
		editorGridLayout.marginHeight = 0;
		editorGridLayout.marginWidth = 0;

		final GridData data = new GridData();
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = SWT.FILL;
		editorComposite.setLayoutData(data);
		editorComposite.setLayout(editorGridLayout);
		return editorComposite;
	}

	// /**
	// *
	// * @param parent
	// * the parent composite
	// */
	// protected void createFirstLine(final Composite parent) {
	//
	// final Table table = this.tableEditorInput.getPapyrusTable().getTable();
	// Composite firstLineComposite = new Composite(parent, SWT.NONE);
	// final GridLayout smallGridLayout = new GridLayout(2, true);
	// smallGridLayout.marginHeight = 0;
	// smallGridLayout.marginWidth = 0;
	// smallGridLayout.marginLeft = 0;
	// smallGridLayout.marginRight = 0;
	//
	// firstLineComposite.setLayout(smallGridLayout);
	// GridData lineData = new GridData();
	// lineData.horizontalSpan = 1;
	// lineData.horizontalAlignment = SWT.FILL;
	// firstLineComposite.setLayoutData(lineData);
	//
	// //we display the context of the table
	// this.contextLabel = new StringLabel(firstLineComposite, SWT.LEFT);
	// this.contextLabel.setLabel(Messages.NatTableEditor_TableContextLabel);
	// this.contextLabel.setToolTipText(Messages.NatTableEditor_TableContextTollTip);
	//
	// //we observe the feature context of the table (and not the name of the
	// context, because the context is not a NamedElement, but an EObject
	// final IObservableValue contextObservable = new
	// EObjectObservableValue(table,
	// TableinstancePackage.eINSTANCE.getTableInstance_Context());
	// table.getContext().eAdapters().add(this.contextListener);
	// /*
	// * we should set the converted before the observable!
	// */
	// this.contextLabel.setConverters(null, new ContextLabelConverter());
	// this.contextLabel.setLabelProvider(new UMLLabelProvider());
	// this.contextLabel.setModelObservable(contextObservable);
	//
	// //set the layout for contextLabel
	// GridData contextGridData = new GridData();
	// contextGridData.grabExcessHorizontalSpace = true;
	// contextGridData.horizontalAlignment = SWT.FILL;
	// contextGridData.horizontalSpan = 1;
	// this.contextLabel.setLayoutData(contextGridData);
	//
	// BooleanRadio checkbox = new BooleanRadio(firstLineComposite, SWT.NONE,
	// "IsSynchronized :");
	// checkbox.setToolTipText("Indicates if the table is synchronized with queries");
	// final IObservableValue isSynchronizedObservable = new
	// EMFObservableValue(this.tableEditorInput.getPapyrusTable(),
	// PapyrustableinstancePackage.eINSTANCE.getPapyrusTableInstance_IsSynchronized(),
	// getEditingDomain());
	// checkbox.setModelObservable(isSynchronizedObservable);
	//
	// GridData checkboxGridData = new GridData();
	// checkboxGridData.grabExcessHorizontalSpace = true;
	// checkboxGridData.horizontalAlignment = SWT.FILL;
	// checkbox.setLayoutData(checkboxGridData);
	//
	// }

	// protected void createDescription(final Composite parent) {
	// final TableInstance table =
	// this.tableEditorInput.getPapyrusTableInstance().getTable();
	// EClass tableEClass = table.eClass();
	//
	// //we display the description of the table
	// final StringEditor descriptionEditor = new StringEditor(parent,
	// SWT.MULTI);
	// descriptionEditor.setLabel(Messages.NatTableEditor_TaleDescriptionLabel);
	// descriptionEditor.setToolTipText(Messages.NatTableEditor_TableDescriptionToolTip);
	//
	//
	// EStructuralFeature myFeature =
	// tableEClass.getEStructuralFeature(TableinstancePackage.TABLE_INSTANCE__DESCRIPTION);
	// EMFObservableValue observable = new EMFObservableValue(table, myFeature,
	// getEditingDomain());
	// descriptionEditor.setModelObservable(observable);
	//
	// //set the layout for the description editor
	// GridData descriptionGridData = new GridData();
	// descriptionGridData.grabExcessHorizontalSpace = true;
	// descriptionGridData.horizontalAlignment = SWT.FILL;
	// descriptionEditor.setLayoutData(descriptionGridData);
	// }

	@Override
	public void dispose() {
		if(this.natTableWidget.getTable().getContext() != null) {// can be null
																	// when we
																	// are
																	// destroying
																	// the
																	// context
																	// (and the
																	// table!)
			this.natTableWidget.getTable().getContext().eAdapters().remove(this.contextListener);
		}
		super.dispose();
	}

	@Override
	public void setFocus() {
		this.natTableWidget.getComposite().setFocus();
	}

	@Override
	public boolean isDirty() {
		return ((BasicCommandStack)this.editingDomain.getCommandStack()).isSaveNeeded();
	}

	@Override
	public boolean isSaveAsAllowed() {
		return true;
	}

	@Override
	public void doSave(final IProgressMonitor monitor) {
		this.natTableWidget.save();
		firePropertyChange(PROP_DIRTY);
	}

	@Override
	public void doSaveAs() {
		this.natTableWidget.saveAs();
		firePropertyChange(PROP_DIRTY);
	}

	public void addSelectionChangedListener(final ISelectionChangedListener listener) {
		this.natTableWidget.addSelectionChangedListener(listener);
	}

	public ISelection getSelection() {
		/*
		 * if nattable has the focus : we retun the nattable selection if not,
		 * we return the papyrus table instance
		 */
		// TODO
		// Control[] children = ((Composite)this.natTableWidget).getChildren();
		// if(children.length != 0) {
		// boolean focus = children[0].isFocusControl();
		// if(focus) {
		// return this.natTableWidget.getSelection();
		// }
		// }
		int i = 0;
		i++;
		final ISelection tableSelection = this.natTableWidget.getSelection();
		if(tableSelection.isEmpty()) {
			return new StructuredSelection(this.tableEditorInput.getPapyrusTable());
		}
		return tableSelection;
	}

	public EditingDomain getEditingDomain() {
		return this.editingDomain;
	}

	public void removeSelectionChangedListener(final ISelectionChangedListener listener) {
		this.natTableWidget.removeSelectionChangedListener(listener);
	}

	public void setSelection(final ISelection selection) {
		this.natTableWidget.setSelection(selection);
	}

	/**
	 * This sets up the editing domain for the model editor
	 */
	protected void initializeEditingDomain() {
		if(this.editingDomain == null) {
			final ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
			final BasicCommandStack commandStack = new BasicCommandStack();
			this.editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, new HashMap<Resource, Boolean>());
		}
		this.editingDomain.getCommandStack().removeCommandStackListener(this.commandListener);
		this.editingDomain.getCommandStack().addCommandStackListener(this.commandListener);
	}

	public IWorkbenchPart getPart() {
		return this;
	}

	/**
	 * This ocnverter is used by the LabelEditor (used to display the context)
	 * 
	 * 
	 * 
	 */
	private class ContextLabelConverter implements IConverter {

		/**
		 * 
		 * @see org.eclipse.core.databinding.conversion.IConverter#getToType()
		 * 
		 * @return
		 */
		public Object getToType() {
			return String.class;
		}

		/**
		 * 
		 * @see org.eclipse.core.databinding.conversion.IConverter#getFromType()
		 * 
		 * @return
		 */
		public Object getFromType() {
			return Object.class;
		}

		/**
		 * 
		 * @see org.eclipse.core.databinding.conversion.IConverter#convert(java.lang.Object)
		 * 
		 * @param fromObject
		 * @return
		 */
		public Object convert(final Object fromObject) {
			if(fromObject instanceof EObject) {
				return UMLUtil.getQualifiedText((EObject)fromObject);
			}
			return ""; //$NON-NLS-1$
		}
	}
}
