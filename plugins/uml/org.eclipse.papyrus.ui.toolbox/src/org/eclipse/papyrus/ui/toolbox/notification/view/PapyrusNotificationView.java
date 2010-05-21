/*****************************************************************************
 * Copyright (c) 2010 ATOS ORIGIN.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.ui.toolbox.notification.view;


import java.util.Collection;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.papyrus.core.utils.PapyrusImageUtils;
import org.eclipse.papyrus.ui.toolbox.notification.ICallBack;
import org.eclipse.papyrus.ui.toolbox.notification.ICompositeCreator;
import org.eclipse.papyrus.ui.toolbox.notification.NotificationRunnable;
import org.eclipse.papyrus.ui.toolbox.notification.PapyrusToolkit;
import org.eclipse.papyrus.ui.toolbox.utils.ToolbooxImageUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.part.ViewPart;


/**
 * This view displays a list of notifications for users
 */

public class PapyrusNotificationView extends ViewPart implements ICallBack {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.eclipse.papyrus.ui.toolbox.notification.view.PapyrusNotificationView";

	private Action closeAllAction;

	private Action collapseAllAction;

	private Action allDefaultAction;

	private boolean isCollapse = true;

	private ScrolledForm form;

	private FormToolkit toolkit = new PapyrusToolkit(Display.getDefault());

	/**
	 * The constructor.
	 */
	public PapyrusNotificationView() {
	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		setTitleImage(PapyrusImageUtils.getDefaultIcon());
		createContent(parent);
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
	}

	/**
	 * Add a composite in the view
	 * 
	 * @param creator
	 *        , the composite creator
	 * @param collection
	 *        , the collection of actions
	 * @return the composite
	 */
	public AbstractInsideComposite setComposite(final ICompositeCreator creator, Collection<NotificationRunnable> collection) {
		MessageComposite composite = new MessageComposite(this, form, toolkit, collection) {

			@Override
			protected Control doCreateContents(FormToolkit toolkit, Composite compo) {
				Composite composite = creator.createComposite(compo, toolkit);
				setCompositeCreated(composite);
				return composite;
			}

		};
		manageComposite(composite);
		return composite;
	}

	/**
	 * Add a composite in the view
	 * 
	 * @param creator
	 *        , the composite creator
	 * @param messageTitle
	 *        , the message in the section
	 * @param collection
	 *        , the collection of actions
	 * @return the composite
	 */
	public AbstractInsideComposite setComposite(final ICompositeCreator creator, final String messageTitle, Collection<NotificationRunnable> runnables) {
		MessageComposite composite = new MessageComposite(this, form, toolkit, runnables) {

			@Override
			protected Control doCreateContents(FormToolkit toolkit, Composite composite) {
				Composite compo = creator.createComposite(composite, toolkit);
				setCompositeCreated(compo);
				return compo;
			}

			@Override
			protected String getSectionName() {
				if(messageTitle == null) {
					return super.getSectionName();
				} else {
					return messageTitle;
				}
			}
		};
		manageComposite(composite);
		return composite;
	}

	/**
	 * Add a composite in the view
	 * 
	 * @param message
	 *        , the message in the composite
	 * @param title
	 *        , the title of the section
	 * @param runnables
	 *        , the actions
	 * @return
	 */
	public AbstractInsideComposite setMessage(String message, final String title, Collection<NotificationRunnable> runnables) {
		MessageComposite compo = new MessageComposite(this, form, toolkit, runnables) {

			@Override
			protected String getSectionName() {
				if(title == null) {
					return super.getSectionName();
				} else {
					return title;
				}
			}
		};
		compo.setText(message);
		manageComposite(compo);
		return compo;
	}

	/**
	 * Add a message in the view
	 * 
	 * @param message
	 *        , the message to display
	 */
	public void setMessage(String message) {
		setMessage(message, null);
	}

	/**
	 * Add a message with a collection of actions
	 * 
	 * @param message
	 *        , the message to display
	 * @param runnables
	 *        , a collection of actions
	 */
	public void setMessage(String message, Collection<NotificationRunnable> runnables) {
		MessageComposite compo = new MessageComposite(this, form, toolkit, runnables);
		compo.setText(message);
		manageComposite(compo);
	}

	private void manageComposite(AbstractInsideComposite compo) {
		if(form.getBody().getChildren().length > 1) {
			Control previous = form.getBody().getChildren()[form.getBody().getChildren().length - 2];
			manageComposite(compo, previous);
		} else {
			manageComposite(compo, null);
		}

	}

	private void manageComposite(Control created, Control previous) {
		FormData data = new FormData();
		if(previous != null) {
			data.bottom = new FormAttachment(previous, -5);
		} else {
			data.bottom = new FormAttachment(98, -5);
		}
		data.left = new FormAttachment(0, 5);

		data.right = new FormAttachment(100, -5);
		created.setLayoutData(data);
		form.reflow(true);
		if(created instanceof AbstractInsideComposite) {
			AbstractInsideComposite inside = (AbstractInsideComposite)created;
			inside.setPrevious(previous);
		}
		if(previous instanceof AbstractInsideComposite) {
			AbstractInsideComposite inside = (AbstractInsideComposite)previous;
			inside.setAfter(created);
		}
		created.setFocus();
	}

	private void createContent(Composite parent) {
		parent.setLayout(new FillLayout(SWT.VERTICAL));
		form = toolkit.createScrolledForm(parent);
		form.getBody().setLayout(new FormLayout());
		form.setShowFocusedControl(true);
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {

			public void menuAboutToShow(IMenuManager manager) {
				PapyrusNotificationView.this.fillContextMenu(manager);
			}
		});
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(allDefaultAction);
		manager.add(closeAllAction);
		manager.add(collapseAllAction);
		manager.add(new Separator());
	}

	private void fillContextMenu(IMenuManager manager) {
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(allDefaultAction);
		manager.add(closeAllAction);
		manager.add(collapseAllAction);
	}

	private void makeActions() {
		allDefaultAction = new Action() {

			public void run() {
				for(Control c : form.getBody().getChildren()) {
					if(c instanceof AbstractInsideComposite) {
						AbstractInsideComposite compo = (AbstractInsideComposite)c;
						compo.runDefault();
					}
				}
				form.getBody().layout(true, true);
				form.layout(true, true);
			}
		};
		allDefaultAction.setText("Run all default action");
		allDefaultAction.setToolTipText("Run all default action");
		allDefaultAction.setImageDescriptor(ToolbooxImageUtils.getImageDescriptor(org.eclipse.papyrus.ui.toolbox.utils.ISharedImages.IMG_RUN));
		closeAllAction = new Action() {

			public void run() {
				for(Control c : form.getBody().getChildren()) {
					c.dispose();
				}
				form.getBody().layout(true, true);
				form.layout(true, true);
			}
		};
		closeAllAction.setText("Close All");
		closeAllAction.setToolTipText("Close all the messages");
		closeAllAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_DELETE));
		collapseAllAction = new Action() {

			public void run() {
				for(Control c : form.getBody().getChildren()) {
					if(c instanceof AbstractInsideComposite) {
						AbstractInsideComposite compo = (AbstractInsideComposite)c;
						if(isCollapse) {
							compo.collapse();
						} else {
							compo.expand();
						}
					}
				}
				isCollapse = !isCollapse;
				if(isCollapse) {
					collapseAllAction.setText("Collapse all the messages");
					collapseAllAction.setToolTipText("Collapse all the messages");
				} else {
					collapseAllAction.setText("Expand all the messages");
					collapseAllAction.setToolTipText("Expand all the messages");
				}
				form.getBody().layout(true, true);
				form.layout(true, true);
			}
		};
		collapseAllAction.setText("Collapse all the messages");
		collapseAllAction.setToolTipText("Collapse all the messages");
		collapseAllAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ELCL_COLLAPSEALL));
	}

	private void hookDoubleClickAction() {
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		form.setFocus();
	}

	/*
	 * (non-Javadoc)
	 * this method update the after and previous attributes to update the layout
	 * 
	 * @see org.eclipse.papyrus.ui.toolbox.notification.view.ICloseCallBack#closed(java.lang.Object)
	 */
	public void callBack(Object element) {
		destroy(element);
	}

	/**
	 * This method destroy the object if it is contained in the view
	 * 
	 * @param element
	 */
	protected void destroy(Object element) {
		if(element instanceof AbstractInsideComposite) {
			AbstractInsideComposite inside = (AbstractInsideComposite)element;
			Control previous = inside.getPrevious();
			Control after = inside.getAfter();
			if(after != null) {
				manageComposite(after, previous);
			} else {
				if(previous instanceof AbstractInsideComposite) {
					AbstractInsideComposite compo = (AbstractInsideComposite)previous;
					compo.setAfter(null);
				}
			}
			inside.dispose();
			form.getBody().layout(true, true);
			form.layout(true, true);
		}
	}
}
