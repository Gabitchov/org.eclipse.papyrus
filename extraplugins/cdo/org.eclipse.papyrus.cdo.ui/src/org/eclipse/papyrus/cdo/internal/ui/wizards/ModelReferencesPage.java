/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *   Christian W. Damus (CEA) - bug 429242
 *   
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.wizards;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.resource.DeviceResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ICheckable;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferConfiguration;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferNode;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.eclipse.papyrus.cdo.internal.ui.l10n.Messages;
import org.eclipse.papyrus.cdo.internal.ui.providers.ModelImportNodeLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * This is the ModelReferencesPage type. Enjoy.
 */
public class ModelReferencesPage extends ModelImportWizardPage {

	private static final String IMPORT_MESSAGE = Messages.ModelReferencesPage_0;

	private static final String EXPORT_MESSAGE = Messages.ModelReferencesPage_1;

	private static final Object[] NO_OBJECTS = {};

	private final boolean isImport;

	private IModelTransferConfiguration importConfig;

	private TreeViewer modelsTree;

	private Text pathText;

	private Button stripSashModelContent;

	public ModelReferencesPage(EventBus bus, boolean isImport) {
		super("references", Messages.ModelReferencesPage_3, null, bus, isImport ? IMPORT_MESSAGE : EXPORT_MESSAGE); //$NON-NLS-1$

		this.isImport = isImport;
	}

	@Override
	public void createControl(Composite parent) {
		initializeDialogUnits(parent);

		Composite result = new Composite(parent, SWT.NONE);
		result.setLayout(new GridLayout(1, false));

		new Label(result, SWT.NONE).setText(Messages.ModelReferencesPage_4);

		ModelImportContentProvider contents = new ModelImportContentProvider();
		modelsTree = new CheckboxTreeViewer(result);
		modelsTree.getControl().setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());
		modelsTree.setAutoExpandLevel(2);
		modelsTree.setContentProvider(contents);
		modelsTree.setLabelProvider(new TreeNodeLabelProvider());

		new Label(result, SWT.NONE).setText(Messages.ModelReferencesPage_5);
		pathText = new Text(result, SWT.BORDER | SWT.MULTI | SWT.WRAP | SWT.READ_ONLY);
		pathText.setLayoutData(GridDataFactory.fillDefaults().grab(true, false).hint(SWT.DEFAULT, convertHeightInCharsToPixels(3)).create());

		if(isImport) {
			stripSashModelContent = new Button(result, SWT.CHECK);
			stripSashModelContent.setText(Messages.ModelReferencesPage_2);
			stripSashModelContent.setToolTipText(Messages.ModelReferencesPage_6);

			stripSashModelContent.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					if(getConfiguration() != null) {
						getConfiguration().setStripSashModelContent(stripSashModelContent.getSelection());
					}
				}
			});
		}

		modelsTree.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection sel = (IStructuredSelection)event.getSelection();
				if(!sel.isEmpty()) {
					selected(sel.getFirstElement());
				} else {
					selected(null);
				}
			}
		});

		((ICheckable)modelsTree).addCheckStateListener(contents);
		((ICheckable)modelsTree).addCheckStateListener(new ICheckStateListener() {

			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				Display.getCurrent().asyncExec(new Runnable() {

					@Override
					public void run() {
						validatePage();
					}
				});
			}
		});

		setControl(result);

		validatePage();
	}

	public IModelTransferConfiguration getConfiguration() {
		return importConfig;
	}

	@Subscribe
	public void setConfiguration(IModelTransferConfiguration configuration) {
		if(configuration != this.importConfig) {
			if(this.importConfig != null) {
				this.importConfig.dispose();
			}

			this.importConfig = configuration;
		}

		modelsTree.setInput(configuration);

		if(configuration != null) {
			// initialize the checkboxes
			initializeCheckedNodes();

			// determine enablement of strip-sash-model option
			if(stripSashModelContent != null) {
				stripSashModelContent.setSelection(true);
				stripSashModelContent.setEnabled(configuration.hasSashModelContent());

				this.importConfig.setStripSashModelContent(true);
			}
		} else if(stripSashModelContent != null) {
			stripSashModelContent.setSelection(true);
			stripSashModelContent.setEnabled(false);
		}

		validatePage();
	}

	@Override
	public void dispose() {
		// I didn't create it, so don't dispose it
		importConfig = null;

		super.dispose();
	}

	private void initializeCheckedNodes() {
		final Collection<IModelTransferNode> initialSet = importConfig.getModelsToTransfer();
		final ITreeContentProvider contents = (ITreeContentProvider)modelsTree.getContentProvider();
		final ICheckable checkable = (ICheckable)modelsTree;

		final Set<IModelTransferNode> visited = Sets.newHashSet();
		final Queue<Object> queue = new java.util.ArrayDeque<Object>(Arrays.asList(contents.getElements(importConfig)));

		for(Object next = queue.poll(); next != null; next = queue.poll()) {
			ITreeNode parent = (ITreeNode)next;

			// we must check a parent if the user initially selected it on opening the wizard
			// or we are importing and it is a dependent of a checked node,
			// or we are exporting and it is a dependency of a checked node,
			// or it is a model sub-unit (required dependency) of a checked node
			boolean mustCheck = initialSet.contains(parent.getElement());
			if(mustCheck) {
				checkable.setChecked(next, true);
			}

			if(visited.add(parent.getElement())) {
				// recurse into the children
				for(Object child : contents.getChildren(next)) {
					ITreeNode treeNode = (ITreeNode)child;
					queue.add(treeNode);

					// we must check a node if either the user initially selected it on opening the wizard,
					// or we are importing and it is a dependent of a checked node,
					// or we are exporting and it is a dependency of a checked node,
					// or it is a model sub-unit (required dependency) of a checked node
					mustCheck = initialSet.contains(treeNode.getElement()) //
						|| (isImport ? treeNode.isDependent() : treeNode.isDependency()) //
						|| (checkable.getChecked(parent) && parent.getElement().isModelSubUnit(treeNode.getElement()));

					if(mustCheck) {
						checkable.setChecked(child, true);
						importConfig.addModelToTransfer(treeNode.getElement().getPrimaryResourceURI());
					}
				}
			}
		}

	}

	void selected(Object treeNode) {
		if(treeNode == null) {
			pathText.setText(""); //$NON-NLS-1$
		} else {
			IModelTransferNode node = ((ITreeNode)treeNode).getElement();

			pathText.setText(node.getName());
		}
	}

	@Override
	protected Diagnostic doValidatePage() {
		Diagnostic result = Diagnostic.CANCEL_INSTANCE;

		if(importConfig != null) {
			if(importConfig.getModelsToTransfer().isEmpty()) {
				result = report(Diagnostic.CANCEL, NLS.bind(Messages.ModelReferencesPage_7, isImport ? Messages.ModelReferencesPage_8 : Messages.ModelReferencesPage_9));
			} else {
				result = importConfig.validate();
			}
		}

		return result;
	}

	//
	// Nested types
	//

	static interface ITreeNode {

		IModelTransferNode getElement();

		boolean isDependent();

		boolean isDependency();
	}

	private class ModelImportContentProvider implements ITreeContentProvider, ICheckStateListener {

		private final Multimap<IModelTransferNode, TreeNode> nodes = HashMultimap.create();

		private IModelTransferConfiguration config;

		private Object[] elements;

		private Viewer viewer;

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			nodes.clear();
			elements = null;

			config = (IModelTransferConfiguration)newInput;

			this.viewer = viewer;
		}

		@Override
		public Object[] getElements(Object inputElement) {
			Object[] result = elements;

			if((inputElement != config) || (result == null)) {
				IModelTransferConfiguration config = (IModelTransferConfiguration)inputElement;
				List<TreeNode> nodes = Lists.newArrayListWithCapacity(config.getModelsToTransfer().size());

				for(IModelTransferNode next : config.getModelsToTransfer()) {
					nodes.add(new TreeNode(next));
				}

				result = nodes.toArray();

				if(inputElement == config) {
					// cache the result
					elements = result;
				}
			}

			return result;
		}

		@Override
		public boolean hasChildren(Object element) {
			IModelTransferNode importNode = ((TreeNode)element).getElement();

			return !(importNode.getDependencies().isEmpty() && importNode.getDependents().isEmpty());
		}

		@Override
		public Object getParent(Object element) {
			return ((TreeNode)element).getParent();
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			return ((TreeNode)parentElement).getChildren();
		}

		@Override
		public void dispose() {
			nodes.clear();
			elements = null;
		}

		@Override
		public void checkStateChanged(CheckStateChangedEvent event) {
			ITreeNode node = (ITreeNode)event.getElement();
			IModelTransferNode model = node.getElement();

			// apply the check state to the model
			if(event.getChecked()) {
				config.addModelToTransfer(model.getPrimaryResourceURI());
			} else {
				config.removeModelToTransfer(model);
			}

			// propagate the check state to other occurrences of the same model
			for(ITreeNode next : nodes.get(model)) {
				event.getCheckable().setChecked(next, event.getChecked());
			}
		}

		/**
		 * Need a tree-node class because {@link IModelTransferNode}s are repeated
		 * in the tree.
		 */
		private class TreeNode implements ITreeNode {

			private final IModelTransferNode element;

			private final TreeNode parent;

			private List<TreeNode> children;

			private final boolean dependent;

			TreeNode(IModelTransferNode element) {
				this(null, element, false);
			}

			TreeNode(TreeNode parent, IModelTransferNode element, boolean dependent) {
				this.parent = parent;
				this.element = element;
				this.dependent = dependent;

				nodes.put(element, this);
			}

			@Override
			public IModelTransferNode getElement() {
				return element;
			}

			@Override
			public boolean isDependent() {
				return (getParent() != null) && dependent;
			}

			@Override
			public boolean isDependency() {
				return (getParent() != null) && !dependent;
			}

			Object getParent() {
				return parent;
			}

			Object[] getChildren() {
				if(children == null) {
					createChildren();
				}

				return (children == null) ? NO_OBJECTS : children.toArray();
			}

			void createChildren() {
				Collection<IModelTransferNode> dependencies = element.getDependencies();
				Collection<IModelTransferNode> dependents = element.getDependents();

				if(!dependencies.isEmpty() || !dependents.isEmpty()) {
					children = Lists.newArrayListWithCapacity(dependencies.size() + dependents.size());

					// the recommendation for importing dependencies vs. dependents is
					// reversed for export as for import.  We suggest to export dependencies
					// of an exported model (those that it references) and import dependents
					// of an imported model (those that reference it)
					for(IModelTransferNode next : isImport ? dependents : dependencies) {
						children.add(new TreeNode(this, next, isImport));
					}

					for(IModelTransferNode next : isImport ? dependencies : dependents) {
						// don't show a model as both a dependent and a
						// dependency if it both references and is
						// referenced by the other
						if(isImport ? !dependents.contains(next) : !dependencies.contains(next)) {
							children.add(new TreeNode(this, next, false));
						}
					}

					// initialize check state of new children from configuration
					Display.getCurrent().asyncExec(new Runnable() {

						@Override
						public void run() {
							if(config != null) {
								Collection<IModelTransferNode> imported = config.getModelsToTransfer();
								ICheckable checkable = (ICheckable)viewer;
								for(ITreeNode next : children) {
									if(imported.contains(next.getElement())) {
										checkable.setChecked(next, true);
									}
								}
							}
						}
					});
				}
			}
		}
	}

	private static class TreeNodeLabelProvider extends ModelImportNodeLabelProvider {

		private final ResourceManager images = new DeviceResourceManager(Display.getCurrent());

		@Override
		public Image getImage(Object element) {
			ITreeNode treeNode = (ITreeNode)element;
			Image result = super.getImage(element);

			if((result != null) && treeNode.isDependent()) {
				// decorate it
				result = (Image)images.get(new DecorationOverlayIcon(result, Activator.getIcon(Activator.ICON_DEPENDENT_OVERLAY16), IDecoration.TOP_RIGHT));
			}

			return result;
		}

		@Override
		public void dispose() {
			images.dispose();
		}

		@Override
		protected IModelTransferNode getModelImportNode(Object element) {
			return ((ITreeNode)element).getElement();
		}
	}
}
