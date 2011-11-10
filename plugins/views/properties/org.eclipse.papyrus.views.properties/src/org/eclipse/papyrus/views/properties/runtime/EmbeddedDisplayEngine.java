/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.runtime;

import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.papyrus.views.properties.contexts.Section;
import org.eclipse.papyrus.views.properties.contexts.Tab;
import org.eclipse.papyrus.views.properties.contexts.View;
import org.eclipse.papyrus.views.properties.xwt.XWTSection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ISection;

/**
 * A Property View display engine which can be embedded in a composite
 * 
 * @author Camille Letavernier
 */
public class EmbeddedDisplayEngine extends DefaultDisplayEngine implements SelectionListener {

	private String lastTabId;

	/**
	 * The displayed CTabFolder
	 * May be null
	 */
	protected CTabFolder currentFolder;

	protected Composite self;

	/**
	 * The currently displayed sections
	 */
	protected Set<ISection> displayedSections = new HashSet<ISection>();

	/**
	 * 
	 * @param views
	 * @param parent
	 * @param selection
	 * @param style
	 *        SWT.BOTTOM or SWT.TOP (Tabs' position)
	 */
	public void display(Set<View> views, Composite parent, ISelection selection, int style) {
		disposeControls();

		self = new Composite(parent, SWT.NONE);

		self.setLayout(new FillLayout());

		final Set<Tab> tabsList = new LinkedHashSet<Tab>();

		for(View view : views) {
			for(Section section : view.getSections()) {
				tabsList.add(section.getTab());
			}
		}

		List<Tab> allTabs = new LinkedList<Tab>(tabsList);

		Collections.sort(allTabs, new Comparator<Tab>() {

			/**
			 * compares two tabs each other
			 * 
			 * @param tab1
			 *        first tab to compare
			 * @param tab2
			 *        second tab to compare
			 * @return a negative integer if the first tab should be placed before the second tab
			 */
			public int compare(Tab tab1, Tab tab2) {
				int priority1 = getPriority(tab1);
				int priority2 = getPriority(tab2);

				if(priority1 < priority2) {
					return -1;
				}

				if(priority1 > priority2) {
					return 1;
				}

				//p1 == p2

				priority1 = getXWTTabPriority(tab1);
				priority2 = getXWTTabPriority(tab2);

				if(priority1 < priority2) {
					return -1;
				}

				if(priority1 > priority2) {
					return 1;
				}

				//p1 == p2

				String label1 = tab1.getLabel();
				String label2 = tab2.getLabel();

				return Collator.getInstance().compare(label1, label2);
			}

			private Tab getPreviousTab(Tab tab) {
				Tab afterTab = tab.getAfterTab();
				if(tabsList.contains(afterTab)) {
					return afterTab;
				}

				// not found. Return null
				return null;
			}

			private int getPriority(Tab tab) {
				Tab previousTab = getPreviousTab(tab);
				if(previousTab != null) {
					return getPriority(previousTab) + 1;
				}

				return getXWTTabPriority(tab);
			}

			private int getXWTTabPriority(Tab tab) {
				return tab.getPriority();
			}

		});

		Map<Tab, Composite> tabs = new LinkedHashMap<Tab, Composite>();

		if(allTabs.size() > 1) {
			CTabItem selectedTab = null;

			currentFolder = new CTabFolder(self, style);
			currentFolder.setSelectionBackground(new Color[]{ currentFolder.getDisplay().getSystemColor(SWT.COLOR_WHITE), currentFolder.getBackground() }, new int[]{ 100 }, true);
			currentFolder.setLayout(new FillLayout());
			for(Tab tab : allTabs) {
				CTabItem item = new CTabItem(currentFolder, SWT.NONE);
				Composite tabControl = new Composite(currentFolder, SWT.NONE);
				item.setControl(tabControl);
				item.setText(tab.getLabel());
				item.setData("id", tab.getId()); //$NON-NLS-1$
				if(tab.getId().equals(lastTabId)) {
					selectedTab = item;
				}
				tabs.put(tab, tabControl);
			}
			currentFolder.addSelectionListener(this);


			if(selectedTab == null) {
				selectedTab = currentFolder.getItem(0);
			}

			currentFolder.setSelection(selectedTab);
		} else if(!allTabs.isEmpty()) {
			Tab tab = allTabs.get(0);
			tabs.put(tab, self);
		} else {
			return;
		}

		for(View view : views) {
			for(Section section : view.getSections()) {
				XWTSection xwtSection = new XWTSection(section, view, this);

				xwtSection.createControls(tabs.get(section.getTab()), null);
				xwtSection.setInput(null, selection);
				xwtSection.refresh();

				displayedSections.add(xwtSection);
			}
		}

		self.layout();
	}

	@Override
	protected void disposeControls() {
		super.disposeControls();
		if(self != null) {
			self.dispose();
			self = null;
			currentFolder = null;
		}

		//		if(currentFolder != null) {
		//			currentFolder.dispose();
		//			currentFolder = null;
		//		}

		for(ISection section : displayedSections) {
			section.dispose();
		}
	}

	public void widgetSelected(SelectionEvent e) {
		if(e.widget instanceof CTabFolder) {
			CTabFolder folder = (CTabFolder)e.widget;
			CTabItem lastTab = folder.getSelection();
			Object lastId = lastTab.getData("id"); //$NON-NLS-1$
			if(lastId != null && lastId instanceof String) {
				lastTabId = (String)lastId;
			}
		}
	}

	public void widgetDefaultSelected(SelectionEvent e) {
		//Nothing
	}

}
