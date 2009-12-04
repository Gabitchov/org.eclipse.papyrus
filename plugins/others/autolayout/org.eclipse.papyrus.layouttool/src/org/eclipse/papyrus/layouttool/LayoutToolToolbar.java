/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Alexia Allanic (Atos Origin) alexia.allanic@atosorigin.com - LayoutToolToolbar Implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.layouttool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.EditPart;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.layouttool.managealgorithms.ZestAlgortihms;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.ToolTip;
import org.eclipse.ui.PlatformUI;

/**
 * The class LayoutToolToolbar.
 */
public class LayoutToolToolbar extends ContributionItem {

	/** The image layout. */
	private static Image imageLayout = null;

	/** The selection. */
	private ISelection theSelection;

	/** The algorithmes. */
	private Collection<LayoutToolAlgorithms> algorithmes = ZestAlgortihms.getRegisteredAlgorithmes();

	/** The menu. */
	private Menu menu = null;

	/** The current algorithm. */
	private LayoutToolAlgorithms currentAlgorithm;

	/** The toolbar. */
	private ToolBar toolbar;

	/** The item for menu. */
	private ToolItem itemForMenu;

	/** The item drop down. */
	private ToolItem itemDropDown;

	/** The current tool tip. */
	private ToolTip currentToolTip = null;

	/** The item layout text. */
	private String itemLayoutText = "Add layout area";

	/** The layout tool tip text. */
	private String layoutToolTipText = "Draw a layout area resizable around nodes, algorithms will be apply to this area";

	/** The layout tool tip. */
	private ToolTip layoutToolTip = null;

	static {
		try {
			imageLayout = new Image(Display.getDefault(), Activator.getDefault().getBundle().getEntry(
					"icons/layoutIcon.gif").openStream());
		} catch (IOException e) {
			Activator.getDefault().log("Cannot load layoutIcon", e);
		}
	}

	/**
	 * Instantiates a new layout tool toolbar.
	 */
	public LayoutToolToolbar() {
		this("LayoutToolToolbar");
	}

	/**
	 * Instantiates a new layout tool toolbar.
	 * 
	 * @param id
	 *        the id
	 */
	public LayoutToolToolbar(String id) {
		super(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.ContributionItem#fill(org.eclipse.swt.widgets.ToolBar, int)
	 */
	@Override
	public void fill(final ToolBar toolBar, int index) {
		this.toolbar = toolBar;
		itemDropDown = new ToolItem(toolBar, SWT.DROP_DOWN);
		if(currentAlgorithm == null) {
			itemDropDown.setImage(imageLayout);
		} else {
			itemDropDown.setImage(currentAlgorithm.getIcon());
		}
		itemDropDown.setText("");
		getMenu(toolBar);
		itemDropDown.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {
				getMenu(toolbar);
				if(event.detail == SWT.ARROW) {
					Rectangle bounds = itemDropDown.getBounds();
					Point point = toolBar.toDisplay(bounds.x, bounds.y + bounds.height);
					menu.setLocation(point);
					menu.setVisible(true);
				}
			}
		});

		Listener selectionListener = new Listener() {

			public void handleEvent(Event event) {
				getSelection();
				if(currentAlgorithm == null && event.y == 0 && itemForMenu.getData() != null
						&& itemForMenu.getData().equals(itemLayoutText)) {
					createLayoutArea();
				}
				if(hasElementsSelected()) {
					if(event.y == 0) {
						if(currentAlgorithm != null) {
							callAlgorithm();
						}
					}
					for(MenuItem menuItem : menu.getItems()) {
						menuItem.setEnabled(true);
					}
				} else {
					for(MenuItem menuItem : menu.getItems()) {
						if(!menuItem.getText().equals(itemLayoutText)) {
							menuItem.setEnabled(false);
						}
					}
				}

			}

		};
		itemDropDown.addListener(SWT.Selection, selectionListener);
	}

	/**
	 * Gets the menu.
	 * 
	 * @param parent
	 *        the parent
	 * 
	 * @return Menu
	 */
	public Menu getMenu(Control parent) {
		menu = new Menu(parent);
		insertIntoMenuAlgorithms();
		if(menu.getItems().length > 0) {
			if(parent instanceof ToolBar) {
				toolbar = (ToolBar)parent;
				if(toolbar.getItems().length == 1) {
					itemForMenu = toolbar.getItem(0);
				}
			}
		}
		createLayoutAreaIcon();
		return menu;
	}

	/**
	 * Add algorithms into the menu.
	 */
	private void insertIntoMenuAlgorithms() {
		if(algorithmes == null || algorithmes.isEmpty()) {
			Activator.getDefault().log("Algorithms not found");
			return;
		}
		Map<String, Menu> mapMenuPath = new HashMap<String, Menu>();
		for(final LayoutToolAlgorithms a : algorithmes) {
			Menu submenu = menu;
			if(a.getPath() != null) {
				String[] pathSplit = a.getPath().split("\\.");
				String subString = "";
				for(int i = 0; i < pathSplit.length; i++) {
					subString += pathSplit[i];
					if(!mapMenuPath.keySet().contains(subString)) {
						MenuItem itemPath = new MenuItem(submenu, SWT.CASCADE);
						itemPath.setText(pathSplit[i]);
						submenu = new Menu(submenu);
						itemPath.setMenu(submenu);
						mapMenuPath.put(subString, submenu);
					} else {
						for(String path : mapMenuPath.keySet()) {
							if(subString.equals(path)) {
								submenu = mapMenuPath.get(path);
							}
						}
					}
					subString += ".";
				}
			}
			final MenuItem item = new MenuItem(submenu, SWT.RADIO);
			item.setText(a.getName());
			item.setImage(a.getIcon());
			item.setData(a);
			if(a.getToolTipText() != null) {
				final ToolTip toolTip = new ToolTip(menu.getShell(), SWT.NONE);
				toolTip.setText(item.getText());
				toolTip.setMessage(((LayoutToolAlgorithms)item.getData()).getToolTipText());
				item.addListener(SWT.Arm, new Listener() {

					public void handleEvent(Event event) {
						if(currentToolTip != null) {
							currentToolTip.setVisible(false);
						}
						if(layoutToolTip != null) {
							layoutToolTip.setVisible(false);
						}
						currentToolTip = toolTip;
						Point mouse = Display.getDefault().getCursorLocation();
						int x = mouse.x + 20;
						int y = mouse.y + 30;
						toolTip.setLocation(new Point(x, y));
						toolTip.setVisible(true);
					}
				});
			} else {
				item.addListener(SWT.Arm, new Listener() {

					public void handleEvent(Event event) {
						if(currentToolTip != null) {
							currentToolTip.setVisible(false);
							currentToolTip = null;
						}
						if(layoutToolTip != null) {
							layoutToolTip.setVisible(false);
						}
					}
				});
			}
			item.addSelectionListener(new SelectionListener() {

				public void widgetDefaultSelected(SelectionEvent e) {
				}

				public void widgetSelected(SelectionEvent e) {
					if(((MenuItem)e.getSource()).getSelection()) {
						if(currentToolTip != null) {
							currentToolTip.setVisible(false);
						}
						handleSelected(e, item);
					}
				}
			});
		}
	}

	/**
	 * Handle selected.
	 * 
	 * @param e
	 *        the e
	 * @param item
	 *        the item
	 */
	private void handleSelected(SelectionEvent e, MenuItem item) {
		LayoutToolAlgorithms layoutToolAlgorithms = (LayoutToolAlgorithms)item.getData();
		if(itemForMenu != null) {
			itemForMenu.setImage(layoutToolAlgorithms.getIcon());
			if(layoutToolAlgorithms.getToolTipText() != null) {
				itemForMenu.setToolTipText(layoutToolAlgorithms.getToolTipText());
			} else {
				itemForMenu.setToolTipText(null);
			}
		}
		currentAlgorithm = layoutToolAlgorithms;
		callAlgorithm();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.ContributionItem#dispose()
	 */
	public void dispose() {
	}

	/**
	 * Run.
	 * 
	 * @param action
	 *        the action
	 */
	public void run(IAction action) {
		callAlgorithm();
	}

	/**
	 * Call algorithm.
	 */
	private void callAlgorithm() {
		if(currentAlgorithm == null) {
			MessageDialog.openWarning(Display.getDefault().getActiveShell(), "Warning", "Please choose an algorithm");
			return;
		}
		LayoutTool.getInstance().applyLayout(currentAlgorithm.getName(), getEditPartSelected());
	}

	/**
	 * Selection changed.
	 * 
	 * @param action
	 *        the action
	 * @param selection
	 *        the selection
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		theSelection = selection;
	}

	/**
	 * Gets the selection.
	 * 
	 * @return selection
	 */
	public ISelection getSelection() {
		theSelection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getSite()
				.getSelectionProvider().getSelection();
		return theSelection;
	}

	/**
	 * Gets the edit part selected.
	 * 
	 * @return list editParts selected
	 */
	public List<EditPart> getEditPartSelected() {
		List<EditPart> editParts = new ArrayList<EditPart>();
		if(theSelection instanceof IStructuredSelection) {
			IStructuredSelection selec = (IStructuredSelection)theSelection;
			List objects = selec.toList();
			for(Object iter : objects) {
				if(iter instanceof EditPart) {
					EditPart e = (EditPart)iter;
					editParts.add(e);
				}
			}
		}
		sort(editParts);
		return editParts;
	}

	/**
	 * Sort editParts to have editParts which have less parents in first.
	 * 
	 * @param editParts
	 *        the edit parts
	 */
	public static void sort(List<EditPart> editParts) {
		Collections.sort(editParts, new Comparator<EditPart>() {

			public int compare(EditPart arg0, EditPart arg1) {
				return getNbParents(arg0) - getNbParents(arg1);
			}
		});
	}

	/**
	 * Gets the nb parents.
	 * 
	 * @param part
	 *        editPart
	 * 
	 * @return number parents of the editPart
	 */
	private static int getNbParents(EditPart part) {
		int result = 0;
		EditPart tmp = part;
		while(tmp.getParent() != null) {
			result++;
			tmp = tmp.getParent();
		}
		return result;
	}

	/**
	 * Checks for elements selected.
	 * 
	 * @return false if 0 or 1 element selected else return true
	 */
	private boolean hasElementsSelected() {
		List<EditPart> l = getEditPartSelected();
		return !(l.size() <= 1);
	}

	/**
	 * create layout area.
	 */
	private void createLayoutArea() {
		LayoutToolExtensionPointManager.getInstance().getLayoutAreaCreator().paintLayoutArea();
	}

	/**
	 * create layout area icon.
	 */
	private void createLayoutAreaIcon() {
		if(LayoutToolExtensionPointManager.getInstance().getLayoutAreaCreator() != null) {
			new MenuItem(menu, SWT.SEPARATOR);

			final MenuItem itemLayout = new MenuItem(menu, SWT.PUSH);
			itemLayout.setText(itemLayoutText);
			try {
				itemLayout.setImage(new Image(Display.getDefault(), Activator.getDefault().getBundle().getEntry(
						"icons/layout_area.gif").openStream()));
			} catch (IOException e) {
				Activator.getDefault().log("Cannot load layout area icon", e);
			}
			layoutToolTip = new ToolTip(menu.getShell(), SWT.NONE);
			itemLayout.addListener(SWT.Arm, new Listener() {

				public void handleEvent(Event event) {
					if(currentToolTip != null) {
						currentToolTip.setVisible(false);
					}
					layoutToolTip.setText(itemLayout.getText());
					layoutToolTip.setMessage(layoutToolTipText);
					layoutToolTip.setVisible(true);
					Point mouse = Display.getDefault().getCursorLocation();
					int x = mouse.x + 20;
					int y = mouse.y + 30;
					layoutToolTip.setLocation(new Point(x, y));
				}
			});
			itemLayout.addSelectionListener(new SelectionListener() {

				public void widgetDefaultSelected(SelectionEvent e) {
				}

				public void widgetSelected(SelectionEvent e) {
					if(layoutToolTip != null) {
						layoutToolTip.setVisible(false);
					}
					createLayoutArea();
					currentAlgorithm = null;
					itemForMenu.setImage(itemLayout.getImage());
					itemForMenu.setData(itemLayoutText);
					itemForMenu.setToolTipText(layoutToolTipText);
				}
			});
		}
	}
}
