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
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.compare;

import java.text.MessageFormat;

import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;


public class StyledMessageFormat {
	
	private static final Styler ELEMENT_STYLER = StyledString.DECORATIONS_STYLER;

	private static final Styler MESSAGE_STYLER = null;

	public static StyledString format(String pattern, String... args) {
		StyledString styledString = new StyledString();
		styledString.append(MessageFormat.format(pattern, (Object[])args), ELEMENT_STYLER);
		int currInd = 0;
		int gap = 0;
		for(int i = 0; i < args.length; i++) {
			int nextInd = pattern.indexOf("{", currInd); //$NON-NLS-1$
			if(nextInd != -1 && args.length > i) {
				styledString.setStyle(nextInd + gap, args[i].length(), MESSAGE_STYLER);
				currInd = nextInd + 1;
				gap += args[i].length() - "{}".length() - String.valueOf(i).length(); //$NON-NLS-1$
			} else {
				break;
			}
		}
		return styledString;
	}

}
