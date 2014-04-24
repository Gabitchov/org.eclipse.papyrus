package org.eclipse.papyrus.infra.widgets.databinding;

import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.ValueDiff;
import org.eclipse.epf.richtext.extension.RichTextEditor;
import org.eclipse.papyrus.infra.tools.databinding.AggregatedObservable;
import org.eclipse.papyrus.infra.widgets.providers.UnchangedObject;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

//TODO Comment
/**
 * An ObservableValue for Rich Text field
 * 
 * @author Camille Letavernier
 */
public class RichTextObservableValue extends AbstractObservableValue implements Listener {

	private RichTextEditor richTextEditor;

	private int eventType;

	private Object currentValue;

	/**
	 * If the Text field may represent more than one value,
	 * use an AggregatedObservable
	 * 
	 * May be null
	 */
	protected AggregatedObservable modelProperty;

	//TODO update param
	/**
	 * Constructor
	 * 
	 * @param text
	 *        The Text field to observe
	 * @param modelProperty
	 *        The model IObservableValue
	 * @param eventType
	 *        The eventType to listen to. When the event is fired by the Text
	 *        widget, this IObservableValue will fire a ChangeEvent
	 */
	public RichTextObservableValue(RichTextEditor richTextEditor, IObservableValue modelProperty, int eventType) {
		this.richTextEditor = richTextEditor;
		this.eventType = eventType;
		if(modelProperty instanceof AggregatedObservable) {
			this.modelProperty = (AggregatedObservable)modelProperty;
		}

		this.richTextEditor.addListener(eventType, this);
		this.richTextEditor.getSourceEdit().addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("keyReleased");

			}

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("keyPressed");

			}
		});

		//		addOkButtonListener();
	}

	/**
	 * 
	 */
	private void addOkButtonListener() {
		//get the ok button if exist to add a listener on it.
		Composite plop2 = this.richTextEditor.getParent().getParent().getParent().getParent().getParent().getParent().getParent();

		Control[] plopList = plop2.getChildren();
		if(plopList.length > 1) {
			Control[] plopList2 = ((Composite)plopList[1]).getChildren();
			if(plopList2.length > 1) {
				Control[] plopList3 = ((Composite)plopList2[1]).getChildren();
				if(plopList3[0] instanceof Button) {
					((Button)plopList3[0]).addMouseListener(new MouseListener() {

						@Override
						public void mouseUp(MouseEvent e) {
							System.out.println("  MouseUp !");
							ValueChange();
						}

						@Override
						public void mouseDown(MouseEvent e) {
							// TODO Auto-generated method stub

						}

						@Override
						public void mouseDoubleClick(MouseEvent e) {
							// TODO Auto-generated method stub

						}
					});
				}
			}
		}
	}

	public Object getValueType() {
		return String.class;
	}

	@Override
	protected Object doGetValue() {
		if(UnchangedObject.instance.toString().equals(richTextEditor.getText())) {
			return null;
		} else {
			return richTextEditor.getText();
		}
	}

	@Override
	protected void doSetValue(Object value) {
		if(modelProperty != null && modelProperty.hasDifferentValues()) {
			this.richTextEditor.setText(UnchangedObject.instance.toString());
			this.currentValue = UnchangedObject.instance;
		} else {
			if(value instanceof String) {
				this.richTextEditor.setText((String)value);
				this.currentValue = value;
			} else if(value == null) {
				this.richTextEditor.setText(""); //$NON-NLS-1$
				this.currentValue = null;
			}
		}
	}

	public void handleEvent(Event event) {
		System.out.println(event.toString());
		final Object oldValue = currentValue;
		final Object newValue = getValue();
		if(newValue == null) {
			return;
		}
		currentValue = newValue;

		if((eventType & event.type) != 0) {
			fireValueChange(new ValueDiff() {

				@Override
				public Object getOldValue() {
					return oldValue;
				}

				@Override
				public Object getNewValue() {
					return newValue;
				}
			});
		}
	}

	private void ValueChange() {
		final Object oldValue = currentValue;
		final Object newValue = getValue();
		if(newValue == null) {
			return;
		}
		currentValue = newValue;

		fireValueChange(new ValueDiff() {

			@Override
			public Object getOldValue() {
				return oldValue;
			}

			@Override
			public Object getNewValue() {
				return newValue;
			}
		});

	}

	@Override
	public synchronized void dispose() {
		this.richTextEditor.removeListener(eventType, this);
		super.dispose();
	}

}
