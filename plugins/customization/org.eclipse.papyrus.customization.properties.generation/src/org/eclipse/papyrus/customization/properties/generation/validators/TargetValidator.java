/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Thibault Le Ouay t.leouay@sherpa-eng.com
 *****************************************************************************/

package org.eclipse.papyrus.customization.properties.generation.validators;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.customization.properties.generation.messages.Messages;

public class TargetValidator extends AbstractValidator {

	
	public IStatus validate(Object value) {
		if(value instanceof String){
			String s = (String) value;
			if(!s.equals("")){ //$NON-NLS-1$
				if(!s.endsWith("ctx")){ //$NON-NLS-1$
					return error(Messages.TargetValidator_2);
				}
			}
			else return error(Messages.TargetValidator_3);
		}
		
		 return Status.OK_STATUS;
		}

}
