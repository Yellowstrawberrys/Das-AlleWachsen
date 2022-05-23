package cf.yellowstrawberry.thdishomebetter;

import android.os.Bundle;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

//    private DevicesBinding binding;
    private View view1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        view1 = getLayoutInflater().inflate(R.layout.devices, null);
        setContentView(view1);
    }

}