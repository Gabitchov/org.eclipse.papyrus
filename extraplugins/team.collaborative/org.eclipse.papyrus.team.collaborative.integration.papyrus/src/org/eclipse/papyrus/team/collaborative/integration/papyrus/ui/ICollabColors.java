package org.eclipse.papyrus.team.collaborative.integration.papyrus.ui;

import org.eclipse.papyrus.team.collaborative.integration.papyrus.utils.UIUtils;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;


public interface ICollabColors {

	public static final Color COMMIT_COLLOR = UIUtils.RESOURCE_MANAGER.createColor(new RGB(255, 65, 72));

	public static final Color UPDATE_COLLOR = UIUtils.RESOURCE_MANAGER.createColor(new RGB(133, 255, 161));

	public static final Color REVERT_COLLOR = UIUtils.RESOURCE_MANAGER.createColor(new RGB(255, 215, 78));

	public static final Color UNLOCK_COLLOR = UIUtils.RESOURCE_MANAGER.createColor(new RGB(172, 209, 62));

	public static final Color LOCK_COLLOR = UIUtils.RESOURCE_MANAGER.createColor(new RGB(232, 132, 59));

}
