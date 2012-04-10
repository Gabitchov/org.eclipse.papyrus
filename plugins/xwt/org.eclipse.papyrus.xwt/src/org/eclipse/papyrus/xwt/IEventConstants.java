/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.       *
 * All rights reserved. This program and the accompanying materials            *
 * are made available under the terms of the Eclipse Public License v1.0       *
 * which accompanies this distribution, and is available at                    *
 * http://www.eclipse.org/legal/epl-v10.html                                   *
 *                                                                             *  
 * Contributors:                                                               *        
 *     Soyatec - initial API and implementation                                *
 *******************************************************************************/
package org.eclipse.papyrus.xwt;

public final class IEventConstants {

	public static final String DATA_PREFIX = "_event.";

	public static final String SUFFIX = "Event";

	public static final String SUFFIX_KEY = "event";

	public static final String PREFIX = "is";

	public static final String KEY_DOWN = "KeyDown";

	public static final String KEY_UP = "KeyUp";

	public static final String[] KEY_GROUP = new String[]{ KEY_DOWN, KEY_UP };

	public static final String XWT_KEY_DOWN = "KeyDown" + SUFFIX;

	public static final String XWT_KEY_UP = "KeyUp" + SUFFIX;

	public static final String MOUSE_DOWN = "MouseDown";

	public static final String MOUSE_UP = "MouseUp";

	public static final String[] MOUSE_GROUP = new String[]{ MOUSE_DOWN, MOUSE_UP };

	public static final String XWT_MOUSE_DOWN = "MouseDown" + SUFFIX;

	public static final String XWT_MOUSE_UP = "MouseUp" + SUFFIX;

	public static final String MOUSE_MOVE = "MouseMove";

	public static final String MOUSE_ENTER = "MouseEnter";

	public static final String MOUSE_EXIT = "MouseExit";

	public static final String MOUSE_HOVER = "MouseHover";

	public static final String[] MOUSE_MOVING_GROUP = new String[]{ MOUSE_ENTER, MOUSE_EXIT };

	public static final String XWT_MOUSE_MOVE = "MouseMove" + SUFFIX;

	public static final String XWT_MOUSE_ENTER = "MouseEnter" + SUFFIX;

	public static final String XWT_MOUSE_EXIT = "MouseExit" + SUFFIX;

	public static final String XWT_MOUSE_HOVER = "MouseHover" + SUFFIX;

	public static final String MOUSE_DOUBLE_CLICK = "MouseDoubleClick";

	public static final String XWT_MOUSE_DOUBLE_CLICK = MOUSE_DOUBLE_CLICK + SUFFIX;

	public static final String PAINT = "Paint";

	public static final String MOVE = "Move";

	public static final String RESIZE = "Resize";

	public static final String DISPOSE = "Dispose";

	public static final String XWT_PAINT = "Paint" + SUFFIX;

	public static final String XWT_MOVE = "Move" + SUFFIX;

	public static final String XWT_RESIZE = "Resize" + SUFFIX;

	public static final String XWT_DISPOSE = "Dispose" + SUFFIX;

	public static final String SELECTION = "Selection";

	public static final String DEFAULT_SELECTION = "DefaultSelection";

	public static final String XWT_SELECTION = "Selection" + SUFFIX;

	public static final String XWT_DEFAULT_SELECTION = "DefaultSelection" + SUFFIX;

	public static final String FOCUS_IN = "FocusIn";

	public static final String FOCUS_OUT = "FocusOut";

	public static final String[] FOCUS_GROUP = new String[]{ FOCUS_IN, FOCUS_OUT };

	public static final String XWT_FOCUS_IN = "FocusIn" + SUFFIX;

	public static final String XWT_FOCUS_OUT = "FocusOut" + SUFFIX;

	public static final String EXPAND = "Expand";

	public static final String COLLAPSE = "Collapse";

	public static final String[] EXPAND_GROUP = new String[]{ EXPAND, COLLAPSE };

	public static final String XWT_EXPAND = "Expand" + SUFFIX;

	public static final String XWT_COLLAPSE = "Collapse" + SUFFIX;

	public static final String ICONIFY = "Iconify";

	public static final String DEICONIFY = "Deiconify";

	public static final String CLOSE = "Close";

	public static final String SHOW = "Show";

	public static final String HIDE = "Hide";

	public static final String[] WINDOW_GROUP = new String[]{ ICONIFY, DEICONIFY, CLOSE, SHOW, HIDE };

	public static final String XWT_ICONIFY = "Iconify" + SUFFIX;

	public static final String XWT_DEICONIFY = "Deiconify" + SUFFIX;

	public static final String XWT_CLOSE = "Close" + SUFFIX;

	public static final String XWT_SHOW = "Show" + SUFFIX;

	public static final String XWT_HIDE = "Hide" + SUFFIX;

	public static final String MODIFY = "Modify";

	public static final String VERIFY = "Verify";

	public static final String XWT_MODIFY = "Modify" + SUFFIX;

	public static final String XWT_VERIFY = "Verify" + SUFFIX;

	public static final String ACTIVATE = "Activate";

	public static final String DEACTIVATE = "Deactivate";

	public static final String[] ACTIVATION_GROUP = new String[]{ ACTIVATE, DEACTIVATE };

	public static final String XWT_ACTIVATE = "Activate" + SUFFIX;

	public static final String XWT_DEACTIVATE = "Deactivate" + SUFFIX;

	public static final String HELP = "Help";

	public static final String XWT_HELP = "Help" + SUFFIX;

	public static final String DRAG_SELECT = "DragDetect";

	public static final String XWT_DRAG_SELECT = "DragDetect" + SUFFIX;

	public static final String ARM = "Arm";

	public static final String XWT_ARM = "Arm" + SUFFIX;

	public static final String TRAVERSE = "Traverse";

	public static final String XWT_TRAVERSE = "Traverse" + SUFFIX;

	public static final String HARD_KEY_DOWN = "HardKeyDown";

	public static final String HARD_KEY_UP = "HardKeyUp";

	public static final String[] HARD_KEY = new String[]{ HARD_KEY_DOWN, HARD_KEY_UP };

	public static final String XWT_HARD_KEY_DOWN = "HardKeyDown" + SUFFIX;

	public static final String XWT_HARD_KEY_UP = "HardKeyUp" + SUFFIX;

	public static final String MENU_DETECT = "MenuDetect";

	public static final String XWT_MENU_DETECT = "MenuDetect" + SUFFIX;

	public static final String MOUSE_WHEEL = "MouseWheel";

	public static final String XWT_MOUSE_WHEEL = "MouseWheel" + SUFFIX;

	public static final String SETTINGS = "Settings";

	public static final String XWT_SETTINGS = "Settings" + SUFFIX;

	public static final String ERASE_ITEM = "EraseItem";

	public static final String MEASURE_ITEM = "MeasureItem";

	public static final String XWT_ERASE_ITEM = "EraseItem" + SUFFIX;

	public static final String XWT_MEASURE_ITEM = "MeasureItem" + SUFFIX;

	public static final String PAINT_ITEM = "PaintItem";

	public static final String SET_DATA = "SetData";

	public static final String IME_COMPOSITION = "ImeComposition";

	public static final String XWT_PAINT_ITEM = "PaintItem" + SUFFIX;

	public static final String XWT_SET_DATA = "SetData" + SUFFIX;

	public static final String XWT_IME_COMPOSITION = "ImeComposition" + SUFFIX;

	public static final int XWT_SWT_LOADED = 1025; // SWT custom event

	public static final String XWT_LOADED = "Loaded"; // deprecated

	public static final String XWT_LOADED_EVENT = XWT_LOADED + SUFFIX;

	static public String getEventName(String swtEventName) {
		return normalize(swtEventName + SUFFIX);
	}

	static public String normalize(String name) {
		return name.toLowerCase();
	}

	static public String getEventPropertyName(String name) {
		return PREFIX + name + SUFFIX;
	}

	static public String getEventPropertyDataName(String name) {
		return DATA_PREFIX + PREFIX + name + SUFFIX;
	}
}
