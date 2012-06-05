/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.dnd.preferences;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.papyrus.infra.gmfdiag.dnd.policy.DropStrategyManager;
import org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.DropStrategy;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

/**
 * A LabelProvider for DropStrategy
 * 
 * @author Camille Letavernier
 */
public class DropStrategyLabelProvider extends ColumnLabelProvider {

	@Override
	public String getText(Object element) {
		if(element instanceof DropStrategy) {
			return ((DropStrategy)element).getLabel();
		}
		return super.getText(element);
	}

	@Override
	public Image getImage(Object element) {
		if(element instanceof DropStrategy) {
			return ((DropStrategy)element).getImage();
		}
		return super.getImage(element);
	}

	@Override
	public String getToolTipText(Object element) {
		if(element instanceof DropStrategy) {
			return ((DropStrategy)element).getDescription();
		}
		return null;
	}


	@Override
	public void update(ViewerCell cell) {
		Object element = cell.getElement();

		if(element instanceof DropStrategy) {
			DropStrategy strategy = (DropStrategy)element;
			if(cell.getColumnIndex() == DropStrategyEditor.LABEL_COLUMN) {
				cell.setImage(strategy.getImage());

				int foreground;

				if(DropStrategyManager.instance.isActive(strategy)) {
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
