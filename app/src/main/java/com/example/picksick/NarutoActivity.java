package com.example.picksick;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.concurrent.atomic.AtomicInteger;

public class NarutoActivity extends AppCompatActivity {

    TextView question;
    RadioGroup rg;
    Button submit;

    int correctAnswerId = R.id.radioButtonB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_naruto);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        question = findViewById(R.id.question);
        rg = findViewById(R.id.rg);
        submit = findViewById(R.id.button);

        AtomicInteger currentScore = new AtomicInteger(getIntent().getIntExtra("score", 0));

        submit.setOnClickListener(v -> {
            int selectedId = rg.getCheckedRadioButtonId();

            if (selectedId == -1) {
                new AlertDialog.Builder(NarutoActivity.this)
                        .setTitle("Selection Required")
                        .setMessage("Please select an option")
                        .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                        .show();
            } else {
                if (selectedId == correctAnswerId) {
                    currentScore.getAndIncrement();
                }

                Intent intent = new Intent(NarutoActivity.this, na1.class);
                intent.putExtra("score", currentScore.get());
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Exit Quiz?")
                .setMessage("Are you sure you want to exit this quiz?")
                .setPositiveButton("Yes", (dialog, which) -> finish())
                .setNegativeButton("No", null)
                .show();
    }
}
