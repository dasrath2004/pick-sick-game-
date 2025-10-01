package com.example.picksick;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class start extends AppCompatActivity {
    TextView tx;
    ImageButton im;
    RadioGroup rg;
    RadioButton rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_start);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tx=findViewById(R.id.textView);
        im=findViewById(R.id.imageButton2);
        rg=findViewById(R.id.radioGroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
                rb=findViewById(checkedId);
            }
        });
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rb != null) {
                    if (rb.getId() == R.id.radioButton12) {
                        startActivity(new Intent(start.this, HarryPotterActivity.class));
                    } else if (rb.getId() == R.id.radioButton2) {
                        startActivity(new Intent(start.this, NarutoActivity.class));
                    } else if (rb.getId() == R.id.radioButton3) {
                        startActivity(new Intent(start.this, DragonballActivity.class));
                    } else if (rb.getId() == R.id.radioButton4) {
                        startActivity(new Intent(start.this, DeathNoteActivity.class));
                    } else if (rb.getId() == R.id.radioButton5) {
                        startActivity(new Intent(start.this, GameOfThronesActivity.class));
                    } else if (rb.getId() == R.id.radioButton6) {
                        startActivity(new Intent(start.this, VikingsActivity.class));
                    } else {
                        Toast.makeText(start.this, "Unknown option!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(start.this, "Please select a game first!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}