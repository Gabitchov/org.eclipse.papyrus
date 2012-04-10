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

package org.eclipse.papyrus.xwt;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;

/**
 * @author jliu
 */
public class XWTMaps {

	private static final Map<String, Integer> styles = new HashMap<String, Integer>();

	private static final Map<String, Integer> colors = new HashMap<String, Integer>();

	private static final Map<String, Integer> events = new HashMap<String, Integer>();

	private static final Map<String, Integer> accelerators = new HashMap<String, Integer>();

	private XWTMaps() {
	}

	private static void checkAndInit() {
		if(styles.isEmpty() || colors.isEmpty() || events.isEmpty() || accelerators.isEmpty()) {
			init();
		}
	}

	private static void init() {
		// styles
		styles.put("SWT.NONE", SWT.NONE);
		styles.put("SWT.FILL", SWT.FILL);
		styles.put("SWT.BORDER", SWT.BORDER);
		styles.put("SWT.PUSH", SWT.PUSH);
		styles.put("SWT.CHECK", SWT.CHECK);
		styles.put("SWT.RADIO", SWT.RADIO);
		styles.put("SWT.TOGGLE", SWT.TOGGLE);
		styles.put("SWT.ARROW", SWT.ARROW);
		styles.put("SWT.ARROW_DOWN", SWT.ARROW_DOWN);
		styles.put("SWT.ARROW_LEFT", SWT.ARROW_LEFT);
		styles.put("SWT.ARROW_RIGHT", SWT.ARROW_RIGHT);
		styles.put("SWT.ARROW_UP", SWT.ARROW_UP);
		styles.put("SWT.FLAT", SWT.FLAT);
		styles.put("SWT.DROP_DOWN", SWT.DROP_DOWN);
		styles.put("SWT.SIMPLE", SWT.SIMPLE);
		styles.put("SWT.READ_ONLY", SWT.READ_ONLY);
		styles.put("SWT.LEFT", SWT.LEFT);
		styles.put("SWT.UP", SWT.UP);
		styles.put("SWT.DOWN", SWT.DOWN);
		styles.put("SWT.CENTER", SWT.CENTER);
		styles.put("SWT.RIGHT", SWT.RIGHT);
		styles.put("SWT.H_SCROLL", SWT.H_SCROLL);
		styles.put("SWT.V_SCROLL", SWT.V_SCROLL);
		styles.put("SWT.DATE", SWT.DATE);
		styles.put("SWT.TIME", SWT.TIME);
		styles.put("SWT.CALENDAR", SWT.CALENDAR);
		styles.put("SWT.SHORT", SWT.SHORT);
		styles.put("SWT.MEDIUM", SWT.MEDIUM);
		styles.put("SWT.LONG", SWT.LONG);
		styles.put("SWT.WRAP", SWT.WRAP);
		styles.put("SWT.HORIZONTAL", SWT.HORIZONTAL);
		styles.put("SWT.VERTICAL", SWT.VERTICAL);
		styles.put("SWT.SEPARATOR", SWT.SEPARATOR);
		styles.put("SWT.SHADOW_IN", SWT.SHADOW_IN);
		styles.put("SWT.SHADOW_NONE", SWT.SHADOW_NONE);
		styles.put("SWT.SHADOW_OUT", SWT.SHADOW_OUT);
		styles.put("SWT.NO_TRIM", SWT.NO_TRIM);
		styles.put("SWT.SHELL_TRIM", SWT.SHELL_TRIM);
		styles.put("SWT.DIALOG_TRIM", SWT.DIALOG_TRIM);

		styles.put("SWT.CLOSE", SWT.CLOSE);
		styles.put("SWT.MIN", SWT.MIN);
		styles.put("SWT.MAX", SWT.MAX);
		styles.put("SWT.RESIZE", SWT.RESIZE);
		styles.put("SWT.TOOL", SWT.TOOL);
		styles.put("SWT.ON_TOP", SWT.ON_TOP);
		styles.put("SWT.MODELESS", SWT.MODELESS);
		styles.put("SWT.PRIMARY_MODAL", SWT.PRIMARY_MODAL);
		styles.put("SWT.APPLICATION_MODAL", SWT.APPLICATION_MODAL);
		styles.put("SWT.SYSTEM_MODAL", SWT.SYSTEM_MODAL);
		styles.put("SWT.TITLE", SWT.TITLE);
		styles.put("SWT.SINGLE", SWT.SINGLE);
		styles.put("SWT.MULTI", SWT.MULTI);
		styles.put("SWT.PASSWORD", SWT.PASSWORD);
		styles.put("SWT.SEARCH", SWT.SEARCH);
		styles.put("SWT.CANCEL", SWT.CANCEL);
		// styles: icon
		tryPut(styles, "SWT.ICON");
		styles.put("SWT.ICON_ERROR", SWT.ICON_ERROR);
		styles.put("SWT.ICON_INFORMATION", SWT.ICON_INFORMATION);
		styles.put("SWT.ICON_QUESTION", SWT.ICON_QUESTION);
		styles.put("SWT.ICON_WARNING", SWT.ICON_WARNING);
		styles.put("SWT.ICON_WORKING", SWT.ICON_WORKING);
		tryPut(styles, "SWT.SHADOW_ETCHED_IN");
		tryPut(styles, "SWT.SHADOW_ETCHED_OUT");
		tryPut(styles, "SWT.BALLOON");
		tryPut(styles, "SWT.NO_BACKGROUND");
		styles.put("SWT.NO_FOCUS", SWT.NO_FOCUS);
		tryPut(styles, "SWT.NO_MERGE_PAINTS");
		tryPut(styles, "SWT.NO_REDRAW_RESIZE");
		styles.put("SWT.DOUBLE_BUFFERED", SWT.DOUBLE_BUFFERED);
		styles.put("SWT.SMOOTH", SWT.SMOOTH);
		styles.put("SWT.INDETERMINATE", SWT.INDETERMINATE);
		styles.put("SWT.FULL_SELECTION", SWT.FULL_SELECTION);
		styles.put("SWT.TOP", SWT.TOP);
		styles.put("SWT.BOTTOM", SWT.BOTTOM);
		styles.put("SWT.NORMAL", SWT.NORMAL);
		styles.put("SWT.ITALIC", SWT.ITALIC);
		styles.put("SWT.BOLD", SWT.BOLD);
		styles.put("SWT.LEFT_TO_RIGHT", SWT.LEFT_TO_RIGHT);
		tryPut(styles, "SWT.RIGHT_TO_LEFT");
		styles.put("SWT.BAR", SWT.BAR);
		styles.put("SWT.CASCADE", SWT.CASCADE);
		tryPut(styles, "SWT.NO_RADIO_GROUP");
		styles.put("SWT.POP_UP", SWT.POP_UP);
		styles.put("SWT.INHERIT_DEFAULT", SWT.INHERIT_DEFAULT);
		styles.put("SWT.INHERIT_NONE", SWT.INHERIT_NONE);
		styles.put("SWT.INHERIT_FORCE", SWT.INHERIT_FORCE);

		// colors
		colors.put("SWT.COLOR_BLACK", SWT.COLOR_BLACK);
		colors.put("SWT.COLOR_BLUE", SWT.COLOR_BLUE);
		colors.put("SWT.COLOR_CYAN", SWT.COLOR_CYAN);
		colors.put("SWT.COLOR_DARK_BLUE", SWT.COLOR_DARK_BLUE);
		colors.put("SWT.COLOR_DARK_CYAN", SWT.COLOR_DARK_CYAN);
		colors.put("SWT.COLOR_DARK_GREEN", SWT.COLOR_DARK_GREEN);
		colors.put("SWT.COLOR_DARK_MAGENTA", SWT.COLOR_DARK_MAGENTA);
		colors.put("SWT.COLOR_DARK_RED", SWT.COLOR_DARK_RED);
		colors.put("SWT.COLOR_DARK_YELLOW", SWT.COLOR_DARK_YELLOW);
		colors.put("SWT.COLOR_GRAY", SWT.COLOR_GRAY);
		colors.put("SWT.COLOR_GREEN", SWT.COLOR_GREEN);
		colors.put("SWT.COLOR_INFO_BACKGROUND", SWT.COLOR_INFO_BACKGROUND);
		colors.put("SWT.COLOR_INFO_FOREGROUND", SWT.COLOR_INFO_FOREGROUND);
		colors.put("SWT.COLOR_LIST_BACKGROUND", SWT.COLOR_LIST_BACKGROUND);
		colors.put("SWT.COLOR_LIST_FOREGROUND", SWT.COLOR_LIST_FOREGROUND);
		colors.put("SWT.COLOR_LIST_SELECTION", SWT.COLOR_LIST_SELECTION);
		colors.put("SWT.COLOR_LIST_SELECTION_TEXT", SWT.COLOR_LIST_SELECTION_TEXT);
		colors.put("SWT.COLOR_MAGENTA", SWT.COLOR_MAGENTA);
		colors.put("SWT.COLOR_RED", SWT.COLOR_RED);
		colors.put("SWT.COLOR_TITLE_BACKGROUND", SWT.COLOR_TITLE_BACKGROUND);
		colors.put("SWT.COLOR_TITLE_BACKGROUND_GRADIENT", SWT.COLOR_TITLE_BACKGROUND_GRADIENT);
		colors.put("SWT.COLOR_TITLE_FOREGROUND", SWT.COLOR_TITLE_FOREGROUND);
		colors.put("SWT.COLOR_TITLE_INACTIVE_BACKGROUND", SWT.COLOR_TITLE_INACTIVE_BACKGROUND);
		colors.put("SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT", SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT);
		colors.put("SWT.COLOR_TITLE_INACTIVE_FOREGROUND", SWT.COLOR_TITLE_INACTIVE_FOREGROUND);
		colors.put("SWT.COLOR_WHITE", SWT.COLOR_WHITE);
		colors.put("SWT.COLOR_WIDGET_BACKGROUND", SWT.COLOR_WIDGET_BACKGROUND);
		colors.put("SWT.COLOR_WIDGET_BORDER", SWT.COLOR_WIDGET_BORDER);
		colors.put("SWT.COLOR_WIDGET_DARK_SHADOW", SWT.COLOR_WIDGET_DARK_SHADOW);
		colors.put("SWT.COLOR_WIDGET_FOREGROUND", SWT.COLOR_WIDGET_FOREGROUND);
		colors.put("SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW", SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW);
		colors.put("SWT.COLOR_WIDGET_LIGHT_SHADOW", SWT.COLOR_WIDGET_LIGHT_SHADOW);
		colors.put("SWT.COLOR_WIDGET_NORMAL_SHADOW", SWT.COLOR_WIDGET_NORMAL_SHADOW);
		colors.put("SWT.COLOR_YELLOW", SWT.COLOR_YELLOW);

		// Events
		events.put("swt.activate", SWT.Activate);
		events.put("swt.arm", SWT.Arm);
		events.put("swt.close", SWT.Close);
		events.put("swt.collapse", SWT.Collapse);
		events.put("swt.deactivate", SWT.Deactivate);
		events.put("swt.defaultselection", SWT.DefaultSelection);
		tryPut(events, "swt.deiconify", "SWT.Deiconify");
		events.put("swt.dispose", SWT.Dispose);
		events.put("swt.dragdetect", SWT.DragDetect);
		tryPut(events, "swt.eraseitem", "SWT.EraseItem");
		events.put("swt.expand", SWT.Expand);
		events.put("swt.focusin", SWT.FocusIn);
		events.put("swt.focusout", SWT.FocusOut);
		tryPut(events, "swt.hardkeydown", "SWT.HardKeyDown");
		tryPut(events, "swt.hardkeyup", "SWT.HardKeyUp");
		events.put("swt.help", SWT.Help);
		events.put("swt.hide", SWT.Hide);
		tryPut(events, "swt.iconify", "SWT.Iconify");
		events.put("swt.keydown", SWT.KeyDown);
		events.put("swt.keyup", SWT.KeyUp);
		tryPut(events, "swt.measureitem", "SWT.MeasureItem");
		events.put("swt.menudetect", SWT.MenuDetect);
		events.put("swt.modify", SWT.Modify);
		events.put("swt.mousedoubleclick", SWT.MouseDoubleClick);
		events.put("swt.mousedown", SWT.MouseDown);
		tryPut(events, "swt.mouseenter", "SWT.MouseEnter");
		tryPut(events, "swt.mouseexit", "SWT.MouseExit");
		tryPut(events, "swt.mousehover", "SWT.MouseHover");
		tryPut(events, "swt.mousemove", "SWT.MouseMove");
		events.put("swt.mouseup", SWT.MouseUp);
		tryPut(events, "swt.mousewheel", "SWT.MouseWheel");
		events.put("swt.move", SWT.Move);
		tryPut(events, "swt.paint", "SWT.Paint");
		tryPut(events, "swt.paintitem", "SWT.PaintItem");
		events.put("swt.resize", SWT.Resize);
		events.put("swt.selection", SWT.Selection);
		events.put("swt.setdata", SWT.SetData);
		tryPut(events, "swt.settings", "SWT.Settings");
		events.put("swt.show", SWT.Show);
		events.put("swt.traverse", SWT.Traverse);
		events.put("swt.verify", SWT.Verify);
		tryPut(events, "swt.imecomposition", "SWT.ImeComposition");

		// accelerators
		accelerators.put("SWT.ALT", SWT.ALT);
		accelerators.put("SWT.ARROW_UP", SWT.ARROW_UP);
		accelerators.put("SWT.ARROW_DOWN", SWT.ARROW_DOWN);
		accelerators.put("SWT.ARROW_LEFT", SWT.ARROW_LEFT);
		accelerators.put("SWT.ARROW_RIGHT", SWT.ARROW_RIGHT);
		accelerators.put("SWT.BREAK", SWT.BREAK);
		accelerators.put("SWT.CAPS_LOCK", SWT.CAPS_LOCK);
		accelerators.put("SWT.CENTER", SWT.CENTER);
		accelerators.put("SWT.CTRL", SWT.CTRL);
		accelerators.put("SWT.DEFAULT", SWT.DEFAULT);
		tryPut(accelerators, "SWT.EMBEDDED");
		accelerators.put("SWT.END", SWT.END);
		accelerators.put("SWT.F1", SWT.F1);
		accelerators.put("SWT.F2", SWT.F2);
		accelerators.put("SWT.F3", SWT.F3);
		accelerators.put("SWT.F4", SWT.F4);
		accelerators.put("SWT.F5", SWT.F5);
		accelerators.put("SWT.F6", SWT.F6);
		accelerators.put("SWT.F7", SWT.F7);
		accelerators.put("SWT.F8", SWT.F8);
		accelerators.put("SWT.F9", SWT.F9);
		accelerators.put("SWT.F10", SWT.F10);
		accelerators.put("SWT.F11", SWT.F11);
		accelerators.put("SWT.F12", SWT.F12);
		accelerators.put("SWT.HELP", SWT.HELP);
		accelerators.put("SWT.HOME", SWT.HOME);
		accelerators.put("SWT.IMAGE_UNDEFINED", SWT.IMAGE_UNDEFINED);
		accelerators.put("SWT.INSERT", SWT.INSERT);
		accelerators.put("SWT.KEYPAD_ADD", SWT.KEYPAD_ADD);
		accelerators.put("SWT.KEYPAD_CR", SWT.KEYPAD_CR);
		accelerators.put("SWT.KEYPAD_DECIMAL", SWT.KEYPAD_DECIMAL);
		accelerators.put("SWT.KEYPAD_DIVIDE", SWT.KEYPAD_DIVIDE);
		accelerators.put("SWT.KEYPAD_EQUAL", SWT.KEYPAD_EQUAL);
		accelerators.put("SWT.KEYPAD_MULTIPLY", SWT.KEYPAD_MULTIPLY);
		accelerators.put("SWT.KEYPAD_SUBTRACT", SWT.KEYPAD_SUBTRACT);
		accelerators.put("SWT.KEYPAD_0", SWT.KEYPAD_0);
		accelerators.put("SWT.KEYPAD_1", SWT.KEYPAD_1);
		accelerators.put("SWT.KEYPAD_2", SWT.KEYPAD_2);
		accelerators.put("SWT.KEYPAD_3", SWT.KEYPAD_3);
		accelerators.put("SWT.KEYPAD_4", SWT.KEYPAD_4);
		accelerators.put("SWT.KEYPAD_5", SWT.KEYPAD_5);
		accelerators.put("SWT.KEYPAD_6", SWT.KEYPAD_6);
		accelerators.put("SWT.KEYPAD_7", SWT.KEYPAD_7);
		accelerators.put("SWT.KEYPAD_8", SWT.KEYPAD_8);
		accelerators.put("SWT.KEYPAD_9", SWT.KEYPAD_9);
		accelerators.put("SWT.NUM_LOCK", SWT.NUM_LOCK);
		accelerators.put("SWT.PAUSE", SWT.PAUSE);
		accelerators.put("SWT.PAGE_DOWN", SWT.PAGE_DOWN);
		accelerators.put("SWT.PAGE_UP", SWT.PAGE_UP);
		accelerators.put("SWT.PRINT_SCREEN", SWT.PRINT_SCREEN);
		accelerators.put("SWT.SCROLL_LOCK", SWT.SCROLL_LOCK);
		accelerators.put("SWT.SHIFT", SWT.SHIFT);

	}

	public static Collection<String> getStyleKeys() {
		checkAndInit();
		return styles.keySet();
	}

	public static int getStyle(String key) {
		if(key == null) {
			return SWT.NONE;
		}
		checkAndInit();
		String mapKey = key.toUpperCase();
		if(!mapKey.startsWith("SWT.")) {
			mapKey = "SWT." + mapKey;
		}
		Integer style = styles.get(mapKey);
		return (style == null ? SWT.NONE : style);
	}

	public static Collection<String> getColorKeys() {
		checkAndInit();
		return colors.keySet();
	}

	public static int getColor(String key) {
		if(key == null || key.equals("")) {
			return SWT.NONE;
		}
		checkAndInit();
		String mapKey = key.toUpperCase();
		if(!mapKey.startsWith("SWT.")) {
			mapKey = "SWT." + mapKey;
		}
		Integer color = colors.get(mapKey);
		return color == null ? SWT.NONE : color;
	}

	public static Collection<String> getEventKeys() {
		checkAndInit();
		return events.keySet();
	}

	public static int getEvent(String key) {
		if(key == null || key.equals("")) {
			return SWT.None;
		}
		checkAndInit();
		String mapKey = key.toLowerCase();
		if(!mapKey.startsWith("swt.")) {
			mapKey = "swt." + mapKey;
		}
		Integer event = events.get(mapKey);
		return event == null ? SWT.None : event;
	}

	public static Collection<String> getAcceleratorKeys() {
		checkAndInit();
		return accelerators.keySet();
	}

	public static int getAccelerator(String key) {
		char letter;
		if(key == null || key.equals("")) {
			return SWT.NONE;
		}
		checkAndInit();
		if(key.equals("BS")) {
			Integer accelerator = Integer.valueOf(SWT.BS);
			return accelerator == null ? SWT.NONE : accelerator;
		} else if(key.equals("ENTER")) {
			Integer accelerator = Integer.valueOf(SWT.CR);
			return accelerator == null ? SWT.NONE : accelerator;
		} else if(key.equals("DEL")) {
			Integer accelerator = Integer.valueOf(SWT.DEL);
			return accelerator == null ? SWT.NONE : accelerator;
		} else if(key.equals("SPACE")) {
			Integer accelerator = Integer.valueOf(' ');
			return accelerator == null ? SWT.NONE : accelerator;
		} else if(key.length() == 1) {
			letter = key.charAt(0);
			if(letter >= 'A' && letter <= 'Z' || letter >= 'a' && letter <= 'z') {
				Integer accelerator = Integer.valueOf(letter);
				return accelerator == null ? SWT.NONE : accelerator;
			}
		}

		String mapKey = key.toUpperCase();
		if(!mapKey.startsWith("SWT.")) {
			mapKey = "SWT." + mapKey;
		}

		Integer accelerator = accelerators.get(mapKey);
		return accelerator == null ? SWT.NONE : accelerator;
	}

	public static int getValue(String key) {
		int value = getStyle(key);
		if(value == SWT.NONE) {
			value = getColor(key);
		}
		if(value == SWT.NONE) {
			value = getEvent(key);
		}
		if(value == SWT.NONE) {
			value = getAccelerator(key);
		}
		return value;
	}

	public static String getCombAccelerator(String content) {
		if(content.equals("Alt0")) {
			return "SWT.ALT | SWT.KEYPAD_0";
		} else if(content.equals("Alt1")) {
			return "SWT.ALT | SWT.KEYPAD_1";
		} else if(content.equals("Alt2")) {
			return "SWT.ALT | SWT.KEYPAD_2";
		} else if(content.equals("Alt3")) {
			return "SWT.ALT | SWT.KEYPAD_3";
		} else if(content.equals("Alt4")) {
			return "SWT.ALT | SWT.KEYPAD_4";
		} else if(content.equals("Alt5")) {
			return "SWT.ALT | SWT.KEYPAD_5";
		} else if(content.equals("Alt6")) {
			return "SWT.ALT | SWT.KEYPAD_6";
		} else if(content.equals("Alt7")) {
			return "SWT.ALT | SWT.KEYPAD_7";
		} else if(content.equals("Alt8")) {
			return "SWT.ALT | SWT.KEYPAD_8";
		} else if(content.equals("Alt9")) {
			return "SWT.ALT | SWT.KEYPAD_9";
		} else if(content.equals("AltBksp")) {
			return "SWT.ALT | BS";
		} else if(content.equals("AltDownArrow")) {
			return "SWT.ALT | SWT.ARROW_DOWN";
		} else if(content.equals("AltF1")) {
			return "SWT.ALT | SWT.F1";
		} else if(content.equals("AltF10")) {
			return "SWT.ALT | SWT.F10";
		} else if(content.equals("AltF11")) {
			return "SWT.ALT | SWT.F11";
		} else if(content.equals("AltF12")) {
			return "SWT.ALT | SWT.F12";
		} else if(content.equals("AltF2")) {
			return "SWT.ALT | SWT.F2";
		} else if(content.equals("AltF3")) {
			return "SWT.ALT | SWT.F3";
		} else if(content.equals("AltF4")) {
			return "SWT.ALT | SWT.F4";
		} else if(content.equals("AltF5")) {
			return "SWT.ALT | SWT.F5";
		} else if(content.equals("AltF6")) {
			return "SWT.ALT | SWT.F6";
		} else if(content.equals("AltF7")) {
			return "SWT.ALT | SWT.F7";
		} else if(content.equals("AltF8")) {
			return "SWT.ALT | SWT.F8";
		} else if(content.equals("AltF9")) {
			return "SWT.ALT | SWT.F9";
		} else if(content.equals("AltLeftArrow")) {
			return "SWT.ALT | SWT.ARROW_LEFT";
		} else if(content.equals("AltRightArrow")) {
			return "SWT.ALT | SWT.ARROW_RIGHT";
		} else if(content.equals("AltUpArrow")) {
			return "SWT.ALT | SWT.ARROW_UP";
		} else if(content.equals("AltEnter")) {
			return "SWT.ALT | Enter";
		} else if(content.equals("AltSpace")) {
			return "SWT.ALT | Space";
		} else if(content.equals("Ctrl0")) {
			return "SWT.CTRL | SWT.KEYPAD_0";
		} else if(content.equals("Ctrl1")) {
			return "SWT.CTRL | SWT.KEYPAD_1";
		} else if(content.equals("Ctrl2")) {
			return "SWT.CTRL | SWT.KEYPAD_2";
		} else if(content.equals("Ctrl3")) {
			return "SWT.CTRL | SWT.KEYPAD_3";
		} else if(content.equals("Ctrl4")) {
			return "SWT.CTRL | SWT.KEYPAD_4";
		} else if(content.equals("Ctrl5")) {
			return "SWT.CTRL | SWT.KEYPAD_5";
		} else if(content.equals("Ctrl6")) {
			return "SWT.CTRL | SWT.KEYPAD_6";
		} else if(content.equals("Ctrl7")) {
			return "SWT.CTRL | SWT.KEYPAD_7";
		} else if(content.equals("Ctrl8")) {
			return "SWT.CTRL | SWT.KEYPAD_8";
		} else if(content.equals("Ctrl9")) {
			return "SWT.CTRL | SWT.KEYPAD_9";
		} else if(content.equals("CtrlA")) {
			return "SWT.CTRL | A";
		} else if(content.equals("CtrlB")) {
			return "SWT.CTRL | B";
		} else if(content.equals("CtrlC")) {
			return "SWT.CTRL | C";
		} else if(content.equals("CtrlD")) {
			return "SWT.CTRL | D";
		} else if(content.equals("CtrlDel")) {
			return "SWT.CTRL | DEL";
		} else if(content.equals("CtrlEnter")) {
			return "SWT.CTRL | Enter";
		} else if(content.equals("CtrlSpace")) {
			return "SWT.CTRL | Space";
		} else if(content.equals("CtrlE")) {
			return "SWT.CTRL | E";
		} else if(content.equals("CtrlF")) {
			return "SWT.CTRL | F";
		} else if(content.equals("CtrlF1")) {
			return "SWT.CTRL | SWT.F1";
		} else if(content.equals("CtrlF10")) {
			return "SWT.CTRL | SWT.F10";
		} else if(content.equals("CtrlF11")) {
			return "SWT.CTRL | SWT.F11";
		} else if(content.equals("CtrlF12")) {
			return "SWT.CTRL | SWT.F12";
		} else if(content.equals("CtrlF2")) {
			return "SWT.CTRL | SWT.F2";
		} else if(content.equals("CtrlF3")) {
			return "SWT.CTRL | SWT.F3";
		} else if(content.equals("CtrlF4")) {
			return "SWT.CTRL | SWT.F4";
		} else if(content.equals("CtrlF5")) {
			return "SWT.CTRL | SWT.F5";
		} else if(content.equals("CtrlF6")) {
			return "SWT.CTRL | SWT.F6";
		} else if(content.equals("CtrlF7")) {
			return "SWT.CTRL | SWT.F7";
		} else if(content.equals("CtrlF8")) {
			return "SWT.CTRL | SWT.F8";
		} else if(content.equals("CtrlF9")) {
			return "SWT.CTRL | SWT.F9";
		} else if(content.equals("CtrlG")) {
			return "SWT.CTRL | G";
		} else if(content.equals("CtrlH")) {
			return "SWT.CTRL | H";
		} else if(content.equals("CtrlI")) {
			return "SWT.CTRL | I";
		} else if(content.equals("CtrlIns")) {
			return "SWT.CTRL | SWT.INSERT";
		} else if(content.equals("CtrlJ")) {
			return "SWT.CTRL | J";
		} else if(content.equals("CtrlK")) {
			return "SWT.CTRL | K";
		} else if(content.equals("CtrlL")) {
			return "SWT.CTRL | L";
		} else if(content.equals("CtrlM")) {
			return "SWT.CTRL | M";
		} else if(content.equals("CtrlN")) {
			return "SWT.CTRL | N";
		} else if(content.equals("CtrlO")) {
			return "SWT.CTRL | O";
		} else if(content.equals("CtrlP")) {
			return "SWT.CTRL | P";
		} else if(content.equals("CtrlQ")) {
			return "SWT.CTRL | Q";
		} else if(content.equals("CtrlR")) {
			return "SWT.CTRL | R";
		} else if(content.equals("CtrlS")) {
			return "SWT.CTRL | S";
		} else if(content.equals("CtrlShift0")) {
			return "SWT.CTRL | SWT.SHIFT | SWT.KEYPAD_0";
		} else if(content.equals("CtrlShift1")) {
			return "SWT.CTRL | SWT.SHIFT | SWT.KEYPAD_1";
		} else if(content.equals("CtrlShift2")) {
			return "SWT.CTRL | SWT.SHIFT | SWT.KEYPAD_2";
		} else if(content.equals("CtrlShift3")) {
			return "SWT.CTRL | SWT.SHIFT | SWT.KEYPAD_3";
		} else if(content.equals("CtrlShift4")) {
			return "SWT.CTRL | SWT.SHIFT | SWT.KEYPAD_4";
		} else if(content.equals("CtrlShift5")) {
			return "SWT.CTRL | SWT.SHIFT | SWT.KEYPAD_5";
		} else if(content.equals("CtrlShift6")) {
			return "SWT.CTRL | SWT.SHIFT | SWT.KEYPAD_6";
		} else if(content.equals("CtrlShift7")) {
			return "SWT.CTRL | SWT.SHIFT | SWT.KEYPAD_7";
		} else if(content.equals("CtrlShift8")) {
			return "SWT.CTRL | SWT.SHIFT | SWT.KEYPAD_8";
		} else if(content.equals("CtrlShift9")) {
			return "SWT.CTRL | SWT.SHIFT | SWT.KEYPAD_9";
		} else if(content.equals("CtrlShiftA")) {
			return "SWT.CTRL | SWT.SHIFT | A";
		} else if(content.equals("CtrlShiftB")) {
			return "SWT.CTRL | SWT.SHIFT | B";
		} else if(content.equals("CtrlShiftC")) {
			return "SWT.CTRL | SWT.SHIFT | C";
		} else if(content.equals("CtrlShiftD")) {
			return "SWT.CTRL | SWT.SHIFT | D";
		} else if(content.equals("CtrlShiftE")) {
			return "SWT.CTRL | SWT.SHIFT | E";
		} else if(content.equals("CtrlShiftF")) {
			return "SWT.CTRL | SWT.SHIFT | F";
		} else if(content.equals("CtrlShiftF1")) {
			return "SWT.CTRL | SWT.SHIFT | SWT.F1";
		} else if(content.equals("CtrlShiftF10")) {
			return "SWT.CTRL | SWT.SHIFT | SWT.F10";
		} else if(content.equals("CtrlShiftF11")) {
			return "SWT.CTRL | SWT.SHIFT | SWT.F11";
		} else if(content.equals("CtrlShiftF12")) {
			return "SWT.CTRL | SWT.SHIFT | SWT.F12";
		} else if(content.equals("CtrlShiftF2")) {
			return "SWT.CTRL | SWT.SHIFT | SWT.F2";
		} else if(content.equals("CtrlShiftF3")) {
			return "SWT.CTRL | SWT.SHIFT | SWT.F3";
		} else if(content.equals("CtrlShiftF4")) {
			return "SWT.CTRL | SWT.SHIFT | SWT.F4";
		} else if(content.equals("CtrlShiftF5")) {
			return "SWT.CTRL | SWT.SHIFT | SWT.F5";
		} else if(content.equals("CtrlShiftF6")) {
			return "SWT.CTRL | SWT.SHIFT | SWT.F6";
		} else if(content.equals("CtrlShiftF7")) {
			return "SWT.CTRL | SWT.SHIFT | SWT.F7";
		} else if(content.equals("CtrlShiftF8")) {
			return "SWT.CTRL | SWT.SHIFT | SWT.F8";
		} else if(content.equals("CtrlShiftF9")) {
			return "SWT.CTRL | SWT.SHIFT | SWT.F9";
		} else if(content.equals("CtrlShiftH")) {
			return "SWT.CTRL | SWT.SHIFT | H";
		} else if(content.equals("CtrlShiftI")) {
			return "SWT.CTRL | SWT.SHIFT | I";
		} else if(content.equals("CtrlShiftJ")) {
			return "SWT.CTRL | SWT.SHIFT | J";
		} else if(content.equals("CtrlShiftK")) {
			return "SWT.CTRL | SWT.SHIFT | K";
		} else if(content.equals("CtrlShiftL")) {
			return "SWT.CTRL | SWT.SHIFT | L";
		} else if(content.equals("CtrlShiftM")) {
			return "SWT.CTRL | SWT.SHIFT | M";
		} else if(content.equals("CtrlShiftN")) {
			return "SWT.CTRL | SWT.SHIFT | N";
		} else if(content.equals("CtrlShiftO")) {
			return "SWT.CTRL | SWT.SHIFT | O";
		} else if(content.equals("CtrlShiftP")) {
			return "SWT.CTRL | SWT.SHIFT | P";
		} else if(content.equals("CtrlShiftQ")) {
			return "SWT.CTRL | SWT.SHIFT | Q";
		} else if(content.equals("CtrlShiftR")) {
			return "SWT.CTRL | SWT.SHIFT | R";
		} else if(content.equals("CtrlShiftS")) {
			return "SWT.CTRL | SWT.SHIFT | S";
		} else if(content.equals("CtrlShiftT")) {
			return "SWT.CTRL | SWT.SHIFT | T";
		} else if(content.equals("CtrlShiftU")) {
			return "SWT.CTRL | SWT.SHIFT | U";
		} else if(content.equals("CtrlShiftV")) {
			return "SWT.CTRL | SWT.SHIFT | V";
		} else if(content.equals("CtrlShiftW")) {
			return "SWT.CTRL | SWT.SHIFT | W";
		} else if(content.equals("CtrlShiftX")) {
			return "SWT.CTRL | SWT.SHIFT | X";
		} else if(content.equals("CtrlShiftY")) {
			return "SWT.CTRL | SWT.SHIFT | Y";
		} else if(content.equals("CtrlShiftZ")) {
			return "SWT.CTRL | SWT.SHIFT | Z";
		} else if(content.equals("CtrlShiftEnter")) {
			return "SWT.CTRL | SWT.SHIFT | Enter";
		} else if(content.equals("CtrlShiftSpace")) {
			return "SWT.CTRL | SWT.SHIFT | Space";
		} else if(content.equals("CtrlT")) {
			return "SWT.CTRL | T";
		} else if(content.equals("CtrlU")) {
			return "SWT.CTRL | U";
		} else if(content.equals("CtrlV")) {
			return "SWT.CTRL | V";
		} else if(content.equals("CtrlW")) {
			return "SWT.CTRL | W";
		} else if(content.equals("CtrlX")) {
			return "SWT.CTRL | X";
		} else if(content.equals("CtrlY")) {
			return "SWT.CTRL | Y";
		} else if(content.equals("CtrlZ")) {
			return "SWT.CTRL | Z";
		} else if(content.equals("ShiftDel")) {
			return "SWT.SHIFT | DEL";
		} else if(content.equals("ShiftF1")) {
			return "SWT.SHIFT | SWT.F1";
		} else if(content.equals("ShiftF10")) {
			return "SWT.SHIFT | SWT.F10";
		} else if(content.equals("ShiftF11")) {
			return "SWT.SHIFT | SWT.F11";
		} else if(content.equals("ShiftF12")) {
			return "SWT.SHIFT | SWT.F12";
		} else if(content.equals("ShiftF3")) {
			return "SWT.SHIFT | SWT.F2";
		} else if(content.equals("ShiftF3")) {
			return "SWT.SHIFT | SWT.F3";
		} else if(content.equals("ShiftF4")) {
			return "SWT.SHIFT | SWT.F4";
		} else if(content.equals("ShiftF5")) {
			return "SWT.SHIFT | SWT.F5";
		} else if(content.equals("ShiftF6")) {
			return "SWT.SHIFT | SWT.F6";
		} else if(content.equals("ShiftF7")) {
			return "SWT.SHIFT | SWT.F7";
		} else if(content.equals("ShiftF8")) {
			return "SWT.SHIFT | SWT.F8";
		} else if(content.equals("ShiftF9")) {
			return "SWT.SHIFT | SWT.F9";
		} else if(content.equals("ShiftIns")) {
			return "SWT.SHIFT | SWT.INSERT";
		} else if(content.equals("ShiftEnter")) {
			return "SWT.SHIFT | Enter";
		} else if(content.equals("ShiftSpace")) {
			return "SWT.SHIFT | Space";
		} else if(content.equals("Enter")) {
			return "Enter";
		} else if(content.equals("Space")) {
			return "Space";
		} else {
			return content;
		}
	}

	private static void tryPut(Map<String, Integer> map, String swtConst) {
		tryPut(map, swtConst, swtConst);
	}

	private static void tryPut(Map<String, Integer> map, String mapKey, String swtConst) {
		try {
			map.put(mapKey, SWT.class.getField(swtConst.substring(swtConst.lastIndexOf('.') + 1, swtConst.length())).getInt(null));
		} catch (Exception e) {
			String message = "Failed to register SWT Constant " + swtConst + ". Excecption: " + e.getClass().getName() + " - " + e.getMessage();
			System.out.println(message);
		}
	}
}
