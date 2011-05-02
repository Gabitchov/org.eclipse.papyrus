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
package org.eclipse.papyrus.table.common.internal;

import java.util.EventObject;
import java.util.HashMap;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
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
import org.eclipse.emf.facet.widgets.nattable.INatTableWidgetFactory;
import org.eclipse.emf.facet.widgets.nattable.INatTableWidgetProvider;
import org.eclipse.emf.facet.widgets.nattable.IWorkbenchPartProvider;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableinstancePackage;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.papyrus.diagram.common.providers.EditorLabelProvider;
import org.eclipse.papyrus.nattable.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.properties.uml.databinding.PapyrusObservableValue;
import org.eclipse.papyrus.table.common.messages.Messages;
import org.eclipse.papyrus.widgets.editors.StringEditor;
import org.eclipse.papyrus.widgets.editors.StringLabel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
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

/**
 * Comes from org.eclipse.emf.facet.widget.nattable.workbench.
 * 
 * This class should not be used by others plugins
 * TODO Should be deleted or merge with an other classe
 */
public class NatTableEditor extends EditorPart implements ISelectionProvider, IEditingDomainProvider, IWorkbenchPartProvider {

	public static final String ID = "org.eclipse.emf.facet.widgets.nattable.workbench.editor.NatTableEditor"; //$NON-NLS-1$

	private TableEditorInput tableEditorInput;

	private INatTableWidget natTableWidget;

	private EditingDomain editingDomain;

	private MenuManager menuMgr;

	private final CommandStackListener commandListener = new CommandStackListener() {

		public void commandStackChanged(final EventObject event) {
			Display.getCurrent().asyncExec(new Runnable() {

				public void run() {
					firePropertyChange(PROP_DIRTY);
				}
			});
		}
	};

	@SuppressWarnings("rawtypes")
	// We cannot change the method signature because of the override
	@Override
	public Object getAdapter(final Class adapter) {
		if(adapter == INatTableWidgetProvider.class) {
			return new INatTableWidgetProvider() {

				public INatTableWidget getNatTableWidget() {
					return natTableWidget;
				}
			};
		}
		return null;
	}

	@Override
	public void init(final IEditorSite site, final IEditorInput input) throws PartInitException {
		if(input instanceof TableEditorInput) {
			tableEditorInput = (TableEditorInput)input;
			editingDomain = tableEditorInput.getEditingDomain();
			initializeEditingDomain();
			setSite(site);
			setInput(tableEditorInput);
			setPartName(tableEditorInput.getName());
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
				tableEditorInput = new TableEditorInput(tableInstance, getEditingDomain());
				setSite(site);
				setInput(tableEditorInput);
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
		menuMgr = new MenuManager("#PopUp", NatTableEditor.ID); //$NON-NLS-1$
		menuMgr.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		menuMgr.setRemoveAllWhenShown(true);

		final TableInstance table = tableEditorInput.getPapyrusTableInstance().getTable();
		EClass tableEClass = table.eClass();

		final Composite editorComposite = new Composite(parent, SWT.NONE);
		final GridLayout editorGridLayout = new GridLayout(1, false);
		editorGridLayout.marginHeight = 0;
		editorGridLayout.marginWidth = 0;
		editorComposite.setLayout(editorGridLayout);

		//we display the context of the table
		final StringLabel contextLabel = new StringLabel(editorComposite, SWT.NONE);
		contextLabel.setLabel(Messages.NatTableEditor_TableContextLabel);
		contextLabel.setToolTipText(Messages.NatTableEditor_TableContextTollTip);

		//TODO use EMF Observable
		EStructuralFeature contextFeature = tableEClass.getEStructuralFeature(TableinstancePackage.TABLE_INSTANCE__CONTEXT);
		final IObservableValue contextObservable = new org.eclipse.papyrus.properties.uml.databinding.PapyrusObservableValue(table, contextFeature, getEditingDomain());
		contextObservable.addValueChangeListener(new IValueChangeListener() {

			/**
			 * 
			 * @see org.eclipse.core.databinding.observable.value.IValueChangeListener#handleValueChange(org.eclipse.core.databinding.observable.value.ValueChangeEvent)
			 * 
			 * @param event
			 */
			public void handleValueChange(final ValueChangeEvent event) {
				//TODO : not verified
				//Change the displayed icon for the StringLabel
				EditorLabelProvider provider = new EditorLabelProvider();
				Image im = provider.getImage(table.getContext());
				contextLabel.getValueLabel().setImage(im);
			}
		});

		/*
		 * we should set the converted before the observable!
		 */
		contextLabel.setConverters(null, new ContextLabelConverter());
		EditorLabelProvider provider = new EditorLabelProvider();
		contextLabel.getValueLabel().setImage(provider.getImage(table.getContext()));
		contextLabel.setModelObservable(contextObservable);

		//set the layout for contextLabel
		GridData contextGridData = new GridData();
		contextGridData.grabExcessHorizontalSpace = true;
		contextGridData.horizontalAlignment = SWT.FILL;
		contextLabel.setLayoutData(contextGridData);


		//we display the description of the table

		final StringEditor descriptionEditor = new StringEditor(editorComposite, SWT.MULTI);
		descriptionEditor.setLabel(Messages.NatTableEditor_TaleDescriptionLabel);
		descriptionEditor.setToolTipText(Messages.NatTableEditor_TableDescriptionToolTip);
		EStructuralFeature myFeature = tableEClass.getEStructuralFeature(TableinstancePackage.TABLE_INSTANCE__DESCRIPTION);
		PapyrusObservableValue observable = new PapyrusObservableValue(table, myFeature, getEditingDomain());
		descriptionEditor.setModelObservable(observable);

		//set the layout for the description editor
		GridData descriptionGridData = new GridData();
		descriptionGridData.grabExcessHorizontalSpace = true;
		descriptionGridData.horizontalAlignment = SWT.FILL;
		descriptionEditor.setLayoutData(descriptionGridData);


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

		// the nattable widget itself
		natTableWidget = INatTableWidgetFactory.INSTANCE.createNatTableWidget(tableComposite, this, tableEditorInput.getPapyrusTableInstance().getTable(), menuMgr);


		final GridData tableGridData = new GridData();
		tableGridData.grabExcessHorizontalSpace = true;
		tableGridData.grabExcessVerticalSpace = true;
		tableGridData.horizontalAlignment = SWT.FILL;
		tableGridData.verticalAlignment = SWT.FILL;
		natTableWidget.getComposite().setLayoutData(tableGridData);

		getSite().setSelectionProvider(natTableWidget);
		getSite().registerContextMenu(menuMgr, natTableWidget);


		//we add a listener on the resource in order to be synchronized with queries
		Resource res = tableEditorInput.getPapyrusTableInstance().getTable().getContext().eResource();


		res.setTrackingModification(true);
		if(!res.eAdapters().contains(modelChangeAdapter)) {
			res.eAdapters().add(modelChangeAdapter);
		}

	}

	@Override
	public void dispose() {
		//TODO remove the listener on the context
		super.dispose();
	}

	//this code comes from NatTableWidget
	//we need to listen change on the context when its a table fillied with queries : 
	private final Adapter modelChangeAdapter = new AdapterImpl() {

		@Override
		public void notifyChanged(final Notification msg) {
			//TODO remove the listener!
			int eventType = msg.getEventType();
			if(eventType != Notification.REMOVING_ADAPTER && eventType != Notification.RESOLVE) {
				// redraw table when model changes
				//				System.out.println("we listen a change on the context");
			}
		}
	};

	@Override
	public void setFocus() {
		natTableWidget.getComposite().setFocus();
	}

	@Override
	public boolean isDirty() {
		return ((BasicCommandStack)editingDomain.getCommandStack()).isSaveNeeded();
	}

	@Override
	public boolean isSaveAsAllowed() {
		return true;
	}

	@Override
	public void doSave(final IProgressMonitor monitor) {
		natTableWidget.save();
		firePropertyChange(PROP_DIRTY);
	}

	@Override
	public void doSaveAs() {
		natTableWidget.saveAs();
		firePropertyChange(PROP_DIRTY);
	}

	/** Override to open with a subclassed factory */
	//	protected NatTableEditorFactory getFactory() {
	//		return NatTableEditorFactory.getInstance();
	//	}

	public void addSelectionChangedListener(final ISelectionChangedListener listener) {
		natTableWidget.addSelectionChangedListener(listener);
	}

	public ISelection getSelection() {
		return natTableWidget.getSelection();
	}

	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	public void removeSelectionChangedListener(final ISelectionChangedListener listener) {
		natTableWidget.removeSelectionChangedListener(listener);
	}

	public void setSelection(final ISelection selection) {
		natTableWidget.setSelection(selection);
	}

	// public INatTableWidget getNatTableWidget() {
	// return this.natTableWidget;
	// }

	/**
	 * This sets up the editing domain for the model editor
	 */
	protected void initializeEditingDomain() {
		if(editingDomain == null) {
			ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
			BasicCommandStack commandStack = new BasicCommandStack();
			editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, new HashMap<Resource, Boolean>());
		}
		editingDomain.getCommandStack().removeCommandStackListener(commandListener);
		editingDomain.getCommandStack().addCommandStackListener(commandListener);
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
