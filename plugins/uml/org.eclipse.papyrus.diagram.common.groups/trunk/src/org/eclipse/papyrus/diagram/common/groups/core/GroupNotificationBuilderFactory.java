/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.groups.core;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.diagram.common.groups.core.ui.ChooseContainedElementsCreator;
import org.eclipse.papyrus.diagram.common.groups.core.ui.ChooseContainingGroupCreator;
import org.eclipse.papyrus.diagram.common.groups.core.ui.CompositeCreatorWithCommand;
import org.eclipse.papyrus.diagram.common.groups.core.utils.Utils;
import org.eclipse.papyrus.ui.toolbox.notification.Type;
import org.eclipse.papyrus.ui.toolbox.notification.builders.NotificationBuilder;

/**
 * This class builds all the necessary notifications for the group framework.
 * It allows to recover configured, ready to run, notification builders.
 * 
 * @author vhemery
 */
public class GroupNotificationBuilderFactory {

	/**
	 * This class allow to recover a NotificationBuilder and a command defined by the notification execution.
	 */
	public static class NotificationBuilderAndResultingCommand {

		private NotificationBuilder builder;

		private CompositeCreatorWithCommand creator;

		public NotificationBuilderAndResultingCommand(NotificationBuilder notificationBuilder, CompositeCreatorWithCommand creatorWithCommand) {
			builder = notificationBuilder;
			creator = creatorWithCommand;
		}

		public NotificationBuilder getBuilder() {
			return builder;
		}

		public Command getResultingCommand() {
			return creator.getResultingCommand();
		}

		public CompositeCreatorWithCommand getCreator() {
			return creator;
		}
	}

	/**
	 * Get a builder for a notification which enable to choose graphical children of a group.
	 * 
	 * @param group
	 *        the group to choose graphical children for
	 * @param children
	 *        list of possible parents
	 * @return notification builder
	 */
	public static NotificationBuilderAndResultingCommand getChooseChildrenBuilder(IGraphicalEditPart group, List<IGraphicalEditPart> children) {
		NotificationBuilder builder = NotificationBuilder.createInformationBuilder();
		builder.setType(Type.QUESTION);
		builder.setTemporary(false);
		builder.setAsynchronous(false);
		Map<IGraphicalEditPart, ChooseContainedElementsCreator.ChildSelection> map = Utils.contructSelectionMapForGroupChildren(group, children);
		ChooseContainedElementsCreator creator = new ChooseContainedElementsCreator(group, map);
		builder.setComposite(creator);
		builder.addAction(creator.getCommandRunner(false));
		return new NotificationBuilderAndResultingCommand(builder, creator);
	}

	/**
	 * Get a builder for a notification which enable to choose graphical parents of edit parts.
	 * 
	 * @param elementPartsAndParents
	 *        map with edit parts and their list of possible parents
	 * @return notification builder
	 */
	public static NotificationBuilderAndResultingCommand getChooseParentBuilder(Map<IGraphicalEditPart, List<IGraphicalEditPart>> elementPartsAndParents) {
		NotificationBuilder builder = NotificationBuilder.createInformationBuilder();
		builder.setType(Type.QUESTION);
		builder.setTemporary(false);
		builder.setAsynchronous(true);
		ChooseContainingGroupCreator creator = new ChooseContainingGroupCreator(elementPartsAndParents);
		builder.setComposite(creator);
		builder.addAction(creator.getCommandRunner(true));
		return new NotificationBuilderAndResultingCommand(builder, creator);
	}
}
