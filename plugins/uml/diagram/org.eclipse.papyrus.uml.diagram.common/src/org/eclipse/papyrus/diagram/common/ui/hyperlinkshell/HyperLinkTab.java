/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.ui.hyperlinkshell;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.diagram.common.helper.AbstractHyperLinkHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * this class is GUI that represent a tab for each kind of hyperlink
 * for example a tab for diagram, for web links...
 * 
 */
public class HyperLinkTab {
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
	
	
	protected ArrayList<HyperlinkObject> hyperlinkObjects= new ArrayList<HyperlinkObject>();
	
	protected AbstractHyperLinkHelper hyperLinkHelper;
	
	private HyperLinkContentProvider contentProvider;
	/**
	 * get TableVeiver
	 * @return
	 */
	public TableViewer getTableViewer() {
		return tableViewer;
	}
	
	/**
	 * 
	 * @return the list of hyperlink displayed in the tab
	 */
	public ArrayList<HyperlinkObject> getHyperlinkObjects() {
		return hyperlinkObjects;
	}
	
	/**
	 * set list of hyperlinks to display in the tab
	 * @param hyperlinkObjects
	 */
	public void setHyperlinkObjects(ArrayList<HyperlinkObject> hyperlinkObjects) {
		this.hyperlinkObjects = hyperlinkObjects;
	}
	
	/**
	 * 
	 * Constructor.
	 *
	 * @param cTabFolder the container of the tab
	 * @param hyperLinkHelper the hyperlinkhelper that will be associated to this tab
	 * @param hyperlinkObjects the lis of htperlink to display in the tab
	 */
	public  HyperLinkTab(CTabFolder cTabFolder,  AbstractHyperLinkHelper hyperLinkHelper,ArrayList<HyperlinkObject> hyperlinkObjects){
		this.hyperLinkHelper= hyperLinkHelper;
		
		this.contentProvider= new HyperLinkContentProvider();
		CTabItem cTabItem2 = new CTabItem(cTabFolder, SWT.NONE);
		cTabItem2.setText(hyperLinkHelper.getNameofManagedHyperLink()+" hyperlinks");
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
		listLabel.setText("List of "+hyperLinkHelper.getNameofManagedHyperLink()+" hyperlinks:");
		listLabel.setEnabled(false);
		listLabel.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		Label filler = new Label(diagramComposite, SWT.NONE);
		hyperLinkListTable = new Table(diagramComposite, SWT.BORDER | SWT.MULTI);
		tableViewer = new TableViewer(hyperLinkListTable);
		
		newHyperLinkbutton = new Button(diagramComposite, SWT.NONE);
		newHyperLinkbutton.setText("");
		newHyperLinkbutton.setImage(AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common", "/icons/obj16/Add_16x16.gif").createImage());
		newHyperLinkbutton.setLayoutData(gridData4);
		hyperLinkListTable.setHeaderVisible(false);
		hyperLinkListTable.setToolTipText("set of "+hyperLinkHelper.getNameofManagedHyperLink()+"hyperlinks ");
		hyperLinkListTable.setLayoutData(gridData1);
		hyperLinkListTable.setLinesVisible(false);
		modifyHyperLinkButton = new Button(diagramComposite, SWT.NONE);
		modifyHyperLinkButton.setImage(AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common", "/icons/obj16/Modify.gif").createImage());

		removeHyperLinkButton = new Button(diagramComposite, SWT.NONE);
		removeHyperLinkButton.setText("");
		removeHyperLinkButton.setImage(AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common", "/icons/obj16/Delete_16x16.gif").createImage());

		upHyperLinkButton = new Button(diagramComposite, SWT.NONE);
		upHyperLinkButton.setImage(AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common", "/icons/obj16/ArrowUp_16x16.gif").createImage());

		upHyperLinkButton.setLayoutData(gridData2);
		downHyperLinkButton = new Button(diagramComposite, SWT.NONE);
		downHyperLinkButton.setImage(AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common", "/icons/obj16/ArrowDown_16x16.gif").createImage());

		downHyperLinkButton.setLayoutData(gridData3);
		
		tableViewer.setContentProvider(contentProvider);
		IPageIconsRegistry editorRegistry=null;
		IMultiDiagramEditor papyrusEditor=EditorUtils.getMultiDiagramEditor();
		try {
			editorRegistry= papyrusEditor.getServicesRegistry().getService(IPageIconsRegistry.class);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.hyperlinkObjects= hyperLinkHelper.getFilteredObject(hyperlinkObjects);
		tableViewer.setLabelProvider(new HyperLinkLabelProvider(editorRegistry));
		getTableViewer().setInput(this.hyperlinkObjects);
	}

	
	/**
	 * @return the tabitem form the this tab
	 */
	public CTabItem getHyperlinksTab() {
		return hyperlinksTab;
	}

	/**
	 * @return the table that show all hyperlinkObjects
	 */
	public Table getHyperLinkListTable() {
		return hyperLinkListTable;
	}

	/**
	 * 
	 * @return get the button to create a hyperlinkObject
	 */
	public Button getNewHyperLinkbutton() {
		return newHyperLinkbutton;
	}
/**
 * 
 * @return the button to edit a hyperlinkObject
 */
	
	public Button getModifyHyperLinkButton() {
		return modifyHyperLinkButton;
	}

	/**
	 * 
	 * @return the button to remove a hyperlinkObject
	 */
	public Button getRemoveHyperLinkButton() {
		return removeHyperLinkButton;
	}

	/**
	 * 
	 * @return the button to move up a hyperlinkObject
	 */
	public Button getUpHyperLinkButton() {
		return upHyperLinkButton;
	}

	/**
	 * 
	 * @return the button to move down the hyperlinkObject
	 */
	public Button getDownHyperLinkButton() {
		return downHyperLinkButton;
	}
	/**
	 * set as input a list of hyperlinkObject to display
	 * @param hyperlinkObjects the lis of hyperlinkobjects
	 */
	public void setInput(List<HyperlinkObject>hyperlinkObjects){
		this.hyperlinkObjects= this.hyperLinkHelper.getFilteredObject(hyperlinkObjects);
		getTableViewer().setInput(this.hyperlinkObjects);
		
	}
}
