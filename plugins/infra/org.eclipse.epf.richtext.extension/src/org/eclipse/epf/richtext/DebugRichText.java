package org.eclipse.epf.richtext;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.epf.common.CommonPlugin;
import org.eclipse.epf.common.IHTMLFormatter;
import org.eclipse.epf.common.serviceability.Logger;
import org.eclipse.epf.common.utils.*;
import org.eclipse.epf.common.xml.XSLTProcessor;
import org.eclipse.epf.richtext.actions.CopyAction;
import org.eclipse.epf.richtext.actions.CutAction;
import org.eclipse.epf.richtext.actions.FindReplaceAction;
import org.eclipse.epf.richtext.actions.PasteAction;
import org.eclipse.epf.richtext.actions.PastePlainTextAction;
import org.eclipse.swt.browser.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.*;

// Referenced classes of package org.eclipse.epf.richtext:
//            IRichText, RichTextSelection, RichTextPlugin, RichTextListener, 
//            RichTextResources, RichTextImages

public class DebugRichText
    implements IRichText
{
    private static final String ENCODED_SINGLE_QUOTE = "%sq%";
    private static final String ENCODED_NEWLINE = "%EOL%";
    protected static final String STATUS_PREFIX = "$$$";
    protected static final int STATUS_PREFIX_LENGTH = "$$$".length();
    protected static final int STATUS_NOP = 0;
    protected static final int STATUS_INITIALIZED = 1;
    protected static final int STATUS_MODIFIED = 2;
    protected static final int STATUS_GET_TEXT = 3;
    protected static final int STATUS_KEY_DOWN = 4;
    protected static final int STATUS_KEY_UP = 5;
    protected static final int STATUS_SELECT_TEXT = 6;
    protected static final int STATUS_SELECT_CONTROL = 7;
    protected static final int STATUS_SELECT_NONE = 8;
    protected static final int STATUS_EXEC_CMD = 9;
    protected static final int STATUS_REFORMAT_LINKS = 10;
    private static final String DEFAULT_BASE_PATH = (new StringBuilder(String.valueOf(System.getProperty("user.home")))).append(System.getProperty("file.separator")).append("rte").toString();
    protected boolean debug;
    protected Logger logger;
    protected Browser editor;
    protected Control editorControl;
    protected static URL copyURL;
    protected Menu contextMenu;
    protected String rteFolder;
    protected String rteURL;
    protected String basePath;
    protected boolean initialized;
    protected boolean initializedWithFocus;
    protected String initialText;
    protected String currentText;
    private String currentRawText;
    protected boolean editable;
    protected boolean modified;
    protected boolean hasSelection;
    protected RichTextSelection richTextSelection;
    protected int status;
    protected IHTMLFormatter htmlFormatter;
    protected Map listeners;
    protected List<ModifyListener> modifyListeners;
    protected boolean notifyingModifyListeners;
    protected boolean hasFocus;
    protected boolean processingJSEvent;
    protected boolean checkingModifyEvent;
    protected FindReplaceAction findReplaceAction;
    protected boolean isIE;
    public static final int RICH_TEXT_INITIALIZED_WIN32 = 98979695;
    public static final int RICH_TEXT_INITIALIZED_LINUX = 98979694;
    
    public DebugRichText(Composite parent, int style, String basePath)
    {
        currentText = "";
        currentRawText = "";
        editable = true;
        richTextSelection = new RichTextSelection();
        status = 0;
        notifyingModifyListeners = false;
        hasFocus = false;
        processingJSEvent = false;
        checkingModifyEvent = false;
        isIE = false;
        debug = RichTextPlugin.getDefault().isDebugging();
        logger = RichTextPlugin.getDefault().getLogger();
        findReplaceAction = new FindReplaceAction(this);
        rteFolder = (new StringBuilder(String.valueOf(RichTextPlugin.getDefault().getInstallPath()))).append("rte/").toString();
        rteURL = XMLUtil.escape((new StringBuilder("file://")).append(rteFolder).toString());
        setBasePath(basePath);
        try
        {
            editor = new Browser(parent, 0);
            if(debug)
                printDebugMessage("RichText", (new StringBuilder("basePath=")).append(basePath).toString());
            editor.setLayoutData(new GridData(1808));
            editor.setData("richText", this);
            init(parent, style);
        }
        catch(Exception e)
        {
            editor = null;
            String msg = (new StringBuilder("Failed to create RichText with basePath=")).append(basePath).toString();
            logger.logError(msg, e);
            if(debug)
            {
                System.out.println(msg);
                e.printStackTrace();
            }
        }
    }

    public DebugRichText(Composite parent, int style)
    {
        this(parent, style, null);
    }

    protected void setBasePath(String path)
    {
        if(path != null && path.length() > 0)
        {
            if(path.startsWith("\\\\"))
                basePath = (new StringBuilder("\\\\")).append(FileUtil.appendSeparator(path.substring(FileUtil.UNC_PATH_PREFIX_LENGTH).replace('\\', '/'), "/")).toString();
            else
                basePath = FileUtil.appendSeparator(path).replace('\\', '/');
        } else
        {
            basePath = FileUtil.appendSeparator(DEFAULT_BASE_PATH).replace('\\', '/');
        }
    }

    protected void init(Composite parent, int style)
        throws Exception
    {
        try
        {
            addStatusTextListener();
            if(debug)
                printDebugMessage("init", "added status text listener");
            String editorHTML = generateEditorHTML();
            if(debug)
                printDebugMessage("init", "generated editor HTML");
            editor.setText(editorHTML);
            if(debug)
                printDebugMessage("init", "loaded editor HTML");
            contextMenu = new Menu(parent.getShell(), 8);
            editor.setMenu(contextMenu);
            fillContextMenu(contextMenu);
            if(debug)
                printDebugMessage("init", "added context menu");
            addListeners();
            if(debug)
                printDebugMessage("init", "added listeners");
            htmlFormatter = (IHTMLFormatter)ExtensionHelper.createExtensionForJTidy(CommonPlugin.getDefault().getId(), "htmlFormatter");
            if(debug)
                printDebugMessage("init", "instantiated HTMLFormatter");
        }
        catch(Exception e)
        {
            editor = null;
            dispose();
            throw e;
        }
    }

    public Control getControl()
    {
        return editor;
    }

    public void setLayoutData(Object layoutData)
    {
        if(editor != null)
            editor.setLayoutData(layoutData);
    }

    public Object getLayoutData()
    {
        if(editor != null)
            return editor.getLayoutData();
        else
            return null;
    }

    public void setFocus()
    {
        if(debug)
            printDebugMessage((new StringBuilder("setFocus, editable=")).append(editable).toString());
        if(editor != null)
            if(initialized)
            {
                if(!editor.isFocusControl())
                {
                    if(!Platform.getOS().equals("win32"))
                        editor.setFocus();
                    executeCommand("setFocus");
                }
                hasFocus = true;
            } else
            {
                initializedWithFocus = true;
            }
    }

    public void setBlur()
    {
        if(debug)
            printDebugMessage((new StringBuilder("setBlur, editable=")).append(editable).toString());
        if(editor != null)
            if(initialized)
                hasFocus = false;
            else
                initializedWithFocus = false;
    }

    public boolean hasFocus()
    {
        if(editor != null)
            return hasFocus;
        else
            return false;
    }

    public String getBasePath()
    {
        return basePath;
    }

    public URL getCopyURL()
    {
        return copyURL;
    }

    public void setCopyURL()
    {
        try
        {
            copyURL = (new File(basePath)).toURL();
        }
        catch(Exception _ex)
        {
            copyURL = null;
        }
    }

    public boolean getEditable()
    {
        return editable;
    }

    public void setEditable(boolean editable)
    {
        this.editable = editable;
        if(initialized)
            executeCommand("setEditable", (new StringBuilder()).append(editable).toString());
    }

    public boolean getModified()
    {
        return modified;
    }

    public void setModified(boolean modified)
    {
        this.modified = modified;
    }

    public String getText()
    {
        if(editor != null && initialized)
            try
            {
                executeCommand("getText");
                if(currentText != null && currentText.length() > 0)
                {
                    currentText = currentText.replaceAll("<P>&nbsp;</P>", "<br/>");
                    currentText = tidyText(currentText);
                    currentText = formatHTML(currentText);
                } else
                {
                    currentText = "";
                }
                if(debug)
                    printDebugMessage("getText", "text=", currentText);
                return currentText;
            }
            catch(Exception e)
            {
                logger.logError(e);
            }
        return "";
    }

    protected String formatHTML(String text)
    {
        try
        {
            String formattedText = htmlFormatter.formatHTML(text);
            if(htmlFormatter.getLastErrorStr() != null)
                logger.logError(htmlFormatter.getLastErrorStr());
            return formattedText;
        }
        catch(UnsupportedEncodingException e)
        {
            logger.logError(e);
        }
        return text;
    }

    public void setText(String text)
    {
        if(editor != null)
        {
            if(debug)
                printDebugMessage("setText", "text=", text);
            setCurrentRawText(text);
            String newText = text;
            if(newText != null)
            {
                newText = tidyText(newText);
                newText = formatHTML(newText);
            } else
            {
                newText = "";
            }
            if(initialized)
                modified = !newText.equals(currentText);
            initialText = newText;
            if(initialText.equals("") && !isIE)
                initialText = "<br />";
            if(debug)
                printDebugMessage("setText", (new StringBuilder("modified=")).append(modified).append(", newText=").toString(), newText);
            if(initialized)
                try
                {
                    executeCommand("setText", workaroundForObjectParamNode(newText));
                    executeCommand("setEditable", (new StringBuilder()).append(editable).toString());
                }
                catch(Exception e)
                {
                    logger.logError(e);
                }
            currentText = newText;
        }
    }

    public void restoreText()
    {
        setText(initialText);
        modified = false;
    }

    public String getSelectedText()
    {
        return richTextSelection.getText();
    }

    public RichTextSelection getSelected()
    {
        return richTextSelection;
    }

    public Object getData(String key)
    {
        if(editor != null)
            return editor.getData(key);
        else
            return null;
    }

    public void setData(String key, Object value)
    {
        if(editor != null)
            editor.setData(key, value);
    }

    protected int execute(final String script)
    {
        status = 0;
        if(editor != null && script != null && script.length() > 0)
            try
            {
                if(!isIE && processingJSEvent)
                    Display.getCurrent().asyncExec(new Runnable() {

                        public void run()
                        {
                            if(!isDisposed())
                            {
                                editor.execute(script);
                                if(!Platform.getOS().equals("win32") && script.startsWith("setText"))
                                    notifyListeners(98979694, new Event());
                            }
                        }
                    });
                else
                    editor.execute(script);
                if(debug)
                    printDebugMessage("execute", script);
            }
            catch(Exception e)
            {
                String msg = (new StringBuilder("Failed to execute ")).append(script).toString();
                logger.logError(msg, e);
                if(debug)
                {
                    printDebugMessage("execute", msg);
                    e.printStackTrace();
                }
            }
        return status;
    }

    public int executeCommand(String command)
    {
        status = 0;
        if(command != null && command.equals("clearContent"))
        {
            String oldInitialText = initialText;
            setText("");
            initialText = oldInitialText;
            status = 1;
            modified = true;
            notifyModifyListeners();
        } else
        {
            status = execute((new StringBuilder(String.valueOf(command))).append("();").toString());
        }
        return status;
    }

    public int executeCommand(String command, String param)
    {
        if(param == null)
            return executeCommand(command);
        else
            return execute((new StringBuilder(String.valueOf(command))).append("('").append(formatText(param)).append("');").toString());
    }

    public int executeCommand(String command, String params[])
    {
        if(params == null || params.length == 0)
            return executeCommand(command);
        StringBuffer sb = new StringBuffer();
        int paramsLength = params.length;
        for(int i = 0; i < paramsLength; i++)
        {
            sb.append('\'').append(formatText(params[i])).append('\'');
            if(i < paramsLength - 1)
                sb.append(',');
        }

        String param = sb.toString();
        return execute((new StringBuilder(String.valueOf(command))).append("(").append(param).append(");").toString());
    }

    public void dispose()
    {
        if(contextMenu != null && !contextMenu.isDisposed())
        {
            contextMenu.dispose();
            contextMenu = null;
        }
        if(listeners != null)
        {
            listeners.clear();
            listeners = null;
        }
        if(modifyListeners != null)
        {
            modifyListeners.clear();
            modifyListeners = null;
        }
        if(htmlFormatter != null)
            htmlFormatter = null;
        if(findReplaceAction != null)
        {
            findReplaceAction.dispose();
            findReplaceAction = null;
        }
    }

    public boolean isDisposed()
    {
        return editor.isDisposed();
    }

    public Iterator getModifyListeners()
    {
        return modifyListeners.iterator();
    }

    public void addKeyListener(KeyListener listener)
    {
        if(editor != null)
            editor.addKeyListener(listener);
    }

    public void removeKeyListener(KeyListener listener)
    {
        if(editor != null)
            editor.removeKeyListener(listener);
    }

    public void addModifyListener(ModifyListener listener)
    {
        if(editor != null && listener != null && !modifyListeners.contains(listener))
            modifyListeners.add(listener);
    }

    public void removeModifyListener(ModifyListener listener)
    {
        if(editor != null && listener != null && modifyListeners.contains(listener))
            modifyListeners.remove(listener);
    }

    public void addDisposeListener(DisposeListener listener)
    {
        if(editor != null)
            editor.addDisposeListener(listener);
    }

    public void removeDisposeListener(DisposeListener listener)
    {
        if(editor != null)
            editor.removeDisposeListener(listener);
    }

    public void addHelpListener(HelpListener listener)
    {
        if(editor != null)
            editor.addHelpListener(listener);
    }

    public void removeHelpListener(HelpListener listener)
    {
        if(editor != null)
            editor.removeHelpListener(listener);
    }

    public void addListener(int eventType, Listener listener)
    {
        if(editor != null && !listeners.containsKey(listener))
        {
            if(eventType != 2 && (editorControl == null || eventType != 26 && eventType != 27 && eventType != 15 && eventType != 16))
                editor.addListener(eventType, listener);
            listeners.put(listener, new RichTextListener(eventType, listener));
        }
    }

    public void removeListener(int eventType, Listener listener)
    {
        if(editor != null && listeners.containsKey(listener))
        {
            if(editorControl == null || eventType != 26 && eventType != 27 && eventType != 15 && eventType != 16)
                editor.removeListener(eventType, listener);
            listeners.remove(listener);
        }
    }

    public Iterator getListeners()
    {
        return listeners.values().iterator();
    }

    protected void addStatusTextListener()
    {
        editor.addStatusTextListener(new StatusTextListener() {

            public void changed(StatusTextEvent event)
            {
                String eventText;
                int eventTextLength;
                eventText = event.text;
                eventTextLength = eventText.length();
                if(!eventText.startsWith("$$$") || eventTextLength <= DebugRichText.STATUS_PREFIX_LENGTH)
                	return;
                try
                {
                    processingJSEvent = true;
                    int endStatusIndex = DebugRichText.STATUS_PREFIX_LENGTH + 1;
                    if(eventText.length() > DebugRichText.STATUS_PREFIX_LENGTH + 1 && Character.isDigit(eventText.charAt(endStatusIndex)))
                        endStatusIndex++;
                    int statusType = Integer.parseInt(eventText.substring(DebugRichText.STATUS_PREFIX_LENGTH, endStatusIndex));
                    switch(statusType)
                    {
                    case 0: // '\0'
                    default:
                        break;

                    case 1: // '\001'
                        if(!initialized)
                        {
                            initialized = true;
                            if(debug)
                                printDebugMessage("statusTextListener", "STATUS_INITIALIZED");
                            if(!Platform.getOS().equals("win32"))
                                executeCommand("setHeight", (new StringBuilder()).append(editor.getBounds().height).toString());
                            executeCommand("setText", DebugRichText.workaroundForObjectParamNode(currentText));
                            if(initializedWithFocus)
                                setFocus();
                            if(!editable)
                                executeCommand("setEditable", (new StringBuilder()).append(editable).toString());
                            if(Platform.getOS().equals("win32"))
                                notifyListeners(98979695, new Event());
                        }
                        break;

                    case 2: // '\002'
                        if(debug)
                            printDebugMessage("statusTextListener", "STATUS_MODIFIED");
                        checkModify();
                        break;

                    case 3: // '\003'
                        if(eventTextLength >= DebugRichText.STATUS_PREFIX_LENGTH + 2)
                        {
                            currentText = eventText.substring(DebugRichText.STATUS_PREFIX_LENGTH + 2);
                            currentText = unWorkaroundForObjectParamNode(currentText);
                        } else
                        {
                            currentText = "";
                        }
                        if(debug)
                            printDebugMessage("statusTextListener", "STATUS_GET_TEXT, currentText=", currentText);
                        break;

                    case 4: // '\004'
                        if(eventTextLength < DebugRichText.STATUS_PREFIX_LENGTH + 2)
                            break;
                        String cmd = eventText.substring(DebugRichText.STATUS_PREFIX_LENGTH + 2);
                        if(debug)
                            printDebugMessage("statusTextListener", (new StringBuilder("STATUS_KEY_DOWN, cmd=")).append(cmd).toString());
                        if(cmd.equals("copy"))
                        {
                            setCopyURL();
                            break;
                        }
                        if(cmd.equals("cut"))
                        {
                            setCopyURL();
                            CutAction action = new CutAction(DebugRichText.this);
                            action.execute(DebugRichText.this);
                            break;
                        }
                        if(cmd.equals("findText"))
                        {
                            getFindReplaceAction().execute(DebugRichText.this);
                            break;
                        }
                        if(cmd.equals("paste"))
                        {
                            PasteAction action = new PasteAction(DebugRichText.this);
                            action.execute(DebugRichText.this);
                            break;
                        }
                        if(cmd.equals("save"))
                        {
                            PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().doSave(null);
                            break;
                        }
                        if(cmd.equals("saveAll"))
                            PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().saveAllEditors(false);
                        break;

                    case 5: // '\005'
                        if(debug)
                            printDebugMessage("statusTextListener", (new StringBuilder("STATUS_KEY_UP, modified=")).append(modified).toString());
                        checkModify();
                        break;

                    case 6: // '\006'
                        if(eventTextLength >= DebugRichText.STATUS_PREFIX_LENGTH + 2)
                        {
                            String strings[] = eventText.substring(DebugRichText.STATUS_PREFIX_LENGTH + 2).split("\\$", 5);
                            try
                            {
                                richTextSelection.setFontName(strings[0]);
                                richTextSelection.setFontSize(strings[1]);
                                richTextSelection.setBlockStyle(strings[2]);
                                richTextSelection.setFlags(Integer.parseInt(strings[3]));
                                richTextSelection.setText(strings[4]);
                            }
                            catch(NumberFormatException e)
                            {
                                logger.logError(e);
                            }
                            if(debug)
                                printDebugMessage("selectionStatusListener", (new StringBuilder("current selection is=")).append(richTextSelection).toString());
                            hasSelection = true;
                            if(hasFocus())
                                notifyListeners(2, new Event());
                        } else
                        {
                            richTextSelection.setText("");
                            hasSelection = false;
                        }
                        if(debug)
                            printDebugMessage("statusTextListener", "STATUS_SELECT_TEXT, selectedText=", richTextSelection.getText());
                        break;

                    case 7: // '\007'
                        if(debug)
                            printDebugMessage("statusTextListener", "STATUS_SELECT_CONTROL, control selected");
                        hasSelection = true;
                        break;

                    case 8: // '\b'
                        if(debug)
                            printDebugMessage("statusTextListener", "STATUS_SELECT_NONE, no selection");
                        hasSelection = false;
                        break;

                    case 9: // '\t'
                        if(eventTextLength >= DebugRichText.STATUS_PREFIX_LENGTH + 3)
                            try
                            {
                                status = Integer.parseInt(eventText.substring(DebugRichText.STATUS_PREFIX_LENGTH + 2, DebugRichText.STATUS_PREFIX_LENGTH + 3));
                            }
                            catch(Exception _ex)
                            {
                                status = -1;
                            }
                        if(debug && status != 1)
                            printDebugMessage("statusTextListener", (new StringBuilder("STATUS_EXEC_CMD, status=")).append(status).toString());
                        break;

                    case 10: // '\n'
                        if(debug)
                            printDebugMessage("statusTextListener", "STATUS_REFORMAT_LINKS");
                        Platform.getOS().equals("win32");
                        checkModify();
                        break;
                    }
                }
                catch(Exception _ex)
                {
                    processingJSEvent = false;
                }
            }
        }
);
    }

    protected String generateEditorHTML()
        throws Exception
    {
        String escapedBasePath = basePath;
        if(escapedBasePath.startsWith("\\\\"))
            escapedBasePath = escapedBasePath.replaceFirst("^\\\\\\\\", "\\\\\\\\\\\\\\\\");
        escapedBasePath = XMLUtil.escape((new StringBuilder("file://")).append(escapedBasePath.replaceAll("'", "\\\\'")).toString());
        String escapedRteUTL = rteURL.replaceAll("&apos;", "%27");
        StringBuffer rteXML = new StringBuffer();
        rteXML.append("<rte id=\"").append("rte").append("\" css=\"").append((new StringBuilder(String.valueOf(escapedRteUTL))).append("rte.css").toString()).append("\" js=\"").append((new StringBuilder(String.valueOf(escapedRteUTL))).append("rte.js").toString()).append("\" baseURL=\"").append(escapedBasePath).append("\"/>");
        StringWriter result = new StringWriter();
        XSLTProcessor.transform((new StringBuilder(String.valueOf(rteFolder))).append("rte.xsl").toString(), rteXML.toString(), result);
        return result.toString();
    }

    protected void fillContextMenu(Menu contextMenu)
    {
        final MenuItem cutItem = new MenuItem(contextMenu, 8);
        cutItem.setText(RichTextResources.cutAction_text);
        cutItem.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent event)
            {
                CutAction action = new CutAction(DebugRichText.this);
                action.execute(DebugRichText.this);
            }
        });
        final MenuItem copyItem = new MenuItem(contextMenu, 8);
        copyItem.setText(RichTextResources.copyAction_text);
        copyItem.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent event)
            {
                CopyAction action = new CopyAction(DebugRichText.this);
                action.execute(DebugRichText.this);
            }
        }
);
        final MenuItem pasteItem = new MenuItem(contextMenu, 8);
        pasteItem.setText(RichTextResources.pasteAction_text);
        pasteItem.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent event)
            {
                PasteAction action = new PasteAction(DebugRichText.this);
                action.execute(DebugRichText.this);
            }
        });
        final MenuItem pastePlainTextItem = new MenuItem(contextMenu, 8);
        pastePlainTextItem.setText(RichTextResources.pastePlainTextAction_text);
        pastePlainTextItem.setImage(RichTextImages.IMG_PASTE_PLAIN_TEXT);
        pastePlainTextItem.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent event)
            {
                PastePlainTextAction action = new PastePlainTextAction(DebugRichText.this);
                action.execute(DebugRichText.this);
            }
        });
        contextMenu.addMenuListener(new MenuListener() {

            public void menuHidden(MenuEvent menuevent)
            {
            }

            public void menuShown(MenuEvent e)
            {
                getSelectedText();
                cutItem.setEnabled(editable && hasSelection);
                copyItem.setEnabled(hasSelection);
                pasteItem.setEnabled(editable);
                pastePlainTextItem.setEnabled(editable);
            }
        });
    }

    protected void addListeners()
    {
        editorControl = getControlSite(editor);
        if(editorControl != null)
        {
            if(debug)
                printDebugMessage("init", (new StringBuilder("editorControl=")).append(editorControl.getClass().getName()).toString());
            isIE = true;
            editorControl.addListener(26, new Listener() {

                public void handleEvent(Event event)
                {
                    if(debug)
                        printDebugMessage("activateListener");
                    setFocus();
                    notifyListeners(26, event);
                }
            });
            editorControl.addListener(27, new Listener() {

                public void handleEvent(Event event)
                {
                    if(debug)
                        printDebugMessage("deactivateListener");
                    setBlur();
                    notifyListeners(27, event);
                }
            });
            editorControl.addListener(15, new Listener() {

                public void handleEvent(Event event)
                {
                    if(debug)
                        printDebugMessage("focusInListener");
                    executeCommand("updateSelection");
                    notifyListeners(15, event);
                }
            });
            editorControl.addKeyListener(new KeyAdapter() {

                public void keyReleased(KeyEvent event)
                {
                    int keyCode = event.keyCode;
                    int stateMask = event.stateMask;
                    if(debug)
                        printDebugMessage("keyUpListener", (new StringBuilder("keyCode=")).append(keyCode).append(", stateMask=").append(stateMask).append(", editable=").append(editable).toString());
                    if(stateMask == 262144 && event.keyCode == 17)
                        executeCommand("updateSelection");
                    if((stateMask & 262144) > 0 || (stateMask & 65536) > 0 || (stateMask & 131072) > 0 && keyCode == stateMask)
                        return;
                    if(editable)
                        switch(event.keyCode)
                        {
                        case 9: // '\t'
                        case 16777217: 
                        case 16777218: 
                        case 16777219: 
                        case 16777220: 
                        case 16777221: 
                        case 16777222: 
                        case 16777223: 
                        case 16777224: 
                            return;

                        default:
                            checkModify();
                            break;
                        }
                }
            });
            editor.addLocationListener(new LocationAdapter() {

                public void changing(LocationEvent event)
                {
                    event.doit = editable;
                }
            });
        } else
        {
            editor.addListener(26, new Listener() {

                public void handleEvent(Event event)
                {
                    if(debug)
                        printDebugMessage("activateListener");
                    setFocus();
                }
            });
            editor.addKeyListener(new KeyListener() {

                public void keyPressed(KeyEvent e)
                {
                    if(e.keyCode == 9)
                    {
                        if((e.stateMask & 131072) != 0)
                            editor.traverse(8);
                        else
                        if((e.stateMask & 262144) == 0)
                            editor.traverse(16);
                        return;
                    }
                    if(!editable)
                        e.doit = false;
                }

                public void keyReleased(KeyEvent e)
                {
                    if((e.stateMask & 262144) > 0 || (e.stateMask & 65536) > 0)
                        return;
                    if(editable)
                        switch(e.keyCode)
                        {
                        default:
                            checkModify();
                            break;

                        case 9: // '\t'
                        case 131072: 
                        case 16777217: 
                        case 16777218: 
                        case 16777219: 
                        case 16777220: 
                        case 16777221: 
                        case 16777222: 
                        case 16777223: 
                        case 16777224: 
                            break;
                        }
                }
            });
        }
        editor.addDisposeListener(new DisposeListener() {

            public void widgetDisposed(DisposeEvent e)
            {
                if(debug)
                    printDebugMessage("disposeListener");
                dispose();
            }
        });
        listeners = new Hashtable();
        modifyListeners = new ArrayList();
    }

    protected void notifyListeners(int eventType, Event event)
    {
        if(notifyingModifyListeners)
            return;
        if(listeners != null)
        {
            event.display = Display.getCurrent();
            event.widget = editor;
            for(Iterator i = listeners.values().iterator(); i.hasNext();)
            {
                RichTextListener listener = (RichTextListener)i.next();
                if(listener.getEventType() == eventType)
                {
                    if(debug)
                        printDebugMessage("notifyListeners", (new StringBuilder("notifying listener, ")).append(listener).append(", eventType=").append(eventType).toString());
                    listener.getListener().handleEvent(event);
                    if(debug)
                        printDebugMessage("notifyListeners", (new StringBuilder("notified listener, ")).append(listener).append(", eventType=").append(eventType).toString());
                }
            }

        }
    }

    public void notifyModifyListeners()
    {
        notifyingModifyListeners = true;
        Event event = new Event();
        event.display = Display.getCurrent();
        event.widget = editor;
        for(Iterator i = modifyListeners.iterator(); i.hasNext();)
        {
            ModifyListener listener = (ModifyListener)i.next();
            if(debug)
                printDebugMessage("notifyModifyListeners", (new StringBuilder("notifying listener, ")).append(listener).toString());
            listener.modifyText(new ModifyEvent(event));
            if(debug)
                printDebugMessage("notifyModifyListeners", (new StringBuilder("notified listener, ")).append(listener).toString());
        }

        notifyingModifyListeners = false;
    }

    public void checkModify()
    {
        if(!checkingModifyEvent)
        {
            checkingModifyEvent = true;
            if(modified)
                notifyModifyListeners();
            else
            if(!isIE && processingJSEvent)
                Display.getCurrent().asyncExec(new Runnable() {

                    public void run()
                    {
                        if(!getText().equals(initialText))
                        {
                            modified = true;
                            notifyModifyListeners();
                        }
                    }
                });
            else
            if(!getText().equals(initialText))
            {
                modified = true;
                notifyModifyListeners();
            }
            if(debug)
                printDebugMessage("checkModify", (new StringBuilder("modified=")).append(modified).toString());
        }
        checkingModifyEvent = false;
        return;
    }

    public String tidyText(String text)
    {
        return text;
    }

    public String formatText(String text)
    {
        if(text == null || text.length() == 0)
            return text;
        StringBuffer result = new StringBuffer();
        int textSize = text.length();
        for(int i = 0; i < textSize; i++)
        {
            char ch = text.charAt(i);
            switch(ch)
            {
            case 9: // '\t'
                result.append(' ');
                break;

            case 10: // '\n'
                result.append("%EOL%");
                break;

            case 39: // '\''
                result.append("%sq%");
                break;

            case 92: // '\\'
                result.append("\\\\");
                break;

            default:
                result.append(ch);
                break;

            case 13: // '\r'
                break;
            }
        }

        return result.toString();
    }

    protected Control getControlSite(Composite composite)
    {
        if(Platform.getOS().equals("win32"))
        {
            Control controls[] = composite.getChildren();
            for(int i = 0; i < controls.length; i++)
            {
                String controlClass = controls[i].getClass().getName();
                if(controlClass.equals("org.eclipse.swt.browser.WebSite"))
                    return controls[i];
                if(controls[i] instanceof Composite)
                    return getControlSite((Composite)controls[i]);
            }

        }
        return null;
    }

    protected void printDebugMessage(String method, String msg, String text)
    {
        StringBuffer strBuf = new StringBuffer();
        strBuf.append("RichText[").append(editor.handle).append(']').append('.').append(method);
        if(msg != null && msg.length() > 0)
            strBuf.append(": ").append(msg);
        if(text != null && text.length() > 0)
            strBuf.append('\n').append(text);
        System.out.println(strBuf);
    }

    protected void printDebugMessage(String method, String msg)
    {
        printDebugMessage(method, msg, null);
    }

    protected void printDebugMessage(String method)
    {
        printDebugMessage(method, null);
    }

    public FindReplaceAction getFindReplaceAction()
    {
        return findReplaceAction;
    }

    public void setFindReplaceAction(FindReplaceAction findReplaceAction)
    {
        if(findReplaceAction != null)
        {
            if(this.findReplaceAction != null && this.findReplaceAction != findReplaceAction)
                this.findReplaceAction.dispose();
            this.findReplaceAction = findReplaceAction;
            this.findReplaceAction.setRichText(this);
        }
    }

    public void setInitialText(String text)
    {
        setText(text);
        initialText = text != null ? text : "";
        modified = false;
    }

    public boolean hasError()
    {
        return htmlFormatter.getLastErrorStr() != null;
    }

    public static String workaroundForObjectParamNode(String html)
    {
        String result = html.replaceAll("<param", "<paramTemp");
        return result;
    }

    private String unWorkaroundForObjectParamNode(String html)
    {
        String result = html.replaceAll("<paramTemp", "<param");
        return result;
    }

    public String getCurrentRawText()
    {
        return currentRawText;
    }

    private void setCurrentRawText(String currentRawText)
    {
        this.currentRawText = currentRawText != null ? currentRawText : "";
    }

}
