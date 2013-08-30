/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.dialogs;

import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.eresource.EresourcePackage;
import org.eclipse.emf.cdo.util.CDOURIUtil;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.papyrus.cdo.internal.core.IInternalPapyrusRepository;
import org.eclipse.papyrus.cdo.internal.core.PapyrusRepositoryManager;
import org.eclipse.papyrus.cdo.internal.ui.views.ModelRepositoryItemProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import com.google.common.base.Strings;


/**
 * This is the BrowseRepositoryDialog type. Enjoy.
 */
public class BrowseRepositoryDialog extends TitleAreaDialog {

	private final String windowTitle;

	private final String title;

	private final String message;

	private final int style;

	private final IInternalPapyrusRepository repository;

	private boolean allowOverwrite = false;

	private EClass nodeTypeFilter = EresourcePackage.Literals.CDO_RESOURCE_NODE;

	private TreeViewer tree;

	private Text nameText;

	private URI initialURI;

	private CDOResourceNode selection;

	private String name;

	/**
	 * @param style
	 *        one of {@link SWT#OPEN} or {@link SWT#SAVE}
	 */
	public BrowseRepositoryDialog(Shell parentShell, String title, String message, CDOView view, int style) {
		this(parentShell, "Browse Repository", title, message, view, style);
	}

	/**
	 * @param style
	 *        one of {@link SWT#OPEN} or {@link SWT#SAVE}
	 */
	public BrowseRepositoryDialog(Shell parentShell, String windowTitle, String title, String message, CDOView view, int style) {
		super(parentShell);

		this.windowTitle = windowTitle;
		this.title = title;
		this.message = message;
		this.style = checkStyle(style);

		this.repository = PapyrusRepositoryManager.INSTANCE.getRepository(view);
	}

	int checkStyle(int style) {
		setShellStyle(getShellStyle() | (style & ~(SWT.OPEN | SWT.SAVE)));

		return style & (SWT.OPEN | SWT.SAVE);
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);

		newShell.setText(windowTitle);
	}

	public boolean isAllowOverwrite() {
		return allowOverwrite;
	}

	public void setAllowOverwrite(boolean allowOverwrite) {
		this.allowOverwrite = allowOverwrite;
	}

	public EClass getNodeTypeFilter() {
		return nodeTypeFilter;
	}

	public void setNodeTypeFilter(EClass nodeTypeFilter) {
		boolean defaulted = (nodeTypeFilter == null) || !EresourcePackage.Literals.CDO_RESOURCE_NODE.isSuperTypeOf(nodeTypeFilter);
		this.nodeTypeFilter = defaulted ? EresourcePackage.Literals.CDO_RESOURCE_NODE : nodeTypeFilter;
	}

	public URI getInitialURI() {
		return initialURI;
	}

	public void setInitialURI(URI initialURI) {
		this.initialURI = initialURI;
	}

	public URI getSelectedURI() {
		return (getReturnCode() != Window.OK) ? null : basicGetSelectedURI();
	}

	private URI basicGetSelectedURI() {
		URI result = null;

		if(selection != null) {
			result = selection.getURI();
			if(name != null) {
				String resourceName = Strings.emptyToNull(name);
				if(resourceName != null) {
					if(!(selection instanceof CDOResourceFolder)) {
						// append the name to the parent folder
						result = result.trimSegments(1);
					}
					result = result.appendSegment(resourceName);
				}
			}
		}

		return result;
	}

	boolean isOpenStyle() {
		return (style & SWT.OPEN) != 0;
	}

	boolean isSaveStyle() {
		return (style & SWT.SAVE) != 0;
	}

	IInternalPapyrusRepository getRepository() {
		return repository;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle(title);
		setMessage(message);

		Composite main = (Composite)super.createDialogArea(parent);
		Composite result = new Composite(main, SWT.NONE);
		result.setLayout(new GridLayout(2, false));
		result.setLayoutData(new GridData(GridData.FILL_BOTH));

		tree = new TreeViewer(result, SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		tree.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		ModelRepositoryItemProvider itemProvider = new ModelRepositoryItemProvider(null, getRepository());
		tree.setContentProvider(itemProvider);
		tree.setLabelProvider(new DecoratingLabelProvider(itemProvider, PlatformUI.getWorkbench().getDecoratorManager().getLabelDecorator()));
		tree.setSorter(itemProvider);
		if(getRepository() != null) {
			tree.setInput(PapyrusRepositoryManager.INSTANCE);
		}

		if(isSaveStyle()) {
			Label label = new Label(result, SWT.NONE);
			label.setText("Resource name:");
			GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
			gd.verticalIndent = convertVerticalDLUsToPixels(8);
			label.setLayoutData(gd);

			nameText = new Text(result, SWT.BORDER);
			gd = new GridData(SWT.FILL, SWT.TOP, true, false);
			gd.verticalIndent = convertVerticalDLUsToPixels(8);
			nameText.setLayoutData(gd);
		}

		if(getInitialURI() != null) {
			initializeSelection();
		} else if(getRepository() != null) {
			selection = getRepository().getMasterView().getRootResource();
		}

		tree.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection sel = (IStructuredSelection)event.getSelection();
				if(sel.isEmpty()) {
					if(getRepository() != null) {
						selection = getRepository().getMasterView().getRootResource();
					} else {
						selection = null;
					}
				} else {
					selection = CDOUtils.adapt(sel.getFirstElement(), CDOResourceNode.class);
				}

				validateSelection();
			}
		});

		if(nameText != null) {
			nameText.addModifyListener(new ModifyListener() {

				public void modifyText(ModifyEvent e) {
					name = Strings.emptyToNull(nameText.getText().trim());
					validateSelection();
				}
			});
		}

		return result;
	}

	private void initializeSelection() {
		URI uri = getInitialURI();
		CDOView view = getRepository().getMasterView();

		String path = CDOURIUtil.extractResourcePath(uri);
		if(view.hasResource(path)) {
			selection = view.getResourceNode(path);
			tree.setSelection(new StructuredSelection(selection));
			tree.expandToLevel(selection, 1);
			if(nameText != null) {
				name = selection.getName();
				nameText.setText(name);
			}
		} else if(uri.segmentCount() > 0) {
			// try the containing folder, then
			URI parent = uri.trimSegments(1);
			path = CDOURIUtil.extractResourcePath(parent);
			if(view.hasResource(path)) {
				// if the root resource, it is represented by the repository
				selection = view.getResourceNode(path);
				Object treeSelection = selection.isRoot() ? getRepository() : selection;
				tree.setSelection(new StructuredSelection(treeSelection), true);
				tree.expandToLevel(treeSelection, 1);
				if(nameText != null) {
					name = uri.lastSegment();
					nameText.setText(name);
				}
			}
		} else {
			// select the repository (representing the root resource)
			selection = view.getRootResource();
			Object treeSelection = getRepository();
			tree.setSelection(new StructuredSelection(treeSelection), true);
			tree.expandToLevel(treeSelection, 1);
		}
	}

	private void validateSelection() {
		String error = null;
		String warning = null;
		String info = null;
		boolean disable = false;

		if(name != null) {
			if(!URI.validSegment(name)) {
				error = "Resource name is not a valid URI segment.";
			}
		}

		if((error == null) && (getRepository() != null)) {
			String path = CDOURIUtil.extractResourcePath(basicGetSelectedURI());
			CDOView view = getRepository().getMasterView();
			if(isOpenStyle() && !view.hasResource(path)) {
				error = "Resource does not exist.";
			} else if(isOpenStyle()) {
				// then the resource exists.  Is it the kind we want?
				CDOResourceNode node = view.getResourceNode(path);
				if(!getNodeTypeFilter().isInstance(node)) {
					info = NLS.bind("Selection must be a {0}.", getNodeType(getNodeTypeFilter()));
				}
			} else if(isSaveStyle() && view.hasResource(path)) {
				if(isAllowOverwrite()) {
					warning = "Resource already exists and will be replaced.";
				} else {
					error = "Resource already exists.";
				}
			}
		}

		getButton(IDialogConstants.OK_ID).setEnabled(!disable && (error == null));
		if(error != null) {
			setMessage(error, IMessageProvider.ERROR);
		} else if(warning != null) {
			setMessage(warning, IMessageProvider.WARNING);
		} else if(info != null) {
			setMessage(info, IMessageProvider.INFORMATION);
		} else {
			setMessage(message);
		}
	}

	private String getNodeType(EClass nodeClass) {
		String result = "node of any kind";

		if(nodeClass.getEPackage() == EresourcePackage.eINSTANCE) {
			switch(nodeClass.getClassifierID()) {
			case EresourcePackage.CDO_RESOURCE:
				result = "model resource";
				break;
			case EresourcePackage.CDO_RESOURCE_FOLDER:
				result = "folder";
				break;
			case EresourcePackage.CDO_TEXT_RESOURCE:
				result = "text resource";
				break;
			case EresourcePackage.CDO_BINARY_RESOURCE:
				result = "binary resource";
				break;
			case EresourcePackage.CDO_FILE_RESOURCE:
				result = "file (document) resource";
				break;
			}
		}

		return result;
	}
}
