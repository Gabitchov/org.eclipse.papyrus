/*****************************************************************************
 * Copyright (c) 2008, 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *  Christian W. Damus (CEA) - Refactoring package/profile import/apply UI for CDO
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.ui.dialogs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.papyrus.uml.profile.ImageManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.util.UMLSwitch;



/**
 * this is a dialog to select an element import
 * 
 */
//FIXME: This dialog should be moved to another plug-in
public class ElementImportTreeSelectionDialog<E extends Element> extends Dialog {

	private final Class<E> elementType;
	
	protected List<Package> packages;
	
	protected final EnumSet<ImportAction> allowedActions;

	protected boolean subSelection = false;

	private Set<E> initialSelections = new java.util.HashSet<E>();
	
	private Map<E, ImportSpec<E>> importSpecs = new java.util.HashMap<E, ImportSpec<E>>();
	
	/**
	 * 
	 */
	protected List<ImportSpec<E>> elementsToImport = new ArrayList<ImportSpec<E>>();

	/**
	 * 
	 */
	protected CheckboxTreeViewer elementTree;

	/**
	 * 
	 */
	protected static final Image IMG_PACKAGE = ImageManager.IMG_PACKAGE;

	/**
	 * 
	 */
	protected static final Image IMG_CLASS = ImageManager.IMG_CLASS;

	/**
	 * 
	 */
	protected static final Image IMG_DATATYPE = ImageManager.IMG_DATATYPE;

	/**
	 * 
	 */
	protected static final Image IMG_ENUM = ImageManager.IMG_ENUMERATION;

	/**
	 * 
	 */
	protected static final Image IMG_PRIMITIVE = ImageManager.IMG_PRIMITIVETYPE;

	protected static final Image IMG_PROFILE = ImageManager.IMG_PROFILE;

	/**
	 * 
	 */
	protected static final Image IMG_ASSOCIATION = ImageManager.IMG_ASSOCIATION;

	/**
	 * 
	 */
	protected static final Image IMG_INSTANCESPEC = ImageManager.IMG_INSTANCESPEC;


	/**
	 * @param parent
	 *        the parent shell
	 * @param action
	 *        the implicit import action (the user doesn't have a choice)
	 * @param model
	 *        the UML model of profile or import library
	 */
	public ElementImportTreeSelectionDialog(Shell parent, ImportAction action, Class<E> elementType, Package model) {
		this(parent, EnumSet.of(action), elementType, Collections.singletonList(model));
	}

	/**
	 * @param parent
	 *        the parent shell
	 * @param action
	 *        the implicit import action (the user doesn't have a choice)
	 * @param model
	 *        the UML models or profiles or import libraries
	 */
	public ElementImportTreeSelectionDialog(Shell parent, ImportAction action, Class<E> elementType, Collection<? extends Package> models) {
		this(parent, EnumSet.of(action), elementType, models);
	}

	/**
	 * @param parent
	 *        the parent shell
	 * @param allowedActions
	 *        the import actions that the user may choose from
	 * @param model
	 *        the UML model of profile or import library
	 */
	public ElementImportTreeSelectionDialog(Shell parent, Set<ImportAction> allowedActions, Class<E> elementType, Package model) {
		this(parent, allowedActions, elementType, Collections.singletonList(model));
	}

	/**
	 * 
	 * 
	 * @param model
	 * @param allowedActions
	 *        the import actions that the user may choose from
	 * @param parent
	 */
	public ElementImportTreeSelectionDialog(Shell parent, Set<ImportAction> allowedActions, Class<E> elementType, Collection<? extends Package> models) {
		super(parent);
		
		this.allowedActions = EnumSet.copyOf(allowedActions);
		this.elementType = elementType;
		this.packages = new java.util.ArrayList<Package>(models);
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Select the elements to import");
	}
	
	/**
	 * 
	 * 
	 * @param parent
	 * 
	 * @return
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite comp = (Composite)super.createDialogArea(parent);
		Tree tree = new Tree(comp, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL);
		GridData treeData = new GridData(SWT.FILL, SWT.FILL, true, true);
		treeData.widthHint = 300;
		treeData.heightHint = 300;
		tree.setLayoutData(treeData);

		tree.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {
				if (event.detail == SWT.CHECK) {
					handleCheckStateChanged(getImportSpec(event.item));
				}
			}
		});
		
		elementTree = new CheckboxTreeViewer(tree);
		
		// create tree column for element
		TreeViewerColumn col = new TreeViewerColumn(elementTree, SWT.NONE);
		col.getColumn().setText("Import");
		col.getColumn().setWidth(300);
		col.getColumn().setResizable(true);
		col.setLabelProvider(new CellLabelProvider() {
			
			@Override
			public void update(ViewerCell cell) {
				ImportSpec<?> importSpec = (ImportSpec<?>) cell
					.getElement();
				cell.setImage(getElementImage(importSpec.getElement()));
				cell.setText(getElementText(importSpec.getElement()));
			}
			
			@Override
			public String getToolTipText(Object element) {
				ImportSpec<?> importSpec = (ImportSpec<?>) element;

				return ((EObject) importSpec.getElement()).eResource().getURI()
					.toString();
			}
		});
		ColumnViewerToolTipSupport.enableFor(elementTree);
		
		if (allowedActions.size() > 1) {
			tree.setHeaderVisible(true);
			col.getColumn().setWidth(220);

			// create tree column for action
			col = new TreeViewerColumn(elementTree, SWT.NONE);
			col.getColumn().setText("Action");
			col.getColumn().setWidth(80);
			col.getColumn().setResizable(true);
			col.setLabelProvider(new CellLabelProvider() {
				
				@Override
				public void update(ViewerCell cell) {
					ImportSpec<?> importSpec = (ImportSpec<?>) cell
						.getElement();
					cell.setText(getDisplayName(importSpec.getAction()));
				}
			});
			col.setEditingSupport(new ImportActionEditingSupport(elementTree));
		}
		
		elementTree.setContentProvider(new ElementTreeContentProvider());
		elementTree.setInput(packages);
		elementTree.expandAll();

		// post a selection of the initially selected elements
		tree.getDisplay().asyncExec(new Runnable() {
			
			public void run() {
				for (E next : initialSelections) {
					ImportSpec<E> importSpec = getImportSpec(next);
					if (importSpec != null) {
						elementTree.setChecked(importSpec, true);
						handleCheckStateChanged(importSpec);
					}
				}
			}
		});
		
		return comp;
	}
	
	protected void handleCheckStateChanged(ImportSpec<E> importSpec) {
		if (!elementTree.getChecked(importSpec)) {
			removeResult(importSpec);

		} else {
			addResult(importSpec);
		}
	}
	
	protected void setInitialSelection(E element) {
		initialSelections.add(element);
	}
	
	protected String getDisplayName(ImportAction importAction) {
		String result;
		
		switch (importAction) {
			case IMPORT:
				result = "Import";
				break;
			case APPLY:
				result = "Apply";
				break;
			case COPY:
				result = "Copy";
				break;
			default:
				result = "<none>";
		}
		
		return result;
	}

	/**
	 * Recursive call that Check item childrens in the tree
	 * 
	 * @param item
	 */
	@SuppressWarnings("unchecked")
	protected void addChildSelection(ImportSpec<E> item) {
		ITreeContentProvider provider = (ITreeContentProvider) elementTree.getContentProvider();
		for (Object next : provider.getChildren(item)) {
			elementTree.setChecked(next, true);
			addResult((ImportSpec<E>) next);
		}
	}

	/**
	 * Recursive call that unCheck item childrens in the tree
	 * 
	 * @param item
	 */
	@SuppressWarnings("unchecked")
	protected void remChildSelection(ImportSpec<E> item) {
		ITreeContentProvider provider = (ITreeContentProvider) elementTree.getContentProvider();
		for (Object next : provider.getChildren(item)) {
			elementTree.setChecked(next, false);
			removeResult((ImportSpec<E>) next);
		}
	}

	protected String getElementText(Element element) {
		String result = null;
		
		if (element instanceof NamedElement) {
			result = ((NamedElement) element).getName();
		}
		
		return (result == null) ? "" : result;
	}
	
	protected Image getElementImage(Element element) {
		return new UMLSwitch<Image>() {
			public Image casePackage(Package object) {
				return IMG_PACKAGE;
			}
			
			public Image caseProfile(Profile object) {
				return IMG_PROFILE;
			}
			
			public Image caseAssociation(Association object) {
				return IMG_ASSOCIATION;
			}
			
			public Image caseEnumeration(Enumeration object) {
				return IMG_ENUM;
			}
			
			public Image casePrimitiveType(PrimitiveType object) {
				return IMG_PRIMITIVE;
			}
			
			public Image caseDataType(DataType object) {
				return IMG_DATATYPE;
			}
			
			public Image caseClass(org.eclipse.uml2.uml.Class object) {
				return IMG_CLASS;
			}
			
			public Image caseInstanceSpecification(InstanceSpecification object) {
				return IMG_INSTANCESPEC;
			}
		}.doSwitch(element);
	}
	
	/**
	 * Returns the elements to import.
	 * 
	 * @return
	 */
	public Collection<ImportSpec<E>> getResult() {
		return elementsToImport;
	}

	protected Collection<? extends Element> getChildren(Package package_) {
		Collection<Element> result = new java.util.ArrayList<Element>();
		
		Iterator<PackageableElement> elemIter = package_.getPackagedElements().iterator();
		while (elemIter.hasNext()) {
			Element elem = elemIter.next();
			if (elem instanceof NamedElement) {
				result.add(elem);
			}
		}
		
		return result;
	}
	
	protected ImportSpec<E> createImportSpec(Element element) {
		@SuppressWarnings("unchecked")
		ImportSpec<E> result = new ImportSpec<E>((E) element);
		if (elementType.isInstance(element) && !allowedActions.isEmpty()) {
			result.setAction(allowedActions.iterator().next());
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	protected ImportSpec<E> getImportSpec(Element element) {
		ImportSpec<E> result = importSpecs.get(element);
		if (result == null) {
			result = createImportSpec(element);
			importSpecs.put((E) element, result);
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	protected ImportSpec<E> getImportSpec(Widget item) {
		return (ImportSpec<E>) item.getData();
	}
	
	protected <T extends E> Iterator<T> getAllElementsOfType(final Class<T> type) {
		return filter(EcoreUtil.getAllContents(packages), type);

	}
	
	private <T> Iterator<T> filter(final Iterator<?> iterator, final Class<T> type) {
		return new Iterator<T>() {

			private final Iterator<?> delegate = iterator;

			private T next;

			public boolean hasNext() {
				if (next == null) {
					while (delegate.hasNext()) {
						Object next = delegate.next();
						if (type.isInstance(next)) {
							this.next = type.cast(next);
							break;
						}
					}
				}

				return next != null;
			}

			public T next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}

				T result = next;
				next = null;
				return result;
			}

			public void remove() {
				throw new UnsupportedOperationException("remove");
			}
		};
	}
	
	protected <T extends E> Iterator<T> getRootElementsOfType(final Class<T> type) {
		return filter(packages.iterator(), type);
	}

	protected void selectAll(ImportAction action) {
		Iterator<E> iter;
		
		// if we propagate selections to children, then we need to cover the
		// entire tree.  Otherwise, we process only the root packages because
		// the nested packages are imported/copied recursively
		if ((action == ImportAction.NONE) || subSelection) {
			iter = getAllElementsOfType(elementType);
		} else {
			// first, clear selection of any nested packages
			selectAll(ImportAction.NONE);
			iter = getRootElementsOfType(elementType);
		}
		
		while (iter.hasNext()) {
			ImportSpec<E> importSpec = getImportSpec(iter.next());
			if (action == ImportAction.NONE) {
				if (elementTree.getChecked(importSpec)) {
					elementTree.setChecked(importSpec, false);
					removeResult(importSpec);
				}
			} else {
				if (!elementTree.getChecked(importSpec)) {
					elementTree.setChecked(importSpec, true);
					addResult(importSpec);
				}
				importSpec.setAction(action);
			}
			elementTree.update(importSpec, null);
		}
	}
	
	protected void addResult(ImportSpec<E> importSpec) {
		if (!elementsToImport.contains(importSpec)) {
			elementsToImport.add(importSpec);
		}
		if (subSelection) {
			addChildSelection(importSpec);
		}
	}

	protected void removeResult(ImportSpec<E> importSpec) {
		// bug fix when list is already initialized, it can have several instance of the same element
		while (elementsToImport.contains(importSpec)) {
			elementsToImport.remove(importSpec);
		}
		if (subSelection) {
			remChildSelection(importSpec);
		}
	}
	
	//
	// Nested types
	//
	
	public static class ImportSpec<E extends Element> {
		private final E element;
		private ImportAction action = ImportAction.NONE;
		
		protected ImportSpec(E element) {
			this.element = element;
		}
		
		public E getElement() {
			return element;
		}
		
		public ImportAction getAction() {
			return action;
		}
		
		public void setAction(ImportAction action) {
			this.action = (action == null) ? ImportAction.NONE : action;
		}
		
		@Override
		public String toString() {
			return String.format("<%s> %s", action, element);
		}
	}

	/**
	 * Enumeration of the possible actions to apply to an element that is
	 * selected for import.
	 */
	public static enum ImportAction {
		/** Do not import the element. */
		NONE,
		/** Import the element or package. */
		IMPORT,
		/** Apply the profile (only applicable to profiles). */
		APPLY,
		/** Copy the element or package. */
		COPY;
	}
	
	private class ElementTreeContentProvider implements ITreeContentProvider {
		public Object[] getElements(Object inputElement) {
			List<ImportSpec<E>> result = new java.util.ArrayList<ImportSpec<E>>(packages.size());
			
			for (Package next : packages) {
				result.add(getImportSpec(next));
			}
			
			return result.toArray();
		}
		
		public Object[] getChildren(Object parentElement) {
			List<ImportSpec<E>> result = new java.util.ArrayList<ImportSpec<E>>();
			
			Element parent = ((ImportSpec<?>) parentElement).getElement();
			if (parent instanceof Package) {
				for (Element next : ElementImportTreeSelectionDialog.this
					.getChildren((Package) parent)) {
					
					result.add(getImportSpec(next));
				}
			}
			
			return result.toArray();
		}
		
		public boolean hasChildren(Object element) {
			Element parent = ((ImportSpec<?>) element).getElement();
			return parent instanceof Package;
		}
		
		public Object getParent(Object element) {
			ImportSpec<?> result = null;
			
			ImportSpec<?> importSpec = (ImportSpec<?>) element;
			Element parent = ((Element) importSpec.getElement()).getOwner();
			
			if ((parent != null) && (importSpecs.containsKey(parent))) {
				result = importSpecs.get(parent);
			}
			
			return result;
		}
		
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// pass
		}
		
		public void dispose() {
			// pass
		}
	}
	
	private class ImportActionEditingSupport extends EditingSupport {
		private ComboBoxViewerCellEditor editor;
		
		public ImportActionEditingSupport(ColumnViewer viewer) {
			super(viewer);
		}

		@Override
		protected CellEditor getCellEditor(Object element) {
			if (editor == null) {
				editor = new ComboBoxViewerCellEditor((Tree) getViewer().getControl());
				editor.setLabelProvider(new LabelProvider() {
					@Override
					public String getText(Object element) {
						return getDisplayName((ImportAction) element);
					}
				});
				editor.setContentProvider(new ArrayContentProvider());
				editor.setInput(allowedActions);
			}
			
			return editor;
		}

		@Override
		protected boolean canEdit(Object element) {
			// can't import elements of the wrong type
			ImportSpec<?> spec = (ImportSpec<?>) element;
			return elementType.isInstance(spec.getElement());
		}

		@Override
		protected Object getValue(Object element) {
			ImportSpec<?> spec = (ImportSpec<?>) element;
			
			return elementType.isInstance(spec.getElement())
				? spec.getAction()
				: ImportAction.NONE;
		}

		@Override
		protected void setValue(final Object element, Object value) {
			@SuppressWarnings("unchecked")
			ImportSpec<E> importSpec = (ImportSpec<E>) element;
			importSpec.setAction((ImportAction) value);
			
			// if the user is setting the import action, he wants it imported
			if (!elementTree.getChecked(importSpec)) {
				elementTree.setChecked(importSpec, true);
				addResult(importSpec);
			}
			
			editor.getControl().getDisplay().asyncExec(new Runnable() {
				
				public void run() {
					elementTree.update(element, null);
				}
			});
		}
		
	}
}
