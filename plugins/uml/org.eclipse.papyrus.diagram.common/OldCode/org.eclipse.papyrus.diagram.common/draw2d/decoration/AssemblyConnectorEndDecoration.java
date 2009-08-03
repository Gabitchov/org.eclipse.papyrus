/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.draw2d.decoration;

import org.eclipse.papyrus.diagram.common.conventions.ConnectorEndConvention;
import org.eclipse.papyrus.diagram.common.draw2d.RequiredInterfaceDecoration;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;

public class AssemblyConnectorEndDecoration extends RequiredInterfaceDecoration {

	public void updateWithEnd(Connector connector, ConnectableElement diagramEnd) {
		ConnectorEnd sourceEnd = ConnectorEndConvention.getConnectorEnd(connector, true);
		boolean forSourceEnd = diagramEnd != null && diagramEnd.equals(sourceEnd.getRole());
		setVisible(forSourceEnd);
	}
}
