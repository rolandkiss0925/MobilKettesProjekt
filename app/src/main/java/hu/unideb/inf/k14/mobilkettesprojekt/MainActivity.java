package hu.unideb.inf.k14.mobilkettesprojekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    SensorManager sensorManager;
    Sensor proximitySensor;
    ImageView white;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        white = findViewById(R.id.white);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        sensorManager.registerListener(proximitySensorEventListener,
                proximitySensor,
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    SensorEventListener proximitySensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent.sensor.getType() == Sensor.TYPE_PROXIMITY) {
                if (sensorEvent.values[0] == 0) white.setImageResource(R.drawable.baby_yoda_hiding_colored_red);
                else white.setImageResource(R.drawable.baby_yoda_peekaboo_colored_red);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    };
}