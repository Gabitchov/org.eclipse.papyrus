/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Soyatec - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.xwt.core;

import java.lang.reflect.Method;

import org.eclipse.papyrus.xwt.IEventConstants;
import org.eclipse.papyrus.xwt.XWT;
import org.eclipse.papyrus.xwt.XWTMaps;
import org.eclipse.papyrus.xwt.annotation.Containment;
import org.eclipse.papyrus.xwt.internal.core.IEventController;
import org.eclipse.papyrus.xwt.internal.utils.LoggerManager;
import org.eclipse.papyrus.xwt.internal.utils.UserData;
import org.eclipse.papyrus.xwt.javabean.Controller;
import org.eclipse.papyrus.xwt.metadata.IEvent;
import org.eclipse.papyrus.xwt.metadata.IMetaclass;
import org.eclipse.papyrus.xwt.metadata.ModelUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Widget;

/**
 * 
 * @author yyang (yves.yang@soyatec.com)
 */
public class EventTrigger extends TriggerBase {

	private String sourceName;

	private String routedEvent;

	private TriggerAction[] actions = TriggerAction.EMPTY_ARRAY;

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getRoutedEvent() {
		return routedEvent;
	}

	public void setRoutedEvent(String routedEvent) {
		this.routedEvent = routedEvent;
	}

	@Containment
	public TriggerAction[] getActions() {
		return actions;
	}

	public void setActions(TriggerAction[] actions) {
		this.actions = actions;
	}

	@Override
	public void prepare(Object target) {
		String routedEvent = getRoutedEvent();
		if(routedEvent != null) {
			Object source = getElementByName(target, getSourceName());
			IMetaclass metaclass = XWT.getMetaclass(source);
			IEvent event = metaclass.findEvent(ModelUtils.normalizeEventName(routedEvent));
			if(event == null) {
				if(routedEvent != null && !routedEvent.toLowerCase().endsWith(IEventConstants.SUFFIX_KEY)) {
					LoggerManager.log("Event " + routedEvent + " is not found in " + source.getClass().getName() + ". Please add a suffix \"Event\"!");
				} else {
					LoggerManager.log("Event " + routedEvent + " is not found in " + source.getClass().getName());
				}
				return;
			}

			for(TriggerAction triggerAction : getActions()) {
				triggerAction.initialize(target);
			}

			String name = event.getName();
			if("loadedevent".equalsIgnoreCase(name)) {
				Widget widget = UserData.getWidget(source);
				IEventController eventController = UserData.updateEventController(source);
				RunablePaintAction paintRunnable = createPaintRunnable(source);
				try {
					Method method = paintRunnable.getClass().getDeclaredMethod("run", Object.class, Event.class);
					eventController.setEvent(event, widget, paintRunnable, this, method);
				} catch (Exception e) {
					LoggerManager.log(e);
				}
			} else {
				RunableAction runnable = createRunnable(source);
				try {
					runnable.setEventTrigger(event);
				} catch (Exception e) {
					LoggerManager.log(e);
				}
			}
		}
	}

	public void on(Object target) {
	}

	protected RunableAction createRunnable(Object target) {
		return new RunableAction(target);
	}

	protected RunablePaintAction createPaintRunnable(Object target) {
		return new RunablePaintAction(target);
	}

	class RunablePaintAction {

		protected Object target;

		public RunablePaintAction(Object target) {
			this.target = target;
		}

		public void run(Object object, Event event) {
			for(TriggerAction triggerAction : EventTrigger.this.getActions()) {
				triggerAction.run(event, target, null);
			}
		}
	}

	class RunableAction implements Listener, Runnable {

		protected Object target;

		private int count = 0;

		boolean started = false;

		boolean transition = false;

		private Event event;

		private int eventType;

		public RunableAction(Object target) {
			this.target = target;
		}

		public void run() {
			count--;
			if(count == 0 && !event.widget.isDisposed()) {
				final Display display = event.widget.getDisplay();
				display.syncExec(new Runnable() {

					public void run() {
						if(transition) {
							for(TriggerAction triggerAction : getActions()) {
								triggerAction.initialize(target);
							}
						} else {
							for(TriggerAction triggerAction : getActions()) {
								triggerAction.endFinalize(target);
							}
						}
						display.removeFilter(eventType, RunableAction.this);
						if(!event.widget.isDisposed()) {
							event.widget.notifyListeners(eventType, event);
							display.addFilter(eventType, RunableAction.this);
						}
						started = false;
					}
				});
			}
		}

		protected void setEventTrigger(IEvent event) {
			Widget widget = UserData.getWidget(target);
			String name = event.getName();
			this.eventType = Controller.getEventTypeByName(name);
			if(this.eventType != SWT.None) {
				widget.getDisplay().addFilter(this.eventType, this);
				transition = (this.eventType == XWTMaps.getEvent("swt.move") || this.eventType == XWTMaps.getEvent("swt.resize"));
			}
		}

		public void handleEvent(Event event) {
			Widget widget = UserData.getWidget(target);
			if(event.widget != widget || widget.isDisposed()) {
				return;
			}
			if(started) {
				event.type = SWT.NONE;
				return;
			}

			// execute the animation actions first and then normal events
			count = EventTrigger.this.getActions().length;
			started = true;
			try {
				this.event = Controller.copy(event);

				if(!transition) {
					for(TriggerAction triggerAction : getActions()) {
						triggerAction.initialize(target);
					}
				}

				for(TriggerAction triggerAction : EventTrigger.this.getActions()) {
					triggerAction.run(event, target, this);
				}
			} catch (Exception e) {
				started = false;
			}
			event.type = SWT.NONE;
		}
	}
}
