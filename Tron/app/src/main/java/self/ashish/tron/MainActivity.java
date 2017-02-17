package self.ashish.tron;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Mybutton(View view){
        Toast.makeText(MainActivity.this, "start app",Toast.LENGTH_SHORT).show();
    }
    public void Mybutton1(View view)
    {
        Toast.makeText(MainActivity.this, "stop app",Toast.LENGTH_SHORT).show();
    }
}
