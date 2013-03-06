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
package org.eclipse.papyrus.cdo.internal.ui.wizards;

import java.util.Collection;
import java.util.List;

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
import org.eclipse.papyrus.cdo.core.importer.IModelImportConfiguration;
import org.eclipse.papyrus.cdo.core.importer.IModelImportNode;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.eclipse.papyrus.cdo.internal.ui.providers.ModelImportNodeLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * This is the ModelReferencesPage type. Enjoy.
 */
public class ModelReferencesPage
		extends ModelImportWizardPage {

	private static final String MESSAGE = "Select referenced models to import into the repository.";

	private IModelImportConfiguration importConfig;

	private TreeViewer modelsTree;

	private Text pathText;

	public ModelReferencesPage(EventBus bus) {
		super("references", "Model Cross-References", null, bus, MESSAGE);
	}

	public void createControl(Composite parent) {
		initializeDialogUnits(parent);

		Composite result = new Composite(parent, SWT.NONE);
		result.setLayout(new GridLayout(1, false));

		new Label(result, SWT.NONE).setText("Models:");

		ModelImportContentProvider contents = new ModelImportContentProvider();
		modelsTree = new CheckboxTreeViewer(result);
		modelsTree.getControl().setLayoutData(
			GridDataFactory.fillDefaults().grab(true, true).create());
		modelsTree.setAutoExpandLevel(2);
		modelsTree.setContentProvider(contents);
		modelsTree.setLabelProvider(new TreeNodeLabelProvider());

		new Label(result, SWT.NONE).setText("Path:");
		pathText = new Text(result, SWT.BORDER | SWT.MULTI | SWT.WRAP
			| SWT.READ_ONLY);
		pathText.setLayoutData(GridDataFactory.fillDefaults().grab(true, false)
			.hint(SWT.DEFAULT, convertHeightInCharsToPixels(3)).create());

		modelsTree.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection sel = (IStructuredSelection) event
					.getSelection();
				if (!sel.isEmpty()) {
					selected(sel.getFirstElement());
				} else {
					selected(null);
				}
			}
		});

		((ICheckable) modelsTree).addCheckStateListener(contents);
		((ICheckable) modelsTree)
			.addCheckStateListener(new ICheckStateListener() {

				public void checkStateChanged(CheckStateChangedEvent event) {
					Display.getCurrent().asyncExec(new Runnable() {

						public void run() {
							validatePage();
						}
					});
				}
			});

		setControl(result);

		validatePage();
	}

	public IModelImportConfiguration getConfiguration() {
		return importConfig;
	}

	@Subscribe
	public void setConfiguration(IModelImportConfiguration configuration) {
		if (configuration != this.importConfig) {
			if (this.importConfig != null) {
				this.importConfig.dispose();
			}

			this.importConfig = configuration;
		}

		modelsTree.setInput(configuration);

		if (configuration != null) {
			// initialize the checkboxes
			Collection<IModelImportNode> initialSet = configuration
				.getModelsToImport();
			ITreeContentProvider contents = (ITreeContentProvider) modelsTree
				.getContentProvider();
			ICheckable checkable = (ICheckable) modelsTree;
			for (Object next : contents.getElements(configuration)) {
				checkable.setChecked(next, true);

				for (Object child : contents.getChildren(next)) {
					ITreeNode treeNode = (ITreeNode) child;
					if (treeNode.isDependent()
						|| initialSet.contains(treeNode.getElement())) {

						checkable.setChecked(child, true);
						configuration.addModelToImport(treeNode.getElement()
							.getPrimaryResourceURI());
					}
				}
			}
		}

		validatePage();
	}

	@Override
	public void dispose() {
		// I didn't create it, so don't dispose it
		importConfig = null;

		super.dispose();
	}

	void selected(Object treeNode) {
		if (treeNode == null) {
			pathText.setText("");
		} else {
			IModelImportNode node = ((ITreeNode) treeNode).getElement();

			pathText.setText(node.getName());
		}
	}

	@Override
	protected Diagnostic doValidatePage() {
		Diagnostic result = Diagnostic.CANCEL_INSTANCE;

		if (importConfig != null) {
			if (importConfig.getModelsToImport().isEmpty()) {
				result = report(Diagnostic.CANCEL,
					"Please select at least one model to import.");
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

		IModelImportNode getElement();

		boolean isDependent();

		boolean isDependency();
	}

	private static class ModelImportContentProvider
			implements ITreeContentProvider, ICheckStateListener {

		private Multimap<IModelImportNode, TreeNode> nodes = HashMultimap
			.create();

		private static final Object[] NO_OBJECTS = {};

		private IModelImportConfiguration config;

		private Object[] elements;

		private Viewer viewer;

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			nodes.clear();
			elements = null;

			config = (IModelImportConfiguration) newInput;

			this.viewer = viewer;
			viewer.refresh();
		}

		public Object[] getElements(Object inputElement) {
			Object[] result = elements;

			if ((inputElement != config) || (result == null)) {
				IModelImportConfiguration config = (IModelImportConfiguration) inputElement;
				List<TreeNode> nodes = Lists.newArrayListWithCapacity(config
					.getModelsToImport().size());

				for (IModelImportNode next : config.getModelsToImport()) {
					nodes.add(new TreeNode(next));
				}

				result = nodes.toArray();

				if (inputElement == config) {
					// cache the result
					elements = result;
				}
			}

			return result;
		}

		public boolean hasChildren(Object element) {
			IModelImportNode importNode = ((TreeNode) element).getElement();

			return !(importNode.getDependencies().isEmpty() && importNode
				.getDependents().isEmpty());
		}

		public Object getParent(Object element) {
			return ((TreeNode) element).getParent();
		}

		public Object[] getChildren(Object parentElement) {
			return ((TreeNode) parentElement).getChildren();
		}

		public void dispose() {
			nodes.clear();
			elements = null;
		}

		public void checkStateChanged(CheckStateChangedEvent event) {
			ITreeNode node = (ITreeNode) event.getElement();
			IModelImportNode model = node.getElement();

			// apply the check state to the model
			if (event.getChecked()) {
				config.addModelToImport(model.getPrimaryResourceURI());
			} else {
				config.removeModelToImport(model);
			}

			// propapate the check state to other occurrences of the same model
			for (ITreeNode next : nodes.get(model)) {
				event.getCheckable().setChecked(next, event.getChecked());
			}
		}

		/**
		 * Need a tree-node class because {@link IModelImportNode}s are repeated
		 * in the tree.
		 */
		private class TreeNode
				implements ITreeNode {

			private IModelImportNode element;

			private TreeNode parent;

			private List<TreeNode> children;

			private boolean dependent;

			TreeNode(IModelImportNode element) {
				this(null, element, false);
			}

			TreeNode(TreeNode parent, IModelImportNode element,
					boolean dependent) {

				this.parent = parent;
				this.element = element;
				this.dependent = dependent;

				nodes.put(element, this);
			}

			public IModelImportNode getElement() {
				return element;
			}

			public boolean isDependent() {
				return (getParent() != null) && dependent;
			}

			public boolean isDependency() {
				return (getParent() != null) && !dependent;
			}

			Object getParent() {
				return parent;
			}

			Object[] getChildren() {
				if (children == null) {
					createChildren();
				}

				return (children == null)
					? NO_OBJECTS
					: children.toArray();
			}

			void createChildren() {
				Collection<IModelImportNode> dependencies = element
					.getDependencies();
				Collection<IModelImportNode> dependents = element
					.getDependents();

				if (!dependencies.isEmpty() || !dependents.isEmpty()) {
					children = Lists.newArrayListWithCapacity(dependencies
						.size() + dependents.size());

					for (IModelImportNode next : dependents) {
						children.add(new TreeNode(this, next, true));
					}
					for (IModelImportNode next : dependencies) {
						// don't show a model as both a dependent and a
						// dependency if it both references and is
						// referenced by the other
						if (!dependents.contains(next)) {
							children.add(new TreeNode(this, next, false));
						}
					}

					// initialize check state of new children from configuration
					Display.getCurrent().asyncExec(new Runnable() {

						public void run() {
							if (config != null) {
								Collection<IModelImportNode> imported = config
									.getModelsToImport();
								ICheckable checkable = (ICheckable) viewer;
								for (ITreeNode next : children) {
									if (imported.contains(next.getElement())) {
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

	private static class TreeNodeLabelProvider
			extends ModelImportNodeLabelProvider {

		private ResourceManager images = new DeviceResourceManager(
			Display.getCurrent());

		@Override
		public Image getImage(Object element) {
			ITreeNode treeNode = (ITreeNode) element;
			Image result = super.getImage(element);

			if ((result != null) && treeNode.isDependent()) {
				// decorate it
				result = (Image) images.get(new DecorationOverlayIcon(result,
					Activator.getIcon(Activator.ICON_DEPENDENT_OVERLAY16),
					IDecoration.TOP_RIGHT));
			}

			return result;
		}

		@Override
		public void dispose() {
			images.dispose();
		}

		@Override
		protected IModelImportNode getModelImportNode(Object element) {
			return ((ITreeNode) element).getElement();
		}
	}
}
