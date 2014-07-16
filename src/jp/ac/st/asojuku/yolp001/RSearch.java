package jp.ac.st.asojuku.yolp001;

import jp.co.yahoo.android.maps.GeoPoint;
import jp.co.yahoo.android.maps.MapActivity;
import jp.co.yahoo.android.maps.MapController;
import jp.co.yahoo.android.maps.MapView;
import jp.co.yahoo.android.maps.PinOverlay;
import jp.co.yahoo.android.maps.routing.RouteOverlay;
import jp.co.yahoo.android.maps.routing.RouteOverlay.RouteOverlayListener;
import android.app.ProgressDialog;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class RSearch extends MapActivity implements RouteOverlayListener, LocationListener, MapView.MapTouchListener{

	MapView mMapView = null;
	PinOverlay mPinOverlay = null;
	RouteOverlay mRouteOverlay = null;
	GeoPoint mStartPos;
	GeoPoint mGoalPos;
	@Override
	public boolean onLongPress(MapView arg0, Object arg1, PinOverlay arg2, GeoPoint arg3) {
		// TODO 自動生成されたメソッド・スタブ
		if(mRouteOverlay != null)mRouteOverlay.cancel();
		if(mStartPos == null){
			mStartPos = arg3;
		}else{
			mGoalPos = arg3;
			mMapView.removeOverlayAll();
			mRouteOverlay = new RouteOverlay(this,"dj0zaiZpPTdhZ1hERlB4QU01ViZzPWNvbnN1bWVyc2VjcmV0Jng9Mjg-");
			mRouteOverlay.setStartTitle("出発地");
			mRouteOverlay.setGoalTitle("目的地");
			mRouteOverlay.setRoutePos(mStartPos,mGoalPos,RouteOverlay.TRAFFIC_WALK);
			mRouteOverlay.setRouteOverlayListener(this);
			mRouteOverlay.search();
			mMapView.getOverlays().add(mRouteOverlay);
		}

		return false;
	}

	@Override
	public boolean onPinchIn(MapView arg0) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean onPinchOut(MapView arg0) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO 自動生成されたメソッド・スタブ

	}

	ProgressDialog mProgDialog = null;
	TextView mDistLabel = null;
	LocationManager mLocationManager = null;

	@Override
	public boolean errorRouteSearch(RouteOverlay arg0, int arg1) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean finishRouteSearch(RouteOverlay arg0) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		mMapView = new MapView(this,"dj0zaiZpPTdhZ1hERlB4QU01ViZzPWNvbnN1bWVyc2VjcmV0Jng9Mjg-");
		mMapView.setLongPress(true);

		double lat = 35.658516;
		double lon = 139.701773;
		GeoPoint gp = new GeoPoint((int)(lat * 1000000),(int)(lon * 1000000));

		MapController c = mMapView.getMapController();

		c.setCenter(gp);
		c.setZoom(3);
		setContentView(mMapView);
	}

}
