/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.palette.dialog;

import java.util.Collections;
import java.util.List;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.Messages;
import org.eclipse.papyrus.uml.diagram.common.service.palette.AspectToolService;
import org.eclipse.papyrus.uml.diagram.common.service.palette.IAspectAction;
import org.eclipse.papyrus.uml.diagram.common.service.palette.IAspectActionProvider;
import org.eclipse.papyrus.uml.diagram.common.service.palette.IPostAction;
import org.eclipse.papyrus.uml.diagram.common.service.palette.IPreAction;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.PageBook;
import org.eclipse.uml2.uml.Profile;


/**
 * Class in charge of the composite in the {@link LocalPaletteContentPage}
 */
public class AspectActionsInformationComposite {

	/** add icon path */
	private static final String ICONS_ADD = "/icons/obj16/Add_16x16.gif";

	/** remove icon path */
	protected static final String ICONS_REMOVE = "/icons/delete.gif";

	/** move up icon path */
	protected static final String ICONS_UP = "/icons/arrow_up.gif";

	/** move down icon path */
	protected static final String ICONS_DOWN = "/icons/arrow_down.gif";

	/** proxy name text */
	protected Text nameText;

	/** proxy description text */
	protected Text descriptionText;

	/** proxy icon text */
	protected Text iconText;

	/** referenced proxy text */
	protected Text referencedText;

	/** current selected action proxy */
	protected PaletteEntryProxy selectedEntryProxy;

	/** tree viewer for the list of aspect actions */
	protected TreeViewer viewer;

	/** page book where specific pages are displayed for configuration of the aspect actions */
	protected PageBook actionDescriptionComposite;

	/** list of applied profiles */
	protected List<Profile> appliedProfiles;

	/** remove aspect action button */
	protected Button removeActionButton;

	/** add aspect action button */
	protected Button addActionButton;

	/** move up aspect action button */
	protected Button moveUpActionButton;

	/** move down aspect action button */
	protected Button moveDownActionButton;

	/**
	 * Creates the content for this composite
	 * 
	 * @param parent
	 *        the conainer of the created content
	 * @return the created composite
	 */
	public Composite createComposite(Composite parent, List<Profile> appliedProfiles) {
		this.appliedProfiles = appliedProfiles;
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		composite.setLayout(layout);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.horizontalSpan = 4;
		composite.setLayoutData(data);

		// composite for the list of aspect actions
		Composite actionList = new Composite(composite, SWT.NONE);
		layout = new GridLayout(5, false);
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		actionList.setLayout(layout);
		data = new GridData(SWT.FILL, SWT.FILL, false, true);
		actionList.setLayoutData(data);

		Label aspectListLabel = new Label(actionList, SWT.LEAD);
		aspectListLabel.setText(Messages.Aspect_Action_Information_List_Label);
		data = new GridData(SWT.FILL, SWT.CENTER, true, false);
		data.horizontalIndent = 5;
		aspectListLabel.setLayoutData(data);

		addActionButton = new Button(actionList, SWT.NONE);
		addActionButton.setImage(Activator.getPluginIconImage(Activator.ID, ICONS_ADD));
		addActionButton.addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
				addButtonPressed();
			}

			public void mouseDown(MouseEvent e) {

			}

			public void mouseDoubleClick(MouseEvent e) {

			}
		});

		removeActionButton = new Button(actionList, SWT.NONE);
		removeActionButton.setImage(Activator.getPluginIconImage(Activator.ID, ICONS_REMOVE));
		removeActionButton.addMouseListener(new MouseListener() {

			/**
			 * @{inheritDoc
			 */
			public void mouseUp(MouseEvent e) {
				// remove the selected aspect action(s)
				ITreeSelection selection = (ITreeSelection)viewer.getSelection();
				if(selection != null && selection.size() > 0) {
					for(Object selected : selection.toList()) {
						if(selected instanceof IPostAction && selectedEntryProxy instanceof PaletteAspectToolEntryProxy) {
							((PaletteAspectToolEntryProxy)selectedEntryProxy).getPostActions().remove(selected);
						}
					}
				}
				setSelectedEntryProxy(selectedEntryProxy);
			}

			/**
			 * @{inheritDoc
			 */
			public void mouseDown(MouseEvent e) {

			}

			/**
			 * @{inheritDoc
			 */
			public void mouseDoubleClick(MouseEvent e) {

			}
		});

		moveUpActionButton = new Button(actionList, SWT.NONE);
		moveUpActionButton.setImage(Activator.getPluginIconImage(Activator.ID, ICONS_UP));
		moveUpActionButton.addMouseListener(new MouseListener() {

			/**
			 * @{inheritDoc
			 */
			public void mouseUp(MouseEvent e) {
				IStructuredSelection selection = (IStructuredSelection)viewer.getSelection();
				if(selection != null && selection.size() > 0 && selectedEntryProxy instanceof PaletteAspectToolEntryProxy) {
					IAspectAction action = (IAspectAction)selection.getFirstElement();
					List<IPreAction> initialPreList = ((PaletteAspectToolEntryProxy)selectedEntryProxy).getPreActions();
					List<IPostAction> initialPostList = ((PaletteAspectToolEntryProxy)selectedEntryProxy).getPostActions();

					if(action instanceof IPreAction) {
						// move from pre action list
						if(initialPreList.indexOf(action) > 0) {
							Collections.swap(initialPreList, initialPreList.indexOf(action), initialPreList.indexOf(action) - 1);
						}
					} else if(action instanceof IPostAction) {
						if(initialPostList.indexOf(action) > 0) {
							Collections.swap(initialPostList, initialPostList.indexOf(action), initialPostList.indexOf(action) - 1);
						}
					}

					((PaletteAspectToolEntryProxy)selectedEntryProxy).setPreActions(initialPreList);
					((PaletteAspectToolEntryProxy)selectedEntryProxy).setPostActions(initialPostList);

					// update content
					viewer.setInput(selectedEntryProxy);
					// restore selection
					viewer.setSelection(new StructuredSelection(action), true);
				}

			}

			/**
			 * @{inheritDoc
			 */
			public void mouseDown(MouseEvent e) {

			}

			/**
			 * @{inheritDoc
			 */
			public void mouseDoubleClick(MouseEvent e) {

			}
		});

		moveDownActionButton = new Button(actionList, SWT.NONE);
		moveDownActionButton.setImage(Activator.getPluginIconImage(Activator.ID, ICONS_DOWN));
		moveDownActionButton.addMouseListener(new MouseListener() {

			/**
			 * @{inheritDoc
			 */
			public void mouseUp(MouseEvent e) {
				IStructuredSelection selection = (IStructuredSelection)viewer.getSelection();
				if(selection != null && selection.size() > 0 && selectedEntryProxy instanceof PaletteAspectToolEntryProxy) {
					IAspectAction action = (IAspectAction)selection.getFirstElement();
					List<IPreAction> initialPreList = ((PaletteAspectToolEntryProxy)selectedEntryProxy).getPreActions();
					List<IPostAction> initialPostList = ((PaletteAspectToolEntryProxy)selectedEntryProxy).getPostActions();

					if(action instanceof IPreAction) {
						// move from pre action list
						if(initialPreList.indexOf(action) < initialPreList.size() - 1) {
							Collections.swap(initialPreList, initialPreList.indexOf(action), initialPreList.indexOf(action) + 1);
						}
					} else if(action instanceof IPostAction) {
						if(initialPostList.indexOf(action) < initialPostList.size() - 1) {
							Collections.swap(initialPostList, initialPostList.indexOf(action), initialPostList.indexOf(action) + 1);
						}
					}

					((PaletteAspectToolEntryProxy)selectedEntryProxy).setPreActions(initialPreList);
					((PaletteAspectToolEntryProxy)selectedEntryProxy).setPostActions(initialPostList);

					// update content
					viewer.setInput(selectedEntryProxy);
					// restore selection
					viewer.setSelection(new StructuredSelection(action), true);
				}

			}

			/**
			 * @{inheritDoc
			 */
			public void mouseDown(MouseEvent e) {

			}

			/**
			 * @{inheritDoc
			 */
			public void mouseDoubleClick(MouseEvent e) {

			}
		});

		updateButtons();

		viewer = new TreeViewer(actionList, SWT.BORDER);
		data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.horizontalSpan = 5;
		data.heightHint = 150;
		viewer.getControl().setLayoutData(data);
		viewer.setLabelProvider(new AspectActionLabelProvider());
		viewer.setContentProvider(new AspectActionContentProvider());
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				handleActionListSelectionChanged(event);
			}

		});

		actionDescriptionComposite = new PageBook(composite, SWT.NONE);
		data = new GridData(SWT.FILL, SWT.FILL, true, true);
		actionDescriptionComposite.setLayoutData(data);

		return composite;
	}

	/**
	 * Action run when the button add is pressed
	 */
	protected void addButtonPressed() {
		Menu menu = new Menu(addActionButton);
		for(IAspectActionProvider factory : AspectToolService.getInstance().getProviders()) {

			// check if action can be added (not present if one instance allowed)
			if(factory.isEnable(selectedEntryProxy)) {
				MenuItem item = new MenuItem(menu, SWT.NONE);
				item.setText(factory.getName());
				item.setImage(factory.getImage());
				item.setData(factory);
				item.addSelectionListener(new SelectionListener() {

					/**
					 * @{inheritDoc
					 */
					public void widgetSelected(SelectionEvent e) {
						IAspectActionProvider factory = (IAspectActionProvider)((MenuItem)e.getSource()).getData();
						IAspectAction action = factory.createAction(null);
						if(selectedEntryProxy instanceof PaletteAspectToolEntryProxy) {
							if(action instanceof IPostAction) {
								((PaletteAspectToolEntryProxy)selectedEntryProxy).getPostActions().add((IPostAction)action);
							} else {
								((PaletteAspectToolEntryProxy)selectedEntryProxy).getPreActions().add((IPreAction)action);
							}
							setSelectedEntryProxy(selectedEntryProxy);
						}
					}

					/**
					 * @{inheritDoc
					 */
					public void widgetDefaultSelected(SelectionEvent e) {

					}
				});
			}
		}
		menu.setVisible(true);

	}

	/**
	 * Handles the selection changed event in the tree viewer of actions
	 * 
	 * @param event
	 *        the event fired by the tree viewer or <code>null</code>
	 */
	protected void handleActionListSelectionChanged(SelectionChangedEvent event) {
		if(event == null) {
			actionDescriptionComposite.showPage(new Composite(actionDescriptionComposite, SWT.NONE));
			removeActionButton.setEnabled(false);
		} else {
			IStructuredSelection selection = (IStructuredSelection)event.getSelection();
			if(selection != null && selection.getFirstElement() instanceof IAspectAction) {
				// udpate the page book where parameters are handled
				actionDescriptionComposite.showPage(((IAspectAction)selection.getFirstElement()).createConfigurationComposite(actionDescriptionComposite, selectedEntryProxy, appliedProfiles));
				removeActionButton.setEnabled(true);
			} else {
				actionDescriptionComposite.showPage(new Composite(actionDescriptionComposite, SWT.NONE));
				removeActionButton.setEnabled(false);
			}
		}
	}

	/**
	 * Sets the new Selected entry
	 * 
	 * @param selectedConfiguration
	 *        the selectedConfiguration to set
	 */
	public void setSelectedEntryProxy(PaletteEntryProxy selectedEntryProxy) {
		// should save the content for the previous selected entry proxy...
		this.selectedEntryProxy = selectedEntryProxy;

		if(viewer != null) {
			viewer.setInput(selectedEntryProxy);

			// select first action
			handleActionListSelectionChanged(null);

			// select first post action
			if(selectedEntryProxy instanceof PaletteAspectToolEntryProxy && ((PaletteAspectToolEntryProxy)selectedEntryProxy).getPostActions().size() > 0) {
				viewer.setSelection(new StructuredSelection(((PaletteAspectToolEntryProxy)selectedEntryProxy).getPostActions().get(0)), true);
			}

			updateButtons();
		}
	}

	/**
	 * Call this method to update the buttons enablement.
	 */
	protected void updateButtons() {
		if(selectedEntryProxy instanceof PaletteAspectToolEntryProxy) {
			addActionButton.setEnabled(true);
			if(((PaletteAspectToolEntryProxy)selectedEntryProxy).getAspectActions().size() > 0) {
				removeActionButton.setEnabled(true);
				moveUpActionButton.setEnabled(true);
				moveDownActionButton.setEnabled(true);
			} else {
				removeActionButton.setEnabled(false);
				moveUpActionButton.setEnabled(false);
				moveDownActionButton.setEnabled(false);
			}
		} else {
			addActionButton.setEnabled(false);
			removeActionButton.setEnabled(false);
			moveUpActionButton.setEnabled(false);
			moveDownActionButton.setEnabled(false);
		}

	}

	/**
	 * Content provider for the aspect action list
	 */
	protected class AspectActionContentProvider implements ITreeContentProvider {

		/**
		 * @{inheritDoc
		 */
		public Object[] getChildren(Object parentElement) {
			if(parentElement instanceof PaletteAspectToolEntryProxy) {
				return ((PaletteAspectToolEntryProxy)parentElement).getPostActions().toArray();
			}
			return new Object[0];
		}

		/**
		 * @{inheritDoc
		 */
		public Object getParent(Object element) {
			if(element instanceof IAspectAction) {
				return selectedEntryProxy;
			}
			return null;
		}

		/**
		 * @{inheritDoc
		 */
		public boolean hasChildren(Object element) {
			return getChildren(element) != null && getChildren(element).length > 0;
		}

		/**
		 * @{inheritDoc
		 */
		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}

		/**
		 * @{inheritDoc
		 */
		public void dispose() {

		}

		/**
		 * @{inheritDoc
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

		}

	}

	/**
	 * Label provider for the aspect actions viewer
	 */
	protected class AspectActionLabelProvider implements ILabelProvider {

		/**
		 * @{inheritDoc
		 */
		public Image getImage(Object element) {
			if(element instanceof IAspectAction) {
				return ((IAspectAction)element).getImage();
			}
			return null;
		}

		/**
		 * @{inheritDoc
		 */
		public String getText(Object element) {
			if(element instanceof IAspectAction) {
				return ((IAspectAction)element).getLabel();
			}
			return "notAnAction";
		}

		/**
		 * @{inheritDoc
		 */
		public void addListener(ILabelProviderListener listener) {

		}

		/**
		 * @{inheritDoc
		 */
		public void dispose() {

		}

		/**
		 * @{inheritDoc
		 */
		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		/**
		 * @{inheritDoc
		 */
		public void removeListener(ILabelProviderListener listener) {

		}

	}

}
