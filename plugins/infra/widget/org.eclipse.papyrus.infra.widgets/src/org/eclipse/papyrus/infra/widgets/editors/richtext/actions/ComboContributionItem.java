/*****************************************************************************
 * Copyright (c) 2013 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/package org.eclipse.papyrus.infra.widgets.editors.richtext.actions;

import java.util.Collection;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.*;

public class ComboContributionItem extends ContributionItem
{
    protected Combo combo;
    protected ToolItem toolItem;
    protected CoolItem coolItem;
    protected int style;
    protected Collection<String> input;
    protected int defaultSelected = 0;

    public ComboContributionItem(int style)
    {
        this.style = style;
    }

    public void fill(ToolBar parent, int index)
    {
        toolItem = new ToolItem(parent, 2);
        Control box = createControl(parent);
        toolItem.setControl(box);
        Point preferredSize = combo.computeSize(-1, -1, true);
        toolItem.setWidth(preferredSize.x);
    }

    public void fill(CoolBar coolBar, int index)
    {
        Control box = createControl(coolBar);
        if(index >= 0)
            coolItem = new CoolItem(coolBar, 4, index);
        else
            coolItem = new CoolItem(coolBar, 4);
        coolItem.setData(this);
        coolItem.setControl(box);
        Point toolBarSize = box.computeSize(-1, -1);
        coolItem.setMinimumSize(toolBarSize);
        coolItem.setPreferredSize(toolBarSize);
        coolItem.setSize(toolBarSize);
    }

    public void fill(Composite parent)
    {
        createControl(parent);
    }

    protected Control createControl(Composite parent)
    {
        combo = new Combo(parent, style);
        combo.setVisibleItemCount(10);
        combo.setEnabled(true);
        combo.setItems((String[])input.toArray(new String[0]));
        if (input.size() > 0) {
            combo.select(defaultSelected);
        }
        combo.addDisposeListener(new DisposeListener() {
	            public void widgetDisposed(DisposeEvent event)
	            {
	                dispose();
	            }
        	});
        
        combo.addSelectionListener(new SelectionListener() {
            public void widgetDefaultSelected(SelectionEvent selectionevent)
            {
            }

            public void widgetSelected(SelectionEvent e)
            {
                performSelectionChanged();
            }
        });
        return combo;
    }

    protected int getSelectionIndex()
    {
        return combo.getSelectionIndex();
    }

    protected void setInput(Collection<String> input)
    {
        this.input = input;
    }

    protected void performSelectionChanged()
    {
    }

    public void dispose()
    {
        super.dispose();
    }

    public Combo getCCombo()
    {
        return combo;
    }

    public ToolItem getToolItem()
    {
        return toolItem;
    }

    public CoolItem getCoolItem()
    {
        return coolItem;
    }
}
