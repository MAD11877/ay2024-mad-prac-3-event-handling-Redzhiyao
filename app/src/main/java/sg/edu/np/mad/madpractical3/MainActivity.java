package sg.edu.np.mad.madpractical3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Random rand = new Random();
        int int_random = rand.nextInt(999999);

        User user = new User("John ", "MAD Developer", 1, false);

        // Get the TextViews and Button from the layout
        TextView tvName = findViewById(R.id.tvName); // Make sure this ID exists in your XML
        TextView tvDescription = findViewById(R.id.tvDescription);
        Button btnFollow = findViewById(R.id.btnFollow);

        // Set the TextViews with the User's name, description, and default button message
        tvName.setText(user.name + int_random);
        tvDescription.setText(user.description);
        btnFollow.setText("Follow");

        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button clicked");

                // Toggle between "Follow" and "Unfollow"
                if (btnFollow.getText().equals("Follow")) {
                    btnFollow.setText("Unfollow");
                    user.followed = true;
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
                } else {
                    btnFollow.setText("Follow");
                    user.followed = false;
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
