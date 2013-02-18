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
package org.eclipse.papyrus.infra.table.common.internal;

import java.util.EventObject;
import java.util.HashMap;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.databinding.EObjectObservableValue;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.facet.widgets.nattable.INatTableWidget;
import org.eclipse.emf.facet.widgets.nattable.INatTableWidgetProvider;
import org.eclipse.emf.facet.widgets.nattable.IWorkbenchPartProvider;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableinstancePackage;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance2.TableInstance2;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.emf.databinding.EMFObservableValue;
import org.eclipse.papyrus.infra.table.common.messages.Messages;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrustableinstancePackage;
import org.eclipse.papyrus.infra.widgets.editors.BooleanRadio;
import org.eclipse.papyrus.infra.widgets.editors.StringEditor;
import org.eclipse.papyrus.infra.widgets.editors.StringLabel;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Comes from org.eclipse.emf.facet.widget.nattable.workbench.
 * 
 * This class should not be used by others plugins
 * TODO Should be deleted or merge with an other classe
 */
public class NatTableEditor extends EditorPart implements ISelectionProvider, IEditingDomainProvider, IWorkbenchPartProvider {

	public static final String ID = "org.eclipse.emf.facet.widgets.nattable.workbench.editor.NatTableEditor"; //$NON-NLS-1$

	private TableEditorInput tableEditorInput;

	protected INatTableWidget natTableWidget;

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
			NatTableEditor.this.contextLabel.refreshValue();
			super.notifyChanged(notification);
		}
	};

	@SuppressWarnings("rawtypes")
	// We cannot change the method signature because of the override
	@Override
	public Object getAdapter(final Class adapter) {
		if(adapter == INatTableWidgetProvider.class) {
			return new INatTableWidgetProvider() {

				public INatTableWidget getNatTableWidget() {
					return NatTableEditor.this.natTableWidget;
				}
			};
		}
		if(adapter == PapyrusTableInstance.class) {
			return this.tableEditorInput.getPapyrusTableInstance();
		}
		return null;
	}

	@Override
	public void init(final IEditorSite site, final IEditorInput input) throws PartInitException {
		if(input instanceof TableEditorInput) {
			this.tableEditorInput = (TableEditorInput)input;
			this.editingDomain = this.tableEditorInput.getEditingDomain();
			initializeEditingDomain();
			setSite(site);
			setInput(this.tableEditorInput);
			setPartName(this.tableEditorInput.getName());
		} else if(input instanceof FileEditorInput) {
			initializeEditingDomain();
			FileEditorInput fileEditorInput = (FileEditorInput)input;
			URI uri = URI.createPlatformResourceURI(fileEditorInput.getFile().getFullPath().toString(), false);
			if(uri != null) {
				Resource resource = null;
				if(getEditingDomain() != null) {
					resource = getEditingDomain().loadResource(uri.toString());
				} else {
					ResourceSet rSet = new ResourceSetImpl();
					resource = rSet.createResource(uri);
				}
				PapyrusTableInstance tableInstance = null;
				for(EObject eObject : resource.getContents()) {
					if(eObject instanceof PapyrusTableInstance) {
						tableInstance = (PapyrusTableInstance)eObject;
						// One instance of tableInstance per .table file
						break;
					}
				}
				this.tableEditorInput = new TableEditorInput(tableInstance, getEditingDomain());
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
		this.menuMgr = new MenuManager("#PopUp", NatTableEditor.ID); //$NON-NLS-1$
		this.menuMgr.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		this.menuMgr.setRemoveAllWhenShown(true);

		final Composite editorComposite = createCompositeCompositeWthTableBorder(parent);
		//		createFirstLine(editorComposite);
		//		createDescription(editorComposite);

		// the composite owning the table
		final Composite tableComposite = new Composite(editorComposite, SWT.NONE);
		GridLayout tableCompositeGridLayout = new GridLayout(1, true);
		tableComposite.setLayout(tableCompositeGridLayout);

		final GridData compositeTableGridLayout = new GridData();
		compositeTableGridLayout.grabExcessHorizontalSpace = true;
		compositeTableGridLayout.grabExcessVerticalSpace = true;
		compositeTableGridLayout.horizontalAlignment = SWT.FILL;
		compositeTableGridLayout.verticalAlignment = SWT.FILL;
		tableComposite.setLayoutData(compositeTableGridLayout);

		this.natTableWidget = createNattableWidget(tableComposite, this, this.tableEditorInput.getPapyrusTableInstance().getTable(), this.menuMgr);

		getSite().setSelectionProvider(this);
		getSite().registerContextMenu(this.menuMgr, this.natTableWidget);
	}


	private INatTableWidget createNattableWidget(final Composite tableComposite, final NatTableEditor natTableEditor, final TableInstance2 table, final MenuManager menuMgr2) {
		//		 the nattable widget itself
		//old instanciation
		//		this.natTableWidget = INatTableWidgetFactory.INSTANCE.createNatTableWidget(tableComposite, this, this.tableEditorInput.getPapyrusTableInstance().getTable(), this.menuMgr);
		this.natTableWidget = new PapyrusNatTableWidget(tableComposite, natTableEditor, table, this.menuMgr);
		final GridData tableGridData = new GridData();
		tableGridData.grabExcessHorizontalSpace = true;
		tableGridData.grabExcessVerticalSpace = true;
		tableGridData.horizontalAlignment = SWT.FILL;
		tableGridData.verticalAlignment = SWT.FILL;
		this.natTableWidget.getComposite().setLayoutData(tableGridData);

		return this.natTableWidget;
	}

	private Composite createCompositeCompositeWthTableBorder(final Composite parent) {
		Composite editorComposite = new Composite(parent, SWT.BORDER);
		final GridLayout editorGridLayout = new GridLayout(1, true);
		editorGridLayout.marginHeight = 0;
		editorGridLayout.marginWidth = 0;

		GridData data = new GridData();
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = SWT.FILL;
		editorComposite.setLayoutData(data);
		editorComposite.setLayout(editorGridLayout);
		return editorComposite;
	}

	/**
	 * 
	 * @param parent
	 *        the parent composite
	 */
	protected void createFirstLine(final Composite parent) {

		final TableInstance table = this.tableEditorInput.getPapyrusTableInstance().getTable();
		Composite firstLineComposite = new Composite(parent, SWT.NONE);
		final GridLayout smallGridLayout = new GridLayout(2, true);
		smallGridLayout.marginHeight = 0;
		smallGridLayout.marginWidth = 0;
		smallGridLayout.marginLeft = 0;
		smallGridLayout.marginRight = 0;

		firstLineComposite.setLayout(smallGridLayout);
		GridData lineData = new GridData();
		lineData.horizontalSpan = 1;
		lineData.horizontalAlignment = SWT.FILL;
		firstLineComposite.setLayoutData(lineData);

		//we display the context of the table
		this.contextLabel = new StringLabel(firstLineComposite, SWT.LEFT);
		this.contextLabel.setLabel(Messages.NatTableEditor_TableContextLabel);
		this.contextLabel.setToolTipText(Messages.NatTableEditor_TableContextTollTip);

		//we observe the feature context of the table (and not the name of the context, because the context is not a NamedElement, but an EObject
		final IObservableValue contextObservable = new EObjectObservableValue(table, TableinstancePackage.eINSTANCE.getTableInstance_Context());
		table.getContext().eAdapters().add(this.contextListener);
		/*
		 * we should set the converted before the observable!
		 */
		this.contextLabel.setConverters(null, new ContextLabelConverter());
		this.contextLabel.setLabelProvider(new UMLLabelProvider());
		this.contextLabel.setModelObservable(contextObservable);

		//set the layout for contextLabel
		GridData contextGridData = new GridData();
		contextGridData.grabExcessHorizontalSpace = true;
		contextGridData.horizontalAlignment = SWT.FILL;
		contextGridData.horizontalSpan = 1;
		this.contextLabel.setLayoutData(contextGridData);

		BooleanRadio checkbox = new BooleanRadio(firstLineComposite, SWT.NONE, "IsSynchronized :");
		checkbox.setToolTipText("Indicates if the table is synchronized with queries");
		final IObservableValue isSynchronizedObservable = new EMFObservableValue(this.tableEditorInput.getPapyrusTableInstance(), PapyrustableinstancePackage.eINSTANCE.getPapyrusTableInstance_IsSynchronized(), getEditingDomain());
		checkbox.setModelObservable(isSynchronizedObservable);

		GridData checkboxGridData = new GridData();
		checkboxGridData.grabExcessHorizontalSpace = true;
		checkboxGridData.horizontalAlignment = SWT.FILL;
		checkbox.setLayoutData(checkboxGridData);

	}

	protected void createDescription(final Composite parent) {
		final TableInstance table = this.tableEditorInput.getPapyrusTableInstance().getTable();
		EClass tableEClass = table.eClass();

		//we display the description of the table
		final StringEditor descriptionEditor = new StringEditor(parent, SWT.MULTI);
		descriptionEditor.setLabel(Messages.NatTableEditor_TaleDescriptionLabel);
		descriptionEditor.setToolTipText(Messages.NatTableEditor_TableDescriptionToolTip);


		EStructuralFeature myFeature = tableEClass.getEStructuralFeature(TableinstancePackage.TABLE_INSTANCE__DESCRIPTION);
		EMFObservableValue observable = new EMFObservableValue(table, myFeature, getEditingDomain());
		descriptionEditor.setModelObservable(observable);

		//set the layout for the description editor
		GridData descriptionGridData = new GridData();
		descriptionGridData.grabExcessHorizontalSpace = true;
		descriptionGridData.horizontalAlignment = SWT.FILL;
		descriptionEditor.setLayoutData(descriptionGridData);
	}

	@Override
	public void dispose() {
		if(this.natTableWidget.getTableInstance().getContext() != null) {//can be null when we are destroying the context (and the table!)
			this.natTableWidget.getTableInstance().getContext().eAdapters().remove(this.contextListener);
		}
		editingDomain.getCommandStack().removeCommandStackListener(commandListener);
		super.dispose();
		for(final ISelectionChangedListener listener : this.natTableWidget.getSelectionChangedListeners()) {
			this.natTableWidget.removeSelectionChangedListener(listener);
		}
		((IPapyrusNatTableWidget)this.natTableWidget).dispose();
		this.natTableWidget = null;
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
		 * if nattable has the focus : we retun the nattable selection
		 * if not, we return the papyrus table instance
		 */
		Control[] children = ((Composite)this.natTableWidget).getChildren();
		if(children.length != 0) {
			boolean focus = children[0].isFocusControl();
			if(focus) {
				return this.natTableWidget.getSelection();
			}
		}
		return new StructuredSelection(this.tableEditorInput.getPapyrusTableInstance());
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
			ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
			BasicCommandStack commandStack = new BasicCommandStack();
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
	 */
	private static class ContextLabelConverter implements IConverter {

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
