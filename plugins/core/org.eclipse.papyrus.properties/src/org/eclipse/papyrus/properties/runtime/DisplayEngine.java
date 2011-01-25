/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.runtime;

import java.net.URL;
import java.util.List;
import java.util.Set;

import org.eclipse.papyrus.properties.contexts.Section;
import org.eclipse.papyrus.properties.contexts.View;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;

public interface DisplayEngine {

	public List<ITabDescriptor> getTabDescriptors(Set<View> views);

	public Control createSection(Composite parent, Section section, DataSource source);

	public Control createSection(Composite parent, Section section, URL sectionFile, DataSource source);

	public void refreshSection(Composite parent, Section section, DataSource source);

	public void hideSection(Composite self);
}
