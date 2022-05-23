package cf.yellowstrawberry.thdishomebetter.Connection;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cf.yellowstrawberry.thdishomebetter.Objects.AlleWachsen;

public class ConnectionManager {
    BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

    public int start() {
        if (bluetoothAdapter != null && bluetoothAdapter.isEnabled()) {
            return 1;
        } else
            return 0;
    }

    public List<AlleWachsen> getPariedAlleWachsen() {
        List<AlleWachsen> AlleWachsens = new ArrayList<>();
        Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();
        if (pairedDevices.size() > 0) {
            for (BluetoothDevice device : pairedDevices) {
                if (device.getName().equals("Das AlleWachsen")){
                    AlleWachsens.add(new AlleWachsen());
                }
            }
        }
        return AlleWachsens;
    }

    public List<AlleWachsen> startToSearch(){
        //Register Events
        IntentFilter filter = new IntentFilter();
        filter.addAction(BluetoothDevice.ACTION_FOUND);
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        registerReceiver(mReceiver, filter);


        adapter.startDiscovery();
    }

    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            if (BluetoothAdapter.ACTION_DISCOVERY_STARTED.equals(action)) {
                //discovery starts, we can show progress dialog or perform other tasks
            } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
                //discovery finishes, dismis progress dialog
            } else if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                //bluetooth device found
                BluetoothDevice device = (BluetoothDevice) intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

                showToast("Found device " + device.getName());
            }
        }
    };
}
