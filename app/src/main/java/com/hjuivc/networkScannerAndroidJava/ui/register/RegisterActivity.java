package com.hjuivc.networkScannerAndroidJava.ui.register;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.hjuivc.networkScannerAndroidJava.R;

public class RegisterActivity extends AppCompatActivity {
    PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        CheckBox checkBoxFaq = findViewById(R.id.checkBoxFaq);
        checkBoxFaq.setOnLongClickListener(v -> {
            // Inflate the custom layout/view
            View customView = getLayoutInflater().inflate(R.layout.tooltip_layout,null);
            // Initialize a new instance of popup window
            popupWindow = new PopupWindow(
                    customView,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            TextView tv = customView.findViewById(R.id.tv);
            tv.setText(R.string.faq_text); // Set your tooltip text here

            // Show the popup window at the center of the screen
            popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);

            // Dismiss the popup window when touched outside
            popupWindow.setOutsideTouchable(true);
            popupWindow.setFocusable(true);

            return true;
        });

        // Set an OnTouchListener on the root view of your activity
        findViewById(android.R.id.content).setOnTouchListener((v, event) -> {
            if (popupWindow != null && popupWindow.isShowing()) {
                popupWindow.dismiss();
            }
            return false;
        });
    }
}