/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *******************************************************************************/
package org.eclipse.papyrus.team.collaborative.strategy.ui;

import org.eclipse.papyrus.team.collaborative.strategy.utils.UIUtils;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;


public interface ICollabColors {

	public static final Color COMMIT_COLLOR = UIUtils.RESOURCE_MANAGER.createColor(new RGB(255, 65, 72));

	public static final Color UPDATE_COLLOR = UIUtils.RESOURCE_MANAGER.createColor(new RGB(133, 255, 161));

	public static final Color REVERT_COLLOR = UIUtils.RESOURCE_MANAGER.createColor(new RGB(255, 215, 78));

	public static final Color UNLOCK_COLLOR = UIUtils.RESOURCE_MANAGER.createColor(new RGB(172, 209, 62));

	public static final Color LOCK_COLLOR = UIUtils.RESOURCE_MANAGER.createColor(new RGB(232, 132, 59));

}
