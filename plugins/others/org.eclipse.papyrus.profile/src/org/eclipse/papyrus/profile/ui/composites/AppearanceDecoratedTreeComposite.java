/*******************************************************************************
 * Copyright (c) 2008 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.profile.ui.composites;

import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.profile.tree.ProfileElementTreeViewer;
import org.eclipse.papyrus.profile.tree.PropertyValueTreeViewer;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipse.uml2.uml.Element;


/**
 * Base class for appearance stereotype composite
 */
public abstract class AppearanceDecoratedTreeComposite extends Composite implements ISectionComposite {

	// child composites for the table composite
	
//	/** main composite of this complex composite */
//	protected Composite composite;
	/**
	 * Label above the table.
	 */
	protected CLabel label;
	
	/**
	 * Table that displays a property for the current element.
	 */
	protected Tree tree;
	
	/**
	 * The tree viewer.
	 */
	protected TreeViewer treeViewer;
		
	
	/**
	 * Element selected in the Papyrus modeler.
	 */
	protected Element element;
	
	
	// Construction parameters for the composite
	/**
	 * text of the label.
	 */
	protected String name;
	
	/**
	 * returns the element that is selected in Papyrus tool, for which
	 * properties are displayed in the property section.
	 * 
	 * @return the element
	 */
	public Element getElement() {
		return element;
	}

	/**
	 * Sets the element that holds property displyed in property section.
	 * 
	 * @param element the element to set
	 */
	public void setElement(Element element) {
		this.element = element;
	}
	
	/**
	 * Constructor.
	 * 
	 * @param style 
	 * @param isStereotypeTree 
	 * @param name text of the Label on the top left of this composite
	 * @param parent 
	 */
	public AppearanceDecoratedTreeComposite(Composite parent, int style, String name, boolean isStereotypeTree) {
		super(parent, style);
		this.name = name;
		this.setLayout(new FormLayout());
			
		if (isStereotypeTree) {
			treeViewer = new ProfileElementTreeViewer(this);
		} else {
			// Property tree
			treeViewer = new PropertyValueTreeViewer(this);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.cea.papyrus.ui.composites.ISectionComposite#createContent(org.eclipse.swt.widgets.Composite, org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory)
	 */
	/**
	 * 
	 * 
	 * @param factory 
	 * @param parent 
	 * 
	 * @return 
	 */
	public Composite createContent(Composite parent,
			TabbedPropertySheetWidgetFactory factory) {

		return this;
	}

	/* (non-Javadoc)
	 * @see com.cea.papyrus.ui.composites.ISectionComposite#refresh()
	 */
	/**
	 * 
	 */
	public void refresh() {
	}
		
	/**
 * Returns the CommmandStack of the current editor.
 * 
 * @return the CommmandStack of the current editor
 */
	public CommandStack getCommandStack() {
		if(getActiveEditor()!=null) {
			return (CommandStack) getActiveEditor().getAdapter(CommandStack.class);
		}
		return null;
	}
	
	/**
	 * Returns the current Editor.
	 * 
	 * @return the current editor
	 */
	public IEditorPart getActiveEditor() {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor(); 
	}	
}
