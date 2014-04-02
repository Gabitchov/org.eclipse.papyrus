/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Refactor a generic StrategyLabelProvider
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.strategy;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

/**
 * A LabelProvider for a Strategy
 */
public class StrategyLabelProvider extends ColumnLabelProvider {

	IStrategyManager instance;
	
	public StrategyLabelProvider(IStrategyManager abstractStrategyManager) {
		instance = abstractStrategyManager;
	}
	
	@Override
	public String getText(Object element) {
		if(element instanceof IStrategy) {
			return ((IStrategy)element).getLabel();
		}
		return super.getText(element);
	}

	@Override
	public Image getImage(Object element) {
		if(element instanceof IStrategy) {
			return ((IStrategy)element).getImage();
		}
		return super.getImage(element);
	}

	@Override
	public String getToolTipText(Object element) {
		if(element instanceof IStrategy) {
			return ((IStrategy)element).getDescription();
		}
		return null;
	}


	@Override
	public void update(ViewerCell cell) {
		Object element = cell.getElement();

		if(element instanceof IStrategy) {
			IStrategy strategy = (IStrategy)element;
			if(cell.getColumnIndex() == StrategyEditor.LABEL_COLUMN) {
				cell.setImage(strategy.getImage());

				int foreground;

				if(instance.isActive(strategy)) {
					foreground = SWT.COLOR_BLACK;
				} else {
					foreground = SWT.COLOR_GRAY;
				}
				cell.setForeground(Display.getCurrent().getSystemColor(foreground));
				cell.setText(strategy.getLabel());
			}
		}
	}
}
