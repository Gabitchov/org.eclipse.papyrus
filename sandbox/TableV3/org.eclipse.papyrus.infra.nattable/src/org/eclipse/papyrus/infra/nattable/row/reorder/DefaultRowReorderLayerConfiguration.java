/*******************************************************************************
 * Copyright (c) 2012 Original authors and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Original authors and others - initial API and implementation
 ******************************************************************************/
package org.eclipse.papyrus.infra.nattable.row.reorder;

import org.eclipse.nebula.widgets.nattable.config.AggregateConfiguration;
import org.eclipse.nebula.widgets.nattable.reorder.ColumnReorderLayer;


/**
 * Added by the {@link ColumnReorderLayer}
 */
public class DefaultRowReorderLayerConfiguration extends AggregateConfiguration {

	public DefaultRowReorderLayerConfiguration() {
		addColumnReorderUIBindings();
	}

	protected void addColumnReorderUIBindings() {
		addConfiguration(new DefaultReorderBindings());
	}

}
