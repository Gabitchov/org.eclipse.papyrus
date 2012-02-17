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
 *  Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - Initial API and implementation
 *  
 * History:
 *  Renamed from MoDiscoLabelProviderWTooltips - fix for bug  371905
 *
 *****************************************************************************/
package org.eclipse.papyrus.modelexplorer;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.internal.navigator.NavigatorDecoratingLabelProvider;

/**
 * the label provider inherits from the decorating label provider and delegates tooltip related
 * operations to the embedded MoDisco label provider (or implements these itself)
 */
public class DecoratingLabelProviderWTooltips extends NavigatorDecoratingLabelProvider {

	protected MoDiscoLabelProvider moDiscoLP;

	public DecoratingLabelProviderWTooltips(ILabelProvider labelProvider) {
		super(labelProvider);
		if(labelProvider instanceof MoDiscoLabelProvider) {
			moDiscoLP = (MoDiscoLabelProvider)labelProvider;
		}
	}

	@Override
	public String getToolTipText(Object element) {
		return moDiscoLP.getMarkerMessage(element);
	}

	@Override
	public Point getToolTipShift(Object object) {
		return new Point(5, 5);
	}

	@Override
	public int getToolTipDisplayDelayTime(Object object) {
		return 1000;
	}

	@Override
	public int getToolTipTimeDisplayed(Object object) {
		return 10000;
	}
}
