package org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.presentation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.papyrus.emf.facet.util.core.Logger;
import org.eclipse.papyrus.emf.facet.util.core.internal.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Sash;
import org.eclipse.ui.forms.FormColors;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.forms.widgets.FormToolkit;

/** Adapted from {@link org.eclipse.ui.forms.MasterDetailsBlock} */
public abstract class FormStyleSashForm extends SashForm {
	private final ArrayList<Sash> fSashes = new ArrayList<Sash>();
	private final FormToolkit formToolkit;
	private int minWidth = 0;

	private final Listener fListener = new Listener() {
		public void handleEvent(final Event e) {
			switch (e.type) {
			case SWT.MouseEnter:
				e.widget.setData("hover", Boolean.TRUE); //$NON-NLS-1$
				((Control) e.widget).redraw();
				break;
			case SWT.MouseExit:
				e.widget.setData("hover", null); //$NON-NLS-1$
				((Control) e.widget).redraw();
				break;
			case SWT.Paint:
				onSashPaint(e);
				break;
			case SWT.Resize:
				hookSashListeners();
				break;
			case SWT.Selection:
				if (e.x < FormStyleSashForm.this.minWidth) {
					e.x = FormStyleSashForm.this.minWidth;
				}
				break;
			default:
				Logger.logWarning("Unhandled event", Activator.getDefault()); //$NON-NLS-1$
			}
		}
	};

	public FormStyleSashForm(final Composite parent, final int style, final FormToolkit formToolkit) {
		super(parent, style);
		this.formToolkit = formToolkit;
		formToolkit.adapt(this, false, false);
		createContents();
		hookListeners();
	}

	public void setMinWidth(final int minWidth) {
		this.minWidth = minWidth;
	}

	protected abstract void createContents();

	private void hookListeners() {
		final Listener listener = this.fListener;
		for (final Control child : getChildren()) {
			if (!(child instanceof Sash)) {
				child.addListener(SWT.Resize, listener);
			}
		}
	}

	@Override
	public void layout(final boolean changed) {
		super.layout(changed);
		hookSashListeners();
	}

	@Override
	public void layout(final Control[] children) {
		super.layout(children);
		hookSashListeners();
	}

	void hookSashListeners() {
		purgeSashes();
		try {
			final Sash[] allSashes = getSashes();
			for (final Sash sash : allSashes) {
				if (this.fSashes.contains(sash)) {
					continue;
				}
				sash.addListener(SWT.Paint, this.fListener);
				sash.addListener(SWT.MouseEnter, this.fListener);
				sash.addListener(SWT.MouseExit, this.fListener);
				sash.addListener(SWT.Selection, this.fListener);
				this.fSashes.add(sash);
			}
		} catch (final Exception e) {
			Logger.logError(e, Activator.getDefault());
		}
	}

	private Sash[] getSashes() {
		try {
			final Field sashesField = SashForm.class.getDeclaredField("sashes"); //$NON-NLS-1$
			sashesField.setAccessible(true);
			final Sash[] allSashes = (Sash[]) sashesField.get(this);
			return allSashes;
		} catch (final Exception e) {
			Logger.logError(e, Activator.getDefault());
			return new Sash[0];
		}
	}

	private void purgeSashes() {
		for (final Iterator<Sash> iter = this.fSashes.iterator(); iter.hasNext();) {
			final Sash sash = iter.next();
			if (sash.isDisposed()) {
				iter.remove();
			}
		}
	}

	void onSashPaint(final Event e) {
		final Sash sash = (Sash) e.widget;
		final FormColors colors = this.formToolkit.getColors();
		final GC gc = e.gc;
		final Boolean hover = (Boolean) sash.getData("hover"); //$NON-NLS-1$
		if (hover != null) {
			gc.setBackground(colors.getColor(IFormColors.TB_BG));
			gc.setForeground(colors.getColor(IFormColors.TB_BORDER));
			final Point size = sash.getSize();
			gc.fillRectangle(0, 0, size.x, size.y);
		}
	}
}