package org.eclipse.papyrus.infra.gmfdiag.common.snap;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionDimension;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.handles.HandleBounds;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.tools.ResizeTracker;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.gmfdiag.common.Activator;
import org.eclipse.papyrus.infra.gmfdiag.common.preferences.PreferencesConstantsHelper;

/**
 * Adapted code from ResizeTracker
 * A resize tracker managing a preference for constrained resize
 * 
 */
public class ResizeTrackerWithPreferences extends ResizeTracker {

	/**
	 * the snap helper to use
	 */
	private SnapToHelper localSnapToHelper;

	/**
	 * the source rect bounds
	 */
	private PrecisionRectangle localSourceRect;

	public ResizeTrackerWithPreferences(GraphicalEditPart owner, int direction) {
		super(owner, direction);
	}

	@Override
	public void activate() {
		super.activate();
		if(getOwner() != null) {
			if(getTargetEditPart() != null)
				localSnapToHelper = (SnapToHelper)getTargetEditPart().getAdapter(SnapToHelper.class);

			IFigure figure = getOwner().getFigure();
			if(figure instanceof HandleBounds)
				localSourceRect = new PrecisionRectangle(((HandleBounds)figure).getHandleBounds());
			else
				localSourceRect = new PrecisionRectangle(figure.getBounds());
			figure.translateToAbsolute(localSourceRect);
		}
	}

	/**
	 * 
	 * @see org.eclipse.gef.tools.ResizeTracker#updateSourceRequest()
	 * 
	 */
	@Override
	protected void updateSourceRequest() {
		ChangeBoundsRequest request = (ChangeBoundsRequest)getSourceRequest();
		Dimension d = getDragMoveDelta();

		Point location = new Point(getLocation());
		Point moveDelta = new Point(0, 0);
		Dimension resizeDelta = new Dimension(0, 0);

		request.setConstrainedResize(isConstrainedResizeAccordingToPreference());
		request.setCenteredResize(getCurrentInput().isModKeyDown(SnapUtils.MODIFIER_CENTERED_RESIZE));
		request.setSnapToEnabled(!getCurrentInput().isModKeyDown(SnapUtils.MODIFIER_NO_SNAPPING));

		if(request.isConstrainedResize() && getOwner() != null) {
			request.setConstrainedResize(true);

			int origHeight = getOwner().getFigure().getBounds().height;
			int origWidth = getOwner().getFigure().getBounds().width;
			float ratio = 1;

			if(origWidth != 0 && origHeight != 0)
				ratio = ((float)origHeight / (float)origWidth);

			if(getResizeDirection() == PositionConstants.SOUTH_EAST) {
				if(d.height > (d.width * ratio))
					d.width = (int)(d.height / ratio);
				else
					d.height = (int)(d.width * ratio);
			} else if(getResizeDirection() == PositionConstants.NORTH_WEST) {
				if(d.height < (d.width * ratio))
					d.width = (int)(d.height / ratio);
				else
					d.height = (int)(d.width * ratio);
			} else if(getResizeDirection() == PositionConstants.NORTH_EAST) {
				if(-(d.height) > (d.width * ratio))
					d.width = -(int)(d.height / ratio);
				else
					d.height = -(int)(d.width * ratio);
			} else if(getResizeDirection() == PositionConstants.SOUTH_WEST) {
				if(-(d.height) < (d.width * ratio))
					d.width = -(int)(d.height / ratio);
				else
					d.height = -(int)(d.width * ratio);
			}
		}

		if((getResizeDirection() & PositionConstants.NORTH) != 0) {
			if(request.isCenteredResize()) {
				resizeDelta.height -= d.height;
			}
			moveDelta.y += d.height;
			resizeDelta.height -= d.height;
		}
		if((getResizeDirection() & PositionConstants.SOUTH) != 0) {
			if(request.isCenteredResize()) {
				moveDelta.y -= d.height;
				resizeDelta.height += d.height;
			}
			resizeDelta.height += d.height;
		}
		if((getResizeDirection() & PositionConstants.WEST) != 0) {
			if(request.isCenteredResize()) {
				resizeDelta.width -= d.width;
			}
			moveDelta.x += d.width;
			resizeDelta.width -= d.width;
		}
		if((getResizeDirection() & PositionConstants.EAST) != 0) {
			if(request.isCenteredResize()) {
				moveDelta.x -= d.width;
				resizeDelta.width += d.width;
			}
			resizeDelta.width += d.width;
		}

		request.setMoveDelta(moveDelta);
		request.setSizeDelta(resizeDelta);
		request.setLocation(location);
		request.setEditParts(getOperationSet());
		request.getExtendedData().clear();
		request.setResizeDirection(getResizeDirection());

		if(request.isSnapToEnabled() && localSnapToHelper != null) {
			PrecisionRectangle rect = localSourceRect.getPreciseCopy();
			rect.translate(moveDelta);
			rect.resize(resizeDelta);
			PrecisionRectangle result = new PrecisionRectangle();

			localSnapToHelper.snapRectangle(request, request.getResizeDirection(), rect, result);
			if(request.isCenteredResize()) {
				if(result.preciseX() != 0.0)
					result.setPreciseWidth(result.preciseWidth() - result.preciseX());
				else if(result.preciseWidth() != 0.0) {
					result.setPreciseX(-result.preciseWidth());
					result.setPreciseWidth(result.preciseWidth() * 2.0);
				}

				if(result.preciseY() != 0.0)
					result.setPreciseHeight(result.preciseHeight() - result.preciseY());
				else if(result.preciseHeight() != 0.0) {
					result.setPreciseY(-result.preciseHeight());
					result.setPreciseHeight(result.preciseHeight() * 2.0);
				}
			}

			PrecisionPoint preciseMove = new PrecisionPoint(result.preciseX() + moveDelta.x, result.preciseY() + moveDelta.y);

			PrecisionDimension preciseResize = new PrecisionDimension(result.preciseWidth() + resizeDelta.width, result.preciseHeight() + resizeDelta.height);

			request.setMoveDelta(preciseMove);
			request.setSizeDelta(preciseResize);
		}

		enforceConstraintsForResize(request);
	}

	/**
	 * 
	 * @return
	 *         <code>true</code> if the current resize must be constrained and <code>false</code> if not
	 */
	private final boolean isConstrainedResizeAccordingToPreference() {
		IPreferenceStore store = Activator.getInstance().getPreferenceStore();
		boolean isInverted = false;
		if(store.contains(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.INVERT_BINDING_FOR_DEFAULT_RESIZE_AND_CONSTRAINED_RESIZE))) {
			isInverted = store.getBoolean(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.INVERT_BINDING_FOR_DEFAULT_RESIZE_AND_CONSTRAINED_RESIZE));
		}
		//to activate this preference use this code during the preference initialization of Papyrus
		//org.eclipse.papyrus.infra.gmfdiag.common.Activator.getInstance().getPreferenceStore().setValue(PreferencesConstantsHelper.getPapyrusEditorConstant(PreferencesConstantsHelper.INVERT_BINDING_FOR_DEFAULT_RESIZE_AND_CONSTRAINED_RESIZE),true);
		if(isInverted) {
			return !getCurrentInput().isModKeyDown(SnapUtils.MODIFIER_CONSTRAINED_RESIZE);
		}
		return getCurrentInput().isModKeyDown(SnapUtils.MODIFIER_CONSTRAINED_RESIZE);
	}
}
