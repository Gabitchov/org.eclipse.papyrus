/*****************************************************************************
 * Copyright (c) 2011, 2013 CEA LIST and others.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA LIST) - Consolidate all hyperlink helper contributions into one tab
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.hyperlink.ui;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.hyperlink.Activator;
import org.eclipse.papyrus.infra.hyperlink.helper.AbstractHyperLinkHelper;
import org.eclipse.papyrus.infra.hyperlink.helper.CompositeHyperlinkHelper;
import org.eclipse.papyrus.infra.hyperlink.messages.Messages;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkObject;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.widgets.providers.CollectionContentProvider;
import org.eclipse.papyrus.infra.widgets.util.PopupButtonMenu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;

/**
 * this class is GUI that represent a tab for each kind of hyperlink
 * for example a tab for diagram, for web links...
 * 
 */

//TODO change the methods to get images after the refactoring
public class HyperLinkTab extends AbstractHyperLinkTab {

	/**
	 * The Class DiagramContentProvider.
	 */
	protected CTabItem hyperlinksTab;

	protected Table hyperLinkListTable;

	protected Button newHyperLinkbutton;

	protected Button modifyHyperLinkButton;

	protected Button removeHyperLinkButton;

	protected Button upHyperLinkButton;

	protected Button downHyperLinkButton;

	protected TableViewer tableViewer;

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public HyperLinkTab() {
		//nothing to do
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param tabId
	 * @param helpers
	 */
	public HyperLinkTab(String tabId, Collection<? extends AbstractHyperLinkHelper> helpers) {
		super(tabId, (helpers.size() == 1) ? helpers.iterator().next() : new CompositeHyperlinkHelper(helpers));
	}

	/**
	 * get TableVeiver
	 * 
	 * @return
	 */
	public TableViewer getTableViewer() {
		return tableViewer;
	}

	/**
	 * 
	 * @return the list of hyperlink displayed in the tab
	 */
	@Override
	public List<HyperLinkObject> getHyperlinkObjects() {
		return hyperlinkObjects;
	}

	/**
	 * set list of hyperlinks to display in the tab
	 * 
	 * @param hyperlinkObjects
	 */
	public void setHyperlinkObjects(List<HyperLinkObject> hyperlinkObjects) {
		this.hyperlinkObjects = hyperlinkObjects;
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.hyperlink.ui.AbstractHyperLinkTab#init(org.eclipse.swt.custom.CTabFolder, java.util.List,
	 *      org.eclipse.emf.ecore.EObject)
	 * 
	 * @param cTabFolder
	 * @param hyperlinkObjects
	 * @param element
	 */
	@Override
	public void init(CTabFolder cTabFolder, List<HyperLinkObject> hyperlinkObjects, EObject element/* , IHyperLinkShell parent */) {
		super.init(cTabFolder, hyperlinkObjects, element /* , parent */);
		CTabItem cTabItem2 = new CTabItem(cTabFolder, SWT.NONE);
		cTabItem2.setText(Messages.HyperLinkTab_title);
		Composite diagramComposite = new Composite(cTabFolder, SWT.NONE);
		cTabItem2.setControl(diagramComposite);
		GridData gridData4 = new GridData();
		gridData4.horizontalAlignment = GridData.FILL;
		gridData4.verticalAlignment = GridData.CENTER;
		GridData gridData3 = new GridData();
		gridData3.horizontalAlignment = GridData.FILL;
		gridData3.verticalAlignment = GridData.CENTER;
		GridData gridData2 = new GridData();
		gridData2.horizontalAlignment = GridData.FILL;
		gridData2.verticalAlignment = GridData.CENTER;
		GridData gridData1 = new GridData();
		gridData1.verticalAlignment = GridData.FILL;
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.grabExcessVerticalSpace = true;
		gridData1.verticalSpan = 6;
		gridData1.horizontalAlignment = GridData.FILL;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		gridLayout.makeColumnsEqualWidth = false;

		diagramComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		diagramComposite.setLayout(gridLayout);
		CLabel listLabel = new CLabel(diagramComposite, SWT.SHADOW_NONE);
		listLabel.setText(Messages.HyperLinkTab_Listof);
		listLabel.setEnabled(false);
		listLabel.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));

		new Label(diagramComposite, SWT.NONE);
		hyperLinkListTable = new Table(diagramComposite, SWT.BORDER | SWT.MULTI);
		tableViewer = new TableViewer(hyperLinkListTable);

		newHyperLinkbutton = new Button(diagramComposite, SWT.PUSH);
		newHyperLinkbutton.setText(""); //$NON-NLS-1$
		newHyperLinkbutton.setImage(org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage("/icons/Add_16x16.gif")); //$NON-NLS-1$
		newHyperLinkbutton.setLayoutData(gridData4);
		newHyperLinkbutton.setToolTipText("New hyperlink");

		hyperLinkListTable.setHeaderVisible(false);
		hyperLinkListTable.setToolTipText(Messages.HyperLinkTab_SetOf);
		hyperLinkListTable.setLayoutData(gridData1);
		hyperLinkListTable.setLinesVisible(false);
		modifyHyperLinkButton = new Button(diagramComposite, SWT.NONE);
		modifyHyperLinkButton.setImage(org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage("/icons/Edit_16x16.gif")); //$NON-NLS-1$ 
		modifyHyperLinkButton.setToolTipText("Edit hyperlink");

		removeHyperLinkButton = new Button(diagramComposite, SWT.NONE);
		removeHyperLinkButton.setText(""); //$NON-NLS-1$
		removeHyperLinkButton.setImage(org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage("/icons/Delete_16x16.gif")); //$NON-NLS-1$ 
		removeHyperLinkButton.setToolTipText("Remove hyperlink");

		upHyperLinkButton = new Button(diagramComposite, SWT.NONE);
		upHyperLinkButton.setImage(org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage("/icons/ArrowUp_16x16.gif")); //$NON-NLS-1$ 
		upHyperLinkButton.setToolTipText("Move hyperlink up");

		upHyperLinkButton.setLayoutData(gridData2);
		downHyperLinkButton = new Button(diagramComposite, SWT.NONE);
		downHyperLinkButton.setImage(org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage("/icons/ArrowDown_16x16.gif")); //$NON-NLS-1$ 
		downHyperLinkButton.setToolTipText("Move hyperlink down");

		downHyperLinkButton.setLayoutData(gridData3);
		addListeners();
		tableViewer.setContentProvider(CollectionContentProvider.instance);

		this.hyperlinkObjects = hyperLinkHelper.getFilteredObject(hyperlinkObjects);

		ILabelProvider provider = null;
		if(element != null) {
			try {
				provider = ServiceUtilsForEObject.getInstance().getService(LabelProviderService.class, element).getLabelProvider();
			} catch (ServiceException ex) {
				Activator.log.error(ex);
			}
		}

		if(provider == null) {
			provider = new LabelProvider();
		}

		tableViewer.setLabelProvider(provider);
		getTableViewer().setInput(this.hyperlinkObjects);
	}

	protected void addListeners() {
		getRemoveHyperLinkButton().addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {
				if(HyperLinkTab.this.getTableViewer().getTable().getSelection().length != 0) {
					Iterator<?> iterator = ((IStructuredSelection)HyperLinkTab.this.getTableViewer().getSelection()).iterator();
					while(iterator.hasNext()) {
						Object object = iterator.next();
						HyperLinkTab.this.getHyperlinkObjects().remove(object);
						HyperLinkTab.this.getTableViewer().setInput(HyperLinkTab.this.getHyperlinkObjects());
					}
				}
			}

			public void mouseDoubleClick(MouseEvent e) {
			}
		});

		getUpHyperLinkButton().addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {
				if(HyperLinkTab.this.getTableViewer().getTable().getSelection().length != 0) {
					Object elt = ((IStructuredSelection)HyperLinkTab.this.getTableViewer().getSelection()).getFirstElement();
					if(HyperLinkTab.this.getHyperlinkObjects().indexOf(elt) == 0) {
						return;
					}
					Iterator<?> iterator = ((IStructuredSelection)HyperLinkTab.this.getTableViewer().getSelection()).iterator();
					while(iterator.hasNext()) {
						HyperLinkObject currentHyperLinkDoc = (HyperLinkObject)iterator.next();
						int index = HyperLinkTab.this.getHyperlinkObjects().indexOf(currentHyperLinkDoc);
						HyperLinkTab.this.getHyperlinkObjects().remove(currentHyperLinkDoc);
						HyperLinkTab.this.getHyperlinkObjects().add(index - 1, currentHyperLinkDoc);
						HyperLinkTab.this.getTableViewer().setInput(HyperLinkTab.this.getHyperlinkObjects());
					}
				}
			}

			public void mouseDoubleClick(MouseEvent e) {
			}
		});

		getDownHyperLinkButton().addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {
				if(HyperLinkTab.this.getTableViewer().getTable().getSelection().length != 0) {
					Object[] block = ((IStructuredSelection)HyperLinkTab.this.getTableViewer().getSelection()).toArray();
					if((HyperLinkTab.this.getHyperlinkObjects().indexOf(block[block.length - 1])) == HyperLinkTab.this.getHyperlinkObjects().size() - 1) {
						return;
					}
					for(int i = block.length - 1; i >= 0; i--) {
						HyperLinkObject currentobject = (HyperLinkObject)block[i];
						int index = HyperLinkTab.this.getHyperlinkObjects().indexOf(currentobject);
						HyperLinkTab.this.getHyperlinkObjects().remove(currentobject);
						HyperLinkTab.this.getHyperlinkObjects().add(index + 1, currentobject);
						HyperLinkTab.this.getTableViewer().setInput(HyperLinkTab.this.getHyperlinkObjects());
					}
				}
			}

			public void mouseDoubleClick(MouseEvent e) {
			}
		});

		final Runnable addHandler = new Runnable() {

			public void run() {
				HyperLinkTab.this.hyperLinkHelper.executeNewMousePressed(HyperLinkTab.this.getHyperlinkObjects(), HyperLinkTab.this.element);
				HyperLinkTab.this.setInput(HyperLinkTab.this.getHyperlinkObjects());
			}
		};
		if(!isCompositeHelper()) {
			getNewHyperLinkbutton().addMouseListener(new MouseAdapter() {

			public void mouseDown(MouseEvent e) {
				addHandler.run();
			}
			});
		} else {
			addNewHyperLinkMenuActions(addHandler);
		}
		
		getModifyHyperLinkButton().addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {
				if(HyperLinkTab.this.getTableViewer().getTable().getSelection().length != 0) {
					HyperLinkObject hyperLinkObject = (HyperLinkObject)((IStructuredSelection)HyperLinkTab.this.getTableViewer().getSelection()).getFirstElement();
					HyperLinkTab.this.hyperLinkHelper.executeEditMousePressed(HyperLinkTab.this.getHyperlinkObjects(), hyperLinkObject, HyperLinkTab.this.element);
					HyperLinkTab.this.setInput(HyperLinkTab.this.getHyperlinkObjects());
				}
			}

			public void mouseDoubleClick(MouseEvent e) {
			}
		});
	}

	private void addNewHyperLinkMenuActions(final Runnable addNewHyperlinkHandler) {
		PopupButtonMenu menu = new PopupButtonMenu(getNewHyperLinkbutton());
		
		for(final AbstractHyperLinkHelper helper : ((CompositeHyperlinkHelper)hyperLinkHelper).getHelpers()) {
				IAction action = new Action(helper.getNameofManagedHyperLink()) {

					@Override
					public void run() {
						((CompositeHyperlinkHelper)hyperLinkHelper).setActiveHelper(helper);
						addNewHyperlinkHandler.run();
					}
				};
				action.setToolTipText(NLS.bind(Messages.HyperLinkTab_addTooltip, helper.getNameofManagedHyperLink()));

				menu.addAction(action);
			}
		}
	
	/**
	 * 
	 * @return get the button to create a hyperlinkObject
	 */
	private Button getNewHyperLinkbutton() {
		return newHyperLinkbutton;
	}
	
	protected boolean isCompositeHelper() {
		return hyperLinkHelper instanceof CompositeHyperlinkHelper;
	}
	
	/**
	 * 
	 * @return the button to edit a hyperlinkObject
	 */

	private Button getModifyHyperLinkButton() {
		return modifyHyperLinkButton;
	}

	/**
	 * 
	 * @return the button to remove a hyperlinkObject
	 */
	private Button getRemoveHyperLinkButton() {
		return removeHyperLinkButton;
	}

	/**
	 * 
	 * @return the button to move up a hyperlinkObject
	 */
	private Button getUpHyperLinkButton() {
		return upHyperLinkButton;
	}

	/**
	 * 
	 * @return the button to move down the hyperlinkObject
	 */
	private Button getDownHyperLinkButton() {
		return downHyperLinkButton;
	}

	/**
	 * set as input a list of hyperlinkObject to display
	 * 
	 * @param hyperlinkObjects
	 *        the lis of hyperlinkobjects
	 */
	@Override
	public void setInput(List<HyperLinkObject> hyperlinkObjects) {
		if(!getTableViewer().getControl().isDisposed()) {
			this.hyperlinkObjects = this.hyperLinkHelper.getFilteredObject(hyperlinkObjects);
			getTableViewer().setInput(this.hyperlinkObjects);
		} else {
			Activator.log.warn("This hyperlink tab has been disposed");
		}
	}
}
