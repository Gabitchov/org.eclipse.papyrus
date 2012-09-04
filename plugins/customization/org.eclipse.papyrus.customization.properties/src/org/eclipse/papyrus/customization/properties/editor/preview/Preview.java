/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.properties.editor.preview;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.ITreeElement;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.papyrus.customization.properties.Activator;
import org.eclipse.papyrus.customization.properties.editor.UIEditor;
import org.eclipse.papyrus.customization.properties.messages.Messages;
import org.eclipse.papyrus.customization.properties.model.xwt.resource.XWTResource;
import org.eclipse.papyrus.views.properties.contexts.Section;
import org.eclipse.papyrus.views.properties.contexts.Tab;
import org.eclipse.papyrus.views.properties.contexts.View;
import org.eclipse.papyrus.views.properties.runtime.DefaultDisplayEngine;
import org.eclipse.papyrus.views.properties.runtime.DisplayEngine;
import org.eclipse.papyrus.views.properties.widgets.layout.PropertiesLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

/**
 * The Preview section of the Customization editor.
 * Displays the given view in a Tab Folder.
 * The preview uses the same Display Engine as the Property view, which should lead
 * to the same results, with a few exceptions :
 * - The Tab Folder has an Horizontal layout for its tabs, while the property view has
 * a vertical layout
 * - The preview is read-only : all actions are disabled. This means that it is
 * not possible to preview dialogs, for example
 * - The Enum and References fields are empty
 * - Some buttons may be marked as disabled, but will be available at runtime (Or vice-versa)
 * - The dynamic sections are always displayed
 * 
 * The preview can be disabled for performance issues
 * 
 * @author Camille Letavernier
 */
public class Preview extends ViewPart implements ISelectionChangedListener, IPartListener {

	private Composite parent;

	private ScrolledComposite scrolledParent;

	private CTabFolder contents;

	private DisplayEngine displayEngine;

	private String selectedTab;

	private boolean enabled = true;

	private View currentView;

	private Label previewTitle;

	private Label previewDisabled;

	private Set<UIEditor> currentEditors = new HashSet<UIEditor>();

	private IWorkbenchPage activePage;

	/**
	 * Constructor.
	 * Constructs a new Preview in a View. The preview will change depending
	 * on the current active UIEditor.
	 */
	public Preview() {
	}

	/**
	 * Constructor.
	 * Constructs a new Preview in an editor (Embedded preview)
	 * 
	 * @param editor
	 */
	public Preview(UIEditor editor) {
		this.currentEditors.add(editor);
	}

	/**
	 * Creates the preview control in the given composite.
	 * 
	 * @param container
	 *        The SWT Composite in which the preview should be displayed
	 */
	@Override
	public void createPartControl(Composite container) {
		scrolledParent = new ScrolledComposite(container, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		scrolledParent.getVerticalBar().setIncrement(10);
		scrolledParent.setBackground(new Color(scrolledParent.getDisplay(), 255, 255, 255));
		scrolledParent.setBackgroundMode(SWT.INHERIT_DEFAULT);
		scrolledParent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		parent = new Composite(scrolledParent, SWT.NONE);
		parent.setLayout(new GridLayout(1, false));

		scrolledParent.setContent(parent);

		Composite controls = new Composite(parent, SWT.NONE);
		controls.setLayout(new GridLayout(5, false));
		controls.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		GridData data;

		//		Label preview = new Label(controls, SWT.NONE);
		//		preview.setImage(Activator.getDefault().getImage("/icons/preview.png")); //$NON-NLS-1$
		//		data = new GridData(SWT.CENTER, SWT.BEGINNING, false, false);
		//		preview.setLayoutData(data);

		//		Label previewText = new Label(controls, SWT.NONE);
		//		previewText.setText(Messages.Preview_preview);
		//		data = new GridData(SWT.CENTER, SWT.BEGINNING, false, false);
		//		previewText.setLayoutData(data);

		previewTitle = new Label(controls, SWT.NONE);
		data = new GridData(SWT.CENTER, SWT.BEGINNING, false, false);
		previewTitle.setLayoutData(data);

		//		final Button togglePreview = new Button(controls, SWT.CHECK);
		//		togglePreview.setText(Messages.Preview_disablePreview);
		//		togglePreview.addSelectionListener(new SelectionListener() {
		//
		//			public void widgetSelected(SelectionEvent e) {
		//				enabled = !enabled;
		//				displayView();
		//			}
		//
		//			public void widgetDefaultSelected(SelectionEvent e) {
		//				//Nothing
		//			}
		//
		//		});

		previewDisabled = new Label(parent, SWT.NONE);
		previewDisabled.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		contents = new CTabFolder(parent, SWT.VERTICAL);

		//If currentEditors is empty, the preview is displayed in a view and
		//should listen to the workbench to know about the activeEditor
		if(currentEditors.isEmpty()) {

			IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			if(window != null) {
				activePage = window.getActivePage();
				if(activePage != null) {
					IEditorPart editorPart = activePage.getActiveEditor();
					if(editorPart instanceof UIEditor) {
						setEditor((UIEditor)editorPart);
					}

					activePage.addPartListener(this);
				} else {
					Activator.log.warn("There is no active page"); //$NON-NLS-1$
				}
			} else {
				Activator.log.warn("There is no current window"); //$NON-NLS-1$
			}
		}

		displayView();
	}

	/**
	 * Sets the current Editor
	 * 
	 * @param editor
	 */
	public void setEditor(UIEditor editor) {
		editor.addPreview(this);
		currentEditors.add(editor);
	}

	private void refreshDisplay() {
		Point size = parent.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		if(scrolledParent.getSize().x > 0) {
			size.x = scrolledParent.getSize().x - 30;
		}
		parent.setSize(size);
	}

	/**
	 * Saves the section's XWT Resource in a temporary file, which
	 * can then be interpreted by XWT. Returns the URL to this file.
	 * 
	 * @param section
	 *        The section for which we want to persist the XWT Resource
	 * @return
	 *         The URL to the XWT Resource
	 */
	private URL saveTmp(Section section) {
		if(section.getSectionFile() == null || section.getWidget() == null) {
			return null;
		}

		IPath path = Activator.getDefault().getPreferencesPath();
		path = path.append("/preview/"); //$NON-NLS-1$
		try {
			File previewDirectory = path.toFile();
			if(!previewDirectory.exists()) {
				previewDirectory.mkdirs();
			}

			File xwtFile = path.append(section.getSectionFile()).toFile();

			if(!xwtFile.exists()) {
				xwtFile.getParentFile().mkdirs();
				xwtFile.createNewFile();
			}

			OutputStream os = new FileOutputStream(xwtFile);
			Map<Object, Object> options = new HashMap<Object, Object>();
			//The outputstream cannot be formatted. If format is true, this is
			//the real file (and not the preview file) that will be formatted
			options.put(XWTResource.OPTION_FORMAT, false);
			if(section.getWidget() == null || section.getWidget().eResource() == null) {
				return null;
			}
			section.getWidget().eResource().save(os, options);
			return xwtFile.toURI().toURL();
		} catch (IOException ex) {
			Activator.log.error(ex);
		}

		return null;
	}

	/**
	 * Sets the view to display in the preview
	 * 
	 * @param view
	 *        The view to display
	 */
	public void setView(View view) {
		this.currentView = view;
		if(view != null) {
			if(view.getName() == null) {
				previewTitle.setText(Messages.Preview_Unnamed);
			} else {
				previewTitle.setText(view.getName());
			}
		} else {
			previewTitle.setText(""); //$NON-NLS-1$
		}

		previewTitle.getParent().layout();
		displayView();
	}

	private void setPreviewError(String message) {
		if(message != null) {
			previewDisabled.setText(message);
			previewDisabled.setVisible(true);
		} else {
			previewDisabled.setVisible(false);
		}
		refreshDisplay();
	}

	/**
	 * Display the current view. When the view to display has changed,
	 * you should call {@link #setView(View)} instead.
	 */
	public void displayView() {
		contents.dispose();

		if(!enabled) {
			setPreviewError(Messages.Preview_previewIsDisabled);
			return;
		}

		if(currentView == null) {
			setPreviewError(Messages.Preview_noSelectedView);
			return;
		}

		setPreviewError(null);

		displayEngine = new DefaultDisplayEngine();
		Map<Tab, Composite> tabs = new HashMap<Tab, Composite>();

		contents = new CTabFolder(parent, SWT.NONE);
		contents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		boolean activeTab = false;

		for(Tab tab : getTabs(currentView)) {
			CTabItem tabItem = new CTabItem(contents, SWT.NONE);
			tabItem.setText(tab.getLabel());

			if(tab.getLabel().equals(selectedTab) || !activeTab) {
				contents.setSelection(tabItem);
				activeTab = true;
			}

			Composite tabControl = new Composite(contents, SWT.NONE);
			tabControl.setLayout(new PropertiesLayout());

			tabItem.setControl(tabControl);

			tabs.put(tab, tabControl);
			tabControl.setEnabled(false);

			contents.addListener(SWT.Selection, new Listener() {

				public void handleEvent(Event event) {
					selectedTab = contents.getSelection().getText();
				}

			});
		}

		for(Section section : currentView.getSections()) {
			Composite tabControl = tabs.get(section.getTab());
			if (tabControl == null){
				Activator.log.warn("The section doesn't have a tab"); //Bug in section deletion: it is still referenced by the views
				continue;
			}
			Composite pView = new Composite(tabControl, SWT.NONE);
			pView.setLayout(new GridLayout(1, false));
			URL sectionURL = saveTmp(section);
			if(sectionURL != null) {
				displayEngine.createSection(pView, section, sectionURL, null);
			}
		}

		refreshDisplay();
	}

	private Collection<Tab> getTabs(View view) {

		List<Tab> tabs = new LinkedList<Tab>();

		for(Section section : view.getSections()) {
			Tab tab = section.getTab();
			if(tab != null && !tabs.contains(tab)) {
				tabs.add(tab);
			}
		}

		Collections.sort(tabs, new Comparator<Tab>() {

			public int compare(Tab tab1, Tab tab2) {
				Tab afterTab1 = tab1.getAfterTab();
				Tab afterTab2 = tab2.getAfterTab();

				if(isAfter(tab1, afterTab2, new HashSet<Tab>())) {
					return -1;
				}

				if(isAfter(tab2, afterTab1, new HashSet<Tab>())) {
					return 1;
				}

				return 0;
			}

		});

		return tabs;
	}

	private boolean isAfter(Tab tab1, Tab tab2, Set<Tab> checkedTabs) {
		if(checkedTabs.contains(tab2)) {
			Activator.log.warn("Loop in the afterTabs"); //$NON-NLS-1$
			return false;
		}

		checkedTabs.add(tab2);

		if(tab2 == null) {
			return false;
		}

		if(tab1.equals(tab2)) {
			return true;
		}

		return isAfter(tab1, tab2.getAfterTab(), checkedTabs);
	}

	/**
	 * The preview listens on
	 * 
	 * @param event
	 *        The SelectionChangedEvent
	 */
	public void selectionChanged(SelectionChangedEvent event) {
		IStructuredSelection selection = (IStructuredSelection)event.getSelection();
		if(selection.size() == 1) {
			ITreeElement child = null;
			ITreeElement element = (ITreeElement)selection.getFirstElement();

			do {

				if(element instanceof IAdaptable) {
					EObject adapter = (EObject)((IAdaptable)element).getAdapter(EObject.class);
					if(adapter instanceof View) {
						setView((View)adapter);
						return;
					}
				}

				child = element;
				element = element.getTreeParent();
			} while(child != element && element != null);
		}
	}

	/**
	 * Activate or deactivate the preview
	 * 
	 * @param enabled
	 *        If true, the preview will be activated. Otherwise, it will
	 *        be disabled
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public void setFocus() {
		parent.setFocus();
	}

	public void partActivated(IWorkbenchPart part) {
		if(part instanceof UIEditor) {
			setEditor((UIEditor)part);
		}
	}

	public void partBroughtToTop(IWorkbenchPart part) {
		//Nothing
	}

	public void partClosed(IWorkbenchPart part) {
		//Nothing
	}

	public void partDeactivated(IWorkbenchPart part) {
		//Nothing
	}

	public void partOpened(IWorkbenchPart part) {
		//Nothing
	}

	@Override
	public void dispose() {
		for(UIEditor editor : currentEditors) {
			editor.removePreview(this);
		}
		if(activePage != null) {
			activePage.removePartListener(this);
		}
		super.dispose();
	}

}
