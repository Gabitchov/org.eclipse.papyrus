/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.modelrepair.ui;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.uml.modelrepair.Activator;
import org.eclipse.papyrus.uml.modelrepair.readonly.ReadOnlyHelper;
import org.eclipse.papyrus.uml.modelrepair.ui.providers.ResourceLabelProvider;
import org.eclipse.papyrus.uml.modelrepair.ui.providers.ResourceLinksContentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;


public class ModelRepairDialog extends TrayDialog {

	private ModelSet modelSet;

	public ModelRepairDialog(Shell shell, ModelSet modelSet) {
		super(shell);

		this.modelSet = modelSet;
	}

	protected TreeViewer viewer;

	protected Tree tree;

	protected TreeEditor editor;

	protected Text textEditor;

	protected TreeItem currentSelection;

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite contents = (Composite)super.createDialogArea(parent);

		Composite self = new Composite(contents, SWT.NONE);
		self.setLayout(new GridLayout(1, false));
		self.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Label descriptionLabel = new Label(self, SWT.NONE);
		String description = "Press F2 or double click on an element to change its URI\n";
		description += "Edit a root element to modify all dependencies to the selected resource\n";
		description += "Edit a child element to modify only the dependencies from the root resource to the selected one\n";
		descriptionLabel.setText(description);

		descriptionLabel.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

		Label warningLabel = new Label(self, SWT.NONE);
		String warning = "/!\\ Modifying the dependencies between models may result into an inconsistent state and a corrupted model /!\\\n";
		warning += "Most corrupted model can be repaired with this tool";
		warningLabel.setText(warning);
		warningLabel.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_RED));

		warningLabel.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));


		viewer = new TreeViewer(self, SWT.FULL_SELECTION | SWT.BORDER);
		tree = viewer.getTree();
		TableLayout layout = new TableLayout();
		tree.setLayout(layout);
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		tree.setHeaderVisible(true);


		TreeColumn nameColumn = new TreeColumn(tree, SWT.NONE);
		nameColumn.setText("Resource");
		layout.addColumnData(new ColumnWeightData(25, 250, true));

		TreeColumn locationColumn = new TreeColumn(tree, SWT.NONE);
		locationColumn.setText("Location");
		layout.addColumnData(new ColumnWeightData(45, 450, true));

		TreeColumn versionColumn = new TreeColumn(tree, SWT.NONE);
		versionColumn.setText("Read-only");
		layout.addColumnData(new ColumnWeightData(10, 100, true));


		viewer.setContentProvider(new ResourceLinksContentProvider());
		viewer.setLabelProvider(new ResourceLabelProvider(modelSet));
		viewer.setInput(modelSet);

		editor = new TreeEditor(tree);
		editor.setColumn(1);
		editor.horizontalAlignment = SWT.CENTER;
		editor.grabHorizontal = true;
		textEditor = new Text(tree, SWT.BORDER);

		textEditor.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
				if(e.widget == textEditor) {
					validate();
				}
			}

			public void focusGained(FocusEvent e) {
				//Nothing
			}
		});

		textEditor.addKeyListener(new KeyListener() {

			public void keyReleased(KeyEvent e) {
				if(e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR) {
					validate();
					e.doit = false;
				}
			}

			public void keyPressed(KeyEvent e) {
				//Nothing
			}
		});

		viewer.getTree().addKeyListener(new KeyListener() {

			public void keyReleased(KeyEvent e) {
				if(e.keyCode == SWT.F2 && e.widget == tree) {
					editElement(tree);
				}
			}

			public void keyPressed(KeyEvent e) {
				//Nothing
			}
		});

		tree.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				//Nothing
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				//Double click
				if(e.widget == tree) {
					editElement(tree);
					e.doit = false;
				}
			}
		});

		return contents;
	}

	protected void editElement(Tree tree) {
		if(tree.getSelection().length == 0) {
			return;
		}

		currentSelection = tree.getSelection()[0];
		Object element = currentSelection.getData();
		textEditor.setText(((ILabelProvider)viewer.getLabelProvider()).getText(element));
		editor.setEditor(textEditor, currentSelection);
		textEditor.setFocus();
		textEditor.forceFocus();
		textEditor.setSelection(textEditor.getText().length()); //At the end
	}

	protected void validate() {
		editor.setEditor(null);
		textEditor.setVisible(false);

		if(currentSelection == null) {
			return;
		}

		TransactionalEditingDomain domain = TransactionalEditingDomain.Factory.INSTANCE.getEditingDomain(modelSet);
		domain.getCommandStack().execute(new RecordingCommand(domain, "Change URI") {

			@Override
			protected void doExecute() {
				doValidate();
			}

		});


		viewer.refresh();
	}

	protected void doValidate() {
		URI newURI = URI.createURI(textEditor.getText());

		Resource fromResource = null;

		Resource toResource;

		if(currentSelection.getParentItem() == null) { //We selected a root, which is a resource
			Object element = currentSelection.getData();

			if(element instanceof Resource) {
				toResource = (Resource)element;
			} else {
				return;
			}
		} else { //We selected a child, which is a URI. Its parent is a Resource.
			TreeItem parentItem = currentSelection.getParentItem();
			Object parentData = parentItem.getData();
			if(parentData instanceof Resource) {
				fromResource = (Resource)parentData;
			} else {
				return;
			}

			Object element = currentSelection.getData();

			if(element instanceof URI) {
				toResource = modelSet.getResource((URI)element, false);
			} else {
				return;
			}
		}

		if(toResource == null) {
			return;
		}

		if(toResource.getURI().equals(newURI)) {
			return;
		}

		Set<Resource> resourcesToEdit = new HashSet<Resource>();

		if(fromResource == null) {
			resourcesToEdit.addAll(modelSet.getResources());
			resourcesToEdit.remove(toResource);
		} else {
			resourcesToEdit.add(fromResource);
		}

		for(Resource currentResource : resourcesToEdit) {

			if(ReadOnlyHelper.isReadOnly(currentResource)) {
				continue;
			}

			Iterator<EObject> allContentsIterator = currentResource.getAllContents();

			while(allContentsIterator.hasNext()) {
				EObject eObject;

				eObject = allContentsIterator.next();

				if(eObject.eIsProxy()) {
					continue;
				}

				for(EReference reference : eObject.eClass().getEAllReferences()) {
					if(reference.isTransient()) {
						continue;
					}

					if(reference.isContainment()) {
						continue;
					}

					Object value = eObject.eGet(reference);
					if(value instanceof EObject) {
						EObject targetEObject = (EObject)value;
						if(targetEObject.eResource() == toResource) {
							EClass targetEClass = targetEObject.eClass();
							EObject newEObject = targetEClass.getEPackage().getEFactoryInstance().create(targetEClass);
							if(newEObject instanceof InternalEObject) {
								String eObjectFragment = targetEObject.eResource().getURIFragment(targetEObject);
								URI eObjectURI = newURI.appendFragment(eObjectFragment);
								((InternalEObject)newEObject).eSetProxyURI(eObjectURI);

								try {
									System.out.println("Replace " + EcoreUtil.getURI(targetEObject) + " with " + EcoreUtil.getURI(newEObject));
									eObject.eSet(reference, newEObject);
								} catch (Exception ex) {
									Activator.log.error(ex);
								}
							}
						}
					} else if(value instanceof Collection<?>) {
						Map<Integer, EObject> indexToNewValue = new HashMap<Integer, EObject>();

						Collection<Object> collection = (Collection<Object>)value;

						int i = 0;
						for(Object collectionElement : (Collection<?>)value) {
							if(collectionElement instanceof EObject) {
								EObject targetEObject = (EObject)collectionElement;
								if(targetEObject.eResource() == toResource) {
									EClass targetEClass = targetEObject.eClass();
									EObject newEObject = targetEClass.getEPackage().getEFactoryInstance().create(targetEClass);
									if(newEObject instanceof InternalEObject) {
										String eObjectFragment = targetEObject.eResource().getURIFragment(targetEObject);
										URI eObjectURI = newURI.appendFragment(eObjectFragment);
										((InternalEObject)newEObject).eSetProxyURI(eObjectURI);

										System.out.println("Replace " + EcoreUtil.getURI(targetEObject) + " with " + EcoreUtil.getURI(newEObject));
										indexToNewValue.put(i, newEObject);
									}
								}
							}

							i++;
						}

						Object[] allValues = collection.toArray();

						if(indexToNewValue.isEmpty()) {
							continue;
						}

						for(Map.Entry<Integer, EObject> entry : indexToNewValue.entrySet()) {
							//								System.out.println("Replace " + allValues[entry.getKey()] + " with " + entry.getValue());
							allValues[entry.getKey()] = entry.getValue();
						}

						try {
							collection.clear();
							collection.addAll(Arrays.asList(allValues));
						} catch (Exception ex) {
							//								Activator.log.warn(ex.getMessage());
						}
					}
				}
			}
		}
	}

	@Override
	protected void okPressed() {
		try {
			modelSet.save(new NullProgressMonitor());
		} catch (IOException ex) {
			Activator.log.error(ex);
		}
		super.okPressed();
	}

	@Override
	public void create() {
		super.create();
		getShell().setText("Edit model links");
		getShell().pack();
	}


	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	public boolean isHelpAvailable() {
		return false;
	}

}
