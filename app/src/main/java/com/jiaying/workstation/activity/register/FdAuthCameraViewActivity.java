package com.jiaying.workstation.activity.register;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.OrientationEventListener;

import com.jiaying.workstation.R;
import com.jiaying.workstation.activity.BaseActivity;
import com.jiaying.workstation.fragment.AuthPreviewFragment;
import com.jiaying.workstation.utils.MyLog;
import com.jiaying.workstation.utils.SetTopView;

/**
 * 人脸识别
 */
public class FdAuthCameraViewActivity extends BaseActivity {
    private static final String TAG = "FdAuthCameraViewActivity";
//    private MyOrientationDetector orientationDetector;

    public class MyOrientationDetector extends OrientationEventListener {
        public MyOrientationDetector(Context context) {
            super(context);
        }

        @Override
        public void onOrientationChanged(int orientation) {
//            MyLog.e(TAG, "onOrientationChanged: before:" + orientation);


            if (orientation == OrientationEventListener.ORIENTATION_UNKNOWN) {
                return;  //手机平放时，检测不到有效的角度
            }
//只检测是否有四个角度的改变
            if (orientation > 350 || orientation < 10) { //0度
                orientation = 0;
            } else if (orientation > 80 && orientation < 100) { //90度
                orientation = 90;
            } else if (orientation > 170 && orientation < 190) { //180度
                orientation = 180;
            } else if (orientation > 260 && orientation < 280) { //270度
                orientation = 270;
            } else {
                return;
            }
//            MyLog.e(TAG, "onOrientationChanged:" + orientation);
        }
    }

    @Override
    public void initVariables() {

    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_fd_auth_cameraview);
        new SetTopView(this, R.string.title_activity_face_collection, true);
//        orientationDetector = new MyOrientationDetector(this);
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new AuthPreviewFragment()).commit();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        MyLog.e(TAG, "onConfigurationChanged");

    }

    @Override
    protected void onResume() {
        super.onResume();
//        orientationDetector.enable();
        MyLog.e(TAG, "onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        orientationDetector.disable();
        MyLog.e(TAG, "onDestroy");
    }

    @Override
    public void loadData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyLog.e(TAG, "onCreate");
    }


}
