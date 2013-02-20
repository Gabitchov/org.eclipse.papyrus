/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.gmf.editpoliciesstates.view;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableColorProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.papyrus.gmf.editpoliciesstates.view.EditPoliciesStateView.EditPolicyDescriptor;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;


/**
 * this is the label provider to display editplicies
 *
 */
public class EditpolicyLabelProvider implements ITableLabelProvider, ITableColorProvider  {
	protected Color papyrusColor = new Color(Display.getDefault(), 0, 127, 14);
	protected Color customizableDropEditPolicyColor = new Color(Display.getDefault(), 0, 38, 255);

	public void removeListener(ILabelProviderListener listener) {
	}

	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	public void dispose() {
	}

	public void addListener(ILabelProviderListener listener) {
	}

	public String getColumnText(Object element, int columnIndex) {
		if(element instanceof EditPolicyDescriptor){
			switch (columnIndex) {
			case 0:
				return ((EditPolicyDescriptor)element).role;
			case 1:
				if(((EditPolicyDescriptor)element).policy!=null){
					return ((EditPolicyDescriptor)element).policy.getClass().getName();}
				else{ return "";}

			}

		}
		return "cannot display it: "+element;
	}

	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	public Color getForeground(Object element, int columnIndex) {
		if(element instanceof EditPolicyDescriptor){
			switch (columnIndex) {
			case 0:
				if(((EditPolicyDescriptor)element).policy!=null){
					if(((EditPolicyDescriptor)element).policy.getClass().getName().contains("CustomizableDropEditPolicy")){
						return customizableDropEditPolicyColor;
					}
					if(((EditPolicyDescriptor)element).policy.getClass().getName().contains("papyrus")){
						return papyrusColor;
					}
				}
				return Display.getDefault().getSystemColor(0);
			case  1:
				if(((EditPolicyDescriptor)element).policy!=null){
					if(((EditPolicyDescriptor)element).policy.getClass().getName().contains("CustomizableDropEditPolicy")){
						return customizableDropEditPolicyColor;
					}
					if(((EditPolicyDescriptor)element).policy.getClass().getName().contains("papyrus")){
						return papyrusColor;
					}
				}
				return Display.getDefault().getSystemColor(0);

			}

		}
		return Display.getDefault().getSystemColor(0);
	}

	public Color getBackground(Object element, int columnIndex) {
		return null;
	}
};	
