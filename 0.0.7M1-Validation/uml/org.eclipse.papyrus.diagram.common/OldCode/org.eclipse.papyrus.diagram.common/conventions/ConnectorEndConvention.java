/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */

package org.eclipse.papyrus.diagram.common.conventions;

import java.util.List;

import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;

public class ConnectorEndConvention {

	public static ConnectorEnd getConnectorEnd(Connector connector, boolean sourceNotTarget) {
		List<ConnectorEnd> ends = connector.getEnds();
		if (ends.size() < 2) {
			return null;
		}
		return ends.get(sourceNotTarget ? 0 : 1);
	}

	public static ConnectorEnd getSourceEnd(Connector connector) {
		return getConnectorEnd(connector, true);
	}

	public static ConnectorEnd getTargetEnd(Connector connector) {
		return getConnectorEnd(connector, false);
	}
}
