/***************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Francisco Javier Cano Mu�oz (Prodevelop) - initial API and implementation
 *  Marc Gil Sendra (Prodevelop)
 * 
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.activity.edit.commands.helpers;

import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityPartition;

/**
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public class ActivityPartitionActivity {

	public static Activity getActivityPartitionActivity(ActivityPartition activityPartition) {
		if (activityPartition.getInActivity() != null) {
			return activityPartition.getInActivity();
		}

		ActivityPartition superPartition, actualPartition;

		superPartition = null;
		actualPartition = activityPartition;

		while ((superPartition = actualPartition.getSuperPartition()) != null) {
			actualPartition = superPartition;
		}

		return actualPartition.getInActivity();
	}
}
