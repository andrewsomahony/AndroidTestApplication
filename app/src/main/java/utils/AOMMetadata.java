package utils;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.example.andrew.testapplication.activities.BaseActivity;

/**
 * Created by andrew on 5/21/17.
 */

public class AOMMetadata {
    public static Bundle getActivityMetadata(BaseActivity activity) {
        try {
            ActivityInfo ai = activity.getPackageManager()
                                .getActivityInfo(activity.getComponentName(),
                    PackageManager.GET_ACTIVITIES | PackageManager.GET_META_DATA);
            return ai.metaData;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
