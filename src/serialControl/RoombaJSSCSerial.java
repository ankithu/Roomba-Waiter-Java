

package serialControl;

import jssc.*;

/**
 * RoombaJSSC implementation, this class contains all the serial library
 * dependent code.
 */
public class RoombaJSSCSerial extends RoombaJSSC implements SerialPortEventListener {

    public SerialPort serialPort;

    private String portName = null;

    /**
     * Get the list of available serial ports.
     * @return String[] of serial ports.
     */
    public String[] portList() {
        String[] portNames = SerialPortList.getPortNames();
        if (portNames.length == 0) {
        
        }
        return portNames;
    }

    /**
     * Connect to serial port.
     * @param portId Name of serial port.
     * @return True on success, False on failure.
     */
    public boolean connect(String portId) {
        portName = portId;
      

        connected = open_port();

        return connected;
    }

    /**
     * Disconnect serial port.
     */
    public void disconnect() {
        try {
            if (serialPort != null) serialPort.closePort();
           
        } catch (SerialPortException ex) {
           
        }
        connected = false;
        serialPort = null;
    }

    /**
     * Send byte[] to serial port.
     * @param bytes Bytes to send.
     * @return True on success, False on failure.
     */
    public boolean send(byte[] bytes) {
        if (connected) {
            try {
              //  log.debug("Sending byte array, of size: '" + bytes.length + "' to serial port.");
                serialPort.writeBytes(bytes);
                return true;
            } catch (SerialPortException ex) {
               // log.error("Failed to send data to serial port, error: " + ex.getMessage());
                return false;
            }
        } else {
           // log.error("Serial port not connected, use connect() first.");
            return false;
        }
    }

    /**
     * Send integer to serial port.
     * @param b Integer to send.
     * @return True on success, False on failure.
     */
    public boolean send(int b) {
        if (connected) {
            try {
              //  log.debug("Sending data: '" + b + "' to serial port.");
                serialPort.writeInt(b);
                return true;
            } catch (SerialPortException ex) {
               // log.error("Failed to send data to serial port, error: " + ex.getMessage());
                return false;
            }
        } else {
        //    log.error("Serial port not connected, use connect() first.");
            return false;
        }
    }

    /**
     * Checks if a given serial port exists.
     * @param portId Name of serial port.
     * @return True if port exists, false if non existing port.
     */
    private boolean portExists(String portId) {
        // Check if requested port exists
        for (String portName: portList()) {
            if (portName.equals(portId))
                return true;
        }
        return false;
    }

    /**
     * Opens the serial port and sets the port parameters.
     * @return True on success, false on failure.
     */
    private boolean open_port() {
        if (portExists(portName)) {
            boolean success;
            serialPort = new SerialPort(portName);
            try {
                success = serialPort.openPort();

                serialPort.setParams(
                        SerialPort.BAUDRATE_115200,
                        SerialPort.DATABITS_8,
                        SerialPort.STOPBITS_1,
                        SerialPort.PARITY_NONE);

                serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);

                // Listen for incoming data
                serialPort.addEventListener(this);

              //  log.info("Successfully opened serial port.");
                return success;

            } catch (SerialPortException ex) {
             //   log.error("Error opening serial port, error: " + ex.getMessage());
                serialPort = null;
                return false;
            }

        } else {
        //    log.error("Port: '" + portName + "' does not exist.");
            return false;
        }
    }

    public void serialEvent(SerialPortEvent serialPortEvent) {
        if (serialPortEvent.isRXCHAR()) {
            try {
                byte[] data = serialPort.readBytes();
                for(byte b: data) {
                    sensorDataBuffer[sensorDataBufferIndex++] = b;
                    if (sensorDataBufferIndex == SENSOR_PACKET_ALL_SIZE) {
                  //      log.debug("Received sensor data packet.");
                        currentSensorData = sensorDataBuffer;
                        sensorDataBufferIndex = 0;
                    }
                }
            } catch (SerialPortException ex) {
                ex.printStackTrace();
            }
        }
    }
}
